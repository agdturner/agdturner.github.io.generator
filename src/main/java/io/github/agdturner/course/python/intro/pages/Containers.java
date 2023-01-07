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
 * For Python Intro Course Containers Page.
 *
 * @author Andy Turner
 */
public class Containers extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Containers(PythonIntroCourse c) {
        super("containers", "Containers", "Containers", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2>1. Introduction</h2>
              <p>In this section we are going to consider some basic types of 
              data structure for storing collections of things in Python. 
              Similar structures are available in most high level languages, but 
              they can be called different things. The main types are sequences, 
              tuples, ranges, lists, arrays, sets and dictionaries. Some of 
              these are mutable - can be changed once they have been created, 
              others are immutable - cannot be changed once they have been 
              created although these may contain elements which themselves can 
              be changed. Some are ordered or can be ordered, and others are 
              unordered. There is 
              <a href="https://docs.python.org/3/tutorial/datastructures.html">
              a good and helpful tutorial about data structures in the Python 
              documentation</a>. There are various ways to compare collections 
              and to iterate over their elements. We will learn more about this
              when we come to use them in practise when developing our basic
              ABM code.</p>
              
              <h2>3. Sequences, Tuples and Ranges</h2>
              
              <h3>Sequences</h3>
              <p>A list is a sequence as is a Byte and a String. A Byte in 
              Python is a sequence of eight zeros and ones which can represent 
              the integers between 0 and 255. We do not use Bytes much in this 
              course, but they can be very useful. Strings are a sequence of one 
              character long Strings. Python unlike many other high level 
              languages does not have a primitive type for individual 
              characters. Strings in Python are immutable (they can not be 
              modified), so part of a String cannot be replaced with part of 
              another String. Instead, when this is effectively wanted, a new 
              String has to be created comprised of what is wanted. This can 
              make processing with Strings inefficient, but it helps with memory 
              management. Strings can be created using single quotation 
              marks ('), double quotation marks ("), and usually for multiline 
              Strings, with triple single quotes (''') or triple double quotes 
              (\"""), and by using the str() constructor function which allows 
              for creating Strings for example from Integers.</p>
              <p>Strings may contain quotation marks, but if a String is to 
              contain both single and double quotes, then one or the other needs 
              escaping using the backslash escape characer (\\). If the String 
              itself is to include a backslash, then this also would need 
              escaping. There are ways of making sure when defining a String 
              that line breaks are as wanted.  As a String is a sequence, parts 
              of it can be accessed using an index. Consider the following and 
              try the code out for yourself:</p>
              <pre>print('''This is \\ # <-- The backslash ensures the continuation of the line
              all one line.
              This is a second.''')</pre>
              <p>The + operator allows to join strings:</p>
              <pre>print("This is all " +
              "one line.")
              print("This is a second")</pre>
              <p>Strings contain many useful funtions for working on Strings 
              which can be accessed in a couple of ways, for example Strings 
              can be split by:</p>
              <pre>a = "A simple string to split."
              delimeter = " " # What is used to split the String into parts
              a_split0 = str.split(a, delimiter) # Doing the split one way
              print(a_split0)
              a_split1 = a.split(delimiter)
              print(a_split1)</pre>
              <p>There is no real difference between the two ways and it is down 
              to programming preference as to what is used. Note that the 
              delimeter is also optional, but by default is white space (a 
              continuous sequence of spaces, tabs and newlines)</p>
              <p>Search and replace is a common String operation as is finding 
              out if a string starts or ends with a particular String
              
              <h3>Tuples</h3>
              A Tuple is also a sequence. Tuple elements (items) are separated 
              with commas. An empty tuple can be made using parentheses. Tuples 
              can be added to and nested. Like Strings, Tuples are immutable in 
              that once created the itemscannot be substituted and their order 
              cannot be changed - although they may themselves be items that can 
              be modified and modifying the items is then allowed. Tuples are 
              commonly used for function returns where several things are wanted 
              to be returned from a function. Returning a Tuple effectively 
              packs the things together, and those things can be unpacked again.
              The order and amount of packing and unpacking must correspond. 
              Consider the following code, the try it for yourself and have a 
              play around to try to figure out what is going on:</p>
              <pre>>>> a = ()
              >>> print(len(a)) # Print the length of a
              0
              >>> singleton = 'hello', # <-- note trailing comma
              >>> print(len(singleton)) # Print the length of singleton
              1
              >>> b = (1, "two", 4) # Pack 3 things into b
              >>> c, d, e = b # unpack b into three things (c will refer to 1, d to "two" and e to 4)
              >>> print(c)
              1
              >>> print(d)
              'two'
              </pre>
              <p>Packing and unpacking is quite a Pythonic thing in that it is
              quite different in Python compared with other high level 
              languages. It is quite a convenient language feature.</p>
              <p>Consider the following code snippet which generates part of a 
              <a href="https://en.wikipedia.org/wiki/Fibonacci_number">
              Fibonacci series</a> of Integers:</p>
              <pre><code class="language-python"># Fibonacci series - the sum of two elements defines the next
              a, b = 0, 1
              print(a)
              while b < 10:
                  print(b)
                  a, b = b, a+b
              print(b)<code></pre>
              <p>The While Statement is a loop with an expression that is 
              evaluated each time around the loop. While the expression (b < 10)
              evaluates to True the loop continues to run, when it evaluates 
              to False, the program continues by executing the next line after 
              the loop.</p>
              
              <h3>
              <p>Ranges are a special type of immutable sequence. They are 
              created as follows:
              <pre><code class="language-python">range(start, stop, step) # start and step are optional and default to 0 and 1 repectively<code></pre>
              <p>start, stop and step should be Integers. The range function 
              generates numbers up to but not including stop, for example:</p>
              <pre><code class="language-python">range(4) # generates 0,1,2,3
              range(2,8,2) # generates 2,4,6
              range(0,-5,-1) # generates 0,-1,-2,-3,-4<pre><code></pre>
              <p>Another way to create a tuple is to use the tuple constructor 
              giving this an argument which is a sequence or producer of a 
              sequence like range:</p>
              <code class="language-python">a = tuple(range(5))
              print(a)
              type(a)<code></pre>
              <p>Produces:</p>
              <pre>(0,1,2,3,4)
              <class 'range'></pre>
              <p>Note that simply assigning a label does not work, the 
              constructor has to be used:</p>
              <code class="language-python">a = range(5)
              print(a)<code></pre>
              <p>Produces:</p>
              <pre>'range(0,5)'</pre>
              <p>There are functions that work with sequences such as min() and 
              max() which will return the minimum and maximum item in a 
              sequence. The function index() can be used to find the first 
              occurence of a particular value in a sequence between different 
              parts of the sequence. For a sequence of Boolean values (True or 
              False) the function any() will return True if any of the items in 
              the sequence are True.</p>
              <code class="language-python">a = (1, 6, 9, 0, 6)
              print(min(a))
              print(max(a))
              print(a.index(6,0,4)) # Print the first index of item equal to 6 at or after index 0 and before index 4<code></pre>
              print(a.count(6)) # Print the count of items equal to 6 in a.
              b = (True, False)
              print(any(b)) # Print if any of the items in b are True.</code></pre>
              <p>Again copy this code into a file and have a play around.</p>
              
              <h2>3. Lists</h2>
              <p>We have already come across lists which are commonly used in 
              Python. They are essentially the mutable form of tuples. Lists 
              have an order, different types of thing can be stored in them, 
              things can be appended, inserted and removed from them. The 
              elements within the list can be reordered in various ways. They 
              are initialised with square brackets or using the list() 
              constructor method that takes in some othe container as an 
              argument. For example:</p>
              <pre><code class="language-python">a = [] # Create an empty list called a.
              a.append("apple") # Append the String "apple" to the list a
              print(len(a)) # Print the length of a
              print(a[0]) # Print the first element of a
              a.insert(0, 2) # Insert the Integer 2 into the first element of a
              a.reverse() # Reverse the order of elements in a
              a.del(1) # Remove the element in a at index 1
              b = list((1, 2, 4, 8))
              print(type(b))</code></pre>
              <p>Again copy this code into a file and have a play around.</p>
              <p>Extended indexing is a way of referencing values in a sequence.
              These are sometimes called a 'slice' (essentially slice objects 
              are generated, containing the indices generated by a range):</p>
              <pre>a[i:j] returns all the elements between i and j, including a[i] but not a[j]
              a[i:j:k] returns the same, but stepping k numbers each time.
              Slices must have at least [:] (slice everything), but the rest is optional.
              If j > len(a), the last position is used.
              If i is None or omitted, zero is used.
              If i > j, the slice is empty.
              What's important is the position of the colons.
              a[:2] # First two values.
              a[-2:] # Last two values.</pre>
              <p>Slices can be used with mutable sequences like lists for 
              assignment as well. Consider the following two examples:</p>
              <pre>>>> a = [0,1,2,3,4]
              >>> b = [10,20,30]
              >>> a[1:3] = b
              >>> a
              [0,10,20,30,3,4]
              # Note we replace 2 values with 3.</pre>
              <pre>>>> a = [0,1,2,3,4]
              >>> b = [10,20]
              >>> a[1:5] = b
              >>> a
              [0,10,20]
              # We replace 4 values with 2.</pre>
              <p>There is a function called zip() which allows for the joining 
              together of two lists or tuples. The items are effectively paired 
              up as follows:
              <pre>>>> a = [1,2,3,4,5]
              >>> b = [10,20,30,40,50]
              >>> c = zip(a,b)
              >>> d = list(c)
              >>> d
              [(1,10),(2,20),(3,30),(4,40),(5,50)]</pre>
              <p>This has varous uses which we will come onto a bit later...</p>
              <p>A final thing on lists for the time being is that command line 
              arguments are a list in Python. So, when a Python program is run 
              at the command line, you can pass information into it. Indeed, 
              when running a Python program from the command line, this is done.
              For instance consider:</p>
              <pre>python helloworld.py</pre>
              <p>This command passes the filename helloworld.py to the Python
              interpretter which then loads the file of commands to execute. 
              More elements can be passed into a program in this way and these 
              elements are called "command line arguments". They are typically 
              used to pass some key parameters to a program so the program can 
              use these. In this way software can be configured and run in 
              different ways without having to modify the code.</p>
              <p>A Python program can record command line arguments. The first 
              argument is the main program file to be run, but the arguments 
              following this and separated by a space are provided in a list 
              that can be accessed from within the program. For example, for:</p>
              <pre>python model.py arg1 arg2 arg3</pre>
              <p>Inside the program, these are made available in a list called 
              sys.argv where argv[0] is the script name (model.py in this case),
              after this, argv[1] is a String representation of arg1, argv[2] 
              is a String representation of arg2, and so on...</p>

              <h2>4. Arrays</h2>
              <p>Arrays can be very large and are used instead of lists for 
              efficiency when storing and processing collections of basic 
              types (characters, integers and floating point numbers). If you 
              know how many elements the collection will contain, then declaring 
              this when the array is initialised will typically improve 
              efficiency.</p>
              <p>Python arrays are in the 
              <a href="https://docs.python.org/3/library/array.html">array 
              module</a>.
              They can be made and used as follows:</p>
              <pre><code class="language-python">import array
              a = array.array('i',[0,0,0,0]) # Signed int type 'i'
              a.insert(3, 21) # Insert in position 3 the value 21
              print(a[3]) # Print the value at position 3</code></pre>
              <p>Arrays are quite specialist and are not so easy to use, so 
              perhaps don't spend time playing around with these and move on
              especially if this is you are new to Python and this is your first 
              use of this particular learning resource.</p>
              
              <h2>5. Sets</h2>
              <p>Sets are unordered collections. Adding something into a set 
              which already contains that thing will not change the set. They 
              are mostly used to test if something is or is not already 
              contained in the collection. Sets are created with curly braces:
              </p> 
              <pre><code class="language-python">a = {} # Empty set import array
              a.add("apple") # Add "apple" to a
              a.add("apple") # Add "apple" to a
              # As "apple" was already in a, it will still be of length 1</code></pre>
                            
              <h2>6. Dictionaries</h2>
              <p>Dictionaries hold keys and value pairs. The keys are unique
              the values can be anything. Dictionaries can be sorted by the 
              keys. The keys can be treated a bit like a set. Dictionaries can 
              be created using curly braces and colons to separate the keys 
              which are given first and the values which are given second. 
              Different paris are separated with commas. Alternatively the 
              <a href="https://docs.python.org/3/library/stdtypes.html#dict">
              dict()</a> constructor can be used:</p>
              <pre><code class="language-python">nickname = {thomas: tom, samuel: sam, samson: sam}
              nickname2 = dict([(thomas, tom), (samuel, sam), (samson, sam)])</code></pre>
              """);
        w.add("</div>");
    }
}
