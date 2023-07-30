/*
 * Copyright 2023 Centre for Computational Geography.
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
package io.github.agdturner.course.coding;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.Course;

/**
 * Coding Course.
 * 
 * @author Andy Turner
 */
public abstract class CodingCourse extends Course {
    
    public CodingCourse(Environment env, String courseType, String courseCode, String courseName) {
        super(env, courseType, courseCode, courseName);
    }
    
}
