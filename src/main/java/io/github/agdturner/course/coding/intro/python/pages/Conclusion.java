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
package io.github.agdturner.course.coding.intro.python.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.course.CoursePage;

/**
 * For Python Intro Course Variables Page.
 *
 * @author Andy Turner
 */
public class Conclusion extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public Conclusion(PythonIntroCodingCourse course) {
        super(course, "conclusion", "Conclusion", "Conclusion");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Summary", sb);
        w.addPST(sb,
                """
                If you followed through and things have worked out, then you
                should now have a simple
                """);
        sb.append(index.getReference("ABM", "Agent Based Model"));
        w.addPET(sb,
                """
                 that represents a set of entities that move around in an
                environment, interacting with the environment and each other.
                """);
        w.addP(sb, """
                   Here is a link to a GitHub repository with some example code:
                   <a href="https://github.com/agdturner/ccg-course-python-intro">https://github.com/agdturner/ccg-course-python-intro</a>
                   """);
        
        w.addP(sb,
                """
                Developing the code by following instructions puts into
                practise some of the theory introduced in other pages.
                If you got things working, then you could use your skills and
                knowledge to develop the model in interesting ways without
                needing detailed instructions.
                """);
        w.addP(sb,
                """
                I hope you found these learning resources useful and that you
                put you coding skills to good use :)
                """);
        return sb.toString();
    }
}
