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
 * For Python Intro Course ABM1 Page.
 *
 * @author Andy Turner
 */
public class ABM1 extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public ABM1(PythonIntroCodingCourse course) {
        super(course, "abm1", "Agent Based Model Practical 1", "ABM1");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        addParagraphStart(sb, 
                "This series of practicals develops a simple spatial ");
        sb.append(index.getReference("ABM", "Agent Based Model", sid));
        addParagraphEnd(sb,
                """
                 (ABM) - a model for simulating the actions and interactions of
                entities (agents) located within an environment which may change
                and be changed by the agents.
                """);
        addParagraph(sb,
                """
                Initially the agents will simply have locations within the
                environment and will move around randomly. The model will run
                iteratively where each iteration is effectively a time step.
                The enviornment might change in a time step, and the agents may
                interact with the environment and each other in a time step.
                """);
        addParagraph(sb, "Following instructions, you get to learn about:");
        addULStart(sb);
        addLI(sb, "testing, debugging and refactoring code;");
        addLI(sb, "using loops, conditionals and containers;");
        addLI(sb, "defining and using functions and classes;");
        addLI(sb, "reading and writing data files;");
        addLI(sb, "organising code into modules;");
        addLI(sb, "developing a simple Graphical User Interface (GUI); and,");
        addLI(sb, "scraping and processing data from the Web.");
        addULEnd(sb);
        addParagraph(sb,
                """
                The agents will have simple behaviours and will interact with
                the environment. The model will be initialised by reading data
                read from files. The model simulation will be visualised as an
                animation. Model progress will be printed to the console.
                Additional outputs from the model will be saved in files.
                """);

        sid = addSection("Getting started", sb);
        addParagraph(sb,
                """
                Initially two agents are going to be represented in an abstract
                two dimensional plane. The location of these agents will be
                given by cartesian coordinates: (x0, y0) and (x1, y1). They will
                be initialised at the same location and will move randomly one
                step. Code will be written to calculate the distance between
                coordinates.
                """);
        addParagraph(sb,
                """
                The code will subsequently be refactored (rewritten) so it is
                more concise and easier to understand, maintain and reuse.
                """);
        addParagraph(sb,
                """
                The algorithm to implement for this practical can be written as
                follows:
                """);
        addPre(sb,
                """
                # Initialise variable x0
                # Initialise variable y0
                # Change x0 and y0 randomly
                # Initialise variable x1
                # Initialise variable y1
                # Change x1 and y1 randomly
                # Calculate the Euclidean distance between (x0, y0) and (x1, y1)
                """);
        addParagraph(sb,
                """
                In your local code repository create a new directory called
                'src' and within this create a new directory called 'abm1'.
                """);
        addParagraph(sb,
                """
                Open Spyder and save the file as 'model.py' in the 'abm1'
                directory.
                """);
        addParagraph(sb,
                "Copy the algorithm above and paste it into the file.");
        addParagraph(sb,
                """
                Add a line after the line "# Initialise a variable x0'", to
                initialise a variable 'x0' with the value '0', then a line to
                print 'x0':
                """);
        addPythonCodeBlock(sb,
                """
                x0 = 0
                print("x0", x0)
                """);
        addParagraph(sb,
                """
                Save and run the program. The output from running the program
                should be:
                """);
        addPre(sb, "x0 0");
        addParagraphStart(sb, "Note that two parameters are passed into the ");
        sb.append(index.getReference("Python print", "print"));
        addParagraphEnd(sb, 
                """
                function. These are printed out sequentially with a space
                delimiter by default.
                """);
        addParagraph(sb, "Do the same for variable 'y0'.");

