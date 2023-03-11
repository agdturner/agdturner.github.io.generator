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
              <h2 id="1">1. Introduction</h2>
              <p>Currently, agents is a list of lists. The lists agents 
              contains have two items - the coordinates defining each agent's
              location. More items could be added to each list - items 
              representing additional agent characteristics. However, the longer 
              a list becomes, the harder it gets to remember what index is 
              associated with what type of item and the easier it is to get 
              confused and make mistakes.</p>
              <p>Defining a class for agents provides a way to name agent 
              characteristics and define functionality as methods that 
              particularly apply to an agent instance.</p>
              <p>The agents list will be changed to contain objects which are 
              instances of an Agent class (agents). The Agent class will be 
              defined in a different file from model.py.</p>
              <p>In your local code repository src directory create a new 
              directory called "abm4". Open Spyder and use "save as" to save 
              your "model.py" file from abm3 into the abm4 directory.</p>
              
              <h2 id="2">2. Agent class definition</h2>
              <p>Create a new file in the abm4 directory named 
              "agentframework.py", and add a class definition for an Agent class
              in it as follows:</p>
              <pre><code class="language-python">class Agent():
                  pass</code></pre>
              <p>The keyword 'pass' ensures the code is syntactically correct 
              and will run.</p>
              <p>In the model.py file reduce n_iterations to 10, and add the 
              following import statement:</p>
              <pre><code class="language-python">import agentframework as af</code></pre>
              <p>Note that this imports the agentframework module which is to be 
              referred to by the abbreviation 'af'.</p>
              <p>At the start of the "# Initialise agents" code block, add the 
              following lines:</p>
              <pre><code class="language-python">a = af.Agent()
              print("type(a)", type(a))</code></pre>
              <p>Run model.py and examine the output. It should contain the 
              following line:</p>
              <pre>type(a) <class 'agentframework.Agent'></pre>
              <p>This indicates that an instance of the class Agent as defined 
              in the agentframework module was successfully created.</p>
              <p>Add a constructor method to the Agent class that initialises 
              x and y variable attributes to be random Integers between 0 and 99 
              as follows:</p>
              <pre><code class="language-python">import random

              class Agent:
                  def __init__(self):
                      self.x = random.randint(0, 99)
                      self.y = random.randint(0, 99)</code></pre>
              <p>Note that for this to work, it was necessary to import the 
              random module.</p>
              <p>In model.py, add a statement to print the agent that was 
              instantiated, and run the program again.</p>
              <p>The new print statement should produce output that looks like 
              the following:</p>
              <pre>&lt;agentframework.Agent object at 0x00000249AEA21D88&gt;</pre>
              <p>The last part of your print statement will probably be 
              different to '0x00000249AEA21D88' and if you run the program 
              again, it will likely be different again. This String is a memory 
              address identifying where the object is stored in the memory of 
              the computer and is not something to be concerned about.</p>
              <p>When printing an Agent instance, it would be better if 
              something more informative was output. The best way to do this 
              is to override the __str__ method which comes from the 'type 
              metaclass' that all classes inherit from by default. Define the 
              method __str__() in (i.e. indented in) the Agent class as 
              follows:</p>
              <pre><code class="language-python">def __str__(self):
                  return self.__class__.__name__ + "(x=" + str(self.x) \\
                      + ", y=" + str(self.y) + ")"</pre></code>
              <p>Note that this returns a String which includes the name of the 
              class and details of the x and y variable attributes which are 
              transformed by the builtin function str() to be Strings.</p>
              <p>Run model.py again and the print statement should now result in 
              the following:</p>
              <pre>Agent(x=49, y=97)</pre>
              <p>Change the "# Initialise agents" code section in model.py to:
              </p>
              <pre><code class="language-python"># Initialise agents
              agents = []
              for i in range(n_agents):
                  # Create an agent
                  agents.append(af.Agent())
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
              [&lt;agentframework.Agent object at 0x00000249B140C6C8&gt;, &lt;agentframework.Agent object at 0x00000249B14194C8&gt;, &lt;agentframework.Agent object at 0x00000249B1419148&gt;, &lt;agentframework.Agent object at 0x00000249B1419388&gt;, &lt;agentframework.Agent object at 0x00000249B14193C8&gt;, &lt;agentframework.Agent object at 0x00000249B1419448&gt;, &lt;agentframework.Agent object at 0x00000249B14191C8&gt;, &lt;agentframework.Agent object at 0x00000249B1419048&gt;, &lt;agentframework.Agent object at 0x00000249B1419488&gt;, &lt;agentframework.Agent object at 0x00000249B1419208&gt;]
              Traceback (most recent call last):
              
                File "\\abm4\\model.py", line 95, in &lt;module&gt;
                  print("Maximum distance between all the agents", get_max_distance())
              
                File "\\abm4\\model.py", line 81, in get_max_distance
                  distance = get_distance(a[0], a[1], b[0], b[1])
              
              TypeError: 'Agent' object is not subscriptable</pre>
              <p>The agents list is initialised, but the print function does not 
              use the __str__ method to get a String representation of the 
              agents when printing the list.</p>
              <p>The error is a consequence of the things stored in the agents 
              list no longer being lists, but instantiated Agent objects.</p>
              <p>Add the following method to the Agent class to get the print 
              function to print String representations of agents when printing 
              the agents list:</p>
              <pre><code class="language-python">def __repr__(self):
                  return str(self)</code></pre>
              <p>Like the method __str__(), the method __repr__() overrides from 
              the 'type metaclass', (for details see: 
              <a href="https://docs.python.org/3/library/functions.html#repr">
              repr()</a>).</p>
              <p>To prevent the error, it is necessary to refer to the 
              attributes of the agents as from the class definition and not to 
              items in lists (as agents are no longer lists, but are instances 
              of the class Agent). So, change the following line of code in 
              the get_max_distance() function:</p> 
              <pre><code class="language-python">distance = get_distance(a[0], a[1], b[0], b[1])</code></pre>
              <p>To be:</p>
              <pre><code class="language-python">distance = get_distance(a.x, a.y, b.x, by)</code></pre>
              <p>Examine the code change and appreciate that there is no longer 
              a need to remember which item in the list refers to a particular 
              coordinate.</p>
              <p>Everywhere else in the model.py that was referring to a 
              coordinate from the agents list is to be changed similarly. Run
              model.py to see where the next error is raised.</p>
              <p>In the code "agents[i][0]" should be changed to "agents[i].x"; 
              and, "agents[i][1]" should be changed to "agents[i].y". Make a 
              further change in the code block that plots agents, changing:
              </p>
              <pre><code class="language-python"># Plot the coordinate with the largest x red
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
              <pre><code class="language-python"># Plot the coordinate with the largest x red
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
              <p>Hopefully, you understand these changes and your program runs 
              without error and produces the same output as previously when you 
              have made all the changes.</p>
              <p>Commit your code to your local repository and assuming you are 
              using GitHub - push your changes to GitHub.</p>
              
              <h2 id="3">3. Separation of Concerns</h2>
              <p>Define a method called move in the Agent class as follows:</p>
              <pre><code class="language-python">def move(self, x_min, y_min, x_max, y_max):</code></pre>
              <p>Cut the code from the "# Move agents" loop that moves an agent 
              and insert it into the body of the new move method. Replace all 
              the instances of "agents[i]" with "self". Where the code was cut 
              from, add the following to call the move method:</p>
              <pre><code class="language-python">agents[i].move(x_min, y_min, x_max, y_max)</code></pre>              
              <p>In the Agent class, the move method has a parameter called 
              self, but this is not a parameter that is passed in. That self is 
              not passed in, is a difference between a method and a function in 
              python. Normally when calling a function the number of parameters 
              matches, but for methods (functions in a class) there is this 
              additional parameter that is not passed in and that is the first 
              parameter.</p>
              <p>Run the program and it should produce the same results as 
              previously. The Agent class code now deals with the details of 
              how agents move, and the model.py code details when they do.
              This is a reasonable separation of concerns for the model being 
              developed.</p>
              
              <h2 id="4">4. Give each agent a unique name</h2>
              <p>It is possible that two Agent class instances will be located 
              at the same coordinates at some iteration of the model, and it 
              would be helpful to distinguish them.</p>
              <p>Add a docstring and a parameter to the constructor method of 
              Agent so that the method is as follows:</p>
              <pre><code class="language-python">def __init__(self, i):
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
              <p>The error message is that an expected argument is missing at 
              the line that is calling for the construction of an Agent 
              instance. Change model.py to pass in the missing argument 'i'. Run 
              the program again and the error should not be encountered.</p>
              <p>Modify the Agent class __str__ method so it additionally 
              returns the unique characteristic of each Agent in the String.</p>
              <p>Commit your code to your local repository and assuming you are 
              using GitHub - push your changes to GitHub.</p>
              """);
//              <p></p>
//              <pre></pre>
//              <pre><code class="language-python"></code></pre>
        w.add("</div>");
    }
}
