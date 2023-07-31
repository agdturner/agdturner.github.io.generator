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

import io.github.agdturner.core.Strings;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.coding.pages.CodingCourseHome;

/**
 * Introduction Level Coding Course Home Page.
 * 
 * @author Andy Turner
 */
public abstract class IntroCodingCourseHome extends CodingCourseHome {

    public IntroCodingCourseHome(Course course, String courseName) {
        super(course, courseName);
    }
    
    @Override
    public void getExpectations(StringBuilder sb) {
        super.getExpectations(sb);
    }
    
    /**
     * Version Control, GitHub, Data Encoding and File Formats
     */
    public void getExpectations0(StringBuilder sb) {
        sb.append("<li>"
                + references.getReference("GitHub")
                + " as a source code repository and for website hosting</li>");
    }
    
    @Override
    public void getExpectationsN(StringBuilder sb) {
        sb.append("""
              </ul>
              <p>Computer programming mostly involves computational thinking, 
              planning, problem solving and testing. It is often helpful to 
              break a task into smaller subtasks, and gradually develop an
              implementation. Often good solutions to coding tasks involve doing
              things repeatedly for a sequence of things.</p>
              <!--<p>Often it is 
              helpful to use a framework for testing from the outset and to test 
              often as the code develops.</p>-->
              """);
        String courseType = getCourse().courseType;
        sb.append("<p>If you are new to computer programming, there is quite a lot "
                + "of terminology to get used to, some is generic to "
                + "programming, some is specific to "
                + index.getReference(courseType, Strings.toUpperCaseFirstLetter(courseType))
                + ".</p>");
    }
    
    
}
