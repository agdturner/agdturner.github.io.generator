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
              <h2>1. Introduction</h2>
              <p><a href="http://www.github.com">GitHub</a> is a
              <a href="https://en.wikipedia.org/wiki/Git">Git</a>
              based code hosting platform for version control and collaboration. 
              "It lets you and others work together on projects from anywhere."
              </p>
              <p>GitHub makes it easy to get involved in code development, and 
              it provides hosting for basic Web sites. It is popular and 
              reliable.</p>
              <p>For a history of GitHub have a look at the Wikipeida article:
              <a href="https://en.wikipedia.org/wiki/GitHub">
              https://en.wikipedia.org/wiki/GitHub</a></p>
              <p>If you are fine with the terms and conditions, please create a
              <a href="http://www.github.com">GitHub</a> account choosing a 
              username comprising lower case letters and numbers.</p>
              
              <h2>2. Getting Started</h2>
              <p>Complete the
              <a href="https://docs.github.com/en/get-started/quickstart/hello-world">
              Hello World Tutorial</a></p>
              <p>If you are using a University of Leeds machine you can access 
              Git client software via AppsAnywhere and the Windows Vitual Desktop:
              <a href="https://wvd.leeds.ac.uk">https://wvd.leeds.ac.uk</a>.
              Alternatively 
              <a href="https://docs.github.com/en/get-started/quickstart/set-up-git#setting-up-git">
              follow these instructions to setup a Git client on your local machine</a>,
              <a href="https://git-scm.com/downloads">direct link to git-scm download<a>.
              </p>
              <p>Next follow the
              <a href="https://docs.github.com/en/get-started/quickstart/create-a-repo">
              Create a Repository Tutorial</a> and clone the repository to the 
              local machine you are using following the
              <a href="https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository">
              Cloning a Repository Tutorial</a>.</p>
              <p>If you have followed correctly, you should now have a 
              hello-world local git repository linked to a hello-world 
              repository on GitHub. Next, practice making changes in 
              hello-world in your local repository, commiting the change 
              locally, and then pushing the change to GitHub: Open README.md in 
              a text editor, make a change and save the file. The next step is 
              to commit and push this change to GitHub. It is recommended that 
              you learn how to do this using the git client Command Line 
              Interface (CLI) as this is almost certainly the quickest, easiest 
              and most flexible way once you are familiar. The process is 
              the same as
              <a href="https://docs.github.com/en/repositories/working-with-files/managing-files/adding-a-file-to-a-repository#adding-a-file-to-a-repository-using-the-command-line">
              adding a file</a>:</p>
              <pre>git add .
              git commit -m "change commit message to make it informative"
              git push</pre>
              <p>Once you have practised this, try making a change to a file 
              in your hello-world repository on GitHub and then in your local
              hello-world repository pull the changes by entering:</p>
              <pre>git pull</pre>
              
              <h2>3. Python Code Repo Setup</h3>
              <p>Create a new repository on GitHub which will be your code 
              repository for this course, call it something simple (you can 
              rename it later), include a README and a LICENSE and in .gitignore
              choose Python. Spend some time to 
              <a href="https://choosealicense.com/">choose a license</a>
              if you want. There are a few different kinds. You are advised 
              against write your own license from scratch. Licenses typically 
              stipulate terms of use, modification and redistribution and 
              provide a disclaimer to indemnify developers just in case 
              something bad happens.</p>
              <p>Clone your new repository so you have a local repository. 
              Create a new folder/directory in the repository called test. 
              Start Spyder, save the file into your test directory, add some 
              Python commands to the file and run it (the action of running the 
              code in Spyder saves it). Commit and push the change and check 
              the new file appears in GitHub.</p>
              <p>You may notice a __pycache__ directory appear in the test 
              directory with python source code file. This contains 
              interpretted files generated by the Python interpretter when the 
              Python source code is run. The .gitignore settings for Python will 
              not push this directory to GitHub which is exactly the behaviour 
              wanted.</p> 
              
              <h2>4. GitHub Pages</h2>
              <p>In this section you are instructed to create another repository 
              on GitHub - your GitHub Pages Website. Follow the
              <a href="https://docs.github.com/en/pages/quickstart">
              GitHub Pages Quickstart Tutorial</a></p>
              
              <h2>
              <h2>5. Taking Stock</h2>
              <p>Hopefully you are convinced to use GitHub and the command line 
              interface git client going forwards. There is a lot more to GitHub
              than has been covered here, but with a good understanding of 
              creating repositories, cloning, pulling, committing and pushing 
              the we are up and running and ready to get on with learning the 
              basics of the Python language.</p>
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
              """);
    }
}
