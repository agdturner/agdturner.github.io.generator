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
 * For Python Intro Course Functions Page.
 *
 * @author Andy Turner
 */
public class Functions extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Functions(PythonIntroCourse c) {
        super("functions", "Functions", "Functions", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2>Control Flow</h2>
              <p>Control flow is about the order in which statements are
              run and. Let's recap by considering the following code:</p>
              <pre><code class=\"language-python\">
              from fractions import Fraction
              
              def add(x, y):
                  return x + y
              
              def multiply(x, y):
                  r = 0
                  for i in range(x):
                      r = add(r, y)
                  return r
              
              print(multiply(5, 7))
              </code></pre>
              <p></p>
              <h2>Documentation</h2>
              w.add("<pre><code class=\"language-python\">");
              from fractions import Fraction


        def divide(x, y):
    """
    A function to divide x by y.

    Parameters
    ----------
    x : Fraction
        A decimal number.
    y : Fraction
        DESCRIPTION.

    Returns
    -------
    Fraction
        x divided by y

    """
    return x / y

# Set x = 1/2.
x = Fraction(1, 2)
print(x)
# Set y = 1/3.
y = Fraction(1, 3)
print(y)
# Call the function and print the result.
print(divide(x, y))
        """)
//        w.add("<p></p>");
//        w.add("<p>Enter: \"\"</p>");
        w.add("</div>");
    }
}
