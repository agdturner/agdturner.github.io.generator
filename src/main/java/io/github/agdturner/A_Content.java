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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
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
     * @param args 
     */
    public static void main(String[] args) {
        A_Content hw = new A_Content();
        String domain = "agdturner.github.io";
        Path dir = Paths.get("C:", "Users", "agdtu", "src", "agdt", domain);
        try {
            // Home Page index
            hw.writeIndex(domain, dir);
        } catch (IOException ex) {
            Logger.getLogger(A_Content.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * For initial write of Web content.
     * 
     * @param domain The domain name as a String.
     * @param name The name of the content.
     * @param filename The filename for the content.
     * @param dir The directory in which the content will be written in a 
     * directory called "output".
     * @param version The version of the content.
     * @throws IOException If thrown.
     */
    public void writeIndex(String domain, Path dir)
            throws IOException {
        String name = "Home";
        String filename = "index";
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }
        Web_ContentWriter w = new Web_ContentWriter();
        w.add(Web_ContentWriter.DIVST);
        w.add(Web_ContentWriter.PST, 
                "<img src=\"./images/a.turner.png\" alt=\"Andy Turner\" />"
                        .getBytes(),
                Web_ContentWriter.PET);
        w.add(Web_ContentWriter.PST);
        w.add("Welcome! I am a research officer based in the School of "
                + "Geography at the University of Leeds. I teach on courses "
                + "that introduce R and Python. I mostly program using Java, "
                + "Maven and Netbeans. I am interested in developing dynamic "
                + "spatial models and processing geographical data. These Web "
                + "pages are hosted on GitHub, here is a link to my profile: "
                + "<a href=\"http://github.com/agdturner\">"
                + "http://github.com/agdturner</a>.");
        w.add(Web_ContentWriter.PET);
        w.add(Web_ContentWriter.DIVET);
        String title = domain + A_Strings.symbol_space + name
                + A_Strings.symbol_space + "Page";
        w.writeHTML(dir, filename, title);
    }
}
