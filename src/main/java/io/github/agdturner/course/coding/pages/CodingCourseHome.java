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
        addParagraph(sb,
                "General computer programming language concepts, including:");
        addULStart(sb);
        addLI(sb, index.getReference("Variable", "Variables"));
        addLIStart(sb, index.getReference("Control Flow"));
        sb.append(" (");
        sb.append(index.getReference("Conditional", "conditionals"));
        sb.append("/");
        sb.append(index.getReference("For Loop", "for loops"));
        sb.append("/");
        sb.append(index.getReference("While Loop", "while loops"));
        addLIEnd(sb, ")");
        addLI(sb, index.getReference("Function", "Functions"));
        addLIStart(sb, "Data encoding and ");
        addLIEnd(sb, index.getReference("File Format", "file formats"));
        addLI(sb, "Documentation");
        addLI(sb, "Testing");
    }
    
    public void getSyllabusObjectOrientation(StringBuilder sb, SectionID sid) {
        addLIStart(sb, index.getReference("Class", "Classes"));
        sb.append(" and ");
        addLIEnd(sb, index.getReference("Object Oriented Programming"));
    }
    
    public void getSyllabusProgrammingEnd(StringBuilder sb, SectionID sid) {
        addULEnd(sb);
    }

    public void getSyllabusOrganisational(StringBuilder sb, SectionID sid) {
        addParagraph(sb, index.getReference("Version Control") + ".");
    }
    
    @Override
    public SectionID getLearningJourney0(StringBuilder sb) {
        SectionID sid = super.getLearningJourney0(sb);
        addParagraph(sb, 
                """
                A key to coding is learning to be able to interpret error
                messages and understand why they occur. If a program
                unexpectedly raises an exception, then try to diagnose why this
                occurred. Ignoring error messages is nearly always a mistake!
                """);
        addParagraph(sb, 
                "Be cautious and only run code you trust.");
        return sid;
    }
}
