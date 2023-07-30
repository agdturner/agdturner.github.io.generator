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
import io.github.agdturner.course.pages.CourseHome;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Course Web Page.
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
     * CCourse Home Page for convenience.
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
        course.addPage(w, id, label, filename);
        this.sections = new TreeMap<>();
        index = course.getIndex();
        references = course.getReferences();
        pages = course.pages;
        homePage = course.getHomePage();
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
                    if (this.id.id > 0) {
                        sb.append(getLinkPrev(pages.get(this.id.id - 1),
                                linkClass));
                        sb.append("</p>\n<p>");
                    } else if (this.id.id == 0) {
                        sb.append(getLinkPrev(homePage, linkClass));
                        sb.append("</p>\n<p>");
                    }
                }
                if (this.id.id < n - 1) {
                    sb.append(getLinkNext(pages.get(this.id.id + 1),
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
}
