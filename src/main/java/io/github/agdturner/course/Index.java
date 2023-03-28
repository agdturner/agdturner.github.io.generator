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

import io.github.agdturner.core.PageID;
import io.github.agdturner.core.SectionID;
import io.github.agdturner.core.TermID;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * For course index pages.
 *
 * @author Andy Turner
 */
public class Index extends Page {

    /**
     * To look up IndexTerms from a term name.
     */
    public TreeMap<String, IndexTerm> termToIndexTerm;

    /**
     * Create a new instance.
     *
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     * @param c What {@code #c} is set to.
     */
    public Index(String filename, String title, String label, Course c) {
        super(filename, title, label, c);
        termToIndexTerm = new TreeMap<>();

        String name;
        String url;
        String description;

        name = "ABM";
        url = getWikipediaURL("Agent-based_model");
        description = "an Agent Based Model is a computational model for "
                + "simulating the actions and interactions of autonomous "
                + "agents (both individual or collective entities such as "
                + "organizations or groups)";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "API";
        url = getWikipediaURL("Application_Programming_Interface");
        description = "an interface allowing some software to interoperate "
                + "with other software";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "ASCII";
        url = getWikipediaURL("ASCII");
        description = "a character encoding standard for electronic "
                + "communication";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Backward Compatibility";
        url = getWikipediaURL("Backward_compatibility");
        description = "(sometimes known as backwards compatibility) is a "
                + "property of an operating system, product, or technology "
                + "that allows for interoperability with an older legacy "
                + "system";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Beautiful Soup";
        url = "https://beautiful-soup-4.readthedocs.io/";
        description = "a Python library for pulling data out of HTML and XML "
                + "files";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Bit";
        url = getWikipediaURL("Bit");
        description = "the most basic unit of information in computing and"
                + " digital communications. A bit represents a logical state"
                + " having one of two possible values";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Bug";
        url = getWikipediaURL("Bug_(engineering)");
        description = "a defect in the design, manufacture or operation of "
                + "machinery, circuitry, electronics, hardware, or software "
                + "that produces undesired results or impedes operation";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Byte";
        url = getWikipediaURL("Byte");
        description = "a unit of digital information that most commonly"
                + " consists of eight bits";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "C++";
        url = getWikipediaURL("C%2B%2B");
        description = "a high-level, general-purpose programming language";
        termToIndexTerm.put(name, new IndexTerm(description, url));
                
        name = "Call By Sharing";
        url = getWikipediaURL("Evaluation_strategy#Call_by_sharing");
        description = "an evaluation strategy where a parameter is shared "
                + "such that changes that are not reassignments are changes to "
                + "a shared object. If there is a reassignment in the function "
                + "then the object is no longer shared and what is in the "
                + "function is distinct from the object in the calling scope";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Call By Value";
        url = getWikipediaURL("Evaluation_strategy#Call_by_value");
        description = "the value in the callers scope remains unchanged";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Class";
        url = getWikipediaURL("Class_(computer_programming)");
        description = "an extensible program-code-template for creating "
                + "objects, providing initial values for state (member "
                + "variables) and implementations of behavior (member "
                + "functions or methods)";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Command Line Interface";
        url = getWikipediaURL("Command-line_interface");
        description = "a command-line interpreter or command-line processor "
                + "uses a command-line interface (CLI) to receive commands "
                + "from a user in the form of lines of text. This provides a "
                + "means of setting parameters for the environment, invoking "
                + "executables and providing information to them as to what "
                + "actions they are to perform";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Computer Programming";
        url = getWikipediaURL("Computer_programming");
        description = "the process of designing and building an executable "
                + "computer program";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Conditional";
        url = getWikipediaURL("Conditional_(computer_programming)");
        description = "perform different computations or actions depending on "
                + "whether a programmer-defined boolean condition evaluates to "
                + "true or false";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Control Flow";
        url = getWikipediaURL("Control_flow");
        description = "a named container of data";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "CSS";
        url = getWikipediaURL("CSS");
        description = "a style sheet language used for describing the "
                + "presentation of a document written in a markup language "
                + "such as HTML or XML";
        termToIndexTerm.put(name, new IndexTerm(description, url));
                
        name = "CSV";
        url = getWikipediaURL("Comma-separated_values");
        description = "a delimited text file format that uses a comma to "
                + "separate values";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Debugging";
        url = getWikipediaURL("Debugging");
        description = "the process of finding and resolving bugs (defects or "
                + "problems that prevent correct operation) within computer "
                + "programs, software, or systems";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Deprecation";
        url = getWikipediaURL("Deprecation");
        description = "the discouragement of use of some terminology, feature, "
                + "design, or practice, typically because it has been "
                + "superseded or is no longer considered efficient or safe, "
                + "without completely removing it or prohibiting its use";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Disk";
        url = getWikipediaURL("Computer_memory");
        description = "computer data storage that is slower than memory and "
                + "is used to store information persistently (from one session "
                + "to the next)";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Double-precision Floating-point";
        url = getWikipediaURL("Double-precision_floating-point_format");
        description = "a computer number format, usually occupying 64 bits in "
                + "computer memory";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "File Format";
        url = getWikipediaURL("File_format");
        description = "a standard way that information is encoded for storage "
                + "in a computer file";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "File System";
        url = getWikipediaURL("File_system");
        description = "a method and data structure that a computer operating "
                + "system uses to control how data is stored and retrieved";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Floating-point";
        url = getWikipediaURL("Floating-point_arithmetic");
        description = "arithmetic that represents real numbers approximately, "
                + "using an integer with a fixed precision, called the "
                + "significand, scaled by an integer exponent of a fixed base";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "For Loop";
        url = getWikipediaURL("For_loop");
        description = "runs a section of code repeatedly until a condition is "
                + "satisfied";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Free and Open Source Software";
        url = getWikipediaURL("Free_and_open-source_software");
        description = "software where anyone is freely licensed to use, copy, "
                + "study, and change the software in any way, and the source "
                + "code is openly shared";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Functional Programming";
        url = getWikipediaURL("Functional_programming");
        description = "a programming paradigm where programs are constructed "
                + "by applying and composing functions";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Function";
        url = getWikipediaURL("Function_(computer_programming)");
        description = "a sequence of program instructions that performs a "
                + "specific task";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "GeoJSON";
        url = getWikipediaURL("GeoJSON");
        description = "an open standard format designed for representing "
                + "simple geographical features, along with their non-spatial "
                + "attributes. It is based on the JSON format";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "GIS";
        url = getWikipediaURL("Geographic_information_system");
        description = "a geographical information system comprises people, "
                + "computational resources, software and data. GIS is for "
                + "storing, managing, processing, analyzing, and visualizing "
                + "geographic data";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Glitch";
        url = getWikipediaURL("Glitch");
        description = "a short-lived fault in a system, such as a transient "
                + "fault that corrects itself, making it difficult to "
                + "troubleshoot";
        termToIndexTerm.put(name, new IndexTerm(description, url));
                
        name = "GML";
        url = getWikipediaURL("Geography_Markup_Language");
        description = "the XML grammar defined by the Open Geospatial "
                + "Consortium (OGC) to express geographical features";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "GUI";
        url = getWikipediaURL("Graphical_user_interface");
        description = "a form of user interface that primarily uses actionable "
                + "graphical icons";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "HTML";
        url = getWikipediaURL("HTML");
        description = "the standard markup language for documents designed to "
                + "be displayed in a web browser";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "HTTP";
        url = getWikipediaURL("HTTP");
        description = "an application layer protocol in the Internet protocol "
                + "suite model for distributed, collaborative, hypermedia "
                + "information systems";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "HTTPS";
        url = getWikipediaURL("HTTPS");
        description = "is an extension of HTTP that uses encryption for secure "
                + "communication over a computer network";
        termToIndexTerm.put(name, new IndexTerm(description, url));
                      
        name = "IDE";
        url = getWikipediaURL("Integrated_development_environment");
        description = "and Integrated Development Environment - a collection of "
                + "software tools used to make writing code and developing "
                + "software easier";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Internet";
        url = getWikipediaURL("Internet");
        description = "a global system of interconnected computer networks "
                + "that uses the Internet protocol suite (TCP/IP) to "
                + "communicate between networks and devices";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "JavaScript";
        url = getWikipediaURL("Javascript");
        description = "a high-level programming language that is one of the "
                + "core technologies of the World Wide Web. All major Web "
                + "browsers have a dedicated JavaScript engine to execute code "
                + "on users' devices";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "JSON";
        url = getWikipediaURL("JSON");
        description = " JavaScript Object Notation is an open standard file "
                + "format and data interchange format that uses human-readable "
                + "text to store and transmit data objects consisting of "
                + "attribute–value pairs and arrays (or other serializable "
                + "values)";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Keyboard";
        url = getWikipediaURL("Computer_keyboard");
        description = "a peripheral input device modeled after the typewriter "
                + "keyboard";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Linux";
        url = getWikipediaURL("Linux");
        description = "a family of open-source Unix-like operating systems";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "MacOS";
        url = getWikipediaURL("macOS");
        description = "a group of several proprietary Unix operating systems "
                + "developed and marketed by Apple Inc";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Magic Number";
        url = getWikipediaURL("File_format#Magic_number");
        description = "file type metadata incorporated into the file - usually "
                + "at the start";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Markdown";
        url = getWikipediaURL("Markdown");
        description = "a lightweight markup language for creating formatted "
                + "text using a plain-text editor";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Metadata";
        url = getWikipediaURL("Metadata");
        description = "data that provides information about other data";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Memory";
        url = getWikipediaURL("Computer_memory");
        description = "computer data storage that operates at a high speed "
                + "compared to other data storage and is used to store "
                + "data for immediate use";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Microsoft Windows";
        url = getWikipediaURL("Microsoft_Windows");
        description = "a group of several proprietary graphical operating "
                + "system families developed and marketed by Microsoft";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Monitor";
        url = getWikipediaURL("Computer_monitor");
        description = "an output device that displays information in pictorial "
                + "or textual form";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Mouse";
        url = getWikipediaURL("Computer_mouse");
        description = "a hand-held pointing device that detects "
                + "two-dimensional motion relative to a surface";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Name Binding";
        url = getWikipediaURL("Name_binding");
        description = "the association of entities (data and/or code) with "
                + "identifiers";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Network Socket";
        url = getWikipediaURL("Network_socket");
        description = " a software structure within a network node of a "
                + "computer network that serves as an endpoint for sending and "
                + "receiving data across the network";
        termToIndexTerm.put(name, new IndexTerm(description, url));
                
        name = "Object Oriented Programming";
        url = getWikipediaURL("Object-oriented_programming");
        description = "a programming paradigm based on the concept of "
                + "\"objects\", which can contain data and code. The data is "
                + "in the form of fields (often known as attributes or "
                + "properties), and the code is in the form of procedures "
                + "(often known as methods)";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Open Source Software";
        url = getWikipediaURL("Open-source_software");
        description = "computer software that is released under a license that "
                + "grants rights to use, study, change, and distribute the "
                + "software and its source code";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Operating System";
        url = getWikipediaURL("Operating_system");
        description = "a system that manages computer hardware and software "
                + "resources, and provides common services for computer "
                + "programs";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "PATH";
        url = getWikipediaURL("PATH_(variable)");
        description = "an environment variable on Unix-like operating systems, "
                + "DOS, OS/2, and Microsoft Windows, specifying a set of "
                + "directories where executable programs are located";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Port";
        url = getWikipediaURL("Port_(computer_networking)");
        description = "a number assigned to uniquely identify a connection "
                + "endpoint and to direct data to a specific service";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Programming Language";
        url = getWikipediaURL("Programming_language");
        description = "a system of notation for writing computer programs";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "PyQGIS";
        url = "https://qgis.org/pyqgis/";
        description = "QGIS Python API";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "PyQGIS Developer Cookbook";
        url = "https://docs.qgis.org/latest/en/docs/pygqis_developer_cookbook/";
        description = "a tutorial and a reference guide to the PyQGIS API";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python";
        url = getWikipediaURL("Python_(programming_language)");
        description = "a high-level, general-purpose programming language";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Python array";
        url = "https://docs.python.org/3/library/array.html";
        description = "a standard library module that defines an object type "
                + "which can compactly represent a sequence of values all of "
                + "the same type. They behave like lists, except that the type "
                + "of objects stored in them is constrained";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Python break";
        url = "https://docs.python.org/3/reference/simple_stmts.html#break";
        description = "terminates the nearest enclosing loop, skipping the optional else clause if the loop has one";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Python builtins";
        url = "https://docs.python.org/3/library/builtins.html";
        description = "an always loaded module that provides direct access to "
                + "all 'built-in' identifiers";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python Built-in Constants";
        url = "https://docs.python.org/3/library/constants.html#built-in-consts";
        description = "constants that are always available";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python Built-in Functions";
        url = "https://docs.python.org/3/library/functions.html#built-in-funcs";
        description = "functions and types that are always available";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python Built-in Types";
        url = "https://docs.python.org/3/library/stdtypes.html";
        description = "the standard numerics, sequences, mappings, classes, "
                + "instances and exceptions that are built into the "
                + "interpreter";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python continue";
        url = "https://docs.python.org/3/reference/simple_stmts.html#continue";
        description = "continues with the next cycle of the nearest enclosing "
                + "loop. When continue passes control out of a try statement "
                + "with a finally clause, that finally clause is executed "
                + "before starting the next loop cycle";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Python csv";
        url = "https://docs.python.org/3/reference/simple_stmts.html#continue";
        description = "a standard library module for handling data in CSV "
                + "format";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Python decimal";
        url = "https://docs.python.org/3/library/decimal.html";
        description = "a standard library module providing support for "
                + "fast correctly rounded decimal floating point arithmetic";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python delimiters";
        url = "https://docs.python.org/3/reference/lexical_analysis.html#delimiters";
        description = "a String that separates parts";
        termToIndexTerm.put(name, new IndexTerm(description, url));
                      
        name = "Python dict";
        url = "https://docs.python.org/3/library/stdtypes.html#dict";
        description = "a mapping object that maps unique keys to values";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python docstring";
        url = "https://peps.python.org/pep-0257/#what-is-a-docstring";
        description = "a string literal comment that occurs as the first "
                + "statement in a module, function, class, or method "
                + "definition. This becomes the __doc__ special attribute of "
                + "that object";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Python built-in exceptions";
        url = "https://docs.python.org/3/library/exceptions.html";
        description = "exceptions are both a sort of error and an object "
                + "raised when there is a problem";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python byte";
        url = "https://docs.python.org/3/library/stdtypes.html#bytes";
        description = "an immutable sequence of integers in the range [0, 255]";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python bytearray";
        url = "https://docs.python.org/3/library/stdtypes.html#bytearray";
        description = "a mutable sequence of integers in the range [0, 255]";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python dir";
        url = "https://docs.python.org/3/library/functions.html#dir";
        description = "a function that: without arguments, returns the list of "
                + "names in the current local scope; and, with an argument, "
                + "attempts to return a list of valid attributes for that "
                + "object";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python for";
        url = "https://docs.python.org/3/reference/compound_stmts.html#for";
        description = "used to iterate over the elements of a sequence";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Python fractions";
        url = "https://docs.python.org/3/library/fractions.html";
        description = "a standard library module providing support for "
                + "rational number arithmetic";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python help";
        url = "https://docs.python.org/3/library/functions.html#help";
        description = "a function that starts the help system";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python if";
        url = "https://docs.python.org/3/reference/compound_stmts.html#if";
        description = "a compound statement used for conditional execution";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Python input";
        url = "https://docs.python.org/3/library/functions.html#input";
        description = "a builtins module function that reads a line from "
                + "standard input, converts it to a string (stripping a "
                + "trailing newline), and returns that string";
        termToIndexTerm.put(name, new IndexTerm(description, url));
              
        name = "Python import";
        url = "https://docs.python.org/3/reference/simple_stmts.html#import";
        description = "a statement for importing modules";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Python io";
        url = "https://docs.python.org/3/library/io.html";
        description = "a standard library module the provides the main "
                + "facilities for dealing with various types of input and "
                + "output";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python json";
        url = "https://docs.python.org/3/library/json.html";
        description = "a standard library module for handling data in JSON "
                + "format";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python keyword";
        url = "https://docs.python.org/3/reference/lexical_analysis.html#keywords";
        description = "a reserved word that cannot be used as an "
                + "ordinary identifier (names of variable, function, class, "
                + "module or package)";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python lambda";
        url = "https://docs.python.org/3/reference/expressions.html#lambda";
        description = "an expression used to create anonymous functions";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python len";
        url = "https://docs.python.org/3/library/functions.html#len";
        description = "a function for getting the length (the number of items) "
                + "of an object";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python list";
        url = "https://docs.python.org/3/library/stdtypes.html#lists";
        description = "a mutable sequence, typically used to store collections "
                + "of homogeneous items";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python match";
        url = "https://docs.python.org/3/reference/compound_stmts.html#the-match-statement";
        description = "statement used for pattern matching";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python math";
        url = "https://docs.python.org/3/library/math.html";
        description = "provides access to the mathematical functions defined "
                + "by the C standard";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python MemoryError";
        url = "https://docs.python.org/3/library/exceptions.html#MemoryError";
        description = "an exception raised when an operation runs out of "
                + "memory but the situation may still be rescued (by deleting "
                + "some objects)";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python Module Index";
        url = "https://docs.python.org/3/py-modindex.html";
        description = "an index of standard library modules";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python NameError";
        url = "https://docs.python.org/3/library/exceptions.html#NameError";
        description = "an exception raised when a local or global name is "
                + "not found";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Python open";
        url = "https://docs.python.org/3/library/functions.html#input";
        description = "a builtin function to open a file and return a "
                + "corresponding file object";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python operator";
        url = "https://docs.python.org/3/library/operator.html";
        description = "a standard library module that exports a set of "
                + "functions corresponding to the intrinsic operators of "
                + "Python";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python print";
        url = "https://docs.python.org/3/library/functions.html#print";
        description = "a function from the builtins module for printing to the "
                + "screen";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python random";
        url = "https://docs.python.org/3/library/random.html";
        description = "a standard library module that implements pseudo-random "
                + "number generators for various distributions";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python range";
        url = "https://docs.python.org/3/library/stdtypes.html#ranges";
        description = "an immutable sequence of numbers, commonly used for "
                + "looping a specific number of times in for loops";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python repr";
        url = "https://docs.python.org/3/library/functions.html#repr";
        description = "a function from the builtins module for getting "
                + "printable representation of an object";
        termToIndexTerm.put(name, new IndexTerm(description, url));
                
        name = "Python Requests";
        url = "https://requests.readthedocs.io/";
        description = "a third party HTTP library for Python";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python set";
        url = "https://docs.python.org/3/library/stdtypes.html#set";
        description = "an unordered collection of distinct hashable objects. "
                + "A hashable object has a hash value which must be the same "
                + "for objects regarded as equal";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python str";
        url = "https://docs.python.org/3/library/functions.html#func-str";
        description = "a function from the builtins module for creating Strings";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python string";
        url = "https://docs.python.org/3/library/stdtypes.html#textseq";
        description = "a standard type and immutable sequence of Unicode code "
                + "points";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python SyntaxError";
        url = "https://docs.python.org/3/library/exceptions.html#SyntaxError";
        description = "an exception raised when the parser encounters a "
                + "syntax error";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python sys";
        url = "https://docs.python.org/3/library/sys.html";
        description = "a standard library module that provides access "
                + "to some variables used or maintained by the interpreter and "
                + "to functions that interact strongly with the interpreter";
        termToIndexTerm.put(name, new IndexTerm(description, url));
                      
        name = "Python time";
        url = "https://docs.python.org/3/library/time.html";
        description = "a standard library module providing various "
                + "time-related functions";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python tkinter";
        url = "https://docs.python.org/3/library/tkinter.html";
        description = "a standard library module providing an interface to the "
                + "Tcl/Tk GUI toolkit";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python tk";
        url = "https://docs.python.org/3/library/tk.html";
        description = "documentation for about developing Graphical User "
                + "Interfaces with Tk";
        termToIndexTerm.put(name, new IndexTerm(description, url));
                      
        name = "Python try";
        url = "https://docs.python.org/3/reference/compound_stmts.html#try";
        description = "a statement specifies exception handlers and/or cleanup "
                + "code for a code block";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python tuple";
        url = "https://docs.python.org/3/library/stdtypes.html#tuples";
        description = "an immutable sequences, typically used to store "
                + "collections of heterogeneous data";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python type";
        url = "https://docs.python.org/3/library/functions.html#type";
        description = "a function from the builtins module for getting the type "
                + "of an identifier";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python TypeError";
        url = "https://docs.python.org/3/library/exceptions.html#TypeError";
        description = "an excpetion raised when an operation or function is "
                + "applied to an object of inappropriate type";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Python venv";
        url = "https://docs.python.org/3/library/venv.html";
        description = "a standard library module that supports creating "
                + "lightweight \"virtual environments\", each with their own "
                + "independent set of Python packages installed in their site "
                + "directories";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Python while";
        url = "https://docs.python.org/3/reference/compound_stmts.html#while";
        description = "a compound statement used for repeated execution as "
                + "long as an expression evaluates as true";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Python zip";
        url = "https://docs.python.org/3/library/functions.html#zip";
        description = "a built-in function that iterates over multiple "
                + "iterables in parallel, producing tuples with an item from "
                + "each one";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Python ZeroDivisionError";
        url = "https://docs.python.org/3/library/exceptions.html#ZeroDivisionError";
        description = "an exception raised when the second argument of a "
                + "division or modulo operation is zero";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "REPL";
        url = getWikipediaURL("Read%E2%80%93eval%E2%80%93print_loop");
        description = "a Read Evaluate Print Loop also termed an interactive "
                + "toplevel or language shell, a simple interactive computer "
                + "programming environment that takes single user inputs, "
                + "executes them, and returns the result to the user";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Reproducibility";
        url = getWikipediaURL("Reproducibility");
        description = "in computational sciences means any results should be "
                + "documented by making all data and code available in such a "
                + "way that the computations can be executed again with "
                + "identical results";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Scope";
        url = getWikipediaURL("Scope_(computer_science)");
        description = "the part of a program where a name binding is valid";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Single-precision Floating-point";
        url = getWikipediaURL("Single-precision_floating-point_format");
        description = " a computer number format, usually occupying 32 bits in "
                + "computer memory";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Software";
        url = getWikipediaURL("Software");
        description = "computer programs and associated documentation and data";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Software Bug";
        url = getWikipediaURL("Software_bug");
        description = "an error, flaw or fault in the design, development, or "
                + "operation of computer software that causes it to produce an "
                + "incorrect or unexpected result, or to behave in unintended "
                + "ways";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "Source Code";
        url = getWikipediaURL("Source_code");
        description = "text written using a human-readable programming "
                + "language";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Syntax Error";
        url = getWikipediaURL("Syntax_error");
        description = "an error in the syntax of a sequence of characters or"
                + " tokens that is intended to be written in a particular"
                + " programming language";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "TCP/IP";
        url = getWikipediaURL("Internet_protocol_suite");
        description = "a framework for organizing the set of communication "
                + "protocols used in the Internet and similar computer "
                + "networks according to functional criteria";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Touchscreen";
        url = getWikipediaURL("Touchscreen");
        description = " both an input ('touch panel') and output ('display') "
                + "device)";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Unicode";
        url = getWikipediaURL("Unicode");
        description = "an information technology standard for the consistent "
                + "encoding, representation, and handling of text expressed in "
                + "most of the world's writing systems";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "URL";
        url = getWikipediaURL("URL");
        description = "Uniform Resource Locator - a reference to a Web "
                + "resource that specifies its location and the protocol for "
                + "retrieving it";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Variable";
        url = getWikipediaURL("Variable_(computer_science)");
        description = "the order in which individual statements, instructions "
                + "or function calls of an imperative program are executed or "
                + "evaluated";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Version Control";
        url = getWikipediaURL("Version_control");
        description = "(also known as revision control, source control, or "
                + "source code management) is a class of systems responsible "
                + "for managing changes to computer programs, documents, large "
                + "web sites, or other collections of information.";
        termToIndexTerm.put(name, new IndexTerm(description, url));

        name = "Web Accessibility";
        url = getWikipediaURL("Web_accessibility");
        description = "the inclusive practice of ensuring there are no "
                + "barriers that prevent interaction with, or access to, "
                + "websites on the World Wide Web by people with physical "
                + "disabilities, situational disabilities, and socio-economic "
                + "restrictions on bandwidth and speed";
        termToIndexTerm.put(name, new IndexTerm(description, url));
        
        name = "World Wide Web";
        url = getWikipediaURL("World_Wide_Web");
        description = "commonly known as the Web, is an information system "
                + "enabling documents and other web resources to be accessed "
                + "over the Internet";
        termToIndexTerm.put(name, new IndexTerm(description, url));
                
        name = "While Loop";
        url = getWikipediaURL("While_loop");
        description = "a control flow statement that allows code to be "
                + "executed repeatedly until a condition evaluates as false";
        termToIndexTerm.put(name, new IndexTerm(description, url));
                
        name = "XML";
        url = getWikipediaURL("XML");
        description = "a markup language and file format for storing, "
                + "transmitting, and reconstructing arbitrary data";
        termToIndexTerm.put(name, new IndexTerm(description, url));
    }

