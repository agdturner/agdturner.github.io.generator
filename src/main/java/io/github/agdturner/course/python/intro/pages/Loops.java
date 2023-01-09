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
        w.add("""
              <h2>1. Introduction</h2>
              <p>Python has syntax for While Loops and For Loops. While Loops 
              are typically used to repeat something until a condition is 
              reached. For Loops are typically used to repeat something for 
              each thing in a sequence. Let's look at these in turn:</p>
              
              <h2>2. While Loops</h2>
              <p>The following is an example of a While Loop:</p>
              <pre><code class="language-python">x = 1
              while (x < 10):
                  print (x)
                  x += 1</code></pre>
              <p>Care is needed with While Loops as if the condition is never 
              reached to break out of the while loop, the program may get stuck 
              in the loop.</p>
              <p>A Break Statement (break) allows us to break out of a loop 
              which is commonly done when some condition is reached. For 
              example, consider the following code:</p>
              <pre><code class="language-python"># Print the largest number less than 1 million that is divisible by 17
              x = 1000000
              while (x != 0):
                  if (x % 17 == 0):
                      break
                  x -= 1
              print(x)</code></pre>
              <p>The output of which is:</p>
              <pre>999991</pre>
              <p>The Continue Statement (continue) gets the program to return to 
              the start of a loop when some condition is reached. For example, 
              consider the following code:</p>
              <pre><code class="language-python"># Print odd numbers from 1 to 10
              x = 0
              while x < 10:
                  x += 1
                  if (x % 2) == 0:
                      continue
                  print(x, end =" ")</code></pre>
              <p>The output of which is:</p>
              <pre>1 3 5 7 9</pre>
              <p>Although not commonly used, While Statements can be used with 
              an else clause which is executed if the while loop condition 
              evaluates to False.</p>
              <p>Note that in the above code snippet a key word argument (kwarg)
              called end has been used to substitute the normal end of print 
              statement - a newline - with a space.</p>
              
              <h2>3. For Loops</h2>
              <p>For Loops in Python are used with sequences that are iterable. 
              What this means is that the for loop is passed the next in the 
              sequence until it has reached the last after which the loop 
              completes. In other languages this is typically called a For Each 
              Loop. Many other languages allow iteration using a index, but 
              currently Python does not. In the following example, the first 
              time around the loop the variable x is asigned the value 0, the 
              second time around the loop it is assigned the value 1 and so on:
              </p>
              <pre><code class="language-python">for x in (0,1,2,3,4,5,6,7,8,9):
                  print(x)</code></pre>
              <p>For sequences of numbers, it is much more common to use a
              range, for example, the following does the same:</p>
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
              <p>This can be particularly helpful when dealing with implicit 
              geographical locations in developing our basic Agent Based Model.
              </p>
              <p>Note though, you cannot change i during this to skip objects. 
              Assignment creates a new temporary variable, and the target 
              variable resets to its next value at the top of the loop - it is 
              coming from the iterator. Run the following code:</p>
              <pre><code class="language-python">names = ("Dale", "Albert", "Gordon", "Tamara", "Philip", "Chester", "Windom")
              for i in range(len(names)):
                  print(i, names[i])
                  i += 1
                  print(i)</code></pre>
              <p>Slices copy containers, while ranges are iterators that 
              actually generate the values one at a time. So, it is more 
              efficient to do:<p>
              names = ("Dale", "Albert", "Gordon", "Tamara", "Philip", "Chester", "Windom")
              <pre><code class="language-python">for i in range(2,len(names),2):
                  print(names[i])</code></pre>
              <p>Instead of:</p>
              <pre><code class="language-python">for name in names[2::2]:
                  print(name)</code></pre>
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
              <p>This is somewhat memory inefficient as it involves creating a 
              complete copy of names.</p>
              <p>Although not commonly used, an else clause can be added to a 
              For Loop and is executed once if the loop completes and not at all 
              if there is a Break Statement is used to terminate the loop early.
              As well as Break Statements, Continue Statements can also be used
              to skip back to the start of a For Loop in much the same way as in
              a While Loop.</p>
              
              <h2>4. Nesting loops</h2>
              <p>In spatial analysis it is common to want to go through two 
              dimensional raster data or tables of values. One way to do this is 
              to nest loops. Consider the following code which goes through all 
              the rows in a data and for each row, goes through the values in 
              each column:</p>
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
              <p>It is often necessary to know indexes, and when this is the 
              case, another way to do this is as follows:</p>
              <pre><code class="language-python">data = [
              [0,1,2],
              [3,4,5]
              ]
              for row in range(len(data)):
                  for col in range(len(data[row])):
                      print(data[row][col], end=" ")
                  print()</code></pre>
              <p>Recall that the function len() when given a sequence returns 
              the length of the sequence, and the function range() turns an 
              Integer into a sequence starting from 0 and ending with one less.
              </p>
              <p>When processing raster data like this, it is reasonably common
              to make mistakes and mix up rows and columns which can be hard to 
              spot if the data has the same number of rows and columns.</p>
              
              <h2>5. Moving Window Algorithms</h2>
              <p>These are commonly used in image processing and for surface 
              analysis. One of the difficulties in applying these concerns what 
              to do at the boundaries. The main options are: to deal with the 
              special edge and corner cases; to process only those parts for 
              which there are data for all parts of the window. Using the latter 
              of these solutions we could calculate the maximum value in a 3x3
              neighbourhood as follows:</p>
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
              
              <h2>6. Next</h2>
              <p>Let us apply what we have learned about Containers, Branching 
              and Looping to simplify and extend our Agent Based Modelling 
              code.</p> 
              """);
        w.add("</div>");
    }
}
