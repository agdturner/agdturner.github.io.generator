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

import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * A POJO for a term.
 *
 * @author Andy Turner
 */
public class Term {

    /**
     * The description of the resource.
     */
    public String description;

    /**
     * The url lookup for the term.
     */
    public String url;


    /**
     * Create a new instance.
     */
    public Term() {
    }
    
    /**
     * Create a new instance.
     *
     * @param description What {@link #description} is set to.
     * @param url What {@link #url} is set to.
     */
    public Term(String description, String url) {
        this.description = description;
        this.url = url;
    }
    
    /**
     * Uses {@link #url} and linkText for a link.
     * @param linkText
     * @return A HTML link.
     */
    public String getLink(String linkText) {
        return Web_ContentWriter.getLink(url, linkText);
    }
    
    /**
     * @param linkText
     * @return A link and description.
     */
    public String getLinkAndDescription(String linkText) {
        String r = getLink(linkText);
        if (description != null) {
           r+= " - " + description;
        }
        return r;
    }
    
}
