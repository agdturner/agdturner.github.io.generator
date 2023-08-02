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

import io.github.agdturner.core.SectionID;
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
     */
    public PythonIntroCodingCourseHome(Course course) {
        super(course);
    }

    @Override
    public void getIntroduction(StringBuilder sb) {
        SectionID sid = getIntroduction0(sb);
        getMaintainer(sb, sid);
        getNavigation(sb, sid);
        getIntroductionN(sb, sid);
    }

    @Override
    public void getSyllabus(StringBuilder sb) {
        SectionID sid = getSyllabus0(sb);
        getSyllabusProgrammingStart(sb, sid);
        getSyllabusObjectOrientation(sb, sid);
        getSyllabusProgrammingEnd(sb, sid);
        getSyllabusOrganisational(sb, sid);
        getSyllabusProgrammingPython(sb, sid);
        getSyllabusN(sb, sid);
    }

    public void getSyllabusProgrammingPython(StringBuilder sb, SectionID sid) {
        sb.append("<p>").append(index.getReference("Python"))
                .append(" language development and limitations.</p>\n");
        sb.append("<p>The ")
                .append(index.getReference("Python"))
                .append(" ")
                .append(index.getReference("REPL", "Read Evaluate Print Loop"))
                .append(" (REPL) environment.</p>\n");
        sb.append("<p>Running ")
                .append(index.getReference("Python"))
                .append(" programs via the command line.</p>\n");
        sb.append("<p>Using ")
                .append(references.getReference("Jupyter Notebook"))
                .append(".</p>\n");
        sb.append("<p>Using ")
                .append(references.getReference("IDLE"))
                .append(" and ")
                .append(references.getReference("Spyder"))
                .append(".</p>\n");
        sb.append("<p>")
                .append(index.getReference("Python"))
                .append(" containers including; ")
                .append(index.getReference("Python list", "lists"))
                .append(", ")
                .append(index.getReference("Python tuple", "tuples"))
                .append(" and ")
                .append(index.getReference("Python dict", "dictionaries"))
                .append(".</p>\n");

        sb.append("<p>")
                .append(index.getReference("Python docstring"))
                .append(" syntax.</p>\n");
//        sb.append("<p>Producing documentation using ")
//                .append(references.getReference(
//                        PythonIndex.PYTHON_DOCS_URL + "/library/pydoc.html",
//                        "Pydoc"))
//                .append(" and ")
//                .append(references.getReference(
//                        "https://www.sphinx-dosite.org/", "Sphinx"))
//                .append(".</p>\n");
        sb.append("<p> ")
                .append(index.getReference("Python"))
                .append(" program input and output.</p>\n");
        sb.append("<p>Structuring and organising ")
                .append(index.getReference("Python"))
                .append(" code into ")
                .append(references.getReference(
                        "Python 3 Documentation: Tutorial: Classes", "Classes"))
                .append(", ")
                .append(references.getReference(
                        "Python 3 Documentation: Tutorial: Modules", "Modules"))
                .append(", and ")
                .append(references.getReference(
                        "Python 3 Documentation: Tutorial: Packages",
                        "Packages"))
                .append(".</p>\n");
        sb.append("<p>")
                .append(index.getReference("Python"))
                .append(" environment management using ")
                .append(references.getReference("Conda"))
                .append(" and ")
                .append(index.getReference("Python venv", "venv"))
                .append(".</p>\n");
        sb.append("<p>Using the ")
                .append(references.getReference(
                        "Python 3 Documentation: Library",
                        "Python 3 Library"))
                .append(".</p>\n");
        sb.append("<p>Using third party packages available via the ")
                .append(index.getReference("Python Package Index"))
                .append(".</p>\n");
    }

    @Override
    public void getExpectations(StringBuilder sb) {
        SectionID sid = getExpectations0(sb);
        getExpectations1(sb, sid);
        getExpectations2(sb, sid);
        getExpectationsN(sb, sid);
    }

    @Override
    public void getExpectations1(StringBuilder sb, SectionID sid) {
        sb.append("<li>Visualisation using ")
                .append(references.getReference("Matplotlib"))
                .append("</li>\n");
        sb.append("<li>Processing raster data stored as lists of lists</li>\n");
        sb.append("<li>Developing a ")
                .append(index.getReference("GUI", "Graphical User Interface"))
                .append(" (GUI)</li>\n");
        sb.append("<li>Developing and visualising a basic spatial ")
                .append(index.getReference("ABM", "Agent Based Model"))
                .append(" (ABM)</li>\n");
        sb.append("<!--<li>Some python parts of the ")
                .append(references.getReference("Anaconda"))
                .append(" data science platform</li>\n");
        sb.append("<li>Processing geographical features (geometry and related)")
                .append(" attribute) data;</li>\n-->");
        sb.append("</ul>\n");
    }

    public void getExpectations2(StringBuilder sb, SectionID sid) {
        sb.append("<p>Computer programming mostly involves computational")
                .append(" thinking, planning, problem solving and testing. It")
                .append(" is often helpful to break a task into smaller")
                .append(" subtasks, and gradually develop an implementation.")
                .append(" Often good solutions to coding tasks involve doing")
                .append(" things repeatedly for a given sequence of things.")
                .append("</p>\n");
        sb.append("<!--<p>Often it is helpful to use a framework for testing")
                .append(" from the outset and to test often as the code")
                .append(" develops.</p>-->\n");
        sb.append("<p>If you are new to computer programming, there is quite")
                .append(" a lot of terminology to get used to, some is generic")
                .append(" to programming, some is specific to ")
                .append(index.getReference("Python"))
                .append(".</p>\n");
    }
    
    public void getExpectations3(StringBuilder sb, SectionID sid) {
        sb.append("<p>There are some key concepts which may take a few")
                .append(" attempts to get used to and comprehensively")
                .append(" understand.</p>\n");
    }

    @Override
    public void getLearningJourney(StringBuilder sb) {
        SectionID sid = getLearningJourney0(sb);
        getLearningJourney1(sb, sid);
        getLearningJourney2(sb, sid);
        getLearningJourneyN(sb, sid);
    }

    public void getLearningJourney1(StringBuilder sb, SectionID sid) {
        sb.append("<p>The webpages with names starting 'ABM' are a sequence")
                .append(" of practicals that progress the development of a")
                .append(" basic spatial ")
                .append(index.getReference("ABM", "Agent Based Model"))
                .append(". The ABM is a simple digital simulation model of")
                .append(" semi-autonomous spatial entities that move in an")
                .append(" environment, interacting with the environment and")
                .append(" each other.</p>\n");
        sb.append("<p>Developing the ABM by following instructions puts into")
                .append(" practise some of the theory encountered. By the end")
                .append(" of the practicals, you should have ABM model code")
                .append(" that has a basic ")
                .append(index.getReference("GUI"))
                .append(", reads in data from local files and from the Web,")
                .append(" and produces an animation, data files and user")
                .append(" friendly messages.</p>\n");
        sb.append("<p>The aim is that after completing the last ABM practical,")
                .append(" you will have sufficient knowledge and skill to")
                .append(" develop the model in interesting ways without being ")
                .append(" given detailed instructions.</p>\n");
    }

    public void getLearningJourney2(StringBuilder sb, SectionID sid) {
        super.getLearningJourneyN(sb, sid);
        sb.append("<p>Do not expect to master ")
                .append(index.getReference(getCourse().courseType))
                .append(" by the end of this course. Usually this takes many")
                .append(" thousands of hours of practice over several years.")
                .append("</p>\n");
    }

    @Override
    public void getPlatform(StringBuilder sb) {
        SectionID sid = getPlatform0(sb);
        getPlatformN(sb, sid);
    }
}
