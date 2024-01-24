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
        
        w.addPST(sb, index.getReference("Computer programming"));
        sb.append(" (coding) is the process of designing and building an ")
                .append(index.getReference("executable"))
                .append(" ")
                .append(index.getReference("computer program"))
                .append(" to achieve an outcome via a series of ")
                .append(index.getReference("commands"))
                .append(" to be processed by a ")
                .append(index.getReference("processor"));
        w.addPET(sb, ".");
        
        w.addPST(sb, 
                """
                Contemporary desktop and laptop computers typically have a \
                """);
        sb.append(index.getReference("keyboard"))
                .append(" and ")
                .append(index.getReference("mouse"))
                .append(" for user input, a visual display screen (")
                .append(index.getReference("monitor"))
                .append("), smaller amounts of faster more volatile data")
                .append(" storage (")
                .append(index.getReference("memory"))
                .append("), and larger amounts of more persistent data storage")
                .append(" (")
                .append(index.getReference("disk"))
                .append(" that is organised using a ")
                .append(index.getReference("file system"))
                .append("""
                        . Computers may have inbuilt or perpherally connected \
                        devices such as \
                        """)
                .append(index.getReference("microphones"))
                .append(", ")
                .append(index.getReference("speakers"))
                .append(", ")
                .append(index.getReference("cameras"))
                .append(", and additional ")
                .append(index.getReference("data storage"))
                .append(". The monitor may also be an ")
                .append(index.getReference("touchscreen"))
                .append("""
                         for user input. Networked computers typically \
                        communicate using standard \
                        """)
                .append(index.getReference("Internet"))
                .append(" protocols. The basic functioning of a ")
                .append(index.getReference("computer"))
                .append(" is handled by an ")
                .append(index.getReference("operating system"))
                .append(" upon which additional ")
                .append(index.getReference("software"))
                .append(" can be installed, including software  ")
                .append(index.getReference("compilers"))
                .append(" and ")
                .append(index.getReference("interpreters"))
                .append(" that convert more readable ")
                .append(index.getReference("source code"))
                .append(" into ")
                .append(index.getReference("machine code"))
                .append(" ")
                .append(index.getReference("instructions"))
                .append(" executed by a ")
                .append(index.getReference("processor"));
        w.addPET(sb, ".");
        return sid;
    }
    
}
