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
package io.github.agdturner.course.coding.c;

import io.github.agdturner.course.coding.cpp.*;
import io.github.agdturner.core.Environment;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.Index;
import io.github.agdturner.course.IndexTerm;

/**
 * Python Index Course Page.
 *
 * @author Andy Turner
 */
public class CIndex extends Index {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     */
    public CIndex(Course course, String filename, String title, String label) {
        super(course, filename, title, label);
        String term; // The term.
        String url;  // The URL.
        String desc; // A description.
        IndexTerm indexTerm;

        term = "C23";
        url = Environment.getWikipediaURL("C23_(C_standard_revision)");
        desc = """
               The current "open standard" for the C programming language",
               published in October 2024.
               """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);
        
        term = "C17";
        url = Environment.getWikipediaURL("C17");
        desc = """
               An "open standard" for the "C programming language", published in
               June 2018.
               """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "C11";
        url = Environment.getWikipediaURL("C11");
        desc = """
               An "open standard" for the "C programming language", published in
               December 2011.
               """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "C standard library";
        url = Environment.getWikipediaURL("C_standard_library");
        desc = """
               Provides macros, type definitions and functions for tasks such as
               string manipulation, mathematical computation, input/output
               processing, memory management, and input/output.
               """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

    }

    /**
     * The default CPPReference URL.
     */
    public static final String EN_CPPREFERENCE_URL = "https://en.cppreference.com/w/cpp/";

    /**
     * @param article Appended to create what is returned.
     * @return {@link #EN_CPPREFERENCE_URL} + "language/" + article;
     */
    public static final String getCPPReferenceLanguageURL(String article) {
        return EN_CPPREFERENCE_URL + "language/" + article;
    }

    /**
     * @param article Appended to create what is returned.
     * @return {@link #EN_CPPREFERENCE_URL} + "container/" + article;
     */
    public static final String getCPPReferenceContainerURL(String article) {
        return EN_CPPREFERENCE_URL + "container/" + article;
    }
}
