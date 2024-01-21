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
package io.github.agdturner.course.coding.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.pages.CourseHome;

/**
 * Coding Course Home Page.
 *
 * @author Andy Turner
 */
public abstract class CodingCourseHome extends CourseHome {

    public CodingCourseHome(Course course) {
        super(course);
    }
    
    @Override
    public final void getSyllabus(StringBuilder sb) {
        SectionID sid = getSyllabus0(sb);
        getSyllabusProgrammingStart(sb, sid);
        getSyllabusObjectOrientation(sb, sid);
        getSyllabusProgrammingEnd(sb, sid);
        getSyllabusLanguage(sb, sid);
        getSyllabusN(sb, sid);
    }
    
    public void getSyllabusProgrammingStart(StringBuilder sb, SectionID sid) {
        w.addP(sb,
                "General computer programming language concepts, including:");
        w.addULST(sb);
        w.addLI(sb, index.getReference("Variables"));
        w.addLIST(sb, index.getReference("Control flow"));
        sb.append(" (");
        sb.append(index.getReference("conditionals"));
        sb.append("/");
        sb.append(index.getReference("For loops"));
        sb.append("/");
        sb.append(index.getReference("While loops"));
        w.addLIET(sb, ")");
        w.addLI(sb, index.getReference("Functions"));
        w.addLIST(sb, "Data encoding and ");
        w.addLIET(sb, index.getReference("File formats"));
        w.addLI(sb, "Documentation");
        w.addLI(sb, "Testing");
    }
    
    public void getSyllabusLanguage0(StringBuilder sb, SectionID sid) {
        String language = getCourse().courseTypeCaptialised;
        w.addP(sb, index.getReference(language) + " specifics:");
        w.addULST(sb);
    }
        
    public void getSyllabusObjectOrientation(StringBuilder sb, SectionID sid) {
        w.addLI(sb, index.getReference("Object Oriented Programming"));
    }
    
    public void getSyllabusProgrammingEnd(StringBuilder sb, SectionID sid) {
        w.addLI(sb, index.getReference("Version control"));
        w.addLI(sb, references.getReference("GitHub") 
                + " as a source code repository and for website hosting");
        w.addULET(sb);
    }
    
    public abstract void getSyllabusLanguage(StringBuilder sb, SectionID sid);
}
