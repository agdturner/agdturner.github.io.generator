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

import java.util.TreeMap;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * For course references pages.
 *
 * @author Andy Turner
 */
public class References extends Page {

    private static final long serialVersionUID = 1L;

    /**
     * To look up terms from a name.
     */
    public TreeMap<String, Term> nameToTerm;

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
        nameToTerm = new TreeMap<>();

        String name;
        String url;
        String description;

        name = "Anaconda";
        url = "https://www.anaconda.com/";
        description = "a data science platform";
        nameToTerm.put(name, new Term(description, url));

        name = "Conda";
        url = "https://docs.conda.io/";
        description = "an open source package management system and "
                + "environment management system";
        nameToTerm.put(name, new Term(description, url));

        name = "GitHub";
        url = "https://github.com/";
        description = "an Internet hosting service for software development "
                + "and version control";
        nameToTerm.put(name, new Term(description, url));

        name = "IDLE";
        url = "https://docs.python.org/3/library/idle.html";
        description = "an Integrated Development and Learning Environment "
                + "distributed with Python";
        nameToTerm.put(name, new Term(description, url));
        
        name = "Jupyter";
        url = "https://jupyter.org/about";
        description = "a non-profit, open-source project supporting "
                + "interactive data science and scientific computing across "
                + "all programming languages";
        nameToTerm.put(name, new Term(description, url));

        name = "Jupyter Notebook";
        url = "https://jupyter-notebook.readthedocs.io/en/stable/notebook.html";
        description = "a web-based application for developing, documenting, "
                + "and executing code, and communicating results";
        nameToTerm.put(name, new Term(description, url));
                
        name = "Matplotlib";
        url = "https://matplotlib.org/";
        description = "a library for creating static, animated, and "
                + "interactive visualizations in Python";
        nameToTerm.put(name, new Term(description, url));

        name = "PIP";
        url = getWikipediaURL("https://pip.pypa.io");
        description = "Python Package Installer";
        nameToTerm.put(name, new Term(description, url));
        
        name = "PyPI";
        url = getWikipediaURL("https://pypi.org/");
        description = "Python Package Index";
        nameToTerm.put(name, new Term(description, url));

        name = "Python 3 Documentation";
        url = "https://docs.python.org/3/";
        description = "the official documentation for Python 3";
        nameToTerm.put(name, new Term(description, url));

        name = "Python 3 Documentation: Reference";
        url = "https://docs.python.org/3/reference/";
        description = "manual describing the syntax and \"core semantics\" of "
                + "Python";
        nameToTerm.put(name, new Term(description, url));

        name = "Python 3 Documentation: Glossary";
        url = "https://docs.python.org/3/glossary.html";
        description = "glossary of Python 3 Documentation Reference terms";
        nameToTerm.put(name, new Term(description, url));

        name = "Python 3 Documentation: Library";
        url = "https://docs.python.org/3/library/";
        description = "the functionality that is included in Python "
                + "distributions as standard and it's reference manual";
        nameToTerm.put(name, new Term(description, url));

        name = "Python 3 Documentation: Tutorial";
        url = "https://docs.python.org/3/tutorial";
        description = null;
        nameToTerm.put(name, new Term(description, url));
        
        name = "Python 3 Documentation: Tutorial: Classes";
        url = "https://docs.python.org/3/tutorial/classes.html";
        description = null;
        nameToTerm.put(name, new Term(description, url));

        name = "Python 3 Documentation: Tutorial: Modules";
        url = "https://docs.python.org/3/tutorial/modules.html";
        description = null;
        nameToTerm.put(name, new Term(description, url));

        name = "Python 3 Documentation: Tutorial: Packages";
        url = "https://docs.python.org/3/tutorial/modules#packages.html";
        description = null;
        nameToTerm.put(name, new Term(description, url));

        name = "Python 3 Documentation: What's New";
        url = "https://docs.python.org/3/whatsnew";
        description = "The \"What's New in Python\" documentation tours "
                + "through the most important changes between major Python "
                + "versions.";
        nameToTerm.put(name, new Term(description, url));

        name = "Python Enhancement Proposal Website";
        url = "https://peps.python.org/";
        description = null;
        nameToTerm.put(name, new Term(description, url));

        name = "Python Lexical Analysis Documentation";
        url = "https://docs.python.org/3/reference/lexical_analysis.html";
        description = null;
        nameToTerm.put(name, new Term(description, url));

        name = "Python Packaging User Guide";
        url = "https://packaging.python.org/";
        description = "a collection of tutorials and references to help you "
                + "distribute and install Python packages with modern tools";
        nameToTerm.put(name, new Term(description, url));

        name = "Python Packaging User Guide";
        url = "https://packaging.python.org/";
        description = "a collection of tutorials and references to help you "
                + "distribute and install Python packages with modern tools";
        nameToTerm.put(name, new Term(description, url));
        
        name = "Python Software Foundation";
        url = "https://www.python.org/psf/";
        description = "an organization devoted to advancing open source "
                + "technology related to the Python programming language";
        nameToTerm.put(name, new Term(description, url));

        name = "Python Website";
        url = "https://www.python.org/";
        description = null;
        nameToTerm.put(name, new Term(description, url));

        name = "QGIS";
        url = "https://qgis.org/";
        description = "Quantum Geographical Infromation System Software";
        nameToTerm.put(name, new Term(description, url));

        name = "Spyder";
        url = "https://www.spyder-ide.org/";
        description = "a web-based application for developing, documenting,"
                + " and an integrated development environment for Python";
        nameToTerm.put(name, new Term(description, url));
        
        name = "Spyder Documentation";
        url = "https://docs.spyder-ide.org/";
        description = null;
        nameToTerm.put(name, new Term(description, url));
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
                    new Term(description, url));
        }
        return Web_ContentWriter.getLink(url, linkText);
    }

    /**
     * @param name The name and linkText of the term.
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
        return nameToTerm.get(name).getLink(linkText);
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("<ul>");
        for (String name : nameToTerm.keySet()) {
            Term r = nameToTerm.get(name);
            StringBuilder sb = new StringBuilder();
            sb.append("<li>");
            sb.append(r.getLinkAndDescription(name));
            sb.append("</li>");
            w.add(sb.toString());
        }
        w.add("</ul>");
        w.add("</div>");
    }

}
