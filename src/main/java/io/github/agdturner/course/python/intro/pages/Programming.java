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
              <p>If you have not done much programming before, then you may 
              witness others progressing faster than you. Please do not worry 
              about this and take time to develop your understanding. You are 
              strongly encouraged to take regular and frequent breaks. Typically 
              learners learn faster and avoid fatigue if they do have plenty 
              of breaks.</p>
              <p>Some concepts are hard to grasp even if you are well rested and
              you may find this frustrating. Remember, your tutor is here to 
              help and has lots of experience, so please ask for help and have a 
              bit of faith in your abilities. Some things you might comprehend 
              instantly, other things might take several attempts. Lots of 
              things in programming are like puzzles. Not everyone enjoys the 
              hard puzzling work to start with, but once you start realising 
              benefits and rewards, then you might enjoy even harder seeming 
              puzzles.</p>
              <p>Once you are familiar with one programming language, it is 
              generally much easier to learn another. Once familiar with two, 
              then learning a third might be even easier again. Some programmers 
              learn and use many languages others specialise.</p>
              <p>Languages evolve and are in some ways becoming more 
              syntactically similar. It is hard to keep up with the changes in 
              any language, let alone the ecosystem of third party packages that 
              enrich it.</p>
              <p>Programming and programming language development are typically 
              community activities. It is normal to ask others for help and to 
              provide others with help and work collaboratively to develop 
              things. There are many different types of forums that can be used 
              for this. Feel free to read the questions and answers posted by 
              others on these forums, but refrain from setting up accounts or 
              posting to them until you have liaised with your tutor about this.
              </p>
              <p>If asking your tutor for help by email, it is often a good idea
              to attach your code, explain what you think should happen and 
              describe what happens instead.</p>
              
              <h2>4. Considerata</h2>
              <p>As languages evolve, new functionality is added and new types 
              of expression can be supported. These changes are driven by what 
              users want and what is available in other languages. Fundamental 
              changes in language syntax are associated with major new versions 
              of a language.</p>
              <p>Deprecation is a common part of modern high level languages. 
              This is a process whereby old ways of doing things are gracefully 
              phased out. When no longer available, code that relied on 
              deprecated ways will only work with older versions of a language. 
              </p>
              <p>So, it is important to know what version of a language code has 
              been tested with. And it is useful to be aware that code written 
              in the any language can start to look quite different over 
              time.</p>
              <p>Using any particular language, there are often different ways
              to achieve the same or a similar thing. Sometimes different people
              will come up with exactly the same code. Other times there might 
              be more than just subtle layout and naming differences.</p>
              <p>In learning to program, and in programming generally, code 
              review is an important way to transfer skills and knowledge, 
              develop good practise and improve code and software.</p>
              <p>In general you are encouraged to produce easy to understand, 
              easy to maintain, efficient, reliable, well tested and well 
              documented code and software. Not all code in use today is like 
              this!</p>
              <p>Also, not all code is used to make the world a better place. 
              So, please take care and think about the trustworthiness of 
              anything you run. If in doubt, consult your tutor.</p>
              <p>Please read and adhere to the terms and conditions of software 
              licenses. Also keep in mind that for academic work, it is 
              important to keep track of what you consult and avoid plagiarism 
              (presenting other's work as your own).</p>
              """);
    }
}