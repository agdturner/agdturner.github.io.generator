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

import io.github.agdturner.core.PageID;

/**
 * For course references pages.
 * 
 * @author Andy Turner
 */
public abstract class CoursePageReferences extends CoursePage {
    
    /**
     * Create a new instance.
     *
     * @param name What {@link #name} is set to.
     * @param id What {@link #id} is set to.
     * @param c What {@code #c} is set to.
     */
    public CoursePageReferences(String name, PageID id, Course c) {
        super(name, id, c);
    }
    
//    /**
//     * Adds navigation section.
//     *
//     * @param w The Web_ContentWriter.
//     * @param dirCourse The course root directory.
//     * @param cc The CourseContent.
//     * @param i The index number of the page in the course content.
//     */
//    void addNav(Path dirCourse, int i) {
//        w.add("<div>");
//        w.add("<nav>");
//        w.add(w.getLink("../index.html", "Home"));
//        if (i > 0) {
//            String s = c.names.get(i - 1);
//            //Path p = Paths.get(cc.lookupPath.get(s).toString(), "index.html");
//            w.add(w.getLink(c.lookupLink.get(s), "Prev: " + c.lookup.get(s)));
//            //w.add(w.getLink(p, "Prev: " + cc.lookup.get(s)));
//        }
//        if (i < c.names.size() - 1) {
//            String s = c.names.get(i + 1);
//            //Path p = Paths.get(cc.lookupPath.get(s).toString(), "index.html");
//            w.add(w.getLink(c.lookupLink.get(s), "Next: " + c.lookup.get(s)));
//            //w.add(w.getLink(p, "Next: " + cc.lookup.get(s)));
//        }
//        w.add("</nav>");
//        w.add("</div>");
//    }
}
