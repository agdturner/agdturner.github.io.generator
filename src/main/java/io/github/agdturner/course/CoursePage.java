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

import io.github.agdturner.core.Page;
import io.github.agdturner.core.PageID;
import io.github.agdturner.core.Section;
import io.github.agdturner.core.SectionID;
import io.github.agdturner.core.Strings;
import io.github.agdturner.course.pages.CourseHome;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Course Page.
 *
 * @author Andy Turner
 */
public abstract class CoursePage extends Page {

    /**
     * Index for convenience.
     */
    protected final Index index;

    /**
     * References for convenience.
     */
    protected final References references;

    /**
     * Course Pages for convenience.
     */
    protected final ArrayList<Page> pages;

    /**
     * Course Home Page for convenience.
     */
    protected final CourseHome homePage;

    /**
     * Create a new instance.
     *
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     * @param course What {@link #site} is set to.
     */
    public CoursePage(Course course, String filename, String title, String label) {
        super(course, filename, title, label, new PageID(course.pages.size()),
                Paths.get(course.courseDir.toString(), filename));
        course.addPage(pageID, label, filename);
        this.sections = new TreeMap<>();
        index = course.getIndex();
        references = course.getReferences();
        pages = course.pages;
        homePage = course.getHomePage();
        sectionNo = 0;
    }

    /**
     * @return {@link #site} cast as a Course.
     */
    public Course getCourse() {
        return (Course) site;
    }

    /**
     * @param course The course for which the index is returned.
     * @return {@code getCourse().getIndex();}.
     */
    public Index getIndex(Course course) {
        return course.getIndex();
    }

    /**
     * @param course The course for which the index is returned.
     * @return {@code getCourse().getIndex();}.
     */
    public References getReferences(Course course) {
        return course.getReferences();
    }

    /**
     * For navigation to the next and optionally previous page.
     *
     * @param linkClass The class for navigation links.
     * @param addPrevious If true, this also adds links to the previous page.
     * @return navigation links
     */
    @Override
    public String getLinks(String linkClass, boolean addPrevious) {
        StringBuilder sb = new StringBuilder("<div>\n<p>");
        if (this instanceof CourseHome) {
            sb.append(getLinkNext(pages.get(0), linkClass));
        } else {
            int n = pages.size();
            if (this instanceof Index) {
                if (addPrevious) {
                    sb.append(getLinkPrev(pages.get(n - 1), linkClass));
                    sb.append("</p>\n<p>");
                    sb.append(getLinkNext(references, linkClass));
                }
            } else if (this instanceof References) {
                sb.append(getLinkPrev(index, linkClass));
                if (addPrevious) {
                    sb.append(getLinkPrev(pages.get(n - 1), linkClass));
                    sb.append("</p>\n<p>");
                    sb.append(getLinkNext(references, linkClass));
                }
            } else {
                if (addPrevious) {
                    if (this.pageID.id > 0) {
                        sb.append(getLinkPrev(pages.get(this.pageID.id - 1),
                                linkClass));
                        sb.append("</p>\n<p>");
                    } else if (this.pageID.id == 0) {
                        sb.append(getLinkPrev(homePage, linkClass));
                        sb.append("</p>\n<p>");
                    }
                }
                if (this.pageID.id < n - 1) {
                    sb.append(getLinkNext(pages.get(this.pageID.id + 1),
                            linkClass));
                } else {
                    sb.append(getLinkNext(index, linkClass));
                }
//                } else {
//                    sb.append(getLinkNext(c.references, linkClass));
//                }
            }
        }
        sb.append("</p>\n</div>");
        return sb.toString();
    }

    /**
     * Get the page contents.
     *
     * @return The page contents.
     */
    @Override
    public String getPageContents() {
        TreeSet<SectionID> sids = site.pageIDToSectionIDs.get(pageID);
        if (sids != null) {
            StringBuilder sb = new StringBuilder("<div>\n");
            sb.append("<h2>Contents</h2>\n");
            sb.append("<ul>\n");
            int level0 = 2;
            int level;
            for (var x : sids) {
                Section section = sections.get(x);
                level = section.level;
                if (level > level0) {
                    sb.append("<ul>\n");
                    sb.append("<li>");
                } else if (level < level0) {
                    sb.append("</li>");
                    sb.append("</ul></li>\n");
                    sb.append("<li>");
                } else {
                    sb.append("<li>");
                }
                sb.append(section.sectionLink);
                level0 = level;
            }
            for (int i = 2; i <= level0; i++) {
                sb.append("</li>\n");
                sb.append("</ul>\n");
            }

            sb.append("</div>\n");
            return sb.toString();
        }
        return "";
    }

    /**
     * Add a paragraph: " Add and commit to your local git repository and
     * assuming you are using GitHub - push your changes to GitHub."
     *
     * @param sb The StringBuilder to append to.
     */
    public void addParagraphCommitToGitHub(StringBuilder sb) {
        addParagraph(sb,
                """
                Add and commit to your local git repository and assuming you are
                using GitHub - push your changes to GitHub.
                """);
    }
}
