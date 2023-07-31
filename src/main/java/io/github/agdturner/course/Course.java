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
package io.github.agdturner.course;

import io.github.agdturner.core.Environment;
import io.github.agdturner.core.Site;
import io.github.agdturner.course.pages.CourseHome;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Java for generating Website Content for a course.
 *
 * @author Andy Turner
 */
public abstract class Course extends Site {

    /**
     * For storing the course Type e.g. python.
     */
    public final String courseType;

    /**
     * For storing the course code e.g. Java0.
     */
    public final String courseCode;

    /**
     * For storing the course Name. e.g. "Introduction to Programming in C++"
     */
    public final String courseName;

    /**
     * For storing the course directory path.
     */
    public transient final Path courseDir;

    /**
     * Creates a new instance.
     *
     * @param env What {@link #env} is set to.
     * @param courseType What {@link #courseType} is set to.
     * @param courseCode What {@link #courseCode} is set to.
     * @param courseName What {@link #courseName} is set to.
     */
    public Course(Environment env, String courseType, String courseCode, 
            String courseName) {
        super(env);
        this.courseType = courseType;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseDir = Paths.get(env.dir.toString(), courseCode);
    }

    /**
     * @return {@link #courseCode}
     */
    public String getCourseCode() {
        return courseCode; 
    }
    
    /**
     * @return The site index page. 
     */
    public abstract Index getIndex();

    /**
     * @return The site References page. 
     */
    public abstract References getReferences();

    /**
     * @return The site Home page. 
     */
    public abstract CourseHome getHomePage();
}
