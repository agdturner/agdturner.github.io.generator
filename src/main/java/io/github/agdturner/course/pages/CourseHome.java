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
        SectionID sid = addSection("1", "Introduction", 2, sb);
        sb.append("<p>Welcome to the course website!</p>\n");
        return sid;
    }

    /**
     * Maintainer.
     *
     * @param sb The StringBuilder to append to.
     * @param sid For indexing terms.
     */
    public void getMaintainer(StringBuilder sb, SectionID sid) {
        sb.append("<p>The website is maintained by ")
                .append(Web_ContentWriter.getLink(
                        Environment.HTTPS_ARC_LEEDS_AC_UK,
                        "Research Computing"))
                .append(" and comprises a set of webpages and file based")
                .append(" resources.</p>\n");
        sb.append("<p>If you are based at ")
                .append(Web_ContentWriter.getLink(Environment.ARC_CONTACT,
                        "contact us"))
                
                .append(Web_ContentWriter.getLink(Environment.ARC_CONTACT,
                        "contact us"))
                .append(" if you want help, clarification or there is a")
                .append(" problem with these resources.</p>\n");
    }

    /**
     * Navigation.
     *
     * @param sb The StringBuilder to append to.
     * @param sid For indexing terms.
     */
    public void getNavigation(StringBuilder sb, SectionID sid) {
        sb.append("<p>At the top of each webpage is a button that can be")
              .append(" actioned to change between a lighter and darker page")
              .append(" style. Below that is a navigation section that links")
              .append(" to each webpage. The webpages are sequential and at")
              .append(" the end of each webpage, there is a link to the next")
              .append(" webpage.</p>\n");
        sb.append("<p>The penultimate webpage is the ")
              .append(getLink(index, "index", "link", ""))
              .append(" - a glossary of terms that links back to webpage")
              .append(" sections where terms are used.</p>\n");
        sb.append("<p>The last webpage is the ")
              .append(getLink(references, "references", "link", ""))
              .append(" - a useful list of references and links to other")
              .append(" resources.</p>\n");
        sb.append("<p>Webpages with multiple sections have a Contents section")
              .append(" that links to these. The Contents is found after the")
              .append(" level 1 heading at the top of the webpage.</p>\n");
        sb.append("<p>Essentially, taking the course involves working your way")
              .append(" through the webpages and undertaking practical")
              .append(" exercises as directed.</p>\n");
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
        SectionID sid = addSection("2", "Syllabus", 2, sb);
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
        SectionID sid = addSection("3", "Expectations", 2, sb);
        sb.append("<p>You will learn about:</p>\n");
        sb.append("<ul>\n");
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
        sb.append("<p>There are some key concepts which may take a few")
                .append(" attempts to get used to and comprehensively")
                .append(" understand.</p>\n");
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
        SectionID sid = addSection("4", "The Learning Journey", 2, sb);
        sb.append("<p>Develop your understanding through practise and by")
                .append(" reading.</p>\n");
        sb.append("<p>Be experimental - test your understanding by testing")
                .append(" things do what you expect. If things do not do what")
                .append(" you expect, try to understand why. An exception")
                .append(" error fault or failure is also a learning")
                .append(" opportunity!</p>\n");
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
        sb.append("<p>Try to enjoy the learning journey, the challenges and ")
                .append("the rewards. Learning to program and learning ")
                .append(index.getReference(courseName, courseNameUC))
                .append(" is empowering!</p>\n");
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
        SectionID sid = addSection("5", "Platform/Software", 2, sb);
        sb.append("<p>All the software used in this course is ")
                .append(index.getReference("Free and Open Source Software"))
                .append(" (FOSS) - available to download and install on ")
                .append(index.getReference("Linux"))
                .append(", ")
                .append(index.getReference("Microsoft Windows"))
                .append(", and ")
                .append(index.getReference("MacOS"))
                .append(".<p>\n");
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
