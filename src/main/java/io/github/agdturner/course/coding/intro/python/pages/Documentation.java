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
 * For Python Intro Course Branching and Loops Page.
 *
 * @author Andy Turner
 */
public class Documentation extends CoursePage {
    
    /**
     * Create a new instance.
     *
         * @param course What {@link #site} is set to.
     */
    public Documentation(PythonIntroCodingCourse course) {
        super(course, "documentation", "Documentation", "Documentation");
    }
    
    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        w.addP(sb,
                """
                <a href="https://docs.python.org/3/library/doctest.html">
                PyDoc</a>
                is the documentation system distributed with Python. It supports
                the generation of a webpage from documentation, and can be run
                from the Anaconda Prompt using:
                """);
        w.addPRE(sb, "pydoc -w filename");
        w.addP(sb, 
                """
                Where the filename is missing the ".py" part.
                """);
        w.addP(sb,
                """
                There are other tools for helping to generate documentation,
                including
                <a href="http://www.sphinx-doc.org/en/stable/">Sphinx</a>, which
                comes with Anaconda.
                """);
        w.addDIVET(sb);
        return sb.toString();
    }
}
