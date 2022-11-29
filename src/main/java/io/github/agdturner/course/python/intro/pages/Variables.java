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
              <p>Python variables are a combination of an identifying label and 
              a primitive value or an object. They work a bit differently 
              depending on whether the variable is a primitive value or an 
              object. Objects comprise other things which may include other 
              objects and/or primitive values. Consider the following code in
              which a variable x is defined and set equal to the value 0. Then
              another variable label y is set to be equal to the value of x:</p>
              <pre><code class=\"language-python\">
              x = 0
              y = x
              print(y)
              </code></pre>
              <p>The output from running this code is:</p>
              <pre>0</pre>
              <p>Pick a way of running Python code and try this yourself.</p>
              
              <h2>2. Variables types</h2>
              
              Variable labels can be reused and set to different values changing 
              the type. This is known as dynamic typing. It allows us to set a 
              variable as an Integer and then set it again to be a String or a 
              List or anything. The Type Function in the Built In Module allows 
              for testing the type of a variable. The following code sets a 
              variable called x to have the Integer value 1, then sets it again
              to have the String value "1".</p>
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
              <p>Again, try this yourself.</p>
                            
              <h3>2.1. Primitives</h3>
              <p>The four primitive variable types are: Integers, Floats, 
              Strings, and Booleans. Integers are whole numbers. Floats are a 
              subset of fractions. Strings are text. Booleans are True or False
              and also equate to 0 or 1.</p>
              <p>Integers are virtually unbounded in Python although there is 
              ultimately a limit based on the size of a word that Python and the 
              machine can handle. Take care if you want to process numbers with 
              more than 2 to the power of 63 digits.</p>
              <p>Floats have a Maximum Value and a Minimum Normal Value 
              (smallest number > 0) that can be ascertained from the sys 
              module and can also be set to postive or negative infinity:</a>
              <pre><code class=\"language-python\">
              import sys
              
              # Exploring Float max and min values.
              max = sys.float_info.max
              min = sys.float_info.min
              print("max", max)
              print("min", min)
              
              # Are there any changes?
              print("max + min", max + min)
              print("max - min", max - min)
              print("min + min", min + min)
              
              # What number do we need to add to max to get inf?
              max2 = max
              d = 2
              while max2 == max:
                  max2 = max2 + d
                  d *= 2
              d = d / 2
              print("d", d)
              print("max + d/2", max + d/2)
              print("max + d", max + d)
              
              # Find a number bigger than min which is the same when min is 
              # added to it. 
              min2 = min * 10**16
              min3 = min2 + min
              if min3 > min2:
                  print("min3 > min2")
              print("min2", min2)                                                        
              </code></pre>
              <p>This code generates the following output:</p>
              <pre>              
              max 1.7976931348623157e+308
              min 2.2250738585072014e-308
              max + min 1.7976931348623157e+308
              max - min 1.7976931348623157e+308
              min + min 4.450147717014403e-308
              d 9.9792015476736e+291
              max + d/2 1.7976931348623157e+308
              max + d inf
              min2 2.2250754194454158e-293
              </pre>
              <p>Float is extremely useful, but for geometry care is needed in 
              working with floating point numbers.</p>
              <p><a href="https://docs.python.org/3/library/decimal.html#floating-point-notes">
              Python documentation floating point notes</a></p>
              <p>Python supports other types of number which you may find 
              useful:</p>
              <ul>
              <li><a href="https://docs.python.org/3/library/decimal.html">decimal</a></li>
              <li><a href="https://docs.python.org/3/library/fractions.html">fractions</a></li>
              </ul>
              <p>If these are not suited to your needs (perhaps in the future) 
              then your needs are especially interesting to me, so if you can, 
              please let me know...</p>
              <p>Strings are assigned in double quotes and can be checked for 
              equality using the == operator:</p>
              <pre><code class=\"language-python\">
              s = "A"
              s2 = "a"
              s3 = "B"
              print("s == s", s == s)
              print("s == s2", s == s2)
              print("s == s3", s == s3)
              </code></pre>
              <p>This code generates the following output:</p>
              <pre>
              s == s True
              s == s2 False
              s == s3 False
              </pre>
              <p>Some code to explore Boolean:</p>
              <pre><code class=\"language-python\">
              t = True
              f = False                            
              print("t == t", t == t)
              print("f == f", f == f)
              print("t == 1", t == 1)
              print("f == 0", f == 0)
              </code></pre>
              <p>This code generates the following output:</p>
              <pre>
              t == t True
              f == f True
              t == 1 True
              f == 0 True
              </pre>
              
              <h3>2.2. Objects</h3>
              <p>The following code sets the variable x to be 1 and y to equal 
              x, it then adds 1 to the value of x and prints out y.</p>
              <pre><code class=\"language-python\">
              x = 1
              y = x
              x = x + 1 # This is the same as: x += 1
              print(y)
              </code></pre>
              <p>The output from running this code is:</p>
              <pre>1</pre>
              <p>So, y only has the same value as x until x is given a new 
              value.</p>
              <p>The following code: creates a list variable called a, sets 
              b to be a new label for a, appends the Integer 1 to the list a,
              and then prints out b.</p>
              <pre><code class=\"language-python\">
              a = [] # Assign a as a new empty List.
              b = a
              a.append(1) # Append the Integer 1 to the List
              print(b)
              </code></pre>
              <p>The output from running this code is:</p>
              <pre>[1]</pre>
              <p>So, a and b are still referring to the same thing, the same 
              list. Try appending another thing to the list and printing out 
              a and b to check they are the same.</p>
              <p>Now, if a is reassigned, then b will left referring to the list 
              with the Integer 1 and whatever else was appended to it (rather 
              than b also being equal to whatever a was reassigned to).<p>
              <p>Spend some time thinking about this key difference between 
              variables that are primitive and variables that are objects. We 
              will revisit this when considering functions and scope...</p>
              
              <h2>3. Fun
              <h2>3. Variable Scope and the Global Keyword</h2>
              <p>The scope of a variable is where it is defined and it's value 
              can be accessed. The global keyword can modify the scope.</p>
              <p>Run the following code:</p>
              <pre><code class=\"language-python\">
              x = 1
              if x == 1:
                  y = 2
              print(y)
              </code></pre>
              <p>You should get a syntax error:</p>
              <pre>
              
              </pre>
              # Assign a as a new empty List.
                            b = a
                            a.append(1) # Append the Integer 1 to the List
                            print(b)
                            </code></pre>
                            
              <p>Whilst we have a list, try adding something of a different type
              into the list. 
              <pre><code class=\"language-python\">
              a = 2
              print(b)
              </code></pre>
              <p>Will result still in:</p>
              <pre>[1]</pre>
              """);
        
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
