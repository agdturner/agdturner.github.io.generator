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
              instances of a class, like you are an instance of a thing known as 
              a human. In Python classes can be embedded throughout programs, 
              but it is good practice to organise classes in modules.</p>
              <p>Modules are source code files, the name of the module is given 
              by the filename which should be a short word all in lowercase. The 
              name of a class should start with a capital letter and should be 
              in CamelCase (with capitalised letters of each word making up the 
              name of the class). It is helpful to organise code into modules as 
              having all code in one file becomes cumbersome.</p>
              
              <h2>2. Class Definitions, Constructors, Attributes and Methods</h2>
              <p>A class is defined using the keyword "class" followed by the 
              name of the class, some parentheses and a colon, for example:</p>
              <pre>class Agent():</pre>
              <p>If nothing is in the parentheses, they are optional, but they 
              may contain details of class inheritence which is described in 
              Section 3.</p>
              <p>Functions inside classes are called methods in Python. A class 
              in Python has one and only one constructor method called __init__ 
              - used to initialise any attributes of an instance of a class as 
              soon as that object is constructed. A default parameter, by 
              convention called 'self' is always first in the parameter Tuple. 
              This effectively refers to a generic instance of the class and is 
              used within the class to define and refer to attributes and 
              methods of the class. For example, instances of the following 
              Agent class are instantiated with x and y variables that are 
              initially set to be zero:</p>
              <pre><code class=\"language-python\">class Agent():
                  def __init__(self):
                      self.x = 0
                      self.y = 0</code></pre>
              <p>Suppose this class was in a file named "agentframework.py" - 
              and so in a module named "agentframework", it could be 
              instantiated as follows:<p>
              <pre><code class=\"language-python\">import agentframework
              a = agentframework.Agent()</code></pre>
              <p>And the x and y variables could then be accessed using the dot 
              operator from as follows:</p>
              <pre>print(a.x) # <-- Prints the value of a.x
              print(a.y) # <-- Prints the value of a.y
              a.x = 3 # <-- Sets the values of a.x to be 3
              a.y = a.y + 1 # <-- Increases the value of a.y by 1</pre>
              <p>A class constructor method may accept multiple arguments. For 
              example, the initial values for x and y could be passed in and 
              used to initialise the attributes x and y as follows:</p>
              <pre><code class=\"language-python\">class Agent():
                  def __init__(self, x, y):
                      self.x = x
                      self.y = y
              </code></pre>
              <p>Note that there is a difference between self.x and x. The 
              attribute is self.x and within the class this is refered to as 
              self.x, whereas x is the variable lable for the first parameter 
              used to construct the instance of the class. When instantiating 
              an instance of this Agents class - an Agent object, it would be 
              necessary to pass in two argument as the method definition does 
              not detail default values. The following code will instantiate an 
              Agent object using the class definition as above:</p>
              <pre><code class=\"language-python\">import agents
              a = agents.Agent(0, 0)</code></pre>
              <p>The parameters x and y could be given default values making it 
              optional as to whether these are supplied, by changing the 
              constructor method as follows:
              </p>
              <pre><code class=\"language-python\">class Agent():
                  def __init__(self, x = 0, y = 0):
                      self.x = x
                      self.y = y
              </code></pre>
              
              <h2>3. Inheritance</h2>
              <p>All classes effectively inherit (attributes and methods) from 
              the Metaclass called "type" in Python. A Metaclass is like a 
              factory for producing classes. We will not concern ourselves with 
              the details of Metaclasses in this course.</p>
              <p>A class can inherit from other classes, the classes from which 
              a class inherits specifically are known as super classes, and the 
              classes that inherit from another class are known as subclasses.
              </p>
              <p>Inheritance is heirarchical and can be very useful. It allows 
              things common to multiple classes to be stored in a super class 
              avoiding having similar attributes and methods repeated in 
              subclasses. Those attributes and methods are accessible directly 
              from subclasses. Methods can be overridden by defining a method 
              with the same name as the superclass method to be overridden.</p>
              <p>The super() function can be used in a subclass, to access an 
              overriden method of a superclass. In this way an overridden method 
              can access the superclass method that it is overriding as we shall 
              see in an example below.<p>
              <p>Python supports multiple inheritance where a subclass may 
              inherit from multiple superclasses. To do this, the classes being 
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
              instantiated with the attribute self.hungry equal to True. Each 
              wolf is given a parameter called pack which it assigns an 
              attribute self.pack to. In this example, pack could be a list that
              gives access to other members of a Wolf instances pack (other Wolf 
              instances).</p> 
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
              underscore should not be accessed directly from outside, but these 
              may be accessed by subclasses.</p>
              <p>The Property Function property() can be used with a 
              specifically named get method to provide indirect access to a 
              class attribute. The function can optionally allow for setting the 
              value and deleting the variable too. In the following example the 
              Property Function is set up to pass, modify and delete the 
              attribute variable _x:</p>
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
              
                  x = property(getx, setx, delx, "I'm the 'x' property.")</code></pre>
              <p>This could be used from another module as follows:</p>
              <pre><code class=\"language-python\">import agents:
              a = agent.Agent(0, 0):
              a.x = 3
              print(a.x) # <-- Prints 3</code></pre>
              <p>The @property decorator can be used to turn a method into a 
              "getter" for an attribute. A property object has getter, setter, 
              and deleter methods usable as decorators that create a copy of the 
              property with the corresponding accessor function set to the 
              decorated function. The following is equivallent to the last code 
              snippet:
              <pre><code class=\"language-python\">class Agent():
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
              <p>Details of this are provided in:
              <a href="https://docs.python.org/3/library/functions.html#property">
              The Python Library Documentation Chapter on Functions Section on Property</a>.</p>
              
              <h2>5. Customisation</h2>
              This __str__ method can be overriden to help the print function to 
              represent the instance of a class as a String. By default the 
              memory address of the class instance is printed, but rarely is 
              this of any use. For example, the following allows for Agent 
              instances to print instead their coordinates and for a Goat the 
              String also includes details of the hungry attribute:
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
              <p>More details on customisation can be found in              
              <a href="https://docs.python.org/3/reference/datamodel.html#basic-customization
              The Python 3 Language Reference Data Model Chapter Section on Basic Customization</a>.</p> 
              
              <h2>6. Further learning</h2>
              <p>For a more in depth consideration of classes, see:
              <a href="https://docs.python.org/3/tutorial/classes.html">The Python Tutorial on Classes</a>.</p>
              """);
        w.add("</div>");
    }
}
