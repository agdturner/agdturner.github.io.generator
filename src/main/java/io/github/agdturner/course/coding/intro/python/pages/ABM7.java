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
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.course.CoursePage;

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
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction and Preparation", sb);
        sb.append(
                """
                <p>In this practical
                <a href="https://matplotlib.org/stable/api/_as_gen/matplotlib.animation.FuncAnimation.html">
                matplotlib.animation.FuncAnimation</a>
                will be used to animate the model in a separate window. Some
                stopping conditions will be added to halt the model and exit.
                </p>
                """);
        sb.append("<p>In your local code repository 'src' directory duplicate ")
                .append(" your 'abm6' directory and name it 'abm7'.</p>");

        sid = addSection("Animation", sb);
        sb.append("<p>Open the new 'model.py' file from the 'abm7' directory")
                .append(" in  Spyder.</p>");
        sb.append("<p>Add the following import statement:</p>");
        addPythonCodeBlock(sb,
                """
                import matplotlib.animation as anim
                """);
        sb.append("<p>After initialising agents add the following code block:")
                .append("</p>");
        addPythonCodeBlock(sb,
                """
                # Animate
                # Initialise fig and carry_on
                fig = matplotlib.pyplot.figure(figsize=(7, 7))
                ax = fig.add_axes([0, 0, 1, 1])
                carry_on = True
                data_written = False
                animation = anim.FuncAnimation(fig, update, init_func=plot, frames=gen_function, repeat=False)
                """);
        sb.append("<p>Define a new function called 'plot' to contain the")
                .append(" 'Plot agents' code. Add a line to clear fig at the")
                .append(" start of the function and specify 'ite' as a global")
                .append(" variable before it is used:</p>");
        addPythonCodeBlock(sb,
                """
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
                plt.show()
                """);
        sb.append("<p>Change the 'main simulation loop' code block into a")
                .append(" function called 'update' that has a parameter called")
                .append(" 'frames'. At the end of this call the 'plot'")
                .append(" function. Specify 'carry_on' as a global variable")
                .append(" and add a random stopping condition as follows:</p>");
        addPythonCodeBlock(sb,
                """
                def update(frames):
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
                    plot()
                """);
        sb.append("<p>Define a function called 'gen_function' as follows:</p>");
        addPythonCodeBlock(sb,
                """
                def gen_function():
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
                        data_written = True
                """);
        sb.append("<p>Before running the code, issue the following magic")
                .append(" command in the Spyder console so that rather than")
                .append(" the plot being directed to the plots pane (where")
                .append(" animation does not work), it is directed to a pop-up")
                .append(" window:</p>");
        sb.append("<pre>%matplotlib qt</pre>");
        sb.append("<p>If you want to revert this change so that plots are")
                .append(" added to the plot plane again issue the following")
                .append(" magic command:</p>");
        sb.append("<pre>%matplotlib inline</pre>");
        sb.append("<p>The keyword '")
                .append(index.getReference("Python yield", "yield", sid))
                .append("' is used to pass the value of the variable 'ite'")
                .append(" back from 'gen_function' whilst continuing to run")
                .append(" the while loop. The '# Write data' code block is")
                .append(" included in 'gen_function' and runs only once after")
                .append(" the model has stopped.</p>");
        addParagraphCommitToGitHub(sb);

        sid = addSection("Code and Model Review", sb);
        sb.append("<p>Most of your code should now be in functions and")
                .append(" organised intomodules.</p>");
        sb.append("<p>The model simulation runs in a loop until some condition")
                .append(" is reached, or until a predefined number of")
                .append(" iterations 'n_iterations' is reached.</p>");
        sb.append("<p>As yet, the model cannot be re-started. Some data is")
                .append(" written to file that could be used to restart the")
                .append(" model, but this is incomplete/insufficient. The")
                .append(" ability to be able to stop and restart a model can")
                .append(" be useful. This is known as 'check pointing'. It is")
                .append(" often good to be able to run a simulation model for")
                .append(" 'n' iterations and then run for a further 'm'")
                .append(" iterations, and for this to produce the same results")
                .append(" as for a run of 'm + n' iterations. The")
                .append(" 'random.getstate()' and 'random.setstate(state)'")
                .append(" methods can be used to store the state of 'random'")
                .append(" to get this to work.</p>");
        sb.append("<p>The simple agents in the model are not learning or")
                .append(" adapting their behaviour based on interaction or the")
                .append(" state of the environment. The model is mostly")
                .append(" random, so observing complex, adaptive/emergent")
                .append(" behaviour from this model should not be expected.")
                .append("</p>");
        sb.append("<p>Whilst the model has been framed as an ecological model,")
                .append(" the agents could represent other things, they don't")
                .append(" necessarily have to communicate by sharing")
                .append(" resources, they could share something else, and they")
                .append(" don't have to 'eat' the environment.</p>");
        sb.append("<p>Some ideas for a more realistic ecological model are:")
                .append("</p>");
        sb.append(
                """
                <ul>
                    <li>To have less resource that can be eaten by the agents, and
                    model this resource as vegetation that grows.</li>
                    <li>Make movement cost some amount of store.</li>
                    <li>Have those agents that are successful at finding resources
                    replicate and those unsuccessful die.</li>
                    <li>Include predator agents that hunt/eat the other agents as
                    prey.</li>
                </ul>
                """);
        return sb.toString();
    }
}
