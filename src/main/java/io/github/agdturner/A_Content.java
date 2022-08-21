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
import uk.ac.leeds.ccg.generic.core.Generic_Strings;
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
        w.add("</ul>");
        w.add("<li>Practice using Python to:");
        w.add("<ul>");
        w.add("<li>Read data from and write data to files</li>");
        w.add("<li>Use lists as data structures</li>");
        w.add("<li>Handle coordinates in lists</li>");
        w.add("<li>Display spatial data</li>");
        w.add("<li>Process raster data</li>");
        w.add("<li>Develop and a dynamic spatial simulation</li>");
        w.add("</ul></li>");
        w.add("<li>Think computationally</li>");
        w.add("<li>Practice and develop problem solving skills</li>");
        w.add("<li>Understand generic programming tasks and how to go about "
                + "these in Python:");
        w.add("<ul>");
        w.add("<li>Tests</li>");
        w.add("<li>Documentation</li>");
        w.add("<li>Sharing</li>");
        w.add("</ul>");
        w.add("<li>Appreciate Python and be aware of its limitations</li>");
        w.add("<li>Understand different ways to code and run Python</li>");
        w.add("<li>Appreciate the utility and benefits of:");
        w.add("<ul>");
        w.add("<li>Integrated Development Environments</li>");
        w.add("<li>Version control</li>");
        w.add("</ul>");
        w.add("</ul>");
        // The learning journey
        w.add("<h3>The Learning Journey</H3>");
        w.add("<ul>");
        w.add("<li>Go at your own pace:");
        w.add("<ul>");
        w.add("<li>Take time to develop your skills</li>");
        w.add("<li>Learners with more experience tend to make faster progress</li>");
        w.add("</ul>");
        w.add("<li>Build up your skills and knowledge gradually");
        w.add("<ul>");
        w.add("<li>There is a lot to learn especially if you are new to "
                + "programming</li>");
        w.add("<li>Practice is key to success</li>");
        w.add("<li>Repeat reading and repeating tasks has helped others before "
                + "and it may well help you.</li>");
        w.add("<li>Try to lean new things when you are fresh and remember to "
                + "take breaks.</li>");
        w.add("<li>Talk to others without disturbing them. Work together if "
                + "like.</li>");
        w.add("<li>Ask for help in class or via email. If something is wrong "
                + "with your code, then try to explain what you expect and "
                + "what is instead happeneing and provide a copy of your "
                + "code.</li>");
        w.add("</ul>");
        w.add("<li>Test your understanding and test your code does what you "
                + "expect it to do.</li>");
        w.add("<li>Be experimental</li>");
        w.add("<li>Learn to interpret error messages</li>");
        w.add("<li>Don't be scared of errors, but don't ignore them!</li>");
        w.add("</ul>");
        // Assignments and Assessments
        w.add("<h3>Assignments and Assessments</h3>");
        w.add("<ul>");
        w.add("<li>There are two assignments that are assessed:");
        w.add("<ul>");
        w.add("<li>A portfolio from the practical tasks worth 30%.</li>");
        w.add("<li>An independent project worth 70%.</li>");
        w.add("</ul>");
        w.add("</ul>");
        // Practicals
        w.add("<h3>Main Sections</h3>");
        w.add("<p>The sections continaing \"ABM\" are practicals that employ "
                + "some of what is learned in the preceeding sections to "
                + "gradually develop an Agent Based Model which is a "
                + "two-dimensional (2D) spatial model of animals moving about "
                + "and interacting with each other and the environment in "
                + "which they are moving.</p>");
        w.add("<nav>");
        w.add("<ol>");
        CourseContent cc = new CourseContent();
        String s;
        String sname;
        s = "programming";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        s = "python";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        s = "github";
        sname = "GitHub";
        addPage(w, s, sname, cc);
        s = "variables";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        s = "containers";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        s = "branching";
        sname = "Branching and Loops";
        addPage(w, s, sname, cc);
        s = "functions";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        s = "classes";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        s = "io";
        sname = "Input/Output";
        addPage(w, s, sname, cc);
        s = "modules";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        s = "exceptions";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        s = "gui";
        sname = "GUI";
        addPage(w, s, sname, cc);
        s = "web";
        sname = Generic_String.getCapitalFirstLetter(s);
        addPage(w, s, sname, cc);
        for (int i = 1; i < 10; i++) {
            s = "abm" + i;
            sname = "ABM " + i;
            addPage(w, s, sname, cc);
        }
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
        String k = "../" + s;
        w.add("<li>" + w.getLink(k, linkName) + "</li>");
        cc.lookupLink.put(s, k);
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
        w.add("<p>Programming is about instructing a computer to carry out a "
                + "set of tasks. Typically these involve data that are "
                + "seperate from the instructions, and their transfer, "
                + "processing and output in visual and/or audio forms.</p>");
        w.add("<p>Programming can be done via a visual interface that allows "
                + "programmers to compose workflows made up of components that "
                + "fit or connect together to represent some sequence of "
                + "calculation and data processing. However, this course is "
                + "not about visual programming and is about programming using "
                + "written instructions that are passed to an interpretter.</p>");
        w.add("<p>There are a wide variety of computer programming languages "
                + "which have varying syntax (rules) as to how to write "
                + "instructions. Whilst this course focusses on Python "
                + "programming, it is helpful to understand ome of the "
                + "similarities and differences between Python and other "
                + "commonly used similar languages.</p>");
        w.add("<p>Nearly all modern computers use electrical charge to store "
                + "and process data. Without going into too much detail, the "
                + "charge can be used to change the state of data from a zero "
                + "(0) to a one (1). A single bit of data is thus a 0 or a 1. "
                + "Typically computers work on fixed size collections of bits "
                + "called bytes. The number of bits in a byte limits how many "
                + "different things can be expressed in a single byte. Bytes "
                + "can be combined to express more, similar to how words in a "
                + "natural language like English can express far more than the "
                + "individual letters.</p>");
        w.add("<p>Lower level languages have smaller numbers of different "
                + "types of instruction, higher level languages can do much "
                + "more, but these are ultimately compiled into the machine "
                + "readable low level language when a program is run. Python "
                + "is a high level language like Java, C# and C++.</p>");
        w.add("<p>Sometimes programming is also called coding. Programming "
                + "using a computer programming language and interpretter "
                + "allows for the automation of tasks that may otherwise "
                + "require the user to manually push buttons or be on hand to "
                + "figure out what to do and set the next things going once a "
                + "process has completed.</p>");
        w.add("<p>If you are new to computer programming, then there may be "
                + "many terms already in this page that are new or are "
                + "unfamiliar to you. As with learning any language, this is "
                + "not uncommon and some level of immersion and repetition "
                + "will help you comprehend. You are not expected to know and "
                + "undertstand everything to be able to move on. The meaining "
                + "of some terms will become clearer the more they are used. "
                + "Gradually you can fill in the gaps in your understanding as "
                + "you go through the learning resources. Many of you will "
                + "benefit going through some parts of these resources several "
                + "times and perhaps go through everything more than once to "
                + "gain a deeper understanding.</p>");
        w.add("<p>In Python (like in Java) instructions or commands are "
                + "entered at a prompt or passed in files to be interpretted. "
                + "Commands entered at a prompt are run one at a time. When "
                + "program files are run, typically multiple instructions are "
                + "run and in some cases the program contains new instructions "
                + "about how to process data which are interpretted too. Using "
                + "a computer programming language and interpretter allows for "
                + "the automation of tasks that may otherwise require the user "
                + "to manually push buttons or be on hand to provide the next "
                + "instruction. Sometimes programming is also called coding. "
                + "Before we get on with some Python coding, let us learn a "
                + "little bit more about that langauge.</p>");
        w.add("</ul>");
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
        w.add(w.getLink(Paths.get(dirCourse.toString(), "index.html"), "Home"));
        if (c > 0) {
            String s = cc.names.get(c - 1);
            //Path p = Paths.get(cc.lookupPath.get(s).toString(), "index.html");
            w.add(w.getLink(cc.lookupLink.get(s), "Prev: " + cc.lookup.get(s)));
            //w.add(w.getLink(p, "Prev: " + cc.lookup.get(s)));
        }
        if (c < cc.names.size() - 1) {
            String s = cc.names.get(c + 1);
            //Path p = Paths.get(cc.lookupPath.get(s).toString(), "index.html");
            w.add(w.getLink(cc.lookupLink.get(s), "Prev: " + cc.lookup.get(s)));
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
                + "or binary form for all major platforms from " + pythonHome
                + ", and may be freely distributed. The web site contains "
                + "distributions of and pointers to many free third party "
                + "Python modules, programs and tools, and additional "
                        + "documentation.</p>");
        w.add("<p>Python underwent a major revision from Python 2 to Python 3 "
                + "in around 2008. Much Python 2 code needed refactoring in "
                + "order to work in Python 3 environments. Python 2 is no "
                + "longer supported, but it is sometimes still used. Python 3 "
                + "is actively developed and a new stable version is released "
                + "from time to time. On the 22nd of August 2022 Version "
                + "3.10.6 was release.</p>");
        w.add("<p>Third party software sometimes needs changes to work with "
                + "the latest version. It is sensible to know exactly which "
                + "version of Python and any third party modules you are "
                + "using. This helps with reproducing results and diagnosing "
                + "issues. Often programmers ask others for help and submit "
                + "bug reports so others can replicate issues on their set up "
                + "to try to diagnose and fix issues. In this way, programming "
                + "is like being part of a community where it is normal to ask "
                + "others for help. In this course, you are not expected to "
                + "engage with the developer community, if you experience any "
                + "problems you are encouraged to ask each other or your "
                + "tutor for help.</p>");
        String python3DocsHome = "https://docs.python.org/3/";
        String python3DocsTutorial = python3DocsHome + "tutorial/";
        w.add("<p>The "
                + w.getLink(python3DocsTutorial, "Getting started tutorial")
                + "linked from the Python web site is as good a place as any "
                + "to start learning Python. We will be covering a lot of the "
                + "same basics in this course.</p>");
        w.add("</div>");
        // Add navigation
        addNav(w, dirCourse, cc, c);
        // Write page
        w.writeHTML(cc.lookupPath.get(code), "index", code + " Page");
    }

}
