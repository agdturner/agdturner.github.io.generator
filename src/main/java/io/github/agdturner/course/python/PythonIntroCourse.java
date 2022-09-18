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

import io.github.agdturner.Page;
import io.github.agdturner.core.PageID;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.CoursePage;
import io.github.agdturner.course.CoursePageGeneral;
import io.github.agdturner.io.IO;
import java.io.IOException;
import java.nio.file.Path;
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
     * @param courseCode What {@link #courseCode} is set to.
     * @param courseName What {@link #courseName} is set to.
     * @param assignment1Weighting What {@link #assignment1Weighting} is set to.
     * @param assignment1Weighting What {@link #assignment1Weighting} is set to.
     */
    public PythonIntroCourse(String courseCode, String courseName,
            boolean hasAssignments, int assignment1Weighting,
            int assignment2Weighting) {
        super(COURSE_TYPE, courseCode, courseName);
        this.hasAssignments = hasAssignments;
        this.assignment1Weighting = assignment1Weighting;
        this.assignment2Weighting = assignment2Weighting;
    }

    /**
     * Adds a Agent Based Modelling Practical Page.
     *
     * @param w The Web_ContentWriter.
     * @param index The index of the ABM Practical.
     */
    public void addABMPage(Web_ContentWriter w, PageID id, int index) {
        addPage(w, id, "abm" + index, "ABM " + index);
    }

    /**
     * Write the Introduction To Python Course HTML.
     *
     * @param domain The domain courseName as a String.
     * @param courseDir The course root directory.
     * @throws IOException If encountered.
     */
    public void write(Path courseDir)
            throws IOException {
        int i = 0;
        PageID id = new PageID(i);

        // Home
        homePage = new PythonIntroCoursePageHome(courseName, id, this);
        homePage.write(courseDir);
        CoursePageGeneral page;

        // Programming
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageProgramming(id, this);
        write(page, id, i);

        // Python
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePagePython(id, this);
        write(page, id, i);

        // GitHub
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageGithub(id, this);
        write(page, id, i);

        // Variables
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageVariables(id, this);
        write(page, id, i);

        // ABM1
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageABM1(id, this);
        write(page, id, i);

        // Containers
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageContainers(id, this);
        write(page, id, i);

        // BranchingAndLoops(
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageBranchingAndLoops(id, this);
        write(page, id, i);

        // ABM2
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageABM2(id, this);
        write(page, id, i);

        // Functions
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageFunctions(id, this);
        write(page, id, i);

        // ABM3
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageABM3(id, this);
        write(page, id, i);

        // Classes
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageGithub(id, this);
        write(page, id, i);

        // ABM4
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageABM4(id, this);
        write(page, id, i);

        // Input/Output
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageIO(id, this);
        write(page, id, i);

        // ABM5
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageABM5(id, this);
        write(page, id, i);

        // Modules
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageModules(id, this);
        write(page, id, i);

        // ABM6
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageABM6(id, this);
        write(page, id, i);

        // Exceptions
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageExceptions(id, this);
        write(page, id, i);

        // ABM7
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageABM7(id, this);
        write(page, id, i);

        // GUI
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageGUI(id, this);
        write(page, id, i);

        // Web
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageWeb(id, this);
        write(page, id, i);

        // ABM8
        i++;
        id = new PageID(i);
        page = new PythonIntroCoursePageABM8(id, this);
        write(page, id, i);

        // Index
        i++;
        id = new PageID(i);
        indexPage = new PythonIntroCoursePageIndex("index", id, this);
        write(indexPage, id);

        // References
        i++;
        id = new PageID(i);
        referencesPage = new PythonIntroCoursePageReferences("references", id, this);
        write(referencesPage, id);
    }

    protected void write(CoursePageGeneral page, PageID id, int i) throws IOException {
        page.write(courseDir);
        // Add navigation
        page.addNav(courseDir, i);
        // Write page
        writePage(page, id);
    }

    protected void write(CoursePage page, PageID id) throws IOException {
        page.write(courseDir);
        // Add navigation
        page.w.add("<div>");
        page.w.add("<nav>");
        page.w.add(Web_ContentWriter.getLink("../index.html", "Home"));
        page.w.add("</nav>");
        page.w.add("</div>");
        // Write page
        writePage(page, id);
    }

    protected void writePage(Page page, PageID id) throws IOException {
        Path p = IO.getDir(courseDir, pageIDToNameA.get(id));
        page.w.writeHTML(p, "index", pageIDToName.get(id) + " Page", Page.getHeaderElements());
    }
}
