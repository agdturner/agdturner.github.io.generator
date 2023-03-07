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
public class Exceptions extends Page {
    
    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Exceptions(PythonIntroCourse c) {
        super("exceptions", "Exceptions", "Exceptions", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2 id="1">1. Introduction</h2>
              <p>In python, an exception is a warning or an error that is raised
              when the python interpreter encounters a problem or issue. There 
              are numerous types of exception, all are derived from 
              <a href="https://docs.python.org/3/library/exceptions.html#BaseException">
              BaseException</a>.</p>
              <p>The raised exception is an object which contains details of 
              what the problem is.</p>
              
              <h2 id="2">2. Try-Except</h2>
              <p>If it is suspected that code might generate an exception, or if 
              code generates an exception and analysis of this is to be done, 
              then a try-except compound statement can be used. This tries to 
              run the code that might or does generate the exception and catches 
              the exceptions if it occurs allowing further code to then be 
              executed.</p>
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
              <p>This will run the try clause of the compound statement, and if 
              an exception is raised in running that, then and only then will it 
              run the except clause.</p>
              <p>The except clause in the example above catches any exception 
              type. It is possible to be more specific and catch particular 
              types of exception, for example, the following example will only 
              run the except clause if the exception thrown is a 
              ZeroDivisionError type exception:</p>
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
              
              <h2 id="3">3. Raising Exceptions</h2>
              <p>Exceptions are raised automatically if they are encountered and 
              not handled in an except clause.</p>
              <p>The keyword 'raise' can be used to raise an exception by simply 
              giving the exception type. The following raises a SystemError</p>
              <pre><code class="language-python">raise SystemError</code></pre>
              <p>New types of exception can be defined by subclassing an 
              exception from the builtin module.</p>
              
              <h2 id="4">4. Else and Finally</h2>
              <p>To run something only if exceptions are not raised, add an Else 
              Clause 'else' to the try-except compound statement, for example:
              </p>
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
              Finally Clause 'finally' try-except compound statement, for 
              example:</p>
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

              <h2 id="5">5. System Exit Calls</h2>
              <p>To exit the system at any point, call the function exit() 
              from the sys module. For example:</p>
              <pre><code class="language-python">import sys
              sys.exit()</code></pre>
              <p>This has an arg option:</p>
              <pre><code class="language-python">sys.exit(arg)</code></pre>
              <p>Where arg is a number that the system will report. Zero is 
              usually regarded as exiting with no issues.</p>
              <p>For more on this, see: 
              <a href="https://docs.python.org/3/library/sys.html#sys.exit">
              sys.exit</a>.
              See also:
              <a href="https://docs.python.org/3/library/errno.html">errno</a> -
              a special module on system error codes.</p>
              """);
//              <pre></pre>
//              <pre><code class="language-python"></code></pre>
//              <p></p>
//              <pre></pre>
//              
        w.add("</div>");
    }
}
