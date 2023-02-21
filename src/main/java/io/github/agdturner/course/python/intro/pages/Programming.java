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
              <h2 id="1">1. Introduction</h2>
              <p>""");
        w.add(addWikipediaReference("Computer programming"));
        w.add("""
              (coding) is about instructing computing machines (computers) to 
              carry out tasks where data is typically input, processed and 
              output.</p> 
              <p>Contemporary desktop and laptop computers typically have a 
              keyboard and mouse for user input, a visual display screen, 
              smaller amounts of faster more volatile data storage (memory), and 
              larger amounts of more persistent data storage (disk) that 
              is organised using a""");
        w.add(addWikipediaReference("File_system",
                "file system") + ".");
        w.add("""
              Computers may have inbuilt or perpherally connected devices such 
              as microphones and cameras, and the screen may be a touch screen. 
              Networked computers can typically communicate using standard """);
        w.add(addWikipediaReference("Internet", "internet") + " protocols.");
        w.add("The basic functioning of a computer is handled by an ");
        w.add(addWikipediaReference("Operating_system",
                "operating system"));
        w.add(" upon which additional ");
        w.add(addWikipediaReference("Software", "software"));
        w.add(" can be installed, including software that interprets ");
        w.add(addWikipediaReference("Programming_language",
                "programming language"));
        w.add(" source code - a human readable form of computer instructions.");
        w.add("""
              </p>
              <p>Programming can be done visually by arranging and connecting 
              pre-built components into executable workflows. However, this 
              course is about programming using text based command instructions
              that have a formal syntax. Some computer languages look similar, 
              some look very different. This course is mostly based on the """);
        w.add(addWikipediaReference("Python_(programming_language)",
                "python") + " programming language.");
        
        SectionID sid = new SectionID(c.sectionIDs.size());
        c.addSection(sid, id, title + " data");
        addToIndex("binary", sid);

        w.add("""
              <h2 id="2">2. Data</h2>
              
              <h2 id="2.1">2.1 Binary</h2>
              <p>In most modern computers, data is encoded in a binary form
              where the smallest units called bits are in one of two possible 
              states: 0 or 1.</p>
              <p>Typically computers work with fixed size collections of bits
              called""");
        w.add(addWikipediaReference("Byte", "bytes") + ".");
        w.add("""
              The more bits there are in a byte, the more different unique 
              combinations or arrangements of bits there are. With each added 
              bit, there is a power of two more combinations. So, with 2
              bits there are 4 possible combinations [00, 01, 10, 11]; with 3 
              bits there are 8 combinations [000, 001, 010, 100, 011, 101, 110,
              111]; with 4, 16 combinations; with 7, 128; with 8, 256; and so on 
              doubling each time. With 64 bits there are 18446744073709551616
              combinations which may seem like a lot of combinations for such a 
              small number of bits, but such is the power of binary!</p>
              <p>7 bits in a byte allows for all English/Roman alphabet letters 
              in both lower and upper case, the ten numeric digits 0 to 9, and 
              64 other symbols to be uniquely represented (encoded). A specific 
              mapping of these is known as
              <a href="https://en.wikipedia.org/wiki/ASCII">ASCII</a>.</p>
              
              <h3 id="2.1">2.1 File Formats</h3>
              <p>Data stored in files is often stored in a standardised 
              <a href="https://en.wikipedia.org/wiki/File_format">
              format</a> - consistent with a (version of) a specification.
              ASCII is a file format and is also used to encode file paths on 
              some operating systems.</p>
              <p>Some formats encode different parts of a file using 
              different byte lengths and with reference to different mappings 
              between bytes and what they represent.</p>
              <p><a href="https://en.wikipedia.org/wiki/Unicode">Unicode</a> is 
              a common standard encoding used for a lot contemporary 
              communication data. As of Unicode version 15.0, there are 149,186 
              characters that are uniquely encoded in this format, including 
              various alphabets, mathematical symbols and emojis. Unicode uses 
              between 1 and 4 bytes of length 8 for encoding.
              </p>
              <p>Commonly, there are multiples of 8 bits in a byte, but there 
              can be any number, and data stored in files can be stored in a 
              bespoke format which only those who write and read the data know 
              about and anyone else must guess unless they are given a
              specification.</p>
              <p>Often the suffix of a filename indicates the format, for 
              example the format of a file named "index.html" is expected to be
              in <a href="https://en.wikipedia.org/wiki/HTML">HTML</a> format. 
              Some formats contain an identifying code (known as a 
              <https://en.wikipedia.org/wiki/File_format#Magic_number>
              magic number</a>) at the start which indicates the file type.</p>
              
              <h3 id="2.1">2.1 Encoding Numbers</h3>
              <p>Individual integer numbers are typically represented using a 
              fixed number of bits that can map individually to every integer 
              number in a range. The encoding will detail how this is done and 
              what the range is. Usually, zero is either in the middle or at the 
              start of the range. To represent integer numbers beyond this 
              range, either the byte size must increase, or multiple bytes must 
              be used.</p>
              <p>Floating point numbers include some integers and some fractions
              in a range centred about zero. They are currently encoded using 
              either 32 or 64 bits. The density of fractions within any part of 
              the range varies. In general, the density is greater towards the 
              centre of the range. In
              <a href="https://en.wikipedia.org/wiki/Floating-point_arithmetic">
              floating point arithmetic</a>, the result of a 
              calculation is rounded to the nearest value in the range. So,
              sometimes the rounding is up and sometimes the rounding is down.
              </p>
              <p>
              <a href="https://en.wikipedia.org/wiki/Single-precision_floating-point_format">
              Single precision floating point format</a> uses 32 bits per 
              number.
              <a href="https://en.wikipedia.org/wiki/Double-precision_floating-point_format">
              Double precision floating point format</a> uses 64 bits per 
              number. The important things to bear in mind about these numbers 
              is that calculations with them are only sometimes accurate. This 
              can cause confusion and error especially when using such numbers 
              in geometry, physics and statistics calculations.</p>
              
              <h2 id="3">3. Learning to Program</h2>
              <p>Learning to program takes time and energy. It involves 
              developing and strengthening neural networks in your brain. It is 
              highly recommended that you organise yourself to be learning
              new programming concepts when you are well rested and able to 
              concentrate and that you allow yourself time for this new thinking 
              to come readily. If you work when tired, it is easier to make 
              mistakes and misunderstand.</p>
              <p>Organise to take breaks as you learn. These help you avoid 
              fatigue, remember what you are learning, and enjoy the learning 
              experience. Often if you do something else for a short while and 
              then return to work on something that you were struggling with, 
              often you may figure it out quickly.</p>
              <p>Saving your work periodically and using
              """);
        w.add(addWikipediaReference("Version_control", "version control"));
        w.add("""
              helps to avoid costly mistakes and so is highly recommended.</p>
              <p>It is not reasonable to expect to learn about all the 
              functionality of a programming language like Python in an 
              introductory course - the standard library contains many functions
              and there is a vast ecosystem of third party libraries too. It is 
              key to learn how to discover and use existing functionality. There 
              are several ways to do this including reading documentation, 
              engaging in code review, and liaising with other programmers.</p>
              <p>The ultimate way to learn is to get involved in software 
              development projects.</p>
              <p>Once familiar with one programming language, it is usually
              much easier to learn others, as they can have many concepts in 
              common despite there often being subtle differences. Different 
              programming languages can be used to do the same things, but some 
              are particularly well geared for certain kinds of thing. 
              When given a choice, experienced programmers will often turn to a 
              particular language to do something as they either know that 
              language well - and know how to approach the problem with it, or 
              because they want to learn something new.</p>
              <p>Programming and programming language development are typically 
              community activities. It is normal to ask others for help and to 
              provide others with help and work collaboratively to develop 
              things. There are many different online forums that can be used 
              for this. Feel free to engage in online forums if you want, but 
              please do not post questions about this course. Ask your tutor or 
              a practical demonstrator if you want help.</p>
              <p>There is a skill to asking for programming help. You might want
              to show someone what is happening and talk about it. This is easy 
              to do in a classroom or shared office, but often that is not an 
              option, so the main alternative is to describe and detail the 
              issue by recording what happens and why this is different to what
              you expect. Often the act of doing this helps you to understand 
              better and in many cases resolve the issue, or come up with ideas 
              to try. Don't see this as wasted effort, the more times you 
              practise detailing an issue and the steps others need to take to 
              replicate, the better you will be at this, and you want to be good 
              at this in order to get help which may even come from your future 
              self!</p>
              <p>Often in detailing an issue involves consulting documentation 
              and providing information about your environment. Sometimes the 
              issue is not that you have done something wrong, but that some 
              other code is not working as it should, which is commonly known 
              as a bug. Writing good bug reports is a community avtivity at the 
              heart of much software and language development. Whether you are 
              filing a bug report, or just asking for help, often you should 
              provide a minimum working example to replicate the issue. As with 
              all data exchanges, you should think about if you can share the 
              data and the source code in the way you intend to before you do!
              </p>
              <p>In learning to program, some things you might comprehend 
              instantly, other things might take several attempts. Some things 
              you might understand, but they seem strange. Usually, there is a 
              good reason why something works and is written the way it is, but 
              no language is perfect and the code to do something might 
              currently seem a little odd and there could be a better way...</p>
              
              <h2 id="4">4. Language Evolution, Deprecation and Versions</h2>
              <p>High level computer programming languages like Python are 
              evolving and new ones occasionally get developed. Some programming 
              languages also become obsolete and some older versions of 
              languages become unsupported over time. Supporting 
              <a href="https://en.wikipedia.org/wiki/Backward_compatibility">
              backward compatibility</a> - interoperability with older versions 
              - has both costs and benefits. These are weighed up seriously by
              those developing languages, and breaking backward compatibility 
              is not done lightly. Language development is attempted in a way to 
              mitigate the costs whilst realising the benefits.</p>
              <p>Languages compete for users and developers. Often new features 
              in one language are implemented in others soon after, as there is 
              a demand and often a genuine need for them. The pace of language 
              evolution is related to the scale of investment in resources and 
              the skill and design decisions taken by the developer community.
              </p>
              <p>As new syntax, new functionality and more efficient ways of
              doing things evolve in a language, some code either becomes 
              obsolete, or is best changed to use the new ways. This can require 
              considerable effort to retire or update code. Changes in the core 
              of a language often take place faster than in third party 
              libraries.</p>
              <p>Fundamental changes in language syntax are associated with 
              major new versions of a language. Minor versions may add new 
              language features. Minor-minor version changes are ususally 
              associated with bug fixes.</p>
              <p>Deprecation is a common part of modern high level languages. 
              This is a process whereby certain ways of doing things are 
              gracefully phased out/retired. When no longer available, code that 
              relied on these deprecated ways will no longer work except with 
              older versions of source code language interpreters.</p>
              <p>So, it is important to know what version of a language code has 
              been tested with. And it is useful to be aware that code written 
              in a language can start to look quite different over time.
              </p>

              <h2 id="5">5. Considerata</h2>
              <p>With any language, there are often several ways to achieve the 
              same or a similar thing. Some ways may work faster, can handle 
              larger volumes of data, or might be more concise in terms of the 
              amount of source code. There might be no obvious right way to do 
              something - so sometimes, independent programming efforts produce
              significantly different source code. In other instances and 
              especially where there are style and naming guidelines, source 
              code may be identical.</p>
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
