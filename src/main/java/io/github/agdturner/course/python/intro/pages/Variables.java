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
              <p>Python variables are a combination of an identifying label or 
              name and a value - either a primitive or a more complex object
              (which may comprise a single primitive variable or be comprised of 
              multiple other primitive variables and other objects).</p>
              <p>Variables work a bit differently depending on whether they are 
              primitives or objects. The main difference is to do with whether 
              the variable is duplicated when it is passed into a function as a 
              parameter or whether a reference or pointer is passed in which 
              still refers to the value of the variable. There are other 
              differences to do with scope, but let's not worry about this for 
              now, we will revise all this in due course...</p>
              
              <h2>2. Variables Types</h2>
              In Python, variable labels/names can be reused to refer to 
              different types of value. This is known as dynamic typing. It 
              allows us to initialise a variable with an Integer value and then 
              set it later to have a value given by a Float or a String or 
              something non-primitive like a List. The Type Function (type()) in 
              the Built In Module 
              (<a href="https://docs.python.org/3/library/builtins.html">builtins</a>)
              allows for testing the type of a variable at some stage of a 
              program execution. For example, the following code initialises a
              variable called x to have the Integer value 1, then sets it 
              again to have the String value "1", after each assignment the type 
              of the variable is printed.</p>
              <pre><code class=\"language-python\"># Set x = 1 and print the type of x")
              x = 1
              print(type(x))
              x = "1"
              print(type(x))</code></pre>
              <p>The output from running this code is:</p>
              <pre>&lt;class 'int'&gt;
              &lt;class 'str'&gt;</pre>
              <p>Again, try this yourself.</p>
              <p>In declarative programming languages, the type of a variable 
              is declared. If the langauge is statically typed, then the 
              variable is not permitted to change type. Some of the most 
              commonly used high level languages (including 
              <a href="https://en.wikipedia.org/wiki/Java_(programming_language)">Java</a>) are both 
              declarative and statically typed.</p>
              <p>The type of Python variables do not have to be declared, and 
              labels can be reassigned to different types of thing. There are 
              both benefits and drawbacks of this. Code can look a bit more 
              succinct, interfaces can be more stable, and some developers find 
              it easier to experiment this way, but there are dangers and 
              some things are much harder with dynamically typed langauges, for 
              example writing tools for developing code. It is possible though,
              as we have seen, to test the type of a variable, so type safety 
              checks can be added to code. However, this makes code more verbose 
              and less efficient.
              <p>
                            
              <h3>2.1. Primitives</h3>
              <p>The four primitive variable types in Python are: Integers, 
              Floats, Strings, and Booleans. Integers are whole numbers. Floats 
              are a special subset of fractions. We've looked at these briefly 
              before. Strings are essentially blocks of text. We created some of 
              these too already. Booleans are True or False and also equate to 0 
              or 1.</p>
              <p>Integers are virtually unbounded in Python although there is 
              ultimately a limit based on the size of a word that Python and the 
              machine can handle (which is typically very large, but depends on 
              available memory).</p>
              <p>Floats have a Maximum Value and a Minimum Normal Value 
              (smallest number > 0). These can be ascertained from the Sys 
              Module (sys) and can also be set to postive or negative 
              infinity:</a>
              <pre><code class=\"language-python\">import sys
              
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
              <p>Float is extremely useful, but programmers must bear in mind 
              the approximate nature of calculations with these numbers. In
              geographical contexts care is especially needed when computing 
              geometrical intersections.</p>
              <p><a href="https://docs.python.org/3/library/decimal.html#floating-point-notes">
              Python documentation floating point notes</a></p>
              <p>Python supports other types of number which you may find 
              useful:</p>
              <ul>
              <li><a href="https://docs.python.org/3/library/decimal.html">decimal</a></li>
              <li><a href="https://docs.python.org/3/library/fractions.html">fractions</a></li>
              </ul>
              <p>Strings can be assigned using; double or single quotes, and the 
              str() constructor function (which can for example create a String 
              from an Integer. Strings can be compared and checked for equality.
              Consider the following code:</p>
              <pre><code class=\"language-python\">s = "A"
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
              <pre><code class=\"language-python\">t = True
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
              <pre><code class=\"language-python\">
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
              <pre><code class=\"language-python\">
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
              
              <h2>3. Functions, Variable Scope and the Global Keyword</h2>
              <p>The scope of a variable is to do with where it is defined and 
              from where it's value can be accessed. The Global Keyword (global)
              can modify the scope.</p>
              <p>Run the following program code:</p>
              <pre><code class=\"language-python\">x = 1
              if x == 1:
                  y = 2
              print(y)</code></pre>
              <p>It should produce the following output:</p>
              <pre>1</pre>
              <p>Now, the program runs one line one at a time, from top to 
              bottom. If the expression of the IF Statement evaluated as false,
              then the interpretter would skip the internal part of it. For 
              example, the following code:</p>
              <pre><code class=\"language-python\">x = 1
              if x == 0:
                  y = 2
              print(y)</code></pre>
              <p>Produces the error:</p>
              <pre>Traceback (most recent call last):
              
                File "variables1.py", line 4, in <module>
                  print(y)
              
              NameError: name 'y' is not defined</pre>
              <p>Have a think about this, then read and run the following code:</p>
              <pre><code class=\"language-python\">x = 1
              def f1():
                  x = 2
                  print("b", x)     
              print("a", x)
              f1()
              print("c", x)</code></pre>
              <p>The output should be:</p>
              <pre>a 1
              b 2
              c 1</pre>
              <p>At line 2, the interpretter reads a function definition for a 
              function called f1(), then skips to the end of the function and 
              executes line 5. Then at line 6 the function is called. The 
              interpreter then effectively goes back to line 2 and runs lines 3
              and 4. Then, at the end of the function, the interpretter 
              effectively runs the next bit of code after the function call i.e.
              line 7.</p> 
              <p>Now, the variable inside the function called x is a different 
              variable to the one outside of the function (even though the names
              are the same). Using the global keyword, we can make these 
              variables the same as follows:</p>
              <pre><code class=\"language-python\">x = 1
              def f1 ():
                  global x
                  x = 2
                  print("b", x)           
              print("a", x)
              f1()
              print("c", x)</code></pre>
              <p>The output should be:</p>
              <pre>a 1
              b 2
              c 2</pre>
              <p>Try the code yourself to test your understanding.</p>
              <p>Note that the function code snippet does not contain any 
              documentation about the function explaining what it is and what it
              does. The function takes in no arguments (parameters) and there is 
              no return statement. We will learn about functions in more detail
              and how to document them a bit later in the course...</p>
              """);
        w.add("</div>");

    }
}
