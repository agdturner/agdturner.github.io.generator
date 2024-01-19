/*
 * Copyright 2024 University of Leeds.
 *
 * Licensed under the Apache License, Version 2.0 (the"License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an"AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.agdturner.course.coding.intro.cpp.pages;

import io.github.agdturner.course.coding.intro.cpp.CPPIntroCodingCourse;
import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.CoursePage;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * CPP Intro Course CPP Page.
 *
 * @author Andy Turner
 */
public class CPP extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public CPP(CPPIntroCodingCourse course) {
        super(course, "cpp", "CPP", "CPP");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        w.addPST(sb, "");
        sb.append(index.getReference("C++"));
        sb.append(" was first standardized in 1998 as (");
        sb.append(index.getReference("C++98"));
        sb.append(", the standard was revised as ");
        sb.append(index.getReference("C++03"));
        sb.append(", ");
        sb.append(index.getReference("C++11"));
        sb.append(", ");
        sb.append(index.getReference("C++14"));
        sb.append(", ");
        sb.append(index.getReference("C++17"));
        sb.append(", and most recently ");
        sb.append(index.getReference("C++20"));
        sb.append(". The standard is not available for free. However, ");
        sb.append(index.getReference("The GNU Compiler Collection"));
        sb.append(" includes a front end for most of these standards of C++ ");
        w.addPET(sb, ".");
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("C++20", sb);
        w.addP(sb,
                """
                C++20 was released in 2020. We will not look closely at the \
                differences between C++20 and earlier versions, however, it is \
                important to bear in mind that different compilers and code \
                run on different hardware may behave differently and produce \
                different results.""");
        w.addPST(sb, index.getReference("Regression testing", sid));
        sb.append(" which checks key results are ");
        sb.append(index.getReference("Reproducibility", "reproducibile", sid));
        w.addPET(sb, " is generally important in scientific research.");
        w.addPST(sb,
                """
                 There is a vast ecosystem of third party C++ libraries. \
                A list of some Open Source offerings can be found on the \
                """);
        sb.append(index.getReference("cppreference.com libs"));
        w.addPET(sb, ".");
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Running C++", sb);
        w.addPST(sb, "To compile and run some C++ code you need a C++ front"
                + " end like ");
        sb.append(index.getReference("The GNU Compiler Collection"));
        sb.append("Open a terminal or command window and type: ");
        w.addPRE(sb, "g++");
        w.addPET(sb, "If 'g++' cannot be found, then please install it.");

        sid = addSubsection("Hello World", sb);
        
        sid = addSubsection("Numerical calculations", sb);
        w.addP(sb,
                """
                Try multiplying and dividing some numbers. Try dividing one by \
                zero:""");
        w.addPRE(sb, "1 / 0");
        w.addP(sb, "Which should result in:");
        

        sid = addSubsection("Statements", sb);
        w.addP(sb,
                """
                ; ends a statement
                """);

        sid = addSubsection("Comments", sb);
        w.addP(sb,
                """
                //
                /*
                */
                """);
        

        sid = addSubsection("Code Layout", sb);
        w.addP(sb,
                """
                Blank lines are allowed and can help structure code into
                blocks. It is good practice to start each code block with a
                comment that outlines what the code block is for.
                """);
        
        sid = addSubsection("Operators", sb);
        w.addP(sb,
                """
                Commas ',', colons ':', and dots '.' are commonly used
                delimeters in Python. Details of other delimiters are omitted
                for the time being. Some are really better thought of as
                operators rather than delimiters.
                """);

        sid = addSubsection("Identifiers and Keywords", sb);
        w.addP(sb,
                """
                Identifiers are names of variables, functions, classes, and namespaces.
                """);
        w.addPST(sb, "A keyword is a reserved word - a term that can't be used "
                + "for an, identifier.");
        
        
        

        sid = addSection("Integrated Development Environments", sb);
        w.addPET(sb, "");
        sb.append(index.getReference("IDE",
                "Integrated Development Environments", sid));
        sb.append(
                """
                 (IDEs) are software tools used to make writing code and
                developing software easier. This section introduces Visual Studio code
                """);
        return sb.toString();
    }

}
