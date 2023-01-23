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
              <h2>1. Introduction</h2>
              <p>A module is usually a single file that may contain classes, 
              functions and variables. It should be imported to make these 
              things accessible and those things are then referred to using the 
              module name and the Dot Operator (.).
              </p>
              <p>Packages are collections of modules structured using a 
              directory tree.</p>
              <p>libraries is a generic name for a collection of code that 
              can be used to do specific things.</p>
              <p>The Standard Python Library comes with a number of other
              packages which are not imported automatically. These need to be 
              imported in order to be used.</p>
              
              <h2>2. Importing</h2>
              <p>A couple of different types of import statement should now be 
              familiar. The following imports a module and then access the Agent
              class within it to construct an instance of that class:<p>
              <pre><code class=\"language-python\">import agentframework
              a = agentframework.Agent()</code></pre>
              <p>This is a very explicit style. There is little ambiguity about 
              which Agent class is to be used (if other imported modules have 
              Agent classes). Provided there are no other modules with the same 
              name with an Agent class, there is not going to be a problem.</p>
              <p>If there is nothing else called Agent then the following can be 
              used:</p>
              <pre><code class=\"language-python\">from agentframework import Agent
              a = Agent()</code></pre>
              <p>The advantages of this is that it can involve slightly less 
              typing and this imports just one class from a module rather than 
              an entire module which is more memory efficent.</p>
              <p>You may see imports of everything in a module using the Star
              Operator (*), for example:</p>
              <pre><code class=\"language-python\">from agentframework import *</code></pre>
              <p>This saves having to import multiple classes, but it is 
              dangerous as imported classes might replace classes you have 
              imported elsewhere.</p>
              <p>In other languages, with better documentation and file 
              structures, it is easier to find out what classes are in 
              libraries, so this kind of syntax is more acceptable with those, 
              but in Python, it is better to avoid doing this and be more 
              explicit.</p>
              <p>The As Keyword (as) can be used to alias a module which helps 
              to save typing, for example:</p>
              <pre><code class=\"language-python\">import agentframework as af
              from af import Agent as A
              a = A()</code></pre>
              <p>When importing, Python will import parent packages (but not 
              subpackages).</p>
              <p>Modules are parsed on import to set up any variables and so 
              that the interpretter knows what functions and classes there are.
              Within the module, any code not in a function or a class is run
              when the module is imported as is any code within a class, but not
              in any method. This means that sometimes there can be side effects 
              of importing modules. It is generally best not to add lots of code 
              into modules that is run when the module is imported.</p>
              <p>When running a module as a script, it is generally best to set 
              it up as a 'double headed' file, that can be run as a script with 
              isolated code. Scripts are run with the global __name__ variable 
              set to "__main__", so adding the following code in a module allows 
              it to run as a script without contaminating the environment:</p>
              <pre><code class=\"language-python\">if __name__ == "__main__":
                  # Imports needed for running.
                  function_name()</code></pre>
                            
              <h2>2. Packages</h2>
              <p>Consider the following package file structure:</p>
              <pre><code class=\"language-python\">/abm
                  __init__.py
                  /general
                      __init__.py
                      agentframework.py
                  /models
                      __init__.py
                      model.py</code></pre>
              <p>The __init__.py files can be empty. Essentially, these allow 
              Python to recognise that the subdirectories are sub-packages. This
              allows the following import statement to work so long as there is 
              a class called Agent within the agentframework module:</p>
              <pre><code class=\"language-python\">import abm.general.agentframework.Agent
              <p>The base __init__.py file can also include a specially named 
              list which will import all the listed subpackages if a star 
              import statement is used. For example, the following could be the 
              contents of /abm/__init__.py:</p>
              <pre>__all__ = ["models", "general"]</pre>
              <p>For which the following import statement would import both the 
              general and models subpackages:</p>
              <pre><code class=\"language-python\">from abm import *</code></pre>
              <p>Packages can be set to run as applications by placing startup 
              code in a file called __main__.py and the following command is 
              issued at the prompt:</p>
              <pre>python -m packagename</pre>
              
              <h2>3. Standard Libraries</h2>
              <p>Browse <a href="https://docs.python.org/3/library/functions.html">
              The Builtin Functions List</a> and
              <a href="https://docs.python.org/3/py-modindex.html">
              The Python Module Index</a>. It is worth spending 
              a little time to get acquainted with what is there. Here are some
              particularly useful libraries with a summary of what they are 
              useful for:
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
              Counter</a> - for counting things.</li>
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
              
              <h2>3. External Libraries</h2>
              <p>Anaconda comes bundled with some useful external libraries. The
              package lists vary depending on the underlying operating system.
              Details can be found via the following URL:
              <a href="https://docs.anaconda.com/anaconda/packages/pkg-docs/">
              https://docs.anaconda.com/anaconda/packages/pkg-docs/</a></p>
              <p>There are many more libraries that might be useful for 
              geographical data processing or whatever you may be doing.</p>
              <p>As mentioned previously a large number of libraries are 
              available via:
              <a href="https://pypi.python.org/pypi">
              The PyPi Python Package Index</a>.
              <p>The following is a list of some widely used libraries:</p>
              <ul>
              <li><a href="http://www.numpy.org/">NUMPY</a> is useful for 
              mathematics and statistics, especially multi-dimensional array 
              manipulation.</li>
              <li><a href="http://pandas.pydata.org/">PANDAS</a> build on NUMPY
              and is useful for a range of other things including time series 
              analysis.</li>
              <li><a href="http://scikit-learn.org/">SCIKIT-LEARN</a> again 
              founded on numpy is useful is useful for scientific analysis and 
              machine learning.</li>
              <li><a href="https://beautiful-soup-4.readthedocs.io/">
              BEAUTIFUL SOUP</a> is useful for pulling data out of HTML and XML 
              files.</li>
              <li><a href="http://www.nltk.org/">NLTK</a> is a Natural Language 
              Toolkit for parsing and analysing text.</li>
              <li><a href="http://www.celeryproject.org/">CELERY</a> is useful 
              for distributed computing (splitting up programs and running them 
              on multiple computers).</li>
              </ul>
              <p>For details on installing packages see the section on 
              <a href="../../python/index.html#9">Python Packages and Environment Management</a>.</p>
              
              """);
//              <pre></pre>
//              <pre><code class=\"language-python\"></code></pre>
//              <p></p>
//              <pre></pre>
//              
        w.add("</div>");
    }
}
