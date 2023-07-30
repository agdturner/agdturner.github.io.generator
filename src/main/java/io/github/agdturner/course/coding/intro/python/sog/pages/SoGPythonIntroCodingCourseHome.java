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

import io.github.agdturner.course.Course;
import io.github.agdturner.course.coding.intro.python.pages.PythonIntroCodingCourseHome;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * SoG Python Intro Course Home Page.
 * 
 * @author Andy Turner
 */
public class SoGPythonIntroCodingCourseHome extends PythonIntroCodingCourseHome {
    
    public SoGPythonIntroCodingCourseHome(Course course, String courseName) {
        super(course, courseName);
    }
    
    @Override
    public void writeMaintainer() {
        w.add("<p>The website is maintained by "
                + Web_ContentWriter.getLink(
                        "https://www.geog.leeds.ac.uk/people/a.turner/index.html",
                        "Andy Turner")
                + " and comprises a set of webpages and file based resources."
                + "</p>");
    }
    
    @Override
    public void writeLearningJourney0() {
        super.writeLearningJourney0();
        w.add("<p>If in doubt, please consult yout tutor.</p>");
    }
    
    @Override
    public void writeLearningJourney1 () {
        super.writeLearningJourney1();
        w.add("""
              <p>To complete the course, you are to undertake an independent 
              project to apply what you have learned to develop some different 
              software - there will be a specification of what the code/software 
              is to do, some guidance for approaching the software development 
              task, but no detailed instructions to follow.</p>
              """);
    }

    @Override
    public void writePlatform() {
        super.writePlatform();
        w.add("<p>The software is available via 'AppsAnywhere' at the "
                + "University of Leeds which is accessible remotely via the "
                + "'Academic' <a href=\"https://wvd.leeds.ac.uk\">"
                + "University Windows Virtual Desktop</a>. The software "
                + "includes: "
                + references.getReference("Anaconda")
                + " - a data science platform, "
                + references.getReference("QGIS")
                + " Desktop - Geographical Information System software, and "
                + "various third party Python packages.</p>");
        w.add("</div>");
    }
}
