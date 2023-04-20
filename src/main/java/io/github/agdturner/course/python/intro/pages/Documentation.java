/*
 * Copyright 2022 Centre for Computational Geography.
 *
 * Licensed under the Apache License, Version 2.0 (the"License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an"AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.agdturner.course.python.intro.pages;

import io.github.agdturner.core.Section;
import io.github.agdturner.course.python.intro.PythonIntroCourse;
import io.github.agdturner.course.Page;

/**
 * For Python Intro Course Branching and Loops Page.
 *
 * @author Andy Turner
 */
public class Documentation extends Page {
    
    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Documentation(PythonIntroCourse c) {
        super("documentation", "Documentation", "Documentation", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        Section s;
        s = addSection("1", "Introduction", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p><a href="https://docs.python.org/3/library/doctest.html">
              PyDoc</a> is the documentation system distributed with Python.
              It supports the generation of a webpage from documentation, and 
              can be run from the Anaconda Prompt using:</p>
              <pre>pydoc -w filename</pre>
              <p>Where the filename is missing the ".py" part.</p>
              <p>There are other tools for helping to generate documentation, 
              including
              <a href="http://www.sphinx-doc.org/en/stable/">Sphinx</a>, which 
              comes with Anaconda.</p>
              """);
        
        w.add("</div>");
    }
}
