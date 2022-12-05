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
        super("home", courseName, "Home", c);
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2>1. Introduction</h2>
              <p>Welcome!</p>
              <p>These web pages are""");
        w.add(addWikipediaReference("Open_educational_resources",
                "Open Educational Resources"));
        w.add(" developed by ");
        w.add(Web_ContentWriter.getLink(
                "https://www.geog.leeds.ac.uk/people/a.turner/index.html",
                "Andy Turner"));
        w.add(" and used for teaching at ");
        w.add(Web_ContentWriter.getLink("https://www.leeds.ac.uk",
                "The University of Leeds") + ".");
        w.add("""
              They support learning the basics of computer programming for
              applications in geography and social science and focus on the""");
        w.add(addWikipediaReference("Python_(programming_language)",
                "Python programming language"));
        w.add("""
              (Python).</p>
              <p>In the header of each page is a common navigation section which
              should indicate which page you are on with a solid outline, and
              in the main section of the page is a level 1 heading containing
              the title of the page. At the bottom of each page there is a
              footer section which links to the next page (until you are on the
              references - the last page). The page before last is an index page
              which might be useful to look things up.</p>
              <p>At the top of each page is a Style Button that can be used
              to change the style of the pages between 'light mode' and 'dark
              mode'. When active, and by default, 'light mode', sets the
              background of each page white. Contrastingly, 'dark mode', sets
              the background of each page black. Other things are restyled
              to show up on the background. In dark mode links to external 
              web resources appear with a dark red background as a warning as
              these may not honour browser dark mode settings.</p>
              <p>The idea is that learners proceed by reading through the web
              pages in order, pausing to think, explore links, take
              breaks, perhaps talking with peers, undertake practical
              exercises as directed, and expriment.</p>
              <p>There are links to other websites, particularly the official""");
        w.add(addWebReference("https://docs.python.org/3/",
                "Python 3 Documentation", "Python 3 Documentation"));
        w.add("""
              which is widely consulted to learn about the language.</p>
              <p>The hope is that you will learn a lot and quickly by running 
              code provided and writing your own code. Try to balance your 
              division of time between theory and practice. An appropriate
              balance will depend on your experience and how you personally 
              learn best.</p>
              <p>On courses with computer practical sessions in a classroom,
              working with others in pairs or small groups with ready access to
              help from tutors is encouraged. Tutors are there to discuss things
              and provide practical demonstration to help you learn and avoid 
              confusion.</p>
              <p>Learning new things is tiring. With increasing tiredness comes 
              decreased ability to learn. So, try to manage your time and make
              good use of your special learning abilities when you have them. 
              And most importantly - take breaks and look after yourself
              mentally and physically.</p>
              
              <h2>2. Syllabus</h2>
              <p>General computer programming concepts and Python including:</p>
              <ul>
              <li>Version control</li>
              """);
        w.add("<li>" + addWikipediaReference(
                "Variable_(computer_science)",
                "Variables"));
        w.add("</li>\n<li>");
        w.add(addWikipediaReference("Control_flow", 
                "Control flow"));
        w.add("(" + addWikipediaReference(
                "Conditional_(computer_programming)", 
                "conditionals") + "/"
                + addWikipediaReference("For_loop", "for loops")
                + ")</li>");
        w.add("<li>" + addWikipediaReference(
                "Function_(computer_programming)",
                "Functions") + "</li>");
        w.add("<li>" + addWikipediaReference(
                "Class_(computer_programming)",
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
              DocTest</a>
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
              <li>Data input and output</li>
              <li>Using data structures to process""");
        w.add(addWikipediaReference("Coordinate_system", "coordinates"));
        w.add("</li>\n<li>Displaying spatial data using");
        w.add(addWebReference("https://matplotlib.org/", "matplotlib", null));
        w.add("""
              </li>
              <li>Processing raster data stored in lists.</li>
              <li>Developing a""");
        w.add(addWikipediaReference("Graphical_user_interface",
                "Graphical User Interface"));
        w.add("""
              </li>
              <li>Developing and visualising a simplistic Agent Based Model</li>
              </ul>
              
              <h2>4. The Learning Journey</h2>
              <p>Learning to program involves practical problem solving and
              computational thinking. This can involve breaking a problem
              down into smaller tasks and repeating a basic workflow to
              accomplish each task. The workflow steps are: plan, write,
              test, and review.</p>
              <p>Take time to develop your understanding and practise your
              skills. There is a lot to learn especially if you are new to
              programming.</p>
              <p>Be experimental and remember to test your understanding and
              test that your code does what you expect it to do.</p>
              <p>The web pages with names starting \"ABM\" are a series of 
              practical exercises that develop an Agent Based Model. It is a
              simple model representing animals moving about in an environment,
              interacting with each other and the environment. (There is much
              that can be done to enhance the model and make it more realistic.)
              The model is animated and run using a basic Graphical User
              Interface. Data are read from files and are scraped from a Web
              page to initialise the model, and data is output to files and
              messages are provided to the user via the standard output.
              </p>
              
              <h2>5. Platform/Software</h2>
              <p>All the software used in this course is Free and Open Source
              Software (FOSS) which is available to download and install on most
              platforms.<p>
              <p>The software is available to University of Leeds staff and
              students via AppsAnywhere on it's Academic Windows Virtual Desktop
              which can be accessed via a Web browser and the following URL:
              <a href="https://wvd.leeds.ac.uk">https://wvd.leeds.ac.uk</a>.
              We will be making use of 
              <a href="https://www.anaconda.com/">Anaconda</a> - a data science 
              platform, and 
              <a href="https://qgis.org/">QGIS</a> Desktop - Geographical 
              Information System software.
              </p>
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
    }
}
