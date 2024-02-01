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
        sb.append(" is the process of developing and running ");
        sb.append(index.getReference("computer programs"));
        sb.append(
                """
                , and is often simply called 'programming' and sometimes \
                'coding' (although coding has several other meanings too). \
                Computer progams are often called simply 'programs' or are \
                sometimes called '\
                """);
        sb.append(index.getReference("executables"));
        sb.append("' or '");
        sb.append(index.getReference("software"));
        sb.append("'. Programs run in an ");
        sb.append(index.getReference("operating system"));
        sb.append(" environment on computational ");
        sb.append(index.getReference("hardware"));
        w.addPET(sb,".");
                
        w.addPST(sb, 
                """
                A contemporary general-purpose computer is sometimes called a \
                workstation and may be a desktop or more compact and portable \
                laptop. These typically have a \
                """);
        sb.append(index.getReference("keyboard"))
                .append(" and ")
                .append(index.getReference("mouse"))
                .append(" for user input, a visual display screen (")
                .append(index.getReference("monitor"));
        sb.append("""
                  ), smaller amounts of faster more volatile data storage (\
                  """);
        sb.append(index.getReference("memory"));
        sb.append("""
                  ), and larger amounts of more persistent data storage (\
                  """);
        sb.append(index.getReference("disk"))
                .append(") that is organised using a ")
                .append(index.getReference("file system"));
        sb.append("""
                  . Such computers may have other inbuilt or perpherally \
                  connected devices such as \
                  """)
                .append(index.getReference("microphones"))
                .append(", ")
                .append(index.getReference("speakers"))
                .append(", ")
                .append(index.getReference("cameras"))
                .append(", and additional ")
                .append(index.getReference("data storage"))
                .append(". The monitor may also be a ")
                .append(index.getReference("touchscreen"));
        w.addPET(sb, " user interface.");
                
        w.addPST(sb, "The basic functioning of a ");
        sb.append(index.getReference("computer"))
                .append(" is handled by the ")
                .append(index.getReference("operating system"))
                .append(" upon which additional ")
                .append(index.getReference("software"))
                .append(" can be installed for programming, including  ")
                .append(index.getReference("compilers"))
                .append(" and ")
                .append(index.getReference("interpreters"))
                .append(" that convert more readable ")
                .append(index.getReference("source code"))
                .append(" into ")
                .append(index.getReference("machine code"))
                .append(" ")
                .append(index.getReference("instructions"))
                .append(" executed by ")
                .append(index.getReference("processors"));
        w.addPET(sb,
                """
                . Contemporary general-purpose workstations are typically \
                multi-core - in that they contain multiple processors.
                """);
        
        w.addPST(sb, 
                """
                Networked computers typically communicate using standard \
                """);
        sb.append(index.getReference("Internet"));
        sb.append(
                """
                 protocols and can be organised to work together. Whilst \
                networked general purpose computers collectively have a lot of \
                power. It is not easy to utilise this power efficiently, so \
                research facilities often make available \
                """);
        sb.append(index.getReference("Supercomputers"));
        sb.append(" for ");
        sb.append(index.getReference("High Performance Computing"));
        w.addPET(sb, ".");
        return sid;
    }
    
}
