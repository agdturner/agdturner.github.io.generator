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
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        getStart(sb);
        getMaintainer(sb);
        getNavigationIntro(sb);
        getSyllabus(sb);
        getConcepts(sb);
        getExpectations(sb);
        return sb.toString();
    }
    
    public void getConcepts(StringBuilder sb) {
        getProgrammingConcepts(sb);
        getOrganisationalConcepts(sb);
        getObjectOrientedProgrammingConcepts(sb);
        getGUIProgrammingConcepts(sb);
        getPythonProgrammingConcepts(sb);
    }
    
    public void getPythonProgrammingConcepts(StringBuilder sb) {
        sb.append("<p>"
                + index.getReference("Python")
                + " Language development and limitations</p>");
        sb.append("<p>The "
                + index.getReference("Python")
                + " "
                + index.getReference("REPL", "Read Evaluate Print Loop")
                + " (REPL) environment</p>");
        sb.append("<p>Running "
                + index.getReference("Python")
                + " programs via the command line</p>");
        sb.append("<p>Using "
                + references.getReference("Jupyter Notebook")
                + "</p>");
        sb.append("<p>Using "
                + references.getReference("IDLE")
                + " and "
                + references.getReference("Spyder")
                + "</p>");
        sb.append("<p>"
                + index.getReference("Python")
                + " containers including; "
                + index.getReference("Python list", "lists")
                + ", "
                + index.getReference("Python tuple", "tuples")
                + " and "
                + index.getReference("Python dict", "dictionaries")
                + "</p>");
        sb.append("<p> "
                + index.getReference("Python")
                + " program input and output</p>");
        sb.append("<p>Structuring and organising "
                + index.getReference("Python")
                + " code into "
                + references.getReference(
                        "Python 3 Documentation: Tutorial: Classes", "Classes")
                + ", "
                + references.getReference(
                        "Python 3 Documentation: Tutorial: Modules", "Modules")
                + ", and "
                + references.getReference(
                        "Python 3 Documentation: Tutorial: Packages",
                        "Packages")
                + "</p>");
        sb.append("<p>"
                + index.getReference("Python")
                + " environment management using "
                + references.getReference("Conda")
                + " and "
                + index.getReference("Python venv", "venv")
                + "</p>");
        sb.append("<p>Using the "
                + references.getReference("Python 3 Documentation: Library",
                        "Python 3 Library")
                + "</p>");
        sb.append("<p>Using third party packages available via the "
                + index.getReference("Python Package Index")
                + "</p>");
        sb.append("<p>"
                + index.getReference("Python docstring")
                + " syntax</p>");
//        sb.append("<p>Producing documentation using "
//                + references.getReference("https://docs.python.org/3/library/pydoc.html",
//                        "Pydoc", null)
//                + " and "
//                + references.getReference("https://www.sphinx-dosite.org/", "Sphinx", null)
//                + "</p>");
    }
    
    @Override
    public void getExpectations(StringBuilder sb) {
        super.getExpectations(sb);
        getExpectations0(sb);
        getExpectations1(sb);
        getExpectations2(sb);
        getExpectationsN(sb);
    }
    
    public void getExpectations2(StringBuilder sb) {       
        sb.append("<!--<li>Python parts of the "
                + references.getReference("Anaconda")
                + " data science platform;</li>");
        sb.append("<li>Processing geographical features (geometry and related"
                + " attribute) data;</li>-->");
        sb.append("<li>Visualisation using "
                + references.getReference("Matplotlib")
                + "</li>");
        sb.append("<li>Processing raster data stored as lists of lists</li>");
        sb.append("<li>Developing and visualising a basic spatial "
                + index.getReference("ABM", "Agent Based Model")
                + " (ABM);</li>");
        sb.append("""
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
        sb.append("<p>If you are new to computer programming, there is quite a lot "
                + "of terminology to get used to, some is generic to "
                + "programming, some is specific to "
                + index.getReference("Python")
                + ".</p>");
        sb.append("""
              <p>There are some key concepts which may take a few attempts to 
              get used to and comprehensively understand.</p>
              """);
        sb.append("<p>You get to review some exemplar code that automates some "
                + references.getReference("QGIS")
                + " Desktop processing using "
                + index.getReference("PyQGIS")
                + "</p>");
        getLearningJourney(sb);
    }
    
    public void getExpectations1(StringBuilder sb) {
        sb.append("<li>Python containers including "
                + index.getReference("Python list", "lists")
                + ", "
                + index.getReference("Python tuple", "tuples")
                + " and "
                + index.getReference("Python dict", "dictionaries")
                + ";</li>");
        sb.append("""
              <li>Program input and output</li>
              <!--
              <li>Developing Python code (planning, writing, testing, 
              organising)</li>
              """);
        sb.append("<li>The Python parts of the "
                + references.getReference("Anaconda")
                + " data science platform;</li>");
        sb.append("<li>Processing geographical features (geometry and related"
                + " attribute) data;</li>-->");
        sb.append("<li>Visualisation using "
                + references.getReference("Matplotlib")
                + ";</li>");
        sb.append("<li>Processing raster data stored as lists of lists;</li>");
        sb.append("<li>Developing a "
                + index.getReference("GUI", "Graphical User Interface")
                + " (GUI);</li>");
        sb.append("<li>Developing and visualising a basic spatial "
                + index.getReference("ABM", "Agent Based Model")
                + " (ABM);</li>");
    }
    
    @Override
    public void getLearningJourney(StringBuilder sb) {
        getLearningJourney0(sb);
        getLearningJourney1(sb);
        getLearningJourney2(sb);
        getLearningJourneyN(sb);
    }
    
    public void getLearningJourney1(StringBuilder sb) {
        sb.append("<p>The webpages with names starting 'ABM' are a sequence of "
                + "practicals that progress the development of a basic spatial "
                + index.getReference("ABM", "Agent Based Model")
                + ". The ABM can be regarded as a simple model of autonomous"
                + " spatial entities that move in an environment, interacting"
                + " with the environment and each other.</p>");
        sb.append("<p>Developing the ABM by following instructions puts into"
                + " practise some of the theory detailed in other webpages. By"
                + " the end of these practicals, you should have ABM model code"
                + " that has a basic "
                + index.getReference("GUI")
                + ", reads in data from local files and from the Web, and"
                + " produces an animation, data files and user friendly "
                + "messages.</p>"
                + "<p>After completing the last ABM practical, you should have"
                + " sufficient knowledge and skill to develop the model in"
                + " interesting ways without being given detailed"
                + " instructions.</p>");
        }
    
    public void getLearningJourney2(StringBuilder sb) {
        sb.append("<p>Do not expect to master "
                + index.getReference(getCourse().courseType)
                + " by the end of this course. Usually this takes many thousands"
                + " of hours of practice over several years.</p>");
    }
}
