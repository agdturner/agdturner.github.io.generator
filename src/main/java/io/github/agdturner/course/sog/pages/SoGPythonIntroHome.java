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
package io.github.agdturner.course.sog.pages;

import io.github.agdturner.course.coding.python.intro.pages.PythonIntroHome;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.Index;
import io.github.agdturner.course.References;
import io.github.agdturner.course.sog.SoGCourseDetails;
import io.github.agdturner.course.sog.SoGPythonIntroCourse;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Python Intro Course Home Page.
 *
 * @author Andy Turner
 */
public class SoGPythonIntroHome extends PythonIntroHome {
    
    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     * @param courseName What {@link #name} is set to.
     */
    public SoGPythonIntroHome(Course course, String courseName) {
        super(course, courseName);
    }

    @Override
    public SoGPythonIntroCourse getCourse(){
        return (SoGPythonIntroCourse) site;
    }
            
    @Override
    public void write() {
        SoGPythonIntroCourse course = getCourse();
        Index index = course.getIndex();
        References references = course.getReferences();
        writeStart();
        SoGCourseDetails soGCourseDetails = course.courseDetails;
        
        w.add("<p>The course timetable is linked from the "
                + Web_ContentWriter.getLink(
                        "https://webprod3.leeds.ac.uk/catalogue/dynmodules.asp?Y="
                        + soGCourseDetails.academicYear + "&M=" + soGCourseDetails.getGEOGCourseCodeM(),
                        soGCourseDetails.getGEOGCourseCode() + " Module Catalogue Page")
                + "</p>");
        writeMaintainer();
        writeNavigationIntro();
        w.add("""
              <p>Please contact your tutor by email or use the 
              <a href="https://minerva.leeds.ac.uk/">Minerva</a> Discussion 
              section if you want help, clarification or there is a problem with
              these resources.</p>
              """);
        writeSyllabus();
        w.add("""
              <p>General computer programming language concepts, including:</p>
              <ul>
              """);
//        w.add("<li>The notion of an "
//                + index.getReference("API",
//                        "Application Programming Interface (API)")
//                + "</li>");
        w.add("<li>" + index.getReference("Variable", "Variables") + ";</li>");
        w.add("<li>"
                + index.getReference("Control Flow")
                + "("
                + index.getReference("Conditional", "conditionals")
                + "/"
                + index.getReference("For Loop", "for loops")
                + "/"
                + index.getReference("While Loop", "while loops")
                + ");</li>");
        w.add("<li>"
                + index.getReference("Function", "Functions")
                + " and "
                + index.getReference("Functional Programming")
                + ";</li>");
        w.add("<li>"
                + index.getReference("Class", "Classes")
                + " and "
                + index.getReference("Object Oriented Programming")
                + ";</li>");
        w.add("</ul>");

        w.add("<p>"
                + index.getReference("Python")
                + " specifics:</p>");
        w.add("<ul>");
        w.add("<li>Language development and limitations;</li>");
        w.add("<li>Structuring and organising code into "
                + references.getReference(
                        "Python 3 Documentation: Tutorial: Classes", "Classes")
                + ", "
                + references.getReference(
                        "Python 3 Documentation: Tutorial: Modules", "Modules")
                + ", and "
                + references.getReference(
                        "Python 3 Documentation: Tutorial: Packages",
                        "Packages")
                + ";</li>");
        w.add("<li>Using the "
                + index.getReference("REPL", "Read Evaluate Print Loop")
                + " (REPL) environment;</li>");
        w.add("<li>Running programs via the command line, "
                + references.getReference("Jupyter Notebook")
                + ", "
                + references.getReference("IDLE")
                + " and "
                + references.getReference("Spyder")
                + ";</li>");
        w.add("<li>Python environment management using "
                + references.getReference("Conda")
                + " and "
                + index.getReference("Python venv", "venv")
                + ";</li>");
        w.add("<li>Using the "
                + references.getReference("Python 3 Documentation: Library",
                        "Python 3 Library")
                + ", and third party packages available via "
                + references.getReference("PyPI")
                + " - the Python Package Index;</li>");
        w.add("<li>Including comments and "
                + index.getReference("Python docstring", "docstrings")
                + " to ease code comprehension and use;</li>");
//        w.add("<li>Producing documentation using "
//                + references.getReference("https://docs.python.org/3/library/pydosite.html",
//                        "Pydoc", null)
//                + " and "
//                + references.getReference("https://www.sphinx-dosite.org/", "Sphinx", null)
//                + ";</li>");
        w.add("<li>Testing code.</li>");
        w.add("</ul>");
        w.add("""
              <h2 id="3">3. Expectations</h2>
              <p>You will learn about:</p>
              <ul>
              """);
        w.add("<li>"
                + index.getReference("Version Control")
                + ";</li>");
        w.add("<li>Data encoding and "
                + index.getReference("File Format", "file formats")
                + ";</li>");
        w.add("<li>Python containers including "
                + index.getReference("Python list", "lists")
                + ", "
                + index.getReference("Python tuple", "tuples")
                + "and "
                + index.getReference("Python dict", "dictionaries")
                + ";</li>");
        w.add("""
              <li>Program input and output</li>
              <!--
              <li>Developing Python code (planning, writing, testing, 
              organising)</li>
              """);
        w.add("<li>The Python parts of the "
                + references.getReference("Anaconda")
                + " data science platform;</li>");
        w.add("<li>Processing geographical features (geometry and related"
                + " attribute) data;</li>-->");
        w.add("<li>Visualisation using "
                + references.getReference("Matplotlib")
                + ";</li>");
        w.add("<li>Processing raster data stored as lists of lists;</li>");
        w.add("<li>Using "
                + references.getReference("GitHub")
                + ";</li>");
        w.add("<li>Developing a "
                + index.getReference("GUI", "Graphical User Interface")
                + " (GUI);</li>");
        w.add("<li>Developing and visualising a basic spatial "
                + index.getReference("ABM", "Agent Based Model")
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
              """);
        w.add("<p>If you are new to computer programming, there is quite a lot "
                + "of terminology to get used to, some is generic to "
                + "programming, some is specific to "
                + index.getReference("Python")
                + ".</p>");
        w.add("""
              <p>There are some key concepts which may take a few attempts to 
              get used to and comprehensively understand.</p>
              """);
        w.add("<p>An example of automating "
                + references.getReference("QGIS")
                + " Desktop using "
                + index.getReference("PyQGIS")
                + " is provided.</p>");

        w.add("""
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
              before moving on. Ignoring error messages is nearly always the 
              wrong thing to do!</p>
              <p>Be cautious and do not run code that you do not fully trust. If
              in doubt consult with your tutor.</p>
              """);
        w.add("<p>The webpages with names starting 'ABM' are a sequence of "
                + "practicals that progress the development of a basic spatial "
                + index.getReference("ABM", "Agent Based Model")
                + ". The ABM can be regarded as a simple model of autonomous"
                + " spatial entities that move in an environment, interacting"
                + " with the environment and each other.</p>");
        w.add("<p>Developing the ABM by following instructions puts into"
                + " practise some of the theory detailed in other webpages. By"
                + " the end of these practicals, you should have ABM model code"
                + " that:</p>");
        w.add("<ul>");
        w.add("<li>has a basic "
                + index.getReference("GUI")
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
              """);
        w.add("<p>Do not expect to master "
                + index.getReference("Python")
                + " by the end of this course. Usually this takes many thousands"
                + " of hours of practice over several years.</p>");
        w.add("""
              <p>Try to enjoy the learning journey, the challenges and the 
              rewards. Learning to program and learning Python is empowering!
              </p>
              
              <h2 id="5">5. Platform/Software</h2>
              <p>All the software used in this course is 
              """);
        w.add(index.getReference("Free and Open Source Software",
                "Free and Open Source Software")
                + " (FOSS) - available to download and install on "
                + index.getReference("Linux")
                + ", "
                + index.getReference("Microsoft Windows")
                + ", and "
                + index.getReference("MacOS")
                + ".<p>");
        w.add("<p>The software is available via 'AppsAnywhere' at the "
                + "University of Leeds which is accessible remotely via the "
                + "'Academic' <a href=\"https://wvd.leeds.ac.uk\">"
                + "University Windows Virtual Desktop</a>. The software "
                + "includes: "
                + references.getReference("Anaconda")
                + " - a data science platform, "
                + references.getReference("QGIS")
                + " Desktop - Geographical Information System software, and "
                + "various third party Python packages.</p>");
        // Assignments and Assessments
        SoGPythonIntroCourse pic = getCourse();
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
                    + "<a href=\"https://minerva.leeds.acuk/\">Minerva</a>"
                    + " for details of the "
                    + "assignments and how they are assessed.</p>");
            w.add("</ol>");
        w.add("""
              <h2 id="7">7. About these learning resources</h2>
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

    @Override
    public void writeMaintainer() {
        w.add("<p>The website is maintained by "
                + Web_ContentWriter.getLink(
                        "https://www.geog.leeds.ac.uk/people/a.turner/index.html",
                        "Andy Turner")
                + " and comprises a set of webpages and file based resources."
                + "</p>");
    }
}
