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

import io.github.agdturner.core.ReferenceID;
import java.util.HashMap;
import java.util.TreeMap;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * For course references pages.
 * 
 * @author Andy Turner
 */
public class References extends Page {
    
    /**
     * To look up Reference ID from a Reference Name. This is an ordered
     * collection for writing out References.
     */
    public TreeMap<String, ReferenceID> referenceNameToReferenceID;

    /**
     * For looking up Reference URLs from ReferenceIDs.
     */
    public HashMap<ReferenceID, String> referenceIDToReferenceURL;
    
    /**
     * Create a new instance.
     *
     * @param name What {@link #name} is set to.
     * @param label What {@link #label} is set to.
     * @param c What {@code #c} is set to.
     */
    public References(String name, String label, Course c) {
        super(name, label, c);
        referenceNameToReferenceID = new TreeMap<>();
        referenceIDToReferenceURL = new HashMap<>();
    }
    
    @Override
    public void write() {
        writeH1(label);
        w.add("<ul>");
        for (String referenceName : referenceNameToReferenceID.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append("<li>");
            sb.append(Web_ContentWriter.getLink(referenceIDToReferenceURL.get(
                    referenceNameToReferenceID.get(referenceName)),
                    referenceName));
            sb.append("</li>");
            w.add(sb.toString());
        }
        w.add("</ul>");
        w.add("</div>");
    }
}
