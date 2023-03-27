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
        super("abm6", "Agent Based Model Practical 6", "ABM6", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        Section s;
        s = addSection("1", "Introduction and Preparation", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>To get agents communicating they need a way to refer to 
              each other. Those agents that are within a given distance are 
              going to share some resource.</p>
              <p>In your local code repository 'src' directory create a new 
              directory called 'abm6'. Open Spyder and use 'save as' to save 
              your 'model.py' into this directory. Create a new directory called
              'my_modules' in 'abm6' and use 'save as' to save your 
              'agentframework.py' and 'io.py' files there.</p>
              
              <h2 id="2">2. Sharing</h2>
              <p>Each agent is going to share their store equally amongst all 
              agents within a given distance. The algorithm is as follows:</p>
              <pre># Calculate which other agents are within a given distance.
              # Calculate shares.
              # Distribute shares.</pre>
              <p>In order to share resources so that the order in which agents 
              are processed is irrelevant, there is a need to distinguish those 
              resources to be shared with those that have been shared.</p>               
              <p>Change the Agent contructor function to include the agents list 
              and add an attribute for storing the shares as follows:</p>
              <pre><code class="language-python">def __init__(self, agents, i, environment, n_rows, n_cols):
                  \"""
                  The constructor method.

                  Parameters
                  ----------
                  agents : List
                      A list of Agent instances.
                  i : Integer
                      To be unique to each instance.
                  environment : List
                      A reference to a shared environment
                  n_rows : Integer
                      The number of rows in environment.
                  n_cols : Integer
                      The number of columns in environment.

                  Returns
                  -------
                  None.

                  \"""
                  self.agents = agents
                  self.i = i
                  self.environment = environment
                  tnc = int(n_cols / 3)
                  self.x = random.randint(tnc - 1, (2 * tnc) - 1)
                  tnr = int(n_rows / 3)    
                  self.y = random.randint(tnr - 1, (2 * tnr) - 1)                   
                  self.store = 0
                  self.store_shares = 0</code></pre>
              <p>Change 'model.py' so that 'agents' is passed as a parameter as 
              'agents' itself is initialised.</p>
              <p>Test your code works and that from one agent you can access 
              other agents by printing out one agent from another agent.</p>
              <p>The plan is to use the 'get_distance' function in 
              'agentframework.py' and avoid cyclic imports. One way to do this 
              is to abstract the 'get_distance' function to a new module. Create 
              a new file called 'geometry.py' in the 'my_modules' directory, and 
              move the 'get_distance' method from 'model.py' to it. Add an 
              import statement for the new geometry module in 'model.py' and 
              change the function call to look for the function in the new 
              geometry module by using the dot operator. (In other words change
              'get_distance' to 'geometry.get_distance').</p>
              <p>Import the geometry module into 'agentframework.py' and add the 
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
              <p>This code is using the fact that 'self.i' will be the same as 
              the index of an agent in the 'agents' list. In the first for loop
              of the 'share' function the distance between 'self' and each agent 
              in the agents list is calculated and if this is less than 
              'neighbourhood' (a parameter that is passed in), then the index of
              the agent from the agents list is stored in the 'neighbours' list. 
              The attribute 'self.store' is then divided into 'shares' and added 
              to the 'store_shares' attribute of all the agents with indexes in 
              'neighbours'.</p>
              <p>Replace the 'main simulation loop' in 'model.py' file with the 
              following:</p>
              <pre><code class="language-python"># Main simulation loop
              for ite in range(1, n_iterations + 1):
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
              <p>Run 'model.py' and interpret the output. Add more print
              statements to gain a clear understanding of how the code works.
              </p>
              
              <h2 id="3">3. Organise module code</h2>
              <p>Move all code in each 'my_modules' module that is not in 
              functions to be within if statement like the following 
              at the end of the file:</p>
              <pre><code class="language-python">if __name__ == '__main__':</code></pre>
              <p>Recall that this isolates this code so it is only run if that 
              file is the one run and not when the module is imported.</p>
              <p>Make sure to test that your code still produces the same 
              results.</p>
              
              <h2 id="4">4. Output images and generate an animated Gif</h2>
              <p>Add the following import statements to the 'model.py' placing 
              these with the other import statements as the first executable 
              statements in the code:</p>
              <pre><code class="language-python">import imageio
              import os</code></pre>
              <p>Before the main simulation loop add the following code:
              <pre><code class="language-python"># Create directory to write images to.
                  try:
                      os.makedirs('../../data/output/images/')
                  except FileExistsError:
                      print("path exists")
                  
                  # For storing images
                  global ite
                  ite = 1
                  images = []</code></pre>
              <p>Indent the plotting so that this occurs within the main 
              simulation loop and replace the following line:</p>
              <pre><code class="language-python">plot.show()</code></pre>
              <p>With:</p>
              <pre><code class="language-python">filename = '../../data/output/images/image' + str(ite) + '.png'
              #filename = '../../data/output/images/image' + str(ite) + '.gif'
              plt.savefig(filename)
              plt.show()
              plt.close()
              images.append(imageio.imread(filename))</code></pre>
              <p>This code should: create plots; save these as images in PNG 
              format files; show and close them rapidly; then reload the PNG 
              format file and append the image to the images list.</p>
              <p>After the end of the main simulation loop the images can be 
              turned into an animated GIF format file using the following:</p>
              <pre><code class="language-python">imageio.mimsave('../../data/output/out.gif', images, fps=3)</code></pre>
              <p>The parameter 'fps' is the number of frames that are shown per 
              second.</p>
              <p>Once you have this working. Commit your code to your local 
              repository and assuming you are using GitHub - push your changes 
              to GitHub.</p>
              
              <h2 id="5">5. Further Assignment 1 Coding Tasks</h2>
              <p>Create some more variable results by randomly setting the 
              'store' of each agent in initialisation to be a value in the range
              [0, 99].</p>
              <p>Change the 'eat' function so that if an agent 'store' goes 
              above 99, then half the store is added to 'environment' where the 
              agent is located.</p>
              <p>Commit your code to your local repository and assuming you 
              are using GitHub - push your changes to GitHub.</p>
              """);
        w.add("</div>");
    }
}
