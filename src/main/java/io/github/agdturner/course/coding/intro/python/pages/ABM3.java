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
import io.github.agdturner.core.Strings;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.course.CoursePage;

/**
 * For Python Intro Course ABM3 Page.
 *
 * @author Andy Turner
 */
public class ABM3 extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public ABM3(PythonIntroCodingCourse course) {
        super(course, "abm3", "Agent Based Model Practical 3", "ABM3");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Recap and preparation", sb);
        addParagraph(sb,
                "Your ABM code should look something like the following:");
        addPythonCodeBlock(sb,
                """
                import random
                import math
                import matplotlib.pyplot as plt
                import operator

                # Set the pseudo-random seed for reproducibility
                random.seed(0)

                # A variable to store the number of agents
                n_agents = 10

                # Initialise agents
                agents = []
                for i in range(n_agents):
                    agents.append([random.randint(0, 99), random.randint(0, 99)])
                print(agents)

                # Move agents
                for i in range(n_agents):
                    # Change agents[i] coordinates randomly
                    # x-coordinate
                    rn = random.random()
                    #print("rn", rn)
                    if rn < 0.5:
                        agents[i][0] = agents[i][0] + 1
                    else:
                        agents[i][0] = agents[i][0] - 1
                    # y-coordinate
                    rn = random.random()
                    #print("rn", rn)
                    if rn < 0.5:
                        agents[i][1] = agents[i][1] + 1
                    else:
                        agents[i][1] = agents[i][1] - 1
                print(agents)

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

                # Plot
                for i in range(n_agents):
                    plt.scatter(agents[i][0], agents[i][1], color='black')
                # Plot the coordinate with the largest x red
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
                plt.scatter(sy[0], sy[1], color='green')
                plt.show()
                """);
        addParagraph(sb,
                "When run, this should produce the following text output:");
        addPre(sb,
                """
                [[49, 97], [53, 5], [33, 65], [62, 51], [38, 61], [45, 74], [27, 64], [17, 36], [17, 96], [12, 79]]
                [[48, 96], [52, 4], [32, 66], [63, 52], [37, 62], [44, 75], [28, 63], [18, 35], [18, 95], [13, 78]]
                ssd 25
                distance 5.0
                distance 5.0
                """);
        addParagraph(sb,
                """
                And this plot:
                <img src="../../resources/abm2/Figure_1.png" alt="ABM2 Output Plot" />
                """);
        addParagraph(sb,
                """
                Some of the print statements in the code presented above have
                been 'commented out' - turned into comments. This reduces the
                amount of text output. Most of the print statements were for
                testing, but might be worth keeping in place for the time being.
                Printing out a lot of information to the console can be slow and
                unhelpful. Generally, it is a lot faster to write to a file.
                """);
        addParagraph(sb,
                """
                The text output gives the agent coordinates before and then
                after a single move. This could be clearer in the information
                printed out, but the output is fine for the time being.
                """);
        addParagraph(sb,
                """
                In your local code repository src directory create a new
                directory called "abm3". Open Spyder and use "save as" to save
                your "model.py" file into the abm3 directory.
                """);

        sid = addSection("Distance Calculations", sb);

        sid = addSubsection("Define a Function", sb);
        addParagraph(sb,
                """
                Change the distance calculation code into a function named
                'get_distance': Use the 'def' keyword and specify four input
                parameters (x0, y0, x1, y1). Recall that a function declaration
                ends with a colon ':', and the code of the function must be
                indented. Return the distance calculated as the last statement
                of the function using the keyword 'return' followed by the name
                of the variable that is the calculated distance. After the
                function write a statement to call it and print out the distance
                returned.
                """);
        addParagraph(sb, "Run the code to test it works");
        addParagraph(sb,
                """
                If your code calculates the square root in two ways, then
                simplify it by removing one of these ways. Consider simplifying
                your code in other ways too...
                """);
        addParagraphStart(sb,
                "<p>Change the comment that describes the function into a ");
        sb.append(index.getReference("Python docstring", "docstring", sid));
        addParagraphEnd(sb,
                " clarifying what the function inputs and outputs are.");

