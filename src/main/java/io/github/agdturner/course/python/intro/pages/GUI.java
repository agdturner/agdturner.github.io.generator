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
 * For Python Intro Course GUI Page.
 *
 * @author Andy Turner
 */
public class GUI extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public GUI(PythonIntroCourse c) {
        super("gui", "GUI", "GUI", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        Section s;
        s = addSection("1", "Introduction", 2);
        w.add(s.sectionHTML);
        w.add("<p>A "
                + c.index.getReference("GUI", "Graphical User Interface", s.sid)
                + " (GUI) is typically comprised of rectangular windows"
                + " containing panels and a menu. Panels can contain data"
                + " displays which can be made interactive, and widgets"
                + " (buttons, sliders, dials, text boxes and other things a"
                + " user might interact with). There is often a menu (or 'menu"
                + " bar') typically along the top of a GUI window with menus"
                + " and 'menu items' that drop down and form cascading lists"
                + " when the menu is used.</p>");
        w.add("<p>A GUI is event based, where some thread of the program is"
                + " typically looping and waiting for events to fire as a"
                + " result of user interaction typically via a keyboard or"
                + " mouse.</p>");
        w.add("<p>The Python standard library package and module for GUI"
                + " development is "
                + c.index.getReference("Python tkinter", "tkinter", s.sid)
                + " for which there is some "
                + c.index.getReference("Python tk", 
                        "additional reference documentation.", s.sid)
                + ".</p>");
        w.add("""
              <!--
              <p>There are various third party library alternatives, including:
              <a href="https://www.wxpython.org/">wxpython</a></p>
              -->
              """);
        w.add("""
              <p>In Python, GUI events are facilitated by 'callbacks' - where a 
              function is passed to another function, with the expectation that 
              (depending on conditions) the function will be run. This involves 
              registering a function with a GUI component, so that when the 
              GUI component is actioned, the registered function is called.</p>
              """);
        
        s = addSection("2", "Getting Started with tkinter", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>The following code sets up a simple canvas for a GUI and a 
              main loop that waits for interactions with it:</p>
              <pre><code class="language-python">import tkinter
              
              root = tkinter.Tk() # Main window.
              
              c = tkinter.Canvas(root, width=200, height=200)
              c.pack() # Layout
              c.create_rectangle(0, 0, 200, 200, fill="blue")
              
              tkinter.mainloop() # Wait for interactions.</code></pre>
              <p>The following defines a function called 'run' and registers 
              this to be executed a GUI menu command is actioned.</p>
              <pre><code class="language-python">import tkinter
              def run():
                  pass
              
              # Menu elements
              root = tkinter.Tk()
              menu_bar = tkinter.Menu(root)
              root.config(menu=menu_bar)
              model_menu = tkinter.Menu(menu_bar)
              menu_bar.add_cascade(label="Model", menu=model_menu)
              model_menu.add_command(label="Run model", command=run)
              
              tkinter.mainloop() # Wait for interactions.</code></pre>
              <p>The run function does nothing currently, but try this code 
              yourself and print something in the run function to check it 
              works.</p>
              """);
        
        s = addSection("3", "GUI Design and Development", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>There are various important things to consider in designing a 
              GUI. Firstly, who are the users and what are the common things 
              they are going to want to do? What are they already familiar with?
              It is key to think about user experience and often it is helpful 
              to get feedback from users when designing and developing GUIs
              and do extensive 'usability testing'.</p>
              <p>For complicated software, it is often good to include a help
              system as part of a GUI.</p>
              <p>At every stage when designing a GUI, think "is it obvious 
              what this does?"</p>
              <p>Often it is a good idea to keep the GUI simple and keep parts 
              hidden until they are called for or disabled until it is sensible 
              to action them.</p>
              """);
//              <pre></pre>
//              <pre><code class="language-python"></code></pre>
//              <p></p>
//              <pre></pre>
        w.add("</div>");
    }
}
