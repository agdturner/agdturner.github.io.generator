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
import io.github.agdturner.core.Strings;
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
        addParagraph(sb, "");
        sb.append(index.getReference("Python"));
        addParagraphEnd(sb, " language development and limitations.");
        addParagraphStart(sb, "The ");
        sb.append(index.getReference("Python"));
        sb.append(" ");
        sb.append(index.getReference("REPL", "Read Evaluate Print Loop"));
        addParagraphEnd(sb, " (REPL) environment.");
        addParagraphStart(sb, "Running ");
        sb.append(index.getReference("Python"));
        addParagraphEnd(sb, " programs via the command line.");
        addParagraphStart(sb, "Using ");
        sb.append(references.getReference("Jupyter Notebook"));
        addParagraphEnd(sb, ".");
        addParagraphStart(sb, "Using ");
        sb.append(references.getReference("IDLE"));
        sb.append(" and ");
        sb.append(references.getReference("Spyder"));
        addParagraphEnd(sb, ".");
        addParagraphStart(sb, "");
        sb.append(index.getReference("Python"));
        sb.append(" containers including; ");
        sb.append(index.getReference("Python list", "lists"));
        sb.append(", ");
        sb.append(index.getReference("Python tuple", "tuples"));
        sb.append(" and ");
        sb.append(index.getReference("Python dict", "dictionaries"));
        addParagraphEnd(sb, ".");
        addParagraphStart(sb, "");
        sb.append(index.getReference("Python docstring"));
        addParagraphEnd(sb, " syntax.");
//        sb.append("<p>Producing documentation using ")
//                .append(references.getReference(
//                        PythonIndex.PYTHON_DOCS_URL + "/library/pydoc.html",
//                        "Pydoc"))
//                .append(" and ")
//                .append(references.getReference(
//                        "https://www.sphinx-dosite.org/", "Sphinx"))
//                .append(".</p>\n");
        addParagraphStart(sb, "");
        sb.append(index.getReference("Python"));
        addParagraphEnd(sb, " program input and output.");
        addParagraphStart(sb, "Structuring and organising ");
        sb.append(index.getReference("Python"));
        sb.append(" code into ");
        sb.append(index.getReference("Python classes", "Classes"));
        sb.append(", ");
        sb.append(index.getReference("Python modules", "Modules"));
        sb.append(", and ");
        sb.append(index.getReference("Python packages", "Packages"));
        addParagraphEnd(sb, ".");
        addParagraphStart(sb, "");
        sb.append(index.getReference("Python"));
        sb.append(" environment management using ");
        sb.append(references.getReference("Conda"));
        sb.append(" and ");
        sb.append(index.getReference("Python venv", "venv"));
        addParagraphEnd(sb, ".");
        addParagraphStart(sb, "Using the ");
        sb.append(references.getReference("Python 3 Documentation: Library",
                "Python 3 Library"));
        addParagraphEnd(sb, ".");
        addParagraphStart(sb, "Using third party packages available via the ");
        sb.append(index.getReference("Python Package Index"));
        addParagraphEnd(sb, ".");
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
        addLIStart(sb, "Visualisation using ");
        sb.append(references.getReference("Matplotlib"));
        addLIEnd(sb, "");
        addLI(sb, "Processing raster data stored as lists of lists");
        addLIStart(sb, "Developing a ");
        sb.append(index.getReference("GUI", "Graphical User Interface"));
        addLIEnd(sb, " (GUI)");
        addLIStart(sb, "Developing and visualising a basic spatial ");
        sb.append(index.getReference("ABM", "Agent Based Model"));
        addLIEnd(sb, " (ABM)");
        sb.append(Strings.UL_END);
    }

    public void getExpectations2(StringBuilder sb, SectionID sid) {
        addParagraph(sb, 
                """
                Computer programming mostly involves computational thinking,
                planning, problem solving and testing. It is often helpful to
                break a task into smaller subtasks, and gradually develop an
                implementation. Often good solutions to coding tasks involve
                doing things repeatedly for a given sequence of things.
                """);
        addParagraphStart(sb, 
                """
                If you are new to computer programming, there is quite a lot of
                terminology to get used to, some is generic to programming, some
                is specific to
                """);
        sb.append(index.getReference("Python"));
        addParagraphEnd(sb, ".");
    }

    public void getExpectations3(StringBuilder sb, SectionID sid) {
        addParagraphStart(sb, 
                """
                There are some key concepts which may take a few attempts to get
                used to and comprehensively understand.
                """);
    }

    @Override
    public void getLearningJourney(StringBuilder sb) {
        SectionID sid = getLearningJourney0(sb);
        getLearningJourney1(sb, sid);
        getLearningJourney2(sb, sid);
        getLearningJourneyN(sb, sid);
    }

    public void getLearningJourney1(StringBuilder sb, SectionID sid) {
        addParagraphStart(sb, 
                """
                The webpages with names starting 'ABM' are a sequence of
                practicals that progress the development of a basic spatial
                """);
        sb.append(index.getReference("ABM", "Agent Based Model"));
        addParagraphEnd(sb, 
                """
                . The ABM is a simple digital simulation model of
                semi-autonomous spatial entities that move in an environment,
                 interacting with the environment and each other.
                """);
        addParagraphStart(sb, 
                """
                Developing the ABM by following instructions puts into practise
                some of the theory encountered. By the end of the practicals,
                you should have ABM model code that has a basic
                """);
        sb.append(index.getReference("GUI"));
        addParagraphEnd(sb,
                """
                , reads in data from local files and from the Web, and produces
                an animation, data files and user friendly messages.
                """);
        addParagraph(sb,
                """
                The aim is that after completing the last ABM practical, you
                will have sufficient knowledge and skill to develop the model in
                interesting ways without being given detailed instructions.
                """);
    }

    public void getLearningJourney2(StringBuilder sb, SectionID sid) {
        addParagraphStart(sb, "Do not expect to master ");
        sb.append(index.getReference(getCourse().courseType));
        addParagraphEnd(sb, 
                """
                by the end of this course. Usually this takes many thousands of
                hours of practice over several years.
                """);
    }

    @Override
    public void getPlatform(StringBuilder sb) {
        SectionID sid = getPlatform0(sb);
        getPlatformN(sb, sid);
    }
}