        sid = addSubsection("Calculate the maximum distance", sb);
        addParagraph(sb,
                """
                Imagine a two dimensional matrix with the agents aligned in the
                same sequence along each dimension and the distances between
                them being the values in the matrix. The matrix is symmetrical
                about a diagonal where all the distances are zero.
                """);
        addParagraphStart(sb,
                """
                The maximum distance between any two agents is the maximum
                distance in this matrix, indeed it is the maximum distance in
                one half of the values not on the zero diagonal. Anyway, a pair
                of nested
                """);
        sb.append(index.getReference("Python for", "for loops", sid));
        addParagraphEnd(sb,
                """
                 can be used to calculate it: An outer loop that iterates over
                all agents; and an inner loop that iterates over all agents.
                Within the inner loop the get_distance function can be used to
                calculate the distance between a pair of agents (one from the
                outer loop and one from the inner loop), and the
                <a href="https://docs.python.org/3/library/functions.html#max">
                builtin max function</a> can be used to calculate the maximum
                distance encountered yet. The following code does this:
                """);
        addPythonCodeBlock(sb,
                """
                max_distance = 0 # Initialise max_distance
                for a in agents:
                    for b in agents:
                        distance = get_distance(a[0], a[1], b[0], b[1])
                        print("distance between", a, b, distance)
                        max_distance = max(max_distance, distance)
                        print("max_distance", max_distance)
                """);
        addParagraph(sb,
                """
                Add the code to the end of your program, run it and examine the
                output. In calculating the maximum distance, you should see
                that some zero distances are calculated. These will either be
                where an agent is located at the same place as another agent, or
                where the calculation is for the same agent - the diagonals in
                the imaginary matrix.
                """);
        addParagraphStart(sb,
                """
                Recall that there are two main ways to iterate over the items in
                a list. As above, and alternatively using list indexes. The
                following code does the same calculation, and uses the
                """);
        sb.append(index.getReference("Python range", "range function"));
        addParagraphEnd(sb, " to get a sequence of indexes:");
        addPythonCodeBlock(sb,
                """
                max_distance = 0
                for i in range(len(agents)):
                    a = agents[i]
                    for j in range(len(agents)):
                        b = agents[j]
                        distance = get_distance(a[0], a[1], b[0], b[1])
                        print("distance between", a, b, distance)
                        max_distance = max(max_distance, distance)
                        print("max_distance", max_distance)
                """);
        addParagraphStart(sb,
                """
                Note that this code uses variables 'i' and 'j' for the indexes,
                and the
                """);
        sb.append(index.getReference("Python len", "len function"));
        addParagraphEnd(sb,
                """
                to get the length of the agents list. (Here, 'len(agents)' is
                the same as 'n_agents', which could be used instead (and would
                be more efficient). Change this if you want, but consider what
                would happen if the length of the agents list gets changed in
                the model.)
                """);
        addParagraph(sb,
                """
                Write a function called 'get_max_distance' that returns the
                maximum distance between all the agents.
                """);
        addParagraph(sb,
                "Your 'get_distance' function should look something like:");
        addPythonCodeBlock(sb,
                """
                def get_distance(x0, y0, x1, y1):
                    \"""
                    Calculate the Euclidean distance between (x0, y0) and (x1, y1).

                    Parameters
                    ----------
                    x0 : Number
                        The x-coordinate of the first coordinate pair.
                    y0 : Number
                        The y-coordinate of the first coordinate pair.
                    x1 : Number
                        The x-coordinate of the second coordinate pair.
                    y1 : Number
                        The y-coordinate of the second coordinate pair.

                    Returns
                    -------
                    distance : Number
                        The Euclidean distance between (x0, y0) and (x1, y1).
                    \"""
                    # Calculate the difference in the x coordinates.
                    dx = x0 - x1
                    # Calculate the difference in the y coordinates.
                    dy = y0 - y1
                    # Return the Sum the squared differences square rooted.
                    return ((dx * dx) + (dy * dy)) ** 0.5
                """);
        addParagraph(sb,
                """
                Use your 'get_max_distance' function to calculate the maximum
                distance between all the agents just after they have been
                initialised.
                """);
        addParagraphStart(sb, "If a ");
        sb.append(index.getReference("Python NameError", "NameError"));
        addParagraphEnd(sb,
                """
                is raised indicating that 'get_max_distance' is not defined,
                then recall that the Python interpreter needs to have read a
                function definition before it can be called. So, rearrange your
                code so that the function is defined before it is called.
                """);

