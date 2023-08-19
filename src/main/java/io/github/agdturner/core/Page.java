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
        w.add("<header>");
        w.add("""
              <button id="style_button" onclick="swapStyle()"></button>
              """);
        w.add("""
              <div class="navbar">
              """);
        if (!site.pages.isEmpty()) {
            w.add(site.getNavigationLinks("nav"));
        }
        w.add("</div>");
        w.add("</header>");
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
        this.subsubsectionNo = 1;
        String inPageID = "" + sectionNo + "." + this.subsectionNo;
        this.subsectionNo += 1;
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
        this.subsubsectionNo += 1;
        String inPageID = "" + sectionNo + "." + this.subsectionNo + "."
                + this.subsubsectionNo;
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
        SectionID sid = new SectionID(site.sectionIDs.size(), this, inPageID);
        site.sectionIDs.add(sid);
        String s = inPageID + ". " + sectionName;
        site.addSection(sid, pageID, label + ": " + s);
        String html = "<h" + level + " id=\"" + inPageID + "\">"
                + s + "</h" + level + ">\n";
        sb.append(html);
        String link = "<a href=\"#" + inPageID + "\">" + s + "</a>";
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
        w.add(getPageContents());
        w.add(page);
    }

    public void writeH1() {
        w.add("<div>");
        w.add("<h1>" + title + "</h1>");
    }

    /**
     * @return The main content of the page.
     */
    public abstract String getMainContent();

    /**
     * @return The page contents.
     */
    public abstract String getPageContents();

    /**
     * @return A list of elements that go in the HTML head section.
     */
    public List<String> getHeadElements() {
        ArrayList<String> r = new ArrayList<>();
        r.add("""
              <!-- Styling. -->
              <!-- The following href is blank, but will be populated once the
              DOM is fully loaded. -->
              <link id="css" rel="stylesheet" type="text/css" href="">\
              """);
        if (site.localPaths) {
            r.add(
                    """
                    <script src="../../scripts/style.js"></script>
                    <!-- The following are used for styling code. -->
                    <script src="../../tools/highlight/highlight.min.js"></script>
                    <script>hljs.highlightAll();</script>
                    <link id="code_theme" rel="stylesheet" type="text/css" href="">
                    """);
        } else {
            r.add(
                    """
                    <script src="/scripts/style.js"></script>
                    <!-- The following are used for styling code. -->
                    <script src="/tools/highlight/highlight.min.js"></script>
                    <script>hljs.highlightAll();</script>
                    <link id="code_theme" rel="stylesheet" type="text/css" href="">
                    """);
        }
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

    /**
     * Wrap a string with an HTML paragraph tag.
     *
     * @param sb The StringBuilder to append to.
     * @param s The string to wrap.
     */
    public void addParagraph(StringBuilder sb, String s) {
        addTag(sb, s, Strings.s_P);
    }

    /**
     * Wrap the start of a string with an HTML start paragraph tag.
     *
     * @param sb The StringBuilder to append to.
     * @param s The string to add after the start tag.
     */
    public void addParagraphStart(StringBuilder sb, String s) {
        addTagStart(sb, Strings.s_P);
        sb.append(s);
    }

    /**
     * Wrap the end of a string with an HTML end paragraph tag.
     *
     * @param sb The StringBuilder to append to.
     * @param s The String to add before the end tag.
     */
    public void addParagraphEnd(StringBuilder sb, String s) {
        sb.append(s);
        addTagEnd(sb, Strings.s_P);
    }

    /**
     * Wrap a string with an HTML start and end tag.
     *
     * @param sb The StringBuilder to append to.
     * @param s The string to wrap.
     * @param tag The tag text.
     */
    public void addTag(StringBuilder sb, String s, String tag) {
        addTagStart(sb, tag);
        sb.append(s);
        addTagEnd(sb, tag);
    }

    /**
     * Wrap a String with a start tag.
     *
     * @param sb The StringBuilder to append to.
     * @param s The string to wrap.
     * @param tag The tag text.
     */
    public void addTagStart(StringBuilder sb, String s, String tag) {
        sb.append("<").append(tag).append(">");
        sb.append(s);
    }

    /**
     * Add a start tag.
     *
     * @param sb The StringBuilder to append to.
     * @param tag The tag text.
     */
    public void addTagStart(StringBuilder sb, String tag) {
        sb.append("<").append(tag).append(">");
    }

    /**
     * Wrap a String with an end tag.
     *
     * @param sb The StringBuilder to append to.
     * @param s The string to wrap.
     * @param tag The tag text.
     */
    public void addTagEnd(StringBuilder sb, String s, String tag) {
        sb.append(s);
        sb.append("</").append(tag).append(">\n");
    }

    /**
     * Add an end tag.
     *
     * @param sb The StringBuilder to append to.
     * @param tag The tag text.
     */
    public void addTagEnd(StringBuilder sb, String tag) {
        sb.append("</").append(tag).append(">\n");
    }

    /**
     * Wrap a string with an HTML pre tag.
     *
     * @param sb The StringBuilder to append to.
     * @param s The string to wrap.
     */
    public void addPre(StringBuilder sb, String s) {
        addTag(sb, s, Strings.s_pre);
    }

    /**
     * Wrap a string with an HTML pre tag.
     *
     * @param sb The StringBuilder to append to.
     * @param s The string to wrap.
     */
    public void addPreStart(StringBuilder sb, String s) {
        addTagStart(sb, s, Strings.s_pre);
    }

    /**
     * Wrap a string with an HTML end pre tag.
     *
     * @param sb The StringBuilder to append to.
     * @param s The string to wrap.
     */
    public void addPreEnd(StringBuilder sb, String s) {
        addTagEnd(sb, s, Strings.s_pre);
    }

    /**
     * Wraps a string with start and HTML list item tags.
     *
     * @param sb The StringBuilder to append to.
     * @param s The string to wrap.
     */
    public void addLI(StringBuilder sb, String s) {
        addTag(sb, s, Strings.s_li);
    }

    /**
     * Wrap the start of a string with an HTML start list item tag.
     *
     * @param sb The StringBuilder to append to.
     * @param s The string to append after the start tag.
     */
    public void addLIStart(StringBuilder sb, String s) {
        addTagStart(sb, s, Strings.s_li);
    }

    /**
     * Wrap the end of a string with an HTML end list item tag.
     *
     * @param sb The StringBuilder to append to.
     * @param s The string to append after the start tag.
     */
    public void addLIEnd(StringBuilder sb, String s) {
        addTagEnd(sb, s, Strings.s_li);
    }

    /**
     * Add a start HTML ordered list tag
     *
     * @param sb The StringBuilder to append to.
     */
    public void addOLStart(StringBuilder sb) {
        addTagStart(sb, Strings.s_ol);
    }

    /**
     * Add an end HTML ordered list tag
     *
     * @param sb The StringBuilder to append to.
     */
    public void addOLEnd(StringBuilder sb) {
        addTagEnd(sb, Strings.s_ol);
    }

    /**
     * Add a start HTML unordered list tag
     *
     * @param sb The StringBuilder to append to.
     */
    public void addULStart(StringBuilder sb) {
        addTagStart(sb, Strings.s_ul);
    }

    /**
     * Add an end HTML unordered list tag
     *
     * @param sb The StringBuilder to append to.
     */
    public void addULEnd(StringBuilder sb) {
        addTagEnd(sb, Strings.s_ul);
    }
}
