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

    /**
     * Initialise the header, h1, and start of the introduction.
     *
     * @param sb The StringBuilder to append to.
     */
    public void getStart(StringBuilder sb) {
        SectionID sid = addSection("1", "Introduction", 2, sb);
        sb.append("""
              <p>Welcome to the course website!</p>
              """);
    }

    /**
     * Default webmaster details - who maintains the site and how to contact
     * them.
     *
     * @param sb The StringBuilder to append to.
     */
    public void getMaintainer(StringBuilder sb) {
        sb.append("<p>The website is maintained by ")
                .append(Web_ContentWriter.getLink(Environment.HTTPS_ARC_LEEDS_AC_UK,
                        "Research Computing"))
                .append(" and comprises a set of webpages and file based")
                .append(" resources.</p>");
        sb.append("<p>Please ")
                .append(Web_ContentWriter.getLink(Environment.ARC_CONTACT,
                        "contact us"))
                .append(" if you want help, clarification or there is a")
                .append(" problem with these resources.</p>");
    }

    /**
     * Explanation about navigation of the site.
     *
     * @param sb The StringBuilder to append to.
     */
    public void getNavigationIntro(StringBuilder sb) {
        sb.append("""
              <p>At the top of each web page is a button that can be actioned to 
              change between a lighter and darker page style. Below that is a 
              navigation section that links to each web page. The pages are 
              sequential and at the end of each page, there is a link to the 
              next page.</p>
              <p>There are index and references pages at the end. The index page 
              is a glossary of terms that links back to particular sections of 
              other pages that are relevant.</p>
              <p>Essentially, taking the course involves working your way 
              through the web pages trying out code and undertaking practical 
              exercises as directed.</p>
              """);
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
     */
    public SectionID getExpectations0(StringBuilder sb) {
        sb.append("<div>\n");
        SectionID sid = addSection("3", "Expectations", 2, sb);
        sb.append("""
              <p>You will learn about:</p>
              <ul>
              """);
        return sid;
    }

    /**
     * For detailing the last part of the expectations.
     *
     * @param sb The StringBuilder to append to.
     */
    public void getExpectationsN(StringBuilder sb, SectionID sid) {
        sb.append("""
              <p>There are some key concepts which may take a few attempts to 
              get used to and comprehensively understand.</p>
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
     * For detailing the first part of the learning journey.
     *
     * @param sb The StringBuilder to append to.
     */
    public SectionID getLearningJourney0(StringBuilder sb) {
        sb.append("<div>\n");
        SectionID sid = addSection("4", "The Learning Journey", 2, sb);
        sb.append("""
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
              <p>Be cautious and do not run code that you do not trust.</p>
              """);
        return sid;
    }

    /**
     * For detailing the last part of the learning journey.
     *
     * @param sb The StringBuilder to append to.
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
     * For detailing the platform.
     *
     * @param sb The StringBuilder to append to.
     */
    public void getPlatform(StringBuilder sb) {
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
    }

    /**
     * @return {@code (Course) site).
     */
    public Course getCourse() {
        return (Course) site;
    }
}
