/*
 * Copyright 2024 University of Leeds.
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
package io.github.agdturner.course.coding.intro.cpp.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.coding.intro.pages.IntroCodingCourseHome;

/**
 * Python Intro Coding Course Home Page.
 *
 * @author Andy Turner
 */
public class CPPIntroCodingCourseHome extends IntroCodingCourseHome {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to
     */
    public CPPIntroCodingCourseHome(Course course) {
        super(course);
    }

    @Override
    public void getIntroduction(StringBuilder sb) {
        SectionID sid = getIntroduction0(sb);
        getMaintainer(sb, sid);
        getNavigation(sb, sid);
        getIntroductionN(sb, sid);
    }
    
    /**
     * Introduction 0.
     *
     * @param sb The StringBuilder to append to.
     * @return SectionID for indexing terms.
     */
    @Override
    public SectionID getIntroduction0(StringBuilder sb) {
        SectionID sid = super.getIntroduction0(sb);
        sb.append(" It is a precursor to ");
        sb.append(references.getReference("CPP1"));
        super.getIntroduction1(sb);
        
//        w.addPST(sb, references.getReference("Java0"));
//        sb.append(" and ");
//        sb.append(references.getReference("CPP0"));
//        sb.append(
//                """
//                 are similar learning resources that respectively focus on the \
//                """);
//        sb.append(index.getReference("Java")).append(" and ");
//        sb.append(index.getReference("C++"));
//        w.addPET(sb, " programming languages.");
        
        return sid;
    }

    @Override
    public void getSyllabusLanguage(StringBuilder sb, SectionID sid) {
        getSyllabusLanguage0(sb, sid);
        
        w.addLI(sb, "Language development");

        w.addLIST(sb, "Structuring and organising code:");
        w.addULST(sb);
        w.addLI(sb, index.getReference("C++ Classes", "Classes"));
        w.addLI(sb, index.getReference("C++ Modules", "Modules"));
        w.addLI(sb, index.getReference("C++ Namespaces", "Namespaces"));
        w.addLI(sb, index.getReference("C++ References", "References"));
        w.addULET(sb);
        w.addLIET(sb);

        w.addLI(sb, "Compiling and running programs from the command line");
        
        w.addLI(sb, "Using " + index.getReference("Visual Studio Code"));
        
        w.addLIST(sb, "Containers including:");
        w.addULST(sb);
        w.addLI(sb, index.getReference("C++ Array", "Arrays"));
        w.addLI(sb, index.getReference("C++ Vector", "Vectors"));
        w.addLI(sb, index.getReference("C++ Set", "Sets"));
        w.addLI(sb, index.getReference("C++ Map", "Maps"));
        w.addULET(sb);
        w.addLIET(sb);
        
        w.addLI(sb, "Program input and output");
        
        w.addLIST(sb, "Using the ");
        w.addLIET(sb, index.getReference("C++ Standard Library"));
        
        w.addLIST(sb, "Using third party packages available via ");
        w.addLIET(sb, index.getReference("VCPKG"));
        
        w.addLIST(sb, index.getReference("Unit testing") + " with:");
        w.addULST(sb);
        w.addLI(sb, index.getReference("Boost.Test"));
//        w.addLI(sb, index.getReference("GoogleTest"));
//        w.addLI(sb, index.getReference("Catch2"));
//        w.addLI(sb, index.getReference("Snitch"));
        w.addULET(sb);
        w.addLIET(sb);
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
