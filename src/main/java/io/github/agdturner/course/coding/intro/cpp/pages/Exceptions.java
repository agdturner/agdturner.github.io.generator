/*
 * Copyright 2024 University of Leeds.
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
package io.github.agdturner.course.coding.intro.cpp.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.coding.intro.cpp.CPPIntroCodingCourse;
import io.github.agdturner.course.CoursePage;

/**
 * For CPP Intro Course Variables Page.
 *
 * @author Andy Turner
 */
public class Exceptions extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public Exceptions(CPPIntroCodingCourse course) {
        super(course, "exceptions", "Exceptions", "Exceptions");
    }
    
    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        w.addPST(sb,
                """
                A Python exception is 'raised' when the Python interpreter
                encounters an error. There are numerous types of exception, all
                are types of
                """);
        sb.append(index.getReference("Python BaseException", "BaseException", sid));
        w.addPET(sb, ".");
        w.addPST(sb,
                """
                The raised exception is an object which contains details of the
                 error and what code was being executed when the error was
                 encountered.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Try-Except", sb);
        w.addPST(sb,
                """
                If it is suspected that code might generate an exception, or if
                code raises an exception and analysis of this is to be done,
                then a
                """);
        sb.append(index.getReference("Python try", "try", sid));
        w.addPET(sb,
                """
                 compound statement can be used with an 'except' clause. This
                tries to run the code in the 'try' section and if specific
                exceptions are raised, then the code in the except clause is
                run.
                """);
        w.addP(sb, "Consider the following example:");
        addCodeBlock(sb,
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
        w.addP(sb,
                """
                To reiterate, this will run the 'try' clause of the compound
                statement, and if an exception is raised in running that, then
                (and only then) will the 'except' clause run.
                """);
        w.addPST(sb,
                """
                The 'except' clause in the example above catches any exception
                type. It is possible to be more specific and catch particular
                types of exception, for example, the following example will only
                run the except clause if the exception thrown is a
                """);
        sb.append(index.getReference("Python ZeroDivisionError", 
                        "ZeroDivisionError", sid));
        w.addPET(sb, ".");
        addCodeBlock(sb,
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
        w.addP(sb,
                """
                There is a
                <a href="https://docs.python.org/3/library/exceptions.html#exception-hierarchy">
                heirarchy of exception types</a>.
                """);
        w.addP(sb,
                """
                If an exception is encountered and is not of the type handled
                by an except clause, it is raised to where the code that raised
                the exception was called from. This raising continues until
                there is exception handling or until the exception reaches the
                top level when the program exits and a stacktrace error message
                (which lists exception raising details) is printed.
                """);
        w.addP(sb,
                """
                More than one type of exception can be handled simultaneously in
                a couple of ways:
                """);
        w.addOLST(sb);
        w.addLIST(sb, 
                "The except clause can contain a tuple of types, for example:");
        addCodeBlock(sb, 
                """
                import random
                try:
                    a = 1/random.random()
                except (ZeroDivisionError, SystemError):
                    a = 0
                print("Done")
                """);
        w.addLIET(sb, "");
        w.addLIST(sb, "Using multiple except clauses, for example:");
        addCodeBlock(sb, 
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
        w.addLIET(sb, "");
        w.addOLET(sb);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Raising Exceptions", sb);
        w.addP(sb, 
                """
                Exceptions are raised automatically if they are encountered and
                not handled in an 'except' clause.
                """);
        w.addPST(sb, 
                """
                The keyword 'raise' can be used to raise an exception by simply
                giving the exception type. The following raises a
                """);
        sb.append(index.getReference("SystemError", sid));
        w.addPET(sb, ".");
        addCodeBlock(sb, "raise SystemError");
        w.addP(sb,
                """
                New types of exception can be defined by subclassing an
                exception from the builtins module.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Else and Finally", sb);
        w.addP(sb,
                """
                To run something only if exceptions are not raised, add an
                'else' clause, for example:
                """);
        addCodeBlock(sb,
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
        w.addP(sb,
                """
                To run code whether an exception is raised or not, then add a
                'finally' clause, for example:
                """);
        addCodeBlock(sb,
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
        w.addP(sb,
                """
                In executing the finally clause, any exceptions encountered are
                raised after the finally has run.
                """);
        w.addP(sb,
                """
                Finally clauses are always executed, even if there is a Return
                Statement (return) in the try or except clauses.
                """);
        w.addP(sb,
                """
                Exceptions raised in executing the finally clause are nested
                within the prior saved exception.
                """);
        w.addP(sb,
                """
                Break and return statements within a finally clause will delete
                the saved exception.
                """);
        w.addP(sb,
                """
                If the Try-Except compound statement is in a loop, then the
                Continue Keyword (continue) can be used to execute the finally
                clause before restarting the loop, and the Break Keyword (break)
                can be used to execute the finally clause.
                """);
        sb.append("-->");
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("System Exit", sb);
        w.addPST(sb,
                """
                To exit a program at any point, call the
                '<a href="https://docs.python.org/3/library/sys.html#sys.exit">
                exit function</a>'
                from the
                """);
        sb.append(index.getReference("Python sys", "sys module", sid));
        w.addPET(sb, ". For example:");
        addCodeBlock(sb,
                """
                import sys
                sys.exit()
                """);
        w.addP(sb, "This has an arg option:");                      
        addCodeBlock(sb, "sys.exit(arg)");
        w.addP(sb, 
                """
                Where arg is a number that the system will report. Zero is
                usually regarded as exiting with no issues.
                """);
        w.addP(sb,
                """
                For details on error codes, see:
                <a href="https://docs.python.org/3/library/errno.html">errno</a>
                - a special module on system error codes.
                """);
        w.addDIVET(sb);
        return sb.toString();
    }
}
