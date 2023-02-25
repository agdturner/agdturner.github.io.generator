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
        super("abm8", "Agent Based Model Part 8", "ABM8", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2 id="1">1. Introduction and Preparation</h2>
              <p>This practical is about adding a Graphical User Interface so 
              that users can run the model.</p>
              <p>In your local code repository src directory duplicate your abm7
              directory and call the new directory "abm8".</p>
              
              <h2 id="2">2. Setting up Tkinter<h2>
              <p>Matplotlib has different "backends" that allow it to render 
              graphics in different ways. As the GUI will be developed using 
              tkinter, it is necessary to change the matplotlib backend by 
              adding the following at the top of your model.py file before
              any other matplotlib imports:</p>
              <pre><code class="language-python">import matplotlib
              matplotlib.use('TkAgg')</code></pre>
              <p>In Spyder, go to:</p>
              <pre>Tools > Preferences > IPython console > Graphics tab</pre>
              <p>And select "Tkinter" from the "Backend" drop down list. Click
              "ok". Then select:
              <pre>File > Restart</pre>
              <p>save your files and restart Spyder.</p>
              
              <h2 id="3">3. Organising the GUI</h2>
              <p>Add the following funtion:</p>
              
              Next, let's add a function that will run our model. We'll connect this to our menu such that when the menu is clicked, this function will run, in line with the event based programming model. Note that what you put in the line to run the model will depend what you did with the animation; you may need to adjust the line to match whatever you have:
              
              <pre><code class="language-python">def run():
                  animation = matplotlib.animation.FuncAnimation(fig, update, frames=gen_function, repeat=False)
                  canvas.draw()</code></pre>
              
              Note also that whereas we did have matplotlib.plot.show() we've replaced this and put in canvas.draw(). We'll come to canvas in a second, but for now make sure matplotlib.plot.show() has been deleted from you code (or you'll get two windows).
              """);
//              <pre></pre>
//              <pre><code class="language-python"></code></pre>
//              <p></p>
//              <pre></pre>
        w.add("</div>");
    }
}
