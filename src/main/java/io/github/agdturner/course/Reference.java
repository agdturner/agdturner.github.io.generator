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
 * A POJO for a Reference (for a Web resource).
 *
 * @author Andy Turner
 */
public class Reference {

    /**
     * The url of the resource.
     */
    public String url;

    /**
     * The description of the resource.
     */
    public String description;

    /**
     * Create a new instance
     *
     * @param url What {@link #url is set to}.
     * @param description What {@link #description is set to}.
     */
    public Reference(String url, String description) {
        this.url = url;
        this.description = description;
    }
    
    /**
     * @param linkText
     * @return A link.
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
