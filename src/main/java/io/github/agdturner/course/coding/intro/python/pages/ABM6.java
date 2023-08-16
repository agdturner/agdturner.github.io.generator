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
 * For Python Intro Course ABM6 Page.
 *
 * @author Andy Turner
 */
public class ABM6 extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public ABM6(PythonIntroCodingCourse course) {
        super(course, "abm6", "Agent Based Model Practical 6", "ABM6");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction and Preparation", sb);
        addParagraph(sb,
                """
                To get agents communicating they need a way to refer to each
                other. Code is going to be developed so that those agents that
                are within a given distance are going to share some of their
                store.
                """);
        addParagraph(sb,
                """
                In your local code repository 'src' directory create a new
                directory called 'abm6'. Open Spyder and use 'save as' to save
                your 'model.py' into this directory. Create a new directory
                called 'my_modules' in 'abm6' and use 'save as' to save your
                'agentframework.py' and 'io.py' files there.
                """);

        sid = addSection("Sharing", sb);
        addParagraph(sb,
                """
                Each agent is going to share their store equally amongst all
                agents within a given distance. The algorithm is as follows:
                """);
        addPre(sb,
                """
                # Calculate which other agents are within a given distance.
                # Calculate shares.
                # Distribute shares.
                """);
        addParagraph(sb,
                """
                In order to share resources so that the order in which agents
                are processed is irrelevant, there is a need to distinguish
                those resources to be shared with those that have been shared.
                """);
        addParagraph(sb,
                """
                Change the Agent contructor to include 'agents' in the
                parameters, store this as a variable, and add an attribute for
                storing the shares 'store_shares' so it is as follows:
                """);
        addPythonCodeBlock(sb,
                """
                def __init__(self, agents, i, environment, n_rows, n_cols):
                    \"""
                    The constructor method.

                    Parameters
                    ----------
                    agents : List
                        A list of Agent instances.
                    i : Integer
                        To be unique to each instance.
                    environment : List
                        A reference to a shared environment.
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
                    self.store_shares = 0
                """);
        addParagraph(sb,
                """
                Change 'model.py' so that 'agents' is passed as a parameter in
                the code that constructs each inidivual Agent class instance.
                """);
        addParagraph(sb,
                """
                Test your code works and that from one agent you can access
                another agent by printing out one agent from another agent. For
                example after all the agents are initialised try printing the
                agent with i equal to 1 from the agent with i equal to 0:
                """);
        addPythonCodeBlock(sb, "print(agents[0].agents[1])");
        addParagraph(sb,
                """
                A way to use the 'get_distance' function in 'agentframework.py'
                and avoid cyclic imports is to move the 'get_distance' function
                to a new module. Create a new file called 'geometry.py' in the
                'my_modules' directory, and move the 'get_distance' method from
                'model.py' to it. Add an import statement for the new geometry
                module in 'model.py' and change the function call to look for
                the function in the new geometry module by using the dot
                operator. (In other words change 'get_distance' to
                'geometry.get_distance').
                """);
        addParagraph(sb,
                """
                Import the geometry module into 'agentframework.py' and add the
                following method:
                """);
        addPythonCodeBlock(sb,
                """
                def share(self, neighbourhood):
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
                        self.agents[i].store_shares += shares
                """);
        addParagraph(sb,
                """
                This code is using the fact that 'self.i' will be the same as
                the index of an agent in the 'agents' list. In the first for
                loop of the 'share' function the distance between 'self' and
                each agent in the agents list is calculated and if this is less
                than 'neighbourhood' (a parameter that is passed in), then the
                index of the agent from the agents list is stored in the
                'neighbours' list. The attribute 'self.store' is then divided
                into 'shares' and added to the 'store_shares' attribute of all
                the agents with indexes in 'neighbours'.
                """);
        addParagraph(sb,
                "Replace the 'main simulation loop' in 'model.py' file with:");
        addPythonCodeBlock(sb,
                """
                # Main simulation loop
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
                    print("total resource", (sum_as + sum_e))
                """);
        addParagraph(sb,
                """
                Run 'model.py' and interpret the output. Add more print
                statements to gain a clear understanding of how the code works.
                """);

        sid = addSection("Organise module code", sb);
        addParagraph(sb,
                """
                Move all code in each 'my_modules' module that is not in
                functions to be within if statement like the following at the
                end of the file:
                """);
        addPythonCodeBlock(sb, "if __name__ == '__main__':");
        addParagraph(sb,
                """
                Recall that this isolates this code so it is only run if that
                file is the one run and not when the module is imported.
                """);
        addParagraph(sb,
                """
                Make sure to test that your code still produces the same
                results.
                """);

        sid = addSection("Output images and generate an animated Gif", sb);
        addParagraph(sb,
                """
                Add the following import statements to the 'model.py' placing
                these with the other import statements as the first executable
                statements in the code:
                """);
        addPythonCodeBlock(sb,
                """
                import imageio
                import os
                """);
        addParagraph(sb,
                "Before the main simulation loop add the following code:");
        addPythonCodeBlock(sb,
                """
                # Create directory to write images to.
                try:
                    os.makedirs('../../data/output/images/')
                except FileExistsError:
                    print("path exists")

                # For storing images
                global ite
                ite = 1
                images = []
                """);
        addParagraph(sb,
                """
                Indent the plotting so that this occurs within the main
                simulation loop and replace the following line:
                """);
        addPythonCodeBlock(sb, "plot.show()");
        addParagraph(sb, "With:");
        addPythonCodeBlock(sb,
                """
                filename = '../../data/output/images/image' + str(ite) + '.png'
                #filename = '../../data/output/images/image' + str(ite) + '.gif'
                plt.savefig(filename)
                plt.show()
                plt.close()
                images.append(imageio.imread(filename))
                """);
        addParagraph(sb,
                """
                This code should: create plots; save these as images in PNG
                format files; show and close them rapidly; then reload the PNG
                format file and append the image to the images list.
                """);
        addParagraph(sb,
                """
                After the end of the main simulation loop the images can be
                turned into an animated GIF format file using:
                """);
        addPythonCodeBlock(sb,
                "imageio.mimsave('../../data/output/out.gif', images, fps=3)");
        addParagraph(sb,
                """
                The parameter 'fps' is the number of frames that are shown per
                 second.
                """);
        addParagraphCommitToGitHub(sb);

        sid = addSection("Further Assignment 1 Coding Tasks", sb);
        sb.append("<p>Create some more variable results by randomly setting the"
                + " 'store' of each agent in initialisation to be a value in"
                + " the range [0, 99].</p>");
        sb.append("<p>Change the 'eat' function so that if an agent 'store'"
                + " goes above 99, then half the store is added to"
                + " 'environment' where the agent is located.</p>");
        addParagraphCommitToGitHub(sb);
        sb.append("</div>");
        return sb.toString();
    }
}