        sid = addSection("Timing", sb);
        addParagraphStart(sb, "This section is about using the ");
        sb.append(index.getReference("Python time", "time module", sid));
        addParagraphEnd(sb, " to report timings and explore code efficiency.");
        addParagraph(sb,
                """
                Save your source code file with a new name, for example
                "timing.py".
                """);
        addParagraph(sb,
                """
                Add the following import statement along with the others
                towards the top of the source code:
                """);
        addPythonCodeBlock(sb, "import time");
        addParagraph(sb,
                """
                Before calculating the maximum distance between the initialised
                agents add the following line:
                """);
        addPythonCodeBlock(sb, "start = time.perf_counter()");
        addParagraph(sb,
                """
                This sets the variable 'start' to a time variable which is the
                number of second since the computer was last rebooted. After
                calculating the maximum distance add the following code to
                calculate and report a time interval:
                """);
        addPythonCodeBlock(sb,
                """
                end = time.perf_counter()
                print("Time taken to calculate maximum distance", end - start,
                "seconds")
                """);
        addParagraph(sb,
                """
                Run your program and check the time taken to calculate maximum
                distance. (It could report '0.0' seconds for 10 agents. This
                does not mean that the processing took no time, but that it was
                very quick and closer to zero milliseconds than one.)
                """);
        addParagraph(sb,
                """
                The plan in this part is to explore the following two things:
                """);
        sb.append(Strings.OL_START);
        addLI(sb,
                "How does the processing time scale as 'n_agents' increases?");
        addLI(sb,
                """
                Other potentially more optimal ways of calculating the maximum
                distance between agents.
                """);
        sb.append(Strings.OL_END);
        addParagraph(sb,
                """
                Increase 'n_agents' to 500 and run the program again. Notice
                that the plotting is a little delayed and printing out the
                agents now clutters the text output.
                """);
        addParagraph(sb,
                """
                As printing and plotting are slow and can effect timings
                significantly, comment out the code for printing agents and the
                code for plotting agents.
                """);
        addParagraph(sb,
                """
                Run your program again. It should now be easy to see the time
                taken to calculate the maximum distance between agents, which is
                expected to take a fraction of a second.
                """);
        addParagraph(sb,
                """
                Run again and compare the timing. It is normal for the timing
                to vary a bit from one run to another. The amount of computation
                is the same, but the exact timing depends on other things that
                are hard to control for - such as how busy your computer is
                doing other things.
              """);
        addParagraph(sb, "Adapt your code:");
        sb.append(Strings.OL_START);
        addLI(sb, "Create a loop to run for a range of n_agents.");
        addLI(sb, "Create a list to store timing results.");
        addLI(sb,
                """
                Create a plot with time on one axis and n_agents on the other.
                """);
        sb.append(Strings.OL_END);
        addParagraph(sb,
                """
                Experiment with your range function to get an interesting plot.
                """);
        addParagraph(sb,
                """
                Spend at least 15 minutes trying to do this coding. If you
                manage to do it within this time, then great, if not, then don't
                worry. Having tried, compare your efforts with
                <a href="../../resources/abm3/timing1.py">this solution</a> that
                produces the following results:
                """);
        addPre(sb,
                """
                Maximum distance between all the agents 133.64505228402584
                Time taken to calculate maximum distance 0.1642232000012882
                Maximum distance between all the agents 137.17871555019022
                Time taken to calculate maximum distance 0.5503714999940712
                Maximum distance between all the agents 137.90213921473443
                Time taken to calculate maximum distance 1.23476789999404
                Maximum distance between all the agents 138.6001443000692
                Time taken to calculate maximum distance 2.1861126000003424
                Maximum distance between all the agents 137.90213921473443
                Time taken to calculate maximum distance 3.4285349999991013
                Maximum distance between all the agents 139.30183056945089
                Time taken to calculate maximum distance 4.966505299991695
                Maximum distance between all the agents 139.30183056945089
                Time taken to calculate maximum distance 6.7055035999946995
                Maximum distance between all the agents 139.30183056945089
                Time taken to calculate maximum distance 8.90659329999471
                Maximum distance between all the agents 140.0071426749364
                Time taken to calculate maximum distance 11.068045900014113
                """);
        addParagraph(sb,
                """
                <img src="../../resources/abm3/Figure_1.png"
                alt="A graph of time (y axis) and n_agents (x axis)" />
                """);
        addParagraph(sb,
                """
                Attempt to optimise the calculation of the maximum distance
                between all the agents as follows: Modify your code so that
                'n_agents = 3', and add the following print statement to the
                inner loop of the 'get_max_distance' function:
                """);
        addPre(sb,
                """
                print("i", i, "j", j)
                """);
        addParagraph(sb,
                """
                Run the code and you should see the following printed in the
                text output:
                """);
        addPre(sb,
                """
                i 0 j 0
                i 0 j 1
                i 0 j 2
                i 1 j 0
                i 1 j 1
                i 1 j 2
                i 2 j 0
                i 2 j 1
                i 2 j 2
                """);
        addParagraphStart(sb,
                """
                Change what is in the inner loop of the 'get_max_distance'
                function to be within an
                """);
        sb.append(index.getReference("Python if", "if statement"));
        addParagraphEnd(sb,
                """
                that is only run when 'i' does not equal 'j' using the operator
                '!='. The 'if statement' will look like:
                """);
        addPythonCodeBlock(sb,
                """
                if i != j:
                """);
        addParagraph(sb,
                """
                Run the program again and you should see the following in the
                console output:
                """);
        addPre(sb,
                """
                i 0 j 1
                i 0 j 2
                i 1 j 0
                i 1 j 2
                i 2 j 0
                i 2 j 1
                """);
        addParagraph(sb,
                """
                Compare this output with the previous run output: There is less
                output, as when the indexes are the same, the calculations are
                skipped.
                """);
        addParagraph(sb,
                """
                Comment out the print statement and run the code for
                'n_agents = 1000'. Compare the processing time with/without the
                'if statement'.
                """);
        addParagraph(sb,
                """
                The timing is probably about the same and may be more with the
                if statement, because the 'if statement' condition is evaluated
                every iteration of the inner loop and only filters out the need
                for calculation of the n_agents distances that are along the
                zero diagonal of the imaginary distance matrix.
                """);
        addParagraph(sb,
                """
                Modify the code again so that: 'n_agents = 3'; the print
                statement that was commented out is no longer commented out;
                and, so that the operator in the 'if statement' is a '&lt;'):
                """);
        addPythonCodeBlock(sb, "if i < j:");
        addParagraph(sb,
                """
                Run the program again and you should get the following output:
                """);
        addPre(sb,
                """
                i 0 j 1
                i 0 j 2
                i 1 j 2
                """);
        addParagraph(sb,
                """
                Understand that the maximum distance can be calculated by
                finding the maximum distance between the coordinates as indexed.
                It may help you appreciate this if you run for 'n_agents = 5' or
                'n_agents = 10' and analyse the output.
                """);
        addParagraph(sb,
                """
                Comment out the print statement again and record timings again
                for 'n_agents = 1000'. You should get the same max_distance
                result calculated previously, but the processing time should be
                roughly half.
                """);
        addParagraph(sb,
                """
                An even faster way involves modifying the loops and removing
                the 'if statement'. Can you work out how to do it? (Hint: Change
                the range function of the inner for loop to start at index i +
                1).
                """);
        addParagraph(sb,
                """
                Once you've given this a try, compare your answer with
                <a href="../../resources/abm3/timing2.py">this one</a> in which
                the code has been simplified a little and the following graph of
                results was obtained:
                """);
        addParagraph(sb,
                """
                <img src="../../resources/abm3/Figure_2.png"
                alt="Another graph of time (y axis) and n_agents (x axis)" />
                """);

