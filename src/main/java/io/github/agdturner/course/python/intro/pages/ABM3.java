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
 * For Python Intro Course ABM3 Page.
 *
 * @author Andy Turner
 */
public class ABM3 extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public ABM3(PythonIntroCourse c) {
        super("abm3", "Agent Based Model Part 3", "ABM3", c);
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        Section s;
        s = addSection("1", "Recap and preparation", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>Your ABM code should look something like the following:</p>
              <pre><code class="language-python">import random
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
              plt.show()</code></pre>
              <p>When run, this code should produce the following text output:</p>
              <pre>[[49, 97], [53, 5], [33, 65], [62, 51], [38, 61], [45, 74], [27, 64], [17, 36], [17, 96], [12, 79]]
              [[48, 96], [52, 4], [32, 66], [63, 52], [37, 62], [44, 75], [28, 63], [18, 35], [18, 95], [13, 78]]
              ssd 25
              distance 5.0
              distance 5.0</pre>
              <p>And the following plot:</p>
              <img src="../../resources/abm2/Figure_1.png" alt="ABM2 Output Plot" />
              <p>Some of the print statements in the code presented above have 
              been 'commented out' - turned into comments. This reduces the 
              amount of text output in the console. Most of the print statements
              were for testing and are not so necessary, but might be worth 
              keeping in place for the time being. Printing out a lot of 
              information to the console can be confusing and is often not very 
              helpful and it also slows down the program execution. If large 
              amounts of output are to be generated, this is best written to a 
              file which is much faster than displaying it.</p>
              <p>The text output gives the agent coordinates before and then 
              after a single move. This could be clearer in the information 
              printed out, but the output is fine for the time being.</p> 
              <p>In your local code repository src directory create a new 
              directory called "abm3". Open Spyder and use "save as" to save 
              your "model.py" file into the abm3 directory.</p>
              """);
        
        s = addSection("2", "Distance Calculations", 2);
        w.add(s.sectionHTML);
        
        s = addSection("2.1", "Define a Function", 3);
        w.add(s.sectionHTML);
        w.add("""
              <p>Change the distance calculation code into a function called 
              get_distance: Use the def keyword and specify four input 
              parameters (x0, y0, x1, y1). Recall that the function declaration 
              ends with a colon ':', and the code of the function must be 
              indented. Return the distance calculated as the last statement of 
              the function using the keyword 'return' followed by the name of 
              the variable that is the calculated distance. After the function 
              write a statement to call it and print out the distance 
              returned.</p>
              <p>Run the code to test it works</p>
              <p>If your code calculates the square root in two ways, then 
              simplify it by removing one of these ways. Consider simplifying
              your code in other ways too...</p>
              """);
        w.add("<p>Change the comment that describes the function into a "
                + c.index.getReference("Python docstring", "docstring", s.sid)
                + " clarifying what the function inputs and outputs are.</p>");
        
        s = addSection("2.2", "Calculate the maximum distance", 3);
        w.add(s.sectionHTML);
        w.add("""
              <p>Imagine a two dimensional matrix with the agents aligned in the 
              same sequence along each dimension and the distances between them 
              being the values in the matrix. The matrix is symmetrical about a 
              diagonal where all the distances are zero.</p>
              """);
        w.add("<p>The maximum distance between any two agents is the maximum"
                + " distance in this matrix, indeed it is the maximum distance"
                + " in one half of the values not on the zero diagonal. Anyway,"
                + " a pair of nested "
                + c.index.getReference("Python for", "for loops", s.sid)
                + " can be used to calculate it: An outer loop that iterates"
                + " over all agents; and an inner loop that iterates over"
                + " all agents. Within the inner loop the get_distance function"
                + " can be used to calculate the distance between a pair of"
                + " agents (one from the outer loop and one from the inner"
                + " loop), and the "
                + "<a href=\"https://docs.python.org/3/library/functions.html#max\">"
                + "builtin max function</a>"
                + " can be used to calculate the maximum distance encountered "
                + " yet. Some code for doing this is as follows:</p>");
        w.add("""
              <pre><code class="language-python">max_distance = 0 # Initialise max_distance
              for a in agents:
                  for b in agents:
                      distance = get_distance(a[0], a[1], b[0], b[1])
                      print("distance between", a, b, distance)
                      max_distance = max(max_distance, distance)
                      print("max_distance", max_distance)</code></pre>
              <p>Add the code to the end of your program, run it and examine the 
              output. In calculating the maximum distance, you should see that
              some zero distances are calculated. These will either be where an 
              agent is located at the same place as another agent, or where the 
              calculation is for the same agent - the diagonals in the imaginary 
              matrix.</p>
              """);
        w.add("<p>Recall that there are two main ways to iterate over the items"
                + " in a list. As above, and alternatively using list indexes."
                + " The following code does the same calculation, and uses the "
                + c.index.getReference("Python range", "range function")
                + " to get a sequence of indexes:</p>");
        w.add("""
              <pre><code class="language-python">max_distance = 0
              for i in range(len(agents)):
                  a = agents[i]
                  for j in range(len(agents)):
                      b = agents[j]
                      distance = get_distance(a[0], a[1], b[0], b[1])
                      print("distance between", a, b, distance)
                      max_distance = max(max_distance, distance)
                      print("max_distance", max_distance)</code></pre>
              """);
        w.add("<p>Note that this code uses variables 'i' and 'j' for the"
                + " indexes, and the "
                + c.index.getReference("Python len", "len function")
                + " to get the length of the agents list. (Here, 'len(agents)'"
                + " is the same as 'n_agents', which could be used instead (and"
                + " would be more efficient). Change this if you want, but"
                + " consider what would happen if the length of the agents list"
                + " gets changed in the model.)</p>");
        w.add("""
              <p>Write a function called 'get_max_distance' that returns the 
              maximum distance between all the agents.</p>
              <p>Your 'get_distance' function should look something like the 
              following:</p>
              <pre><code class="language-python">def get_distance(x0, y0, x1, y1):
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
                  dx = x0 - x1
                  # Calculate the difference in the y coordinates.
                  dy = y0 - y1
                  # Return the Sum the squared differences square rooted.
                  return ((dx * dx) + (dy * dy)) ** 0.5</code></pre>
              <p>Use your 'get_max_distance' function to calculate the maximum 
              distance between all the agents just after they have been 
              initialised.</p>
              """);
        w.add("If a "
                + c.index.getReference("Python NameError", "NameError")
                + " is raised indicating that 'get_max_distance' is not"
                + " defined, then recall that the Python interpreter needs to"
                + " have read a function definition before it can be called."
                + " So, rearrange your code so that the function is defined"
                + " before it is called.</p>");
        
        s = addSection("3", "Timing", 2);
        w.add(s.sectionHTML);
        w.add("<p>This section is about using the "
                + c.index.getReference("Python time", "time module", s.sid)
                + " to report timings and explore code efficiency.</p>");
        w.add("""
              <p>Save your source code file with a new name, for example 
              "timing.py".<p>
              <p>Add the following import statement along with the others
              towards the top of the source code:</p>
              <pre><code class="language-python">import time</code></pre>
              <p>Before calculating the maximum distance between the initialised 
              agents add the following line:</p>
              <pre><code class="language-python">start = time.perf_counter()</code></pre>
              <p>This sets the variable 'start' to a time variable which is the 
              number of second since the computer was last rebooted. After 
              calculating the maximum distance add the following code to 
              calculate and report a time interval:</p>
              <pre><code class="language-python">end = time.perf_counter()
              print("Time taken to calculate maximum distance", end - start, "seconds")</code></pre>
              <p>Run your program and check the time taken to calculate maximum 
              distance. (It could report '0.0' seconds for 10 agents. This does 
              not mean that the processing took no time, but that it was very 
              quick and closer to zero milliseconds than one.)</p>
              <p>The plan in this part is to explore the following two things:</p>
              <ol>
              <li>How does the processing time scale as 'n_agents' increases?
              </li>
              <li>Other potentially more optimal ways of calculating the 
              maximum distance between agents.</li>
              </ol>
              <p>Increase 'n_agents' to 500 and run the program again. 
              Notice that the plotting is a little delayed and printing out the 
              agents now clutters the text output.</p>
              <p>As printing and plotting are slow and can effect timings 
              significantly, comment out the code for printing agents and the 
              code for plotting agents.</p>
              <p>Run your program again. It should now be easy to see the time 
              taken to calculate the maximum distance between agents, which is 
              expected to take a fraction of a second.</p>
              <p>Run again and compare the timing. It is normal for the timing 
              to vary a bit from one run to another. The amount of computation 
              is the same, but the exact timing depends on other things that are 
              hard to control for - such as how busy your computer is doing 
              other things.</p>
              <li>Adapt your code:
              <ol>
              <li>Create a loop to run for a range of n_agents.</li>
              <li>Create a list to store timing results.</li> 
              <li>Create a plot with time on one axis and n_agents on the other
              </li>
              </ol>
              <li>Experiment with your range function to get an interesting 
              plot.</li>
              </ul>
              <p>Spend at least 15 minutes trying to do this coding. If you 
              manage to do it within this time, then great, if not, then don't 
              worry. Having tried, compare your efforts with
              <a href="../../resources/abm3/timing1.py">this solution</a> that 
              produces the following results:</p>
              <pre>Maximum distance between all the agents 133.64505228402584
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
              Time taken to calculate maximum distance 11.068045900014113</pre>
              <p><img src="../../resources/abm3/Figure_1.png" 
              alt="A graph of time (y axis) and n_agents (x axis)" /></p>
              <p>Attempt to optimise the calculation of the maximum distance 
              between all the agents as follows: Modify your code so that 
              'n_agents = 3', and add the following print statement to the 
              inner loop of the 'get_max_distance' function:</p>
              <pre>print("i", i, "j", j)</pre>
              <p>Run the code and you should see the following printed in the 
              text output:</p>
              <pre>i 0 j 0
              i 0 j 1
              i 0 j 2
              i 1 j 0
              i 1 j 1
              i 1 j 2
              i 2 j 0
              i 2 j 1
              i 2 j 2</pre>
              """);
        w.add("<p>Change what is in the inner loop of the 'get_max_distance'"
                + " function to be within an "
                + c.index.getReference("Python if", "if statement")
                + " that is only run when 'i' does not equal 'j' using the"
                + " operator '!='. The 'if statement' will look like:</p>");
        w.add("""
              <pre><code class="language-python">if i != j:</code></pre>
              <p>Run the program again and you should see the following in the 
              console output:</p>
              <pre>i 0 j 1
              i 0 j 2
              i 1 j 0
              i 1 j 2
              i 2 j 0
              i 2 j 1</pre>
              <p>Compare this output with the previous run output: There is less 
              output, as when the indexes are the same, the calculations are 
              skipped.</p>
              <p>Comment out the print statement and run the code for 
              'n_agents = 1000'. Compare the processing time with/without the 
              'if statement'.</p>
              <p>The timing is probably about the same and may be more with the
              if statement, because the 'if statement' condition is evaluated 
              every iteration of the inner loop and only filters out the need 
              for calculation of the n_agents distances that are along the zero
              diagonal of the imaginary distance matrix.</p>
              <p>Modify the code again so that: 'n_agents = 3'; the print 
              statement that was commented out is no longer commented out; and, 
              so that the operator in the 'if statement' is a '&lt;'):</p>
              <pre><code class="language-python">if i < j:</code></pre>
              <p>Run the program again and you should get the following output:
              </p>
              <pre>i 0 j 1
              i 0 j 2
              i 1 j 2</pre>
              <p>Understand that the maximum distance can be calculated by 
              finding the maximum distance between the coordinates as indexed. 
              It may help you appreciate this if you run for 'n_agents = 5' or 
              'n_agents = 10' and analyse the output.</p>
              <p>Comment out the print statement again and record timings again 
              for 'n_agents = 1000'. You should get the same max_distance result 
              calculated previously, but the processing time should be roughly 
              half.</p>
              <p>An even faster way involves modifying the loops and removing 
              the 'if statement'. Can you work out how to do it? (Hint: 
              Change the range function of the inner for loop to start at index
              i + 1).</p>
              <p>Once you've given this a try, compare your answer with
              <a href="../../resources/abm3/timing2.py">this one</a> in which
              the code has been simplified a little and the following graph of 
              results was obtained:</p>
              <img src="../../resources/abm3/Figure_2.png" 
              alt="Another graph of time (y axis) and n_agents (x axis)" />
              """);
        
        s = addSection("4", "Other distance statistics", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>In calculating the maximum distance, a lower bound of 0 was 
              used to initialise the max_distance variable. To calculate the 
              minimum distance, then either an upper bound is wanted, or the 
              initial minimum distance should be set to be a distance between 
              any two different agents. The upper bound of the distance 
              between two agents in Euclidean space is theoretically 
              infinite.</p>
              """);
        w.add("<p>From the "
              + c.index.getReference("Python math", "math module", s.sid)
              + " the following can be used for positive infinity:</p>");
        w.add("""
              <pre><code class="language-python">math.inf</code></pre>
              <p>Write a function that calculates the minumum distance between 
              all the agents and record timings of how long it takes to 
              calculate both the maximum and minimum distances using the two 
              different functions.</p>
              <p>Change your code so that it calculates both the minimum and 
              maximum distances in a single function and returns the result in 
              a Tuple. If you have not done so, change the code so that the 
              maximum and minumum distances are calculated using the same set of 
              nested loops. You should find that this is significantly quicker 
              than calculating all the distances twice. Write a brief document 
              about the timings, save it and commit this to your repository 
              along with your code.</p>
              <p>As well as the maximum and minimum distance, you might want to
              calculate other statistics, such as the average distance.</p>
              <p>The 
              <a href="https://en.wikipedia.org/wiki/Arithmetic_mean">arithmetic mean</a> 
              average can be calculated with one run through the data. To 
              calculate the
              <a href="https://en.wikipedia.org/wiki/Standard_deviation">standard deviation</a>, 
              it is first necessary to know the arithmetic mean. So, it is 
              necessary in calculating the standard deviation to iterate over 
              the data values a second time. The 
              <a href="https://en.wikipedia.org/wiki/Median">median</a>
              and
              <a hre="https://en.wikipedia.org/wiki/Mode_(statistics)">mode</a>
              could be calculated with a single run through the data. For 
              calculating the median the data needs to be sorted. Calculating 
              the mode of a continuous variable is often not useful. Anyway, for 
              a mode calculation, a dictionary can be used to store a count for 
              each value and then return the value for which the count is 
              highest.</p>
              <p>Practising calculating such summary statistics from first 
              principles is a good way to develop programming skills, so if 
              you want the extra practise then have a go. Perhaps try 
              calculating a truncated mean of distances ignoring a proportion 
              of the highest and lowest distances. Think about how you would 
              test to ensure your code produces correct results.</p>
              <p>Replace the get_max_distance() in model.py with the new faster 
              version you have developed.</p>
              <p>Commit changes to your local repository and assuming you are 
              using GitHub - push your changes there.</p>
              """);
        
        s = addSection("5", "Movement", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>Currently, in 'model.py' agents move once. The code will now be 
              changed to move them a number of times. After initialising
              'n_agents', initialise a variable called 'n_iterations' and set it 
              equal to 1000.</p>
              """);
        w.add("<p>Create a new outer "
                + c.index.getReference("Python for", "for loop")
                + " to loop through moving agents n_iteration times. An outer"
                + " loop is wanted rather than an inner loop as in each"
                + " iteration agents are to move in turn rather than each agent "
                + " taking all their turns before any others.</p>");
        w.add("""
              <p>The agents move randomly, and the more of them there are, the 
              more spread out they are likely to become.</p>
              <p>Edge effects are important to consider in geographical data 
              analysis and modelling. The agents currently have a theoretically 
              infinite two dimensional (2D) area to move in. We want to restrict 
              agents to move in a more constrained area. Constrain agents to a   
              rectangluar area by limiting the x and y coordinates using the 
              following code blocks:</p>
              <pre><code class="language-python"># Variables for constraining movement.
              # The minimum x coordinate.
              x_min = 0
              # The minimum y coordinate.
              y_min = 0
              # The maximum x coordinate.
              x_max = 99
              # The maximum y coordinate.
              y_max = 99</code></pre>
              <pre><code class="language-python"># Apply movement constraints.
              if agents[i][0] < x_min:
                  agents[i][0] = x_min
              if agents[i][1] < y_min:
                  agents[i][1] = y_min
              if agents[i][0] > x_max:
                  agents[i][0] = x_max
              if agents[i][1] > y_max:
                  agents[i][1] = y_max</code></pre>
              <p>Insert the first code block at the top of 'model.py' with 
              the other initialised variables. Insert the other code block as 
              part of moving each agent.</p>
              <p>After having moved each agent, the code could loop through the 
              agents again to constrain movement, but this would be less 
              efficient than constraining within same loop as moving each 
              agent.<p>
              <p>Commit your code to your local repository and assuming you 
              are using GitHub - push your changes to GitHub.</p>
              """);
        w.add("</div>");
    }
}
