/*
 * Copyright 2024 University of Leeds.
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
package io.github.agdturner.course.coding.intro.python.process;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Python0.
 *
 * @author Andy Turner
 */
public class Python0 extends PythonIntroCodingCourse {
    
    public Python0(Environment env, String courseCode, String courseName,
            boolean localPaths) {
        super(env, courseCode, courseName, localPaths);
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        String courseCode = "Python0";
        String courseName = "Python for HPC Level 0";
        Path dir = Paths.get("C:", "Users", "geoagdt", "src", "agdt");
        //Path local = Paths.get("courses", "computing");
        String domain = Environment.AGDTURNER_GITHUB_IO;
        Path local = Paths.get(dir.toString(), domain, courseCode, "public_html");
        Environment env = new Environment(domain, dir);
        // Set localPaths to false when deploying.
        boolean localPaths = false;
        Python0 course = new Python0(env, courseCode, courseName, localPaths);
        course.write(local);
    }
}
