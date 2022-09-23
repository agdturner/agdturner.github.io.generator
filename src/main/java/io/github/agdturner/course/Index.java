/*
 * Copyright 2022 Centre for Computational Geography.
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
package io.github.agdturner.course;

import io.github.agdturner.core.PageID;
import io.github.agdturner.core.SectionID;
import io.github.agdturner.core.TermID;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * For course index pages.
 *
 * @author Andy Turner
 */
public class Index extends Page {

    /**
     * To look up a Term from a TermID
     */
    public HashMap<TermID, String> termIDToTerm;

    /**
     * To look up TermIDs in Term order.
     */
    public TreeMap<String, TermID> termToTermID;

    /**
     * For storing an index of Terms and the SectionIDs they are in
     */
    public HashMap<TermID, TreeSet<SectionID>> index;

    /**
     * Create a new instance.
     *
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     * @param c What {@code #c} is set to.
     */
    public Index(String filename, String title, String label, Course c) {
        super(filename, title, label, c);
        termIDToTerm = new HashMap<>();
        termToTermID = new TreeMap<>();
        index = new HashMap<>();
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("<ul>");
        for (TermID termID : index.keySet()) {
            TreeSet<SectionID> sectionIDs = index.get(termID);
            String term = termIDToTerm.get(termID);
            StringBuilder sb = new StringBuilder();
            sb.append("<li>" + term);
            for (SectionID sectionID : sectionIDs) {
                String sectionName = c.sectionIDToSectionName.get(sectionID);
                PageID pageID = c.sectionIDToPageID.get(sectionID);
                String pageName = c.pageIDToName.get(pageID);
                sb.append(" " + c.pageIDToLink.get(pageID));
            }
            w.add(sb.toString());
        }
        w.add("</ul>");
        w.add("</div>");
    }

}
