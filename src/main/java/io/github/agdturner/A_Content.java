/*
 * Copyright 2022 Centre for Computational Geography.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.agdturner;

import io.github.agdturner.core.A_Strings;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.ac.leeds.ccg.generic.lang.Generic_String;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Java for generating some https://agdturner.github.io Website Content.
 *
 * @author Andy Turner
 */
public class A_Content {

    /**
     * Create a new instance.
     */
    public A_Content() {
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        A_Content hw = new A_Content();
        String domain = "agdturner.github.io";
        Path dir = Paths.get("C:", "Users", "agdtu", "src", "agdt", domain);
        String gURL = "http://github.com/";
        String gaURL = gURL + "agdturner/";
        ArrayList<Path> subDirectories = new ArrayList<>();
        Path dirCourse = Paths.get(dir.toString(), "courses", "python");
        subDirectories.add(dirCourse);
        try {
            // Home Page index
            hw.writeIndex(domain, dir, gaURL, subDirectories);
            hw.writeIntroductionToPythonCourse(domain, dir, dirCourse);
        } catch (IOException ex) {
            Logger.getLogger(A_Content.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * For initial write of Web content.
     *
     * @param domain The domain name as a String.
     * @param dir The directory in which the content will be written.
     * @param subdirs The subdirectories in the index.
     * @throws IOException If thrown.
     */
    public void writeIndex(String domain, Path dir, String gaURL, ArrayList<Path> subdirs)
            throws IOException {
        String name = "Home";
        String filename = "index";
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }
        Web_ContentWriter w = new Web_ContentWriter();
        w.add("<div>");
        w.add("<h1><img src=\"./images/a.turner.png\" alt=\"Andy Turner profile "
                + "picture head and shoulders\" /></h1>");
        w.add("<p>I am a research officer based in the School of Geography at the "
                + "University of Leeds. Amongst other things, I teach students "
                + "how to program and use R and Python for processing "
                + "geographical data and modelling. I mostly program using "
                + "Java, Maven and Netbeans and am interested in developing "
                + "dynamic spatial models and processing geographical data to "
                + "help mitigate risk and make the world a safer, happier and "
                + "healthier place for people and wildlife.</p>");
        String gadURL = gaURL + domain;
        String gadgURL = gadURL + ".generator";
        w.add("<p>These Web pages are hosted on GitHub in the repository: "
                + w.getLink(gadURL, gadURL)
                + ". They have been generated using some Java code in the "
                + "repository: "
                + w.getLink(gadgURL, gadgURL)
                + ". Here is a link to my Github profile: "
                + w.getLink(gaURL, gaURL)
                + ". Below is a list of links to web site content.</p>");
        // Links
        int dirnc = dir.getNameCount();
        Iterator<Path> ite = subdirs.iterator();
        while (ite.hasNext()) {
            Path subdir = ite.next();
            int subdirnc = subdir.getNameCount();
            String relpath = "";
            //int depth = subdirnc - dirnc;
            for (int i = dirnc; i < subdirnc; i++) {
                w.add("<ul>");
                w.add("<li>");
                String subdirname = subdir.getName(i).toString();
                relpath = relpath.concat(subdirname + "/");
                if (i == subdirnc - 1) {
                    w.add(w.getLink(relpath,
                            Generic_String.getCapitalFirstLetter(subdirname)));
                } else {
                    w.add(Generic_String.getCapitalFirstLetter(subdirname));
                }
            }
            for (int i = dirnc; i < subdirnc; i++) {
                w.add("</li>");
                w.add("</ul>");
            }
        }
        w.add(Web_ContentWriter.DIVET);
        String title = domain + A_Strings.symbol_space + name
                + A_Strings.symbol_space + "Page";
        w.writeHTML(dir, filename, title);
    }

    /**
     * Write the Introduction To Python Course HTML.
     *
     * @param domain The domain name as a String.
     * @param dirCourse The course root directory.
     * @throws IOException If encountered.
     */
    public void writeIntroductionToPythonCourse(String domain, Path dir,
            Path dirCourse)
            throws IOException {
        CourseContent cc = writeIntroductionToPythonCourseIndex(domain, dirCourse);
        Iterator<String> ite = cc.names.iterator();
        while (ite.hasNext()) {
            String name = ite.next();
            cc.lookupPath.put(name, getDir(dirCourse, name));
        }
        int c = 0;
        // Programming
        writeIntroductionToPythonCourseProgramming(dirCourse, cc, c);
        // Python
        c++;
        writeIntroductionToPythonCoursePython(dirCourse, cc, c);
    }

    /**
     *
     * @param dir The directory in which to create a directory.
     * @param name The name of the directory to create.
     * @return The Path to the directory created.
     * @throws IOException If encountered.
     */
    public Path getDir(Path dir, String name) throws IOException {
        Path r = Paths.get(dir.toString(), name);
        if (!Files.exists(r)) {
            Files.createDirectories(r);
        }
        return r;
    }

    /**
     * A POJO class for holding course content collections.
     */
    public class CourseContent {

        public ArrayList<String> names;
        public HashMap<String, String> lookup;
        public HashMap<String, Path> lookupPath;
        public HashMap<String, String> lookupLink;

        public CourseContent() {
            names = new ArrayList<>();
            lookup = new HashMap<>();
            lookupPath = new HashMap<>();
            lookupLink = new HashMap<>();
        }
    }

    /**
     * For initial write of Web content.
     *
     * @param domain The domain name as a String.
     * @param dirRoot The root directory in the domain.
     * @param dirCourse The course base directory.
     * @throws IOException If thrown.
     * @return A map of directory name to name - a lookup for content.
     */
    public CourseContent writeIntroductionToPythonCourseIndex(String domain,
            Path dirCourse) throws IOException {
        String name = "Introduction to Programming and Python";
        String filename = "index";
        if (!Files.exists(dirCourse)) {
            Files.createDirectories(dirCourse);
        }
        Web_ContentWriter w = new Web_ContentWriter();
        writeH1(w, name);
        w.add("<p>These learning resources were developed for teaching a "
                + "course at the University of Leeds where typically a tutor "
                + "was available to help learners.</p>");
        w.add("<h2>Course Outline</H2>");
        // Aims and Objectives
        w.add("<h3>Aims and Objectives</H3>");
        w.add("<ul>");
        w.add("<li>Understand key computer programming concepts including:");
        w.add("<ul>");
        w.add("<li>Variables</li>");
        w.add("<li>Control flow</li>");
        w.add("<li>Loops</li>");
        w.add("<li>Conditional statements</li>");
        w.add("<li>Classes, functions/methods</li>");
        w.add("<li>Object Orientated Programming</li>");
        w.add("</ul></li>");
        w.add("<li>Use Python to:");
        w.add("<ul>");
        w.add("<li>Read data from files and from the Web</li>");
        w.add("<li>Write data to files</li>");
        w.add("<li>Handle coordinates in lists</li>");
        w.add("<li>Display spatial data</li>");
        w.add("<li>Process raster data</li>");
        w.add("<li>Develop and visualise a dynamic spatial simulation</li>");
        w.add("</ul></li>");
        w.add("<li>Practice:");
        w.add("<ul>");
        w.add("<li>Problem solving</li>");
        w.add("<li>Computational thinking</li>");
        w.add("<li>Object Orientated Programming</li>");
        w.add("</ul></li>");
        w.add("<li>Understand generic programming tasks and how to go about "
                + "these in Python including:");
        w.add("<ul>");
        w.add("<li>Testing</li>");
        w.add("<li>Documenting</li>");
        w.add("<li>Sharing</li>");
        w.add("</ul></li>");
        w.add("<li>Familiarisation with:");
        w.add("<ul>");
        w.add("<li>Python language development</li>");
        w.add("<li>Python limitations</li>");
        w.add("<li>Jupyter Notebooks</li>");
        w.add("<li>Version control</li>");
        w.add("<li>GitHub</li>");
        w.add("</ul></li>");
        w.add("</ul>");
        // The learning journey
        w.add("<h3>The Learning Journey</h3>");
        w.add("<ul>");
        w.add("<li>Take time to develop your understanding and practise your "
                + "skills.</li>");
        w.add("<li>There is a lot to learn especially if you are new to "
                + "programming.</li>");
        w.add("<li>Practise is essential.</li>");
        w.add("<li>Repeat reading and repeating tasks is highly recommended."
                + "</li>");
        w.add("<li>Try to learn new things when you are fresh and remember to "
                + "take breaks.</li>");
        w.add("<li>Talk to others without disturbing them. Work together if "
                + "you like.</li>");
        w.add("<li>Ask your tutor for help or clarification in class or via "
                + "email.</li>");
        w.add("<li>Test your understanding by testing that your code does what "
                + "you expect it to do.</li>");
        w.add("<li>Be experimental.</li>");
        w.add("<li>Learn to interpret error messages.</li>");
        w.add("</ul></li>");
        // Assignments and Assessments
        w.add("<h3>Assignments and Assessments</h3>");
        w.add("<p>There are two assignments that are assessed:</p>");
        w.add("<ul>");
        w.add("<li>A portfolio from the practical tasks worth 30%.</li>");
        w.add("<li>An independent project worth 70%.</li>");
        w.add("</ul>");
        // Practicals
        w.add("<h3>Main Sections</h3>");
        w.add("<p>The sections names starting \"ABM\" are practicals that "
                + "develop an Agent Based Model. It is a simplistic model "
                + "representing animals moving about in an environment, "
                + "interacting with each other and the environment. (There is "
                + "much that can be done to enhance the model and make it more "
                + "realistic.)</p>");
        w.add("<nav>");
        w.add("<ol>");
        CourseContent cc = new CourseContent();
        String s;
        String sname;
        // 1.
        s = "programming";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        // 2.
        s = "python";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        // 3.
        s = "github";
        sname = "GitHub";
        addPage(w, s, sname, cc);
        // 4.
        s = "variables";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        // 5.
        int abmi = 1;
        addABMPage(w, abmi, cc);
        // 6.
        s = "containers";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        // 7.
        s = "branching";
        sname = "Branching and Loops";
        addPage(w, s, sname, cc);
        // 8.
        abmi++;
        addABMPage(w, abmi, cc);
        // 9.
        s = "functions";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        // 10.
        abmi++;
        addABMPage(w, abmi, cc);
        // 11.
        s = "classes";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        // 12.
        abmi++;
        addABMPage(w, abmi, cc);
        // 13.
        s = "io";
        sname = "Input/Output";
        addPage(w, s, sname, cc);
        // 14.
        abmi++;
        addABMPage(w, abmi, cc);
        // 15.
        s = "modules";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        // 16.
        abmi++;
        addABMPage(w, abmi, cc);
        // 17.
        s = "exceptions";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        // 18.
        abmi++;
        addABMPage(w, abmi, cc);
        // 19.
        s = "gui";
        sname = "GUI";
        addPage(w, s, sname, cc);
        // 20.
        s = "web";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        // 21.
        abmi++;
        addABMPage(w, abmi, cc);
        w.add("</ol>");
        w.add("</nav>");
        w.add("</div>");
        String title = domain + A_Strings.symbol_space + name
                + A_Strings.symbol_space + "Page";
        w.writeHTML(dirCourse, filename, title);
        return cc;
    }

    void addPage(Web_ContentWriter w, String s, String linkName, CourseContent cc) {
        cc.names.add(s);
        cc.lookup.put(s, linkName);
        w.add("<li>" + w.getLink(s, linkName) + "</li>");
        cc.lookupLink.put(s, "../" + s);
    }

    void addABMPage(Web_ContentWriter w, int index, CourseContent cc) {
        addPage(w, "abm" + index, "ABM " + index, cc);
    }

    /**
     * Start the main div and write the title of the page in h1 tags.
     *
     * @param w The Web_ContentWriter.
     * @param name The title of the page.
     */
    void writeH1(Web_ContentWriter w, String name) {
        w.add("<div>");
        w.add("<h1>" + name + "</h1>");
    }

    /**
     * For initial write of Web content.
     *
     * @param domain The domain name as a String.
     * @param dir0 The root directory for the course.
     * @param dir1 The directory for this content.
     * @throws IOException If thrown.
     */
    public void writeIntroductionToPythonCourseProgramming(Path dirCourse,
            CourseContent cc, int c) throws IOException {
        String code = cc.names.get(c);
        String name = cc.lookup.get(code);
        Web_ContentWriter w = new Web_ContentWriter();
        writeH1(w, name);
        String cp = w.getLink(
                "https://en.wikipedia.org/wiki/Computer_programming",
                "Computer programming");
        w.add("<p> " + cp + " (programming, or coding) is about instructing a "
                + "computer to carry out a set of tasks. Typically, the tasks "
                + "involve data that are transferred, processed and output in "
                + "visual and audio forms.</p>");
        w.add("<p>The first computers were human calculators. These days most "
                + "computers are electrical machines with circuits. Desktop "
                + "machines typically have a keyboard for user inputs, process "
                + "binary data stored in a file system and have a graphical "
                + "display. Machines are typically networked and can "
                + "communicate with other similar machines on the "
                + w.getLink("https://en.wikipedia.org/wiki/Internet",
                        "Internet") + ".</p>");
        w.add("<p>Programming can be done visually by arranging pre-built "
                + "components that fit or connect together to form programs or "
                + "workflows that can then be run to produce output. However, "
                + "this course is not about visual programming, it is about "
                + "programming using text commands written in a computer "
                + "programming language and either entered at a prompt one "
                + "after another or passed to an interpretter in a file or a "
                + "set of files. (A file is an ordered collection of data that "
                + "is registered with the computer operating system and can be "
                + "persistently stored (made so that it is available in "
                + "subsequent computer sessions).)</p>");
        w.add("<p>There are a wide variety of computer programming languages "
                + "each defined by a specific syntax (rules). Like natural "
                + "languages, computer languages can share a lot in common and "
                + "can look completely different. These learning resources "
                + "focus on Python and will mention some similarities and "
                + "differences that are useful to be aware of.</p>");
        w.add("<p>The smallest amount of binary data is called a bit - one or "
                + "the other state. Perhaps it is easiest to think of these "
                + "states as being a zero or a one.</p>");
        w.add("<p>Typically computers work with fixed size collections of bits "
                + "called bytes. The more more bits in a byte, the more "
                + "different unique combinations there are. With each added "
                + "bit there is a power of two more combinations. With 2 bits "
                + "there are 4 possible combinations of zeros and ones (00, "
                + "01, 10, 11). With 3 bits there are 8 combinations (000, "
                + "001, 010, 100, 011, 101, 110, 111). With 4, 16... With 8, "
                + "256...</p>");
        w.add("<p>Many encodings use 8 bits in a byte (as this allows for all "
                + "English letters in both lower and upper case, every numeric "
                + "digit 0 to 9, and 192 mathematical and other symbols to be "
                + "uniquely represented. To represent individual numbers, "
                + "computers typically use more bits depending on the type of "
                + "number. We will come back to numerical representations and "
                + "calculations later.</p>");
        w.add("<p>The lowest level languages are called machine languages and "
                + "these tell the computer how to read instructions and "
                + "transfer data. Higher level languages like Python have "
                + "interpretters that translate more human readable code into "
                + "the machine language.</p>");
        w.add("<p>If you are new to computer programming, then you will be "
                + "learning lots of new terms and concepts as well as learning "
                + "the syntax of Python in this course. There is a lot to take "
                + "on board and you will be most ready to learn these new "
                + "things when you are well rested and able to concentrate. "
                + "You are strongly encouraged to take breaks when you are "
                + "learning and allow time for the concepts and new "
                + "terminology to sink in. Taking breaks will almost certainly "
                + "help you to learn faster on the whole as you tap you "
                + "subconscious. Learning should be a joy, but it is not so "
                + "much fun if you are not making progress which can happen if "
                + "you try to work when you are tired. Learning to program "
                + "requires practice and will inevitable involve making lots "
                + "of mistakes - a bit like learning to play a musical "
                + "instrument. Most learning computer programming learn best "
                + "by doing practical exercises and reusing the code they have "
                + "written.</p>");
        w.add("<p>There is typically more to learn with the first computer "
                + "programming language you learn. Once you can use one, it is "
                + "much easier to learn another.</p>");
        w.add("</div>");
        // Add navigation
        addNav(w, dirCourse, cc, c);
        // Write page
        w.writeHTML(cc.lookupPath.get(code), "index", name + " Page");
    }

    /**
     * Adds navigation section.
     *
     * @param w The Web_ContentWriter.
     * @param dirCourse The course root directory.
     * @param cc The CourseContent.
     * @param c The index number of the page in the course content.
     */
    void addNav(Web_ContentWriter w, Path dirCourse, CourseContent cc, int c) {
        w.add("<div>");
        w.add("<nav>");
        w.add(w.getLink("../index.html", "Home"));
        if (c > 0) {
            String s = cc.names.get(c - 1);
            //Path p = Paths.get(cc.lookupPath.get(s).toString(), "index.html");
            w.add(w.getLink(cc.lookupLink.get(s), "Prev: " + cc.lookup.get(s)));
            //w.add(w.getLink(p, "Prev: " + cc.lookup.get(s)));
        }
        if (c < cc.names.size() - 1) {
            String s = cc.names.get(c + 1);
            //Path p = Paths.get(cc.lookupPath.get(s).toString(), "index.html");
            w.add(w.getLink(cc.lookupLink.get(s), "Next: " + cc.lookup.get(s)));
            //w.add(w.getLink(p, "Next: " + cc.lookup.get(s)));
        }
        w.add("</nav>");
        w.add("</div>");
    }

    /**
     * For initial write of Web content.
     *
     * @param domain The domain name as a String.
     * @param dir1 The Introduction To Python Course directory.
     * @param dir2 The "python" directory in dir1.
     * @param previous The previous directory.
     * @param next The next directory.
     * @throws IOException If thrown.
     */
    public void writeIntroductionToPythonCoursePython(Path dirCourse,
            CourseContent cc, int c)
            throws IOException {
        String code = cc.names.get(c);
        String name = cc.lookup.get(code);
        Web_ContentWriter w = new Web_ContentWriter();
        w.add("<div>");
        w.add("<h1>" + name + "</h1>");
        String pythonWikipedia = w.getLink(
                "https://en.wikipedia.org/wiki/Python_(programming_language)",
                "Python");
        String pythonHome = w.getLink("https://www.python.org/",
                "Python web site");
        w.add("<p>" + pythonWikipedia + " is a popular and powerful "
                + "programming language. The Python interpreter and the "
                + "extensive standard library are freely available in source "
                + "and binary form for all major platforms from " + pythonHome
                + ", and may be freely distributed. The web site contains "
                + "distributions of and pointers to many free third party "
                + "Python modules, programs and tools, and additional "
                + "documentation.</p>");
        w.add("<p>Python underwent a major revision from Python 2 to Python 3 "
                + "in around 2008. There were changes that were not backwards "
                + "compatible. As a result a lot of Python 2 code needed "
                + "refactoring in order to work in Python 3 environments. "
                + "This somewhat divided the community at the time. Python 2 "
                + "is no longer supported in that the Python developers are no "
                + "longer responding to issues reported against Python 2. "
                + "On the 22nd of August 2022 Python 3.10.6 was released. "
                + "With each main release of Python 3 there is a \"whatsnew\" "
                + "Web page:"
                + "</p>");
        w.add("<ul>");
        for (int i = 0; i < 11; i++) {
            w.add("<li>" + w.getLink(
                    "https://docs.python.org/3/whatsnew/3." + i + ".html",
                    "Whatsnew Python 3." + i) + "</li>");
        }
        w.add("</ul>");
        w.add("<p>On whatsnew Web pages, changes are marked against Python "
                + "Enhancement Proposals (PEPs). These are community proposed "
                + "and allow us to look ahead and see what might change in "
                + "subsequent versions of Python. PEPs have their own Web site:"
                + w.getLink("https://peps.python.org/",
                        "https://peps.python.org/")
                + "</p>");
        w.add("<p>It is important to know exactly which version of Python you "
                + "are using and what versions of any third party modules you "
                + "are using. This helps with reproducing results and "
                + "diagnosing issues.</p>");
        w.add("<p>Programming and programming language development are "
                + "community activities. It is normal to ask others for help "
                + "and to provide others with help and work collaboratively "
                + "to develop things. There are different types of forums for "
                + "asking and anwering questions and different types of "
                + "project that you might want to get involved with once you "
                + "have gained some experience. In this course, you are "
                + "discouraged from asking questions on any forums other than "
                + "our own. But, you are encouraged to search for and use the "
                + "posts others have made on forums you can access. These may "
                + "help you complete tasks and understand better, but be sure "
                + "to keep a track of what you use as it is expected that you "
                + "refer to these in your academic work. You might want to "
                + "create forum accounts so that you can up or down vote "
                + "posts, but until you complete this course please do not "
                + "make original posts asking for help or reply to posts to "
                + "help others without first liaising with your tutor. Please "
                + "ask your tutor for help if you get stuck. If you ask for "
                + "help by email, it is often a good idea to attach your code, "
                + "explain what you think should happen and describe what "
                + "happens instead.</p>");
        String python3DocsHome = "https://docs.python.org/3/";
        String python3DocsTutorial = python3DocsHome + "tutorial/";
        w.add("<p>The "
                + w.getLink(python3DocsTutorial, "getting started tutorial")
                + "linked from the " + pythonHome + " is a good place to start "
                + "learning Python. We will be covering a lot of the same "
                + "things in this course, but we will be going about it "
                + "in a more geographical way.</p>");
        w.add("<p>In Python instructions or commands are entered at a prompt "
                + "or passed in files to be interpretted. Commands entered at "
                + "a prompt are run one at a time. When program files are run, "
                + "typically multiple instructions are run. There is an order "
                + "in which instructions run. In some cases the program files "
                + "that are run contains new types of instructions. Sometimes "
                + "programming is also called coding. Let us get going now "
                + "with a bit of Python coding.</p>");
        w.add("</div>");
        w.add("<div>");
        w.add("<p>To follow the instructions below, you need to have Python "
                + "installed on your system. These instructions also assume "
                + "that you are using a Windows Operating System.</p>");
        w.add("<p>Open up a command window and enter: "
                + "\"python --version\"</p>");
        w.add("<p>This should output the version of Python your system is set "
                + "up to use. If Python is not on your Path, then you will get "
                + "an error message.</p>");
        w.add("<p>Enter the command: \"python\"</p>");
        w.add("<p>The prompt should change to look more like: \">>> \"</p>");
        w.add("<p>This is the Read-Eval-Print Loop (REPL) environment for "
                + "Python where user inputs are read and evaluated, and then "
                + "the results are returned to the user. We call this \"the "
                + "Python prompt\".");
        w.add("<p>Enter: \"2 + 3\"</p>");
        w.add("<p>You should see the result \"5\" printed.</p>");
        w.add("<p>You can use this Python REPL environment to do some "
                + "mathematical calculations.</p>");
        w.add("<p>The symbol \"*\" is the symbol for multiplication.</p>");
        w.add("<p>Try multiplying two numbers.</p>");
        w.add("<p>\"/\" is the division operator. \"**\" is a power operator."
                + "Have a little play.</p>");
        w.add("<p>Each of these operators can also be accessed via a function "
                + "in the \"operator\" module.</p>");
        w.add("<p>Enter: \"operator.add(2, 3)\"</p>");
        w.add("<p>You should get a \"NameError\" informing you that the "
                + "interpretter does not know about the module named "
                + "\"operator\"</p>");
        w.add("<p>We have to \"import\" it if we want to use it. Before we do "
                + "that, check what your Python environment does know about."
                + "</p>");
        w.add("<p>Enter: \"dir()\"</p>");
        w.add("<p>This runs (or calls) the \"dir\" function. You can tell it "
                + "is a function as after the name there is a start "
                + "parenthesis \"(\". The function call is completed by the "
                + "end parenthesis \")\". This function has no arguments - "
                + "things that are passed to the function - as there is "
                + "nothing between the start and end parentheses.</p>");
        w.add("<p>You should get a list printed out that looks like:"
                + "\"['__annotations__', '__builtins__', '__doc__', "
                + "'__loader__', '__name__', '__package__', '__spec__']\"</p>");
        w.add("<p>You can tell this is a list as it starts with \"[\" and ends "
                + "with \"]\" and the elements are separated with commas "
                + "(\",\").</p>");
        w.add("<p>Enter: \"import operator\"</p>");
        w.add("<p>This imports the \"operator\" module.</p>");
        w.add("<p>Enter: \"dir()\"</p>");
        w.add("<p>You should see the \"operator\" module in the list.</p>");
        w.add("<p>Enter: \"operator.add(2, 3)\"</p>");
        w.add("<p>You should see the result \"5\" printed.</p>");
        w.add("<p>Enter: \"dir(operator)\"</p>");
        w.add("<p>This lists all the functions in the \"operator\" module. It "
                + "is quite a long list and contains \"add\", the function "
                + "that we called to add the numbers 2 and 3. There are "
                + "numerous functions that have a name starting and ending "
                + "with \"__\". These are not supposed to be called directly, "
                + "but they can be called.</p>");
        w.add("<p>Enter: \"operator.__add__(2, 3)\"</p>");
        w.add("<p>Python does not have a way of exerting access control on "
                + "variables or functions, so it uses a naming convention to "
                + "indicate to users that the variable or function should not "
                + "be accessed from outside the module. Variables with names "
                + "that start with a single underscore (\"_\") or double "
                + "underscore \"__\" you generally should not be accessing or "
                + "using directly.</p>");
        w.add("<p>Enter: \"help(operator.add)\"</p>");
        w.add("<p>This prints out some information about how to use the "
                + "\"operator\" module \"add\" function.</p>");
        w.add("<p>Enter: \"help()\"</p>");
        w.add("<p>This enters the help system and the prompt changes to look "
                + "like \"help> \".</p>");
        w.add("<p>Read what is printed.</p>");
        w.add("<p>Enter: \"modules\"</p>");
        w.add("<p>Enter: \"operator\"</p>");
        w.add("<p>This is the help documentation for the operator module. It "
                + "is many lines long. Press and hold the <enter> key to get "
                + "the next lines of the help documentation and let go after a "
                + "few lines. Try pressing your <space bar> key to get the "
                + "next page of the help documentation. Usually you can keep "
                + "pressing your <space bar> key to scan through this help "
                + "documentation until you exit. You can also press your <q> "
                + "key to quit and return to the help system.</p>");
        w.add("<p>Enter: \"q\"</p>");
        w.add("<p>This should exit the help system and return you to the "
                + "Python prompt.</p>");
        w.add("<p>Call the \"quit\" function to quit the Python REPL i.e. "
                + "Enter: \"quit()\"</p>");
        w.add("<p>This should return you to the normal command prompt.</p>");
//        w.add("<p></p>");
//        w.add("<p></p>");
//        w.add("<p></p>");
//        w.add("<p>Enter: \"\"</p>");
//        w.add("<p>Enter: \"\"</p>");
//        w.add("<p>Enter: \"\"</p>");
//        w.add("<p>Enter: \"\"</p>");
        w.add("</div>");
        // Add navigation
        addNav(w, dirCourse, cc, c);
        // Write page
        w.writeHTML(cc.lookupPath.get(code), "index", code + " Page");
    }

}
