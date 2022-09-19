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
        writeH1();
        // Aims and Objectives
        w.add("<h2>Aims and Objectives</h2>");
        w.add("<ul>");
        w.add("<li>Understand key computer programming concepts including:");
        w.add("<ul>");
        w.add("<li>Variables</li>");
        w.add("<li>Control flow</li>");
        w.add("<li>Loops</li>");
        w.add("<li>Conditional statements</li>");
        w.add("<li>Classes, functions/methods</li>");
        w.add("<li>Object Orientated Programming</li>");
        w.add("</ul></li>");
        w.add("<li>Use Python to:");
        w.add("<ul>");
        w.add("<li>Read data from files and from the Web</li>");
        w.add("<li>Write data to files</li>");
        w.add("<li>Handle coordinates in lists</li>");
        w.add("<li>Display spatial data</li>");
        w.add("<li>Process raster data</li>");
        w.add("<li>Develop and visualise a dynamic spatial simulation</li>");
        w.add("</ul></li>");
        w.add("<li>Practice:");
        w.add("<ul>");
        w.add("<li>Problem solving</li>");
        w.add("<li>Computational thinking</li>");
        w.add("<li>Object Orientated Programming</li>");
        w.add("</ul></li>");
        w.add("<li>Understand generic programming tasks and how to go about "
                + "these in Python including:");
        w.add("<ul>");
        w.add("<li>Testing</li>");
        w.add("<li>Documenting</li>");
        w.add("<li>Sharing</li>");
        w.add("</ul></li>");
        w.add("<li>Familiarisation with:");
        w.add("<ul>");
        w.add("<li>Python language development</li>");
        w.add("<li>Python limitations</li>");
        w.add("<li>Jupyter Notebooks</li>");
        w.add("<li>Version control</li>");
        w.add("<li>GitHub</li>");
        w.add("</ul></li>");
        w.add("</ul>");
        // The learning journey
        w.add("<h2>The Learning Journey</h2>");
        w.add("<ul>");
        w.add("<li>Take time to develop your understanding and practise your "
                + "skills.</li>");
        w.add("<li>There is a lot to learn especially if you are new to "
                + "programming.</li>");
        w.add("<li>Repeating tasks can help you learn.</li>");
        w.add("<li>Try to learn new things when you are fresh and try to take "
                + "plenty of breaks to rest from computer work and to allow "
                + "new ideas and concepts to sink in.</li>");
        w.add("<li>Talk to others without disturbing them. Work together if "
                + "you like.</li>");
        w.add("<li>Ask your tutor for help or clarification in class or via "
                + "email.</li>");
        w.add("<li>Test your understanding by testing that your code does what "
                + "you expect it to do.</li>");
        w.add("<li>Be experimental.</li>");
        w.add("<li>Learn to interpret error messages.</li>");
        w.add("</ul></li>");
        // Assignments and Assessments
        w.add("<h2>Assignments and Assessments</h2>");
        PythonIntroCourse pic = (PythonIntroCourse) c;
        if (pic.hasAssignments) {
            w.add("<p>There are two assignments that are assessed:</p>");
            w.add("<ol>");
            w.add("<li>A portfolio from the practical tasks worth "
                    + pic.assignment1Weighting + "%.</li>");
            w.add("<li>An independent project worth  "
                    + pic.assignment2Weighting + "%.</li>");
            w.add("</ol>");
        }
        // Practicals
        w.add("<h2>Main Sections</h2>");
        w.add("<p>The sections names starting \"ABM\" are practicals that "
                + "develop an Agent Based Model. It is a simplistic model "
                + "representing animals moving about in an environment, "
                + "interacting with each other and the environment. (There is "
                + "much that can be done to enhance the model and make it more "
                + "realistic.)</p>");
        w.add("<nav>");
        w.add("<ol>");
        
//        // Navigation buttons.
//        for (CoursePageGeneral page: c.coursePages) {
//            c.addPage(w, page.id, page.name, page.label);
//        }
//        c.addPage(w, c.indexPage.id, c.indexPage.name, c.indexPage.label);
//        c.addPage(w, c.referencesPage.id, c.referencesPage.name, c.referencesPage.label);
        w.add("</ol>");
        w.add("</nav>");
        w.add("</div>");
    }
}
