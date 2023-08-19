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
package io.github.agdturner.course.coding.intro.python.sog.process;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.coding.intro.python.sog.SoGPythonIntroCodingCourse;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * GEOG5003M is/was a School of Geography Online Distance Learning module.
 *
 * @author Andy Turner
 */
public class GEOG5003M extends SoGPythonIntroCodingCourse {
    
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
    public GEOG5003M(Environment env, String courseCode, String courseName, 
            boolean localPaths, String academicYear, String assignment1Name, 
            String assignment1DueDate, int assignment1Weighting, 
            String assignment2Name, String assignment2DueDate,
            int assignment2Weighting) {
        super(env, courseCode, courseName, localPaths, academicYear,
                assignment1Name, assignment1DueDate, assignment1Weighting, 
                assignment2Name, assignment2DueDate, assignment2Weighting);
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
        String assignment1DueDate = "28th April 2023";//23rd March 2023";
        String assignment2Name = "Assignment 2 Independent Project";
        String assignment2DueDate = "12th May 2023";//11th May 2023";
        //Path dir = Paths.get("C:", "Users", "agdtu", "src", "agdt");
        Path dir = Paths.get("C:", "Users", "geoagdt", "src", "agdt");
        Path local = Paths.get("courses", "computing");
        String domain = Environment.AGDTURNER_GITHUB_IO;
        //String  domain = "www.geog.leeds.ac.uk";
        Environment env = new Environment(domain, dir);
        //public final Path DIR_COURSES = Paths.get(dir.toString(), "courses");
        //public final String URL_GITHUB_AGDTURNER = URL_GITHUB + "agdturner/";
        boolean localPaths = true;
        GEOG5003M course = new GEOG5003M(env,
                "5003", courseName, localPaths, "202223",
                assignment1Name, assignment1DueDate, assignment1Weighting,
                assignment2Name, assignment2DueDate, assignment2Weighting);
        course.write(local);
    }
}
