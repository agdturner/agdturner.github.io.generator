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
              <h2 id="1">1. Introduction</h2>
              <p>Python variables are a combination of an identifying label (a 
              name) and a value - either a primitive or a more complex object
              (the object may be comprised of multiple primitive variables and 
              other objects).</p>
              <p>Variables work a bit differently depending on whether they are 
              primitives or objects. The main difference is to do with whether 
              the variable is duplicated when it is passed into a function as a 
              parameter (known as 'pass by value') or whether a reference or 
              pointer is passed in which refers to the value of the variable 
              (known as 'pass by reference').</p>
              
              <h2 id="2">2. Variables/types</h2>
              In Python, variable labels/names can be reused to refer to 
              different types of value. This is known as dynamic typing. It 
              allows for a variable to be initialised with one type of value and 
              then later to be assigned a different type of value. The function 
              'type()' in the 
              (<a href="https://docs.python.org/3/library/builtins.html">
              builtins</a> module)
              can be used to test and reporting the type of a variable. For 
              example, the following code initialises a variable called x to 
              have the Integer value 1, then sets it again to have the String 
              value "1", after each assignment the type of the variable is 
              printed.</p>
              <pre><code class="language-python"># Set x = 1 and print the type of x")
              x = 1
              print(type(x))
              x = "1"
              print(type(x))</code></pre>
              <p>The output from running this code is:</p>
              <pre>&lt;class 'int'&gt;
              &lt;class 'str'&gt;</pre>
              <p>Again, try this yourself.</p>
              <p>In declarative programming languages, the type of a variable 
              is declared. If the language is statically typed, then the 
              variable is not permitted to change type. In python, the type of 
              a variable is not declared, and variable labels can be reassigned 
              to refer to different types of thing. The main benefits of this 
              are that code can be more succinct and application programming 
              interfaces can be more stable. However, with dynamic typing it is 
              easier to accidentally re-use a variable name, it can make 
              debugging code harder, and it can make developing tools to help 
              write code harder. Testing the type of a variable can help 
              mitigate some of the issues, but doing this a lot makes code 
              overly verbose and inefficient.</p>
                            
              <h3 id="2.1">2.1. Primitives</h3>
              <p>The four primitive variable types in python are: Integers, 
              Floats, Strings, and Booleans. Integers are whole numbers. Floats 
              are a special subset of fractions. Strings are essentially blocks 
              of text. Booleans are True or False and also equate to 0 or 1.</p>
              <p>Integers are virtually unbounded in python although there is 
              limit to the size of an Integer that a system can handle related 
              to the amount of memory available.</p>
              <p>Floats have a Maximum Value and a Minimum Normal Value 
              (smallest number &gt; 0). These can be ascertained from the 
              <a href="https://docs.python.org/3/library/sys.html">sys module</a>
              and can also be set to postive or negative infinity:</a>
              <pre><code class="language-python">import sys
              
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
              print("min2", min2)</code></pre>
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
              min2 2.2250754194454158e-293</pre>
              <p>Float is very useful, but programmers must bear in mind 
              the approximate nature of calculations with these numbers.</p>
              <p>The standard library has two very useful number types that 
              provide more calculation precision and can represent many more
              rational numbers:</p>
              <ul>
              <li><a href="https://docs.python.org/3/library/decimal.html">decimal</a></li>
              <li><a href="https://docs.python.org/3/library/fractions.html">fractions</a></li>
              </ul>
              <p>Strings can be assigned using; double or single quotes, and the 
              str() constructor function (which can for example create a String 
              from an Integer. Strings can be compared and checked for equality.
              Consider the following code:</p>
              <pre><code class="language-python">s = "A"
              s2 = "a"
              s3 = "B"
              print(s == s)  # True
              print(s == s2) # False (case sensitive)
              print(s == s3) # False
              print(s > s2)  # False
              print(s < s2)  # True
              print(str(3))  # 3
              </code></pre>
              <p>Some code to explore Boolean:</p>
              <pre><code class="language-python">t = True
              f = False                            
              print("t == t", t == t)             # True
              print("f == f", f == f)             # True
              print("t == 1", t == 1)             # True
              print("f == 0", f == 0)             # True
              print("t != f", t != f)             # True
              print("not t", not t)               # False
              print("not f", not f)               # True
              print("t and f", t and f)           # False
              print("t and not f", t and not f)   # True
              print("t or f", t or f)             # True
              print("not (t or f)", not (t or f)) # False</code></pre>
              
              <h3>2.2. Objects</h3>
              <p>The following code sets the variable x to be 1 and y to equal 
              x, it then adds 1 to the value of x and prints out y.</p>
              <pre><code class="language-python">
              x = 0    # Set x equal to 0
              y = x    # Set y equal to x
              x = 1    # Set x to a different value
              print(y) # 0 (y no longer equals x)
              </code></pre>
              <p>So, y only has the same value as x until x is assigned another 
              value.</p>
              <p>The following code: creates a list variable called a, sets 
              b to equal a, appends the Integer 1 to the list a, and then prints 
              out b.</p>
              <pre><code class="language-python">
              a = [] # Assign a to equal a new empty List.
              b = a  # Set b to equal a
              a.append(1) # Append the Integer 1 to the List a
              print(b) # [1]
              </code></pre>
              <p>The output from running this code is:</p>
              <pre>[1]</pre>
              <p>So, a and b are still referring to the same thing, the same 
              list. That is because appending to the list does not change the 
              references to the list, it changes what is in the list.</p>
              <p>Try running this code and then modify it to append another 
              thing to the list and print out a and b to check they are still 
              the same.</p>
              <p>Now, if a is reassigned, then b will still refer to the list 
              containing the Integer 1 (and whatever else was appended to it).
              Have a play around to help this make sense.</p>
              
              <h2 id="3">3. Functions, Variable Scope and the Global Keyword</h2>
              <p>The scope of a variable is from where in the code it can be 
              accessed. The keyword 'global' can modify the scope.</p>
              <p>Consider the following code:</p>
              <pre><code class="language-python">x = 1
              if x == 1:
                  y = 2
              print(y)</code></pre>
              <p>That outputs:</p>
              <pre>2</pre>
              <p>The code in the If Statement is executed as the condition 
              x == 1 evaluates as True. If the conidtion were to evaluate as 
              False, then the interpreter would skip to the end of the If 
              Statement, as in the following code:</p>
              <pre><code class="language-python">x = 1
              if x == 0:
                  y = 2
              print(y)</code></pre>
              <p>That results in:</p>
              <pre>NameError: name 'y' is not defined</pre>
              <p>This is because y does not get initialised and so cannot be 
              passed into the print function.</p>
              <p>Consider the following code:</p>
              <pre><code class="language-python">x = 1
              def my_function():
                  x = 2
                  print("b", x)     
              print("a", x)
              my_function()
              print("c", x)</code></pre>
              <p>That outputs:</p>
              <pre>a 1
              b 2
              c 1</pre>
              <p>At line 2, the interpreter reads a function definition for a 
              function called my_function(), then skips to the end of the 
              function and executes line 5. Then at line 6 my_function() is 
              called. The interpreter then effectively goes back to line 2 and 
              runs the function commands (lines 2 to 4). Then, at the end of the 
              function, the interpreter returns to line 6 and moves directly on 
              to line 7.</p> 
              <p>In this example, the variable inside the function called x is a 
              different variable to the variable called x that is referred to 
              outside of the function (even though the names are the same). 
              Using the keyword 'global', we can make these variables the same 
              as follows:</p>
              <pre><code class="language-python">x = 1
              def my_function():
                  global x
                  x = 2
                  print("b", x)           
              print("a", x)
              my_function()
              print("c", x)</code></pre>
              <p>The output should be:</p>
              <pre>a 1
              b 2
              c 2</pre>
              <p>Try the code yourself and play around to test your 
              understanding.</p>
              <p>More details about functions will be provided shortly as they 
              are a key aspect of programming...</p>
              
              <h2 id="4">4. Deleting variables</h2>
              <p>Variables can be deleted using the keyword 'del' 
              followed by the name of the variable or a Tuple of variables to 
              delete.</p>
              <p>Deleting variables can free up resources that can be used by 
              other things. The following code snippets shows how to initialise 
              a variable called and then delete it:<p>
              <pre><code class="language-python">a = 1
              del a # <-- deletes a
              #print(a) # <-- Would result in: NameError: name 'a' is not defined
              b = 2
              c = 3
              del(b, c) # <-- deletes b and c</code></pre>
              """);
        w.add("</div>");

    }
}
