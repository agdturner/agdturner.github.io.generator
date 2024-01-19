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
package io.github.agdturner.course.coding.intro.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.coding.pages.CodingCourseHome;

/**
 * Introduction Level Coding Course Home Page.
 * 
 * @author Andy Turner
 */
public abstract class IntroCodingCourseHome extends CodingCourseHome {

    public IntroCodingCourseHome(Course course) {
        super(course);
    }

    public void getSyllabusOrganisational(StringBuilder sb, SectionID sid) {
        w.addP(sb, index.getReference("Version Control"));
    }
    
}
