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
 * For Python Intro Course ABM7 Page.
 *
 * @author Andy Turner
 */
public class ABM7 extends Page {
    
    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public ABM7(PythonIntroCourse c) {
        super("abm7", "Agent Based Model Part 7", "ABM7", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2 id="1">1. Introduction and Preparation</h2>
              <p>In this practical we make use of matplotlibs FuncAnimation to
              animate the model in a separate window. Also, some stopping 
              conditions will be added to halt the model and exit.</p>
              <p>In your local code repository src directory duplicate your abm6
              directory and call the new directory "abm7".</p>
              
              <h2 id="2">2. Animation</h2>
              <p>Open the new model.py file from the abm7 directory in 
              Spyder.</p>
              <p>A matplotlib animation requires us to have a figure that is
              cleared and redrawn, and to make use of the animation module. Add 
              the following import statement:</p>
              <pre><code class="language-python">import matplotlib.animation as anim</code></pre>
              <p>After initialising agents add the following code block:</p>
              <pre><code class="language-python"># Animate
              # Initialise fig and carry_on
              fig = matplotlib.pyplot.figure(figsize=(7, 7))
              ax = fig.add_axes([0, 0, 1, 1])
              carry_on = True
              data_written = False
              animation = anim.FuncAnimation(fig, update, init_func=plot, frames=gen_function, repeat=False)</code></pre>
              <p>Change the plotting code block into a function plot() 
              defined where the other functions are defined. Add a line to clear 
              fig at the start of the function and at the end of the function 
              return fig. Rather than pass ite into the function set it as a 
              global variable. The following is what is wanted:</p>
              <pre><code class="language-python">def plot():
              fig.clear()
              plt.ylim(y_min, y_max)
              plt.xlim(x_min, x_max)
              plt.imshow(environment)
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
              global ite
              filename = '../../data/output/images/image' + str(ite) + '.png'
              plt.savefig(filename)
              images.append(imageio.imread(filename))
              plt.show
              return fig</code></pre>
              <p>Change the model loop code block into a function called update
              that has a parameter called frames. At the end of this call the 
              function plot(). Set the variables carry_on and ite as global 
              variables and add a random stopping condition as follows:</p>
              <pre><code class="language-python">def update(frames):
                  # Model loop
                  global carry_on
                  #for ite in range(1, n_iterations + 1):
                  print("Iteration", frames)
                  # Move agents
                  print("Move and eat")
                  for i in range(n_agents):
                      agents[i].move(x_min, y_min, x_max, y_max)
                      agents[i].eat()
                      #print(agents[i])
                  # Share store
                  print("Share")
                  # Distribute shares
                  for i in range(n_agents):
                      agents[i].share(neighbourhood)
                  # Add store_shares to store and set store_shares back to zero
                  for i in range(n_agents):
                      #print(agents[i])
                      agents[i].store = agents[i].store_shares
                      agents[i].store_shares = 0
                  #print(agents)
                  # Print the maximum distance between all the agents
                  print("Maximum distance between all the agents", get_max_distance())
                  # Print the total amount of resource
                  sum_as = sum_agent_stores()
                  print("sum_agent_stores", sum_as)
                  sum_e = sum_environment()
                  print("sum_environment", sum_e)
                  print("total resource", (sum_as + sum_e))

                  # Stopping condition    
                  # Random
                  if random.random() < 0.1:
                      #if sum_as / n_agents > 80:
                      carry_on = False
                      print("stopping condition")
              
                  # Plot
                  plot()</code></pre>
              <p>Define a function gen_function() as follows:</p>
              <pre><code class="language-python">def gen_function():
                  global ite
                  global carry_on #Not actually needed as we're not assigning, but clearer
                  while (ite <= n_iterations) & (carry_on) :
                      yield ite # Returns control and waits next call.
                      ite = ite + 1
                  global data_written
                  if data_written == False:
                      # Write data
                      print("write data")
                      io.write_data('../../data/output/out7.txt', environment)
                      imageio.mimsave('../../data/output/out7.gif', images, fps=3)
                      data_written = True</code></pre>
              <p>Before running the code, issue the following magic command in 
              the console of Spyder so that rather than the plot being directed 
              to the plots pane (where animation does not work), it is directed 
              to a pop-up window:</p>
              <pre>%matplotlib qt</pre>
              <p>If you want to revert this change so that plots are added to 
              the plot plane again issue the following magic command:</p>
              <pre>%matplotlib inline</pre>
              <p>The keyword 'yield' is used to pass the value of the 
              variable "ite" back from the function gen_function whilst 
              continuing to run the while loop in it. The "# Write data" code 
              block is included in gen_function and runs only once after the 
              model has stopped.</p>
              <p>Commit your code to your local repository and assuming you 
              are using GitHub - push your changes to GitHub.</p>
              
              <h2 id="3">3. Code and Model Review</h2>
              <p>Nearly all our code is now in functions and organised into 
              modules.</p>
              <p>The essence of a Spatial Agent Based Model is now working. 
              Typically such models either run in a loop until some condition is 
              reached, or for a predefined number of iterations. At the moment 
              'n_iterations' is the maximum number of iterations the model will 
              run for, but there is a stopping condition that is likely to occur 
              randomly before this is reached if 'n_iterations' is set to 10
              or more.</p>
              <p>As yet, the model cannot be re-started. Although some 
              information is written to file that could be used to restart the 
              model, this is incomplete/insufficient. The ability to be able to 
              stop and restart a model can be useful and is often called 'check 
              pointing'. For reproducibility, so that a run of 'n' iterations 
              followed by a further 'm' iterations would produce the same results 
              as a run of 'm + n' iterations, the 'random.getstate()' and 
              'random.setstate(state)' methods could be used to checkpoint 
              random.</p>
              <p>The simple agents in the model are not learning or adapting 
              their behaviour based on interaction or the state of the 
              environment. The model is mostly random, so observing complex, 
              adaptive/emergent behaviour from this model should not be 
              expected.</p>
              <p>Whilst the model has been framed as an ecological model, the 
              agents could represent other things, they don't necessarily have 
              to communicate by sharing resources, they could share something 
              else, and they don't have to 'eat' the environment.</p>
              <p>Some things that should make the model a more realistic 
              ecological model are:</p>
              <ul>
              <li>To have less resource that can be eaten by the agents, and 
              model this resource as vegetation that grows.</li>
              <li>Have movement cost energy/store and for this to relate to how 
              much store an agent has and a varying cost of movement based on 
              the environment terrain. Grazing agents may then 'favour' 
              movement that looks to be worth the effort.</li>
              <li>Have those agents that are successful at finding resources get 
              stronger/more able to move and replicate and those unsuccessful 
              get weaker/less able and die.</li>
              <li>Include predator agents that hunt/eat the other agents as
              prey. A lot of complication can be added with this as predators 
              might work collectively to hunt and prey may behave collectively 
              for safety. Predators might have advantage in some types of places
              and prey may learn this and stay away from those places.</li>
              </ul>
              
              <h2 id="4">4. Further Assignment 1 Coding Task</h2>
              <p>Alter the stopping condition so that the model stops when the
              average agent store is greater than 80.</p>
              <p>Commit your code to your local repository and assuming you 
              are using GitHub - push your changes to GitHub.</p>
              """);
        w.add("</div>");
    }
}
