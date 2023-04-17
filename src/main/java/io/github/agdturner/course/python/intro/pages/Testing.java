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
package io.github.agdturner.course.python.intro.pages;

import io.github.agdturner.core.Section;
import io.github.agdturner.course.python.intro.PythonIntroCourse;
import io.github.agdturner.course.Page;

/**
 * Python Intro Course Programming Page.
 *
 * @author Andy Turner
 */
public class Testing extends Page {

    private static final long serialVersionUID = 1L;

    /**
     * Create a new instance.
     *
     * @param index The Page index.
     * @param c The Course.
     */
    public Testing(PythonIntroCourse c) {
        super("testing", "Testing", "Testing", c);
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        Section s;
        s = addSection("1", "Introduction", 2);
        w.add(s.sectionHTML);
        w.add("<p>There are a number of different types of testing involved in "
                + "developing software, some key ones are: functionality "
                + "testing, performance testing and usability testing. "
                + "Functionality testing aims to assure that functions behave "
                + "as expected. "
                + "Performace testing helps to explore the responsiveness, "
                + "stability, scalability, reliability and resource usage of "
                + "software. "
                + "Usability testing aims to ensure user interfaces "
                + "are easy to use and understand. In "
                + "<a href=\"../abm3/index.html\">ABM3</a>"
                + " there is an exercise in performace testing to optimise a "
                + "function. This section focuses on functionality testing and "
                + "some different ways to do this in Python that goes beyond "
                + "the use of "
                + c.index.getReference("Python print", "print", s.sid)
                + " statements which are also fundamental for a lot of testing "
                + "and issue diagnosis. As you should know by now, testing is "
                + "key to developing code and creating reproducible results."
                + "</p>");
        
        s = addSection("2", "Doctest", 2);
        w.add(s.sectionHTML);
        w.add("<p>The "
                + c.index.getReference("Python Standard Library", s.sid)
                + " comes with "
                + c.index.getReference("Python doctest", "doctest", s.sid)
                + " a module that can be used to search for text that looks "
                + "like interactive Python sessions, and then executes those "
                + "sessions to verify that they work as shown. Such text is "
                + "sometimes placed in a "
                + c.index.getReference("Python docstring", "docstring", s.sid)
                + " as per the example in 'calculator_doctest.py'.</p>");
        w.add("<p>Save "
                + "<a href=\"../../resources/testing/calculator.py\">calculator_doctest.py</a>"
                + ", inspect the code and run it. It should run without"
                + " reporting anything. Try altering \"0.3\" to "
                + "\"0.30000000000000004\" and run the file again. The output "
                + "should be along the following lines:</p>");
        w.add("""
              <pre>File "calculator_doctest.py", line 25, in __main__.add
              Failed example:
                  add(0.1, 0.1, 0.1)
              Expected:
                  0.30000000000000004
              Got:
                  0.3
              **********************************************************************
              1 items had failures:
                 1 of   2 in __main__.add
              ***Test Failed*** 1 failures.</pre>
              """);
        
        s = addSection("3", "Unit Tests", 2);
        w.add(s.sectionHTML);
        w.add("<p>Unit testing aims to reduce software development risks, "
                + "time, and costs. In test driven development, the tests are "
                + "written before the functional code. When the code passes "
                + "the tests, if the tests have good enough coverage, then the "
                + "functionality is successfully implemented."
                + "</p>");
        w.add("<p>The "
                + c.index.getReference("Python Standard Library", s.sid)
                + " comes with "
                + c.index.getReference("Python unittest", "unittest", s.sid)
                + " a module providing tools for constructing and running"
                + " tests.</p>");
        w.add("""
              <p>It is best to separate testing code from functional code so 
              that testing code does not have to be distributed with functional 
              code. In some software development the overall size of the testing 
              code is huge compared to the functional code and this separation 
              is helpful. Organising this is simply a matter of packaging code
              and having a separate test package. Usually the structure of the 
              test package is the same as the main code package structure.</p>
              """);
        w.add("<p>To understand how to implement a unittest consider the "
                + "following example. The functional code is in "
                + "'calculator.py', the module contains a simple class called "
                + "'Real' which has a single method called 'add'. The idea is "
                + "that this method will add up numbers and may perhaps do "
                + "this more accurately than using the standard add operator "
                + "by utilsing "
                + c.index.getReference("Python decimal", "decimal", s.sid)
                + ".</p>");
        w.add("<p>Save "
                + "<a href=\"../../resources/testing/calculator.py\">calculator.py</a>"
                + " and "
                + "<a href=\"../../resources/testing/test.py\">test.py</a>"
                + "in the same directory, inspect the code and run 'test.py'."
                + " This is another case of learning by example. For more "
                + "details, see: "
                + c.index.getReference("Python unittest", "unittest", s.sid)
                + ".</p>");
        
        w.add("</div>");
    }
}
