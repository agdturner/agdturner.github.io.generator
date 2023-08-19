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
package io.github.agdturner.course.coding.intro.java.process;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.coding.intro.java.JavaIntroCodingCourse;
import io.github.agdturner.course.coding.intro.java.pages.JavaIntroCodingCourseHome;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Java for generating Java0 Website Content.
 *
 * @author Andy Turner
 */
public class Java0 extends JavaIntroCodingCourse {

    /**
     * Creates a new instance.
     *
     * @param env 
     * @param courseCode What {@link #courseCode} is set to.
     * @param courseName What {@link #courseName} is set to.
     * @param localPaths What {@link #localPaths} is set to.
     */
    public Java0(Environment env, String courseCode, String courseName,
            boolean localPaths) {
        super(env, courseCode, courseName, localPaths);
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        String courseName = "Introduction to Programming in Java";
        Path dir = Paths.get("C:", "Users", "geoagdt", "src", "agdt");
        String domain = Environment.AGDTURNER_GITHUB_IO;
        Environment env = new Environment(domain, dir);
        boolean localPaths = true;
        Java0 course = new Java0(env, "Java0", courseName, localPaths);
        course.write(dir);
    }

    @Override
    public JavaIntroCodingCourseHome getHomePage() {
        return (JavaIntroCodingCourseHome) homePage;
    }
}
