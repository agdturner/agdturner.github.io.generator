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
package io.github.agdturner.course.coding.intro.java.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.coding.intro.pages.IntroCodingCourseHome;

/**
 * Java Intro Coding Course Home Page.
 *
 * @author Andy Turner
 */
public class JavaIntroCodingCourseHome extends IntroCodingCourseHome {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public JavaIntroCodingCourseHome(Course course) {
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
        getSyllabusProgrammingJava(sb, sid);
        getSyllabusOrganisational(sb, sid);
        getSyllabusN(sb, sid);
    }
    
    public void getSyllabusProgrammingJava(StringBuilder sb, SectionID sid) {
        sb.append("<p>").append(index.getReference("Java"))
                .append(" language development and limitations</p>");
        sb.append("<p>Structuring and organising code into ")
                .append(index.getReference("Java Class", "Java Classes"))
                .append(", ")
                .append(index.getReference("Java Package", "Packages"))
                .append(", and ")
                .append(index.getReference("Java Platform Module System",
                        "Modules"))
                .append("</p>\n");
        sb.append("<p>Using the ")
                .append(index.getReference("JShell"))
                .append(" ")
                .append(index.getReference("REPL", "Read Evaluate Print Loop"))
                .append(" environment</p>");
        sb.append("<p>Running programs via the command line</p>");
        sb.append("<li>Java collections:")
                .append(index.getReference("Java ArrayList", "ArrayList"))
                .append(", ")
                .append(index.getReference("Java Set", "Set"))
                .append(" and ")
                .append(index.getReference("Java Map", "Map"))
                .append("</li>");
        sb.append("<p>Using third party libraries;</p>");
        sb.append("<p>Creating ")
                .append(index.getReference("Javadoc"))
                .append(" documentation</p>");
        sb.append("<p>Testing code</p>");
    }

    @Override
    public void getExpectations(StringBuilder sb) {
        SectionID sid = getExpectations0(sb);
        getExpectations1(sb, sid);
        getExpectationsN(sb, sid);
    }
    
    @Override
    public void getExpectations1(StringBuilder sb, SectionID sid) {
        sb.append("</ul>\n");
    }

    @Override
    public void getLearningJourney(StringBuilder sb) {
        SectionID sid = getLearningJourney0(sb);
        getLearningJourneyN(sb, sid);
    }

    @Override
    public void getPlatform(StringBuilder sb) {
        SectionID sid = getPlatform0(sb);
        getPlatformN(sb, sid);
    }
}
