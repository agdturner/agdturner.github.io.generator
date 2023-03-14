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
import io.github.agdturner.core.Section;
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
        Section s;
        s = addSection("1", "Introduction", 2);
        w.add(s.sectionHTML);
        String pythonWebsiteLink = c.references.getReference(
                "Python Website");
        String python3ReferenceLink = c.references.getReference(
                "Python 3 Language Reference");
        String pythonStandardLibraryLink = c.references.getReference(
                "Python Standard Library");
        String psfLink = c.references.getReference(
                "Python Software Foundation");
        w.add("<p>"
                + c.index.getReference("Python")
                + " is a popular and powerful high-level programming language "
                + "supported and developed by the "
                + psfLink + " - an organisation with a mission to promote,"
                + " protect, and advance the language, and support and"
                + " facilitate the growth of a diverse and international "
                + "community of python programmers.</p>");
        w.add("<p>The " + pythonStandardLibraryLink + " and various Python"
                + " source code interpreters are freely available in source"
                + " and binary forms for all major platforms from the "
                + pythonWebsiteLink + ", and these may be freely distributed."
                + " Python interpreters translate Python source code into"
                + " machine instructions that work at a much lower level."
                + " The need for interpretation is what classifies Python as a"
                + " high-level language.</p>"
                + "<p>The " + pythonWebsiteLink + " contains distributions of"
                + " and pointers to many third party Python libraries, tools,"
                + " and additional documentation.</p>"
                + "<p>A particularly useful page for beginners is the "
                + python3ReferenceLink + ".</p>");

        s = addSection("2", "Python 3", 2);

        w.add(s.sectionHTML);
        w.add("""
              <p>Python 3 was first released in 2008. For several years both 
              Python 2 and Python 3 were developed and supported, but eventually 
              in January 2020 development and maintenance of Python 2 ceased. 
              We will not look at the differences between Python 2 and Python 3 
              in this course and will focus just on Python 3.</p>
              <p>Python 3.10 was released on the 4th of October 2021.
              Python 3.11 was released on the 24th of October 2022.
              Python 3.12 is due for release in October 2023.
              For each major incremental Python 3 release there is a
              """);
        w.add(c.references.getReference("Python What's New")
                + " webpage that introduces what is new:</p>");
        w.add("<ul>");
        for (int i = 0; i < 12; i++) {
            w.add("<li>" + Web_ContentWriter.getLink(
                    "https://docs.python.org/3/whatsnew/3." + i + ".html",
                    "Whatsnew Python 3." + i) + "</li>");
        }
        w.add("</ul>");
        w.add("<p>On these webpages, changes are marked against numbered"
                + " Python Enhancement Proposals (PEPs). PEPs allow the"
                + " community of Python users to look ahead and see what might"
                + " change and get involved in language development. PEPs have"
                + " their own website: "
                + c.references.getReference(
                        "Python Enhancement Proposal Website")
                + "</p>");
        w.add("<p>As with all programming languages, Python evolves through"
                + " versions. As well as adding new things (such as new kinds"
                + " of expression and new functions), things may also change"
                + " from one version to the next. Though there are few "
                + c.index.getReference("API",
                        "Application Programming Interface", s.sid)
                + " (API) changes - changes to the syntax, names, and details"
                + " of function inputs and outputs that are not "
                + c.index.getReference("Backward Compatibility",
                        "backward compatible", s.sid)
                + ".</p>");
        w.add("""
              <p>New language features will not work with older interpreters,
              and code tested with older interpreters might not necessarily 
              work the same as before with newer interpreters - due to API 
              changes and bug fixes. This is important to bear in mind - for 
              reproducibility of results and diagnosing issues when it can be
              key to know exactly which versions of everything have been used.
              </p>
              """);
        w.add("<p>There is a vast ecosystem of third party python libraries."
                + " Much of this is made available as packages via the "
                + c.references.getReference("PyPI",
                        "Python Package Index (PyPI)")
                + "</p>");
        w.add("""
              <p>In <a href="#9">Section 9</a>, there is an exercise that 
              involves installing Python packages from PyPI and that links to 
              details about how to package code and make it available via 
              PyPI.</p>
              """);

        w.add("<p>The "
                + c.references.getReference("Python Tutorial")
                + " is a good place to start learning Python. In your private"
                + " study time, you might like to make your way through that"
                + " learning material too.</p>");
        w.add("<p>Running Python code in different ways...</p>");

        s = addSection("3", "Running Python", 2);

        w.add(s.sectionHTML);
        w.add("<p>Python instructions also known as 'commands' or 'statements',"
                + " can be entered one at a time at a "
                + c.index.getReference("Command Line Interface",
                        "command-line interface", s.sid)
                + " or passed in a file.</p>");
        w.add("<p>Check if there is a version of Python already on your "
                + c.index.getReference("PATH", s.sid)
                + " by running a 'Terminal' or 'Command Window' and entering"
                + " the following at the prompt:</p>");
        w.add("<pre>python --version</pre>");
        w.add("<p>If 'python' cannot be found, then it is most likely"
                + " that Python is not installed. If a version of Python is"
                + " available, then the version of it should be reported.</p>");
        w.add("<p>" + c.references.getReference("Anaconda")
                + " is a data science platform. It contains:"
                + c.references.getReference("Conda")
                + " - an environment manager; a Python interpreter; some"
                + " commonly used third party Python packages; and, some useful"
                + " additional tools. It is available at the University of"
                + " Leeds via 'AppsAnywhere' using machines on campus or the "
                + "'Academic' "
                + "<a href=\"https://wvd.leeds.ac.uk\">"
                + "University Windows Virtual Desktop"
                + ".</a>");
        w.add("<p>You can also download and install Anaconda on your own"
                + " device. If you do this, then choose the default options"
                + " to avoid interfering with any other version of Python"
                + " already installed on your system. By default, Anaconda"
                + " installs into your user home directory.</p>");

        s = addSection("3.1", "Python REPL", 3);

        w.add(s.sectionHTML);
        w.add("""
              <h4>3.1.1. Hello World</h4>
              <p>Open an Anaconda prompt. On Windows the prompt should look 
              something like:</p>
              <pre>(base) C:\\></pre>
              <p>Here, 'base' is the activated Python environment and 'C:\\' is 
              the current drive and directory. Enter:</p>
              <pre>python --version</pre>
              <p>This should inform you about the version of Python that came 
              with Anaconda. Enter:</p>
              <pre>python</pre>
              <p>You should arrive at the 'Python prompt' that looks something 
              like:</p>
              <pre>>>></pre>
              """);
        w.add("<p>This is a "
                + c.index.getReference("REPL", s.sid)
                + " environment for Python. Enter:</p>");
        w.add("""
              <pre>print("Hello World")</pre>
              <p>You should see the following output:</p>
              <pre>Hello World</pre>
              """);
        s = addSection("3.1.2", "Numerical calculations", 4);

        w.add(s.sectionHTML);
        w.add("""
              <p>The Python prompt can be used for some basic calculations. 
              Enter:</p>
              <pre>2 + 3</pre>
              <p>You should see the result of adding the number 2 to the number
              3:</p>
              <pre>5</pre>
              <p>The plus symbol '+' is the operator for addition. The 
              operator for multiplication is the asterix '*' symbol, try 
              multiplying two numbers.</p>
              <p>The operator symbol for division is the forward slash '/' 
              symbol. Try dividing 3 by 2. Notice that the result is not an 
              integer.</p>
              <p>Run the following command:</p>
              <pre>1 / 0</pre>
              <p>You should get the following Divide by Zero Error message:</p>
              <pre>
              Traceback (most recent call last):
                File "<stdin>", line 1, in <module>
              ZeroDivisionError: division by zero
              </pre>
              <p>Have a play: Try calculating bigger and bigger numbers that are 
              powers of 2. Enter:</p>
              <pre>2 ** 64</pre>
              <p>This calculates 2 to the power of 64 - an integer number with 
              20 digits. Enter:</p>
              <pre>2 ** 1000000</pre>
              <p>This calculates 2 to the power of 1000000 - an integer number 
              with 301030 digits. This may take noticeably more time to 
              calculate and display.</p>
              <p>To calculate how many digits are in a number, it can be 
              converted to a String using the function 'str()', the result of 
              which we can pass into the function 'len()' which gives the 
              length. Enter:</p>
              <pre>len(str(2 ** 1000000))</pre>
              <p>Increasing the power by a further multiple of 10 would give 10 
              times more digits. This takes significantly longer to compute in 
              this way. Enter:</p>
              <pre>len(str(2 ** 10000000))</pre>
              <p>While waiting for an answer, open another Anaconda prompt to 
              look at some small numbers close to zero. Enter:
              <pre>1 / 10</pre>
              <pre>1 / 100</pre>
              <pre>1 / 1000</pre>
              <pre>1 / 10000</pre>
              <pre>1 / 100000</pre>
              <p>Notice how the format of the number printed out changes with 
              the last command. This is a number written in a scientific 
              notation where the letter e stands for 'multiply by 10 raised to 
              the power of'. Enter:<p>
              <pre>1/(2**1074)</pre>
              <pre>1/(2**1075)</pre>
              """);
        w.add("<p>This demonstrates that these types of calculations are "
                + "approximations - ones that use "
                + c.index.getReference("Floating-point", "floating point arithmetic", s.sid)
                + " which rounds to the nearest value that can be represented"
                + " in a specific way.</p>");
        s = addSection("3.2", "Loading Modules and Using Functions", 3);
        w.add(s.sectionHTML);
        w.add("<p>Mathematical operators can also be accessed via functions "
                + "that reside in the "
                + c.index.getReference("Python operator", "operator", s.sid)
                + " module.</p>");
        w.add("""
              <p>Enter:</p>
              <pre>operator.add(2, 3)</pre>
              <p>You should see the following error message:</p>
              <pre>Traceback (most recent call last):
                File "<stdin>", line 1, in <module>
              NameError: name 'operator' is not defined</pre>
              <p>The error is that the interpreter does not know about the
              operator module. Notice the similarity with this error message 
              and the divide by zero error message.</p>
              <p>Enter:</p>
              <pre>dir()</pre>
              <p>This runs (or calls) the function 'dir()'. You can tell it is
              a function as after the name there are start and end parentheses.
              This function takes no arguments as there is nothing between the 
              start and end parentheses.</p>
              <p>The function dir() should print out a list that looks like:</p>
              <pre>['__annotations__', '__builtins__', '__doc__', '__loader__',
              '__name__', '__package__', '__spec__']</pre>
              <p>The list is alphabetically ordered and you can tell it is a 
              list as it starts with an open square bracket '[' and ends with 
              a closing square bracket ']', and each element is separated with a
              comma ','. In the list are module identifiers that the current 
              Python environment has access to (and from which functionality can 
              be used directly).</p>
              <p>Enter:</p
              <pre>import operator</pre>
              <p>This imports or loads the operator module so that it's 
              functionality can be accessed.</p>
              <p>Enter:</p>
              <pre>dir()</pre>
              <p>You should see the operator module in the list.</p>
              <p>Enter:</p>
              <pre>operator.add(2, 3)</pre>
              <p>Now, you should not get the error encountered before the 
              operator module was imported, but a result.</p>
              <p>The dot '.' in this command is an operator called the 'dot 
              operator'. It instructs the python interpretter to look inside the 
              thing on the left (of the dot) to find the thing on the right 
              (of the dot). So, the expression looks inside the operator module 
              for the function 'add', and passes into the it two parameters in 
              the given order. The function returns the result of summing these
              two numbers, and the result is displayed.</p> 
              <p>To list the functions in the operator module, enter:</p>
              <pre>dir(operator)</pre>
              <p>It is quite a long list!</p>
              <p>Notice that there are numerous functions that have a name 
              starting and ending with a double underscore '__'. These are not 
              normally called directly, but they can be.</p>
              <p>Enter:</p>
              <pre>operator.__add__(2, 3)</pre>
              <p>Python does not exert access control on variables and 
              functions. A naming convention is used to indicate to users 
              whether a variable or function is meant to be accessed from 
              outside the module. Underscores '_' and double underscores '__' at
              the start and/or end of identifiers have a special meaning in 
              Python. As a general rule, you should not modify anything with 
              these in their name.</p>
              <p>Have a play and use some other functions from the operator 
              module.</p>
              """);
        s = addSection("3.3", "The Help System", 3);
        w.add(s.sectionHTML);
        w.add(c.index.getReference("Python help", "", s.sid));
        w.add("""
              <p>At the Python prompt, enter:</p>
              <pre>help(operator.add)</pre>
              <p>This prints out some information about how to use the operator
              module add function.</p>
              <p>Enter the following to enter the help system:</p>
              <pre>help()</pre>
              <p>The prompt should change to the 'Help prompt' and look like:</p>
              <pre>help> </pre>
              <p>Read what is printed.</p>
              <p>Enter:</p>
              <pre>modules</pre>
              <p>It may take a few minutes to report a list of available 
              modules.</p>
              <p>At the Help prompt enter:</p>
              <pre>operator</pre>
              <p>This should display the start of the help documentation for the 
              operator module. Press the &lt;enter&gt; key to see the next line 
              of the documentation. Press and hold the &lt;enter&gt; key and the 
              documentation should stream to the screen. The &lt;space&gt; bar 
              key streams the documentation a page at a time. The &lt;q&gt; key 
              quits and should return you to the prompt.</p>
              <p>Have a look at some documentation for other modules.</p>
              <p>To exit the help system and return you to the Python prompt, 
              enter:</p>
              <pre>q</pre>
              <p>Before learning how to run a file of Python commands, let us 
              consider a bit more basic Python syntax.</p>
              """);
        s = addSection("4", "Basic Python Syntax", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>The syntax of a computer programming language are the rules 
              about how it must be written.</p>
              """);
        s = addSection("4.1", "Syntax Errors", 3);
        w.add(s.sectionHTML);
        w.add("<p>If a statement or expression is syntactically incorrect, and"
                + " the Python interpreter attempts to interpret it, a "
                + c.index.getReference("Syntax Error", "syntax error", s.sid)
                + " gets raised.</p>");
        w.add("""
              <p>At the Python prompt enter:</p>
              <pre>x=</pre>
              """);
        w.add("<p>You should get the following "
                + c.index.getReference("Python SyntaxError", "SyntaxError", 
                        s.sid)
                + ":</p>");
        w.add("""
              <pre>
              File "<stdin>", line 1
                  x =
                     ^
              SyntaxError: invalid syntax
              </pre>
              <p>Notice how this attempts to indicate where the syntax error 
              is.</p>
              <p>Essentially, the issue with this code is that the expression is 
              incomplete: There should be something on the right of the equals 
              sign '='.</p>
              <p>One of the key skills in coding is learning to read and 
              understand error messages.</p>
              
              <h3 id="4.2">4.2. Statements</h3>
              <p>Multiple statements on a single line are separated with 
              semicolons ';'. At the python prompt enter:</p>
              <pre>y=1;x=y;print(x)</pre>
              <p>The output should be:</p>
              <pre>1</pre>
              <p>The same line could be spaced out more and each statement could
              be on a separate line.</p> 
              <p>Individual statements might include mulitple expressions and 
              can be formulated over several lines. We will consider some 
              examples of these shortly...</p>
              <p>Python does not have a special symbol to end a statement like 
              many other languages do.</p>
              """);

        s = addSection("4.3", "Comments", 3);

        w.add(s.sectionHTML);

        w.add("""
              <p>The # symbol is the start of a comment.</p>
              <pre>
              # This entire line is a comment
              x = 0 # This part of the line is a comment
              print(x) # Print out the value of x
              # Comments should be informative.
              # x = 1 # Commented code is not run.
              </pre>
              """);
        w.add("<p>Between triple quotes everything is a comment. There are two"
                + " types of triple quote, those using single quotation marks,"
                + " and those using double quotation marks.</p>");
        w.add("<p>Triple double quotes are used for "
                + c.index.getReference("Python docstring", "docstrings", s.sid)
                + " - a form of source documentation that will be detailed"
                + " later in the course.</p>");
        w.add("<p>Triple single quotes are useful for commenting out"
                + " sections of code when "
                + c.index.getReference("Debugging", "debugging", s.sid)
                + ".</p>");
        w.add("""
              <pre>
              '''
              This is between triple single quotes and is a comment
              '''
              
              \"\"\"
              This is between triple double quotes and is a comment.
              \"\"\"
              
              '''
              \"\"\"
              This is both between triple single and double quotes and is a comment.
              \"\"\"
              '''
              </pre>
              <p>Comments are to help make code easier for humans to read and 
              understand. It can be helpful to refer to other information 
              sources in comments. It is sensible to add a comment to inform 
              why code is commented out.</p>
              
              <h3 id="4.4">4.4. Code Layout</h3>
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
              blank space that precedes expressions on a line. (Blank space is 
              sometimes called 'white space' - as code backgrounds were normally 
              white in colour). It is good to be consistent with indentation and 
              to be aware that indentation can effect what code does. Care must 
              be taken with spaces and tabs in this respect as these are 
              different, but often a number of spaces appears the same as a 
              single tab. It is recommended not to use tabs at all in python 
              source code and to use multiple spaces instead to indent. The 
              following is a code block with an example If Statement:</p>
              <pre>
              # if x is greater than y, then print a
              if x > y: # This line has the same indent as the comment above.
                  print(x) # This line is indented one standard step further.
              print(\"done\") # This line is indented to the previous level.
              </pre>
              <p>In the code above, if the variable 'x' is greater than the 
              variable 'y', then the value of 'x' is printed. If the variable 
              'x' has not been initialised, then there will be an error:</p>
              <pre>Traceback (most recent call last):
                File "<stdin>", line 1, in <module>
              NameError: name 'x' is not defined</pre>
              """);
        w.add("<p>The function "
                + c.index.getReference("Python print", "print", s.sid)
                + " is a function of the "
                + c.index.getReference("Python builtins", "builtins", s.sid)
                + " module that is loaded by default. Read the the help for it."
                + " Enter:</p>");
        w.add("<pre>help(print)</pre>");
        
        s = addSection("4.5", "Delimiters, Literals and Operators", 3);
        w.add(s.sectionHTML);
        w.add("<p>Delimiters in code separate and help organise things. The "
                + " following are "
                + c.index.getReference("Python delimiters", s.sid)
                + ":</p>");
        w.add("""
              <pre>(       )       [       ]       {       }
              ,       :       .       ;       @       =       ->
              +=      -=      *=      /=      //=     %=      @=
              &=      |=      ^=      >>=     <<=     **=</pre>
              <p>The various types of bracket are paired: parentheses '()',
              square brackets '[]' and curly brackets '{}' also known as braces.
              A lot of code uses brackets. Each open bracket must be paired 
              with a closing bracket. Failure to pair brackets correctly is 
              problematic and is a common reason for confusion. Commas ',', 
              colons ':', dots '.' and semicolons ';' are also commonly used 
              delimeters in code. Details of these other delimiters are omitted 
              for the time being, but some are also operators.</p>
              <p>Literals are specific numerical or text values.</p>
              """);
        w.add("<p>Operators are sequences of symbols that are shorthand for "
                + c.index.getReference("Python operator", "operator", s.sid)
                + " module functions (e.g. +, -, *, /, %)</p>");
        
        s = addSection("4.6", "Identifiers and Keywords", 3);
        w.add(s.sectionHTML);
        w.add("<p>Identifiers are names of variables, functions, classes,"
                + " modules and packages.</p>");
        w.add("<p>A Python "
                + c.index.getReference("Python keyword", "keyword", s.sid)
                + " is a reserved word - a term that can't be used for an"
                + " identifier.</p>");
        w.add("<p>Attempting to "
                + c.index.getReference("Name Binding", "use", s.sid) 
                + " a keyword as an identifier such as a variable name"
                + " typically results in a "
                + c.index.getReference("Syntax Error", "syntax error", s.sid)
                + ". Enter the following at the Python prompt:</p>");
        w.add("""
              <pre>if = 2</pre>
              <p>This should result in:</p>
              <pre>File "@lt;stdin>", line 1
                  if = 2
                     ^
              SyntaxError: invalid syntax</pre>
              <p>Notice that the syntax error is pointing at the equals sign
              '='. This is because the Python interpreter is expecting a
              conditional expression after the keyword 'if'. The error has come 
              about because of the attempt to use a keyword as a variable name.
              </p>
              """);
        w.add("<p>For details, see the "
                + c.references.getReference(
                        "Python Lexical Analysis Documentation"));
        w.add("""
              </p>
              
              <h4 id="4.7">4.7. Style</h4>
              <p>The following code block is an If Statement which has an 
              Else Condition. This can be read as follows: If the variable x
              is greater than the variable y, then x is printed, otherwise y is
              printed.</p>
              <pre>x = 0 
              y = 1
              # If x is greater than y, then print x, else print y.
              if x > y:
                  print("x", x)
              else:
                  print("y", y)</pre>
              <p>The function print is called with two arguments, and the code 
              contains variables, comments, indentation, operators and 
              keywords. Styling can be used added to make it easier to 
              identify different parts, read and understand code. The following 
              is the same code, but coloured to make different things in the 
              code easier to identify:</p>
              <pre><code class="language-python">x = 0
              y = 1
              # if x is greater than y, then print x
              if x > y:
                  print("x", x)
              else:
                  print("y", y)
              print("done")</code></pre>
              <p>The style does not change the meaning of the code, but it can 
              make it easier to read and understand. Most code blocks presented 
              subsequently in these learning resources will typically be styled 
              as in the last snippet.</p>
              
              <h2 id="5">5. Running a file of Python commands</h2>
              <p>Create a new ASCII text file, add to it the following line:</p>
              <pre>print("Hello World")</pre>
              <p>Save the file with the name "HelloWorld.py". Open an Anaconda 
              prompt. Change to the directory where you saved the file 
              'path_to_directory' using:</p>
              <pre>cd path_to_directory</pre>
              <p>Run the file using:</p>
              <pre>python HelloWorld.py</pre>
              <p>You should see the following printed to the console:</p>
              <pre>Hello World</pre>
              <p>If your file is on a different drive in Windows, then you 
              may have to switch to the drive before changing to the directory 
              within the drive. To change from drive 'C:' to drive 'M:' in 
              Windows, enter the following at the prompt:</p>
              <pre>M:</pre>
              <p>To change back again to 'C:', enter the following at the 
              prompt:</p>
              <pre>C:</pre>
              <p>For code in files, the statements are executed from top to 
              bottom, but the flow may call functions which may themselves call 
              other functions. The interpreter returns to the line of code after 
              a function call once the function has been executed.</p>
              <p>Try creating another file, add some Python commands and run it.
              </p>
              <p>It is not necessary to run files of Python code from the 
              directory in which the file is located. A path to the file can be 
              given in the Python command. That path can be absolute (from 
              the base of the file system) or relative (from the current 
              directory.</p>
              """);

        s = addSection("6", "Jupyter Notebook", 2);

        w.add(s.sectionHTML);
        w.add("<p>"
                + c.references.getReference("Jupyter Notebook")
                + ", is a "
                + c.index.getReference("REPL", s.sid)
                + " like system that embeds code into a document"
                + " containing other information: text, images, data, and"
                + " links. Code is entered in cells which when run present"
                + " outputs within the document which is displayed in a Web"
                + " browser (unless ouputs are configured to appear in separate"
                + " windows).</p>");
        w.add("<p>Jupyter Notebook comes bundled with Anaconda and can be "
                + "downloaded separately from:"
                + c.references.getReference("Jupyter")
                + ".</p>");
        w.add("""
              <p>At the Anaconda prompt change to a directory where you can 
              write new files and enter:</p>
              <pre>jupyter notebook</pre>
              <p>Some messages should appear in the Command Window and a Web 
              browser tab should open with the Jupyter Notebook Interface.</p>
              <p>From the New Button drop down list of the Jupyter Notebook 
              Interface, select:</p>
              <pre>Python 3 (ipykernel)</pre>
              <p>The New Button is highlighted with a red oval in the following 
              image of the interface:</p>
              <img src="../../resources/python/jupyter1.png" alt="Jupyter Notebook Interface 1" />
              <p>A python REPL environment should appear in another browser tab
              like shown in the following image:</p>
              <img src="../../resources/python/jupyter2.png" alt="Jupyter Notebook Interface 2" />
              <p>Try typing the following at the prompt and actioning run:</p>
              <pre>print("Hello World")</pre>
              <p>You should see something like:</p>
              <img src="../../resources/python/jupyter3.png" alt="Jupyter Notebook Interface 3" />
              """);
        w.add("<p>Entire programs can be entered into cells as can "
                + c.index.getReference("Markdown", s.sid)
                + ".</p>");
        w.add("<p>Because a Jupyter Notebook application runs in a Web "
                + "browser, it can utilise "
                + c.index.getReference("JavaScript", s.sid)
                + " - a programming language that all widely used modern Web "
                + "browsers can run. Leveraging JavaScript and Python allows "
                + "for the generation of some Web based interactive maps. In "
                + "<a href=\"#9\">Section 9</a>, there is a practical exercise "
                + "about this. Prior to attempting this, it is important to "
                + "learn about setting up Python environments and installing "
                + "Python packages. First though, let's explore running Python "
                + "code in some other ways...</p>");

        s = addSection("7", "Integrated Development Environments", 2);

        w.add(s.sectionHTML);

        w.add("<p>"
                + c.index.getReference("IDE", 
                        "Integrated Development Environments", s.sid)
                + "(IDEs) are software tools used to make writing code and "
                + "developing software easier. This section introduces "
                + c.references.getReference("IDLE")
                + " and "
                + c.references.getReference("Spyder")
                + "- IDEs that come with "
                + c.references.getReference("Anaconda")
                + ".</p>");
        s = addSection("7.1", "IDLE", 3);
        w.add(s.sectionHTML);
        w.add("""
              <p>Python comes with IDLE - an Integrated Development and Learning 
              Environment. The IDLE application has an 'editor window' for 
              editing files of Python commands, and a 'console window' for 
              entering REPL commands and displaying output. At the Anaconda 
              prompt enter:</p>
              <pre>idle</pre>
              <p>This should open up the IDLE console window that should look 
              something like the image below:</p>
              <img src="../../resources/python/idle1.png" alt="The IDLE interface" />
              <p>As well as the python console prompt, there are some menus. 
              Choose:</p>
              <pre>File -> Open...</pre>
              <p>Open your HelloWorld.py file. It should open the file in an 
              editor window that looks something like:</p>
              <img src="../../resources/python/idle2.png" alt="The IDLE file editor window interface" />
              <p>Notice that as with a Jupyter Notebook, the code appearing in 
              the IDLE editor window is styled.</a>
              <p>The editor window has other menu options. Select:</p>
              <pre>Run -> Run Module</pre>
              <p>This should run the HelloWorld.py file, and output to the 
              console in the other window which should appear something like:</p>
              <img src="../../resources/python/idle3.png" alt="The IDLE interface having run the Hello World program" />
              """);
        w.add("<p>"
                + c.references.getReference("IDLE")
                + " is an IDE that comes with Python.</p>);");
        w.add("<p>Close down the instance of IDLE that is running.<p>");
        s = addSection("7.2", "Spyder", 3);
        w.add(s.sectionHTML);
        w.add("<p>"
                + c.references.getReference("Spyder") 
                + " - the Scientific PYthon Development EnviRonment, is"
                + " currently more sophisticated IDE that comes with Anaconda."
                + "</p>");
        w.add("""
              <p>From the Anaconda prompt enter:</p>
              <pre>spyder</pre>
              <p>It may take a couple of minutes to load, when you should see 
              something like this:</p>
              <img src="../../resources/python/spyder1.png" alt="The Spyder interface" />
              <p>The pane to the left is the 'editor pane'. The pane to the top 
              right is the 'inspector pane'. The pane to the bottom right is the 
              'console pane'.</p>
              <p>From the menu, choose:</p>
              <pre>File -> Open...</pre>
              <p>Open your 'HelloWorld.py' file which should appear in the 
              editor pane. From the menu, choose:</p>
              <pre>Run -> Run</pre>
              <p>If a popup box appears choose the default and this should run 
              your program and output should apear in the console like in the 
              following image:</p>
              <img src="../../resources/python/spyder2.png" alt="The Spyder interface showing the Hello
              World program successfully run" />
              <p>Use the editor and add the following in line 2:</p>
              <pre>x = y</pre>
              """);
        w.add("<p>Try to run the file again. It should raise a "
                + c.index.getReference("Python NameError", "NameError", s.sid)
                + " and there should be marks against the code on line 2 on "
                + "the left and right of the editor pane. Hover your mouse "
                + "cursor over the mark on the left. You should see something "
                + "similar to the image below:</p>");
        w.add("""
              <img src="../../resources/python/spyder3.png" 
              alt="The Spyder interface showing an error." />
              """);
        w.add("<p>Have a look at the latest "
                + c.references.getReference("Spyder Documentation")
                + "</p>");
        w.add("""
              <h3 id="7.3">7.3 Other IDEs</h3>
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
              """);
        s = addSection("8", "QGIS Desktop Python Console", 2);
        w.add(s.sectionHTML);
        w.add("<p>"
                + c.index.getReference("Geographical Information System (GIS)")
                + " software are used to create, manage, process, model,"
                + " visualise and distribute geographical data and information."
                + c.references.getReference("QGIS") 
                + " Desktop is GIS software that is "
                + c.index.getReference("Free and Open Source Software", 
                "free and open source")
                + ", there is currently a thriving developer and user "
                + "community and a Python "
                + c.index.getReference("API")
                + ". QGIS is mostly written in mixture of "
                + c.index.getReference("C++", s.sid)
                + " and Python and there is both Desktop and Server software"
                + " that to some extent can be automatedusing Python APIs."
                + "</p>");
        w.add("<p>QGIS Desktop is often controlled via a "
                + c.index.getReference("GUI", s.sid)
                + ". The GUI has a Menu, Panels and Toolbars. Load QGIS "
                + "Desktop via 'AppsAnywhere' or download, install and run it "
                + "on your own device.</p>");
        w.add("<p>As QGIS Desktop software loads, a splash screen should "
                + "appear. When fully loaded the GUI should appear.</p>");
        w.add("""
              From the GUI Menu select:</p>
              <pre>Plugins > Python Console</pre>
              <p>You should see something like:</p>
              <img src="../../resources/python/qgis1.png" alt="QGIS Desktop Python Console basic interface" />
              <p>There are 5 buttons, a display area and a Python prompt:</p>
              <pre>>>></pre> 
              <p>At the Python prompt enter:</p>
              <pre>dir()</pre>
              <p>A considerable amount of functionality should be listed in the 
              display area of the Python Console.</p>
              <p>To list the functionality of the QGIS Desktop interface, 
              enter:</p>
              <pre>dir(iface)</pre>
              """);
        w.add("<p>"
                + c.index.getReference("PyQGIS", s.sid)
                + " allows us to access all the functionality accessible via "
                + "the QGIS Desktop GUI programatically, and gives greater "
                + "control in data loading and processing. It also allows us "
                + "to develop and use additional functionality including "
                + "functionality available in the Python environment provided."
                + "</p>");
        w.add("""
              <p>In the QGIS Desktop Python console, locate and action the 
              'Show Editor' button. The 'editor panel' should appear on the 
              right of the console.</p>
              <p>Download
              <a href="../../resources/python/QGIS1.py">QGIS1.py</a> - a Python
              source code file written to be run in the QGIS Desktop Python 
              console. Read the source code, and run the program following the 
              instructions that are in the multi-line comment at the top of the
              source code. (An outline of what to expect is provided in that 
              multi-line comment.)</p>
              <p>The import statements are at the top (which is good practise). 
              Code is organised into code blocks with comments that outline what 
              each code block does (also good practise). The import statements 
              start with the keyword 'from' which details from which package the 
              specified modules are imported.</p>
              """);
        w.add("<p>The code contains some "
                + c.index.getReference("For Loop", "for loops")
                + " which start with the keyword 'for'. The first of these "
                + "iterates over the 'fields' in a 'layer'. The others iterate "
                + "over the 'features' in a 'layer'. (Iteration simply means "
                + "going through a collection of things one at a time.)</p>");
        w.add("<p>The program accesses both attribute and geometry data from a "
                + "layer, and adds data into the QGIS Desktop GUI display."
                + "</p>");
        w.add("<p>Once the program has run the QGIS Desktop GUI should look "
                + "something like:</p>");
        w.add("""
              <img src="../../resources/python/qgis2.png" alt="QGIS Python 
              Console after having run QGISExample.py" />
              </p>
              <p>QGIS Desktop Plugins can be written in both C++ and Python. For 
              details see the following:
              </p>
              <ul>
              <li><a href="https://www.qgis.org/en/site/getinvolved/development/development.html">
              QGIS Development Web Page</a></li>
              <li><a href="https://docs.qgis.org/testing/en/docs/pyqgis_developer_cookbook/plugins/index.html#developing-python-plugins">
              PyQGIS Development Cookbook: Plugins Web Page: Section on Developing Python Plugins</a></li>
              </ul>
              """);
        
        s = addSection("9", "Python Packages and Environment Management", 2);

        w.add(s.sectionHTML);
        
        w.add("""
              <p>Packaging code and delivering it to users via repositories is 
              good practise for a numerous reasons. Many software and code 
              repositories are language specific or software specific (like QGIS
              Desktop Plugins), components within the repositories are packaged 
              in standard ways, and there is some process of review and some 
              policy about package availability and removal. For details on 
              packaging Python code see the following:
              """);
        w.add(c.references.getReference("Python Packaging User Guide")
                + " - a collection of tutorials and references to help you "
                + "distribute and install Python packages with modern tools.");
        w.add("""
              <p>For those just beginning to learn to program, learning to 
              package code is jumping a step ahead. However, it helps to be 
              aware of Python packaging and repositories as a beginner from the 
              offset, and to learn about managing Python Environments, 
              installing packages into them and understand a few key things 
              about dependencies.</p>
              """);
        w.add("<p>As mentioned, "
                + c.references.getReference("PyPI")
                + " is a widely used repository. Developers deploy packages"
                + " there for users. Many are provided as "
                + c.index.getReference("Free and Open Source Software")
                + ", although private proprietary packages are also supported."
                + "</p>");
        w.add("""
              <p>When installing a package, by default package dependencies are
              installed at the same time. In Python terms, a dependency is a 
              package, module or function that some other code needs in order to 
              work. At the package level, for any package that is being 
              installed, a dependency list (tree) can be generated which 
              includes all the dependencies. It is referred to as a tree as 
              there can be several levels as packages may depend on other 
              packages, but in fact it can be more like a web as there can be 
              common dependencies in the tree.</p>
              <p>One of the criticisms levelled at Python is to do with 
              dependency management. When code in two different packages depends 
              on different versions of common dependency there is what is known 
              as a dependency conflict. There are ways to work around this using
              something called orchestration which involves organising multiple 
              Python environments with different versions of the same package 
              installed in different environments, but this is fiddly and is 
              regarded as an advanced topic that we will not cover in this 
              course.</p>
              <p>Learning about creating, activating, using, deactivating and 
              deleting Python environments is important for orchestration and 
              for other reasons introduced below, so we cover these things in 
              this section.</p>
              <p>It is easy to pollute environments by installing packages (and 
              their dependencies) that turn out not to be useful and that then 
              get in the way - using up resources and slowing things down. This
              is in part because uninstalling packages and removing all their 
              dependencies is not easy due to the way things are organised. 
              Managing environments is the recommended Python way to do deal 
              with this for the time being.</p>
              <p>The general advice for the time being is to install all the 
              required packages and their dependencies at the same time. The 
              main reason for this is that dependency conflict resolution is 
              easier then and takes place. For example, if one dependency 
              requires a version between 1.2 to 1.5 of a particular package and 
              another requies a version from 1.1 to 1.10, then version 1.5 would 
              be installed and if there is a conflict that cannot be resolved 
              this would become clear. If the installations were done one at a 
              time, there is greater risk that version 1.10 would be the version 
              available and it could be hard to diagnose issues as a result of 
              this.</p>
              """);
        w.add("<p>"
                + c.references.getReference("Conda")
                + " is a package and environment manager that comes with "
                + "Anaconda. There is another common way to create and manage "
                + "Python environments using "
                + c.index.getReference("Python venv", "venv", s.sid)
                + " - which creates what are termed 'Virtual Environments' and "
                + c.references.getReference("PIP", "pip")
                + ". These are much like the Python environments created by"
                + " Conda (and the commands for doing this are very similar)."
                + " Conda is the recommended way of installing some Python"
                + " GIS packages. It is not necessarily that those packages"
                + " cannot be configured and made to work using venv and pip,"
                + " but that such configuration is currently more complicated,"
                + " especially on Microsoft Windows operating systems.</p>");
        w.add("""
              <p>Open an Anaconda prompt, change to a directory where you can 
              write files and enter the following command to create a list of
              Python packages available in the Python environment:</p>
              <pre>pip list > piplist.txt</pre>
              <p>It may take a minute or so to run, and it should output an 
              ASCII text file containing a list of names with version numbers 
              (that produced should be similar to 
              <a href="../../resources/python/piplist.txt">piplist.txt</a>, but there may be 
              differences).</p>
              <p>Enter the following command to create a similar list:</p>
              <pre>conda list > condalist.txt</pre>
              <p>Again, it may take a minute or so to run, and it should output
              an ASCII text file (similar to  
              <a href="../../resources/python/condalist.txt">condalist.txt</a>).</p>
              <p>Enter the following command to create an explicit list of all 
              the conda packages sved in a file named "spec-file.txt":</p>
              <pre>conda list --explicit > spec-file.txt</pre>
              <p>You or others can use this file or something similar to 
              replicate the environment on another resource. For details of how
              to do that see:
              <a href="https://conda.io/projects/conda/en/latest/user-guide/tasks/manage-environments.html#sharing-an-environment">
              The Conda User Guide Page on Managing Environments Section on 
              Sharing an Environment</a></p>
              <p>Get a list of available Conda environments. Enter:</p>
              <pre>conda env list</pre>
              <p>The list is displayed and should look something like:</p>
              <pre># conda environments:
              #
              base                  *  C:\\ProgramData\\Anaconda3</pre>
              <p>Often when creating an Python environment, it is for a specific 
              purpose and only specific packages are installed. It is advised to
              install packages together as the installer attempts to resolve 
              conflicts and ensure the versions of packages installed will work 
              together. Below, the instructions are to install a default Python
              environment - one that comes with Anaconda, then install in this 
              environment all the packages needed for this course. Altogether 
              you need about 2GB of space in the location where you create the 
              environment.
              """);
        w.add("<p>Creating Python environments on Cloud storage such as on "
                + "<a href=\"https://en.wikipedia.org/wiki/OneDrive\">"
                + "Microsoft OneDrive</a>"
                + " or "
                + "<a href=\"https://en.wikipedia.org/wiki/GoogleDrive\">"
                + "Google Drive</a>"
                + " is currently not recommended. On University of Leeds"
                + " campus computers or the 'Academic' "
                + "<a href=\"https://wvd.leeds.ac.uk\">"
                + "University Windows Virtual Desktop</a>"
                + " it is recommended to create the Python environment on the "
                + "M:\\ drive, for example in the following location:");
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
                + "environments in a directory called 'envs' located wherever "
                + "Anaconda is installed."
                + "Confirm the environment creation by pressing the <y> key "
                + "when prompted. Creating the environment should just take a "
                + "few seconds. Once created, check it is listed. Enter:</p>");
        w.add("<pre>conda env list</pre>");
        w.add("<p>You should see something like what is shown below. The "
                + "details can vary depending on where the environment was "
                + "created:<p>");
        w.add("<pre># conda environments:");
        w.add("#");
        w.add("base             *  C:\\ProgramData\\Anaconda3");
        w.add("myenv               " + envPath + "</pre>");
        w.add("<p>Conda environments are registered/listed in the '.conda' "
                + "directory in your user home directory in a file with the "
                + "name 'environments.txt'.</p>");
        w.add("<p>Assuming you named your environment 'myenv', activate it by"
                + " entering:</p>");
        w.add("<pre>conda activate " + envPath + "</pre>");
        w.add("""
              <p>The prompt should change to have "(myenv)" prepended</p>
              <p>Next install the following Python packages:</p>
              <ul>
              <li><a href="https://contextily.readthedocs.io/en/latest/">Contextily</a></li>
              <li><a href="https://github.com/Toblerity/Fiona">Fiona</a></li>
              <li><a href="https://python-visualization.github.io/folium/">Folium</a></li>
              <li><a href="https://geopandas.org/">Geopandas</a></li>
              <li><a href="https://readthedocs.org/projects/pip/">pip</a></li>
              <li><a href="https://pypi.org/project/ipykernel/">ipykernel</a></li>
              <li><a href="https://pypi.org/project/PyQt5">PyQt5</a></li>
              <li><a href="https://pypi.org/project/spyder-kernels/">spyder-kernels</li>
              </ul>
              <p>Enter:</p>
              <pre>conda install -c conda-forge contextily fiona folium geopandas pip pysal ipykernel spyder spyder-kernels=2.2</pre>
              <pre>pip install pyqt5</pre>
              <p>Install 'myenv' into the 'ipykernel' so it is available via the 
              Jupyter Notebook interface:</p>  
              <pre>python -m ipykernel install --user --name=myenv</pre>
              <p>Download
              <a href="../../resources/python/Jupyter1.ipynb">
              Jupyter1.ipynb</a>, save it to a directory and start 
              Jupyter Notebook so it can load the file.</p>
              <p>Enter the following to run Jupyter Notebook:</p>
              <pre>jupyter notebook --NotebookApp.max_buffer_size=1073741824</pre>
              <p>This gives Jupyter Notebook twice as much memory as the current 
              default (which helps prevent memory errors being encountered).</p> 
              <p>Wait for a Web browser tab to appear with the Jupyter Notebook 
              interface. When it appears select:<p>
              <pre>New > myenv</pre>
              <p>Open 'Jupyter1.ipynb' read and run it cell by cell.</p>
              <p>If for some reason that does not work, then try something a bit 
              simpler and copy the code below into a cell and run it.</p>
              <pre><code class="language-python"># Simple example code 
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
              
              map</code></pre>
              <p>This should produce a slippy map with an icon on it that looks 
              something like:</p>
              <img src="../../resources/python/jupyter4.png" alt="Jupyter Notebook Interface 4" />
              <p>From the Jupyter Notebook interface choose:</p>
              <pre>new > Python 3 (ipykernel)</pre>
              <p>Try running the same code. Most likely, the folium package is 
              not installed in your base environment and the following error is
              thrown:</p> 
              <pre>---------------------------------------------------------------------------
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
               
               ModuleNotFoundError: No module named 'folium'</pre>
              <p>Exit Jupyter Notebook and deactivate myenv2 by entering:</p>
              <pre>deactivate myenv2</pre>
              <p>To remove the conda environment myenv2 use:</p>
              <pre>conda remove --name myenv --all</pre>
              <p>This ends the section on environment management and installing 
              packages.</p> 
              <p>Below are key references for installing packages using pip and conda:</p>
              <ul>
              <li><a href="https://packaging.python.org/en/latest/tutorials/installing-packages/#use-pip-for-installing">
              https://packaging.python.org/en/latest/tutorials/installing-packages/#use-pip-for-installing</a></li>
              <li><a href="https://docs.anaconda.com/anaconda/user-guide/tasks/install-packages/">
              https://docs.anaconda.com/anaconda/user-guide/tasks/install-packages/</a></li>
              </ul>

              <h2 id="10">10. Recap and Expectations</h2>
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
              Python/Conda environments and installing Python packages in them.
              </p>
              <p>Some example code has been provided. This is quite good code in
              that there are plentiful comments, and the code also does some 
              interesting things: The code that automated some QGIS Desktop 
              processing demonstrates how to access functionality from within 
              QGIS. The Jupyter Notebook based example utilised Javascript 
              capabilities of the Web browser and leveraged some widely used 
              Python GIS tools.</p>
              <p>This has been a broad brush overview. You might benefit from 
              revisiting parts of this learning once you are a bit more familiar
              with developing Python code and as you think about undertaking 
              projects.</p>
              </div>
              """);
    }

}
