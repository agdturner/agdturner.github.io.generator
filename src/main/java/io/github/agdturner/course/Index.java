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
package io.github.agdturner.course;

import io.github.agdturner.core.Environment;
import io.github.agdturner.core.SectionID;
import java.util.TreeMap;
import java.util.TreeSet;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Index Course Page.
 *
 * @author Andy Turner
 */
public class Index extends CoursePage {

    /**
     * To look up an IndexTerm from a term.
     */
    public final TreeMap<String, IndexTerm> termToIndexTerm;

    /**
     * These are aliases included in the index.
     */
    protected final TreeSet<String> aliasesToIndex;

    /**
     * A complete set of terms and aliases for the index.
     */
    protected final TreeSet<String> termsAndAliasesToIndex;

    /**
     * To look up a term name from an alias.
     */
    protected final TreeMap<String, String> aliasToTerm;

    /**
     * To look up aliases from a term.
     */
    protected final TreeMap<String, TreeSet<String>> termToAliases;

    /**
     * For checking and adding aliases.
     *
     * @param term The index term.
     * @param alias The alias to add for the term.
     * @param indexTerm The index term.
     */
    public final void addAlias(String term, String alias, IndexTerm indexTerm) {
        if (aliasToTerm.containsKey(alias)) {
            throw new RuntimeException("Alias " + alias + " already in use!");
            /**
             * Could add in logic to warn about/refer to other uses/ambiguity of
             * a term/alias.
             */
        }
        aliasToTerm.put(alias, term);
        TreeSet<String> aliases;
        if (termToAliases.containsKey(term)) {
            aliases = termToAliases.get(term);
        } else {
            aliases = new TreeSet<>();
        }
        aliases.add(alias);
    }

    /**
     * For checking and adding aliases.
     *
     * @param term The index term.
     * @param indexTerm The index term.
     */
    public final void addAliasTermPlural(String term, IndexTerm indexTerm) {
        addAlias(term, term + "s", indexTerm);
    }

    /**
     * For checking and adding aliases.
     *
     * @param term The index term.
     * @param indexTerm The index term.
     */
    public final void addAliasTermLowerCase(String term, IndexTerm indexTerm) {
        addAlias(term, term.toLowerCase(), indexTerm);
    }

    /**
     * Adds alias term plural and lower case.
     *
     * @param term The index term.
     * @param indexTerm The index term.
     */
    public final void addAliasTermPluralAndLowerCase(String term, 
            IndexTerm indexTerm) {
        addAliasTermPlural(term, indexTerm);
        addAliasTermLowerCase(term, indexTerm);
    }
    
    /**
     * For checking and adding aliases.
     *
     * @param term The index term.
     * @param alias The alias to add for the term.
     * @param indexTerm The index term.
     */
    public final void addAliasAndAliasLowerCase(String term, String alias,
            IndexTerm indexTerm) {
        addAlias(term, alias, indexTerm);
        addAlias(term, alias.toLowerCase(), indexTerm);
    }

    /**
     * For checking and adding aliases.
     *
     * @param term The index term.
     * @param alias The alias to add for the term once pluralised.
     * @param indexTerm The index term.
     */
    public final void addAliasPlural(String term, String alias,
            IndexTerm indexTerm) {
        addAlias(term, alias + "s", indexTerm);
    }

    /**
     * For checking and adding aliases.
     *
     * @param term The index term.
     * @param alias The alias to add for the term once turned into lower case.
     * @param indexTerm The index term.
     */
    public final void addAliasLowerCase(String term, String alias,
            IndexTerm indexTerm) {
        addAlias(term, alias.toLowerCase(), indexTerm);
    }

    /**
     * For checking and adding aliases.
     *
     * @param term The index term.
     * @param alias The alias to add for the term.
     * @param indexTerm The index term.
     */
    public final void addAliasToIndex(String term, String alias,
            IndexTerm indexTerm) {
        addAlias(term, alias, indexTerm);
        aliasesToIndex.add(alias);
        termsAndAliasesToIndex.add(alias);
    }

    /**
     * Adds alias adds alias plural as aliases for term.
     *
     * @param term The index term.
     * @param alias The alias to add for the term.
     * @param indexTerm The index term.
     */
    public final void addAliasAndAliasPlural(String term, String alias,
            IndexTerm indexTerm) {
        addAlias(term, alias, indexTerm);
        addAliasPlural(term, alias, indexTerm);
    }

    /**
     * Adds alias to index and adds alias and plural of alias as aliases for
     * term.
     *
     * @param term The index term.
     * @param alias The alias to add for the term.
     * @param indexTerm The index term.
     */
    public final void addAliasToIndexAndAliasPlural(String term, String alias,
            IndexTerm indexTerm) {
        addAliasToIndex(term, alias, indexTerm);
        addAliasPlural(term, alias, indexTerm);
    }

    /**
     * Adds alias to index and adds alias and plural of alias as aliases for
     * term.
     *
     * @param term The index term.
     * @param alias The alias to add for the term.
     * @param indexTerm The index term.
     */
    public final void addAliasToIndexAndAliasLowerCase(String term, String alias,
            IndexTerm indexTerm) {
        addAliasToIndex(term, alias, indexTerm);
        addAliasLowerCase(term, alias, indexTerm);
    }

    /**
     * Adds alias to index and adds alias and plural of alias as aliases for
     * term.
     *
     * @param term The index term.
     * @param alias The alias to add for the term.
     * @param indexTerm The index term.
     */
    public final void addAliasToIndexAndAliasPluralAndAliasAndAliasPluralLowerCase(String term, String alias,
            IndexTerm indexTerm) {
        addAliasToIndex(term, alias, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, alias, indexTerm);
    }

    /**
     * Adds alias to index, adds alias and plural of alias as aliases for term,
     * and also adds the lower case version of the alias and the lower case and
     * plural version of the alias similarly.
     *
     * @param term The index term.
     * @param alias The alias to add for the term.
     * @param indexTerm The index term.
     */
    public final void addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(
            String term, String alias, IndexTerm indexTerm) {
        addAliasAndAliasPlural(term, alias, indexTerm);
        addAliasAndAliasPlural(term, alias.toLowerCase(), indexTerm);
    }

    /**
     * Adds the lower case of term as an alias.
     *
     * @param term The term to add the aliases for.
     * @param indexTerm The index term.
     */
    public final void addAliasLowerCase(String term, IndexTerm indexTerm) {
        addAlias(term, term.toLowerCase(), indexTerm);
    }

