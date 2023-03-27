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
 * For Python Intro Course ABM1 Page.
 *
 * @author Andy Turner
 */
public class ABM1 extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public ABM1(PythonIntroCourse c) {
        super("abm1", "Agent Based Model Practical 1", "ABM1", c);
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        Section s;
        s = addSection("1", "Introduction", 2);
        w.add(s.sectionHTML);
        w.add("<p>This series of practicals develops a simple spatial "
                + c.index.getReference("ABM", "Agent Based Model", s.sid)
                + " (ABM) - a type of model useful for studying behaviour"
                + " and emergence in complex systems.</p>");
        w.add("""
              <p>The ABM will represent individual 'agents' which will have 
              varying characteristics. It will run iteratively such that
              each agent will do things in simulation steps (iterations of the 
              model) which represent the passage of time. What the agents do 
              will in some ways change their characteristics, the 
              characteristics of other agents, and the spatial 'environment' 
              in which they are located and which is represented as a different 
              kind of entity.</p>
              """);
        w.add("""
              <p>In building an ABM, you will put theory into practise and learn 
              more about:</p>
              <ul>
              <li>testing, debugging and refactoring code;</li>
              <li>using loops, conditionals and containers;</li>
              <li>defining and using functions and classes;</li>
              <li>reading and writing data files;</li>
              <li>organising code into modules;</li>
              <li>developing a simple Graphical User Interface (GUI); and,</li>
              <li>scraping and processing data from the Web.</li>
              </ul>
              <p>The agents will have simple behaviours and will interact 
              with the environment. The model will be initialised by reading 
              data read from files. The model simulation will be visualised as 
              an animation. Model progress will be printed to the console. 
              Additional outputs from the model will be saved in files.</p>
              """);