        sid = addSection("Randomly changing values", sb);
        addParagraphStart(sb, "The Python standard library ");
        sb.append(index.getReference("Python random", "random module", sid));
        addParagraphEnd(sb, 
                """
                 implements pseudo-random number generators for various
                distributions and provides a way to change variable values
                randomly. To use the module it has to be imported. Towards the
                top of 'model.py' add the following import statement:
                """);
        addPythonCodeBlock(sb, "import random");
        addParagraph(sb,
                """
                It is good practice to organise import statements at the top of
                files as this makes them easy to find and makes it less likely
                that a module is imported multiple times, which does not raise
                excpetions and stop code executing as expected, but clutters
                code and makes it less efficient.
                """);
        addParagraphStart(sb, "Use an ");
        sb.append(index.getReference("Python if", "if statement", sid));
        sb.append(
                """
                 to determine whether to increase or decrease 'x0' based on the
                value obtained from a call to the function
                """);
        sb.append(index.getReference("Python random.random", "random", sid));
        addParagraphEnd(sb,
                """
                : First obtain and print a pseudo-random number in the range
                [0, 1) as follows:
                """);
        addPythonCodeBlock(sb,
                """
                rn = random.random()
                print(rn)
                """);
        addParagraph(sb,
                """
                Run your program a few times to observe that the value of 'rn'
                varies randomly.
                """);
        addParagraph(sb,
                """
                What is happening, is that the start (seed) of pseudo-random
                sequence used to generate numbers randomly is being set from the
                computer clock time (which moves on incrementally at a high
                frequency.
                """);
        addParagraph(sb,
                """
                Declare an 'if statement' so that if the value 'rn' is less than
                '0.5' increase 'x0' by '1', otherwise decrease "'x0' by '1':
                """);
        addPythonCodeBlock(sb,
                """
                if rn < 0.5:
                    x0 = x0 + 1
                else:
                    x0 = x0 - 1
                print("x0", x0)
                """);
        addParagraph(sb,
                """
                Run your program a few times to observe that sometimes the
                value of 'x0' increases and sometimes it decreases and this
                corresponds to the value of 'rn'.
                """);
        addParagraph(sb,
                """
                When testing code, it is unhelpful for results to vary
                randomly in ways that are difficult to repeat, as this makes
                conditions that only occassionally happen difficult to
                investigate. So, it is sensible to 'set the seed' of random
                and in doing so ensure that the same results are produced each
                time. After the import statements add the following:
                """);
        addPythonCodeBlock(sb,
                """
                # Set the pseudo-random seed for reproducibility
                random.seed(0)
                """);
        addParagraph(sb, 
                "When run, the program should generate the following output:");
        addPre(sb,
                """
                x0 0
                y0 0
                rn 0.8444218515250481
                b False
                x0 - 1
                """);
        addParagraph(sb,
                """
                For different results pass in a different value into the 'seed'
                function (e.g. random.seed(1)), for more random results the time
                could be input as the 'seed'.
                """);
        addParagraph(sb,
                """
                Similarly modify the value of 'y0'. Then similarly initialise
                the variables 'x1' and 'y1' and then similarly modify these
                randomly. Test that the movements vary for different seeds and
                that changes in each coordinate are independent of how the other
                coordinates change.
                """);

        addSection("Calculate the Euclidean distance", sb);
        addParagraph(sb,
                """
                Use the
                <a href="https://en.wikipedia.org/wiki/Pythagorean_theorem">
                Pythogorean theorem</a> to calculate the distance between the
                cartesian coordinates (x0, y0) and (x1, y1). The algorithm is:
                """);
        addPre(sb,
                """
                # Calculate the difference in the x coordinates.
                # Calculate the difference in the y coordinates.
                # Square the differences and add the squares
                # Calculate the square root</pre>
                """);
        addParagraph(sb,
                """
                At the end of your source code set: 'x0' and 'y0' to equal '0';
                'x1' to equal '3', and 'y1' to equal '4'. Then add the algorithm
                above into your source code and try to calculate the distance
                between the cartesian coordinates(0, 0) and (3, 4). The symbol
                '**' can be used to raise a number to the power of another
                number. So, raising a number to the power of '0.5' calculates
                the square root.
                """);
        addParagraphStart(sb, "(Alternatively, import the standard library ");
        sb.append(index.getReference("Python math", "math module", sid));
        addParagraphEnd(sb, 
                """
                 and use the
                <a href="https://docs.python.org/3/library/math.html#math.sqrt">
                sqrt</a> function. The expected distance between (0, 0) and
                (3, 4) is 5.
                """);

        sid = addSection("Review, commit and look ahead", sb);
        addParagraph(sb,
                """
                Hopefully, you managed to develop code that produces the correct
                answer. If not, do not worry, the important thing is to have
                tried. Perhaps look ahead to the start of the next ABM practical
                where some code that does everything is provided.
                """);
        addParagraph(sb,
                """
                There is a lot of repetition in the code. The agents are not
                well defined. There are just some variables that have been
                changed randomly. If the code that changes the variable randomly
                was duplicated the coordinates would move as many times as that
                code is duplicated. But, there is a better to do this with less
                code repetition and that results in easier to understand and
                maintain code.
                """);
        addParagraphCommitToGitHub(sb);
        addParagraphStart(sb,
                """
                In the next ABM practical: Each pair of coordinates will be
                stored together in a container,
                """);
        sb.append(index.getReference("Python for", "for loops"));
        addParagraphEnd(sb,
                """
                will be used to create and move more agents, and the model will
                be visualised.
                """);
        sb.append("</div>\n");
        return sb.toString();
    }
}
