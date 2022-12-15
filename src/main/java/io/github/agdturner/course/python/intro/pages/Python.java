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
                + " freely distributed. There are various Python interpretters"
                + " that read source code written in Python and translate it"
                + " into machine instructions. We won't concern ourselves with"
                + " the differences in this course.</p>"
                + "<p>The Python Website contains distributions of and pointers"
                + " to many Free and Open Source third party Python modules,"
                + " programs, tools, and additional documentation.</p>"
                + "<p>A particularly useful documentation page for beginners is"
                + " the " + python3ReferenceLink + ".</p>");
        w.add("""
              <h2>2. Python 3</h2>
              <p>Python 3 was first released in 2008. Most third party packages 
              written in Python 2 needed major modifications in order to work as
              intended or at all in Python 3 environments. For several years 
              Python 2 and Python 3 were both developed, but eventually in 
              January 2020 development and maintenance of Python 2 ceased. We 
              will not look at the differences between Python 2 and Python 3 in 
              this course and will focus just on Python 3.</p>
              <p>On October 4, 2021 Python 3.10 was released.
              On November 24th, 2022 Python 3.11 was released.
              <!--On <date> Python 3.12 was released.-->
              For each incremental releases there are Whatsnew Web Pages:</p>
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
              <p>On Whatsnew Web Pages, changes are marked against numbered 
              Python Enhancement Proposals (PEPs) which allow us to look ahead 
              to see what might change and get involved in language development. 
              PEPs have their own Web site:""");
        w.add(addWebReference("https://peps.python.org/",
                "Python Enhancement Proposal Website",
                "https://peps.python.org/",
                ""));
        w.add("""
              </p>
              <p>New features of say Python 3.11 will not work in Python 3.10. 
              Code written and tested with a Python 3.10 interpretter is not 
              guaranteed to work in a Python 3.11.</p>              
              <p>So, for reproducing results and diagnosing issues. It is 
              important to know and sometimes provide information about exactly
              which version of: Python you have tested with; and, third party 
              dependecies are used.</p>
              
              <p>As well as the core of the Python language - the language 
              specification and a reference implementation of an interpretter
              (<a href="https://github.com/python/cpython">cpython</a>), 
              there is a vast ecosystem of third party packages that extend the 
              language. There are also other interpretters written in other 
              languages, but we will not concern ourselves with these.</p>

              <p>Many third party Python packages are useful and many are 
              available via the
              <a href="https://pypi.org/">PyPI</a> Python Package Index.</p>
              <p>In Section 9, there is an exercise that involves installing 
              Python packages from PyPI and that links to details about how to 
              package code and make it available via PyPI.</p>
              <p>Most of the additions to the core Python language used in this 
              course are distributed as part of Anaconda which we will learn 
              more about and start using shortly...</p>
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
              focused. In your own study time, you might like to make your way 
              through that learning material too.</p>
              <p>The following sections of this Web page comprise practical 
              exercises to get you running Python code in different ways. All 
              these ways are useful to know about.</p>
              
              <h2>3. Running Python from the Command Prompt</h2>
              <p>Python instructions also known as commands or statements, can 
              typically be entered in a Terminal or Command Window. They can 
              also be passed in files to be interpretted as explained in Section 
              6.</p>
              <p>Check if you have a version of Python on your path. In a 
              Terminal or Command Window enter the following at the prompt:</p>
              <pre>python --version</pre>
              <p>If the command cannot be found, then this means that the system 
              or some other software installed is not depending on a version of 
              Python. If a version of Python is already on your system then 
              the version of Python should be reported.</p>
              <p><a href="https://www.anaconda.com/">Anaconda</a> is a data 
              science platform. If you want, download and install it choosing 
              the default options so as not to interfere with any version of
              python already installed on your system. Typically this will by
              default install into your user home directory if you do not have 
              permission to install elsewhere.</p>
              <p>Anaconda is also available at the University of Leeds via the 
              Windows Virtual Desktop which can be accessed via the following
              URL:<p>
              <p><a href="https://wvd.leeds.ac.uk">https://wvd.leeds.ac.uk</a>
              </p>
              <p>Once logged in load Anaconda via AppsAnywhere.</p>
                            
              <h3>3.1. Python REPL</h3>
              
              <h4>3.1.1. Hello World</h4>
              <p>Open the Anaconda Prompt. It should provide a prompt that looks
              something like:</p>
              <pre>(base) C:\\></pre>
              <p>"(base)" is the activated Python environment and "C:\" is the 
              current directory. Enter:</p>
              <pre>python --version</pre>
              <p>This should output the version of Python that came with 
              Anaconda, for example:</p>
              <pre>Python 3.9.12</pre>
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
              
              <h4>3.1.2. Numberical calculations</h4>
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
              
              <h3>3.2. Loading Modules and Using Functions</h3>
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
              environment has access to and from which functionality can be 
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

              <h3>3.3. The Help System</h3>
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
              
              <h2>4. Basic Python Syntax</h3>
              <p>The syntax of a computer programming language are the rules 
              about how it must be written.</p>
              
              <h3>4.1. Syntax Errors</h3>
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
              
              <h3>4.2. Statements</h3>
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
              
              <h3>4.3. Comments</h3>
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
              
              <h3>4.4. Code Layout</h3>
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
              
              <h3>4.5. Delimiters, Literals and Operators</h3>
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
              
              <h3>4.6. Identifiers and Keywords</h3>
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
              
              <h4>4.7. Style</h4>
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
              
              <h2>5. Running a file of Python commands</h2>
              <p>Create a new ASCII text file, add to it the following line:</p>
              <pre>print("Hello World")</pre>
              <p>Save the file with the name "HelloWorld.py". Open a Command 
              Window. Change to the directory where you saved the file 
              (path_to_directory) using:</p>
              <pre>cd path_to_directory</pre>
              <p>Run the file using:</p>
              <pre>python HelloWorld.py</pre>
              <p>You should see the following printed to the console:</p>
              <pre>
              Hello World
              </pre>
              <p>For code in files, the statements are executed from top to 
              bottom, but the flow may call functions and return to a statement
              at the end of running the function. We will learn how to define 
              functions later in the course, but we lear about calling and using 
              functions soon...</p>
              <p>Try creating another file adding some Python commands and 
              running it.</p>
              <p>It is not necessary to run the files of Python code from the 
              directory in which the file is located. You can provide a path to
              the file in the run command. That path can be absolute (from the 
              base of the file system) or relative (from the current 
              directory).</p>
              
              <h2>6. Jupyter Notebook</h2>
              <p>Jupyter Notebook, is a REPL based system that embeds code into 
              a document containing other information: text, images, data, and 
              links. Code is entered in cells which when run present outputs 
              within the document which is displayed in a Web browser (unless 
              configured to appear in separate windows). Code can be described 
              in detail and distributed with associated data and visualizations.
              </p>
              <p>Jupyter Notebook was renamed from IPython Notebook as 
              <a href="https://en.wikipedia.org/wiki/R_(programming_language)">
              R (programming language)</a>
              support was added. It comes bundled with Anaconda and can be 
              downloaded separately from 
              <a href="https://jupyter.org/">Jupyter</a>.</p>
              <p>Key reference for Jupyter notebooks:
              <a href="https://jupyter-notebook.readthedocs.io/">
              https://jupyter-notebook.readthedocs.io/</a></p>
              <p>At the command prompt change to a directory where you can write
              new files and enter:</p>
              <pre>jupyter notbook</pre>
              <p>Some messages should appear in the Command Window and a Web 
              browser tab should open with the Jupyter Notebook Interface.</p>
              <p>From the New Button drop down list of the Jupyter Notebook 
              Interface, select:</p>
              <pre>Python 3 (ipykernel)</pre>
              <p>The New Button is highlighted with a red oval in the following 
              image of the interface:</p>
              <img src="jupyter1.png" alt="Jupyter Notebook Interface 1" />
              <p>A Python REPL environment should appear in another browser tab
              like shown in the following image:</p>
              <img src="jupyter2.png" alt="Jupyter Notebook Interface 2" />
              <p>Try typing the following at the prompt and actioning run:</p>
              <pre>print("Hello World")</pre>
              <p>You should see something like:</p>
              <img src="jupyter3.png" alt="Jupyter Notebook Interface 3" />
              <p>Entire programs can be entered into cells as can 
              <a href="https://www.markdownguide.org/basic-syntax/">markdown</a>
              .</p>
              <p>In Section 8 there is a further exercise using Jupyter 
              Notebooks. Because Jupyter Notebooks runs in the browser, it can 
              utilise
              <a href="https://en.wikipedia.org/wiki/JavaScript">Javascript</a>
              - a programming language that all widely used modern Web browsers 
              work with. This allows us to leverage Javascript from Python which 
              can be very useful for generating interactive maps. Prior to that, 
              there are some exercises on setting up environments and installing 
              packages, as an easy way to get interactive maps working in a 
              Jupyter notebook is to make use of additional packages that are 
              not included in the Python environment provided currently in a 
              default Anaconda install.</p>
              
              <h2>7. Integrated Development Environments</h2>
              
              <p><a href="https://en.wikipedia.org/wiki/Integrated_development_environment">
              Integrated Development Environment</a>s (IDEs) are software tools 
              used to make writing code and developing software easier. This 
              section introduces IDLE and Spyder - IDEs that come with Anaconda.
              </p>
              
              <h3>7.1. IDLE</h3>
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
              
              <h3>7.2. Spyder</h3>
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
              
              <h3>7.3 Other IDEs</h3>
              <p>There are other IDEs that support Python code development. If 
              you are already familiar with an IDE that supports Python code 
              development, then you might like to give it a try. Other IDEs that 
              might be useful to you in future include:
              <a href="https://www.jetbrains.com/pycharm/">PyCharm</a>
              , and
              <a href="https://www.pydev.org">PyDev</a>
              <!--
              for 
              <a href="https://en.wikipedia.org/wiki/Eclipse_(software)">Eclipse</a>
              -->
              .
              </p>
              
              <h2>8. Python and GIS Software</h2>
              <p>Geographical Information System (GIS) software are used to 
              create, manage, process, model, visualise and serve geographical 
              data and information. Some GIS software allows users to automate 
              tasks using a Python Application Program Interface to access the 
              core GIS functionality which may or may not be written in a 
              different programming language. Usually what this involves is the 
              GIS software including a Python environment within it. Section 
              7.1 introduces how to do this with QGIS Desktop software which 
              also has a plugin architecture that allows for it's Graphical User 
              Interface (GUI) to be extended by plugins written in Python. 
              Section 7.2. considers some other open source GIS software written 
              in Python.</p>
              
              <h3>8.1. QGIS Desktop</h3>
              <p><a href="https://www.qgis.org/">QGIS</a> software, sometimes 
              called Quantum GIS, is widely used both in and outwith academia. 
              There are both server and client software mostly written in 
              mixture of 
              <a href="https://en.wikipedia.org/wiki/C%2B%2B">C++</a>
              and Python. QGIS is Free and Open Source Software and there is a 
              thriving developer and user community.</p>
              <p>If you are not already familiar with the QGIS Desktop Graphical 
              User Interface (GUI), then hopefully you can still follow along 
              and appreciate the utility of the QGIS Desktop Python Application 
              Program Interface (API).</p>
              """);
        w.add("<p>" + addWebReference("https://qgis.org/pyqgis/", 
                                            "QGIS Python API Documentation", "",
                                            "") + "</p>");
        w.add("""
              <p>The QGIS Desktop GUI has a Menu, Panels and Toolbars. Please 
              download, install and start QGIS Desktop, or simply 
              start it if you already have it available to you. It can be 
              downloaded via:
              <a href="https://www.qgis.org/">https://www.qgis.org/</a>
              </p>
              <p>A splash screen should appear as the software loads, after 
              which the GUI should appear. From the GUI Menu select:</p>
              <pre>Plugins > Python Console</pre>
              <p>You should see something like:</p>
              <img src="qgis1.png" alt="QGIS Python Console basic interface" />
              <p>There are 5 buttons, a display area and a Python Prompt:</p>
              <pre>>>></pre> 
              <p>At the Python Prompt enter:</p>
              <pre>dir()</pre>
              <p>A considerable amount of functionality should be listed in the 
              display area of the Python Console.</p>
              <p>To list the functionality of the QGIS interface, enter:</p>
              <pre>dir(iface)</pre>
              <p>The QGIS Python API allows us to access all the functionality 
              in the GUI programatically, gives greater control in data loading 
              and processing, and allows us to use additional functionality 
              available in the Python environment provided.</p> 
              <p>Locate and action the Python Console Show Editor Button.</p>
              <p>The Editor should appear on the right of the Python Console.
              </p>
              <p>Download <a href="./QGIS1.py">QGIS1.py</a> -  a Python source 
              code file written to be run in the QGIS Desktop Python Console.
              Read the source code, and run the program following the 
              instructions that are in the multi-line comment at the top of 
              source code. (An outline of what to expect is provided in that 
              multi-line comment too.)</p>
              <p>The import statements are at the top (which is good practise). 
              Code is organised into code blocks with comments that outline what 
              each code block does (also good practise). The import statements 
              start with the keyword "from" which details from which package the 
              specified modules are imported. In the code there are some For 
              Loops which start with the keyword "for". The first of these 
              iterates over the fields in a layer. The others iterate over the 
              features in a layer. The program accesses both attribute and 
              geometry from a layer, and adds data into the QGIS Desktop GUI 
              display.</p>
              <p>Once the program has run the QGIS interface should look 
              something like:
              <img src="qgis2.png" alt="QGIS Python Console after having run QGISExample.py" />
              </p>
              <p>As previously mentioned, QGIS Desktop has a plug in 
              architecture. Plugins can be written in both C++ and Python. This 
              course does not provide instructions for writing plugins, but here 
              are some key links about that:
              </p>
              <ul>
              <li><a href="https://www.qgis.org/en/site/getinvolved/development/development.html">
              QGIS Development Web Page</a></li>
              <li><a href="https://docs.qgis.org/testing/en/docs/pyqgis_developer_cookbook/plugins/index.html#developing-python-plugins">
              PyQGIS Development Cookbook: Plugins Web Page: Section on Developing Python Plugins</a></li>
              </ul>

              <h3>8.2. Other GIS software written in Python</h3>
              <p>As well as Python APIs for automating GIS software, there are 
              initiatives developing GIS software in Python using just the 
              Python core language (and third party packages). Some of these 
              will be introduced in due course.</p>
              
              <h2>9. Python Packages and Environment Management</h2>
              <p>Packaging code and delivering it to users via repositories is 
              sensible for numerous reasons. The main reasons are to do with 
              security, availability, and understanding dependencies and 
              utilisation of packages. Many software and code repositories are 
              language specific, components within are packaged in standard 
              ways, and there is some process of review and some policy about 
              package availability and removal. A key reference for packaging 
              Python code is:
              """);
        w.add(addWebReference(
                "https://packaging.python.org/", 
                "Packaging Python", ""));
        w.add("""
              <p>For those just beginning to learn to program, learning to 
              package code is jumping a step ahead. However, helps to be aware 
              of packaging and repositories, to learn how to install packages
              from repositories into environents, and to understand about
              dependencies.</p>
              <p>As mentioned, <a href="https://pypi.org/">PyPI</a> is a widely 
              used repository, for deploying packages to, and for users to get 
              packages from. Many packages are provided as open source software. 
              Private packages are also supported, but we will not be using any 
              in this course.</p>
              <p>Often when installing a package, it is necessary to install a 
              number of other packages that are dependencies. In Python terms, 
              a dependency is a module that some other module needs in order to 
              work. Often the details are at the level of functions. As code is 
              refactored, sometimes module dependencies change and functions 
              change. A function's name may change, the specification of the 
              parameters it expects may change, and the details of what is 
              returned may change in ways such that some code calling the 
              funtion is either syntactically incorrect, or no longer works.
              Internally, functions may utilise other different functions, but 
              if the interface does not change, then code that worked with 
              previous version is likely to still work. The only way to be 
              confident is to test. We will come onto testing later...</p>
              <p>One of the criticisms levelled at Python is to do with 
              dependency management. Suppose modules from two different packages 
              depend on different versions of another module (and there is no 
              common version of that module that contains all that is wanted). 
              In this scenario, some way of using two different versions of 
              these dependencies is wanted. This involves orchestration - 
              something not covered in this introductory course. In some cases, 
              it is probably better to try to avoid the need for orchestration 
              and expend efort investigating if and how the modules depending on 
              an older version of a module can be modified to use a newer 
              version. Whilst again the details of this are beyond introductory
              level, the way to do this is to: read documentation, try to find 
              out if others have come across this issue, investigate any 
              workarounds suggested, and perhaps contact package developers to 
              raise an issue. How best to "raise an issue" all depends on what 
              platforms the package developers are using. Let us leave that 
              tangent and refocus on managing environments and installing
              packages.</p>
              <p>Learning about creating, activating, using, deactivating and 
              deleting Python environments is important for other reasons: It is 
              easy to pollute environments by installing packages (and their 
              dependencies) that turn out not to be useful and that then get in
              the way - using up resources and slowing things down. Also, in 
              setting up new environments a degree of dependency conflict 
              analysis is automatically done, which can result in environments 
              that work better than those that are created by installing 
              dependencies in a more peacemeal fashion - which can have 
              undesirable side effects as upgrading or downgrading dependencies
              can be necesssary in order to install a package and it seems there 
              is less intelligence in the package installers at this level. It 
              is worth noting that uninstalling packages is often as cumbersome 
              as setting up new environments. So, my recommendation once you 
              have enviornments that you care about is to look after these and 
              use others to experiment and for development. Often systems end up 
              with a production environment and one or more development 
              environments, and this fits with that.</p>
              <p>Furthermore, to facilitate reproducing scientific results and 
              information used in policy making, it is good to be explicit and 
              clear about exactly what versions of all software have been used 
              to generate outputs, as well as the process for doing this, and 
              some information about resource requirements. (The more automated 
              the output generation process, the easier reproducibility becomes 
              and the more trust and assurance carries through into evidence 
              bases.</p>
              <p>So, it is usual and good practice to set up and use different 
              environments and so managing environments is a key topic.</p>
              <p>Conda is a package manager that comes with Anaconda. In 
              addition to managing packages, Conda is also an environment 
              manager. There are other ways to create and manage environments 
              using
              <a href="https://docs.python.org/3/library/venv.html">venv</a> - 
              which creates what are termed Virtual Environments. These are much
              like the Python environments created by Conda. The reason for us 
              using Conda is because this is a recommended way of installing 
              some packages that are helpful for geographical data processing 
              and visualisation. It is not necessarily that those packages 
              cannot be configured and made to work using venv and pip, but that 
              such configuration can be more complicated and varies more for 
              different platform operating systems currently. A key reference 
              for Conda:
              <a href="https://docs.conda.io/">https://docs.conda.io/</a>
              </p>
              <p>Open an Anaconda Prompt, change to a directory where you can 
              write files and enter the following command to create a list of
              Python packages available in the Python environment:</p>
              <pre>pip list > piplist.txt</pre>
              <p>It may take a minute or so to run, and it should output an 
              ASCII text file containing a list of names with version numbers 
              (that produced should be similar to 
              <a href="./piplist.txt">piplist.txt</a>, but there may be 
              differences).</p>
              <p>Enter the following command to create a similar list:</p>
              <pre>conda list > condalist.txt</pre>
              <p>Again, it may take a minute or so to run, and it should output
              an ASCII text file (similar to  
              <a href="./condalist.txt">condalist.txt</a>).</p>
              <p>Enter the following command to create an explicit list of all 
              the conda packages sved in a file named "spec-file.txt":</p>
              <pre>conda list --explicit > spec-file.txt</pre>
              <p>You or others can use this file or something similar to 
              replicate the environment on another resource. For details of how
              to do that see:
              <a href="https://conda.io/projects/conda/en/latest/user-guide/tasks/manage-environments.html#sharing-an-environment">
              https://conda.io/projects/conda/en/latest/user-guide/tasks/manage-environments.html#sharing-an-environment</a>
              </p>
              <p>Get a list of available environments. Enter:</p>
              <pre>conda env list</pre>
              <p>The list is displayed and should look something like:</p>
              <pre># conda environments:
              #
              base                  *  C:\\ProgramData\\Anaconda3</pre>
              <p>Often when creating an environment, it is for a specific 
              purpose and only specific packages are installed. It is advised to
              install packages together as the installer attempts to resolve 
              conflicts and ensure the versions of the package dependencies 
              installed will work together. You are instructed to install a 
              default environment with just the core of the version of Python 
              that comes with Anaconda, then install on this environment all the 
              packages needed for this course. Altogether you need about 2GB of 
              space in the location where you install the environment. 
              Installation onto OneDrive is not advised. On University of Leeds 
              shared computers or on the Windows Virtual Desktop, it is 
              recommended that you organise to install onto the M:\\ drive e.g.
              into:
              """);
        String envPath = "M:\\" + c.getCourseCode1() + "\\envs";  
        w.add(envPath);
        w.add("<p>Create the directory in which to store the environment.</p>");
        envPath = envPath + "\\myenv";
        w.add("<p>Create the environment giving it a name added to the end of "
                + "the directory path. Enter:</p>");
        w.add("<pre>conda create -p " + envPath + "</pre>");
        w.add("<p>The -p option is the option to use a path to get conda to "
                + "install the environment in a particular location. The path "
                + "example given here is for Windows if using Linux or MacOS, "
                + "then the path will be different. By default conda creates "
                + "environments in a directory called envs located wherever "
                + "Anaconda is installed."
                + "Confirm the environment creation by pressing the <y> key "
                + "when prompted. When the environment creating is complete, "
                + "which should just take a few seconds. Check the newly "
                + "created environment is listed. Enter:</p>");
        w.add("<pre>conda env list</pre>");
        w.add("<p>You should see something like what is shown below. The "
                + "details can vary depending on where the environment was "
                + "installed:<p>");
        w.add("<pre># conda environments:");
        w.add("#");
        w.add("base             *  C:\\ProgramData\\Anaconda3");
        w.add("myenv               " + envPath + "</pre>");
        w.add("<p>Conda environments are registered/listed in the .conda "
                + "directory in your home directory in a file with the name "
                + "environments.txt</p>");        
        w.add("<p>Assuming you named your environment myenv, activate it by"
                + " entering:</p>");
        w.add("<pre>conda activate " + envPath + "</pre>");
        w.add("""
              <p>The prompt should change to have "(myenv)" prepended</p>
              <p>Next step is to install a set of packages including:</p>
              <ul>
              <li><a href="https://contextily.readthedocs.io/en/latest/">Contextily</a></li>
              <li><a href="https://github.com/Toblerity/Fiona">Fiona</a></li>
              <li><a href="https://python-visualization.github.io/folium/">Folium</a></li>
              <li><a href="https://geopandas.org/">Geopandas</a></li>
              <li><a href="https://readthedocs.org/projects/pip/">pip</a></li>
              <li><a href="https://pypi.org/project/ipykernel/">ipykernel</a></li>
              <li><a href="https://www.riverbankcomputing.com/static/Docs/PyQt5/">PyQt5</a></li>
              </ul>
              <p>Install these as well as ipykernel and spyder-kernels=2.2. Enter:</p>
              <pre>conda install -c conda-forge contextily fiona folium geopandas pip pysal ipykernel spyder spyder-kernels=2.2</pre>
              <p>Install PyQt5 with:</p>
              <pre>pip install pyqt5</pre>
              <>
              <p>Install myenv into the ipykernel so it is available via the 
              Jupyter Notebook interface.</p>  
              <pre>python -m ipykernel install --user --name=myenv</pre>
              <p>Download
              <a href="./Jupyter1.ipynb">Jupyter1.ipynb</a> and save it in a 
              directory and start Jupyter Notebook so it can load the file.</p>
              <p>Enter the following to run Jupyter Notebook:</p>
              <pre>jupyter notebook --NotebookApp.max_buffer_size=1073741824</pre>
              <p>This gives Jupyter Notebook twice as much memory as the current 
              default to overcome memory errors.</p> 
              <p>Wait for a Web browser tab to appear with the Jupyter Notebook 
              interface. When it appears select:<p>
              <pre>New > myenv</pre>
              <p>Open Jupyter1.ipynb read and run it cell by cell.</p>
              <p>If for some reason that does not work, then try something a bit 
              simpler and copy the code below into a cell and run it.</p>
              <pre><code class=\"language-python\">
              # Simple example code 
              import folium
              
              map = folium.Map(
                  location=(53.804, -1.555),
                  zoom_start=16,
                  control_scale=True
              )
              
              ccg = folium.Marker(
                  location=(53.8041954,-1.5549235),
                  tooltip="Centre for Computational Geography",
                  icon=folium.Icon()
              )
              ccg.add_to(map)
              
              map
              </code></pre>
              <p>This should produce a slippy map with an icon on it that looks 
              something like:</p>
              <img src="jupyter4.png" alt="Jupyter Notebook Interface 4" />
              <p>From the Jupyter Notebook interface choose:</p>
              <pre>new > Python 3 (ipykernel)</pre>
              <p>Try running the same code. Most likely, the folium package is 
              not installed in your base environment and the following error is
              thrown:</p> 
              <pre>
               ---------------------------------------------------------------------------
               ModuleNotFoundError                       Traceback (most recent call last)
               Input In [1], in <cell line: 1>()
               ----> 1 import folium
                     3 map = folium.Map(
                     4     location=(53.804, -1.555),
                     5     zoom_start=16,
                     6     control_scale=True
                     7 )
                     9 ccg = folium.Marker(
                    10     location=(53.8041954,-1.5549235),
                    11     tooltip="Centre for Computational Geography",
                    12     icon=folium.Icon()
                    13 )
               
               ModuleNotFoundError: No module named 'folium' 
              </pre>
              <p>Exit Jupyter Notebook and deactivate myenv2 by entering:</p>
              <pre>deactivate myenv2</pre>
              <p>To remove the conda environment myenv2 use:</p>
              <pre>conda remove --name myenv --all</p>
              <p>This ends the section on environment management and installing 
              packages.</p> 
              <p>Below are key references for installing pacakges using pip and conda:</p>
              <ul>
              <li><a href="https://packaging.python.org/en/latest/tutorials/installing-packages/#use-pip-for-installing">
              https://packaging.python.org/en/latest/tutorials/installing-packages/#use-pip-for-installing</a></li>
              <li><a href="https://docs.anaconda.com/anaconda/user-guide/tasks/install-packages/">
              https://docs.anaconda.com/anaconda/user-guide/tasks/install-packages/</a></li>
              </ul>

              <h2>10. Recap and Expectations</h2>
              <p>This section of the course introduced some basic Python syntax 
              and considered the evolution of the language. It explored running
              Python code: using the REPL environment and help system; in files;  
              Jupyter Notebooks; the IDLE and Spyder IDEs; and the Python 
              environment in QGIS.</p>
              <p>It introduced loading modules using import statements, and 
              accessing functionality via a dot operator. There are example 
              IF Statements and For Loops which we will learn about again 
              shortly.</p>
              <p>Versioning and packaging were introduced, as was managing 
              Python/Conda environments and installing packages in them.</p>
              <p>Some example code has been provided. This is quite good code in
              that there are plentiful comments, and the code also does some 
              interesting things: The code that automated some QGIS Desktop 
              processing demonstrates how to access functionality from within 
              QGIS. The Jupyter Notebook based example utilised Javascript 
              capabilities of the Web browser and leveraged some widely used 
              Python GIS tools.</p>
              <p>This has been a broad brush overview which you might like to 
              revisit once you are a bit more familiar with developing Python
              code and as you think about doing projects.</p>
              <p>You are not expected to remember all the details, but hopefully 
              you are gaining confidence that you are on a good learning path, 
              and you are enjoying the learning journey.</p>
              """);
    }
}
