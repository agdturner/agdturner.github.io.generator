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
 * For Python Intro Course Input/Output Page.
 *
 * @author Andy Turner
 */
public class IO extends Page {
    
    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public IO(PythonIntroCourse c) {
        super("io", "Input and Output", "IO", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2>1. Introduction</h2>
              <p>There are a variety of functions to help with Input and Output 
              (IO), including the builtins
              <a href="https://docs.python.org/3/library/functions.html#input">input()</a>
              and 
              <a href="https://docs.python.org/3/library/functions.html#open">open()</a>,
              and functions in the libraries: 
              <a href="https://docs.python.org/3/library/fileinput.html">fileinput</a>,
              <a href="https://docs.python.org/3/library/os.html">os</a>,
              <a href="https://docs.python.org/3/library/pathlib.html">pathlib</a>,
              <a href="https://docs.python.org/3/library/contextlib.html">contextlib</a>,
              <a href="https://docs.python.org/3/library/csv.html">csv</a>,
              <a href="https://docs.python.org/3/library/json.html">json</a>,
              <a href="https://docs.python.org/3/library/pickle.html">pickle</a>
              <a href="https://docs.python.org/3/library/markup.html">markup</a>,
              <a href="https://docs.python.org/3/library/internet.html">internet</a>,
              <a href="https://docs.python.org/3/library/tempfile.html">tempfile</a>, and
              <a href="https://docs.python.org/3/library/shutil.html">shutil</a>.</p>
              
              <h2>2. Builtins and Standard IO</h2>
              
              <h3>2.1. The Input Function</h3>
              <p>The Input Function reads input from the Standard Input (stdin) 
              which is usually the keyboard. This continues until the <ENTER> 
              (or <RETURN>) key is pressed. The function returns a String 
              (without a newline character). If there is a prompt String 
              provided as a parameter to the Input Function, this is printed to
              the current prompt line. Run the following and provide input:</p>
              <pre><code class=\"language-python\">n_agents = input("Key in a positive integer between 10 and 100 to set the number of agents then press the <ENTER> or <RETURN> key:")
              print("The input detected is:", n_agents)</code></pre>
              
              <h3>2.2. Streams</h3>
              <p>The Print Function writes to the Standard Output (stdout) which 
              is usually the screen.</p>
              <p>Streams are a name given to a flow of data, so stdin and stdout
              are streams. Also, the Standard Error (stderr) is a stream - one 
              where error messages from programs are sent: again, usually the 
              screen by default.</p>
              <p>The streams stdin and stdout can be redirected to come from a 
              file (in the case of stdin), or go to a file (in the case of 
              stdout). From the Anaconda Prompt the following will stream data 
              from stdin.txt into a.py as it runs:</p>
              <pre>python a.py < stdin.txt</pre>
              <p>The following will send output from running a.py into stdout.txt:</p>
              <pre>python a.py > stdout.txt</pre>
              <p>This would overwrite stdout.txt if it already existed. To 
              append to the end of any existing stdout.txt, the following could 
              be used:</p> 
              <pre>python a.py >> stdout.txt</pre>
              <p>To stream data in and out, the following can be used:</p>
              <pre>python a.py < stdin.txt > stdout.txt</pre>
              <p>It is also possible to pipe the stdout of one program to the 
              stdin of another program using the pipe symbol "|".</p>
              
              <h3>2.3. Open</h3>
              <p>The following code uses the Builtin Open Function to open a 
              file in the current directory called "a.in" and reads this 
              one line at a time streming the output to the screen before then 
              closing the file:</p>
              <pre><code class=\"language-python\">f = open("a.in")
              for line in f:
                  print(line)
              f.close()</code></pre>
              <p>The Close Function (close) closes the file and releases 
              resources.</p>
              <p>There are helpful functions to read all lines of a file into a 
              list which is sometimes preferable. However, if a file is large 
              and not everything is wanted, then this can be expensive in terms 
              of using up available memory, so often it is better to parse a 
              file line by line.</p>
              <p>Files are also opened for writing in a similar way. Writing to 
              a file can be done as follows:</p>
              <pre><code class=\"language-python\"># Create something to write
              a = []
              for i in range(10):
                  a.append("Coding is fun!");
              # Open a file for writing
              f = open("a.out", 'w')
              for line in a:
                  f.write(line)
              f.close()</code></pre>
              <p>Note the additional 'w' parameter passed into the Open 
              Function which prepares the file a.out to be written to. Writing 
              to a file requires different preparation to reading from a file.
              </p>
              <p>There are other optional arguments that can be used with the 
              Open Function as detailed in
              <a href="https://docs.python.org/3/library/functions.html#open">
              The Python Documentation Functions Chapter Open Section</a></p>

              <h3>2.3. File formats</h3>
              <p>All files are binary files, but some binary files are known as 
              text files which are typically delimited into lines using a 
              newline character. To read other types of binary file, it is 
              helpful to know details of the format. Usually this is given in a 
              file format specification that details the structure of the file, 
              and byte lengths and directions. This course focuses just on 
              reading and writing text files. These text files are typically 
              small and we are not overly concerned with optimising for memory 
              and efficiency.</p>
              <p>Details about handling generic binary data considered a 
              distraction and are intentionally omitted. However, it is 
              important to know that using text file formats for storing data 
              that is mostly numerical can be many times less inefficent 
              compared with a well designed binary format.<p>
              <p>In terms of text file formats, there are several types of 
              commonly used text file formats.</p>
              
              <h4>2.3.1. CSV Format</h4>
              <p>CSV files are comma separated variable files. The variables 
              may be numeric or Strings. There can be a complication if String 
              variables also contain commas when the entire String is usually 
              enclosed in quotation marks, and again there are difficulties if 
              quotation marks or apostrophes are in the Strings.</p>
              
              <h4>2.3.2. JSON Format</h4>
              <p>JSON was originally designed to capture JavaScript objects. It
              stored data as text attribute and value pairs. Values can include 
              more complex entities made up of further attribute-value pairs.
              Here is an example of some GeoJSON data:</p>
              <pre>GeoJSON example
              {
                  "type": "FeatureCollection",
                  "features": [ {
                      "type": "Feature",
                      "geometry": {
                          "type": "Point",
                          "coordinates": [42.0, 21.0]
                      },
                      "properties": {
                          "prop0": "value0"
                      }
                  }]
              }</pre>
              
              <h4>2.3.3. Markup</h4>
              <p>Markup is essentially tags and content. Tags often note the 
              ontological context of the data, making the value have meaning: 
              that is determining its semantic content. Examples formats 
              include: HTML (HyperText Markup Language); and, XML (Extensible 
              Markup Language). Tags can be nested to give information about the 
              content. Style information can be embedded about how to portray 
              the data, but this is better kept separate. XML is extensible in 
              that new tags can be added to extend the langauge in what are 
              known as profiles. There are lots of standard profiles of XML for 
              different kinds of information including 
              <a href="http://www.opengeospatial.org/standards/gml">
              Geographical Markup Language (GML)</a> - a standard developed by 
              the Open Geospatial Consortium.</p>
              
              <h3>2.4. Reading and Writing Data-Text Files</h3>
              <p>Because it is easy to forget to close an open file, it has 
              become good practice to set up a Context Manager using the With 
              Keyword (with), which temporarily deals with how some code runs. 
              The following code closes the opened file automatically. The file
              is read line by line as before, but each line is parsed. First, 
              the line is split into a sequence using the comma symbol (,) as a 
              delimeter that separates each item in the sequence, then each of 
              the items get parsed, which in this case involves using them to 
              generate Float numbers and storing them in a list. The stored list 
              of Float numbers is then stored in another list called data:</p>
              <pre><code class=\"language-python\">with open("data.txt") as f:
              data = []
              for line in f:
                  parsed_line = str.split(line,",")
                  data_line = []
                  for word in parsed_line:
                      data_line.append(float(word))
                  data.append(data_line)
              print(data)</code></pre>
              </p>
              <p>Multiple files can be open for reading and writing at any time,
              but this does not work with the Context Manager. For more 
              information about reading and writing multiple files see:
              <a href="https://docs.python.org/3/library/fileinput.html">
              fileinput</a></p> 
              <p>The Print Function also includes an option to direct stout to a  
              file too. That file has to be open in order for the writing to be 
              successful and the open file should be closed before the program 
              exits. Failure to do so may result in some things not being 
              flushed into the file due to buffering (where a buffer is filled 
              first before data is appended to a file for efficiency. Closing a 
              file forces a flush. There is though an option in the Print 
              Function to force a flush each time which can be useful if 
              something else is check for data that might otherwise be sitting 
              in a buffer...</p>
              
              <h4>2.4.1. CSV Module</h4>
              <p>It is easier to read and write CSV format files using code 
              written specifically to do this which is in the CSV Module (csv).
              </p>
              <p>The following is an example of reading data using csv:</p>
              <pre><code class=\"language-python\">import csv
              f = open('data.csv', newline='')
              reader = csv.reader(f, quoting=csv.QUOTE_NONNUMERIC)
              for row in reader: # A list of rows
                  for value in row: # A list of value
                      print(value) # Floats
              f.close()</code></pre>
              <p>The keyword argument (kwarg) quoting=csv.QUOTE_NONNUMERIC not 
              only puts quotation marks around non numeric data, but also 
              converts some number formats into Floats.</p>
              <p>The following is an example of writing data using csv:</p>
              <pre><code class=\"language-python\">import csv
              f = open('data.csv', 'w', newline='')
              writer = csv.writer(f, delimiter=' ')
              for row in data:
                  writer.writerow(row) # List of values.
              f.close()</code></pre>
              <p>The optional delimiter parameter specified here delimits using 
              a space instead of the default comma.</p>
              
              <h4>2.4.2. JSON Module</h4>
              <p>The following code can be used to read a JSON file:</p>
              <pre><code class=\"language-python\">import json
              f = open('data.json')
              data = json.load(f)
              f.close()
              print(data)</code></pre>
              <p>The following code can be used to write a JSON file:</p>
              <pre><code class=\"language-python\">import json
              f = open('data.json', 'w')
              json.dump(data, f)
              f.close()</code></pre>
              
              <h4>2.4.3. Serialisation/Deserialisation</h4>
              <p>Serialisation is the converting of program data into data 
              stored typically in a file. Deserialisation is the opposite 
              process that converts data back into working code. Essentially 
              any Python object can be serialised and later deserialised. For 
              details on how to do this, see:
              <a href="https://docs.python.org/3/library/pickle.html">pickle</a>
              </p>
              
              <h4>2.4.4. Handling HTML/XML</h4>
              <p>The Python standard library for processing HTML and XML is:
              <a href="https://docs.python.org/3/library/markup.html">
              markup</a>, but there are often better third party tools for 
              dealing with these types of data. Later in the course we will use
              <a href="https://beautiful-soup-4.readthedocs.io/en/latest/">
              Beautiful Soup</a> - a Python library for pulling data out of HTML
              and XML files.
              
              <h3>3. OS and File Systems</h3>
              <p>The OS Module 
              (<a href="https://docs.python.org/3/library/os.html">os</a>) 
              allows for interaction with the underlying Operating System (OS), 
              including environment variable manipulation and file system 
              navigation.</p>
              <p>Environment variables are variables at the OS level. For 
              example, PATH is a variable which details how the OS looks for
              programs. The mapping object "os.environ" allows for accessing 
              environment information from a Python program. For example, the 
              following will print the PATH:</p>
              <pre><code class=\"language-python\">import os
              print(os.environ["PATH"])</code></pre>
              <p>For more info on getting and setting OS environment variables, 
              see:
              <a href="https://docs.python.org/3/library/os.html#os.environ">
              os.environ</a></p>
              <p>There are various os functions for working with the underlying 
              file system. For example the following will print a list of 
              every file and directory in the current working directory:</p>
              <pre>print os.listdir(path='.')</pre>
              <p>A standard library for dealing with file paths is:
              <a href="https://docs.python.org/3/library/pathlib.html">
              pathlib</a>. To get information about files and directories 
              (including file sizes and modification times), see:
              <a href="https://docs.python.org/3/library/pathlib.html#Path.stat">
              pathlib#Path.stat</a>. To set file permissions and ownership, see:
              <a href="https://docs.python.org/3/library/pathlib.html#chmod">
              pathlib#chmod</a> and
              <a href="https://docs.python.org/3/library/pathlib.html#chown">
              pathlib#chown</a>.
              </p>
              <p>Some other useful standard Python IO libraries are:
              <a href="https://docs.python.org/3/library/tempfile.html">
              tempfile</a> - for generating temporary files and directories;
              <a href="https://docs.python.org/3/library/shutil.html">
              shutil</a> - for copying files and directory structures;
              <a href="https://docs.python.org/3/library/glob.html">
              glob</a> - for pattern hunting in files and directories.</p>
              """);
//              <p></p>
//              <pre></pre>
//              <pre><code class=\"language-python\"></code></pre>
        w.add("</div>");
    }
}
