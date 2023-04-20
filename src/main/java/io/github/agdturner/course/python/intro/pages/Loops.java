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

import io.github.agdturner.core.Section;
import io.github.agdturner.course.python.intro.PythonIntroCourse;
import io.github.agdturner.course.Page;

/**
 * For Python Intro Course Branching and Loops Page.
 *
 * @author Andy Turner
 */
public class Loops extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Loops(PythonIntroCourse c) {
        super("loops", "Loops", "Loops", c);
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        Section s;
        s = addSection("1", "Introduction", 2);
        w.add(s.sectionHTML);
        w.add("<p>Python has syntax for '"
                + c.index.getReference("While Loop", "while loops", s.sid)
                + "' and '"
                + c.index.getReference("For Loop", "for loops", s.sid)
                + "'. While loops are typically used to repeat something until "
                + " a condition is reached. For loops are typically used to "
                + " repeat something a set number of times (or for each thing"
                + " in a sequence). Let's explore while loops first...</p>");

        s = addSection("2", "While", 2);
        w.add(s.sectionHTML);
        w.add("<p>The following provides an example of a "
                + c.index.getReference("Python while", "while", s.sid)
                + " statement:</p>");
        w.add("""
              <pre><code class="language-python">x = 1
              while (x < 10):
                  print(x)
                  x += 1</code></pre>
              <p>If a while loops condition never evaluates as 'False' then the 
              loop will continue indefinitely. This is sometimes a reason why a 
              program fails to terminate when you were expecting it to.</p>
              """);
        w.add("<p>A "
                + c.index.getReference("Python break", "break", s.sid)
                + " statement breaks out of a loop which is commonly done when"
                + " some other condition is reached. For example, consider the"
                + " following code:</p>");
        w.add("""
              <pre><code class="language-python"># Print the largest number less than 1 million that is divisible by 17
              x = 1000000
              while (x != 0):
                  if (x % 17 == 0):
                      break
                  x -= 1
              print(x)</code></pre>
              <p>The output of which is:</p>
              <pre>999991</pre>
              """);
        w.add("<p>The "
                + c.index.getReference("Python continue", "continue", s.sid)
                + " statement gets the program to return to the start of a loop"
                + " when a condition is reached:</p>");
        w.add("""
              <pre><code class="language-python"># Print odd numbers from 1 to 10
              x = 0
              while x < 10:
                  x += 1
                  if (x % 2) == 0:
                      continue
                  print(x, end =" ")</code></pre>
              <p>The output of which is:</p>
              <pre>1 3 5 7 9</pre>
              <p>An 'else' clause can be used with a while loop and this code 
              within it is executed when the while condition evaluates as 
              'False'.</p>
              <p>Note that in the above code snippet a 'keyword argument 
              (kwarg)' called 'end' is used in the print command to substitute 
              the normal end of print statement - a newline - with a space.</p>
              """);

        s = addSection("3", "For", 2);
        w.add(s.sectionHTML);
        w.add("<p>"
                + c.index.getReference("For Loop", "For loops", s.sid)
                + " in Python ("
                + c.index.getReference("Python for", "for loop", s.sid)
                + ") are used with sequences that are 'iterable'."
                + " Iterable means can be gone through one at a time. In the"
                + " following example, the first time around the loop, the"
                + " variable 'x' is assigned the value '0', the second time"
                + " around the loop x is assigned the value '1' and so on:"
                + "</p>");
        w.add("""
              <pre><code class="language-python">for x in (0,1,2,3,4,5,6,7,8,9):
                  print(x)</code></pre>
              """);
        w.add("<p>For sequences of numbers, it is much more common to use a "
                + c.index.getReference("Python range", "range", s.sid)
                + " , for example, the following does the same as the previous"
                + " example:</p>");
        w.add("""
              <pre><code class="language-python">for x in range(10):
                  print(x)</code></pre>
              <p>It is also common to use a slice, for example:</p>
              <pre><code class="language-python">names = ("Dale", "Albert", "Gordon", "Tamara", "Philip", "Chester", "Windom")
              for name in names[1:5:2]:
                  print(name) # <-- Prints "Albert", "Tamara"</code></pre>
              <p>Sometimes it is helpful to know the index in the sequence when 
              iterating, so alternatively we can do the following:</p>
              <pre><code class="language-python">names = ("Dale", "Albert", "Gordon", "Tamara", "Philip", "Chester", "Windom")
              for i in range(len(names)):
                  print(i, names[i])</code></pre>
              <p>Note, that 'i' cannot be changes within the loop to skip 
              objects. As assignment for 'i' would creates a new variable. 
              So the following code:</p>
              <pre><code class="language-python">names = ("Dale", "Albert", "Gordon", "Tamara", "Philip", "Chester", "Windom")
              for i in range(len(names)):
                  print(i, names[i])
                  i += 2
                  print(i)</code></pre>
              <p>Produces:</p>
              <pre>0 Dale
              2
              1 Albert
              3
              2 Gordon
              4
              3 Tamara
              5
              4 Philip
              6
              5 Chester
              7
              6 Windom
              8</pre>
              <p>Slices copy containers, while ranges are iterators that 
              actually generate the values one at a time. So, it is more 
              efficient to do the following:<p>
              <pre><code class="language-python">names = ("Dale", "Albert", "Gordon", "Tamara", "Philip", "Chester", "Windom")
              for i in range(2,len(names),2):
                  print(names[i])</code></pre>
              <p>Instead of:</p>
              <pre><code class="language-python">for name in names[2::2]:
                  print(name)</code></pre>
              """);
        w.add("""
              <p>A disadvantage of not having an index counter and using a 
              sequence is that it makes it harder to remove items from the 
              sequence which is often useful. For example, the following code 
              does not empty the list names because as we remove the first thing 
              in the list, everything else moves to a new position and the 
              iterator skips over a value each time:</p>
              <pre><code class="language-python">names = ["Dale","Albert","Gordon","Tamara","Philip", "Chester","Windom"]
              for name in names:
                  names.remove(name)
              print(names)</code></pre>
              <p>A solution to this is to create a slice containing everything
              and then remove from the original list:</p>
              <pre><code class="language-python">names = ["Dale","Albert","Gordon","Tamara","Philip", "Chester","Windom"]
              for name in names[:]:
                  names.remove(name)
              print(names)</code></pre>
              <p>It would though probably be better to simply reinitialise 
              'names' as an empty list.</p>
              """);
        w.add("<p>As with a while loop, an 'else' clause can be added to for"
                + " loop and is executed once the loop completes, or not at"
                + " all if there is a "
                + c.index.getReference("Python break", "break", s.sid)
                + " statement that terminates the loop before the last"
                + " iteration completes.<p>");
        w.add("Also, a "
                + c.index.getReference("Python continue", "continue",
                        s.sid)
                + " statement can be used to skip to the start of the next loop"
                + " iteration in the same way as in a while loop.</p>");

