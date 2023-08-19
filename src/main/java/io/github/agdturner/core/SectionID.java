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
package io.github.agdturner.core;

import uk.ac.leeds.ccg.data.id.Data_ID_int;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Page Section Identifier.
 *
 * @author Andy Turner
 */
public class SectionID extends Data_ID_int {

    private static final long serialVersionUID = 1L;

    /**
     * The Page.
     */
    private transient final Page page;

    /**
     * The in page section ID for linking.
     */
    private final String inPageID;

    /**
     * Create a new instance.
     * 
     * @param id What {@link #id} is set to.
     * @param page What {@link #page} is set to.
     * @param inPageID What {@link #inPageID} is set to.
     */
    public SectionID(int id, Page page, String inPageID) {
        super(id);
        this.page = page;
        this.inPageID = inPageID;
    }

    /**
     * @return A link to the section.
     */
    public String getLink() {
        return Web_ContentWriter.getLink(
                "../" + page.filename + "/index.html#" + inPageID,
                page.site.sectionIDToSectionName.get(this));
    }
    
    @Override
    public String toString() {
        return "" + super.id;
    }
}
