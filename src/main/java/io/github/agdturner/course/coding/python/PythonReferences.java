/*
 * Copyright 2023 Centre for Computational Geography.
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
import io.github.agdturner.course.References;
import io.github.agdturner.course.Term;

/**
 * Python Course References.
 * 
 * @author Andy Turner
 */
public class PythonReferences extends References {
    
    /**
     * Create a new instance.
     *
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     * @param course What {@link #site} is set to.
     */
    public PythonReferences(Course course, String filename, String title, String label) {
        super(course, filename, title, label);

        String name;
        String url;
        String description;
        
        name = "Anaconda";
        url = "https://www.anaconda.com/";
        description = "a data science platform";
        nameToTerm.put(name, new Term(index, description, url));

        name = "Conda";
        url = "https://docs.conda.io/";
        description = "an open source package management system and "
                + "environment management system";
        nameToTerm.put(name, new Term(index, description, url));
        
        name = "IDLE";
        url = PythonIndex.getPythonDocsLibraryURL("idle.html");
        description = "an Integrated Development and Learning Environment "
                + "distributed with Python";
        nameToTerm.put(name, new Term(index, description, url));
        
        name = "Jupyter";
        url = "https://jupyter.org/about";
        description = "a non-profit, open-source project supporting "
                + "interactive data science and scientific computing across "
                + "all programming languages";
        nameToTerm.put(name, new Term(index, description, url));

        name = "Jupyter Notebook";
        url = "https://jupyter-notebook.readthedocs.io/en/stable/notebook.html";
        description = "a web-based application for developing, documenting, "
                + "and executing code, and communicating results";
        nameToTerm.put(name, new Term(index, description, url));
        
        name = "Matplotlib";
        url = "https://matplotlib.org/";
        description = "a library for creating static, animated, and "
                + "interactive visualizations in Python";
        nameToTerm.put(name, new Term(index, description, url));

        name = "PIP";
        url = "https://pip.pypa.io";
        description = "The Package Installer for \"Python\"";
        nameToTerm.put(name, new Term(index, description, url));
        
        name = "Python Package Index (PyPI)";
        url = "https://pypi.org/";
        description = "A repository of software for \"Python\".";
        nameToTerm.put(name, new Term(index, description, url));

        String python3Documentation = "Python 3 Documentation";
        
        name = python3Documentation;
        url = PythonIndex.PYTHON_DOCS_URL;
        description = "Python 3 Documentation";
        nameToTerm.put(name, new Term(index, description, url));

        name = python3Documentation + ": Reference";
        url = PythonIndex.getPythonDocsReferenceURL("");
        description = "Manual describing the syntax and \"core semantics\" of "
                + "Python";
        nameToTerm.put(name, new Term(index, description, url));

        name = python3Documentation + ": Glossary";
        url = PythonIndex.PYTHON_DOCS_URL + "glossary.html";
        description = "Python 3 Documentation glossary of terms";
        nameToTerm.put(name, new Term(index, description, url));

        name = python3Documentation + ": Library";
        url = PythonIndex.getPythonDocsLibraryURL("");
        description = "The functionality that is included in Python "
                + "distributions as standard and it's reference manual";
        nameToTerm.put(name, new Term(index, description, url));

        String pythonTutorialURL = PythonIndex.PYTHON_DOCS_URL + "tutorial/";
                
        String python3DocumentationTutorial = python3Documentation + ": Tutorial";
        name = python3DocumentationTutorial;
        url = pythonTutorialURL;
        description = null;
        nameToTerm.put(name, new Term(index, description, url));
        
        name = python3DocumentationTutorial + ": Classes";
        url = pythonTutorialURL + "classes.html";
        description = null;
        nameToTerm.put(name, new Term(index, description, url));

        name = python3DocumentationTutorial + ": Modules";
        url = pythonTutorialURL + "modules.html";
        description = null;
        nameToTerm.put(name, new Term(index, description, url));

        name = python3DocumentationTutorial + ": Packages";
        url = pythonTutorialURL + "modules#packages.html";
        description = null;
        nameToTerm.put(name, new Term(index, description, url));

        name = python3Documentation + ": What's New";
        url = PythonIndex.PYTHON_DOCS_URL + "whatsnew";
        description = "The \"What's New in Python\" documentation tours "
                + "through the most important changes between major Python "
                + "versions";
        nameToTerm.put(name, new Term(index, description, url));

        name = "Python Enhancement Proposal Website";
        url = "https://peps.python.org/";
        description = null;
        nameToTerm.put(name, new Term(index, description, url));

        name = "Python Lexical Analysis Documentation";
        url = PythonIndex.getPythonDocsReferenceURL("lexical_analysis.html");
        description = null;
        nameToTerm.put(name, new Term(index, description, url));

        name = "Python Packaging User Guide";
        url = "https://packaging.python.org/";
        description = "a collection of tutorials and references to help you "
                + "distribute and install Python packages with modern tools";
        nameToTerm.put(name, new Term(index, description, url));
        
        name = "Python Software Foundation";
        url = "https://www.python.org/psf/";
        description = "an organization devoted to advancing open source "
                + "technology related to the Python programming language";
        nameToTerm.put(name, new Term(index, description, url));

        name = "Python Website";
        url = "https://www.python.org/";
        description = null;
        nameToTerm.put(name, new Term(index, description, url));
        
        name = "QGIS";
        url = "https://qgis.org/";
        description = "Quantum Geographical Infromation System Software";
        nameToTerm.put(name, new Term(index, description, url));
        
        name = "Spyder";
        url = "https://www.spyder-ide.org/";
        description = "a web-based application and an integrated development "
                + "environment for Python";
        nameToTerm.put(name, new Term(index, description, url));
        
        name = "Spyder Documentation";
        url = "https://docs.spyder-ide.org/";
        description = null;
        nameToTerm.put(name, new Term(index, description, url));
    }
}
