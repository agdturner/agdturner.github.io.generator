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
        super("abm2", "Agent Based Model Practical 2", "ABM2", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        Section s;
        s = addSection("1", "Recap and preparation", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>Your 'model.py' ABM1 code should look something like the 
              following:</p>
              <pre><code class="language-python">import random
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
              distance 5.0</pre>
              <p>In your local code repository src directory create a new 
              directory called 'abm2'. Open Spyder and save 'model.py' into the 
              'abm2' directory.</p>
              """);
        
        s = addSection("2", "Using Lists", 2);
        w.add(s.sectionHTML);
        w.add("<p>Rather than handle coordinates for each agent"
                + " individually, the coordinates for each agent are now going"
                + " to be stored in"
                + c.index.getReference("Python list", "lists", s.sid)
                + " of length 2, with the first item being an 'x' coordinate,"
                + " and the second item being a 'y' cordinate. All agents "
                + " are also going to be stored in a list.<p>");
        w.add("<p>The code is also going to be reorganised so that the agents"
                + " are created in a "
                + c.index.getReference("Python for", "for loop", s.sid)
                + ", and there will be a second for loop to adjust the "
                + " coordinates (move the agents).<p>");
        w.add("""
              <p>Towards the top of the file (below the import statements and 
              setting of the random seed) add the following to create a new 
              empty list called 'agents':</p>
              <pre><code class="language-python"># Create a list to store agents
              agents = []</pre></code>
              <p>Next, add coordinates to this list: First add one pair after 
              initialising 'y0' and 'x0', by adding the following:
              </p>
              <pre><code class="language-python">agents.append([x0,y0]) # Append to the list agents</pre></code>
              <p>Note that '[x0,y0]' creates a list containing 'x0' and 'y0', 
              and the 'append' function adds this list to the agents list. After
              doing this, 'agents[0][0]' is the 'x' coordinate of the first 
              agent in the agents list and 'agents[0][1]' is the 'y' coordinate 
              of the first agent in the agents list.</p>
              <p>Go through and replace all the other uses of 'x0' with indexed 
              list references, i.e. 'agents[0][0]' and 'y0' with 'agents[0][1]' 
              (uses - not the initial assignments). Check your code still runs.
              </p>
              <p>The code that creates the first agent and adds this to the 
              agents list should be as follows:</p>
              <pre><code class="language-python"># Initialise variable x0
              x0 = random.randint(0, 99)
              print("x0", x0)
              # Initialise variable y0
              y0 = random.randint(0, 99)
              print("y0", y0)
              agents.append([x0, y0])</code></pre>
              <p>Note that the variables 'x0' and 'y0' are only created for 
              this initialisation. Can you think of a way to reduce this code 
              and do the initialition more succinctly?</p>
              """);
        
        s = addSection("3", "Plotting", 2);
        w.add(s.sectionHTML);
        w.add("<p>To plot the agents using "
                + c.references.getReference("Matplotlib")
                + " add the following import statements:</p>");
        w.add("""
              <pre><code class="language-python">import matplotlib.pyplot as plt
              import operator</code></pre>
              <p>And adding the following code to the end of 'model.py':</p>
              <pre><code class="language-python"># Plot the agents
              plt.scatter(agents[0][0], agents[0][1], color='black')
              plt.scatter(agents[1][0], agents[1][1], color='black')
              plt.show()
              # Get the coordinates with the largest x-coordinate 
              print(max(agents, key=operator.itemgetter(0)))</code></pre>
              <p>Run 'model.py' and you should see an image output in the 
              'Plots' pane of Spyder. The image should contain two points.</p>
              <p>Have a look at
              <a href="https://matplotlib.org/stable/api/pyplot_summary.html">
              the matplotlib pyplot documentation</a></p>
              <p>After the code that plots the points black, plot the point 
              with the largest x coordinate red. One way to do this is to store 
              those coordinates in a variable and then pass the x-coordinate and 
              y-coordinate as arguments to the command aliased as 'plt' before 
              the 'show()' command.</p>
              <p>Have a try and don't worry if you don't get this to work.</p>
              """);
        
        s = addSection("4", "Using Loops", 2);
        w.add(s.sectionHTML);
        w.add("<p>This section guides you through restructuring your code so"
                + " that agent initialisation (for all agents) happens first,"
                + " and moving (for all agents) happens second. There will be"
                + " loops for each of these things and for plotting all the"
                + " agents.</p>");
        w.add("<p>To prepare yourself, review your code. In doing so, it might"
                + " help to insert some blank lines to separate different"
                + " parts of it, and to add more comments to help you"
                + " understand what it is doing. Once you have done that,"
                + " commit your code to your local repository and assuming"
                + " you are using GitHub - push your changes to GitHub.</p>");
        w.add("<p>Comment out the code for initialising and changing the"
                + " coordinates of the second agent. After the line of code"
                + " that initialises the agent list add a variable called"
                + " 'n_agents' and set this equal to '10'. Then create a "
                + c.index.getReference("Python for", "for loop", s.sid)
                + " that uses n_agents to create 10 agents. The code you want"
                + " is:</p>");
        w.add("""
              <pre><code class="language-python">n_agents = 10
              for i in range(n_agents):
                  agents.append([random.randint(0, 99), random.randint(0, 99)])</code></pre>
              <p>Check that your program still runs.</p>
              <p>You no longer want any code that initialises other agents.</p>
              """);
        w.add ("<p>Use another for loop to move all 10 agents. And use another"
                + " for loop to plot all 10 agents black. Hopefully, there is"
                + " still a red coloured dot which gives the location of the"
                + " agent with the largest x coordinate.</p>");
        w.add("<p>Add and commit to your local git repository and assuming you"
                + " are using GitHub - push your changes to GitHub.</p>");
        
        s = addSection("5", "More Plotting", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>Similarly to plotting the agent with the largest x coordinate
              red, write code to plot the agent with the smallest x coordinate 
              blue; the largest y coordinate yellow; and the smallest y 
              coordinate green.</p>
              <p>Commit your code to your local repository and assuming you 
              are using GitHub - push your changes to GitHub.</p>""");
        
        s = addSection("6", "Code Review and Looking Forward", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>If you managed to complete all parts, then it should be 
              straight forward to modify your code to run for different numbers
              of agent. Have a try and also think about how you would get the 
              agents to move multiple times.</p>
              <p>If you got stuck, then don't worry, look ahead to the start of 
              the next ABM practical where some code that does everything is 
              provided.</p>
              <p>Next we will look in more detail about functions and how to 
              document them. Then in the next ABM practical: a loop will be 
              created to simulate movement of the agents multiple times; and the 
              distance calculation code, which is currently just a test case, 
              will be changed into a function. Most of the next practical will 
              be an exercise involving calculating the maximum distance between 
              agents and timing code to optimise this.</p>
              """);
        w.add("</div>");
    }
}
