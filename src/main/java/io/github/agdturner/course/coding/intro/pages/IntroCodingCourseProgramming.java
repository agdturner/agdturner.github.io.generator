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
package io.github.agdturner.course.coding.intro.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.coding.pages.CodingCourseProgramming;

/**
 * Intro Coding Course Programming.
 * 
 * @author Andy Turner
 */
public class IntroCodingCourseProgramming extends CodingCourseProgramming {
    
    public IntroCodingCourseProgramming(Course course) {
        super(course);
    }
    
    @Override
    public SectionID getIntroduction0(StringBuilder sb) {
        SectionID sid = super.getIntroduction0(sb);
        sb.append("<p>").append(index.getReference("Computer Programming",
                "Computer programming"))
                .append(" (coding) is the process of designing and building an")
                .append(" executable computer program - a set of instruction")
                .append(" fetched and executed sequentially.</p>\n");
        sb.append("<p>Contemporary desktop and laptop computers typically have")
                .append(" a ")
                .append(index.getReference("Keyboard", "keyboard"))
                .append(" and ")
                .append(index.getReference("Mouse", "mouse"))
                .append(" for user input, a visual display screen (")
                .append(index.getReference("Monitor", "monitor"))
                .append("), smaller amounts of faster more volatile data")
                .append(" storage (")
                .append(index.getReference("Memory", "memory"))
                .append("), and larger amounts of more persistent data storage")
                .append(" (")
                .append(index.getReference("Disk", "disk"))
                .append(" that is organised using a ")
                .append(index.getReference("File System", "file system"))
                .append(". Computers may have inbuilt or perpherally connected")
                .append(" devices such as microphones, cameras, and additional")
                .append(" data  storage. The monitor may also be an ")
                .append(index.getReference("Touchscreen", "touchscreen"))
                .append(" for user input. Networked computers typically")
                .append(" communicate using standard ")
                .append(index.getReference("Internet"))
                .append(" protocols. The basic functioning of a computer is")
                .append(" handled by an ")
                .append(index.getReference("Operating System", 
                        "operating system"))
                .append(" upon which additional ")
                .append(index.getReference("Software", "software"))
                .append(" can be installed, including software that can ")
                .append("interpret more readable ")
                .append(index.getReference("Source Code", "source code"))
                .append(" into lower level less readable machine instructions.")
                .append("</p>\n");
        sb.append("<p>Programming can be done visually by arranging and")
                .append(" connecting pre-built components into executable")
                .append(" workflows. However, this course is about programming")
                .append(" using text based command instructions.</p>\n");
        return sid;
    }
    
}
