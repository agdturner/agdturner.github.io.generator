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
package io.github.agdturner.course.coding.intro.python.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.course.CoursePage;

/**
 * For Python Intro Course Variables Page.
 *
 * @author Andy Turner
 */
public class Variables extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public Variables(PythonIntroCodingCourse course) {
        super(course, "variables", "Variables", "Variables");
    }
    
    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        addParagraphStart(sb, "");
        sb.append(index.getReference("Variable", "Variables", sid));
        addParagraphEnd(sb, 
                """
                are a combination of an identifier (a name) and a value
                """);

        sid = addSection("Python Variables", sb);
        addParagraph(sb,
                """
                In Python, the 'type' of a variable does not have to be declared
                - it is effectively inferred by the value of the variable (if it
                needs to be).
                """);
        addParagraphStart(sb,
                """
                In Python, identifiers such as variable names can be reassigned.
                A benefit of this is that
                """);
        sb.append(index.getReference("API", "APIs"));
        addParagraphEnd(sb,
                """
                can be more stable (as there is no need to specify exactly what
                types of things are input and output from functions). A downside
                is that, it is easier to make mistakes and accidentally re-use
                an identifier with unintended consequences.
                """);
        addParagraph(sb,
                """
                The four primitive variable types in Python are: Integers,
                Floats, Strings, and Booleans:
                """);
        addParagraphStart(sb,
                """
                Integers are whole numbers and are unbounded in Python. The
                largest Integer is constrained by
                """);
        sb.append(index.getReference("Memory", "memory", sid));
        addParagraphEnd(sb, " availability.");
        addParagraphStart(sb, "Floats are standard ");
        sb.append(index.getReference("Double-precision Floating-point", sid));
        sb.append(
                """
                numbers - a special subset of fractions. These have a 'Maximum
                Value' and a 'Minimum Normal Value' (smallest number &gt; 0)
                which can be ascertained from the
                """);
        sb.append(index.getReference("Python sys", "sys", sid));
        addParagraphEnd(sb,
                """
                module. There are Float values for positive and negative
                infinity. Consider and run the following code:
                """);
        addPythonCodeBlock(sb,
                """
                import sys

                # Exploring Float max and min values.
                max = sys.float_info.max
                min = sys.float_info.min
                print("max", max)
                print("min", min)

                # Are there any changes?
                print("max + min", max + min)
                print("max - min", max - min)
                print("min + min", min + min)

                # What number do we need to add to max to get inf?
                max2 = max
                d = 2
                while max2 == max:
                    max2 = max2 + d
                    d *= 2
                d = d / 2
                print("d", d)
                print("max + d/2", max + d/2)
                print("max + d", max + d)

                # Find a number bigger than min which is the same when min is 
                # added to it. 
                min2 = min * 10**16
                min3 = min2 + min
                if min3 > min2:
                    print("min3 > min2")
                print("min2", min2)
                """);
        addParagraph(sb, "This code generates the following output:");
        addPre(sb,
                """
                max 1.7976931348623157e+308
                min 2.2250738585072014e-308
                max + min 1.7976931348623157e+308
                max - min 1.7976931348623157e+308
                min + min 4.450147717014403e-308
                d 9.9792015476736e+291
                max + d/2 1.7976931348623157e+308
                max + d inf
                min2 2.2250754194454158e-293
                """);
        addParagraphStart(sb, 
                """
                Float is very useful for approximate numerical calculations. Do
                keep in mind that
                """);
        sb.append(index.getReference("Floating-point",
                        "Floating Point Arithmetic", sid));
        addParagraphEnd(sb,
                """
                is approximate - so calculations that use it are not necessarily
                accurate.
                """);
        addParagraphStart(sb, "The ");
        sb.append(references.getReference("Python 3 Documentation: Library",
                        "Python Standard Library"));
        sb.append(" has two modules that support more arithmetic accuracy: ");
        sb.append(index.getReference("Python decimal", "decimal", sid));
        sb.append("; and, ");
        sb.append(index.getReference("Python fractions", "fractions", sid));
        addParagraphEnd(sb, ".");
        addParagraphStart(sb,
                """
                Strings are essentially blocks of text (which are sequences of
                single character length Strings). Strings can be assigned using;
                double or single quotes, or the constructor function
                """);
        sb.append(index.getReference("Python str", "str", sid));
        addParagraphEnd(sb,
                """
                (which can for example create a String from an Integer). Strings
                can be compared and checked for equality using the operator
                '=='. Consider and run the following code:
                """);
        addPythonCodeBlock(sb,
                """
                s = "A"
                s2 = "a"
                s3 = "B"
                print(s == s)  # Prints True
                print(s == s2) # Prints False (case sensitive)
                print(s == s3) # Prints False
                print(s > s2)  # Prints False
                print(s < s2)  # Prints True
                print(str(3))  # Prints 3
                """);
        addParagraph(sb, 
                "Booleans are 'True' or 'False' and also equate to '0' or '1'.");
        addParagraph(sb, "Consider and run the following code:");
        addPythonCodeBlock(sb, 
                """
                t = True
                f = False
                print("t == t", t == t)             # Prints True
                print("f == f", f == f)             # Prints True
                print("t == 1", t == 1)             # Prints True
                print("f == 0", f == 0)             # Prints True
                print("t != f", t != f)             # Prints True
                print("not t", not t)               # Prints False
                print("not f", not f)               # Prints True
                print("t and f", t and f)           # Prints False
                print("t and not f", t and not f)   # Prints True
                print("t or f", t or f)             # Prints True
                print("not (t or f)", not (t or f)) # Prints False
                """);
        addParagraph(sb,
                """
                More complex objects have state given by multiple primitives
                variables. Objects can also be comprised of multiple other
                objects as defined by a class.
                """);
        addParagraphStart(sb, 
                "The type of any object can be got using the function ");
        sb.append(index.getReference("Python type", "type", sid));
        sb.append(" from the ");
        sb.append(index.getReference("Python builtins", "builtins", sid));
        addParagraphEnd(sb, 
                """
                module. Consider and run the following code that initialises a
                variable named 'x' with the Integer value '1', then prints out
                the type of the variable 'x', then reassigns 'x' to have a
                String value, then again prints out the type of the variable
                'x'.
                """);
        addPythonCodeBlock(sb, 
                """
                # Set x = 1 and print the type of x")
                x = 1
                print(type(x)) # Prints &lt;class 'int'&gt;
                x = "1"
                print(type(x)) # Prints &lt;class 'str'&gt;
                """);
        addParagraph(sb, "The output from running this code is:");
        addPre(sb, 
                """
                &lt;class 'int'&gt;
                &lt;class 'str'&gt;
                """);

        sid = addSection("Functions, Variable Scope and the Global Keyword", sb);
        addParagraphStart(sb, 
                """
                When passed as parameters into functions, variables are shared
                this is technically known as '
                """);
        sb.append(index.getReference("Call By Sharing", sid));
        sb.append(
                """
                '. If a variable is a primitive object then effectively a new
                variable is created within the function which is distinct from
                the variable outwith the function but that has the same value
                which is technically known as '
                """);
        sb.append(index.getReference("Call By Value", sid));
        addParagraphEnd(sb, "'.");
        addParagraphStart(sb, "The ");
        sb.append(index.getReference("Scope", "scope", sid));
        sb.append(
                """
                of a variable is from where in the code it can be accessed. The
                """);
        sb.append(index.getReference("Python keyword", "keyword", sid));
        addParagraphEnd(sb, " 'global' can modify the scope.");
        addParagraph(sb, "Consider the following:");
        addPythonCodeBlock(sb,
                """
                x = 1
                if x == 1:
                    y = 2
                print(y) # Prints 2
                """);
        addParagraphStart(sb, "The code in the ");
        sb.append(index.getReference("Python if", "if statement", sid));
        addParagraphEnd(sb, 
                """
                is executed as the condition 'x == 1' evaluates as 'True'. If
                the condition were to evaluate as 'False', then the interpreter
                would skip to the end of the if statement, as happens running
                the following code:
                """);
        addPythonCodeBlock(sb,
                """
                x = 1
                if x == 0:
                    y = 2
                print(y)
                """);
        addParagraph(sb, "Which results in:");
        addPre(sb, "NameError: name 'y' is not defined");
        addParagraph(sb, 
                """
                This is because 'y' does not get initialised and so cannot be
                passed into the print function.
                """);
        addParagraph(sb, "Consider the following code:");
        addPythonCodeBlock(sb,
                """
                x = 1
                def my_function():
                    x = 2
                    print("b", x)
                print("a", x)
                my_function()
                print("c", x)
                """);
        addParagraph(sb, "That outputs:");
        addPre(sb, 
                """
                a 1
                b 2
                c 1
                """);
        addParagraph(sb, 
                """
                At line 2, the interpreter reads a function definition for a
                function called my_function(), then skips to the end of the
                function and executes line 5. Then at line 6 my_function() is
                called. The interpreter then effectively goes back to line 2 and
                runs the function commands (lines 2 to 4). Then, at the end of
                the function, the interpreter returns to line 6 and moves
                directly on to line 7.
                """);
        addParagraph(sb, 
                """
                In this example, the variable inside the function called x is a
                different variable to the variable called x that is referred to
                outside of the function (even though the names are the same).
                Using the keyword 'global', we can make these variables the same
                as follows:
                """);
        addPythonCodeBlock(sb, 
                """
                x = 1
                def my_function():
                    global x
                    x = 2
                    print("b", x)
                print("a", x)
                my_function()
                print("c", x)
                """);
        addParagraph(sb, "The output should be:");
        addPre(sb,
                """
                a 1
                b 2
                c 2
                """);

        sid = addSection("Deleting variables", sb);
        addParagraphStart(sb, 
                """
                Variables can be deleted using the keyword 'del' followed by
                the name of the variable or a
                """);
        sb.append(index.getReference("Python tuple", "tuple", sid));
        addParagraphEnd(sb, " of variables to delete.");
        addParagraph(sb,
                """
                Deleting variables can free up memory for other things. The
                following code snippets shows how to initialise and delete
                variables:
                """);
        addPythonCodeBlock(sb,
                """
                a = 1
                del a # <-- deletes a
                #print(a) # <-- Would result in: NameError: name 'a' is not defined.
                b = 2
                c = 3
                del(b, c) # <-- Deletes b and site.
                """);
        return sb.toString();
    }
}
