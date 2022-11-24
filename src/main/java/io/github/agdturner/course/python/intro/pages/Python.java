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
import io.github.agdturner.core.Environment;
import io.github.agdturner.course.Page;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Python Intro Course Python Page.
 *
 * @author Andy Turner
 */
public class Python extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Python(PythonIntroCourse c) {
        super("python", "Python", "Python", c);
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("<h2>1. Introduction</h2>");
        String pythonWebsiteLink = addWebReference(Environment.URL_PYTHON,
                "Python Website", "Python Website", "");
        w.add("<p>");
        w.add(addWikipediaReference("Python_(programming_language)",
                "Python"));
        w.add("""
              is a popular and powerful interpretted programming language. The 
              Python interpreter and the extensive standard library are freely 
              available in source and binary form for all major platforms from 
              the """);
        w.add(pythonWebsiteLink);
        w.add(", and may be freely distributed. The ");
        w.add(pythonWebsiteLink);
        w.add("""
              contains distributions of and pointers to many free third party 
              Python modules, programs and tools, and additional documentation.
              </p>
              <p>Python underwent a major revision from Python 2 to Python 3 in
              around 2008. There were changes that were not all backward 
              compatible. As a result a lot of Python 2 code needed 
              changing/fixing (refactoring) in order to work in Python 3 
              environments. This somewhat divided the community. Python 2 is no 
              longer supported in that the Python developers are no longer 
              responding to issues reported against Python 2.</p>
              <p>On October 4, 2021 Python 3.10 was released. On November 24th, 
              2022 Python 3.11 was released. For each of these incremental 
              releases there are "whatsnew" Web pages:</p>
              <ul>""");
        w.add(addWebReference("https://docs.python.org/3/whatsnew",
                "Python Documentation What's New", "", ""));
        for (int i = 0; i < 12; i++) {
            w.add("<li>" + Web_ContentWriter.getLink(
                    "https://docs.python.org/3/whatsnew/3." + i + ".html",
                    "Whatsnew Python 3." + i) + "</li>");
        }
        w.add("</ul>");
        w.add("""
              <p>On "whatsnew" Web pages, changes are marked against Python
              Enhancement Proposals (PEPs). These are community proposed and 
              allow us to look ahead and see what might change. PEPs have their 
              own Web site:""");
        w.add(addWebReference("https://peps.python.org/",
                "Python Enhancement Proposal Website",
                "https://peps.python.org/",
                ""));
        w.add("""
              </p>
              <p>It is important to know exactly which version of Python you are
              using and what versions of any third party modules you are using. 
              This helps with reproducing results and diagnosing issues.</p>
              <p>Programming and programming language development are
              community activities. It is normal to ask others for help and to 
              provide others with help and work collaboratively to develop 
              things. There are different types of forums for asking and 
              answering questions and different types of project that you might 
              want to get involved with once you have gained some experience. 
              Please refrain from asking questions on any forums unless you are 
              encouraged to do so by your tutor. Please ask your tutor for help 
              if you want it. If asking for help by email, it is often a good 
              idea to attach your code, explain what you think should happen and 
              describe what happens instead.</p>""");
        String python3DocsHome = Environment.URL_PYTHON_DOCS + "3/";
        String python3DocsTutorial = python3DocsHome + "tutorial/";
        w.add("<p>The");
        w.add(Web_ContentWriter.getLink(python3DocsTutorial,
                "getting started tutorial"));
        w.add("linked from the");
        w.add(addWebReference(Environment.URL_PYTHON,
                "Python Website", Environment.URL_PYTHON, ""));
        w.add("""
              is a good place to start learning Python. This course covers 
              much of that but in a slightly different geographically focussed
              way.</p>
              <h2>2. Running Python</h2>
              <p>Python instructions or commands are entered at a prompt or
              passed in files to be interpretted. There is an order in which 
              instructions run. Program files may contain new types of 
              instructions called functions that can be accessed and run from 
              other files of a program.</p>
              <p>These instructions assume that you have""");
        w.add(addWebReference("https://www.anaconda.com/", "Anaconda", "Anaconda"));
        w.add("""
              installed. When installing Anoconda, please choose 
              the option to add to your Path (which is not the default option).
              </p>
              <p>Open up a terminal or command window and enter:</p>
              <pre>python --version</pre>
              <p>This should output the version of Python your system is set up
              to use. If Python is not on your Path, then you should get an 
              error message.</p>
              <p>Enter the following command:</p>
              <pre>python</pre>
              <p>The prompt should change to look more like:</p>
              <pre>>>></pre>
              <p>This is the Read-Eval-Print Loop (REPL) environment for Python
              where user inputs are read and evaluated, and then the results
              are returned to the user. We call this \"the Python prompt\".</p>
              <p>Enter:</p>
              <pre>2 + 3</pre>
              <p>You should see the result of adding the number 2 to the number
              3:</p>
              <pre>5</pre>
              <p>The Python REPL environment can act as a basic calculator.</p>
              <p>Using the operator symbol for multiplication (*), try 
              multiplying two numbers.</p>
              <p>Have a little play perhaps also trying the operator symbol for
              division (/)...</p>
              <p>Mathematical operators can also be accessed via functions that
              reside in the \"operator\" module.</p>
              <p>Enter:</p>
              <pre>operator.add(2, 3)</pre>
              <p>You should see the following error message:</p>
              <pre>Traceback (most recent call last):
                File "<stdin>", line 1, in <module>
              NameError: name 'operator' is not defined</pre>
              <p>The error is that the interpretter does not know about the
              module named \"operator\"</p>
              <p>Enter:</p>
              <pre>dir()</pre>
              <p>This runs (or calls) the \"dir\" function. You can tell it is
              a function as after the name there are start and end parentheses
              (()). In this case, the function is passed no arguments as there
              is nothing between the start and end parentheses.</p>
              <p>You should get a list printed out that looks like:</p>
              <pre>['__annotations__', '__builtins__', '__doc__', '__loader__',
              '__name__', '__package__', '__spec__']</pre>
              <p>You can tell this is a list as it starts with an open square
              bracket ([) and ends with a closing square bracket (]), and each 
              element is separated with a comma (,).</p>
              <p>Enter:</p
              <pre>import operator</pre>
              <p>This imports the \"operator\" module.</p>
              <p>Enter:</p>
              <pre>dir()</pre>
              <p>This time, you should see the \"operator\" module in the list.
              </p>
              <p>Enter:</p>
              <pre>operator.add(2, 3)</pre>
              <p>This time, you should see the result:</p>
              <pre>5</pre>
              <p>Enter:</p>
              <pre>dir(operator)</pre>
              <p>This lists all the functions in the \"operator\" module. It is
              quite a long list that contains the \"add\" function that was
              called to add the numbers 2 and 3.</p>
              <p>Notice that there are numerous functions that have a name 
              starting and ending with \"__\". These are not supposed to be 
              called directly, but they can be.</p>
              <p>Enter:</p>
              <pre>operator.__add__(2, 3)</pre>
              <p>Python does not have a way of exerting access control on
              variables or functions, so it uses a naming convention to 
              indicate to users that the variable or function should not be 
              accessed from outside the module. Variables with names that start 
              with a single underscore (\"_\") or double underscore \"__\" 
              should not be accessed or used directly.</p>
              <p>Enter:</p>
              <pre>help(operator.add)</p>
              <p>This prints out some information about how to use the"
                + " \"operator\" module \"add\" function.</p>
              <p>Enter:</p>
              <pre>help()</pre>
              <p>This enters the help system and the prompt changes to look 
              like:</p>
              <pre>help> </pre>
              <p>Read what is printed.</p>
              <p>Enter:</p>
              <pre>modules</pre>
              <p>This may take a while to build a list of available modules.
              It takes longer the first time you run it.</p>
              <p>Within a few minutes, a list of modules should be returned.
              If you don't want to wait for this to be returned, then open 
              another command prompt and do something else while you are
              waiting.</p>
              <p>At the help prompt enter:</p>
              <pre>operator</pre>
              <p>This is the help documentation for the operator module. It is 
              many lines long. Press and hold the <enter> key to get the next 
              lines of the help documentation and let go after a few lines have 
              appeared. Then try pressing the <space bar> key to get the next
              page of the help documentation. Usually you can keep pressing the 
              <space bar> key to scan through the help documentation until you
              exit. You could also press your <q> key to quit and return to the
              help system.</p>
              <p>Enter:</p>
              <pre>q</pre>
              <p>This should exit the help system and return you to the Python
              prompt.</p>
              <p>Enter:</p>
              <pre>quit()</pre>
              <p>This should quit the Python REPL environment and return you 
              to the normal command prompt.</p>
              <p>Before learning how to run a file of Python commands, let us 
              go through some basics of Python syntax.
              <h2>3. Basic Python Syntax</h3>
              <h3>3.1. Statements</h3>
              <p>Multiple statements on a single line are separated with"
                + " semicolons (;).</p>
              <p>Python does not have a special symbol to end a statement"
                + " like many languages do.</p>
              <h3>3.2. Comments</h3>
              <p>The # symbol is the start of a comment.</p>
              <pre><code class=\"language-python\">
              # This entire line is a comment
              x = 0 # This part of the line is a comment
              print(x) # Print out the value of x
              # Comments should be informative.
              # x = 1 # Commented code is not run.
              </code></pre>
              <p>Between triple quotes everything is a comment. There are two
              types of triple quote, those using single quotation marks, and 
              those using double quotation marks. Triple double quotes (\"\"\")
              are typically used for documentation. Triple single quotes (''') 
              are often used to comment out sections of code when""");
        w.add(addWikipediaReference("Debugging",
                "debugging") + ".</p>");
        w.add("""
              <pre><code class=\"language-python\">
              \"\"\"
              This is between triple quotes and is a comment.
              \"\"\"
              </code></pre>
              <p>It is good practise to leave a comment to indicate why a
              section of code has been commented out. Comments aim to help make
              code easier to read and understand. What is an appropriate amount
              of comment depends. Sometimes it is good to refer to other 
              information sources in comments.</p>
              <h3>3.3. Code layout: code blocks</h3>
              <p>Blank lines are allowed and can help structure code into 
              blocks. It is good practice to start each code block with a
              comment that outlines what the code block is for. For example:
              </p>
              <pre><code class=\"language-python\">
              # Initialise x and y"
              x = 2
              y = 4
              print(x)
              print(y)
              # Calculate x to the power of y
              x ** y
              </code></pre>
              <p>Indentation is syntax in Python. Indentation refers to the 
              blank space that precedes text on a line. (It is sometimes called
              white space - as code backgrounds were normally white in colour).
              It is good to be consistent with indentation and to be aware that 
              indentation can effect what code does. Also, care must be taken 
              with spaces and tabs as these are different, but spaces can appear
              the same as a tab in many editors. With Python it is recommended 
              not to use tabs at all in source code and to use multiple spaces 
              instead to indent. The following is a code block with an example
              "if" statement:</p>
              <pre><code class=\"language-python\">
              # if x is greater than y, then print a
              if x > y: # This line has the same indent as the comment above.
                  print(x) # This line is indented one standard step further.
              print(\"done\") # This line is dedented to the previous level.
              </code></pre>
              <p>In the code above, if the variable x is greater than the 
              variable y, then the value of x is printed. If the variable x has 
              not been initialised, then there will be an error:</p>
              <pre>Traceback (most recent call last):
                File "<stdin>", line 1, in <module>
              NameError: name 'x' is not defined</pre>
              <p>The print function is a built in function that is located in 
              the __builtins__ module. Have a look at the help for the function 
              by entering:</p>
              <pre><code class=\"language-python\">
              help(print)
              </code></pre>
              <h3>3.4. Delimiters, Literals and operators</h3>
              <p>Delimiters separate bits of code like blank lines and the
              colon (:) in the if statement above. Some delimeters also act as 
              operators. Here are some to look at:</p>
              <pre>(       )       [       ]       {       }\n"
                + ",       :       .       ;       @       =       ->\n"
                + "+=      -=      *=      /=      //=     %=      @=\n"
                + "&=      |=      ^=      >>=     <<=     **=</pre>
              <p>The various types of bracket ((), [], {}) are parentheses (()),
              square brackets ([]) and curly brackets ({}) also known as braces.
              A lot of code uses brackets. Each open bracket ((, [, {) must be
              matched with a closing bracket (), ], }). Commas (,), colons (:),
              dots (.) and semicolons (;) are also common in code. A common 
              issue with code can be because of brackets not being closed, so 
              this is always something worth checking.
              </p>
              <p>Literals are specific numerical or text values.</p>
              <p>Operators are sequences of mathematical symbols that are a 
              shorthand for functions (e.g. +, -, *, /, %)</p> 
              <h3>3.5. Identifiers and Keywords</h3>
              <p>Identifiers are (for the most part) names of variables. They 
              are also used for function names, class names and module names.
              </p>
              <p>Keywords are reserved terms that can't be used for other
              things like variable names (e.g. else, for, if, import).</p>
              <p>Attempting to use them as variable names results in syntax
              errors as in the following where commands were entered at the
              python prompt:</p>
              <pre>
              >>> if = 2
                File "<stdin>", line 1
                  if = 2
                     ^
              SyntaxError: invalid syntax
              </pre>
              <p>Notice that the syntax error is pointing at the equals sign
              (=). This is because the python interpreter is expecting a
              conditional expression after the keyword (if). The actual issue
              is that there was an attempt to use a keyword as a variable name.
              </p>
              <p>For more details of Python language lexicon, see the""");
        w.add(addWebReference("https://docs.python.org/3/reference/lexical_analysis.html",
                "Python 3 Lexical Analysis Documentation",
                "Python 3 Lexical Analysis Documentation"));
        w.add("""
              </p>
              <h4>2.7. Examples</h4>
              <p>The following code block is an if statement which has an else"
                + " condition. The way this works is that the expression is "
                + " evaluated and if True, then x is printed otherwise y is"
                + " printed.</p>
              <pre><code class=\"language-python\">
              x = 0
              y = 1
              # if x is greater than y, then print x
              if x > y:
                  print("x", x)
              else:
                  print("y", y)
              print("done")
              </code></pre>
              <p>In this code, the print function is called with both one and 
              two arguments. There are variables, comments, indentation, 
              operators and keywords.</p>
              <p>Copy the code above, paste it into a text document and save 
              it with the filename "test.py". Open a terminal or command prompt
              change to the directory where you saved the file 
              (path_to_directory) using:</p>
              <pre>cd path_to_directory<pre>
              <p>Run the file of python commands using:</p>
              <pre>python test.py<pre>
              <p>There should be two lines of output printed to the console:
              <pre>
              y 1
              done
              </pre>""");
    }
}
