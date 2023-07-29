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
package io.github.agdturner.course.coding.java.intro;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.CoursePage;
import io.github.agdturner.course.coding.pages.Programming;
import io.github.agdturner.course.coding.java.JavaCourse;
import io.github.agdturner.course.coding.java.intro.pages.Java;
import io.github.agdturner.course.coding.java.intro.pages.JavaIntroHome;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Java for generating Java Intro Course Website content.
 *
 * @author Andy Turner
 */
public abstract class JavaIntroCourse extends JavaCourse {

    /**
     * Creates a new instance.
     *
     * @param env What {@link #env} is set to.
     * @param courseCode What {@link #courseCode} is set to.
     * @param courseName What {@link #courseName} is set to.
     */
    public JavaIntroCourse(Environment env, String courseCode,
            String courseName) {
        super(env, courseCode, courseName);
        /**
         * Initialise Course Pages.
         */
        // Home
        homePage = new JavaIntroHome(this, courseName);
        // Course Pages
        pages.add(new Programming(this));
        pages.add(new Java(this));
/*        coursePages.add(new Variables(this));
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
        coursePages.add(new Modules(this));
        coursePages.add(new ABM6(this));
        coursePages.add(new Exceptions(this));
        coursePages.add(new ABM7(this));
        coursePages.add(new GUI(this));
        coursePages.add(new ABM8(this));
        coursePages.add(new Web(this));
        coursePages.add(new ABM9(this));
        coursePages.add(new Testing(this));
         */
    }

    /**
     * Write Pages.
     *
     * @param local The path.
     */
    public void write(Path local) {
        write(homePage, local);
        for (int j = 0; j < pages.size(); j++) {
            write((CoursePage) pages.get(j), local);
        }
        write(index, local);
        write(references, local);
    }

    protected final void write(CoursePage page, Path local) {
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
            page.w.writeHTML(page.path, "index", page.title + " Page", CoursePage.getHeadElements(local));
        } catch (IOException ex) {
            Logger.getLogger(JavaIntroCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
