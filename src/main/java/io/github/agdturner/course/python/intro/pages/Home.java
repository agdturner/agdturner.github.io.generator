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
package io.github.agdturner.course.python.intro.pages;

import io.github.agdturner.course.python.intro.PythonIntroCourse;
import io.github.agdturner.course.Page;
import io.github.agdturner.course.Course;

/**
 * Python Intro Course Home Page.
 *
 * @author Andy Turner
 */
public class Home extends Page {

    /**
     * Create a new instance.
     *
     * @param courseName What {@link #name} is set to.
     * @param index The index of the page.
     * @param c What {@code #c} is set to.
     */
    public Home(String courseName, Course c) {
        super("home", c.getCourseCode1() + " " + courseName, "Home", c);
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        String moduleCataloguePage = "https://webprod3.leeds.ac.uk/catalogue/dynmodules.asp?Y="
                + c.academicYear + "&M=" + c.getCourseCode2();
        w.add("""
              <h2>1. Introduction</h2>
              <p>Welcome to the course website!</p>
              """);
        w.add("<p>The course timetable is linked from the");
        w.add("<a href=\"" + moduleCataloguePage + "\">"
                + "University of Leeds " + c.getCourseCode1()
                + " Module Catalogue Page</a>.</p>");
//        w.add("These Web pages are");
//        w.add(addWikipediaReference("Open_educational_resources",
//                "Open Educational Resources"));
//        w.add("developed by");
//        w.add(Web_ContentWriter.getLink(
//                "https://www.geog.leeds.ac.uk/people/a.turner/index.html",
//                "Andy Turner"));
        w.add("""
              <p>The website is a set of webpages and file based resources. At 
              the top of each webpage is a Style Button that can be used to 
              change between a lighter and darker style. Below that is a 
              Navigation Section which outlines the current page. Each webpage 
              links to the next at the end. Index and Reference webpages are 
              provided. Essentially, the idea is for you - students taking the 
              course - to read through the webpages trying out code yourself 
              and undertaking practical exercises. You may find it helpful to 
              re-read parts and re-do exercises.</p>
              <p>If you encounter issues with the website, then please provide 
              feedback to get these sorted. If you are struggling to comprehend 
              parts, then please don't struggle for too long and ask for help.
              </p>
              """);

        w.add("""
              <h2 id="2">2. Syllabus</h2>
              
              <p>General computer programming language concepts, including:</p>
              <ul>
              """);
        w.add("<li>The notion of an "
                + addWikipediaReference("API",
                        "Application Programming Interface (API)")
                + "</li>");
        w.add("<li>"
                + addWikipediaReference("Variable_(computer_science)",
                        "Variables") + "</li>");
        w.add("<li>"
                + addWikipediaReference("Control_flow", "Control flow")
                + "("
                + addWikipediaReference("Conditional_(computer_programming)",
                        "conditionals")
                + "/"
                + addWikipediaReference("For_loop", "for loops")
                + "/"
                + addWikipediaReference("While_loop", "while loops")
                + "/"
                + addWikipediaReference("Thread_(computing)", "threads")
                + ")</li>");
        w.add("<li>"
                + addWikipediaReference("Function_(computer_programming)",
                        "Functions")
                + " and "
                + addWikipediaReference("Functional_programming",
                        "Functional Programming")
                + "</li>");
        w.add("<li>"
                + addWikipediaReference("Class_(computer_programming)",
                        "Classes")
                + " and "
                + addWikipediaReference("Object-oriented_programming",
                        "Object Oriented Programming")
                + "</li>");
        w.add("</ul>");

        w.add("<p>"
                + addWikipediaReference("Python_(programming_language)",
                        "Python programming language")
                + " specifics:</p>");
        w.add("<ul>");
        w.add("<li>Language development and limitations</li>");
        w.add("<li>Structuring and organising code into "
                + addWebReference(
                        "https://docs.python.org/3/tutorial/classes.html",
                        "Classes", null) + ", "
                + addWebReference(
                        "https://docs.python.org/3/tutorial/modules.html",
                        "Modules", null) + ", and "
                + addWebReference(
                        "https://docs.python.org/3/tutorial/modules#packages.html",
                        "Packages", null) + ".</li>");
        w.add("<li>Using the "
                + addWikipediaReference("Read%E2%80%93eval%E2%80%93print_loop",
                        "Read Evaluate Print Loop (REPL)") + " environment</li>");
        w.add("<li>Running programs from the command line, in  "
                + addWebReference("https://jupyter.org/", "Jupyter", null)
                + " Notebooks, and from within the "
                + addWebReference("https://docs.python.org/3/library/idle.html",
                        "IDLE", null)
                + " and "
                + addWebReference("https://www.spyder-ide.org/", "Spyder", null)
                + " Integrated Development Environments.</li>");
        w.add("<li>Python Environment Management using "
                + addWebReference("https://docs.conda.io/", "Conda", null)
                + " and "
                + addWebReference("https://docs.python.org/3/library/venv.html",
                        "Venv", null)
                + "</li>");
        w.add("<li>Using the "
                + addWebReference("https://docs.python.org/3/library/",
                        "Standard Library", null)
                + ", and third party packages available via "
                + addWebReference("https://pypi.org/",
                        "PyPI - the Python Package Index",
                        null)
                + "</a></li>");
        w.add("<li>Using Python to automate "
                + addWebReference("https://qgis.org/", "QGIS", null)
                + " Desktop - geospatial data processing software.</li>");
        w.add("<li>Code comments, "
                + "<a href=\"https://peps.python.org/pep-0257/#what-is-a-docstring\">"
                + "docstring</a>s and print statements to ease comprehension "
                + "and use.</li>");
        w.add("<li>Producing documentation using "
                + addWebReference("https://docs.python.org/3/library/pydoc.html",
                        "Pydoc", null)
                + " and "
                + addWebReference("https://www.sphinx-doc.org/", "Sphinx", null)
                + "</li>");
        w.add("<li>Testing code using print statements and "
                + addWebReference(
                        "https://docs.python.org/3/library/doctest.html",
                        "Doctest", null)
                + "</li>");
        w.add("<li>"
                + addWikipediaReference("Unit_testing", "Unit testing")
                + " using "
                + addWebReference(
                        "https://docs.python.org/3/library/unittest.html",
                        "Unittest", null)
                + " and "
                + addWebReference(
                        "https://docs.pytest.org/", "Pytest", null)
                + "</li></ul>");
        w.add("""
              <h2 id="3">3. Expectations</h2>
              
              <p>You will learn about:</p>
              <ul>
              """);
        w.add("<li>"
                + addWikipediaReference("Version_control", "Version control")
                + "</li>");
        w.add("""
              <li>Data encoding</li>
              <li>Program input and output</li>
              <!--
              <li>Developing Python code (planning, writing, testing, 
              organising)</li>
              <li>The Python parts of the 
              <a href="https://www.anaconda.com/">Anaconda</a> data science 
              platform</li>
              <li>Processing geographical features (geometry and related 
              attribute) data.</li>
              -->
              """);
        w.add("<li>Visualisation using "
                + addWebReference("https://matplotlib.org/", "Matplotlib",
                        null)
                + "</li>");
        w.add("<li>Processing raster data stored in lists.</li>");
        w.add("<li>Using "
                + addWebReference("https://github.com/", "GitHub", null)
                + "</li>");
        w.add("<li>Developing a "
                + addWikipediaReference("Graphical_user_interface",
                        "Graphical User Interface")
                + "</li>");
        w.add("<li>Developing and visualising a basic spatial "
                + addWikipediaReference("Agent-based_model",
                        "Agent Based Model")
                + "</li>");
        w.add("""
              </ul>
              <p>Developing a computer program to do something typically 
              involves some problem solving and computational thinking. Often it 
              is helpful to break a task into smaller subtasks and to consider 
              if there is an order to these. Often a good solution involves 
              doing things repeatedly employing variables that may change with 
              each repetition. Often it is helpful to use a framework for 
              testing from the outset and to test often as the code develops.  
              </p>
              <p>There is quite a lot of terminology for you to learn as well as 
              learning how things work. Some of the terminology is generic to 
              programming, some is more specific to Python.</p>
              <p>There is a lot to learn especially if you are new to 
              programming.</p>

              <h2 id="4">4. The Learning Journey</h2>
              <p>Take time to develop your understanding and practise your new 
              programming skills.</p>
              <p>Be experimental and remember to test your understanding by 
              testing code does what you expect it to. But, be cautious and 
              do not run code from a potentially untrustworthy source or 
              without comprehending fully what it does.</p>
              <p>If some code does not do what you expected it to do, then treat
              it as a learning experience. A key to coding is learning to be 
              able to interpret errors messages and understand what caused them. 
              Errors are not something to fear, but they are something not to 
              ignore!</p>
              <p>In this website, the webpages with names starting \"ABM\" are a 
              series that gradually develop a basic spatial Agent Based Model. 
              This ABM can be regarded as a simplistic representation of animals 
              moving about in an environment, interacting with each other and 
              the environment. Developing the ABM by following instructions puts 
              into practise some of the theory detailed in the other webpages. 
              By the end of the instructions, you should have ABM model code 
              that: produces an animation; that can be operated from a basic 
              Graphical User Interface; reads in data from local files and from 
              the Web; and, outputs data files and messages for the user. You 
              should also at that stage be confident in how to go about 
              developing the model further without instructions. Whilst you 
              might like to spend time doing that. Your main challenge for this
              module is to undertake an independent project - something done on
              your own with perhaps additional guidance from your tutor. The 
              project will involve applying what you have learned to develop
              some software or a program without detailed instructions.</p>
              
              
              <h2 id="5">5. Platform/Software</h2>
              <p>All the software used in this course is 
              """);
        w.add(addWikipediaReference("Free_and_open-source_software",
                "Free and Open Source Software (FOSS)") + " which is "
                + "available to download and install on "
                + addWikipediaReference("Linux", "Linux") + ", "
                + addWikipediaReference("Microsoft_Windows",
                        "Microsoft Windows") + ", and "
                + addWikipediaReference("MacOS", "macOS") + ".<p>");
        w.add("""
              <p>The software is available to University of Leeds staff and
              students via AppsAnywhere and the Academic Windows Virtual Desktop
              which can be accessed via a Web browser and the following URL:
              <a href="https://wvd.leeds.ac.uk">https://wvd.leeds.ac.uk</a>.
              We will be making use of 
              <a href="https://www.anaconda.com/">Anaconda</a> - a data science 
              platform,
              <a href="https://qgis.org/">QGIS</a> Desktop - Geographical 
              Information System software, and various third party Python 
              packages.</p>
              """);
        // Assignments and Assessments
        PythonIntroCourse pic = (PythonIntroCourse) c;
        if (pic.hasAssignments) {
            w.add("""
                  <h2 id="6">6. Assignments and Assessments</h2>
                  <p>There are two assignments that are assessed:</p>
                  <ol>
                  """);
            w.add("<li>" + pic.assignment1Name + " worth "
                    + pic.assignment1Weighting + "% of the overal mark and due "
                    + pic.assignment1DueDate + " - developed by completing "
                    + "practical exercises by following instructions.</li>");

            w.add("<li>" + pic.assignment1Name + " worth "
                    + pic.assignment1Weighting + "% of the overal mark and due "
                    + pic.assignment1DueDate + " - developed by applying what "
                    + "you have learned to a task for which there are no "
                    + "detailed instructions. You should have sufficent "
                    + "knowledge to begin this assignment from about half way "
                    + "through the course.</li>");
            w.add("</ol>");
        }
        w.add("</div>");
    }
}
