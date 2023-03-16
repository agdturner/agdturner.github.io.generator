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
        Section s;
        s = addSection("1", "Introduction", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>Data structures types in Python include: sequences, tuples, 
              ranges, lists, arrays, sets and dictionaries. Similar data 
              structures are available in other high level languages, but they 
              may be called different things. Some of the aforementioned Python
              data structures are mutable - can be changed once they have been 
              created, others are immutable - cannot be changed once they have 
              been created (although these may contain things which themselves 
              can be changed). Some are ordered, or can be ordered, and others 
              are unordered.</p>
              """);
        
        s = addSection("2", "Sequences", 2);
        w.add(s.sectionHTML);
        w.add("<p>A "
                + c.index.getReference("Python lists", "list", s.sid)
                + " is a sequence as are "
                + c.index.getReference("Python bytes", "bytes", s.sid)
                + " and a "
                + c.index.getReference("Python string", "strings", s.sid)
                + ". Strings are immutable sequences of"
                + c.index.getReference("Unicode", s.sid)
                + " points. Unlike some other high level languages, Python"
                + " does not have a primitive type for individual characters."
                + " As strings in Python are immutable, part of a string cannot"
                + " be replaced with part of another string. Instead of"
                + " changing a string, a new one has to be created. This can"
                + " make processing with strings seem inefficient. Strings can"
                + " be created using either single or double quotation marks,"
                + " one places before at the start and placed after the end of"
                + " a sequence of single length strings.</p>");
        w.add("<p>Multiline strings are either encapsulated by triple single"
                + " quotes or triple double quotes. The function "
                + c.index.getReference("Python str", "str", s.sid)
                + " can be used to create strings from other types of "
                + "object.</p>");
        w.add("""
              <p>Strings may contain quotation marks, but if a string is to 
              contain single or double quotes, then these need escaping using 
              the backslash escape character '\\'. If the string itself is to 
              include a backslash, then this also would need escaping.</p>
              <p>As a string is a sequence, parts of it can be accessed using 
              indexes and slices. Consider the following and 
              try the code out for yourself:</p>
              <pre><code class="language-python">print('''This is \\
              all one line.
              This is a second.''')</code></pre>
              <p>The backslash at the end of the first line ensures the 
              continuation of the line. Unfortunately, a comment cannot be 
              added at the end of a line that is continued in this way, so the 
              following does not work:</p>
              <pre><code class="language-python">print('''This is \\ # Not a comment, but is  
              all one line.
              This is a second.''')</code></pre>
              </p> The + operator allows to join strings and this allows also 
              for comments to work:</p>
              <pre><code class="language-python">print("This is all " + # This comment works fine!
              "one line.")
              print("This is a second")</code></pre>
              <p>Strings contain many useful funtions for working on Strings 
              which can be accessed in a couple of ways, for example Strings 
              can be split by:</p>
              <pre><code class="language-python">a = "A simple string to split."
              delimeter = " " # What is used to split the String into parts
              a_split0 = str.split(a, delimiter) # Doing the split one way
              print(a_split0)
              a_split1 = a.split(delimiter)
              print(a_split1)</code></pre>
              <p>There is no real difference between the two ways and it is down 
              to programming preference as to what is used. Note that the 
              delimeter is also optional, but by default is white space (a 
              continuous sequence of spaces, tabs and newlines)</p>
              <p>Search and replace is a common String operation as is finding 
              out if a string starts or ends with a particular String
              
              <h3 id="2.2">2.2. Tuples</h3>
              A Tuple is also a sequence. Tuple elements (items) are separated 
              with commas. An empty tuple can be made using parentheses. Tuples 
              can be added to and nested. Like Strings, Tuples are immutable in 
              that once created the items cannot be substituted and their order 
              cannot be changed - although they may themselves contain items 
              that can be modified. Tuples are commonly used for function 
              returns where several things are to be returned from a function. 
              Returning a Tuple effectively packs the things together. Consider 
              the following code where there is some packing and unpacking of a 
              tuple:</p>
              <pre><code class="language-python">a = ()
              print(len(a)) # <-- Prints 0
              singleton = 'hello', # <-- Note the trailing comma.
              print(len(singleton)) # Prints 1
              b = (1, "two", 4) # Pack 3 things into b
              c, d, e = b # unpack b into three things (c will refer to 1, d to "two" and e to 4)
              print(c) # <-- Prints 1
              print(d) # <-- Prints 'two'</code></pre>
              <p>Try the code yourself, then consider the following code snippet
              which generates part of a 
              <a href="https://en.wikipedia.org/wiki/Fibonacci_number">
              Fibonacci series</a> of Integers:</p>
              <pre><code class="language-python"># Fibonacci series - the sum of the last two numbers in a sequence defines the next
              a, b = 0, 1
              print(a)
              while b < 10:
                  print(b)
                  a, b = b, a+b
              print(b)</code></pre>
              <p>The While Statement is a loop with an expression that is 
              evaluated each time around the loop. While the expression 'b < 10'
              evaluates to True the loop continues to run, when it evaluates 
              to False, the program continues by executing the next line after 
              the loop.</p>
              
              <h3 id="2.3">2.3. Ranges</h3>
              <p>Ranges are a special type of immutable sequence. They are 
              created as follows:
              <pre><code class="language-python">range(start, stop, step) # start and step are optional and default to 0 and 1 repectively</code></pre>
              <p>The parameters: start, stop and step should be Integers. The 
              range function generates numbers up to but not including stop, 
              for example:</p>
              <pre><code class="language-python">r = range(4) # generates 0,1,2,3
              print(r)
              r = range(2,8,2) # generates 2,4,6
              print(r)
              r = range(0,-5,-1) # generates 0,-1,-2,-3,-4
              print(r)</pre></code>
              <p>Try the code for yourself and have a play around. See if you 
              can generate the sequence: -10, -5, 0, 5, 10.</p>
              <p>Another way to create a Tuple is to use the Tuple constructor 
              tuple() giving this an argument which is a sequence or producer of
              a sequence like range:</p>
              <code class="language-python">a = tuple(range(5))
              print(a) # <-- Prints (0,1,2,3,4)
              type(a) # <-- Prints <class 'range'></code></pre>
              <p>Note that simply assigning a label does not work, the 
              constructor has to be used:</p>
              <code class="language-python">a = range(5)
              print(a) # <-- Prints 'range(0,5)'</code></pre>
              <p>There are functions that work with sequences such as min() and 
              max() which will return the minimum and maximum item in a 
              sequence. The function index() can be used to find the first 
              occurence of a particular value in a sequence between different 
              parts of the sequence. For a sequence of Boolean values (True or 
              False) the function any() will return True if any of the items in 
              the sequence are True.</p>
              <pre><code class="language-python">a = (1, 6, 9, 0, 6)
              print(min(a))
              print(max(a))
              print(a.index(6,0,4)) # Print the first index of item equal to 6 at or after index 0 and before index 4
              print(a.count(6)) # Print the count of items equal to 6 in a.
              b = (True, False)
              print(any(b)) # Print if any of the items in b are True.</code></pre>
              <p>Again copy this code into a file and have a play around.</p>
              
              <h3 id="2.4">2.4. Lists</h3>
              <p>Lists are commonly used in python. They are the mutable form of 
              tuples. Lists have an order, different types of thing can be 
              stored in them, things can be appended, inserted and removed from 
              them. The elements within the list can be reordered in various 
              ways. They are initialised with square brackets or using the 
              constructur function list() that can take in some other container 
              as an argument. For example:</p>
              <pre><code class="language-python">a = [] # Create an empty list called a.
              a.append("apple") # Append the String "apple" to the list a
              print(len(a)) # Print the length of a
              print(a[0]) # Print the first element of a
              a.insert(0, 2) # Insert the Integer 2 into a at index 0
              a.reverse() # Reverse the order of elements in a
              a.del(1) # Remove the element of a at index 1
              b = list((1, 2, 4, 8))
              print(type(b))</code></pre>
              <p>Again copy this code into a file, run it and check the output
              then have a play around.</p>
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
              assignment. Consider the following example that replaces 2 values 
              in one with the values from another list:</p>
              <pre><code class="language-python">a = [0,1,2,3,4]
              b = [10,20,30]
              a[1:3] = b
              print(a) # <-- Prints [0,10,20,30,3,4]</code></pre>
              <p>The next example replaces 4 values with 2:</p>
              <pre><code class="language-python">a = [0,1,2,3,4]
              b = [10,20]
              a[1:5] = b
              print(a) # <-- Prints [0,10,20]</code></pre>
              <p>The builtin module function zip() can be used to join together 
              lists or tuples as follows:
              <pre><code class="language-python">a = [1,2,3,4,5]
              b = [10,20,30,40,50]
              c = zip(a,b)
              d = list(c)
              print(d) # <-- Prints [(1,10),(2,20),(3,30),(4,40),(5,50)]</code></pre>
              <p>The zip function pairs up the values by index. If the sequences 
              have different lengths then the paired up list is the length of 
              the shorter sequence and does not contain the end of the longer 
              sequence.</p>
              <p>Command line arguments are passed in a list. For example, the
              following command passes the filename HelloWorld.py to the Python
              interpreter which then loads the file of commands to execute:</p>
              <pre>python HelloWorld.py</pre>
              <p>More command line arguments can be passed, each one separated 
              by a space.</p>
              <p>The python program receives the command line arguments as a list. 
              The first item in the list is the program filename. For example, 
              the following is a python run command that passes in four 
              arguments:</p>
              <pre>python model.py arg1 arg2 arg3</pre>
              <p>Inside the program, these are made available in a list called 
              sys.argv. In the last example, sys.argv[0] is "model.py", 
              sys.argv[1] is "arg1", sys.argv[2] is "arg2" and sys.argv[3] is 
              "arg3".</p>

              <h2 id="4">4. Arrays, Sets, Dictionaries</h2>
              
              <h3 id="4.1">4.1. Arrays</h3>
              <p>Arrays are suited to storing and processing large collections 
              of Bytes, Integers or Floats. If it is known as to how many 
              elements the array will contain, then declaring this in the 
              initialisation can be more efficient.</p>
              <p>Python arrays are classes declared in the 
              <a href="https://docs.python.org/3/library/array.html">array 
              module</a>.
              They can be made and used as follows:</p>
              <pre><code class="language-python">import array
              a = array.array('i',[0,0,0,0]) # Signed int type 'i'
              a.insert(3, 21) # Insert in position 3 the value 21
              print(a[3]) # Print the value at position 3</code></pre>
              
              <h3 id="4.2">4.2. Sets</h3>
              <p>Sets are unordered collections. Adding something into a set 
              which already contains that thing will not change the set. It is 
              easy to test whether or not something is in a set. Sets are 
              created using the 
              <a href="https://docs.python.org/3/library/stdtypes.html#set">
              set()</a> constructor, for example:</p>
              <pre><code class="language-python">a = set() # Empty set
              a.add("apple") # Add "apple" to a
              a.add("orange") # Add "orange" to a
              if "orange" in a:
                  print('"orange" is in a')</code></pre>
              <p>Traditional mathemetical set functions like union() and 
              intersection() are available for sets which can also be compared.
              Two sets are equal if they contain all of the same elements.</p> 
                            
              <h3 id="4.3">4.3. Dictionaries</h3>
              <p>Dictionaries hold key-value pairs. The keys are unique, the
              values can be anything. Dictionaries can be sorted by the keys. 
              The keys can be treated a bit like a set. Dictionaries can 
              be created using curly braces and colons to separate the keys,
              which are given first, and the values, which are given second. 
              Different pairs are separated with commas. Alternatively the 
              <a href="https://docs.python.org/3/library/stdtypes.html#dict">
              dict()</a> constructor can be used, for example:</p>
              <pre><code class="language-python">nickname = {"thomas": "tom", "samuel": "sam", "samson": "sam"}
              alias = dict([("rm", "remove"), ("cd", "change directory"), ("ls", "list")])
              print(alias.get("rm")) # <-- This should print 'remove'.
              </code></pre>
              <p>Again there are functions that help with modifying and 
              processing dictionaries.</p>
              
              <h3 id="5">Further reading</h3>
              <p><a href="https://docs.python.org/3/tutorial/datastructures.html">
              Python documentation tutorial about data structures</a>.
              """);
        w.add("</div>");
    }
}
