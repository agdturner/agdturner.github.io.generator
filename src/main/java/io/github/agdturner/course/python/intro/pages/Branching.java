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
              <h2>1. Introduction</h2>
              <p>
              Python supports looping (when some part of the code is executed 
              repeatedly a number of times, or until some condition is reached) 
              and branching (when some code is executed only if some condition 
              is matched). The way looping, branching, calling functions and 
              threading (where multiple threads of execution are running 
              simultaneously) are all part of what is termed control flow. These 
              things help make code much more concise. Threading allows for more 
              interactivity with users and often speeds up processing. This
              section of the course focuses on loops and branching.</p>
              
              <h2>2. Loops</h3>
              
              
              <h3>Branching</h3>
              <p>A simple control flow is to branch based upon a condition which
              evaluates to either True or False. So, if the condition is True, 
              then the program follows one path, otherwise it follows another 
              path. Branching can be done with various types of If Statement and 
              since Python 3.10 there is also a Match-case Statement which 
              saves using long chains of If-elif constructs which have multiple 
              conditions. Consider the following code snippet:</p>
              <pre><code class="language-python">
              # A simple If Statement
              day_of_week = 5
              day = "Weekday"
              if day_of_week >= 6:
                  day = "Weekend"
              # An If-else Statement 
              if day_of_week < 6:
                  day = "Weekday"
              else:
                  day = "Weekend"
              # An If-elif Statement
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
                  day = "Weekend"
              </code></pre>
              <p>You could argue that this example would be better stored in a 
              dictionary. A Match-case Statement which offers another way to do 
              this:</p>
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
              <p>In this example the Match-case Statement is not much better
              than a If-elif Statement. The final case is a catch all case using 
              the anonymous variable which matches anything. The added extras of 
              the Match-case Statement are from passing in containers or other 
              objects and having more sophisticated case clauses. Examples of 
              these are a bit involved, so for the time being we will leave 
              this here after referencing the PEPS:</p>
              <ul>
              <li><a href="https://peps.python.org/pep-0634/">PEP 634, Structural Pattern Matching: Specification</a></li>
              <li><a href="https://peps.python.org/pep-0635/">PEP 635, Structural Pattern Matching: Motivation and Rationale</a></li>
              <li><a href="https://peps.python.org/pep-0636/">PEP 636, Structural Pattern Matching: Tutorial</a></li>
              </ul>
                            
              
              """);
        w.add("""
              
              <h3>Match-case Statement</h3>
              <p>Python 3.10 (2021) introduced the match-case statement which 
              provides an implementation of a "switch" for Python which has long
              been available in most other high level langauges.</p>
              """);
//        w.add("<p></p>");
//        w.add("<p>Enter: \"\"</p>");
        w.add("</div>");
    }
}
