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
 * For Python Intro Course Input/Output Page.
 *
 * @author Andy Turner
 */
public class IO extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public IO(PythonIntroCodingCourse course) {
        super(course, "io", "Input and Output", "IO");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        addParagraphStart(sb, "The Python standard library ");
        sb.append(index.getReference("Python io", "io module", sid));
        addParagraphEnd(sb,
                """
                 provides the main facilities for dealing with input and output
                (IO). Numerous other standard library modules have functionality
                for dealing with specific aspects and types of IO, including:
                """);
        addParagraph(sb,
                """
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
                <a href="https://docs.python.org/3/library/shutil.html">shutil</a>.
                There are also various third party libraries with useful
                functionality for read and writing data in specific file formats
                and processing data on the Web.
                """);

        sid = addSection("Standard Input", sb);
        addParagraphStart(sb, "The builtins module ");
        sb.append(index.getReference("Python input", "input", sid));
        addParagraphEnd(sb,
                """
                 function reads input from the standard input 'stdin' which is
                usually the keyboard. This continues until the &lt;ENTER&gt;
                (or &lt;RETURN&gt;) key is pressed. The function returns a
                string (without a newline character). A string provided as a
                parameter is displayed to prompt user input. Run the following
                at the Python prompt and enter some keyboard input:
                """);
        addPythonCodeBlock(sb,
                """
                n_agents = input("Enter n_agents (a number between 10 and 100) and press the &lt;ENTER&gt; or &lt;RETURN&gt; key:")
                print("The input detected is:", n_agents)
                """);

        sid = addSection("Streams", sb);
        addParagraphStart(sb, "The builtins module ");
        sb.append(index.getReference("Python print", "print", sid));
        addParagraphEnd(sb,
                """
                 function writes to the standard output 'stdout' which is usually
                the terminal/console/screen.
                """);
        addParagraph(sb,
                """
                Stdin and stdout are streams - flows of data. Standard error
                'stderr' is also a stream - one where error messages go. Like
                stdout, stderr is usually written to the screen by default.
                """);
        addParagraph(sb,
                """
                The streams stdin and stdout can be redirected to come from a
                file (in the case of stdin), or go to a file (in the case of
                stdout). From the Anaconda Prompt the following will stream data
                from 'stdin.txt' into 'a.py' as it runs:
                """);
        addPre(sb, "python a.py &lt; stdin.txt");
        addParagraph(sb,
                """
                The following will send output from running 'a.py' into
                'stdout.txt':
                """);
        addPre(sb, "python a.py &gt; stdout.txt");
        addParagraph(sb,
                """
                This would overwrite 'stdout.txt' if it already existed. To
                append to the end of any existing 'stdout.txt', the following
                could be used:
                """);
        addPre(sb, "python a.py &gt;&gt; stdout.txt");
        addParagraph(sb, 
                "To stream data in and out, the following can be used:");
        addPre(sb, "python a.py &lt; stdin.txt &gt; stdout.txt");
        addParagraph(sb,
                """
                The stdout of one program can be piped to the stdin of another
                program using the pipe symbol '|'.
                """);
        addParagraphStart(sb, "The ");
        sb.append(index.getReference("Python print", "print", sid));
        addParagraph(sb,
                """
                 function also includes an option to direct stout to a file.
                That file has to be open in order for the writing to be
                successful and the open file should be closed to ensure all the
                data gets written. Typically reading and writing files uses
                'buffers' that read or write a certain number of bytes in one go
                which is more efficient. Closing a file that is being written to
                - forces a flush of any partially filled buffer. There is an
                option in the print function to force a flush which can also
                sometimes be useful...<
                """);

