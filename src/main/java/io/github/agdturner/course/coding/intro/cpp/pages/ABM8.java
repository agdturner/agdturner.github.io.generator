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
package io.github.agdturner.course.coding.intro.cpp.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.coding.intro.cpp.CPPIntroCodingCourse;
import io.github.agdturner.course.CoursePage;

/**
 * For CPP Intro Course ABM8 Page.
 *
 * @author Andy Turner
 */
public class ABM8 extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public ABM8(CPPIntroCodingCourse course) {
        super(course, "abm8", "Agent Based Model Practical 8", "ABM8");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction and Preparation", sb);
        w.addP(sb,
                """
                This practical is about adding a Graphical User Interface (GUI).
                """);
        w.addP(sb,
                """
                In your local code repository 'src' directory duplicate your
                'abm7' directory and call the new directory 'abm8'.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Setting up Tkinter", sb);
        w.addP(sb,
                """
                Matplotlib has different 'backends' that allow it to render
                graphics in different ways. As the GUI will be developed using
                tkinter, it is necessary to change the matplotlib backend by
                adding the following at the top of 'model.py' before any other
                matplotlib imports:
                """);
        addCodeBlock(sb, "matplotlib.use('TkAgg')");
        w.addP(sb, "In Spyder, go to:");
        w.addPRE(sb, "Tools > Preferences > IPython console > Graphics tab");
        w.addP(sb,
                """
                Select 'Tkinter' from the 'Backend' drop down list. Click 'ok'.
                Then select:
                """);
        w.addPRE(sb, "File > Restart");
        w.addP(sb, "Save your files if prompted.");
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Organising the GUI", sb);
        w.addP(sb, "Add the following function to 'model.py':");
        addCodeBlock(sb,
                """
                def run(canvas):
                    animation = anim.FuncAnimation(fig, update, init_func=plot, frames=gen_function, repeat=False)
                    animation.new_frame_seq()
                    canvas.draw()
                """);
        w.addP(sb, "Add the following import statement to 'model.py':");
        addCodeBlock(sb, "import tkinter as tk");
        w.addP(sb,
                """
                In 'model.py' replace the following line (not the line in the
                new run function):
                """);
        addCodeBlock(sb,
                """
                animation = anim.FuncAnimation(fig, update, init_func=plot, frames=gen_function, repeat=False)
                """);
        w.addP(sb, "With:");
        addCodeBlock(sb,
                """
                # GUI
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
                tk.mainloop()
                """);
        w.addP(sb, "Add the following functions to 'model.py':");
        addCodeBlock(sb,
                """
                def output():
                    # Write data
                    print("write data")
                    io.write_data('../../data/output/out.txt', environment)
                    imageio.mimsave('../../data/output/out.gif', images, fps=3)

                def exiting():
                    \"""
                    Exit the program.
                    \"""
                    root.quit()
                    root.destroy()
                    #sys.exit(0)
                """);
        w.addP(sb, "Change the 'gen_function' from:");
        addCodeBlock(sb,
                """
                def gen_function():
                    global ite
                    global carry_on
                    while (ite <= n_iterations) & (carry_on) :
                        yield ite # Returns control and waits next call.
                        ite = ite + 1
                    global data_written
                    if data_written == False:
                        # Write data
                        print("write data")
                        io.write_data('../../data/output/out.txt', environment)
                        imageio.mimsave('../../data/output/out.gif', images, fps=3)
                        data_written = True
                """);
        w.addP(sb, "To:");
        addCodeBlock(sb,
                """
                def gen_function():
                    global ite
                    global carry_on
                    while (ite <= n_iterations) & (carry_on) :
                        yield ite # Returns control and waits next call.
                        ite = ite + 1
                    global data_written
                    if data_written == False:
                        # Set the Write data menu to normal.
                        menu_0.entryconfig("Write data", state="normal")
                        data_written = True
                """);
        w.addP(sb,
                """
                Now if the window in which the animation runs is closed, the
                program should exit and exiting the program is also added as a
                menu option in the GUI.
                """);
        w.addP(sb,
                """
                The 'output' function now deals with writing the outputs and
                this becomes actionable from the GUI once the simulation has
                run.
                """);
        w.addP(sb, "Run the program.");
        addCommitToGitHub(sb);
        w.addDIVET(sb);
        return sb.toString();
    }
}
