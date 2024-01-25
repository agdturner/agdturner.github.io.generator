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
 * For Python Intro Course ABM2 Page.
 *
 * @author Andy Turner
 */
public class ABM2 extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public ABM2(PythonIntroCodingCourse course) {
        super(course, "abm2", "Agent Based Model Practical 2", "ABM2");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Recap and preparation", sb);
        w.addP(sb,
                "Your ABM1 'model.py' code should look something like:");
        addCodeBlock(sb,
                """
                import random
                import math

                # Set the pseudo-random seed for reproducibility
                random.seed(0)

                # Initialise variable x0
                x0 = random.randint(0, 99)
                print("x0", x0)
                # Initialise variable y0
                y0 = random.randint(0, 99)
                print("y0", y0)

                # Change x0 and y0 randomly
                rn = random.random()
                print("rn", rn)
                if rn < 0.5:
                    x0 = x0 + 1
                else:
                    x0 = x0 - 1
                print("x0", x0)
                rn = random.random()
                print("rn", rn)
                if rn < 0.5:
                    y0 = y0 + 1
                else:
                    y0 = y0 - 1
                print("y0", y0)

                # Initialise variable x1
                x1 = random.randint(0, 99)
                print("x1", x1)
                # Initialise variable y1
                y1 = random.randint(0, 99)
                print("y1", y1)

                # Change x1 and y1 randomly
                rn = random.random()
                print("rn", rn)
                if rn < 0.5:
                    x1 = x1 + 1
                else:
                    x1 = x1 - 1
                print("x1", x1)
                rn = random.random()
                print("rn", rn)
                if rn < 0.5:
                    y1 = y1 + 1
                else:
                    y1 = y1 - 1
                print("y1", y1)

                # Calculate the Euclidean distance between (x0, y0) and (x1, y1)
                # Set x0 and y0 to equal 0, x1 to equal 3, and y1 to equal 4
                x0 = 0
                y0 = 0
                x1 = 3
                y1 = 4
                # Calculate the difference in the x coordinates.
                dx = x0 - x1
                # Calculate the difference in the y coordinates.
                dy = y0 - y1
                # Square the differences and add the squares
                ssd = (dx * dx) + (dy * dy)
                print("ssd", ssd)
                # Calculate the square root
                distance = ssd ** 0.5
                print("distance", distance)
                distance = math.sqrt(ssd)
                print("distance", distance)
                """);
        w.addP(sb,
                "Running the code should produce the following text output:");
        w.addPRE(sb,
                """
                x0 49
                y0 97
                rn 0.890243920837131
                x0 48
                rn 0.04048437818077755
                y0 98
                x1 65
                y1 62
                rn 0.4049341374504143
                x1 66
                rn 0.7837985890347726
                y1 61
                ssd 25
                distance 5.0
                distance 5.0
                """);
        w.addP(sb,
                """
                In your local code repository src directory create a new
                directory called 'abm2'. Open Spyder and save 'model.py' into
                the 'abm2' directory.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Using Lists", sb);
        w.addPST(sb,
                """
                Rather than handle coordinates for each agent individually, the
                coordinates for each agent will be stored in
                """);
        sb.append(index.getReference("Python list", "lists", sid));
        w.addPET(sb,
                """
                 of length 2, with the first item being an 'x' coordinate, and
                the second item being a 'y' coordinate. All agents are also
                going to be stored in a list.
                """);
        w.addPST(sb,
                """
                The code is also going to be reorganised so that the agents are
                created in a
                """);
        sb.append(index.getReference("Python for", "for loop", sid));
        w.addPET(sb,
                """
                , and there will be a second for loop to adjust the coordinates
                (move the agents).
                """);
        w.addP(sb,
                """
                Towards the top of the file (below the import statements and
                setting of the random seed) add the following to create a new
                empty list called 'agents':
                """);
        addCodeBlock(sb,
                """
                # Create a list to store agents
                agents = []
                """);
        w.addP(sb,
                """
                Next, add coordinates to this list: First add one pair after
                initialising 'y0' and 'x0', by adding the following:
                """);
        addCodeBlock(sb,
                "agents.append([x0,y0]) # Append to the list agents");
        w.addP(sb,
                """
                Note that '[x0,y0]' creates a list containing 'x0' and 'y0', and
                the 'append' function adds this list to the agents list. After
                doing this, 'agents[0][0]' is the 'x' coordinate of the first
                agent in the agents list and 'agents[0][1]' is the 'y'
                coordinate of the first agent in the agents list.
                """);
        w.addP(sb,
                """
                Go through and replace all the other uses of 'x0' with indexed
                list references, i.e. 'agents[0][0]' and 'y0' with
                'agents[0][1]' (uses - not the initial assignments). Check your
                code still runs.
                """);
        w.addP(sb,
                """
                The code that creates the first agent and adds this to the
                agents list should be as follows:
                """);
        addCodeBlock(sb,
                """
                # Initialise variable x0
                x0 = random.randint(0, 99)
                print("x0", x0)
                # Initialise variable y0
                y0 = random.randint(0, 99)
                print("y0", y0)
                agents.append([x0, y0])
                """);
        w.addP(sb,
                """
                Note that the variables 'x0' and 'y0' are only created for this
                initialisation. Can you think of a way to reduce this code and
                do the initialition more succinctly?
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Plotting", sb);
        w.addPST(sb, "To plot the agents using ");
        sb.append(references.getReference("Matplotlib"));
        w.addPET(sb, " add the following import statements:");
        addCodeBlock(sb,
                """
                import matplotlib.pyplot as plt
                import operator
                """);
        w.addP(sb,
                "And adding the following code to the end of 'model.py':");
        addCodeBlock(sb,
                """
                # Plot the agents
                plt.scatter(agents[0][0], agents[0][1], color='black')
                plt.scatter(agents[1][0], agents[1][1], color='black')
                plt.show()
                # Get the coordinates with the largest x-coordinate
                print(max(agents, key=operator.itemgetter(0)))
                """);
        w.addP(sb,
                """
                Run 'model.py' and you should see an image output in the
                'Plots' pane of Spyder. The image should contain two points.
                """);
        w.addP(sb,
                """
                Have a look at
                <a href="https://matplotlib.org/stable/api/pyplot_summary.html">
                the matplotlib pyplot documentation</a>
                """);
        w.addP(sb,
                """
                After the code that plots the points black, plot the point with
                the largest x coordinate red. One way to do this is to store
                those coordinates in a variable and then pass the x-coordinate
                and y-coordinate as arguments to the command aliased as 'plt'
                before the 'show()' command.
                """);
        w.addP(sb,
                "Have a try and don't worry if you don't get this to work.");
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Using Loops", sb);
        w.addP(sb,
                """
                This section guides you through restructuring your code so that
                agent initialisation (for all agents) happens first, and moving
                (for all agents) happens second. There will be loops for each of
                these things and for plotting all the agents.
                """);
        w.addP(sb,
                """
                To prepare yourself, review your code. In doing so, it might
                help to insert some blank lines to separate different parts of
                it, and to add more comments to help you understand what it is
                doing.
                """);
        addCommitToGitHub(sb);
        w.addP(sb,
                """
                Comment out the code for initialising and changing the
                coordinates of the second agent. After the line of code that
                initialises the agent list, add a variable called 'n_agents' and
                set this equal to '10'. Then create a
                """);
        sb.append(index.getReference("Python for", "for loop", sid));
        w.addP(sb, " that uses n_agents to create 10 agents as follows:");
        addCodeBlock(sb,
                """
                n_agents = 10
                for i in range(n_agents):
                    agents.append([random.randint(0, 99), random.randint(0, 99)])
                """);
        w.addP(sb, "Check your program still runs.");
        w.addP(sb,
                """
                Delete or comment out any other code that initialises agents.
                """);
        w.addP(sb,
                """
                Use another for loop to move all 10 agents. And use another for
                loop to plot all 10 agents black. Hopefully, there is still a
                red coloured dot which gives the location of the agent with the
                largest x coordinate.
                """);
        addCommitToGitHub(sb);
        w.addDIVET(sb);
        sb.append("\n");
        
        sid = addSection("More Plotting", sb);        
        w.addP(sb,
                """
                Similarly to plotting the agent with the largest x coordinate
                red, write code to plot the agent with the smallest x coordinate
                blue; the largest y coordinate yellow; and the smallest y
                coordinate green.
                """);
        addCommitToGitHub(sb);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Code Review and Looking Forward", sb);
        w.addP(sb,
                """
                If you managed to complete all parts, then it should be straight
                forward to modify your code to run for different numbers of
                agent. Have a try and also think about how you would get the
                agents to move multiple times.
                """);
        w.addP(sb,
                """
                If you got stuck, then don't worry, look ahead to the start of
                the next ABM practical where some code that does everything is
                provided.
                """);
        w.addP(sb,
                """
                Next we will look in more detail about functions and how to
                document them. Then in the next ABM practical: a loop will be
                created to simulate movement of the agents multiple times; and
                the distance calculation code, which is currently just a test
                case, will be changed into a function. Most of the next
                practical will be an exercise involving calculating the maximum
                distance between agents and timing code to optimise this.
                """);
        w.addDIVET(sb);
        return sb.toString();
    }
}
