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
 * For Python Intro Course ABM8 Page.
 *
 * @author Andy Turner
 */
public class ABM8 extends Page {
    
    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public ABM8(PythonIntroCourse c) {
        super("abm8", "Agent Based Model Practical 8", "ABM8", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        Section s;
        s = addSection("1", "Introduction and Preparation", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>This practical is about adding a Graphical User Interface 
              (GUI).</p>
              <p>In your local code repository 'src' directory duplicate your 
              'abm7' directory and call the new directory 'abm8'.</p>
              
              <h2 id="2">2. Setting up Tkinter</h2>
              <p>Matplotlib has different 'backends' that allow it to render 
              graphics in different ways. As the GUI will be developed using 
              tkinter, it is necessary to change the matplotlib backend by 
              adding the following at the top of 'model.py' before any other 
              matplotlib imports:</p>
              <pre><code class="language-python">import matplotlib
              matplotlib.use('TkAgg')</code></pre>
              <p>In Spyder, go to:</p>
              <pre>Tools > Preferences > IPython console > Graphics tab</pre>
              <p>Select 'Tkinter' from the 'Backend' drop down list. Click
              'ok'. Then select:
              <pre>File > Restart</pre>
              <p>Save your files if prompted.</p>
              
              <h2 id="3">3. Organising the GUI</h2>
              <p>Add the following function to 'model.py':</p>
              <pre><code class="language-python">def run(canvas):
                  animation = anim.FuncAnimation(fig, update, init_func=plot, frames=gen_function, repeat=False)
                  animation.new_frame_seq()
                  canvas.draw()</code></pre>
              <p>Add the following import statement to 'model.py':</p>
              <pre><code class="language-python">import tkinter as tk</code></pre>
              <p>In 'model.py' replace the following line (not the line in the new run function):</p>
              <pre><code class="language-python">animation = anim.FuncAnimation(fig, update, init_func=plot, frames=gen_function, repeat=False)</code></pre>
              <p>With:</p>
              <pre><code class="language-python"># GUI
              root = tk.Tk()
              root.wm_title("Agent Based Model")
              canvas = matplotlib.backends.backend_tkagg.FigureCanvasTkAgg(fig, master=root)
              canvas._tkcanvas.pack(side=tk.TOP, fill=tk.BOTH, expand=1)
              menu_bar = tk.Menu(root)
              root.config(menu=menu_bar)
              menu_0 = tk.Menu(menu_bar)
              menu_bar.add_cascade(label="Model", menu=menu_0)
              menu_0.add_command(label="Run model", command=lambda: run(canvas))
              menu_0.add_command(label="Write data", command=lambda: output())
              menu_0.add_command(label="Exit", command=lambda: exiting())
              menu_0.entryconfig("Write data", state="disabled")
              # Exit if the window is closed.
              root.protocol('WM_DELETE_WINDOW', exiting)
              tk.mainloop()</code></pre>
              <p>Add the following function:</p>
              <pre><code class="language-python">def exiting():
                  \"""
                  Exit the program.
                  \"""
                  root.quit()
                  root.destroy()
                  #sys.exit(0)</code></pre>
              <p>Now if the window in which the animation runs is closed, the 
              program should exit and exiting the program is also added as a 
              menu option in the GUI.</p>
              <p>Run the program.</p>
              <p>Commit your code to your local repository and assuming you 
              are using GitHub - push your changes to GitHub.</p>
              """);
        w.add("</div>");
    }
}
