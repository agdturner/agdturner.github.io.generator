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
        w.add("<h2>Introduction</h2>");
        w.add("<p>After considering basic syntax, this section focuses on "
                + "variables</p>");
        w.add("<h3>Basic Python Syntax</h3>");
        w.add("<h4>Statements</h4>");
        w.add("<p>Multiple statements on a single line are separated with"
                + " semicolons. Yet, it is unusual though to have lines with"
                + " multiple statements.</p>");
        w.add("<p>Python does not have a special symbol to end a statement"
                + " like many languages do.</p>");
        w.add("<p>The following is a Python statement that sets the variable a"
                + " equal to the number 1:</p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("a = 1");
        w.add("</code></pre></p>");

        w.add("<h4>Comments</h4>");
        w.add("<p>The # symbol is the start of a comment.</p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("# This entire line is a comment");
        w.add("a = 1 # This part of the line is a comment");
        w.add("</code></pre>");

        w.add("<p>Between triple quotes everything is a comment. There are two"
                + " types of triple quote, those using single quotation marks,"
                + " and those using double quotation marks. Triple double"
                + " quotes (\"\"\") are typically used for documentation."
                + " Triple single quotes (''') are often used to comment out"
                + " sections of code when debugging (debugging is a coding term"
                + " for the activity of resolving issues to do with code not"
                + " doing what is wanted).</p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("\"\"\"");
        w.add("This is between triple quotes and is a comment.");
        w.add("\"\"\"");
        w.add("</code></pre>");

        w.add("<h4>Code layout: code blocks</h4>");
        w.add("<p>Blank lines are allowed and indeed help structure code into"
                + " blocks. It is good practice to start each code block with a"
                + " comment that outlines what the code block is for. For"
                + " example:</p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("# Initialise a and b");
        w.add("a = 2");
        w.add("b = 4");
        w.add("print(a)");
        w.add("print(b)");
        w.add("");
        w.add("# Calculate a to the power of b");
        w.add("c = a ** b");
        w.add("print(c)");
        w.add("</code></pre>");

        w.add("Indentation is syntax in Python. Indentation refers to the blank"
                + " space (sometimes called white space - as code backgrounds"
                + " were normally white in colour). It is what precedes text on"
                + " a line. It is good to be consistent with indentation and to"
                + " an extent, Python forces this. It is important to know that"
                + " indentation can effect what code does. Also, care must be"
                + " taken with spaces and tabs as these are different and can"
                + " appear identical. With Python it is recommended not to use"
                + " tabs at all in source code and to use multiple spaces"
                + " instead. It is easier to see differences if the indents and"
                + " dedents (where the indent is less than on the preceeding"
                + " statement. For example, here is a code block with a compund"
                + " statement that is an if statement</p>");

        w.add("<pre><code class=\"language-python\">");
        w.add("# if a is greater than b, then print a");
        w.add("if a > b: # This line has the same indent as the comment above.");
        w.add("print a # This line is indented one standard step further.");
        w.add("print(\"done\") # This line is dedented to the previous level.");
        w.add("</code></pre>");

        w.add("Let us give names to some other language features:");
        w.add("<ul>");
        w.add("<li>delimiters - are things that separate and include indents,"
                + " semicolons and commas</li>");
        w.add("<li>keywords - are reserved terms that can't be used for"
                + " anything else like variable names (e.g. if, for, import)"
                + "</li>");
        w.add("<li>identifiers - for the most part, these are names of "
                + "variables</li>");
        w.add("<li>literals - these are specific numerical or text"
                + " values.</li>");
        w.add("<li>operators - these are mathematical symbols (e.g. +, -, *,"
                + " /, %)</li>");
        w.add("</ul>");

        w.add("<pre><code class=\"language-python\">");
        w.add("# if a is greater than b, then print a");
        w.add("if a > b: # This line has the same indent as the comment above.");
        w.add("print a # This line is indented one standard step further.");
        w.add("print(\"done\") # This line is dedented to the previous level.");
        w.add("</code></pre>");

        w.add("<pre><code class=\"language-python\">");
        w.add("if a < 10 :\n"
                + "    print (a)\n"
                + "print (\"done\")");
        w.add("</code></pre>");

        w.add("<pre><code class=\"language-python\">");
        w.add("if a < 10 :\n"
                + "    print (a)\n"
                + "    print (\"done\")");
        w.add("</code></pre>");

        w.add("<p></p>");
        w.add("<p></p>");
        w.add("<p></p>");

    }
}
