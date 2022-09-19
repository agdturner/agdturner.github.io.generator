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
import io.github.agdturner.core.Environment;
import io.github.agdturner.course.Page;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * For Python Intro Course Python Page.
 *
 * @author Andy Turner
 */
public class Python extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Python(PythonIntroCourse c) {
        super("python", "Python", "Python", c);
    }
    
    @Override
    public void write() {
        writeH1();
        w.add("<p>"
                + addWikipediaReference("Python_(programming_language)",
                        "Python")
                + " is a popular and powerful programming language. The Python"
                + " interpreter and the extensive standard library are freely"
                + " available in source and binary form for all major platforms"
                + " from "
                + addWebReference(Environment.URL_PYTHON, "Python Website",
                        Environment.URL_PYTHON, "")
                + ", and may be freely distributed. The web site contains"
                + " distributions of and pointers to many free third party"
                + " Python modules, programs and tools, and additional"
                + " documentation.</p>");
        w.add("<p>Python underwent a major revision from Python 2 to Python 3"
                + " in around 2008. There were changes that were not backwards"
                + " compatible. As a result a lot of Python 2 code needed"
                + " refactoring in order to work in Python 3 environments."
                + " This somewhat divided the community at the time. Python 2"
                + " is no longer supported in that the Python developers are no"
                + " longer responding to issues reported against Python 2."
                + " On the 22nd of August 2022 Python 3.10.6 was released."
                + " With each main release of Python 3 there is a \"whatsnew\""
                + " Web page:"
                + "</p>");
        w.add("<ul>");
        addWebReference("https://docs.python.org/3/whatsnew",
                        "Python Documentation What's New", "", "");
        for (int i = 0; i < 11; i++) {
            w.add("<li>" + Web_ContentWriter.getLink(
                    "https://docs.python.org/3/whatsnew/3." + i + ".html",
                    "Whatsnew Python 3." + i) + "</li>");
        }
        w.add("</ul>");
        w.add("<p>On whatsnew Web pages, changes are marked against Python"
                + " Enhancement Proposals (PEPs). These are community proposed"
                + " and allow us to look ahead and see what might change in"
                + " subsequent versions of Python. PEPs have their own Web "
                + "site: "
                + addWebReference("https://peps.python.org/",
                        "Python Enhancement Proposal Website",
                        "https://peps.python.org/",
                        "")
                + "</p>");
        w.add("<p>It is important to know exactly which version of Python you"
                + " are using and what versions of any third party modules you"
                + " are using. This helps with reproducing results and"
                + " diagnosing issues.</p>");
        w.add("<p>Programming and programming language development are"
                + " community activities. It is normal to ask others for help"
                + " and to provide others with help and work collaboratively"
                + " to develop things. There are different types of forums for"
                + " asking and anwering questions and different types of"
                + " project that you might want to get involved with once you"
                + " have gained some experience. In this course, you are"
                + " discouraged from asking questions on any forums other than"
                + " our own. But, you are encouraged to search for and use the"
                + " posts others have made on forums you can access. These may"
                + " help you complete tasks and understand better, but be sure"
                + " to keep a track of what you use as it is expected that you"
                + " refer to these in your academic work. You might want to"
                + " create forum accounts so that you can up or down vote"
                + " posts, but until you complete this course please do not"
                + " make original posts asking for help or reply to posts to"
                + " help others without first liaising with your tutor. Please"
                + " ask your tutor for help if you get stuck. If you ask for"
                + " help by email, it is often a good idea to attach your code,"
                + " explain what you think should happen and describe what"
                + " happens instead.</p>");
        String python3DocsHome = Environment.URL_PYTHON_DOCS + "3/";
        String python3DocsTutorial = python3DocsHome + "tutorial/";
        w.add("<p>The "
                + Web_ContentWriter.getLink(python3DocsTutorial,
                        "getting started tutorial")
                + " linked from the "
                + addWebReference(Environment.URL_PYTHON, 
                        "Python Website", Environment.URL_PYTHON, "")
                + " is a good place to start learning Python. We will be"
                + " covering a lot of the same things in this course, but we"
                + " will be going about it in a more geographical way.</p>");
        w.add("<p>In Python instructions or commands are entered at a prompt"
                + " or passed in files to be interpretted. Commands entered at"
                + " a prompt are run one at a time. When program files are run,"
                + " typically multiple instructions are run. There is an order"
                + " in which instructions run. In some cases the program files"
                + " that are run contains new types of instructions. Sometimes"
                + " programming is also called coding. Let us get going now"
                + " with a bit of Python coding.</p>");
        w.add("</div>");
        w.add("<div>");
        w.add("<p>To follow the instructions below, you need to have Python"
                + " installed on your system. These instructions also assume"
                + " that you are using a Windows Operating System.</p>");
        w.add("<p>Open up a command window and enter:"
                + " \"python --version\"</p>");
        w.add("<p>This should output the version of Python your system is set"
                + " up to use. If Python is not on your Path, then you will get"
                + " an error message.</p>");
        w.add("<p>Enter the command: \"python\"</p>");
        w.add("<p>The prompt should change to look more like: \">>> \"</p>");
        w.add("<p>This is the Read-Eval-Print Loop (REPL) environment for"
                + " Python where user inputs are read and evaluated, and then"
                + " the results are returned to the user. We call this \"the"
                + " Python prompt\".");
        w.add("<p>Enter: \"2 + 3\"</p>");
        w.add("<p>You should see the result \"5\" printed.</p>");
        w.add("<p>You can use this Python REPL environment to do some"
                + " mathematical calculations.</p>");
        w.add("<p>The symbol \"*\" is the symbol for multiplication.</p>");
        w.add("<p>Try multiplying two numbers.</p>");
        w.add("<p>\"/\" is the division operator. \"**\" is a power operator."
                + " Have a little play.</p>");
        w.add("<p>Each of these operators can also be accessed via a function"
                + " in the \"operator\" module.</p>");
        w.add("<p>Enter: \"operator.add(2, 3)\"</p>");
        w.add("<p>You should get a \"NameError\" informing you that the"
                + " interpretter does not know about the module named"
                + " \"operator\"</p>");
        w.add("<p>We have to \"import\" it if we want to use it. Before we do"
                + " that, check what your Python environment does know about."
                + "</p>");
        w.add("<p>Enter: \"dir()\"</p>");
        w.add("<p>This runs (or calls) the \"dir\" function. You can tell it"
                + " is a function as after the name there is a start"
                + " parenthesis \"(\". The function call is completed by the"
                + " end parenthesis \")\". This function has no arguments -"
                + " things that are passed to the function - as there is"
                + " nothing between the start and end parentheses.</p>");
        w.add("<p>You should get a list printed out that looks like:"
                + " \"['__annotations__', '__builtins__', '__doc__',"
                + " '__loader__', '__name__', '__package__', '__spec__']\"</p>");
        w.add("<p>You can tell this is a list as it starts with \"[\" and ends"
                + " with \"]\" and the elements are separated with commas"
                + " (\",\").</p>");
        w.add("<p>Enter: \"import operator\"</p>");
        w.add("<p>This imports the \"operator\" module.</p>");
        w.add("<p>Enter: \"dir()\"</p>");
        w.add("<p>You should see the \"operator\" module in the list.</p>");
        w.add("<p>Enter: \"operator.add(2, 3)\"</p>");
        w.add("<p>You should see the result \"5\" printed.</p>");
        w.add("<p>Enter: \"dir(operator)\"</p>");
        w.add("<p>This lists all the functions in the \"operator\" module. It"
                + " is quite a long list and contains \"add\", the function"
                + " that we called to add the numbers 2 and 3. There are"
                + " numerous functions that have a name starting and ending"
                + " with \"__\". These are not supposed to be called directly,"
                + " but they can be called.</p>");
        w.add("<p>Enter: \"operator.__add__(2, 3)\"</p>");
        w.add("<p>Python does not have a way of exerting access control on"
                + " variables or functions, so it uses a naming convention to"
                + " indicate to users that the variable or function should not"
                + " be accessed from outside the module. Variables with names"
                + " that start with a single underscore (\"_\") or double"
                + " underscore \"__\" you generally should not be accessing or"
                + " using directly.</p>");
        w.add("<p>Enter: \"help(operator.add)\"</p>");
        w.add("<p>This prints out some information about how to use the"
                + " \"operator\" module \"add\" function.</p>");
        w.add("<p>Enter: \"help()\"</p>");
        w.add("<p>This enters the help system and the prompt changes to look"
                + " like \"help> \".</p>");
        w.add("<p>Read what is printed.</p>");
        w.add("<p>Enter: \"modules\"</p>");
        w.add("<p>Enter: \"operator\"</p>");
        w.add("<p>This is the help documentation for the operator module. It"
                + " is many lines long. Press and hold the <enter> key to get"
                + " the next lines of the help documentation and let go after a"
                + " few lines. Try pressing your <space bar> key to get the"
                + " next page of the help documentation. Usually you can keep"
                + " pressing your <space bar> key to scan through this help"
                + " documentation until you exit. You can also press your <q>"
                + " key to quit and return to the help system.</p>");
        w.add("<p>Enter: \"q\"</p>");
        w.add("<p>This should exit the help system and return you to the"
                + " Python prompt.</p>");
        w.add("<p>Call the \"quit\" function to quit the Python REPL i.e."
                + " Enter: \"quit()\"</p>");
        w.add("<p>This should return you to the normal command prompt.</p>");
//        w.add("<p></p>");
//        w.add("<p>Enter: \"\"</p>");
        w.add("</div>");
    }
}
