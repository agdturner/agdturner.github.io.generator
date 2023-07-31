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
package io.github.agdturner.course.coding.intro.java;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.CoursePage;
import io.github.agdturner.course.coding.pages.CodingCourseProgramming;
import io.github.agdturner.course.coding.java.JavaCodingCourse;
import io.github.agdturner.course.coding.intro.java.pages.Java;
import io.github.agdturner.course.coding.intro.java.pages.JavaIntroCodingCourseHome;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Java Intro Coding Course.
 *
 * @author Andy Turner
 */
public abstract class JavaIntroCodingCourse extends JavaCodingCourse {

    /**
     * Creates a new instance.
     *
     * @param env What {@link #env} is set to.
     * @param courseCode What {@link #courseCode} is set to.
     * @param courseName What {@link #courseName} is set to.
     */
    public JavaIntroCodingCourse(Environment env, String courseCode,
            String courseName) {
        super(env, courseCode, courseName);
        /**
         * Initialise Course Pages.
         */
        // Home
        homePage = new JavaIntroCodingCourseHome(this, courseName);
        // Course Pages
        pages.add(new CodingCourseProgramming(this));
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
}
