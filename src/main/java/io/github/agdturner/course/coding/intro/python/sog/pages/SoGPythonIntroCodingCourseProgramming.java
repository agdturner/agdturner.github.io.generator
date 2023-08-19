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
import io.github.agdturner.course.Course;
import io.github.agdturner.course.coding.intro.python.pages.PythonIntroCodingCourseProgramming;

/**
 * SoG Python Intro Course Home Page.
 *
 * @author Andy Turner
 */
public class SoGPythonIntroCodingCourseProgramming extends PythonIntroCodingCourseProgramming {

    public SoGPythonIntroCodingCourseProgramming(Course course) {
        super(course);
    }

    @Override
    public SectionID getLearning0(StringBuilder sb) {
        SectionID sid = super.getLearning0(sb);
        addParagraph(sb,
                """
                You are at liberty to engage in online forums, but please do not
                post questions about this course, particularly about the
                assignments. Ask a tutor if you want help.
                """);
        return sid;
    }

    @Override
    public SectionID getConsiderata0(StringBuilder sb) {
        SectionID sid = super.getConsiderata0(sb);
        addParagraph(sb,
                """
                Keep in mind that it is important to keep track of what you
                consult and avoid plagiarising (presenting other's work as your
                own).
                """);
        return sid;
    }
}
