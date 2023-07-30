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
import io.github.agdturner.course.Course;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.course.CoursePage;
import io.github.agdturner.course.Index;

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
    public void write() {
        Course course = getCourse();
        Index index = course.getIndex();
        writeHeader();
        writeH1();
        SectionID sid = addSection("1", "Introduction", 2);
        w.add("""
              <p>A Python exception is 'raised' when the Python interpreter 
              encounters an error. There are numerous types of exception, all 
              are types of 
              <a href="https://docs.python.org/3/library/exceptions.html#BaseException">
              BaseException</a>.</p>
              <p>The raised exception is an object which contains details of 
              the error and what code was being executed when the error was 
              encountered.</p>
              """);

        sid = addSection("2", "Try-Except", 2);
        w.add("<p>If it is suspected that code might generate an exception, or"
                + " if code raises an exception and analysis of this is to be"
                + " done, then a "
                + index.getReference("Python try", "try", sid)
                + " compound statement can be used with an 'except' clause."
                + " This tries to run the code in the try section and if"
                + " specific exceptions are raised, then the code in the except"
                + " clause is run.</p>");
        w.add("""
              <p>Consider the following example:</p>
              <pre><code class="language-python"># Catch an exception
              import random
              try:
                  a = 1/random.random()
                  # Random generates number in
                  # range [0,1) so
                  # ZeroDivisionError possible
              except:
                  a = 0
              print("Done")</code></pre>
              <p>To reiterate, this will run the 'try' clause of the compound 
              statement, and if an exception is raised in running that, then 
              (and only then) will the 'except' clause run.</p>
              <p>The 'except' clause in the example above catches any exception 
              type. It is possible to be more specific and catch particular 
              types of exception, for example, the following example will only 
              run the except clause if the exception thrown is a 
              'ZeroDivisionError' type exception:</p>
              <pre><code class="language-python"># Catch a specific exception:
              import random
              try:
                  a = 1/random.random()
                  # Random generates number in
                  # range 0,1 so
                  # ZeroDivisionError possible
              except ZeroDivisionError:
                  a = 0
              print("Done")</code></pre>
              <p>There is a
              <a href="https://docs.python.org/3/library/exceptions.html#exception-hierarchy">
              heirarchy of exception types</a>.</p>
              <p>If an exception is encountered and is not of the type handled 
              by an except clause, it is raised to where the code that raised 
              the exception was called from. This raising continues until there 
              is exception handling or until the exception reaches the top level 
              when the program exits and a stacktrace error message (which lists 
              exception raising details) is printed.</p>
              <p>More than one type of exception can be handled simultaneously 
              in a couple of ways:</p>
              <ol>
              <li>The except clause can contain a tuple of types, for example:
              <pre><code class="language-python">import random
              try:
                  a = 1/random.random()
              except (ZeroDivisionError, SystemError):
                  a = 0
              print("Done")</code></pre></li>
              <li>Using multiple except clauses, for example:
              <pre><code class="language-python">import random
              try:
                  a = 1/random.random()
              except ZeroDivisionError:
                  a = 0
              except SystemError:
                  print("Warning: SystemError")
                  a = 0
              print("Done")</code></pre></li>
              </ol>
              """);

        sid = addSection("3", "Raising Exceptions", 2);
        w.add("<p>Exceptions are raised automatically if they are encountered "
                + "and not handled in an 'except' clause.</p>");
        w.add("<p>The keyword 'raise' can be used to raise an exception by "
                + "simply giving the exception type. The following raises a "
                + index.getReference("SystemError")
                + ".</p>");
        w.add("""
              <pre><code class="language-python">raise SystemError</code></pre>
              <p>New types of exception can be defined by subclassing an 
              exception from the builtins module.</p>
              """);

        sid = addSection("4", "Else and Finally", 2);
        w.add("<p>To run something only if exceptions are not raised, add an "
                + "'else' clause, for example:</p>");
        w.add("""
              <pre><code class="language-python">import random
              try:
                  a = 1/random.random()
              except:
                  a = 0
              else:
                  print(a)
                  # Exceptions here are raised.
              print("Done")</code></pre>
              <p>To run code whether an exception is raised or not, then add a 
              'finally' clause, for example:</p>
              <pre><code class="language-python">import random
              try:
                  a = 1/random.random()
              except:
                  a = 0
              finally:
                  if a == None:
                      a = -1
              print("Done")</code></pre>
              <!--
              <p>In executing the finally clause, any exceptions encountered are 
              raised after the finally has run.</p> Finally clauses 
              are always executed, even if there is a Return Statement (return) 
              in the try or except clauses.<p>
              <p>Exceptions raised in executing the finally clause are nested 
              within the prior saved exception.</p>
              <p>Break and return statements within a finally clause will delete
              the saved exception.</p>
              <p>If the Try-Except compound statement is in a loop, then the 
              Continue Keyword (continue) can be used to execute the finally 
              clause before restarting the loop, and the Break Keyword (break)
              can be used to execute the finally clause.</p>
              -->
              """);

        sid = addSection("5", "System Exit", 2);
        w.add("<p>To exit a program at any point, call the '"
                + "<a href=\"https://docs.python.org/3/library/sys.html#sys.exit\">"
                + "exit function</a>'"
                + " from the "
                + index.getReference("Python sys", "sys module", sid)
                + ". For example:</p>");
        w.add("""
              <pre><code class="language-python">import sys
              sys.exit()</code></pre>
              <p>This has an arg option:</p>
              <pre><code class="language-python">sys.exit(arg)</code></pre>
              <p>Where arg is a number that the system will report. Zero is 
              usually regarded as exiting with no issues.</p>
              <p>For details on error codes, see:
              <a href="https://docs.python.org/3/library/errno.html">errno</a>
              - a special module on system error codes.</p>
              """);
        w.add("</div>");
    }
}
