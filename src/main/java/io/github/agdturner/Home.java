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
import io.github.agdturner.core.Strings;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.ac.leeds.ccg.generic.lang.Generic_String;
import uk.ac.leeds.ccg.generic.util.TreeNode;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Java for generating some https://agdturner.github.io Website Content.
 *
 * @author Andy Turner
 */
public class Home extends Page {

    ArrayList<TreeNode<Path>> subdirs;

    /**
     * Create a new instance.
     */
    public Home(String name, PageID id) {
        super(name, id);
        subdirs = new ArrayList<>();
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        String name = "Andy Turner " + Environment.domain + " Home Page";
        PageID id = new PageID(0);
        Home h = new Home(name, id);
        //Path p = Paths.get(Environment.dir.toString(), "course");
        Path p = Paths.get("courses");
        TreeNode<Path> dirCourses = new TreeNode<>(p);
        h.subdirs.add(dirCourses);
        Path pPython = Paths.get(p.toString(), "python");
        TreeNode<Path> dirCoursesPython = dirCourses.addChild(pPython);
        dirCoursesPython.addChild(Paths.get(pPython.toString(), "GEOG5990M"));
        dirCoursesPython.addChild(Paths.get(pPython.toString(), "GEOG5995M"));
        dirCoursesPython.addChild(Paths.get(pPython.toString(), "GEOG5003M"));
        Path pJava = Paths.get(p.toString(), "java");
        TreeNode<Path> dirCoursesJava = dirCourses.addChild(pJava);
        dirCoursesJava.addChild(Paths.get(pJava.toString(), "GEOG5990M"));
        try {
            // Home Page index
            h.write(Environment.dir);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * For initial write of Web content.
     *
     * @param domain The domain name as a String.
     * @param dir The directory in which the content will be written.
     * @param subdirs The subdirectories in the index.
     * @throws IOException If thrown.
     */
    @Override
    public void write(Path dir) throws IOException {
        String filename = "index";
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }
        w.add("<div>");
        w.add("<h1><img src=\"./images/a.turner.png\" alt=\"Andy Turner profile "
                + "picture head and shoulders\" /></h1>");
        w.add("<p>I am a research officer based in the School of Geography at the "
                + "University of Leeds. Amongst other things, I teach students "
                + "how to program and use R and Python for processing "
                + "geographical data and modelling. I mostly program using "
                + "Java, Maven and Netbeans and am interested in developing "
                + "dynamic spatial models and processing geographical data to "
                + "help mitigate risk and make the world a safer, happier and "
                + "healthier place for people and wildlife.</p>");
        String gadURL = Environment.gaURL + Environment.domain;
        String gadgURL = gadURL + ".generator";
        w.add("<p>These Web pages are hosted on GitHub in the repository: "
                + Web_ContentWriter.getLink(gadURL, gadURL)
                + ". They have been generated using some Java code in the "
                + "repository: "
                + Web_ContentWriter.getLink(gadgURL, gadgURL)
                + ". Here is a link to my Github profile: "
                + Web_ContentWriter.getLink(Environment.gaURL,
                        Environment.gaURL)
                + ". Below is a list of links to web site content.</p>");
        // Links
        //int level00 = Environment.dir.getNameCount();
        int level00 = 0;
        boolean startLeaf = true;
        for (TreeNode<Path> subdir : subdirs) {
            int level0 = 0;
            int depth = 0;
            for (TreeNode<Path> node : subdir) {
                int level = node.getLevel();
                // HTML startList and endList elements
                String startList = "";
                String endList = "";
                if (level == level0) {
                    if (node.isRoot()) {
                        startList += "<ul>\n<li>";
                    } else {
                        startList += "<li>";
                        endList += "</li>";
                    }
                } else if (level < level0) {
                    w.add("</ul>\n</li>");
                    startList += "<li>";
                    startLeaf = true;
                } else {
                    depth ++;
                    if (node.isLeaf()) {
                        if (startLeaf) {
                            startList += "<ul>\n";
                            startLeaf = false;
                        }
                        startList += "<li>";
                        endList += "</li>";
                    } else {
                        startList += "<ul>\n<li>";
                    }
                }
                //String indent = createIndent();
                //String dedent = createDedent(node.getLevel());
                //w.add(indent);
                String relpath = "./" + node.data.toString().replaceAll("\\\\", "/");
                if (node.isLeaf()) {
                    // Display leaf nodes as links.
                    w.add(startList + Web_ContentWriter.getLink(relpath,
                        Generic_String.getCapitalFirstLetter(
                                node.data.getName(level00 + level).toString()))
                        + endList);
                } else {
                    // Display directories not as links.
                    w.add(startList + Generic_String.getCapitalFirstLetter(
                                node.data.getName(level00 + level).toString())
                        + endList);
                }
                level0 = level;
            }
            for (int i = 0 ; i < depth; i ++) {
                w.add("</ul></li>");
            }
            w.add("</ul>");
        }
//        for (Path subdir : subdirs) {
//            int subdirnc = subdir.getNameCount();
//            String relpath = "";
//            //int depth = subdirnc - dirnc;
//            for (int i = dirnc; i < subdirnc; i++) {
//                w.add("<ul>");
//                w.add("<li>");
//                String subdirname = subdir.getName(i).toString();
//                relpath = relpath.concat(subdirname + "/");
//                if (i == subdirnc - 1) {
//                    w.add(Web_ContentWriter.getLink(relpath,
//                            Generic_String.getCapitalFirstLetter(subdirname)));
//                } else {
//                    w.add(Generic_String.getCapitalFirstLetter(subdirname));
//                }
//            }
//            for (int i = dirnc; i < subdirnc; i++) {
//                w.add("</li>");
//                w.add("</ul>");
//            }
//        }
        w.add(Web_ContentWriter.DIVET);
        String title = Environment.domain + Strings.symbol_space + name
                + Strings.symbol_space + "Page";
        w.writeHTML(dir, filename, title);
    }

}
