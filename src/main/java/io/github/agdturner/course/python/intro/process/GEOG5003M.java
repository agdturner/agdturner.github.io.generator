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

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.python.intro.PythonIntroCourse;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Java for generating some https://agdturner.github.io Website Content.
 *
 * @author Andy Turner
 */
public class GEOG5003M extends PythonIntroCourse {
    
    /**
     * Creates a new instance.
     *
     * @param courseNumber What {@link #courseNumber} is set to.
     * @param courseName What {@link #courseName} is set to.
     * @param academicYear What {@link #academicYear} is set to.
     * @param assignment1Weighting What {@link #assignment1Weighting} is set to.
     * @param assignment1Weighting What {@link #assignment1Weighting} is set to.
     */
    public GEOG5003M(Environment env, int courseNumber, String courseName, String academicYear,
            boolean hasAssignments,
            String assignment1Name,
            String assignment1DueDate,
             int assignment1Weighting, 
            String assignment2Name,
            String assignment2DueDate,
            int assignment2Weighting, Path local) {
        super(env, courseNumber, courseName, academicYear, hasAssignments,
                assignment1Name, assignment1DueDate, assignment1Weighting, 
                assignment2Name, assignment2DueDate, assignment2Weighting, 
                local);
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        String courseName = "Programming for Geographical Information Analysis:"
                + " Core Skills";
        int assignment1Weighting = 30;
        int assignment2Weighting = 70;
        String assignment1Name = "Assignment 1 Portfolio";
        String assignment1DueDate = "23rd March 2023";
        String assignment2Name = "Assignment 2 Independent Project";
        String assignment2DueDate = "11th May 2023";
        Path dir = Paths.get("C:", "Users", "agdtu", "src", "agdt");
        Path local = Paths.get("courses", "computing");
        //Path dir = Paths.get("C:", "Users", "geoagdt", "src", "agdt");
        //String  domain = "agdturner.github.io";
        String  domain = "www.geog.leeds.ac.uk";
        Environment env = new Environment(domain, dir);
        //public final Path DIR_COURSES = Paths.get(dir.toString(), "courses");
        //public final String URL_GITHUB_AGDTURNER = URL_GITHUB + "agdturner/";
        GEOG5003M c = new GEOG5003M(env,
                5003, courseName, "202223", true,
                assignment1Name, assignment1DueDate, assignment1Weighting,
                assignment2Name, assignment2DueDate, assignment2Weighting,
                local);
    }
}
