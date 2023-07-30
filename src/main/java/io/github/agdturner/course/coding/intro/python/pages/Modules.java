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
import io.github.agdturner.course.Course;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.course.CoursePage;
import io.github.agdturner.course.Index;
import io.github.agdturner.course.References;

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
    public void write() {
        Course course = getCourse();
        Index index = course.getIndex();
        References references = course.getReferences();
        writeHeader();
        writeH1();
        SectionID sid = addSection("1", "Introduction", 2);
        w.add("""
              <p>In Python a 'module' is a single file that may contain classes, 
              functions and variables. It has to be imported to make these 
              things accessible and those things are then referred to using the 
              module name or the alias defined in the import statement and the 
              dot operator '.'.</p>
              <p>'Packages' are collections of modules structured using a 
              directory tree.</p>
              <p>A code 'library' is a generic name for a collection of code. 
              So, a Python library might contain a single module, or multiple 
              packages.</p>
              """);

        sid = addSection("2", "Importing", 2);
        w.add("<p>The "
                + index.getReference("Python Module Index", sid)
                + " is a useful look up for "
                + references.getReference("Python 3 Documentation: Library",
                        "Python Standard Library")
                + " modules. These modules can be readily imported and used"
                + " without needing to customise the environment.</p>");
        w.add("""
              <p>There are two types of import statement, those that begin with
              the keyword 'import' and others that begin with the keyword 
              'from' and also contain the keyword 'import'.</p>
              <p>The following code imports a module called 'agentframework' and 
              then constructs an instance of the 'Agent' class as defined in the 
              'agentframework' module:</p>
              <pre><code class="language-python">import agentframework
              a = agentframework.Agent()</code></pre>
              <p>This is a very explicit style. There is little ambiguity about 
              which 'Agent' class is used - it is the one from the 
              'agentframework' module.</p>
              <p>Another way to create instances of the 'Agent' class is as 
              follows:</p>
              <pre><code class="language-python">from agentframework import Agent
              a = Agent()</code></pre>
              <p>The advantage of this is that it is less verbose when it comes 
              to lines of code that instantiate instances of the Agent class. 
              Also this is more memory efficent as it only makes available that 
              specific class from the 'agentframework' module rather than  
              keeping the entire module available.</p>
              <p>You may see imports of everything in a module using the star
              operator '*', for example:</p>
              <pre><code class="language-python">from agentframework import *</code></pre>
              <p>This saves having to import multiple classes, but it can be 
              problematic as what gets imported can replace things imported 
              before that have the same name. It is good practise to be explicit 
              and import individually only those things that are used and to 
              check if an identifier is already in use and if so use aliases.
              </p>
              <p>The keyword 'as' can be used to alias a module or class on 
              import. This can also abbreviate a name, for example the following 
              are alternatives for creating 'agentframework' 'Agent' class 
              instances:</p>
              <pre><code class="language-python">import agentframework as af
              a = af.Agent()</code></pre>
              <pre><code class="language-python">from agentframework import Agent as A
              a = A()</code></pre>
              <p>The Python interpreter parses modules on import initialising
              variables and making functions and classes available for use. 
              Within the module, any code not in a function or a class is 
              run when the module is imported as is any code within a class that 
              is not in a method. This means that sometimes there can be side 
              effects of importing modules. It can be argued that the less code 
              that is run when the module is imported the better!</p>
              <p>It is good practise to set up a module so that any code not in 
              functions is isolated and is not run when the module is imported. 
              This can be done by ensuring all code not in functions is within 
              an 'if statement' that has a condition that tests if the global 
              '__name__' variable equals "__main__":</p>
              <pre><code class="language-python">if __name__ == "__main__":
                  # All code in this is only run when the module is run as a script.
                  # It is not run if the module is imported.</code></pre>
              """);

        sid = addSection("3", "Packages", 2);
        w.add("""
              <p>Consider the following package file structure:</p>
              <pre><code class="language-python">/abm
                  __init__.py
                  __main__.py
                  /models
                      __init__.py
                      model.py
                  /my_modules
                      __init__.py
                      agentframework.py</code></pre>
              <p>The '__init__.py' files can be empty, but they must exist so 
              the Python interpreter recognises these subdirectories as 
              subpackages and allows import statements to work as follows:</p>
              <pre><code class="language-python">import abm.my_modules.agentframework.Agent</code></pre>
              <p>This import statement will work so long as there is an 'Agent'
              class within the 'agentframework' module</p>
              <p>The base '__init__.py' file in the 'abm' directory can also 
              include a text representation of a specially named list which will 
              import specific subpackages if a star import statement is used. 
              For example, if the following were the contents of 
              '/abm/__init__.py':</p>
              <pre>__all__ = ["models", "my_modules"]</pre>
              <p>Then, the following import statement would import both the 
              'models' and 'my_modules' subpackages:</p>
              <pre><code class="language-python">from abm import *</code></pre>
              <p>Packages are set to run as applications by placing startup 
              code in a file called '__main__.py'. The following command would 
              then run the application when issued at the prompt:</p>
              <pre>python -m packagename</pre>
              """);

        sid = addSection("4", "Third Party Libraries", 2);
        w.add("<p>"
                + references.getReference("Anaconda")
                + " comes bundled with numerous third party libraries.</p>");
        w.add("""
              <p>
              Exactly what Anaconda comes with varies with the version and 
              underlying operating system. Details can be found via the 
              following URL:
              <a href="https://docs.anaconda.com/anaconda/packages/pkg-docs/">
              https://docs.anaconda.com/anaconda/packages/pkg-docs/</a></p>
              <p>There are many additional libraries that might be useful for 
              geographical data processing or whatever you may be doing.</p>
              """);
        w.add("<p>Many Python libraries are made available via "
                + references.getReference("PyPI")
                + " - the Python Package Index (PyPi) including:</p>");
        w.add("""
              <ul>
              <li><a href="https://pro.arcgis.com/en/pro-app/latest/arcpy/get-started/what-is-arcpy-.htm">
              ArcPY</a>
              - <a href="https://www.esri.com/en-us/arcgis/products/arcgis-pro/overview">ArcGIS Pro</a> API.</li>
              <li><a href="https://beautiful-soup-4.readthedocs.io/">
              beautiful-soup</a>
              - for parsing HTML and XML files.</li>
              <li><a href="http://www.celeryproject.org/">celery</a>
              - useful for distributed computing (splitting up programs and 
              running them on multiple computers).</li>
              <li><a href="https://contextily.readthedocs.io/">
              Contextily</a>
              - for retrieving tile maps from the Internet, then adding them to 
              matplotlib figures or writing them to files.</li>
              <li><a href="https://github.com/Toblerity/Fiona">Fiona</a>
              - reads and writes geographic data files.</li>
              <li><a href="https://python-visualization.github.io/folium/">
              Folium</a> - for visualising data on an interactive javascript
              map.</li>
              <li><a href="https://geopandas.org/">Geopandas</a>
              - extends the data types used by 'pandas' to include geometry (and 
              has support for many geometry operations).</li>
              <li><a href="https://geopy.readthedocs.io/">GeoPy</a>
              - a client for several popular geocoding web services.</li>
              <li><a href="https://matplotlib.org/">matplotlib</a>
              - a comprehensive library for creating static, animated, and 
              interactive visualizations.</li>
              <li><a href="http://www.nltk.org/">nltk</a>
              - a Natural Language Toolkit for parsing and analysing text.</li>
              <li><a href="http://www.numpy.org/">numpy</a>
              - useful for mathematics and statistics, especially 
              multi-dimensional array manipulation.</li>
              <li><a href="http://pandas.pydata.org/">pandas</a>
              - useful for a range of other things including time series 
              analysis.</li>
              <li><a href="https://docs.qgis.org/3.10/en/docs/pyqgis_developer_cookbook/">
              PyQGIS</a>
              - <a href="https://www.qgis.org/">QGIS</a> API.</li>
              <li><a href="http://scikit-learn.org/">scikit-learn</a>
              - useful for scientific analysis and machine learning.</li>
              </ul>
              <p>For details on installing packages see: 
              <a href="../python/index.html#9">Python Packages and Environment Management</a>.</p>
              """);
        w.add("</div>");
    }
}