        sid = addSection("Reading and Writing Files Part 1", sb);
        addParagraphStart(sb, "The following code uses the builtins module ");
        sb.append(index.getReference("Python open", "open", sid));
        addParagraphEnd(sb,
                """
                 function to open a file in the current directory called 'a.in'
                and read the file one line at a time streaming the output to the
                screen before then closing the file:
                """);
        addPythonCodeBlock(sb,
                """
                f = open("a.in")
                for line in f:
                    print(line)
                f.close()
                """);
        addParagraphStart(sb,
                """
                The <a href="https://docs.python.org/3/c-api/file.html">
                File Object</a> returned from the above
                """);
        sb.append(index.getReference("Python open", "open", sid));
        addParagraph(sb,
                """
                 function call 'f' is best closed once it is read by calling it's
                'close' method as done on line 4 of the code snippet. After this
                line is executed, 'f' becomes" unusuable. Closing releases
                system resources and is recommended as good practice altough
                code will work without doing that.
                """);
        addParagraph(sb,
                """
                An alternative where a 'close' method call is not necessary uses
                the keyword 'with'. The following does effectively the same as
                the previous snippet:
                """);
        addPythonCodeBlock(sb,
                """
                with open("a.in") as f:
                    for line in f:
                        print(line)
                """);
        addParagraph(sb,
                """
                This saves having to close the file, but it is awkward this
                way to read several files simultaneously.
                """);
        addParagraph(sb,
                """
                The standard library
                <a href="https://docs.python.org/3/library/fileinput.html">
                fileinput module</a>
                helps with reading multiple files simultaneously.
                """);
        addParagraphStart(sb,
                """
                The
                <a href="https://docs.python.org/3/library/io.html#io.IOBase.readlines\">
                readlines method</p> can read some or all lines of a file into a
                list of strings (each item being a line of the file. Whilst this
                can be convenient, if a file is large and not everything is
                wanted, then this can use a lot of memory and risks a
                """);
        sb.append(index.getReference("Python MemoryError", "MemoryError", sid));
        addParagraphEnd(sb,
                """
                 being raised. So, often it is better to parse a file in
                portions, such as line by line. Parsing might involve processing
                or simply storing parts or all of the line in one or more
                variables.
                """);
        addParagraph(sb,
                """
                Files are opened for writing in a similar way. Writing to a file
                can be done as follows:
                """);
        addPythonCodeBlock(sb, 
                """
                # Create something to write
                a = []
                for i in range(10):
                    a.append("Coding is fun!");
                # Open a file for writing
                f = open("a.out", 'w')
                # Write a to the file
                for line in a:
                    f.write(line)
                # Close the file
                f.close()
                """);
        addParagraph(sb,
                """
                Note the additional 'w' parameter passed into the Open
                Function which prepares the file a.out to be written to. Writing
                to a file requires different preparation to reading from a file.
                """);
        addParagraphStart(sb,
                """
                There are other optional arguments that can be used with the
                """);
        sb.append(index.getReference("Python open", "open", sid));
        addParagraphEnd(sb, " function, follow the link for details...");
        addParagraph(sb,
                """
                An alternative using the keyword 'with' that does not
                require closing the file is:
                """);
        addPythonCodeBlock(sb,
                """
                # Create something to write
                a = []
                for i in range(10):
                    a.append("Coding is fun!");
                # Write a to file
                with open("a.out", 'w') as f:
                    # Write a to the file
                    for line in a:
                        f.write(line)
                """);

        sid = addSection("File formats", sb);
        addParagraph(sb,
                """
                File formats were briefly introduced in
                <a href="../programming/index.html#2.2">Programming Section 2.2
                </a>.
                """);
        addParagraph(sb,
                """
                All files are binary files, but some binary files are known as
                'text files' - the encoding is generally recognised as text.
                Text files are typically delimited into lines by a 'newline'
                code which in Python is '\\n'. File formats are usually defined
                in a file format specification that details the structure of the
                file. In this section three types of text file formats are
                described (CSV, JSON and Markup).
                """);

        sid = addSubsection("CSV", sb);
        addParagraphStart(sb, "");
        sb.append(index.getReference("CSV", "CSV format", sid));
        addParagraphEnd(sb,
                """
                 files are text files of comma separated values. The values are
                text, but this text might represent numbers. If a value contains
                a comma then the value is usually enclosed in quotation marks.
                If the value also contains quotation marks or newline then there
                can be difficulty parsing the file.
                """);

        sid = addSubsection("JSON", sb);
        addParagraphStart(sb, "");
        sb.append(index.getReference("JSON", "JavaScript Object Notation", sid));
        addParagraphEnd(sb,
                """
                 (JSON) is an open standard file format and data interchange
                format that uses human-readable text to store and transmit data
                objects consisting of attribute–value pairs and arrays (or other
                serializable values.
                """);
        addParagraphStart(sb, "Here is an example of some ");
        sb.append(index.getReference("GeoJSON", sid));
        addParagraphEnd(sb, " data:");
        addPre(sb, 
                """
                GeoJSON example
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
                }
                """);

        sid = addSubsection("Markup", sb);
        addParagraphStart(sb,
                """
                Markup is essentially tags and content. Tags often note the
                ontological context of the content helping define it's meaning.
                Tags can be nested. Examples formats include:
                """);
        sb.append(index.getReference("HTML", sid));
        sb.append("; and, ");
        sb.append(index.getReference("XML", sid));
        sb.append(
                """
                . Style information can be embedded about how to portray the
                data, but this is better kept separate. XML is extensible in
                that new tags can be added to extend the langauge in what are
                known as profiles. There are lots of standard profiles of XML
                for different kinds of information including
                """);
        sb.append(index.getReference("GML", sid));
        addParagraphEnd(sb,
                """
                 the XML grammar defined by the Open Geospatial Consortium (OGC)
                to express geographical features.
                """);

