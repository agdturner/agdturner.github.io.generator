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

import io.github.agdturner.core.A_Strings;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.ac.leeds.ccg.generic.lang.Generic_String;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Java for generating some https://agdturner.github.io Website Content.
 *
 * @author Andy Turner
 */
public class A_Content {

    /**
     * Create a new instance.
     */
    public A_Content() {
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        A_Content hw = new A_Content();
        String domain = "agdturner.github.io";
        Path dir = Paths.get("C:", "Users", "agdtu", "src", "agdt", domain);
        String gURL = "http://github.com/";
        String gaURL = gURL + "agdturner/";
        ArrayList<Path> subDirectories = new ArrayList<>();
        Path dirCourses = Paths.get(dir.toString(), "courses");
        Path dirPython = Paths.get(dirCourses.toString(), "python");
        subDirectories.add(dirPython);
        try {
            // Home Page index
            hw.writeIndex(domain, dir, gaURL, subDirectories);
            hw.writeIntroductionToPythonCourse(domain, dir, dirPython);
        } catch (IOException ex) {
            Logger.getLogger(A_Content.class.getName()).log(Level.SEVERE, null, ex);
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
    public void writeIndex(String domain, Path dir, String gaURL, ArrayList<Path> subdirs)
            throws IOException {
        String name = "Home";
        String filename = "index";
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }
        Web_ContentWriter w = new Web_ContentWriter();
        w.add(Web_ContentWriter.DIVST);
        w.add(Web_ContentWriter.H1ST,
                ("<img src=\"./images/a.turner.png\" alt=\"Andy Turner profile "
                        + "picture head and shoulders\" />").getBytes(),
                Web_ContentWriter.H1ET);
        w.add(Web_ContentWriter.PST);
        w.add("I am a research officer based in the School of Geography at the "
                + "University of Leeds. Amongst other things, I teach students "
                + "how to program and use R and Python for processing "
                + "geographical data and modelling. I mostly program using "
                + "Java, Maven and Netbeans and am interested in developing "
                + "dynamic spatial models and processing geographical data to "
                + "help mitigate risk and make the world a safer, happier and "
                + "healthier place for people and wildlife.");
        w.add(Web_ContentWriter.PET);
        w.add(Web_ContentWriter.PST);
        String gadURL = gaURL + domain;
        String gadgURL = gadURL + ".generator";
        w.add("These Web pages are hosted on GitHub in the repository: "
                + w.getLink(gadURL, gadURL)
                + ". They have been generated using some Java code in the "
                + "repository: "
                + w.getLink(gadgURL, gadgURL)
                + "."
                + "Here is a link to my Github profile: "
                + w.getLink(gaURL, gaURL)
                + ". Below is a list of links to web site content.");
        w.add(Web_ContentWriter.PET);
        // Links
        int dirnc = dir.getNameCount();
        w.add(Web_ContentWriter.ULST);
        Iterator<Path> ite = subdirs.iterator();
        while (ite.hasNext()) {
            Path subdir = ite.next();
            int subdirnc = subdir.getNameCount();
            //String relpath = "";
            String relpath = "";
            //int depth = subdirnc - dirnc;
            for (int i = dirnc; i < subdirnc; i++) {
                w.add(Web_ContentWriter.ULST);
                w.add(Web_ContentWriter.LIST);
                String subdirname = subdir.getName(i).toString();
                //relpath = relpath.concat("../");
                relpath = relpath.concat(subdirname + "/");
                if (i == subdirnc - 1) {
                    w.add(w.getLink(relpath, 
                            Generic_String.getCapitalFirstLetter(subdirname)));
                } else {
                    w.add(Generic_String.getCapitalFirstLetter(subdirname));
                }
            }
            for (int i = dirnc; i < subdirnc; i++) {
                w.add(Web_ContentWriter.LIET);
                w.add(Web_ContentWriter.ULET);
            }
        }
        w.add(Web_ContentWriter.ULET);
        w.add(Web_ContentWriter.DIVET);
        String title = domain + A_Strings.symbol_space + name
                + A_Strings.symbol_space + "Page";
        w.writeHTML(dir, filename, title);
    }

    /**
     * For initial write of Web content.
     *
     * @param domain The domain name as a String.
     * @param dir The directory in which the content will be written.
     * @param subdirs The directories in the index.
     * @throws IOException If thrown.
     */
    public void writeIntroductionToPythonCourse(String domain, Path dir,
            Path subdir)
            throws IOException {
        String name = "Python";
        String filename = "index";
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }
        Web_ContentWriter w = new Web_ContentWriter();
        w.add(Web_ContentWriter.DIVST);
        w.add(Web_ContentWriter.H1ST,
                "Python".getBytes(),
                Web_ContentWriter.H1ET);
        w.add(Web_ContentWriter.PST);
        w.add("Python is an easy to learn, powerful programming language. "
                + "It has efficient high-level data structures and a simple "
                + "but effective approach to object-oriented programming. "
                + "Python’s elegant syntax and dynamic typing, together with "
                + "its interpreted nature, make it an ideal language for "
                + "scripting and rapid application development in many areas "
                + "on most platforms.");
        w.add(Web_ContentWriter.PET);
        w.add(Web_ContentWriter.PST);
        String pythonHome = "https://www.python.org/";
        w.add("The Python interpreter and the extensive standard library "
                + "are freely available in source or binary form for all major "
                + "platforms from the Python web site, "
                + w.getLink(pythonHome, pythonHome)
                + ", and may be freely distributed. The same site also "
                + "contains distributions of and pointers to many free third "
                + "party Python modules, programs and tools, and additional "
                + "documentation.");
        w.add(Web_ContentWriter.PET);
        w.add(Web_ContentWriter.PST);
        w.add("Python underwent a major revision from Python 2 to Python "
                + "3. It is important to be aware of this and to know exactly "
                + "what version of Python you are using and about any "
                + "modifications you have made to your Python environment.");
        w.add(Web_ContentWriter.PET);
        w.add(Web_ContentWriter.PST);
        String python3DocsHome = "https://docs.python.org/3/";
        String python3DocsTutorial = python3DocsHome + "tutorial/";
        String geogCourseComputingHome = "https://www.geog.leeds.ac.uk/courses/computing/";
        w.add("A getting started tutorial is available on the Python web "
                + "site, "
                + w.getLink(python3DocsTutorial, python3DocsTutorial)
                + ". This is almost certainly the best place to start if you "
                + "are a complete beginner and want to learn on your own. If "
                + "you want to learn with others, there are plenty of courses "
                + "to choose from. At the University of Leeds there are a "
                + "number of courses and I currently teach some of them, "
                + w.getLink(geogCourseComputingHome, geogCourseComputingHome)
                + ".");
        w.add(Web_ContentWriter.PET);
        // Links
        w.add(Web_ContentWriter.ULST);
        w.add(Web_ContentWriter.LIST);
        int dirnc = dir.getNameCount();
        int subdirnc = subdir.getNameCount();
        //String relpath = "";
        String relpath = "";
        //int depth = subdirnc - dirnc;
        for (int i = dirnc; i < subdirnc; i++) {
            relpath = relpath.concat("../");
            //relpath = relpath.concat(subdirname + "/");
            if (i == subdirnc - 1) {
                w.add(w.getLink(relpath, "Home"));
            }
        }
        w.add(Web_ContentWriter.LIET);
        w.add(Web_ContentWriter.ULET);
        w.add(Web_ContentWriter.DIVET);
        String title = domain + A_Strings.symbol_space + name
                + A_Strings.symbol_space + "Page";
        w.writeHTML(subdir, filename, title);
    }

}
