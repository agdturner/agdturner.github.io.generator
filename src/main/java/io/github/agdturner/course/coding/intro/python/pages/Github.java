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
 * Java for generating github page.
 *
 * @author Andy Turner
 */
public class Github extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public Github(PythonIntroCodingCourse course) {
        super(course, "github", "GitHub", "GitHub");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("1", "Introduction", 2, sb);
        sb.append("""
              <p><a href="http://www.github.com">GitHub</a> is a
              <a href="https://en.wikipedia.org/wiki/Git">Git</a>
              based code hosting platform. 
              "It lets you and others work together on projects from anywhere."
              </p>
              <p>GitHub makes it easy to get involved in code development, and 
              provides hosting for basic websites. It is popular and reliable.
              </p>
              <p>For a history of GitHub have a look at the
              <a href="https://en.wikipedia.org/wiki/GitHub">
              GitHub Wikipedia Article</a></p>
              <p>If you accept the 
              <a href="https://docs.github.com/en/site-policy/github-terms/github-terms-of-service">
              GitHub Terms of Service</a>, please create an account choosing a 
              username comprising lower case letters and numbers. You do not 
              need a GitHub account to complete this course, but it is 
              recommended.</p>
                  """);
        
        sid = addSection("2", "Getting Started with GitHub", 2, sb);
        sb.append("""
              <p>Complete the
              <a href="https://docs.github.com/en/get-started/quickstart/hello-world">
              Hello World Tutorial</a>.</p>
              """);
        sb.append("""
              <p>Git client software is available via 'AppsAnywhere' at the 
              University of Leeds which is accessible remotely via the 
              'Academic'
              <a href="https://wvd.leeds.ac.uk">
              University Windows Virtual Desktop</a>
              . Alternatively, 
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
              'hello-world' local git repository cloned from a 'hello-world' 
              remote repository on GitHub.</p>
              <p>Now to practice making changes and keeping things synchronised: 
              First, make a change in the local hello-world repository, commit 
              the change, and then push the change to the remote repository on 
              GitHub:<p>
              <ol>
              <li>Open your local copy of 'README.md' in a text editor, make a 
              change (for example, add a line of text) and save the file.</li>
              <li>Open the git client command line interface and change to 
              the local repository directory.</li>
              <li>Commit the change to the local repository and then push this 
              change to the remote repository on GitHub using the following 
              commands:
              <pre>git add .
              git commit -m "change this commit message so it is informative"
              git push</pre>
              </li>
              </ol>
              <p>There are alternative ways to do this, but this way is 
              recommended.</p>
              <p>Now, check on GitHub that the 'README.md' file there is 
              updated. You may need to reload the page in order to see the 
              change.</p>
              <p>Next, change the file on the remote GitHub repository using the 
              browser and commit the change there: To edit the README click on 
              the 'Edit Button' which looks like a pen (in dark mode it looks 
              like the following where the button is identified with a red 
              elipse:
              <img src="../resources/github/edit.png"  alt="GitHub README edit 
              button" />). Once you have finished editing, action the 
              'Commit changes' button to save the changes.</p>
              <p>The remote repository is now 'ahead' of the local repository 
              (which is 'behind'). To synchronize, pull the committed remote 
              repository changes to the local repository: In the git bash tool 
              in the repository directory directory enter:</p>
              <pre>git pull</pre>
              <p>You should see confirmation of this pulling the remote 
              repository changes to the local repository.</p>
              <p>There is a lot to GitHub that we are not going to use or learn 
              about in this course including: forking repositories, creating 
              branches, creating issues, resolving issues by submitting and 
              accepting 'pull requests'. These are all commonly taken steps in 
              collaborating on shared code bases in the GitHub ecosystem which 
              is typically what a lot of team programming involves.</p>
              <p>Something you may have to learn about is to deal with 'merge 
              conflicts'. This is when changes have been made to the same file 
              and in the same places such that the act of sychronizing the 
              repositories now requires decisions to be made about which 
              changes to keep. Let us deal with that in an ad hoc manner if and 
              when it happens.</p>
              <p>One of the main benefits of using git or a similar repository 
              like system is that all changes are recorded and versioned, so it 
              is possible to reset to an earlier version should this be desired, 
              and this takes the difficulty away from doing all this in a more 
              manual way.</p>
                  """);
        
        sid = addSection("3", "Python Code Repository Setup", 2, sb);
        sb.append("""
              <p>Create a new repository on GitHub which will be your code 
              repository for this course, call it something simple (you can 
              rename it later), include a README, and in the '.gitignore' 
              section choose the 'python' option. Spend some time to 
              <a href="https://choosealicense.com/">choose a license</a> and 
              select this from the options available. There are a few different 
              kinds of license. You are advised to choose an open source license
              and not write your own from scratch. The license is a legal 
              document that states terms of use, modification and redistribution
              and provides a disclaimer to indemnify you if something goes 
              wrong.</p>
              <p>Clone your new repository so you have a local repository set 
              up as was done with the 'hello-world' repository. Create a new 
              folder/directory in the new repository called 'test'. 
              Start Spyder; add a python command and save the code in a file in 
              the newly created 'test' directory. Add and commit changes to the 
              local repository and push the changes to the remote repository 
              as was done with the 'hello-world' repository. Check the new file 
              appears on GitHub.</p>
              <p>Run the new Python file you have created. A directory named 
              __pycache__ might appear in the test directory. This contains 
              interpreted files generated by the Python interpreter. The GitHub
              '.gitignore' settings for Python will not push this directory 
              contents to GitHub - which is what is wanted.</p>
              """);
        
        sid = addSection("4", "GitHub Pages", 2, sb);
        sb.append("""
              <p>Create another repository on GitHub - your GitHub Pages 
              Website. Follow the
              <a href="https://docs.github.com/en/pages/quickstart">
              GitHub Pages Quickstart Tutorial</a></p>
              """);
        
        sid = addSection("5", "Taking Stock", 2, sb);
        sb.append("""
              <p>The benefits of using GitHub and the command line interface for 
              git might not yet be clear and this may seem a complicated 
              distraction, but it is important to be aware of current 
              programming practice and hopefully you will realise the benefits 
              during the course as you become more familiar with programming and 
              using git/GitHub.</p>
              <p>As mentioned, there is a lot more to GitHub than has been 
              covered here. Practised creating repositories, cloning, pulling, 
              committing and pushing is something is good for now.</p>
              <p>If you have decided against using GitHub, then consider 
              using 
              <a href="https://about.gitlab.com/">GitLab</a>;
              <a href="http://sourceforge.net/">Sourceforge</a>, or 
              <a href="https://bitbucket.org/">BitBucket</a> instead.</p>
              <p>If you do not want to use these either, then consider using:
              <a href="http://git-scm.com/">Git</a>, 
              <a href="https://www.mercurial-scm.org/">Mercurial</a> or
              <a href="http://subversion.apache.org/">Subversion</a> to set up 
              a local repository.</p>
              <p>As a minimum, please ensure your files are organised, versioned
              and backed up.</p>
              """);
        sb.append("</div>\n");
        return sb.toString();
    }
}
