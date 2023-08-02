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

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.pages.CourseHome;

/**
 * Coding Course Home Page.
 *
 * @author Andy Turner
 */
public abstract class CodingCourseHome extends CourseHome {

    public CodingCourseHome(Course course) {
        super(course);
    }

    public void getSyllabusProgrammingStart(StringBuilder sb, SectionID sid) {
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
    }
    
    public void getSyllabusObjectOrientation(StringBuilder sb, SectionID sid) {
        sb.append("<li>")
                .append(index.getReference("Class", "Classes"))
                .append(" and ")
                .append(index.getReference("Object Oriented Programming"))
                .append("</li>\n");
    }
    
    public void getSyllabusProgrammingEnd(StringBuilder sb, SectionID sid) {
        sb.append("</ul>\n");
    }

    public void getSyllabusOrganisational(StringBuilder sb, SectionID sid) {
        sb.append("<p>")
                .append(index.getReference("Version Control"))
                .append("</p>\n");
    }
    
    @Override
    public SectionID getLearningJourney0(StringBuilder sb) {
        SectionID sid = super.getLearningJourney0(sb);
        sb.append("<p>One of the keys to coding is learning to be able to")
                .append(" interpret errors messages and understand what caused")
                .append(" them. If a program you are developing unexpectedly")
                .append(" raises an exception and reports an error message,")
                .append(" then try to understand why and stop this happening")
                .append(" before moving on. Ignoring error messages is nearly")
                .append(" always the wrong thing to do!</p>");
        sb.append("<p>Be cautious and do not run code that you do not trust.")
                .append("</p>\n");
        return sid;
    }
}
