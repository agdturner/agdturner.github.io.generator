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
 * For Python Intro Course Functions Page.
 *
 * @author Andy Turner
 */
public class Functions extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Functions(PythonIntroCourse c) {
        super("functions", "Functions", "Functions", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2>1. Introduction</h2>
              <p>So far, we've been using functions from the builtin module, 
              which is automatically loaded in most cases. We've also accessed 
              functions in other modules using import statements. We'll now 
              look more closely at building our own functions.</p>
              <p>Functions are a code block begun with a function declaration or 
              header followed by a set of indented statements:</p>
              <pre>def function_name():
                  # Suite of statements</pre>
              <p>In a standard script, functions need to be defined before they 
              can be used. Once they are defined, they can be used or called 
              many times, which can dramatically reduce the amount of repetition 
              in code, making code smaller, and easier to understand and 
              maintain.</p>
              
              <h2>2. Parameters</h2>
              
              <h3>2.1. Positional Parameters</h3>
              <p>Functions can be parameterised; that is, made flexible through 
              variables which are set up when the function is called. If the 
              variable passed into the function is primitive, then the parameter 
              becomes a copy of the primitive value and if the copy is changed 
              within the function, the value of the variable passed in remains 
              unchanged. However, if the variable is not primitive, then the 
              parameter and the variable are the same thing. So, a non-primitive 
              passed into a function can be modified and though the function may 
              not return that modificiation, the modification will have happened
              to the variable value that is held outside the function.</p>
              <p>As with variable declarations, in Python there is no need to 
              declare the type of a parameter as declared in a function.</p>
              <p>By default, functions invisibly return None, but other things 
              can be returned. Only one thing can be returned, so typically 
              multiple things are turned into a Tuple when they are returned. 
              Often it is sensible to test the type of something that is 
              returned when you are not sure what is being returned to help you 
              unpack it or know how to handle it.</p>
              <p>Arguments can be allocated to parameters based on position, so 
              the first argument is the first in a sequence and the last is the 
              last in a sequence. For example:</p>
              <pre>def add(num1, num2):
                  return num1 + num2              
              print(add(20,30)) # Prints 50</pre>
              <p>These are called positional arguments and in the example: num1 
              gets 20, as it is first; and, num2 gets 30 as it is second.</p>
              <p>Default values can be specified if a parameter is missing:</p>
              <pre>def add(num1 = 0, num2 = 0):
                  return num1 + num2              
              print(add(3)) # Prints 3</pre>
              <p>Arguments are allocated left to right, so in the example, num1 
              gets 3, and num2 gets nothing and so is set to the default of 0.
              </p>
              <p>In the absence of a default, an argument must be passed in.
              For example the following code:</p>
              <pre>def add(num1 = 0, num2):
                  return num1 + num2
              print(add(3))</pre>
              <p>Results in:</p>
              <pre>SyntaxError: non-default argument follows default argument</pre>
              <p>Because of this, parameters with defaults come after any 
              undefaulted parameters.</p>
              
              <h3>2.2. Keyword Arguments (kwargs)</h3>
              <p>Arguments can also be named, these are called keyword arguments 
              or kwargs. Note that this use of the term keyword has nothing to 
              do with the generic use for words you can't use as identifiers.
              Consider the following which uses kwargs to assign the parameter
              values:</p>
              <pre>def add(num1, num2):
                  return num1 + num2
              print(add(num2 = 30, num1 = 50))</pre>
              <p>In the example, the order of the positional arguments is 
              ignored as kwargs are used to assign the values: num2 gets 30; 
              and, num1 gets 50.</p>
              <p>Mixing positional arguments and kwargs is allowed, but kwargs 
              must come to the right of positional arguments.</p>
              <p>Parameters can be forced into being kwargs by putting a * to 
              the left of the kwarg.</p>
              
              <h3>2.3. Flexibility using Tuples and Dictionaries</h3>
              <p>More positional arguments can be allowed using *tuple_name, as 
              in the following example:</p>
              <pre><code class="language-python">def sum (num1, num2, *others):
                  sum = num1
                  sum += num2
                  for num in others:
                      sum += num
                  return sum
              print(sum(1,2,3,4,5,6,7)) # Prints 28</code></pre>
              <p>The * used this way is known as the iterable un/packing 
              operator. If nothing is allocated, the tuple is empty.</p>
              <p>The * operator can be used with lists or tuples to generate 
              parameters:</p>
              <pre><code class="language-python">def sum (num1, num2, num3, num4):
                  return num1 + num2 + num3 + num4
              a = [1,2,3,4]
              print(sum(*a)) # Prints 10</code></pre>
              <p>Note that these can also be in the middle:</p>
              <pre><code class="language-python">a = [10,20]
              print(sum(1,*a, 2)) # Prints 33</code></pre>
              <p>So, it can be used in both positions packing and unpacking:</p>
              <pre><code class="language-python">def sum(*nums):
                  sum = 0
                  for num in nums:
                      sum += num
                  return sum
              a = [1,2,3]
              print(sum(*a)) # Prints 6</code></pre>
              <p>The same can be done with dictionaries using **dict_name (where 
              ** is the dictionary unpacking operator), which will make a 
              dictionary from unallocated kwargs:</p>
              <pre><code class="language-python">def print_details (a, **details):
                  first = details["first"]
                  surname = details["surname"]
                  print (first + " " + surname + " has " + a + " pounds")
              print_details("5", first="George", surname="Formby") # Prints George Formby has 5 pounds</code></pre>
              <p>Note that you can't use one of these to override other 
              variables. If nothing is allocated, the dictionary is empty.</p>
              <p>The ** dictionary operator can be used to generate kwargs:</p>
              <pre><code class="language-python">def print_details(a, first, surname):
                  print (first + " " + surname + " has " + a + " pounds")
              d = {"first":"George","surname":"Formby"}
              print_details("5",**d) # Prints George Formby has 5 pounds</code></pre>
              <p>Similar to with standard arguments *tuple_name arguments must 
              come before **dict_name arguments if both are used. *tuple_name 
              must come after positional parameters and **dict_name after other
              kwargs. It is, therefore usual to place them after their 
              associated variables or together at the end.</p>
              <pre><code class="language-python">def func(a,b,*c,d,**e) # d has to be a kwarg.
              def func(a,b,d,*c,**e) # abd,bd,or d can be kwargs.</code></pre>
              
              <h3>2.4. Nested Functions</h3>
              <p>It is possible to nest functions inside of other functions 
              although. This is fairly unusual, but there are occasions when 
              this can be useful.</p>
              
              <h2>3. Documentation Functions<h2>
              <p></p>
              
              
              
              SUMMARY
               Parameters:
              Undefaulted parameters
              Defaulted parameters
              *tuple_name
              Forced keyword parameters
              **dict_name
              Arguments:
              Positional arguments
              Keyword arguments
              Unpacked lists, tuples, or dicts may be anywhere
              
              
              
              
              <pre><code class=\"language-python\">
              from fractions import Fraction
              
              def add(x, y):
                  return x + y
              
              def multiply(x, y):
                  r = 0
                  for i in range(x):
                      r = add(r, y)
                  return r
              
              print(multiply(5, 7))
              </code></pre>
              <p></p>
              <h2>Documentation</h2>
              w.add("<pre><code class=\"language-python\">");
              from fractions import Fraction


        def divide(x, y):
    A function to divide x by y.
   
\"\"\"
                  Parameters
    ----------
    x : Fraction
        A decimal number.
    y : Fraction
        DESCRIPTION.

    Returns
    -------
    Fraction
        x divided by y

    \"\"\"
    return x / y

# Set x = 1/2.
x = Fraction(1, 2)
print(x)
# Set y = 1/3.
y = Fraction(1, 3)
print(y)
# Call the function and print the result.
print(divide(x, y))
        """);
//        w.add("<p></p>");
//        w.add("<p>Enter: \"\"</p>");
        w.add("</div>");
    }
}
