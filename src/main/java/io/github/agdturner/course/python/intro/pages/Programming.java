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
              (coding) is about instructing a computing machine (computer) to 
              carry out a set of tasks where data is typically input, processed 
              and output. Computers are typically networked through connections 
              to other devices and other computers.</p> 
              <p>Desktop and laptop computers typically have: a keyboard and
              mouse for user input and a visual display screen; smaller amounts
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
              111). With 4, 16... With 8, 256...</p>""");
        
        SectionID sid = new SectionID(c.sectionIDs.size());
        c.addSection(sid, id, title + " data");
        addToIndex("binary", sid);
        
        w.add("""
              <p>Many encodings use 8 bits in a byte (as this allows for all
              English letters in both lower and upper case, the ten numeric 
              digits 0 to 9, and with capacity let for 192 other symbols to be 
              uniquely represented. To represent individual numbers, computers 
              typically use more bits depending on the type of number. Let us
              consider numerical representations and calculations in more detail
              later in the course...</p>
              <h2>3. Learning to Program</h2>
              <p>If you are new to computer programming, then you will learn
              lots of new terms and concepts as you learn the basics of Python
              in this course. There is a lot to learn which can be tiring and so 
              you are strongly encouraged to take breaks as to help you learn 
              faster and avoid fatigue. Learning should be a joy, but it is not
              much fun if you make slow progress and keep forgetting things 
              which is much more likely to happen if you are tired. When you are
              not tired, sometimes you might struggle to understand something 
              too. This is perfectly normal. With some things, it can take 
              several attempts to understand something even when others seem to 
              understand that thing seemingly easily.</p>
              <p>Once you can program well in one language, it is generally much 
              easier to learn to programme in another language. Once you know 
              two languages well, you might use one to do some things and 
              another to do other things and you might be more confident to try
              another language.</p>
              <p>Programming and programming language development are typically 
              community activities. It is normal to ask others for help and to 
              provide others with help and work collaboratively to develop 
              things. There are different types of forums for asking and 
              answering questions and different types of project that you might 
              want to get involved with once you have gained some experience. 
              Please refrain from asking questions on any forums unless you are 
              encouraged to do so by your tutor. Please ask your tutor for help 
              if you want it. If asking for help by email, it is often a good 
              idea to attach your code, explain what you think should happen and 
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
              that a ot of code writing in adherence to an old syntax will not 
              necessarily work in the newer interpretters that convert that 
              syntax into machine readble instructions.</p>
              <p>With any given syntax, there are usually a plethora of 
              different ways to achieve the same or a similar thing. Some ways 
              might be computationally faster under all or particular 
              circumstances, some might be more memory efficient, some may work 
              on a more diverse range of inputs, and in a range of cases all 
              these different ways might result in the same answers or 
              behaviour. In other cases, some ways might be more precise or 
              accurate. For some tasks, it is likely to get a large variation in
              the ways different people will implement a solution in a given 
              language, for others tasks, there may only be subtle differences 
              such as in the names of the variables used or functions defined.
              In learning to program, it is often good to review how others have 
              done the same or similar things. It is a good way to learn so long 
              as you pick up good habits and not bad habits.</p>
              <p>In general you are encouraged to produce easy to understand, 
              easy to maintain, efficient, reliable, well tested and well 
              documented code. Only a fraction of the code used today is like 
              this. Also it is worth bearing in mind that not all code is used 
              to make the world a better place. Please take care to review code
              before you run it just in case the code is nefarious. Also, please
              adhere to the terms and conditions of software licenses, keep a 
              track of what you use and what is useful and attribute others work
              as appropriate.</p>""");
    }
}