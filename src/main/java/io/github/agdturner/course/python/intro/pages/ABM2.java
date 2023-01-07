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
 * For Python Intro Course ABM2 Page.
 *
 * @author Andy Turner
 */
public class ABM2 extends Page {

    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public ABM2(PythonIntroCourse c) {
        super("abm2", "Agent Based Model Part 2", "ABM2", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2>Recap from last practical</h2>
              <p>Currently you code should look something like the following:
              </p>
              <pre><code class=\"language-python\">import random
              import math
              
              # Set the pseudo-random seed for reproducibility
              random.seed(0)
              # Initialise variable x0
              x0 = 0
              print("x0", x0)
              # Initialise variable y0
              y0 = 0
              print("y0", y0)
              # Change x0 and y0 randomly
              rn = random.random()
              if rn < 0.5:
                  x0 = x0 + 1
              else:
                  x0 = x0 - 1
              print("x0", x0)
              rn = random.random()
              print("rn", rn)
              if rn < 0.5:
                  y0 = y0 + 1
              else:
                  y0 = y0 - 1
              print("y0", y0)
              # Initialise variable x1
              x1 = 0
              print("x1", x1)
              # Initialise variable y1
              y1 = 0
              print("y1", y1)
              # Change x1 and y1 randomly
              rn = random.random()
              if rn < 0.5:
                  x1 = x1 + 1
              else:
                  x1 = x1 - 1
              print("x1", x1)
              rn = random.random()
              print("rn", rn)
              if rn < 0.5:
                  y1 = y1 + 1
              else:
                  y1 = y1 - 1
              print("y1", y1)
              # Calculate the Euclidean distance between (x0, y0) and (x1, y1)
              # Set x0 and y0 to equal 0, x1 to equal 3, and y1 to equal 4
              x0 = 0
              y0 = 0
              x1 = 3
              y1 = 4
              # Calculate the difference in the x coordinates.
              diff_x = x0 - x1
              # Calculate the difference in the y coordinates.
              diff_y = y0 - y1
              # Square the differences and add the squares
              ssd = (diff_x * diff_x) + (diff_y * diff_y)
              print("ssd", ssd)
              # Calculate the square root
              distance = ssd ** 0.5
              print("distance", distance)
              distance = math.sqrt(ssd)
              print("distance", distance)</code></pre>
              <p>The output from running it should be something like:</p>
              <pre>x0 0
              y0 0
              x0 -1
              rn 0.7579544029403025
              y0 -1
              x1 0
              y1 0
              x1 1
              rn 0.25891675029296335
              y1 1
              ssd 25
              distance 5.0
              distance 5.0</pre>
              To define a function, we use 
              the def keyword and we have to give the function a valid name. For the time being, we 
              want the function to have 4 parameters for the two coordinates and 
              we want it to return the distance between them.</p>
              <p>
              <h2>""");
        w.add("""
              <pre><code class="language-python">for j in range(num_of_iterations):
                  for i in range(num_of_agents):
                      if random.random() < 0.5:
                          agents[i][0] = (agents[i][0] + 1) % 100
                      else:
                          agents[i][0] = (agents[i][0] - 1) % 100
                      if random.random() < 0.5:
                          agents[i][1] = (agents[i][1] + 1) % 100
                      else:
                          agents[i][1] = (agents[i][1] - 1) % 100</code></pre>""");
        w.add("</div>");
    }
}
