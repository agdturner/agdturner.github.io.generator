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
package io.github.agdturner.course.coding.intro.python.sog.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.coding.intro.python.pages.PythonIntroCodingCourseHome;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * SoG Python Intro Course Home Page.
 *
 * @author Andy Turner
 */
public class SoGPythonIntroCodingCourseHome extends PythonIntroCodingCourseHome {

    public SoGPythonIntroCodingCourseHome(Course course) {
        super(course);
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder(super.getMainContent());
        getAssignment(sb);
        return sb.toString();
    }

    @Override
    public void getMaintainer(StringBuilder sb, SectionID sid) {
        w.addPST(sb, "The website is maintained by ");
        sb.append(Web_ContentWriter.getLink(
                "https://www.geog.leeds.ac.uk/people/a.turner/index.html",
                "Andy Turner"));
        w.addPET(sb,
                " and comprises a set of webpages and file based resources.");
    }

    @Override
    public SectionID getLearningJourney0(StringBuilder sb) {
        SectionID sid = super.getLearningJourney0(sb);
        w.addP(sb,
                "If in doubt, please consult yout tutor.");
        return sid;
    }

    public void getLearningJourney1(StringBuilder sb, SectionID sid) {
        w.addP(sb,
                """
                To complete the course, you are to undertake an independent
                project to apply what you have learned to develop some
                different software - there will be a specification of what the
                code/software is to do, some guidance for approaching the
                software development task, but no detailed instructions to
                follow.
                """);
    }

    //@Override
    public void getExpectations2(StringBuilder sb, SectionID sid) {
        //super.getExpectations2(sb, sid);
        w.addPST(sb,
                "You get to review some exemplar code that automates some ");
        sb.append(references.getReference("QGIS"));
        sb.append(" Desktop processing using ");
        sb.append(index.getReference("PyQGIS"));
        w.addPET(sb, ".");
    }

    @Override
    public void getPlatform(StringBuilder sb) {
        super.getPlatform(sb);
        w.addPST(sb,
                """
                The software is available via 'AppsAnywhere' at the University
                of Leeds which is accessible remotely via the 'Academic'
                <a href="https://wvd.leeds.ac.uk">University Windows Virtual Desktop</a>.
                The software includes:
                """);
        sb.append(references.getReference("Anaconda"));
        sb.append(" - a data science platform, ");
        sb.append(references.getReference("QGIS"));
        w.addPET(sb,
                """
                Desktop - Geographical Information System software, and various
                third party Python packages.
                """);
        sb.append("</div>");
    }

    public void getAssignment(StringBuilder sb) {
        sb.append("");
    }
}
