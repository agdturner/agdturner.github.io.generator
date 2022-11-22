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
package io.github.agdturner.course.python.intro.pages;

import io.github.agdturner.course.python.intro.PythonIntroCourse;
import io.github.agdturner.course.Page;

/**
 * For Python Intro Course Branching and Loops Page.
 *
 * @author Andy Turner
 */
public class Branching extends Page {
    
    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Branching(PythonIntroCourse c) {
        super("branching", "Branching", "Branching", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("<p>ABM</p>");
//        w.add("<p></p>");
//        w.add("<p>Enter: \"\"</p>");
        w.add("</div>");
    }
}