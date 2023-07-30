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
package io.github.agdturner.course.coding.intro.python.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.course.CoursePage;
import io.github.agdturner.course.Index;

/**
 * For Python Intro Course ABM7 Page.
 *
 * @author Andy Turner
 */
public class ABM7 extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public ABM7(PythonIntroCodingCourse course) {
        super(course, "abm7", "Agent Based Model Practical 7", "ABM7");
    }

    @Override
    public void write() {
        Course course = getCourse();
        Index index = course.getIndex();
        writeHeader();
        writeH1();
        SectionID sid = addSection("1", "Introduction and Preparation", 2);
        w.add("""
              <p>In this practical 
              <a href="https://matplotlib.org/stable/api/_as_gen/matplotlib.animation.FuncAnimation.html">
              matplotlib.animation.FuncAnimation</a>
              will be used to animate the model in a separate window. Some 
              stopping conditions will be added to halt the model and exit.</p>
              <p>In your local code repository 'src' directory duplicate your 
              'abm6' directory and call the new directory 'abm7'.</p>
              """);

        sid = addSection("2", "Animation", 2);
        w.add("""
              <p>Open the new 'model.py' file from the 'abm7' directory in 
              Spyder.</p>
              <p>Add the following import statement:</p>
              <pre><code class="language-python">import matplotlib.animation as anim</code></pre>
              <p>After initialising agents add the following code block:</p>
              <pre><code class="language-python"># Animate
              # Initialise fig and carry_on
              fig = matplotlib.pyplot.figure(figsize=(7, 7))
              ax = fig.add_axes([0, 0, 1, 1])
              carry_on = True
              data_written = False
              animation = anim.FuncAnimation(fig, update, init_func=plot, frames=gen_function, repeat=False)</code></pre>
              <p>Define a new function called 'plot' to contain the 'Plot 
              agents' code. Add a line to clear fig at the start of the function 
              and specify 'ite' as a global variable before it is used:</p>
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
              plt.show()</code></pre>
              <p>Change the 'main simulation loop' code block into a function 
              called 'update' that has a parameter called 'frames'. At the end 
              of this call the 'plot' function. Specify 'carry_on' as a global 
              variable and add a random stopping condition as follows:</p>
              <pre><code class="language-python">def update(frames):
                  # Model loop
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
                  global carry_on
                  # Random
                  if random.random() < 0.1:
                      #if sum_as / n_agents > 80:
                      carry_on = False
                      print("stopping condition")
              
                  # Plot
                  plot()</code></pre>
              <p>Define a function called 'gen_function' as follows:</p>
              <pre><code class="language-python">def gen_function():
                  global ite
                  global carry_on
                  while (ite <= n_iterations) & (carry_on) :
                      yield ite # Returns control and waits next call.
                      ite = ite + 1
                  global data_written
                  if data_written == False:
                      # Write data
                      print("write data")
                      io.write_data('../../data/output/out.txt', environment)
                      imageio.mimsave('../../data/output/out.gif', images, fps=3)
                      data_written = True</code></pre>
              <p>Before running the code, issue the following magic command in 
              the Spyder console so that rather than the plot being directed 
              to the plots pane (where animation does not work), it is directed 
              to a pop-up window:</p>
              <pre>%matplotlib qt</pre>
              <p>If you want to revert this change so that plots are added to 
              the plot plane again issue the following magic command:</p>
              <pre>%matplotlib inline</pre>
              """);
        w.add("<p>The keyword '"
                + index.getReference("Python yield", "yield", sid)
                + "' is used to pass the value of the variable 'ite' back from"
                + " 'gen_function' whilst continuing to run the while loop. The"
                + " '# Write data' code block is included in 'gen_function' and"
                + " runs only once after the model has stopped.</p>");
        w.add("""
              <p>Commit your code to your local repository and assuming you 
              are using GitHub - push your changes to GitHub.</p>
              """);

        sid = addSection("3", "Code and Model Review", 2);
        w.add("""
              <p>Most of your code should now be in functions and organised into 
              modules.</p>
              <p>The model simulation runs in a loop until some condition is 
              reached, or until a predefined number of iterations 'n_iterations' 
              is reached.</p>
              <p>As yet, the model cannot be re-started. Some data is written to 
              file that could be used to restart the model, but this is 
              incomplete/insufficient. The ability to be able to stop and 
              restart a model can be useful and is often called 'check 
              pointing'. It would be good if the model could be run for 'n' 
              iterations and then run for a further 'm' iterations and for this 
              to produce the same results as a run of 'm + n' iterations. The 
              'random.getstate()' and 'random.setstate(state)' methods could be 
              used to checkpoint random to help get this to work.</p>
              <p>The simple agents in the model are not learning or adapting 
              their behaviour based on interaction or the state of the 
              environment. The model is mostly random, so observing complex, 
              adaptive/emergent behaviour from this model should not be 
              expected.</p>
              <p>Whilst the model has been framed as an ecological model, the 
              agents could represent other things, they don't necessarily have 
              to communicate by sharing resources, they could share something 
              else, and they don't have to 'eat' the environment.</p>
              <p>Some ideas for a more realistic ecological model are:</p>
              <ul>
              <li>To have less resource that can be eaten by the agents, and 
              model this resource as vegetation that grows.</li>
              <li>Make movement cost some amount of store.</li>
              <li>Have those agents that are successful at finding resources 
              replicate and those unsuccessful die.</li>
              <li>Include predator agents that hunt/eat the other agents as
              prey.</li>
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
