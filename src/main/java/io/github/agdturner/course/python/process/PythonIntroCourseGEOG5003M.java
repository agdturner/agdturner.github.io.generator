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
package io.github.agdturner.course.python.process;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.python.PythonIntroCourse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java for generating some https://agdturner.github.io Website Content.
 *
 * @author Andy Turner
 */
public class PythonIntroCourseGEOG5003M extends PythonIntroCourse {
    
    /**
     * Creates a new instance.
     *
     * @param courseCode What {@link #courseCode} is set to.
     * @param courseName What {@link #courseName} is set to.
     * @param assignment1Weighting What {@link #assignment1Weighting} is set to.
     * @param assignment1Weighting What {@link #assignment1Weighting} is set to.
     */
    public PythonIntroCourseGEOG5003M(String courseCode, String courseName,
            int assignment1Weighting, int assignment2Weighting) {
        super(courseCode, courseName, assignment1Weighting, 
                assignment2Weighting);
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        String courseName = "Programming for Geographical Information Analysis:"
                + " Core Skills";
        String courseCode = "GEOG5003M";
        int assignment1Weighting = 30;
        int assignment2Weighting = 70;
        PythonIntroCourseGEOG5003M c = new PythonIntroCourseGEOG5003M(
                courseCode, courseName, assignment1Weighting, 
                assignment2Weighting);
        try {
            c.write(c.courseDir);
        } catch (IOException ex) {
            Logger.getLogger(PythonIntroCourseGEOG5003M.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}