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
package io.github.agdturner.course.coding.intro.python;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.coding.python.PythonCodingCourse;
import io.github.agdturner.course.coding.intro.python.pages.ABM1;
import io.github.agdturner.course.coding.intro.python.pages.ABM2;
import io.github.agdturner.course.coding.intro.python.pages.ABM3;
import io.github.agdturner.course.coding.intro.python.pages.ABM4;
import io.github.agdturner.course.coding.intro.python.pages.ABM5;
import io.github.agdturner.course.coding.intro.python.pages.ABM6;
import io.github.agdturner.course.coding.intro.python.pages.ABM7;
import io.github.agdturner.course.coding.intro.python.pages.ABM8;
import io.github.agdturner.course.coding.intro.python.pages.ABM9;
import io.github.agdturner.course.coding.intro.python.pages.Branching;
import io.github.agdturner.course.coding.intro.python.pages.Classes;
import io.github.agdturner.course.coding.intro.python.pages.Containers;
import io.github.agdturner.course.coding.intro.python.pages.Exceptions;
import io.github.agdturner.course.coding.intro.python.pages.Functions;
import io.github.agdturner.course.coding.intro.python.pages.GUI;
import io.github.agdturner.course.coding.intro.python.pages.Github;
import io.github.agdturner.course.coding.intro.python.pages.PythonIntroCodingCourseHome;
import io.github.agdturner.course.coding.intro.python.pages.IO;
import io.github.agdturner.course.coding.intro.python.pages.Loops;
import io.github.agdturner.course.coding.intro.python.pages.Modules;
import io.github.agdturner.course.coding.intro.python.pages.PythonIntroCodingCourseProgramming;
import io.github.agdturner.course.coding.intro.python.pages.Python;
import io.github.agdturner.course.coding.intro.python.pages.Testing;
import io.github.agdturner.course.coding.intro.python.pages.Variables;
import io.github.agdturner.course.coding.intro.python.pages.Web;

/**
 * Java for generating Python Intro Course  Website content.
 *
 * @author Andy Turner
 */
public abstract class PythonIntroCodingCourse extends PythonCodingCourse {

    /**
     * Creates a new instance.
     *
     * @param env What {@link #env} is set to.
     * @param courseCode What {@link #courseCode} is set to.
     * @param courseName What {@link #courseName} is set to.
     */
    public PythonIntroCodingCourse(Environment env, String courseCode,
            String courseName) {
        super(env, courseCode, courseName);
        /**
         * Initialise Course Pages.
         */
        // Home
        homePage = new PythonIntroCodingCourseHome(this);
        // Course Pages
        pages.add(new PythonIntroCodingCourseProgramming(this));
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

    @Override
    public PythonIntroCodingCourseHome getHomePage() {
        return (PythonIntroCodingCourseHome) homePage;
    }
}
