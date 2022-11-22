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

import io.github.agdturner.core.PageID;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * A Web WebPage.
 *
 * @author Andy Turner
 */
public abstract class WebPage {

    /**
     * The Web_ContentWriter.
     */
    public final Web_ContentWriter w;

    /**
     * Name used for filenames.
     */
    public final String filename;

    /**
     * Used for Title and H1.
     */
    public final String title;

    /**
     * Used for links.
     */
    public final String label;

    /**
     * WebPage ID
     */
    public final PageID id;

    /**
     * Path to the file.
     */
    public final Path p;

    /**
     * Create a new instance.
     *
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     * @param id What {@link #id} is set to.
     * @param p What {@link #p} is set to.     * 
     */
    public WebPage(String filename, String title, String label, PageID id, Path p) {
        this.w = new Web_ContentWriter();
        this.filename = filename;
        this.title = title;
        this.label = label;
        this.id = id;
        this.p = p;
    }
    
    /**
     * For writing the page to file.
     */
    public abstract void write();

    public void writeH1() {
        w.add("<div>");
        w.add("<h1>" + title + "</h1>");
    }
    
    public static List<String> getHeadElements() {
        ArrayList<String> r = new ArrayList<>();
        r.add("""
              <!-- Styling. -->
              <!-- The following href is blank, but will be populated once the
              DOM is fully loaded. -->
              <link id="css" rel="stylesheet" type="text/css" href="">\
              <script src="/scripts/style.js"></script>
              <!-- The following are used for stying code. -->
              <script src="/tools/highlight/highlight.min.js"></script>
              <script>hljs.highlightAll();</script>
              <link id="code_theme" rel="stylesheet" type="text/css" href="">""");
//        r.add("""
//              <!-- Styling. -->
//              <!-- The following href is blank, but will be populated once the
//              DOM is fully loaded. -->
//              <link id="css" rel="stylesheet" type="text/css" href="">\
//              <script src="/scripts/style.js"></script>
//              <!-- The following are used for stying code. -->
//              <script src="/tools/highlight/highlight.min.js"></script>
//              <script>hljs.highlightAll();</script>
//              <link id="code_theme" rel="stylesheet" type="text/css" href="">""");
        r.add("""
              <!-- Styling. -->
              <script src="/scripts/style.js"></script>
              <!-- The following are used for stying code. -->
              <script src="/tools/highlight/highlight.min.js"></script>
              <script>hljs.highlightAll();</script>
              <!-- The following href should be set when the DOM is loaded. -->
              <link id="css1" rel="stylesheet" type="text/css" href="">
              <link id="css2" rel="stylesheet" type="text/css" href="">""");
        return r;
    }
}
