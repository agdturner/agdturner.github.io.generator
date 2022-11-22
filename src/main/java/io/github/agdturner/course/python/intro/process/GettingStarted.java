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
package io.github.agdturner.course.python.intro.process;

import io.github.agdturner.course.python.intro.PythonIntroCourse;

/**
 * Java for generating https://agdturner.github.io Courses Python GettingStarted
 * content.
 *
 * @author Andy Turner
 */
public class GettingStarted extends PythonIntroCourse {
    
    /**
     * Creates a new instance.
     *
     * @param courseCode What {@link #courseCode} is set to.
     * @param courseName What {@link #courseName} is set to.
     * @param hasAssignments Is true if there are assignments and false otherwise.
     * @param assignment1Weighting What {@link #assignment1Weighting} is set to.
     * @param assignment1Weighting What {@link #assignment1Weighting} is set to.
     */
    public GettingStarted(String courseCode, String courseName,
            boolean hasAssignments, int assignment1Weighting, 
            int assignment2Weighting) {
        super(courseCode, courseName, hasAssignments, assignment1Weighting, 
                assignment2Weighting);
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        String courseName = "Programming for Geography: Python 1";
        String courseCode = "GettingStarted";
        boolean assignments = false;
        GettingStarted c = new GettingStarted(courseCode, courseName, 
                assignments, 0, 0);
    }
}