    /**
     * @return "https://en.wikipedia.org/wiki/" + articleName
     */
    public String getWikipediaURL(String articleName) {
        return "https://en.wikipedia.org/wiki/" + articleName;
    }

    /**
     * Adds a reference to the appropriate course collections and returns a link
     * to use in a WebPage.
     *
     * @param name The name for the reference.
     * @param linkText The text for the link.
     * @param url The url of the reference.
     * @param description The description of the reference.
     * @return A link.
     */
    public String addWebReference(String name, String linkText,
            String url, String description) {
        if (!c.references.nameToTerm.containsKey(name)) {
            c.references.nameToTerm.put(name,
                    new IndexTerm(description, url));
        }
        return Web_ContentWriter.getLink(url, linkText);
    }

    /**
     * @param name The name of the reference to get a link from.
     * @return the link for the reference given by name.
     */
    public String getReference(String name) {
        return getReference(name, name);
    }

    /**
     * @param name The name of the reference to get a link from.
     * @param linkText The link text for the link.
     * @return the link for the reference given by name.
     */
    public String getReference(String name, String linkText) {
        return getReference(name, linkText, null);
    }

    /**
     * @param name The name of the reference to get a link from.
     * @param sid The SectionID where the term is used.
     * @return the link for the reference given by name.
     */
    public String getReference(String name, SectionID sid) {
        return getReference(name, name, sid);
    }

    /**
     * @param name The name of the reference to get a link from.
     * @param linkText The link text for the link.
     * @param sid The SectionID where the term is used.
     * @return the link for the reference given by name.
     */
    public String getReference(String name, String linkText, SectionID sid) {
        IndexTerm r = termToIndexTerm.get(name);
        if (sid != null) {
            r.sids.add(sid);
        }
        return r.getLink(linkText);
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("<ul>");
        for (String name : termToIndexTerm.keySet()) {
            IndexTerm r = termToIndexTerm.get(name);
            StringBuilder sb = new StringBuilder();
            sb.append("<li>");
            sb.append(r.getLinkAndDescription(name));
            sb.append(".");
            if (!r.sids.isEmpty()) {
                sb.append(" (");
                int l = sb.length();
                for (SectionID s : r.sids) {
                    sb.append(s.getLink());
                    sb.append(", ");
                }
                // Remove the last delimiter
                if (sb.length() > l) {
                    sb.setLength(sb.length() - 2);
                }
                sb.append(")");
            }
            sb.append("</li>");
            w.add(sb.toString());
        }
        w.add("</ul>");
        w.add("</div>");

    }

}
