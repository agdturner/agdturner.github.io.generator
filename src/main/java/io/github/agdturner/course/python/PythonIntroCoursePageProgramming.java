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
package io.github.agdturner.course.python;

import io.github.agdturner.core.PageID;
import io.github.agdturner.course.CoursePageGeneral;
import java.io.IOException;
import java.nio.file.Path;

/**
 * For Python Intro Course Programming Page.
 *
 * @author Andy Turner
 */
public class PythonIntroCoursePageProgramming extends CoursePageGeneral {

    /**
     * What {@link #name} will be set to.
     */
    private static final String NAME = "programming";
    
    /**
     * Create a new instance.
     *
     * @param id The Page ID.
     * @param c The Course.
     */
    public PythonIntroCoursePageProgramming(PageID id, PythonIntroCourse c) {
        super(NAME, id, c);
    }

    
    /**
     * For initial write of Web content.
     *
     * @param domain The domain courseName as a String.
     * @param dir0 The root directory for the course.
     * @param dir1 The directory for this content.
     * @throws IOException If thrown.
     */
    @Override
    public void write(Path dir) throws IOException {
        writeH1(name);
        w.add("<p>" 
                + addWikipediaReference("Computer programming") 
                + " (programming, or coding) is about instructing a"
                + " computer to carry out a set of tasks. Typically, the tasks"
                + " involve data that are transferred, processed and output in"
                + " visual and audio forms.</p>");
        w.add("<p>The first computers were human calculators. These days most"
                + " computers are electrical machines with circuits. Desktop"
                + " machines typically have a keyboard for user inputs, process"
                + " binary data stored in a file system and have a graphical"
                + " display. Machines are typically networked and can"
                + " communicate with other similar machines on the "
                + addWikipediaReference("Internet")
                + ".</p>");
        w.add("<p>Programming can be done visually by arranging pre-built"
                + " components that fit or connect together to form programs or"
                + " workflows that can then be run to produce output. However,"
                + " this course is not about visual programming, it is about"
                + " programming using text commands written in a computer "
                + addWikipediaReference("Programming_language")
                + " and either entered at a "
                + addWikipediaReference("Command-line_interface#Command_prompt",
                        "Command Prompt")
                + " one after another or passed to an interpretter in a file or a"
                + " set of files. (A file is an ordered collection of data that"
                + " is registered with the computer operating system and can be"
                + " persistently stored (made so that it is available in"
                + " subsequent computer sessions).)</p>");
        w.add("<p>There are a wide variety of computer programming languages"
                + " each defined by a specific syntax (rules). Like natural"
                + " languages, computer languages can share a lot in common and"
                + " can look completely different. These learning resources"
                + " focus on Python and will mention some similarities and"
                + " differences that are useful to be aware of.</p>");
        w.add("<p>The smallest amount of binary data is called a bit - one or"
                + " the other state. Perhaps it is easiest to think of these"
                + " states as being a zero or a one.</p>");
        w.add("<p>Typically computers work with fixed size collections of bits"
                + " called " 
                + addWikipediaReference("Byte", "bytes") 
                + ". The more more bits in a byte, the more"
                + " different unique combinations there are. With each added"
                + " bit there is a power of two more combinations. With 2 bits"
                + " there are 4 possible combinations of zeros and ones (00,"
                + " 01, 10, 11). With 3 bits there are 8 combinations (000,"
                + " 001, 010, 100, 011, 101, 110, 111). With 4, 16... With 8,"
                + " 256...</p>");
        w.add("<p>Many encodings use 8 bits in a byte (as this allows for all"
                + " English letters in both lower and upper case, the ten"
                + " numeric digits 0 to 9, and 192 mathematical and other"
                + " symbols to be uniquely represented. To represent individual"
                + " numbers, computers typically use more bits depending on the"
                + " type of number. We will come back to numerical"
                + " representations and calculations later.</p>");
        w.add("<p>The lowest level languages are called machine languages and"
                + " these tell the computer how to read instructions and"
                + " transfer data. Higher level languages like Python have"
                + " interpretters that translate more human readable code into"
                + " the machine language.</p>");
        w.add("<p>If you are new to computer programming, then you will be"
                + " learning lots of new terms and concepts as well as learning"
                + " the syntax of Python in this course. There is a lot to take"
                + " on board and you will be most ready to learn these new"
                + " things when you are well rested and able to concentrate."
                + " You are strongly encouraged to take breaks when you are"
                + " learning and allow time for the concepts and new"
                + " terminology to sink in. Taking breaks will almost certainly"
                + " help you to learn faster on the whole as you tap you"
                + " subconscious. Learning should be a joy, but it is not so"
                + " much fun if you are not making progress which can happen if"
                + " you try to work when you are tired. Learning to program"
                + " requires practice and will inevitable involve making lots"
                + " of mistakes - a bit like learning to play a musical"
                + " instrument. Most learning computer programming learn best"
                + " by doing practical exercises and reusing the code they have"
                + " written.</p>");
        w.add("<p>There is typically more to learn with the first computer"
                + " programming language you learn. Once you can use one, it is"
                + " much easier to learn another.</p>");
//        w.add("<p></p>");
        w.add("</div>");
    }
}
