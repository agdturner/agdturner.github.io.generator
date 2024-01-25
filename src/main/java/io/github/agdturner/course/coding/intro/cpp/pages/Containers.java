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
 * For CPP Intro Course Containers Page.
 *
 * @author Andy Turner
 */
public class Containers extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public Containers(CPPIntroCodingCourse course) {
        super(course, "containers", "Containers", "Containers");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        w.addP(sb,
                """
                There are various containers for data in Python including:
                sequence objects (bytes, bytearrays, strings, tuples, ranges,
                lists, arrays), sets and dictionaries. Similar data structures
                are available in other high level languages, but they may be
                called different things. Some of these data structures are
                'mutable' - can be changed once they have been created, others
                are 'immutable' - cannot be changed once they have been created
                (although these may contain things which themselves can be
                changed). Some are ordered, or can be ordered, and others are
                unordered. A dictionary is a mapping of keys to values.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Sequences", sb);
        w.addP(sb,
                """
                Commonly used sequences include: strings, tuples, ranges, and
                lists.
                """);

        sid = addSubsection("Bytes and Bytearray", sb);
        index.getReference("Bytes", "", sid);
        w.addPST(sb, "A ");
        sb.append(index.getReference("Python bytes", "bytes", sid));
        sb.append(
                """
                 container stores an immutable sequence of integers in the
                range [0, 255]. Since many major binary protocols are based on
                """);
        sb.append(index.getReference("ASCII", sid));
        sb.append(
                """
                 text encoding, bytes objects offer several methods that are only
                valid when working with ASCII compatible data and are closely
                related to
                """);
        sb.append(index.getReference("Python strings", "strings", sid));
        w.addPET(sb, " in other ways.");
        w.addPST(sb, "A ");
        sb.append(index.getReference("Python bytearray", "bytearray", sid));
        w.addPET(sb,
                " is a mutable sequence of integers in the range [0, 255].");
        w.addP(sb,
                """
                These are worth knowing about, but are not directly in this
                course, so details are omitted.
                """);

        sid = addSubsection("Strings", sb);
        w.addPST(sb, "");
        sb.append(index.getReference("Python strings", "Strings", sid));
        sb.append(" are immutable sequences of ");
        sb.append(index.getReference("Unicode", sid));
        sb.append(
                """
                 points. Unlike some other high level languages, Python does not
                have a primitive type for individual characters. As strings are
                immutable: parts of a string cannot be replaced with parts of
                another string. Instead of changing a string, a new one has to
                be created. This is a somewhat subtle difference, but it does
                mean that processing with strings can be inefficient. Strings
                can be created by encapsulating text in single or double
                quotation marks, or using the function
                """);
        sb.append(index.getReference("Python str", "str", sid));
        w.addPET(sb,
                """
                 which allows strings to be constructed from other types of
                object. Multiline strings are either encapsulated by triple
                single quotes or triple double quotes.
                """);
        w.addP(sb,
                """
                Strings may contain quotation marks. If a string is encapsulated
                using single quotes, then in order to contain single quote
                symbols, then these need escaping by preceding them with a
                defined backslash '\\'. Similarly, if a string is encapsulated
                using double quotes, then in order to contain double quote
                symbols, then these need escaping. Also, if the string is to
                include a backslash, then this also would need escaping.
                """);
        w.addP(sb,
                """
                As a string is a sequence, parts of it can be accessed using
                indexes and it can also be 'sliced' (as explained in detail in
                <a href="#2.4">Section 2.4</a>). Strings can be concatenated
                using the '+' symbol. Consider and try the following code:
                """);
        addCodeBlock(sb,
                """
                s0 = "this is a string"
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
                print(s9) # <-- Prints strings can be concatenated using '+'
                """);
        w.addP(sb,
                """
                A backslash can also ensure the continuation of a line. For
                example:
                """);
        addCodeBlock(sb,
                """
                print('''This is \\
                all one line.
                This is a second.''')
                """);
        w.addP(sb, "Produces:");
        w.addPRE(sb,
                """
                This is all one line.
                This is a second.
                """);
        w.addP(sb,
                """
                The symbol '#' can be included in a string. Source code
                comments are only comments provided they are not in the string.
                So, running the following:
                """);
        addCodeBlock(sb,
                """
                print('''This is \\ # Not a comment
                all one line.''')
                """);
        w.addP(sb, "Results in:");
        w.addPRE(sb,
                """
                This is \\ # Not a comment
                all one line.
                """);
        w.addP(sb,
                """
                It is sometimes easier to use concatenation in order to add
                source code comments:
                """);
        addCodeBlock(sb,
                """
                print("This is " + # A comment
                "all one line.")
                print("This is a second")
                """);
        w.addP(sb, "Results in:");
        w.addPRE(sb,
                """
                This is all one line.
                This is a second.
                """);
        w.addP(sb,
                """
                The string class contains many useful
                <a href="https://docs.python.org/3/library/stdtypes.html#string-methods">
                methods</a> for processing strings. (Methods being functions
                belonging to the class.) For example, strings can be split into
                a list using a delimiter. As it is a method, this functionality
                can be used in a couple of ways:
                """);
        addCodeBlock(sb,
                """
                s = "A simple string to split."
                delimiter = " " # What is used to split the String into parts
                # Split by accessing the function and passing the string to be split as a parameter.
                split0 = str.split(s, delimiter)
                print(split0)
                # Split by accessing the function from the string instance.
                split1 = s.split(delimiter)
                print(split1)
                """);
        w.addP(sb,
                """
                The two ways produce the same result. The delimeter is optional,
                by default it is any blank space (a continuous sequence of
                spaces, tabs and/or newlines).
                """);
        w.addP(sb,
                """
                Search and replace is a common string operation as is finding
                out if a string starts or ends with a particular string.
                """);

        sid = addSubsection("Tuples", sb);
        w.addPST(sb, "A ");
        sb.append(index.getReference("Python tuple", "tuple", sid));
        w.addPET(sb,
                """
                 is an immutable sequence that can be added to and nested. Like
                strings, once created the items cannot be substituted and their
                order cannot be changed - although they may themselves contain
                items that can be modified. Tuples are commonly used to return a
                sequence of things from functions. Functions can only return one
                thing, but that thing can be a tuple that effectively packs a
                sequence of things together. Consider the following code where
                there is some packing and unpacking of a tuple:
                """);
        addCodeBlock(sb,
                """
                a = () # A new empty tuple
                print(len(a)) # <-- Prints 0
                b = (1, "two", 4) # Pack 3 things into b
                print(len(b)) # Prints 3
                c, d, e = b # unpack b into three things (c will refer to 1, d to "two" and e to 4)
                print(c) # <-- Prints 1
                print(d) # <-- Prints 'two'
                singleton = 'hello', # <-- Note the trailing comma.
                print(len(singleton)) # Prints 1
                """);
        w.addP(sb,
                """
                Try the code yourself, then consider the following code snippet
                which generates part of a
                <a href="https://en.wikipedia.org/wiki/Fibonacci_number">
                Fibonacci series</a> of integer numbers:
                """);
        addCodeBlock(sb,
                """
                # Fibonacci series - the sum of the last two numbers in a sequence defines the next
                a, b = 0, 1
                print(a)
                while b < 10:
                    print(b)
                    a, b = b, a+b
                print(b)
                """);
        w.addP(sb, "The ");
        sb.append(index.getReference("Python while", "while statement"));
        w.addP(sb,
                """
                is a loop with an expression that is evaluated each time around
                the loop. While this expression 'b < 10' evaluates as 'True' the
                loop continues to run, when it evaluates as 'False', the program
                continues by executing the next line after the loop. Notice in
                the example how things are packed and unpacked in the tuples.
                Such packing/unpacking is not common in other languages
                (currently).
                """);

        sid = addSubsection("Ranges", sb);
        w.addPST(sb, "");
        sb.append(index.getReference("Python range", "Ranges", sid));
        w.addPET(sb,
                " are a special type of immutable sequence created as follows:");
        addCodeBlock(sb,
                """
                range(start, stop, step) # start and step are optional and default to 0 and 1 repectively
                """);
        w.addP(sb,
                """
                The parameters: start, stop and step should be integers. The
                range function generates numbers up to but not including stop,
                for example:
                """);
        addCodeBlock(sb,
                """
                for x in range(4):
                    print(x)
                """);
        w.addP(sb, "Results in:");
        w.addPRE(sb,
                """
                0
                1
                2
                3
                """);
        addCodeBlock(sb,
                """
                for x in range(2,8,2):
                    print(x)
                """);
        w.addP(sb, "Results in:");
        w.addPRE(sb,
                """
                2
                4
                6
                """);
        addCodeBlock(sb,
                """
                for x in range(0,-5,-1)
                    print(x)
                """);
        w.addP(sb, "Results in:");
        w.addPRE(sb,
                """
                0
                -1
                -2
                -3
                -4
                """);
        w.addP(sb,
                """
                Try the code for yourself and then try to generate the following
                using range and a for loop:
                """);
        w.addPRE(sb,
                """
                -10
                -5
                0
                5
                10
                """);
        w.addP(sb,
                """
                A tuple can be constructed from a range or another sequence
                producer:
                """);
        addCodeBlock(sb,
                """
                r = range(5)
                type(r) # <-- Prints <class 'range'>
                print(r) # <-- Prints range(0, 5)
                t = tuple(r)
                print(t) # <-- Prints (0, 1, 2, 3, 4)
                """);
        w.addPST(sb, "There are various ");
        sb.append(index.getReference("Python Built-in Functions",
                "built-in functions", sid));
        w.addPET(sb,
                """
                 that process sequences, for example
                <a href="https://docs.python.org/3/library/functions.html#min">
                min</a>
                will return the minimum value,
                <a href="https://docs.python.org/3/library/functions.html#max">
                max</a>
                will return the minimum value, and
                <a href="https://docs.python.org/3/library/functions.html#sum">
                sum</a>
                will add up all the values in a sequence.
                """);
        w.addP(sb,
                """
                Additionally, there are a number of
                <a href="https://docs.python.org/3/library/stdtypes.html#common-sequence-operations">
                common sequence methods</a>: The method 'index' will return the
                index of the first occurrence of an object equal to a given
                value. The method 'count' will return the number of occurrences
                instances of objects equal to a given value. For a sequence of
                boolean values ('True' or 'False') the method 'any' will return
                'True' if any of the items in the sequence are 'True'.
                """);
        addCodeBlock(sb,
                """
                a = (1, 6, 9, 0, 6)
                print(min(a))
                print(max(a))
                print(sum(a))
                print(a.index(6,0,4)) # Print the first index of item equal to 6 at or after index 0 and before index 4
                print(a.count(6)) # Print the count of items equal to 6 in a.
                b = (True, False)
                print(any(b)) # Print if any of the items in b are True.
                """);

        sid = addSubsection("Lists", sb);
        w.addPST(sb, "");
        sb.append(index.getReference("Python list", "Lists", sid));
        w.addPET(sb,
                """
                 are the mutable form of tuples. Lists have an order, different
                types of thing can be stored in them, things can be appended,
                inserted and removed from them. The elements within a list can
                be reordered and there are various methods that help with this.
                """);
        w.addP(sb,
                """
                Lists are initialised with square brackets or using the
                constructor that can take in some other container as an
                argument. For example:
                """);
        addCodeBlock(sb,
                """
                a = [] # Create an empty list called a.
                a.append("apple") # Append the String "apple" to the list a
                print(len(a)) # Print the length of a
                print(a[0]) # Print the first element of a
                a.insert(0, 2) # Insert the Integer 2 into a at index 0
                a.reverse() # Reverse the order of elements in a
                del a[1] # Remove the element of a at index 1
                a.remove('apple') # Remove the first occurance of 'apple' in the list
                b = list((1, 2, 4, 8))
                print(type(b))
                print(b)
                """);
        w.addP(sb,
                """
                Run this code and check if the output is what you expect and
                then have a play around trying some different things.
                """);
        w.addP(sb,
                """
                A 'slice' of a sequence contains all those items at the indexes
                given by a range:
                """);
        addCodeBlock(sb,
                """
                a = [0, 1, 2, 3, 4]
                print("a", a)
                i = 1
                j = 3
                b = a[i:j] # a between and including a[i] and a[j - 1]
                print("b", b)
                k = 2
                c = a[i:j:k] # a between and including a[i] and a[j - 1], but stepping k indexes each time.
                print("c", c)
                d = a[:] # A complete slice i.e. all items of a
                print("d", d)
                """);
        w.addP(sb, "In slicing a list a using a[i:j:k]:");
        w.addULST(sb);
        w.addLI(sb, "If j > len(a), the last position is used.");
        w.addLI(sb, "If i is None or omitted, zero is used.");
        w.addLI(sb, "If i > j, the slice is empty.");
        w.addULET(sb);
        w.addP(sb, "Negative indexes can be used:");
        w.addULST(sb);
        w.addLI(sb, "a[:2] # First two values.");
        w.addLI(sb, "a[-2:] # Last two values.");
        w.addULET(sb);
        w.addP(sb,
                """
                Slices can be used with mutable sequences (like lists for
                assignment). Consider the following example that replaces values
                from one list with the values from another:
                """);
        addCodeBlock(sb,
                """
                a = [0,1,2,3,4]
                b = [10,20,30]
                a[1:3] = b
                print(a) # <-- Prints [0,10,20,30,3,4]
                """);
        w.addP(sb,
                """
                Notice that the values '1' and '2' originally in index
                positions 1 and 2 of 'a' are replaced by the three values in 'b'.
                It is perhaps easier to thing of replacements as deletions and
                insertions.
                """);
        w.addP(sb, "The following example replaces 4 values with 2:");
        addCodeBlock(sb,
                """
                a = [0,1,2,3,4]
                b = [10,20]
                a[1:5] = b
                print(a) # <-- Prints [0,10,20]
                """);
        w.addPST(sb,"<p>The ");
        sb.append(index.getReference("Python builtins", "builtin module"));
        sb.append(" function ");
        sb.append(index.getReference("Python zip", "zip", sid));
        w.addPET(sb,
                """
                 can be used to combine lists into a sequence of tuples as
                follows:
                """);
        addCodeBlock(sb,
                """
                a = [1,2,3,4,5]
                b = [10,20,30,40,50]
                c = zip(a,b)
                d = list(c)
                print(d) # <-- Prints [(1,10),(2,20),(3,30),(4,40),(5,50)]
                """);
        w.addP(sb,
                """
                The zip function pairs up the values by index. If the sequences
                have different lengths then the paired up list is the length of
                the shorter sequence and does not contain the end of the longer
                sequence.
                """);
        w.addP(sb,
                """
                Command line arguments are passed in a list. For example, the
                following command passes the filename 'HelloWorld.py' to the
                Python interpreter which then loads the file of commands to
                execute:
                """);
        w.addPRE(sb, "python HelloWorld.py");
        w.addP(sb,
                """
                More command line arguments can be passed, each one separated
                by a space.
                """);        
        w.addP(sb,
                """
                The Python program receives the command line arguments as a
                list. The first item in the list is the program filename. For
                example, the following Python run command passes in four
                arguments:
                """);
        w.addPRE(sb, "python model.py arg1 arg2 arg3");
        w.addP(sb,
                """
                Inside the program, these are made available in a list called
                'sys.argv'. In the last example, sys.argv[0] is "model.py",
                sys.argv[1] is "arg1", sys.argv[2] is "arg2" and sys.argv[3] is
                "arg3".
                """);

        sid = addSubsection("Arrays", sb);
        w.addPST(sb, "");
        sb.append(index.getReference("Python array", "Arrays", sid));
        w.addP(sb,
                """
                 are for storing and processing large collections of things of
                the same type. Typically those things are numbers. An array is
                like a list but it cannot be used to store anything, it can only
                store things of a specific type.
                """);
        w.addPST(sb,
                """
                The following creates an array containing signed Integers and
                inserts a new Integer value into the array. The attempts to
                insert a Float into the array which results in a
                """);
        sb.append(index.getReference("Python array", "TypeError", sid));
        w.addPET(sb, ":");
        addCodeBlock(sb,
                """
                import array
                a = array.array('i', [1, 2, 3, 4])
                print(a)
                a.insert(2, 4)
                print(a)
                a.insert(2, 2.5)
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Sets", sb);
        w.addPST(sb, "");
        sb.append(index.getReference("Python set", "Sets", sid));
        w.addPET(sb,
                """
                 are unordered collections. Adding something into a set which
                already contains that thing will not change the set. It is easy
                to test whether or not something is in a set. The following code
                creates an empty set, adds some things into it and then tests if
                something is in the set.
                """);
        addCodeBlock(sb,
                """
                a = set() # Empty set
                a.add("apple")    # Add "apple" to a
                a.add("orange") # Add "orange" to a
                if "orange" in a:
                    print('"or    ange" is in a')
                """);
        w.addPET(sb,
                """
                Traditional mathemetical set functions like union() and
                intersection() are available for sets which can also be
                compared. Two sets are equal if they contain all of the same
                elements.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Dictionaries", sb);
        w.addPST(sb, "");
        sb.append(index.getReference("Python dict", "Dictionaries", sid));
        w.addPET(sb,
                """
                 hold key-value pairs. The keys are unique, the values can be
                anything. Dictionaries can be created using curly braces and
                colons to separate the keys, which are given first, and the
                values, which are given second. Different pairs are separated
                with commas. Alternatively the dict() constructor method can be
                used. The following code creates a dictionary and retrieves a
                value for a particular key and prints it:
                """);
        addCodeBlock(sb,
                """
                alias = dict([("rm", "remove"), ("cd", "change directory"), ("ls", "list")])
                print(alias.get("rm")) # <-- This should print 'remove'.
                """);
        w.addP(sb,
                """
                There are functions that help with modifying and processing
                dictionaries.
                """);

        
        sid = addSubsection("Further reading", sb);
        w.addP(sb,
                """
                <a href="https://docs.python.org/3/tutorial/datastructures.html">
                Python documentation tutorial about data structures</a>.
                """);
        w.addDIVET(sb);
        return sb.toString();
    }
}
