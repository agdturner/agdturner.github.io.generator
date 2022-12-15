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
 * Java for generating some https://agdturner.github.io Website Content.
 *
 * @author Andy Turner
 */
public class GEOG5995M extends PythonIntroCourse {

    /**
     * Creates a new instance.
     *
     * @param courseNumber What {@link #courseNumber} is set to.
     * @param courseName What {@link #courseName} is set to.
     * @param hasAssignments
     * @param assignment1Weighting What {@link #assignment1Weighting} is set to.
     * @param assignment1Weighting What {@link #assignment1Weighting} is set to.
     */
    public GEOG5995M(int courseNumber, String courseName, String academicYear,
            boolean hasAssignments, int assignment1Weighting,
            int assignment2Weighting) {
        super(courseNumber, courseName, academicYear, hasAssignments,
                assignment1Weighting, assignment2Weighting);
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        String courseName = "Programming for Social Science: Core Skills";
        int courseNumber = 5995;
        int assignment1Weighting = 30;
        int assignment2Weighting = 70;
        GEOG5995M c = new GEOG5995M(courseNumber, courseName, "202223",
                true, assignment1Weighting, assignment2Weighting);
    }
}
