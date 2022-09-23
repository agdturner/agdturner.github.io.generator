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
        w.add("<h2>Introduction</h2>");
        w.add("<p>Welcome!</p>");
        w.add("<p>These web pages are "
                + addWikipediaReference("Open_educational_resources",
                        "Open Educational Resources")
                + " developed by "
                + Web_ContentWriter.getLink(url, "Andy Turner")
                + " and used for teaching at "
                + Web_ContentWriter.getLink("https://www.leeds.ac.uk",
                        "The University of Leeds")
                + ". They support learning the basics of computer programming"
                + " for applications in geography and social science and focus"
                + " on the "
                + addWikipediaReference("Python_(programming_language)",
                        "Python programming language")
                + " (Python).</p>");
        w.add("<p>In the header of each web page is a navigation section"
                + " which links to all the other web pages. The navigation"
                + " section is essentially the same for all the web pages. To"
                + " help know which page you are on, the link for that page has"
                + " a solid outline, and in the main section there is a level 1"
                + " heading containing the title of the page. At the bottom of"
                + " each web page there is a footer section which links to the"
                + " next page (until you are on the last page - a page of"
                + " references). The page before last is an index page which"
                + " links back to sections of web pages to help look things up"
                + " within the pages.</p>");
        w.add("<p>At the top of each page is a Style Button that can be"
                + " used to change the style of the pages between 'light mode'"
                + " and 'dark mode'. When active, and by default, 'light mode',"
                + " sets the background of each page white. Contrastingly,"
                + " 'dark mode', sets the background of each page black. Other"
                + " things may be restyled to show up on the background."
                + "</p>");
        w.add("<p>The idea is that learners proceed by reading through the web"
                + " pages in order, pausing to think, exploring links, taking"
                + " breaks, perhaps talking with peers, and undertake practical"
                + " exercises as directed.</p>");
        w.add("<p>There are many links to other websites, particularly Python"
                + " documentation which, once you get the hang of reading it,"
                + " is a great way to learn about the language. However,"
                + " you will also learn a lot by running code and writing your"
                + " own code. It is hard to prescribe a blanace between reading"
                + " and writing as eveyone is different, but most people learn"
                + " fastest with about an even split of reading and writing to"
                + " begin with.</p>");
        w.add("<p>On courses with computer practical sessions in a classroom,"
                + " students I teach work through these resources either on"
                + " their, or in pairs and with ready access to help from"
                + " tutors. Tutors may give practical demonstrations and help"
                + " to speed up learning. Those learning remotely typically"
                + " have access to other means to interact with tutors and"
                + " peers. Yet, these resources can also be followed by anyone"
                + " wanting to 'go it alone' and teach themselves. Anyway, I"
                + " hope you find these resources helpful and that they help"
                + " make the world a better place!</p>");
        w.add("<p>Learning new things is tiring and can be very difficult or"
                + " impossible if you are tired. When you are tired, but not"
                + " too tired, you may be able to churn out work as a"
                + " programmer, especially things you already know how to do"
                + " and have practiced lots, but working tired can often be a"
                + " waste of time as it can be easy to make mistakes and get"
                + " things in a mess. Try to keep this in mind and manage your"
                + " time and make good use of your special learning abilities"
                + " when you have them. And very importantly - remember to take"
                + " breaks and look after yourself. There is always more to"
                + " learn and the more you know, the more you know you don't"
                + " know and the more you realise how fast things are changing"
                + " and how much more there is to learn. It is very hard to"
                + " keep up with every change, so my advice is to focus on what"
                + " you need. In the Python philosophy \"good enough\" is what"
                + " you should strive for.</p>");
        w.add("<h2>Syllabus</h2>");
        w.add("<p>General computer programming concepts including:</p>");
        w.add("<ul>");
        w.add("<li>"
                + addWikipediaReference("Variable_(computer_science)",
                        "Variables")
                + "</li>");
        w.add("<li>"
                + addWikipediaReference("Control_flow", "Control flow")
                + "("
                + addWikipediaReference("Conditional_(computer_programming)",
                        "conditionals")
                + ", "
                + addWikipediaReference("For_loop", "for loops") + ")"
                + "</li>");
        w.add("<li>"
                + addWikipediaReference("Class_(computer_programming)",
                        "Classes")
                + ", "
                + addWikipediaReference("Function_(computer_programming)",
                        "functions")
                + "/"
                + addWikipediaReference("Method_(computer_programming)",
                        "methods")
                + "</li>");
        w.add("</ul>");
        w.add("<p>Testing code works as expected and dealing with 'edge"
                + " cases'.</p>");
        w.add("<p>Documenting code, producing documentation for other"
                + " programmers and documentation for software end users.</p>");
        w.add("<p>Programming (particularly Python) language development.</p>");
        w.add("<p>Python limitations.</p>");
        w.add("<p>Jupyter Notebooks.</p>");
        w.add("<p>Version control.</p>");
        w.add("<p>GitHub.</p>");
        w.add("<h2>Expectations</h2>");
        w.add("<p>You will practice developing Python code to:</p>");
        w.add("<ul>");
        w.add("<li>Input data into programs from files and from the Web</li>");
        w.add("<li>Output data to files.</li>");
        w.add("<li>Use data structures to process "
                + addWikipediaReference("Coordinate_system", "coordinates")
                + ".</li>");
        w.add("<li>Display spatial data using "
                + addWebReference("https://matplotlib.org/", "matplotlib", null)
                + ".</li>");
        w.add("<li>Process raster data.</li>");
        w.add("<li>Develop and visualise a dynamic spatial simulation "
                + "controlled from and displayed within a "
                + addWikipediaReference("Graphical_user_interface",
                        "Graphical User Interface")
                + ".</li>");
        w.add("</ul>");
        w.add("<h2>The Learning Journey</h2>");
        w.add("<p>Learning to program involves practical problem solving and"
                + " computational thinking. This can involve breaking a problem"
                + " down into smaller tasks and repeating a basic workflow to "
                + " accomplish each task. The workflow steps are: plan, write,"
                + " test, and review.</p>");
        w.add("<p>Take time to develop your understanding and practise your"
                + " skills. There is a lot to learn especially if you are new"
                + " to programming.</li>");
        w.add("<p>Be experimental and remember to test your understanding and"
                + " test that your code does what you expect it to do.</p>");
        w.add("<p>The web pages with names starting \"ABM\" are a series of "
                + " practicals that develop an Agent Based Model. It is a"
                + " simplistic model representing animals moving about in an"
                + " environment, interacting with each other and the "
                + " environment. (There is much that can be done to enhance the"
                + " model and make it more realistic.) Developing such a model"
                + " </p>");
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
