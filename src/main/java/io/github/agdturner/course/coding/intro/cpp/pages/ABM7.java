/*
 * Copyright 2024 University of Leeds.
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
package io.github.agdturner.course.coding.intro.cpp.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.coding.intro.cpp.CPPIntroCodingCourse;
import io.github.agdturner.course.CoursePage;

/**
 * For CPP Intro Course ABM7 Page.
 *
 * @author Andy Turner
 */
public class ABM7 extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public ABM7(CPPIntroCodingCourse course) {
        super(course, "abm7", "Agent Based Model Practical 7", "ABM7");
    }
    
    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction and Preparation", sb);
        w.addP(sb,
                """
                In this practical
                <a href="https://matplotlib.org/stable/api/_as_gen/matplotlib.animation.FuncAnimation.html">
                matplotlib.animation.FuncAnimation</a>
                will be used to animate the model in a separate window. Some
                stopping conditions will be added to halt the model and exit.
                """);
        w.addP(sb,
                """
                In your local code repository 'src' directory duplicate your
                'abm6' directory and name it 'abm7'.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Animation", sb);
        w.addP(sb,
                """
                Open the new 'model.py' file from the 'abm7' directory in
                Spyder.
                """);
        w.addP(sb, "Add the following import statement:");
        addCodeBlock(sb, "import matplotlib.animation as anim");
        w.addP(sb,
                "After initialising agents add the following code block:");
        addCodeBlock(sb,
                """
                # Animate
                # Initialise fig and carry_on
                fig = matplotlib.pyplot.figure(figsize=(7, 7))
                ax = fig.add_axes([0, 0, 1, 1])
                carry_on = True
                data_written = False
                animation = anim.FuncAnimation(fig, update, init_func=plot, frames=gen_function, repeat=False)
                """);
        w.addP(sb,
                """
                Define a new function called 'plot' to contain the 'Plot agents'
                code. Add a line to clear fig at the start of the function and
                specify 'ite' as a global variable before it is used:
                """);
        addCodeBlock(sb,
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
        w.addP(sb,
                """
                Change the 'main simulation loop' code block into a function
                called 'update' that has a parameter called 'frames'. At the end
                of this call the 'plot' function. Specify 'carry_on' as a global
                variable and add a random stopping condition as follows:
                """);
        addCodeBlock(sb,
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
        w.addP(sb, "Define a function called 'gen_function' as follows:");
        addCodeBlock(sb,
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
        w.addP(sb,
                """
                Before running the code, issue the following magic command in
                the Spyder console so that rather than the plot being directed
                to the plots pane (where") animation does not work), it is
                 directed to a pop-up window:
                """);
        w.addPRE(sb, "%matplotlib qt");
        w.addP(sb,
                """
                If you want to revert this change so that plots are added to the
                 plot plane again issue the following magic command:
                """);
        w.addPRE(sb, "%matplotlib inline");
        w.addPST(sb, "The keyword '");
        sb.append(index.getReference("Python yield", "yield", sid));
        w.addPET(sb,
                """
                ' is used to pass the value of the variable 'ite' back from
                'gen_function' whilst continuing to run the while loop. The
                '# Write data' code block is included in 'gen_function' and runs
                 only once after the model has stopped.
                """);
        addCommitToGitHub(sb);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Code and Model Review", sb);
        w.addP(sb,
                """
                Most of your code should now be in functions and organised into
                modules.
                """);
        w.addP(sb,
                """
                The model simulation runs in a loop until some condition is
                reached, or until a predefined number of iterations
                'n_iterations' is reached.
                """);
        w.addP(sb,
                """
                As yet, the model cannot be re-started. Some data is written to
                file that could be used to restart the model, but this is
                incomplete/insufficient. The ability to be able to stop and
                restart a model can be useful. This is known as 'check
                pointing'. It is often good to be able to run a simulation model
                for 'n' iterations and then run for a further 'm' iterations,
                and for this to produce the same results as for a run of 'm + n'
                iterations. The 'random.getstate()' and 'random.setstate(state)'
                methods can be used to store the state of 'random' to get this
                to work.
                """);
        w.addP(sb,
                """
                The simple agents in the model are not learning or adapting
                their behaviour based on interaction or the state of the
                environment. The model is mostly random, so observing complex,
                adaptive/emergent behaviour from this model should not be
                expected.
                """);
        w.addP(sb,
                """
                Whilst the model has been framed as an ecological model, the
                agents could represent other things, they don't necessarily have
                to communicate by sharing resources, they could share something
                else, and they don't have to 'eat' the environment.
                """);
        w.addP(sb,
                "Some ideas for a more realistic ecological model are:");
        w.addULST(sb);
        w.addLI(sb, 
                """
                To have less resource that can be eaten by the agents, and
                model this resource as vegetation that grows.
                """);
        w.addLI(sb, "Make movement cost some amount of store.");
        w.addLI(sb, 
                """
                Have those agents that are successful at finding resources
                replicate and those unsuccessful die.
                """);
        w.addLI(sb, 
                """
                Include predator agents that hunt/eat the other agents as prey.
                """);
        w.addULET(sb);
        w.addDIVET(sb);
        return sb.toString();
    }
}
