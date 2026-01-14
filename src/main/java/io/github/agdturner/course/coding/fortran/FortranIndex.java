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
package io.github.agdturner.course.coding.fortran;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.Index;
import io.github.agdturner.course.IndexTerm;

/**
 * Java Index Course Page.
 *
 * @author Andy Turner
 */
public class FortranIndex extends Index {

    /**
     * Create a new instance.
     *
     * @param course What {@code #course} is set to.
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     */
    public FortranIndex(Course course, String filename, String title, String label) {
        super(course, filename, title, label);
        String term; // The term.
        String url;  // The URL.
        String desc; // A description.
        IndexTerm indexTerm;

        term = "Fortran 2023";
        url = "https://www.iso.org/standard/82170.html";
        desc = """
               "ISO/IEC 1539-1:2023" standard "Fortran".
               """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "ISO/IEC 1539-1:2023";
        url = "https://www.iso.org/standard/82170.html";
        desc = """
               A "standards" document for "Fortran 2023" base language.
               """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

    }

}
