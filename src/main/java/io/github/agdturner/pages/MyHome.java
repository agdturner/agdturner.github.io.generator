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
package io.github.agdturner.pages;

import io.github.agdturner.MySite;
import io.github.agdturner.core.Environment;
import io.github.agdturner.core.Page;
import io.github.agdturner.core.PageID;
import io.github.agdturner.core.Site;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Java for generating my home page.
 *
 * @author Andy Turner
 */
public class MyHome extends Page {
    
    public static final Path DIR = Paths.get("C:", "Users", "geoagdt", "src", 
            "agdt", Environment.AGDTURNER_GITHUB_IO);
    
    /**
     * Create a new instance.
     * @param site What {@link #site} is set to.
     * @param title What {@link #title} is set to.
     * @param id What {@link #pageID} is set to.
     * @param path What {@link #p} is set to.
     */
    public MyHome(Site site, String title, PageID id, Path path) {
        super(site, "index", title, "Index", id, path);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException ex) {
                Logger.getLogger(MyHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("<div>");
        sb.append("<h1><img src=\"./images/a.turner.png\" alt=\"Andy Turner profile "
                + "picture head and shoulders\" /></h1>");
        sb.append("<p>In June 2023 I joined the "
                + "<a href=\"" + Environment.HTTPS_ARC_LEEDS_AC_UK + "about/team/\">"
                + "Research Computing Team"
                + "</a>"
                + " at the "
                + "University of Leeds"
                + " as a Research Software Engineer. I have "
                + "worked at the University for over 25 years mostly "
                + "specialising in computational geography.</p>");
        sb.append("<p>"
                + Web_ContentWriter.getLink(Environment.HTTPS_WWW_GITHUB_COM_AGDTURNER,
                        "Github Profile")
                + "</p>");
        // End WebPage
        sb.append(Web_ContentWriter.DIVET);
        return sb.toString();
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        String name = "Andy Turner " + Environment.AGDTURNER_GITHUB_IO + " Home Page";
        PageID id = new PageID(0);
        MySite site = new MySite(new Environment(Environment.AGDTURNER_GITHUB_IO, DIR));
        MyHome myHome = new MyHome(site, name, id, DIR);
        myHome.write();
    }

    @Override
    public String getLinks(String linkClass, boolean addPrevious) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getPageContents() {
        return "";
    }
    
    
}
