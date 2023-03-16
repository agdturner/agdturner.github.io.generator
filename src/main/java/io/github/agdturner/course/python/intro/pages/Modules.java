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
package io.github.agdturner.course.python.intro.pages;

import io.github.agdturner.course.python.intro.PythonIntroCourse;
import io.github.agdturner.course.Page;

/**
 * For Python Intro Course Modules Page.
 *
 * @author Andy Turner
 */
public class Modules extends Page {
    
    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Modules(PythonIntroCourse c) {
        super("modules", "Modules", "Modules", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2 id="1">1. Introduction</h2>
              <p>In Python a 'module' is a single file that may contain classes, 
              functions and variables. It should be imported to make these 
              things accessible and those things are then referred to using the 
              module name and the dot operator '.'.</p>
              <p>'Packages' are collections of modules structured using a 
              directory tree.</p>
              <p>A code 'library' is a name for a collection of code that 
              can be used to do specific things. So, in Python terms, a library 
              is a collection of modules and packages.</p>
              
              <h2 id="2">2. Importing</h2>
              <p>To recap, the 
              python standard library
              <!--" math and operator and https://docs.python.org/3/py-modindex.html"-->
              contains numerous 
              packages which are not imported automatically. These need to be 
              imported in order to be used.</p>
              <p>There are two types of import statement, those that begin with
              the keyword 'import' and others that begin with the keyword 
              'from' and also contain the keyword 'import'.</p>
              <p>The following code imports a module called agentframework and 
              then constructs an instance of the Agent class:</p>
              <pre><code class="language-python">import agentframework
              a = agentframework.Agent()</code></pre>
              <p>This is a very explicit style. There is little ambiguity about 
              which Agent class is used - it is the one from the agentframework 
              module.</p>
              <p>Another way to create instances of the Agent class is as 
              follows:</p>
              <pre><code class="language-python">from agentframework import Agent
              a = Agent()</code></pre>
              <p>The advantages of this is that it is less verbose the more 
              times instances of the Agent class are instantiated. Also this 
              imports just that specific class from the agentframework module 
              rather than the entire module which is more memory efficent.</p>
              <p>You may see imports of everything in a module using the star
              operator '*', for example:</p>
              <pre><code class="language-python">from agentframework import *</code></pre>
              <p>This saves having to import multiple classes, but it is 
              dangerous as imported classes might replace classes you have 
              imported elsewhere. It is best to be explicit and import 
              individually all those things that are used and nothing else.</p>
              <p>The keyword 'as' can be used to alias a module or a class which 
              also helps to save typing, for example the following are 
              alternatives for creating and agentframework Agent class
              instance:</p>
              <pre><code class="language-python">import agentframework as af
              a = af.Agent()</code></pre>
              <pre><code class="language-python">from agentframework import Agent as A
              a = A()</code></pre>
              <p>The python interpreter parses modules on import initialising
              variables and setting up so that functions and classes can be 
              used. Within the module, any code not in a function or a class is 
              run when the module is imported as is any code within a class that 
              is not in a method. This means that sometimes there can be side 
              effects of importing modules. It can be argued that the less code 
              that is run when the module is imported the better!</p>
              <p>When running a module as a script, it is generally best to set 
              it up as a 'double headed' file, that can be run as a script with 
              isolated code. Scripts are run with the global __name__ variable 
              set to "__main__", so adding the following code in a module allows 
              it to run as a script without contaminating the environment:</p>
              <pre><code class="language-python">if __name__ == "__main__":
                  function_name() # <-- do something </code></pre>
                            
              <h2 id="3">3. Packages</h2>
              <p>Consider the following package file structure:</p>
              <pre><code class="language-python">/abm
                  __init__.py
                  /general
                      __init__.py
                      agentframework.py
                  /models
                      __init__.py
                      model.py</code></pre>
              <p>The __init__.py files can be empty, but they must exist so the 
              python interpreter recognise these subdirectories as subpackages
              and allowing import statements to work as follows:</p>
              <pre><code class="language-python">import abm.general.agentframework.Agent</code></pre>
              <p>This import statement will work so long as there is a class 
              called Agent within the agentframework module</p>
              <p>The base __init__.py file in the abm directory can also include 
              a specially named list which will import specific subpackages if a 
              star import statement is used. For example, the following could be 
              the contents of /abm/__init__.py:</p>
              <pre>__all__ = ["models", "general"]</pre>
              <p>For which the following import statement would import both the 
              general and models subpackages:</p>
              <pre><code class="language-python">from abm import *</code></pre>
              <p>Packages can be set to run as applications by placing startup 
              code in a file called '__main__.py'. The following command would 
              then run the application when issued at the prompt:</p>
              <pre>python -m packagename</pre>
              
              <h2 id="4">4. Standard Libraries</h2>
              <p>The <a href="https://docs.python.org/3/library/functions.html">
              Builtin Functions List</a> and the
              <a href="https://docs.python.org/3/py-modindex.html">
              Python Module Index</a> contain numerous libraries useful for 
              geographical data processing, including:
              <ul>
              <li><a href="https://docs.python.org/3/library/difflib.html">
              difflib</a> - for comparing text documents.</li>
              <li><a href="https://docs.python.org/3/library/unicodedata.html">
              unicodedata</a> - for dealing with complex character sets.</li>
              <li><a href="https://docs.python.org/3/library/re.html">
              regex</a> - for text and name searching and processing based on 
              patterns.</li> 
              <li><a href="https://docs.python.org/3/library/math.html">
              math</a> - for mathematics.</li>
              <li><a href="https://docs.python.org/3/library/decimal.html">
              decimal</a> - for high precision numerical calculations.
              </li>
              <li><a href="https://docs.python.org/3/library/fractions.html">
              fractions</a> - for dealing with rational numbers (fractions).
              </li>
              <li><a href="https://docs.python.org/3/library/argparse.html">
              argparse</a> - parser for command-line options, arguments and 
              sub-commands.</li>
              <li><a href="https://docs.python.org/3/library/datetime.html">
              datetime</a> - for dates and times, plus getting the current 
              date/time.</li>
              <li><a href="https://docs.python.org/3/library/binary.html">
              binary</a> - for dealing with binary data.</li>
              <li><a href="https://docs.python.org/3/library/struct.html">
              struct</a> - also for dealing with binary data.</li>
              <li><a href="https://docs.python.org/3/library/bisect.html ">
              bisect</a> - for searching and sorting very large arrays.</li>
              <li><a href="https://docs.python.org/3/library/collections.html">
              collections</a> - for storing and organising multiple things.</li>
              <li><a href="https://docs.python.org/3/library/collections.html#collections.Counter">
              counter</a> - for counting things.</li>
              <li><a href="https://docs.python.org/3/library/tk.html">
              tkinter</a> - for developing Graphical User Interfaces (windows, menus, buttons, sliders etc.)</li>
              <li><a href="https://docs.python.org/3/library/turtle.html">
              turtle</a> - for drawing.</li>
              <li><a href="https://docs.python.org/3/library/sqlite3.html">
              sqlite3</a> - for building and managing SQLite databases.</li>
              <li><a href="https://docs.python.org/3/library/statistics.html">
              statistics</a> - for basic summary statistics.</li>
              <li><a href="https://docs.python.org/3/library/random.html">
              random</a> - for sampling and doing things randomly.</li>
              </ul>
              
              <h2 id="5">5. Third Party Libraries</h2>
              <p>Anaconda comes bundled with numerous third party libraries. 
              Exactly what it comes with varies with the version and underlying 
              operating system. Details can be found via the following URL:
              <a href="https://docs.anaconda.com/anaconda/packages/pkg-docs/">
              https://docs.anaconda.com/anaconda/packages/pkg-docs/</a></p>
              <p>There are many more libraries that might be useful for 
              geographical data processing or whatever you may be doing.</p>
              <p>Many python libraries are made available via the
              <a href="https://pypi.python.org/pypi">
              Python Package Index (PyPi)</a>.</p>
              
              <h3 id="5.1">5.1. General utility</h3>
              <p>The following is a list of some widely used libraries for 
              computational geography:</p>
              <ul>
              <li><a href="http://www.numpy.org/">numpy</a> is useful for 
              mathematics and statistics, especially multi-dimensional array 
              manipulation.</li>
              <li><a href="http://pandas.pydata.org/">panda</a> build on NUMPY
              and is useful for a range of other things including time series 
              analysis.</li>
              <li><a href="http://scikit-learn.org/">scikit-learn</a> again 
              founded on numpy is useful is useful for scientific analysis and 
              machine learning.</li>
              <li><a href="https://beautiful-soup-4.readthedocs.io/">
              beautiful-soup</a> is useful for pulling data out of HTML and XML 
              files.</li>
              <li><a href="http://www.nltk.org/">nltk</a> is a Natural Language 
              Toolkit for parsing and analysing text.</li>
              <li><a href="http://www.celeryproject.org/">celery</a> is useful 
              for distributed computing (splitting up programs and running them 
              on multiple computers).</li>
              </ul>
              
              <h3 id="5.2">5.2. Geospatial</h3>
              <p>Some of these were used in the introduction to the course:</p>
              <ul>
              <li><a href="https://docs.qgis.org/3.10/en/docs/pyqgis_developer_cookbook/">
              PyQGIS</a> - <a href="https://www.qgis.org/">QGIS</a> API.</li>
              <li><a href="https://pro.arcgis.com/en/pro-app/latest/arcpy/get-started/what-is-arcpy-.htm">
              ArcPY</a> - <a href="https://www.esri.com/en-us/arcgis/products/arcgis-pro/overview">ArcGIS Pro</a> API.</li>
              <li><a href="https://github.com/Toblerity/Fiona">Fiona</a> - reads
              and writes geographic data files.</li>
              <li><a href="https://geopandas.org/">Geopandas</a> - extends the 
              datatypes used by pandas to include geometry (and has support for 
              many geometry operations).</li>
              <li><a href="https://geopy.readthedocs.io/en/stable/">GeoPy</a> - 
              a client for several popular geocoding web services.</li>
              <li><a href="https://contextily.readthedocs.io/en/latest/">
              Contextily</a> - for retrieving tile maps from the internet, then 
              adding them to matplotlib figures or writing them to files.</li>
              <li><a href="https://python-visualization.github.io/folium/">
              Folium</a> - for visualising data on an interactive javascript
              map.</li>
              </ul>
              <p>For details on installing packages see: 
              <a href="../python/index.html#9">Python Packages and Environment Management</a>.</p>
              """);
//              <pre></pre>
//              <pre><code class="language-python"></code></pre>
//              <p></p>
//              <pre></pre>
//              
        w.add("</div>");
    }
}
