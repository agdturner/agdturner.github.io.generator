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
package io.github.agdturner.course.coding.pages;

import io.github.agdturner.course.Course;
import io.github.agdturner.course.pages.CourseHome;

/**
 * Coding Course Home Page.
 *
 * @author Andy Turner
 */
public abstract class CodingCourseHome extends CourseHome {

    public CodingCourseHome(Course course, String courseName) {
        super(course, courseName);
    }

    public void getProgrammingConcepts(StringBuilder sb) {
        sb.append("""
              <p>General computer programming language concepts, including:</p>
              <ul>
              """);
        sb.append("<li>" + index.getReference("Variable", "Variables") + "</li>\n");
        sb.append("<li>"
                + index.getReference("Control Flow")
                + " ("
                + index.getReference("Conditional", "conditionals")
                + "/"
                + index.getReference("For Loop", "for loops")
                + "/"
                + index.getReference("While Loop", "while loops")
                + ")</li>\n");
        sb.append("<li>"
                + index.getReference("Function", "Functions")
                + "</li>\n");
        sb.append("<li>Data encoding and "
                + index.getReference("File Format", "file formats")
                + "</li>\n");
        sb.append("<li>Documentation</li>\n");
        sb.append("<li>Testing</li>\n");
        sb.append("</ul>\n");
    }

    public void getOrganisationalConcepts(StringBuilder sb) {
        sb.append("<p>"
                + index.getReference("Version Control")
                + "</p>\n");
    }

    public void getObjectOrientedProgrammingConcepts(StringBuilder sb) {
        sb.append("<p>"
                + index.getReference("Version Control")
                + "</p>\n");
        sb.append("<p>"
                + index.getReference("Class", "Classes")
                + " and "
                + index.getReference("Object Oriented Programming")
                + "</p>\n");
    }

    public void getGUIProgrammingConcepts(StringBuilder sb) {
        sb.append("<p>Developing "
                + index.getReference("GUI", "Graphical User Interfaces")
                + "</p>\n");
    }
}
