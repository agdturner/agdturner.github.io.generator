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
                + " containing panels and a menu bar. Panels can contain data"
                + " displays which can be made interactive, and widgets"
                + " (buttons, sliders, dials, text boxes and other things a"
                + " user might interact with). The menu bar is typically along"
                + " the top of a GUI window with cascading drop down menus that"
                + " appear if the menu is somehow selected.</p>");
        w.add("<p>Most programs with a GUI have a thread that 'listens' for"
                + " interaction and then changes variables and calls functions"
                + " depending on the interaction with the GUI typically through"
                + " keyboard or mouse actions. This is usually regarded as a"
                + " form of 'event-based' programming.</p>");
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
              <p>In tkinter, 'callbacks' are used to register a function with a 
              GUI component, so that when the GUI component is actioned, the 
              registered function is called. A callback is a function passed to 
              another function, with the expectation that (depending on 
              conditions) the function will be run. </p>
              """);
        
        s = addSection("2", "Getting Started with tkinter", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>The following code sets up a main window called 'root', a 
              'Label' called 'label', a 'Button' to modify the label text via 
              the 'increment' function and a 'Button' to exit the program via 
              the 'exiting' function:</p>
              <pre><code class="language-python">import tkinter as tk
              
              def increment():
                  global i
                  i = i + 1
                  label.config(text=str(i))
              
              def exiting():
                  \"""
                  Exit the program.
                  \"""
                  root.quit()
                  root.destroy()
                  #sys.exit(0)
                  
              # Create the tkinter window
              root = tk.Tk()
              i = 0
              # Create a Label widget
              label = tk.Label(root, text=str(i))
              # Create a Button widget and link this with the increment function
              increment_button = tk.Button(root, text="Increment", command=increment)
              # Create a Button widget and link this with the exiting function
              exit_button = tk.Button(root, text="Exit", command=exiting)
              
              # Pack widgets so they are visible.
              label.pack()
              increment_button.pack()
              exit_button.pack()
               
              # Start the GUI
              root.mainloop()</code></pre>
              """);
        
        s = addSection("2.1", "TTK", 3);
        w.add(s.sectionHTML);
        w.add("""
              <p>A slightly different look is provided by a more recent "themed"
              toolkit. The following does the same, but uses 'ttk' for the 
              widgets:</p>
              <pre><code class="language-python">import tkinter as tk
              import tkinter.ttk as ttk
              
              def increment():
                  global i
                  i = i + 1
                  label.config(text=str(i))
              
              def exiting():
                  \"""
                  Exit the program.
                  \"""
                  root.quit()
                  root.destroy()
                  #sys.exit(0)
                  
              # Create the tkinter window
              root = tk.Tk()
              i = 0
              # Create a Label widget
              label = ttk.Label(root, text=str(i))
              # Create a Button widget and link this with the increment function
              increment_button = ttk.Button(root, text="Increment", command=increment)
              # Create a Button widget and link this with the exiting function
              exit_button = ttk.Button(root, text="Exit", command=exiting)
              
              # Pack widgets so they are visible.
              label.pack()
              increment_button.pack()
              exit_button.pack()
               
              # Start the GUI
              root.mainloop()</code></pre>
              """);
        
        s = addSection("2.2", "Menus", 3);
        w.add(s.sectionHTML);
        w.add("""
              <p>The following builds on the example setting up a menu and also 
              configuring so that if the window is closed, then the program 
              exits.</p>
              <pre><code class="language-python">import tkinter as tk
              import tkinter.ttk as ttk
              
              def increment():
                  global i
                  i = i + 1
                  label.config(text=str(i))
              
              def exiting():
                  \"""
                  Exit the program.
                  \"""
                  root.quit()
                  root.destroy()
                  #sys.exit(0)
                  
              # Create the tkinter window
              root = tk.Tk()
              
              # Create a menu bar
              menu_bar = tk.Menu(root)
              root.config(menu=menu_bar)
              increment_menu = tk.Menu(menu_bar)
              menu_bar.add_cascade(label="Options", menu=increment_menu)
              increment_menu.add_command(label="Increment", command=increment)
              exit_menu = tk.Menu(menu_bar)
              menu_bar.add_cascade(label="Exit", menu=exit_menu)
              exit_menu.add_command(label="Exit", command=exiting)
              
              i = 0
              # Create a Label widget
              label = ttk.Label(root, text=str(i))
              # Create a Button widget and link this with the increment function
              increment_button = ttk.Button(root, text="Increment", command=increment)
              # Create a Button widget and link this with the exiting function
              exit_button = ttk.Button(root, text="Exit", command=exiting)
              
              # Pack widgets so they are visible.
              label.pack()
              increment_button.pack()
              exit_button.pack()
              
              # Exit if the window is closed.
              root.protocol('WM_DELETE_WINDOW', exiting)
              
              # Start the GUI
              root.mainloop()</code></pre>
              """);
        
        s = addSection("3", "Example scale or slider widget", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>The following sets up a scale or slider widget so that the user
              can move the slider to change the power used to dynamically scale 
              a small raster data set.</p>
              <pre><code class="language-python">import tkinter as tk
              import tkinter.ttk as ttk
              import csv
              import matplotlib
              import matplotlib.pyplot as plt
              
              def read_data(path):
                  \"""
                  
              
                  Parameters
                  ----------
                  path : String
                      Path of the file to be read. The file is expected to be a rectangular 
                      2D CSV format data with numerical values. 
              
                  Returns
                  -------
                  data : List of lists
                      The data in row major order.
              
                  \"""
                  f = open(path)
                  data = []
                  for line in csv.reader(f, quoting=csv.QUOTE_NONNUMERIC):
                      row = []
                      for value in line:
                          row.append(value)
                      data.append(row)
                  f.close()
                  #print(data)
                  return data
              
              def plot(p):
                  \"""
                  Redraws the canvas if there is a new power.
              
                  Parameters
                  ----------
                  p : int
                      The power to raise values to.
              
                  Returns
                  -------
                  None.
              
                  \"""
                  global p0
                  if p0 != p:
                      figure.clear()
                      #print(p)
                      data_p = []
                      #data.reverse()
                      for row in data:
                          row_p = []
                          for val in row:
                             row_p.append(val ** p)
                          data_p.append(row_p)
                      plt.imshow(data_p)
                      plt.show()
                      p0 = p
                      canvas.draw()
              
              def exiting():
                  \"""
                  Exit the program.
                  \"""
                  root.quit()
                  root.destroy()
                  \"""
                  Exit the program.
                  \"""
                  root.quit()
                  try:
                      root.destroy()
                  except Exception:
                      # Prevents reporting of a harmless Tcl error message:
                      # "TclError: can't invoke "destroy" command: application has been destroyed"
                      pass
              
              def update(x):
                  \"""
                  Updates scale_label and canvas.
              
                  Parameters
                  ----------
                  x : str.
                      Number.
              
                  Returns
                  -------
                  None.
              
                  \"""
                  #print(x)
                  #print(type(x))
                  #print(scale.get())
                  #print(int(float(scale.get())))
                  # Integerise p
                  p = int(float(scale.get()))
                  scale_label.config(text='power=' + str(p))
                  plot(p)
              
              # Initialise figure
              figure = matplotlib.pyplot.figure(figsize=(7, 7))
              #ax = figure.add_axes([0, 0, 1, 1])
              
              # Initialise data
              data = read_data('../../data/input/in.txt')
              
              # Initialise p0
              p0 = None
              
              # Create the tkinter window
              root = tk.Tk()
              
              # Create a canvas to display the figure
              canvas = matplotlib.backends.backend_tkagg.FigureCanvasTkAgg(figure, master=root)
              canvas._tkcanvas.pack(side=tk.TOP, fill=tk.BOTH, expand=1)
              
              # Create a scale
              scale = ttk.Scale(root, from_=1, to=10, command=update)
              scale.pack()
              
              # Create a Label widget to display scale value
              scale_label = ttk.Label(root, text='Move the scale slider to choose a power and see an image.')
              scale_label.pack()
              
              # Create a Button widget and link this with the exiting function
              exit_button = ttk.Button(root, text="Exit", command=exiting)
              exit_button.pack()
              
              # Exit if the window is closed.
              root.protocol('WM_DELETE_WINDOW', exiting)
              
              # Start the GUI
              root.mainloop()</code></pre>
              """);
                
        s = addSection("4", "GUI Design and Development", 2);
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
