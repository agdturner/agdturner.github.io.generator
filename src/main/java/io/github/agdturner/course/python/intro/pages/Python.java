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
        w.add("<p>");
        w.add(addWikipediaReference("Python_(programming_language)",
                "Python"));
        w.add("""
              is a popular and powerful interpretted programming language. The 
              Python interpreter and the extensive standard library are freely 
              available in source and binary form for all major platforms from 
              the""");
        w.add(pythonWebsiteLink + ", and may be freely distributed. The "
                + pythonWebsiteLink + " contains distributions of and pointers"
                + " to many free third party Python modules, programs and tools,"
                + " and additional documentation.</p>");
        w.add("""
              <p>On October 4, 2021 Python 3.10 was released. On November 24th, 
              2022 Python 3.11 was released. For each of these incremental 
              releases there are Whatsnew Web Pages:</p>
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
              and get involved in language development which is a somewhat open 
              and well organised process. PEPs have their own Web site:""");
        w.add(addWebReference("https://peps.python.org/",
                "Python Enhancement Proposal Website",
                "https://peps.python.org/",
                ""));
        w.add("""
              </p>
              <p>It is important to know exactly which version of Python you are
              using and what versions of any third party modules you are using. 
              This helps with reproducing results and diagnosing issues.</p>
              <p>Python underwent a major revision from Python 2 to Python 3 in
              around 2008. There were changes that were not all backward 
              compatible. As a result a lot of Python 2 code needed 
              changing/fixing (refactoring) in order to work as intended or at 
              all in Python 3 environments. This somewhat divided the community. 
              Python 2 is no longer supported in that Python developers are no
              longer responding to issues reported against Python 2. Python 2
              code may still be being maintained, and there might still be 
              useful code written in Python 2 that could be translated to 
              Python 3, but we will not look at the differences in this course.
              </p>
              <p>As high level computer programming languages like Python 
              evolve, some ways of doing things are retired (deprecated). 
              Deprecation gives advanced notice of retiring features allowing 
              programmers that look after code to plan for succession.</p>
              <p>It is important to be aware of the evolving nature of high 
              level computer programming languages. New features of Python 3.11
              will not work in Python 3.10. It is more likely that code written 
              in Python 3.10 syntax will work in Python 3.11, but that is not 
              always the case.</p>""");
        
        String python3DocsHome = Environment.URL_PYTHON_DOCS + "3/";
        String python3DocsTutorial = python3DocsHome + "tutorial/";
        w.add("<p>The");
        w.add(Web_ContentWriter.getLink(python3DocsTutorial,
                "getting started tutorial"));
        w.add("linked from the");
        w.add(addWebReference(Environment.URL_PYTHON,
                "Python Website", Environment.URL_PYTHON,
                ""));
        w.add("""
              is a good place to start learning Python. This course covers 
              many of the same things albeit in a more geographically focused
              way.</p>
              <p>The remainder of this page is a practical exercise which
              introduces running Python code in different ways which can be 
              useful to know as not all options might be available to you.</p>
              
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
              installed or available for use. When installing Anoconda, choose
              the option to add to your Path (which is not the default 
              option).</p>
              
              <h3>2.1. Hello World</h3>
              <p>Open up a Terminal or Command Window (which we will call 
              Command Window) and enter:</p>
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
              are returned to the user. We call this the Python Prompt.</p>
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
              <p>You should get the following error message:</p>
              <pre>
              Traceback (most recent call last):
                File "<stdin>", line 1, in <module>
              ZeroDivisionError: division by zero
              </pre>
              
              <h3>2.3. Loading modules and Using functions</h3>
              <p>Mathematical operators can also be accessed via functions that
              reside in the "operator" module.</p>
              <p>Enter:</p>
              <pre>operator.add(2, 3)</pre>
              <p>You should see the following error message:</p>
              <pre>Traceback (most recent call last):
                File "<stdin>", line 1, in <module>
              NameError: name 'operator' is not defined</pre>
              <p>The error is that the interpretter does not know about the
              module named "operator"</p>
              <p>Enter:</p>
              <pre>dir()</pre>
              <p>This runs (or calls) the "dir" function. You can tell it is
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
              environment has loaded and from which functionality can be 
              accessed. Later on we will learn how to install modules that are 
              not available. What we are learning here is about loading modules
              that are available.</p>
              <p>Enter:</p
              <pre>import operator</pre>
              <p>This imports or loads the "operator" module.</p>
              <p>Enter:</p>
              <pre>dir()</pre>
              <p>Now, you should see the operator module in the list.</p>
              <p>Enter:</p>
              <pre>operator.add(2, 3)</pre>
              <p>Now, you should not get the error, but see the result:</p>
              <pre>5</pre>
              <p>The dot (.) is an operator called the dot operator. It 
              instructs the Python interpretter to look inside the thing on the 
              left to find the thing on the right. So, the expression looks 
              inside the operator module for the add function, and passes into 
              the add function two parameters, in this case the Integers 2 and 
              3. The function returns the result which is then output.</p> 
              <p>Enter:</p>
              <pre>dir(operator)</pre>
              <p>This lists all the functions in the "operator" module. It is
              quite a long list!</p>
              <p>Notice that there are numerous functions that have a name 
              starting and ending with "__". These are not supposed to be 
              called directly, but they can be.</p>
              <p>Enter:</p>
              <pre>operator.__add__(2, 3)</pre>
              <p>Python does not have a way of exerting access control on
              variables or functions, so it uses a naming convention to 
              indicate to users that the variable or function should not be 
              accessed from outside the module. Variables with names that start 
              with a single underscore (\"_\") or double underscore \"__\" 
              are not to be accessed or used directly.</p>
              <p>Try using some other functions from the operator module.</p>

              <h3>2.4. The Help System</h3>
              <p>Enter:</p>
              <pre>help(operator.add)</pre>
              <p>This prints out some information about how to use the operator
              module add function.</p>
              <p>Enter:</p>
              <pre>help()</pre>
              <p>This enters the help system and the prompt changes to look 
              like:</p>
              <pre>help> </pre>
              <p>Read what is printed.</p>
              <p>Enter:</p>
              <pre>modules</pre>
              <p>This may take a few minutes to build a list of available 
              modules. It takes longer to run the first time it is run.</p>
              <p>A list of modules should be returned.</p>
              <p>At the help prompt enter:</p>
              <pre>operator</pre>
              <p>This should dispay the start of the help documentation for the 
              operator module. Press the <enter> key to get the next line of the 
              help documentation. Press and hold the <enter> key and the 
              documentation should stream to the screen at a reading speed. 
              Release the <enter> key after you have read a bit further. The 
              <space bar> key streams the documentation a page at a time. The 
              <q> key quits and should return you to the help system prompt.</p>
              <p>Have a quick look at some documentation for other modules.</p>
              <p>Enter:</p>
              <pre>q</pre>
              <p>This should exit the help system and return you to the Python
              prompt.</p>
              <p>Enter:</p>
              <pre>quit()</pre>
              <p>This should quit the Python REPL environment and return you 
              to the normal command prompt.</p>
              <p>Before learning how to run a file of Python commands, let us 
              go through some basics of Python syntax.</p>
              
              <h2>3. Basic Python Syntax</h3>
              <p>The syntax of a computer programming language are the rules 
              about how it must be written.</p>
              
              <h3>3.1. Syntax Errors</h3>
              <p>If a statement or expression is syntactically incorrect, and 
              the Python interpretter attempts to interpret it, a syntax error 
              is thrown.</p>
              <p> It is possible to set a file of Python code containing 
              incorrect syntax running. In general though, it is best to avoid 
              syntax errors by ensuring all code is syntactically correct. At 
              the Python prompt enter:</p>
              <pre>x=</pre>
              <p>You should get the following syntax error:</p>
              <pre>
              File "<stdin>", line 1
                  x =
                     ^
              SyntaxError: invalid syntax
              </pre>
              <p>Notice how this attempts to indicate where the syntax error is.
              Essentially, this is an incomplete expression. A lot of learning 
              to code is about interpretting error messages and understanding 
              what to do.</p>
              
              <h3>3.3. Statements</h3>
              <p>Multiple statements on a single line are separated with 
              semicolons (;). At the Python Prompt enter:</p>
              <pre>y=1;x=y;print(x)</pre>
              <p>The output of this is:</p>
              <pre>1</pre>
              <p>Statements might include many expressions and can be formulated 
              over several lines. We will come across some examples shortly...
              </p>
              <p>Python does not have a special symbol to end a statement like 
              many other languages do.</p>
              
              <h3>3.4. Comments</h3>
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
              of comment depends. Sometimes it is good to refer to other 
              information sources in comments.</p>
              
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
              indentation can effect what code does. Also, care must be taken 
              with spaces and tabs as these are different, but spaces can appear
              the same as a tab in many editors. With Python it is recommended 
              not to use tabs at all in source code and to use multiple spaces 
              instead to indent. The following is a code block with an example
              "if" statement:</p>
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
              <p>The print function is a built in function that is located in 
              the __builtins__ module. Have a look at the help for the function 
              by entering:</p>
              <pre><code class=\"language-python\">
              help(print)
              </code></pre>
              
              <h3>3.5. Delimiters, Literals and Operators</h3>
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
              
              <h3>3.6. Identifiers and Keywords</h3>
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
        w.add(addWebReference(
                "https://docs.python.org/3/reference/lexical_analysis.html",
                "Python 3 Lexical Analysis Documentation",
                "Python 3 Lexical Analysis Documentation"));
        w.add("""
              </p>
              
              <h4>3.7. Style</h4>
              <p>The following code block is an "if statement" which has an 
              "else" condition. This can be read as follows: If the variable x
              is greater than the variable y, then  x is printed otherwise y is
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
              <p>Notice that the print function is called with two arguments. 
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
              blocks presented subsequently, will tyically be styled as above.
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
              separate windows. Code can be described in detail and 
              distributed with associated data and visualizations. There are a 
              variety of save options – including saving a document as Web page
              or <a href="https://en.wikipedia.org/wiki/PDF">PDF</a>.</p>
              <p>Jupyter Notebook was renamed from IPython Notebook as the 
              project expanded to allow other REPL languages, including 
              <a href="https://en.wikipedia.org/wiki/R_(programming_language)">R</a>,
              to be integrated.</p>
              <p>Jupyter Notebooks comes bundled with Anaconda and can be 
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
              <pre>print("Hello World")</pre>w
              <p>The following is an image of the one this "Hello World" 
              program has been run:</p>
              <img src="jupyter3.png" alt="Python REPL environment" />
              <p>As you can see, the code in the Jupyter Notebook styles the 
              code. Entire programs can be entered into cells as can 
              <a href="https://www.markdownguide.org/basic-syntax/">markdown</a>
              . Have a play...</p>
              <p>Try downloading, opening and running the following example:
              <a href="https://www.geog.leeds.ac.uk/courses/computing/practicals/python/running-python/examples/Example_Notebook.ipynb">
              Example_Notebook.ipynb</a></p>
              <p>You're not expected to understand the code at this stage, but 
              have a look and if you get an inkling of how it works, all the 
              better.</p>
              
              <h2>6. Integrated Development Environments</h2>
              
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
              
              <h2>6. Python Environments In GIS Software</h2>
              <p>Python environments are provided as part of some Geographical 
              Information System (GIS) software including
              <a href="https://www.qgis.org/">QGIS</a> which is also Free and 
              Open Source Software. Most of QGIS is written in 
              <a href="https://en.wikipedia.org/wiki/C%2B%2B">C++</a> and 
              Python. There is a Plug In Architecture allowing others to write 
              plugins which typically ad something to the interface and provide 
              new functionality or scripted more automated ways to do things.
              </p>
              <p>Download <a href="./QGISExample.py">QGISExample.py</a>, read
              the code and try to run it in QGIS following the instructions in
              the comments at the top of the file which are also reproduced 
              below:</p>
              <p>This course does not cover plugin development for QGIS. For 
              more details about QGIS development see:
              <a href="https://www.qgis.org/en/site/getinvolved/development/development.html">
              https://www.qgis.org/en/site/getinvolved/development/development.html</a>
              </p>
              """);
        w.add("<p>" + addWebReference("https://qgis.org/pyqgis/", 
                "QGIS Python API Documentation", "",
                "") + "</p>");
        w.add("""
              <h2>7. Recap</h2>
              <p>This section of the course introduced some basic Python syntax 
              and considered the evolution of the language. It explored running
              Python code in files, using the REPL environment and help system, 
              Jupyter Notebooks, the IDLE and Spyder IDEs, and the Python 
              environment in QGIS.</p>
              <p>It introduced loading modules using an import statement, and 
              accessing functionality via a dot operator. It introduced 
              a conditional IF statement and a For Loop. (Conditional statements 
              and loops will be gone through in more detail subsequently in the 
              course.)</p>""");
    }
}
