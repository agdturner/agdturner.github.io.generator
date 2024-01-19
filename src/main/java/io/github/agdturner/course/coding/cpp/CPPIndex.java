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
package io.github.agdturner.course.coding.cpp;

import io.github.agdturner.core.Environment;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.Index;
import io.github.agdturner.course.IndexTerm;

/**
 * Python Index Course Page.
 *
 * @author Andy Turner
 */
public class CPPIndex extends Index {
    
    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     */
    public CPPIndex(Course course, String filename, String title, String label) {
        super(course, filename, title, label);
        String term;
        String url;
        String description;
        IndexTerm indexTerm;
        
        term = "Boost.Test";
        url = "https://www.boost.org/doc/libs/1_84_0/libs/test/doc/html/index.html";
        description = """
                      A library that provides interfaces for writing test \
                      programs, organizing tests into simple test cases and \
                      test suites, and controlling their runtime execution
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "Catch2";
        url = "https://github.com/catchorg/Catch2";
        description = """
                      A unit testing framework for "C++"
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "C++ Array";
        url = getCPPReferenceLanguageURL("array");
        description = """
                      A construct for storing multiple values of the same type \
                      in a single variable
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermPlural(term, indexTerm);
        
        term = "C++ Class";
        url = getCPPReferenceLanguageURL("class");
        description = """
                      A user-defined type, defined by class-specifier, which \
                      appears in decl-specifier-seq of the declaration syntax.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "C++ class", indexTerm);
        addAlias(term, "C++ Classes", indexTerm);
        addAlias(term, "C++ classes", indexTerm);
        
        term = "C++ Map";
        url = getCPPReferenceContainerURL("map");
        description = """
                      A sorted associative container that contains key-value \
                      pairs with unique keys. Keys are sorted.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, "C++ map", indexTerm);

        term = "C++ Module";
        url = getCPPReferenceLanguageURL("modules");
        description = """
                      A language feature since "C++20" to share declarations \
                      and definitions across translation units
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, "C++ module", indexTerm);
                
        term = "C++ Namespace";
        url = getCPPReferenceLanguageURL("namespace");
        description = """
                      A way to prevent name conflicts in large projects. \
                      Entities declared inside a namespace block are placed in \
                      a namespace scope, which prevents them from being \
                      mistaken for identically-named entities in other \
                      scopes.
                      
                      Entities declared outside all namespace blocks belong to \
                      the global namespace. The global namespace belongs to \
                      the global scope, and can be referred to explicitly with \
                      a leading ::. While it has no declaration, the global \
                      namespace is not an unnamed namespace.
                      
                      Multiple namespace blocks with the same name are \
                      allowed. All declarations within these blocks are \
                      declared in the same namespace scope
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, "C++ namespace", indexTerm);
                
        term = "C++ Reference";
        url = getCPPReferenceLanguageURL("reference");
        description = "An alias to an already-existing object or function";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, "C++ reference", indexTerm);
        
        term = "C++ Set";
        url = getCPPReferenceContainerURL("set");
        description = """
                      An associative container that contains a sorted set of \
                      unique objects of type Key
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, "C++ set", indexTerm);

        term = "C++ Standard Library";
        url = Environment.getWikipediaURL("C%2B%2B_Standard_Library");
        description = """
                      A collection of classes and functions in the core "C++"
                      "ISO"/"IEC" 14882 standard
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "C++ Vector";
        url = getCPPReferenceContainerURL("vector");
        description = """
                      A sequence container that encapsulates dynamic size arrays
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, "C++ vector", indexTerm);

        term = "GoogleTest";
        url = "https://google.github.io/googletest/";
        description = """
                      Google’s "C++" testing and mocking framework
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "VCPKG";
        url = "https://vcpkg.io/";
        description = """
                      "C"/"C++" dependency manager for all platforms, \
                      buildsystems, and workflows
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
    }

    /**
     * The default CPPReference URL.
     */
    public static final String EN_CPPREFERENCE_URL = "https://en.cppreference.com/w/cpp/";
    
    /**
     * @param article Appended to create what is returned.
     * @return {@link #EN_CPPREFERENCE_URL} + "language/"  + article;
     */
    public static final String getCPPReferenceLanguageURL(String article) {
        return EN_CPPREFERENCE_URL + "language/" + article;
    }

    /**
     * @param article Appended to create what is returned.
     * @return {@link #EN_CPPREFERENCE_URL} + "container/"  + article;
     */
    public static final String getCPPReferenceContainerURL(String article) {
        return EN_CPPREFERENCE_URL + "container/" + article;
    }
}
