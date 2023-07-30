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
package io.github.agdturner.course.coding.intro.python.sog;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.course.coding.intro.python.sog.pages.SoGPythonIntroCodingCourseHome;
import io.github.agdturner.course.sog.SoGCourseDetails;

/**
 * Java for generating a SoG Course Website.
 *
 * @author Andy Turner
 */
public abstract class SoGPythonIntroCodingCourse extends PythonIntroCodingCourse {

    /**
     * Course details.
     */
    public SoGCourseDetails courseDetails;
    
    /**
     * The weighting given to Assignment 1.
     */
    public int assignment1Weighting;

    /**
     * The name for Assignment 1.
     */
    public String assignment1Name;
    
    /**
     * The date for Assignment 1.
     */
    public String assignment1DueDate;
    
    /**
     * The weighting given to Assignment 2.
     */
    public int assignment2Weighting;

    /**
     * The name for Assignment 2.
     */
    public String assignment2Name;
    
    /**
     * The date for Assignment 2.
     */
    public String assignment2DueDate;
    
    /**
     * Creates a new instance.
     *
     * @param env What {@link #env} is set to.
     * @param courseCode What {@link #courseCode} is set to.
     * @param courseName What {@link #courseName} is set to.
     * @param academicYear What {@link #academicYear} is set to.
     * @param assignment1Name What {@link #assignment1Name} is set to.
     * @param assignment1DueDate What {@link #assignment1DueDate} is set to.
     * @param assignment1Weighting What {@link #assignment1Weighting} is set to.
     * @param assignment2Name What {@link #assignment2Name} is set to.
     * @param assignment2DueDate What {@link #assignment2DueDate} is set to.
     * @param assignment2Weighting What {@link #assignment2Weighting} is set to.
     */
    public SoGPythonIntroCodingCourse(Environment env, String courseCode, 
            String courseName, String academicYear,
            String assignment1Name, String assignment1DueDate, 
            int assignment1Weighting, String assignment2Name, 
            String assignment2DueDate, int assignment2Weighting) {
        super(env, courseCode, courseName);
        homePage = new SoGPythonIntroCodingCourseHome(this, courseName);
        this.courseDetails = new SoGCourseDetails(this, academicYear);
        this.assignment1Name = assignment1Name;
        this.assignment1DueDate = assignment1DueDate;
        this.assignment1Weighting = assignment1Weighting;
        this.assignment2Name = assignment2Name;
        this.assignment2DueDate = assignment2DueDate;
        this.assignment2Weighting = assignment2Weighting;
    }
    
    @Override
    public String getCourseCode() {
        return "GEOG" + super.getCourseCode();
    }
    
}
