/*
 * Copyright 2022 Centre for Computational Geography.
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
package io.github.agdturner.course.coding.intro.python.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.course.CoursePage;

/**
 * Python Intro Course Programming Page.
 *
 * @author Andy Turner
 */
public class Testing extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public Testing(PythonIntroCodingCourse course) {
        super(course, "testing", "Testing", "Testing");
    }
    
    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        w.addPST(sb,
                """
                There are a number of different types of testing involved in
                developing software, some key ones are: functionality testing,
                performance testing and usability testing. Functionality testing
                aims to assure that functions behave as expected. Performace
                testing helps to explore the responsiveness, stability,
                scalability, reliability and resource usage of software.
                Usability testing aims to ensure user interfaces are easy to use
                and understand. In
                <a href=\"../abm3/index.html\">ABM3</a>
                there is an exercise in performace testing to optimise a
                function. This section focuses on functionality testing and some
                different ways to do this in Python that goes beyond the use of
                """);
        sb.append(index.getReference("Python print", "print", sid));
        w.addPST(sb,
                """
                statements which are also fundamental for a lot of testing and
                issue diagnosis. As you should know by now, testing is key to
                developing code and creating reproducible results.
                """);

        sid = addSection("Doctest", sb);
        w.addPST(sb, "The ");
        sb.append(index.getReference("Python Standard Library", sid));
        sb.append(" comes with ");
        sb.append(index.getReference("Python doctest", "doctest", sid));
        sb.append(
                """
                a module that can be used to search for text that looks like
                interactive Python sessions, and then executes those sessions to
                verify that they work as shown. Such text is sometimes placed in
                a
                """);
        sb.append(index.getReference("Python docstring", "docstring", sid));
        w.addPET(sb, " as per the example in 'calculator_doctest.py'.");
        w.addP(sb, 
                """
                Save
                <a href="../../resources/testing/calculator_doctest.py">calculator_doctest.py</a>
                , inspect the code and run it. It should run without reporting
                anything. Try altering "0.3" to "0.30000000000000004" and run
                the file again. The output should be along the following lines:
                """);
        w.addPRE(sb, 
                """
                File "calculator_doctest.py", line 25, in __main__.add
                Failed example:
                    add(0.1, 0.1, 0.1)
                Expected:
                    0.30000000000000004
                Got:
                    0.3
                **********************************************************************
                1 items had failures:
                   1 of   2 in __main__.add
                ***Test Failed*** 1 failures.
                """);

        sid = addSection("Unit Tests", sb);
        w.addPST(sb, "");
        sb.append(index.getReference("Unit Testing", sid));
        w.addPET(sb,
                """
                is where individual units of source code - together with
                associated control data, usage procedures, and operating
                procedures - are tested to determine whether they are fit for
                use. It aims to reduce software development risks, time, and
                costs.
                """);
        w.addP(sb, 
                """
                In test driven development, the tests are written before the
                functional code. When the code passes the tests, if the tests
                have good enough coverage, then the functionality is
                successfully implemented.
                """);
        w.addP(sb, 
                """
                It can be good to separate testing code from functional code so
                that testing code does not have to be distributed with
                functional code. In some software development the overall size
                of the testing code is huge compared to the functional code, so
                separating this out allows for distributions to be smaller.
                Organising this is involves packaging code to have a separate
                test package. Usually, the structure of the test package is the
                same as the main code package structure making the tests for
                specific modules, classes and functions to be easily found and
                updated.
                """);
        w.addPST(sb, "The ");
        sb.append(index.getReference("Python Standard Library", sid));
        sb.append(" comes with ");
        sb.append(index.getReference("Python unittest", "unittest", sid));
        w.addPET(sb,
                """
                a module providing tools for constructing and running tests.
                """);
        w.addPST(sb,
                """
                Consider the following example. The functional code is in
                'calculator.py', the module contains a single function 'add'
                which adds up numbers provided as Integer or Float
                """);
        sb.append(index.getReference("Python Numeric Types", "Numeric Types ", sid));
        sb.append(" using ");
        sb.append(index.getReference("Python decimal", "decimal", sid));
        sb.append(" to avoid some ");
        sb.append(index.getReference("Floating-point", "floating-point", sid));
        w.addPET(sb, " rounding issues.");
        w.addPST(sb, 
                """
                Save
                <a href="../../resources/testing/calculator.py">calculator.py</a>
                and
                <a href="../../resources/testing/test.py">test.py</a>
                in the same directory, inspect the code and run 'test.py'. For
                more details about developing unit tests in Python, see:
                """);
        sb.append(index.getReference("Python unittest", "unittest", sid));
        w.addPET(sb, ".");
        return sb.toString();
    }
}
