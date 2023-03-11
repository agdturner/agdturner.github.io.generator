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

import io.github.agdturner.core.Section;
import io.github.agdturner.course.python.intro.PythonIntroCourse;
import io.github.agdturner.course.Page;

/**
 * Python Intro Course Programming Page.
 *
 * @author Andy Turner
 */
public class Programming extends Page {

    /**
     * Create a new instance.
     *
     * @param index The Page index.
     * @param c The Course.
     */
    public Programming(PythonIntroCourse c) {
        super("programming", "Programming", "Programming", c);
    }

    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2 id="1.">1. Introduction</h2>
              <p>""");
        w.add(c.index.getReference("Computer Programming", 
                "Computer programming")
                + " (coding) is the process of designing and building an"
                + " executable computer program - a set of instruction that"
                + " are fetched and executed sequentially.</p>");
        w.add("<p>Contemporary desktop and laptop computers typically have a"
                + " keyboard and mouse for user input, a visual display screen,"
                + " smaller amounts of faster more volatile data storage"
                + " (memory), and larger amounts of more persistent data"
                + " storage (disk) that is organised using a "
                + c.index.getReference("File System") 
                + ". Computers may have inbuilt or perpherally connected"
                + " devices such as microphones and cameras, and the screen"
                + " may be a touch screen. Networked computers can typically"
                + " communicate using standard " 
                + c.index.getReference("Internet")
                + " protocols. The basic functioning of a computer is handled"
                + " by an "
                + c.index.getReference("Operating System")
                + " upon which additional "
                + c.index.getReference("Software")
                + " can be installed, including software that interprets "
                + c.index.getReference("Programming Language")
                + " source code into machine instructions.</p>");
        w.add("<p>Programming can be done visually by arranging and connecting"
                + " pre-built components into executable workflows. However,"
                + " this course is about programming using text based command"
                + " instructions that have a formal syntax. Some computer"
                + " languages look similar, some look very different. This"
                + " course is mostly based on the "
                + c.index.getReference("Python",
                "Python programming language")
                + " (Python).");
        
        w.add("<h2 id=\"2.\">2. Data</h2>");
        Section s;
        s = addSection("2.1", "Bits and Bytes", 3);
        w.add(s.sectionHTML);
        w.add("<p>In most modern computers, data is encoded in binary: the"
                + " smallest unit is a "
                + c.index.getReference("Bit", "bit", s.sid)
                + " which is in one of two possible states: 0 or 1.</p>");
        w.add("<p>Typically computers work with fixed size collections of bits"
                + " called "
                + c.index.getReference("Byte", "bytes", s.sid)
                + ".");
        w.add("""
              The more bits there are in a byte, the more different unique 
              combinations or arrangements of bits there can be. With each added 
              bit, there are double the number of combinations. So, with 2
              bits there are 4 possible combinations [00, 01, 10, 11]; with 3 
              bits there are 8 combinations [000, 001, 010, 100, 011, 101, 110,
              111]; with 4, 16 combinations; with 5, 32 combination, and so on.
              </p>
              <p>7 bits in a byte allows for (128 combinations) which is 
              suffient to represent all the letters in the English alphabet in 
              both lower and upper case, the ten numeric digits 0 to 9, and 
              64 other symbols.</p>
              """);
        w.add("<p>7 bit bytes is the basis of " 
                + c.index.getReference("ASCII", "ASCII", s.sid) 
                + " - a data encoding which is the basis of some text file "
                + "formats.</p>");
        w.add("<p>" + c.index.getReference("Unicode", "Unicode", s.sid) + " is "
                + "another commonly used encoding. As of Unicode format "
                + "version 15.0, there are 149,186 characters that are "
                + "uniquely encoded, including various alphabets, mathematical "
                + "symbols and emojis. Unicode uses between 1 and 4 bytes of "
                + "length 8 for encoding.</p>");
        w.add("<p>Commonly, there are multiples of 8 bits in a byte, but there "
                + "can be any number.</p>");
        s = addSection("2.2", "File Formats", 3);
        w.add(s.sectionHTML);
        w.add("<p>Data stored in a file is often stored in standard " 
                + c.index.getReference("File Format", "file format", s.sid)
                + " - typically based on a versioned specification which "
                + "details what encodings are used and how the data is "
                + "organised.</p>");
        w.add("<p>Some file formats use different encodings in different parts "
                + "to make the data more usable and require less storage space."
                + "</p>");
        w.add("<p>Often the suffix of a filename indicates the file format, "
                + "for example the file format of a file named \"index.html\" "
                + "is expected to be in " 
                + c.index.getReference("HTML", s.sid) 
                + " format. Some file formats contain an identifying code"
                + " (known as a "
                + c.index.getReference("Magic Number", "magic number", s.sid) 
                + " typically at the start of the file.</p>");
        s = addSection("2.3", "Integers and Floating Point", 3);
        w.add(s.sectionHTML);
        w.add("""
              <p>Each integer number in a range is typically represented using a 
              single byte with a length sufficient to represent all those 
              integers in the range. The encoding will detail how this is done 
              and what the range is. Usually, zero is either in the middle or at 
              the start of the range. To represent integer numbers in a wider 
              range, either the byte size must increase, or multiple bytes must 
              be used.</p>
              <p>Floating point numbers are a subset of fractions typically 
              encoded using either 32 or 64 bit bytes. The density of fractions 
              within any part of the range varies. In general, the density is 
              greater towards the centre of the range which with standard 
              floating point numbers is zero.</p>
              """);
        w.add("<p>" + c.index.getReference("Floating-point", 
                "Floating point arithmetic", s.sid) 
                + " has been standardised. The result of a calculation is"
                + " rounded to the nearest value in the range. So, in some"
                + " instances a calculation is accurate, other times it is"
                + " rounded either up or down. It is important to be aware that"
                + " there can be significant error in this standardised"
                + " arithmetic.</p>");
        w.add("<p>" + c.index.getReference(
                "Single-precision Floating-point",
                "Single precision floating point", s.sid) + " is a standard "
                + "encoding that uses 32 bits per number.</p>");
        w.add("<p>" + c.index.getReference(
                "Double-precision Floating-point",
                "Double precision floating point", s.sid) + " is a standard "
                + "encoding that uses 64 bits per number.</p>");
        s = addSection("3", "Learning to Program", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>Learning to program takes time and energy. It involves 
              developing and strengthening neural networks in your brain. It is 
              highly recommended that you organise to learn new programming 
              concepts when you are well rested and have good concentration. 
              Mistakes and misunderstandings are more likely if you are tired or 
              distracted.</p>
              <p>Take breaks as you learn. They do more than help avoid fatigue. 
              They can help conceptually.</p>
              """);
        w.add("<p>Save your work often and use " 
                + c.index.getReference("Version Control", 
                        "version control", s.sid) 
                + " as this avoids losing work and provides a track of "
                + " progress that you and others might find useful.</p>");
        w.add("""
              <p>Once you have a good grip of programming basics, as you should 
              have by the end of this course, good ways to improve your skills 
              are by getting involved in open source software development 
              projects and completing more advanced programming courses.</p>
              <p>Being familiar with one programming language helps in learning 
              others. Many concepts are shared and the language syntax and 
              workflows are often similar.</p>
              <p>Some programming languages are particularly well geared for 
              particular types of application. This can be a consequence of the 
              langauge fundamentals, but more often it is because something 
              similar has already been done with that langauge that you can 
              build upon or learn from.</p>
              <p>When given a choice, experienced programmers will often choose 
              a language for an implementation because they either know that 
              language well - and can envisage what to do, or because they want 
              to learn/try something new.</p>
              <p>Programming and programming language development are typically 
              community activities. It is normal to ask others for help and to 
              provide others with help and work collaboratively to develop 
              software. There are various online systems that help with this 
              including online forums. You are at liberty to engage in online 
              forums, but please do not post questions about this course 
              including the assignments. Ask a tutor if you want help.</p>
              <p>There is a skill to asking for programming help whether this 
              be from your tutor or on a forum. Whilst it may be easiest for you 
              to show someone what is happening and talk about it. It is often 
              not so easy to arrange an interactive session. Often the best way 
              to get help is to describe and detail the issue with words and 
              pictures. Often the act of describing and detailing the issue 
              helps you to understand better and think of different ideas to 
              try - which may ultimately resolve the issue before you ask for 
              help. Don't see this as wasted effort, the more times you practise 
              detailing issues and the steps others need to take to replicate 
              the same behaviour that is confusing you, the better you should be
              at it.</p>
              <p>Often detailing an issue involves consulting documentation 
              and providing information about your environment. Sometimes the 
              issue is not that you have done something wrong, but that some 
              other code or software is not working as it should. Sometimes 
              these issues are bugs, and writing a good bug report is an 
              important activity in software and language development. Whether 
              you are filing a bug report, or just asking for help, often you 
              should aim to provide a minimum working example to replicate the 
              issue. And as with all data exchanges, you should think carefully 
              before sharing data.</p>
              <p>In learning to program, some things you might comprehend 
              instantly, other things might take several attempts to grasp or 
              fully understand. Some things you might understand, but they seem 
              strange. Usually, there is a good reason why something works and 
              is written the way it is, but no language is perfect and there may
              well be a better way...</p>
              """);
        s = addSection("4", "Language Evolution, Deprecation and Versions", 2);
        w.add(s.sectionHTML);
        w.add("""
              <p>High level computer programming languages like Python are 
              evolving and new ones occasionally get developed. Some programming 
              languages also become obsolete and some older versions of 
              languages become unsupported over time.</p>
              """);
        w.add("<p>Supporting "
              + c.index.getReference("Backward Compatibility", 
                      "backward compatibility", s.sid)
              + " - interoperability with older versions - has both costs and "
              + "benefits. These costs and benefits should be and typically "
              + "are weighed up by those developing languages. Changes that "
              + "are not backward compatible can create a lot of work!</p>");
        w.add("""
              <p>Languages compete for users and developers. Often new features 
              in one language are implemented in others soon after, as there is 
              a demand and often a genuine need for them. The pace of language 
              evolution is related to the scale of investment in resources, and 
              the skill, and design decisions taken by the developer community.
              </p>
              <p>As new syntax, new functionality and more efficient ways of
              doing things evolve in a language, some code either becomes 
              obsolete, or is best changed to use the new ways. This can require 
              considerable effort to retire or update code.</p>
              <p>Fundamental changes in language syntax are associated with 
              major new versions of a language. Minor versions may add new 
              language features. Minor-minor version changes are usually 
              associated with bug fixes.</p>
              """);
        w.add("<p>" +
                c.index.getReference("Deprecation", s.sid)
                 + " is a common part of modern high level languages and third"
                 + " party software. It is part of a process of phasing things"
                 + " out. Things are first marked as deprecated in a version,"
                 + " then in subsequent versions the things are removed.</p>");
        w.add("<p>It is important to know what version of a language and any"
                + " third party components a program has been tested with."
                + "</p>");
        w.add("""
              <h2 id="5">5. Considerata</h2>
              <p>With any language, there are often several ways to achieve the 
              same or a similar thing. Some ways may work faster, can handle 
              larger volumes of data, or might be more concise in terms of the 
              amount of source code. There might be no obvious right way to do 
              something - so sometimes, independent programming efforts produce
              significantly different source code that essentially does the same 
              thing. In other instances, and especially where there are style 
              and naming guidelines, source code produced independently may be 
              identical.</p>
              <p>In learning to program, and in programming generally, code 
              review is an important way to transfer skills and knowledge, 
              develop good practise and improve code and software.</p>
              <p>Throughout this course, you are encouraged to produce easy to 
              understand, easy to maintain, efficient, reliable, well tested and 
              well documented code/software. Not all code/software in use today 
              is like this!</p>
              <p>Just to re-iterate: Please take care and think about the 
              trustworthiness of any code you run and if in doubt, consult your 
              tutor.</p>
              <p>Please read and adhere to the terms and conditions of software 
              licenses. Also keep in mind that for academic work, it is 
              important to keep track of what you consult and avoid plagiarism 
              (presenting other's work as your own).</p>
              </div>
              """);
    }
}
