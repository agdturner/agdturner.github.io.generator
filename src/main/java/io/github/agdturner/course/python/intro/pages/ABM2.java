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
 * For Python Intro Course ABM2 Page.
 *
 * @author Andy Turner
 */
public class ABM2 extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public ABM2(PythonIntroCourse c) {
        super("abm2", "Agent Based Model Part 2", "ABM2", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        
        w.add("""
              <h2 id="1">1. Recap</h2>
              <p>Your ABM code should look something like the following:</p>
              <pre><code class=\"language-python\">import random
              import math
              
              # Set the pseudo-random seed for reproducibility
              random.seed(0)
              
              # Initialise variable x0
              x0 = random.randint(0, 99)
              print("x0", x0)
              # Initialise variable y0
              y0 = random.randint(0, 99)
              print("y0", y0)
              
              # Change x0 and y0 randomly
              rn = random.random()
              print("rn", rn)
              if rn < 0.5:
                  x0 = x0 + 1
              else:
                  x0 = x0 - 1
              print("x0", x0)
              rn = random.random()
              print("rn", rn)
              if rn < 0.5:
                  y0 = y0 + 1
              else:
                  y0 = y0 - 1
              print("y0", y0)
              
              # Initialise variable x1
              x1 = random.randint(0, 99)
              print("x1", x1)
              # Initialise variable y1
              y1 = random.randint(0, 99)
              print("y1", y1)
              
              # Change x1 and y1 randomly
              rn = random.random()
              print("rn", rn)
              if rn < 0.5:
                  x1 = x1 + 1
              else:
                  x1 = x1 - 1
              print("x1", x1)
              rn = random.random()
              print("rn", rn)
              if rn < 0.5:
                  y1 = y1 + 1
              else:
                  y1 = y1 - 1
              print("y1", y1)
              
              # Calculate the Euclidean distance between (x0, y0) and (x1, y1)
              # Set x0 and y0 to equal 0, x1 to equal 3, and y1 to equal 4
              x0 = 0
              y0 = 0
              x1 = 3
              y1 = 4
              # Calculate the difference in the x coordinates.
              dx = x0 - x1
              # Calculate the difference in the y coordinates.
              dy = y0 - y1
              # Square the differences and add the squares
              ssd = (dx * dx) + (dy * dy)
              print("ssd", ssd)
              # Calculate the square root
              distance = ssd ** 0.5
              print("distance", distance)
              distance = math.sqrt(ssd)
              print("distance", distance)</code></pre>
              <p>Running the code should produce the following text output:</p>
              <pre>x0 49
              y0 97
              rn 0.890243920837131
              x0 48
              rn 0.04048437818077755
              y0 98
              x1 65
              y1 62
              rn 0.4049341374504143
              x1 66
              rn 0.7837985890347726
              y1 61
              ssd 25
              distance 5.0
              distance 5.0</pre></code>
              
              <h2 id="2">2. Using Lists</h2>
              <p>Rather than handle each coordinate individually, they are going 
              to be stored in lists of length 2, with the first item being x and 
              the second item being y. All the coordinate pairs are also going 
              to be stored in a list. The code is also going to be reorganised 
              so that all the coordinate pairs (the agents) are created in a 
              first loop, and there will be a second loop to adjust the 
              coordinates (move the agents).<p>
              <p>In your local code repository src directory create a new 
              directory called "abm2". Open Spyder and use "save as" to save 
              your "model.py" file into the abm2 directory. Then, towards the 
              top of the file (below the import statements and setting of the 
              random seed) add the following:</p>
              <pre># Create a list to store agents
              agents = []</pre>
              <p>Now to add coordinates to this list: First add one pair after 
              initialising y0 and x0, by adding the following:
              </p>
              <pre>agents.append([x0,y0]) # Append to the list agents</pre>
              <p>Notice the extra square brackets, which add the coordinates as 
              a list which is then appended to the agents list. So agents[0][0] 
              is the x coordinate of the first coordinate pair in the agents 
              list and agents[0][1] is the y coordinate of the first coordinate 
              pair in the agents list.</p>
              <p>Go through and replace all the other uses of x0 with indexed 
              list references, i.e. agents[0][0] and y0 with agents[0][1] 
              (all, except the first assignments). Check your code still runs.
              </p>
              <p>Now, about those first two assignments. At the moment the code 
              is:</p>
              <pre><code class=\"language-python\"># Initialise variable x0
              x0 = random.randint(0, 99)
              print("x0", x0)
              # Initialise variable y0
              y0 = random.randint(0, 99)
              print("y0", y0)
              agents.append([x0, y0])</code></pre>
              <p>In essence the variables x0 and y0 are only created for this 
              initialisation. Can you think of a way to remove the need for them 
              and do the initialition more simply?</p>
              
              <h2 id="3">3. Plotting</h2>
              <p>Now plot the coordinates using matplotlib by adding the 
              following import statements to those at the top of your file:
              </p>
              <pre><code class=\"language-python\">import matplotlib
              from matplotlib import pyplot as plt
              import operator</code></pre>
              <p>And adding the following code to the end of your file:</p>
              <pre><code class=\"language-python\"># Plot the agents
              plt.scatter(agents[0][0], agents[0][1], color='black')
              plt.scatter(agents[1][0], agents[1][1], color='black')
              plt.show()
              # Get the coordinates with the largest x-coordinate 
              print(max(agents, key=operator.itemgetter(0)))</code></pre>
              <p>Have a look at
              <a href="https://matplotlib.org/stable/api/pyplot_summary.html">
              the documentation for pyplot on the matplotlib site</a></p>
              <p>If you run the code you should see an image output in the 
              console, in Plots or it will appear in a pop up window. The image 
              should contain two dots.</p>
              <p>Now, overplot the dot with the largest x coordinate in red. One 
              way to do this is to store those coordinates in a variable and 
              then pass the x-coordinate and y-coordinate as arguments into an 
              matplotlib-pyplot (plt) command before the show() command.</p>
              <p>Once you have this working, commit your code to your local 
              repository and assuming you are using GitHub - push your changes 
              to GitHub.</p>
              
              <h2 id="4">4. Using Loops</h2>
              <p>This section provides guidance on how to restructure your code 
              so that all the agent initialisation happens first, all the moving 
              happens second, and all the plotting happens third. There will be 
              loops for each of these things. To prepare yourself, review your 
              code. In doing so, it might help to insert some blank lines to 
              separate different parts of it.</p>
              <p>Now, comment out the code for initialising and changing the 
              coordinates of the second agent. Then, after the line of code that 
              initialises the agent list: add a variable called n_agents and set 
              this equal to 10. Then create a For Loop that uses this to create 
              10 agents, replacing the code that creates a single agent. The 
              code you want is:</p>
              <pre><code class=\"language-python\">n_agents = 10
              for i in range(n_agents):
                  agents.append([random.randint(0, 99), random.randint(0, 99)])</code></pre>
              <p>Check that your code still runs.</p>
              <p>Using the same For Loop construction, modify the code to move
              the agents. Recall that agents[0] is the first agent, so if using 
              i for the loop: agents[i] is the i-th agent.</p>
              <p>Using the same For Loop construction, modify the code to plot
              all the agents.</p>
              <p>Have a go at getting this working. Hopefully, the red coloured 
              dot is still the agent with the maximum x coordinate.</p>
              <p>Add and commit to your local git repository and assuming you 
              are using GitHub - push your changes to GitHub.</p>
              
              <h2 id="5">5. More Plotting</h2>
              <p>As a further exercise, overplot the coordinate points with: the 
              smallest x coordinate using the colour blue; the largest y 
              coordinate using the colour yellow; and the smallest y coordinate 
              using the colour green.</p>
              <p>Commit your code to your local repository and assuming you 
              are using GitHub - push your changes to GitHub.</p>
              
              <h2 id="6">6. Code Review and Looking Forward</h2>
              <p>If you managed to complete all parts, then it should be 
              straight forward to modify your code to run for different numbers
              of agent.</p>
              <p>Next we will look in more detail about functions and how to 
              document them. Then in the next Agent Based Modelling practical
              the distance calculation code, which is currently really just a 
              test case, will be changed into a function. The next practical 
              will include an exercise involving timing code for different 
              numbers of agents.</p>
              """);
        w.add("</div>");
    }
}
