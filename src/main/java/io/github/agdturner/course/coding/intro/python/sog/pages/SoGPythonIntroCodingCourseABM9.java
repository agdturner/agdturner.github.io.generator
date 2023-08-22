/*
 * Copyright 2023 Centre for Computational Geography.
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
package io.github.agdturner.course.coding.intro.python.sog.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.course.coding.intro.python.pages.ABM9;

/**
 * SoG Python Intro Course ABM9 Page.
 *
 * @author Andy Turner
 */
public class SoGPythonIntroCodingCourseABM9 extends ABM9 {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public SoGPythonIntroCodingCourseABM9(PythonIntroCodingCourse course) {
        super(course);
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getMainContent());
        
        SectionID sid = addSection("Assignment 1 submission", sb);
        w.addP(sb, 
                """
                Update the README file for your repository and submit your work.
                """);
        w.addDIVET(sb);
        sb.append("\n");
        return sb.toString();
    }
}
