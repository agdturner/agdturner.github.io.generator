/*
 * Copyright 2024 University of Leeds.
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
package io.github.agdturner.course.coding.intro.cpp;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.coding.cpp.CPPCodingCourse;
import io.github.agdturner.course.coding.intro.cpp.pages.ABM1;
import io.github.agdturner.course.coding.intro.cpp.pages.ABM2;
import io.github.agdturner.course.coding.intro.cpp.pages.ABM3;
import io.github.agdturner.course.coding.intro.cpp.pages.ABM4;
import io.github.agdturner.course.coding.intro.cpp.pages.ABM5;
import io.github.agdturner.course.coding.intro.cpp.pages.ABM6;
import io.github.agdturner.course.coding.intro.cpp.pages.ABM7;
import io.github.agdturner.course.coding.intro.cpp.pages.ABM8;
import io.github.agdturner.course.coding.intro.cpp.pages.ABM9;
import io.github.agdturner.course.coding.intro.cpp.pages.Branching;
import io.github.agdturner.course.coding.intro.cpp.pages.Classes;
import io.github.agdturner.course.coding.intro.cpp.pages.Containers;
import io.github.agdturner.course.coding.intro.cpp.pages.Exceptions;
import io.github.agdturner.course.coding.intro.cpp.pages.Functions;
import io.github.agdturner.course.coding.intro.cpp.pages.GUI;
import io.github.agdturner.course.coding.intro.cpp.pages.Github;
import io.github.agdturner.course.coding.intro.cpp.pages.CPPIntroCodingCourseHome;
import io.github.agdturner.course.coding.intro.cpp.pages.IO;
import io.github.agdturner.course.coding.intro.cpp.pages.Loops;
import io.github.agdturner.course.coding.intro.cpp.pages.Modules;
import io.github.agdturner.course.coding.intro.cpp.pages.CPPIntroCodingCourseProgramming;
import io.github.agdturner.course.coding.intro.cpp.pages.CPP;
import io.github.agdturner.course.coding.intro.cpp.pages.Testing;
import io.github.agdturner.course.coding.intro.cpp.pages.Variables;
import io.github.agdturner.course.coding.intro.cpp.pages.Web;

/**
 * CPP Intro Coding Course.
 *
 * @author Andy Turner
 */
public abstract class CPPIntroCodingCourse extends CPPCodingCourse {

    public CPPIntroCodingCourse(Environment env, String courseCode,
            String courseName, boolean localPaths) {
        super(env, courseCode, courseName, localPaths);
        /**
         * Initialise Course Pages.
         */
        // Home
        homePage = new CPPIntroCodingCourseHome(this);
        // Course Pages
        pages.add(new CPPIntroCodingCourseProgramming(this));
        pages.add(new CPP(this));
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
    public CPPIntroCodingCourseHome getHomePage() {
        return (CPPIntroCodingCourseHome) homePage;
    }
}
