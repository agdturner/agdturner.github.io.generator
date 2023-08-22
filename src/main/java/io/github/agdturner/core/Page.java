/*
 * Copyright 2022 Centre for Computational Geography.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.agdturner.core;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import uk.ac.leeds.ccg.web.core.Web_Strings;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Class for a Generic Web Page.
 *
 * @author Andy Turner
 */
public abstract class Page {

    /**
     * The site provides access to other pages.
     */
    public Site site;

    /**
     * The Page Sections.
     */
    public TreeMap<SectionID, Section> sections;

    /**
     * The Web_ContentWriter.
     */
    public final Web_ContentWriter w;

    /**
     * Name used for filenames.
     */
    public final String filename;

    /**
     * Used for Title and H1.
     */
    public final String title;

    /**
     * Used for links.
     */
    public final String label;

    /**
     * Page ID
     */
    public final PageID pageID;

    /**
     * Path to the file.
     */
    public final Path path;

    /**
     * The section number.
     */
    protected int sectionNo;

    /**
     * The subsection number.
     */
    protected int subsectionNo;

    /**
     * The sub-subsection number.
     */
    protected int subsubsectionNo;

    /**
     * Create a new instance.
     *
     * @param site What {@link #site} is set to.
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     * @param pageID What {@link #pageID} is set to.
     * @param path What {@link #path} is set to.
     */
    public Page(Site site, String filename, String title, String label,
            PageID pageID, Path path) {
        this.site = site;
        this.w = new Web_ContentWriter();
        this.filename = filename;
        this.title = title;
        this.label = label;
        this.pageID = pageID;
        this.path = path;
        this.site.addPage(pageID, label, filename);
        this.sections = new TreeMap<>();
    }

    /**
     * Write the header including: the dark/light style button and navigation.
     */
    protected void writeHeader() {
        w.add("""
              <button id="style_button" onclick="swapStyle()"></button>
              """);
        if (!site.pages.isEmpty()) {
            w.add(site.getNavigationLinks("nav"));
        }
    }

    /**
     * For navigation to the next and optionally previous page.
     *
     * @param linkClass The class for navigation links.
     * @param addPrevious If true, this also adds links to the previous page.
     * @return
     */
    public abstract String getLinks(String linkClass, boolean addPrevious);

    /**
     * Gets a link to the next page in the series.
     *
     * @param p The page.
     * @param linkClass The class for the link element.
     * @return a link to the next page in the series.
     */
    protected String getLinkNext(Page p, String linkClass) {
        return getLink(p, "next", linkClass, "Next: ");
    }

    /**
     * Gets a link to the previous page in the series.
     *
     * @param p The page.
     * @param linkClass The class for the link element.
     * @return a link to the next page in the series.
     */
    protected String getLinkPrev(Page p, String linkClass) {
        return getLink(p, "previous", linkClass, "Prev: ");
    }

    /**
     * Gets a link to a page in the series.
     *
     * @param page The page.
     * @param linkID The ID for the link element.
     * @param linkClass The class for the link element.
     * @param prepend Text prepended to the page label.
     * @return a link to a page in the series.
     */
    protected String getLink(Page page, String linkID, String linkClass,
            String prepend) {
        return Web_ContentWriter.getLink(site.getLinkPathString(page), linkID,
                linkClass, prepend + page.label);
    }

    /**
     * If this term is already in the index, then the section ID is added to the
     * set of SectionIDs stored against the TermID for this term. Otherwise a
     * new TermID for this term is created and a new set of SectionIDs is
     * initialised with the sectionID added to it and this is added to the
     * index.
     *
     * @param name The reference name.
     * @param sectionID The SectionID to add.
     */
    public void addToIndex(String name, SectionID sectionID) {
        site.index.termToIndexTerm.get(name).sectionIDs.add(sectionID);
    }

    /**
     * Adds a Section to the site and returns the SectionID.
     *
     * @param sectionName Section name.
     * @param sb For appending the HTML to.
     * @return SectionID
     */
    public SectionID addSection(String sectionName, StringBuilder sb) {
        this.subsectionNo = 1;
        String inPageID = "" + sectionNo;
        this.sectionNo += 1;
        return addSection(inPageID, sectionName, sb, 2);
    }

