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
     * For checking and adding aliases.
     *
     * @param term The index term.
     * @param alias The alias to add for the term.
     * @param indexTerm The index term.
     */
    public final void addAliasAndAliasLowerCase(String term, String alias, IndexTerm indexTerm) {
        addAlias(term, alias, indexTerm);
        addAlias(term, alias.toLowerCase(), indexTerm);
    }
    
    /**
     * For checking and adding aliases.
     *
     * @param term The index term.
     * @param alias The alias to add for the term.
     * @param indexTerm The index term.
     */
    public final void addAliasPlural(String term, String alias, IndexTerm indexTerm) {
        addAlias(term, alias + "s", indexTerm);
    }

    /**
     * For checking and adding aliases.
     *
     * @param term The index term.
     * @param alias The alias to add for the term.
     * @param indexTerm The index term.
     */
    public final void addAliasToIndex(String term, String alias, IndexTerm indexTerm) {
        addAlias(term, alias, indexTerm);
        aliasesToIndex.add(alias);
        termsAndAliasesToIndex.add(alias);
    }

    /**
     * Adds alias to index and adds alias and plural of alias as aliases for
     * term.
     *
     * @param term The index term.
     * @param alias The alias to add for the term.
     * @param indexTerm The index term.
     */
    public final void addAliasAndAliasPlural(String term, String alias, 
            IndexTerm indexTerm) {
        addAliasToIndex(term, alias, indexTerm);
        addAliasPlural(term, alias, indexTerm);
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
    public final void addIndexTermAndTermPlural(String term,
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
    public final void addIndexTermAndTermLowerCase(String term,
            IndexTerm indexTerm) {
        addIndexTerm(term, indexTerm);
        addAliasTermLowerCase(term, indexTerm);
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

        term = "Agent Based Model";
        url = Environment.getWikipediaURL("Agent-based_model");
        description = "A computational model for simulating the actions and "
                + "interactions of entities";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasPlural(term, "ABM", indexTerm);

        term = "Apache Netbeans";
        url = "https://netbeans.apache.org/";
        description = "Development Environment, Tooling Platform and"
                + " Application Framework.";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Netbeans", indexTerm);

        term = "Application software";
        url = Environment.getWikipediaURL("Application_software");
        description = "A \"computer program\" designed to carry out a specific "
                + "task other than one relating to the operation of the "
                + "computer itself, typically to be used by \"end users\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, 
                "Application", indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, 
                "APP", indexTerm);

        term = "Application Programming Interface";
        url = Environment.getWikipediaURL("Application_Programming_Interface");
        description = "An interface allowing some \"software\" to interoperate "
                + "with other software";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasPlural(term, "API", indexTerm);

        term = "ASCII";
        url = Environment.getWikipediaURL("ASCII");
        description = "A character encoding standard for electronic "
                + "communication";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Backward Compatibility";
        url = Environment.getWikipediaURL("Backward_compatibility");
        description = "A property of an \"operating system\", product, or "
                + "technology that allows for interoperability with an older "
                + "legacy system";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);
        addAlias(term, "backwards compatability", indexTerm);

        term = "Bit";
        url = Environment.getWikipediaURL("Bit");
        description = "A basic unit of information in computing and digital "
                + "communications representing a logical state having one of "
                + "two possible values";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Bug";
        url = Environment.getWikipediaURL("Bug_(engineering)");
        description = "A defect in the design, manufacture or operation of "
                + "machinery, circuitry, electronics, \"hardware\", or "
                + "\"software\" that produces undesired results or impedes "
                + "operation. "
                + "See also \"Software Bug\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Byte";
        url = Environment.getWikipediaURL("Byte");
        description = "A unit of digital information that most commonly"
                + " consists of eight \"bits\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Bytecode";
        url = Environment.getWikipediaURL("Bytecode");
        description = "A form of \"instruction set\" designed for efficient "
                + "execution by a software \"interpreter\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);
        
        term = "C++ Programming Language";
        url = Environment.getWikipediaURL("C%2B%2B");
        description = """
                      A high-level, general-purpose "programming language". \
                      The latest standard version "C++20" was published in \
                      December 2020. The next is coming soon...
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "C++ programming language", indexTerm);
        addAlias(term, "C++", indexTerm);
        addAlias(term, "CPP", indexTerm);

        term = "C++98";
        url = Environment.getWikipediaURL("C%2B%2B98");
        description = """
                      The first version of the "ISO"/"IEC" 14882 standard for \
                      the "C++ programming language" superseeded by "C++03"
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "C++03";
        url = Environment.getWikipediaURL("C%2B%2B03");
        description = """
                      A version of the "ISO"/"IEC" 14882 standard for the \
                      "C++ programming language". C++03 superseeded "C++98", \
                      and was superseeded by "C++11"
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "C++11";
        url = Environment.getWikipediaURL("C%2B%2B11");
        description = """
                      A version of the "ISO"/"IEC" 14882 standard for the \
                      "C++ programming language". C++11 superseeded "C++03", \
                      and was superseeded by "C++14"
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "C++14";
        url = Environment.getWikipediaURL("C%2B%2B14");
        description = """
                      A version of the "ISO"/"IEC" 14882 standard for the \
                      "C++ programming language". C++14 superseeded "C++11", \
                      and was superseeded by "C++17"
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "C++17";
        url = Environment.getWikipediaURL("C%2B%2B17");
        description = """
                      A version of the "ISO"/"IEC" 14882 standard for the \
                      "C++ programming language". C++17 superseeded "C++14", \
                      and was superseeded by "C++20"
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "ISO/IEC 14882:2020";
        url = "https://www.iso.org/standard/79358.html";
        description = """
                      A standards document that specifies requirements for \
                      implementations of the "C++ programming language"
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "C++20";
        url = Environment.getWikipediaURL("C%2B%2B20");
        description = """
                      The "ISO/IEC 14882:2020" standard for the \
                      "C++ programming language". C++20 superseeded \
                      "C++17"
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "C Programming Language";
        url = Environment.getWikipediaURL("C_(programming_language)");
        description = """
                      A general-purpose computer "programming language". The \
                      latest standard "C17" was published in June 2018. The \
                      next is coming soon...
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "C programming language", indexTerm);
        addAlias(term, "C", indexTerm);
        addAlias(term, "C Standard", indexTerm);
        
        term = "C11";
        url = Environment.getWikipediaURL("C11");
        description = """
                      The informal name for "ISO"/"IEC" 9899 standard for the \
                      "C programming language" superseeded by "C17".
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "ISO/IEC 9899:2018";
        url = "https://www.iso.org/standard/74528.html";
        description = """
                      A standards document that specifies the form and \
                      establishes the interpretation of programs written in \
                      the "C programming language"
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "C17";
        url = Environment.getWikipediaURL("C17");
        description = """
                      The informal name for "ISO/IEC 9899:2018" - the most \
                      recent standard for the "C programming language", \
                      published in June 2018. It replaces "C11" and will be \
                      superseded soon...
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Call By Sharing";
        url = Environment.getWikipediaURL("Evaluation_strategy#Call_by_sharing");
        description = "An evaluation strategy where a parameter is shared "
                + "such that changes that are not reassignments are changes to "
                + "a shared object. If there is a reassignment in the function "
                + "then the object is no longer shared and what is in the "
                + "function is distinct from the object in the calling "
                + "\"scope\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Call By Value";
        url = Environment.getWikipediaURL("Evaluation_strategy#Call_by_value");
        description = "An evaluation strategy where the value in the callers "
                + "\"scope\" remains unchanged";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Class";
        url = Environment.getWikipediaURL("Class_(computer_programming)");
        description = "An extensible program-code-template for creating "
                + "objects, providing initial values for state (member "
                + "variables) and implementations of behavior (member "
                + "functions or methods)";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Classes", indexTerm);

        term = "Client";
        url = Environment.getWikipediaURL("Client_(computing)");
        description = "A piece of computer \"hardware\" or \"software\" that "
                + "accesses a service made available by a \"server\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Computer";
        url = Environment.getWikipediaURL("Computer");
        description = "A machine that can be programmed to carry out sequences "
                + "of arithmetic or logical operations (computation) "
                + "automatically";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, 
                "General-purpose computer", indexTerm);

        term = "Computer cluster";
        url = Environment.getWikipediaURL("Computer_cluster");
        description = "A set of \"computers\" that work together so that they "
                + "can be viewed as a single system";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Computer Hardware";
        url = Environment.getWikipediaURL("Computer_hardware");
        description = "The physical parts of a \"computer\", such as the case, "
                + "central processing unit (CPU), random access memory (RAM), "
                + "monitor, mouse, keyboard, computer data storage, graphics "
                + "card, sound card, speakers and motherboard";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Hardware", indexTerm);

        term = "Command Line Interface";
        url = Environment.getWikipediaURL("Command-line_interface");
        description = "A command-line interpreter or command-line processor "
                + "uses a command-line interface (CLI) to receive commands "
                + "from a user in the form of lines of text. This provides a "
                + "means of setting parameters for the environment, invoking "
                + "executables and providing information to the user";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasToIndex(term, "CLI", indexTerm);

        term = "Computer Program";
        url = Environment.getWikipediaURL("Computer_program");
        description = "A sequence or set of instructions in a "
                + "\"programming language\" for a \"computer\" to execute";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Computer Programming";
        url = Environment.getWikipediaURL("Computer_programming");
        description = "The process of designing and building an executable "
                + "computer program";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Conditional";
        url = Environment.getWikipediaURL("Conditional_(computer_programming)");
        description = "A \"control flow\" switch that performs some kind of "
                + " evaluation to determine what code is executed next";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Control Flow";
        url = Environment.getWikipediaURL("Control_flow");
        description = "The order in which individual statements, instructions "
                + "or function calls of an imperative program are executed or "
                + "evaluated";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "CSS";
        url = Environment.getWikipediaURL("CSS");
        description = """
                      A style sheet language used for describing the
                      presentation of a document written in a markup language
                      such as "HTML" or "XML"
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "CSV";
        url = Environment.getWikipediaURL("Comma-separated_values");
        description = "A delimited text file format that uses commas to "
                + "separate values";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Debugging";
        url = Environment.getWikipediaURL("Debugging");
        description = """
                      The process of finding and resolving "bugs" (defects or
                      problems that prevent correct operation) within
                      "computer programs", "software", or systems""";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Deprecation";
        url = Environment.getWikipediaURL("Deprecation");
        description = "The discouragement of use of some terminology, feature, "
                + "design, or practice, typically because it has been "
                + "superseded or is no longer considered efficient or safe, "
                + "without completely removing it or prohibiting its use";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Disk";
        url = Environment.getWikipediaURL("Computer_memory");
        description = "Computer data storage that is slower than memory and "
                + "is used to store information persistently (from one session "
                + "to the next)";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Double-precision Floating-point";
        url = Environment.getWikipediaURL("Double-precision_floating-point_format");
        description = """
                      A "computer" number format, usually occupying 64 "bits"
                      of computer memory
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "End user";
        url = Environment.getWikipediaURL("End_user");
        description = "A person who ultimately uses or is intended to "
                + "ultimately use a product";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "File Format";
        url = Environment.getWikipediaURL("File_format");
        description = "A standard way that information is encoded for storage "
                + "in a computer file";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "File System";
        url = Environment.getWikipediaURL("File_system");
        description = "A method and data structure that a computer operating "
                + "system uses to control how data is stored and retrieved";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Floating-point";
        url = Environment.getWikipediaURL("Floating-point_arithmetic");
        description = """
                      Arithmetic that represents real numbers approximately,
                      using an "integer" with a fixed precision, called the
                      significand, scaled by an "integer" exponent of a fixed
                      base""";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "For Loop";
        url = Environment.getWikipediaURL("For_loop");
        description = "A computer programming construct for repeating a set of "
                + "operations for a sequence of things, for a number of times, "
                + "and/or until a condition is met";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Fortran";
        url = Environment.getWikipediaURL("Fortran");
        description = "A general-purpose \"programming language\". The latest "
                + "standard 'Fortran 2018' was released in November 2018. A "
                + "new standard is expected for publication in July 2023";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Free and Open Source Software";
        url = Environment.getWikipediaURL("Free_and_open-source_software");
        description = "\"Software\" which anyone is freely licensed to use, "
                + "copy, study, change and share";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "FOSS", indexTerm);

        term = "Functional Programming";
        url = Environment.getWikipediaURL("Functional_programming");
        description = "A programming paradigm where programs are constructed "
                + "by applying and composing functions";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Function";
        url = Environment.getWikipediaURL("Function_(computer_programming)");
        description = "A sequence of program instructions that performs a "
                + "specific task";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "GeoJSON";
        url = Environment.getWikipediaURL("GeoJSON");
        description = "An open standard format designed for representing "
                + "simple geographical features, along with their non-spatial "
                + "attributes. It is based on the \"JSON\" format";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "GIS";
        url = Environment.getWikipediaURL("Geographic_information_system");
        description = "a geographical information system comprises people, "
                + "computational resources, software and data. GIS is for "
                + "storing, managing, processing, analyzing, and visualizing "
                + "geographic data";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Git";
        url = Environment.getWikipediaURL("Git");
        description = "a distributed \"version control\" system";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "GitHub";
        url = "http://www.github.com";
        description = "a developer platform to build, scale, and deliver secure"
                + " software";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "Glitch";
        url = Environment.getWikipediaURL("Glitch");
        description = "A short-lived fault in a system, such as a transient "
                + "fault that corrects itself, making it difficult to "
                + "troubleshoot";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "GML";
        url = Environment.getWikipediaURL("Geography_Markup_Language");
        description = "The \"XML\" grammar defined by the Open Geospatial "
                + "Consortium to express geographical features";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Graphical User Interface";
        url = Environment.getWikipediaURL("Graphical_user_interface");
        description = "A form of user interface that primarily uses actionable "
                + "graphical icons";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasPlural(term, "GUI", indexTerm);
        
        term = "High Performance Computing";
        url = Environment.getWikipediaURL("High-performance_computing");
        description = "Uses \"supercomputers\" and \"computer clusters\" to"
                + " solve advanced computation problems.";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasPlural(term, "HPC", indexTerm);

        term = "HTML";
        url = Environment.getWikipediaURL("HTML");
        description = "The standard markup language for documents designed to "
                + "be displayed in a web browser";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "HTTP";
        url = Environment.getWikipediaURL("HTTP");
        description = "An application layer protocol in the \"Internet "
                + "protocol suite\" model for distributed, collaborative, "
                + "hypermedia information systems";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "HTTPS";
        url = Environment.getWikipediaURL("HTTPS");
        description = "An extension of \"HTTP\" that uses encryption for "
                + "secure communication over a computer network";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Integer";
        url = Environment.getWikipediaURL("Integer");
        description = """
                      the number zero, a positive "natural number", or a
                      negative integer
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "IEC";
        url = Environment.getWikipediaURL("ISO");
        description = """
                       the International Electrotechnical Commission is an
                      international standards organization that prepares and
                      publishes international standards for all electrical,
                      electronic and related technologies – collectively known
                      as electrotechnology.""";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "International Electrotechnical Commission",
                indexTerm);
        
        term = "Integrated Development Environment";
        url = Environment.getWikipediaURL("Integrated_development_environment");
        description = "An IDE is a collection of \"software\" tools used to "
                + "make writing code and developing \"software\" easier";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);
        addAlias(term, "IDE", indexTerm);

        term = "Interpreter";
        url = Environment.getWikipediaURL("Interpreter_(computing)");
        description = "A computer program that directly executes instructions "
                + "written in a programming or scripting language, without "
                + "requiring them previously to have been compiled into a "
                + "machine language program";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Internet";
        url = Environment.getWikipediaURL("Internet");
        description = "A global system of interconnected computer networks "
                + "that uses the \"Internet protocol suite\" (TCP/IP) to "
                + "communicate between networks and devices";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);
        
        term = "ISO";
        url = Environment.getWikipediaURL("ISO");
        description = """
                      the International Organization for Standardization is an \
                      international standard development organization composed \
                      of representatives from the national standards \
                      organizations of member countries""";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "International Organization for Standardization",
                indexTerm);

        term = "Java";
        url = Environment.getWikipediaURL("Java_(programming_language)");
        description = "A high-level general purpose \"programming language\". "
                + "The latest version is Java 21, released in September 2023. "
                + "Java 21 is also the latest long-term support (LTS) version. "
                + "Java 22 is scheduled for release in March 2024.";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);
        addAlias(term, "Java programming language", indexTerm);
        addAlias(term, "Java Programming Language", indexTerm);

        term = "JavaScript";
        url = Environment.getWikipediaURL("Javascript");
        description = "A high-level \"programming language\" that is one of "
                + "the core technologies of the \"Web\". All major Web "
                + "browsers have a dedicated JavaScript engine to execute code "
                + "on user devices";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);
        addAlias(term, "JavaScript programming language", indexTerm);
        addAlias(term, "JavaScript Programming Language", indexTerm);

        term = "JSON";
        url = Environment.getWikipediaURL("JSON");
        description = "\"JavaScript\" Object Notation is an open standard "
                + "data interchange format that uses human-readable text to "
                + "store and transmit data objects consisting of attribute"
                + "–value pairs and arrays (or other serializable values)";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Keyboard";
        url = Environment.getWikipediaURL("Computer_keyboard");
        description = "A peripheral input device modeled after the typewriter "
                + "keyboard";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Linux";
        url = Environment.getWikipediaURL("Linux");
        description = "A family of open-source Unix-like \"operating systems\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "MacOS";
        url = Environment.getWikipediaURL("macOS");
        description = "A group of several proprietary Unix \"operating "
                + "systems\" developed and marketed by the company Apple";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "macOS", indexTerm);
        addAliasAndAliasLowerCase(term, "OSX", indexTerm);

        term = "Magic Number";
        url = Environment.getWikipediaURL("File_format#Magic_number");
        description = "File type metadata incorporated into the file - usually "
                + "at the start";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Markdown";
        url = Environment.getWikipediaURL("Markdown");
        description = "A lightweight markup language for creating formatted "
                + "text using a plain-text editor";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);
       
        term = "Apache Maven";
        url = "https://maven.apache.org/";
        description = "a software project management and comprehension tool";
        indexTerm = new IndexTerm(this, description, url); addIndexTerm(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Maven", indexTerm);
        
        term = "Metadata";
        url = Environment.getWikipediaURL("Metadata");
        description = "Data that provides information about other data";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Memory";
        url = Environment.getWikipediaURL("Computer_memory");
        description = "Computer data storage that operates at a high speed "
                + "compared to other data storage and is used to store "
                + "data for immediate use";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Microsoft Windows";
        url = Environment.getWikipediaURL("Microsoft_Windows");
        description = "A group of several proprietary graphical \"operating "
                + "system\" families developed and marketed by the company "
                + "Microsoft";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Monitor";
        url = Environment.getWikipediaURL("Computer_monitor");
        description = "An output device that displays information in pictorial "
                + "or textual form";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Mouse";
        url = Environment.getWikipediaURL("Computer_mouse");
        description = "A hand-held pointing device that detects "
                + "two-dimensional motion relative to a surface";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Name Binding";
        url = Environment.getWikipediaURL("Name_binding");
        description = "The association of entities (data and/or code) with "
                + "identifiers";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);
        
        term = "Natural number";
        url = Environment.getWikipediaURL("Natural_number");
        description = "the numbers 1, 2, 3, etc.";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Network Socket";
        url = Environment.getWikipediaURL("Network_socket");
        description = "A \"software\" structure within a network node of a "
                + "computer network that serves as an endpoint for sending and "
                + "receiving data";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Object Oriented Programming";
        url = Environment.getWikipediaURL("Object-oriented_programming");
        description = "a programming paradigm based on the concept of "
                + "\"objects\", which have data (state), and methods "
                + "(functionality)";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);
        addAlias(term, "object-oriented", indexTerm);

        term = "Open Source Software";
        url = Environment.getWikipediaURL("Open-source_software");
        description = "Computer software for which the \"source code\" is "
                + "released and available for study. See also \"FOSS\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "OSS", indexTerm);

        term = "Operating System";
        url = Environment.getWikipediaURL("Operating_system");
        description = "A system that manages computer \"hardware\" and "
                + "\"software\" resources, and provides common services for "
                + "computer programs";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAlias(term, "OS", indexTerm);
        
        term = "Parallel programming";
        url = Environment.getWikipediaURL("Parallel_computing");
        description = """
                      A type of computation in which many calculations or \
                      processes are carried out simultaneously
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "Parallelisation";
        url = Environment.getWikipediaURL("Parallel_computing");
        description = """
                      The process of changing a "computer program" from a serial \
                      execution (where procesing tasks are completed one after \
                      another), to a parallel execution (where numerous tasks) \
                      are carried out simultaneously
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "PATH";
        url = Environment.getWikipediaURL("PATH_(variable)");
        description = "An environment variable expected to be set on many "
                + "\"operating systems\". The variable specifies a set of "
                + "directories/folders where executable programs are located";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Port";
        url = Environment.getWikipediaURL("Port_(computer_networking)");
        description = "A number assigned to uniquely identify a connection "
                + "endpoint and to direct data to a specific service";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);
        
        term = "Profiling";
        url = Environment.getWikipediaURL("Profiling_(computer_programming)");
        description = """
                      A form of dynamic program analysis that measures, for \
                      example, the memory requirments or processing time of \
                      parts of a "computer program"
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "Programming Language";
        url = Environment.getWikipediaURL("Programming_language");
        description = "A system of notation for writing computer programs";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "Python";
        url = Environment.getWikipediaURL("Python_(programming_language)");
        description = "A high-level, general-purpose \"programming language\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);
        
        term = "Rational number";
        url = Environment.getWikipediaURL("Rational_number");
        description = """
                      a number that can be expressed as the quotient or
                      fraction of two "integers"
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Regression test";
        url = Environment.getWikipediaURL("Regression_testing");
        description = """
                      A test rerun to ensure that previously developed and
                      tested "software" still performs as expected after a
                      change
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "Regression testing";
        url = Environment.getWikipediaURL("Regression_testing");
        description = "Re-running tests to ensure that previously developed "
                + "and tested \"software\" still performs as expected after a "
                + "change";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "REPL";
        url = Environment.getWikipediaURL("Read%E2%80%93eval%E2%80%93print_loop");
        description = "A Read Evaluate Print Loop is an interactive computer "
                + "programming environment that takes single user inputs, "
                + "executes them, and returns the result to the user";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "Reproducibility";
        url = Environment.getWikipediaURL("Reproducibility");
        description = """
                      In computational sciences, reproducibility means results \
                      should be documented by making all data and code \
                      available in such a way that the computations can be \
                      executed again with identical end results
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "Server";
        url = Environment.getWikipediaURL("Server_(computing)");
        description = "Computer \"hardware\" or \"software\" that provides "
                + "functionality for other programs or devices, called "
                + "\"clients\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "Scope";
        url = Environment.getWikipediaURL("Scope_(computer_science)");
        description = "In \"computer programming\", the scope of a "
                + "\"name binding\" (an association of a name to an entity, "
                + "such as a variable) is the part of a program where the "
                + "name binding is valid; that is, where the name can be used "
                + "to refer to the entity. In other parts of the program, the "
                + "name may refer to a different entity";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "Single-precision Floating-point";
        url = Environment.getWikipediaURL("Single-precision_floating-point_format");
        description = "A \"computer\" number format, usually occupying 32 "
                + "\"bits\" of computer memory";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "Software";
        url = Environment.getWikipediaURL("Software");
        description = "computer programs and associated documentation and data";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "Software Bug";
        url = Environment.getWikipediaURL("Software_bug");
        description = "An error, flaw or fault in the design, development, or "
                + "operation of \"software\" that causes it to produce an "
                + "incorrect or unexpected result, or to behave in unintended "
                + "ways. See also \"bug\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "Source Code";
        url = Environment.getWikipediaURL("Source_code");
        description = "Text written using a human-readable \"programming "
                + "language\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "Supercomputer";
        url = Environment.getWikipediaURL("Supercomputer");
        description = "A computer with a high level of performance as compared "
                + "to a \"general-purpose computer\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Syntax Error";
        url = Environment.getWikipediaURL("Syntax_error");
        description = "An error in the syntax of a sequence of characters or "
                + "tokens that is intended to be written in a particular "
                + "\"programming language\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "TCP/IP";
        url = Environment.getWikipediaURL("Internet_protocol_suite");
        description = "A framework for organizing the set of communication "
                + "protocols used in the \"Internet\" and similar computer "
                + "networks according to functional criteria";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Internet protocol suite", indexTerm);

        term = "The GNU Compiler Collection";
        url = "https://gcc.gnu.org/";
        description = """
                      Includes front ends for "C", "C++", Objective-C, \
                      "Fortran", Ada, Go, and D, as well as libraries for \
                      these languages (libstdc++,...)
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "GCC", indexTerm);
        
        term = "Touchscreen";
        url = Environment.getWikipediaURL("Touchscreen");
        description = "Both an input touch panel and output display device";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "Unicode";
        url = Environment.getWikipediaURL("Unicode");
        description = "An information technology standard for the consistent "
                + "encoding, representation, and handling of text expressed in "
                + "most writing systems";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Unit Testing";
        url = Environment.getWikipediaURL("Unit_testing");
        description = "A \"software\" testing method by which individual units "
                + "of \"source code\" - sets of one or more computer program "
                + "modules together with associated control data, usage "
                + "procedures, and operating procedures - are tested to "
                + "determine whether they are fit for use. See also "
                + "\"regression testing\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "Unit testing", indexTerm);
        
        term = "University of Leeds";
        url = Environment.getWikipediaURL("University_of_Leeds");
        description = "A public research university in Leeds, West Yorkshire, "
                + "England";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "URL";
        url = Environment.getWikipediaURL("URL");
        description = "Uniform Resource Locator - a reference to a \"Web\" "
                + "resource that specifies its location and the protocol for "
                + "retrieving it";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Variable";
        url = Environment.getWikipediaURL("Variable_(computer_science)");
        description = "A named container for a particular set of bits or type "
                + "of data";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);

        term = "Version Control";
        url = Environment.getWikipediaURL("Version_control");
        description = "A class of systems responsible for managing changes to "
                + "data";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTermAndTermLowerCase(term, indexTerm);

        term = "Visual Studio Code";
        url = "https://code.visualstudio.com/";
        description = """
                      A code editor with support for development operations \
                      like debugging, task running, and version control
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "VSCode", indexTerm);

        term = "Web Accessibility";
        url = Environment.getWikipediaURL("Web_accessibility");
        description = "The inclusive practice of ensuring there are no "
                + "barriers that prevent interaction with, or access to, "
                + "websites on the \"World Wide Web\" by people with physical "
                + "disabilities, situational disabilities, and socio-economic "
                + "restrictions on bandwidth and speed";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "World Wide Web";
        url = Environment.getWikipediaURL("World_Wide_Web");
        description = "Commonly known as the Web, is an information system "
                + "enabling documents and other web resources to be accessed "
                + "over the \"Internet\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Web", indexTerm);

        term = "While Loop";
        url = Environment.getWikipediaURL("While_loop");
        description = "A control flow statement that allows code to be "
                + "executed repeatedly or until a condition evaluates as false";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "XML";
        url = Environment.getWikipediaURL("XML");
        description = "A extensible markup language standard and data format "
                + "for storing, transmitting, and reconstructing data";
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
            return r.getLink(linkText);
        }
        return null;
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        w.addULST(sb);
        for (String aliasOrTerm : termsAndAliasesToIndex) {
            w.addLIST(sb);
            IndexTerm indexTerm;
            if (aliasesToIndex.contains(aliasOrTerm)) {
                indexTerm = termToIndexTerm.get(aliasToTerm.get(aliasOrTerm));
                sb.append(aliasOrTerm)
                        .append(" - (See ")
                        .append(indexTerm.getLink(aliasToTerm.get(aliasOrTerm)))
                        .append(").");
            } else {
                indexTerm = termToIndexTerm.get(aliasOrTerm);
                sb.append(indexTerm.getLinkAndDescription(aliasOrTerm));
                sb.append(".");
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
