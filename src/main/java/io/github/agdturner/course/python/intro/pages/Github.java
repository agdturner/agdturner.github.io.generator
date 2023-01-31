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
 * Java for generating github page.
 *
 * @author Andy Turner
 */
public class Github extends Page {
    
    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Github(PythonIntroCourse c) {
        super("github", "GitHub", "GitHub", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2 id="1">1. Introduction</h2>
              <p><a href="http://www.github.com">GitHub</a> is a
              <a href="https://en.wikipedia.org/wiki/Git">Git</a>
              based code hosting platform for version control and collaboration. 
              "It lets you and others work together on projects from anywhere."
              </p>
              <p>GitHub makes it easy to get involved in code development, and 
              provides hosting for basic Web sites. It is popular and reliable.
              </p>
              <p>For a history of GitHub have a look at the Wikipeida article:
              <a href="https://en.wikipedia.org/wiki/GitHub">
              https://en.wikipedia.org/wiki/GitHub</a></p>
              <p>Assuming you are fine with the terms and conditions, please 
              create a
              <a href="http://www.github.com">GitHub</a> account choosing a 
              username comprising lower case letters and numbers. You do not 
              need a GitHub account to complete this course, but it is 
              recommended. There are other ways that you can use version control 
              and create a basic Website which form part of the 
              assignments/assessment</p>
              
              <h2 id="2">2. Getting Started with GitHub</h2>
              <p>Complete the
              <a href="https://docs.github.com/en/get-started/quickstart/hello-world">
              Hello World Tutorial</a>.</p>
              <p>If you are using a University of Leeds machine you can access 
              Git client software via AppsAnywhere and the Windows Vitual 
              Desktop:
              <a href="https://wvd.leeds.ac.uk">https://wvd.leeds.ac.uk</a>.
              Alternatively, 
              <a href="https://docs.github.com/en/get-started/quickstart/set-up-git#setting-up-git">
              follow these instructions to setup a 
              <a href="https://git-scm.com/downloads">Git Client<a> on your 
              local machine</a>.</p>
              <p>Complete the
              <a href="https://docs.github.com/en/get-started/quickstart/create-a-repo">
              GitHub Create a Repository Tutorial</a> and clone the repository 
              to the local machine you are using by following the
              <a href="https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository">
              GitHub Clone a Repository Tutorial</a>.</p>
              <p>If you have followed correctly, you should now have a 
              hello-world local git repository cloned from a hello-world 
              remote repository on GitHub.</p>
              <p>Now to practice making changes and keeping things synchronised: 
              First, make a change in the local hello-world repository, commit 
              the change, and then push the change to the remote repository on 
              GitHub:<p>
              <ol>
              <li>Open the local copy of README.md in a text editor, make a 
              change (for example, add some lines of text) and save the file.
              </li>
              <li>Open the git client Command Line Interface (CLI) and change to 
              the local repository directory.</li>
              <li>Commit the change to the local repository and then push this 
              change to the remote repository on GitHub using the following 
              commands:
              <pre>git add .
              git commit -m "change commit message to make it informative"
              git push</pre>
              </li>
              </ol>
              <p>There are alternative ways to do this, but this way is 
              recommended.</p>
              <p>Now, check on GitHub that the README.md file has changed. You 
              may need to reload the Web page in order to see the change.</p>
              <p>Next, change the file on the remote GitHub repository using the 
              browser and commit the change there: To edit the README click on 
              the Edit Button which looks like a pen (in dark mode it looks 
              like the following where the button is identified with a red 
              elipse:
              <img src="../resources/github/edit.png"  alt="GitHub README edit 
              button" />), then click on the "Commit changes" button which 
              should save the changes.</p>
              <p>At this stage the remote repository is "ahead" of the local 
              repository which is "behind". To synchronize, we can pull the 
              committed remote repository change to the local repository: In the 
              git bash tool in the repository directory directory enter:</p>
              <pre>git pull</pre>
              <p>You should see confirmation of this pulling the remote 
              repository changes to the local repository.</p>
              <p>There is a lot to learn with a versioning system and with 
              having multiple clones of repositories. Indeed there is a lot to 
              GitHub that we are not going to learn about and use in this 
              course. We are not going to learn about forking repositories, 
              creating branches, creating issues and resolving these by 
              submitting and accepting pull requests. These are all key steps in 
              collaborating on shared code bases in the GitHub ecosystem which 
              is typically what a lot of team programming involves nowadays.</p>
              <p>Something you may have to learn about is to deal with merge 
              conflicts. This is when changes have been made to the same file 
              and in the same places such that the act of sychronizing the 
              repositories now requires decisions to be made about which 
              changes to keep. Let us deal with that in an ad hoc manner if and 
              when it happens.</p>
              <p>One of the main benefits of using git or a similar repository 
              like system is that all changes are recorded and versioned, so it 
              is possible to back track and without having to do all this 
              yourself.</p>
              
              <h2 id="3">3. Python Code Repository Setup</h3>
              <p>Create a new repository on GitHub which will be your code 
              repository for this course, call it something simple (you can 
              rename it later), include a README and a LICENSE and in .gitignore
              choose Python. Spend some time to 
              <a href="https://choosealicense.com/">choose a license</a> and 
              select this from the options available. There are a few different 
              kinds. You are advised against write your own license from 
              scratch. The license is a legal document the typically stipulate 
              terms of use, modification and redistribution and provides a 
              disclaimer to indemnify developers just in case something bad 
              happens.</p>
              <p>Clone your new repository so you have a local repository. 
              Create a new folder/directory in the repository called test. 
              Start Spyder; add a Python command to the file that opens by 
              default and save this into your test directory. Add and Commit 
              changes to the local repository and push the changes to the remote
              GitHub repository. Finally check the new file appears in GitHub.
              </p>
              <p>Run the new Python file you have created. A directory named 
              __pycache__ should appear in the test directory with python source 
              code file. This contains interpretted files generated by the 
              Python interpretter when the Python source code is run. The 
              .gitignore settings for Python will not push this directory to 
              GitHub which is what we want.</p> 
              
              <h2 id="4">4. GitHub Pages</h2>
              <p>In this section you are instructed to create another repository 
              on GitHub - your GitHub Pages Website. Follow the
              <a href="https://docs.github.com/en/pages/quickstart">
              GitHub Pages Quickstart Tutorial</a></p>
              
              <h2 id="5">5. Taking Stock</h2>
              <p>The benefits of using GitHub and the command line interface for 
              git might not yet be clear and this may seem a complicated 
              distraction, but it is important to be aware of current 
              programming practice and hopefully you will realise the benefits 
              during the course as you become more familiar with programming and 
              using git/GitHub.</p>
              <p>There is a lot more to GitHub than has been covered here, but 
              having understood an practised creating repositories, cloning, 
              pulling, committing and pushing you are ready to return to 
              learning more about the Python language.</p>
              <p>If you have read through and are unconvinced that you want 
              a GitHub account, then so be it. It is not strictly necessary for 
              the assignments or their assessment.<p>
              <p>Optional sites for storing and managing code include:
              <a href="https://about.gitlab.com/">GitLab</a>;
              <a href="http://sourceforge.net/">Sourceforge</a>, and 
              <a href="https://bitbucket.org/">BitBucket</a>.</p>
              <p>If you are not keen on using them either then consider using:
              <a href="http://git-scm.com/">Git</a>, 
              <a href="https://www.mercurial-scm.org/">Mercurial</a> or
              <a href="http://subversion.apache.org/">Subversion</a> to set up 
              a local repository.</p>
              <p>As a minimum, please ensure your files are organised, versioned
              and backed up.</p>
              <p>Ask your tutor if you want help and consider taking a break...
              </p>
              """);
    }
}
