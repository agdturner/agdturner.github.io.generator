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
import io.github.agdturner.core.ReferenceID;
import java.util.HashMap;
import java.util.TreeMap;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * For course references pages.
 * 
 * @author Andy Turner
 */
public class References extends Page {
    
    /**
     * To look up Reference from a Reference Name. This is an ordered
     * collection for writing out References.
     */
    public TreeMap<String, Reference> referenceNameToReference;

    /**
     * Create a new instance.
     *
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     * @param c What {@code #c} is set to.
     */
    public References(String filename, String title, String label, Course c) {
        super(filename, title, label, c);
        referenceNameToReference = new TreeMap<>();
        
        String name;
        String url;
        String description;
        
        // Module Catalogue Page
        name = c.getCourseCode1() + " Module Catalogue Page";
        url = "https://webprod3.leeds.ac.uk/catalogue/dynmodules.asp?Y="
                + c.academicYear + "&M=" + c.getCourseCode2();
        description = null;
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Agent Based Model";
        url = getWikipediaURL("Agent-based_model");
        description = "a computational model for simulating the actions and "
                + "interactions of autonomous agents (both individual or "
                + "collective entities such as organizations or groups)";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Anaconda";
        url = "https://www.anaconda.com/";
        description = "a data science platform";
        referenceNameToReference.put(name, new Reference(url, description));
              
        name = "ASCII";
        url = getWikipediaURL("ASCII");
        description = "a character encoding standard for electronic "
                + "communication";
        referenceNameToReference.put(name, new Reference(url, description));

        name = "Backward Compatibility";
        url = getWikipediaURL("Backward_compatibility");
        description = "(sometimes known as backwards compatibility) is a "
                + "property of an operating system, product, or technology "
                + "that allows for interoperability with an older legacy "
                + "system";
        referenceNameToReference.put(name, new Reference(url, description));

        name = "Bit";
        url = getWikipediaURL("Bit");
        description = "the most basic unit of information in computing and"
                + " digital communications. A bit represents a logical state"
                + " having one of two possible values";
        referenceNameToReference.put(name, new Reference(url, description));

        name = "Byte";
        url = getWikipediaURL("Byte");
        description = "a unit of digital information that most commonly"
                + " consists of eight bits";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Class";
        url = getWikipediaURL("Class_(computer_programming)");
        description = "an extensible program-code-template for creating "
                + "objects, providing initial values for state (member "
                + "variables) and implementations of behavior (member "
                + "functions or methods)";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Command Line Interface";
        url = getWikipediaURL("Command-line_interface");
        description = "a command-line interpreter or command-line processor "
                + "uses a command-line interface (CLI) to receive commands "
                + "from a user in the form of lines of text. This provides a "
                + "means of setting parameters for the environment, invoking "
                + "executables and providing information to them as to what "
                + "actions they are to perform";
        referenceNameToReference.put(name, new Reference(url, description));
                      
        name = "Computer Programming";
        url = getWikipediaURL("Computer_programming");
        description = "the process of designing and building an executable "
                + "computer program";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Conda";
        url = "https://docs.conda.io/";
        description = "an open source package management system and "
                + "environment management system";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Conditional";
        url = getWikipediaURL("Conditional_(computer_programming)");
        description = "perform different computations or actions depending on "
                + "whether a programmer-defined boolean condition evaluates to "
                + "true or false";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Control Flow";
        url = getWikipediaURL("Control_flow");
        description = "a named container of data";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Double-precision Floating-point";
        url = getWikipediaURL("Double-precision_floating-point_format");
        description = " a computer number format, usually occupying 64 bits in "
                + "computer memory";
        referenceNameToReference.put(name, new Reference(url, description));
                
        name = "File Format";
        url = getWikipediaURL("File_format");
        description = "a standard way that information is encoded for storage "
                + "in a computer file";
        referenceNameToReference.put(name, new Reference(url, description));
                
        name = "File System";
        url = getWikipediaURL("File_system");
        description = "a method and data structure that a computer operating "
                + "system uses to control how data is stored and retrieved";
        referenceNameToReference.put(name, new Reference(url, description));
                
        name = "Floating-point";
        url = getWikipediaURL("Floating-point_arithmetic");
        description = " arithmetic that represents real numbers approximately, "
                + "using an integer with a fixed precision, called the "
                + "significand, scaled by an integer exponent of a fixed base";
        referenceNameToReference.put(name, new Reference(url, description));
                
        name = "For Loop";
        url = getWikipediaURL("For_loop");
        description = "runs a section of code repeatedly until a condition is "
                + "satisfied";
        referenceNameToReference.put(name, new Reference(url, description));
                
        name = "Free and Open Source Software";
        url = getWikipediaURL("Free_and_open-source_software");
        description = "software where anyone is freely licensed to use, copy, "
                + "study, and change the software in any way, and the source "
                + "code is openly shared";
        referenceNameToReference.put(name, new Reference(url, description));
                
        name = "Functional Programming";
        url = getWikipediaURL("Functional_programming");
        description = "a programming paradigm where programs are constructed "
                + "by applying and composing functions";
        referenceNameToReference.put(name, new Reference(url, description));
                
        name = "Functions";
        url = getWikipediaURL("Function_(computer_programming)");
        description = "a sequence of program instructions that performs a "
                + "specific task";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "GitHub";
        url = "https://github.com/";
        description = "an Internet hosting service for software development "
                + "and version control";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Graphical User Interface";
        url = getWikipediaURL("Graphical_user_interface");
        description = "a form of user interface that primarily uses actionable "
                + "graphical icons";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "HTML";
        url = getWikipediaURL("HTML");
        description = "the standard markup language for documents designed to "
                + "be displayed in a web browser";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Internet";
        url = getWikipediaURL("Internet");
        description = "a global system of interconnected computer networks "
                + "that uses the Internet protocol suite (TCP/IP) to "
                + "communicate between networks and devices";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Linux";
        url = getWikipediaURL("Linux");
        description = "a family of open-source Unix-like operating systems";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "MacOS";
        url = getWikipediaURL("macOS");
        description = "a group of several proprietary Unix operating systems "
                + "developed and marketed by Apple";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Magic Number";
        url = getWikipediaURL("File_format#Magic_number");
        description = "file type metadata incorporated into the file - usually "
                + "at the start";
        referenceNameToReference.put(name, new Reference(url, description));
                        
        name = "Microsoft Windows";
        url = getWikipediaURL("Microsoft_Windows");
        description = "a group of several proprietary graphical operating "
                + "system families developed and marketed by Microsoft";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Matplotlib";
        url = "https://matplotlib.org/";
        description = "a library for creating static, animated, and "
                + "interactive visualizations in Python";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Object Oriented Programming";
        url = getWikipediaURL("Object-oriented_programming");
        description = "a programming paradigm based on the concept of "
                + "\"objects\", which can contain data and code. The data is "
                + "in the form of fields (often known as attributes or "
                + "properties), and the code is in the form of procedures "
                + "(often known as methods)";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Operating System";
        url = getWikipediaURL("Operating_system");
        description = "a system that manages computer hardware and software "
                + "resources, and provides common services for computer "
                + "programs";
        referenceNameToReference.put(name, new Reference(url, description));
               
        name = "PATH";
        url = getWikipediaURL("PATH_(variable)");
        description = "an environment variable on Unix-like operating systems, "
                + "DOS, OS/2, and Microsoft Windows, specifying a set of "
                + "directories where executable programs are located";
        referenceNameToReference.put(name, new Reference(url, description));
               
        name = "Programming Language";
        url = getWikipediaURL("Programming_language");
        description = "a system of notation for writing computer programs";
        referenceNameToReference.put(name, new Reference(url, description));
                
        name = "PyPI";
        url = getWikipediaURL("https://pypi.org/");
        description = "the Python Package Index";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Python";
        url = getWikipediaURL("Python_(programming_language)");
        description = "a high-level, general-purpose programming language";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Python 3 Language Reference";
        url = "https://docs.python.org/3/reference/";
        description = "manual describing the syntax and \"core semantics\" of "
                + "Python";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Python Docstring";
        url = "https://peps.python.org/pep-0257/#what-is-a-docstring";
        description = "a string literal that occurs as the first statement in "
                + "a module, function, class, or method definition. Such a "
                + "docstring becomes the __doc__ special attribute of that "
                + "object.";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Python Documentation Classes Tutorial";
        url = "https://docs.python.org/3/tutorial/classes.html";
        description = null;
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Python Documentation Modules Tutorial";
        url = "https://docs.python.org/3/tutorial/modules.html";
        description = null;
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Python Tutorial";
        url = "https://docs.python.org/3/tutorial";
        description = null;
        referenceNameToReference.put(name, new Reference(url, description));
                
        name = "Python Enhancement Proposal Website";
        url = "https://peps.python.org/";
        description = null;
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Python IDLE";
        url = "https://docs.python.org/3/library/idle.html";
        description = "Python’s Integrated Development and Learning "
                + "Environment";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Python Lexical Analysis Documentation";
        url = "https://docs.python.org/3/reference/lexical_analysis.html";
        description = null;
        referenceNameToReference.put(name, new Reference(url, description));
                
        name = "Python Packages";
        url = "https://docs.python.org/3/tutorial/modules#packages.html";
        description = null;
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Python Packaging User Guide";
        url = "https://packaging.python.org/";
        description = "a collection of tutorials and references to help you "
                + "distribute and install Python packages with modern tools";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Python Software Foundation";
        url = "https://www.python.org/psf/";
        description = "an organization devoted to advancing open source "
                + "technology related to the Python programming language";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Python Standard Library";
        url = "https://docs.python.org/3/library/";
        description = "the functionality that is commonly included in Python "
                + "distributions and it's reference manual";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Python Venv";
        url = "https://docs.python.org/3/library/venv.html";
        description = "a Python module that supports creating lightweight "
                + "\"virtual environments\", each with their own independent "
                + "set of Python packages installed in their site directories";
        referenceNameToReference.put(name, new Reference(url, description));
                
        name = "Python What's New";
        url = "https://docs.python.org/3/whatsnew";
        description = "The \"What’s New in Python\" documentation tours "
                + "through the most important changes between major Python "
                + "versions.";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "QGIS Python API Documentation";
        url = "https://qgis.org/pyqgis/";
        description = null;
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Read Evaluate Print Loop";
        url = getWikipediaURL("Read%E2%80%93eval%E2%80%93print_loop");
        description = "also termed an interactive toplevel or language shell, "
                + "is a simple interactive computer programming environment "
                + "that takes single user inputs, executes them, and returns "
                + "the result to the user";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Single-precision Floating-point";
        url = getWikipediaURL("Single-precision_floating-point_format");
        description = " a computer number format, usually occupying 32 bits in "
                + "computer memory";
        referenceNameToReference.put(name, new Reference(url, description));
                
        name = "Software";
        url = getWikipediaURL("Software");
        description = "computer programs and associated documentation and data";
        referenceNameToReference.put(name, new Reference(url, description));
                
        name = "Spyder";
        url = "https://www.spyder-ide.org/";
        description = "a web-based application for developing, documenting,"
                + " and an integrated development environment for Python";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "The Jupyter Notebook";
        url = "https://jupyter-notebook.readthedocs.io/en/stable/notebook.html";
        description = "a web-based application for developing, documenting, "
                + "and executing code, and communicating results";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "The Python Website";
        url = "https://www.python.org/";
        description = null;
        referenceNameToReference.put(name, new Reference(url, description));

        name = "Unicode";
        url = getWikipediaURL("Unicode");
        description = "an information technology standard for the consistent "
                + "encoding, representation, and handling of text expressed in "
                + "most of the world's writing systems";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Variable";
        url = getWikipediaURL("Variable_(computer_science)");
        description = "the order in which individual statements, instructions "
                + "or function calls of an imperative program are executed or "
                + "evaluated";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "Version Control";
        url = getWikipediaURL("Version_control");
        description = "(also known as revision control, source control, or "
                + "source code management) is a class of systems responsible "
                + "for managing changes to computer programs, documents, large "
                + "web sites, or other collections of information.";
        referenceNameToReference.put(name, new Reference(url, description));
        
        name = "While Loop";
        url = getWikipediaURL("While_loop");
        description = "a control flow statement that allows code to be "
                + "executed repeatedly until a condition evaluates as false";
        referenceNameToReference.put(name, new Reference(url, description));
        
        
        referenceNameToReference.put(name, new Reference(url, description));
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
        if (!c.references.referenceNameToReference.containsKey(name)) {
            c.references.referenceNameToReference.put(name, 
                    new Reference(url, description));
        }
        return Web_ContentWriter.getLink(url, linkText);
    }
    
    /**
     * @param name The name of the reference to get a link from.
     * @return the link for the reference given by name.
     */
    public String getReference(String name) {
        return referenceNameToReference.get(name).getLink(name);
    }
    
    /**
     * @param name The name of the reference to get a link from.
     * @param linkText The link text for the link.
     * @return the link for the reference given by name.
     */
    public String getReference(String name, String linkText) {
        return referenceNameToReference.get(name).getLink(linkText);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("<ul>");
        for (String name : referenceNameToReference.keySet()) {
            Reference r = referenceNameToReference.get(name);
            StringBuilder sb = new StringBuilder();
            sb.append("<li>");
            sb.append(Web_ContentWriter.getLink(r.url, name));
            sb.append(r.description);
            sb.append("</li>");
            w.add(sb.toString());
        }
        w.add("</ul>");
        w.add("</div>");
        
    }
    
    
}
