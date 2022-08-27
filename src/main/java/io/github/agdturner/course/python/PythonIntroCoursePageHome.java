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
package io.github.agdturner.course.python;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.*;
import io.github.agdturner.core.PageID;
import io.github.agdturner.core.Strings;
import java.io.IOException;
import java.nio.file.Path;
import uk.ac.leeds.ccg.generic.lang.Generic_String;

/**
 * For Python Intro Course Home Page.
 *
 * @author Andy Turner
 */
public class PythonIntroCoursePageHome extends CoursePageHome {

    /**
     * Create a new instance.
     *
     * @param name What {@link #name} is set to.
     * @param id What {@link #id} is set to.
     * @param c What {@code #c} is set to.
     */
    public PythonIntroCoursePageHome(String name, PageID id, Course c) {
        super(name, id, c);
    }

    @Override
    public void write(Path dir) throws IOException {
        String filename = "index";
        writeH1(name);
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
        w.add("<p>There are two assignments that are assessed:</p>");
        w.add("<ol>");
        w.add("<li>A portfolio from the practical tasks worth "
                + pic.assignment1Weighting + "%.</li>");
        w.add("<li>An independent project worth  "
                + pic.assignment2Weighting + "%.</li>");
        w.add("</ol>");
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
        int i = id.id;
        String s;
        String nameTitle;
        // 1.
        i++;
        s = "programming";
        nameTitle = Generic_String.getCapitalFirstLetter(s);
        c.addPage(w, new PageID(i), s, nameTitle);
        // 2.
        i++;
        s = "python";
        nameTitle = Generic_String.getCapitalFirstLetter(s);
        c.addPage(w, new PageID(i), s, nameTitle);
        // 3.
        i++;
        s = "github";
        nameTitle = "GitHub";
        c.addPage(w, new PageID(i), s, nameTitle);
        // 4.
        i++;
        s = "variables";
        nameTitle = Generic_String.getCapitalFirstLetter(s);
        c.addPage(w, new PageID(i), s, nameTitle);
        // 5.
        i++;
        int abmi = 1;
        pic.addABMPage(w, new PageID(i), abmi);
        // 6.
        i++;
        s = "containers";
        nameTitle = Generic_String.getCapitalFirstLetter(s);
        c.addPage(w, new PageID(i), s, nameTitle);
        // 7.
        i++;
        s = "branching";
        nameTitle = "Branching and Loops";
        c.addPage(w, new PageID(i), s, nameTitle);
        // 8.
        i++;
        abmi++;
        pic.addABMPage(w, new PageID(i), abmi);
        // 9.
        i++;
        s = "functions";
        nameTitle = Generic_String.getCapitalFirstLetter(s);
        c.addPage(w, new PageID(i), s, nameTitle);
        // 10.
        i++;
        abmi++;
        pic.addABMPage(w, new PageID(i), abmi);
        // 11.
        i++;
        s = "classes";
        nameTitle = Generic_String.getCapitalFirstLetter(s);
        c.addPage(w, new PageID(i), s, nameTitle);
        // 12.
        i++;
        abmi++;
        pic.addABMPage(w, new PageID(i), abmi);
        // 13.
        i++;
        s = "io";
        nameTitle = "Input/Output";
        c.addPage(w, new PageID(i), s, nameTitle);
        // 14.
        i++;
        abmi++;
        pic.addABMPage(w, new PageID(i), abmi);
        // 15.
        i++;
        s = "modules";
        nameTitle = Generic_String.getCapitalFirstLetter(s);
        c.addPage(w, new PageID(i), s, nameTitle);
        // 16.
        i++;
        abmi++;
        pic.addABMPage(w, new PageID(i), abmi);
        // 17.
        i++;
        s = "exceptions";
        nameTitle = Generic_String.getCapitalFirstLetter(s);
        c.addPage(w, new PageID(i), s, nameTitle);
        // 18.
        i++;
        abmi++;
        pic.addABMPage(w, new PageID(i), abmi);
        // 19.
        i++;
        s = "gui";
        nameTitle = "GUI";
        c.addPage(w, new PageID(i), s, nameTitle);
        // 20.
        i++;
        s = "web";
        nameTitle = Generic_String.getCapitalFirstLetter(s);
        c.addPage(w, new PageID(i), s, nameTitle);
        // 21.
        i++;
        abmi++;
        pic.addABMPage(w, new PageID(i), abmi);
        // 22.
        i++;
        s = "index";
        nameTitle = Generic_String.getCapitalFirstLetter(s);
        c.addPage(w, new PageID(i), s, nameTitle);
        // 23.
        i++;
        s = "references";
        nameTitle = Generic_String.getCapitalFirstLetter(s);
        c.addPage(w, new PageID(i), s, nameTitle);
        w.add("</ol>");
        w.add("</nav>");
        w.add("</div>");
        String title = Environment.DOMAIN + Strings.symbol_space + name
                + Strings.symbol_space + "Page";
        w.writeHTML(dir, filename, title);
    }
}
