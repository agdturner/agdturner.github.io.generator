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
package io.github.agdturner.course;

import io.github.agdturner.core.SectionID;
import java.util.TreeSet;

/**
 * IndexTerm.
 *
 * @author Andy Turner
 */
public class IndexTerm extends Term {

    /**
     * The SectionIDs where this term is used.
     */
    public TreeSet<SectionID> sectionIDs;
    
    /**
     * Create a new instance.
     *
     * @param index What {@link #index} is set to.
     * @param description What {@link #description} is set to.
     * @param url What {@link #url} is set to.
     */
    public IndexTerm(Index index, String description, String url) {
        this(index, description, url, null);
    }
    
    /**
     * Create a new instance.
     *
     * @param index What {@link #index} is set to.
     * @param description What {@link #description} is set to.
     * @param url What {@link #url} is set to.
     * @param sid A SectionID where the term is used.
     */
    public IndexTerm(Index index, String description, String url, SectionID sid) {
        super(index, description, url);
        this.sectionIDs = new TreeSet<>();
        if (sid != null) {
            this.sectionIDs.add(sid);
        }
    }
}