        s = addSection("2", "Getting started", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>Initially two agents are going to be represented in an absrtact 
              two dimensional plane. The location of these agents will be given 
              by cartesian coordinates: (x0, y0) and (x1, y1). They will be
              initialised at the same location and will move randomly one step. 
              Code will be written to calculate the distance between cartesian 
              coordinates.</p>
              <p>The way this is done by following the instructions is 
              imperfect. The code will be refactored and rewritten in subsequent 
              practicals so it is done in a better ways as you learn more
              theory.</p>
              <p>The algorithm to implement for this practical can be written as 
              follows:</p>
              <pre># Initialise variable x0
              # Initialise variable y0
              # Change x0 and y0 randomly
              # Initialise variable x1
              # Initialise variable y1
              # Change x1 and y1 randomly
              # Calculate the Euclidean distance between (x0, y0) and (x1, y1)</pre>
              <p>In your local code repository create a new directory called 
              'src' and within this create a new directory called 'abm1'.</p>
              <p>Open Spyder and save the file as 'model.py' in the 'abm1'
              directory.</p>
              <p>Copy the algorithm above and paste it into the file.</li>
              <p>Add a line after the line "# Initialise a variable x0' to 
              initialise a variable 'x0' with the value '0' and print this 
              out:</p>
              <pre><code class="language-python">x0 = 0
              print("x0", x0)</code></pre>
              <p>Save and run the program. The output from running the program 
              should be:</p>
              <pre>x0 0</pre>
              """);
        w.add("<p>Note that two parameters are passed into the "
                + c.index.getReference("Python print", "print")
                + " function. These are printed out sequentially with a space"
                + " delimiter by default.</p>");
        w.add("<p>Do the same for variable 'y0'.</p>");

        s = addSection("3", "Randomly changing values", 2);
        w.add(s.sectionHTML);
        w.add("<p>The Python standard library "
                + c.index.getReference("Python random", "random module", s.sid)
                + " implements pseudo-random number generators for various"
                + " distributions and provides a way to change variable "
                + " values randomly. To use the module it has to be imported."
                + " Towards the top of 'model.py' add the following import"
                + " statement:</p>");
        w.add("""
              <pre><code class="language-python">import random</code></pre>
              <p>It is good practice to organise import statements at the top 
              of files as this makes them easy to find and makes it less likely 
              that a module is imported multiple times, which does not raise 
              excpetions and stop code executing as expected, but clutters code 
              and makes it less efficient.</p>
              """);
        w.add("<p>Use an "
                + c.index.getReference("Python if", "if statement", s.sid)
                + " to determine whether to increase or decrease 'x0' based on "
                + " the value obtained from a call to the function "
                + "<a href=\"https://docs.python.org/3/library/random.html#random.random\">"
                + "random</a>:"
                + " First obtain and print a pseudo-random number in the range"
                + " [0, 1) as follows:</p>");
        w.add("""
              <pre><code class="language-python">rn = random.random()
              print(rn)</code></pre>
              """);
        w.add("<p>Run your program a few times to observe that the value of "
                + "'rn' varies randomly.</p>"
                + "<p>What is happening, is that the start (seed) of pseudo"
                + "-random sequence used to generate numbers randomly is being"
                + " set from the computer clock time (which moves on"
                + " incrementally at a high frequency.</p>"
                + "<p>Declare an 'if statement' so that if the value 'rn' is "
                + "less that '0.5' increase 'x0' by '1', otherwise decrease "
                + "'x0' by '1':</p>");
        w.add("""
              <pre><code class="language-python">if rn < 0.5:
                  x0 = x0 + 1
              else:
                  x0 = x0 - 1</code>
              print("x0", x0)</pre>
              """);
        w.add("""
              <p>Run your program a few times to observe that sometimes the 
              value of 'x0' increases and sometimes it decreases and this 
              corresponds to the value of 'rn'.</p>
              <p>When testing code, it is unhelpful for results to vary 
              randomly in ways that are difficult to repeat, as this makes 
              conditions that only occassionally happen difficult to 
              investigate. So, it is sensible to 'set the seed' of random 
              and in doing so ensure that the same results are produced each 
              time. After the import statements add the following:</p>
              <pre><code class="language-python"># Set the pseudo-random seed for reproducibility
              random.seed(0)</code></pre>
              <p>When you run the program, you should get the following output:
              </p>
              <pre>x0 0
              y0 0
              rn 0.8444218515250481
              b False
              x0 - 1 </pre>
              <p>For different results pass in a different value into the 'seed'
              function (e.g. random.seed(1)), for more random results the time 
              could be input as the 'seed'.</p>
              <p>Similarly modify the value of 'y0'. Then similarly initialise 
              the variables 'x1' and 'y1' and then similarly modify these 
              randomly. Test that the movements vary for different seeds and 
              that changes in each coordinate are independent of how the other 
              coordinates change.</p>
              """);

        s = addSection("4", "Calculate the Euclidean distance", 2);
        w.add(s.sectionHTML);
        w.add("<p>Use the "
                + "<a href = \"https://en.wikipedia.org/wiki/Pythagorean_theorem\">"
                + "Pythogorean theorem</a> to calculate the distance between "
                + "the cartesian coordinates (x0, y0) and (x1, y1). The "
                + "algorithm is:</p>");
        w.add("""
              <pre># Calculate the difference in the x coordinates.
              # Calculate the difference in the y coordinates.
              # Square the differences and add the squares
              # Calculate the square root</pre>
              <p>At the end of your source code set: 'x0' and 'y0' to equal '0';
              'x1' to equal '3', and 'y1' to equal '4'. Then add the algorithm 
              above into your source code and try to calculate the distance 
              between the cartesian coordinates(0, 0) and (3, 4). The symbol 
              '**' can be used to raise a number to the power of another number. 
              So, raising a number to the power of '0.5' calculates the square 
              root.
              """);
        w.add("(Alternatively, import the standard library "
                + c.index.getReference("Python math", "math module", s.sid)
                + " and use the "
                + "<a href = \"https://docs.python.org/3/library/math.html#math.sqrt\">"
                + "sqrt</a> function). The expected distance between (0, 0) and"
                + "(3, 4) is 5.</p>");

        s = addSection("5", "Review, commit and look ahead", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>Hopefully, you managed to develop code that produces the 
              correct answer. If not, do not worry, the important thing is to 
              have tried. Perhaps look ahead to the start of the next ABM 
              practical where some code that does everything is provided.</p>
              <p>There is a lot of repetition in the code. The agents are not 
              well defined. There are just some variables that have been changed 
              randomly. If the code that changes the variable randomly was 
              duplicated the coordinates would move as many times as that code 
              is duplicated. But, there is a better to do this with less code 
              repetition and that results in easier to understand and maintain 
              code.<p>
              <p>Add and commit to your local git repository and assuming you 
              are using GitHub - push your changes to GitHub.</p>
              """);
        w.add("<p>In the next ABM practical: Each pair of coordinates will be"
                + " stored together in a container, "
                + c.index.getReference("Python for", "for loops")
                + " will be used to create and move more agents, and the model"
                + " will be visualised.</p>");
        w.add("</div>");
    }
}