        sid = addSection("Other distance statistics", sb);
        addParagraph(sb,
                """
                In calculating the maximum distance, a lower bound of 0 was
                used to initialise the max_distance variable. To calculate the
                minimum distance, then either an upper bound is wanted, or the
                initial minimum distance should be set to be a distance between
                any two different agents. The upper bound of the distance
                between two agents in Euclidean space is theoretically
                infinite.
                """);
        addParagraphStart(sb, "From the ");
        sb.append(index.getReference("Python math", "math module", sid));
        addParagraphEnd(sb,
                " the following can be used for positive infinity:");
        addPythonCodeBlock(sb,
                """
                math.inf
                """);
        addParagraph(sb,
                """
                Write a function that calculates the minumum distance between
                all the agents and record timings of how long it takes to
                calculate both the maximum and minimum distances using the two
                different functions.
                """);
        addParagraph(sb,
                """
                Develop a function that calculates both the minimum and
                maximum distances using a single set of nested loops and returns
                the result in a tuple. You should find that it is significantly
                quicker to calculate both the maximum and minimum this way
                rather than looping through things and calculating the distances
                twice. Write a brief document about the timings to show that
                calculating both the minimum and maximum distances using a
                single set of nested loops is more efficient. Commit this
                document to your repository along with your code.
                """);
        addParagraph(sb,
                """
                As well as the maximum and minimum distance, you might want to
                calculate other statistics, such as the average distance.
                """);
        addParagraph(sb,
                """
                The <a href="https://en.wikipedia.org/wiki/Arithmetic_mean">arithmetic mean</a>
                average can be calculated with one run through the data. To
                calculate the
                <a href="https://en.wikipedia.org/wiki/Standard_deviation">standard deviation</a>
                of distances, it is first necessary to know the arithmetic mean.
                So, it is necessary in calculating the standard deviation to
                iterate over the data values at least twice, once to calculate the
                mean and again to sum some difference of values from the mean. The
                <a href="https://en.wikipedia.org/wiki/Median">median</a>
                and
                <a href="https://en.wikipedia.org/wiki/Mode_(statistics)">mode</a>
                could be calculated with a single run through the data. For
                calculating the median the data needs to be sorted. Calculating
                the mode of a continuous variable is often not useful. Anyway, for
                a mode calculation, a dictionary can be used to store a count for
                each value and then return the value for which the count is
                highest.
                """);
        addParagraph(sb,
                """
                Practising calculating such summary statistics from first
                principles is a good way to develop programming skills, so if
                you want the extra practise then have a go. Perhaps try
                calculating a truncated mean of distances ignoring a proportion
                of the highest and lowest distances. Think about how you would
                test to ensure your code produces correct results.
                """);
        addParagraph(sb,
                """
                Replace the get_max_distance() in model.py with the new faster
                version you have developed.
                """);
        addParagraphCommitToGitHub(sb);

