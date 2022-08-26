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

import io.github.agdturner.Page;
import io.github.agdturner.core.PageID;
import io.github.agdturner.core.ReferenceID;
import java.nio.file.Path;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * For course pages.
 *
 * @author Andy Turner
 */
public abstract class CoursePageGeneral extends Page {

    /**
     * The Course.
     */
    protected final Course c;
    
    /**
     * Create a new instance.
     *
     * @param name What {@link #name} is set to.
     * @param id What {@link #id} is set to.
     * @param c What {@code #c} is set to.
     */
    public CoursePageGeneral(String name, PageID id, Course c) {
        super(name, id);
        this.c = c;
    }

    /**
     * Adds navigation section.
     *
     * @param w The Web_ContentWriter.
     * @param dirCourse The course root directory.
     * @param cc The CourseContent.
     * @param i The index number of the page in the course content.
     */
    public void addNav(Path dirCourse, int i) {
        w.add("<div>");
        w.add("<nav>");
        w.add(Web_ContentWriter.getLink("../index.html", "Home"));
        if (i > 1) {
            PageID pid = new PageID(i - 1);
            w.add(Web_ContentWriter.getLink(c.pageIDToLink.get(pid),
                    "Prev: " + c.pageIDToName.get(pid)));
        }
        if (i < c.pageIDs.size() - 2) {
            PageID pid = new PageID(i + 1);
            w.add(Web_ContentWriter.getLink(c.pageIDToLink.get(pid),
                    "Next: " + c.pageIDToName.get(pid)));
        }
        w.add("</nav>");
        w.add("</div>");
    }

    /**
     * Adds a reference to the appropriate course collections and returns a
     * link to use in a Page.
     *
     * @param linkName The name of the Wikipedia article and section (spaces are
     * replaced with underscores) and the text for the link returned.
     * @return A link to a Wikipedia article with the linkName.
     */
    public String addWikipediaReference(String linkName) {
        return addWikipediaReference(linkName, linkName);
    }

    /**
     * Adds a reference to the appropriate course collections and returns a
     * link to use in a Page.
     *
     * @param linkName The name of the Wikipedia article and section (spaces are
     * replaced with underscores).
     * @param linkText The text for the link returned.
     * @return A link to a Wikipedia article with the linkName.
     */
    public String addWikipediaReference(String linkName, String linkText) {
        String resourceName = "Wikipedia";
        String url = "https://en.wikipedia.org/wiki/" + linkName.replace(' ', '_');
        return addWeb(url, linkName, linkText, resourceName);
    }
    
    /**
     * Adds a reference to the appropriate course collections and returns a
     * link to use in a Page.
     *
     * @param linkName The name of the Wikipedia article and section (spaces are
     * replaced with underscores) and the text for the link returned.
     * @return A link to a Wikipedia article with the linkName.
     */
    public String addWebReference(String url, String linkName, String resourceName) {
        return addWeb(url, linkName, linkName, resourceName);
    }

    /**
     * Adds a reference to the appropriate course collections and returns a
     * link to use in a Page.
     *
     * @param linkName The name of the Wikipedia article and section (spaces are
     * replaced with underscores).
     * @param linkText The text for the link returned.
     * @return A link to a Wikipedia article with the linkName.
     */
    public String addWeb(String url, String linkName, String linkText, String resourceName) {
        ReferenceID rID = new ReferenceID(c.iReference);
        String referenceName = resourceName + " " + linkName;
        String r = Web_ContentWriter.getLink(url, linkText);
        String reference = Web_ContentWriter.getLink(url, referenceName);
        c.referenceIDs.add(rID);
        c.referenceToReferenceID.put(reference, rID);
        c.referenceIDToReference.put(rID, reference);
        c.iReference++;
        return r;
    }
}
