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

        public CourseContent() {
            names = new ArrayList<>();
            lookup = new HashMap<>();
            lookupPath = new HashMap<>();
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
        String name = "Introduction To Programming and Python Course";
        String filename = "index";
        if (!Files.exists(dirCourse)) {
            Files.createDirectories(dirCourse);
        }
        Web_ContentWriter w = new Web_ContentWriter();
        writeH1(w, name);
        String cc0 = "https://creativecommons.org/share-your-work/public-domain/cc0/";
        w.add("<p>These learning resources were developed for teaching based "
                + "the University of Leeds where typically a tutor was "
                + "available to help learners. They are provided here as Open "
                + "Educational Resources (" 
                + w.getLink(cc0, "CCO Licence") + ").</p>");
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
        ArrayList<String> names = cc.names;
        HashMap<String, String> lookup = cc.lookup;
        String s;
        s = "programming";
        names.add(s);
        lookup.put(s, Generic_String.getCapitalFirstLetter(s));
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "python";
        names.add(s);
        lookup.put(s, Generic_String.getCapitalFirstLetter(s));
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "github";
        names.add(s);
        lookup.put(s, "GitHub");
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "variables";
        names.add(s);
        lookup.put(s, Generic_String.getCapitalFirstLetter(s));
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "abm1";
        names.add(s);
        lookup.put(s, "ABM 1");
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "containers";
        names.add(s);
        lookup.put(s, Generic_String.getCapitalFirstLetter(s));
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "abm2";
        names.add(s);
        lookup.put(s, "ABM 2");
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "branching";
        names.add(s);
        lookup.put(s, "Branching and Loops");
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "abm3";
        names.add(s);
        lookup.put(s, "ABM 3");
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "functions";
        names.add(s);
        lookup.put(s, Generic_String.getCapitalFirstLetter(s));
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "abm4";
        names.add(s);
        lookup.put(s, "ABM 4");
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "classes";
        names.add(s);
        lookup.put(s, Generic_String.getCapitalFirstLetter(s));
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "abm5";
        names.add(s);
        lookup.put(s, "ABM 5");
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "io";
        names.add(s);
        lookup.put(s, "Input Output");
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "abm6";
        names.add(s);
        lookup.put(s, "ABM 6");
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "modules";
        names.add(s);
        lookup.put(s, Generic_String.getCapitalFirstLetter(s));
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "abm7";
        names.add(s);
        lookup.put(s, "ABM 7");
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "exceptions";
        names.add(s);
        lookup.put(s, Generic_String.getCapitalFirstLetter(s));
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "abm8";
        names.add(s);
        lookup.put(s, "ABM 8");
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "gui";
        names.add(s);
        lookup.put(s, "GUI");
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "web";
        names.add(s);
        lookup.put(s, Generic_String.getCapitalFirstLetter(s));
        w.add("<li>" + w.getLink("./" + s, lookup.get(s)) + "</li>");
        s = "abm9";
        names.add(s);
        lookup.put(s, Generic_String.getCapitalFirstLetter(s));
        w.add("<li>" + w.getLink("./" + s, "ABM 9") + "</li>");
        w.add("</ol>");
        w.add("</nav>");
        w.add("</div>");
        String title = domain + A_Strings.symbol_space + name
                + A_Strings.symbol_space + "Page";
        w.writeHTML(dirCourse, filename, title);
        return cc;
    }

    /**
     * Start the main div and write the title of the page in h1 tags. 
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
            Path p = Paths.get(cc.lookupPath.get(s).toString(), "index.html");
            w.add(w.getLink(p, "Prev: " + cc.lookup.get(s)));
        }
        if (c < cc.names.size() - 1) {
            String s = cc.names.get(c + 1);
            Path p = Paths.get(cc.lookupPath.get(s).toString(), "index.html");
            w.add(w.getLink(p, "Next: " + cc.lookup.get(s)));
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
        String pythonHome = "https://www.python.org/";
        w.add("<p>Python is a popular and powerful programming language. "
                + "The Python interpreter and the extensive standard library "
                + "are freely available in source or binary form for all major "
                + "platforms from the Python web site, "
                + w.getLink(pythonHome, pythonHome)
                + ", and may be freely distributed. The same site also "
                + "contains distributions of and pointers to many free third "
                + "party Python modules, programs and tools, and additional "
                + "documentation.</p>");
        w.add("<p>Python underwent a major revision from Python 2 to Python 3. "
                + "Much Python 2 code needed refactoring in order to work in "
                + "Python 3 environments. It is sensible to know exactly which "
                + "version of Python you are using and to keep a track of any "
                + "modifications you have made to your Python environment. "
                + "This is helpful in science to try to make results more "
                + "reproducible, but also in programming sometimes you want to "
                + "ask others for help or to submit a bug report and the "
                + "helpers or developers will want to replicate the issue."
                + "</p>");
        w.add("<p>Computer programming languages are typically evolving over "
                + "time like software do. Often development teams will support "
                + "older versions before deprecating or making them obsolete "
                + "and no longer supporting them. This encourages users to "
                + "try and use newwer versions which are typically more "
                + "capable or functional, but not always!</p>");
        String python3DocsHome = "https://docs.python.org/3/";
        String python3DocsTutorial = python3DocsHome + "tutorial/";
        w.add("<p>A getting started tutorial is available on the Python web "
                + "site and this can be find via the following URL: "
                + w.getLink(python3DocsTutorial, python3DocsTutorial)
                + ". We will be going through much of the same in this "
                + "course.</p>");
        w.add("</div>");
        // Add navigation
        addNav(w, dirCourse, cc, c);
        // Write page
        w.writeHTML(cc.lookupPath.get(code), "index", code + " Page");
    }

}
