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

import io.github.agdturner.core.Section;
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
        Section s;
        s = addSection("1", "Introduction", 2);
        w.add(s.sectionHTML);
        w.add("<p>Python "
                + c.index.getReference("Variable", "variables", s.sid)
                + " are a combination of an identifier (a name) and a value - "
                + "either a primitive or a more complex object.</p>");
        w.add("<p>When passed as parameters into functions, variables are"
                + " handled differently depending on whether they are"
                + " primitives or more complex objects. The main difference is"
                + " to do with whether the variable is duplicated when it is"
                + " passed into the function as a parameter (known as '"
                + c.index.getReference("Call By Value", s.sid)
                + "') or whether a shared object is passed in (known as '"
                + c.index.getReference("Call By Sharing", s.sid)
                + "').</p>");
        s = addSection("2", "Variables Types", 2);
        w.add(s.sectionHTML);
        w.add("In Python, variable names can be reused to refer to different"
                + " types of value. The function 'type()' in the"
                + c.index.getReference("Python Builtins", "builtins module",
                        s.sid)
                + " can be used to get the type of a variable. For example, the"
                + " following code initialises a variable named 'x' to have the"
                + " Integer value '1', then assigns the name x to a String"
                + " value \"1\". After each assignment the type of the variable"
                + " is printed.</p>");
        w.add("""
              <pre><code class="language-python"># Set x = 1 and print the type of x")
              x = 1
              print(type(x))
              x = "1"
              print(type(x))</code></pre>
              <p>The output from running this code is:</p>
              <pre>&lt;class 'int'&gt;
              &lt;class 'str'&gt;</pre>
              <p>Again, try this yourself.</p>
              """);
        w.add("<p>In declarative programming languages, the type of a variable"
                + " is declared and this typically prevents the name being"
                + " assigned to a value not of that type. In Python, the"
                + " type of a variable is not declared. The main benefit of"
                + " this is that "
                + c.index.getReference("API", "APIs")
                + " can be more stable. However, without type safety, it is"
                + " easier to make mistakes and accidentally re-use a variable"
                + " name. It can also make"
                + c.index.getReference("Debugging", "debugging", s.sid)
                + " code harder, and it can make developing tools to help write"
                + " code harder. Being able to test the type of a variable"
                + " helps mitigate these things, but adding code to test the"
                + " type of variables a lot is cumbersome and it makes code a"
                + " lot less succinct and can make it significantly less"
                + " efficient.</p>");
        s = addSection("2.1", "Primitives", 3);
        w.add(s.sectionHTML);
        w.add("<p>The four primitive variable types in Python are: Integers,"
                + " Floats, Strings, and Booleans. Integers are whole numbers."
                + " Floats are "
                + c.index.getReference("Double-precision Floating-point", s.sid)
                + " numbers - a special subset of fractions. Strings are"
                + " essentially blocks of text (or sequences of single"
                + " character length Strings). Booleans are True or False and"
                + " also equate to 0 or 1.</p>");
        w.add("""
              <p>Integers are virtually unbounded in Python. The limit for the 
              largest number is based on the available memory.</p>
              """);
        w.add("<p>Floats have a 'Maximum Value' and a 'Minimum Normal Value'"
                + " (smallest number &gt; 0). These can be ascertained from the"
                + c.index.getReference("Python Sys Module", s.sid)
                + " (sys). There are Float values for positive and negative"
                + " infinity:</p>");
        w.add("""
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
              """);
        w.add("<p>Float is very useful, but it is important to bear in mind"
                + " the approximate nature of "
                + c.index.getReference("Floating-point", 
                        "Floating Point Arithmetic", s.sid)
                + " which can result in significant calculation error.</p>");
        w.add("<p>The "
                + c.references.getReference("Python Standard Library")
                + " has two modules that provide for more accurate arithmetic:"
                + c.index.getReference("Python Decimal Module", s.sid)
                + "; "
                + c.index.getReference("Python Fractions Module", s.sid)
                + ".</p>");
        w.add("""
              <p>Strings can be assigned using; double or single quotes, and the 
              constructor function str() (which can for example create a String 
              from an Integer). Strings can be compared and checked for
              equality using the operator '=='. Consider and run the following 
              code:</p>
              <pre><code class="language-python">s = "A"
              s2 = "a"
              s3 = "B"
              print(s == s)  # Prints True
              print(s == s2) # Prints False (case sensitive)
              print(s == s3) # Prints False
              print(s > s2)  # Prints False
              print(s < s2)  # Prints True
              print(str(3))  # Prints 3
              </code></pre>
              <p>Consider and run the following code to explore Boolean:</p>
              <pre><code class="language-python">t = True
              f = False                            
              print("t == t", t == t)             # Prints True
              print("f == f", f == f)             # Prints True
              print("t == 1", t == 1)             # Prints True
              print("f == 0", f == 0)             # Prints True
              print("t != f", t != f)             # Prints True
              print("not t", not t)               # Prints False
              print("not f", not f)               # Prints True
              print("t and f", t and f)           # Prints False
              print("t and not f", t and not f)   # Prints True
              print("t or f", t or f)             # Prints True
              print("not (t or f)", not (t or f)) # Prints False</code></pre>
              """);
        w.add("""
              <h3>2.2. Objects</h3>
              <p>Any variable that is not of a primitive type is a more complex
              object. A list is not a primitive type. The following code
              creates a list variable, assigns a new identifier to that list, 
              appends a primitive value to the list, then prints out the list 
              using one of the identifiers.</p>
              <pre><code class="language-python">
              a = [] # Assign a to equal a new empty List.
              b = a  # Set b to equal a
              a.append(1) # Append the Integer 1 to the List a
              print(b) # Prints [1]
              </code></pre>
              """);
        s = addSection("3", "Variable Scope and the Global Keyword", 2);
        w.add(s.sectionHTML);        
        w.add("<p>The "
                + c.index.getReference("Scope", "scope", s.sid)
                + " of a variable is from where in the code it can be accessed."
                + " The "
                + c.index.getReference("Python Keywords", "keyword", s.sid)
                + " 'global' can modify the scope.</p>");
        w.add("""
              <p>Consider the following:</p>
              <pre><code class="language-python">x = 1
              if x == 1:
                  y = 2
              print(y) # Prints 2</code></pre>
              """);
        w.add("<p>The code in the "
                + c.index.getReference("Python If Statement", "If Statement",
                        s.sid)
                + " is executed as the condition 'x == 1' evaluates as 'True'."
                + " If the condition were to evaluate as 'False', then the"
                + " interpreter would skip to the end of the statement, as in"
                + " the following code:</p>");
        w.add("""
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
              """);
        w.add("<p>More details about Python "
               + c.index.getReference("Function", "functions", s.sid)
               + " is provided <a href=\"../functions#9\">Functions</a>"
               + "...</p>");
        s = addSection("4", "Deleting variables", 2);
        w.add(s.sectionHTML);        
        
        w.add("<p>Variables can be deleted using the keyword 'del' followed by"
                + " the name of the variable or a "
                + c.index.getReference("Python Tuple", "Tuple")
                + " of variables to delete.</p>");
        w.add("""
              <p>Deleting variables can free up resources that can be used by 
              other things. The following code snippets shows how to initialise 
              a variable called and then delete it:<p>
              <pre><code class="language-python">a = 1
              del a # <-- deletes a
              #print(a) # <-- Would result in: NameError: name 'a' is not defined.
              b = 2
              c = 3
              del(b, c) # <-- Deletes b and c.</code></pre>
              """);
        w.add("</div>");

    }
}
