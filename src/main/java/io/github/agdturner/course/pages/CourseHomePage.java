/*
 * Copyright 2023 Centre for Computational Geography.
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
package io.github.agdturner.course.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.CoursePage;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.Index;
import io.github.agdturner.course.References;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Extend this for a Home Page.
 *
 * @author Andy Turner
 */
public abstract class CourseHomePage extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     * @param courseName What {@link #name} is set to.
     */
    public CourseHomePage(Course course, String courseName) {
        super(course, "home", course.getCourseCode() + ": " + courseName, 
                "Home");
    }
    
    /**
     * Initialise the header, h1, and start of the introduction.
     */
    public void writeStart() {
        writeHeader();
        writeH1();
        SectionID sid = addSection("1", "Introduction", 2);
        w.add("""
              <p>Welcome to the course website!</p>
              """);
    }

    /**
     * Default webmaster details - who maintains the site and how to contact 
     * them. 
     */
    public void writeMaintainer() {
        w.add("<p>The website is maintained by "
                + Web_ContentWriter.getLink(
                        "https://arc.leeds.ac.uk/",
                        "Research Computing Leeds")
                + " and comprises a set of webpages and file based resources."
                + "</p>");
        w.add("<p>Please "
                + Web_ContentWriter.getLink(
                        "https://it.leeds.ac.uk/it?id=sc_cat_item&sys_id=7587b2530f675f00a82247ece1050eda",
                        "contact us")
                + " if you want help, clarification or there is a problem with"
                + "these resources.</p>");
    }

    /**
     * Explanation about navigation of the site.
     */
    public void writeNavigationIntro() {
        w.add("""
              <p>At the top of each web page is a button that can be actioned to 
              change between a lighter and darker page style. Below that is a 
              navigation section that links to each page. The pages are 
              sequential and at the end of each page, there is a link to the 
              next page.</p>
              <p>There are index and references pages at the end. The index page 
              contains definitions for some terms and so is also a bit like a 
              glossary. As well, it links back to particular sections of other 
              pages that are relevant.</p>
              <p>Essentially, taking the course involves working your way 
              through the web pages trying out code and undertaking practical 
              exercises as directed.</p>
              """);
    }

    public void writeSyllabus() {
        SectionID sid = addSection("2", "Syllabus", 2);
    }

    public void writeExpectations() {
        Course course = getCourse();
        Index index = course.getIndex();
        References references = course.getReferences();
        SectionID sid = addSection("3", "Expectations", 2);
        w.add("""
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
    }

    public void writeLearningJourney() {
        Course course = getCourse();
        Index index = course.getIndex();
        SectionID sid = addSection("4", "The Learning Journey", 2);
        w.add("""
              <p>Develop your understanding through practise and by reading.</p>
              <p>Be experimental - test your understanding by testing code does 
              what you expect it to. If code does not do what you expect, try to
              understand why - regard failure and errors as a learning 
              opportunity!</p>
              <p>One of the keys to coding is learning to be able to interpret 
              errors messages and understand what caused them. If a program you 
              are developing unexpectedly raises an exception and reports an 
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
              """);
    }

    public void writePlatform() {
        Course course = getCourse();
        Index index = course.getIndex();
        References references = course.getReferences();
        SectionID sid = addSection("5", "Platform/Software", 2);
        w.add("""
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
        w.add("</div>");
    }
}
