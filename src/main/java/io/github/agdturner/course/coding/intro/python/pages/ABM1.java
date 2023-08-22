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
        w.addPST(sb,
                """
                Part 1 in a series of 9 practicals with instructions to \
                develop a simple spatial \
                """);
        sb.append(index.getReference("ABM", "Agent Based Model", sid));
        w.addPET(sb, 
                """
                 (ABM) - a model for simulating the actions and interactions \
                of entities (agents) located within a spatial environment \
                which may change and be changed by the agents.""");
        w.addP(sb,
                """
                Agents will be located at coordinates in the environment and \
                move around randomly interacting with the environment and each \
                other. How the agents interact will be based on their \
                characteristics, the characteristics of their environment, and \
                the characteristics of other agents in their environment.""");
        w.addP(sb,
                """
                The model will iterate with a regular time step in that all \
                agents will have a turn at interacting in each iteration."""); 
        w.addP(sb, "You will learn about:");
        w.addULST(sb);
        w.addLI(sb, "testing, debugging and refactoring code;");
        w.addLI(sb, "using loops, conditionals and containers;");
        w.addLI(sb, "defining and using functions and classes;");
        w.addLI(sb, "reading and writing data files;");
        w.addLI(sb, "organising code into modules;");
        w.addLI(sb, "developing a simple Graphical User Interface (GUI); and,");
        w.addLI(sb, "scraping and processing data from the Web.");
        w.addULET(sb);
        w.addP(sb, "The final version of will:");
        w.addULST(sb);
        w.addLI(sb, "initialise agents by reading data from the Web;");
        w.addLI(sb, "initialise the environment with data read from a file;");
        w.addLI(sb, "the simulation will be visualised as an animation;");
        w.addLI(sb, "display information about the model as it runs;");
        w.addLI(sb, "create output files; and,");
        w.addLI(sb, "produce results that can easily be reproduced.");
        w.addULET(sb);

        addSection("Getting started", sb);
        w.addP(sb,
                """
                Initially two agents are going to be represented in an \
                abstract two dimensional plane. The location of these agents \
                will be given by the coordinates: (x0, y0) and (x1, y1). \
                They will be initialised at the same location and will move \
                randomly one step. Code will be written to calculate the \
                distance between coordinates.""");
        w.addP(sb,
                """
                The code will subsequently be refactored (rewritten) so it is \
                more concise and easier to understand, maintain and reuse.
                """);
        w.addP(sb,
                """
                The algorithm to implement for this practical can be written \
                as follows:
                """);
        w.addPRE(sb,
                """
                # Initialise variable x0
                # Initialise variable y0
                # Change x0 and y0 randomly
                # Initialise variable x1
                # Initialise variable y1
                # Change x1 and y1 randomly
                # Calculate the Euclidean distance between (x0, y0) and (x1, y1)
                """);
        w.addP(sb,
                """
                In your local code repository create a new directory 'src' and \
                within this create a new directory 'abm1'.
                """);
        w.addP(sb, "Create a file 'model.py' in the 'abm1' directory.");
        w.addP(sb,
                "Copy the algorithm above and paste it in.");
        w.addP(sb,
                """
                Add a line after the line "# Initialise a variable x0", to \
                initialise a variable 'x0' with the value '0', then a line to \
                print 'x0':""");
        addPythonCodeBlock(sb,
                """
                x0 = 0
                print("x0", x0)
                """);
        w.addP(sb,
                """
                Save and run the program. The output from running the program \
                should be:
                """);
        w.addPRE(sb, "x0 0");
        w.addPST(sb, "Note that two parameters are passed into the ");
        sb.append(index.getReference("Python print", "print"));
        w.addPET(sb,
                """
                function. These are printed out sequentially with a space \
                delimiter by default.""");
        w.addP(sb, "Do similarly to initialise the variable 'y0'.");

        sid = addSection("Randomly changing values", sb);
        w.addPST(sb, "The Python standard library ");
        sb.append(index.getReference("Python random", "random module", sid));
        w.addPET(sb,
                """
                 implements pseudo-random number generators for various \
                distributions and provides a way to change variable values \
                randomly. To use the module it has to be imported. Towards \
                the top of 'model.py' add the following import statement:""");
        addPythonCodeBlock(sb, "import random");
        w.addP(sb,
                """
                It is good practice to organise import statements at the top \
                of files as this makes them easy to find and makes it less \
                likely that modules are imported multiple times. Whilst \
                importing modules multiple time is not likely to result in \
                errors, it is usually not necessary and generally \
                inefficent.""");
        w.addPST(sb, "Use an ");
        sb.append(index.getReference("Python if", "if statement", sid));
        sb.append(
                """
                 to determine whether to increase or decrease 'x0' based on \
                the value obtained from a call to the function""");
        sb.append(index.getReference("Python random.random", "random", sid));
        w.addPET(sb,
                """
                : First obtain and print a pseudo-random number in the range \
                [0, 1) as follows:""");
        addPythonCodeBlock(sb,
                """
                rn = random.random()
                print(rn)
                """);
        w.addP(sb,
                """
                Run your program a few times to observe that the value of 'rn' \
                varies somewhat randomly.""");
        w.addP(sb,
                """
                What is happening, is that the start (seed) of a pseudo-random \
                sequence used to generate numbers randomly is being set from \
                the computer clock time (which updates many times a second). \
                So, each time the code is run, a different seed is set and the \
                movement of the agents might be different. The seed set in \
                this way would nearly always be different and so results will \
                often be different and the more so, the more changes there \
                were in the model. We will reconsider how to make results more \
                reprocuible in due course.""");
        w.addP(sb,
                """
                Declare an 'if statement' so that if the value 'rn' is less \
                than '0.5' increase 'x0' by '1', otherwise decrease "'x0' by \
                '1':""");
        addPythonCodeBlock(sb,
                """
                if rn < 0.5:
                    x0 = x0 + 1
                else:
                    x0 = x0 - 1
                print("x0", x0)
                """);
        w.addP(sb,
                """
                Run your program a few times to observe that sometimes the \
                value of 'x0' increases and sometimes it decreases and this \
                corresponds to the value of 'rn'.""");
        w.addP(sb,
                """
                When testing code, it can be difficult if results vary from \
                one run to the next, so it can be helpful to set the random \
                seed to ensure that the same results are produced each time. \
                At the top of your code, after the import statements add the \
                following:""");
        addPythonCodeBlock(sb,
                """
                # Set the pseudo-random seed for reproducibility
                random.seed(0)
                """);
        w.addP(sb,
                "When run, the program should generate the following output:");
        w.addPRE(sb,
                """
                x0 0
                y0 0
                rn 0.8444218515250481
                b False
                x0 - 1
                """);
        w.addP(sb,
                """
                To generate different results you pass in a different \
                parameter value into the 'seed' function.""");
        w.addP(sb,
                """
                Similarly modify the value of 'y0'. Then similarly initialise \
                the variables 'x1' and 'y1' and then similarly modify these \
                randomly. Test that the movements vary for different seeds and \
                that changes in each coordinate are independent of how the \
                other coordinates change.""");

        addSection("Calculate the Euclidean distance", sb);
        w.addP(sb,
                """
                Use the \
                <a href="https://en.wikipedia.org/wiki/Pythagorean_theorem"> \
                Pythogorean theorem</a> to calculate the distance between the \
                coordinates (x0, y0) and (x1, y1). The algorithm is:""");
        w.addPRE(sb,
                """
                # Calculate the difference in the x coordinates.
                # Calculate the difference in the y coordinates.
                # Square the differences and add the squares
                # Calculate the square root
                """);
        w.addP(sb,
                """
                At the end of your source code set: 'x0' and 'y0' to equal \
                '0'; 'x1' to equal '3', and 'y1' to equal '4'. Then copy and \
                paste the Pythogorean theorem algorithm into your source code. \
                Try to implement the algorithm, but spend no more than 5 \
                minutes trying to do this. Hints: the distance between \
                coordinates (0, 0) and (3, 4) is 5; the symbol '**' can be \
                used to raise a number to the power of another number; raising \
                a number to the power of '0.5' calculates the square root; \
                testing can simply be done by printing out the result.""");

        sid = addSection("Review, commit and look ahead", sb);
        w.addP(sb,
                """
                Hopefully, you managed to develop code that produces the \
                correct answer. If not, do not worry, the important thing is \
                to have tried and not spent too long trying.""");
        w.addP(sb,
                """
                There is a lot of repetition in the code.""");
        w.addPST(sb, 
                """
                An alternative, to using '**0.5' to calculate a square root is \
                to import the standard library \
                """);
        sb.append(index.getReference("Python math", "math module", sid));
        w.addPET(sb,
                """
                 and use the \
                <a href="https://docs.python.org/3/library/math.html#math.sqrt"> \
                sqrt</a> function.""");
        addParagraphCommitToGitHub(sb);
        w.addPST(sb,
                """
                In the next ABM practical: The code will be modified so the \
                coordinates for each agent are stored together in a container; \
                """);
        sb.append(index.getReference("Python for", "for loops"));
        w.addPET(sb,
                """
                will be used to create and move more agents, and the model \
                will be visualised.""");
        return sb.toString();
    }
}
