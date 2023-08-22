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
        getExpectations(sb);
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
        sb.append("<div>\n");
        SectionID sid = addSection("Introduction", sb);
        w.addPST(sb, 
                """
                This website is an open educational resource geared towards
                helping researchers at the University of Leeds start learning
                to program using the
                """);
        sb.append(index.getReference("Python"));
        w.addPET(sb, " programming language.");
        return sid;
    }

    /**
     * Maintainer.
     *
     * @param sb The StringBuilder to append to.
     * @param sid For indexing terms.
     */
    public void getMaintainer(StringBuilder sb, SectionID sid) {
        w.addPST(sb, "The website is maintained by the ");
        sb.append(Web_ContentWriter.getLink(
                Environment.HTTPS_ARC_LEEDS_AC_UK_ABOUT_TEAM,
                "Research Computing Team"));
        sb.append(" at the ");
        sb.append(Web_ContentWriter.getLink(Environment.HTTPS_WWW_LEEDS_AC_UK,
                "University of Leeds"));
        w.addPET(sb, ".");
        w.addPST(sb, "Please ");
        sb.append(Web_ContentWriter.getLink(Environment.GITHUB_REPO,
                "raise issues and submit pull requests on GitHub"));
        w.addPET(sb, ".");
    }

    /**
     * Navigation.
     *
     * @param sb The StringBuilder to append to.
     * @param sid For indexing terms.
     */
    public void getNavigation(StringBuilder sb, SectionID sid) {
        w.addP(sb,
                """
                Each web page has a button at the top to change between a
                lighter and darker page style, then a navigation section that
                links to the other pages. The pages are sequential and at the end of each webpage, there is a link to
                the next webpage.
                """);
        w.addPST(sb, "The ");
        sb.append(getLink(index, "index", "link", ""));
        w.addPET(sb,
                """
                 webpage is a glossary of terms that links back to webpage
                sections where terms are used.
                """);
        w.addPST(sb, "The ");
        sb.append(getLink(references, "references", "link", ""));
        w.addPET(sb,
                """
                 webpage is a useful list of references and links to other
                resources.
                """);
        w.addP(sb,
                """
                Webpages with multiple sections have a contents towards the top
                that links to those sections.
                """);
        w.addP(sb,
                """
                Essentially, taking the course involves working your way through
                these webpages and undertaking practical exercises as directed.
                """);
    }

    /**
     * Introduction N.
     *
     * @param sb The StringBuilder to append to.
     * @param sid For indexing terms.
     */
    public void getIntroductionN(StringBuilder sb, SectionID sid) {
        sb.append("</div>\n");
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
        sb.append("<div>\n");
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
        sb.append("</div>\n");
    }

    /**
     * For detailing the expectations.
     *
     * @param sb The StringBuilder to append to.
     */
    public abstract void getExpectations(StringBuilder sb);

    /**
     * For detailing the first part of the expectations.
     *
     * @param sb The StringBuilder to append to.
     * @return SectionID for indexing terms.
     */
    public SectionID getExpectations0(StringBuilder sb) {
        sb.append("<div>\n");
        SectionID sid = addSection("Expectations", sb);
        w.addP(sb, "You will learn about:");
        w.addULST(sb);
        return sid;
    }

    /**
     * For detailing the expectations.
     *
     * @param sb The StringBuilder to append to.
     * @param sid For indexing terms.
     */
    public abstract void getExpectations1(StringBuilder sb, SectionID sid);

    /**
     * For detailing the last part of the expectations.
     *
     * @param sb The StringBuilder to append to.
     * @param sid For indexing terms.
     */
    public void getExpectationsN(StringBuilder sb, SectionID sid) {
        w.addP(sb,
                """
                There are some key concepts which may take a few attempts to get
                used to and comprehensively understand.
                """);
        sb.append("</div>\n");
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
        sb.append("<div>\n");
        SectionID sid = addSection("The Learning Journey", sb);
        w.addP(sb,
                "Develop your understanding through practise and by reading.");
        w.addP(sb,
                """
                Be experimental - test your understanding by testing things do
                what you expect. If things do not do what you expect, try to
                understand why. An exception error fault or failure is also a
                learning opportunity!
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
        String courseName = getCourse().courseType;
        String courseNameUC = Strings.toUpperCaseFirstLetter(courseName);
        w.addPST(sb,
                """
                Try to enjoy the learning journey, the challenges and the
                rewards. Learning to program and learning
                """);
        sb.append(index.getReference(courseName, courseNameUC));
        w.addPET(sb, " is empowering!");
        sb.append("</div>\n");
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
        sb.append("</div>\n");
    }

    /**
     * @return {@code (Course) site).
     */
    @Override
    public Course getCourse() {
        return (Course) site;
    }
}
