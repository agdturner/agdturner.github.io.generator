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
        w.add("<p>The website is maintained by "
                + Web_ContentWriter.getLink(
                        "https://www.geog.leeds.ac.uk/people/a.turner/index.html",
                        "Andy Turner")
                + " and comprises a set of webpages and file based resources."
                        + "</p>");
        w.add("""
              <p>At the top of each webpage is a button that can be actioned to 
              change between a lighter and darker page style. Below that is a 
              navigation section that links to each page. The pages are 
              sequential and at the end of each page, there is a link to the 
              next page.</p>
              <p>There are index and references pages at the end. The index page 
              contains definitions for some terms and so is also a bit like a 
              glossary. As well, it links back to particular sections of other 
              pages that are relevant.</p>
              <p>Essentially, the idea is that you - students taking the course
              - read through the webpages trying out code and undertaking 
              practical exercises as directed.</p>
              <p>Please contact your tutor by email or use the 
              <a href="https://minerva.leeds.ac.uk/">Minerva</a> Discussion 
              section if you want help, clarification or there is a problem with
              these resources.</p>
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
        w.add("<li>" + c.index.getReference("Variable", "Variables") + ";</li>");
        w.add("<li>"
                + c.index.getReference("Control Flow")
                + "("
                + c.index.getReference("Conditional", "conditionals")
                + "/"
                + c.index.getReference("For Loop", "for loops")
                + "/"
                + c.index.getReference("While Loop", "while loops")
                + ");</li>");
        w.add("<li>"
                + c.index.getReference("Function", "Functions")
                + " and "
                + c.index.getReference("Functional Programming")
                + ";</li>");
        w.add("<li>"
                + c.index.getReference("Class", "Classes")
                + " and "
                + c.index.getReference("Object Oriented Programming")
                + ";</li>");
        w.add("</ul>");

        w.add("<p>"
                + c.index.getReference("Python")
                + " specifics:</p>");
        w.add("<ul>");
        w.add("<li>Language development and limitations;</li>");
        w.add("<li>Structuring and organising code into "
                + c.references.getReference(
                        "Python 3 Documentation: Tutorial: Classes", "Classes")
                + ", "
                + c.references.getReference(
                        "Python 3 Documentation: Tutorial: Modules", "Modules")
                + ", and "
                + c.references.getReference(
                        "Python 3 Documentation: Tutorial: Packages", 
                        "Packages")
                + ";</li>");
        w.add("<li>Using the "
                + c.index.getReference("REPL", "Read Evaluate Print Loop")
                + " (REPL) environment;</li>");
        w.add("<li>Running programs via the command line, "
                + c.references.getReference("Jupyter Notebook")
                + ", "
                + c.references.getReference("IDLE")
                + " and "
                + c.references.getReference("Spyder")
                + ";</li>");
        w.add("<li>Python Environment Management using "
                + c.references.getReference("Conda")
                + " and "
                + c.index.getReference("Python venv", "venv")
                + ";</li>");
        w.add("<li>Using the "
                + c.references.getReference("Python 3 Documentation: Library",
                        "Python 3 Library")
                + ", and third party packages available via "
                + c.references.getReference("PyPI")
                + " - the Python Package Index;</li>");
        w.add("<li>Including comments and "
                + c.index.getReference("Python docstring", "docstrings")
                + " to ease code comprehension and use;</li>");
//        w.add("<li>Producing documentation using "
//                + c.references.getReference("https://docs.python.org/3/library/pydoc.html",
//                        "Pydoc", null)
//                + " and "
//                + c.references.getReference("https://www.sphinx-doc.org/", "Sphinx", null)
//                + ";</li>");
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
        w.add("<li>Automating "
                + c.references.getReference("QGIS")
                + " Desktop using "
                + c.index.getReference("PyQGIS")
                + ";</li>");
        w.add("<li>"
                + c.index.getReference("Version Control")
                + ";</li>");
        w.add("<li>Data encoding and "
                + c.index.getReference("File Format", "file formats")
                + ";</li>");
        w.add("<li>Python containers including "
                + c.index.getReference("Python list", "lists")
                + ", "
                + c.index.getReference("Python tuple", "tuples")
                + "and "
                + c.index.getReference("Python dict", "dictionaries")
                + ";</li>");
        w.add("""
              <li>Program input and output</li>
              <!--
              <li>Developing Python code (planning, writing, testing, 
              organising)</li>
              """);
        w.add("<li>The Python parts of the "
                + c.references.getReference("Anaconda")
                + " data science platform;</li>");
        w.add("<li>Processing geographical features (geometry and related"
                + " attribute) data;</li>-->");
        w.add("<li>Visualisation using "
                + c.references.getReference("Matplotlib")
                + ";</li>");
        w.add("<li>Processing raster data stored as lists of lists;</li>");
        w.add("<li>Using "
                + c.references.getReference("GitHub")
                + ";</li>");
        w.add("<li>Developing a "
                + c.index.getReference("GUI", "Graphical User Interface")
                + " (GUI);</li>");
        w.add("<li>Developing and visualising a basic spatial "
                + c.index.getReference("ABM", "Agent Based Model")
                + " (ABM);</li>");
        w.add("""
              </ul>
              <p>Computer programming mostly involves computational thinking, 
              planning, problem solving and testing. It is often helpful to 
              break a task into smaller subtasks, and gradually develop an
              implementation. Often good solutions to coding tasks involve doing
              things repeatedly for a given sequence of things.</p>
              <!--<p>Often it is 
              helpful to use a framework for testing from the outset and to test 
              often as the code develops.</p>-->
              <p>If you are new to computer programming, there is quite a lot of 
              terminology to get used to, some is generic to programming, some 
              is more specific to Python.</p>
              <p>There are some key concepts to understand which may take a few  
              attempts to understand, but hopefully you will realise that any 
              struggle was worth the effort!</p>

              <h2 id="4">4. The Learning Journey</h2>
              <p>Develop your understanding through practise and by reading.</p>
              <p>Be experimental - test your understanding by testing code does 
              what you expect it to. If code does not do what you expect, try to
              understand why - regard failure and errors as a learning 
              opportunity!</p>
              <p>One of the keys to coding is learning to be able to interpret 
              errors messages and understand what caused them. If a program you 
              are developing unexpectedle raises an exception and reports an 
              error message, then try to understand why and stop this happening 
              before moving on. Ignoring an error message is nearly always the 
              wrong thing to do!</p>
              <p>Be cautious and do not run code that you do not fully trust. If
              in doubt consult with your tutor.</p>
              """);
        w.add("<p>The webpages with names starting 'ABM' are a sequence of "
                + "practicals that progress the development of a basic spatial "
                + c.index.getReference("ABM", "Agent Based Model")
                + ". The ABM can be regarded as a simple model of autonomous"
                + " spatial entities that move in an environment, interacting"
                + " with the environment and each other.</p>");
        w.add("<p>Developing the ABM by following instructions puts into"
                + " practise some of the theory detailed in other webpages. By"
                + " the end of these practicals, you should have ABM model code"
                + " that:</p>");
        w.add("<ul>");
        w.add("<li>has a basic "
                + c.index.getReference("GUI")
                + ";</li>");
        w.add("""
              <li>reads in data from local files and from the Web; and</li>
              <li>produces an animation, data files and user friendly messages.
              </li>
              </ul>
              <p>After completing the last ABM practical, you should have 
              sufficient knowledge and skill to develop the model in interesting 
              ways without being given detailed instructions.</p>
              <p>To complete the course, you are to undertake an independent 
              project to apply what you have learned to develop some different 
              software - there will be a specification of what the code/software 
              is to do, some guidance for approaching the software development 
              task, but no detailed instructions to follow.</p>
              <p>Do not expect to master the Python language by the end of this 
              course. Usually this takes many thousands of hours of practice 
              over many years.</p>
              <p>Try to enjoy the learning journey, the challenges and the 
              rewards. Learning to program and learning Python is empowering!
              </p>
              
              <h2 id="5">5. Platform/Software</h2>
              <p>All the software used in this course is 
              """);
        w.add(c.index.getReference("Free and Open Source Software",
                "Free and Open Source Software")
                + " (FOSS) - available to download and install on "
                + c.index.getReference("Linux")
                + ", "
                + c.index.getReference("Microsoft Windows")
                + ", and "
                + c.index.getReference("MacOS")
                + ".<p>");
        w.add("<p>The software is available via 'AppsAnywhere' at the "
                + "University of Leeds which is accessible remotely via the "
                + "'Academic' <a href=\"https://wvd.leeds.ac.uk\">"
                + "University Windows Virtual Desktop</a>. The software "
                + "includes: "
                + c.references.getReference("Anaconda")
                + " - a data science platform, "
                + c.references.getReference("QGIS")
                + " Desktop - Geographical Information System software, and "
                + "various third party Python packages.</p>");
        // Assignments and Assessments
        PythonIntroCourse pic = (PythonIntroCourse) c;
        if (pic.hasAssignments) {
            w.add("""
                  <h2 id="6">6. Assignments and Assessments</h2>
                  <p>There are two assignments that are assessed:</p>
                  <ol>
                  """);
            w.add("<li>" + pic.assignment1Name
                    + " worth "
                    + pic.assignment1Weighting
                    + "% of the overall mark and due "
                    + pic.assignment1DueDate
                    + " - developed by completing the ABM practicals.</li>");

            w.add("<li>" + pic.assignment2Name
                    + " worth "
                    + pic.assignment2Weighting
                    + "% of the overall mark and due "
                    + pic.assignment2DueDate
                    + " - developed by applying what you have learned to a"
                    + " software development task for which there is a"
                    + " specification and suggestions of how to approach"
                    + " implementation, but no detailed instructions to"
                    + " follow. You should have sufficent knowledge and"
                    + " skill to begin this assignment after completing the"
                    + " ABM5 practical.</li>");
            w.add("<p>See the module page on "
                    + "<a href=\"https://minerva.leeds.ac.uk/\">Minerva</a>"
                    + " for details of the "
                    + "assignments and how they are assessed.</p>");
            w.add("</ol>");
        }
        w.add("""
              <h2 id="6">6. About these learning resources</h2>
              <p>These learning resources are based on 
              <a href=\"https://www.geog.leeds.ac.uk/courses/computing/\">
              earlier versions of courses</a> developed originally by
              <a href="https://ajevans.github.io/">
              Andy Evans</a>.</p>
              <p>Slightly updated version of the course were developed for 
              years, but a major refactor was completed in the academic year 
              2022-2023 to make the learning resources more accessible. This
              refactoring involved implementing a
              <a href=\"https://github.com/agdturner/agdturner.github.io\">
              new website build system</a>
              which is based on
              <a href=\"https://en.wikipedia.org/wiki/Java_(programming_language)\">
              Java</a>.</p>
              """);
        w.add("</div>");
    }
}
