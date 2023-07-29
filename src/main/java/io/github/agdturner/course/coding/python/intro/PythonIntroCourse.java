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
package io.github.agdturner.course.coding.python.intro;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.CoursePage;
import io.github.agdturner.course.coding.python.PythonCourse;
import io.github.agdturner.course.coding.python.PythonIndex;
import io.github.agdturner.course.coding.python.PythonReferences;
import io.github.agdturner.course.coding.python.intro.pages.ABM1;
import io.github.agdturner.course.coding.python.intro.pages.ABM2;
import io.github.agdturner.course.coding.python.intro.pages.ABM3;
import io.github.agdturner.course.coding.python.intro.pages.ABM4;
import io.github.agdturner.course.coding.python.intro.pages.ABM5;
import io.github.agdturner.course.coding.python.intro.pages.ABM6;
import io.github.agdturner.course.coding.python.intro.pages.ABM7;
import io.github.agdturner.course.coding.python.intro.pages.ABM8;
import io.github.agdturner.course.coding.python.intro.pages.ABM9;
//import io.github.agdturner.course.python.intro.pages.Assignments;
import io.github.agdturner.course.coding.python.intro.pages.Branching;
import io.github.agdturner.course.coding.python.intro.pages.Classes;
import io.github.agdturner.course.coding.python.intro.pages.Containers;
import io.github.agdturner.course.coding.python.intro.pages.Exceptions;
import io.github.agdturner.course.coding.python.intro.pages.Functions;
import io.github.agdturner.course.coding.python.intro.pages.GUI;
import io.github.agdturner.course.coding.python.intro.pages.Github;
import io.github.agdturner.course.coding.python.intro.pages.PythonIntroHome;
import io.github.agdturner.course.coding.python.intro.pages.IO;
import io.github.agdturner.course.coding.python.intro.pages.Loops;
import io.github.agdturner.course.coding.python.intro.pages.Modules;
import io.github.agdturner.course.coding.python.intro.pages.Programming;
import io.github.agdturner.course.coding.python.intro.pages.Python;
import io.github.agdturner.course.coding.python.intro.pages.Testing;
import io.github.agdturner.course.coding.python.intro.pages.Variables;
import io.github.agdturner.course.coding.python.intro.pages.Web;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Java for generating Python Intro Course  Website content.
 *
 * @author Andy Turner
 */
public abstract class PythonIntroCourse extends PythonCourse {

    /**
     * Creates a new instance.
     *
     * @param env What {@link #env} is set to.
     * @param courseCode What {@link #courseCode} is set to.
     * @param courseName What {@link #courseName} is set to.
     */
    public PythonIntroCourse(Environment env, String courseCode,
            String courseName) {
        super(env, courseCode, courseName);
        /**
         * Initialise Course Pages.
         */
        // Home
        homePage = new PythonIntroHome(this, courseName);
        // Course Pages
        pages.add(new Programming(this));
        pages.add(new Python(this));
        pages.add(new Variables(this));
        pages.add(new Github(this));
        pages.add(new ABM1(this));
        pages.add(new Containers(this));
        pages.add(new Branching(this));
        pages.add(new Loops(this));
        pages.add(new ABM2(this));
        pages.add(new Functions(this));
        pages.add(new ABM3(this));
        pages.add(new Classes(this));
        pages.add(new ABM4(this));
        pages.add(new IO(this));
        pages.add(new ABM5(this));
        pages.add(new Modules(this));
        pages.add(new ABM6(this));
        pages.add(new Exceptions(this));
        pages.add(new ABM7(this));
        pages.add(new GUI(this));
        pages.add(new ABM8(this));
        pages.add(new Web(this));
        pages.add(new ABM9(this));
        pages.add(new Testing(this));
    }

    /**
     * Write Pages.
     *
     * @param path
     */
    protected void write(Path path) {
        write(homePage, path);
        for (int j = 0; j < pages.size(); j++) {
            write((CoursePage) pages.get(j), path);
        }
        write(index, path);
        write(references, path);
    }

    /**
     * 
     * @param page
     * @param path 
     */
    protected void write(CoursePage page, Path path) {
        page.write();
        // Write footer
        // Add navigation
        page.w.add("<footer>");
        page.w.add(page.getLinks("nav", false));
        page.w.add("<p>Date last modified: " + LocalDate.now().toString() + ".</p>");
        String cc0 = "https://creativecommons.org/share-your-work/public-domain/cc0/";
        page.w.add("<p>" + Web_ContentWriter.getLink(cc0, "CC0 Licence") + "</p>");
        page.w.add("</footer>");
        // Write page
        try {
            page.w.writeHTML(page.path, "index", page.title + " Page", 
                    CoursePage.getHeadElements(path));
        } catch (IOException ex) {
            Logger.getLogger(PythonIntroCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public PythonIndex getIndex() {
        return (PythonIndex) index;
    }

    @Override
    public PythonReferences getReferences() {
        return (PythonReferences) references;
    }

    @Override
    public PythonIntroHome getHomePage() {
        return (PythonIntroHome) homePage;
    }
}
