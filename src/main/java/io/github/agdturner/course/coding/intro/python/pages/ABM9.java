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
 * For Python Intro Course ABM8 Page.
 *
 * @author Andy Turner
 */
public class ABM9 extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public ABM9(PythonIntroCodingCourse course) {
        super(course, "abm9", "Agent Based Model Practical 9", "ABM9");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction and Preparation", sb);
        w.addP(sb,
                """
                This practical is about using some data in an HTML file Table to
                initialise part of the model.
                """);
        w.addP(sb,
                """
                In your local code repository 'src' directory duplicate your
                'abm8' directory as 'abm9'.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Parsing an HTML File", sb);
        w.addP(sb,
                """
                <a href="../../resources/abm9/data.html">The HTML to parse</a>.
                """);
        w.addP(sb,
                """
                Have a look at the source code for the file by either opening it
                in a text editor or viewing the source in your Web browser.
                <!--
                (The Python code used to generate data.html:
                <a href="../../resources/abm9/data.py">data.py</a>.)
                -->
                """);
        w.addP(sb, "Add the following import statements to 'model.py':");
        addCodeBlock(this.getCourse().courseType, sb,
              """
              import requests
              import bs4
              """);
        w.addP(sb,
                "Change the agent initialisation code block as follows:");
        String url = "https://" + site.env.domain + "/resources/abm9/data.html";
        addCodeBlockStart(this.getCourse().courseType, sb,
                """
                # Initialise agents
                """);
        sb.append("url = '" + url + "'");
        addCodeBlockEnd(sb,
                """
                r = requests.get(url, verify=False)");
                content = r.text
                soup = bs4.BeautifulSoup(content, 'html.parser')
                td_ys = soup.find_all(attrs={"class" : "y"})
                td_xs = soup.find_all(attrs={"class" : "x"})
                print(td_ys)
                print(td_xs)
                agents = []
                for i in range(n_agents):
                    # Create an agent
                    y = int(td_ys[i].text) + 99
                    x = int(td_xs[i].text) + 99
                    agents.append(af.Agent(agents, i, environment, n_rows, n_cols, x, y))
                    print(agents[i].agents[i])
                """);
        w.addP(sb,
                "Change the '__init__' function in 'agentframework.py' to:");
        addCodeBlock(this.getCourse().courseType, sb,
                """
                def __init__(self, agents, i, environment, n_rows, n_cols, x = None, y = None):
                \"""
                The constructor method.

                Parameters
                ----------
                i : Integer
                    To be unique to each instance.
                environment : List
                    A reference to a shared environment.
                n_rows : Integer
                    The number of rows in environment.
                n_cols : Integer
                    The number of columns in environment.
                x : Integer
                    For initialising the x coordinate of the agent.
                y : Integer
                    For initialising the y coordinate of the agent.

                Returns
                -------
                None.

                \"""
                self.agents = agents
                self.i = i
                self.environment = environment
                if x == None:
                    tnc = int(n_cols / 3)
                    self.x = random.randint(tnc - 1, (2 * tnc) - 1)
                else:
                    self.x = x
                if y == None:
                    tnr = int(n_rows / 3)
                    self.y = random.randint(tnr - 1, (2 * tnr) - 1)
                else:
                    self.y = y
                self.store = random.randint(0, 99)
                self.store_shares = 0
                """);
        w.addDIVET(sb);
        return sb.toString();
    }
}
