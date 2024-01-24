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

import io.github.agdturner.core.Environment;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Term.
 *
 * @author Andy Turner
 */
public class Term {

    /**
     * The index for looking up terms.
     */
    protected Index index;
    
    /**
     * The description of the resource.
     */
    public final String description;

    /**
     * The URL lookup for the term.
     */
    public final String url;

    /**
     * Create a new instance.
     *
     * @param index What {@link #index} is set to.
     * @param description What {@link #description} is set to.
     * @param url What {@link #url} is set to.
     */
    public Term(Index index, String description, String url) {
        this.index = index;
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
     * Uses linkName for an internal link.
     * @param linkName
     * @return A HTML link.
     */
    public String getLinkWithin(String linkName) {
        return Web_ContentWriter.getLink("#" + linkName, linkName);
    }
    
    /**
     * Uses linkName for an internal link using linkText.
     * @param linkName The id or target of the link.
     * @param linkText The text displayed.
     * @return A HTML link.
     */
    public String getLinkWithin(String linkName, String linkText) {
        return Web_ContentWriter.getLink(index.path + "/index.html#" + linkName, linkText);
    }
    
    /**
     * If there is text marked up with double quotes in the description, then an 
     * attempt is made to additionally insert a link for that text. This also 
     * looks to use any alias set up for these terms.
     * 
     * @param linkText
     * @return A link and description.
     */
    public String getLinkAndDescription(String linkText) {
        String r = getLink(linkText);
        if (description != null) {
            r += " - ";
            if (description.contains("\"")) {
                String[] split = description.split("\"");
                for (int i = 0; i < split.length; i ++) {
                    if (i % 2 == 0) {
                        r+= split[i];
                    } else {
                        String l = index.getReference(split[i]);
                        if (l == null) {
                            String la = index.aliasToTerm.get(split[i]);
                            if (la == null) {
                                r+= "\"" + split[i] + "\"";                                
                            } else {
                                r+= index.getReference(la, split[i]);
                            }
                        } else {
                            r+= l;
                        }    
                    }
                }
            } else {
                r+= description;
            }
        }
        return r;
    }
}
