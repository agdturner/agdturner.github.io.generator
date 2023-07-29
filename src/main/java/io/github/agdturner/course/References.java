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

import java.util.TreeMap;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * For course references pages.
 *
 * @author Andy Turner
 */
public class References extends CoursePage {

    /**
     * To look up terms from a name.
     */
    public TreeMap<String, Term> nameToTerm;

    /**
     * Create a new instance.
     * 
     * @param course What {@link #site} is set to.
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     */
    public References(Course course, String filename, String title, String label) {
        super(course, filename, title, label);
        nameToTerm = new TreeMap<>();

        String name;
        String url;
        String description;

        name = "GitHub";
        url = "https://github.com/";
        description = "an Internet hosting service for software development "
                + "and version control";
        nameToTerm.put(name, new Term(description, url));

    }

    /**
     * @param articleName The name of the Wikipedia article.
     * @return "https://en.wikipedia.org/wiki/" + articleName
     */
    public String getWikipediaURL(String articleName) {
        return "https://en.wikipedia.org/wiki/" + articleName;
    }

    /**
     * Adds a reference to the appropriate course collections and returns a link
     * to use in a WebPage.
     *
     * @param name The name for the reference.
     * @param linkText The text for the link.
     * @param url The url of the reference.
     * @param description The description of the reference.
     * @return A link.
     */
    public String addWebReference(String name, String linkText,
            String url, String description) {
        Course course = getCourse();
        References references = course.getReferences();
        if (!references.nameToTerm.containsKey(name)) {
            references.nameToTerm.put(name,
                    new Term(description, url));
        }
        return Web_ContentWriter.getLink(url, linkText);
    }

    /**
     * @param name The name of the reference to get.
     * @return {@link #getReference(java.lang.String, java.lang.String)}.
     */
    public String getReference(String name) {
        return getReference(name, name);
    }

    /**
     * @param name The name of the reference to get a link from.
     * @param linkText The link text for the link.
     * @return the link for the reference given by name.
     */
    public String getReference(String name, String linkText) {
        return nameToTerm.get(name).getLink(linkText);
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("<ul>");
        for (String name : nameToTerm.keySet()) {
            Term r = nameToTerm.get(name);
            StringBuilder sb = new StringBuilder();
            sb.append("<li>");
            sb.append(r.getLinkAndDescription(name));
            sb.append("</li>");
            w.add(sb.toString());
        }
        w.add("</ul>");
        w.add("</div>");
    }

}
