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
    public final TreeSet<String> aliasesToIndex;

    /**
     * A complete set of terms and aliases for the index.
     */
    public final TreeSet<String> termsAndAliasesToIndex;

    /**
     * To look up a term name from an alias.
     */
    public final TreeMap<String, String> aliasToTerm;

    /**
     * To look up aliases from a term.
     */
    public final TreeMap<String, TreeSet<String>> termToAliases;

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
     * @param alias The alias to add for the term.
     * @param indexTerm The index term.
     */
    public final void addAliasAndLowerCase(String term, String alias, IndexTerm indexTerm) {
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
    public final void addAliasAndAliasPlural(String term, String alias, IndexTerm indexTerm) {
        addAliasToIndex(term, alias, indexTerm);
        addAlias(term, alias + "s", indexTerm);
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
    public final void addAliasAndAliasPluralAndAliasLowerCaseAndAliasLowerCaseAndPlural(String term, String alias, IndexTerm indexTerm) {
        addAliasToIndex(term, alias, indexTerm);
        addAlias(term, alias + "s", indexTerm);
        String aliasLowerCase = alias.toLowerCase();
        addAlias(term, aliasLowerCase, indexTerm);
        addAlias(term, aliasLowerCase + "s", indexTerm);
    }

    /**
     * Adds the lower case of term as an alias.
     *
     * @param term The term to add the aliases for.
     * @param indexTerm The index term.
     */
    public final void addLowerCaseAlias(String term, IndexTerm indexTerm) {
        addAlias(term, term.toLowerCase(), indexTerm);
    }

    /**
     * Adds the plural, lower case and lower case plural of term as aliases.
     *
     * @param term The term to add the aliases for.
     * @param indexTerm The index term.
     */
    public final void addLowerCaseAndPluralAliases(String term, IndexTerm indexTerm) {
        addAlias(term, term + "s", indexTerm);
        String lowerCaseTerm = term.toLowerCase();
        addAlias(term, lowerCaseTerm, indexTerm);
        addAlias(term, lowerCaseTerm + "s", indexTerm);
    }

    /**
     * Adds to {@link #termToIndexTerm} and {@link #termsAndAliasesToIndex}.
     *
     * @param term The term to add.
     * @param indexTerm The IndexTerm.
     */
    public final void addIndexTerm(String term, IndexTerm indexTerm) {
        termToIndexTerm.put(term, indexTerm);
        termsAndAliasesToIndex.add(term);
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
        url = getWikipediaURL("Agent-based_model");
        description = "A computational model for simulating the actions and "
                + "interactions of (semi-)autonomous agents (individual or "
                + "collective entities)";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasPlural(term, "ABM", indexTerm);

        term = "Application software";
        url = getWikipediaURL("Application_software");
        description = "A \"computer program\" designed to carry out a specific "
                + "task other than one relating to the operation of the "
                + "computer itself, typically to be used by \"end users\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasPluralAndAliasLowerCaseAndAliasLowerCaseAndPlural(term, "Application", indexTerm);
        addAliasAndAliasPluralAndAliasLowerCaseAndAliasLowerCaseAndPlural(term, "APP", indexTerm);

        term = "Application Programming Interface";
        url = getWikipediaURL("Application_Programming_Interface");
        description = "An interface allowing some \"software\" to interoperate "
                + "with other software";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasPlural(term, "API", indexTerm);

        term = "ASCII";
        url = getWikipediaURL("ASCII");
        description = "A character encoding standard for electronic "
                + "communication";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Backward Compatibility";
        url = getWikipediaURL("Backward_compatibility");
        description = "A property of an \"operating system\", product, or "
                + "technology that allows for interoperability with an older "
                + "legacy system";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);
        addAlias(term, "backwards compatability", indexTerm);

        term = "Bit";
        url = getWikipediaURL("Bit");
        description = "A basic unit of information in computing and digital "
                + "communications representing a logical state having one of "
                + "two possible values";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAndPluralAliases(term, indexTerm);

        term = "Bug";
        url = getWikipediaURL("Bug_(engineering)");
        description = "A defect in the design, manufacture or operation of "
                + "machinery, circuitry, electronics, \"hardware\", or "
                + "\"software\" that produces undesired results or impedes "
                + "operation. "
                + "See also \"Software Bug\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAndPluralAliases(term, indexTerm);

        term = "Byte";
        url = getWikipediaURL("Byte");
        description = "A unit of digital information that most commonly"
                + " consists of eight \"bits\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAndPluralAliases(term, indexTerm);

        term = "Bytecode";
        url = getWikipediaURL("Bytecode");
        description = "A form of \"instruction set\" designed for efficient "
                + "execution by a software \"interpreter\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "C++";
        url = getWikipediaURL("C%2B%2B");
        description = "A high-level, general-purpose \"programming language\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Call By Sharing";
        url = getWikipediaURL("Evaluation_strategy#Call_by_sharing");
        description = "An evaluation strategy where a parameter is shared "
                + "such that changes that are not reassignments are changes to "
                + "a shared object. If there is a reassignment in the function "
                + "then the object is no longer shared and what is in the "
                + "function is distinct from the object in the calling "
                + "\"scope\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Call By Value";
        url = getWikipediaURL("Evaluation_strategy#Call_by_value");
        description = "An evaluation strategy where the value in the callers "
                + "\"scope\" remains unchanged";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Class";
        url = getWikipediaURL("Class_(computer_programming)");
        description = "An extensible program-code-template for creating "
                + "objects, providing initial values for state (member "
                + "variables) and implementations of behavior (member "
                + "functions or methods)";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Client";
        url = getWikipediaURL("Client_(computing)");
        description = "A piece of computer \"hardware\" or \"software\" that "
                + "accesses a service made available by a \"server\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAndPluralAliases(term, indexTerm);

        term = "Computer";
        url = getWikipediaURL("Computer");
        description = "A machine that can be programmed to carry out sequences "
                + "of arithmetic or logical operations (computation) "
                + "automatically";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Computer Hardware";
        url = getWikipediaURL("Computer_hardware");
        description = "The physical parts of a \"computer\", such as the case, "
                + "central processing unit (CPU), random access memory (RAM), "
                + "monitor, mouse, keyboard, computer data storage, graphics "
                + "card, sound card, speakers and motherboard";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndLowerCase(term, "Hardware", indexTerm);

        term = "Command Line Interface";
        url = getWikipediaURL("Command-line_interface");
        description = "A command-line interpreter or command-line processor "
                + "uses a command-line interface (CLI) to receive commands "
                + "from a user in the form of lines of text. This provides a "
                + "means of setting parameters for the environment, invoking "
                + "executables and providing information to the user";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasToIndex(term, "CLI", indexTerm);

        term = "Computer Program";
        url = getWikipediaURL("Computer_program");
        description = "A sequence or set of instructions in a "
                + "\"programming language\" for a \"computer\" to execute";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAndPluralAliases(term, indexTerm);

        term = "Computer Programming";
        url = getWikipediaURL("Computer_programming");
        description = "The process of designing and building an executable "
                + "computer program";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAndPluralAliases(term, indexTerm);

        term = "Conditional";
        url = getWikipediaURL("Conditional_(computer_programming)");
        description = "A \"control flow\" switch that performs some kind of "
                + " evaluation to determine what code is executed next";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAndPluralAliases(term, indexTerm);

        term = "Control Flow";
        url = getWikipediaURL("Control_flow");
        description = "The order in which individual statements, instructions "
                + "or function calls of an imperative program are executed or "
                + "evaluated";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "CSS";
        url = getWikipediaURL("CSS");
        description = "A style sheet language used for describing the "
                + "presentation of a document written in a markup language "
                + "such as \"HTML\" or \"XML\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "CSV";
        url = getWikipediaURL("Comma-separated_values");
        description = "A delimited text file format that uses commas to "
                + "separate values";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Debugging";
        url = getWikipediaURL("Debugging");
        description = "The process of finding and resolving \"bugs\" (defects "
                + "or problems that prevent correct operation) within "
                + "\"computer programs\", \"software\", or systems";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Deprecation";
        url = getWikipediaURL("Deprecation");
        description = "The discouragement of use of some terminology, feature, "
                + "design, or practice, typically because it has been "
                + "superseded or is no longer considered efficient or safe, "
                + "without completely removing it or prohibiting its use";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Disk";
        url = getWikipediaURL("Computer_memory");
        description = "Computer data storage that is slower than memory and "
                + "is used to store information persistently (from one session "
                + "to the next)";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Double-precision Floating-point";
        url = getWikipediaURL("Double-precision_floating-point_format");
        description = "A \"computer\" number format, usually occupying 64 "
                + "\"bits\" of computer memory";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "End user";
        url = getWikipediaURL("End_user");
        description = "A person who ultimately uses or is intended to "
                + "ultimately use a product.";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAndPluralAliases(term, indexTerm);

        term = "File Format";
        url = getWikipediaURL("File_format");
        description = "A standard way that information is encoded for storage "
                + "in a computer file";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "File System";
        url = getWikipediaURL("File_system");
        description = "A method and data structure that a computer operating "
                + "system uses to control how data is stored and retrieved";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Floating-point";
        url = getWikipediaURL("Floating-point_arithmetic");
        description = "Arithmetic that represents real numbers approximately, "
                + "using an integer with a fixed precision, called the "
                + "significand, scaled by an integer exponent of a fixed base";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "For Loop";
        url = getWikipediaURL("For_loop");
        description = "A computer programming construct for repeating a set of "
                + "operations for a sequence of things, for a number of times, "
                + "and/or until a condition is met";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Free and Open Source Software";
        url = getWikipediaURL("Free_and_open-source_software");
        description = "\"Software\" which anyone is freely licensed to use, "
                + "copy, study, change and share";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "FOSS", indexTerm);

        term = "Functional Programming";
        url = getWikipediaURL("Functional_programming");
        description = "A programming paradigm where programs are constructed "
                + "by applying and composing functions";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Function";
        url = getWikipediaURL("Function_(computer_programming)");
        description = "A sequence of program instructions that performs a "
                + "specific task";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "GeoJSON";
        url = getWikipediaURL("GeoJSON");
        description = "An open standard format designed for representing "
                + "simple geographical features, along with their non-spatial "
                + "attributes. It is based on the \"JSON\" format";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "GIS";
        url = getWikipediaURL("Geographic_information_system");
        description = "a geographical information system comprises people, "
                + "computational resources, software and data. GIS is for "
                + "storing, managing, processing, analyzing, and visualizing "
                + "geographic data";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Glitch";
        url = getWikipediaURL("Glitch");
        description = "A short-lived fault in a system, such as a transient "
                + "fault that corrects itself, making it difficult to "
                + "troubleshoot";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "GML";
        url = getWikipediaURL("Geography_Markup_Language");
        description = "The \"XML\" grammar defined by the Open Geospatial "
                + "Consortium to express geographical features";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Graphical User Interface";
        url = getWikipediaURL("Graphical_user_interface");
        description = "A form of user interface that primarily uses actionable "
                + "graphical icons";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasPlural(term, "GUI", indexTerm);

        term = "HTML";
        url = getWikipediaURL("HTML");
        description = "The standard markup language for documents designed to "
                + "be displayed in a web browser";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "HTTP";
        url = getWikipediaURL("HTTP");
        description = "An application layer protocol in the \"Internet "
                + "protocol suite\" model for distributed, collaborative, "
                + "hypermedia information systems";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "HTTPS";
        url = getWikipediaURL("HTTPS");
        description = "An extension of \"HTTP\" that uses encryption for "
                + "secure communication over a computer network";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Integrated Development Environment";
        url = getWikipediaURL("Integrated_development_environment");
        description = "An IDE is a collection of \"software\" tools used to "
                + "make writing code and developing \"software\" easier";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);
        addAlias(term, "IDE", indexTerm);

        term = "Interpreter";
        url = getWikipediaURL("Interpreter_(computing)");
        description = "A computer program that directly executes instructions "
                + "written in a programming or scripting language, without "
                + "requiring them previously to have been compiled into a "
                + "machine language program";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Internet";
        url = getWikipediaURL("Internet");
        description = "A global system of interconnected computer networks "
                + "that uses the \"Internet protocol suite\" (TCP/IP) to "
                + "communicate between networks and devices";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Java";
        url = getWikipediaURL("Java_(programming_language)");
        description = "A high-level, class-based, \"object-oriented\" "
                + "\"programming language\" that is designed to have as few "
                + "implementation dependencies as possible";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "JavaScript";
        url = getWikipediaURL("Javascript");
        description = "A high-level \"programming language\" that is one of "
                + "the core technologies of the \"Web\". All major Web "
                + "browsers have a dedicated JavaScript engine to execute code "
                + "on user devices";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "JSON";
        url = getWikipediaURL("JSON");
        description = "\"JavaScript\" Object Notation is an open standard "
                + "data interchange format that uses human-readable text to "
                + "store and transmit data objects consisting of attribute"
                + "–value pairs and arrays (or other serializable values)";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Keyboard";
        url = getWikipediaURL("Computer_keyboard");
        description = "A peripheral input device modeled after the typewriter "
                + "keyboard";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Linux";
        url = getWikipediaURL("Linux");
        description = "A family of open-source Unix-like \"operating systems\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "MacOS";
        url = getWikipediaURL("macOS");
        description = "A group of several proprietary Unix \"operating "
                + "systems\" developed and marketed by the company Apple";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "macOS", indexTerm);
        addAliasAndLowerCase(term, "OSX", indexTerm);
        
        term = "Magic Number";
        url = getWikipediaURL("File_format#Magic_number");
        description = "File type metadata incorporated into the file - usually "
                + "at the start";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Markdown";
        url = getWikipediaURL("Markdown");
        description = "A lightweight markup language for creating formatted "
                + "text using a plain-text editor";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Metadata";
        url = getWikipediaURL("Metadata");
        description = "Data that provides information about other data";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Memory";
        url = getWikipediaURL("Computer_memory");
        description = "Computer data storage that operates at a high speed "
                + "compared to other data storage and is used to store "
                + "data for immediate use";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Microsoft Windows";
        url = getWikipediaURL("Microsoft_Windows");
        description = "A group of several proprietary graphical \"operating "
                + "system\" families developed and marketed by the company "
                + "Microsoft";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Monitor";
        url = getWikipediaURL("Computer_monitor");
        description = "An output device that displays information in pictorial "
                + "or textual form";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Mouse";
        url = getWikipediaURL("Computer_mouse");
        description = "A hand-held pointing device that detects "
                + "two-dimensional motion relative to a surface";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Name Binding";
        url = getWikipediaURL("Name_binding");
        description = "The association of entities (data and/or code) with "
                + "identifiers";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Network Socket";
        url = getWikipediaURL("Network_socket");
        description = "A \"software\" structure within a network node of a "
                + "computer network that serves as an endpoint for sending and "
                + "receiving data";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Object Oriented Programming";
        url = getWikipediaURL("Object-oriented_programming");
        description = "a programming paradigm based on the concept of "
                + "\"objects\", which have data (state), and methods "
                + "(functionality)";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);
        addAlias(term, "object-oriented", indexTerm);

        term = "Open Source Software";
        url = getWikipediaURL("Open-source_software");
        description = "Computer software for which the \"source code\" is "
                + "released and available for study. See also \"FOSS\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "OSS", indexTerm);

        term = "Operating System";
        url = getWikipediaURL("Operating_system");
        description = "A system that manages computer \"hardware\" and "
                + "\"software\" resources, and provides common services for "
                + "computer programs";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAndPluralAliases(term, indexTerm);
        addAlias(term, "OS", indexTerm);

        term = "PATH";
        url = getWikipediaURL("PATH_(variable)");
        description = "An environment variable expected to be set on many "
                + "\"operating systems\". The variable specifies a set of "
                + "directories/folders where executable programs are located";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Port";
        url = getWikipediaURL("Port_(computer_networking)");
        description = "A number assigned to uniquely identify a connection "
                + "endpoint and to direct data to a specific service";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Programming Language";
        url = getWikipediaURL("Programming_language");
        description = "A system of notation for writing computer programs";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Python";
        url = getWikipediaURL("Python_(programming_language)");
        description = "A high-level, general-purpose \"programming language\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Regression test";
        url = getWikipediaURL("Regression_testing");
        description = "A test rerun to ensure that previously developed "
                + "and tested \"software\" still performs as expected after a "
                + "change";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Regression testing";
        url = getWikipediaURL("Regression_testing");
        description = "Re-running tests to ensure that previously developed "
                + "and tested \"software\" still performs as expected after a "
                + "change";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "REPL";
        url = getWikipediaURL("Read%E2%80%93eval%E2%80%93print_loop");
        description = "A Read Evaluate Print Loop is an interactive computer "
                + "programming environment that takes single user inputs, "
                + "executes them, and returns the result to the user";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Reproducibility";
        url = getWikipediaURL("Reproducibility");
        description = "In computational sciences, reporducibility means "
                + "results should be documented by making all data and code "
                + "available in such a way that the computations can be "
                + "executed again with identical end results";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Server";
        url = getWikipediaURL("Server_(computing)");
        description = "Computer \"hardware\" or \"software\" that provides "
                + "functionality for other programs or devices, called "
                + "\"clients\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Scope";
        url = getWikipediaURL("Scope_(computer_science)");
        description = "In \"computer programming\", the scope of a "
                + "\"name binding\" (an association of a name to an entity, "
                + "such as a variable) is the part of a program where the "
                + "name binding is valid; that is, where the name can be used "
                + "to refer to the entity. In other parts of the program, the "
                + "name may refer to a different entity";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Single-precision Floating-point";
        url = getWikipediaURL("Single-precision_floating-point_format");
        description = "A \"computer\" number format, usually occupying 32 "
                + "\"bits\" of computer memory";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Software";
        url = getWikipediaURL("Software");
        description = "computer programs and associated documentation and data";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Software Bug";
        url = getWikipediaURL("Software_bug");
        description = "An error, flaw or fault in the design, development, or "
                + "operation of \"software\" that causes it to produce an "
                + "incorrect or unexpected result, or to behave in unintended "
                + "ways. See also \"bug\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Source Code";
        url = getWikipediaURL("Source_code");
        description = "Text written using a human-readable \"programming "
                + "language\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        aliasToTerm.put(term.toLowerCase(), term);

        term = "Syntax Error";
        url = getWikipediaURL("Syntax_error");
        description = "An error in the syntax of a sequence of characters or "
                + "tokens that is intended to be written in a particular "
                + "\"programming language\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        aliasToTerm.put(term.toLowerCase(), term);

        term = "TCP/IP";
        url = getWikipediaURL("Internet_protocol_suite");
        description = "A framework for organizing the set of communication "
                + "protocols used in the \"Internet\" and similar computer "
                + "networks according to functional criteria";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasPluralAndAliasLowerCaseAndAliasLowerCaseAndPlural(term, 
                "Internet protocol suite", indexTerm);

        term = "Touchscreen";
        url = getWikipediaURL("Touchscreen");
        description = "Both an input touch panel and output display device";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Unicode";
        url = getWikipediaURL("Unicode");
        description = "An information technology standard for the consistent "
                + "encoding, representation, and handling of text expressed in "
                + "most writing systems";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Unit Testing";
        url = getWikipediaURL("Unit_testing");
        description = "A \"software\" testing method by which individual units "
                + "of \"source code\" - sets of one or more computer program "
                + "modules together with associated control data, usage "
                + "procedures, and operating procedures - are tested to "
                + "determine whether they are fit for use. See also "
                + "\"regression testing\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "URL";
        url = getWikipediaURL("URL");
        description = "Uniform Resource Locator - a reference to a \"Web\" "
                + "resource that specifies its location and the protocol for "
                + "retrieving it";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Variable";
        url = getWikipediaURL("Variable_(computer_science)");
        description = "A named container for a particular set of bits or type "
                + "of data";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Version Control";
        url = getWikipediaURL("Version_control");
        description = "A class of systems responsible for managing changes to "
                + "computer programs, documents, \"Web\" sites, or other "
                + "collections of information.";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(term, indexTerm);

        term = "Web Accessibility";
        url = getWikipediaURL("Web_accessibility");
        description = "The inclusive practice of ensuring there are no "
                + "barriers that prevent interaction with, or access to, "
                + "websites on the \"World Wide Web\" by people with physical "
                + "disabilities, situational disabilities, and socio-economic "
                + "restrictions on bandwidth and speed";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "World Wide Web";
        url = getWikipediaURL("World_Wide_Web");
        description = "Commonly known as the Web, is an information system "
                + "enabling documents and other web resources to be accessed "
                + "over the \"Internet\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndLowerCase(term, "Web", indexTerm);

        term = "While Loop";
        url = getWikipediaURL("While_loop");
        description = "A control flow statement that allows code to be "
                + "executed repeatedly or until a condition evaluates as false";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "XML";
        url = getWikipediaURL("XML");
        description = "A extensible markup language standard and data format "
                + "for storing, transmitting, and reconstructing data";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
    }

    /**
     * The default Wikipedia URL.
     */
    public static final String EN_WIKIPEDIA_URL = "https://en.wikipedia.org/wiki/";

    /**
     * @param article Appended to create what is returned.
     * @return {@link #EN_WIKIPEDIA_URL} + article;
     */
    public final String getWikipediaURL(String article) {
        return EN_WIKIPEDIA_URL + article;
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
        if (!references.nameToTerm.containsKey(name)) {
            references.nameToTerm.put(name,
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
        sb.append("<ul>");
        for (String aliasOrTerm : termsAndAliasesToIndex) {
            IndexTerm indexTerm;
            if (aliasesToIndex.contains(aliasOrTerm)) {
                indexTerm = termToIndexTerm.get(aliasToTerm.get(aliasOrTerm));
            } else {
                indexTerm = termToIndexTerm.get(aliasOrTerm);
            }
            sb.append("<li>");
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
            sb.append("</li>\n");
        }
        sb.append("</ul>\n");
        sb.append("</div>\n");
        return sb.toString();
    }

    
    /**
     * For writing the page to file. (This does not write out a contents.)
     */
    @Override
    public void write() {
        writeHeader();
        writeH1();
        String page = getMainContent();
        w.add(page);
    }
}
