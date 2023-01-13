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
package io.github.agdturner.course.python.intro;

import io.github.agdturner.course.Course;
import io.github.agdturner.course.Page;
import io.github.agdturner.course.python.intro.pages.ABM1;
import io.github.agdturner.course.python.intro.pages.ABM2;
import io.github.agdturner.course.python.intro.pages.ABM3;
import io.github.agdturner.course.python.intro.pages.ABM4;
import io.github.agdturner.course.python.intro.pages.ABM5;
import io.github.agdturner.course.python.intro.pages.ABM6;
import io.github.agdturner.course.python.intro.pages.ABM7;
import io.github.agdturner.course.python.intro.pages.ABM8;
import io.github.agdturner.course.python.intro.pages.Branching;
import io.github.agdturner.course.python.intro.pages.Classes;
import io.github.agdturner.course.python.intro.pages.Containers;
import io.github.agdturner.course.python.intro.pages.Exceptions;
import io.github.agdturner.course.python.intro.pages.Functions;
import io.github.agdturner.course.python.intro.pages.GUI;
import io.github.agdturner.course.python.intro.pages.Github;
import io.github.agdturner.course.python.intro.pages.Home;
import io.github.agdturner.course.python.intro.pages.IO;
import io.github.agdturner.course.python.intro.pages.Loops;
import io.github.agdturner.course.python.intro.pages.Programming;
import io.github.agdturner.course.python.intro.pages.Python;
import io.github.agdturner.course.python.intro.pages.Variables;
import io.github.agdturner.course.python.intro.pages.Web;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Java for generating PythonIntro Course https://agdturner.github.io Website
 * Content.
 *
 * @author Andy Turner
 */
public abstract class PythonIntroCourse extends Course {

    /**
     * The course Type for setting {@link #courseType}.
     */
    protected static final String COURSE_TYPE = "python";

    public final boolean hasAssignments;

    /**
     * The weighting given to Assignment 1.
     */
    public final int assignment1Weighting;

    /**
     * The weighting given to Assignment 2.
     */
    public final int assignment2Weighting;

    /**
     * Creates a new instance.
     *
     * @param courseNumber What {@link #courseNumber} is set to.
     * @param courseName What {@link #courseName} is set to.
     * @param assignment1Weighting What {@link #assignment1Weighting} is set to.
     * @param assignment1Weighting What {@link #assignment1Weighting} is set to.
     */
    public PythonIntroCourse(int courseNumber, String courseName,
            String academicYear,
            boolean hasAssignments,  
            int assignment1Weighting,
            int assignment2Weighting) {
        super(COURSE_TYPE, courseNumber, courseName, academicYear);
        this.hasAssignments = hasAssignments;
        this.assignment1Weighting = assignment1Weighting;
        this.assignment2Weighting = assignment2Weighting;
        /**
         * Initialise Course Pages.
         */
        // Home
        homePage = new Home(courseName, this);
        // Course Pages
        coursePages.add(new Programming(this));
        coursePages.add(new Python(this));
        coursePages.add(new Variables(this));
        coursePages.add(new Github(this));
        coursePages.add(new ABM1(this));
        coursePages.add(new Containers(this));
        coursePages.add(new Branching(this));
        coursePages.add(new Loops(this));
        coursePages.add(new ABM2(this));
        coursePages.add(new Functions(this));
        coursePages.add(new ABM3(this));
        coursePages.add(new Classes(this));
        coursePages.add(new ABM4(this));
        coursePages.add(new IO(this));
        coursePages.add(new ABM5(this));
        coursePages.add(new ABM6(this));
        coursePages.add(new Exceptions(this));
        coursePages.add(new ABM7(this));
        coursePages.add(new GUI(this));
        coursePages.add(new Web(this));
        coursePages.add(new ABM8(this));
        /**
         * Write Pages.
         */
        write(homePage);
        for (int j = 0; j < coursePages.size(); j ++) {
            write(coursePages.get(j));
        }
        write(index);
        write(references);
    }

    protected final void write(Page page) {
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
            page.w.writeHTML(page.p, "index", page.title + " Page", Page.getHeadElements());
        } catch (IOException ex) {
            Logger.getLogger(PythonIntroCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
