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
              <h2>1. Recap</h2>
              <p>Your ABM code should look something like the following:</p>
              <pre><code class=\"language-python\">import random
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
              diff_x = x0 - x1
              # Calculate the difference in the y coordinates.
              diff_y = y0 - y1
              # Square the differences and add the squares
              ssd = (diff_x * diff_x) + (diff_y * diff_y)
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
              <p>And the following image:</p>
              <img src="../../resources/abm2/Figure_1.png" alt="ABM2 Output Plot" />
              <p>Note that: In the code above, some of the print statements have 
              been commented out to reduce the amount of text output. The 
              program output reveals movement of agents, which move only once: 
              It could be easier to interpret the program output if there was a 
              bit more information printed out.</p>
              <p>In your local code repository src directory create a new 
              directory called "abm3". Open Spyder and use "save as" to save 
              your "model.py" file into the abm3 directory.</p>
              
              <h2>2. Distance Calculations</h2>
              
              <h3>2.1 Define a Function</h3>
              <p>Change the distance calculation code into a function called 
              get_distance: Use the def keyword and specify four input 
              parameters (x0, y0, x1, y1). Recall that the function declaration 
              ends with a colon (:). Indent the code that does the calculation. 
              At the end of the function return the distance calculated. After 
              the end of the function write a statement to call the function and 
              print out the result. Run the code to test this works. Simplify 
              the code by removing one of the ways the square root is 
              calculated and in other ways you think are approriate. Next, 
              change the comment that describes the function into a docstring 
              and clarify what the inputs and outputs are.</p>
              
              <h3>2.2 Calculate the maximum distance</h3>
              <p>Consider a two dimensional matrix organised in rows and columns
              where the cells are distances between an agent for the row and an
              agent for the column, and the rows and the columns represent all 
              the agents in the same sequence. Where the row and column indexes 
              are the same, the distance values should be zero and the matrix 
              should be symmetrical about this diagonal. This is because the 
              distance between agent a and agent b is the same as the distance 
              between agent b and agent a. So, really to calculate the maximum
              distance there is only a need to calculate and find the maximum of 
              distance for less than half of this matrix of distances.
              </p> 
              <p>To calculate the maximum distance, we can use nested loops. An 
              outer loop to go through all the agents, and an inner loop to go 
              through all agents. Within the inner loop we can use the function 
              get_distance() to calculate the distances between two agents. 
              Using the max() function we can find the maximum of two values. 
              By setting max_distance within the loop to be the maximum of 
              max_distance and the distance between the two agents, once all 
              combinations have been computed - at the end of the loops - 
              max_distance should store the maximum distance between any two 
              agents. Some code for doing this is as follows:</p>
              <pre><code class=\"language-python\">max_distance = 0
              for a in agents:
                  for b in agents:
                      distance = get_distance(a[0], a[1], b[0], b[1])
                      print("distance between", a, b, distance)
                      max_distance = max(max_distance, distance)
                      print("max_distance", max_distance)</code></pre>
              <p>Examining the program output, it is clear that some zero 
              distances calculated. These will either be where an agent is 
              located at the same place as another agent, or where the
              calculation is for the same agent.</p>
              <p>Recall that there are two main ways to iterate over the items 
              in a list. As above, and alternatively using the list indexes. It 
              is common to use range() to get a sequence of indexes. So, the 
              looping can also be done as follows:</p>
              <pre><code class=\"language-python\">max_distance = 0
              for i in range(len(agents)):
                  a = agents[i]
                  for j in range(len(agents)):
                      b = agents[j]
                      distance = get_distance(a[0], a[1], b[0], b[1])
                      print("distance between", a, b, distance)
                      max_distance = max(max_distance, distance)
                      print("max_distance", max_distance)</code></pre>
              <p>Notice that this code uses variables i and j for the indexes 
              given sequencially by range() and len() is used to get the length 
              of the agents list. As this is the same as n_agents, we could 
              alternatively use that - which would be slightly more efficient.
              </p>
              <p>Now, define a function called get_max_distance that uses the 
              above code and returns the max_distance. This is like the exercise 
              of defining get_distance(). It is good to practise turning code 
              into functions.</p>
              <p>Your distance function should look something like the 
              following:</p>
              <pre><code class=\"language-python\">def get_distance(x0, y0, x1, y1):
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
              <p>Test your get_max_distance function.</p>
              <p>Try calling the get_max_distance function to calculate the 
              maximum distance between all the agents just after they have been 
              initialised. You may encounter:</p>
              <pre>NameError: name 'get_max_distance' is not defined</pre>
              <p>This may seem strange until you remember that in Python the 
              interpretter needs to have read a function definition in order to 
              know what it is. So, rearrange your code so that the functions are 
              towards the top and are defined before they are called. Probably 
              the best place to move them is just after the variable n_agents 
              is initialised.</p>
              
              <h2>3. Timing</h2>
              <p>We will use the time module to test the efficiency of code and 
              see how well it scales for some larger numbers of agents. Add the 
              following import statement along with the others:</p>
              <pre>import time</pre>
              <p>Before calculating the maximum distance between the initialised 
              agents add the following line:</p>
              <pre>start = time.perf_counter()</pre>
              <p>After calculating the maximum distance add the following:</p>
              <pre>end = time.perf_counter()
              print("Time taken to calculate maximum distance", end - start)</pre>
              <p>Run the program and check the time taken to calculate maximum 
              distance. It could register 0.0 for 10 agents. This does not mean 
              that the processing took no time, but it was very quick. (There is 
              a higher temporal resolution timer perf_counter_ns() that could be 
              used, but we've no need...</p>
              <p>We are going to explore two things:</p>
              <ol>
              <li>How does the processing time scale as n_agents increases?</li>
              <li>Other potentially more optimal ways of calculating the 
              maximum distance between agents.
              </li>
              </ol>
              <p>Let's begin with the first of these things:</p>
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
              max_distance(): Modify your loop so that it runs for just once, 
              for n_agents = 3. Add the following print statement to the inner 
              loop of get_max_distance():</p>
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
              <li>In the inner loop of get_max_distance() add an If Statement to
              exclude when i = j in the calculation (Hint: use the Not Equals 
              Operator (!=)). Run the program again and compare the output with
              the previous run:</li>
              <pre>i 0 j 1
              i 0 j 2
              i 1 j 0
              i 1 j 2
              i 2 j 0
              i 2 j 1</pre>
              <p>Comment out the print statement and run the code for 1000 
              agents. Compare the processing time without the if statement.</p>
              <p>The timing with the If Statement is about the same. It may 
              sometimes be slower as calculating whether on not to do the 
              calculation is about as computationally demanding as simply doing 
              it!</p>
              <p>Modify the If Statement added in the loop so that it only 
              considers the distance between a and b and not b and a or vice 
              versa. One way to do this is to change the operator in the If 
              Statement. (Hints: Set n_agents to a small number and uncomment 
              the Print Statement to test. Try the Less Than (<) or Greater Than 
              (>) operator).</p>
              <p>Run again for n_agents = 1000, (after commenting out the Print
              Statement). You should get the same max_distance result calculated 
              previously, but the run time should be roughly half.</p>
              <p>There is a way to do this even faster by modifying the loops 
              and removing the If Statement. Can you work out how to do it? 
              (Hint: Change the range function of the inner ForLoop to begin at 
              i).</p>
              <p>Once you've given this a try, compare your answer with
              <a href="../../resources/abm3/timing2.py">this one</a> in which
              the code has been simplified a little and the following graph of 
              results was obtained:
              <img src="../../resources/abm3/Figure_2.png" 
              alt="Another graph of time (y axis) and n_agents (x axis)" /></p>
              
              <h2>4. Other distance statistics</h2>
              <p>In calculating the maximum distance, a lower bound of 0 was 
              used to initialise the max_distance variable. If you were trying 
              to calculate the minimum distance, then an upper bound would be 
              wanted, or the initial minimum distance would have to be set to be 
              between any two non identical agents. The upper bound of the 
              distance between two agents in Euclidean space is theoretically 
              infinite. From the math module the following can be used for 
              positive infinity:</p>
              <pre>math.inf</pre>
              <p>Write a function that calculates the minumum distance between 
              all the agents.</p>
              <p>Suppose, you wanted to know both the minimum and maximum 
              distances, then it would be faster to have a single function that 
              calculates both these statistics in the same loops, returning the 
              result in a Tuple. At some stage, not necessarily right away, but 
              working on your own, attempt this and compile a brief document 
              that compares the timings. Save the document and commit this to 
              your repository along with your code. This code and the 
              accompanying will be summatively assessed as part of the portfolio 
              submission for Assignment 1.</p>
              <p>There may be other statistics that you might want to generate 
              such as the average distance. The 
              <a href="https://en.wikipedia.org/wiki/Arithmetic_mean">arithmetic mean</a> 
              average can be calculated with one run through the data. To 
              calculate the
              <a href="https://en.wikipedia.org/wiki/Standard_deviation">standard deviation</a>, 
              it is first necessary to known the arithmetic mean. So, it is 
              necessary in calculating the standard deviation to iterate over 
              the data values a second time. The 
              <a href="https://en.wikipedia.org/wiki/Median">median</a>
              and
              <a hre="https://en.wikipedia.org/wiki/Mode_(statistics)">mode</a>
              could be calculated with a single run through the data, but for 
              these two statistics, it might be easier to use an inbuilt 
              function to sort or order the data values.</p>
              <p>Learning how to calculate these kinds of statistics from first 
              principles is a good way to develop programming skills, so if 
              you want the extra practise then have a go. Try to think about how 
              you would test your code before you start.</p>
              <p>Replace the get_max_distance() in model.py with the new faster 
              version.</p>
              <p>Commit changed to your local repository and assuming you are 
              using GitHub - push your changes there.</p>
                                                          
              <h2>5. Movement</h2>
              <p>Currently, our program moves all agents once, but we want them 
              to move a number of times. As well as moving, we'll want them to 
              maybe do other things iteratively depending on the environment at 
              a location and the what other agents are nearby (and possibly what 
              they are doing). So, after setting n_agents, initialise a new 
              variable called n_iterations and set it equal to 1000.</p>
              <p>Create a new For Loop to loop through moving agents n_iteration 
              times.</p>
              <p>What we'll want is that in each iteration all the agents move 
              and possibly interact. So, we don't want to move one agent a 
              number of times and then move the next a number of times, we want 
              to move all agents once, and then move all agents again. (We can 
              worry about whether the order of movement matters later.) So, the 
              iteration For Loop should be an outer loop and the loop for moving 
              the agents wants to be within it.</p>
              <p>The agents are moving randomly, and the more of them there are, 
              the more spread out they are likely to become. Edge effects are a 
              major issue in geographical modelling. Our agents currently have a 
              theoretically infinite two dimensional (2D) area to move in. What 
              we want to do soon is to load in some 2D environment data so that 
              the agents can interact with it. To keep the model simple, let's 
              restrict the movement of agents to stay within a rectangluar area
              by limiting the x and y coordinates using the following code:</p>
              <pre># Bounds for restricting agents movement
              # The minimum an agents x coordinate can be
              x_min = 0
              # The minimum an agents y coordinate can be
              y_min = 0
              # The maximum an agents x coordinate can be
              x_max = 99
              # The maximum an agents y coordinate can be
              y_max = 99
              # Keep agents in bounds.
              if agents[i][0] < x_min:
                  agents[i][0] = x_min
              if agents[i][1] < y_min:
                  agents[i][0] = y_min
              if agents[i][0] > x_max:
                  agents[i][0] = x_max
              if agents[i][1] > y_max:
                  agents[i][1] = y_max</code></pre>
              <p>The variables x_min, y_min, y_max, and y_max can be initialised 
              outside of the loop (perhaps best placed with all the other 
              initialised variables towards the top of the code). The correction 
              code should be added at the end of the loop where each agents is 
              moved. There is no need to loop through the agents again to 
              apply the correction.<p>
              <p>Commit your code to your local repository and assuming you 
              are using GitHub - push your changes to GitHub.</p>
              """);
        w.add("</div>");
    }
}
