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

import io.github.agdturner.core.Environment;
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
        String term; // The term.
        String url;  // The URL.
        String desc; // A description.
        IndexTerm indexTerm;

        term = "Anaconda";
        url = "https://www.anaconda.com/";
        desc = "A data science platform.";
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Beautiful Soup";
        url = "https://beautiful-soup-4.readthedocs.io/";
        desc
                = """
                A "Python" library for pulling data out of "HTML" and "XML"
                files.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Conda";
        url = "https://docs.conda.io/";
        desc
                = """
                An "open source" "package" management system and environment
                management system.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "CPython";
        url = Environment.getWikipediaURL(term);
        desc
                = """
                The reference implementation of "Python". Written in "C" and
                Python, CPython is the default and most widely used Python
                implementation. It is both a "compiler" and "interpreter".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "IDLE";
        url = PythonIndex.getPythonDocsLibraryURL("idle.html");
        desc
                = """
                An "Integrated Development Environment" and learning
                environment distributed with "Python".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Jupyter Notebook";
        url = "https://en.wikipedia.org/wiki/Project_Jupyter#Jupyter_Notebook";
        desc = """
                      Jupyter Notebook can colloquially refer to two different
                      concepts, either the user-facing application to edit
                      code and text, or the underlying "file format" which is
                      interoperable across many implementations.
                      """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "PIP";
        url = "https://pip.pypa.io";
        desc
                = """
                The "Python" "package" installer.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(url, indexTerm);

        term = "Python Package Index";
        url = "https://pypi.org/";
        desc
                = """
                A repository of "Python" "software".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "PyPI", indexTerm);
        addAliasAndAliasLowerCase(term, "PyPi", indexTerm);

        term = "PyQGIS";
        url = "https://qgis.org/pyqgis/";
        desc
                = """
                "QGIS" "Python" "API".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "PyQGIS Developer Cookbook";
        url = "https://docs.qgis.org/latest/en/docs/pygqis_developer_cookbook/";
        desc
                = """
                A tutorial and a reference guide for "PyQGIS".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Pytest";
        url = "https://docs.pytest.org/";
        desc = """
               A "Python" "unit testing" framework.
               """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);
        addAliasLowerCase(term, indexTerm);

        term = "Python array";
        url = getPythonDocsLibraryURL("array.html");
        desc = """
               A "Python Standard Library" module that defines an "array" -
               an object type which can compactly represent a sequence of
               values all of the same type. It behaves like a "list", except
               that the type of objects stored in them is restricted.
               """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);

        term = "Python BaseException";
        url = getPythonDocsLibraryURL("exceptions.html#BaseException");
        desc = """
                The base class for all "Python built-in exceptions".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python break";
        url = getPythonDocsReferenceURL("simple_stmts.html#break");
        desc = """
               A "keyword" that terminates the nearest enclosing loop,
               skipping the optional 'else' clause if the loop has one.
               """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python builtins";
        url = getPythonDocsLibraryURL("builtins.html");
        desc = """
               An always loaded "Python module" that provides direct access
               to all 'built-in' identifiers.
               """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Builtins module", indexTerm);

        term = "Python built-in constant";
        url = getPythonDocsLibraryURL("constants.html#built-in-consts");
        desc = """
                "Python" "value" that is always available.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Built-in constant", indexTerm);

        term = "Python built-in exception";
        url = getPythonDocsLibraryURL("exceptions.html");
        desc = """
                "Error messages" generated by a "Python" "interpreter" or a
                "built-in function" when an error is encountered.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Built-in exception", indexTerm);

        term = "Python built-in function";
        url = getPythonDocsLibraryURL("functions.html#built-in-funcs");
        desc = "Functions and types that are always available.";
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Built-in function", indexTerm);

        term = "Python built-in type";
        url = getPythonDocsLibraryURL("stdtypes.html");
        desc = """
                "Python Standard Library" numerics, sequences, mappings,
                classes, instances and exceptions that are 'built-in' to the
                "Python interpreter".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Built-in type", indexTerm);

        term = "Python byte";
        url = getPythonDocsLibraryURL("stdtypes.html#bytes");
        desc = """
                A "Python" container storing an immutable sequence of
                "integers" in the range [0, 255].
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);

        term = "Python bytearray";
        url = getPythonDocsLibraryURL("stdtypes.html#bytearray");
        desc = """
                A mutable counterpart of a "Python byte".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);

        term = "Python class";
        url = PYTHON_DOCS_URL_TUTORIAL + "classes.html";
        desc = """
                A "Python" "class" - a bundle of "data" and/or "functionality".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "Python classes", indexTerm);

        term = "Python compound statement";
        url = getPythonDocsReferenceURL("compound_stmts.html");
        desc = """
                Grouped "Python" "statements" that affect or control the
                execution of those statements. (See also: "Python if"; "Python try", "Python while")
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);

        term = "Python continue";
        url = getPythonDocsReferenceURL("simple_stmts.html#continue");
        desc = """
                A "Python keyword" that continues with the next cycle of the
                nearest enclosing loop. When 'continue' passes control out of
                a "try" statement with a 'finally' clause, that finally clause
                is executed before starting the next loop cycle.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python csv";
        url = getPythonDocsReferenceURL("simple_stmts.html#continue");
        desc = """
                A "Python Standard Library" module for handling data in a "CSV"
                "file format".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python decimal";
        url = getPythonDocsLibraryURL("decimal.html");
        desc
                = """
                A "Python Standard Library" module providing support for fast
                correctly rounded decimal "floating point arithmetic".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python delimiter";
        url = getPythonDocsReferenceURL("lexical_analysis.html#delimiters");
        desc
                = """
                A "string" that separates parts.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);

        term = "Python dict";
        url = getPythonDocsLibraryURL("stdtypes.html#dict");
        desc
                = """
                A mapping object that maps unique keys to "values".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python dir";
        url = getPythonDocsLibraryURL("functions.html#dir");
        desc
                = """
                A "Python" "function" that: without arguments, returns the list
                of names in the current local scope; and, with an argument,
                attempts to return a list of valid attributes for that
                "object".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python docstring";
        url = "https://peps.python.org/pep-0257/#what-is-a-docstring";
        desc
                = """
                A "Python" string literal comment that occurs as the first
                statement in a module, function, class, or method definition.
                This becomes the '__doc__' attribute of that object.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);

        term = "Python doctest";
        url = getPythonDocsLibraryURL("doctest.html");
        desc
                = """
                A "Python Standard Library" module that can be used to search for
                text that looks like interactive Python sessions, and then
                executes those sessions to verify that they work as shown.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python for";
        url = getPythonDocsReferenceURL("compound_stmts.html#for");
        desc
                = """
                A "Python" "for loop" used to iterate over the elements of a
                "Python sequence".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasAndAliasPlural(term, "Python for loop", indexTerm);

        term = "Python fractions";
        url = getPythonDocsLibraryURL("fractions.html");
        desc
                = """
                A "Python Standard Library" module providing support for
                "rational number" arithmetic.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python help";
        url = getPythonDocsLibraryURL("functions.html#help");
        desc
                = """
                A "Python" "function" that starts the help system.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python if";
        url = getPythonDocsReferenceURL("compound_stmts.html#if");
        desc
                = """
                A "conditional" "Python compound statement" effecting
                execution "control flow".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python input";
        url = getPythonDocsLibraryURL("functions.html#input");
        desc
                = """
                A "builtins module" function that reads a line from standard
                input, converts it to a "string" (stripping the trailing
                newline), and returns that string.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python import";
        url = getPythonDocsReferenceURL("simple_stmts.html#import");
        desc = "A statement for importing modules.";
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python interpreter";
        url = getPythonDocsTutorialURL("interpreter.html");
        desc
                = """
                An "interpreter" for "Python" "source code".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python io";
        url = getPythonDocsLibraryURL("io.html");
        desc
                = """
                A "Python Standard Library" module the provides the main
                facilities for dealing with various types of input and output.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python json";
        url = getPythonDocsLibraryURL("json.html");
        desc
                = """
                A "Python Standard Library" module for handling data in
                "JSON" format.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python keyword";
        url = getPythonDocsReferenceURL("lexical_analysis.html#keywords");
        desc
                = """
                A reserved word that cannot be used as an ordinary identifier
                (i.e. names of: variables, functions, classes, modules or
                packages).
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "keyword", indexTerm);

        term = "Python lambda";
        url = getPythonDocsReferenceURL("expressions.html#lambda");
        desc = "An expression used to create anonymous functions.";
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python len";
        url = getPythonDocsLibraryURL("functions.html#len");
        desc = "A function for getting the length (the number of items) "
                + "of an object";
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python list";
        url = getPythonDocsLibraryURL("stdtypes.html#lists");
        desc
                = """
                A mutable sequence of items.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "List", indexTerm);

        term = "Python match";
        url = getPythonDocsReferenceURL("compound_stmts.html#the-match-statement");
        desc = "A statement used for pattern matching.";
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python math";
        url = getPythonDocsReferenceURL("math.html");
        desc
                = """
                A "Python Standard Library" module providing access to the
                mathematical functions defined by the "C Standard".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python MemoryError";
        url = getPythonDocsLibraryURL("exceptions.html#MemoryError");
        desc
                = """
                A "built-in exception" raised when an operation runs out of
                "memory" but the situation may still be rescued (by freeing
                up memory).
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);

        term = "Python module";
        url = PYTHON_DOCS_URL_TUTORIAL + "modules.html";
        desc = "A file containing Python definitions and statements.";
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Module", indexTerm);

        term = "Python Module Index";
        url = PYTHON_DOCS_URL + "py-modindex.html";
        desc
                = """
                An index of "Python Standard Library" "modules".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermLowerCase(term, indexTerm);

        term = "Python NameError";
        url = getPythonDocsLibraryURL("exceptions.html#NameError");
        desc
                = """
                A "Python built-in exception" raised when a local or global
                name is not found.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python Numeric Type";
        url = getPythonDocsLibraryURL(
                "stdtypes.html#numeric-types-int-float-complex");
        desc
                = """
                A generic "Python Standard Library" type for some numbers
                (including "integers", "floating point" numbers, and complex
                numbers).
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPluralAndAliasAndAliasPluralTermLowerCase(term, indexTerm);
        
        term = "Python open";
        url = getPythonDocsLibraryURL("functions.html#open");
        desc
                = """
                A "Python builtins" module function to open a file and return
                a corresponding file object.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python operator";
        url = getPythonDocsLibraryURL("operator.html");
        desc
                = """
                A "Python Standard Library" module that exports a set of
                functions corresponding to the intrinsic operators of "Python".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python print";
        url = getPythonDocsLibraryURL("functions.html#print");
        desc
                = """
                A "Python builtins" module function for printing to the screen.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python packages";
        url = getPythonDocsTutorialURL("modules.html#packages");
        desc = "A way of structuring using 'dotted module names'.";
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python pydoc";
        url = getPythonDocsLibraryURL("pydoc.html");
        desc
                = """
                A "Python Standard Library" module that automatically
                generates documentation from "Python modules". The
                documentation can be presented as pages of text on the
                console, served to a "Web browser", or saved to "HTML" files.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);
        addAliasAndAliasLowerCase(term, "Pydoc", indexTerm);

        term = "Python random";
        url = getPythonDocsLibraryURL("random.html");
        desc
                = """
                A "Python Standard Library" module that implements
                pseudo-random number generators.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python range";
        url = getPythonDocsLibraryURL("stdtypes.html#ranges");
        desc
                = """
                An immutable sequence of numbers, commonly used for looping a
                specific number of times in "Python for loops".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Range", indexTerm);

        term = "Python repr";
        url = getPythonDocsLibraryURL("functions.html#repr");
        desc
                = """
                A "Python builtins" function for getting printable
                representation of an object.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python Requests";
        url = "https://requests.readthedocs.io/";
        desc = "A third party HTTP library for Python";
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python sequence";
        url = getPythonDocsLibraryURL("stdtypes.html#sequence-types-list-tuple-range");
        desc
                = """
                There are three basic "Python" sequence types: "lists",
                "tuples", and "ranges". There are additional sequence types
                for processing of binary data and text strings.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python set";
        url = getPythonDocsLibraryURL("stdtypes.html#set");
        desc
                = """
                An unordered collection of distinct hashable objects. A
                hashable object has a hash value which must be the same for
                objects regarded as being equal.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python Standard Library";
        url = getPythonDocsLibraryURL("");
        desc
                = """
                The functionality included in "Python" distributions as
                standard (and the reference manual).
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "standard library", indexTerm);

        term = "Python str";
        url = getPythonDocsLibraryURL("functions.html#func-str");
        desc = """
                      A "builtins module" function for creating a "string".
                      """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python string";
        url = getPythonDocsLibraryURL("stdtypes.html#textseq");
        desc
                = """
                A standard type and immutable sequence of "Unicode" code points.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);

        term = "Python SyntaxError";
        url = getPythonDocsLibraryURL("exceptions.html#SyntaxError");
        desc
                = """
                A "Python built-in exception" raised when a "syntax error"  is
                encountered.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python sys";
        url = getPythonDocsLibraryURL("sys.html");
        desc
                = """
                A "Python Standard Library" module that provides access to
                "variables" used or maintained by the interpreter and to
                functions that interact strongly with the interpreter.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python SystemError";
        url = getPythonDocsLibraryURL("exceptions.html#SystemError");
        desc
                = """
                A "Python built-in exception" raised when an internal is
                encountered.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python time";
        url = getPythonDocsLibraryURL("time.html");
        desc
                = """
                A "Python Standard Library" module providing various
                time-related functions.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python tk";
        url = getPythonDocsLibraryURL("tk.html");
        desc
                = """
                A Python library for developing "Graphical User Interfaces"
                with "tkinter".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python tkinter";
        url = getPythonDocsLibraryURL("tkinter.html");
        desc
                = """
                A "Python Standard Library" module providing an interface to
                the Tcl/Tk "Graphical User Interfaces" toolkit.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "tkinter", indexTerm);

        term = "Python try";
        url = getPythonDocsReferenceURL("compound_stmts.html#try");
        desc
                = """
                A "Python compound statement" that specifies exception
                handlers and/or cleanup code.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);
        addAlias(term, "try", indexTerm);

        term = "Python tuple";
        url = getPythonDocsLibraryURL("stdtypes.html#tuples");
        desc
                = """
                An immutable "Python sequence" of heterogeneous or homogenous
                data.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTermAndAliasTermPlural(term, indexTerm);
        addAliasAndAliasPluralAndAliasAndAliasPluralLowerCase(term, "Tuple", indexTerm);

        term = "Python type";
        url = getPythonDocsLibraryURL("functions.html#type");
        desc
                = """
                A "Python builtins" module function for getting the type
                of something from its identifier.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python TypeError";
        url = getPythonDocsLibraryURL("exceptions.html#TypeError");
        desc
                = """
                A "Python built-in exception" raised when an operation or function is
                applied to an object of inappropriate type.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python unittest";
        url = getPythonDocsLibraryURL("unittest.html");
        desc
                = """
                A "Python Standard Library" module providing tools for
                constructing and running "unit tests".
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python venv";
        url = getPythonDocsLibraryURL("venv.html");
        desc
                = """
                A "Python Standard Library" module that supports creating
                lightweight Python 'virtual environments' - a Python
                environment with only specified "Python packages" installed.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python while";
        url = getPythonDocsReferenceURL("compound_stmts.html#while");
        desc
                = """
                A "Python compound statement" used for repeated execution as
                long as an expression evaluates as true.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python yield";
        url = getPythonDocsReferenceURL("simple_stmts.html#yield");
        desc
                = """
                A "Python keyword" used in a statement or expression that
                returns something from a function whilst allowing further
                expressions in the function to be evaluated.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python zip";
        url = getPythonDocsLibraryURL("functions.html#zip");
        desc
                = """
                A "Python builtins" module function that iterates over
                multiple iterables in parallel, producing "tuples" with an
                item from each one.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Python ZeroDivisionError";
        url = getPythonDocsLibraryURL("exceptions.html#ZeroDivisionError");
        desc
                = """
                A "Python built-in exception" raised when the second argument
                of a division or modulo operation is zero.
                """;
        indexTerm = new IndexTerm(this, desc, url);
        addIndexTerm(term, indexTerm);

        term = "Sphinx";
        url = "https://www.sphinx-doc.org/";
        desc = "A tool for creating documentation.";
        indexTerm = new IndexTerm(this, desc, url);
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
