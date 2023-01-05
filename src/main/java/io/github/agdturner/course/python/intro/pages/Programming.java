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

import io.github.agdturner.core.SectionID;
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
              <h2>1. Introduction</h2>
              <p>""");
        w.add(addWikipediaReference("Computer programming"));
        w.add("""
              (coding) is about instructing computing machines (computers) to 
              carry out tasks where data is typically input, processed and 
              output.</p> 
              <p>Desktop and laptop computers typically have a keyboard and
              mouse for user input, a visual display screen, smaller amounts
              of faster more volatile data storage (memory), and larger amounts
              of more persistent data storage (disk) using a""");
        w.add(addWikipediaReference("File_system", 
                "file system") + ".");
        w.add("""
              Computers may have inbuilt or perpherally connected deveices such 
              as microphones and cameras, and the screen may be a touch screen. 
              Networked computers can typically communicate using""");
        w.add(addWikipediaReference("Internet") + " protocols.");
        w.add("The basic functioning of a computer is handled by an ");
        w.add(addWikipediaReference("Operating_system", 
                "operating system"));
        w.add(" upon which additional ");
        w.add(addWikipediaReference("Software", "software"));
        w.add(" can be installed, including ");
        w.add(addWikipediaReference("Programming_language",
                                      "computer programming language"));
        w.add("""
              interpretters and run time environments.</p>
              <p>Programming can be done visually by arranging pre-built
              components that fit or connect together to form workflows that 
              can be run. However, this course is not about visual programming,
              it is about programming using text based command instructions 
              written specifically in the""");
        w.add(addWikipediaReference("Python_(programming_language)",
                        "Python programming language") + ".</p>");
        w.add("""
              <p>There are a wide variety of computer programming languages
              each defined by a specific syntax. Some computer languages
              look similar, some look very different. Whilst these learning 
              resources focus on Python, occasionally similarities and 
              differences between Python and other languages are pointed out.
              </p>
              
              <h2>2. Data</h2>
              <p>In most modern computers, data is encoded in a binary form
              where the smallest units called bits are in one of two possible 
              states. Let us label these one (1) and zero (0).</p>
              <p>Typically computers work with fixed size collections of bits
              called""");
        w.add(addWikipediaReference("Byte", "bytes") + ".");
        w.add("""
              The more bits there are in a byte, the more different unique 
              combinations or arrangements of bits there are. With each added 
              bit, there is a power of two more combinations. So, with 2
              bits there are 4 possible combinations (00, 01, 10, 11); with 3 
              bits there are 8 combinations (000, 001, 010, 100, 011, 101, 110,
              111); with 4, 16; with 7, 128; with 8, 256.</p>""");
        
        SectionID sid = new SectionID(c.sectionIDs.size());
        c.addSection(sid, id, title + " data");
        addToIndex("binary", sid);
        
        w.add("""
              <p>The order of the bits in a byte is known as the endian - there 
              are two types: big-endian and little endian. 7 bits in a byte 
              allows for all English letters in both lower and upper case, the 
              ten numeric digits 0 to 9, and 64 other symbols to be uniquely 
              represented. Often file paths are encoded in 7 bit 
              representations.</p>
              <p>More commonly these days there are multiples of 8 bits in a 
              byte. To represent individual numbers, often 32 or 64 bits are 
              used. Numerical representations of a subset of non-integer numbers
              are often in either
              <a href="https://en.wikipedia.org/wiki/Single-precision_floating-point_format">
              single precision floating point format</a> (which uses 32 bits per
              number) or
              <a href="https://en.wikipedia.org/wiki/Double-precision_floating-point_format">
              double precision floating point format</a> (which uses 64 bits per 
              number). These provide an extended range of numbers at the cost of 
              precision. Calculations done with these numbers are only sometimes 
              accurate. This is important to bear in mind when using them to 
              represent geometry and angles and also when calculating 
              statistics.</p>
              
              <h2>3. Learning to Program</h2>
              <p>If you have done little or no programming before, then other 
              learners may progress faster than you. Please do not worry about 
              this and take time to develop your understanding. Try to take 
              regular and frequent breaks to look after yourself, avoid fatigue 
              and help you remember and enjoy the learning experience.</p>
              <p>Some concepts are hard to grasp even if you are well rested and
              this can be frustrating. Remember, your tutor is here to help and 
              has lots of experience, so please ask for help. Some things you 
              might comprehend instantly, other things might take several 
              attempts. Some things you might understand, but it seems odd.
              Usually, there is a good reason why something works and is
              written the way it is, but no language is perfect!</p>
              <p>Once familiar with one programming language, it is usually
              much easier to learn others. Many languages can be used to do the 
              same things, but some are particularly suited to specific tasks.
              </p>
              <p>Languages evolve and are in some ways becoming more 
              syntactically similar. It is hard to keep up with the changes in 
              some high level languages, let alone the ecosystem of third party 
              packages that enrich it.</p>
              <p>Programming and programming language development are typically 
              community activities. It is normal to ask others for help and to 
              provide others with help and work collaboratively to develop 
              things. There are many different types of forums that can be used 
              for this. Feel free to read the questions and answers posted by 
              others on forums, but please do not post questions about this 
              course and liaise with your tutor before posting on forums.</p>
              <p>It you want help, then make it easy for others to help you. 
              Sometimes by documenting an issue helps you to understand and 
              resolve it. Once you get into coding, if something is not working
              as you expect, and you want to ask for help, then bear in mind 
              that it is often easiest for your tutor to first replicate the 
              issue which generally requies you to provide a copy of your code
              and details of what the issue is. A key skill in programming is 
              learning how to ask for help.</p>
              
              <h2>4. Language Evolution, Deprecation and Versions</h2>
              <p>As languages evolve, often new functionality is added and new 
              types of expression (new syntax) are supported. These changes are 
              driven by what users want and what is available in other 
              languages. Fundamental changes in language syntax are associated 
              with major new versions of a language.</p>
              <p>Deprecation is a common part of modern high level languages. 
              This is a process whereby certain ways of doing things are 
              gracefully phased out. When no longer available, code that relied 
              on deprecated ways will only work with older versions of the 
              language.</p>
              <p>So, it is important to know what version of a language code has 
              been tested with. And it is useful to be aware that code written 
              in the any language can start to look quite different over time.
              </p>

              <h2>5. Considerata</h2>
              <p>Programatically, with any given language, there are often 
              several different ways to achieve the same or a similar thing. 
              Sometimes independent programming efforts produce (almost) 
              identical code, but this is rare.</p>
              <p>In learning to program, and in programming generally, code 
              review is an important way to transfer skills and knowledge, 
              develop good practise and improve code and software.</p>
              <p>We encourage you to produce easy to understand, easy to 
              maintain, efficient, reliable, well tested and well documented 
              code and software. Not all code in use today is like this!</p>
              <p>Please take care and think about the trustworthiness of any 
              code you run. If in doubt, consult your tutor.</p>
              <p>Please read and adhere to the terms and conditions of software 
              licenses. Also keep in mind that for academic work, it is 
              important to keep track of what you consult and avoid plagiarism 
              (presenting other's work as your own).</p>
              """);
    }
}