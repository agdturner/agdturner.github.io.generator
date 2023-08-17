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
import io.github.agdturner.core.Strings;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.course.CoursePage;

/**
 * For Python Intro Course Variables Page.
 *
 * @author Andy Turner
 */
public class Exceptions extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public Exceptions(PythonIntroCodingCourse course) {
        super(course, "exceptions", "Exceptions", "Exceptions");
    }
    
    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        addParagraphStart(sb,
                """
                A Python exception is 'raised' when the Python interpreter
                encounters an error. There are numerous types of exception, all
                are types of
                """);
        sb.append(index.getReference("Python BaseException", "BaseException", sid));
        addParagraphEnd(sb, ".");
        addParagraphStart(sb,
                """
                The raised exception is an object which contains details of the
                 error and what code was being executed when the error was
                 encountered.
                """);

        sid = addSection("Try-Except", sb);
        addParagraphStart(sb,
                """
                If it is suspected that code might generate an exception, or if
                code raises an exception and analysis of this is to be done,
                then a
                """);
        sb.append(index.getReference("Python try", "try", sid));
        addParagraphEnd(sb,
                """
                compound statement can be used with an 'except' clause. This
                tries to run the code in the 'try' section and if specific
                exceptions are raised, then the code in the except clause is
                run.
                """);
        addParagraph(sb, "Consider the following example:");
        addPythonCodeBlock(sb,
                """
                # Catch an exception
                import random
                try:
                    a = 1/random.random()
                    # Random generates number in
                    # range [0,1) so
                    # ZeroDivisionError possible
                except:
                    a = 0
                print("Done")
                """);
        addParagraph(sb,
                """
                To reiterate, this will run the 'try' clause of the compound
                statement, and if an exception is raised in running that, then
                (and only then) will the 'except' clause run.
                """);
        addParagraphStart(sb,
                """
                The 'except' clause in the example above catches any exception
                type. It is possible to be more specific and catch particular
                types of exception, for example, the following example will only
                run the except clause if the exception thrown is a
                """);
        sb.append(index.getReference("Python ZeroDivisionError", 
                        "ZeroDivisionError", sid));
        addParagraphEnd(sb, ".");
        addPythonCodeBlock(sb,
                """
                # Catch a specific exception:
                import random
                try:
                    a = 1/random.random()
                    # Random generates number in
                    # range 0,1 so
                    # ZeroDivisionError possible
                except ZeroDivisionError:
                    a = 0
                print("Done")
                """);
        addParagraph(sb,
                """
                There is a
                <a href="https://docs.python.org/3/library/exceptions.html#exception-hierarchy">
                heirarchy of exception types</a>.
                """);
        addParagraph(sb,
                """
                If an exception is encountered and is not of the type handled
                by an except clause, it is raised to where the code that raised
                the exception was called from. This raising continues until
                there is exception handling or until the exception reaches the
                top level when the program exits and a stacktrace error message
                (which lists exception raising details) is printed.
                """);
        addParagraph(sb,
                """
                More than one type of exception can be handled simultaneously in
                a couple of ways:
                """);
        sb.append(Strings.OL_START);
        addLIStart(sb, 
                "The except clause can contain a tuple of types, for example:");
        addPythonCodeBlock(sb, 
                """
                import random
                try:
                    a = 1/random.random()
                except (ZeroDivisionError, SystemError):
                    a = 0
                print("Done")
                """);
        addLIEnd(sb, "");
        addLIStart(sb, "Using multiple except clauses, for example:");
        addPythonCodeBlock(sb, 
                """
                import random
                try:
                    a = 1/random.random()
                except ZeroDivisionError:
                    a = 0
                except SystemError:
                    print("Warning: SystemError")
                    a = 0
                print("Done")
                """);
        addLIEnd(sb, "");
        sb.append(Strings.OL_END);

        sid = addSection("Raising Exceptions", sb);
        addParagraph(sb, 
                """
                Exceptions are raised automatically if they are encountered and
                not handled in an 'except' clause.
                """);
        addParagraphStart(sb, 
                """
                The keyword 'raise' can be used to raise an exception by simply
                giving the exception type. The following raises a
                """);
        sb.append(index.getReference("SystemError", sid));
        addParagraphEnd(sb, ".");
        addPythonCodeBlock(sb, "raise SystemError");
        addParagraph(sb,
                """
                New types of exception can be defined by subclassing an
                exception from the builtins module.
                """);

        sid = addSection("Else and Finally", sb);
        addParagraph(sb,
                """
                To run something only if exceptions are not raised, add an
                'else' clause, for example:
                """);
        addPythonCodeBlock(sb,
                """
                import random
                try:
                    a = 1/random.random()
                except:
                    a = 0
                else:
                    print(a)
                    # Exceptions here are raised.
                print("Done")
                """);
        addParagraph(sb,
                """
                To run code whether an exception is raised or not, then add a
                'finally' clause, for example:
                """);
        addPythonCodeBlock(sb,
                """
                import random
                try:
                    a = 1/random.random()
                except:
                    a = 0
                finally:
                    if a == None:
                        a = -1
                print("Done")
                """);
        sb.append("<!--");
        addParagraph(sb,
                """
                In executing the finally clause, any exceptions encountered are
                raised after the finally has run.
                """);
        addParagraph(sb,
                """
                Finally clauses are always executed, even if there is a Return
                Statement (return) in the try or except clauses.
                """);
        addParagraph(sb,
                """
                Exceptions raised in executing the finally clause are nested
                within the prior saved exception.
                """);
        addParagraph(sb,
                """
                Break and return statements within a finally clause will delete
                the saved exception.
                """);
        addParagraph(sb,
                """
                If the Try-Except compound statement is in a loop, then the
                Continue Keyword (continue) can be used to execute the finally
                clause before restarting the loop, and the Break Keyword (break)
                can be used to execute the finally clause.
                """);
        sb.append("-->");

        sid = addSection("System Exit", sb);
        addParagraphStart(sb,
                """
                To exit a program at any point, call the
                '<a href="https://docs.python.org/3/library/sys.html#sys.exit">
                exit function</a>'
                from the
                """);
        sb.append(index.getReference("Python sys", "sys module", sid));
        addParagraphEnd(sb, ". For example:");
        addPythonCodeBlock(sb,
                """
                import sys
                sys.exit()
                """);
        addParagraph(sb, "This has an arg option:");                      
        addPythonCodeBlock(sb, "sys.exit(arg)");
        addParagraph(sb, 
                """
                Where arg is a number that the system will report. Zero is
                usually regarded as exiting with no issues.
                """);
        addParagraph(sb,
                """
                For details on error codes, see:
                <a href="https://docs.python.org/3/library/errno.html">errno</a>
                - a special module on system error codes.
                """);
        return sb.toString();
    }
}
