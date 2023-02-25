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
 * For Python Intro Course Branching and Loops Page.
 *
 * @author Andy Turner
 */
public class Branching extends Page {
    
    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Branching(PythonIntroCourse c) {
        super("branching", "Branching", "Branching", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2 id="1">1. Introduction</h2>
              
              <p>Branching is to do with the flow of a program. At a branching, 
              the program either goes one way or another. In this section we 
              will look at a couple of main ways of branching.</p>
              
              <h2 id="2">2. If, Else and Elif</h2>                            
              
              <p>The If Statement provides a means to branch based upon a 
              condition which evaluates to either True or False as in the 
              following example.</p>
              <pre><code class="language-python"># A simple If Statement
              day_of_week = 5
              day = "Weekday"
              if day_of_week >= 6:
                  day = "Weekend"</code></pre>
              <p>An Else clause branches into two distinct paths which become 
              one again at the end of the compound statement as in the 
              following example.</p>
              <pre><code class="language-python"># An If-else Statement 
              if day_of_week < 6:
                  day = "Weekday"
              else:
                  day = "Weekend"</code></pre>
              <p>One or many Elif clauses can also be inserted between an If and 
              Else clause. Elif is a short for 'else if'. Consider the following 
              example:</p>
              <pre><code class="language-python"># An If-elif-else Statement
              if day_of_week == 1:
                  day = "Monday"
              elif day_of_week == 2:
                  day = "Tuesday"
              elif day_of_week == 3:
                  day = "Wednesday"
              elif day_of_week == 4:
                  day = "Thursday"
              elif day_of_week == 5:
                  day = "Friday"
              else:
                  day = "Weekend"</code></pre>
              <p>It can be argued that it is better to store a dictionary to 
              look up the day from the day_of_week, but a simple mlook up does 
              not branch, and more code can be inserted in any of the clauses, 
              so this can be more than a sort of look up.</p>
              
              <h2 id="3">3. Match-case</h2>
              
              <p>Since Python 3.10 there is also a Match-case statement which 
              can simplify long If-elif compound statements. The following 
              example shows the equivalent of the If-elif-else example from the 
              end of previous section:</p>
              <pre><code class="language-python">
              day_of_week = 5
              match day_of_week:
                  case 1:
                      day = "Monday"
                  case 2:
                      day = "Tuesday"
                  case 3:
                      day = "Wednesday"
                  case 4:
                      day = "Thursday"
                  case 5:
                      day = "Friday"
                  case _:
                      day = "Weekend"
              </code></pre>
              <p>The final case is a catch all case using the anonymous variable 
              which matches anything.</p>
              <p>The Math-case statement offers more than a syntactic variation 
              of Else-elif-else compound statements, as containers and other 
              objects can be matched against. Examples of these can be found in 
              the relevant PEPS:</p>
              <ul>
              <li><a href="https://peps.python.org/pep-0634/">PEP 634, Structural Pattern Matching: Specification</a></li>
              <li><a href="https://peps.python.org/pep-0635/">PEP 635, Structural Pattern Matching: Motivation and Rationale</a></li>
              <li><a href="https://peps.python.org/pep-0636/">PEP 636, Structural Pattern Matching: Tutorial</a></li>
              </ul>
              """);
        w.add("</div>");
    }
}
