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
               <button id="style_button" onclick="swapStyle()"></button>""");
        w.add(site.getNavigationLinks("nav"));
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
     * @param p The page.
     * @param id The id for the link element.
     * @param linkClass The class for the link element.
     * @param prepend
     * @return a link to a page in the series.
     */
    protected String getLink(Page p, String id, String linkClass, String prepend) {
        return Web_ContentWriter.getLink(site.getLinkPathString(p), id,
                linkClass, prepend + p.label);
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
        site.index.termToIndexTerm.get(name).sids.add(sectionID);
    }

    /**
     * Adds a Section to the site and returns the SectionID.
     * @param inPageID HTML id.
     * @param sectionName Section name.
     * @param level For heading.
     * @param stringBuilder For appending the HTML to.
     * @return SectionID
     */
    public SectionID addSection(String inPageID, String sectionName, int level, 
            StringBuilder stringBuilder) {
        SectionID sectionID = new SectionID(site.sectionIDs.size(), this, inPageID);
        site.sectionIDs.add(sectionID);
        site.addSection(sectionID, pageID, title + ": " + inPageID + ". " + sectionName);
        String html = "<h" + level + " id=\"" + inPageID + "\">" 
                + inPageID + ". " + sectionName + "</h" + level + ">";
        stringBuilder.append(html);
        sections.put(sectionID, new Section(sectionID, html));
        TreeSet<SectionID> sectionIDs = site.pageIDToSectionIDs.get(pageID);
        sectionIDs.add(sectionID);
        return sectionID;
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
    
    public abstract String getMainContent();
    
    public abstract String getPageContents();
    
    public static List<String> getHeadElements(Path dir) {
        ArrayList<String> r = new ArrayList<>();
        r.add("""
              <!-- Styling. -->
              <!-- The following href is blank, but will be populated once the
              DOM is fully loaded. -->
              <link id="css" rel="stylesheet" type="text/css" href="">\
              <script src="/scripts/style.js"></script>
              <!-- The following are used for stying code. -->
              <script src="/tools/highlight/highlight.min.js"></script>
              <script>hljs.highlightAll();</script>
              <link id="code_theme" rel="stylesheet" type="text/css" href="">""");
        return r;
    }
    
   
}
