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
 * For Python Intro Course Functions Page.
 *
 * @author Andy Turner
 */
public class Functions extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public Functions(PythonIntroCodingCourse course) {
        super(course, "functions", "Functions", "Functions");
    }
    
    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        w.addPST(sb,
                """
                Functions are a key part of many programming languages. These
                are reusable code blocks that are called and which return. In
                calling the function typically parameters can be passed in. A
                function return may contain objects or values that can be
                assigned to variables and in returning
                """);
        sb.append(index.getReference("Python Built-in Functions", sid));
        sb.append(" are available as part of the ");
        sb.append(index.getReference("Python builtins", "builtins module",
                        sid));
        sb.append(" Functions from modules in the ");
        sb.append(references.getReference("Python 3 Documentation: Library",
                        "standard library"));
        sb.append(" are made available using ");
        sb.append(index.getReference("Python import", "import",
                        sid));
        w.addPET(sb, " statements.");
        w.addP(sb,
                """
                Python functions are defined in a code block that begins with a
                definition or 'function declaration', and is followed by a set
                of indented statements. The function declaration uses the
                keyword 'def' which is followed by the name of the function.
                After the function name, there are parenthesis which may be
                empty or may contain a tuple of 'parameters' also called
                'arguments' - names for things passed into the function. The
                function declaration ends with a colon ':'. The following gives
                the general form:
                """);
        addCodeBlock(sb,
                """
                def function_name(arg_0, arg_1):
                    # Function statements
                """);
        w.addP(sb,
                """
                A function may return one thing which can be a tuple of things.
                This is done with a return statement which starts with the
                keyword 'return' followed by the name of the thing returned. By
                default, functions invisibly return 'None' - a special object of
                type 'NoneType'.
                """);
        w.addP(sb,
                """
                Functions are effectively blocks of code that can be used or
                'called' repeatedly. Rather than repeat a block of code, it is
                typically better to define a function and call the function
                twice. The bigger the block of code turned into a function, the
                greater the gain is in terms of making the code easier to read,
                understand, maintain and use.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Parameters", sb);
        w.addP(sb,
                """
                Parameters or 'arguments' add flexibility and utility to
                functions. Arguments can be variables or functions. Variables
                that are primitive get copied. Variables that are non-primitive
                are shared. Passing in a function as an argument allows that
                function to be used within the function.
                """);
        w.addP(sb,
                """
                As with variable declarations, in Python there is no need to
                declare the type of a parameter passed to a function.
                """);

        sid = addSubsection("Positional Parameters", sb);
        w.addP(sb,
                """
                Positional parameters or positional arguments are given in
                order from left to right, so in the following 'add' function
                'num1' is the first argument and 'num2' is the second argument:
                """);
        addCodeBlock(sb,
                """
                def add(num1, num2):
                    return num1 + num2
                print(add(20,30)) # Prints 50
                """);
        w.addP(sb, "Default values can be specified as follows:");
        addCodeBlock(sb,
                """
                def add(num1 = 0, num2 = 0):
                    return num1 + num2
                print(add(3)) # Prints 3
                """);
        w.addP(sb,
                """
                As arguments are ordered left to right, in the example, 'num1'
                gets '3', and 'num2' gets nothing and so is set to the default
                value '0'.
                """);
        w.addP(sb,
                """
                In the absence of a default, an argument must be passed in.
                For example the following code:
                """);
        addCodeBlock(sb,
                """
                def add(num1 = 0, num2):
                    return num1 + num2
                print(add(3))
                """);
        w.addP(sb, "Results in:");
        w.addPRE(sb, 
                "SyntaxError: non-default argument follows default argument");
        w.addP(sb,
                """
                Because of this, arguments with defaults are declared after
                any undefaulted arguments in the function declaration.
                """);

        sid = addSubsection("Keyword Arguments (kwargs)", sb);
        w.addP(sb,
                """
                Arguments can also be named, these are called keyword arguments
                or 'kwargs'. Note that this use of the term keyword has nothing
                to do with the keywords that are special names for things that
                can't be used as identifiers.
                """);
        w.addP(sb,
                """
                Consider the following which uses kwargs in the function call to
                assign the parameter values:
                """);
        addCodeBlock(sb, 
                """
                def add(num1, num2):
                    return num1 + num2
                print(add(num2 = 30, num1 = 50))
                """);
        w.addP(sb,
                """
                Note that the order of the positional arguments is ignored:
                'num2' gets '30'; and, 'num1' gets '50'.
                """);
        w.addP(sb,
                """
                Having both positional arguments and kwargs is allowed, but
                kwargs are declared after (i.e. to the right of) positional
                arguments in the function declaration.
                """);

        sid = addSubsection("Flexibility using Tuples and Dictionaries", sb);
        w.addP(sb,
                """
                More positional arguments can be allowed using '*tuple_name',
                as in the following example:
                """);
        addCodeBlock(sb,
                """
                def add(*nums):
                    r = 0
                    for num in nums:
                        r += num
                    return r
                print(add(1,2,3,4,5,6,7)) # <-- Prints 28
                """);
        w.addP(sb,
                """
                The '*' used this way is known as the iterable (un)packing
                operator. If nothing is allocated, the tuple is empty.
                """);
        w.addP(sb,
                """
                The '*' can be used with lists or tuples to generate parameters:
                """);
        addCodeBlock(sb,
                """
                def add(*nums):
                    r = 0
                    for num in nums:
                        r += num
                    return r
                a = [1,2,3,4]
                print(add(*a)) # <-- Prints 10
                print(add(1,*a, 2)) # <-- Prints 13
                """);
        w.addP(sb,
                """
                The same can be done with dictionaries using '**dict_name'
                (where '**' is the dictionary (un)packing operator) - which will
                make a dictionary from unallocated kwargs. The following code:
                """);
        addCodeBlock(sb,
                """
                def f1(a, **details):
                    print(a)
                    print(details)

                f1(1, b=2, c=3)
                """);
        w.addP(sb, "Produces:");
        w.addPRE(sb,
                """
                1
                {'b': 2, 'c': 3}
                """);
        w.addP(sb,
                """
                The '**' dictionary operator can be used to generate kwargs.
                The following code:
                """);
        addCodeBlock(sb,
                """
                def f1(a, b, c):
                    print(a)
                    print(b)
                    print(c)

                d = {'b':2, 'c':3}
                f1(1,**d)
                """);
        w.addP(sb, "Produces:");
        w.addPRE(sb,
                """
                1
                2
                3
                """);
        w.addP(sb,
                """
                Similar to with standard arguments, '*tuple_name' arguments
                must come before '**dict_name arguments' (if both are used). And
                '*tuple_name' arguments must come after positional arguments.
                And '**dict_name' arguments must come after other kwargs. It is,
                therefore usual to place them after their associated variables
                or together at the end. The following code:
                """);
        addCodeBlock(sb,
                """
                def f1(a, b=2, *args, **kwargs):
                    print(a, b)
                    print(args)
                    print(kwargs)

                l = [10, 20, 30]
                d = {'c': 100, 'd': 200}

                f1(1, 3, *l, **d)
                """);
        w.addP(sb, "Produces:");
        w.addPRE(sb,
                """
                1 3
                (10, 20, 30)
                {'c': 100, 'd': 200}
                """);
        w.addP(sb,
                """
                Note that the kwargs packed into the dictionary cannot have
                name collisions with the other arguments. So, the following:
                """);
        addCodeBlock(sb,
                """
                def f1(a, b=2, *args, **kwargs):
                    print(a, b)
                    print(args)
                    print(kwargs)

                l = [10, 20, 30]
                d = {'c': 100, 'd': 200, 'b':300}

                f1(1, 3, *l, **d)
                """);
        w.addP(sb, "Results in:");
        w.addPRE(sb, "TypeError: f1() got multiple values for argument 'b'");
        w.addP(sb,
                """
                For details on unpacking operators see:
                <a href="https://peps.python.org/pep-0448/">PEP-0448</a>
                """);
        w.addP(sb,
                """
                Another useful summary reference is the
                <a href="https://docs.python.org/3/faq/programming.html#how-do-i-write-a-function-with-output-parameters-call-by-reference">
                Python documentation: Outline of how to get output from a function documentation</a>
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Scope", sb);
        w.addP(sb,
                """
                The scope of a variable is from where in the code it can be
                accessed. Scope was introduced in
                <a href="../Variables/index.html#3">Variables Section 3</a>,
                where there is an explanation of changing a variable scope using
                the 'global' keyword. To recap, consider the following code:
                """);
        addCodeBlock(sb,
                """
                a = 10
                def f1():
                    print(a) # Prints 10;
                print(a) # Prints 10.
                f1()
                print(a) # Prints 10.
                """);
        w.addP(sb,
                """
                The variable 'a' is declared and initialised prior to any call
                to f1() and the variable can be accessed from within the
                function f1(). However, assigning a local variable within a
                function that has the same name as a variable already accessible
                from the function creates a new variable. So, to force a local
                assignment to a global variable, use the global keyword as
                follows:
                """);
        addCodeBlock(sb,
                """
                a = 10
                def f1():
                    global a
                    a = 20
                    print(a) # Prints 20.
                print(a) # Prints 10.
                f1()
                print(a) # Prints 20 as the function changes the global a.
                """);
        w.addP(sb,
                """
                With nested functions there are situations where non local and
                non global variables are wanted in the inner function such that
                the outer function and inner function share the same variable
                and this does not change any variable with the same name in the
                broader scope from where the function is called. To do this the
                'nonlocal' keyword can be used, as in the following example:
                """);
        addCodeBlock(sb, 
                """
                a = 1
                def f1():
                    a = 2
                    def f2():
                        nonlocal a
                        a = 3
                        print(a) # Prints 3.
                    f2()
                    print (a) # Prints 3.
                f1()
                print(a) # Prints 1.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Function Complexity", sb);
        w.addP(sb,
                """
                As shown above, functions can be nested. In the example above,
                'f2' is inside 'f1', so: f2 is an 'inner function'; and, f2 is
                an 'outer function'. Nesting functions thus hides inner
                functions - they cannot be called directly from outside the
                outer function. This is a way to make things appear simple.
                """);
        w.addP(sb,
                """
                Inner functions can be used to help unpack arguments and deal
                with different types of argument passed to the outer function in
                a function call.
                """);
        w.addP(sb,
                """
                As mentioned, Python allows for functions to be passed into
                functions as arguments. Functions can also be returned from
                functions. An inner function can be returned in the output from
                an outer function.
                """);
        w.addP(sb,
                """
                Functions are key to a lot of programming. Supporting nested
                functions, being able to pass functions into other functions as
                parameters, and returning functions from functions are useful
                features of Python.
                """);
        w.addP(sb,
                """
                This section considers a number of other features of functions.
                The detail might be better understood after gaining practise in
                defining and using functions that simply have variables as
                parameter arguments and return variables, perhaps packed in a
                tuple.
                """);

        sid = addSubsection("Decorators", sb);
        w.addP(sb,
                """
                Decorators are functions that aare applied to the outputs of
                other functions using the '@' symbol as part of the
                function definition (see
                <a href="https://docs.python.org/3/reference/compound_stmts.html#function-definitions">
                function definitions</a>). There can be multiple decorators
                which would work in turn passing the output back until all the
                decorators have been applied. A decorator function can be used for
                reporting the time it takes to run a function:
                """);
        addCodeBlock(sb,
                """
                import random
                import time

                def timer(func):
                    \"""
                    Get the run time of the decorated function.

                    Parameters
                    ----------
                    func : The function to be timed.
                        DESCRIPTION.

                    Returns
                    -------
                    Tuple
                        The run time then func output.
                    \"""
                    def inner_timer(*args, **kwargs):
                        start = time.perf_counter()
                        value = func(*args, **kwargs)
                        run_time = time.perf_counter() - start
                        return run_time, value
                    return inner_timer

                @timer
                def create_agents(n_agents):
                    \"""
                    A function to create a list of agents. The decorator will print the time
                    it takes to run this function.

                    Parameters
                    ----------
                    n_agents : Integer
                        The number of agents to create.

                    Returns
                    -------
                    agents : List
                        A list of the created agents.

                    \"""
                    agents = []
                    for i in range(n_agents):
                        agents.append([random.randint(0, 99), random.randint(0, 99)])
                    return agents

                # Create agents
                n_agents = 1000000
                run_time, agents = create_agents(n_agents)
                print(run_time, "seconds to create", n_agents, "agents.")
                """);

        sid = addSubsection("Lambdas", sb);
        w.addP(sb, "");
        sb.append(index.getReference("Python lambda", "Lambda expressions",
                        sid));
        w.addP(sb,
                """
                are used to create anonymous functions. They can have any
                number of arguments, but the expression is made up of a single
                non-compound statement. Consider the following example:
                """);
        addCodeBlock(sb,
                """
                # A lambda to return the result of dividing a by b.
                x = lambda a, b : a / b

                print(x(1, 2)) # <-- Prints 0.5.
                """);
        w.addP(sb,
                """
                Note that: the lambda function is defined with the 'lambda'
                keyword, the parameters are separated with commas, and a colon
                is used to separate the parameters from the expression - the
                result of which is passed back.
                """);

        sid = addSubsection("Callbacks", sb);
        w.addP(sb,
                """
                A Python callback is a subroutine function which is passed as
                an argument to be executed at some point in the future. Consider
                the following example where the callbacks are to the 'add' and
                'multiply' functions from the caller function (that itself is
                called in the lines that print out the results returned from the
                function calls):
                """);
        addCodeBlock(sb, 
                """
                def add(x):
                    \"""
                    Calculate and return all the elements of x added together.

                    Parameters
                    ----------
                    x : Tuple
                        The things to add.

                    Returns
                    -------
                    r : Things added.
                        All the things in x added together.

                    \"""
                    r = 0
                    for y in x:
                        r = r + y
                    return r

                def multiply(x):
                    \"""
                    Calculate and return all the elements of x multplied together.

                    Parameters
                    ----------
                    x : Tuple
                        The things to multiply.

                    Returns
                    -------
                    r : Things multiplied.
                        All the things in x multiplied together.

                    \"""
                    r = 0
                    for y in x:
                        r = r + y
                    return r

                def caller(func, args):
                    \"""
                    A function that calls the function func passing in the
                    arguments args.

                    Parameters
                    ----------
                    func : Function
                        The (name of the) function to be called.
                    args : Tuple
                        The arguments to be passed to func
                    Returns
                    -------
                    Whatever is returned from func(args)
                    \"""
                    return func(args)

                print(caller(add, (1, 2, 3))) # Prints 6
                print(caller(multiply, (1, 2, 3, 4, 5, 6))) # Prints 21
                """);
        w.addP(sb,
                """
                The following is another example which uses a callback to sort
                items in a list:
                """);
        addCodeBlock(sb, 
                """
                class Mark:
                    def __init__(self, name, grade):
                        self.name = name
                        self.grade = grade

                    def __str__(self):
                        return "name=" + self.name + " grade=" + str(self.grade)

                def getGrade(mark):
                    return mark.grade

                marks = [Mark("name1", 50), Mark("name2", 70), Mark("name3", 60)]
                print("Unordered marks:")
                for mark in marks:
                    print(mark)

                # Sort marks using a callback
                marks.sort(key=getGrade)

                print("Ordered marks:")
                for mark in marks:
                    print(mark)
                """);
        w.addP(sb,
                """
                Often a callback is used in event based processing. It allows
                other tasks to be done whilst waiting for an event to happen.
                """);

        sid = addSubsection("Partial", sb);
        w.addP(sb,
                """
                Functools <a href="https://docs.python.org/3/library/functools.html?highlight=partial#functools.partial">
                partial</a> allows for arguments of a function to be set
                partially. For example:
                """);
        addCodeBlock(sb,
                """
                from functools import partial

                def f(x, y, z):
                    return x + y + z

                # A partial function that calls f with x = 1 and y = 2.
                pf = partial(f, 1, 2)

                print(pf(3)) # Prints 6
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Style and Documenting Functions", sb);

        sid = addSubsection("Style", sb);
        w.addP(sb,
                """
                Good Python style is set out in
                <a href="https://www.python.org/dev/peps/pep-0008/">PEP-0008</a>
                which is worth finding time to read.
                """);
        w.addP(sb, "The main style elements are:");
        w.addULST(sb);
        w.addLI(sb, "Use 4 spaces per indent");
        w.addLI(sb, 
                """
                Insert blank lines before function definitions and to separate
                logical code units.
                """);
        w.addLI(sb,
                """
                function_names and variable_names should be lower case with
                underscores separating words (snake case) as shown.
                """);
        w.addLI(sb, 
                """
                ClassNames should be mostly lower case, but with capitalised
                first letters of name parts (camel case) as shown.
                """);
        w.addLI(sb, "CONSTANT_NAMES should be upper case and snake case.");
        w.addLI(sb, "Keep lines to 79 characters or less.");
        w.addLI(sb, "Add spaces after commas");
        w.addLI(sb, "Indent comments to the level of the code referred to.");
        w.addULET(sb);

        sid = addSubsection("Documenting Functions", sb);
        w.addPST(sb, "");
        sb.append(index.getReference("Python docstring", "Docstrings", sid));
        w.addPET(sb, 
                """
                 are automatically extracted to describe code. They are added in
                triple-double quote enclosed comments after, class or function
                declarations. For functions these should ideally have a short
                description of what the function does which is typically written
                like a command to the function more than as a description of
                what the function does. It should also list what the parameters
                are and what if anything is returned from the function. For
                example:
                """);
        addCodeBlock(sb,
                """
                def add (num1, num2):
                    \"""
                    Add two numbers.

                    Keyword arguments:
                    num1 -- an integer or double number (no default)
                    num2 -- an integer or double number (no default)

                    Returns:
                    The sum of the numbers.
                    \"""
                    return num1 + num2
                """);
        w.addP(sb, 
                """
                For details on docstrings see
                <a href="https://www.python.org/dev/peps/pep-0257/">PEP-0257</a>
                """);
        w.addP(sb, 
                """
                The help system will display docstrings. So, where "x" is a
                function or module the following will display the docstring:
                """);
        w.addPRE(sb, "help(x)");
        w.addP(sb, "The docstring can also be printed using:");
        w.addPRE(sb, "print(x.__doc__)");
        w.addDIVET(sb);
        sb.append("\n");
        
        sid = addSection("Next", sb);
        w.addP(sb,
                """
                Refactoring the Agent Based Model code to use functions...
                """);
        w.addDIVET(sb);
        return sb.toString();
    }
}
