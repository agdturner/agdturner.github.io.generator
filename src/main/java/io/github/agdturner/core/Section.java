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
package io.github.agdturner.core;

/**
 * A POJO for a page section.
 * 
 * @author Andy Turner
 */
public class Section {

    /**
     * The Level.
     */
    public final int level;

    /**
     * The SectionID.
     */
    public final SectionID sid;

    /**
     * The section HTML fragment.
     */
    public final String sectionHTML;

    /**
     * The section Link.
     */
    public final String sectionLink;

    /**
     * Creates a new instance.
     *
     * @param level What {@level #sid} is set to.
     * @param sid What {@link #sid} is set to.
     * @param sectionHTML What {@link #sectionHTML} is set to.
     * @param sectionLink What {@link #sectionLink} is set to.
     */
    public Section(int level, SectionID sid, String sectionHTML,
            String sectionLink) {
        this.level = level;
        this.sid = sid;
        this.sectionHTML = sectionHTML;
        this.sectionLink = sectionLink;
    }

    @Override
    public String toString() {
        return "" + sid.toString() + ", " + sectionHTML;
    }
}