    /**
     * Adds a Subsection to the site and returns the SectionID.
     *
     * @param sectionName Section name.
     * @param sb For appending the HTML to.
     * @return SectionID
     */
    public SectionID addSubsection(String sectionName, StringBuilder sb) {
        subsubsectionNo = 1;
        String inPageID = "" + (sectionNo - 1) + "." + subsectionNo;
        subsectionNo += 1;
        return addSection(inPageID, sectionName, sb, 3);
    }

    /**
     * Adds a Sub-subsection to the site and returns the SectionID.
     *
     * @param sectionName Section name.
     * @param sb For appending the HTML to.
     * @return SectionID
     */
    public SectionID addSubsubsection(String sectionName, StringBuilder sb) {
        subsubsectionNo += 1;
        String inPageID = "" + (sectionNo - 1) + "." + (subsectionNo - 1) + "."
                + subsubsectionNo;
        return addSection(inPageID, sectionName, sb, 4);
    }

    /**
     * Adds a Section to the site and returns the SectionID.
     *
     * @param sectionName Section name.
     * @param sb For appending the HTML to.
     * @param level For heading.
     * @return SectionID
     */
    private SectionID addSection(String inPageID, String sectionName,
            StringBuilder sb, int level) {
        w.addDIVST(sb);
        SectionID sid = new SectionID(site.sectionIDs.size(), this, inPageID);
        site.sectionIDs.add(sid);
        String s = inPageID + ". " + sectionName;
        site.addSection(sid, pageID, label + ": " + s);
        String html = "<H" + level + " id=\"" + inPageID + "\">"
                + s + "</H" + level + ">\n";
        sb.append(html);
        String link = "<A href=\"#" + inPageID + "\">" + s + "</A>";
        sections.put(sid, new Section(level, sid, html, link));
        TreeSet<SectionID> sectionIDs = site.pageIDToSectionIDs.get(pageID);
        sectionIDs.add(sid);
        return sid;
    }

    /**
     * For writing the page to file.
     */
    public void write() {
        writeHeader();
        writeH1();
        String page = getMainContent();
        String contents = getContents();
        if (contents != null) {
            w.add(contents);
        }
        w.add(page);
    }

    public void writeH1() {
        w.add(Web_Strings.H1_ST + title + Web_Strings.H1_ET);
    }

    /**
     * @return The main content of the page.
     */
    public abstract String getMainContent();

    /**
     * @return The page contents.
     */
    public abstract String getContents();

    /**
     * @return A list of elements that go in the HTML head section.
     */
    public List<String> getHeadElements() {
        ArrayList<String> r = new ArrayList<>();
        r.add(
                """
                <!-- Styling -->
                <!-- href to be populated by the script (once the DOM is fully loaded) -->
                <link id="css" rel="stylesheet" type="text/css" href="" />
                <script src="/scripts/style.js"></script>
                <!-- For styling code -->
                <script src="/tools/highlight/highlight.min.js"></script>
                <script>hljs.highlightAll();</script>
                <!-- href to be populated by the script (once the DOM is fully loaded) -->
                <link id="code_theme" rel="stylesheet" type="text/css" href="" />
                """);
        return r;
    }

    /**
     * Wraps a code block for Python code.
     *
     * @param sb The StringBuilder to append to.
     * @param s The code block to wrap.
     */
    public void addPythonCodeBlock(StringBuilder sb, String s) {
        addPythonCodeBlockStart(sb, s);
        addPythonCodeBlockEnd(sb, "");
    }

    /**
     * Appends {@code <pre><code class="language-python">} to sb.
     *
     * @param sb The StringBuilder to append to.
     * @param s The string to add after the start tag.
     */
    public void addPythonCodeBlockStart(StringBuilder sb, String s) {
        sb.append(
                """
                <pre><code class="language-python">
                """);
        sb.append(s);
    }

    /**
     * Appends {@code </code></pre>} to sb.
     *
     * @param sb The StringBuilder to append to.
     * @param s The string to add before the end tag.
     */
    public void addPythonCodeBlockEnd(StringBuilder sb, String s) {
        sb.append(s);
        sb.append("</code></pre>");
    }

}
