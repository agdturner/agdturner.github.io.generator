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
              defining their location. More attributes could be added to the 
              list to represent other characteristics of the agents, but it is 
              almost certainly easier to define them a class for an agent and 
              use this instead.</p>
              
              <h2>2. Define an Agent class</h2>
              <p>In your local code repository src directory create a new 
              directory called "abm4". Open Spyder and use "save as" to save 
              your "model.py" file from abm3 into the abm4 directory.</p>
              <p>Create a new file in the abm4 directory called 
              "agentframework.py", and add a minimal class definition for 
              an Agent class in it:</p>
              <pre><code class=\"language-python\">class Agent():
                  pass</code></pre>
              <p>The keyword "pass" does not really do anything, but ensures 
              this code is syntactically correct. In the model.py file reduce 
              n_iterations to 10, and add the following import statement:</p>
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
              to be random Integers between 0 and 99 as follows:</p>
              <pre><code class=\"language-python\">import random

              class Agent:
                  def __init__(self):
                      self.x = random.randint(0, 99)
                      self.y = random.randint(0, 99)</code></pre>
              <p>Note that for this to work, it was necessary to import the 
              random module.</p>
              <p>In model.py, add a statement to print Agent a after it has 
              been instantiated and run the program again.</p>
              <p>The new print statement should produce output that looks like 
              the following:</p>
              <pre><agentframework.Agent object at 0x00000249AEA21D88></pre>
              <p>The last part of your print statement will probably be 
              different and if you run the program again, it will likely be 
              different again. That last part is a memory address for where the 
              object is stored. Python does not control which address in memory 
              is used to store things, this is handled by the underlying 
              operating system, and what is allocated will depend on the system 
              state when the program is run.</p>
              <p>When printing an Agent instance, it would be better if 
              something more informative were printed. The way yo do this is to 
              override the __str__ method in the Agent class. To do this, define 
              the method __str__() in the Agent class as follows:</p>
              <pre><code class=\"language-python\">def __str__(self):
                  return self.__class__.__name__ + "(x=" + str(self.x) \
                      + ", y=" + str(self.y) + ")"</pre></code>
              <p>Note that this has to be indented at the right level in the 
              Agent class. Also note that it returns a String which includes 
              the name of the class and details of the x and y variable 
              attributes which have been transformed by the built in function 
              str() to add them to the String that is returned. Run model.py 
              again and the print statement should now result in the following:
              </p>
              <pre>x=49, y=97</pre>
              <p>Change the "# Initialise agents" code section to be:</p>
              <pre><code class=\"language-python\"># Initialise agents
              agents = []
              for i in range(n_agents):
                  # Create an agent
                  agents.append(agentframework.Agent())
                  print(agents[i])
              print(agents)</code></pre>
              <p>Run model.py and you should get similar output to the 
              following (in the error report, the file paths will probably be 
              different, and the line numbers might be different if your code 
              is not exactly the same):</p>
              <pre>Check this is equal to 5: 5.0
              Agent(x=49, y=97)
              Agent(x=53, y=5)
              Agent(x=33, y=65)
              Agent(x=62, y=51)
              Agent(x=38, y=61)
              Agent(x=45, y=74)
              Agent(x=27, y=64)
              Agent(x=17, y=36)
              Agent(x=17, y=96)
              Agent(x=12, y=79)
              [<agentframework.Agent object at 0x00000249B140C6C8>, <agentframework.Agent object at 0x00000249B14194C8>, <agentframework.Agent object at 0x00000249B1419148>, <agentframework.Agent object at 0x00000249B1419388>, <agentframework.Agent object at 0x00000249B14193C8>, <agentframework.Agent object at 0x00000249B1419448>, <agentframework.Agent object at 0x00000249B14191C8>, <agentframework.Agent object at 0x00000249B1419048>, <agentframework.Agent object at 0x00000249B1419488>, <agentframework.Agent object at 0x00000249B1419208>]
              Traceback (most recent call last):
              
                File "\\abm4\\model.py", line 95, in <module>
                  print("Maximum distance between all the agents", get_max_distance())
              
                File "\\abm4\\model.py", line 81, in get_max_distance
                  distance = get_distance(a[0], a[1], b[0], b[1])
              
              TypeError: 'Agent' object is not subscriptable</pre>
              <p>So, the agents list is initialised, but when the list is 
              printed, it is as though the print function does not access the 
              __str__ method. The error is a consequence of the things stored in 
              the agents list no longer being lists, but instantiated Agent 
              objects.</p>
              <p>To get the agents list to print out add the following method to 
              the Agent class:</p>
              <pre><code class=\"language-python\">def __repr__(self):
                  return str(self)</code></pre> 
              <p>To overcome the error, it is necessary to refer to the 
              attributes of the Agent instances and not to the item in a no 
              longer existant list. So, change the following line of code in 
              the get_max_distance() function:</p> 
              <pre>distance = get_distance(a[0], a[1], b[0], b[1])</pre>
              <p>To be:</p>
              <pre>distance = get_distance(a.x, a.y, b.x, by)</pre>
              <p>Notice that this is simpler and easier to read and understand.
              </p>
              <p>Now, everywhere else in the code that was referring to 
              a coordinate from the agents list - as being an item in a list -
              also needs changing. Run the modified program to see the error and 
              where the next issue is encountered.</p>
              <p>Occurrences of "agents[i][0]" should be changed to 
              "agents[i].x"; and, occurances of "agents[i][1]" should be change 
              to "agents[i].y". Make a further change in section of code for 
              plotting agents from:
              </p>
              <pre><code class=\"language-python\">
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
              plt.scatter(sy[0], sy[1], color='green')</code></pre>
              <p>To:</p>
              <pre><code class=\"language-python\">
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
              plt.scatter(sy.x, sy.y, color='green')</code></pre>
              <p>Compare the code to identify what has changed.</p>
              <p>If you made all the changes as instructed, then the program 
              should now run without error and produce the same output as 
              previously.</p>
              <p>As this completes a refactoring step, it is good practise to 
              commit this code to your repository with an approriate message.
              So, do that now. It is not necessary to push this change to 
              GitHub yet, but remember to do so before the end of your coding 
              session (assuming you are using GitHub).</p>
              
              <h2>3. Separation of Concerns</h2>
              <p>Define a method called move in the Agent class as follows:</p>
              <pre>def move(self, x_min, y_min, x_max, y_max):</pre>
              <p>Cut the code from the "# Move agents" loop that moves an agent 
              and add it to the new move method, replacing all the "agents[i]" 
              with "self". Where the code was cut from, add the following to 
              call the move method:</p>
              <pre>agents[i].move(x_min, y_min, x_max, y_max)</pre>              
              <p>Now, in the Agent class, it appears as though the move method 
              also takes in self, but this is not a parameter that is passed in. 
              Normally when calling a function the number of parameters matches,
              but for methods (function in a class) things are slightly 
              different.</p>
              <p>Running the program should produce the same results as 
              previously. The Agent class code now deals with the details of 
              how instances move, and the model.py code details when they do.
              This is a reasonable separation of concerns for an Agent Based 
              Model.</p>
               
              <h2>4. Give each agent a unique name</h2>
              <p>It is possible that two Agent class instances might be located 
              at the same coordinates, and it would be helpful to distinguish 
              them further.</p>
              <p>Add a docstring and a parameter to the constructor method of 
              Agent so that the method is as follows: 
              </p>
              <pre><code class=\"language-python\">def __init__(self, i):
              \"""
              The constructor method.
               
               Parameters
              ----------
              i : Integer
                  To be unique to each instance.
              
               Returns
              -------
              None.
              
              \"""
              self.i = i
              self.x = random.randint(0, 99)
              self.y = random.randint(0, 99)
              pass</code></pre>
              <p>Run model.py and you should get the following error:</p>
              <pre>Traceback (most recent call last):
              
                File "\\abm4\\model.py", line 91, in <module>
                  agents.append(agentframework.Agent())
              
              TypeError: __init__() missing 1 required positional argument: 'i'</pre>
              <p>This error indicates that a positional argument is missing when 
              constructing an instance of the Agent class. Change model.py to 
              add the missing argument "i". Modify the Agent class __str__ 
              method to add the unique characteristic of each Agent to the 
              returned String.</p>
              """);
//              <p></p>
//              <pre></pre>
//              <pre><code class=\"language-python\"></code></pre>
        w.add("</div>");
    }
}
