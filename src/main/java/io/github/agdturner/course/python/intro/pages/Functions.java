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
        Section s;
        s = addSection("1", "Introduction", 2);
        w.add(s.sectionHTML);
        w.add("<p>Functions are a key part of many programming languages. These"
                + " are reusable code blocks that are called and which return."
                + " In calling the function typically parameters can be passed"
                + " in. A function return may contain objects or values that "
                + " can be assigned to variables and in returning "
                + c.index.getReference("Python Built-in Functions", s.sid)
                + " are available as part of the "
                + c.index.getReference("Python builtins", "builtins module",
                        s.sid) 
                + " Functions from modules in the "
                + c.references.getReference("Python 3 Documentation: Library",
                        "standard library")
                + " are made available using "
                + c.index.getReference("Python import", "import", 
                    s.sid)
                + " statements.</p>");
        w.add("Python functions are defined in a code block that begins with a"
                + " definition or 'function declaration', and is followed by a"
                + " set of indented statements. The function declaration uses"
                + " the keyword 'def' which is followed by the name of the"
                + " function. After the function name, there are parenthesis"
                + " which may be empty or may contain a tuple of 'parameters'"
                + " also called 'arguments' - names for things passed into the"
                + " function. The function declaration ends with a colon ':'."
                + " The following gives the general form:</p>");
        w.add("""
              <pre><code class="language-python">def function_name(arg_0, arg_1):
                  # Function statements</code></pre>
              <p>A function may return one thing which can be a tuple of things.
              This is done with a return statement which starts with the keyword 
              'return' followed by the name of the thing returned. By default, 
              functions invisibly return 'None' - a special object of type 
              'NoneType'.</p>
              """);
        w.add("""
              <p>Functions are effectively blocks of code that can be used or 
              'called' repeatedly. Rather than repeat a block of code, it is 
              typically better to define a function and call the function twice.
              The bigger the block of code turned into a function, the greater 
              the gain is in terms of making the code easier to read, 
              understand, maintain and use.</p>
              """);
        
        s = addSection("2", "Parameters", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>Parameters or 'arguments' add flexibility and utility to 
              functions. Arguments can be variables or functions. Variables that  
              are primitive get copied. Variables that are non-primitive are 
              shared. Passing in a function as an argument allows that function 
              to be used within the function.</p>
              <p>As with variable declarations, in Python there is no need to 
              declare the type of a parameter passed to a function.</p>
              """);
        
        s = addSection("2.1", "Positional Parameters", 3);
        w.add(s.sectionHTML);
        w.add("""
              <p>Positional parameters or positional arguments are given in 
              order from left to right, so in the following 'add' function 
              'num1' is the first argument and 'num2' is the second argument:
              </p>
              <pre><code class="language-python">def add(num1, num2):
                  return num1 + num2              
              print(add(20,30)) # Prints 50</code></pre>
              <p>Default values can be specified as follows:</p>
              <pre><code class="language-python">def add(num1 = 0, num2 = 0):
                  return num1 + num2              
              print(add(3)) # Prints 3</code></pre>
              <p>As arguments are ordered left to right, in the example, 'num1' 
              gets '3', and 'num2' gets nothing and so is set to the default 
              value '0'.</p>
              <p>In the absence of a default, an argument must be passed in.
              For example the following code:</p>
              <pre><code class="language-python">def add(num1 = 0, num2):
                  return num1 + num2
              print(add(3))</code></pre>
              <p>Results in:</p>
              <pre>SyntaxError: non-default argument follows default argument</pre>
              <p>Because of this, arguments with defaults are declared after 
              any undefaulted arguments in the function declaration.</p>
              """);
        
        s = addSection("2.2", "Keyword Arguments (kwargs)", 3);
        w.add(s.sectionHTML);
        w.add("""
              <p>Arguments can also be named, these are called keyword arguments 
              or 'kwargs'. Note that this use of the term keyword has nothing to 
              do with the keywords that are special names for things that can't 
              be used as identifiers.</p>
              <p>Consider the following which uses kwargs in the function call 
              to assign the parameter values:</p>
              <pre><code class="language-python">def add(num1, num2):
                  return num1 + num2
              print(add(num2 = 30, num1 = 50))</code></pre>
              <p>Note that the order of the positional arguments is ignored:
              'num2' gets '30'; and, 'num1' gets '50'.</p>
              <p>Having both positional arguments and kwargs is allowed, but 
              kwargs are declared after (i.e. to the right of) positional 
              arguments in the function declaration.</p>
              """);
        
     s = addSection("2.3", "Flexibility using Tuples and Dictionaries", 3);
     w.add(s.sectionHTML);
        w.add("""
              <p>More positional arguments can be allowed using '*tuple_name', 
              as in the following example:</p>
              <pre><code class="language-python">def add(*nums):
                  r = 0
                  for num in nums:
                      r += num
                  return r
              print(add(1,2,3,4,5,6,7)) # <-- Prints 28</code></pre>
              <p>The '*' used this way is known as the iterable (un)packing 
              operator. If nothing is allocated, the tuple is empty.</p>
              <p>The '*' can be used with lists or tuples to generate 
              parameters:</p>
              <pre><code class="language-python">def add(*nums):
                  r = 0
                  for num in nums:
                      r += num
                  return r
              a = [1,2,3,4]
              print(add(*a)) # <-- Prints 10
              print(add(1,*a, 2)) # <-- Prints 13</code></pre>
              <p>The same can be done with dictionaries using '**dict_name'
              (where '**' is the dictionary (un)packing operator) - which will 
              make a dictionary from unallocated kwargs. The following code:</p>
              <pre><code class="language-python">def f1(a, **details):
                  print(a)
                  print(details)
              
              f1(1, b=2, c=3)</code></pre>
              <p>Produces:</p>
              <pre>1
              {'b': 2, 'c': 3}</pre>
              <p>The '**' dictionary operator can be used to generate kwargs.
              The following code:</p>
              <pre><code class="language-python">def f1(a, b, c):
                  print(a)
                  print(b)
                  print(c)
              
              d = {'b':2, 'c':3}
              f1(1,**d)</code></pre>
              <p>Produces:</p>
              <pre>1
              2
              3</pre>
              <p>Similar to with standard arguments, '*tuple_name' arguments 
              must come before '**dict_name arguments' (if both are used). And
              '*tuple_name' arguments must come after positional arguments. 
              And '**dict_name' arguments must come after other kwargs. It is, 
              therefore usual to place them after their associated variables or
              together at the end. The following code:</p>
              <pre><code class="language-python">def f1(a, b=2, *args, **kwargs):
                  print(a, b)
                  print(args)
                  print(kwargs)
              
              l = [10, 20, 30]
              d = {'c': 100, 'd': 200}
              
              f1(1, 3, *l, **d)</code></pre>
              <p>Produces:</p>
              <pre>1 3
              (10, 20, 30)
              {'c': 100, 'd': 200}</pre>
              <p>Note that the kwargs packed into the dictionary cannot have 
              name collisions with the other arguments. So, the following:</p>
              <pre><code class="language-python">def f1(a, b=2, *args, **kwargs):
                  print(a, b)
                  print(args)
                  print(kwargs)

              l = [10, 20, 30]
              d = {'c': 100, 'd': 200, 'b':300}

              f1(1, 3, *l, **d)</code></pre>
              <p>Results in:</p>
              <pre>TypeError: f1() got multiple values for argument 'b'</pre>            
              <p>For details on unpacking operators see: 
              <a href="https://peps.python.org/pep-0448/">PEP-0448</a></p>
              <p>Another useful summary reference is the 
              <a href="https://docs.python.org/3/faq/programming.html#how-do-i-write-a-function-with-output-parameters-call-by-reference">
              Python documentation: Outline of how to get output from a function documentation</a></p>
              """);
        
        s = addSection("3", "Scope", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>The scope of a variable is from where in the code it can be 
              accessed. Scope was introduced in 
              <a href="../Variables/index.html#3">Variables Section 3</a> when 
              functions were first considered, and where there is an explanation 
              of changing a variable scope using the 'global' keyword. To 
              recap, consider the following code:</p>
              <pre><code class="language-python">a = 10
              def f1():
                  print(a) # Prints 10;
              print(a) # Prints 10.
              f1()
              print(a) # Prints 10.</code></pre>
              <p>The variable 'a' is declared and initialised prior to any call 
              to f1() and the variable can be accessed from within the function 
              f1(). However, assigning a local variable within a function that 
              has the same name as a variable already accessible from the 
              function creates a new variable. So, to force a local assignment 
              to a global variable, use the global keyword as follows:
              <pre><code class="language-python">a = 10
              def f1():
                  global a
                  a = 20
                  print(a) # Prints 20.
              print(a) # Prints 10.
              f1()
              print(a) # Prints 20 as the function changes the global a.</code></pre>
              <p>With nested functions there are situations where non local 
              and non global variables are wanted in the inner function such 
              that the outer function and inner function share the same variable 
              and this does not change any variable with the same name in the 
              broader scope from where the function is called. To do this the 
              'nonlocal' keyword can be used, as in the following example:</p>
              <pre><code class="language-python">a = 1
              def f1():
                  a = 2
                  def f2():
                      nonlocal a
                      a = 3
                      print(a) # Prints 3.
                  f2()
                  print (a) # Prints 3.
              f1()
              print(a) # Prints 1.</code></pre>
              """);
        
        s = addSection("4", "Function Complexity", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>As shown above, functions can be nested. In the example above, 
              'f2' is inside 'f1', so: f2 is an 'inner function'; and, f2 is an 
              'outer function'. Nesting functions thus hides inner functions - 
              they cannot be called directly from outside the outer function. 
              This is a way to make things appear simple.</p>
              <p>Inner functions can be used to help unpack arguments and deal 
              with different types of argument passed to the outer function in a 
              function call.</p>
              <p>As mentioned, Python allows for functions to be passed into 
              functions as arguments. Functions can also be returned from 
              functions. An inner function can be returned in the output from an 
              outer function.</p>
              <p>Functions are key to a lot of programming. Supporting nested 
              functions, being able to pass functions into other functions as 
              parameters, and returning functions from functions are useful 
              features of Python.</p>
              <p>This section considers a number of other features of functions.
              The detail might be better understood after gaining practise in 
              defining and using functions that simply have variables as 
              parameter arguments and return variables, perhaps packed in a 
              tuple.</p>
              """);
        
        s = addSection("4.1", "Decorators", 3);
        w.add(s.sectionHTML);
        w.add("""
              <p>Decorators are functions that aare applied to the outputs of 
              other functions using the '@' symbol as part of the 
              function definition (see 
              <a href="https://docs.python.org/3/reference/compound_stmts.html#function-definitions">
              function definitions</a>). There can be multiple decorators 
              which would work in turn passing the output back until all the 
              decorators have been applied. A decorator function can be used for 
              reporting the time it takes to run a function:<p>
              <pre><code class="language-python">import random
              import time
              
              def timer(func):
                  \"""
                  Get the run time of the decorated function.
              
                  Parameters
                  ----------
                  func : The function to be timed.
                      DESCRIPTION.
              
                  Returns
                  -------
                  Tuple
                      The run time then func output.
                  \"""
                  def inner_timer(*args, **kwargs):
                      start = time.perf_counter()
                      value = func(*args, **kwargs)
                      run_time = time.perf_counter() - start
                      return run_time, value
                  return inner_timer
              
              @timer
              def create_agents(n_agents):
                  \"""
                  A function to create a list of agents. The decorator will print the time
                  it takes to run this function.
              
                  Parameters
                  ----------
                  n_agents : Integer
                      The number of agents to create.
              
                  Returns
                  -------
                  agents : List
                      A list of the created agents.
              
                  \"""
                  agents = []
                  for i in range(n_agents):
                      agents.append([random.randint(0, 99), random.randint(0, 99)])
                  return agents
              
              # Create agents
              n_agents = 1000000
              run_time, agents = create_agents(n_agents)
              print(run_time, "seconds to create", n_agents, "agents.")</code></pre>
              """);
        
        s = addSection("4.2", "Lambdas", 3);
        w.add(s.sectionHTML);
        w.add("<p>"
                + c.index.getReference("Python lambda", "Lambda expressions", 
                        s.sid)
                + " are used to create anonymous functions. They can have any"
                + " number of arguments, but the expression is made up of a "
                + "single non-compound statement. Consider the following "
                + "example:</p>");
        w.add("""
              <pre><code class="language-python"># A lambda to return the result of dividing a by b.
              x = lambda a, b : a / b
              
              print(x(1, 2)) # <-- Prints 0.5.</code></pre>
              <p>Note that: the lambda function is defined with the 'lambda' 
              keyword, the parameters are separated with commas, and a colon is 
              used to separate the parameters from the expression - the result 
              of which is passed back.</p>
              """);
        
        s = addSection("4.3", "Callbacks", 3);
        w.add(s.sectionHTML);
        w.add("""
              <p>A Python callback is a subroutine function which is passed as 
              an argument to be executed at some point in the future. Consider 
              the following example where the callbacks are to the 'add' and 
              'multiply' functions from the caller function (that itself is 
              called in the lines that print out the results returned from the 
              function calls):</p>
              <pre><code class="language-python">def add(x):
                  \"""
                  Calculate and return all the elements of x added together.
                  
                  Parameters
                  ----------
                  x : Tuple
                      The things to add.
              
                  Returns
                  -------
                  r : Things added.
                      All the things in x added together.
              
                  \"""
                  r = 0
                  for y in x:
                      r = r + y
                  return r
              
              def multiply(x):
                  \"""
                  Calculate and return all the elements of x multplied together.
                  
                  Parameters
                  ----------
                  x : Tuple
                      The things to multiply.
              
                  Returns
                  -------
                  r : Things multiplied.
                      All the things in x multiplied together.
              
                  \"""
                  r = 0
                  for y in x:
                      r = r + y
                  return r
                             
              def caller(func, args):
                  \"""
                  A function that calls the function func passing in the 
                  arguments args.
               
                  Parameters
                  ----------
                  func : Function
                      The (name of the) function to be called.
                  args : Tuple
                      The arguments to be passed to func
                  Returns
                  -------
                  Whatever is returned from func(args)   
                  \"""
                  return func(args)
              
              print(caller(add, (1, 2, 3))) # Prints 6
              print(caller(multiply, (1, 2, 3, 4, 5, 6))) # Prints 21</code></pre>
              <p>The following is another example which uses a callback to sort
              items in a list:</p>
              <pre><code class="language-python">class Mark:
                  def __init__(self, name, grade):
                      self.name = name
                      self.grade = grade
               
                  def __str__(self):
                      return "name=" + self.name + " grade=" + str(self.grade)
               
              def getGrade(mark):
                  return mark.grade
               
              marks = [Mark("name1", 50), Mark("name2", 70), Mark("name3", 60)]
              print("Unordered marks:")
              for mark in marks:
                  print(mark)
              
              # Sort marks using a callback
              marks.sort(key=getGrade)
              
              print("Ordered marks:")
              for mark in marks:
                  print(mark)
              </code></pre>
              <p>Often a callback is used in event based processing. It allows 
              other tasks to be done whilst waiting for an event to happen.</p>
              """);
        
        s = addSection("4.4", "Partial", 3);
        w.add(s.sectionHTML);
        w.add("""
              <p>Functools <a href="https://docs.python.org/3/library/functools.html?highlight=partial#functools.partial">
              partial</a> allows for arguments of a function to be set 
              partially. For example:</p>
              <pre><code class="language-python">from functools import partial
                
              def f(x, y, z):
                  return x + y + z
                
              # A partial function that calls f with x = 1 and y = 2.
              pf = partial(f, 1, 2)
                
              print(pf(3)) # Prints 6</code></pre>
              """);
        
        s = addSection("5", "Style and Documenting Functions", 2);
        w.add(s.sectionHTML);
        
        s = addSection("5.1", "Style", 3);
        w.add(s.sectionHTML);
        w.add("""
              <p>Good Python style is set out in 
              <a href="https://www.python.org/dev/peps/pep-0008/">PEP-0008</a>
              which is worth finding time to read.</p>
              <p>The main style elements are:
              <ul>
              <li>Use 4 spaces per indent</li>
              <li>Insert blank lines before function definitions and to separate 
              logical code units.</li>
              <li>function_names and variable_names should be lower case with 
              underscores separating words (snake case) as shown.</li>
              <li>ClassNames should be mostly lower case, but with capitalised 
              first letters of name parts (camel case) as shown.</li>
              <li>CONSTANT_NAMES should be upper case and snake case.</li>
              <li>Keep lines to 79 characters or less.</li>
              <li>Add spaces after commas</li>
              <li>Indent comments to the level of the code referred to.</li>
              </ul>
              """);
        
        s = addSection("5.2", "Documenting Functions", 3);
        w.add(s.sectionHTML);
        w.add("<p>"
                + c.index.getReference("Python docstring", "Docstrings", s.sid)
                + " are automatically extracted to describe code. They are"
                + " added in triple-double quote enclosed comments after,"
                + " class or function declarations. For functions these should"
                + " ideally have a short description of what the function does"
                + " which is typically written like a command to the function"
                + " more than as a description of what the function does. It"
                + " should also list what the parameters are and what if"
                + " anything is returned from the function. For example:</p>");
        w.add("""
              <pre><code class="language-python">def add (num1, num2):
                  \"""
                  Add two numbers.
              
                  Keyword arguments:
                  num1 -- an integer or double number (no default)
                  num2 -- an integer or double number (no default)
              
                  Returns:
                  The sum of the numbers.
                  \"""
                  return num1 + num2</code></pre>
              <p>For details on docstrings see 
              <a href="https://www.python.org/dev/peps/pep-0257/">PEP-0257</a>
              </p>
              <p>The help system will display docstrings. So, where "x" is a 
              function or module the following will display the docstring:</p>
              <pre>help(x)</pre>
              <p>The docstring can also be printed using:</p>
              <pre>print(x.__doc__)</pre>
              
              <h2 id="6">6. Next</h2>
              <p>Refactoring the Agent Based Model code to use functions...</p>
              """);
        w.add("</div>");
    }
}