        sid = addSection("Reading and Writing Files Part 2", sb);
        addParagraph(sb,
                """
                The following code reads a file line by line, parsing each line
                by splitting it using a comma and converting each part into a
                Float which is appended to a list which is then appended to
                another list called 'data':
                """);
        addPythonCodeBlock(sb, 
                """
                with open("data.txt") as f:
                data = []
                for line in f:
                    parsed_line = str.split(line,",")
                    data_line = []
                    for word in parsed_line:
                        data_line.append(float(word))
                    data.append(data_line)
                print(data)
                """);
        addParagraphStart(sb,
                """
                It is easier to read and write CSV format files using functions
                from the Python standard library
                """);
        sb.append(index.getReference("Python csv", "csv module", sid));
        addParagraphEnd(sb,
                """
                 written specifically to do this. The following is an example of
                reading some numeric data:
                """);
        addPythonCodeBlock(sb, 
                """
                import csv
                f = open('data.csv', newline='')
                reader = csv.reader(f, quoting=csv.QUOTE_NONNUMERIC)
                for row in reader: # A list of rows
                    for value in row: # A list of value
                        print(value) # Floats
                f.close()
                """);
        addParagraph(sb,
                """
                The keyword argument 'quoting=csv.QUOTE_NONNUMERIC' not only
                puts quotation marks around non numeric data, but also converts
                some number formats into Floats.
                """);
        addParagraph(sb,
                """
                The following is an example of using the csv module to write
                data:
                """);
        addPythonCodeBlock(sb, 
                """
                import csv
                f = open('data.csv', 'w', newline='')
                writer = csv.writer(f, delimiter=' ')
                for row in data:
                    writer.writerow(row) # List of values.
                f.close()
                """);
        addParagraph(sb,
                """
                The optional delimiter kwarg specified here delimits using a
                space ' ' instead of the default comma ',', so this would
                actually not generate CSV format data!
                """);
        addParagraphStart(sb, "The following code uses the standard library ");
        sb.append(index.getReference("Python json", "json module", sid));
        addParagraphEnd(sb, " to read a JSON file:");
        addPythonCodeBlock(sb,
                """
                import json
                f = open('data.json')
                data = json.load(f)
                f.close()
                print(data)
                """);
        addParagraph(sb, "The following code can be used to write a JSON file:");
        addPythonCodeBlock(sb, 
                """
                import json
                f = open('data.json', 'w')
                json.dump(data, f)
                f.close()
                """);
        addParagraph(sb,
                """
                The standard library for processing HTML and XML is:
                <a href="https://docs.python.org/3/library/markup.html">
                markup</a>, but the third party
                <a href="https://beautiful-soup-4.readthedocs.io/en/latest/">
                Beautiful Soup</a> package is used later in the course to parse
                some HTML.""");

        sid = addSection("Serialisation/Deserialisation", sb);
        addParagraph(sb,
                """
                Serialisation is the conversion of program data into data
                stored typically in a file. Deserialisation is the opposite
                process that converts data back into working code. Essentially
                any Python object can be serialised and later deserialised. For
                details on how to do this, see the standard library
                <a href="https://docs.python.org/3/library/pickle.html">
                pickle module</a>
                """);

        sid = addSection("OS and File Systems", sb);
        addParagraph(sb,
                """
                The standard library
                (<a href="https://docs.python.org/3/library/os.html">os module
                </a>)
                allows for interaction with the underlying computer operating
                system (OS), including 'environment variable' manipulation and
                file system navigation.
                """);
        addParagraphStart(sb,
                """
                Environment variables are variables at the OS level. The mapping
                object
                '<a href="https://docs.python.org/3/library/os.html#os.environ">
                os.environ</a>'
                allows for accessing environment information from a Python
                program. For example, the following will print the
                """);
        sb.append(index.getReference("PATH", sid));
        addParagraphEnd(sb, ":");
        addPythonCodeBlock(sb, 
                """
                import os
                print(os.environ["PATH"])
                """);
        addParagraph(sb,
                """
                And the following will print a list of every file and directory
                in the current working directory:
                """);
        addPythonCodeBlock(sb, "print os.listdir(path='.')");
        addParagraph(sb,
                """
                The standard library
                <a href="https://docs.python.org/3/library/pathlib.html">
                pathlib module</a>
                helps with handling file paths and managing file systems
                """);
        addParagraph(sb,
                """
                The standard library
                <a href="https://docs.python.org/3/library/tempfile.html">
                tempfile module</a> is useful for creating temporary files.
                """);
        addParagraph(sb,
                """
                The standard library
                <a href="https://docs.python.org/3/library/shutil.html">
                shutil module</a> is useful for copying files and directory
                structures.
                """);
        addParagraph(sb,
                """
                The standard library
                <a href="https://docs.python.org/3/library/glob.html">
                glob module</a> is useful for pattern hunting in files and
                directories.
                """);
        return sb.toString();
    }
}
