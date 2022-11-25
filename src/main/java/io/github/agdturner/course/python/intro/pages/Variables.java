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
 * For Python Intro Course Variables Page.
 *
 * @author Andy Turner
 */
public class Variables extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Variables(PythonIntroCourse c) {
        super("variables", "Variables", "Variables", c);
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        //w.add("<div>");
        w.add("""
              <h2>1. Introduction</h2>
              <p>Variables can be thought of as labels that are assigned values
              which may change. The following code is comprised of three 
              statements. The first initialises a variable x and assigned it the 
              value 0. The second initialises a variable y and assigns it the 
              value of the x variable. The third statement prints out the value 
              of y.</p>
              <pre><code class=\"language-python\">
              x = 0
              y = x
              print(y)
              </code></pre>
              <p>The output from running this code is:</p>
              <pre>0</pre>
              <h2>2. Variables types</h2>
              <p>In Python, there are primitive and non-primitive variable
              types. The four primitive variable types are: Integers, Floats, 
              Strings, and Booleans. Everyhing else is a non-primitive type. 
              Variable declaration and assignment in Python are done in a single 
              step where the type of a variable is not explicitly set, it is 
              inferred by what is set. Variable labels can be reused and set to 
              different values changing the type. This is known as dynamic
              typing. It allows us to set a variable as an Integer and then set 
              it again to be a String or a List or anything. The built in 
              function type allows us to test the type of a variable. The
              following code sets a variable called x to have the Integer value 
              1, then sets it again to have the String value "1".</p>
              <pre><code class=\"language-python\">
              # Set x = 1 and print the type of x")
              x = 1
              print(type(x))
              x = "1"
              print(type(x))
              </code></pre>
              <p>The output from running this code is:</p>
              <pre>
              &lt;class 'int'&gt;
              &lt;class 'str'&gt;
              </pre>
              <p>The following code sets the variable x to be 1 and y to equal 
              x, it then adds 1 to the value of x and prints out y.</p>
              <pre><code class=\"language-python\">
              x = 1
              y = x
              x += 1
              print(y)
              </code></pre>
              <p>The output from running this code is:</p>
              <pre>1</pre>
              <p>So, y is only the value of x until x is given a new value.</p>
              <p>The following code: creates a list variable called a, sets 
              b to be a new label for a, appends the Integer 1 to the list a,
              and then prints out b.</p>
              <pre><code class=\"language-python\">
              a = []
              b = a
              a.append(1)
              print(b)
              </code></pre>
              <p>The output from running this code is:</p>
              <pre>[1]</pre>
              <p>So, a and b are still referring to the same thing.</p>""");
        
        w.add("<p></p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("for a in range(0, 10) :\n"
                + "    print (a)\n"
                + "    print (\"done\")");
        w.add("</code></pre>");

        w.add("<p></p>");
        w.add("<p></p>");
        w.add("<p></p>");
        w.add("<p></p>");

    }
}
