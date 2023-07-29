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
package io.github.agdturner.course.coding.python;

import io.github.agdturner.course.*;
import io.github.agdturner.core.Environment;

/**
 * Java for generating PythonCourse Web content.
 *
 * @author Andy Turner
 */
public abstract class PythonCourse extends Course {

    /**
     * The course Type for setting {@link #courseType}.
     */
    public static final String COURSE_TYPE = "python";

    /**
     * Creates a new instance.
     *
     * courseType is set to "python".
     *
     * @param env What {@link #env} is set to.
     * @param courseCode What {@link #courseCode} is set to.
     * @param courseName What {@link #courseName} is set to.
     */
    public PythonCourse(Environment env, String courseCode,
            String courseName) {
        super(env, COURSE_TYPE, courseCode, courseName);
        index = new PythonIndex(this, "index", "Index", "Index");
        references = new PythonReferences(this, "references", "References", "References");
    }

}
