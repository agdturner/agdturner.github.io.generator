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
              <p>There are various containers for data in Python including: 
              sequence objects (bytes, bytearrays, strings, tuples, ranges, 
              lists, arrays), sets and dictionaries. Similar data structures are
              available in other high level languages, but they may be called 
              different things. Some of these data structures are 'mutable' - 
              can be changed once they have been created, others are 'immutable'
              - cannot be changed once they have been created (although these 
              may contain things which themselves can be changed). Some are 
              ordered, or can be ordered, and others are unordered. A dictionary
              is a mapping of keys to values. In this part of the course we 
              introduce each in a bit more detail.</p>
              """);

        s = addSection("2", "Sequences", 2);
        w.add(s.sectionHTML);
        w.add("<p>A sequence is a particular class of object. The following are"
                + " perhaps more commonly used sequences: strings, tuples,"
                + " ranges, and lists.</p>");
        
        s = addSection("2.1", "Bytes and Bytearray", 3);
        w.add(s.sectionHTML);
        c.index.getReference("Byte", "", s.sid);
        w.add("<p>A "
                + c.index.getReference("Python byte", "byte", s.sid)
                + " is an immutable sequence of integers in the range [0, 255]. "
                + "</p>");
        w.add("<p>A "
                + c.index.getReference("Python bytearray", "bytearray", s.sid)
                + " is a mutable sequence of integers in the range [0, 255]."
                + "</p>");
        w.add("<p>These are worth knowing about, but are not used directly in "
                + "this course, so details are omitted.</p>");
        
        s = addSection("2.2", "Strings", 3);
        w.add(s.sectionHTML);
        w.add("<p>"
                + c.index.getReference("Python string", "Strings", s.sid)
                + " are immutable sequences of "
                + c.index.getReference("Unicode", s.sid)
                + " points. Unlike some other high level languages, Python"
                + " does not have a primitive type for individual characters."
                + " As strings are immutable: parts of a string cannot"
                + " be replaced with parts of another string. Instead of"
                + " changing a string, a new one has to be created. This is"
                + " a somewhat subtle difference, but it does mean that"
                + " processing with strings can be inefficient. Strings can"
                + " be created by encapsulating text in single or double"
                + " quotation marks, or using the function "
                + c.index.getReference("Python str", "str", s.sid)
                + " which allows strings to be constructed from other types of"
                + " object. Multiline strings are either encapsulated by triple"
                + " single quotes or triple double quotes.</p>");
        w.add("""
              <p>Strings may contain quotation marks. If a string is 
              encapsulated using single quotes, then in order to contain single
              quote symbols, then these need escaping by preceding them with a
              defined backslash '\\'. Similarly, if a string is encapsulated 
              using double quotes, then in order to contain double quote 
              symbols, then these need escaping. Also, if the string is to 
              include a backslash, then this also would need escaping.</p>
              <p>As a string is a sequence, parts of it can be accessed using 
              indexes and it can also be 'sliced' (as explained in detail in 
              <a href="#2.4">Section 2.4</a>). Strings can be concatenated 
              using the '+' symbol. Consider and try the following code:</p>
              <pre><code class="language-python">s0 = "this is a string"
              s2 = 'this is also a string'
              s3 = "string encapsulated with double quotes and containing single 'quotes'"
              s4 = 'string encapsulated with single quotes and containing double "quotes"'
              s5 = "string encapsulated with double quotes and containing double \"quotes\""
              s6 = 'string encapsulated with single quotes and containing single \'quotes\''
              s7 = str(s0) # A string constructed from another string
              print(s7) # < prints this is a string
              s8 = str(s0[8:]) # A string constructed from a slice of another string
              print(s8) # <-- Prints a string
              s9 = "strings " + "can be " + "concatenated using '+'"
              print(s9) # <-- Prints strings can be concatenated using '+'</code></pre>
              <p>A backslash can also ensure the continuation of a line. 
              For example:</p>
              <pre><code class="language-python">print('''This is \\
              all one line.
              This is a second.''')</code></pre>
              <p>Produces:</p>
              <pre>This is all one line.
              This is a second.</pre>
              <p>The symbol '#' can be included in a string. Source code 
              comments are only comments provided they are not in the string.
              So, running the following:</p>
              <pre><code class="language-python">print('''This is \\ # Not a comment  
              all one line.''')</code></pre>
              <p>Results in:</p>
              <pre>This is \\ # Not a comment 
              all one line.</pre>
              <p>It is sometimes easier to use concatenation in order to add 
              source code comments:</p>
              <pre><code class="language-python">print("This is " + # A comment
              "all one line.")
              print("This is a second")</code></pre>
              <pResults in:</p>
              <pre>This is all one line.
              This is a second.</pre>
              <p>The string class contains many useful
              <a href="https://docs.python.org/3/library/stdtypes.html#string-methods">
              methods</a> for processing strings. (Methods being functions 
              belonging to the class.) For example, strings can be split into a 
              list using a delimiter. As it is a method, this functionality can 
              be used in a couple of ways:</p>
              <pre><code class="language-python">s = "A simple string to split."
              delimiter = " " # What is used to split the String into parts
              # Split by accessing the function and passing the string to be split as a parameter.
              split0 = str.split(s, delimiter) 
              print(split0)
              # Split by accessing the function from the string instance.
              split1 = s.split(delimiter)
              print(split1)</code></pre>
              <p>The two ways produce the same result. The delimeter is 
              optional, by default it is any blank space (a continuous sequence 
              of spaces, tabs and/or newlines).</p>
              <p>Search and replace is a common string operation as is finding 
              out if a string starts or ends with a particular string.</p>
              """);

        s = addSection("2.3", "Tuples", 3);
        w.add(s.sectionHTML);
        w.add("A "
                + c.index.getReference("Python tuple", "tuple", s.sid)
                + " is an immutable sequence that can be added to and nested."
                + " Like strings, once created the items cannot be substituted "
                + " and their order cannot be changed - although they may"
                + " themselves contain items that can be modified. Tuples are "
                + " commonly used to return a sequence of things from"
                + " functions. Functions can only return one thing, but that"
                + " thing can be a tuple that effectively packs a sequence of"
                + " things together. Consider the following code where there is"
                + " some packing and unpacking of a tuple:</p>");
        w.add("""
              <pre><code class="language-python">a = () # A new empty tuple
              print(len(a)) # <-- Prints 0
              b = (1, "two", 4) # Pack 3 things into b
              print(len(b)) # Prints 3
              c, d, e = b # unpack b into three things (c will refer to 1, d to "two" and e to 4)
              print(c) # <-- Prints 1
              print(d) # <-- Prints 'two'
              singleton = 'hello', # <-- Note the trailing comma.
              print(len(singleton)) # Prints 1</code></pre>
              <p>Try the code yourself, then consider the following code snippet
              which generates part of a 
              <a href="https://en.wikipedia.org/wiki/Fibonacci_number">
              Fibonacci series</a> of integer numbers:</p>
              <pre><code class="language-python"># Fibonacci series - the sum of the last two numbers in a sequence defines the next
              a, b = 0, 1
              print(a)
              while b < 10:
                  print(b)
                  a, b = b, a+b
              print(b)</code></pre>
              """);
        w.add("<p>The "
                + c.index.getReference("Python while", "while statement")
                + " is a loop with an expression that is evaluated each time"
                + " around the loop. While this expression 'b < 10' evaluates"
                + " as 'True' the loop continues to run, when it evaluates as"
                + " 'False', the program continues by executing the next line"
                + " after the loop. Notice in the example how things are packed"
                + " and unpacked in the tuples. Such packing/unpacking is"
                + " is not common in other languages (currently).</p>");

        s = addSection("2.4", "Ranges", 3);
        w.add(s.sectionHTML);
        w.add("<p>"
                + c.index.getReference("Python range", "Ranges", s.sid)
                + " are a special type of immutable sequence created as"
                + " follows:</p>");
        w.add("""
              <pre><code class="language-python">range(start, stop, step) # start and step are optional and default to 0 and 1 repectively</code></pre>
              <p>The parameters: start, stop and step should be integers. The 
              range function generates numbers up to but not including stop, 
              for example:</p>
              <pre><code class="language-python">for x in range(4):
                  print(x)
              </pre></code>
              <p>Results in:</p>
              <pre>0
              1
              2
              3</pre>              
              <pre><code class="language-python">for x in range(2,8,2):
                  print(x)</pre></code>
              <p>Results in:</p>
              <pre>2
              4
              6</pre>
              <pre><code class="language-python">for x in range(0,-5,-1)
                  print(x)</pre></code>
              <p>Results in:</p>
              <pre>0
              -1
              -2
              -3
              -4</pre>
              <p>Try the code for yourself and then try to generate the 
              following using range and a for loop:</p>
              <pre>-10
              -5
              0
              5
              10</pre>
              <p>A tuple can be constructed from a range or another sequence 
              producer:</p>
              <code class="language-python">r = range(5)
              type(r) # <-- Prints <class 'range'>
              print(r) # <-- Prints range(0, 5)
              t = tuple(r)
              print(t) # <-- Prints (0, 1, 2, 3, 4)</code></pre>
              """);
        w.add("<p>There are various "
                + c.index.getReference("Python Built-in Functions",
                        "built-in functions", s.sid)
                + " that process sequences, for example "
                + "<a href=\"https://docs.python.org/3/library/functions.html#min\">"
                + "min</a>"
                + " will return the minimum value, "
                + "<a href=\"https://docs.python.org/3/library/functions.html#max\">"
                + "max</a>"
                + " will return the minimum value, and "
                + "<a href=\"https://docs.python.org/3/library/functions.html#sum\">"
                + "sum</a>"
                + " will add up all the values in a sequence.</p>");
        w.add("<p>Additionally, there are a number of "
                + "<a href=\"https://docs.python.org/3/library/stdtypes.html#common-sequence-operations\">"
                + "common sequence methods</a>: The method 'index' will return "
                + "the index of the first occurrence of an object equal to a "
                + "given value. The method 'count' will return the number of "
                + "occurrences instances of objects equal to a given value. "
                + "For a sequence of boolean values ('True' or 'False') the "
                + "method 'any' will return 'True' if any of the items in "
                + "the sequence are 'True'.</p>:");
        w.add("""
              <pre><code class="language-python">a = (1, 6, 9, 0, 6)
              print(min(a))
              print(max(a))
              print(sum(a))
              print(a.index(6,0,4)) # Print the first index of item equal to 6 at or after index 0 and before index 4
              print(a.count(6)) # Print the count of items equal to 6 in a.
              b = (True, False)
              print(any(b)) # Print if any of the items in b are True.</code></pre>
              """);

        s = addSection("2.5", "Lists", 3);
        w.add(s.sectionHTML);
        w.add("<p>"
                + c.index.getReference("Python list", "Lists", s.sid)
                + " are the mutable form of tuples. Lists have an order,"
                + " different types of thing can be stored in them, things can"
                + " be appended, inserted and removed from them. The elements"
                + " within a list can be reordered and there are various"
                + " methods that help with this.</p>");
        w.add("""
              <p>Lists are initialised with square brackets or using the
              constructor that can take in some other container as an argument. 
              For example:</p>
              <pre><code class="language-python">a = [] # Create an empty list called a.
              a.append("apple") # Append the String "apple" to the list a
              print(len(a)) # Print the length of a
              print(a[0]) # Print the first element of a
              a.insert(0, 2) # Insert the Integer 2 into a at index 0
              a.reverse() # Reverse the order of elements in a
              del a[1] # Remove the element of a at index 1
              a.remove('apple') # Remove the first occurance of 'apple' in the list
              b = list((1, 2, 4, 8))
              print(type(b))
              print(b)</code></pre>
              <p>Run this code and check if the output is what you expect and 
              then have a play around trying some different things.</p>
              """);
        w.add("""
              <p>A 'slice' of a sequence contains all those items at the 
              indexes given by a range:</p>
              <pre><code class="language-python">a = [0, 1, 2, 3, 4]
              print("a", a)
              i = 1
              j = 3
              b = a[i:j] # a between and including a[i] and a[j - 1]
              print("b", b)
              k = 2
              c = a[i:j:k] # a between and including a[i] and a[j - 1], but stepping k indexes each time.
              print("c", c)
              d = a[:] # A complete slice i.e. all items of a
              print("d", d)</code></pre>
              """);
        w.add("""
              <p>In slicing a list a using a[i:j:k]:</p>
              <ul>
              <li>If j > len(a), the last position is used.</li>
              <li>If i is None or omitted, zero is used.</li>
              <li>If i > j, the slice is empty.</li>
              </ul>
              <p>Negative indexes can be used:</p>
              <ul>
              <li>a[:2] # First two values.</li>
              <li>a[-2:] # Last two values.</li>
              </ul>
              <p>Slices can be used with mutable sequences like lists for 
              assignment. Consider the following example that replaces values 
              from one list with the values from another:</p>
              <pre><code class="language-python">a = [0,1,2,3,4]
              b = [10,20,30]
              a[1:3] = b
              print(a) # <-- Prints [0,10,20,30,3,4]</code></pre>
              <p>Notice that the values '1' and '2' originally in index 
              positions 1 and 2 of 'a' are replaced by the three values in 'b'.
              It is perhaps easier to thing of replacements as deletions and 
              insertions.</p> 
              <p>The following example replaces 4 values with 2:</p>
              <pre><code class="language-python">a = [0,1,2,3,4]
              b = [10,20]
              a[1:5] = b
              print(a) # <-- Prints [0,10,20]</code></pre>
              """);
        w.add("<p>The "
                + c.index.getReference("Python builtins", "builtin module")
                + " function "
                + c.index.getReference("Python zip", "zip", s.sid)
                + " can be used to combine lists into a sequence of tuples as"
                + " follows:</p>");
        w.add("""
              <pre><code class="language-python">a = [1,2,3,4,5]
              b = [10,20,30,40,50]
              c = zip(a,b)
              d = list(c)
              print(d) # <-- Prints [(1,10),(2,20),(3,30),(4,40),(5,50)]</code></pre>
              <p>The zip function pairs up the values by index. If the sequences 
              have different lengths then the paired up list is the length of 
              the shorter sequence and does not contain the end of the longer 
              sequence.</p>
              """);
        w.add("""
              <p>Command line arguments are passed in a list. For example, the
              following command passes the filename 'HelloWorld.py' to the 
              Python interpreter which then loads the file of commands to 
              execute:</p>
              <pre>python HelloWorld.py</pre>
              <p>More command line arguments can be passed, each one separated 
              by a space.</p>
              <p>The Python program receives the command line arguments as a 
              list. The first item in the list is the program filename. For 
              example, the following Python run command passes in four 
              arguments:</p>
              <pre>python model.py arg1 arg2 arg3</pre>
              <p>Inside the program, these are made available in a list called 
              'sys.argv'. In the last example, sys.argv[0] is "model.py", 
              sys.argv[1] is "arg1", sys.argv[2] is "arg2" and sys.argv[3] is 
              "arg3".</p>
              """);
        
        s = addSection("2.6", "Arrays", 3);
        w.add(s.sectionHTML);
        w.add("<p>"
                + c.index.getReference("Python array", "Arrays", s.sid)
                + " are for storing and processing large collections of"
                + " things of the same type. Typically those things are"
                + " numbers. An array is like a list but it cannot be used to"
                + " store anything, it can only store things of a specific"
                + " type.</p>");
        w.add("<p>The following creates an array containing signed Integers and"
                + " inserts a new Integer value into the array. The attempts to"
                + " insert a Float into the array which results in a "
                + c.index.getReference("Python array", "TypeError", s.sid)
                + ":</p>");
        w.add("""
              <pre><code class="language-python">import array
              a = array.array('i', [1, 2, 3, 4])
              print(a)
              a.insert(2, 4)
              print(a)
              a.insert(2, 2.5)
              </code></pre>
              """);
        
        s = addSection("3", "Sets", 2);
        w.add(s.sectionHTML);
        w.add("<p>"
                + c.index.getReference("Python set", "Sets", s.sid)
                + " are unordered collections. Adding something into a set"
                + " which already contains that thing will not change the set."
                + " It is easy to test whether or not something is in a set."
                + " The following code creates an empty set, adds some things"
                + " into it and then tests if something is in the set.</p>");
        w.add("""
              <pre><code class="language-python">a = set() # Empty set
              a.add("apple") # Add "apple" to a
              a.add("orange") # Add "orange" to a
              if "orange" in a:
                  print('"orange" is in a')</code></pre>
              <p>Traditional mathemetical set functions like union() and 
              intersection() are available for sets which can also be compared.
              Two sets are equal if they contain all of the same elements.</p> 
              """);
        
        s = addSection("4", "Dictionaries", 2);
        w.add(s.sectionHTML);
        w.add("<p>"
                + c.index.getReference("Python dict", "Dictionaries", s.sid)
                + " hold key-value pairs. The keys are unique, the values can"
                + " be anything. Dictionaries can be created using curly braces"
                + " and colons to separate the keys, which are given first, and"
                + " the values, which are given second. Different pairs are"
                + " separated with commas. Alternatively the dict() constructor"
                + " method can be used. The following code creates a dictionary"
                + " and retrieves a value for a particular key and prints it:"
                 + "</p>");
        w.add("""
              <pre><code class="language-python">alias = dict([("rm", "remove"), ("cd", "change directory"), ("ls", "list")])
              print(alias.get("rm")) # <-- This should print 'remove'.
              </code></pre>
              <p>There are functions that help with modifying and processing 
              dictionaries.</p>
              """);
        
        w.add("""
              <h3 id="5">Further reading</h3>
              <p><a href="https://docs.python.org/3/tutorial/datastructures.html">
              Python documentation tutorial about data structures</a>.
              """);
        w.add("</div>");
    }
}
