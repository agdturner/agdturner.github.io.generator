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
package io.github.agdturner.course.coding.intro.java.pages;

import io.github.agdturner.course.Course;
import io.github.agdturner.course.coding.intro.pages.IntroCodingCourseHome;

/**
 * Java Intro Coding Course Home Page.
 *
 * @author Andy Turner
 */
public class JavaIntroCodingCourseHome extends IntroCodingCourseHome {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     * @param courseName What {@link #name} is set to.
     */
    public JavaIntroCodingCourseHome(Course course, String courseName) {
        super(course, courseName);
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        getStart(sb);
        getMaintainer(sb);
        getNavigationIntro(sb);
        getSyllabus(sb);
        return sb.toString();
    }
        
    @Override
    public void getSyllabus(StringBuilder sb) {
        super.getSyllabus(sb);
        sb.append("<p>"
                + index.getReference("Java")
                + " specifics:</p>");
        sb.append("<ul>");
        sb.append("<li>Language development and limitations;</li>");
        sb.append("<li>Structuring and organising code into "
                + index.getReference("Java Class", "Java Classes")
                + ", "
                + index.getReference("Java Package", "Packages")
                + ", and "
                + index.getReference("Java Platform Module System",
                        "Modules")
                + ";</li>");
        /*
        sb.append("<li>Using the "
                + index.getReference("REPL", "Read Evaluate Print Loop")
                + " (REPL) environment;</li>");
        sb.append("<li>Running programs via the command line;</li>");
        sb.append("<li>Using third party libraries;</li>");
        sb.append("<li>Creating Javadoc documentation;</li>");
        sb.append("<li>Testing code.</li>");
        sb.append("</ul>");
        sb.append("""
              <h2 id="3">3. Expectations</h2>
              <p>You will learn about:</p>
              <ul>
              """);
//        sb.append("<li>"
//                + c.index.getReference("Version Control")
//                + ";</li>");
        sb.append("<li>Data encoding and "
                + index.getReference("File Format", "file formats")
                + ";</li>");
        sb.append("<li>Java collections:"
                + index.getReference("Java ArrayList", "ArrayList")
                + ", "
                + index.getReference("Java Set", "Set")
                + "and "
                + index.getReference("Java Map", "Map")
                + ";</li>");
        sb.append("""
              <li>Program input and output</li>
              <!--
              <li>Developing Python code (planning, writing, testing, 
              organising)</li>
              """);
        sb.append("<li>Visualisation;</li>");
        sb.append("<li>Using "
                + course.references.getReference("GitHub")
                + ";</li>");
        sb.append("<li>Developing a "
                + index.getReference("GUI", "Graphical User Interface")
                + " (GUI);</li>");
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
        sb.append("<p>An example of automating "
                + course.references.getReference("QGIS")
                + " Desktop using "
                + index.getReference("PyQGIS")
                + " is provided.</p>");

        sb.append("""
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
        sb.append("<p>The webpages with names starting 'ABM' are a sequence of "
                + "practicals that progress the development of a basic spatial "
                + index.getReference("ABM", "Agent Based Model")
                + ". The ABM can be regarded as a simple model of autonomous"
                + " spatial entities that move in an environment, interacting"
                + " with the environment and each other.</p>");
        sb.append("<p>Developing the ABM by following instructions puts into"
                + " practise some of the theory detailed in other webpages. By"
                + " the end of these practicals, you should have ABM model code"
                + " that:</p>");
        sb.append("<ul>");
        sb.append("<li>has a basic "
                + index.getReference("GUI")
                + ";</li>");
        sb.append("""
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
        sb.append("<p>Do not expect to master "
              + index.getReference("Python")
              + " by the end of this course. Usually this takes many thousands"
              + " of hours of practice over several years.</p>");
        sb.append("""
              <p>Try to enjoy the learning journey, the challenges and the 
              rewards. Learning to program and learning Python is empowering!
              </p>
              
              <h2 id="5">5. Platform/Software</h2>
              <p>All the software used in this course is 
              """);
        sb.append(index.getReference("Free and Open Source Software",
                "Free and Open Source Software")
                + " (FOSS) - available to download and install on "
                + index.getReference("Linux")
                + ", "
                + index.getReference("Microsoft Windows")
                + ", and "
                + index.getReference("MacOS")
                + ".<p>");
        sb.append("<p>The software is available via 'AppsAnywhere' at the "
                + "University of Leeds which is accessible remotely via the "
                + "'Academic' <a href=\"https://wvd.leeds.ac.uk\">"
                + "University Windows Virtual Desktop</a>. The software "
                + "includes: "
                + course.references.getReference("Anaconda")
                + " - a data science platform, "
                + course.references.getReference("QGIS")
                + " Desktop - Geographical Information System software, and "
                + "various third party Python packages.</p>");
        */
        sb.append("</div>");
    }
}
