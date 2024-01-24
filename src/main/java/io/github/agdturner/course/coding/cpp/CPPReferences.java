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
package io.github.agdturner.course.coding.cpp;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.References;
import io.github.agdturner.course.Term;

/**
 * Python Course References.
 * 
 * @author Andy Turner
 */
public class CPPReferences extends References {
    
    /**
     * Create a new instance.
     *
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     * @param course What {@link #site} is set to.
     */
    public CPPReferences(Course course, String filename, String title, String label) {
        super(course, filename, title, label);

        String term;
        String url;
        String description;
        
        term = "C++ Standard Library";
        url = Environment.getWikipediaURL("C%2B%2B_Standard_Library");
        description =
                """
                A collection of classes and functions, which are in the core \
                ISO/IEC 14882 C++ standard.
                """;
        termToTerm.put(term, new Term(index, description, url));
        
        term = "cppreference.com";
        url = "https://en.cppreference.com/";
        description = 
                """
                A community generated online reference for "C" and "C++".
                """;
        termToTerm.put(term, new Term(index, description, url));
        
        term = "Matplot++";
        url = "https://alandefreitas.github.io/matplotplusplus/";
        description = 
                """
                A "C++" graphics library for data visualization.
                """;
        termToTerm.put(term, new Term(index, description, url));
        
        term = "The GNU Compiler Collection";
        url = "https://gcc.gnu.org/";
        description = 
                """
                Includes front ends for "C", "C++", Objective-C, "Fortran", \
                Ada, Go, and D, as well as libraries for these languages.
                """;
        termToTerm.put(term, new Term(index, description, url));
        
        term = "cppreference.com links libs";
        url = "https://en.cppreference.com/w/cpp/links/libs";
        description = 
                """
                A list of "open-source" "C++" libraries.
                """;
        termToTerm.put(term, new Term(index, description, url));
        
    }
}
