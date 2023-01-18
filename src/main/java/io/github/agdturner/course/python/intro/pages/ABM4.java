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
 * For Python Intro Course ABM4 Page.
 *
 * @author Andy Turner
 */
public class ABM4 extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public ABM4(PythonIntroCourse c) {
        super("abm4", "Agent Based Model Part 4", "ABM4", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2>1. Introduction</h2>
              <p>Up to now, our agents are lists of two items - the coordinates 
              defining their location. More attributes could be addded to the 
              list to represent other characteristics of the agents, but it is 
              almost certainly easier to define them as classes.</p>
              
              <h2>2. Using Classes to Define Agents</h2>
              <p>In your local code repository src directory create a new 
              directory called "abm4". Open Spyder and use "save as" to save 
              your "model.py" file into the abm4 directory.</p>
              <p>Create a new file in the abm4 directory called "agentframework.py", 
              have this open in Spyder. Add to it a minimal class definition for 
              an Agent class:</p>
              <pre><code class=\"language-python\">class Agent():
                  pass</code></pre>
              <p>In the model.py file reduce n_iterations to 10, and add the 
              following import statement:</p>
              <pre><code class=\"language-python\">import agentframework</code></pre>
              <p>At the start of the "# Initialise agents" code section add the 
              following lines:</p>
              <pre><code class=\"language-python\">a = agentframework.Agent()
              print("type(a)", type(a))</code></pre>
              <p>Run model.py and examine the output which should contain the 
              following line:</p>
              <pre>type(a) <class 'agentframework.Agent'></pre>
              <p>So, we have successfully created an instance of the class Agent
              as defined in the agentframework module.</p>
              <p>Add a constructor method to the Agent class that initialises 
              x and y variable attributes of instances of the Agent class 
              to be random Integers between 0 and 99. Note that for this to 
              work, it is necessary to import the random module. The Agent class 
              should be as follows:</p>
              <pre><code class=\"language-python\">import random

              class Agent:
                  def __init__(self):
                      self.x = random.randint(0, 99)
                      self.y = random.randint(0, 99)</code></pre>
              <p>In model.py, add a statement to print Agent a after it has 
              been instantiated and run the program again.</p>
              <p>The new print statement should produce output that looks like 
              the following:</p>
              <pre><agentframework.Agent object at 0x00000249AEA21D88></pre>
              <p>The last part of your print statement will probably be 
              different and if you run the program again, it will likely be 
              different again. What that last part is, is a memory address for 
              where the object is stored. When printing an Agent instance, 
              something more informative can be returned by overriding the 
              __str__ method. To do this, define the method __str__() in the 
              Agent class. It should return a String and ideally this will be 
              something useful for identifying the instance. The following 
              returns a String detailing the x and y variable attributes:</p>
              <pre><code class=\"language-python\">def __str__(self):
                  return self.__class__.__name__ + "(x=" + str(self.x) \
                      + ", y=" + str(self.y) + ")"</pre></code>
              <p>Run model.py again and the print statement should now be:</p>
              <pre>x=49, y=97</pre>
              <p>Change the "# Initialise agents" code section to be:</p>
              <pre><code class=\"language-python\"># Initialise agents
              agents = []
              for i in range(n_agents):
                  # Create an agent
                  agents.append(agentframework.Agent())
              print(agents)</code></pre>
              <p>Run model.py and you should get the following error, or 
              something that looks very similar (the file paths and line numbers
              might be slightly different if your code is slightly different):
              </p>
              <pre>Traceback (most recent call last):
              
                File "\\abm4\\model.py", line 95, in <module>
                  print("Maximum distance between all the agents", get_max_distance())
              
                File "\\abm4\\model.py", line 81, in get_max_distance
                  distance = get_distance(a[0], a[1], b[0], b[1])
              
              TypeError: 'Agent' object is not subscriptable</pre>
              <p>The issue is that our the things stored in the agents list are 
              no longer lists, they are instantiated Agent objects. To get the 
              rest of the program to work with the Agent instances, we need to 
              change the following line of code in get_max_distance():</p> 
              <pre>distance = get_distance(a[0], a[1], b[0], b[1])<pre>
              <p>To be:</p>
              <pre>distance = get_distance(a.x, a.y, b.x, by)<pre>
              <p>Notice that this is simpler and easier to read and understand.
              </p>
              <p>Now, everywhere else in the code that was referring to 
              a coordinate from the agents list as being an item in a list also 
              needs changing as above. Run the modified program to see the 
              error and where the next issue is encountered.</p>
              <p>So, occurances of "agents[i][0]" should be changed to 
              "agents[i].x"; and, occurances of "agents[i][1]" should be change 
              to "agents[i].y". Change the plotting section of the code from:
              </p>
              <pre><code class=\"language-python\"># Plot
              for i in range(n_agents):
                  plt.scatter(agents[i][0], agents[i][1], color='black')
              # Plot the coordinate with the largest x red
              lx = max(agents, key=operator.itemgetter(0))
              plt.scatter(lx[0], lx[1], color='red')
              # Plot the coordinate with the smallest x blue
              sx = min(agents, key=operator.itemgetter(0))
              plt.scatter(sx[0], sx[1], color='blue')
              # Plot the coordinate with the largest y yellow
              ly = max(agents, key=operator.itemgetter(1))
              plt.scatter(ly[0], ly[1], color='yellow')
              # Plot the coordinate with the smallest y green
              sy = min(agents, key=operator.itemgetter(1))
              plt.scatter(sy[0], sy[1], color='green')
              plt.show()</code></pre>
              <p>To:</p>
              <pre><code class=\"language-python\"># Plot
              for i in range(n_agents):
                  plt.scatter(agents[i].x, agents[i].y, color='black')
              # Plot the coordinate with the largest x red
              lx = max(agents, key=operator.attrgetter('x'))
              plt.scatter(lx.x, lx.y, color='red')
              # Plot the coordinate with the smallest x blue
              sx = min(agents, key=operator.attrgetter('x'))
              plt.scatter(sx.x, sx.y, color='blue')
              # Plot the coordinate with the largest y yellow
              ly = max(agents, key=operator.attrgetter('y'))
              plt.scatter(ly.x, ly.y, color='yellow')
              # Plot the coordinate with the smallest y green
              sy = min(agents, key=operator.attrgetter('y'))
              plt.scatter(sy.x, sy.y, color='green')
              plt.show()</code></pre>
              <p>Compare the code to identify what has changed.</p>
              <p>The program should now run without error and produce the same 
              output as previously.</p>
              <p>Define a method called move in the Agent class as follows:</p>
              <pre>def move(self, x_min, y_min, x_max, y_max):</pre>
              <p>Cut the code from the "# Move agents" loop that moves an agent 
              and add it to the new move method. In this code, replace 
              "agents[i]" with "self". Where the code was cut from, add the 
              following to call the move method:</p>
              <pre>agents[i].move(x_min, y_min, x_max, y_max)</pre>              
              <p>Notice again that the Dot Operator is used to access the 
              method. Now, in the Agent class, the move method also takes in 
              self, but this is not a parameter that is passed in. Normally when
              calling a function the number of parameters matches what is passed 
              in, but for a method (which is just a function belonging to a 
              class), this additional parameter is given within the class.</p>
               
              <h2>3. Give each agent a unique name</h2>
              <p>It is possible that two agents might be at the same 
              coordinates, and it would be helpful to distinguish them further...</p>
              
              <h2>4. Give each agent a unique name</h2>
              <p>The code is more consise and easier to understand, 
              there is not a huge gain in much has been gained 
              yet from this new way of representing agents.</p>
                
              """);
//        w.add("<p></p>");
//        w.add("<p>Enter: \"\"</p>");
        w.add("</div>");
    }
}
