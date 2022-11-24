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
 * For Python Intro Course Home Page.
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
        String url = "https://www.geog.leeds.ac.uk/people/a.turner/index.html";
        w.add("""
              <h2>Introduction</h2>
              <p>Welcome!</p>
              <p>These web pages are""");
        w.add(addWikipediaReference("Open_educational_resources",
                        "Open Educational Resources"));
        w.add(" developed by ");
        w.add(Web_ContentWriter.getLink(url, "Andy Turner"));
        w.add(" and used for teaching at ");
        w.add(Web_ContentWriter.getLink("https://www.leeds.ac.uk",
                        "The University of Leeds"));
        w.add("""
              . They support learning the basics of computer programming for
              applications in geography and social science and focus on the""");
        w.add(addWikipediaReference("Python_(programming_language)",
                        "Python programming language"));
        w.add("""
              (Python).</p>
              <p>In the header of each web page is a navigation section which
               links to all the other web pages. The navigation section is
              essentially the same for all the web pages. To help know which
              page you are on, the link for that page has a solid outline, and
              in the main section there is a level 1 heading containing the
              title of the page. At the bottom of each web page there is a
              footer section which links to the next page (until you are on the
              references). The page before last is an index page which links
              back to sections of web pages to help look things up within the
              pages. At the top of each page is a Style Button that can be used
              to change the style of the pages between 'light mode' and 'dark
              mode'. When active, and by default, 'light mode', sets the
              background of each page white. Contrastingly, 'dark mode', sets
              the background of each page black. Other things may be restyled
              to show up on the background.</p>
              <p>The idea is that learners proceed by reading through the web
              pages in order, pausing to think, exploring links, taking
              breaks, perhaps talking with peers, and undertake practical
              exercises as directed.</p>
              <p>There are links to other websites, particularly the official""");
        w.add(addWebReference("https://docs.python.org/3/",
                "Python 3 Documentation", null));
        w.add("""
              which is the main way many programmers learn about the language.</p>
              <p>You will learn a lot by running code provided and writing your
              own code. Try to balance your division of time between theory and
              practice so that you learn fast. An appropriate balance will 
              depend on your experience and how you personally learn best.</p>
              <p>On courses with computer practical sessions in a classroom,
              working with others in pairs or small groups with ready access to
              help from tutors is encouraged. Tutors may give practical
              demonstrations and help speed up learning by talking things
              through.</p>
              <p>Learning new things is tiring and as tiredness increases,
              learning decreases. So, try to manage your time and make good use
              of your special learning abilities when you have them. And very
              importantly - remember to take breaks and look after yourself
              both mentally and physically.</p>
              <h2>Syllabus</h2>
              <p>General computer programming concepts including:</p>
              <ul>
              <li>""");
        w.add(addWikipediaReference("Variable_(computer_science)",
                        "Variables"));
        w.add("</li>\n<li>");
        w.add(addWikipediaReference("Control_flow", "Control flow"));
        w.add("(");
        w.add(addWikipediaReference("Conditional_(computer_programming)",
                        "conditionals"));
        w.add(",");
        w.add(addWikipediaReference("For_loop", "for loops"));
        w.add(")</li>\n<li>");
        w.add(addWikipediaReference("Class_(computer_programming)",
                        "Classes"));
        w.add(",");
        w.add(addWikipediaReference("Function_(computer_programming)",
                        "functions"));
        w.add("/");
        w.add(addWikipediaReference("Method_(computer_programming)",
                        "methods"));
        w.add("""
              </li>
              <li>Testing and ensuring that code works as expected.</li>
              <li>Documentation.</li>
              <li>Python language development and limitations.</li>
              <li>Jupyter Notebooks.</li>
              <li>Version control.</li>
              <li>GitHub.</li>
              </ul>
              <h2>Expectations</h2>
              <p>You will practice developing Python code to:</p>
              <ul>
              <li>Input data into programs from files and from the Web</li>
              <li>Output data to files.</li>
              <li>Use data structures to process:""");
        w.add(addWikipediaReference("Coordinate_system", "coordinates"));
        w.add("""
              .</li>
              <li>Display spatial data using""");
        w.add(addWebReference("https://matplotlib.org/", "matplotlib", null));
        w.add("""
              .</li>
              <li>Process raster data.</li>
              <li>Develop and visualise a dynamic spatial simulation "
                + "controlled from and displayed within a""");
        w.add(addWikipediaReference("Graphical_user_interface",
                        "Graphical User Interface"));
        w.add("""
              .</li>
              </ul>
              <h2>The Learning Journey</h2>
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
              interacing with each other and the environment. (There is much
              that can be done to enhance the model and make it more realistic.)
              The model is animated and run using a basic Graphical User
              Interface. Data are read from files and are scraped from a Web
              page to initialise the model, and data is output to files and
              messages are provided to the user via the standard output.
              </p>""");
        // Assignments and Assessments
        PythonIntroCourse pic = (PythonIntroCourse) c;
        if (pic.hasAssignments) {
            w.add("<h2>Assignments and Assessments</h2>");
            w.add("<p>There are two assignments that are assessed:</p>");
            w.add("<ol>");
            w.add("<li>A portfolio from the practical tasks worth "
                    + pic.assignment1Weighting + "%.</li>");
            w.add("<li>An independent project worth  "
                    + pic.assignment2Weighting + "%.</li>");
            w.add("</ol>");
        }
    }
}
