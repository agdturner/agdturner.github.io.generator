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
package io.github.agdturner.course.coding.java.pages;

import io.github.agdturner.course.coding.java.JavaCodingCourse;
import io.github.agdturner.course.pages.CourseHome;

/**
 * Extend this for a Java Course Home Page.
 *
 * @author Andy Turner
 */
public abstract class CourseJavaHomePage extends CourseHome {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     * @param courseName What {@link #name} is set to.
     */
    public CourseJavaHomePage(String courseName, JavaCodingCourse course) {
        super(course, courseName);
    }
    
    /**
     * @return JavaCourse.
     */
    @Override
    public JavaCodingCourse getCourse() {
        return (JavaCodingCourse) site; 
    }
}
