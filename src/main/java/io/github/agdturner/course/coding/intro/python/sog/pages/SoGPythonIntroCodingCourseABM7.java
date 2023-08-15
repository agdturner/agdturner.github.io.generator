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
import io.github.agdturner.course.coding.intro.python.pages.ABM7;

/**
 * SoG Python Intro Course ABM7 Page.
 *
 * @author Andy Turner
 */
public class SoGPythonIntroCodingCourseABM7 extends ABM7 {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public SoGPythonIntroCodingCourseABM7(PythonIntroCodingCourse course) {
        super(course);
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getMainContent());
        SectionID sid = addSection("Further Assignment 1 Coding Task", sb);
        sb.append("<p>Alter the stopping condition so that the model stops")
                .append(" when the average agent store is greater than 80.")
                .append("</p>");
        sb.append("<p>Commit your code to your local repository and assuming")
                .append(" you are using GitHub - push your changes to GitHub.")
                .append("</p>")
                .append("</div>\n");
        return sb.toString();
    }
}
