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
        w.addPST(sb, 
                """
                These learning resources are to help researchers develop \
                computational thinking and software development skills in the \
                """);
        sb.append(getLanguageReference());
        sb.append(
                """
                 programming language. It is a beginner level course and \
                assumes no computer programming knowledge.
                """);
        return sid;
    }

    public void getIntroduction1(StringBuilder sb) {
        sb.append(" which considers ");
        sb.append(index.getReference("parallelisation")).append(", ");
        sb.append(index.getReference("multithreading")).append(", ");
        sb.append(index.getReference("multiprocessing")).append(", ");
        sb.append(index.getReference("distributed computing"));
        sb.append(", and running programs on ");
        sb.append(index.getReference("High Performance Computing"));
        sb.append(" (HPC) resources.");
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
        w.addPST(sb, "The learning resources are maintained by ");
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
                     Each page of the website starts with a button to change \
                     between a lighter and darker page style, and a main \
                     navigation section that links to all other pages. The \
                     """);
        sb.append(getLink(index, "index", "link", ""));
        sb.append(
                """
                 page is a glossary of terms that links back page sections \
                where specific terms are used. The \
                """);
        sb.append(getLink(references, "references", "link", ""));
        w.addPET(sb,
                """
                 page provides a list of references and links to other \
                relevant resources. Pages with multiple sections have a \
                contents (below the main navigation section) linking to them.
                """);
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
                These learning resources focus on the basics. You will be \
                introduced to general computer programming terms, and terms \
                specific to \
                """);
        sb.append(index.getReference(getCourse().courseTypeCaptialised));
        w.addPET(sb, ".");
        
        
        w.addPST(sb,
                """
                Pages with names starting 'ABM' are a sequence of practicals \
                that help you learn to develop an \
                """);
        sb.append(index.getReference("ABM", "Agent Based Model"))
                .append(" a simple ")
                .append(index.getReference("simulation"))
                .append(" ")
                .append(index.getReference("model"))
                .append(
                """
                 that represents a set of entities that move around in an \
                environment, interacting with the environment and each other. \
                Developing the code by following instructions puts into \
                practise some of the theory introduced in other pages. By the \
                end of the practicals, you should have code that reads in data \
                from local files and from the \
                """)
                .append(index.getReference("Web"));
        
        w.addPET(sb,
                """
                 and produces an animation, data files, log files and messages \
                for the user. The aim is that, after completing the final \
                practical, you will have sufficient knowledge, skills and \
                ideas to develop the model in interesting ways to create more \
                reproducible results without further detailed instructions.
                """);
        
        w.addP(sb, 
                """
                Be experimental, but be cautious and recall your training on \
                the safe and secure use of computer systems.
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
