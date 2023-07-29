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
package io.github.agdturner.course.sog;

import io.github.agdturner.course.Course;

/**
 * Java for generating a SoG Course Website.
 *
 * @author Andy Turner
 */
public class SoGCourseDetails {

    /**
     * The Course.
     */
    public final Course course;

    /**
     * For storing the academic year. 202223 is the academic year that begins in 
     * 2022 and ends in 2023.
     */
    public final String academicYear;

    /**
     * Creates a new instance.
     *
     * @param course What {@link #course} is set to.
     * @param academicYear What {@link #academicYear} is set to.
     */
    public SoGCourseDetails(Course course, String academicYear) {
        this.course = course;
        this.academicYear = academicYear;
    }

    /**
     * @return "GEOG" + {@link #courseCode}
     */
    public final String getGEOGCourseCode() {
        return "GEOG" + course.courseCode; 
    }

    /**
     * @return "GEOG-" + {@link #courseCode} + "M"
     */
    public String getGEOGCourseCodeM() {
        return "GEOG-" + course.courseCode + "M"; 
    }
}
