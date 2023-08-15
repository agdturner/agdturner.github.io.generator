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
package io.github.agdturner.course.coding.intro.python.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.course.CoursePage;

/**
 * For Python Intro Course GUI Page.
 *
 * @author Andy Turner
 */
public class GUI extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public GUI(PythonIntroCodingCourse course) {
        super(course, "gui", "GUI", "GUI");
    }
    
    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        sb.append("<p>A "
                + index.getReference("GUI", "Graphical User Interface", sid)
                + " (GUI) is typically comprised of rectangular windows"
                + " containing panels and a menu bar. Panels can contain data"
                + " displays which can be made interactive, and widgets"
                + " (buttons, sliders, dials, text boxes and other things a"
                + " user might interact with). The menu bar is typically along"
                + " the top of a GUI window with cascading drop down menus that"
                + " appear if the menu is somehow selected.</p>\n");
        sb.append("<p>Most programs with a GUI have a thread that 'listens' for"
                + " interaction and then changes variables and calls functions"
                + " depending on the interaction with the GUI typically through"
                + " keyboard or mouse actions. This is usually regarded as a"
                + " form of 'event-based' programming.</p>\n");
        sb.append("<p>The Python standard library package and module for GUI"
                + " development is "
                + index.getReference("Python tkinter", "tkinter", sid)
                + " for which there is some "
                + index.getReference("Python tk",
                        "additional reference documentation.", sid)
                + ".</p>\n");
        sb.append("""
              <!--
              <p>There are various third party library alternatives, including:
              <a href="https://www.wxpython.org/">wxpython</a></p>
              -->
              """);
        sb.append("""
              <p>In tkinter, 'callbacks' are used to register a function with a 
              GUI component, so that when the GUI component is actioned, the 
              registered function is called. A callback is a function passed to 
              another function, with the expectation that (depending on 
              conditions) the function will be run. </p>
              """);

        sid = addSection("Getting Started with tkinter", sb);
        sb.append("""
              <p>The following code sets up a main window called 'root', a 
              'Label' called 'label', a 'Button' to modify the label text via 
              the 'increment' function and a 'Button' to exit the program via 
              the 'exiting' function. This code is also available in a file: 
              <a href="../../resources/gui/gui1.py">gui1.py</a></p>
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

        sid = addSubsection("TTK", sb);
        sb.append("""
              <p>A slightly different look is provided by a more recent "themed"
              toolkit. The following does the same, but uses 'ttk' for the 
              widgets. This code is also available in a file: 
              <a href="../../resources/gui/gui2.py">gui2.py</a></p>
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

        sid = addSubsection("Menus", sb);
        sb.append("""
              <p>The following builds on the example setting up a menu and also 
              configuring so that if the window is closed, then the program 
              exits. This code is also available in a file: 
              <a href="../../resources/gui/gui3.py">gui3.py</a></p>
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

        sid = addSection("Example scale or slider widget", sb);
        sb.append("""
              <p>The following sets up a scale or slider widget so that the user
              can move the slider to change the power used to dynamically scale 
              a small raster data set. This code is also available in a file: 
              <a href="../../resources/gui/gui4.py">gui4.py</a></p>
              <pre><code class="language-python">import tkinter as tk
              import tkinter.ttk as ttk
              import csv
              import matplotlib
              matplotlib.use('TkAgg')
              import matplotlib.pyplot as plt
              
              def read_data(path):
                  \"""
                  Read data.
              
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

        sid = addSection("GUI Design and Development", sb);
        sb.append("""
              <p>There are various important things to consider in designing a 
              GUI. Usually the aim is to provide a GUI that is intuitive to use.
              For software that does lots of things, it may be desriable to have
              parts of the interface hidden until activated, and to include a 
              help system where users can search for infomration about how to 
              use the software.</p>
              <p>In GUI design, it is often helpful to consider what are the 
              first and common things a user is likely to want to do. Also, what 
              are they already familiar with? Often it is helpful to get 
              feedback from users and involve them in GUI design and 
              development.</p>
              """);
//              <pre></pre>
//              <pre><code class="language-python"></code></pre>
//              <p></p>
//              <pre></pre>
        sb.append("</div>\n");
        return sb.toString();
    }
}
