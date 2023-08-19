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
package io.github.agdturner.course.coding.python;

import io.github.agdturner.course.Course;
import io.github.agdturner.course.Index;
import io.github.agdturner.course.IndexTerm;

/**
 * Python Index Course Page.
 *
 * @author Andy Turner
 */
public class PythonIndex extends Index {

    /**
     * A constant storing the Python 3 Documentation URL as a String.
     */
    public final static String PYTHON_DOCS_URL = "https://docs.python.org/3/";

    /**
     * A constant storing the Python 3 Documentation tutorial URL as a String.
     */
    public final static String PYTHON_DOCS_URL_TUTORIAL = PYTHON_DOCS_URL + "tutorial/";
    
    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     */
    public PythonIndex(Course course, String filename, String title, String label) {
        super(course, filename, title, label);
        String term;
        String url;
        String description;
        IndexTerm indexTerm;

        
        term = "Anaconda";
        url = "https://www.anaconda.com/";
        description = "a data science platform";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "Beautiful Soup";
        url = "https://beautiful-soup-4.readthedocs.io/";
        description = """
                      A "Python" library for pulling data out of "HTML" and
                      "XML" files
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Conda";
        url = "https://docs.conda.io/";
        description = "an open source package management system and "
                + "environment management system";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "IDLE";
        url = PythonIndex.getPythonDocsLibraryURL("idle.html");
        description = "an Integrated Development and Learning Environment "
                + "distributed with Python";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "PIP";
        url = "https://pip.pypa.io";
        description = "The Package Installer for \"Python\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addLowerCaseAlias(url, indexTerm);

        term = "Python Package Index";
        url = "https://pypi.org/";
        description = "A repository of software for the Python programming "
                + "language.";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAliasAndLowerCase(term, "PyPi", indexTerm);

        term = "PyQGIS";
        url = "https://qgis.org/pyqgis/";
        description = "QGIS Python API";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "PyQGIS Developer Cookbook";
        url = "https://docs.qgis.org/latest/en/docs/pygqis_developer_cookbook/";
        description = "A tutorial and a reference guide to the PyQGIS API";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python array";
        url = getPythonDocsLibraryURL("array.html");
        description = "A \"standard library\" module that defines an object "
                + "type which can compactly represent a sequence of values all "
                + "of the same type. An array behaves like a \"list\", except "
                + "that the type of objects stored in them is "
                + "restricted/constrained";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python BaseException";
        url = getPythonDocsLibraryURL("exceptions.html#BaseException");
        description = "The base class for all \"Python Built-in Exceptions\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "Python break";
        url = getPythonDocsReferenceURL("simple_stmts.html#break");
        description = "A \"keyword\" that terminates the nearest enclosing "
                + "loop, skipping the optional 'else' clause if the loop has "
                + "one";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python builtins";
        url = getPythonDocsLibraryURL("builtins.html");
        description = "An always loaded module that provides direct access to "
                + "all 'built-in' identifiers";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "builtins module", indexTerm);

        term = "Python Built-in Constants";
        url = getPythonDocsLibraryURL("constants.html#built-in-consts");
        description = "Constants that are always available";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "built-in constant", indexTerm);

        term = "Python Built-in Exceptions";
        url = getPythonDocsLibraryURL("exceptions.html");
        description = "Are generated by the interpreter or a \"built-in "
                + "function\" when an error is encountered";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "built-in exception", indexTerm);

        term = "Python Built-in Functions";
        url = getPythonDocsLibraryURL("functions.html#built-in-funcs");
        description = "Functions and types that are always available";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "built-in function", indexTerm);

        term = "Python Built-in Types";
        url = getPythonDocsLibraryURL("stdtypes.html");
        description = "A \"Standard library\" numerics, sequences, mappings, "
                + "classes, instances and exceptions that are 'built-in' to "
                + "the interpreter";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "built-in type", indexTerm);

        term = "Python continue";
        url = getPythonDocsReferenceURL("simple_stmts.html#continue");
        description = "A \"keyword\" that continues with the next cycle of the "
                + "nearest enclosing loop. When continue passes control out of "
                + "a \"try\" statement with a 'finally' clause, that finally "
                + "clause is executed before starting the next loop cycle";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python csv";
        url = getPythonDocsReferenceURL("simple_stmts.html#continue");
        description = "A \"standard library\" module for handling data in a "
                + "\"CSV file format\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python decimal";
        url = getPythonDocsLibraryURL("decimal.html");
        description = "A \"standard library\" module providing support for "
                + "fast correctly rounded decimal floating point arithmetic";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python delimiters";
        url = getPythonDocsReferenceURL("lexical_analysis.html#delimiters");
        description = "A \"string\" that separates parts";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python dict";
        url = getPythonDocsLibraryURL("stdtypes.html#dict");
        description = "A mapping object that maps unique keys to values";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python docstring";
        url = "https://peps.python.org/pep-0257/#what-is-a-docstring";
        description = "A string literal comment that occurs as the first "
                + "statement in a module, function, class, or method "
                + "definition. This becomes the '__doc__' attribute of "
                + "that object";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python bytes";
        url = getPythonDocsLibraryURL("stdtypes.html#bytes");
        description = "A container storing an immutable sequence of integers "
                + "in the range [0, 255]";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python bytearray";
        url = getPythonDocsLibraryURL("stdtypes.html#bytearray");
        description = "A mutable counterpart to a \"Python byte\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python classes";
        url = PYTHON_DOCS_URL_TUTORIAL + "classes.html";
        description = "\"Classes\" provide a means of bundling data and "
                + "functionality together";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "Python dir";
        url = getPythonDocsLibraryURL("functions.html#dir");
        description = "A function that: without arguments, returns the list of "
                + "names in the current local scope; and, with an argument, "
                + "attempts to return a list of valid attributes for that "
                + "object";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python doctest";
        url = getPythonDocsLibraryURL("doctest.html");
        description = "A \"standard library\" module that can be used to "
                + "search for text that looks like interactive Python "
                + "sessions, and then executes those sessions to verify "
                + "that they work as shown";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python for";
        url = getPythonDocsReferenceURL("compound_stmts.html#for");
        description = "Used to iterate over the elements of a sequence";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python fractions";
        url = getPythonDocsLibraryURL("fractions.html");
        description = "A \"standard library\" module providing support for "
                + "rational number arithmetic";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python help";
        url = getPythonDocsLibraryURL("functions.html#help");
        description = "A function that starts the help system";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python if";
        url = getPythonDocsReferenceURL("compound_stmts.html#if");
        description = "A compound statement used for conditional execution";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python input";
        url = getPythonDocsLibraryURL("functions.html#input");
        description = "A \"builtins module\" function that reads a line from "
                + "standard input, converts it to a \"string\" (stripping the "
                + "trailing newline), and returns that string";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python import";
        url = getPythonDocsReferenceURL("simple_stmts.html#import");
        description = "A statement for importing modules";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python io";
        url = getPythonDocsLibraryURL("io.html");
        description = "A \"standard library\" module the provides the main "
                + "facilities for dealing with various types of input and "
                + "output";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python json";
        url = getPythonDocsLibraryURL("json.html");
        description = "A \"standard library\" module for handling data in "
                + "\"JSON\" format";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python keyword";
        url = getPythonDocsReferenceURL("lexical_analysis.html#keywords");
        description = "A reserved word that cannot be used as an "
                + "ordinary identifier (names of variable, function, class, "
                + "module or package)";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "keyword", indexTerm);

        term = "Python lambda";
        url = getPythonDocsReferenceURL("expressions.html#lambda");
        description = "An expression used to create anonymous functions";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python len";
        url = getPythonDocsLibraryURL("functions.html#len");
        description = "A function for getting the length (the number of items) "
                + "of an object";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python list";
        url = getPythonDocsLibraryURL("stdtypes.html#lists");
        description = "A mutable sequence, typically used to store collections "
                + "of homogeneous items";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "list", indexTerm);

        term = "Python match";
        url = getPythonDocsReferenceURL("compound_stmts.html#the-match-statement");
        description = "A statement used for pattern matching";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python math";
        url = getPythonDocsReferenceURL("math.html");
        description = "A \"standard library\" module providing access to the "
                + "mathematical functions defined by the \"C Standard\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python MemoryError";
        url = getPythonDocsLibraryURL("exceptions.html#MemoryError");
        description = "A \"built-in exception\" raised when an operation runs "
                + "out of \"memory\" but the situation may still be rescued "
                + "(by freeing up memory)";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python modules";
        url = PYTHON_DOCS_URL_TUTORIAL + "modules.html";
        description = "A file containing Python definitions and statements.";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        
        term = "Python Module Index";
        url = PYTHON_DOCS_URL + "py-modindex.html";
        description = "An index of \"standard library\" modules";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python NameError";
        url = getPythonDocsLibraryURL("exceptions.html#NameError");
        description = "A \"built-in exception\" raised when a local or global "
                + "name is not found";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python Numeric Types";
        url = getPythonDocsLibraryURL(
                "stdtypes.html#numeric-types-int-float-complex");
        description = "Three distinct types: integers, floating point numbers, "
                + "and complex numbers";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python open";
        url = getPythonDocsLibraryURL("functions.html#open");
        description = "A \"builtins module\" function to open a file and "
                + "return a corresponding file object";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python operator";
        url = getPythonDocsLibraryURL("operator.html");
        description = "A \"standard library\" module that exports a set of "
                + "functions corresponding to the intrinsic operators of "
                + "Python";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python print";
        url = getPythonDocsLibraryURL("functions.html#print");
        description = "A \"builtins module\" function for printing to the "
                + "screen";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python packages";
        url = getPythonDocsTutorialURL("modules.html#packages");
        description = "A way of structuring using 'dotted module names'.";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python random";
        url = getPythonDocsLibraryURL("random.html");
        description = "A \"standard library\" module that implements pseudo-random "
                + "number generators for various distributions";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python range";
        url = getPythonDocsLibraryURL("stdtypes.html#ranges");
        description = "An immutable sequence of numbers, commonly used for "
                + "looping a specific number of times in for loops";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python repr";
        url = getPythonDocsLibraryURL("functions.html#repr");
        description = "A \"builtins module\" function for getting "
                + "printable representation of an object";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python Requests";
        url = "https://requests.readthedocs.io/";
        description = "A third party HTTP library for Python";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python set";
        url = getPythonDocsLibraryURL("stdtypes.html#set");
        description = "An unordered collection of distinct hashable objects. "
                + "A hashable object has a hash value which must be the same "
                + "for objects regarded as equal";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python Standard Library";
        url = getPythonDocsLibraryURL("");
        description = "The functionality that is included in Python "
                + "distributions as standard (and it's reference manual)";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "standard library", indexTerm);

        term = "Python str";
        url = getPythonDocsLibraryURL("functions.html#func-str");
        description = """
                      A "builtins module" function for creating a "string"
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python string";
        url = getPythonDocsLibraryURL("stdtypes.html#textseq");
        description = """
                      A standard type and immutable sequence of "Unicode" code
                      points
                      """;
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "string", indexTerm);

