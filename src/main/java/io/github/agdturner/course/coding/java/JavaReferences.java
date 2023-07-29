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
package io.github.agdturner.course.coding.java;

import io.github.agdturner.course.Course;
import io.github.agdturner.course.References;
import io.github.agdturner.course.Term;

/**
 * @author Andy Turner
 */
public class JavaReferences extends References {
    
    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     */
    public JavaReferences(Course course, String filename, String title, String label) {
        super(course, filename, title, label);
        
        String name;
        String url;
        String description;
        
        name = "Apache Maven";
        url = "https://en.wikipedia.org/wiki/Apache_Maven";
        description = "Maven is a build automation tool used primarily for "
                + "Java projects.";
        nameToTerm.put(name, new Term(description, url));
        
    }
}
