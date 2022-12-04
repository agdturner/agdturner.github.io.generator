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
              output. Computers are typically networked through connections 
              to other devices.</p> 
              <p>Desktop and laptop computers typically have a keyboard and
              mouse for user input, a visual display screen, smaller amounts
              of faster more volatile data storage (memory), and larger amounts
              of more persistent data storage (disk) that uses a""");
        w.add(addWikipediaReference("File_system", 
                "file system") + ".");
        w.add("""
              Computers may have inbuilt or perpherally connected microphones 
              and cameras, and the screen may be a touch screen. Networked 
              computers can typically communicate with other machines on the""");
        w.add(addWikipediaReference("Internet") + ".");
        w.add("The basic functioning of the computer is handled by an ");
        w.add(addWikipediaReference("Operating_system", 
                "operating system"));
        w.add(" that is configured to run when ");
        w.add(addWikipediaReference("Booting", "booted") + ".");
        w.add("Additional ");
        w.add(addWikipediaReference("Software", "software"));
        w.add("""
              can be added and run on the operating system to extend the
              capability of the computer. This includes""");
        w.add(addWikipediaReference("Programming_language",
                                      "computer programming language"));
        w.add("""
              interpretters and run time environments which allow programs 
              to be compiled and run.</p>
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
              where the smallest unit is called a bit which is in one of two
              possible states. Let us lable these one (1) and zero (0).</p>
              <p>Typically computers work with fixed size collections of bits
              called""");
        w.add(addWikipediaReference("Byte", "bytes") + ".");
        w.add("""
              The more more bits in a byte, the more different unique 
              combinations or arrangements of bits in the byte there are. With
              each added bit, there is a power of two more combinations. With 2
              bits there are 4 possible combinations (00, 01, 10, 11). With 3 
              bits there are 8 combinations (000, 001, 010, 100, 011, 101, 110,
              111). With 4, 16... With 7, 128. With 8, 256...</p>""");
        
        SectionID sid = new SectionID(c.sectionIDs.size());
        c.addSection(sid, id, title + " data");
        addToIndex("binary", sid);
        
        w.add("""
              <p>Encodings use different numbers of bits in a byte depending on 
              the variety of things that are to be expressed. The order of the 
              bits in the byte is known as the endian (big-endian, or little 
              endian). 7 bits in a byte allows for all English letters in both 
              lower and upper case, the ten numeric digits 0 to 9, and with 
              capacity for 64 other symbols to be uniquely represented. Often 
              file paths are encoded in 7 bit representations. More commonly 
              there are 8 bits in a byte. To represent individual numbers, 
              often 32 or multiples of 2 thereof bits are used depending on the 
              type of number. Numerical representations of non-integer numbers
              including is often  
              <a href="https://en.wikipedia.org/wiki/Single-precision_floating-point_format">
              single precision floating point format</a>
              or
              <a href="https://en.wikipedia.org/wiki/Double-precision_floating-point_format">
              double precision floating point format</a>. Essentially, these 
              provide an extended range over a fixed-point (<a href="https://en.wikipedia.org/wiki/Order_of_magnitude">order of magnitude</a>) 
              format at the cost of precision. We will revisit numerical 
              representation and precision in more detail later in the course...</p>
              
              <h2>3. Learning to Program</h2>
              <p>If you are new to computer programming, then you will learn
              lots of new terms and concepts as you learn the basics of Python
              in this course. There is a lot to learn, which can be tiring! You 
              are strongly encouraged to take breaks to help understand these 
              new things. Typically you will learn faster, remember easier, 
              avoid fatigue and enjoy the learning experience more if you take 
              regular breaks.</p>
              <p>It is perfectly normal for it to take several attempts to learn 
              some concepts, even if you are well rested and in the right frame 
              of mind to learn. This can be frustrating especially if you think 
              others are learning things faster. Try not to worry about how fast 
              anyone else is learning, it is not a race and there are likely to 
              be technical hiccups along the way that might slow anyone down.
              </p>
              <p>Once you can program well in one language, it is generally much 
              easier to learn to program using another language. Once you know 
              two languages well, you might use one to do some things and 
              another to do other things, and you might be more confident to try
              another language.</p>
              <p>Programming and programming language development are typically 
              community activities. It is normal to ask others for help and to 
              provide others with help and work collaboratively to develop 
              things. There are different types of forums for asking, answering 
              and feeding back available. Whilst you are encouraged to use these 
              to read things and perhaps feedback. If you are enrolled on a 
              course, please first ask your tutor for help before posting. If 
              asking your tutor for help by email, it is often a good idea to 
              attach your code, explain what you think should happen and 
              describe what happens instead.</p>
              
              <h2>4. Considerata</h2>
              <p>High level languages evolve. New functionality is added and 
              syntax can change to allow for more compact or easier to 
              understand expressions. This can mean that code written in an 
              older version of a language might appear different. In some 
              language evolution, old versions of the syntax are broken and 
              it is no longer guaranteed that code will run as expected and so 
              needs reviewing and testing again and potentially refactoring 
              (reworking) so that it will work again. It is important to be 
              aware of this when learning to program. Everything that you do and
              use needs to be reviewed and tested.</p>
              <p>Sometimes language evolution results in syntactic changes such
              that code written in older syntax will not necessarily work in 
              newer interpretters. (Interpretters convert the source code into 
              lower level machine instructions.)</p>
              <p>With any given syntax, there are usually a plethora of 
              different ways to achieve the same or a similar thing. Some ways 
              might be computationally faster under all or particular 
              circumstances, some might be more memory efficient, some may work 
              on a more diverse range of inputs, and in a range of cases all 
              these different ways might result in the same results or 
              behaviours. In other cases, some ways might be more precise or 
              accurate or result in different behaviours. For some programming 
              tasks, implementation detail are likley to vary a lot, for others,
              there only subtle differences are likely.</p>
              <p>In learning to program, and in programming generally, code 
              review is an important way to transfer skills and knowledge, and 
              to develop good practises and improve code bases.</p>
              <p>In general you are encouraged to produce easy to understand, 
              easy to maintain, efficient, reliable, well tested and well 
              documented code. Only a fraction of the code used today is like 
              this!</p>
              <p>Please also bear in mind that not all code is used to make the 
              world a better place. Take care to think about the trustworthiness 
              of anything you run, review code before you run it - just in case 
              the code is nefarious.</p>
              <p>Please adhere to the terms and conditions of software licenses.
              Also bear in mind that in academia it is important to keep track 
              of what we use, and to not plagiarise (present other's work as our 
              own).</p>""");
    }
}