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
 * For Python Intro Course ABM1 Page.
 *
 * @author Andy Turner
 */
public class ABM1 extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public ABM1(PythonIntroCourse c) {
        super("abm1", "Agent Based Model Part 1", "ABM1", c);
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        Section s;
        s = addSection("1", "Introduction", 2);
        w.add(s.sectionHTML);
        w.add("<p>In a series of practicals you are going to develop a simple"
                + " spatial "
                + c.index.getReference("ABM", "Agent Based Model", s.sid)
                + " (ABM). Developing such models is useful in social and"
                + " ecological sciences in studying behaviour and emergence in"
                + " complex systems.</p>");
        w.add("""
              <p>The ABM will represent individual 'agents' with varying 
              characteristics including their spatial location. The model will 
              run iteratively such that individual agents will each get to act 
              in each simulation step or iteration of the model which represents
              the passage of time.</p>
              <p>The implemention will have:</p>
              <ul>
              <li><em>Model code</em> that deals with user interaction, sets up 
              and activates the model, checks for stopping conditions, and 
              manages model inputs and outputs.</li>
              <li><em>Agent code</em>, which is used to define agents and their
              actions, and record their state. Agents will have some behaviours 
              conditioned by what is happening around them in a local 
              neighbourhood.</li>
              <li><em>Environment code</em>, which represents the place in which 
              agents act and interact, and may constrain elements of agent 
              actions and interactions.</li>
              </ul>
              <p>In building an ABM, you will practise:</p>
              <ul>
              <li>understanding errors</li>
              <li>testing and debugging</li>
              <li>using for loops and if statements</li>
              <li>defining functions and classes and structuring code into 
              modules</li>
              <li>reading and writing data</li>
              <li>organising code into modules</li>
              <li>ways of interacting with users</li>
              </ul>
              <p>The agents will have simplistic behaviour and the model will be 
              very abstract. Nevertheless, hopefully, it will become clear how 
              to evolve it into something more realistic and useful.</p>
              <p>The environment will be initialised with data read from a file. 
              The model will be visualised as an animation as it runs. Outputs 
              from the model will be saved in files.</p>
              """);

