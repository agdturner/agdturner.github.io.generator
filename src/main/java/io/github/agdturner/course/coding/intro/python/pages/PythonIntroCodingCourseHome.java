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
package io.github.agdturner.course.coding.intro.python.pages;

import io.github.agdturner.course.Course;
import io.github.agdturner.course.coding.intro.pages.IntroCodingCourseHome;

/**
 * Python Intro Coding Course Home Page.
 *
 * @author Andy Turner
 */
public class PythonIntroCodingCourseHome extends IntroCodingCourseHome {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to
     * @param courseName What {@link #name} is set to.
     */
    public PythonIntroCodingCourseHome(Course course, String courseName) {
        super(course, courseName);
    }

    @Override
    public void write() {
        writeStart();
        writeMaintainer();
        writeNavigationIntro();
        writeSyllabus();
        writeConcepts();
        writeExpectations();
    }
    
    public void writeConcepts() {
        writeProgrammingConcepts();
        writeObjectOrientedProgrammingConcepts();
        pythonProgrammingConcepts();
    }
    
    public void pythonProgrammingConcepts() {
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
        w.add("<li>"
                + index.getReference("Python docstring", "docstrings")
                + ";</li>");
//        w.add("<li>Producing documentation using "
//                + references.getReference("https://docs.python.org/3/library/pydosite.html",
//                        "Pydoc", null)
//                + " and "
//                + references.getReference("https://www.sphinx-dosite.org/", "Sphinx", null)
//                + ";</li>");
        w.add("</ul>");
    }
    
    @Override
    public void writeExpectations() {
        super.writeExpectations();
        writeExpectations0();
        writeExpectations1();
        writeExpectations2();
        writeExpectationsN();
    }
    
    public void writeExpectations2() {       
        w.add("<li>Python containers including "
                + index.getReference("Python list", "lists")
                + ", "
                + index.getReference("Python tuple", "tuples")
                + " and "
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

        writeLearningJourney();
    }
    
    public void writeExpectations1() {
        w.add("<li>Python containers including "
                + index.getReference("Python list", "lists")
                + ", "
                + index.getReference("Python tuple", "tuples")
                + " and "
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
        w.add("<li>Developing a "
                + index.getReference("GUI", "Graphical User Interface")
                + " (GUI);</li>");
        w.add("<li>Developing and visualising a basic spatial "
                + index.getReference("ABM", "Agent Based Model")
                + " (ABM);</li>");
        w.add("<p>You get to review and try some example code that automates "
                + references.getReference("QGIS")
                + " Desktop using "
                + index.getReference("PyQGIS")
                + ".</p>");
    }
    
    @Override
    public void writeLearningJourney() {
        writeLearningJourney0();
        writeLearningJourney1();
        writeLearningJourney2();
        writeLearningJourneyN();
    }
    
    public void writeLearningJourney1() {
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
              """);
        }
    
    public void writeLearningJourney2() {
        w.add("<p>Do not expect to master "
                + index.getReference(getCourse().courseType)
                + " by the end of this course. Usually this takes many thousands"
                + " of hours of practice over several years.</p>");
    }
}
