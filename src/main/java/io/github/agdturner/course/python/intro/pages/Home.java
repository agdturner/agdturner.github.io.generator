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
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

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
              <p>Welcome to the course website.</p>
              """);
        w.add("<p>The timetable for the course is linked from the");
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
              is lighter. In Dark Mode links to other websites appear with a 
              dark grey background.</p>
              <p>Below the Style Button is a Navigation Section. The bottom 
              of each page links to the next page (the last page links back to
              this Home Page.</p>
              """);
//        w.add("""
//              <p>The idea is that learners proceed by reading through the web
//              pages in order, pausing to think, explore links, take
//              breaks, perhaps talking with peers, undertake practical
//              exercises as directed, and expriment.</p>
        w.add("<p>The official " + addWebReference("https://docs.python.org/3/",
                "Python 3 Documentation", "Python 3 Documentation") + " is"
                + " often referred to for details about the "
                + addWikipediaReference("Python_(programming_language)",
                        "Python programming language") + ".</p>");

        w.add("""
              <h2>2. Syllabus</h2>
              <p>General computer programming concepts and Python including:</p>
              <ul>
              """);
        w.add("<li>" + addWikipediaReference("Version_control",
                "Version control") + "</li>");
        w.add("<li>" + addWikipediaReference("Variable_(computer_science)",
                "Variables") + "</li>");
        w.add("<li>" + addWikipediaReference("Control_flow", "Control flow")
                + "(" + addWikipediaReference(
                        "Conditional_(computer_programming)", "conditionals") 
                + "/" + addWikipediaReference("For_loop", "for loops") 
                + ")</li>");
        w.add("<li>" + addWikipediaReference("Function_(computer_programming)",
                "Functions") + "</li>");
        w.add("<li>" + addWikipediaReference("Class_(computer_programming)",
                "Classes") + "</li>");
        w.add("""
              <li>Python language development and limitations</li>
              <li>Running Python code from the command line, in 
              <a href="https://jupyter.org/">Jupyter</a> 
              Notebooks, and in Integrated Development Environments</li>
              <li>Python Environment Management using 
              <a href="https://docs.conda.io/">Conda</a></li>
              <li>Installing Python Packages</li>
              <li>Using Python to automate
              <a href="https://qgis.org/">QGIS</a> Desktop data processing.</li>
              <li>Setting up a profile on 
              <a href=""https://github.com/">GitHub</a></li>
              <li>Testing:
              <a href="https://docs.python.org/3/library/doctest.html">
              doctest</a>
              and
              <a href="https://en.wikipedia.org/wiki/Unit_testing">
              unit testing</a></li>
              <li>Developing documentation: documenting functions; 
              <a href="https://docs.python.org/3/library/pydoc.html">PyDoc</a>
              and
              <a href="https://www.sphinx-doc.org/">Sphinx</a></li>
              </ul>
              
              <h2>3. Expectations</h2>
              <p>You will learn about:</p>
              <ul>
              <li>Input and outputs</li>
              <li>Processing geographical features (geometry and related 
              attribute) data.</li>
              <li>Visualising spatial data using
              """);
        w.add(addWebReference("https://matplotlib.org/", "matplotlib", null));
        w.add("""
              </li>
              <li>Processing raster data stored in lists.</li>
              <li>Developing""");
        w.add(addWikipediaReference("Graphical_user_interface",
                "Graphical User Interface") + "s");
        w.add("""
              </li>
              <li>Developing and visualising a basic spatial Agent Based 
              Model</li>
              </ul>
              
              <h2>4. The Learning Journey</h2>
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
              
              <h2>5. Platform/Software</h2>
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
            w.add("<h2>6. Assignments and Assessments</h2>");
            w.add("<p>There are two assignments that are assessed:</p>");
            w.add("<ol>");
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
