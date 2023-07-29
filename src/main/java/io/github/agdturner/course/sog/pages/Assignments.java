/*
 * Copyright 2022 Centre for Computational Geography.
 *
 * Licensed under the Apache License, Version 2.0 (the"License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an"AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.agdturner.course.sog.pages;

import io.github.agdturner.course.coding.python.intro.PythonIntroCourse;
import io.github.agdturner.course.CoursePage;

/**
 * For Python Intro Course Modules Page.
 *
 * @author Andy Turner
 */
public class Assignments extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public Assignments(PythonIntroCourse course) {
        super(course, "assignments", "Assignments", "Assignments");
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2 id="1">1. Assignment 1</h2>");
              <p></p>
              <h2 id="2">2. Assignment 2</h2>");
              <p></p>
              """);
        w.add("</div>");
    }
}
