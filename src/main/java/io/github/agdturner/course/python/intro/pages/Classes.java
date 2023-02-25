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
              <h2 id="1">1. Introduction</h2>
              <p>Classes are templates for making objects. Objects are instances 
              of the class that defines them. So, there can be many objects that 
              are instances of a class. The class defines the attributes an 
              objects can have, and the functionality the class instances can 
              call. In python, the functions defined in a class are known as 
              methods and the type of an object is the class that defines it.
              </p>
              <p>In python, classes can be embedded throughout programs, 
              but it is considered good practice to organise classes in 
              modules.</p>
              <p>Modules are source code files, the name of the module is given 
              by the filename which should be a short word all in lowercase. 
              Modules are commonly stored in a directory alongside the main 
              script that is run. If they are simply placed in the same 
              directory as the script that is run, then there can be name 
              collisions with modules in the standard library and this is best 
              avoided.</p>
              <p>The name of a class should start with a capital letter and be 
              in CamelCase (with capitalised letters of each word making up the 
              name of the class). It is helpful to organise code into modules as 
              this makes the code more reusable. Having all your code in one 
              file soon becomes cumbersome.</p>
              
              <h2 id="2">2. Class Definitions, Constructors, Attributes and Methods</h2>
              <p>A class is defined using the keyword 'class' followed by the 
              name of the class, parentheses, and a colon, for example:</p>
              <pre>class Agent():</pre>
              <p>A single or multiple other class names can be added in the 
              parentheses to declare parent classes that the class is to inherit 
              from. If there is multipl inheritance, then each class inherited 
              from is separated by a comma. Class inheritence is described in 
              <a href="#3">Section 3</a>.</p>
              <p>In python, as mentioned, functions inside classes are called 
              methods. A class in python has one and only one constructor method 
              named __init__. The constuctor method is used to initialise 
              attributes of an instance when it is constructed. A default 
              parameter, by convention called 'self' is always first parameter. 
              This effectively refers to a generic instance of the class and is 
              used within the class to define and refer to attributes and 
              methods of the class. For example, instances of the following 
              Agent class are instantiated with x and y variables that are 
              initially set to be zero:</p>
              <pre><code class="language-python">class Agent():
                  def __init__(self):
                      self.x = 0
                      self.y = 0</code></pre>
              <p>Suppose this class was in a file named "agentframework.py" - 
              and so in a module named "agentframework", it could be 
              instantiated as follows:<p>
              <pre><code class="language-python">import agentframework
              a = agentframework.Agent()</code></pre>
              <p>And the x and y variables could then be accessed using the dot 
              operator from as follows:</p>
              <pre><code class="language-python">print(a.x) # <-- Prints the value of a.x
              print(a.y) # <-- Prints the value of a.y
              a.x = 3 # <-- Sets the values of a.x to be 3
              a.y = a.y + 1 # <-- Increases the value of a.y by 1</code></pre>
              <p>A class constructor method may accept multiple arguments. For 
              example, the initial values for x and y could be passed in and 
              used to initialise the attributes x and y of the instance as 
              follows:</p>
              <pre><code class="language-python">class Agent():
                  def __init__(self, x, y):
                      self.x = x
                      self.y = y</code></pre>
              <p>When instantiating an instance of this Agents class, it is 
              necessary to pass in two argument as the constructor method does 
              not set defaults of these values. The following code will 
              instantiate an Agent object using the latest class definition 
              above:</p>
              <pre><code class="language-python">import agents
              a = agents.Agent(0, 0)</code></pre>
              <p>The parameters x and y can be given default values making it 
              optional as to whether these are supplied, by changing the 
              constructor method as follows:</p>
              <pre><code class="language-python">class Agent():
                  def __init__(self, x = 0, y = 0):
                      self.x = x
                      self.y = y</code></pre>
              
              <h2 id="3">3. Inheritance</h2>
              <p>In python, all classes inherit (attributes and methods) from 
              the type metaclass. A metaclass can be thought of as a factory for 
              producing classes.</p>
              <p>The classes from which a class inherits are known as super 
              classes, and the classes that inherit from another class are known 
              as subclasses.</p>
              <p>Inheritance is heirarchical and allows for things in common to 
              multiple classes to be stored in a super class avoiding having 
              to define attributes and methods repeatedly in subclasses. Those 
              attributes and methods in a superclass are accessible directly 
              from subclasses.</p>
              <p>Methods can be overridden by defining a method with the same 
              name as the superclass method. The function super() can be used, 
              to access an overriden method. In this way an overridden method 
              can access the superclass method that it is overriding as shown in 
              an example below.<p>
              <p>Python supports multiple inheritance where a subclass may 
              inherit from multiple superclasses. To do this, the classes being 
              inherited from are listed in the class definition - each separated
              by a comma.</p>
              <p>The following defines Goat and Wolf as classes that inherit 
              from the Agent class:</p>
              <pre><code class="language-python">class Agent():
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
              superclass constructor method. Each instance of Goat would be 
              instantiated with the attribute self.hungry equal to True. Each 
              instance of Wolf is given a parameter called pack when 
              constructed. This is a variable which is assigned to the 
              respective attribute. In this example, pack could be a identifier 
              for a pack that the instance is part of, or it could be a list of 
              references or something else.</p> 
              <p>Inheritance allows for a class (A) to be extended to create 
              different subclasses, and a further class to be defined as the 
              subclass of multiple of the subclasses of A. In such a case, there 
              is an order in the way inheritence works and how methods get 
              overridden. For more details of this see:
              <a href="https://docs.python.org/3/tutorial/classes.html#multiple-inheritance">
              The Python Tutorial on Classes Section on Multiple Inheritance</a>.</p>
              
              <h2 id="4">4. Access Control</h2>
              <p>Python does not have a way to declare the accessibility of 
              variables or functions/methods as is common in other languages.
              </p>
              <p>Instead there is a naming convention which is that variables 
              that have a name starting with an underscore and functions 
              starting with a double underscore are not to be accessed directly 
              from outside the class or module.</p>
              <p>The function property() can be used with a specifically named 
              get method to provide indirect access to a object attribute. This 
              can optionally allow for setting the attribute value and deleting
              the attribute too. In the following example the function 
              property() is set up to pass, modify and delete the attribute _x:
              </p>
              <pre><code class="language-python">class Agent():
                  def __init__(self, ax, ay):
                      self._x = ax
                      self._y = ay
              
                  def getx(self):
                      return self._x
                      
                  def setx(self, value):
                      self._x = value
                     
                  def delx(self):
                      del self._x
              
                  x = property(getx, setx, delx, "I'm the 'x' property.")</code></pre>
              <p>This could be used from another module as follows:</p>
              <pre><code class="language-python">import agents:
              a = agent.Agent(0, 0):
              a.x = 3
              print(a.x) # <-- Prints 3</code></pre>
              <p>So, rather than access the attribute _x directly, this is done 
              via a function which is aliased as x.</p>
              <p>Decorators can alternatively be used to achieve the same thing 
              as follows:</p>
              <pre><code class="language-python">class Agent():
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
                      del self._x</code></pre>
              <p>Details of this are provided in:
              <a href="https://docs.python.org/3/library/functions.html#property">
              The Python Library Documentation Chapter on Functions Section on Property</a>.</p>
              
              <h2 id="5">5. Customisation</h2>
              This __str__ method can be overriden to help the print function to 
              represent the instance of a class as a String. By default the 
              memory address of the class instance is printed, but rarely is 
              this of any use. The following allows for Agent instances to print 
              their coordinates and for a Goat the String also includes details 
              of the hungry attribute:
              <pre><code class="language-python">class Agent():
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
              <p>More details on customisation can be found in              
              <a href="https://docs.python.org/3/reference/datamodel.html#basic-customization">
              The Python 3 Language Reference Data Model Chapter Section on Basic Customization</a>.</p> 
              
              <h2 id="6">6. Further learning</h2>
              <p>For a more in depth consideration of classes, see:
              <a href="https://docs.python.org/3/tutorial/classes.html">
              The Python Tutorial on Classes</a>.</p>
              """);
        w.add("</div>");
    }
}
