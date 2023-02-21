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
              <p>The next step in developing our Agent Based Model is to load 
              some spatial data to represent a varied environment in which the 
              agents interact. The model will be changed so that the agents 
              interact with the environment in a simplistic way. Model output 
              in the form of a file will be generated.</p>
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
              <pre><code class=\"language-python\">import csv
              
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
              data file only the values are presented with ".0" added.</p>
              <p>Change the code block into a function called "read_data" that 
              returns data. Write code to call this function from model.py by 
              adding the following import statement:</p>
              <pre>import io</pre>
              <p>After the import statements try to call the read_data function
              using:</p>
              <pre>environment = io.read_data()</pre>
              <p>It is expected that you will encounter the following error:</p>
              <pre>Traceback (most recent call last):
              
                File "\\src\\abm5\\model.py", line 19, in <module>
                  environment = io.read_data('../../data/input/in.txt')
              
              AttributeError: module 'io' has no attribute 'read_data'</pre>
              <p>This is confusing until you realise that there is a name 
              collision because io is also a Python standard library and this is 
              being imported instead. Create a directory called my_modules and 
              move io.py and agentframework.py into it. Change the respective 
              import statements in model.py to be:</p>
              <pre><code class=\"language-python\">from my_modules import agentframework
              from my_modules import io</code></pre>
              <p>Your code is hopefully now correct and should run without 
              error, but if you still get a confusing error and you are using 
              Spyder, try restarting Spyder.</p>
              <p>When reading the data add code to check that each row of data 
              contains the same number of values and modify the read_data 
              function to return the number of lines (rows) and number of values 
              in each line (columns).</p>
              <p>Let's regard each row as aligning with a y-coordinate and each 
              column as aligning with an x-coordinate.</p>
              
              <h2 id="3">3. Plot environment</h2>
              <p>To plot the agents on the environment add the following at the 
              start of the plotting section:</p>
              <pre>plt.imshow(environment)</pre>
              <p>A plot should be produced that looks like:</p>
              <p><img src="../../resources/abm5/Figure_1.png" 
                alt="A plot of agents on the enviornment." /></p>
              <p>Notice that the plot y-axis has flipped. Limit the plot axes 
              and flip the y-axis back by adding the following code before the 
              plot.show() function is called:</p>
              <pre>plt.ylim(y_min, y_max)
              plt.xlim(x_min, x_max)</pre>
              <p>The output plot should now look like:</p>
              <p><img src="../../resources/abm5/Figure_2.png" 
                alt="A plot of agents on a limited part of the environment." /></p>
              
              <h2 id="4">4. Agent-Environment Interaction</h2>
              <p>Let us imagine that the environment values represent resources 
              that can be eaten/stored by agents.</a>
              <p>Add environment as a parameter to the Agent class constructor.
              Set a class attribute in the same way as for the 
              parameter/variable i, and add a store attribute setting this equal 
              to zero. The __init__ method should be something like:</p>
              <pre><code class=\"language-python\">def __init__(self, i, environment):
              \"""
              The constructor method.

              Parameters
              ----------
              i : Integer
                  To be unique to each instance.
              environment : List
                  A reference to a shared environment

              Returns
              -------
              None.

              \"""
              self.i = i
              self.environment = environment
              self.x = random.randint(0, 99)
              self.y = random.randint(0, 99)
              self.store = 0</code></pre>
              <p>In model.py when you instantiate Agent objects be sure to pass 
              in the parameters/arguments in the correct order.</p>
              <p>In the Agent class define the following function:</p>
              <pre><code class=\"language-python\">def eat(self):
                  if self.environment[self.y][self.x] > 10:
                      self.environment[self.y][self.x] -= 10
                      self.store += 10</code></pre>
              <p>Think about what this code does and adapt it so that if the 
              value of environment[self.y][self.x] &lt;= 10 then the Agent 
              instance stores what there is. If two or more agents are at the 
              same location and there is less at the location for all the agents
              to have 10, then those that are processed first will be getting 
              more. We will worry about this later.</p>
              <p>In model.py call the new eat function after the move function
              and run the file. You should be able to see that the environment 
              in the plot has changed around where the agents have been plotted,
              as in the following image.</p>
              <p><img src="../../resources/abm5/Figure_3.png" 
                alt="A plot of agents on a limited part of the environment with part of it eaten away." /></p>
              </p>
              <p>The eating away should be more obvious if n_iterations is 
              increased.</p>
              <p>Commit your code to your local repository.</p>
              
              <h2 id="5">5. Coding Tasks</h2>
              <p>Define a function in model.py that adds up all the values in 
              environment.</p>
              <p>Define another function that adds up all the store values in 
              all the agents.</p>
              <p>Print out these sums and check that the total amount of 
              resource and store in the system is not changing after each
              iteration of the model.</p>   
              <p>Define a function to write out the values of environment to a 
              file at the end of the the iterations.</p>
              <p>Try setting some of the model parameters towards the start of 
              the program using keyboard input using something like:</p>
              <pre><code class=\"language-python\">n_agents = int(input("Set n_agents: Key in a positive integer then press <ENTER>:"))</code></pre>
              <p>Commit your code to your local repository, and assuming you are 
              using GitHub - push your changes to GitHub.</p>
              """);
//              <pre></pre>
//              <pre><code class=\"language-python\"></code></pre>
//              <p></p>
//              <pre></pre>
//              
    }
}
