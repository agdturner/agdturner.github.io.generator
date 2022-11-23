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
                + " printed. Much of the code is comment.</p>");

        w.add("<h3>2.4. Delimiters, Literals and operators</h3>");
        w.add("<p>Delimiters separate bits of code like blank lines and the"
                + " colon (:) in the if statement. Some delimeters also act as"
                + " operators. Here are some to look at:</p>");

        w.add("pre>(       )       [       ]       {       }\n"
                + ",       :       .       ;       @       =       ->\n"
                + "+=      -=      *=      /=      //=     %=      @=\n"
                + "&=      |=      ^=      >>=     <<=     **=</pre>");

        w.add("<p>You might have be able to guess what some of these do... To "
                + "be more sure you can search online and run some tests.");
        w.add("<h3>2.5. Identifiers and Keywords</h3>");
        w.add("<p>Keywords are reserved terms that can't be used for other "
                + " things like variable names (e.g. if, for, import).</p>");
        w.add("<p>identifiers are for the most part names of variables</p>");
        w.add("<p>For details see the "
                + addWebReference("https://docs.python.org/3/reference/lexical_analysis.html",
                        "Python documentation Lexical Analysis",
                        "Python documentation Lexical Analysis")
                + "</p>");
        w.add("<p>Literals are specific numerical or text values.</p>");
        w.add("<p>Operators are mathematical symbols (e.g. +, -, *, /, %)</p>");

        w.add("<h4>2.7. Examples</h4>");
        w.add("<p>The following code block is an if statement which has an else"
                + " part. The way this works is that the expression is "
                + " evaluated and if True, then x is printed otherwise y is"
                + " printed.</p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("# if x is greater than y, then print x");
        w.add("if x > y:");
        w.add("    print(x)");
        w.add("else:");
        w.add("    print(y)");
        w.add("print(\"done\")");
        w.add("</code></pre>");

        w.add("<p>If the variable x was set to the value 10 and the variable"
                + " y was set to the value 5, what would be the output from"
                + " running this code?</p>");

        w.add("<p>Test your understanding in a Python environment.</p>");
        w.add("<p>Variables can be set equal to each other.</p>");
        w.add("<p></p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("if a > b :\n"
                + "    print (a)\n"
                + "print (\"done\")");
        w.add("</code></pre>");

        w.add("<pre><code class=\"language-python\">");
        w.add("if a > b :\n"
                + "    print (a)\n"
                + "    print (\"done\")");
        w.add("</code></pre>");

        w.add("<pre><code class=\"language-python\">");
        w.add("for a in range(0, 10) :\n"
                + "    print (a)\n"
                + "    print (\"done\")");
        w.add("</code></pre>");

        w.add("<p></p>");
        w.add("<p></p>");
        w.add("<p></p>");

    }
}