    /**
     * Adds the plural, lower case and lower case plural of term as aliases.
     *
     * @param term The term to add the aliases for.
     * @param indexTerm The index term.
     */
    public final void addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(String term,
            IndexTerm indexTerm) {
        addAliasTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, term.toLowerCase(), indexTerm);
    }

    /**
     * Adds to {@link #termToIndexTerm} and {@link #termsAndAliasesToIndex}. If
     * the term already exists and the description is different, then an
     * RuntimeException is thrown.
     *
     * @param term The term to add.
     * @param indexTerm The IndexTerm.
     */
    public final void addIndexTerm(String term, IndexTerm indexTerm) {
        if (termToIndexTerm.containsKey(term)) {
            IndexTerm iT = termToIndexTerm.get(term);
            if (!iT.description.equalsIgnoreCase(indexTerm.description)) {
                throw new RuntimeException("Term " + term + " already defined"
                        + " as " + iT.description + "!");
            } else {
                throw new RuntimeException("Term " + term + " already"
                        + " defined!");
            }
        }
        termToIndexTerm.put(term, indexTerm);
        termsAndAliasesToIndex.add(term);
    }

    /**
     * Adds to {@link #termToIndexTerm} and {@link #termsAndAliasesToIndex} and
     * adds plural alias.
     *
     * @param term The term to add.
     * @param indexTerm The IndexTerm.
     */
    public final void addIndexTermAndAliasTermPlural(String term,
            IndexTerm indexTerm) {
        addIndexTerm(term, indexTerm);
        addAliasTermPlural(term, indexTerm);
    }

    /**
     * Adds to {@link #termToIndexTerm} and {@link #termsAndAliasesToIndex} and
     * adds plural alias.
     *
     * @param term The term to add.
     * @param indexTerm The IndexTerm.
     */
    public final void addIndexTermAndAliasTermLowerCase(String term,
            IndexTerm indexTerm) {
        addIndexTerm(term, indexTerm);
        addAliasTermLowerCase(term, indexTerm);
    }

    /**
     * Adds to {@link #termToIndexTerm} and {@link #termsAndAliasesToIndex} and
     * adds plural alias.
     *
     * @param term The term to add.
     * @param indexTerm The IndexTerm.
     */
    public final void addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(
            String term, IndexTerm indexTerm) {
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, term.toLowerCase(), indexTerm);
    }

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     */
    public Index(Course course, String filename, String title, String label) {
        super(course, filename, title, label);
        termToIndexTerm = new TreeMap<>();
        aliasesToIndex = new TreeSet<>();
        termsAndAliasesToIndex = new TreeSet<>();
        aliasToTerm = new TreeMap<>();
        termToAliases = new TreeMap<>();
        String term;
        String url;
        String description;
        IndexTerm indexTerm;

        term = "Alphabet";
        url = Environment.getWikipediaURL("Alphabet_(formal_languages)");
        description = """
                      A non-empty set of indivisible "symbols" or "glyphs".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Agent Based Model";
        url = Environment.getWikipediaURL("Agent-based_model");
        description = """
                      A computational model for simulating the actions and \
                      interactions of entities.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasToIndex(term, "ABM", indexTerm);

        term = "Application software";
        url = Environment.getWikipediaURL("Application_software");
        description = """
                      A "computer program" designed to carry out a specific \
                      task other than one relating to the operation of the \
                      computer itself, typically to be used by "end users".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term,
                "Application", indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term,
                "APP", indexTerm);

        term = "Application Programming Interface";
        url = Environment.getWikipediaURL("Application_Programming_Interface");
        description = """
                      An interface allowing "software" to "interoperate".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasToIndexAndAliasPlural(term, "API", indexTerm);

        term = "ASCII";
        url = Environment.getWikipediaURL("ASCII");
        description = """
                      A "character" "encoding" "standard" for electronic \
                      communication.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Backward compatibility";
        url = Environment.getWikipediaURL("Backward_compatibility");
        description = """
                      A property of an "operating system", product, or \
                      technology that allows for "interoperability" with an \
                      older legacy system.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAlias(term, "backwards compatability", indexTerm);

        term = "Bit";
        url = Environment.getWikipediaURL("Bit");
        description = """
                      A basic unit of "information" in "computing" and digital \
                      communications representing a logical state having one \
                      of two possible "values".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Bug";
        url = Environment.getWikipediaURL("Bug_(engineering)");
        description = """
                      A defect in the design, manufacture or operation of \
                      machinery, circuitry, electronics, "hardware", or \
                      "software" that produces undesired results or impedes \
                      operation. (See also: "Software bug")
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Byte";
        url = Environment.getWikipediaURL("Byte");
        description = """
                      A unit of "digital" "information" that most commonly \
                      consists of eight "bits".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Bytecode";
        url = Environment.getWikipediaURL("Bytecode");
        description = """
                      A form of "instruction set" designed for efficient \
                      execution by a "software" "interpreter".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "C++ Programming Language";
        url = Environment.getWikipediaURL("C%2B%2B");
        description = """
                      A high-level, general-purpose "programming language". \
                      The latest standard version "C++20" was published in \
                      December 2020. The next is coming soon.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "C++ programming language", indexTerm);
        addAlias(term, "C++", indexTerm);
        addAlias(term, "CPP", indexTerm);

        term = "C++98";
        url = Environment.getWikipediaURL("C%2B%2B98");
        description = """
                      A version of the "ISO"/"IEC" 14882 "standard" for "C++". \
                      C++98 was superseeded by "C++03".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "C++03";
        url = Environment.getWikipediaURL("C%2B%2B03");
        description = """
                      A version of the "ISO"/"IEC" 14882 "standard" for "C++". \
                      C++03 superseeded "C++98", and was superseeded by "C++11".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "C++11";
        url = Environment.getWikipediaURL("C%2B%2B11");
        description = """
                      A version of the "ISO"/"IEC" 14882 "standard" for "C++". \
                      C++11 superseeded "C++03", and was superseeded by "C++14".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "C++14";
        url = Environment.getWikipediaURL("C%2B%2B14");
        description = """
                      A version of the "ISO"/"IEC" 14882 "standard" for "C++". \
                      C++14 superseeded "C++11", and was superseeded by "C++17".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "C++17";
        url = Environment.getWikipediaURL("C%2B%2B17");
        description = """
                      A version of the "ISO"/"IEC" 14882 "standard" for "C++". \
                      C++17 superseeded "C++14", and was superseeded by "C++20".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "ISO/IEC 14882:2020";
        url = "https://www.iso.org/standard/79358.html";
        description = """
                      A "standards" document that specifies requirements for \
                      implementations of "C++20".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "C++20";
        url = Environment.getWikipediaURL("C%2B%2B20");
        description = """
                      The "ISO/IEC 14882:2020" "standard" for "C++". \
                      C++20 superseeded "C++17" and is to be superseeded soon...
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "C Programming Language";
        url = Environment.getWikipediaURL("C_(programming_language)");
        description = """
                      A general-purpose "programming language". The latest \
                      "standard" "C17" was published in June 2018. \
                      The next is coming soon...
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "C programming language", indexTerm);
        addAlias(term, "C", indexTerm);
        addAlias(term, "C Standard", indexTerm);

        term = "C11";
        url = Environment.getWikipediaURL("C11");
        description = """
                      The informal name for a version of the "ISO"/"IEC" 9899 \
                      "standard" for "C" superseeded by "C17".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "ISO/IEC 9899:2018";
        url = "https://www.iso.org/standard/74528.html";
        description = """
                      A standards document that specifies the form and \
                      establishes the interpretation of programs written in \
                      the "C programming language".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "C17";
        url = Environment.getWikipediaURL("C17");
        description = """
                      The informal name for "ISO/IEC 9899:2018" - the most \
                      recent standard for the "C", published in June 2018. It \
                      replaces "C11" and is to be superseded soon...
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "Calculation";
        url = Environment.getWikipediaURL("Calculation");
        description = """
                      A deliberate mathematical process that transforms one or \
                      more inputs into one or more outputs or results.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Call By Sharing";
        url = Environment.getWikipediaURL("Evaluation_strategy#Call_by_sharing");
        description = """
                      An evaluation strategy where a "parameter" is shared \
                      such that changes that are not reassignments are changes \
                      to a shared "object". If there is a reassignment in the \
                      "function" then the object is no longer shared and what \
                      is in the function is distinct from the object in the \
                      calling "scope".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Call By Value";
        url = Environment.getWikipediaURL("Evaluation_strategy#Call_by_value");
        description = """
                      An evaluation strategy where the "value" in the callers \
                      "scope" remains unchanged.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Central Processing Unit";
        url = Environment.getWikipediaURL("Central_processing_unit");
        description = """
                      The most important "processor" in a "computer".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasToIndex(term, "CPU", indexTerm);

        term = "Character";
        url = Environment.getWikipediaURL("Character_(computing)");
        description = """
                      A unit of "information" in an "alphabet".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Class";
        url = Environment.getWikipediaURL("Class_(computer_programming)");
        description = """
                      An extensible program-code-template for creating \
                      "objects", providing initial "values" for state (member \
                      "variables") and implementations of behavior (member \
                      "functions" or "methods").
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Classes", indexTerm);

        term = "Class Based Programming";
        url = Environment.getWikipediaURL("Class-based_programming");
        description = """
                      A style of "Object Oriented Programming" in which \
                      "inheritance" occurs via defining classes of "objects", \
                      instead of inheritance occurring via the objects alone \
                      (as in "Prototype Based Programming").
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Class-orientation", indexTerm);

        term = "Client";
        url = Environment.getWikipediaURL("Client_(computing)");
        description = """
                      A piece of "computer" "hardware" or "software" that \
                      accesses a "service" made available by a "server".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Cloud computing";
        url = Environment.getWikipediaURL("Cloud_computing");
        description = """
                      The use of on-demand "computational" resources.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Code";
        url = Environment.getWikipediaURL("Code");
        description = """
                      A system of rules to convert "information" to another \
                      form. (See also: "Source code", "Computer programming")
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        //addAliasToIndexAndAliasLowerCase(term, "Coding", indexTerm);
        addAliasToIndexAndAliasLowerCase(term, "Coded", indexTerm);
        addAliasToIndexAndAliasLowerCase(term, "Encoding", indexTerm);
        addAliasToIndexAndAliasLowerCase(term, "Encode", indexTerm);
        addAliasToIndexAndAliasLowerCase(term, "Encoded", indexTerm);
        addAliasToIndexAndAliasLowerCase(term, "Decoding", indexTerm);
        addAliasToIndexAndAliasLowerCase(term, "Decode", indexTerm);
        addAliasToIndexAndAliasLowerCase(term, "Decoded", indexTerm);

        term = "Command";
        url = Environment.getWikipediaURL("Command_(computing)");
        description = """
                      A directive to a "computer program" to perform a \
                      specific task.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Compiler";
        url = Environment.getWikipediaURL("Compiler");
        description = """
                      A "computer program" that translates "code" written in \
                      one "programming language" (the source language) into \
                      another language (the target language).
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Computation";
        url = Environment.getWikipediaURL("Computation");
        description = """
                      Any type of arithmetic or non-arithmetic "calculation" \
                      that is well-defined.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Computational";
        url = Environment.getWikipediaURL("Computational");
        description = """
                      Of or relating to "computation".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        
        term = "Computational workflow";
        url = Environment.getWikipediaURL("Workflow");
        description = """
                      A multi-step procedure that might involve invoking \
                      services, organising "data" and resources and running \
                      "processes".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Computer";
        url = Environment.getWikipediaURL("Computer");
        description = """
                      A machine that can be programmed to automatically carry \
                      out sequences of arithmetic or logical operations.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term,
                "General-purpose computer", indexTerm);
        addAliasAndAliasLowerCase(term, "Computing machinery", indexTerm);
        
        term = "Computer case";
        url = Environment.getWikipediaURL("Command-line_interface");
        description = """
                      An enclosure that contains most of the "hardware" of a \
                      "computer".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Case", indexTerm);

        term = "Computer cluster";
        url = Environment.getWikipediaURL("Computer_cluster");
        description = """
                      A set of "computers" that work together so that they can \
                      be viewed as a single system.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Computer data storage";
        url = Environment.getWikipediaURL("Computer_data_storage");
        description = """
                      Technology consisting of "computer" components and \
                      recording media that are used to retain "digital data".
                      (See also: "Random Access Memory")
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Data storage", indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Data store", indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Computer storage device", indexTerm);

        term = "Computer file";
        url = Environment.getWikipediaURL("Computer_file");
        description = """
                      A resource for recording data on a "computer storage \
                      device", primarily identified by its "filename". Just as \
                      words can be written on paper, so can "data" be written \
                      to a computer file. Files can be shared with and \
                      transferred between computers and devices via removable \
                      media, networks, or the "Internet".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "File", indexTerm);

        term = "Computer hardware";
        url = Environment.getWikipediaURL("Computer_hardware");
        description = """
                      The physical parts of a "computer", such as the "case", \
                      "Central Processing Unit", "Random Access Memory", \
                      "screen", "mouse", "keyboard", "data stores", \
                      "graphics card", "sound card", "speakers" and \
                      "motherboard".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Hardware", indexTerm);

        term = "Computer simulation";
        url = Environment.getWikipediaURL("Computer_simulation");
        description = """
                      The running of a "computer program" that models a \
                      system. (See also: "Digital model")
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Simulation", indexTerm);

        term = "Command Line Interface";
        url = Environment.getWikipediaURL("Command-line_interface");
        description = """
                      A command-line "interpreter" or command-line "processor" \
                      uses a command-line interface (CLI) to receive \
                      "commands" from a user in the form of "strings". This \
                      provides a means of setting "parameters" for the \
                      environment, invoking "executables" and providing \
                      "information" to the user.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasToIndex(term, "CLI", indexTerm);

        term = "Computer program";
        url = Environment.getWikipediaURL("Computer_program");
        description = """
                      A sequence of "computer" "commands" in a "programming \
                      language".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Program", indexTerm);

        term = "Computer programming";
        url = Environment.getWikipediaURL("Computer_programming");
        description = """
                      The process of designing and building a "computer \
                      program".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasToIndexAndAliasLowerCase(term, "Programming", indexTerm);
        addAliasToIndexAndAliasLowerCase(term, "Coding", indexTerm);

        term = "Computing";
        url = Environment.getWikipediaURL("Computing");
        description = """
                      A goal-oriented activity requiring, benefiting from, or \
                      creating "computing machinery".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        
        term = "Computing container";
        url = Environment.getWikipediaURL("Containerization_(computing)");
        description = """
                      A "virtual machine" that shares more of the underlying \
                      "operating system" which typically makes them more \
                      lightweight and less demanding of system resources. \
                      Containerisation technology is widely adopted by "cloud \
                      computing" platforms.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Containerization", indexTerm);

        term = "Conditional";
        url = Environment.getWikipediaURL("Conditional_(computer_programming)");
        description = """
                      A "control flow" switch that performs some kind of \
                      evaluation to determine what is run next.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Control flow";
        url = Environment.getWikipediaURL("Control_flow");
        description = """
                      The order in which individual "statements" or "function" \
                      calls of an "imperative program" are run.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "CSS";
        url = Environment.getWikipediaURL("CSS");
        description = """
                      A style sheet language used for describing the
                      presentation of a document written in a markup language
                      such as "HTML" or "XML".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "CSV";
        url = Environment.getWikipediaURL("Comma-separated_values");
        description = """
                      A delimited text "file format" that uses commas to \
                      separate "values".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Data";
        url = Environment.getWikipediaURL("Data");
        description = """
                      A collection of discrete or continuous "values" that \
                      convey "information", describing the quantity, quality, \
                      fact, statistics, other basic units of meaning, or \
                      simply sequences of symbols that may be further \
                      interpreted formally. (See also: "Digital data")
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Data structure";
        url = Environment.getWikipediaURL("Comma-separated_values");
        description = """
                      A "data" organization, management, and storage format \
                      that is usually chosen for efficient access to data.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Data type";
        url = Environment.getWikipediaURL("Data_type");
        description = """
                      A collection or grouping of data "values", usually \
                      specified by a set of possible values, a set of allowed \
                      operations on these values, and/or a representation of \
                      these values as machine types.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Debugging";
        url = Environment.getWikipediaURL("Debugging");
        description = """
                      The process of finding and resolving "bugs" (defects or
                      problems that prevent correct operation) within
                      "computer programs", "software", or systems.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Deprecation";
        url = Environment.getWikipediaURL("Deprecation");
        description = """
                      The discouragement of use of some terminology, feature, \
                      design, or practice, typically because it has been \
                      superseded or is no longer considered efficient or safe, \
                      without removing it or prohibiting its use.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Digital data";
        url = Environment.getWikipediaURL("Digital_data");
        description = """
                      "Information" represented as a string of discrete \
                      symbols, each of which can take on one of only a finite \
                      number of values from an "alphabet". (See also: "Data")
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Digital", indexTerm);
        
        term = "Digital footprint";
        url = Environment.getWikipediaURL("Digital_footprint");
        description = """
                      Traceable digital activities, actions, contributions, \
                      and communications manifested on the "Internet" or \
                      digital devices.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Digital model";
        url = Environment.getWikipediaURL("Digital_twin");
        description = """
                      An informative "computer" based representation of an \
                      individual object or system.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Model", indexTerm);
        
        term = "Digital shadow";
        url = Environment.getWikipediaURL("Digital_twin");
        description = """
                      A digital "model" of a physical product, system, or \
                      process. The abstract model represents the real thing \
                      using observations, measurents and scientific \
                      understanding. (See also: "Digital footprint")
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Digital twin";
        url = Environment.getWikipediaURL("Digital_twin");
        description = """
                      A digital "model" of a physical product, system, or \
                      process (a physical twin). This is beyond a "digital \
                      shadow" model in that the digital twin provides \
                      feedback on how to better represent the physical twin - \
                      a process which to an extent can be automated. It is the \
                      addition of feedback that distiguishes a digital twin \
                      from a "digital shadow".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Directory";
        url = Environment.getWikipediaURL("Directory_(computing)");
        description = """
                      A "file system" cataloging structure which contains \
                      references to "files", and possibly other directories. \
                      On some computers, directories are known as folders. A \
                      directory contained inside another directory is called a \
                      subdirectory.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Directories", indexTerm);
        addAliasAndAliasLowerCase(term, "Subdirectory", indexTerm);
        addAliasAndAliasLowerCase(term, "Subdirectories", indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Folder", indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Subfolder", indexTerm);

        term = "Disk";
        url = Environment.getWikipediaURL("Computer_memory");
        description = """
                      "Computer" "data storage" that is slower than "Random \
                      Access Memory" and is used to store data persistently \
                      (from one session to the next).
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Distributed computing";
        url = Environment.getWikipediaURL("Distributed_computing");
        description = """
                      A distributed system is a system whose components are \
                      located on different networked "computers", which \
                      communicate and coordinate their actions by passing \
                      "messages" to one another.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);
        
        term = "Documentation";
        url = Environment.getWikipediaURL("Documentation");
        description = """
                      Any communicable material that is used to describe, \
                      explain or instruct regarding some attributes of an \
                      object, system or procedure, such as its parts, \
                      assembly, installation, maintenance, and use.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Domain name";
        url = Environment.getWikipediaURL("Domain_name");
        description = """
                      A "string" that identifies a realm of administrative \
                      autonomy, authority or control.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Double-precision floating-point";
        url = Environment.getWikipediaURL("Double-precision_floating-point_format");
        description = """
                      A "computer" number format, usually occupying 64 "bits"
                      of computer "memory".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Double precision", indexTerm);

        term = "End user";
        url = Environment.getWikipediaURL("End_user");
        description = """
                      A person who ultimately uses or is intended to \
                      ultimately use a product.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Environment variable";
        url = Environment.getWikipediaURL("Environment_variable");
        description = """
                      A "variable" that can affect the way running "processes" \
                      behave on a "computer". For example, a running process \
                      may query the value of an environment variable to \
                      discover a suitable location to store temporary files.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Error";
        url = Environment.getWikipediaURL("Error_message");
        description = """
                      Information displayed when an unforeseen problem occurs.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Executable";
        url = Environment.getWikipediaURL("Executable");
        description = """
                      A "computer program" that can be run.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Execution";
        url = Environment.getWikipediaURL("Execution_(computing)");
        description = """
                      The process by which a "computer" reads and acts on the \
                      "commands" of a "computer program".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Expression";
        url = Environment.getWikipediaURL("Expression_(computer_science)");
        description = """
                      A "syntactic" entity in a "programming language" that \
                      may be evaluated to determine its "value" or fail to \
                      terminate, in which case the expression is undefined.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "File format";
        url = Environment.getWikipediaURL("File_format");
        description = """
                      A standard way that "information" is "encoded" for \
                      storage in a "computer file".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Data format", indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "File type", indexTerm);

        term = "Filename";
        url = Environment.getWikipediaURL("File_format");
        description = """
                      A name used to uniquely identify a "computer file" in a \
                      "file system".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "File System";
        url = Environment.getWikipediaURL("File_system");
        description = """
                      A "method" and "data structure" that a "computer" \
                      "operating system" uses to control how data is stored \
                      and retrieved.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Floating-point";
        url = Environment.getWikipediaURL("Floating-point_arithmetic");
        description = """
                      Arithmetic that represents real numbers approximately, \
                      using an "integer" with a fixed precision, called the \
                      significand, scaled by an "integer" exponent of a fixed \
                      base.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "For loop";
        url = Environment.getWikipediaURL("For_loop");
        description = """
                      A "computer" programming construct for repeating a set \
                      of operations for a sequence of things, for a number of \
                      times, and/or until a condition is met.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Formal language";
        url = Environment.getWikipediaURL("Formal_language");
        description = """
                      A language consisting of words whose letters are taken \
                      from an "alphabet" and are "well-formed" according to a \
                      specific set of rules called a "formal grammar".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Formal grammar";
        url = Environment.getWikipediaURL("Formal_grammar");
        description = """
                      Describes how to form strings from an "alphabet" of a \
                      "formal language" that are valid according to the \
                      "syntax".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Fortran";
        url = Environment.getWikipediaURL("Fortran");
        description = """
                      A general-purpose "programming language". The latest \
                      standard is "Fortran 2023".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Fortran 2023";
        url = "https://www.iso.org/standard/82170.html";
        description = """
                      "ISO/IEC 1539-1:2023" standard "Fortran".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "ISO/IEC 1539-1:2023";
        url = "https://www.iso.org/standard/82170.html";
        description = """
                      A "standards" document for "Fortran 2023" base language.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Free and Open Source Software";
        url = Environment.getWikipediaURL("Free_and_open-source_software");
        description = """
                      "Software" which anyone is freely licensed to use, copy \
                      copy, study, change and share.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "FOSS", indexTerm);

        term = "Functional programming";
        url = Environment.getWikipediaURL("Functional_programming");
        description = """
                      A "programming paradigm" where "programs" are \
                      constructed by applying and composing "functions".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Function";
        url = Environment.getWikipediaURL("Function_(computer_programming)");
        description = """
                      A sequence of "program" "commands" that performs a \
                      specific task.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Subroutine", indexTerm);
        addAliasAndAliasLowerCase(term, "Functionality", indexTerm);
                 
        term = "GeoJSON";
        url = Environment.getWikipediaURL("GeoJSON");
        description = """
                      An open "standard" "data format" designed for \
                      representing simple geographical features. It is based \
                      on the "JSON" format.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Geographical Information System";
        url = Environment.getWikipediaURL("Geographic_information_system");
        description = """
                      A GIS comprises people, computational resources, \
                      "software" and "data" to store, manage, process, \
                      analyze, and visualize geographical data.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "GIS", indexTerm);

        term = "Git";
        url = Environment.getWikipediaURL("Git");
        description = """
                      A distributed "version control" system.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "GitHub";
        url = "http://www.github.com";
        description = """
                      A platform to build, scale, and deliver secure "software".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Glyph";
        url = Environment.getWikipediaURL("Glyph");
        description = "Any kind of purposeful mark.";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Glitch";
        url = Environment.getWikipediaURL("Glitch");
        description = """
                      A short-lived fault in a system, such as a transient \
                      fault that corrects itself, making it difficult to \
                      troubleshoot.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "GML";
        url = Environment.getWikipediaURL("Geography_Markup_Language");
        description = """
                      The "XML" grammar defined by the "Open Geospatial \
                      Consortium" to express geographical features.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Graphical User Interface";
        url = Environment.getWikipediaURL("Graphical_user_interface");
        description = """
                      A form of user interface that primarily uses actionable \
                      graphical icons perhaps alongside displays.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, "GUI", indexTerm);

        term = "Graphics card";
        url = Environment.getWikipediaURL("Graphics_card");
        description = """
                      "Computer" "hardware" that generates a feed of graphics \
                      output to a display device. A key component is the \
                      "Graphics Processing Unit" that performs the necessary \
                      computations.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Graphics Processing Unit";
        url = Environment.getWikipediaURL("Graphics_processing_unit");
        description = """
                      A specialized electronic circuit initially designed to \
                      accelerate computer graphics and image processing. They \
                      are used for other calculations due to efficienies of \
                      their structure which is suited to some forms of \
                      "parallel processing".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAlias(term, "Graphical Processing Unit", indexTerm);
        addAliasToIndex(term, "GPU", indexTerm);
        
        term = "Grid computing";
        url = Environment.getWikipediaURL("Grid_computing");
        description = """
                      The use of shared distributed "computational" resources. \
                      Grid computers are typically more heterogeneous and \
                      geographically dispersed compared to conventional \
                      "High Performance Computing" systems.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        
        term = "High Performance Computing";
        url = Environment.getWikipediaURL("High-performance_computing");
        description = """
                      Uses "supercomputers" and "computer clusters" to solve \
                      advanced computation problems.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasToIndex(term, "HPC", indexTerm);

        term = "HTML";
        url = Environment.getWikipediaURL("HTML");
        description = """
                      The standard markup language for documents designed to \
                      be displayed in a "Web browser".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "HTTP";
        url = Environment.getWikipediaURL("HTTP");
        description = """
                      An application layer "protocol" in the \
                      "Internet protocol suite" model for distributed, \
                      collaborative, hypermedia information systems.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "HTTPS";
        url = Environment.getWikipediaURL("HTTPS");
        description = """
                      An extension of "HTTP" that uses encryption for secure \
                      communication over a computer network.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Identifier";
        url = Environment.getWikipediaURL("Identifier_(computer_programming)");
        description = """
                      A "lexical token" that names entities (e.g. "variables", \
                      "data types", "labels", "functions") in a "programming \
                      language".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(
                term, indexTerm);

        term = "Imperative program";
        url = Environment.getWikipediaURL("Imperative_programming");
        description = """
                      A "programming paradigm" of "software" that uses \
                      statements that change a program's state. An imperative \
                      program consists of commands for the "computer" to \
                      perform. Imperative programming focuses on describing \
                      how a program operates step by step, rather than on \
                      high-level descriptions of its expected results.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Imperative programming", indexTerm);

        term = "Information";
        url = Environment.getWikipediaURL("Information");
        description = """
                      Information is the meaning that may be derived from a \
                      representation through interpretation.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Inheritance";
        url = Environment.getWikipediaURL("Inheritance_(object-oriented_programming)");
        description = """
                      The mechanism of basing an "object" or "class" upon \
                      another object ("Prototype Based Programming" \
                      inheritance) or class ("Class Based Programming" \
                      inheritance).
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Instance";
        url = Environment.getWikipediaURL("Instance_(computer_science)");
        description = """
                      When a "computer" system creates a new context based on \
                      a pre-existing model or scheme, the model is said to \
                      have been instantiated.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Instruction";
        url = Environment.getWikipediaURL("Instruction");
        description = """
                      One operation for a "Central Processing Unit".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Instruction Set Architecture";
        url = Environment.getWikipediaURL("Instruction_set_architecture");
        description = """
                      An abstract model of a device that executes \
                      "instructions" described by that model. A "Central \
                      Processing Unit", is an implementation of the ISA.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Instruction set", indexTerm);
        addAliasToIndex(term, "ISA", indexTerm);

        term = "Integer";
        url = Environment.getWikipediaURL("Integer");
        description = """
                      The number zero, a positive "natural number", or its \
                      negative.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Integrated Development Environment";
        url = Environment.getWikipediaURL("Integrated_development_environment");
        description = """
                      A collection of "software" tools used to make writing \
                      "code" and developing software easier.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasToIndex(term, "IDE", indexTerm);

        term = "Interface";
        url = Environment.getWikipediaURL("Interface_(computing)");
        description = """
                      A shared boundary across which two or more separate \
                      components of a "computer" system exchange "information".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Interpreter";
        url = Environment.getWikipediaURL("Interpreter_(computing)");
        description = """
                      A "computer program" that interprets "commands" into \
                      "instructions" in "machine code" and runs them. This \
                      combines compiling and executing all in one step. (See \
                      also: "Compiler").
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "International Electrotechnical Commission";
        url = Environment.getWikipediaURL("IEC");
        description = """
                      An international "standards" organization that prepares \
                      and publishes standards for electrical, electronic and \
                      related technologies – collectively known as \
                      electrotechnology.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasToIndex(term, "IEC", indexTerm);

        term = "International Organization for Standardization";
        url = Environment.getWikipediaURL("ISO");
        description = """
                      An international "standards" organization composed \
                      of representatives from the national standards \
                      organizations of member countries.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasToIndex(term, "ISO", indexTerm);

        term = "Internet";
        url = Environment.getWikipediaURL("Internet");
        description = """
                      A global system of interconnected "computer" networks \
                      that uses the "Internet protocol suite" ("TCP/IP") to \
                      communicate between networks and devices.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Interoperability";
        url = Environment.getWikipediaURL("Internet");
        description = """
                      A capability of a product or system to work with other \
                      products or systems.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Interoperate", indexTerm);
        
        term = "Java";
        url = Environment.getWikipediaURL("Java_(programming_language)");
        description = """
                      A high-level general purpose "programming language".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "Java programming language", indexTerm);
        
        term = "Java 21";
        url = Environment.getWikipediaURL("Java_version_history#Java_21");
        description = """
                      The latest "long term support" release of "Java", \
                      released on the 19th of September, 2023.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "JavaScript";
        url = Environment.getWikipediaURL("Javascript");
        description = """
                      A high-level "programming language" that is one of the \
                      core technologies of the "Web". All major "Web browsers" \
                      have a dedicated JavaScript engine to execute code on \
                      user devices.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);
        addAlias(term, "JavaScript programming language", indexTerm);

        term = "JSON";
        url = Environment.getWikipediaURL("JSON");
        description = """
                      An open "standard" data interchange format for data \
                      objects consisting of attribute–value pairs and arrays \
                      (or other serializable values).
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "Kernel";
        url = Environment.getWikipediaURL("Kernel_(operating_system)");
        description = """
                      The part of the "computer" "operating system" that is \
                      responsible for preventing and mitigating resource \
                      conflicts between different "processes".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Keyboard";
        url = Environment.getWikipediaURL("Computer_keyboard");
        description = """
                      A peripheral input device modeled after the typewriter \
                      keyboard.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Label";
        url = Environment.getWikipediaURL("Label_(computer_science)");
        description = """
                      A sequence of "characters" that identifies a location \
                      within "source code".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Lexical token";
        url = Environment.getWikipediaURL("Lexical_analysis#Lexical_token_and_lexical_tokenization");
        description = """
                      A token name and an optional token value. The token name \
                      is a category of a rule-based lexical unit.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Linux";
        url = Environment.getWikipediaURL("Linux");
        description = """
                      A family of "open-source" "Unix"-like "operating systems".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Long term support";
        url = Environment.getWikipediaURL("Long-term_support");
        description = """
                      A "product lifecycle management" policy in which a \
                      stable release of "software" is maintained for a \
                      longer period of time than the standard edition.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Long-term support", indexTerm);

        term = "Machine code";
        url = Environment.getWikipediaURL("Machine_code");
        description = """
                      Machine language "instructions", which for a "Central \
                      Processing Unit".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "MacOS";
        url = Environment.getWikipediaURL("macOS");
        description = """
                      A group of several proprietary "Unix"-like "operating \
                      systems" developed and marketed by the company Apple.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "macOS", indexTerm);
        addAliasAndAliasLowerCase(term, "OSX", indexTerm);

        term = "Magic Number";
        url = Environment.getWikipediaURL("File_format#Magic_number");
        description = """
                      "File type" metadata incorporated into the file - \
                      usually at the start.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Markdown";
        url = Environment.getWikipediaURL("Markdown");
        description = """
                      A lightweight markup language for creating formatted \
                      text using a plain-text editor.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Maven";
        url = "https://maven.apache.org/";
        description = """
                      A "software" project management and comprehension tool.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Memory";
        url = Environment.getWikipediaURL("Computer_memory");
        description = """
                      Stores "information", such as "data" and "programs" for \
                      immediate use in a "computer". (See also: "Computer data \
                      storage", "Random Access Memory")
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Computer_memory", indexTerm);

        term = "Message";
        url = Environment.getWikipediaURL("Message_passing");
        description = """
                      An object of communication that could be "data", \
                      "commands" or "instructions".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Message passing", indexTerm);

        term = "Metadata";
        url = Environment.getWikipediaURL("Metadata");
        description = "Data that provides information about other data.";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Method";
        url = Environment.getWikipediaURL("Method_(computer_programming)");
        description = """
                      A method in "Object Oriented Programming" is a \
                      "procedure" associated with an "object", and generally \
                      also a "message". An object consists of state data and \
                      behavior; these compose an "interface", which specifies \
                      how the object may be used. A method is a behavior of an \
                      object parametrized by a user.
                      
                      Data is represented as "properties" of the object, and \
                      behaviors are represented as methods. For example, a \
                      <code>Window</code> object could have methods such as \
                      <code>open</code> and <code>close</code>, while its \
                      state (whether it is open or closed at any given point \
                      in time) would be a property.
                      
                      In "Class Based Programming", methods are defined within \
                      a "class", and objects are instances of a given class.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Microphone";
        url = Environment.getWikipediaURL("Microphone");
        description = """
                      An acoustic-to-electric transducer or sensor that \
                      converts sound into an electrical signal.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Microsoft Windows";
        url = Environment.getWikipediaURL("Microsoft_Windows");
        description = """
                      A group of several proprietary graphical "operating \
                      system" families developed and marketed by the company \
                      Microsoft.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Monitor";
        url = Environment.getWikipediaURL("Computer_monitor");
        description = """
                      A "computer" output device that displays information.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Screen", indexTerm);

        term = "Motherboard";
        url = Environment.getWikipediaURL("Motherboard");
        description = """
                      The main printed circuit board in "general-purpose \
                      computers" and other expandable systems. It holds and \
                      allows communication between components of a system, \
                      such as the "Central Processing Unit" and "memory", and \
                      provides connectors for other "peripherals".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Mouse";
        url = Environment.getWikipediaURL("Computer_mouse");
        description = """
                      A hand-held pointing device that detects two-dimensional \
                      motion relative to a surface.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Multithreading";
        url = Environment.getWikipediaURL("Thread_(computing)#Single-threaded_vs_multithreaded_programs");
        description = """
                      A programming and execution model that allows multiple \
                      "threads" to exist within the context of one "process". \
                      These threads share the process's resources, but are \
                      able to execute independently. Multithreading can be \
                      applied to one process to enable parallel execution on \
                      a "multiprocessing" system.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Multithreaded", indexTerm);
        addAliasAndAliasLowerCase(term, "Multi-threading", indexTerm);
        addAliasAndAliasLowerCase(term, "Multi-threaded", indexTerm);

        term = "Multiprocessing";
        url = Environment.getWikipediaURL("Multiprocessing");
        description = """
                      The use of two or more processing units within a single \
                      "computer".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Multiprocessor", indexTerm);
        addAliasAndAliasLowerCase(term, "Multi-processing", indexTerm);
        addAliasAndAliasLowerCase(term, "Multi-processor", indexTerm);

        term = "Multi-user";
        url = Environment.getWikipediaURL("Multi-user_software");
        description = """
                      "Software" that allows access by multiple users of a \
                      "computer".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        
        term = "Name binding";
        url = Environment.getWikipediaURL("Name_binding");
        description = "The association of entities with identifiers.";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndLowerCase(term, indexTerm);
        
        term = "Namespace";
        url = Environment.getWikipediaURL("Namespace");
        description = """
                      A set of names used to identify and refer to objects of \
                      various kinds. Namespaces ensure objects have unique \
                      names so that they can be easily identified.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Natural number";
        url = Environment.getWikipediaURL("Natural_number");
        description = "the numbers 1, 2, 3, etc...";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Netbeans";
        url = "https://netbeans.apache.org/";
        description = """
                      An "Integrated Development Environment", tooling \
                      platform and "application" framework.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "Network socket";
        url = Environment.getWikipediaURL("Network_socket");
        description = """
                      A "software" structure within a network node of a \
                      "computer" network that serves as an endpoint for \
                      sending and receiving "data".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Object";
        url = Environment.getWikipediaURL("Object_(computer_science)");
        description = """
                      A "variable", "data structure", "function", or "method". \
                      As regions of "memory", objects contain a "value" and \
                      are referenced by "identifiers".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Object Oriented Programming";
        url = Environment.getWikipediaURL("Object-oriented_programming");
        description = """
                      A "programming paradigm" based on the concept of \
                      "objects" which have "data" (state), and "methods" \
                      (functionality).
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Object-oriented programming", indexTerm);
        addAliasToIndex(term, "OOP", indexTerm);
        
        term = "Open Geospatial Consortium";
        url = Environment.getWikipediaURL("Open_Geospatial_Consortium");
        description = """
                      An international voluntary consensus "standards" \
                      organization for geospatial content and location-based \
                      services, sensor web and Internet of Things, "GIS" data \
                      processing and data sharing.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "OGC", indexTerm);

        term = "Open Source Software";
        url = Environment.getWikipediaURL("Open-source_software");
        description = """
                      "Software" for which the "source code" is released and \
                      available for study. (See also: "FOSS")
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "OSS", indexTerm);
        addAliasAndAliasLowerCase(term, "Open-source", indexTerm);

        term = "Operating System";
        url = Environment.getWikipediaURL("Operating_system");
        description = """
                      A system that manages computer "hardware" and \
                      "software" resources, and provides common services for \
                      "computer programs".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasToIndex(term, "OS", indexTerm);

        term = "Parallel programming";
        url = Environment.getWikipediaURL("Parallel_computing");
        description = """
                      A type of computation in which many calculations or \
                      "processes" are carried out simultaneously. (See also: \
                      "Multi-threading", "Multi-processing")
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Parallel processing", indexTerm);

        term = "Parallelisation";
        url = Environment.getWikipediaURL("Parallel_computing");
        description = """
                      The process of changing a "computer program" from a \
                      serial execution (where procesing tasks are completed \
                      one after another), to a parallel execution (where \
                      multiple tasks) are carried out simultaneously.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Parameter";
        url = Environment.getWikipediaURL("Parameter_(computer_programming)");
        description = """
                      A special kind of "variable" used in a "subroutine" to \
                      refer to one of the pieces of "data" provided as input \
                      to the subroutine.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "PATH";
        url = Environment.getWikipediaURL("PATH_(variable)");
        description = """
                      An "environment variable" expected to be set on many \
                      "operating systems". The variable specifies a set of \
                      "directories" where "executable" programs are located.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Peripheral";
        url = Environment.getWikipediaURL("Peripheral");
        description = """
                      An auxiliary "hardware" device used to transfer \
                      "information" into and out of a "computer".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
                
        term = "Port";
        url = Environment.getWikipediaURL("Port_(computer_networking)");
        description = """
                      A number assigned to uniquely identify a connection \
                      endpoint and to direct "data" to a specific "service".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Primitive data type";
        url = Environment.getWikipediaURL("Lexical_analysis#Lexical_token_and_lexical_tokenization");
        description = """
                      A set of basic "data types" from which all other data \
                      types are constructed.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Primitive", indexTerm);

        term = "Procedural programming";
        url = Environment.getWikipediaURL("Procedural_programming");
        description = """
                      A "programming paradigm", derived from "imperative \
                      programming", based on the concept of the "procedure" \
                      call. Procedures (a type of "subroutine") contain a \
                      series of computational steps to be carried out.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(url, "Procedure", indexTerm);

        term = "Processor";
        url = Environment.getWikipediaURL("Processor_(computing)");
        description = """
                      A "computer" electrical circuit that performs operations \
                      on an "data" source, usually "Random Access Memory".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Process";
        url = Environment.getWikipediaURL("Process_(computing)");
        description = """
                      The instance of a "computer program" that is being \
                      executed by one or many "threads".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Processes", indexTerm);
        
        term = "Product lifecycle";
        url = Environment.getWikipediaURL("Product_lifecycle");
        description = """
                      The entire lifecycle of a product from its inception \
                      through the engineering, design, development, service, \
                      and end of life (end of support - retirement).
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Product lifecycle management", indexTerm);
        
        term = "Profiling";
        url = Environment.getWikipediaURL("Profiling_(computer_programming)");
        description = """
                      A form of dynamic program analysis that measures \
                      performance, for example, the memory requirments or \
                      processing time of parts of a "computer program".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Programming paradigm";
        url = Environment.getWikipediaURL("Programming_paradigm");
        description = """
                      A way to classify "programming languages" based on their \
                      features.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Programming language";
        url = Environment.getWikipediaURL("Programming_language");
        description = """
                      A system of notation for writing "computer programs". \
                      A programming language is usually described in terms of \
                      its "syntax" (form) and "semantics" (meaning). These are \
                      usually defined by a "formal language".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Property";
        url = Environment.getWikipediaURL("Property_(programming)");
        description = """
                      A system of notation for writing "computer programs". \
                      A programming language is usually described in terms of \
                      its "syntax" (form) and "semantics" (meaning). These are \
                      usually defined by a "formal language".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Properties", indexTerm);

        term = "Protocol";
        url = Environment.getWikipediaURL("Communication_protocol");
        description = """
                      A system of rules that allows two or more entities of a \
                      communications system to transmit "information". The \
                      protocol defines the rules, "syntax", "semantics", and \
                      synchronization of communication and possible error \
                      recovery methods. Protocols may be implemented by \
                      "hardware", "software", or a combination of both.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Prototype Based Programming";
        url = Environment.getWikipediaURL("Prototype-based_programming");
        description = """
                      A style of "object-oriented programming" in which \
                      behaviour reuse (known as "inheritance") is performed \
                      via a process of reusing existing "objects" that serve \
                      as prototypes.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Python";
        url = Environment.getWikipediaURL("Python_(programming_language)");
        description = """
                      A high-level, general-purpose "programming language".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Random Access Memory";
        url = Environment.getWikipediaURL("Random-access_memory");
        description = """
                      A form of electronic "computer" "memory" that can be \
                      read and changed in any order, typically used to store \
                      working "data" and "machine code".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasToIndex(term, "RAM", indexTerm);

        term = "Rational number";
        url = Environment.getWikipediaURL("Rational_number");
        description = """
                      A number that can be expressed as the quotient or \
                      fraction of two "integers".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Regression test";
        url = Environment.getWikipediaURL("Regression_testing");
        description = """
                      A test rerun to ensure that previously developed and \
                      tested "software" still performs as expected after a \
                      change.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Regression testing";
        url = Environment.getWikipediaURL("Regression_testing");
        description = """
                      Re-running tests to ensure that previously developed \
                      and tested "software" still performs as expected after a \
                      change.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Read Evaluate Print Loop";
        url = Environment.getWikipediaURL("Read%E2%80%93eval%E2%80%93print_loop");
        description = """
                      An interactive "computer programming" environment that \
                      takes single user inputs, executes them, and returns the \
                      result to the user.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasToIndex(term, "REPL", indexTerm);

        term = "Reproducibility";
        url = Environment.getWikipediaURL("Reproducibility");
        description = """
                      In computational sciences, reproducibility means results \
                      should be documented by making all "data" and "code" \
                      available in such a way that the computations can be \
                      executed again with identical end results.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        
        term = "Scheduler";
        url = Environment.getWikipediaURL("Scheduling_(computing)");
        description = """
                      Assigns resources to perform tasks.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Scope";
        url = Environment.getWikipediaURL("Scope_(computer_science)");
        description = """
                      In "computer programming", the scope of a "name binding" \
                      (an association of a name to an entity, such as a \
                      "variable") is the part of a "program" where the name \
                      binding is valid; that is, where the name can be used to \
                      refer to the entity. In other parts of the program, the \
                      name may refer to a different entity.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Semantics";
        url = Environment.getWikipediaURL("Semantics_(computer_science)");
        description = """
                      The rigorous mathematical study of the meaning of \
                      "programming languages".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Server";
        url = Environment.getWikipediaURL("Server_(computing)");
        description = """
                      Computer "hardware" or "software" that provides \
                      "functionality" for other "programs" or devices, called \
                      "clients".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Service";
        url = Environment.getWikipediaURL("Service_(systems_architecture)");
        description = """
                      "Software" functionality, or a set of software \
                      functionalities (such as the retrieval of specified \
                      "information" or the execution of a set of operations) \
                      with a purpose that different clients can reuse for \
                      different purposes, together with the policies that \
                      should control its usage.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Single-precision floating-point";
        url = Environment.getWikipediaURL("Single-precision_floating-point_format");
        description = """
                      A "computer" number format, usually occupying 32 "bits" \
                      of computer "memory".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Single precision", indexTerm);

        term = "Software";
        url = Environment.getWikipediaURL("Software");
        description = """
                      "Computer programs" and associated "documentation" and \
                      "data".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Software bug";
        url = Environment.getWikipediaURL("Software_bug");
        description = """
                      An error, flaw or fault in the design, development, or \
                      operation of "software" that causes it to produce an \
                      incorrect or unexpected result, or to behave in \
                      unintended ways. (See also: "Bug")
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Source code";
        url = Environment.getWikipediaURL("Source_code");
        description = "Text written using a human-readable \"programming "
                + "language\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Sound card";
        url = Environment.getWikipediaURL("Sound_card");
        description = """
                      "Computer hardware" that provides input and output of \
                      audio signals to and from a computer under the control \
                      of "computer programs".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Speakers";
        url = Environment.getWikipediaURL("Computer_speakers");
        description = """
                      "Computer hardware" that provides audio output.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Statement";
        url = Environment.getWikipediaURL("Statement_(computer_science)");
        description = """
                      A "syntactic" unit of an "imperative programming" \
                      language that expresses some action to be carried out. \
                      A "program" written in such a language is formed by a \
                      sequence of one or more statements. A statement may have \
                      internal components (e.g. "expressions").
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Standard";
        url = Environment.getWikipediaURL("Technical_standard");
        description = """
                      Documantation that establishes uniform engineering or \
                      technical criteria, methods, processes, and practices.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "String";
        url = Environment.getWikipediaURL("String_(computer_science)");
        description = """
                      Sequences of "characters".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Supercomputer";
        url = Environment.getWikipediaURL("Supercomputer");
        description = """
                      A "computer" with a high level of performance as \
                      compared to a "general-purpose computer".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Symbol";
        url = Environment.getWikipediaURL("Symbol_(programming)");
        description = """
                      A "primitive data type" whose instances have a \
                      human-readable form.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Syntax";
        url = Environment.getWikipediaURL("Syntax_(programming_languages)");
        description = """
                      The rules that define the combinations of symbols that \
                      are considered to be correctly structured "statements" \
                      or "expressions" in a "programming language".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Syntactic", indexTerm);

        term = "Syntax Error";
        url = Environment.getWikipediaURL("Syntax_error");
        description = """
                      An "error" in the "syntax" of a sequence of characters \
                      or tokens that is intended to be written in a particular \
                      "programming language".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "TCP/IP";
        url = Environment.getWikipediaURL("Internet_protocol_suite");
        description = """
                      A framework for organizing the set of communication \
                      "protocols" used in the "Internet" and similar computer \
                      networks according to functional criteria.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Internet protocol suite", indexTerm);

        term = "The GNU Compiler Collection";
        url = "https://gcc.gnu.org/";
        description = """
                      Includes front ends for "C", "C++", Objective-C, \
                      "Fortran", Ada, Go, and D, as well as libraries for \
                      these languages...
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasToIndex(term, "GCC", indexTerm);

        term = "Thread";
        url = Environment.getWikipediaURL("Thread_(computing)");
        description = """
                      The smallest sequence of programmed "commands" that \
                      can be managed independently by a "scheduler".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term,
                indexTerm);

        term = "Touchscreen";
        url = Environment.getWikipediaURL("Touchscreen");
        description = """
                      Both an input touch panel and output display device. \
                      (See also: "Monitor")
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Unicode";
        url = Environment.getWikipediaURL("Unicode");
        description = """
                      An "information" technology "standard" for the \
                      consistent "encoding", representation, and handling of \
                      text expressed in most writing systems.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Unit testing";
        url = Environment.getWikipediaURL("Unit_testing");
        description = """
                      A "software" testing method by which individual units of \
                      "source code" - sets of one or more "computer program" \
                      modules together with associated control data, usage \
                      procedures, and operating procedures - are tested to \
                      determine whether they are fit for use. (See also: \
                      "regression testing")
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "Unit testing", indexTerm);

        term = "University of Leeds";
        url = Environment.getWikipediaURL("University_of_Leeds");
        description = """
                      A public research university in Leeds, England.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Unix";
        url = Environment.getWikipediaURL("Unix");
        description = """
                      A family of multi-tasking, "multi-user" "computer" \
                      "operating systems".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "UNIX", indexTerm);

        term = "URL";
        url = Environment.getWikipediaURL("URL");
        description = """
                      Uniform Resource Locator - a reference to a "Web" \
                      resource that specifies its location and the "protocol" \
                      for retrieving it.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Value";
        url = Environment.getWikipediaURL("Value_(computer_science)");
        description = """
                      The representation of some entity that can be \
                      manipulated by a "program".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Variable";
        url = Environment.getWikipediaURL("Variable_(computer_science)");
        description = """
                      A named container for a particular set of "bits" or type \
                      of "data".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Version control";
        url = Environment.getWikipediaURL("Version_control");
        description = """
                      A class of systems responsible for managing changes to \
                      "data".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);
        
        term = "Virtual machine";
        url = Environment.getWikipediaURL("Virtual_machine");
        description = """
                      A virtual "computer" within a physical computer. An \
                      'operating system-level virtualization' provides a more \
                      complete system platform and "operating system". An \
                      'application-level virtualization' encapsulates \
                      "computer programs" from the underlying operating system \
                      which run in a more platform-independent way. (See also: \
                      "Containerization")
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);        
                
        term = "Visual Studio Code";
        url = "https://code.visualstudio.com/";
        description = """
                      A code editor with support for development operations \
                      like "debugging", task running, and "version control".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "VSCode", indexTerm);

        term = "Web accessibility";
        url = Environment.getWikipediaURL("Web_accessibility");
        description = """
                      The inclusive practice of ensuring there are no \
                      barriers that prevent interaction with, or access to, \
                      websites on the "Web" by people with physical \
                      disabilities, situational disabilities, and socio-\
                      economic restrictions on bandwidth and speed.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Web browser";
        url = Environment.getWikipediaURL("Web_browser");
        description = """
                      An "application" for accessing "websites" and the \
                      "Internet".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);

        term = "Webpage";
        url = Environment.getWikipediaURL("Webpage");
        description = """
                      A document on the "World Wide Web".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Webserver";
        url = Environment.getWikipediaURL("Webserver");
        description = """
                      "Software" and underlying "hardware" that accepts \
                      requests via "HTTP" or "HTTPS".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
                
        term = "Website";
        url = Environment.getWikipediaURL("Website");
        description = """
                      A collection of "webpages" and related content that is \
                      identified by a common "domain name" and published on at \
                      least one "webserver".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Well-formed";
        url = Environment.getWikipediaURL("Well-formedness");
        description = """
                      The quality of a clause, word, or other linguistic \
                      element that conforms to the grammar of the language of \
                      which it is a part.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "While loop";
        url = Environment.getWikipediaURL("While_loop");
        description = """
                      A control flow statement that allows code to be executed \
                      repeatedly or until a condition evaluates as false.
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "World Wide Web";
        url = Environment.getWikipediaURL("World_Wide_Web");
        description = """
                      An "information" system enabling documents and other \
                      resources to be accessed over the "Internet".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasToIndex(term, "Web", indexTerm);
        addAliasToIndex(term, "WWW", indexTerm);

        term = "XML";
        url = Environment.getWikipediaURL("XML");
        description = """
                      An extensible markup language "standard" and "data \
                      format" for storing, transmitting, and reconstructing \
                      "data".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
    }

    /**
     * Adds a reference to the appropriate course collections and returns a link
     * to use in a WebPage.
     *
     * @param name The name for the reference.
     * @param linkText The text for the link.
     * @param url The URL of the reference.
     * @param description The description of the reference.
     * @return A link.
     */
    public String addWebReference(String name, String linkText,
            String url, String description) {
        if (!references.termToTerm.containsKey(name)) {
            references.termToTerm.put(name,
                    new IndexTerm(this, description, url));
        }
        return Web_ContentWriter.getLink(url, linkText);
    }

    /**
     * @param name The name to get a link from.
     * @return the link for the reference given by name.
     */
    public String getReference(String name) {
        return getReference(name, name);
    }

    /**
     * @param name The name to get a link from.
     * @param linkText The link text for the link.
     * @return The link for the reference given by name.
     */
    public String getReference(String name, String linkText) {
        return getReference(name, linkText, null);
    }

    /**
     * @param name The name to get a link from.
     * @param sid The SectionID where the term is used.
     * @return the link for the reference given by name.
     */
    public String getReference(String name, SectionID sid) {
        return getReference(name, name, sid);
    }

    /**
     * @param name The name to get a link from.
     * @param linkText The link text for the link.
     * @param sid The SectionID where the term is used.
     * @return the link for the reference given by name.
     */
    public String getReference(String name, String linkText, SectionID sid) {
        IndexTerm r = termToIndexTerm.get(name);
        if (r == null) {
            String term = aliasToTerm.get(name);
            if (term != null) {
                return getReference(term, linkText, sid);
            }
        } else {
            if (sid != null) {
                r.sectionIDs.add(sid);
            }
            return r.getLinkWithin(name, linkText);
            //return r.getLink(linkText);
        }
        return null;
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        w.addULST(sb);
        for (String aliasOrTerm : termsAndAliasesToIndex) {
            IndexTerm indexTerm;
            if (aliasesToIndex.contains(aliasOrTerm)) {
                w.addLIST(sb);
                indexTerm = termToIndexTerm.get(aliasToTerm.get(aliasOrTerm));
                sb.append(aliasOrTerm)
                        .append(" - See: ")
                        .append(indexTerm.getLinkWithin(aliasToTerm.get(aliasOrTerm)));
                //.append(indexTerm.getLink(aliasToTerm.get(aliasOrTerm)));
            } else {
                indexTerm = termToIndexTerm.get(aliasOrTerm);
                w.addLIIDST(sb, aliasOrTerm);
                sb.append(indexTerm.getLinkAndDescription(aliasOrTerm));
                //sb.append(".");
                if (!indexTerm.sectionIDs.isEmpty()) {
                    sb.append(" (");
                    int l = sb.length();
                    for (var x : indexTerm.sectionIDs) {
                        sb.append(x.getLink());
                        sb.append(", ");
                    }
                    // Remove the last delimiter
                    if (sb.length() > l) {
                        sb.setLength(sb.length() - 2);
                    }
                    sb.append(")");
                }
            }
            w.addLIET(sb);
        }
        w.addULET(sb);
        w.addDIVET(sb);
        return sb.toString();
    }
}