        s = addSection("2", "Getting started", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>The first step is to represent two agents in two dimensional 
              spatial locations given by cartesian coordinates ('x' and 'y'), 
              get them to move randomly and calculate the distance between 
              them.</p>
              <p>The algorithm for this practical:</p>
              <pre># Initialise variable x0
              # Initialise variable y0
              # Change x0 and y0 randomly
              # Initialise variable x1
              # Initialise variable y1
              # Change x1 and y1 randomly
              # Calculate the Euclidean distance between (x0, y0) and (x1, y1)
              </pre>
              <p>In your local code repository create a new directory called 
              'src' and within this create a new directory called 'abm1'.</p>
              <p>Open Spyder and save the file as 'model.py' in the 'abm1'
              directory</p>
              <p>Copy the algorithm for the practical and paste it in.</li>
              <p>Add a line after the line "# Initialise a variable x0" to 
              initialise a variable 'x0' with the value '0' and print this 
              out:</p>
              <pre><code class="language-python">x0 = 0
              print("x0", x0)</code></pre>
              <p>Save and run the program. The output from running the program 
              should be:</p>
              <pre>x0 0</pre>
              """);
        w.add("<p>Note that two parameters are passed into the "
                + c.index.getReference("Python print", "print")
                + " function. These are printed out sequentially with a space"
                + " delimiter by default.</p>");
        w.add("<p>Do the same for variable 'y0'.</p>");

        s = addSection("3", "Randomly changing values", 2);
        w.add(s.sectionHTML);
        w.add("<p>The Python standard library "
                + c.index.getReference("Python random", "random", s.sid)
                + " module implements pseudo-random number generators for"
                + " various distributions and provides a way to change variable "
                + " values randomly. To use the module it has to be imported."
                + " Towards the top of your source code file add the following"
                + " import statement:</p>");
        w.add("""
              <pre><code class="language-python">import random</code></pre>
              <p>Import statements are best placed at the top of files as this 
              makes them easy to find.</p>
              """);
        w.add("<p>An "
                + c.index.getReference("Python if", "if statement", s.sid)
                + " is going to be used to increase or decrease 'x0' based on "
                + " the value obtained from a call to the function "
                + "<a href=\"https://docs.python.org/3/library/random.html#random.random\">"
                + "random</a>"
                + " from the random module. First obtain and print a"
                + " pseudo-random number in the range [0, 1) as follows:</p>");
        w.add("""
              <pre><code class="language-python">rn = random.random()
              print(rn)</code></pre>
              """);
        w.add("<p>Run your program a few times to observe that the value of "
                + "'rn' varies randomly.</p>"
                + "<p>What is happening is that the start of the pseudo-random "
                + "sequence used to generate numbers randomly is being set "
                + "from the computer clock time which is continually changing.</p>"
                + "<p>If the value 'rn' is less that '0.5' increase 'x0' by '1',"
                + " otherwise decrease 'x0' by '1':</p>");
        w.add("""
              <pre><code class="language-python">if rn < 0.5:
                  x0 = x0 + 1
              else:
                  x0 = x0 - 1</code>
              print("x0", x0)</pre>
              """);
        w.add("""
              <p>Run your program a few times to observe that sometimes the 
              value of 'x0' increases and sometimes it decreases and this 
              corresponds to the value of 'rn'.</p>
              <p>When testing code, it is undesireable to have different results 
              each time. So, it is better to 'set the seed' of random. After the 
              import statements add the following:</p>
              <pre><code class="language-python"># Set the pseudo-random seed for reproducibility
              random.seed(0)</code></pre>
              <p>When you run the program, you should get the following output:
              </p>
              <pre>x0 0
              y0 0
              rn 0.8444218515250481
              b False
              x0 - 1 </pre>
              <p>For differnet results pass in a different value into the 'seed'
              function.</p>
              <p>Repeat what is done to modify the value of 'x0' to modify the 
              value of 'y0'. Repeat what has been done for 'x0' and 'y0' to do 
              similarly to 'x1' and 'y1'.</p>
              """);

        s = addSection("4", "Calculate the Euclidean distance", 2);
        w.add(s.sectionHTML);
        w.add("<p>Use the "
                + "<a href = \"https://en.wikipedia.org/wiki/Pythagorean_theorem\">"
                + "Pythogorean theorem</a> to calculate the distance between "
                + "the cartesian coordinates (x0, y0) and (x1, y1). The "
                + "algorithm is:</p>");
        w.add("""
              <pre># Calculate the difference in the x coordinates.
              # Calculate the difference in the y coordinates.
              # Square the differences and add the squares
              # Calculate the square root</pre>
              <p>At the end of your source code set: 'x0' and 'y0' to equal '0';
              x1 to equal 3, and y1 to equal 4. Then add the algorithm above 
              into your source code and try to calculate the distance between
              the cartesian coordinates(0, 0) and(3, 4). You can use the symbol
              '**' to raise a number to the power of another number. So, raising 
              a number to the power of '0.5' calculates the square root.
              """);
        w.add("(Alternatively, import the Python standard library "
                + c.index.getReference("Python math", "math", s.sid)
                + " module and use the "
                + "<a href = \"https://docs.python.org/3/library/math.html#math.sqrt\">"
                + "sqrt</a> function).</p>");

        s = addSection("5", "Review, commit and look ahead", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>If you managed to develop the code and get it running and
              producing the correct answer, then great. Do not worry if you
              did not get it working but gave it a try.</p>
              <p>There is a lot of repetition in the code. If '(x0, y0)" are the 
              coordinates for 'agent_0' and '(x1, y1)' are the coordinates for 
              'agent_1'. The code currently initialises agent_0 and agent_1
              at the same coordinates. These agents only move once each.<p>
              <p>Add and commit to your local git repository and assuming you 
              are using GitHub - push your changes to GitHub.</p>
              """);
        w.add("<p>In the next ABM practical: Coordinate pairs will be stored"
                + " as lists. The distance calculation will be turned into a"
                + " function. And, "
                + c.index.getReference("Python for", "for loops")
                + " will be used to create and move more agents more times."
                + "</p>");
        w.add("</div>");
    }
}
