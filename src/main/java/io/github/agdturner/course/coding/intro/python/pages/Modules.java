/*
 * Copyright 2022 Centre for Computational Geography.
 *
 * Licensed under the Apache License, Version 2.0 (the"License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an"AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.agdturner.course.coding.intro.python.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.course.CoursePage;

/**
 * For Python Intro Course Modules Page.
 *
 * @author Andy Turner
 */
public class Modules extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public Modules(PythonIntroCodingCourse course) {
        super(course, "modules", "Modules", "Modules");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        w.addP(sb,
                """
                In Python a 'module' is a single file that may contain classes,
                functions and variables. It has to be imported to make these
                things accessible and those things are then referred to using
                the module name or the alias defined in the import statement and
                the dot operator '.'.
                """);
        w.addP(sb,
                """
                'Packages' are collections of modules structured using a
                directory tree.
                """);
        w.addP(sb,
                """
                A code 'library' is a generic name for a collection of code.
                So, a Python library might contain a single module, or multiple
                packages.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Importing", sb);
        w.addPST(sb, "The ");
        sb.append(index.getReference("Python Module Index", sid));        
        sb.append(" is a useful look up for ");
        sb.append(references.getReference("Python 3 Documentation: Library",
                        "Python Standard Library"));
        w.addPET(sb,
                """
                modules. These modules can be readily imported and used without
                needing to customise the environment.
                """);
        w.addP(sb,
                """
                There are two types of import statement, those that begin with
                the keyword 'import' and others that begin with the keyword
                'from' and also contain the keyword 'import'.
                """);
        w.addP(sb,
                """
                The following code imports a module called 'agentframework' and
                then constructs an instance of the 'Agent' class as defined in
                the 'agentframework' module:
                """);
        addCodeBlock(sb,
                """
                import agentframework
                a = agentframework.Agent()
                """);
        w.addP(sb,
                """
                This is a very explicit style. There is little ambiguity about
                which 'Agent' class is used - it is the one from the
                'agentframework' module.
                """);
        w.addP(sb,
                """
                Another way to create instances of the 'Agent' class is as
                follows:
                """);
                      
        addCodeBlock(sb,
                """
                from agentframework import Agent
                a = Agent()
                """);
        w.addP(sb,
                """
                The advantage of this is that it is less verbose when it comes
                to lines of code that instantiate instances of the Agent class.
                Also this is more memory efficent as it only makes available
                that specific class from the 'agentframework' module rather than
                keeping the entire module available.
                """);
        w.addP(sb,
                """
                You may see imports of everything in a module using the star
                operator '*', for example:
                """);
                      
        addCodeBlock(sb, "from agentframework import *");
        w.addP(sb,
                """
                This saves having to import multiple classes, but it can be
                problematic as what gets imported can replace things imported
                before that have the same name. It is good practise to be
                explicit and import individually only those things that are
                used and to check if an identifier is already in use and if so
                use aliases.
                """);
        w.addP(sb,
                """
                The keyword 'as' can be used to alias a module or class on
                import. This can also abbreviate a name, for example the
                following are alternatives for creating 'agentframework' 'Agent'
                class instances:
                """);
        addCodeBlock(sb,
                """
                import agentframework as af
                a = af.Agent()
                """);
        addCodeBlock(sb,
                """
                from agentframework import Agent as A
                a = A()
                """);
        w.addP(sb,
                """
                The Python interpreter parses modules on import initialising
                variables and making functions and classes available for use.
                Within the module, any code not in a function or a class is run
                when the module is imported as is any code within a class that
                is not in a method. This means that sometimes there can be side
                effects of importing modules. It can be argued that the less
                code that is run when the module is imported the better!
                """);
        w.addP(sb,
                """
                It is good practise to set up a module so that any code not in
                functions is isolated and is not run when the module is
                imported. This can be done by ensuring all code not in functions
                is within an 'if statement' that has a condition that tests if
                the global '__name__' variable equals "__main__":
                """);
                      
                      
        addCodeBlock(sb,
                """
                if __name__ == "__main__":
                    # All code in this is only run when the module is run as a script.
                    # It is not run if the module is imported.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Packages", sb);
        w.addP(sb, "Consider the following package file structure:");
        addCodeBlock(sb,
                """
                /abm
                    __init__.py
                    __main__.py
                    /models
                        __init__.py
                        model.py
                    /my_modules
                        __init__.py
                        agentframework.py
                """);
        w.addP(sb,
                """
                The '__init__.py' files can be empty, but they must exist so
                the Python interpreter recognises these subdirectories as
                subpackages and allows import statements to work as follows:
                """);
        addCodeBlock(sb, "import abm.my_modules.agentframework.Agent");
        w.addP(sb,
                """
                This import statement will work so long as there is an 'Agent'
                class within the 'agentframework' module
                """);
        
        w.addP(sb,
                """
                The base '__init__.py' file in the 'abm' directory can also
                include a text representation of a specially named list which
                will import specific subpackages if a star import statement is
                used. For example, if the following were the contents of
                '/abm/__init__.py':
                """);
        w.addPRE(sb, """
                   __all__ = ["models", "my_modules"]
                   """);
        w.addP(sb,
                """
                Then, the following import statement would import both the
                'models' and 'my_modules' subpackages:
                """);
        addCodeBlock(sb, "from abm import *");
        w.addP(sb,
                """
                Packages are set to run as applications by placing startup
                code in a file called '__main__.py'. The following command would
                then run the application when issued at the prompt:
                """);
        w.addPRE(sb,"python -m packagename");
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Third Party Libraries", sb);
        w.addPST(sb, "");
        sb.append(references.getReference("Anaconda"));
        w.addPET(sb,
                " comes bundled with numerous third party libraries.");
        w.addP(sb,
                """
                Exactly what Anaconda comes with varies with the version and
                underlying operating system. Details can be found via the
                following URL:
                <a href="https://docs.anaconda.com/anaconda/packages/pkg-docs/">
                https://docs.anaconda.com/anaconda/packages/pkg-docs/</a>
                """);
        w.addP(sb,
                """
                There are many additional libraries that might be useful for
                geographical data processing or whatever you may be doing.
                """);
        w.addPST(sb, "Many Python libraries are made available via ");
        sb.append(index.getReference("PyPI"));
        w.addPET(sb, " - the Python Package Index (PyPi) including:");
        w.addULST(sb);
        w.addLI(sb,
                """
                <a href="https://pro.arcgis.com/en/pro-app/latest/arcpy/get-started/what-is-arcpy-.htm">
                ArcPY</a>
                - <a href="https://www.esri.com/en-us/arcgis/products/arcgis-pro/overview">ArcGIS Pro</a> API.
                """);
        w.addLI(sb,
                """
                <a href="https://beautiful-soup-4.readthedocs.io/">
                beautiful-soup</a>
                - for parsing HTML and XML files.
                """);
        w.addLI(sb,
                """
                <a href="http://www.celeryproject.org/">celery</a>
                - useful for distributed computing (splitting up programs and
                running them on multiple computers).
                """);
        w.addLI(sb,
                """
                <a href="https://contextily.readthedocs.io/">
                Contextily</a>
                - for retrieving tile maps from the Internet, then adding them
                to matplotlib figures or writing them to files.
                """);
        w.addLI(sb,
                """
                <a href="https://github.com/Toblerity/Fiona">Fiona</a>
                - reads and writes geographic data files.
                """);
        w.addLI(sb,
                """
                <a href="https://python-visualization.github.io/folium/">
                Folium</a> - for visualising data on an interactive javascript
                map.
                """);
        w.addLI(sb,
                """
                <a href="https://geopandas.org/">Geopandas</a>
                - extends the data types used by 'pandas' to include geometry
                (and has support for many geometry operations).
                """);
        w.addLI(sb,
                """
                <a href="https://geopy.readthedocs.io/">GeoPy</a>
                - a client for several popular geocoding web services.
                """);
        w.addLI(sb,
                """
                <a href="https://matplotlib.org/">matplotlib</a>
                - a comprehensive library for creating static, animated, and
                interactive visualizations.
                """);
        w.addLI(sb,
                """
                <a href="http://www.nltk.org/">nltk</a>
                - a Natural Language Toolkit for parsing and analysing text.
                """);
        w.addLI(sb,
                """
                <a href="http://www.numpy.org/">numpy</a>
                - useful for mathematics and statistics, especially
                multi-dimensional array manipulation.
                """);
        w.addLI(sb,
                """
                <a href="http://pandas.pydata.org/">pandas</a>
                - useful for a range of other things including time series
                analysis.
                """);
        w.addLI(sb,
                """
                <a href="https://docs.qgis.org/3.10/en/docs/pyqgis_developer_cookbook/">
                PyQGIS</a>
                - <a href="https://www.qgis.org/">QGIS</a> API.
                """);
        w.addLI(sb,
                """
                <a href="http://scikit-learn.org/">scikit-learn</a>
                - useful for scientific analysis and machine learning.
                """);
        w.addULET(sb);
        w.addP(sb,
                """
                For details on installing packages see:
                <a href="../python/index.html#9">Python Packages and Environment Management</a>.
                """);
        w.addDIVET(sb);
        return sb.toString();
    }
}
