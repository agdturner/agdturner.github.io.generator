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
              <p>This practical is about animating the model and incorporating 
              some stopping conditions to halt the model and exit.</p>
              <p>In your local code repository src directory duplicate your abm6
              directory and call the new directory "abm7".</p>
              
              <h2 id="2">2. Animation</h2>
              <p>Open the new model.py file from the abm7 directory in 
              Spyder.</p>
              <p>A matplotlib animation requires us to have a figure that is
              cleared and redrawn, and to make use of the animation module. Add 
              the following import statement:</p>
              <pre><code class=\"language-python\">from matplotlib import animation as anim</code></pre>
              <p>After initialising agents add the following code block:</p>
              <pre><code class=\"language-python\"># Initialise fig and carry_on
              fig = matplotlib.pyplot.figure(figsize=(7, 7))
              ax = fig.add_axes([0, 0, 1, 1])
              carry_on = True</code></pre>
              <p>Change the plotting code block into a function and move the 
              code to where the other functions are defined. Add a line to clear 
              fig at the start of the function and at the end of the function 
              return fig. Leave the plt.show() command at the end of the code:
              </p>
              <pre><code class=\"language-python\">def plot():
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
                  return fig</code></pre>
              <p>Change the model loop code block into a function called update
              that has a parameter called frames. At the end of this call the 
              plot function. Declare the carry_on global function and add a 
              random stopping condition:</p>
              <pre><code class=\"language-python\">def update(frames):
                  # Model loop
                  global carry_on
                  #for ite in range(n_iterations):
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
                  if random.random() < 0.1:
                      #if sum_as / n_agents > 80:
                      carry_on = False
                      print("stopping condition")
                  
                  # Plot
                  plot()</code></pre>
              <p>Define a function called gen_function and create the animation 
              using the following:</p>
              <pre><code class=\"language-python\">def gen_function():
                  a = 0
                  while (a < n_iterations) & (carry_on) :
                      yield a			# Returns control and waits next call.
                      a = a + 1
                  # Write data
                  print("write data")
                  io.write_data('../../data/output/out.txt', environment)
                  
              animation = anim.FuncAnimation(fig, update, init_func=plot, frames=gen_function, repeat=False)
              plt.show()</code></pre>
              <p>Before running the code, issue the following magic command in 
              the console of Spyder so that rather than the plot being directed 
              to the plots pane (where animation does not work), it is directed 
              to a pop-up window:</p>
              <pre>%matplotlib qt</pre>
              <p>If you want to revert this change so that plots are added to 
              the plot plane again issue the following magic command:</p>
              <pre>%matplotlib inline</pre>
              <p>The Keyword Yield (yield) is used to pass the value of the 
              variable "a" back from the function gen_function whilst continuing 
              to run the while loop in it. The "# Write data" code block is 
              included in gen_function and runs only once carry_on is equal to 
              False.</p>
              
              <h2 id="3">3. Code and Model Review</h2>
              <p>Nearly all our code is now in functions and organised into 
              modules.</p>
              <p>The essence of a Spatial Agent Based Model is now working. 
              Typically such models either run in a loop until some condition is 
              reached, or for a predefined number of iterations. At the moment 
              n_iterations is the maximum number of iterations the model will 
              run for, but there is a stopping condition that is likely to occur 
              randomly before this is reached if the n_iterations is set to 10
              or more.</p>
              <p>As yet, the model cannot be re-started. Although some 
              information is written to file that could be used to restart the 
              model, this is incomplete/insufficient. The ability to be able to 
              stop and restart a model can be useful and is often called check 
              pointing. For reproducibility, so that a run of n iterations 
              followed by a further m iterations would produce the same results 
              as a run of m + n iterations, it would be sensible to make use of 
              the random.getstate() and random.setstate(state) methods.</p>
              <p>The simple agents in the model are not learning or adapting 
              their behaviour based on interaction or the state of the 
              environment. So, it is more random than anything else, and 
              observing complex, adaptive/emergent behaviour from this model 
              should not be expected.</p>
              <p>Whilst the model has been framed as an ecological model, the 
              agents could represent other things, they don't necessarily have 
              to communicate by sharing resources, they could share something 
              else, and they don't have to eat the environment.</p>
              <p>Developing a more sophisticated model could be fun and the 
              practise could help develop your programming skills.</p>
              <p>Some things that might make the model more realistic are:</p>
              <ul>
              <li>To have less resource in the environment that can be eaten 
              by the agents, and model this resource as vegetation that 
              grows.</li>
              <li>Have those agents that are successful at finding resources get 
              stronger/more able and replicating and those unsuccessful get 
              weaker/less able and dying.</li>
              <li>Dependency relationships could be modelled.</li>
              <li>Different types of agent could be incorporated. The next step 
              for a more natural ecological model is to introduce a predator.
              </li>
              </ul>
              
              <h2 id="4">4. Coding Tasks</h2>
              <p>Complete the following tasks for your portfolio.</p>
              <p>Write docstrings and comments in your code to help clarify what 
              it is doing.</p>
              <p>Alter the stopping condition so that the model stops when the
              average agent store is greater than 80.</p>
              <p>To output animations in the
              <a href="https://en.wikipedia.org/wiki/GIF">GIF image format</a>,
              add the following import statement:
              <pre><code class=\"language-python\">from matplotlib.animation import PillowWriter</code></pre>
              <p>And add the following code after the plt.show() line:</p>
              <pre><code class=\"language-python\"># Write out the animation as a GIF
              animation.save('../../data/output/out.gif', writer=PillowWriter(fps=3))
              </code></pre>
              <p>The fps argument is the number of frames per second.</p>
              <p>Note that in writing out the animation as a GIF, the other
              output seems to be written out twice. Write some code to ensure 
              the text output is only written once. (Hint: declare and use 
              another global boolean variable.)</p>
              <p>For your portfolio, attempt one of the following:</p>
              <ul>
              <li>Include preditor agents.<li>
              <li>Model agent breeding.</li>
              <li>Initialise the environment with fewer resources that may 
              gradually accumulate as well as being eaten.</li>
              </ul>
              """);
//              <pre></pre>
//              <pre><code class=\"language-python\"></code></pre>
//              <p></p>
//              <pre></pre>
        w.add("</div>");
    }
}
