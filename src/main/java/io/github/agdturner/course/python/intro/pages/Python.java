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
                "Python Website", "Python Website",
                "");
        String python3ReferenceLink = addWebReference(
                "https://docs.python.org/3/reference/",
                "Python 3 Language Reference", "");
        String psfLink = addWebReference("https://www.python.org/psf/", 
                "Python Software Foundation", "");
        w.add("<p>" +
                addWikipediaReference("Python_(programming_language)",
                "Python")
                + " is a popular and powerful interpretted programming language."
                + " The language is supported and developed by the "
                + psfLink + " with a mission to promote, protect, and advance"
                + " the language, and to support and facilitate the growth of a"
                + " diverse and international community of Python programmers."
                + "</p>");
        w.add("<p>The core standard library and interpretters are freely"
                + " available in source and binary forms for all major"
                + " platforms from the " + pythonWebsiteLink + ", and may be"
                + " freely distributed. There are various Python interpretter"
                + " that read source code written in Python and translates this"
                + " into machine instructions. We won't concern ourselves with"
                + " the differences here.</p>"
                + "<p>The Python Website contains distributions of and pointers"
                + " to many Free and Open Source third party Python modules,"
                + " programs, tools, and additional documentation.</p>"
                + "<p>A particularly useful documentation page for beginners is"
                + " the " + python3ReferenceLink + ".</p>");
        w.add("""
              <p>On October 4, 2021 Python 3.10 was released. On November 24th, 
              2022 Python 3.11 was released. For each incremental releases there
              are Whatsnew Web Pages:</p>
              <ul>""");
        w.add(addWebReference("https://docs.python.org/3/whatsnew",
                "Python Documentation What's New", "",
                ""));
        for (int i = 0; i < 12; i++) {
            w.add("<li>" + Web_ContentWriter.getLink(
                    "https://docs.python.org/3/whatsnew/3." + i + ".html",
                    "Whatsnew Python 3." + i) + "</li>");
        }
        w.add("</ul>");
        w.add("""
              <p>On Whatsnew Web Pages, changes are marked against Python
              Enhancement Proposals (PEPs). Each PEP is numbered and 
              collectively they allow us to look ahead to see what might change
              and get involved in language development. PEPs have their own 
              Web site:""");
        w.add(addWebReference("https://peps.python.org/",
                "Python Enhancement Proposal Website",
                "https://peps.python.org/",
                ""));
        w.add("""
              </p>
              <p>For reproducing results and diagnosing issues. It is important 
              to know exactly which version of Python you are using and what 
              versions of any third party modules you are using.</p>
              <p>Python underwent a major revision from Python 2 to Python 3 in
              around 2008. There were changes that were not all backward 
              compatible. As a result a lot of Python 2 code needed modifying
              (refactoring) in order to work as intended or at all in Python 3 
              environments. Tools were written to help refactor code. Python 2 
              is no longer supported in that Python Software Foundation Python 
              language developers and supporters are no longer responding to 
              issues reported against Python 2. Python 2 code may still be in 
              use. We will not look at the differences in this course.
              </p>
              <p>As Python evolves, some ways of doing things are retired 
              (deprecated). Deprecation gives advanced notice of retiring 
              features allowing code developers and maintainers to plan ahead.
              </p>
              <p>It is important to be aware of the evolving nature of high 
              level computer programming languages. New features of Python 3.11
              will not work in Python 3.10. It is more likely that code written 
              in Python 3.10 syntax will work in Python 3.11 environments, but 
              that is not always the case.</p>
              <p>As well as the core of the Python language - the language 
              specification and a reference implementation of an interpretter, 
              there is a vast ecosystem of third party libraries written in 
              Python. Many of these are useful and most that are well used find 
              their way into <a href="https://pypi.org/">PyPI</a> - a Python 
              Package Index - a repository of third party Python packages. 
              Installing Python packages from PyPI is relatively 
              straightforward and we will learn about this in due course, but we
              won't learn about packaging and depositing code on PyPI. Most of 
              the things additional to the core langauge that we will be using 
              are part of Anaconda which we will learn more about and start 
              using shortly...</p>
              <p>The quality of third party code and indeed core Python code 
              varies. You should always be a bit careful about running code 
              written by others as it is quite easy to write malicious software
              or bad code that can damage computer systems, result in data 
              breaches, and leave you and others vulnerable.
              """);
        
        String python3DocsHome = Environment.URL_PYTHON_DOCS + "3/";
        String python3DocsTutorial = python3DocsHome + "tutorial/";
        w.add("<p>The");
        w.add(Web_ContentWriter.getLink(python3DocsTutorial,
                "Getting Started Tutorial"));
        w.add("linked from the " + pythonWebsiteLink);
        w.add("""
              is a good place to start learning Python. This course covers 
              some of the same things but in a way that is more geographically 
              focused.</p>
              <p>The following sections of this Web page comprise practical 
              exercises to get you running Python code in different ways. All 
              these ways are useful to know about in general and for this 
              course.</p>
              
              <h2>2. Running Python from the Command Prompt</h2>
              <p>Python instructions also known as commands or statements, can 
              be entered at what is called the Command Prompt, or they can be 
              passed in files to be interpretted. There is a logical order in 
              which the code is run. For code in files, the statements are 
              executed from top to bottom. Program files may contain new types
              of instructions called functions that can be accessed and run from 
              other parts of a program. We will learn how to define our own 
              functions later in the course, but we will start accessing 
              functions almost straight away...</p>
              <p>These instructions assume that you have""");
        w.add(addWebReference("https://www.anaconda.com/",
                "Anaconda", ""));
        w.add("""
              installed or available for use. When installing Anaconda, choose
              the option to add to your Path (which is not the default 
              option).</p>
              
              <h3>2.1. Hello World</h3>
              <p>Open up a Terminal (Command Window) and enter:</p>
              <pre>python --version</pre>
              <p>This should output the version of Python your system is set up
              to use. If Python is not on your Path, then you should get an 
              error message.</p>
              <p>Enter the following command to arrive at the Python Prompt:</p>
              <pre>python</pre>
              <p>The Python Prompt should look like:</p>
              <pre>>>></pre>
              <p>This is the Read-Eval-Print Loop (REPL) environment for Python
              where user inputs are read and evaluated, and then the results
              are returned to the user.</p>
              <p>Enter the following at the Python Prompt:</p>
              <pre>print("Hello World")</pre>
              <p>You should see the following output:</p>
              <pre>Hello World</pre>
              
              <h3>2.2. Numberical calculations</h3>
              <p>The Python REPL environment can act as a basic calculator. 
              Enter:</p>
              <pre>2 + 3</pre>
              <p>You should see the result of adding the number 2 to the number
              3:</p>
              <pre>5</pre>
              <p>Using the operator symbol for multiplication (*), try 
              multiplying two numbers.</p>
              <p>Use the operator symbol for division (/) to divide two 
              numbers. Try dividing 3 by 2 and notice that the result is not an 
              Integer, but a Float. Python has a huge range of Integer numbers. 
              Float is a bit harder to explain. It is a floating point number 
              which supports a subset of fractions or decimal numbers. We will 
              worry about the details of this later. For the time being, cause 
              an error by attempting a division by 0. Enter:</p>
              <pre>1/0</pre>
              <p>You should get the following Divide by Zero Error message:</p>
              <pre>
              Traceback (most recent call last):
                File "<stdin>", line 1, in <module>
              ZeroDivisionError: division by zero
              </pre>
              
              <h3>2.3. Loading Modules and Using Functions</h3>
              <p>Mathematical operators can also be accessed via functions that
              reside in the Operator Module.</p>
              <p>Enter:</p>
              <pre>operator.add(2, 3)</pre>
              <p>You should see the following error message:</p>
              <pre>Traceback (most recent call last):
                File "<stdin>", line 1, in <module>
              NameError: name 'operator' is not defined</pre>
              <p>The error is that the interpretter does not know about the
              Operator Module.</p>
              <p>Enter:</p>
              <pre>dir()</pre>
              <p>This runs (or calls) the Dir Function. You can tell it is
              a function as after the name there are start and end parentheses
              (()). In this case, the function is passed no arguments as there 
              is nothing between the start and end parentheses.</p>
              <p>You should get a list printed out that looks like:</p>
              <pre>['__annotations__', '__builtins__', '__doc__', '__loader__',
              '__name__', '__package__', '__spec__']</pre>
              <p>The list is alphabetically ordered and you can tell it is a 
              list as it starts with an open square bracket ([) and ends with 
              a closing square bracket (]), and each element is separated with a
              comma (,). This is a list of modules that the current Python 
              Environment has access to and from which functionality can be 
              used.</p>
              <p>Enter:</p
              <pre>import operator</pre>
              <p>This imports or loads the Operator Module so that it's 
              functionality can be accessed/used.</p>
              <p>Enter:</p>
              <pre>dir()</pre>
              <p>Now, you should see the Operator Module in the list.</p>
              <p>Enter:</p>
              <pre>operator.add(2, 3)</pre>
              <p>Now, you should not get the error we encoutered previously, but 
              see the result.</p>
              <p>The dot (.) is an operator called the Dot Operator. It 
              instructs the Python interpretter to look inside the thing on the 
              left to find the thing on the right. So, the expression looks 
              inside the Operator Module for the Add Function, and passes into 
              the Add Function two parameters, in this case the Integer 2 
              followed by the Integer 3. The Add Function returns the result of
              adding these two numbers, and be default the value is printed.</p> 
              <p>Enter:</p>
              <pre>dir(operator)</pre>
              <p>This lists the functions in the Operator Module. It is quite a 
              long list!</p>
              <p>Notice that there are numerous functions that have a name 
              starting and ending with a double underscore (__). These are not 
              meant to be called directly, but they can be.</p>
              <p>Enter:</p>
              <pre>operator.__add__(2, 3)</pre>
              <p>Python does not exert access control on variables and 
              functions. A naming convention is used to indicate to users 
              whether a variable or function is meant to be accessed from 
              outside the module. Underscores (_) and double underscores (__) at
              the start and/or end of identifiers have a special meaning in 
              Python.</p>
              <p>Try using some other functions from the Operator Module.</p>

              <h3>2.4. The Help System</h3>
              <p>Enter:</p>
              <pre>help(operator.add)</pre>
              <p>This prints out some information about how to use the Operator
              Module Add Function.</p>
              <p>Enter:</p>
              <pre>help()</pre>
              <p>This enters the Help System Prompt which looks like:</p>
              <pre>help> </pre>
              <p>Read what is printed.</p>
              <p>Enter:</p>
              <pre>modules</pre>
              <p>It may take a few minutes to report a list of available 
              modules. It takes longer to run the first time it is run.</p>
              <p>At the help prompt enter:</p>
              <pre>operator</pre>
              <p>This should dispay the start of the help documentation for the 
              Operator Module. Press the <enter> key to see the next line of the 
              documentation. Press and hold the <enter> key and the 
              documentation should stream to the screen. The <space> bar key 
              streams the documentation a page at a time. The 
              <q> key quits and should return you to the Help System Prompt.</p>
              <p>Have a quick look at some documentation for other modules.</p>
              <p>Enter:</p>
              <pre>q</pre>
              <p>This should exit the Help System and return you to the Python
              Prompt.</p>
              <p>Enter:</p>
              <pre>quit()</pre>
              <p>This should quit the Python REPL environment and return you 
              to the Command Prompt.</p>
              <p>Before learning how to run a file of Python commands, let us 
              consider a bit more basic Python syntax.</p>
              
              <h2>3. Basic Python Syntax</h3>
              <p>The syntax of a computer programming language are the rules 
              about how it must be written.</p>
              
              <h3>3.1. Syntax Errors</h3>
              <p>If a statement or expression is syntactically incorrect, and 
              the Python interpretter attempts to interpret it, a syntax error 
              is thrown. (N.B. The Divide by Zero Error we encountered earlier 
              was not as a result of a syntax error, the expression was 
              syntactically correct. However, when the expression was evaluated
              there was an error. The general type of that error is known as a 
              Runtime Error.</p>
              <p> It is possible to set a file of Python code containing 
              incorrect syntax running. In general though, it is best to avoid 
              syntax errors by ensuring all code is syntactically correct before 
              running it. At the Python prompt enter:</p>
              <pre>x=</pre>
              <p>You should get the following syntax error:</p>
              <pre>
              File "<stdin>", line 1
                  x =
                     ^
              SyntaxError: invalid syntax
              </pre>
              <p>Notice how this attempts to indicate where the syntax error is.
              Essentially, this issue is that the expression is incomplete. 
              There needs to be something on the right of the equals sign (=). A 
              lot of learning to code is about interpretting error messages of 
              one kind or another.</p>
              
              <h3>3.2. Statements</h3>
              <p>Multiple statements on a single line are separated with 
              semicolons (;). At the Python Prompt enter:</p>
              <pre>y=1;x=y;print(x)</pre>
              <p>The output of this is fairly ugly line of Python code is:</p>
              <pre>1</pre>
              <p>Statements might include many expressions and can be formulated 
              over several lines. We will come across some examples shortly...
              </p>
              <p>Python does not have a special symbol to end a statement like 
              many other languages do.</p>
              
              <h3>3.3. Comments</h3>
              <p>The # symbol is the start of a comment.</p>
              <pre>
              # This entire line is a comment
              x = 0 # This part of the line is a comment
              print(x) # Print out the value of x
              # Comments should be informative.
              # x = 1 # Commented code is not run.
              </pre>
              <p>Between triple quotes everything is a comment. There are two
              types of triple quote, those using single quotation marks, and 
              those using double quotation marks. Triple double quotes (\"\"\")
              are typically used for documentation. Triple single quotes (''') 
              are often used to comment out sections of code when""");
        w.add(addWikipediaReference("Debugging",
                "debugging") + ".</p>");
        w.add("""
              <pre>
              \"\"\"
              This is between triple quotes and is a comment.
              \"\"\"
              </pre>
              <p>It is good practise to leave a comment to indicate why a
              section of code has been commented out. Comments aim to help make
              code easier to read and understand. What is an appropriate amount
              of comment depends, but to start with try to write plenty of 
              comments as it helps you learn. We will see some examples in 
              shortly. Sometimes in source code comments, it is good to refer to
              other information sources in comments.</p>
              
              <h3>3.4. Code Layout</h3>
              <p>Blank lines are allowed and can help structure code into 
              blocks. It is good practice to start each code block with a
              comment that outlines what the code block is for. For example:
              </p>
              <pre>
              # Initialise x and y"
              x = 2
              y = 4
              print(x)
              print(y)
              # Calculate x to the power of y
              x ** y
              </pre>
              <p>Indentation is syntax in Python. Indentation refers to the 
              blank space that precedes text on a line. (It is sometimes called
              white space - as code backgrounds were normally white in colour).
              It is good to be consistent with indentation and to be aware that 
              indentation can effect what code does. Care must be taken with 
              spaces and tabs in this respect as these are different, but often 
              a number of spaces appears the same as a single tab. With Python 
              it is recommended not to use tabs at all in source code and to use 
              multiple spaces instead to indent. The following is a code block 
              with an example If Statement:</p>
              <pre>
              # if x is greater than y, then print a
              if x > y: # This line has the same indent as the comment above.
                  print(x) # This line is indented one standard step further.
              print(\"done\") # This line is dedented to the previous level.
              </pre>
              <p>In the code above, if the variable x is greater than the 
              variable y, then the value of x is printed. If the variable x has 
              not been initialised, then there will be an error:</p>
              <pre>Traceback (most recent call last):
                File "<stdin>", line 1, in <module>
              NameError: name 'x' is not defined</pre>
              <p>The Print Function is a Built In Function that is located in 
              the __builtins__ module. Have a look at the help for the function 
              by entering:</p>
              <pre><code class=\"language-python\">
              help(print)
              </code></pre>
              
              <h3>3.5. Delimiters, Literals and Operators</h3>
              <p>Delimiters separate bits of code, like blank lines and the
              colon (:) in the If Statement example above. Some delimeters also 
              act as operators. Here is a list from the Python Reference 
              Documentation to look at:</p>
              <pre>(       )       [       ]       {       }\n"
                + ",       :       .       ;       @       =       ->\n"
                + "+=      -=      *=      /=      //=     %=      @=\n"
                + "&=      |=      ^=      >>=     <<=     **=</pre>
              <p>The various types of bracket ((), [], {}) are parentheses (()),
              square brackets ([]) and curly brackets ({}) also known as braces.
              A lot of code uses brackets. Each open bracket ((, [, {) must be
              matched with a closing bracket (), ], }). Failure to match 
              brackets is a cause of much confusion as it can be difficult when 
              there is a bracket mismatch to locate what the cause of the 
              resulting error is. Commas (,), colons (:), dots (.) and 
              semicolons (;) are also common in code.
              </p>
              <p>Literals are specific numerical or text values.</p>
              <p>Operators are sequences of symbols that are shorthand for 
              Operator Module functions (e.g. +, -, *, /, %)</p>
              
              <h3>3.6. Identifiers and Keywords</h3>
              <p>Identifiers are names of variables, modules, functions and 
              classes.
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
        w.add(addWebReference(
                "https://docs.python.org/3/reference/lexical_analysis.html",
                "Python 3 Lexical Analysis Documentation",
                "Python 3 Lexical Analysis Documentation"));
        w.add("""
              </p>
              
              <h4>3.7. Style</h4>
              <p>The following code block is an If Statement which has an 
              Else Condition. This can be read as follows: If the variable x
              is greater than the variable y, then x is printed, otherwise y is
              printed.</p>
              <pre>
              x = 0
              y = 1
              # If x is greater than y, then print x, else print y.
              if x > y:
                  print("x", x)
              else:
                  print("y", y)
              </pre>
              <p>Notice that the Print Function is called with two arguments. 
              There are variables, comments, indentation, operators and 
              keywords. Styling can be used added to make it easier to 
              identify different parts, read and understand code:</p>
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
              <p>The style does not change the meaning of the code. Code 
              blocks presented subsequently in these learning resources will
              typically be styled as above.
              </p>
              
              <h2>4. Running a file of Python commands</h2>
              <p>Create a new text file called "HelloWorld.py". Add to it the 
              following line:</p>
              <pre>print("Hello World")</pre>
              <p>Save the file. Open a terminal or command prompt. Change to the 
              directory where you saved the file (path_to_directory) using:</p>
              <pre>cd path_to_directory</pre>
              <p>Run the file of python commands using:</p>
              <pre>python HelloWorld.py</pre>
              <p>You should see the following printed to the console:</p>
              <pre>
              Hello World
              </pre>
              <p>Try creating another file adding some python commands and 
              running it.</p>
              
              <h2>5. Jupyter Notebook</h2>
              <p>Jupyter Notebook, is a REPL based system that embeds code into 
              a Web based document containing other information: text, images, 
              data, and links. Code is entered in cells which when run present
              outputs within the document unless configured to appear in
              separate windows. Code can be described in detail and distributed
              with associated data and visualizations.</p>
              <p>Jupyter Notebook was renamed from IPython Notebook as the 
              <a href="https://en.wikipedia.org/wiki/R_(programming_language)">R</a>
              support was added.</p>
              <p>Jupyter Notebook comes bundled with Anaconda and can be 
              downloaded separately from <a href="https://jupyter.org/">Jupyter</a>.</p>
              <p>At the command prompt change to a directory where you can write
              new files and enter:</p>
              <pre>jupyter notbook</pre>
              <p>Some messages should appear in the terminal or command window 
              and a Web browser tab should open.</p>
              <p>From the New drop down list, select:</p>
              <pre>python 3 (ipykernel)</pre>
              <p>The New button is highlighted with a red oval in the following 
              image of the interface:</p>
              <img src="jupyter1.png" alt="Jupyter Notebook interface" />
              <p>The Python REPL environment should appear in another browser 
              tab like shown in the following image:</p>
              <img src="jupyter2.png" alt="Python REPL environment" />
              <p>Try typing the following at the prompt and actioning run:</p>
              <pre>print("Hello World")</pre>
              <p>The result should be something like the following image:</p>
              <img src="jupyter3.png" alt="Python REPL environment" />
              <p>Entire programs can be entered into cells as can 
              <a href="https://www.markdownguide.org/basic-syntax/">markdown</a>
              .</p>
              <p>At the end of this section we will briefly return to Jupyter 
              Notebooks once we have learned about installing packages that are 
              not available. This is to make use of some additional packages 
              that help to create interactive maps that are not available in the 
              Python environment provided in Anaconda.</p>
                            
              <h2>6. Integrated Development Environments</h2>
              
              <p><a href="https://en.wikipedia.org/wiki/Integrated_development_environment">
              Integrated Development Environment</a>s (IDEs) are software tools 
              used to make writing code and developing software easier. In this 
              section we look at IDLE and Spyder - IDEs that come with Anaconda.
              There are other IDEs that support Python code development and if 
              you are already familiar with one that does, then you might like 
              to try using that. Other IDEs that I have been recommended by 
              others Python developers are:
              <a href="https://www.jetbrains.com/pycharm/">PyCharm</a>
              , and
              <a href="https://www.pydev.org">PyDev</a>
              <!--
              for 
              <a href="https://en.wikipedia.org/wiki/Eclipse_(software)">Eclipse</a>
              -->
              .
              </p>
              
              <h3>6.1. IDLE</h3>
              <p>The core Python language comes with IDLE - an Integrated 
              Development and Learning Environment. IDLE has an editor window,
              as well as a console window for REPL commands and for output from
              files. From your terminal command prompt or command window type:</p>
              <pre>idle</pre>
              <p>This should open up the IDLE console window that should look 
              something like the image below:</p>
              <img src="idle1.png" alt="The IDLE interface" />
              <p>As well as the Python console prompt, there are some menus. 
              Choose:</p>
              <pre>File -> Open...</pre>
              <p>Open your HelloWorld.py file. It should open the file in an 
              editor window that looks something like:</p>
              <img src="idle2.png" alt="The IDLE file editor window interface" />
              <p>Notice again that like Jupyter Notebook, the code appearing in 
              the IDLE editor window is styled.</a>
              <p>The editor window has other menu options. Select:</p>
              <pre>Run -> Run Module</pre>
              <p>This should run the HelloWorld.py file, and output to the 
              console in the other window which should appear something like:</p>
              <img src="idle3.png" alt="The IDLE interface having run the Hello World program" />
              <p><a href="https://docs.python.org/3/library/idle.html">
              IDLE Documentation</a>.</p>
              <p>IDLE is an Integrated Development Environment (IDE).</p>
              <p>Close down IDLE.<p>
              
              <h3>6.2. Spyder</h3>
              <p>Spyder (the Scientific PYthon Development EnviRonment) is a 
              more sophisticated and IDE that comes with Anaconda and can be 
              downloaded from the 
              <a href="https://www.spyder-ide.org/">Spyder Website</a>.
              <p>From your terminal command prompt or command window type:</p>
              <pre>spyder</pre>
              <p>You should see something like this:</p>
              <img src="spyder1.png" alt="The Spyder interface" />
              <p>The pane to the left is the editor pane. The pane to the top 
              right is the inspector pane. The pane to the bottom right is the 
              console pane.</p>
              <p>From the menus, choose:</p>
              <pre>File -> Open...</pre>
              <p>Open your HelloWorld.py file which should appear in the editor 
              pane. From the menus, choose:</p>
              <pre>Run -> Run</pre>
              <p>If a popup box appears choose the default and this should run 
              your program and output should apear in the console like in the 
              following image:</p>
              <img src="spyder2.png" alt="The Spyder interface showing the Hello
              World program successfully run" />
              <p>Use the editor and add the following in line 2:</p>
              <pre>x = y</pre>
              <p>Try to run the file again. You should get an error. There 
              should also be a mark against the code on line 2 on the left and 
              on the right of the editor pane. Try hovering your mouse over the 
              mark on the left. You should see something similar to the image 
              below:</p>
              <img src="spyder3.png" alt="The Spyder interface showing an error." />
              <p><a href="https://docs.spyder-ide.org/current/index.html">
              Spyder Documentation</a></p>
              
              <h2>7. Python Environments In GIS Software</h2>
              <p>Python environments are provided as part of some Geographical 
              Information System (GIS) software including
              <a href="https://www.qgis.org/">QGIS</a> which is also Free and 
              Open Source Software and 
              <a href="https://www.esri.com/">ESRI Products</a>.</p>
              <p>Most of QGIS is written in 
              <a href="https://en.wikipedia.org/wiki/C%2B%2B">C++</a> and 
              Python.</p>
              <p>Try following these instructions:</p>
              <ol>
              <li>Open GIS Desktop Software</li>
              <li>From the Menu select:
              <pre>Plugins > Python Console</pre> and you should see something 
              like:
              <img src="qgis1.png" alt="QGIS Python Console basic interface" />
              There are 5 buttons, a display area and a Python Prompt (>>>). 
              </li>
              <li>At the Python Prompt type:
              <pre>dir</pre>
              Then:
              <pre>dir()</pre>
              A considerable amount of functionality should be listed.
              Type:
              <pre>dir(iface)</pre>
              This lists the functionality of the QGIS interface. With it we can
              programatically access functionality and any data loaded. 
              <li>Action the Python Console Show Editor Button. The interface 
              should change so that there is an additional pane in the Python 
              Console</li>
              </ol>
              <p>Download <a href="./QGIS1.py">QGIS1.py</a>, read the source 
              code and try to run it. As with the Jupyter Notebook example, you
              are not expected to fully understand the code at this stage. 
              (Instructions and an outline of what to expect are provided in the
              multi-line comment at the top of source code.</p>
              <p>Notice that after the comments at the top of the file, there 
              are some import statements, code is organised into code blocks 
              with comments that outline what each code block does. The import 
              statements are a bit more involved than what you have been shown 
              so far. In the code there are For Loops which is used to iterate 
              over the features in a layer. From the layer both attribute and 
              geometry is used.</p>
              <p>Once the program has run the QGIS interface should look 
              something like:
              <img src="qgis2.png" alt="QGIS Python Console after having run QGISExample.py" />
              </p>
              <p>QGIS has a Plug In Architecture allowing others to write 
              plugins in both C++ and Python. Plugins typically add something to 
              the interface and provide new functionality or scripted more 
              automated ways to do things. This course does not cover plugin 
              development for QGIS in detail, but here are some links:
              </p>
              <ul>
              <li><a href="https://www.qgis.org/en/site/getinvolved/development/development.html">
              QGIS Development Web Page</a></li>
              <li><a href="https://docs.qgis.org/testing/en/docs/pyqgis_developer_cookbook/plugins/index.html#developing-python-plugins">
              QGIS Development Cookbook Plugins Web Page Section on Developing Python Plugins</a></li>
              </ul>
              """);
        w.add("<p>" + addWebReference("https://qgis.org/pyqgis/", 
                "QGIS Python API Documentation", "",
                "") + "</p>");
        
        w.add("""
              <h2>8. Python Environment Management and Installing Packages</h2>
              <p>One of the criticisms levelled at Python is to do with 
              dependency management. In Python terms, a dependency is a module 
              that some other module needs in order to work. Now, suppose 
              modules from two different packages depend on different versions 
              of another module (and there is no common version of that 
              module that they can both use for what is wanted). In this case, 
              some way of using both versions of these dependencies is wanted. 
              However, due to the way Python works, this is not straightforward,
              and different Python environments called virtual Python 
              environments have to be set and used.</p>
              <p>Python has a simple and efficient way to set up, use, modify 
              and delete virtual Python environments. There are several other 
              reasons why you might want to set up virtual Python environments. 
              One is that it is easy to pollute a Python environment and install 
              packages that turn out not to be useful and that then get in the 
              way using up resources and slowing things down. The issue is often 
              not to do with a single package, but most packages depend on other 
              packages and as mentioned at the start of this section, Python can 
              be criticised currently in terms of dependency management. This 
              is likely to improve in the future. Other languages have faced 
              similar problems as they mature.</p>
              <p>Conda is a package manager for Python and R packages produced 
              by Anaconda. In addition to managing packages, Conda is also an
              environment manager. With the Python environment that comes with
              Anaconda, a slightly different way is recommended to create 
              virtual Python environments and install packages than would be 
              done in other Python environments.</p>
              <!--
              <p>This course does not detail how to set up, use, modify and 
              delete virtual Python environments. This is for later in the 
              learning journey. It is a good stage though to consider packages 
              and installing them.</p>
              -->
              <p>Packaging code and delivering it to users via trusted 
              repositories is a good thing for both developers and users.
              <a href"https://packaging.python.org/en/latest/overview/">This is 
              a link to a website all about packaging Python</a>.</p>
              <p>Open a Command Window, change to a directory where you can 
              write files and enter the following command to create a list of
              Python packages available in the Python environment:</p>
              <pre>pip list > piplist.txt</pre>
              <p>It may take a minute or so to run, and it should output a list 
              of names with version numbers like 
              <a href="./piplist.txt">this</a>.</p>
              <p>Enter the following command to create a similar list:</p>
              <pre>conda list > condalist.txt</pre>
              <p>Again, it may take a minute or so to run. The list is a bit 
              longer and includes an additional column of information, like 
              <a href="./condalist.txt">this</a>.</p>
              
              <p>Create a new conda environment in which to practice 
              installing some extra packages. Create an explicit list of all the
              conda packages using:</p>
              <pre>conda list --explicit > spec-file.txt</pre>
              <p>The create a new conda environment using:</p>
              <pre>conda list --explicit > spec-file.txt</pre>
              <p>Followed by:</p>
              <pre>conda create --name myenv --file spec-file.txt</pre>

              <p>We are going to risk polluting our Python environment and 
              install some other software without first creating a virtual 
              Python environment and using that. The first step is to update
              the exising conda packages by running:</p>
              <pre>conda update</pre>
              <pre>conda install -c conda-forge geopandas</pre>
              <pre>conda install -c conda-forge geoplot</pre>
              <pre>conda install -c conda-forge contextily</pre>
              <pre>conda install -c conda-forge bokeh</pre>
              conda install -c conda-forge ipympl
              https://github.com/geopandas/contextily
              https://github.com/geopandas/geopandas
              https://residentmario.github.io/geoplot/ Looks a bit abandoned!
              https://github.com/SciTools/cartopy/
              https://github.com/bokeh/bokeh                                                                                                                                                                        <a href="https://geopandas.org/">GeoPandas</a> which is available 
              via 
              <a href="https://pypi.org/">PyPI</a>.                            
              The way to do this not in Conda is using <pre>pip</pre> is a bit 
              involved, so let us use the following recommended command in a 
              Command Window:</p>
              <pre>conda install -c conda-forge geopandas</pre>
              <p>This will take a while to run. So, maybe take a break or
              read about installing packages using pip and installing packages 
              via Conda:</p>
              <ul>
              <li><a href="https://packaging.python.org/en/latest/tutorials/installing-packages/#use-pip-for-installing">
              https://packaging.python.org/en/latest/tutorials/installing-packages/#use-pip-for-installing</a></li>
              <li><a href="https://docs.anaconda.com/anaconda/user-guide/tasks/install-packages/">
              https://docs.anaconda.com/anaconda/user-guide/tasks/install-packages/</a></li>
              </ul>
              <p>Once GeoPandas is installed, then you could look at what has 
              changed in terms of packages using:</p>
              <pre>conda list</pre>
              <p>And comparing the output with last time.</p>
              <p>Try to run the Jupyter Notebook that failed to run previously 
              because Geopandas was not available.</p> 

              <p>Download, open in Jupyter, read and run the following notebook:
              <a href="https://www.geog.leeds.ac.uk/courses/computing/practicals/python/running-python/examples/Example_Notebook.ipynb">
              Example_Notebook.ipynb</a></p>
              <p>You are not expected to fully understand the code at this 
              stage, but hopfully you get an inkling of how it works.</p>
              """);
        
        
        w.add("""
              <h2>9. Recap and Expectations</h2>
              <p>This section of the course introduced some basic Python syntax 
              and considered the evolution of the language. It explored running
              Python code in files, using the REPL environment and help system, 
              Jupyter Notebooks, the IDLE and Spyder IDEs, and the Python 
              environment in QGIS.</p>
              <p>It introduced loading modules using an import statement, and 
              accessing functionality via a dot operator. It considered examples 
              of IF Statements and For Loops. (There will be more detail on 
              conditional statements and loops subsequently.)</p>
              <p>This has been a broad brush overview which you might like to 
              revisit once you are a bit more familiar with developing Python
              code and as you think about doing projects.</p> 
              """);
    }
}
