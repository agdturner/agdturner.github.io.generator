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
              <p>At the top of each page is a Style Button to change between 
              Light Mode and Dark Mode. In Light Mode, the background of pages 
              is lighter. <!--In Dark Mode links to other websites appear with a 
              dark grey background.--></p>
              <p>Below the Style Button is a Navigation Section. Essentially, 
              the idea is for you - students taking the course, to work your way 
              through all the pages as linked from the Navigation Section. The 
              general progression is from left to right. Within each page, 
              sections are numbered, and there are Index and References pages at 
              the end to help.</p>
              <p>If you have feedback about the website, especially if you 
              encounter problems or spot any errors or inconsistencies, then 
              please let your tutor know.
              </p>
              """);

        w.add("""
              <h2 id="2">2. Syllabus</h2>
              
              <p>General computer programming concepts, including:</p>
              <ul>
              """);
        w.add("<li>"
                + addWikipediaReference("Version_control", "Version control")
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
                        "Object Orientated Programming")
                + "</li>");
        w.add("</ul>");

        w.add("<p>"
                + addWikipediaReference("Python_(programming_language)",
                        "Python programming language")
                + " specifics:</p>");
        w.add("<ul>");
        w.add("<li>Python language development and limitations</li>");
        w.add("<li>Structuring and organising Python code in "
                + addWebReference(
                        "https://docs.python.org/3/tutorial/classes.html",
                        "Classes", null) + ", "
                + addWebReference(
                        "https://docs.python.org/3/tutorial/modules.html",
                        "Modules", null) + ", and "
                + addWebReference(
                        "https://docs.python.org/3/tutorial/modules#packages.html",
                        "Packages", null) + ".</li>");
        w.add("<li>Using the Python Read Evaluate Print Loop (REPL) "
                + "environment</li>");
        w.add("<li>Running Python code from the command line, in  "
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
                        "Python Standard Library", null)
                + ", and third party Python packages available via "
                + addWebReference("https://pypi.org/",
                        "PyPI - the Python Package Index",
                        null)
                + "</a></li>");
        w.add("<li>Using Python to automate "
                + addWebReference("https://qgis.org/", "QGIS", null)
                + " Desktop - geospatial data processing software.</li>");
        w.add("<li>Developing documentation: "
                + "<a href=\"https://peps.python.org/pep-0257/#what-is-a-docstring\">"
                + "docstring</a>, "
                + addWebReference("https://docs.python.org/3/library/pydoc.html",
                        "Pydoc", null)
                + " and "
                + addWebReference("https://www.sphinx-doc.org/", "Sphinx", null)
                + "</li>");
        w.add("<li>"
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
              <li>Program input and output</li>
              <li>Developing Python code (planning, writing, testing, 
              organising)</li>
              <!--<li>Processing geographical features (geometry and related 
              attribute) data.</li>-->
              """);
        w.add("<li>Visualising spatial data using "
                + addWebReference("https://matplotlib.org/", "Matplotlib",
                        null)
                + "</li>");
        w.add("<li>Processing raster data stored in lists.</li>");
        w.add("<li>Using "
                + addWebReference("https://github.com/", "GitHub", null)
                + "</li>");
        w.add("<li>Developing "
                + addWikipediaReference("Graphical_user_interface",
                        "Graphical User Interface") + "s"
                + "</li>");
        w.add("<li>Developing and visualising a basic spatial "
                + addWikipediaReference("Agent-based_model",
                        "Agent Based Model") + "s"
                + "</li>");
        w.add("""
              </ul>
              
              <h2 id="4">4. The Learning Journey</h2>
              <p>Learning to program involves practical problem solving and
              computational thinking. This often involves breaking a problem
              down into smaller tasks and repeating basic workflows to
              accomplish tasks.</p>
              <p>Take time to develop your understanding and practise your
              skills. There is a lot to learn especially if you are new to
              programming.</p>
              <p>Be experimental and remember to test your understanding and
              test code does what you expect it to do.</p>
              <p>The web pages with names starting \"ABM\" are a series of 
              practical exercises that develop an basic spatial Agent Based 
              Model that represents some animals moving about in an environment,
              interacting with each other and the environment. One of the 
              outputs of running the model is an animation. A very basic 
              Graphical User Interface is developed for users to run the model.
              Data are read from files and are scraped from a Web page to 
              initialise the model, and data is output to files and messages are 
              provided to the user via the standard output.
              </p>
              
              <h2 id="5">5. Platform/Software</h2>
              <p>All the software used in this course is Free and Open Source
              Software (FOSS) which is available to download and install on 
              Linux, Windows and MacOS.<p>
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
            w.add("<li>A portfolio culmination from completing the practical"
                    + " tasks worth "
                    + pic.assignment1Weighting + "%.</li>");
            w.add("<li>An independent project worth  "
                    + pic.assignment2Weighting + "%.</li>");
            w.add("</ol>");
        }
        w.add("</div>");
    }
}
