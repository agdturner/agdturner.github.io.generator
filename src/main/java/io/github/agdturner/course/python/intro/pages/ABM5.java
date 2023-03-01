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
 * For Python Intro Course ABM5 Page.
 *
 * @author Andy Turner
 */
public class ABM5 extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public ABM5(PythonIntroCourse c) {
        super("abm5", "Agent Based Model Part 5", "ABM5", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2 id="1">1. Introduction and Preparation</h2>
              <p>In this part the ABM will be enhanced by loading spatial data 
              representing an environment from a file, agents will interact with 
              the environment in a simplistic way, and an output file will be 
              generated.</p>
              <p>In your local code repository src directory create a new 
              directory called "abm5". Open Spyder and use "save as" to save 
              your "model.py" and "agentframework.py" files from abm4 into the 
              abm5 directory. Create a new directory at the same level as your 
              "src" directory called "data" and within this create new 
              directories called "input" and "output". These directories will be 
              used to store the model data separately to the program source 
              code.</p>
              
              <h2 id="2">2. Input Data</h2>
              <p>Download/save into your newly created input data directory the 
              text file:
              <a href="../../resources/abm5/in.txt">in.txt</a></p>
              <p>Open the file in a text editor. Note that the file is made up 
              of lines of Integer numbers separated with commas. Essentially, 
              the file is a rectangular data file with 300 lines each with 300 
              values.</p>
              <p>Create a new source code file named "io.py" in the abm5 
              directory, add the following lines:</p>
              <pre><code class="language-python">import csv
              
              # Read input data
              f = open('../../data/input/in.txt', newline='')
              data = []
              for line in csv.reader(f, quoting=csv.QUOTE_NONNUMERIC):
                  row = []
                  for value in line:
                      row.append(value)
                      #print(value)
                  data.append(row)
              f.close()
              print(data)</code></pre>
              <p>Run this new file. The output should correspond to the input 
              data file only the values are presented with ".0" added as they 
              have been loaded as Float type numbers.</p>
              <p>Note that the data variable is a list of lists. Essentially 
              the list is the rows of data and the lists are the values in the 
              columns for each row.</p>
              <p>Change the code block into a function called 'read_data' that 
              returns the data variable. Write code to call this function from 
              model.py by adding the following import statement:</p>
              <pre><code class="language-python">import io</code></pre>
              <p>After the import statements try to call the read_data function
              using:</p>
              <pre><code class="language-python">environment = io.read_data()</code></pre>
              <p>You should encounter an error along the lines of the following:
              </p>
              <pre>Traceback (most recent call last):
              
                File "\\src\\abm5\\model.py", line 19, in <module>
                  environment = io.read_data('../../data/input/in.txt')
              
              AttributeError: module 'io' has no attribute 'read_data'</pre>
              <p>This error occurs because there is a name collision - 'io' is 
              also a python standard library module and this is what is imported 
              instead of the module you have just created.</p>
              <p>To overcome this error there is a need to package the module. 
              This involves creating a directory, moving io.py into it and 
              modifying the import statement. In the abm5 directory, create a 
              directory called "my_modules" and move both io.py and 
              agentframework.py into it. Change the respective import statements 
              in model.py to be:</p>
              <pre><code class="language-python">import my_modules.agentframework as af
              import my_modules.io as io</code></pre>
              <p>Run model.py and it should now run without the error. (If you 
              still get an error then try restarting Spyder.)</p>
              <p>Change the function read_data so it checks that each row of 
              data contains the same number of values. Also change the function 
              so it returns the number of lines (n_rows) and number of values 
              in each line (n_cols) as well as data.</p>
              
              <h2 id="3">3. Plot environment</h2>
              <p>Assume that each row aligns with a y-coordinate and each column 
              aligns with an x-coordinate.</p>
              <p>To plot the agents on the environment add the following at the 
              start of the plotting section:</p>
              <pre><code class="language-python">plt.imshow(environment)</code></pre>
              <p>Change the initialisation of x_max and y_max to be as follows:
              </p>
              <pre><code class="language-python"># The maximum an agents x coordinate is allowed to be.
              x_max = n_cols - 1
              # The maximum an agents y coordinate is allowed to be.
              #y_max = 99
              y_max = n_rows - 1</code></pre>
              <p>A plot should be produced that looks like:</p>
              <p><img src="../../resources/abm5/Figure_1.png" 
                alt="A plot of agents on the environment." /></p>
              <p>The pattern of agent locations is the same, although the plot 
              y-axis has flipped and the x-axis and y-axis now have the same 
              increments so the the pattern is more squashed along the x-axis. 
              Limit the plot axes and flip the y-axis back by adding the 
              following code before the plot.show() function is called:</p>
              <pre><code class="language-python">plt.ylim(y_min, y_max)
              plt.xlim(x_min, x_max)</code></pre>
              <p>The output plot should now look like:</p>
              <img src="../../resources/abm5/Figure_2.png" 
                alt="A plot of agents on a limited part of the environment." />
              <p>Currently, the agents are being initialised in a corner of the 
              environment. Change the code so that they are initialised in the 
              middle by modifying the constructor method. A good way to do this 
              is to pass in n_rows and n_cols and use these parameters to 
              initialise the x and y coordinates as follows:</p> 
              <pre><code class="language-python">def __init__(self, i, n_rows, n_cols):
                  \"""
                  The constructor method.

                  Parameters
                  ----------
                  i : Integer
                      To be unique to each instance.
                  n_rows : Integer
                      The number of rows in environment.
                  n_cols : Integer
                      The number of columns in environment.
                  Returns
                  -------
                  None.
                  \"""
                  self.i = i
                  tnc = int(n_cols / 3)
                  self.x = random.randint(tnc - 1, (2 * tnc) - 1)
                  tnr = int(n_rows / 3)    
                  self.y = random.randint(tnr - 1, (2 * tnr) - 1)</code></pre>
              <p>When calling the constuctor method pass in the variables n_rows 
              and ncols. Run model.py. The output plot should look like the 
              following:</p>
              <img src="../../resources/abm5/Figure_3.png" 
                alt="A plot of agents on the environment in the middle." />
              <p>Note that although the random seed has not changed, the pattern 
              of agent locations is different. This is because the calls to 
              random.randint are different and produce different coordinates. 
              The pattern could be kept the same if 100 was added to the x and 
              y values. The following code would do this and effectively 
              initialise agents in the central third of a similar rectangular 
              environment irrespective of the number of rows and columns:</p>
              <pre><code class="language-python">tnc = int(n_cols / 3)
              self.x = random.randint(0, tnc - 1) + tnc
              tnr = int(n_rows / 3)
              self.y = random.randint(0, tnr - 1) + tnr</code></pre>
              
              <h2 id="4">4. Agent-Environment Interaction</h2>
              <p>Imagine that the environment values represent resources that 
              can be eaten/stored by Agent class instances (agents).</a>
              <p>Change the constructor method of the Agent class again so that 
              environment is also expected to be passed in and keep a reference 
              to this as a class attribute. Also create a store attribute and 
              set this equal to zero:</p>
              <pre><code class="language-python">def __init__(self, i, environment, n_rows, n_cols):
              \"""
              The constructor method.

              Parameters
              ----------
              i : Integer
                  To be unique to each instance.
              environment : List
                  A reference to a shared environment
              n_rows : Integer
                  The number of rows in environment.
              n_cols : Integer
                  The number of columns in environment.
              
              Returns
              -------
              None.

              \"""
              self.i = i
              self.environment = environment
              self.x = random.randint(n_cols/3 - 1, 2 * n_cols / 3)
              self.y = random.randint(n_rows/3 - 1, 2 * n_rows / 3)
              self.store = 0</code></pre>
              <p>Change model.py so that environment is passed in correctly as 
              agents are initialised.</p>
              <p>In the Agent class define the following method:</p>
              <pre><code class="language-python">def eat(self):
                  if self.environment[self.y][self.x] &gt;= 10:
                      self.environment[self.y][self.x] -= 10
                      self.store += 10</code></pre>
              <p>This method checks the value of the environment where the agent
              is located and if this is greater than or equal to 10, the value 
              of the environment where the agent is located is reduced by 10 and 
              10 is added to the store attribute of the agent.</p>
              <p>Write a docstring for the method eat().</p>
              <p>In model.py call the method eat() after the move function
              and run the program. The environment in the plot should have 
              changed around where the agents are plotted, but this is difficult 
              to see.</p>
              <p>Change the plot limits for a closer look at the centre of the 
              environment as follows:</p>
              <pre><code class="language-python">plt.ylim(y_max / 3, y_max * 2 / 3)
              plt.xlim(x_max / 3, x_max * 2 / 3)</code></pre>
              <p>Run the program again and you should get the following image:
              </p>
              <img src="../../resources/abm5/Figure_4.png" 
              alt="A plot of agents on a limited part of the environment with part of it eaten away and the agents centralised." />
              <p>Note that two of the agents have moved to the right beyond the 
              limited area.</p> 
              <p>Increase n_iterations to 100 and run again and you should get 
              the following image:</p>
              <img src="../../resources/abm5/Figure_5.png" 
                alt="A plot of agents on a limited part of the environment with part of it eaten away." />
              <p>Note that there is a checkerboard effect. This is a consequence 
              of how the agents move!</p>
              <p>Commit your code to your local repository and assuming you are 
              using GitHub - push your changes to GitHub.</p>
              
              <h2 id="5">5. Further Assignment 1 Coding Tasks</h2>
              <p>For the method eat() in the Agent class, detail an Else clause 
              for the If Statement so that if the value of environment where the 
              agent is located is less than or equal to 10 then what is there is 
              removed and added to the store of the agent. Test this works and 
              write a brief document about the testing. Consider what happens 
              when two or more agents are at the same location and there is less 
              resource at the location for all the agents to have 10... Those 
              agents processed first will get more... And if we always process 
              agents in the same order, then some agents will eat more as 
              resources become limited... Keep this in mind and write a comment 
              in your source code about it. 
              <p>Define a function in model.py that adds up all the values in 
              environment.</p>
              <p>Define another function that adds up all the store values in 
              all the agents.</p>
              <p>Print out these sums and check that the total amount of 
              resource and store in the system is not changing after each
              iteration of the model.</p>   
              <p>Define a function to write out the values of environment to a 
              file and call this function after the main model loop.</p>
              <!--
              <p>Set some of the model parameters towards the start of 
              the program using keyboard input such like:</p>
              <pre><code class="language-python">n_agents = int(input("Set n_agents: Key in a positive integer then press <ENTER>:"))</code></pre>
              <p>Get agents to optional stay still or moving left, right, up or down and not just diagonally.</p>
              <p>Get agents to move or eat but not both in an iteration.</p>
              -->
              <p>Commit your code to your local repository, and assuming you are 
              using GitHub - push your changes to GitHub.</p>
              """);
//              <pre></pre>
//              <pre><code class="language-python"></code></pre>
//              <p></p>
//              <pre></pre>
//              
    }
}