        s = addSection("4", "Nesting loops", 2);
        w.add(s.sectionHTML);
        w.add("<p>In spatial analysis it is common to want to go through two"
                + " dimensional (2D) raster data or tables of values. One way"
                + " to do this is to nest for loops. Consider the following"
                + " code which goes through all the rows in 'data' and for each"
                + " 'row', goes through the values (one for each 'column'):"
                + "</p>");
        w.add("""
              <pre><code class="language-python">data = [
              [0,1,2],
              [3,4,5]
              ]
              for row in data:
                  for value in row:
                      print(value, end=" ")
                  print()</code></pre>
              <p>The output of this program is:</p>
              <pre>0 1 2 
              3 4 5</pre>
              <p>It is often necessary to know and use the row and column 
              indexes. Another way to do this is as follows:</p>
              <pre><code class="language-python">data = [
              [0,1,2],
              [3,4,5]
              ]
              for row in range(len(data)):
                  for col in range(len(data[row])):
                      print(data[row][col], end=" ")
                  print()</code></pre>
              """);
        w.add("<p>Recall that the "
                + c.index.getReference("Python len", "len", s.sid)
                + " function, when passed a sequence as a parameter, returns"
                + " the length of the sequence, and the "
                + c.index.getReference("Python range", "range", s.sid)
                + " function turns an Integer argument into a sequence starting"
                + " from '0' and ending with one less than that argument"
                + " stepping by 1.</p>");
        w.add("""
              <p>When processing raster data like this, care is needed not to
              get rows and columns mixed up. This is easier to do if the data 
              have the same number of rows and columns!</p>
              
              <h2 id="5">5. Moving Window Algorithms</h2>
              <p>These are commonly used in image processing and for surface 
              analysis. One of the difficulties in applying these concerns what 
              to do at the boundaries. The main options are: to deal with the 
              special edge and corner cases; to process only those parts for 
              which there are data for all parts of the 'window'. Using the 
              latter of these solutions we could calculate the maximum value in 
              a 3x3 neighbourhood as follows:</p>
              <pre><code class="language-python">data = [
              [0,1,2,3,4,5],
              [6,7,8,9,10,11],
              [12,13,14,15,16,17],
              [18,19,20,21,22,23],
              [24,25,26,27,28,29],
              [30,31,32,33,34,35]
              ]
              result = []
              for row in range(1, len(data) - 1):
                  row_result = []
                  for col in range(1, len(data[row]) - 1):
                      value = data[row][col]
                      for i in range(-1, 2):
                          for j in range(-1, 2):
                              value = max(value, data[row + i][col + j])
                      row_result.append(value)
                      print(value, end=" ")
                  result.append(row_result)
                  print()
              #print(result)</code></pre>
              <p>The output of which is:</p>
              <pre>14 15 16 17 
              20 21 22 23 
              26 27 28 29 
              32 33 34 35</pre>
              
              <h2 id="6">6. Next</h2>
              <p>Use containers, branches and loops to simplify and extend the 
              Agent Based Model code.</p> 
              """);
        w.add("</div>");
    }
}
