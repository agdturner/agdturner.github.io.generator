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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * A Web Page.
 *
 * @author Andy Turner
 */
public abstract class Page {

    /**
     * The Web_ContentWriter.
     */
    public final Web_ContentWriter w;

    /**
     * Page Name (used for filenames).
     */
    public final String name;

    /**
     * Page Label (used for links).
     */
    public final String label;

    /**
     * Page ID
     */
    public final PageID id;

    /**
     * Path to the file.
     */
    public final Path p;

    /**
     * Create a new instance.
     *
     * @param name What {@link #name} is set to.
     * @param id What {@link #id} is set to.
     */
    public Page(String name, String label, PageID id, Path p) {
        this.w = new Web_ContentWriter();
        this.name = name;
        this.label = label;
        this.id = id;
        this.p = p;
    }
    
    /**
     * For writing the page to file.
     */
    public abstract void write();
    
    /**
     * Start the main div and write the title of the page in h1 tags.
     *
     * @param name The title of the page.
     */
    public void writeH1(String name) {
        w.add("<div>");
        w.add("""
              <button onclick="swapStyleSheet()" id="style_button"></button>""");
        w.add("<h1>" + name + "</h1>");
    }

    public static List<String> getHeaderElements() {
        ArrayList<String> r = new ArrayList<>();
        r.add("""
              <!-- Styling. -->
              <link id="code_theme" rel="stylesheet" type="text/css" href="">
              <script src="/scripts/style.js"></script>
              <script src="/tools/highlight/highlight.min.js"></script>
              <script>hljs.highlightAll();</script>
              <link rel="stylesheet" href="../../../../css/style.css">""");
        return r;
    }
}