        term = "Python SyntaxError";
        url = getPythonDocsLibraryURL("exceptions.html#SyntaxError");
        description = "A \"built-in exception\" raised when the parser encounters a "
                + "\"syntax error\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python sys";
        url = getPythonDocsLibraryURL("sys.html");
        description = "A \"standard library\" module that provides access "
                + "to some variables used or maintained by the interpreter and "
                + "to functions that interact strongly with the interpreter";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python SystemError";
        url = getPythonDocsLibraryURL("exceptions.html#SystemError");
        description = "A \"built-in exception\" raised when the interpreter "
                + "encounters an internal error";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python time";
        url = getPythonDocsLibraryURL("time.html");
        description = "A \"standard library\" module providing various "
                + "time-related functions";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python tk";
        url = getPythonDocsLibraryURL("tk.html");
        description = "A library for developing \"GUIs\" with \"tkinter\"";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python tkinter";
        url = getPythonDocsLibraryURL("tkinter.html");
        description = "A \"standard library\" module providing an interface to "
                + "the Tcl/Tk \"GUI\" toolkit";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "tkinter", indexTerm);

        term = "Python try";
        url = getPythonDocsReferenceURL("compound_stmts.html#try");
        description = "A statement specifies exception handlers and/or cleanup "
                + "code for a code block";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "try", indexTerm);

        term = "Python tuple";
        url = getPythonDocsLibraryURL("stdtypes.html#tuples");
        description = "An immutable sequences, typically used to store "
                + "collections of heterogeneous data";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python type";
        url = getPythonDocsLibraryURL("functions.html#type");
        description = "A \"builtins module\" function for getting the type "
                + "of an identifier";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python TypeError";
        url = getPythonDocsLibraryURL("exceptions.html#TypeError");
        description = "A \"built-in exception\" raised when an operation or "
                + "function is applied to an object of inappropriate type";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python unittest";
        url = getPythonDocsLibraryURL("unittest.html");
        description = "A \"standard library\" module providing tools for "
                + "constructing and running tests.";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python venv";
        url = getPythonDocsLibraryURL("venv.html");
        description = "A \"standard library\" module that supports creating "
                + "lightweight <a href=\"" + PYTHON_DOCS_URL 
                + "glossary.html#term-virtual-environment\">"
                + "virtual environments</a>, each with their own "
                + "independent set of \"Python packages\" installed in their "
                + "dsite irectories";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python while";
        url = getPythonDocsReferenceURL("compound_stmts.html#while");
        description = "A compound statement used for repeated execution as "
                + "long as an expression evaluates as true";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python yield";
        url = getPythonDocsReferenceURL("simple_stmts.html#yield");
        description = "A keyword used in a statement or expression that "
                + "returns something from a function whilst allowing further "
                + "expressions in the function to be evaluated";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python zip";
        url = getPythonDocsLibraryURL("functions.html#zip");
        description = "A \"builtins module\" function that iterates over "
                + "multiple iterables in parallel, producing tuples with an "
                + "item from each one";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);

        term = "Python ZeroDivisionError";
        url = getPythonDocsLibraryURL("exceptions.html#ZeroDivisionError");
        description = "A \"built-in exception\" raised when the second "
                + "argument of a division or modulo operation is zero";
        indexTerm = new IndexTerm(this, description, url);
        addIndexTerm(term, indexTerm);
    }

    /**
     * @param article Appended to complete the URL String.
     * @return {@link #PYTHON_DOCS_URL} + article;
     */
    public static final String getPythonDocsLibraryURL(String article) {
        return PYTHON_DOCS_URL + "library/" + article;
    }

    /**
     * @param article Appended to complete the URL String.
     * @return {@link #PYTHON_DOCS_URL} + article;
     */
    public static final String getPythonDocsReferenceURL(String article) {
        return PYTHON_DOCS_URL + "reference/" + article;
    }

    /**
     * @param article Appended to complete the URL String.
     * @return {@link #PYTHON_DOCS_URL} + article;
     */
    public static final String getPythonDocsTutorialURL(String article) {
        return PYTHON_DOCS_URL + "tutorial/" + article;
    }

}
