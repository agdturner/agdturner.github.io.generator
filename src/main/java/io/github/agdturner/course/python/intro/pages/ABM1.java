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
        w.add("""
              <h2 id="1">1. Introduction to ABM</h2>
              <p>In a series of practicals we are going to develop a simple 
              spatial agent-based model (ABM). Spatial agent based modelling is 
              widely used in social and ecological sciences. The model will 
              represent individual agents with varying characteristics including 
              their spatial location. The model will run iteratively such that 
              individual agents will each get to act in each step or iteration
              which represents the passage of time.</p>
              <p>The key code elements of the ABM are:</p>
              <ul>
              <li><em>Model code</em>, which deals with user interaction, sets 
              up and activates the model, checks for stopping conditions, and 
              manages model inputs and outputs.</li>
              <li><em>Agent code</em>, which is used to define agents and their
              actions, and record their state. Agents will have some behaviours 
              conditioned by what is happening around them in a local 
              neighbourhood.</li>
              <li><em>Environment code</em>, which represents the place in which 
              agents act and interact, and may constrain elements of agent 
              actions and interactions.</li>
              </ul>
              <p>In building an ABM, we will practise:</p>
              <ul>
              <li>structuring code</li>
              <li>using for loops and if statements</li>
              <li>calculating distances</li>
              <li>reading and writing data</li>
              <li>object orientated programming</li>
              <li>ways of interacting with users</li>
              <li>understanding errors</li>
              <li>testing and debugging</li>
              </ul>
              <p>The agents in the model developed in these practical exercises 
              have simplistic behaviours and the model is abstract. Hopefully, 
              it will become clearer how the code could evolve into a framework 
              that could be used to tackle more problem focused analysis.</p>
              <p>You could imagine the model as something real, by thinking of 
              the first set of agents as being grazing animals. The model is 
              going to involve these agents wandering around and gaining 
              resource from the underlying landscape.</p>
              <p>The code can be used as a foundation for a very wide range of 
              models, not limited to ecological scenarios – as we'll consider 
              towards the end of the practical exercises.</p>
              <p>The model will have agents moving through space over time. Each
              agent will have access to a list of the other agents to allow for 
              communication between agents. Each agent will have reference to 
              the environment and be able to query and modify the environment. 
              The environment will be initialised with data read from a file. 
              The model will be visualised as an animation as it runs. Outputs 
              from the model will be saved in files.</p>
              
              <h2 id="2">2. Practical task</h2>
              <p>Represent two agents with two dimensional spatial locations 
              given by cartesian coordinates (x and y), get them to move 
              randomly and calculate the distance between them.</p>
              <p>The algorithm for this practical:</p>
              <pre># Initialise variable x0
              # Initialise variable y0
              # Change x0 and y0 randomly
              # Initialise variable x1
              # Initialise variable y1
              # Change x1 and y1 randomly
              # Calculate the Euclidean distance between (x0, y0) and (x1, y1)
              </pre>
              <p>Follow these steps:</p>
              <ul>
              <li>In your local code repository create a new directory called 
              "src" and within this create a new directory called "abm1".</li>
              <li>Open Spyder and save a file as "model.py" in the abm1 
              directory</li>
              <li>Copy the algorithm for the practical and paste it at the end 
              of the model.py file.</li>
              <li>After the line "# Initialise a variable x0" add the 
              following to initialise the variable x0 with the Integer value 0:
              <pre><code class="language-python">x0 = 0
              print("x0", x0)</code></pre>
              </li>
              <li>Save and run the program</li>
              </ul>
              <p>The output from running the program should be:</p>
              <pre>x0 0</pre>
              <p>It is good to run something simple to begin with to check 
              things are working. If this has worked, then similarly initialise 
              the value of y0 and test you get the following output:</p>
              <pre>x0 0
              y0 0</pre>
              <p>Note that it is always worth thinking about how to test code to 
              make sure it is working. In this case, testing involved printing 
              something out.</p>
              
              <h2 id="3">3. Randomly changing variable values</h2>
              <p>To do this, we will make use of the
              <a href="https://docs.python.org/3/library/random.html">Random 
              Package (random)</a>
              which has to be imported. Towards the top of your source code file 
              below any general file comments add the import statement:</p>
              <pre><code class="language-python">import random</code></pre>
              <p>Import statements are best placed at the top of files as this 
              makes them easy to find.</p>
              <p>In order to increase or decrease variable values, we are going 
              to make use of an if-else statement of the form:</p>
              <pre>if (some condition is True):
                  # Do something.
              else:
                  # Do something else.</pre>
              <p>From the random package there are a few ways to create 
              pseudo-random numbers. These are pseudo-random, rather than 
              completely random, and are generated from a binary sequence that 
              has some properties including being somewhat random. Let us not 
              be concerned with the deatils of how random the sequence is, or 
              what the other properties are for the time being.</p>
              <p>Add code to generate a pseudo-random Float value in the range 
              [0 to 1) - a range that includes 0 but does not include 1 by 
              adding the following after the "# Change x0 and y0 randomly" 
              line:</p>
              <pre><code class="language-python">rn = random.random()
              print(rn)</code></pre>
              <p>Now, run your code a few times. Notice that the number rn
              generated and printed out varies in the range given. What is going 
              on, is that the current time is used to initialise the position 
              (seed) within the pseudo-random sequence from which the Float 
              values are obtained (from the random.random() function). As the 
              time is different for each run, then we typically get different 
              Float values returned.</p>
              <p>Now, when testing code, there can be difficulties and confusion
              if the program generates different variable values and works 
              differently in random ways in different runs. Sometimes an error 
              might be encountered and other times not - which can make 
              debugging a program difficult. For now, we are going to set the 
              seed (the initial position within the pseudo-random sequence) 
              using a called to the random seed function. Let us do that in a 
              line after the import statements towards the top of the source 
              code by adding in the following lines:</p>
              <pre><code class="language-python"># Set the pseudo-random seed for reproducibility
              random.seed(0)</code></pre>
              <p>Note that this passes the Integer 0 into the random seed 
              function. Passing in different integers will result in different 
              results. Try passing in a few different integers and running the 
              program before setting the seed using 0 again.</p>
              <p>Now, for the conditional part of the if-else statement, we want 
              something that evaluates to True or False. We can use the less 
              than operator (<) to evaluate whether the Float rn is less than 
              another number. Add the following lines after printing out rn:</p>
              <pre><code class="language-python">b = rn < 0.5
              print("b", b)
              if b:
                  x0 = x0 + 1
              else:
                  x0 = x0 - 1
              print("x0", x0)</code></pre>
              <p>When you run the program, you should get the following output:
              </p>
              <pre>x0 0
              y0 0
              rn 0.8444218515250481
              b False
              x0 -1</pre>
              <p>The value of x0 has been decreased by 1 as rn < 0.5 evaluates 
              to False so the if-else statement else condition is computed.</p>
              <p>Now, let us simplify the code a little and replace the 
              following:</p>
              <pre><code class="language-python">b = rn < 0.5
              print("b", b)
              if b:</code></pre>
              <p>With:</p>
              <pre><code class="language-python">if rn < 0.5:</code></pre>
              <p>Next, duplicate the if-else statement and modify it to change 
              the value of y0 and print out the modified value. Then, after 
              having initialised x1 and y1 add code to randomly change these 
              values and print them out.</p>
              <p>Change the coordinate initialisation to randomly intialise the 
              coordinates to have values in the range [0, 99] using the function 
              randint() from the random module. Take time to comment your code
              so you can understand it later.</p>
              
              <h2 id="4">4. Calculate the Euclidean distance</h2>
              <p>In this section we are going to use the 
              <a href="https://en.wikipedia.org/wiki/Pythagorean_theorem">
              Pythogorean theorem</a> to calculate the distance between pairs of 
              coordinates in two dimensions. What is needed for this is the 
              following algorithm:</p>
              <pre># Calculate the difference in the x coordinates.
              # Calculate the difference in the y coordinates.
              # Square the differences and add the squares
              # Calculate the square root</pre>
              <p>At the end of your source code set x0 and y0 to equal 0, x1 to
              equal 3, and y1 to equal 4. Then add the algorithm above into 
              your source code and try to calculate the distance between the 
              coordinates (0, 0) and (3, 4). You can use the power operator 
              (**) in order to calculate the square root as raising a value to 
              the power of 0.5 is equivallent to calculating the square root. 
              Alternatively, you can import the math package and use the sqrt 
              function (<a href="https://docs.python.org/3/library/math.html?highlight=sqrt#math.sqrt">math.sqrt()</a>).</p>
              <p>In the next practical we will modify our code to use lists to
              store coordinate pairs and turn the distance calculation into a 
              function. We will also use For Loops to create and move the 
              coordinates.</p>
              
              <h2 id="5">5. Review and Save</h2>
              <p>If you managed to develop the code and get it running and 
              producing the correct answer, then great. Don't worry if you 
              didn't get it working but gave it a try. The start of the next 
              practical in this series begins with a recap. Before moving on 
              though, let's review the code and make a further change:</p>
              <ul>
              <li>There is a lot of repetition in the code, in that there are 
              sections of code doing similar things.</li>
              <li>The code is not very agent based, it is simply coordinates and 
              no behaviour.</li>
              <li>The space the coordinates are currently moving about in is 
              unbounded, which may or may not be appropriate.</li>
              <li>The coordinates made initially start in the same place and 
              as there is only one move each, they are not likely to be very 
              different after this.</li>
              </ul>
              <p>Add and commit to your local git repository and assuming you 
              are using GitHub - push your changes to GitHub.</p>
              """);
//        w.add("<p></p>");
//        w.add("<p>Enter: \"\"</p>");
        w.add("</div>");
    }
}
