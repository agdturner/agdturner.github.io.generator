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

        String term;
        String url;
        String description;
        
        term = "Anaconda";
        url = "https://www.anaconda.com/";
        description = "a data science platform";
        termToTerm.put(term, new Term(index, description, url));

        term = "Conda";
        url = "https://docs.conda.io/";
        description = "an open source package management system and "
                + "environment management system";
        termToTerm.put(term, new Term(index, description, url));
        
        term = "IDLE";
        url = PythonIndex.getPythonDocsLibraryURL("idle.html");
        description = "an Integrated Development and Learning Environment "
                + "distributed with Python";
        termToTerm.put(term, new Term(index, description, url));
        
        term = "Jupyter";
        url = "https://jupyter.org/about";
        description = "a non-profit, open-source project supporting "
                + "interactive data science and scientific computing across "
                + "all programming languages";
        termToTerm.put(term, new Term(index, description, url));

        term = "Jupyter Notebook";
        url = "https://jupyter-notebook.readthedocs.io/en/stable/notebook.html";
        description = "a web-based application for developing, documenting, "
                + "and executing code, and communicating results";
        termToTerm.put(term, new Term(index, description, url));
        
        term = "Matplotlib";
        url = "https://matplotlib.org/";
        description = "a library for creating static, animated, and "
                + "interactive visualizations in Python";
        termToTerm.put(term, new Term(index, description, url));

        term = "PIP";
        url = "https://pip.pypa.io";
        description = "The Package Installer for \"Python\"";
        termToTerm.put(term, new Term(index, description, url));
        
        term = "Python Package Index (PyPI)";
        url = "https://pypi.org/";
        description = "A repository of software for \"Python\".";
        termToTerm.put(term, new Term(index, description, url));

        String python3Documentation = "Python 3 Documentation";
        
        term = python3Documentation;
        url = PythonIndex.PYTHON_DOCS_URL;
        description = "Python 3 Documentation";
        termToTerm.put(term, new Term(index, description, url));

        term = python3Documentation + ": Reference";
        url = PythonIndex.getPythonDocsReferenceURL("");
        description = "Manual describing the syntax and \"core semantics\" of "
                + "Python";
        termToTerm.put(term, new Term(index, description, url));

        term = python3Documentation + ": Glossary";
        url = PythonIndex.PYTHON_DOCS_URL + "glossary.html";
        description = "Python 3 Documentation glossary of terms";
        termToTerm.put(term, new Term(index, description, url));

        term = python3Documentation + ": Library";
        url = PythonIndex.getPythonDocsLibraryURL("");
        description = "The functionality that is included in Python "
                + "distributions as standard and it's reference manual";
        termToTerm.put(term, new Term(index, description, url));

        String python3DocumentationTutorial = python3Documentation + ": Tutorial";
        term = python3DocumentationTutorial;
        url = PythonIndex.PYTHON_DOCS_URL_TUTORIAL;
        description = null;
        termToTerm.put(term, new Term(index, description, url));
        
        term = python3DocumentationTutorial + ": Classes";
        url = PythonIndex.PYTHON_DOCS_URL_TUTORIAL + "classes.html";
        description = null;
        termToTerm.put(term, new Term(index, description, url));

        term = python3DocumentationTutorial + ": Modules";
        url = PythonIndex.PYTHON_DOCS_URL_TUTORIAL + "modules.html";
        description = null;
        termToTerm.put(term, new Term(index, description, url));

        term = python3DocumentationTutorial + ": Packages";
        url = PythonIndex.PYTHON_DOCS_URL_TUTORIAL + "modules.html#packages";
        description = null;
        termToTerm.put(term, new Term(index, description, url));

        term = python3Documentation + ": What's New";
        url = PythonIndex.PYTHON_DOCS_URL + "whatsnew";
        description = "The \"What's New in Python\" documentation tours "
                + "through the most important changes between major Python "
                + "versions";
        termToTerm.put(term, new Term(index, description, url));

        term = "Python Enhancement Proposal Website";
        url = "https://peps.python.org/";
        description = null;
        termToTerm.put(term, new Term(index, description, url));

        term = "Python Lexical Analysis Documentation";
        url = PythonIndex.getPythonDocsReferenceURL("lexical_analysis.html");
        description = null;
        termToTerm.put(term, new Term(index, description, url));

        term = "Python Packaging User Guide";
        url = "https://packaging.python.org/";
        description = "a collection of tutorials and references to help you "
                + "distribute and install Python packages with modern tools";
        termToTerm.put(term, new Term(index, description, url));
        
        term = "Python Software Foundation";
        url = "https://www.python.org/psf/";
        description = "an organization devoted to advancing open source "
                + "technology related to the Python programming language";
        termToTerm.put(term, new Term(index, description, url));

        term = "Python Website";
        url = "https://www.python.org/";
        description = null;
        termToTerm.put(term, new Term(index, description, url));
        
        term = "QGIS";
        url = "https://qgis.org/";
        description = "Quantum Geographical Infromation System Software";
        termToTerm.put(term, new Term(index, description, url));
        
        term = "Spyder";
        url = "https://www.spyder-ide.org/";
        description = "a web-based application and an integrated development "
                + "environment for Python";
        termToTerm.put(term, new Term(index, description, url));
        
        term = "Spyder Documentation";
        url = "https://docs.spyder-ide.org/";
        description = null;
        termToTerm.put(term, new Term(index, description, url));
    }
}
