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
        w.add("""
              <h2 id="1">1. Recap</h2>
              <p>Your ABM code should look something like the following:</p>
              <pre><code class="language-python">import random
              import math
              import matplotlib
              from matplotlib import pyplot as plt
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
              been turned into comments. This reduces the amount of text output
              in the console which is desirable as now things have been tested, 
              this output is no longer very useful and it slows down the program
              execution. The text output in the console is a print of the agent 
              coordinates before and then after a single move.</p> 
              <p>In your local code repository src directory create a new 
              directory called "abm3". Open Spyder and use "save as" to save 
              your "model.py" file into the abm3 directory.</p>
              
              <h2 id="2">2. Distance Calculations</h2>
              
              <h3 id="2.1">2.1 Define a Function</h3>
              <p>Change the distance calculation code into a function called 
              get_distance: Use the def keyword and specify four input 
              parameters (x0, y0, x1, y1). Recall that the function declaration 
              ends with a colon ':'. The code of the function must be indented. 
              Return the distance calculated as the last statement of the 
              function using the keyword 'return' followed by the name of the 
              variable. After the function write a statement to call it and 
              print out the distance returned.</p>
              <p>Run the code to test it works</p>
              <p>If your code calculates the square root in two ways, then 
              simplify it by removing one of these ways. You may want to 
              simplify the code in other ways too...</p>
              <p>Change the comment that describes the function into a 
              docstring. Clarify what the inputs and outputs are in the 
              docstring.</p>
              
              <h3 id="2.2">2.2 Calculate the maximum distance</h3>
              <p>Imagine a two dimensional matrix of distances where each 
              distance is the distance between the cooridnate for a row and the 
              coordinate for a column. If all the coordinates for the rows and 
              columns are the same and in the same order, then the matrix is 
              symetrical about a diagonal where all the distances are zero.</p>
              <p>The maximum distance between any two agents is the maximum 
              distance in this matrix. Nested loops can be used to calculate it.
              An outer loop to go through all the agents, and an inner 
              loop to go through all agents. Within the inner loop we can use 
              the function get_distance() to calculate the distance between a 
              pair of coordinates, and the max() function to calculate the
              maximum distance encountered yet. Some code for doing this is as 
              follows:</p>
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
              calculation is for the same agent.</p>
              <p>Recall that there are two main ways to iterate over the items 
              in a list. As above, and alternatively using the list indexes. It 
              is common to use range() to get a sequence of indexes, and the 
              looping can also be done as follows:</p>
              <pre><code class="language-python">max_distance = 0
              for i in range(len(agents)):
                  a = agents[i]
                  for j in range(len(agents)):
                      b = agents[j]
                      distance = get_distance(a[0], a[1], b[0], b[1])
                      print("distance between", a, b, distance)
                      max_distance = max(max_distance, distance)
                      print("max_distance", max_distance)</code></pre>
              <p>Notice that this code uses variables i and j for the indexes 
              given sequencially by range(), and len() is used to get the length 
              of the agents list. (Also, as len(agents) is the same as n_agents,
              we could alternatively be using n_agents as a parameter for the 
              range function. This would save a calculation and be slightly more 
              efficient. As the length of the agents list is something that we 
              may want to change, keep using len(agents) for now...</p>
              <p>Define a function called get_max_distance that uses the 
              above code and returns the max_distance. This is like the exercise 
              of defining get_distance(). It is good to practise turning code 
              into functions as it is a key programming skill.</p>
              <p>Your get_distance function should look something like the 
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
              <p>Use your get_max_distance function to calculate the maximum 
              distance between all the agents just after they have been 
              initialised. You may encounter:</p>
              <pre>NameError: name 'get_max_distance' is not defined</pre>
              <p>Recall that the Python interpreter needs to have read a 
              function definition before the function is called. So, if you 
              encounter this error, then rearrange your code so that the 
              function is defined before it is called.</p>
              
              <h2 id="3">3. Timing</h2>
              <p>This section is about using the time module to report timings
              and explore the efficiency of different adaptions of the code.</p>
              <p>Add the following import statement along with the others
              towards the top of the source code:</p>
              <pre>import time</pre>
              <p>Before calculating the maximum distance between the initialised 
              agents add the following line:</p>
              <pre>start = time.perf_counter()</pre>
              <p>This sets the variable start to a time variable which is the 
              number of second since the computer was last rebooted. After 
              calculating the maximum distance add the following:</p>
              <pre>end = time.perf_counter()
              print("Time taken to calculate maximum distance", end - start, "seconds")</pre>
              <p>This should calculate and report a time interval. So, run 
              your program and check the time taken to calculate maximum 
              distance. It could report 0.0 seconds for 10 agents. This does not 
              mean that the processing took no time, but it was very quick and 
              closer to zero milliseconds than one. (There is a higher temporal 
              resolution timer perf_counter_ns() that could be used, but we have no need for it.)</p>
              <p>We are going to explore two things:</p>
              <ol>
              <li>How does the processing time scale as n_agents increases?</li>
              <li>Other potentially more optimal ways of calculating the 
              maximum distance between agents.
              </li>
              </ol>
              <p>Begin with the first of these things:</p>
              <ul>
              <li>Save your source code file with a new name, for example 
              "timing.py".</li>
              <li>Increase n_agents to 500 and run the program again. Notice 
              that the plotting is a little delayed and printing out the agents 
              now clutters the text output. (Printing is slow and can effect 
              timing significantly - much more so than writing results to a 
              file. Typically anything to do with display is slow compared with 
              reading and writing data, and numerical data processing.)</li>
              <li>Comment out the printing of the agents and the code for 
              plotting agents.</li>
              <li>Run again, it should now be easy to see the time taken to 
              calculate the maximum distance between agents, which is expected
              to be a fraction of a second.</li>
              <li>Run again and compare the timing. It is likely to vary a bit 
              from one run to another. (The amount of computation is the same, 
              but timings depend also on what else the system is doing. 
              Processing is generally slower if the system is busy.)</li>
              <li>Adapt your code to:
              <ol>
              <li>Create a loop to run for a range of n_agents.</li>
              <li>Create a list to store the store the timing results.</li> 
              <li>Create a plot with time on one axis and n_agents on the other
              </li>
              </ol>
              <li>Experiment with your range function to get an interesting 
              plot.</li>
              </ul>
              <p>Recall that when learning to code, it is helpful to think about 
              and experiment with how to do something working systematically. 
              So, give this coding challenge a try: Spend at least 10 minutes 
              puzzling over it. If you manage to complete it within this time, 
              then great, if not, then don't worry.</p>
              <p>Once you have given this a try, then compare your efforts 
              with
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
              <p>Let's now attempt to optimise the calculation of 
              max_distance(): Modify your code so that n_agents = 3, and add the 
              following print statement to the inner loop of get_max_distance():
              </p>
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
              <li>Change what is in the inner loop of get_max_distance() to be 
              within an If Statement that is only run when i does not equals j
              using the Not Equals operator '!='. The if statement will look 
              like:</p>
              <pre><code class="language-python">if i != j:</code></pre>
              Run the program again and you 
              should see the following printed in the text output:</li>
              <pre>i 0 j 1
              i 0 j 2
              i 1 j 0
              i 1 j 2
              i 2 j 0
              i 2 j 1</pre>
              <p>Compare the output with the previous run. There is less output 
              as when the indexes are the same, the calculations are skipped.
              </p>
              <p>Comment out the print statement and run the code for 1000 
              agents. Compare the processing time with/without the if statement.
              </p>
              <p>The timing with the If Statement is about the same. It may be 
              slower - as calculating whether on not to do the calculation is 
              about as much computation as doing the calculation.</p>
              <p>Modify the code again so that n_agents = 3, the print statement 
              that was commented out is not commented out again, and so that the
              operator in the If Statement is a Less Than '@lt;' operator):</p>
              <pre><code class="language-python">if i < j:</code></pre>
              <p>Run the program again and you should get the following output:
              </p>
              <pre>i 0 j 1
              i 0 j 2
              i 1 j 2</pre>
              <p>Understand that the maximum distance can be calculated by 
              finding the maximum distance between the coordinates as indexed. 
              It may help you understand if you run for n_agents = 5 or 10.</p>               
              <p>Comment out the print statement and record timings again for
              n_agents = 1000. You should get the same max_distance result 
              calculated previously, but the processing time should be roughly 
              half.</p>
              <p>There is a faster way which involves modifying the loops and 
              removing the If Statement. Can you work out how to do it? (Hint: 
              Change the range function of the inner For Loop to begin at 
              i + 1).
              </p>
              <p>Once you've given this a try, compare your answer with
              <a href="../../resources/abm3/timing2.py">this one</a> in which
              the code has been simplified a little and the following graph of 
              results was obtained:
              <img src="../../resources/abm3/Figure_2.png" 
              alt="Another graph of time (y axis) and n_agents (x axis)" /></p>
              
              <h2 id="4">4. Other distance statistics</h2>
              <p>In calculating the maximum distance, a lower bound of 0 was 
              used to initialise the max_distance variable. To calculate the 
              minimum distance, then either an upper bound is wanted, or the 
              initial minimum distance should be set to be a distance between 
              any two non identical agents. The upper bound of the distance 
              between two agents in Euclidean space is theoretically 
              infinite. From the math module the following can be used for 
              positive infinity:</p>
              <pre>math.inf</pre>
              <p>Write a function that calculates the minumum distance between 
              all the agents and record timings of how long it takes to 
              calculate both the maximum and minimum distances using the two 
              different functions.</p>
              <p>For Assignment 1, working on your own, change your code so that 
              it calculates both the minimum and maximum distances in a single 
              function and returns the result in a Tuple. Change the code so 
              that the maximum and minumum distances are calculated using the 
              same set of nested loops which you should find is a lot faster. 
              Write a brief document about the timings, save it and commit this 
              to your repository along with your code.
              </p>
              <p>As well as the maximum and minimum distance, you might want to
              calculate other statistics, such as the average distance. The 
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
              calculating the median the data needs to be sorted, and for 
              calculating the mode it might be best to use a dictionary to store 
              the count. However as distance is a continuous, the mode is 
              probably not a very useful statistic.</p>
              <p>Learning how to calculate these summary statistics from first 
              principles is a good way to develop programming skills, so if 
              you want the extra practise then have a go. Perhaps try 
              calculating a truncated mean of distances ignoring the 10% of 
              highest and lowest distances. Think about how you would test to 
              ensure your code produces correct results.</p>
              <p>Replace the get_max_distance() in model.py with the new faster 
              version you have developed.</p>
              <p>Commit changes to your local repository and assuming you are 
              using GitHub - push your changes there.</p>
                                                          
              <h2 id="5">5. Movement</h2>
              <p>Currently, our program moves all agents once, but we want them 
              to move a number of times. As well as moving, the agents are going 
              to be doing other things iteratively depending on attributes of 
              the environment at their location, and interaction with other 
              nearby agents. So, after setting n_agents, initialise a new 
              variable called n_iterations and set it equal to 1000.</p>
              <p>Create a new outer For Loop to loop through moving agents 
              n_iteration times. An outer loop rather than an inner loop as 
              what is wanted is that in each iteration all the agents move 
              and possibly interact in turn. A bit like in a roll play game, it 
              does not work if one player makes all their moves before another 
              player gets a turn.</p>
              <p>The agents are moving randomly, and the more of them there are, 
              the more spread out they are likely to become. Edge effects can be 
              a major issue in geographical modelling. Our agents currently have a 
              theoretically infinite two dimensional (2D) area to move in. What 
              we want to do soon is to load in some 2D environment data so that 
              the agents can interact with it. To keep the model simple, the 
              movement of agents is going to be restricted so that they stay 
              within a rectangluar area by limiting the x and y coordinates 
              using the following code:</p>
              <pre><code class="language-python"># Variables for constraining movement.
              # The minimum x coordinate.
              x_min = 0
              # The minimum y coordinate.
              y_min = 0
              # The maximum x coordinate.
              x_max = 99
              # The maximum y coordinate.
              y_max = 99
              # Apply movement constraints.
              if agents[i][0] < x_min:
                  agents[i][0] = x_min
              if agents[i][1] < y_min:
                  agents[i][0] = y_min
              if agents[i][0] > x_max:
                  agents[i][0] = x_max
              if agents[i][1] > y_max:
                  agents[i][1] = y_max</code></pre>
              <p>The variables x_min, y_min, y_max, and y_max are to be 
              initialised outside of the loop (perhaps best placed with all the 
              other initialised variables towards the top of the code). The 
              correction code is to become part of the loop that moves the 
              agents. There is no need to loop through the agents again to 
              apply the correction, which would also work, but would be slightly 
              less efficient.<p>
              <p>Commit your code to your local repository and assuming you 
              are using GitHub - push your changes to GitHub.</p>
              """);
        w.add("</div>");
    }
}
