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
package io.github.agdturner.course.python.intro.pages;

import io.github.agdturner.course.python.intro.PythonIntroCourse;
import io.github.agdturner.course.Page;
import io.github.agdturner.course.Course;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Python Intro Course Home Page.
 *
 * @author Andy Turner
 */
public class Home extends Page {

    private static final long serialVersionUID = 1L;

    /**
     * Create a new instance.
     *
     * @param courseName What {@link #name} is set to.
     * @param index The index of the page.
     * @param c What {@code #c} is set to.
     */
    public Home(String courseName, Course c) {
        super("home", c.getCourseCode1() + " " + courseName, "Home", c);
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2>1. Introduction</h2>
              <p>Welcome to the course website!</p>
              """);
        w.add("<p>The course timetable is linked from the "
                + Web_ContentWriter.getLink(
                        "https://webprod3.leeds.ac.uk/catalogue/dynmodules.asp?Y="
                        + c.academicYear + "&M=" + c.getCourseCode2(),
                        c.getCourseCode1() + " Module Catalogue Page")
                + "</p>");
        w.add("<p>These website is maintained by "
                + Web_ContentWriter.getLink(
                        "https://www.geog.leeds.ac.uk/people/a.turner/index.html",
                        "Andy Turner")
                + " and comprises a set of webpages and file based resources."
                        + "</p>");
        w.add("""
              <p>At the top of each webpage is a Style Button that can be used to 
              change between a lighter and darker style. Below that is a 
              Navigation Section which outlines the current page. Each webpage 
              links to the next and at the end there is an index and a page of 
              references.</p>
              <p>Essentially, the idea is that you - students taking the course
              - read through the webpages trying out code and undertaking 
              practical exercises as directed.</p>
              <p>Please contact your tutor by email or us the module Discussion 
              tool in  
              <a href="https://minerva.leeds.ac.uk/">Minerva</a> if you want 
              help or clarification or there is a problem with these resources.
              </p>
              """);

        w.add("""
              <h2 id="2">2. Syllabus</h2>
              
              <p>General computer programming language concepts, including:</p>
              <ul>
              """);
//        w.add("<li>The notion of an "
//                + c.index.getReference("API",
//                        "Application Programming Interface (API)")
//                + "</li>");
        w.add("<li>" + c.index.getReference("Variable", "Variables") + "</li>");
        w.add("<li>"
                + c.index.getReference("Control Flow")
                + "("
                + c.index.getReference("Conditional", "conditionals")
                + "/"
                + c.index.getReference("For Loop", "for loops")
                + "/"
                + c.index.getReference("While Loop", "while loops")
                + ")</li>");
        w.add("<li>"
                + c.index.getReference("Function", "Functions")
                + " and "
                + c.index.getReference("Functional Programming")
                + "</li>");
        w.add("<li>"
                + c.index.getReference("Class", "Classes")
                + " and "
                + c.index.getReference("Object Oriented Programming")
                + "</li>");
        w.add("</ul>");

        w.add("<p>"
                + c.index.getReference("Python")
                + " specifics:</p>");
        w.add("<ul>");
        w.add("<li>Language development and limitations</li>");
        w.add("<li>Structuring and organising code into "
                + c.references.getReference(
                        "Python Documentation Classes Tutorial", "Classes")
                + ", "
                + c.references.getReference(
                        "Python Documentation Modules Tutorial",
                        "Modules")
                + ", and "
                + c.references.getReference("Python Packages", "Packages")
                + ".</li>");
        w.add("<li>Using the "
                + c.index.getReference("Read Evaluate Print Loop",
                        "Read Evaluate Print Loop (REPL)")
                + " environment</li>");
        w.add("<li>Running programs via the command line, "
                + c.references.getReference("Jupyter Notebook")
                + ", "
                + c.references.getReference("IDLE")
                + " and "
                + c.references.getReference("Spyder")
                + ".</li>");
        w.add("<li>Python Environment Management using "
                + c.references.getReference("Conda")
                + " and "
                + c.index.getReference("Python Venv Module")
                + "</li>");
        w.add("<li>Using the "
                + c.references.getReference("Python Standard Library")
                + ", and third party packages available via "
                + c.references.getReference("PyPI",
                        "PyPI - the Python Package Index")
                + "</a></li>");
//        w.add("<li>Using Python to automate "
//                + c.references.getReference("https://qgis.org/", "QGIS", null)
//                + " Desktop - geospatial data processing software.</li>");
        w.add("<li>Including code comments and "
                + c.index.getReference("Python Docstring", "docstrings")
                + " to ease comprehension and use.</li>");
//        w.add("<li>Producing documentation using "
//                + c.references.getReference("https://docs.python.org/3/library/pydoc.html",
//                        "Pydoc", null)
//                + " and "
//                + c.references.getReference("https://www.sphinx-doc.org/", "Sphinx", null)
//                + "</li>");
        w.add("<li>Testing code using print statements.</li>");
//        w.add("<li>Testing code using print statements and "
//                + c.references.getReference(
//                        "https://docs.python.org/3/library/doctest.html",
//                        "Doctest", null)
//                + "</li>");
//        w.add("<li>"
//                + c.references.getReference("Unit_testing", "Unit testing")
//                + " using "
//                + c.references.getReference(
//                        "https://docs.python.org/3/library/unittest.html",
//                        "Unittest", null)
//                + " and "
//                + c.references.getReference(
//                        "https://docs.pytest.org/", "Pytest", null)
//                + "</li>");
        w.add("</ul>");
        w.add("""
              <h2 id="3">3. Expectations</h2>
              <p>You will learn about:</p>
              <ul>
              """);
        w.add("<li>"
                + c.index.getReference("Version Control")
                + "</li>");
        w.add("""
              <li>Data encoding and data formats</li>
              <li>Program input and output</li>
              <!--
              <li>Developing Python code (planning, writing, testing, 
              organising)</li>
              """);
        w.add("<li>The Python parts of the "
                + c.references.getReference("Anaconda")
                + " data science platform</li>");
        w.add("<li>Processing geographical features (geometry and related"
                + " attribute) data.</li>-->");
        w.add("<li>Visualisation using "
                + c.references.getReference("Matplotlib")
                + "</li>");
        w.add("<li>Processing raster data stored in lists.</li>");
        w.add("<li>Using "
                + c.references.getReference("GitHub")
                + "</li>");
        w.add("<li>Developing a "
                + c.index.getReference("Graphical User Interface")
                + " (GUI)</li>");
        w.add("<li>Developing and visualising a basic spatial "
                + c.index.getReference("Agent Based Model")
                + " (ABM)</li>");
        w.add("""
              </ul>
              <p>Computer programming mostly involves computational thinking, 
              planning, problem solving and testing. It is often helpful to 
              break a task into smaller subtasks, and to think about the order 
              in which to do things. Often good solutions involve doing a 
              sequence of things repeatedly on some data stored in a data 
              structure.</p>
              <!--<p>Often it is 
              helpful to use a framework for testing from the outset and to test 
              often as the code develops.</p>-->
              <p>If you are new to computer programming, there is quite a lot of 
              terminology to get used to, some is generic to programming, some 
              is more specific to Python.</p>
              <p>There are some key concept to understand which may take several 
              attempts to learn fully.</p>

              <h2 id="4">4. The Learning Journey</h2>
              <p>Develop your understanding through practise and by reading.</p>
              <p>Be experimental - test your understanding by testing code does 
              what you expect it to. If code does not do what you expect, try to
              understand why - treat it as a learning opportunity.</p>
              <p>One of the keys to coding is learning to be able to interpret 
              errors messages - understand what caused them. If your program 
              generates an exception and error message, then figure out what the
              issue is and resolve before trying to implement code that does 
              something else. Ignoring errors is a bad idea. In general, the 
              more changes made to a program, the harder it becomes resolve an 
              issue.</p>
              <p>Be cautious and do not run code that you do not fully trust. 
              Think about the code does that you want to try: Do you comprehend 
              it sufficiently to know it won't do anything malicious before 
              trying it out?</p>
              """);
        w.add("<p>The webpages with names starting \"ABM\" are a sequence of"
                + " practicals for the development of a basic spatial "
                + c.index.getReference("Agent Based Model", "ABM")
                + ". The ABM can be regarded as a simple model of animals"
                + " moving about in an environment, interacting with each other"
                + " and the environment.</p>");
        w.add("<p>Developing the ABM by following instructions puts into"
                + " practise much of the theory detailed in other webpages. By"
                + " the end of these practicals, you should have ABM model code"
                + " that:</p>");
        w.add("<ul>");
        w.add("<li>has a basic "
                + c.index.getReference("Graphical User Interface", "GUI")
                + ";</li>");
        w.add("""
              <li>reads in data from local files and from the Web; and</li>
              <li>produces an animation, data files and user friendly messages.
              </li>
              </ul>
              <p>At that stage, you should have sufficient knowledge and skill 
              to develop the model further without detailed instructions.</p>
              <p>You are then to undertake an independent project to apply what 
              you have learned to develop some different software - there will 
              be a specification, some guidance for approaching the task, but no
              detailed instructions to follow.</p>
              <p>Do not expect to master the Python language by the end of this 
              course. It can take many years of experience to learn all about a 
              language. Try to enjoy the learning journey, the challenges and 
              the rewards.</p>
              <p>Gaining elementry programming skills and knowledge is 
              empowering in a world where there skills are in high demand and 
              with which you can make a difference.</p>
              
              <h2 id="5">5. Platform/Software</h2>
              <p>All the software used in this course is 
              """);
        w.add(c.index.getReference("Free and Open Source Software",
                "Free and Open Source Software")
                + " (FOSS) which is available to download and install on "
                + c.index.getReference("Linux")
                + ", "
                + c.index.getReference("Microsoft Windows")
                + ", and "
                + c.index.getReference("MacOS")
                + ".<p>");
        w.add("""
              <p>The software is available at the University of Leeds via 
              AppsAnywhere and the Academic Windows Virtual Desktop which can be 
              accessed via a Web browser and the following URL:
              <a href="https://wvd.leeds.ac.uk">https://wvd.leeds.ac.uk</a>.
              This includes: 
              <a href="https://www.anaconda.com/">Anaconda</a> - a data science 
              platform,
              <a href="https://qgis.org/">QGIS</a> Desktop - Geographical 
              Information System software, and various third party Python 
              packages.</p>
              """);
        // Assignments and Assessments
        PythonIntroCourse pic = (PythonIntroCourse) c;
        if (pic.hasAssignments) {
            w.add("""
                  <h2 id="6">6. Assignments and Assessments</h2>
                  <p>There are two assignments that are assessed:</p>
                  <ol>
                  """);
            w.add("<li>" + pic.assignment1Name + " worth "
                    + pic.assignment1Weighting + "% of the overal mark and due "
                    + pic.assignment1DueDate + " - developed by completing "
                    + "practical exercises by following instructions.</li>");

            w.add("<li>" + pic.assignment2Name + " worth "
                    + pic.assignment2Weighting + "% of the overal mark and due "
                    + pic.assignment2DueDate + " - developed by applying what "
                    + "you have learned to a software development task for "
                    + "which there is a specification and a suggested way to "
                    + "approach implementation, but no detailed instructions "
                    + "to follow. You should have sufficent knowledge and "
                    + "skill to sensibly begin this assignment from about half "
                    + "way through the course.</li>");
            w.add("</ol>");
        }
        w.add("</div>");
    }
}
