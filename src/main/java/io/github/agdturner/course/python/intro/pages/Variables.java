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
        w.add("<p>"
                + c.index.getReference("Variable", "Variables", s.sid)
                + " are a combination of an identifier (a name) and a value"
                + ".</p>");

        s = addSection("2", "Python Variables", 2);
        w.add(s.sectionHTML);
        w.add("<p>In Python, the 'type' of a variable does not have to be "
                + "declared - it is effectively inferred by the value of the "
                + "variable (if it needs to be).</p>");
        w.add("<p>In Python, identifiers such as variable names can be "
                + "reassigned. A benefit of this is that "
                + c.index.getReference("API", "APIs")
                + " can be more stable (as there is no need to specify exactly"
                + " what types of things are input and output from functions)."
                + " A downside is that, it is easier to make mistakes and "
                + " accidentally re-use an identifier with unintended"
                + " consequences.");
        w.add("<p>The four primitive variable types in Python are: Integers,"
                + " Floats, Strings, and Booleans:</p>"
                + "<p>Integers are whole numbers and are unbounded in Python. "
                + "The largest Integer is constrained by "
                + c.index.getReference("Memory", "memory", s.sid)
                + " availability.</p>"
                + "<p>Floats are standard "
                + c.index.getReference("Double-precision Floating-point", s.sid)
                + " numbers - a special subset of fractions. These have a "
                + "'Maximum Value' and a 'Minimum Normal Value' (smallest "
                + "number &gt; 0) which can be ascertained from the "
                + c.index.getReference("Python sys", "sys", s.sid)
                + " module. There are Float values for positive and negative"
                + " infinity. Consider and run the following code:</p>");
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
        w.add("<p>Float is very useful for approximate numerical calculations."
                + " Do keep in mind that "
                + c.index.getReference("Floating-point",
                        "Floating Point Arithmetic", s.sid)
                + " is approximate - so calculations that use it are not"
                + " necessarily accurate.</p>");
        w.add("<p>The "
                + c.references.getReference("Python 3 Documentation: Library", 
                        "Python Standard Library")
                + " has two modules that support more arithmetic accuracy: "
                + c.index.getReference("Python decimal", "decimal", s.sid)
                + "; and, "
                + c.index.getReference("Python fractions", "fractions", s.sid)
                + ".</p>");
        w.add("<p>Strings are essentially blocks of text (which are sequences "
                + "of single character length Strings). Strings can be "
                + "assigned using; double or single quotes, or the constructor "
                + "function "
                + c.index.getReference("Python str", "str", s.sid)
                + " (which can for example create a String from an Integer). "
                + "Strings can be compared and checked for equality using the "
                + "operator '=='. Consider and run the following code:</p>");
        w.add("""
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
              <p>Booleans are 'True' or 'False' and also equate to '0' or '1'.
              </p>
              <p>Consider and run the following code:</p>
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
              <p>More complex objects have state given by multiple primitives 
              variables. Objects can also be comprised of multiple other 
              objects as defined by a class.</p>
              """);
        w.add("<p>The type of any object can be got using the function "
                + c.index.getReference("Python type", "type", s.sid)
                + " from the "
                + c.index.getReference("Python builtins", "builtins", s.sid)
                + " module. Consider and run the following code that "
                + "initialises a variable named 'x' with the Integer value "
                + "'1', then prints out the type of the variable 'x', then "
                + "reassigns 'x' to have a String value, then again prints out "
                + "the type of the variable 'x'.</p>");
        w.add("""
              <pre><code class="language-python"># Set x = 1 and print the type of x")
              x = 1
              print(type(x)) # Prints &lt;class 'int'&gt;
              x = "1"
              print(type(x)) # Prints &lt;class 'str'&gt;</code></pre>
              <p>The output from running this code is:</p>
              <pre>&lt;class 'int'&gt;
              &lt;class 'str'&gt;</pre>
              """);

        s = addSection("3", "Functions, Variable Scope and the Global Keyword", 2);
        w.add(s.sectionHTML);
        w.add("<p>When passed as parameters into functions, variables are "
                + "shared this is technically known as '"
                + c.index.getReference("Call By Sharing", s.sid)
                + "'. If a variable is a primitive object then effectively a "
                + "new variable is created within the function which is "
                + "distinct from the variable outwith the function but that "
                + "has the same value which is technically known as '"
                + c.index.getReference("Call By Value", s.sid)
                + "'.</p>");
        w.add("<p>The "
                + c.index.getReference("Scope", "scope", s.sid)
                + " of a variable is from where in the code it can be accessed."
                + " The "
                + c.index.getReference("Python keyword", "keyword", s.sid)
                + " 'global' can modify the scope.</p>");
        w.add("""
              <p>Consider the following:</p>
              <pre><code class="language-python">x = 1
              if x == 1:
                  y = 2
              print(y) # Prints 2</code></pre>
              """);
        w.add("<p>The code in the "
                + c.index.getReference("Python if", "if statement", s.sid)
                + " is executed as the condition 'x == 1' evaluates"
                + " as 'True'. If the condition were to evaluate as 'False',"
                + " then the interpreter would skip to the end of the if"
                + " statement, as happens running the following code:</p>");
        w.add("""
              <pre><code class="language-python">x = 1
              if x == 0:
                  y = 2
              print(y)</code></pre>
              <p>Which results in:</p>
              <pre>NameError: name 'y' is not defined</pre>
              <p>This is because 'y' does not get initialised and so cannot be 
              passed into the print function.</p>
              """);
        w.add("""
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
              """);

        s = addSection("4", "Deleting variables", 2);
        w.add(s.sectionHTML);
        w.add("<p>Variables can be deleted using the keyword 'del' followed by"
                + " the name of the variable or a "
                + c.index.getReference("Python tuple", "tuple", s.sid)
                + " of variables to delete.</p>");
        w.add("""
              <p>Deleting variables can free up memory for other things. The 
              following code snippets shows how to initialise and delete
              variables:<p>
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
