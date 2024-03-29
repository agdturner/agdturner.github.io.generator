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
package io.github.agdturner.course.coding.java;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.coding.CodingCourse;

/**
 * Java for generating JavaCourse web content.
 *
 * @author Andy Turner
 */
public abstract class JavaCodingCourse extends CodingCourse {

    /**
     * The course Type for setting {@link #courseType}.
     */
    protected static final String COURSE_TYPE = "java";

    /**
     * The course Type for setting {@link #courseTypeCapitalised}.
     */
    public static final String COURSE_TYPE2 = "Java";
    
    /**
     * Creates a new instance.courseType is set to "python".
     *
     * @param env What {@link #env} is set to.
     * @param courseCode What {@link #courseCode} is set to.
     * @param courseName What {@link #courseName} is set to.
     * @param localPaths What {@link #localPaths} is set to.
     */
    public JavaCodingCourse(Environment env, String courseCode, 
            String courseName, boolean localPaths) {
        super(env, COURSE_TYPE, COURSE_TYPE2, courseCode, courseName,
                localPaths);
        index = new JavaIndex(this, "index", "Index", "Index");
        references = new JavaReferences(this, "references", "References",
                "References");
    }

    @Override
    public JavaIndex getIndex() {
        return (JavaIndex) index;
    }

    @Override
    public JavaReferences getReferences() {
        return (JavaReferences) references;
    }
}
