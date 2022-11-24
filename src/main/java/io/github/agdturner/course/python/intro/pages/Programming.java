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
              <h2>Introduction</h2>
              <p>""");
        w.add(addWikipediaReference("Computer programming"));
        w.add("""
              (coding) is about instructing a computer to carry out a set of
              tasks. Data can be input, processed and output. Outputs may also
              be visual displays and sounds, and a computer can be used to
              control other things like motors and sensors.</p>
              <p>Current desktop or laptop machines typically have a keyboard
              and a mouse for user input and a visual display screen. They have
              smaller amounts of faster more volitile data storage (memory),
              and larger amounts of more persistent data storage (disk) that
              store files in a""");
        w.add(addWikipediaReference("File_system", "file system"));
        w.add("""
              . The machines may have microphones and cameras, and the"
                + " screen may be a touch screen. The machines are typically"
                + " networked and can communicate with other machines on the""");
        w.add(addWikipediaReference("Internet"));
        w.add(". The basic functioning of the machine is done by an ");
        w.add(addWikipediaReference("Operating_system", "operating system"));
        w.add(" that is loaded onto the machine and configured to run when it is ");
        w.add(addWikipediaReference("Booting", "booted"));
        w.add(". Additional ");
        w.add(addWikipediaReference("Software", "software"));
        w.add("""
              can be added and run on the operating system to extend the
              machines capability. This includes things like interpretters or
              virtual machines which allow users to run programs written in
              specific""");
        w.add(addWikipediaReference("Programming_language",
                        "computer programming language") + "s.</p>");
        w.add("""
              <p>Programming can be done visually by arranging pre-built
              components that fit or connect together to form workflows that 
              can be run. However, this course is not about visual programming,
              it is about programming using text based command instructions 
              written in """);
        w.add(addWikipediaReference("Python_(programming_language)",
                        "Python") + ".</p>");
        w.add("""
              <p>There are a wide variety of computer programming languages
              each defined by a specific syntax (rules). Some computer languages
              look similar, others look very different. Whilst these learning 
              resources focus on Python, occasionally similarities and 
              differences between Python and other languages are pointed out.
              </p>
              <h2>Data</h2>
              <p>The smallest amount of binary data is called a bit. It is a
              unit that is in one of two possible states. Perhaps it is easiest 
              to think of these states as being positive or negative, true or 
              false, or one (1) or zero (0).</p>
              <p>Typically computers work with fixed size collections of bits
              called""");
        w.add(addWikipediaReference("Byte", "bytes") + ".");
        w.add("""
              The more more bits in a byte, the more different unique 
              combinations or arrangements of bits in the byte there are. With
              each added bit, there is a power of two more combinations. With 2
              bits there are 4 possible combinations (00, 01, 10, 11). With 3 
              bits there are 8 combinations (000, 001, 010, 100, 011, 101, 110,
              111). With 4, 16... With 8, 256...</p>""");
        
        SectionID sid = new SectionID(c.sectionIDs.size());
        c.addSection(sid, id, title);
        addToIndex("binary", sid);
        
        w.add("""
              <p>Many encodings use 8 bits in a byte (as this allows for all
              English letters in both lower and upper case, the ten numeric 
              digits 0 to 9, and 192 mathematical and other symbols to be 
              uniquely represented. To represent individual numbers, computers 
              typically use more bits depending on the type of number. We will 
              come back to numerical representations and calculations later.</p>
              <h2>Learning to Program</h2>
              <p>If you are new to computer programming, then you will be
              learning lots of new terms and concepts as well as learning the 
              basics of Python in this course. There is a lot to take on board
              which can be tiring and so you are strongly encouraged to take 
              breaks as this will almost certainly help you to learn faster and 
              help prevent fatigue. Learning should be a joy, but it is not
              much fun if you are not making progress which can happen if you 
              attempt to learn when you are tired. When you are not tired,
              sometimes you might struggle to understand something too. This is 
              perfectly normal. Sometimes it takes several attempts and a bit of 
              frustration to understand something.</p>
              <p>Once you can program well in one language, it is generally much 
              easier to learn to programme in another language. Once you know 
              two languages well, you might turn to one to do some things and 
              another to do other things. Or, you might prefer a particular 
              language for most things.</p>
              <p>High level languages are typically evolving. As they evolve, 
              there are typically better ways of doing things. So, code written 
              in a langauge to do something might look different in the future.
              Often, there are several ways to achieve the same thing.</p>
              <p>In general you are encouraged to produce easy to understand, 
              easy to maintain, efficient, reliable, well tested and well 
              documented code that helps make the world a better place. Only a
              fraction of the code used today is like this!</p>
              </div>""");
    }
}