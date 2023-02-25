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
        w.add("""
              <h2 id="1">1. Introduction</h2>
              <p>A Graphical User Interface (GUI) is typically comprised of 
              rectangular windows and panels (parts of windows), a panal for 
              data display, menus, and various things called widgets (buttons, 
              sliders, and other things a user might interact with using a mouse 
              or keyboard.</p>
              <p>There are various alternatives for GUI development in Python.
              In this section, we briefly look at 
              <a href="https://docs.python.org/3/library/tkinter.html">
              TkInter</a> which is part of 
              <a href="https://docs.python.org/3/library/tk.html">tk</a>.</p> 
              <!--
              <p><a href="https://www.wxpython.org/">wxpython</a></p>
              -->
              <p>GUIs are event based, where some thread of the program is 
              typically looping and waiting for events to fire as a result 
              of user interaction. In Python this is facilitated by callbacks - 
              where a function is passed to another function, with the 
              expectation that (depending on conditions) the function will be 
              run. This involves registering a function with a GUI component 
              such that when the GUI component is actioned, the registered 
              function is called.</p>
              
              <h2 id="2">2. Getting Started with TkInter</h2>
              <p>The following code sets up a simple canvas for a GUI 
              and a main loop that waits for interactions with it:</p>
              <pre><code class="language-python">import tkinter
              
              root = tkinter.Tk() # Main window.
              
              c = tkinter.Canvas(root, width=200, height=200)
              c.pack() # Layout
              c.create_rectangle(0, 0, 200, 200, fill="blue")
              
              tkinter.mainloop() # Wait for interactions.</code></pre>
              <p>The following defines a function called run and registers this 
              to run when the command that is added to GUI menu is actioned.</p>
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
              
              <h2 id="3">3. GUI Design and Development</h2>
              <p>There are various important things to consider in designing a 
              GUI. Firstly, who are the users and what are the common things 
              they are going to want to do? What are they already familiar with?
              It is key to think about user experience and often it is helpful 
              to get feedback from users when designing and developing GUIs.</p>
              <p>It is often helpful to including help systems and tutorials 
              and do extensive 'usability testing'.</p>
              <p>At every stage when designing the GUI, think "is it obvious 
              what this does?"</p>
              <p>Often it is a good idea to keep the GUI simple and keep parts 
              hidden until they are called for or disabled until it is sensible 
              to action them. In Tkinter this is achieved with a parameter
              called "state".
              """);
//              <pre></pre>
//              <pre><code class="language-python"></code></pre>
//              <p></p>
//              <pre></pre>
        w.add("</div>");
    }
}
