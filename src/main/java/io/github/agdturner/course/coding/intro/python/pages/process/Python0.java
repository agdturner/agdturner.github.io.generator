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
package io.github.agdturner.course.coding.intro.python.pages.process;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Java for generating GEOG5003M Website Content.
 *
 * @author Andy Turner
 */
public class Python0 extends PythonIntroCodingCourse {
    
    /**
     * Creates a new instance.
     *
     * @param env What {@link #env} is set to.
     * @param courseCode What {@link #courseCode} is set to.
     * @param courseName What {@link #courseName} is set to.
     */
    public Python0(Environment env, String courseCode, String courseName) {
        super(env, courseCode, courseName);
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        String courseName = "Introduction to Python Programming";
        Path dir = Paths.get("C:", "Users", "geoagdt", "src", "agdt");
        Path local = Paths.get("courses", "computing");
        String domain = Environment.AGDTURNER_GITHUB_IO;
        Environment env = new Environment(domain, dir);
        Python0 course = new Python0(env, "Python0", courseName);
        course.write(local);
    }
}
