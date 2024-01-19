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
    public void getSyllabusLanguage(StringBuilder sb, SectionID sid) {
        getSyllabusLanguage0(sb, sid);
        
        w.addLI(sb, "Language development");
        
        w.addLIST(sb, "Structuring and organising code:");
        w.addULST(sb);
        w.addLI(sb, index.getReference("Java Class", "Classes"));
        w.addLI(sb, index.getReference("Java Package", "Packages"));
        w.addLI(sb, index.getReference("Java Platform Module System", 
                "Modules"));
        w.addULET(sb);
        w.addLIET(sb);
        
        w.addLIST(sb, "Using the ");
        sb.append(index.getReference("JShell"))
                .append(" ")
                .append(index.getReference("REPL", "Read Evaluate Print Loop"));
        w.addLIET(sb, " environment");
        
        w.addLI(sb, "Compiling and running programs from the command line");
        
        w.addLI(sb, "Using " + index.getReference("Apache Netbeans"));
        
        w.addLIST(sb, "Collections including:");
        w.addULST(sb);
        w.addLI(sb, index.getReference("Java Array", "Array"));
        w.addLI(sb, index.getReference("Java ArrayList", "ArrayList"));
        w.addLI(sb, index.getReference("Java Set", "Set"));
        w.addLI(sb, index.getReference("Java Map", "Map"));
        w.addULET(sb);
        w.addLIET(sb);
        
        w.addLI(sb, index.getReference("Javadoc"));
        
        w.addLI(sb, "Program input and output");
        
        w.addLI(sb, index.getReference("Maven"));
        
        w.addLI(sb, "Using third party libraries");
        
        w.addLIST(sb, index.getReference("Unit testing") + " with ");
        w.addLIET(sb, index.getReference("JUnit"));
        
        w.addULET(sb);
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
