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
        String term; // The term.
        String url;  // The URL.
        String desc; // A description.
        IndexTerm indexTerm;

        term = "Boost.Test";
        url = "https://www.boost.org/doc/libs/1_84_0/libs/test/doc/html/index.html";
        desc = """
                A "software library" that provides interfaces for
                writing test programs, organizing tests into simple test
                cases and test suites, and controlling their runtime
                execution.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Catch2";
        url = "https://github.com/catchorg/Catch2";
        desc = """
                A unit testing framework for "C++".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "C++98";
        url = Environment.getWikipediaURL("C%2B%2B98");
        desc = """
                A version of the "ISO"/"IEC" 14882 "standard" for "C++".
                C++98 was superseeded by "C++03".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "C++03";
        url = Environment.getWikipediaURL("C%2B%2B03");
        desc = """
                A version of the "ISO"/"IEC" 14882 "standard" for "C++".
                C++03 superseeded "C++98", and was superseeded by
                "C++11".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "C++11";
        url = Environment.getWikipediaURL("C%2B%2B11");
        desc = """
                A version of the "ISO"/"IEC" 14882 "standard" for "C++".
                C++11 superseeded "C++03", and was superseeded by
                "C++14".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "C++14";
        url = Environment.getWikipediaURL("C%2B%2B14");
        desc = """
                A version of the "ISO"/"IEC" 14882 "standard" for "C++".
                C++14 superseeded "C++11", and was superseeded by
                "C++17".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "C++17";
        url = Environment.getWikipediaURL("C%2B%2B17");
        desc = """
                A version of the "ISO"/"IEC" 14882 "standard" for "C++".
                C++17 superseeded "C++14", and was superseeded by
                "C++20".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "C++20";
        url = Environment.getWikipediaURL("C%2B%2B20");
        desc = """
                The "ISO/IEC 14882:2020" "standard" for "C++".
                C++20 superseeded "C++17" and was superseeded by
                "C++23".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "C++23";
        url = Environment.getWikipediaURL("C%2B%2B20");
        desc = """
               The current "open standard" for the "C++ programming language".
               """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);
        
        term = "C++ Array";
        url = getCPPReferenceLanguageURL("array");
        desc = """
               A construct for storing multiple values of the same type
               in a single variable.
               """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);

        term = "C++ Class";
        url = getCPPReferenceLanguageURL("class");
        desc = """
                A user-defined type, defined by class-specifier, which
                appears in decl-specifier-seq of the declaration syntax.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "C++ class", indexTerm);
        addAlias(term, "C++ Classes", indexTerm);
        addAlias(term, "C++ classes", indexTerm);

        term = "C++ Map";
        url = getCPPReferenceContainerURL("map");
        desc = """
                A sorted associative container that contains key-value
                pairs with unique keys. Keys are sorted.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, "C++ map", indexTerm);

        term = "C++ Module";
        url = getCPPReferenceLanguageURL("modules");
        desc = """
                A language feature since "C++20" to share declarations
                and definitions across translation units.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, "C++ module", indexTerm);

        term = "C++ Namespace";
        url = getCPPReferenceLanguageURL("namespace");
        desc = """
                A way to prevent name conflicts in large projects.
                Entities declared inside a namespace block are placed in
                a namespace scope, which prevents them from being
                mistaken for identically-named entities in other
                scopes.
                
                Entities declared outside all namespace blocks belong to
                the global namespace. The global namespace belongs to
                the global scope, and can be referred to explicitly with
                a leading ::. While it has no declaration, the global
                namespace is not an unnamed namespace.
                
                Multiple namespace blocks with the same name are
                allowed. All declarations within these blocks are
                declared in the same namespace scope.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, "C++ namespace", indexTerm);

        term = "C++ Reference";
        url = getCPPReferenceLanguageURL("reference");
        desc = "An alias to an already-existing object or function";
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, "C++ reference", indexTerm);

        term = "C++ Set";
        url = getCPPReferenceContainerURL("set");
        desc = """
                An associative container that contains a sorted set of
                unique objects of type Key.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, "C++ set", indexTerm);

        term = "C++ Standard Library";
        url = Environment.getWikipediaURL("C%2B%2B_Standard_Library");
        desc = """
                A collection of classes and functions in the core "C++"
                "ISO"/"IEC" 14882 standard.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "C++ Vector";
        url = getCPPReferenceContainerURL("vector");
        desc = """
                A sequence container that encapsulates dynamic size
                "arrays".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, "C++ vector", indexTerm);

        term = "ISO/IEC 14882:2020";
        url = "https://www.iso.org/standard/79358.html";
        desc = """
                A "standards" document that specifies requirements for
                implementations of "C++20".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "GoogleTest";
        url = "https://google.github.io/googletest/";
        desc = """
                Google’s "C++" testing and mocking framework.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "VCPKG";
        url = "https://vcpkg.io/";
        desc = """
                "C"/"C++" dependency manager for all platforms,
                build systems, and workflows.
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
