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
        w.add("<h2>1. Introduction</h2>");
        w.add("<p>Variables can be thought of as labels that are assigned"
                + " values which may change. The following code is comprised of"
                + " two statements. The first initialises a variable which is"
                + " given the label x and assigned the value 0. The second"
                + " calls the print function with x passed in as a parameter."
                + "</p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("x = 0");
        w.add("print(x)");
        w.add("</code></pre>");

        w.add("<p>The output from running this code is:</p>");

        w.add("<pre><code>");
        w.add("0");
        w.add("</code></pre>");

        w.add("<p>Let's come back to variables shortly...</p>");
        w.add("<h2>2. Basic Python Syntax</h3>");
        w.add("<h3>2.1. Statements</h3>");
        w.add("<p>Multiple statements on a single line are separated with"
                + " semicolons (;).</p>");
        w.add("<p>Python does not have a special symbol to end a statement"
                + " like many languages do.</p>");
        w.add("<h3>2.2. Comments</h3>");
        w.add("<p>The # symbol is the start of a comment.</p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("# This entire line is a comment");
        w.add("x = 0 # This part of the line is a comment");
        w.add("print(x) # Print out the value of x");
        w.add("# Comments should be informative.");
        w.add("# x = 1 # Commented code is not run.");
        w.add("# x = 2 # Coders commonly comment out options.");
        w.add("#print(x) # And sections of testing code.");
        w.add("</code></pre>");

        w.add("<p>Between triple quotes everything is a comment. There are two"
                + " types of triple quote, those using single quotation marks,"
                + " and those using double quotation marks. Triple double"
                + " quotes (\"\"\") are typically used for documentation"
                + " sections. Triple single quotes (''') are often used to"
                + " comment out sections of code when "
                + addWikipediaReference("Debugging",
                        "debugging") + ".</p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("\"\"\"");
        w.add("This is between triple quotes and is a comment.");
        w.add("\"\"\"");
        w.add("</code></pre>");

        w.add("<p>It is good practise to leave a comment to indicate why a"
                + " section of code has been commented out. Comments help"
                + " make code more readable and understandable. It is not"
                + " uncommon in good code for more than a third of it to be"
                + " comments.</p>");

        w.add("<h3>2.3. Code layout: code blocks</h4>");
        w.add("<p>Blank lines are allowed and can help structure code into"
                + " blocks. It is good practice to start each code block with a"
                + " comment that outlines what the code block is for. For"
                + " example:</p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("# Initialise x and y");
        w.add("x = 2");
        w.add("y = 4");
        w.add("print(x)");
        w.add("print(y)");
        w.add("");
        w.add("# Calculate x to the power of y");
        w.add("x ** y");
        w.add("</code></pre>");

        w.add("<p>Indentation is syntax in Python. Indentation refers to the blank"
                + " space that precedes text on a line. (It is sometimes called"
                + " white space - as code backgrounds were normally white in"
                + " colour). It is good to be consistent with indentation and"
                + " to be aware that indentation can effect what code does."
                + " Also, care must be taken with spaces and tabs as these are"
                + " different, yet can appear identical. With Python it is"
                + " recommended not to use tabs at all in source code and to"
                + " use multiple spaces instead to indent. The following is a"
                + " code block with an example <em>if</em> statement.</p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("# if x is greater than y, then print a");
        w.add("if x > y: # This line has the same indent as the comment above.");
        w.add("    print(x) # This line is indented one standard step further.");
        w.add("print(\"done\") # This line is dedented to the previous level.");
        w.add("</code></pre>");

        w.add("<p>What this code does is test if the variable x is greater"
                + " than the variable y and if so, then the value of x is"
                + " printed. Without the variables x and y being set, then this"
                + " this code will return an error indicating that. The"
                + " function called print is a built in function. We will"
                + " return to functions ad what is built in later...</p>");

        w.add("<h3>2.4. Delimiters, Literals and operators</h3>");
        w.add("<p>Delimiters separate bits of code like blank lines and the"
                + " colon (:) in the if statement above. Some delimeters also"
                + " act as operators. Here are some to look at:</p>");

        w.add("<pre>(       )       [       ]       {       }\n"
                + ",       :       .       ;       @       =       ->\n"
                + "+=      -=      *=      /=      //=     %=      @=\n"
                + "&=      |=      ^=      >>=     <<=     **=</pre>");

        w.add("""
              <p>The various types of bracket ((), [], {}) are parentheses (()),
              square brackets ([]) and curly brackets ({}) also known as braces.
              A lot of code uses brackets. Each open bracket ((, [, {) must be
              matched with a closing bracket (), ], }). Commas (,), colons (:),
              dots (.) and semicolons (;) are also common in code. Let's learn
              more about these later... </p>""");
        
        w.add("""
              <h3>2.5. Identifiers and Keywords</h3>
              <p>Keywords are reserved terms that can't be used for other
              things like variable names (e.g. else, for, if, import).</p>
              <p>Attempting to use them as variable names results in syntax
              errors as in the following where commands were entered at the
              python prompt:</p>""");
 
        w.add("""
              <pre>
              >>> if = 2
                File "<stdin>", line 1
                  if = 2
                     ^
              SyntaxError: invalid syntax
              </pre>""");
        
        w.add("""
              <p>Notice that the syntax error is pointing at the equals sign
              (=). This is because the python interpreter is expecting a
              conditional expression after the keyword (if). The actual issue
              is that there was an attempt to use a keyword as a variable name.
              </p>""");

        w.add("""
              <p>Identifiers are (for the most part) names of variables</p>
              <p>Literals are specific numerical or text values.</p>
              <p>Operators are mathematical symbols (e.g. +, -, *, /, %)</p>
              <p>For more details of Python language lexicon, see the""");
        w.add(addWebReference("https://docs.python.org/3/reference/lexical_analysis.html",
                        "Python 3 Lexical Analysis Documentation",
                        "Python 3 Lexical Analysis Documentation"));
        w.add("</p>");

        w.add("<h4>2.7. Examples</h4>");
        w.add("<p>The following code block is an if statement which has an else"
                + " condition. The way this works is that the expression is "
                + " evaluated and if True, then x is printed otherwise y is"
                + " printed.</p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("""
              x = 0
              y = 1
              # if x is greater than y, then print x
              if x > y:
                  print(\"x\", x)
              else:
                  print(\"y\", y)
              print(\"done\")""");
        w.add("</code></pre>");

        w.add("<p>In this code, the print function takes in two arguments."
                + " There are variables, comments, indentation and"
                + " keywords.</p>");

        w.add("<h2>2. Variables types</h2>");        
        w.add("<p>In Python, there are primitive and non-primitive variable"
                + " types. The four primitive variable types are: Integers, "
                + " Floats, Strings, and Booleans. Everyhing else is a"
                + " non-primitive type. Variable declaration and assignment in"
                + " Python are done in a single step where the type of a"
                + " variable is not explicitly set, it is inferred by what is"
                + " set. Variable labels can be reused and set to different"
                + " values changing the type. This is known as dynamic"
                + " typing. So, it is possible to set a variable as an Integer"
                + " and then set it again to be a String or a List. The"
                + " built in function caled type alows us to test the type of a"
                + " variable.</p>");

        w.add("""
              <pre><code class=\"language-python\">
              # Set x = 1 and print the type of x")
              x = 1
              print(type(x))
              x = "1"
              print(type(x))
              </code></pre>""");

        w.add("<p>The output from running the above is:</p>");
        
        w.add("""
              <pre>
              <class 'int'>
              <class 'str'>
              </pre>""");
        
        w.add("<p></p>");
        
        w.add("<p></p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("for a in range(0, 10) :\n"
                + "    print (a)\n"
                + "    print (\"done\")");
        w.add("</code></pre>");

        w.add("<p></p>");
        w.add("<p></p>");
        w.add("<p></p>");
        w.add("<p></p>");

    }
}
