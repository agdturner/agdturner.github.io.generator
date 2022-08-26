/*
 * Copyright 2022 Centre for Computational Geography.
 *
 * Licensed under the Apache License, Version 2.0 (the"License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an"AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.agdturner.course.python;

import io.github.agdturner.core.TermID;
import io.github.agdturner.core.PageID;
import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.CoursePageIndex;
import java.io.IOException;
import java.nio.file.Path;
import java.util.TreeSet;

/**
 * For Python Intro Course Index Page.
 *
 * @author Andy Turner
 */
public class PythonIntroCoursePageIndex extends CoursePageIndex {

    /**
     * Create a new instance.
     *
     * @param code What {@link #code} is set to.
     * @param name What {@link #name} is set to.
     */
    public PythonIntroCoursePageIndex(String name, PageID id,
            PythonIntroCourse c) {
        super(name, id, c);
    }

    @Override
    public void write(Path dir) throws IOException {
        writeH1(name);
        w.add("<ul>");
        for (TermID termID : c.index.keySet()) {
            TreeSet<SectionID> sectionIDs = c.index.get(termID);
            String term = c.termIDToTerm.get(termID);
            StringBuilder sb = new StringBuilder();
            sb.append("<li>" + term);
            for (SectionID sectionID : sectionIDs) {
                String sectionName = c.sectionIDToSectionName.get(sectionID);
                PageID pageID = c.sectionIDToPageID.get(sectionID);
                String pageName = c.pageIDToName.get(pageID);
                sb.append(" " + pageName);
            }
            w.add(sb.toString());
        }
        w.add("</ul>");
        w.add("</div>");
    }
}
