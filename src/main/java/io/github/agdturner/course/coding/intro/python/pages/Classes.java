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
 * For Python Intro Course Classes Page.
 *
 * @author Andy Turner
 */
public class Classes extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public Classes(PythonIntroCodingCourse course) {
        super(course, "classes", "Classes", "Classes");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        w.addP(sb,
                """
                Classes are templates for making objects. Objects are instances
                of the 'class' that defines them. There can be many objects
                that are instances of a class, like there are many individual
                people that are humans. Classes define the attributes and
                functionality of objects. In Python, the functions defined in a
                class are known as 'methods' and the 'type' of an object is the
                class that defines it.
                """);
        w.addP(sb,
                """
                Python class definitions can be embedded throughout programs,
                but it is considered good practice to organise classes in
                'modules'.
                """);
        w.addP(sb,
                """
                Modules are source code files, the name of the module is given
                by the filename which should be a short word all in lowercase.
                Modules are commonly stored in a directory alongside the main
                script that is run. If they are simply placed in the same
                directory as the script that is run, then there can be name
                collisions with modules in the standard library and this is best
                avoided. It is good to organise code into modules as this makes
                it more reusable, and having lots of code in one file becomes
                cumbersome. (Details on modules is provided after the next ABM
                practical.)
                """);
        w.addP(sb,
                """
                The name of a class should start with a capital letter and be
                in 'CamelCase' (with no spaces and mostly in lower case except
                for capitalised first letters for each word).
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Class Definitions, Constructors, Attributes and Methods", sb);
        w.addP(sb,
                """
                A class is defined using the keyword 'class' followed by the
                name of the class, parentheses, and a colon, for example:
                """);
        addCodeBlock(sb, "class Agent():");
        sb.append(
                """
                Class names separated by commas can be added in the parentheses
                to declare parent classes that the class inherits from. Class
                inheritence is detailed further in <a href="#3">Section 3</a>.
                """);
        w.addP(sb,
                """
                As mentioned, in Python, functions inside classes are called
                'methods'. A class in Python has one and only one constructor
                method named '__init__'. The constuctor method is used to
                initialise attributes of an instance when it is constructed. A
                default parameter, by convention called 'self' is always first
                parameter. This 'self' parameter effectively refers to a generic
                instance of the class and is used within the class to define and
                refer to attributes and methods of the class. For example,
                instances of the following 'Agent' class are instantiated with
                'x' and 'y' attribute variables that are initially set to be
                zero:
                """);
        addCodeBlock(sb,
                """
                class Agent():
                    def __init__(self):
                        self.x = 0
                        self.y = 0
                """);
        w.addP(sb,
                """
                Suppose this class was in a file named 'agentframework.py' -
                and so in a module named 'agentframework', it could be
                instantiated from a script in the same directory as
                'agentframework.py' as follows:
                """);
        addCodeBlock(sb,
                """
                import agentframework
                a = agentframework.Agent()
                """);
        w.addP(sb,
                """
                And the 'x' and 'y' aatribute variables of 'a' - the instance
                of the class could then be accessed using the dot operator '.'
                as follows:
                """);
        addCodeBlock(sb,
                """
                print(a.x) # <-- Prints the value of a.x
                print(a.y) # <-- Prints the value of a.y
                a.x = 3 # <-- Sets the values of a.x to be 3
                a.y = a.y + 1 # <-- Increases the value of a.y by 1
                """);
        w.addP(sb,
                """
                A class constructor method may accept multiple arguments. For
                example, the initial values for 'x' and 'y' could be passed in
                as follows:
                """);
        addCodeBlock(sb,
                """
                class Agent():
                    def __init__(self, x, y):
                        self.x = x
                        self.y = y
                """);
        w.addP(sb,
                """
                When instantiating an instance of this Agent class, it is
                necessary to pass in two argument as the constructor method does
                not set defaults of these values. The following code will
                instantiate an Agent object using the latest class definition
                above:
                """);
        addCodeBlock(sb,
                """
                import agents
                a = agents.Agent(0, 0)
                """);
        w.addP(sb,
                """
                The parameters 'x' and 'y' do not have to have names
                corresponding to the attributes, and they can be given default
                values making it optional as to whether these are supplied, by
                changing the constructor method as follows:
                """);
        addCodeBlock(sb,
                """
                class Agent():
                    def __init__(self, x = 0, y = 0):
                        self.x = x
                        self.y = y
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Inheritance", sb);
        w.addP(sb,
                """
                In Python, all classes inherit (attributes and methods) from the
                'type' metaclass. A 'metaclass' can be thought of as a factory
                for producing classes.
                """);
        w.addP(sb,
                """
                The classes from which a class inherits are known as 'super
                classes', and the classes that inherit from another class are
                known as 'subclasses'.
                """);
        w.addP(sb,
                """
                Inheritance is heirarchical and allows for things in common to
                multiple classes to be stored in a super class avoiding having
                to define attributes and methods repeatedly in subclasses. Those
                attributes and methods in a superclass are accessible directly
                from subclasses.
                """);
        w.addP(sb,
                """
                Methods can be 'overridden' by defining a method with the same
                name as the superclass method. The function super() can be used,
                to access an overriden method. In this way an overridden method
                can access the superclass method that it is overriding as shown
                in the example below.
                """);
        w.addP(sb,
                """
                Python supports 'multiple inheritance' where a subclass may
                inherit from multiple superclasses. To do this, the classes
                being inherited from are specified in the class definition, each
                separated by a comma.
                """);
        w.addP(sb,
                """
                The following defines 'Goat' and 'Wolf' as classes that inherit
                from the 'Agent' class:
                """);
        addCodeBlock(sb,
                """
                class Agent():
                    def __init__(self, x, y):
                        self.x = x
                        self.y = y

                class Goat(Agent):
                    def __init__(self, x, y):
                        super().__init__(x, y)
                        self.hungry = True

                class Wolf(Agent):
                    def __init__(self, x, y, pack):
                        super().__init__(x, y)
                        self.pack = pack
                """);
        w.addP(sb,
                """
                The constructor methods of the Goat and Wolf classes call the
                superclass constructor method. Each instance of Goat would be
                instantiated with the attribute 'self.hungry' equal to 'True'.
                Each instance of Wolf is given a parameter called 'pack' when
                constructed. This is a variable which is assigned to the
                attribute with the same name. In this example, 'pack' could be a
                identifier or a list or something else.
                """);
        w.addP(sb,
                """
                Inheritance allows for a class (call it 'A') to be extended to
                create different subclasses, and a further class to be defined
                as the subclass of multiple of the subclasses of A. In such a
                case, there is an order in the way inheritence works and how
                methods get overridden. For more details of this see:
                <a href="https://docs.python.org/3/tutorial/classes.html#multiple-inheritance">
                The Python Tutorial on Classes Section on Multiple Inheritance</a>.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Access Control", sb);
        w.addP(sb,
                """
                Python does not have an direct way to declare the access level
                or control access to variables or functions/methods as is common
                in other languages.
                """);
        w.addP(sb,
                """
                Instead there is a naming convention which is that variables
                that have a name starting with an underscore and functions
                starting with a double underscore are not to be accessed
                directly from outside the class or module.
                """);
        w.addP(sb,
                """
                The function property() can be used with a specifically named
                get method to provide indirect access to a object attribute.
                This can optionally allow for setting the attribute value and
                deleting the attribute too. In the following example the
                function property() is set up to pass, modify and delete the
                attribute _x:
                """);
        addCodeBlock(sb,
                """
                class Agent():
                    def __init__(self, ax, ay):
                        self._x = ax
                        self._y = ay

                    def getx(self):
                        return self._x

                    def setx(self, value):
                        self._x = value

                    def delx(self):
                        del self._x

                    x = property(getx, setx, delx, "I'm the 'x' property.")
                """);
        w.addP(sb, "This could be used from another module as follows:");        
        addCodeBlock(sb,
                """
                import agents:
                a = agent.Agent(0, 0):
                a.x = 3
                print(a.x) # <-- Prints 3
                """);
        w.addP(sb,
                """
                So, rather than access the attribute _x directly, this is done
                via a function which is aliased as x.
                """);
        w.addP(sb,
                """
                Decorators can alternatively be used to achieve the same thing
                as follows:
                """);
        addCodeBlock(sb,
                """
                class Agent():
                    def __init__(self, ax, ay):
                        self._x = ax
                        self._y = ay

                    @property
                    def x(self):
                        \"""I'm the 'x' property.\"""
                        return self._x

                    @x.setter
                    def x(self, value):
                        self._x = value

                    @x.deleter
                    def x(self):
                        del self._x
                """);
        sb.append(
                """
                Details of this are provided in:
                <a href="https://docs.python.org/3/library/functions.html#property">
                The Python Library Documentation Chapter on Functions Section on Property</a>.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Customisation", sb);
        w.addPST(sb, "By default, when printing an object using the ");
        sb.append(index.getReference("Python print", "print", sid));
        w.addPET(sb,
                """
                 function, the memory address of the object is printed, but
                rarely is this useful. The '__str__' method can be overriden to
                provide a more useful string representation of an object, for
                example:
                """);
        addCodeBlock(sb,
                """
                class Agent():
                    def __init__(self, x, y):
                        self.x = x
                        self.y = y

                    def __str__(self):
                        return "x=" + self.str(x) + ", y=" + self.str(y)

                class Goat(Agent):
                    def __init__(self, x, y):
                        super().__init__(x, y)
                        self.hungry = True

                    def __str__(self):
                        return super().__str__() + ", hungry=" + self.str(hungry)
                """);
        w.addP(sb,
                """
                More details on customisation can be found in
                <a href="https://docs.python.org/3/reference/datamodel.html#basic-customization">
                The Python 3 Language Reference Data Model Chapter Section on Basic Customization</a>.
                """);
        w.addDIVET(sb);
        sb.append("\n");
        
        sid = addSection("Further learning", sb);
        w.addP(sb,
                """
                For a more in depth consideration of classes, see:
                <a href="https://docs.python.org/3/tutorial/classes.html">
                The Python Tutorial on Classes</a>.
                """);
        w.addDIVET(sb);
        return sb.toString();
    }
}
