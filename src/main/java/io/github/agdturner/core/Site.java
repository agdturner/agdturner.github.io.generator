/*
 * Copyright 2023 Centre for Computational Geography.
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

import io.github.agdturner.course.Index;
import io.github.agdturner.course.References;
import io.github.agdturner.course.pages.CourseHomePage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * A class for a site. A site knows about the pages and other resources that it
 * is comprised of.
 *
 * @author Andy Turner
 */
public abstract class Site {

    /**
     * The Environment.
     */
    public final Environment env;

    /**
     * For storing the course Home Page.
     */
    protected CourseHomePage homePage;

    /**
     * The Site Pages (other than the {@link #homePage}, {@link indexPage#index}
     * and {@link #references}.
     */
    public final ArrayList<Page> pages;

    /**
     * For storing the course Index Page.
     */
    protected Index index;

    /**
     * For storing the course References Page.
     */
    protected References references;

    /**
     * A set of all the Page IDs.
     */
    public TreeSet<PageID> pageIDs;

    /**
     * A set of all the Section IDs.
     */
    public TreeSet<SectionID> sectionIDs;

    /**
     * To look up the SectionIDs in a Page.
     */
    public TreeMap<PageID, TreeSet<SectionID>> pageIDToSectionIDs;

    /**
     * To look up a PageID from a SectionID.
     */
    public TreeMap<SectionID, PageID> sectionIDToPageID;

    /**
     * To look up a Section Name from a SectionID.
     */
    public TreeMap<SectionID, String> sectionIDToSectionName;

    /**
     * To look up the name from the pageID.
     */
    public HashMap<PageID, String> pageIDToName;

    /**
     * To look up the abbreviated name from the PageID.
     */
    public HashMap<PageID, String> pageIDToNameA;

    /**
     * To look up the PageID from the abbreviated name.
     */
    public HashMap<String, PageID> nameAToPageID;

    /**
     * To look up a Link from a PageID.
     */
    public HashMap<PageID, String> pageIDToLink;

    /**
     * Create a new instance.
     *
     * @param env What {@link #env} is set to.
     */
    public Site(Environment env) {
        this.env = env;
        pages = new ArrayList<>();
        pageIDs = new TreeSet<>();
        pageIDToName = new HashMap<>();
        pageIDToNameA = new HashMap<>();
        nameAToPageID = new HashMap<>();
        pageIDToLink = new HashMap<>();
        sectionIDs = new TreeSet<>();
        pageIDToSectionIDs = new TreeMap<>();
        sectionIDToPageID = new TreeMap<>();
        sectionIDToSectionName = new TreeMap<>();
    }

    /**
     * For adding a General Page to the Course.
     *
     * @param w The Web_ContentWriter of the Home Page to add the link to.
     * @param id The PageID.
     * @param pageName The page name (this can have spaces and other
     * characters).
     * @param linkName The link name for the Page - this is to be unique and not
     * contain characters not allowed in a URL. In some cases it is the same as
     * pageName, in other cases it might be an abbreviation.
     */
    public void addPage(Web_ContentWriter w, PageID id, String pageName, String linkName) {
        pageIDs.add(id);
        pageIDToName.put(id, linkName);
        pageIDToNameA.put(id, pageName);
        nameAToPageID.put(pageName, id);
        String link = Web_ContentWriter.getLink("../" + linkName + "/index.html", pageName);
        pageIDToLink.put(id, link);
    }

    /**
     * Add a section for the index.
     *
     * @param sid The Section ID.
     * @param pid The Page ID.
     * @param sectionName The name of the section.
     */
    public void addSection(SectionID sid, PageID pid, String sectionName) {
        sectionIDToPageID.put(sid, pid);
        sectionIDToSectionName.put(sid, sectionName);
    }

    /**
     * For getting all navigation buttons.
     * @param linkClass The HTML class for the navigation links.
     * @return The navigation links HTML.
     */
    public String getNavigationLinks(String linkClass) {
        StringBuilder sb = new StringBuilder("<div>\n<nav>\n");
        sb.append(Web_ContentWriter.getLink(getLinkPathString(homePage),
                homePage.filename, linkClass, homePage.label));
        sb.append(" ");
        for (Page page : pages) {
            sb.append(Web_ContentWriter.getLink(getLinkPathString(page),
                    page.filename, linkClass, page.label));
            sb.append(" ");
        }
        sb.append(Web_ContentWriter.getLink(getLinkPathString(index),
                index.filename, linkClass, index.label));
        sb.append(" ");
        sb.append(Web_ContentWriter.getLink(getLinkPathString(references),
                references.filename, linkClass, references.label));
        sb.append("\n</nav>\n</div>");
        return sb.toString();
    }

    public String getLinkPathString(Page p) {
        return "../" + p.filename + "/index.html";
    }

}