        sid = addSection("Movement", sb);
        addParagraph(sb,
                """
                Currently, in 'model.py' agents move once. The code will now be
                changed to move them a number of times. After initialising
                'n_agents', initialise a variable called 'n_iterations' and set
                it equal to 1000.
                """);
        addParagraphStart(sb, "Create a new outer ");
        sb.append(index.getReference("Python for", "for loop"));
        addParagraphEnd(sb,
                """
                to loop through moving agents n_iteration times. An outer loop
                is wanted rather than an inner loop as in each iteration agents
                are to move in turn rather than each agent taking all their
                turns before any others. This outer loop is the 'main simulation
                loop'. Add a comment to identify it as such.
                """);
        addParagraph(sb,
                """
                The agents move randomly, and the more of them there are, the
                more spread out they are likely to become.
                """);
        addParagraph(sb,
                """
                Edge effects are important to consider in geographical data
                analysis and modelling. The agents currently have a
                theoretically infinite two dimensional (2D) area to move in. To
                make things more manageable, movement will be restricted to a
                rectangular area by limiting the x and y coordinates using the
                following code blocks:
                """);
        addPythonCodeBlock(sb,
                """
                # Variables for constraining movement.
                # The minimum x coordinate.
                x_min = 0
                # The minimum y coordinate.
                y_min = 0
                # The maximum x coordinate.
                x_max = 99
                # The maximum y coordinate.
                y_max = 99
                """);
        addPythonCodeBlock(sb,
                """
                # Apply movement constraints.
                if agents[i][0] < x_min:
                    agents[i][0] = x_min
                if agents[i][1] < y_min:
                    agents[i][1] = y_min
                if agents[i][0] > x_max:
                    agents[i][0] = x_max
                if agents[i][1] > y_max:
                    agents[i][1] = y_max
                """);
        addParagraph(sb,
                """
                Insert the first code block at the top of 'model.py' with
                the other initialised variables. Insert the other code block as
                part of moving each agent.
                """);
        addParagraph(sb,
                """
                After having moved each agent, the code could loop through the
                agents again to constrain movement, but this would be less
                efficient than constraining within same loop as moving each
                agent.
                """);
        addParagraphCommitToGitHub(sb);
        sb.append("</div>\n");
        return sb.toString();
    }
}
