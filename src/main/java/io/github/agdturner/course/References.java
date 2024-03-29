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
 * References Course Page.
 *
 * @author Andy Turner
 */
public class References extends CoursePage {

    /**
     * To look up terms from a name.
     */
    public TreeMap<String, Term> termToTerm;

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
        termToTerm = new TreeMap<>();

        String name;
        String url;
        String description;

        name = "GitHub";
        url = "https://github.com/";
        description = """
                      A platform to build, scale, and deliver secure "software".
                      """;
        termToTerm.put(name, new Term(index, description, url));
        
        
        name = "CPP0";
        url = "https://agdturner.github.io/CPP0/public_html/home/index.html";
        description = """
                      CPP0: C++ for HPC Level 0.
                      """;
        termToTerm.put(name, new Term(index, description, url));
        
        name = "CPP1";
        url = "https://agdturner.github.io/CPP1/public_html/home/index.html";
        description = """
                      CPP1: C++ for HPC Level 0.
                      """;
        termToTerm.put(name, new Term(index, description, url));
        
        name = "Python0";
        url = "https://agdturner.github.io/Python0/public_html/home/index.html";
        description = """
                      Python0: Python for HPC Level 0.
                      """;
        termToTerm.put(name, new Term(index, description, url));
        
        name = "Python1";
        url = "https://agdturner.github.io/Python1/public_html/home/index.html";
        description = """
                      Python1: Python for HPC Level 1.
                      """;
        termToTerm.put(name, new Term(index, description, url));
        
        name = "Java0";
        url = "https://agdturner.github.io/Java0/public_html/home/index.html";
        description = """
                      Java0: Java for HPC Level 0.
                      """;
        termToTerm.put(name, new Term(index, description, url));
        
        name = "Java1";
        url = "https://agdturner.github.io/Java1/public_html/home/index.html";
        description = """
                      Java1: Java for HPC Level 1.
                      """;
        termToTerm.put(name, new Term(index, description, url));
        
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
     * @param course The course.
     * @param name The name for the reference.
     * @param linkText The text for the link.
     * @param url The URL of the reference.
     * @param description The description of the reference.
     * @return A link.
     */
    public String addWebReference(Course course, String name, String linkText,
            String url, String description) {
        if (!references.termToTerm.containsKey(name)) {
            references.termToTerm.put(name,
                    new Term(index, description, url));
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
        Term t = termToTerm.get(name);
        if (t == null) {
            //throw new RuntimeException();
            return null;
        }
        return t.getLink(linkText);
//        return termToTerm.get(name).getLink(linkText);
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>");
        for (String name : termToTerm.keySet()) {
            Term term = termToTerm.get(name);
            sb.append("<li>");
            sb.append(term.getLinkAndDescription(name));
            sb.append(".");            
            sb.append("</li>\n");
        }
        sb.append("</ul>\n");
        sb.append("</div>\n");
        return sb.toString();
    }
}
