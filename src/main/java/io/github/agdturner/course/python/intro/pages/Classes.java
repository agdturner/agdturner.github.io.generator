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
 * For Python Intro Course Classes Page.
 *
 * @author Andy Turner
 */
public class Classes extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Classes(PythonIntroCourse c) {
        super("classes", "Classes", "Classes", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2>1. Introduction</h2>
              <p>Classes are templates for making objects which offer a way to 
              combine attributes (data/state) and functionality. Objects are 
              instances of a class. In Python classes can be embedded throughout 
              programs, but it is good practice to organise classes in modules. 
              Modules are source code files, the name of the module is given by 
              the filename which should be a short word all in lowercase. The 
              name of a class should start with a capital letter and should be 
              in CamelCase (with capitalised letters of each word).</p>
              <p>It is helpful to organise code into modules as having all code 
              in one file becomes cumbersome.</p>
              
              <h2>2. Definition, Initialisation, Constructor Function, Attributes and Methods</h2>
              <p>A class is defined using the keyword "class" followed by the 
              name of the class, some parentheses and a colon, for example:</p>
              <pre>class Agent():</pre>
              <p>A class in Python has one and only one constructor function.
              This is called __init__ and is used to initialise the attributes 
              of an object as soon as the object is constructed. A default 
              parameter, by convention called 'self' is always passed in as an 
              argument. This represents a generic object instance of the class.
              </p>
              <p>The self parameter is used within the class to define and refer 
              to attributes of the class. For example, the following class 
              can be used to instantiate an Agent with x and y variables that 
              are initially set to be zero:</p>
              <pre><code class=\"language-python\">class Agent():
                  def __init__(self):
                      self.x = 0
                      self.y = 0</code></pre>
              <p>Suppose this class was in a file named "agents.py" - and so in 
              the module named "agents", it could be instantiated as follows:<p>
              <pre><code class=\"language-python\">import agents
              a = agents.Agent()</code></pre>
              <p>And the x and y variables can then be accessed (externally to 
              the class) using the dot operator as follows:</p>
              <pre>print(a.x) # <-- Prints the value of a.x
              a.y # <-- Prints the value of a.x
              a.x = 3 # <-- Sets the values of a.x to be 3
              a.y = a.y + 1 # <-- Increases the value of a.y by 1</pre>
              <p>The constructor function of a class may accept multiple input 
              parameters. For example, the initial values for x and y could be
              passed in and used to initialise the the instances x and y 
              coordinates as follows:</p>
              <pre><code class=\"language-python\">class Agent():
                  def __init__(self, x, y):
                      self.x = x
                      self.y = y
              </code></pre>
              <p>When instantiating an object of this class it would be 
              necessary to pass in two argument. The first would be assigned to
              the objects x attribute and the second would be assigned to the 
              objects y attribute. The names do not have to correspond. For 
              example, the following code will instantiate an object using the 
              latest class definition:</p>
              <pre><code class=\"language-python\">import agents
              a = agents.Agent(0, 0)</code></pre>
              <p>However, the variables x and y could be given default values 
              making it optional as to whether these are supplied, as follows:
              </p>
              <pre><code class=\"language-python\">class Agent():
                  def __init__(self, x = 0, y = 0):
                      self.x = x
                      self.y = y
              </code></pre><p>Methods in Python are functions inside classes.</p>
              
              <h2>3. Inheritance</h2>
              <p>All classes efectively inherit from type in Python. Classes can 
              inherit from other classes, but in the heirarchy of inheritance, 
              type (which is slightly odd in that it has a lower case name) is 
              at the top. The class a class inherits from is known as the super 
              class, and the class that inherits from another class is known as 
              the subclass of the class it inherits from.</p>
              <p>Inheritance can be very useful. It allows things common to
              multiple classes to be stored in the super class avoiding having 
              similar attributes and methods repeated in subclasses.</p>
              <p>Methods can be overridden in subclasses. A method with the same 
              name and number of arguments in a subtype as is in a super type is 
              overridden.</p>
              <p>The super() is used in a subclass, to access an attribute or 
              method of a super class. In this way an overridden method can also
              access the superclass method that it is overriding.<p>
              <p>Python supports multiple inheritance where a subclass may 
              inherit from multiple super classes. To do this, the classes being 
              inherited from are listed in the class definition - each separated
              by a comma.</p>
              <p>The following defines Goat and Wolf as classes that inherit 
              from the Agent class:</p>
              <pre><code class=\"language-python\">class Agent():
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
                      self.pack = pack</code></pre>
              <p>The constructors methods of the Goat and Wolf classes call the 
              superclass (Agent) constructor method. Each instance of Goat is 
              instantiated with the variable hungry equal to True. Each wolf is 
              given something called pack which it keeps a reference to (it also 
              gives this the name pack, although it could be any valid variable 
              name). The idea is that the variable pack could be a list of the 
              other members of a wolf's pack.</p> 
              <p>Inheritance allows for a class (A) to be extended to create 
              different subclasses, and a further class to be defined as the 
              subclass of multiple of the subclasses of A. In such a case, there 
              is an order in the way inheritence works and how methods get 
              overridden. For more details of this see:
              <a href="https://docs.python.org/3/tutorial/classes.html#multiple-inheritance">
              The Python Tutorial on Classes Section on Multiple Inheritance</a>.</p>
              
              <h2>4. Access Control</h2>
              <p>Python does not have a way to declare the accessibility of 
              variables or functions as is common in other languages.</p>
              <p>Instead it uses a convention that variables that have a name 
              starting with an underscore and functions starting with a double 
              underscore should not be accessed directly from outside of a 
              class.</p>
              <p>There is a property function that can be used with specifically 
              named get, set and del functions, to provide access to variables
              within a class. The set property function would allow for setting 
              the variable value and del would allow for deleting the variable.
              The following shown how a property would be defined for x:
              <pre><code class=\"language-python\">class Agent():
                  def __init__(self, ax, ay):
                      self._x = ax
                      self._y = ay
              
                  def getx(self):
                      return self._x
                      
                  def setx(self, value):
                      self._x = value
                     
                  def delx(self):
                      del self._x
              
                  x = property(getx, setx, delx, "The x coordinate.")</code></pre>
              <p>Users of the class could then refer to the x property of the 
              class which would indirectly modify the variable _x. For example, 
              assuming the class Agent is in the module agents:
              </p>
              <pre><code class=\"language-python\">import agents:
              a = agent.Agent(0, 0):
              a.x = 3
              print(a.x) # <-- Prints 3</code></pre>
              <p>Details of this are provided in:
              <a href="https://docs.python.org/3/library/functions.html#property">
              The Python Documentation > functions > property</a>. This details 
              how to use decorators to do the same thing, a detail omitted from 
              these learning resources, but something you might see in other 
              code and wonder about. A decorator starts with the @ symbol and 
              gives the name of another function that is returned from a call to 
              another function.</p>
              
              <h2>5. __str__</h2>
              This function can be defined in a class to override the default 
              print behaviour for the class. By default the memory address of 
              the instance is printed, but rarely is this of any use. For 
              example, the following allows for an Agent to print out it's 
              location and for a Goat reports the value of the variable hungry:
              <pre><code class=\"language-python\">class Agent():
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
                      return super().__str__() + ", hungry=" + self.str(hungry)</code></pre>
              <p>Note that the last few code examples do not contain any 
              comments or docstrings and so they are not ideal code.</p> 
              
              <h2>6. Further learning</h2>
              <p>For a more in depth consideration of classes, see:
              <a href="https://docs.python.org/3/tutorial/classes.html">The Python Tutorial on Classes</a>.</p>
              """);
        w.add("</div>");
    }
}
