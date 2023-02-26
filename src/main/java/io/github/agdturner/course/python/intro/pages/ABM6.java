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
 * For Python Intro Course ABM6 Page.
 *
 * @author Andy Turner
 */
public class ABM6 extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public ABM6(PythonIntroCourse c) {
        super("abm6", "Agent Based Model Part 6", "ABM6", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2 id="1">1. Introduction and Preparation</h2>
              <p>To get the agents communicating they need a way to refer to 
              each other. Those agents that are within a given distance are 
              going to share some resource.
              </p>
              <p>In your local code repository src directory create a new 
              directory called "abm6". Open Spyder and use "save as" to save 
              your "model.py" into this directory. Create a new directory called
              "my_modules" in abm6 and use "save as" to save your 
              "agentframework.py" and "io.py" files there.</p>
              
              <h2 id="2">2. Sharing</h2>
              <p>Each agent is going to share their store equally amongst all 
              agents within a given distance. The algorithm is as follows:</p>
              <pre># Calculate which other agents are within a given distance.
              # Calculate shares.
              # Distribute shares.</pre>
              <p>In order to share resources fairly (in that the order in which
              agents are processed is irrelevant), there is a need to 
              distinguish those resources to be shared with those that have been 
              shared.</p>               
              <p>Change the Agent contructor function to include the agents list 
              and add an attribute for storing the shares as follows:</p>
              <pre><code class="language-python">def __init__(self, agents, i, environment, nrows, ncols):
                  self.agents = agents
                  self.i = i
                  self.environment = environment
                  self.x = random.randint(0, 99)
                  self.y = random.randint(0, 99)
                  self.store = 0
                  self.store_shares = 0</code></pre>
              <p>Change model.py so that agents are initialised passing in the 
              reference to the agents list.</p>
              <p>Test your code works and that this provide access to another 
              agent by printing out another agent from an agent.</p>
              <p>In agentframework.py we are going to want to use the 
              get_distance function, and we want to avoid cyclic imports. Create 
              a new file called geometry.py in the my_modules directory, and 
              move the get_distance method from model.py to it. Add an 
              import statement for geometry in model.py and change where the 
              function is called by referring to the new module and by using the 
              dot operator. (In other words change "get_distance" to 
              "geometry.get_distance").</p>
              <p>Import the geometry module into agentframework and add the 
              following method:</p>
              <pre><code class="language-python">def share(self, neighbourhood):
                  # Create a list of agents in neighbourhood
                  neighbours = []
                  #print(self.agents[self.i])
                  for a in self.agents:
                      distance = geometry.get_distance(a.x, a.y, self.x, self.y)
                      if distance < neighbourhood:
                          neighbours.append(a.i)
                  # Calculate amount to share
                  n_neighbours = len(neighbours)
                  #print("n_neighbours", n_neighbours)
                  shares = self.store / n_neighbours
                  #print("shares", shares)
                  # Add shares to store_shares
                  for i in neighbours:
                      self.agents[i].store_shares += shares</code></pre>
              <p>This code is using the fact that self.i will be the same as the 
              index of an agent in the agents list. In the first For Loop the 
              distance between self and each agent in the agents lists 
              (including itself) is calculated and if this is less than the 
              neighbourhood paramter that is passed in, then the index of the 
              agent from the agents list is stored in the neighbours list. The 
              attribute self.store is than divided into shares and added to the 
              store_shares attribute of all neighbours.</p>
              <p>Replace the model loop in the model.py file with the following:
              </p>
              <pre><code class="language-python"># Model loop
              for ite in range(n_iterations):
                  print("Iteration", ite)
                  # Move agents
                  print("Move")
                  for i in range(n_agents):
                      agents[i].move(x_min, y_min, x_max, y_max)
                      agents[i].eat()
                      #print(agents[i])
                  # Share store
                  # Distribute shares
                  for i in range(n_agents):
                      agents[i].share(neighbourhood)
                  # Add store_shares to store and set store_shares back to zero
                  for i in range(n_agents):
                      print(agents[i])
                      agents[i].store = agents[i].store_shares
                      agents[i].store_shares = 0
                  print(agents)
                  # Print the maximum distance between all the agents
                  print("Maximum distance between all the agents", get_max_distance())
                  # Print the total amount of resource
                  sum_as = sum_agent_stores()
                  print("sum_agent_stores", sum_as)
                  sum_e = sum_environment()
                  print("sum_environment", sum_e)
                  print("total resource", (sum_as + sum_e))</code></pre>
              <p>Run model.py and try to interpret the output. Add in more print 
              statements and play around to gain a good understanding of how 
              the code works.</p>
              
              <h2 id="3">3. Coding Tasks</h2>
              <p>Create some more variable results by randomly setting the 
              store of each agent in initialisation to be a value between 0 and 
              100.</p>
              <p>Change the eat function so that if an agent store reaches 100, 
              then half the store is released back to the environment.</p>
              """);
//              <pre></pre>
//              <pre><code class="language-python"></code></pre>
//              <p></p>
//              <pre></pre>
        w.add("</div>");
    }
}
