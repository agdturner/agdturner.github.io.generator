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
        sb.append("<p>The website is maintained by ")
                .append(Web_ContentWriter.getLink(
                "https://www.geog.leeds.ac.uk/people/a.turner/index.html",
                "Andy Turner"))
                .append(" and comprises a set of webpages and file based")
                .append(" resources.</p>\n");
    }
    
    @Override
    public SectionID getLearningJourney0(StringBuilder sb) {
        SectionID sid = super.getLearningJourney0(sb);
        sb.append("<p>If in doubt, please consult yout tutor.</p>\n");
        return sid;
    }
    
    @Override
    public void getLearningJourney1 (StringBuilder sb, SectionID sid) {
        super.getLearningJourney1(sb, sid);
        sb.append("<p>To complete the course, you are to undertake an")
                .append(" independent project to apply what you have learned")
                .append(" to develop some different software - there will be")
                .append(" a specification of what the code/software is to do,")
                .append(" some guidance for approaching the software")
                .append(" development task, but no detailed instructions to")
                .append(" follow.</p>\n");    }

    public void getExpectations2(StringBuilder sb, SectionID sid) {
        super.getExpectations2(sb, sid);
        sb.append("<p>You get to review some exemplar code that automates")
                .append(" some ")
                .append(references.getReference("QGIS"))
                .append(" Desktop processing using ")
                .append(index.getReference("PyQGIS"))
                .append(".</p>\n");
    }
    
    @Override
    public void getPlatform(StringBuilder sb) {
        super.getPlatform(sb);
        sb.append("<p>The software is available via 'AppsAnywhere' at the")
                .append(" University of Leeds which is accessible remotely")
                .append(" via the 'Academic' ")
                .append("<a href=\"https://wvd.leeds.ac.uk\">")
                .append("University Windows Virtual Desktop</a>")
                .append(". The software includes: ")
                .append(references.getReference("Anaconda"))
                .append(" - a data science platform, ")
                .append(references.getReference("QGIS"))
                .append(" Desktop - Geographical Information System software,")
                .append(" and various third party Python packages.</p>\n");
        sb.append("</div>");
    }
    
    public void getAssignment(StringBuilder sb) {
        sb.append("");
        
    }
}
