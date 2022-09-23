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
package io.github.agdturner.course;

import io.github.agdturner.WebPage;
import io.github.agdturner.core.PageID;
import io.github.agdturner.core.ReferenceID;
import io.github.agdturner.core.SectionID;
import io.github.agdturner.core.TermID;
import io.github.agdturner.course.python.intro.pages.Home;
import java.nio.file.Paths;
import java.util.TreeSet;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * For course pages.
 *
 * @author Andy Turner
 */
public abstract class Page extends WebPage {

    /**
     * The Course.
     */
    protected final Course c;

    /**
     * Create a new instance.
     *
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     * @param c What {@code #c} is set to.
     */
    public Page(String filename, String title, String label, Course c) {
        super(filename, title, label, new PageID(c.coursePages.size()),
                Paths.get(c.courseDir.toString(), filename));
        this.c = c;
        this.c.addPage(w, id, label, filename);
    }

    /**
     * Write the header including: the dark/light style button and navigation.
     */
    public void writeHeader() {
        w.add("<header>");
        w.add("""
               <button id="style_button" onclick="swapStyle()"></button>""");
        w.add(c.getNavigationLinks("nav"));
        w.add("</header>");
    }

    /**
     * For navigation to the next and optionally previous page.
     *
     * @param linkClass The class for navigation links.
     * @param addPrevious If true, this also adds links to the previous page.
     */
    public String getLinks(String linkClass, boolean addPrevious) {
        StringBuilder sb = new StringBuilder("<div>\n<p>");
        if (this instanceof Home) {
            sb.append(getLinkNext(c.coursePages.get(0), linkClass));
        } else {
            int n = c.coursePages.size();
            if (this instanceof Index) {
                if (addPrevious) {
                    sb.append(getLinkPrev(c.coursePages.get(n - 1), linkClass));
                    sb.append("</p>\n<p>");
                    sb.append(getLinkNext(c.references, linkClass));
                }
            } else if (this instanceof References) {
                sb.append(getLinkPrev(c.index, linkClass));
            } else {
                if (addPrevious) {
                    if (this.id.id > 0) {
                        sb.append(getLinkPrev(c.coursePages.get(this.id.id - 1),
                                linkClass));
                        sb.append("</p>\n<p>");
                    } else if (this.id.id == 0) {
                        sb.append(getLinkPrev(c.homePage, linkClass));
                        sb.append("</p>\n<p>");
                    }
                }
                if (this.id.id < n - 1) {
                    sb.append(getLinkNext(c.coursePages.get(this.id.id + 1),
                            linkClass));
                } else {
                    sb.append(getLinkNext(c.index, linkClass));
                }
            }
        }
        sb.append("</p>\n</div>");
        return sb.toString();
    }

    /**
     * Gets a link to the next page in the series.  
     * @param p The page.
     * @param linkClass The class for the link element.
     * @return a link to the next page in the series.
     */
    protected String getLinkNext(Page p, String linkClass) {
        return getLink(p, "next", linkClass, "Next: ");
    }

    /**
     * Gets a link to the previous page in the series.  
     * @param p The page.
     * @param linkClass The class for the link element.
     * @return a link to the next page in the series.
     */
    protected String getLinkPrev(Page p, String linkClass) {
        return getLink(p, "previous", linkClass, "Prev: ");
    }

    /**
     * Gets a link to a page in the series.  
     * @param p The page.
     * @param id The id for the link element.
     * @param linkClass  The class for the link element.
     * @param prepend
     * @return a link to a page in the series.
     */
    protected String getLink(Page p, String id, String linkClass, String prepend) {
        return Web_ContentWriter.getLink(c.getLinkPathString(p), id,
                linkClass, prepend + p.label);
    }

    /**
     * Adds a reference to the appropriate course collections and returns a link
     * to use in a WebPage.
     *
     * @param linkName The name of the Wikipedia article and section (spaces are
     * replaced with underscores) and the text for the link returned.
     * @return A link to a Wikipedia article with the linkName.
     */
    public String addWikipediaReference(String linkName) {
        return addWikipediaReference(linkName, linkName);
    }

    /**
     * Adds a reference to the appropriate course collections and returns a link
     * to use in a WebPage.
     *
     * @param linkName The name of the Wikipedia article and section (spaces are
     * replaced with underscores).
     * @param linkText The text for the link returned.
     * @return A link to a Wikipedia article with the linkName.
     */
    public String addWikipediaReference(String linkName, String linkText) {
        String resourceName = "Wikipedia";
        String url = "https://en.wikipedia.org/wiki/" + linkName.replace(' ', '_');
        return addWebReference(url, linkName, linkText, resourceName);
    }

    /**
     * Adds a reference to the appropriate course collections and returns a link
     * to use in a WebPage.
     *
     * @param url The url of the Web resource to reference.
     * @param linkName The name for the link in the reference prepended with
     * resourceName. This is also used as the link Text that is returned.
     * @param resourceName Prepended to linkName (with a space added) for the
     * reference if it is not null.
     * @return A link to a Wikipedia article with the linkName.
     */
    public String addWebReference(String url, String linkName, String resourceName) {
        return addWebReference(url, linkName, linkName, resourceName);
    }

    /**
     * Adds a reference to the appropriate course collections and returns a link
     * to use in a WebPage.
     *
     * @param url The url of the Web resource to reference.
     * @param linkName The name for the link in the reference prepended with
     * resourceName.
     * @param linkText The text for the link returned.
     * @param resourceName Prepended to linkName (with a space added) for the
     * reference if it is not null.
     * @return A link to a Wikipedia article with the linkName.
     */
    public String addWebReference(String url, String linkName, String linkText,
            String resourceName) {
        String referenceName = "";
        if (resourceName != null) {
            referenceName += resourceName + " ";
        }
        referenceName += linkName;
        if (!c.references.referenceNameToReferenceID.containsKey(referenceName)) {
            ReferenceID rID = new ReferenceID(c.references.referenceNameToReferenceID.size());
            c.references.referenceNameToReferenceID.put(referenceName, rID);
            c.references.referenceIDToReferenceURL.put(rID, url);
        }
        return Web_ContentWriter.getLink(url, linkText);
    }

    /**
     * If this term is already in the index, then the section ID is added to the
     * set of SectionIDs stored against the TermID for this term. Otherwise a
     * new TermID for this term is created and a new set of SectionIDs is
     * initialised with the sectionID added to it and this is added to the
     * index.
     *
     * @param term The term to add.
     * @param sectionID The section to link to.
     */
    public void addToIndex(String term, SectionID sectionID) {
        if (c.index.termToTermID.containsKey(term)) {
            TermID key = c.index.termToTermID.get(term);
            c.index.index.get(key).add(sectionID);
        } else {
            TreeSet<SectionID> sections = new TreeSet<>();
            sections.add(sectionID);
            TermID key = new TermID(c.index.index.size());
            c.index.index.put(key, sections);
            c.index.termIDToTerm.put(key, term);
            c.index.termToTermID.put(term, key);
        }
    }

}
