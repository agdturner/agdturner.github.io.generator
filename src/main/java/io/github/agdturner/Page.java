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
import java.io.IOException;
import java.nio.file.Path;
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
     * Page Name
     */
    public final String name;
    
    /**
     * Page ID
     */
    public final PageID id;
    
    
    /**
     * Create a new instance.
     *
     * @param name What {@link #name} is set to.
     * @param id What {@link #id} is set to.
     */
    public Page(String name, PageID id){
        this.w = new Web_ContentWriter();
        this.name = name;
        this.id = id;
    }
    
    /**
     * For initial write of Web content.
     *
     * @param dir The directory in which the content will be written.
     * @throws IOException If thrown.
     */
    public abstract void write(Path dir) throws IOException;
    
    /**
     * Start the main div and write the title of the page in h1 tags.
     *
     * @param name The title of the page.
     */
    public void writeH1(String name) {
        w.add("<div>");
        w.add("<h1>" + name + "</h1>");
    }
    
}
