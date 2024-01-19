/*
 * Copyright 2024 University of Leeds.
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
package io.github.agdturner.course.coding.intro.cpp.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.coding.intro.cpp.CPPIntroCodingCourse;
import io.github.agdturner.course.CoursePage;

/**
 * For CPP Intro Course ABM4 Page.
 *
 * @author Andy Turner
 */
public class ABM4 extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public ABM4(CPPIntroCodingCourse course) {
        super(course, "abm4", "Agent Based Model Practical 4", "ABM4");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Recap and preparation", sb);
        w.addP(sb,
                """
                Currently, 'agents' is a list that contains lists of two items;
                an x-coordinate, and a y-coordinate. More items could be added
                to the lists to representing additional agent characteristics.
                However, the longer the lists become, the harder it is to
                remember what is stored in each index and the more confusing
                code gets.
                """);
        w.addP(sb,
                """
                Defining an Agent class provides a way to name agent
                characteristics and refer to them by name rather than by a list
                index. The Agent class will be defined in a different file from
                'model.py' so the program code going forwards will be in
                multiple files.
                """);
        w.addP(sb,
                """
                In your local code repository src directory create a new
                directory called "abm4". Open Spyder and use 'save as' to save
                your 'model.py' file from abm3 into the abm4 directory.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Define an Agent class", sb);
        w.addP(sb,
                """
                Create a new file in the abm4 directory named
                'agentframework.py', and add a class definition for an Agent
                class in it as follows:
                """);
        addCodeBlock(this.getCourse().courseType, sb,
                """
                class Agent():
                    pass
                """);
        w.addP(sb,
                """
                The keyword 'pass' ensures the code is syntactically correct
                and will run.
                """);
        w.addP(sb,
                """
                In 'model.py' reduce 'n_iterations' to 10, and add the following
                import statement:
                """);
        addCodeBlock(this.getCourse().courseType, sb, "import agentframework as af");
        w.addP(sb,
                """
                Note that this imports the agentframework module as loaded from
                'agentframework.py' which is to be referred to by 'af'.
                """);
        w.addP(sb,
                """
                At the start of the '# Initialise agents' code block, add the
                following:
                """);
        addCodeBlock(this.getCourse().courseType, sb,
                """
                a = af.Agent()
                print("type(a)", type(a))
                """);
        w.addP(sb,
                """
                Run 'model.py' and examine the output. It should contain the
                following line:
                """);
        w.addPRE(sb, "type(a) <class 'agentframework.Agent'>");
        w.addP(sb,
                """
                This indicates that an instance of the class Agent as defined
                in the agentframework module was successfully created.
                """);
        w.addP(sb,
                """
                Add a constructor method to the Agent class that initialises 'x'
                and 'y' variable attributes to be random integers in the range
                [0, 99]. The code in 'agentframework.py' should be:
                """);
        addCodeBlock(this.getCourse().courseType, sb,
                """
                import random

                class Agent:
                    def __init__(self):
                        self.x = random.randint(0, 99)
                        self.y = random.randint(0, 99)
                """);
        w.addPST(sb, "Note that the ");
        sb.append(index.getReference("Python random", "random module", sid));
        w.addPET(sb,
                """
                 is imported as this is used in the Agent constructor '__init__'
                method.
                """);
        w.addP(sb,
                """
                In 'model.py', add a statement to print the agent that was
                instantiated, and run the program again. Text along the lines
                of the following should be in the output:
                """);
        w.addPRE(sb,
                "&lt;agentframework.Agent object at 0x00000249AEA21D88&gt;");
        w.addP(sb,
                """
                The last part of this will almost certainly be different to
                '0x00000249AEA21D88' and if you run your program again, it will
                likely be different again. Recall that this string is a memory
                address identifying where the object is stored in the memory of
                the computer.
                """);
        w.addP(sb,
                """
                When printing an Agent instance, it would be better if something
                more informative was output. The best way to do this is to
                override the '__str__' method which comes from the 'type'
                metaclass that all classes inherit from by default. Define the
                method in the Agent class as follows:
                """);
        addCodeBlock(this.getCourse().courseType, sb,
                """
                def __str__(self):
                   return self.__class__.__name__ + "(x=" + str(self.x) \\
                      + ", y=" + str(self.y) + ")"
                """);
        w.addPST(sb,
                """
                Note that this returns a string which includes the name of the
                class and details of the 'x' and 'y' variable attributes which
                are transformed by the builtins module
                """);
        sb.append(index.getReference("Python str", "str function", sid));
        w.addPET(sb, " to be strings.");
        w.addP(sb,
                """
                Run 'model.py' again and the print statement should result in
                the following:
                """);
        w.addPRE(sb, "Agent(x=49, y=97)");
        w.addP(sb,
                """
                Change the '# Initialise agents' code block in 'model.py' to:
                """);
        addCodeBlock(this.getCourse().courseType, sb, 
                """
                # Initialise agents
                agents = []
                for i in range(n_agents):
                    # Create an agent
                    agents.append(af.Agent())
                    print(agents[i])
                print(agents)
                """);
        w.addP(sb,
                """
                Run 'model.py' and you should get similar output to the
                following (in the error report, the file paths will probably be
                different, and the line numbers might be different):
                """);
        w.addPRE(sb,
                """
                Check this is equal to 5: 5.0
                Agent(x=49, y=97)
                Agent(x=53, y=5)
                Agent(x=33, y=65)
                Agent(x=62, y=51)
                Agent(x=38, y=61)
                Agent(x=45, y=74)
                Agent(x=27, y=64)
                Agent(x=17, y=36)
                Agent(x=17, y=96)
                Agent(x=12, y=79)
                [&lt;agentframework.Agent object at 0x00000249B140C6C8&gt;, &lt;agentframework.Agent object at 0x00000249B14194C8&gt;, &lt;agentframework.Agent object at 0x00000249B1419148&gt;, &lt;agentframework.Agent object at 0x00000249B1419388&gt;, &lt;agentframework.Agent object at 0x00000249B14193C8&gt;, &lt;agentframework.Agent object at 0x00000249B1419448&gt;, &lt;agentframework.Agent object at 0x00000249B14191C8&gt;, &lt;agentframework.Agent object at 0x00000249B1419048&gt;, &lt;agentframework.Agent object at 0x00000249B1419488&gt;, &lt;agentframework.Agent object at 0x00000249B1419208&gt;]
                Traceback (most recent call last):

                  File "\\abm4\\model.py", line 95, in &lt;module&gt;
                    print("Maximum distance between all the agents", get_max_distance())

                  File "\\abm4\\model.py", line 81, in get_max_distance
                    distance = get_distance(a[0], a[1], b[0], b[1])

                TypeError: 'Agent' object is not subscriptable
                """);
        w.addP(sb,
                """
                The list 'agents' is initialised, but the print function does
                not use the '__str__' method to get string representations when
                printing the list.
                """);
        w.addPST(sb, "The ");
        sb.append(index.getReference("Python TypeError", "TypeError", sid));
        w.addPET(sb,
                """
                 is a consequence of the 'agents' list no longer containing
                lists, but instantiated Agent objects, and some parts of the
                code are still written as though each agent is a list and not an
                instance of the Agent class.
                """);
        w.addP(sb,
                """
                Add the following method to the Agent class to get the print
                function to print string representations when printing the
                agents list:
                """);
        addCodeBlock(this.getCourse().courseType, sb, 
                """
                def __repr__(self):
                    return str(self)
                """);
        w.addPST(sb,
                """
                Like the '__str__' method, the '__repr__' method overrides from
                the 'type' metaclass, (for details see:
                """);
        sb.append(index.getReference("Python repr", "repr", sid));
        w.addPET(sb, ".");
        w.addP(sb,
                """
                To avoid raising the TypeError exception, it is necessary to
                refer to the class attributes and not list items (as agents are
                no longer lists, but are instances of the class Agent). So,
                change the following line of code in the 'get_max_distance()'
                function:
                """);
        addCodeBlock(this.getCourse().courseType, sb, 
                "distance = get_distance(a[0], a[1], b[0], b[1])");
        w.addP(sb, "<p>To be:</p>");
        addCodeBlock(this.getCourse().courseType, sb, "distance = get_distance(a.x, a.y, b.x, by)");
        w.addP(sb, 
                "Appreciate that this is easier to read and understand.");
        w.addP(sb,
                """
                Everywhere else in the 'model.py' that was referring to a
                coordinate from the agents list is to be changed similarly. Run
                'model.py' to see where the next TypeError is raised.
                """);
        w.addP(sb, "In the code change:");
        addCodeBlock(this.getCourse().courseType, sb, "agents[i][0]");
        w.addP(sb, "To:");
        addCodeBlock(this.getCourse().courseType, sb, "agents[i].x");
        w.addP(sb, "And change:");
        addCodeBlock(this.getCourse().courseType, sb, "agents[i][1]");
        w.addP(sb, "To:");
        addCodeBlock(this.getCourse().courseType, sb, "agents[i].y");
        w.addP(sb,
                """
                Make a further change in the code block that plots agents,
                changing:
                """);
        addCodeBlock(this.getCourse().courseType, sb,
              """
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
              """);
        w.addP(sb, "To:");
        addCodeBlock(this.getCourse().courseType, sb,
              """
              # Plot the coordinate with the largest x red
              lx = max(agents, key=operator.attrgetter('x'))
              plt.scatter(lx.x, lx.y, color='red')
              # Plot the coordinate with the smallest x blue
              sx = min(agents, key=operator.attrgetter('x'))
              plt.scatter(sx.x, sx.y, color='blue')
              # Plot the coordinate with the largest y yellow
              ly = max(agents, key=operator.attrgetter('y'))
              plt.scatter(ly.x, ly.y, color='yellow')
              # Plot the coordinate with the smallest y green
              sy = min(agents, key=operator.attrgetter('y'))
              plt.scatter(sy.x, sy.y, color='green')
              """);
        w.addP(sb,
                """
                Study these changes. Your program should run without raising
                exceptions and produces the same output as previously.
                """);
        addCommitToGitHub(sb);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Separation of Concerns", sb);
        w.addP(sb,
                "Define a method called 'move' in the Agent class as follows:");
        addCodeBlock(this.getCourse().courseType, sb, "def move(self, x_min, y_min, x_max, y_max):");
        w.addP(sb,
                """
                Cut the code that moves an individual agent from 'model.py' and
                paste it into the body of the new 'move' method. Replace:
                "agents[i]" with "self" in the method. Where the code was cut
                from, add the following to call the move method:
                """);
        addCodeBlock(this.getCourse().courseType, sb, "agents[i].move(x_min, y_min, x_max, y_max)");
        w.addP(sb,
                """
                Note that in the Agent class, the 'move' method has a parameter
                called 'self', but this is not a parameter that is passed in.
                Normally when calling a function the number of parameters
                matches, but for methods (functions in a class) there is this
                additional parameter that is not passed in and that is the first
                parameter.
                """);
        w.addP(sb,
                """
                Run the program and it should produce the same results as
                previously. The Agent class code now deals with the details of
                how an agent moves, and 'model.py' actions when they do. This is
                a reasonable separation of concerns.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Give each agent a unique name", sb);
        w.addP(sb,
                """
                It is possible that two agents will be located at the same
                coordinates, and it would be helpful to distinguish them.
                """);
        w.addPST(sb, "Add a ");
        sb.append(index.getReference("Python docstring", "docstring"));        
        w.addPET(sb,
                """
                and a parameter to the '__init__' constructor method of Agent
                so that the method is as follows:
                """);
        addCodeBlock(this.getCourse().courseType, sb,
              """
              def __init__(self, i):
              \"""
              The constructor method.
              
              Parameters
              ----------
              i : Integer
                  To be unique to each instance.
              
              Returns
              -------
              None.
              
              \"""
              self.i = i
              self.x = random.randint(0, 99)
              self.y = random.randint(0, 99)
              pass
              """);
        w.addP(sb,
                "Run 'model.py' and you should get the following error:");
        w.addPRE(sb, 
                """
                Traceback (most recent call last):
              
                File "\\abm4\\model.py", line 91, in &amp;module>
                  agents.append(agentframework.Agent())
              
                TypeError: __init__() missing 1 required positional argument:
                'i'
                """);
        w.addP(sb,
                """
                The TypeError is indicating that an expected argument is
                missing in the call that creates the Agent instance. Change
                'model.py' to pass in the missing argument 'i'. Make sure the
                positional arguments are in a correspodiong order in the method
                call and in the method definition. Run the program again and
                the TypeError should not be raised.
                """);
        w.addP(sb,
                """
                Modify the Agent class '__str__' method so it additionally
                returns the unique characteristic of each Agent 'i'.
                """);
        addCommitToGitHub(sb);
        w.addDIVET(sb);
        return sb.toString();
    }
}
