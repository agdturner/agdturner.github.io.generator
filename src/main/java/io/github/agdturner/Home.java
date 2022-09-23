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
package io.github.agdturner;

import io.github.agdturner.core.Environment;
import io.github.agdturner.core.PageID;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Java for generating some https://agdturner.github.io Website Content.
 *
 * @author Andy Turner
 */
public class Home extends WebPage {

    /**
     * Create a new instance.
     */
    public Home(String title, PageID id, Path p) {
        super("home", title, "Home", id, p);
        if (!Files.exists(p)) {
            try {
                Files.createDirectories(p);
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void write() {
        w.add("<div>");
        w.add("<h1><img src=\"./images/a.turner.png\" alt=\"Andy Turner profile "
                + "picture head and shoulders\" /></h1>");
        String myGeogHome = "http://www.geog.leeds.ac.uk/people/a.turner/index.html";
        w.add("<p>I am a research officer based in the School of Geography"
                + " (SoG) at the University of Leeds. I specialise in"
                + " computational geography. I undertake consultancy and teach."
                + "</p>");
        String wikipediaJava = "https://en.wikipedia.org/wiki/Java_(programming_language)";
        w.add("<p>I mostly program using the "
                + Web_ContentWriter.getLink(wikipediaJava,
                        "Java programming language")
                + " and try to keep up with changes as it evolves. I typically"
                + " use: the most recent long term support version of the "
                + Web_ContentWriter.getLink("https://openjdk.org/",
                        "OpenJDK")
                + "; the "
                + Web_ContentWriter.getLink("https://maven.apache.org/",
                        "Apache Maven software project management and "
                        + "comprehension tool")
                + "; and, the "
                + Web_ContentWriter.getLink("https://netbeans.apache.org/",
                        "Apache NetBeans development environment, tooling "
                        + "platform and application framework")
                + ".</p>");
        w.add("<p>Professionally, I am interested in: mitigating (fire, flood, "
                + " drought, famine, and accident) risks; estimating and"
                + " measuring costs and benefits; ecology and working with"
                + " nature; developing dynamic geospatial models and processing"
                + " geographical data to help mitigate risk; and developing"
                + " geographical Digital Twins - models of places based on data"
                + " about them and linked with sensors in the place that are"
                + " iteratively used to develop a more detailed representation."
                + " I am keen to nurture others and work collaboratively.</p>");
//        String gadURL = Environment.URL_GITHUB_AGDTURNER + Environment.DOMAIN;
//        String gadgURL = gadURL + ".generator";
//        w.add("<p>These Web pages are hosted on GitHub in the repository: "
//                + Web_ContentWriter.getLink(gadURL, gadURL)
//                + ". They have been generated using some Java code in the "
//                + "repository: "
//                + Web_ContentWriter.getLink(gadgURL, gadgURL)
//                + ".</p>");
        w.add("<p>"
                + Web_ContentWriter.getLink(myGeogHome,
                        "SoG Profile")
                + " | "
                + Web_ContentWriter.getLink(Environment.URL_GITHUB_AGDTURNER,
                        "Github Profile")
                + "</p>");
//        w.add("<p>"
//                + ". Below is a list of links to web site content.</p>");
//        // Links
//        //int level00 = Environment.DIR.getNameCount();
//        int level00 = 0;
//        boolean startLeaf = true;
//        for (TreeNode<Path> subdir : subdirs) {
//            int level0 = 0;
//            int depth = 0;
//            for (TreeNode<Path> node : subdir) {
//                int level = node.getLevel();
//                // HTML startList and endList elements
//                String startList = "";
//                String endList = "";
//                if (level == level0) {
//                    if (node.isRoot()) {
//                        startList += "<ul>\n<li>";
//                    } else {
//                        startList += "<li>";
//                        endList += "</li>";
//                    }
//                } else if (level < level0) {
//                    w.add("</ul>\n</li>");
//                    startList += "<li>";
//                    startLeaf = true;
//                } else {
//                    depth++;
//                    if (node.isLeaf()) {
//                        if (startLeaf) {
//                            startList += "<ul>\n";
//                            startLeaf = false;
//                        }
//                        startList += "<li>";
//                        endList += "</li>";
//                    } else {
//                        startList += "<ul>\n<li>";
//                    }
//                }
//                //String indent = createIndent();
//                //String dedent = createDedent(node.getLevel());
//                //w.add(indent);
//                String relpath = "./" + node.data.toString().replaceAll("\\\\", "/");
//                if (node.isLeaf()) {
//                    // Display leaf nodes as links.
//                    w.add(startList + Web_ContentWriter.getLink(relpath,
//                            Generic_String.getCapitalFirstLetter(
//                                    node.data.getName(level00 + level).toString()))
//                            + endList);
//                } else {
//                    // Display directories not as links.
//                    w.add(startList + Generic_String.getCapitalFirstLetter(
//                            node.data.getName(level00 + level).toString())
//                            + endList);
//                }
//                level0 = level;
//            }
//            for (int i = 0; i < depth; i++) {
//                w.add("</ul></li>");
//            }
//            w.add("</ul>");
//        }
        // End WebPage
        w.add(Web_ContentWriter.DIVET);
        try {
            w.writeHTML(p, "index.html", title, null);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        String name = "Andy Turner " + Environment.DOMAIN + " Home Page";
        PageID id = new PageID(0);
        Home h = new Home(name, id, Paths.get(Environment.DIR.toString(), "index.html"));
    }

}
