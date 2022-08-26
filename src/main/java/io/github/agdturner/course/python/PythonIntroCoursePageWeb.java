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
package io.github.agdturner.course.python;

import io.github.agdturner.core.PageID;
import io.github.agdturner.course.CoursePageGeneral;
import java.io.IOException;
import java.nio.file.Path;

/**
 * For Python Intro Course Variables Page.
 *
 * @author Andy Turner
 */
public class PythonIntroCoursePageWeb extends CoursePageGeneral {

    /**
     * What {@link #name} will be set to.
     */
    private static final String NAME = "variables";
    
    /**
     * Create a new instance.
     *
     * @param id The Page ID.
     * @param c The Course.
     */
    public PythonIntroCoursePageWeb(PageID id, PythonIntroCourse c) {
        super(NAME, id, c);
    }

    @Override
    public void write(Path dir) throws IOException {
        writeH1(name);
        w.add("<p>ABM</p>");
//        w.add("<p></p>");
//        w.add("<p>Enter: \"\"</p>");
        w.add("</div>");
    }
}
