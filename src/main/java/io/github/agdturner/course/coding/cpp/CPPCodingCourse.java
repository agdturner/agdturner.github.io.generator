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
package io.github.agdturner.course.coding.cpp;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.coding.CodingCourse;

/**
 * Python Coding Course.
 *
 * @author Andy Turner
 */
public abstract class CPPCodingCourse extends CodingCourse {

    /**
     * The course Type for setting {@link #courseType}.
     */
    public static final String COURSE_TYPE = "cpp";

    /**
     * The course Type for setting {@link #courseTypeCapitalised}.
     */
    public static final String COURSE_TYPE2 = "C++";

    public CPPCodingCourse(Environment env, String courseCode,
            String courseName, boolean localPaths) {
        super(env, COURSE_TYPE, COURSE_TYPE2, courseCode, courseName,
                localPaths);
        index = new CPPIndex(this, "index", "Index", "Index");
        references = new CPPReferences(this, "references", "References",
                "References");
    }

    @Override
    public CPPIndex getIndex() {
        return (CPPIndex) index;
    }

    @Override
    public CPPReferences getReferences() {
        return (CPPReferences) references;
    }
}
