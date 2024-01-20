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

import io.github.agdturner.core.Environment;
import io.github.agdturner.core.SectionID;
import io.github.agdturner.core.Strings;
import io.github.agdturner.course.CoursePage;
import io.github.agdturner.course.Course;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Course Home Page.
 *
 * @author Andy Turner
 */
public abstract class CourseHome extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public CourseHome(Course course) {
        super(course, "home",
                course.getCourseCode() + ": " + course.courseName,
                "Home");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        getIntroduction(sb);
        getSyllabus(sb);
        getLearningJourney(sb);
        getPlatform(sb);
        return sb.toString();
    }

    /**
     * Introduction.
     *
     * @param sb The StringBuilder to append to.
     */
    public abstract void getIntroduction(StringBuilder sb);

    /**
     * Introduction 0.
     *
     * @param sb The StringBuilder to append to.
     * @return SectionID for indexing terms.
     */
    public SectionID getIntroduction0(StringBuilder sb) {
        w.addDIVST(sb);
        SectionID sid = addSection("Introduction", sb);
        w.addPST(sb, """
                     This is a course to help researchers develop software in \
                     the
                     """);
        sb.append(index.getReference(getCourse().courseTypeCaptialised));
        sb.append(" programming language that can take advantage of ");        
        sb.append(index.getReference("High Performance Computing"));
        sb.append("""
                   (HPC) resources. It assumes no knowledge of computer \
                  programming (coding) and is a precursor to a Level 1 course \
                  that focuses more on \
                  """);
        sb.append(index.getReference("profiling"));
        sb.append(", ");
        sb.append(index.getReference("parallelisation")).append(", ");
        sb.append(index.getReference("multithreading")).append(", ");
        sb.append(index.getReference("multiprocessing")).append(", ");
        sb.append(index.getReference("distributed computing"));
        w.addPET(sb, ", and running programs on HPC resources.");
        return sid;
    }

    /**
     * Maintainer.
     *
     * @param sb The StringBuilder to append to.
     * @param sid For indexing terms.
     */
    public void getMaintainer(StringBuilder sb, SectionID sid) {
//        w.addPST(sb, "The ");
//        sb.append(Web_ContentWriter.getLink(
//                Environment.getWikipediaURL("HTML"), "HTML"));
//        sb.append(", ");
//        sb.append(Web_ContentWriter.getLink(
//                Environment.getWikipediaURL("CSS"), "CSS"));
//        sb.append(", ");
//        sb.append(Web_ContentWriter.getLink(
//                Environment.getWikipediaURL("JavaScript"), "JavaScript"));
//        sb.append(", image, and data files are maintained by ");
        w.addPST(sb, "The website is maintained by ");
        sb.append(Web_ContentWriter.getLink(
                Environment.HTTPS_AGDTURNER_GITHUB_IO,
                "Andy Turner"));
        sb.append(". ");
        sb.append(Web_ContentWriter.getLink(
                Environment.AGDTURNER_GITHUB_IO_REPO + "/" 
                        + getCourse().courseCode + "/public_html",
                "Please report issues and suggest improvements here"));
        w.addPET(sb, ".");
    }

    /**
     * Navigation.
     *
     * @param sb The StringBuilder to append to.
     * @param sid For indexing terms.
     */
    public void getNavigation(StringBuilder sb, SectionID sid) {
        w.addPST(sb, """
                     Up top of each page is a button to change between a \
                     lighter and darker page style, and a navigation section \
                     that links to other pages. The \
                     """);
        sb.append(getLink(index, "index", "link", ""));
        sb.append(
                """
                 page is a glossary of terms that links back to sections where \
                specific terms are used. The \
                """);
        sb.append(getLink(references, "references", "link", ""));
        w.addPET(sb,
                """
                 page is a useful list of references and links to other \
                resources. Pages with multiple sections have a contents \
                towards the top linking to sections within the page.
                """);
//        w.addP(sb,
//                """
//                To get the most from the learning resources, work your way 
//                through the pages and undertake practical exercises as directed.
//                """);
    }

    /**
     * Introduction N.
     *
     * @param sb The StringBuilder to append to.
     * @param sid For indexing terms.
     */
    public void getIntroductionN(StringBuilder sb, SectionID sid) {
        w.addDIVET(sb);
    }

    /**
     * For detailing the syllabus.
     *
     * @param sb The StringBuilder to append to.
     */
    public abstract void getSyllabus(StringBuilder sb);

    /**
     * For detailing the first part of the syllabus.
     *
     * @param sb The StringBuilder to append to.
     * @return SectionID for indexing terms.
     */
    public SectionID getSyllabus0(StringBuilder sb) {
        w.addDIVST(sb);
        SectionID sid = addSection("Syllabus", sb);
        return sid;
    }

    /**
     * For detailing the last part of the syllabus.
     *
     * @param sb The StringBuilder to append to.
     * @param sid For indexing terms.
     */
    public void getSyllabusN(StringBuilder sb, SectionID sid) {
        w.addDIVET(sb);
    }

    /**
     * For detailing the learning journey.
     *
     * @param sb The StringBuilder to append to.
     */
    public abstract void getLearningJourney(StringBuilder sb);

    /**
     * For detailing the first part of the learning journey section.
     *
     * @param sb The StringBuilder to append to.
     * @return SectionID for indexing terms.
     */
    public SectionID getLearningJourney0(StringBuilder sb) {
        w.addDIVST(sb);
        SectionID sid = addSection("The Learning Journey", sb);
        
        w.addPST(sb, 
                """
                Computer programming involves computational thinking, \
                planning, problem solving and testing. It is often helpful to \
                break a task into smaller subtasks, and gradually develop an \
                implementation. Often good solutions to coding tasks involve \
                doing things repeatedly for a given sequence of things. If you \
                are new to computer programming, there is quite a lot of \
                terminology to get used to, some is generic to programming, \
                some is specific to \
                """);
        sb.append(index.getReference(getCourse().courseTypeCaptialised));
        w.addPET(sb, 
                """
                . There are some key concepts which may take a few attempts to \
                get used to and comprehensively understand. Develop your \
                understanding through practise and by reading.
                """);
        
        w.addP(sb, 
                """
                A key to coding is interpretting error messages, understanding \
                why they occur and thinking about how to handle errors.
                """);
        
        w.addP(sb, 
                "Be cautious and only run code you trust.");
        
        w.addPST(sb,
                """
                Pages with names starting 'Prac' are a sequence of \
                practicals that progress the development of a basic spatial \
                """);
        sb.append(index.getReference("ABM", "Agent Based Model"));
        w.addPET(sb,
                """
                - a simple digital simulation model of semi-autonomous spatial \
                entities that move in an environment, interacting with the \
                environment and each other. Developing the code by following \
                instructions puts into practise some of the theory. By the end \
                of the practicals, you should have code that reads in data \
                from local files and from the Web, and produces an animation, \
                data files and user friendly messages. After completing the \
                last practical, you will hopefully have sufficient knowledge, \
                skills and ideas to develop the model in interesting ways \
                without further detailed instructions.
                """);
        return sid;
    }

    /**
     * For detailing the last part of the learning journey section.
     *
     * @param sb The StringBuilder to append to.
     * @param sid For indexing terms.
     */
    public void getLearningJourneyN(StringBuilder sb, SectionID sid) {
//        w.addPST(sb, "Enjoy the learning journey and look after yourself!");
        w.addDIVET(sb);
    }

    /**
     * For detailing the platform section.
     *
     * @param sb The StringBuilder to append to.
     */
    public abstract void getPlatform(StringBuilder sb);

    /**
     * For detailing the first part of the platform section.
     *
     * @param sb The StringBuilder to append to.
     * @return SectionID for indexing terms.
     */
    public SectionID getPlatform0(StringBuilder sb) {
        SectionID sid = addSection("Platform/Software", sb);
        w.addPST(sb, "All the software used in this course is ");
        sb.append(index.getReference("Free and Open Source Software"));
        sb.append(" (FOSS) - available to download and install on ");
        sb.append(index.getReference("Linux"));
        sb.append(", ");
        sb.append(index.getReference("Microsoft Windows"));
        sb.append(", and ");
        sb.append(index.getReference("MacOS"));
        w.addPET(sb, ".");
        return sid;
    }

    /**
     * For detailing the last part of the platform section.
     *
     * @param sb The StringBuilder to append to.
     * @param sid For indexing terms.
     */
    public void getPlatformN(StringBuilder sb, SectionID sid) {
        w.addDIVET(sb);
    }

    /**
     * @return {@code (Course) site).
     */
    @Override
    public Course getCourse() {
        return (Course) site;
    }
}
