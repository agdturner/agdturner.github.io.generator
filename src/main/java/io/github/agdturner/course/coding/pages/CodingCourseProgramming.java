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
package io.github.agdturner.course.coding.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.Course;
import io.github.agdturner.course.pages.CourseProgramming;

/**
 * Coding Course Programming Page.
 *
 * @author Andy Turner
 */
public class CodingCourseProgramming extends CourseProgramming {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public CodingCourseProgramming(Course course) {
        super(course);
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        getIntroduction(sb);
        getData(sb);
        getLearning(sb);
        getLanguageEvolution(sb);
        return sb.toString();
    }

    public void getIntroduction(StringBuilder sb) {
        SectionID sid = getIntroduction0(sb);
    }

    public SectionID getIntroduction0(StringBuilder sb) {
        SectionID sid = addSection("1", "Introduction", 2, sb);
        return sid;
    }

    public void getData(StringBuilder sb) {
        SectionID sid = addSection("2", "Data", 2, sb);
        getDataBitsAndBytes(sb);
        getDataFileFormats(sb);
        getDataIntegersAndFloatingPoint(sb);
    }

    public void getDataBitsAndBytes(StringBuilder sb) {
        SectionID sid = addSection("2.1", "Bits and Bytes", 3, sb);
        sb.append("<p>In most modern computers, data is encoded in binary: the")
                .append("smallest unit is a ")
                .append(index.getReference("Bit", "bit", sid))
                .append(" which encodes one of two possible states, which -")
                .append(" for  simplicity and brevity - are denoted '0' and")
                .append(" '1'.</p>\n");
        sb.append("<p>Typically computers work with fixed size collections of")
                .append(" bits called ")
                .append(index.getReference("Byte", "bytes", sid))
                .append(".");
        sb.append("""
              The more bits there are in a byte, the more different unique 
              combinations or arrangements of bits there can be. With each added 
              bit, there are double the number of combinations. So, with 2
              bits there are 4 possible combinations [00, 01, 10, 11]; with 3 
              bits there are 8 combinations [000, 001, 010, 100, 011, 101, 110,
              111]; with 4, 16 combinations; with 5, 32 combination, and so on.
              With each added bit in a byte there are twice as many 
              combinations compared to the smaller sizes byte. This doubling
              adds up exponentially and soon provides many combinations...</p>
              <p>7 bits in a byte allows for (128 combinations) which is 
              sufficient to represent all the letters in the English alphabet in 
              both lower and upper case, the ten numeric digits 0 to 9, and 
              64 other symbols.</p>
              """);
        sb.append("<p>7 bit bytes is the basis of ")
                .append(index.getReference("ASCII", "ASCII", sid))
                .append(" - a data encoding which is used often used for text,")
                .append(" and is  the basis of a number of different ")
                .append(index.getReference("File Format", "file formats"))
                .append(".</p>\n");
        sb.append("<p>").append(index.getReference("Unicode", "Unicode", sid))
                .append(" is another commonly used encoding. As of Unicode")
                .append(" version 15.0, there are 149,186 characters that are")
                .append(" uniquely encoded, including various alphabets,")
                .append(" mathematical symbols and emojis. Unicode uses")
                .append(" between 1 and 4 bytes of length 8 for encoding.")
                .append("</p>\n");
        sb.append("<p>Commonly, there are multiples of 8 bits in a byte, but")
                .append(" there can be any number.</p>\n");
    }

    public void getDataFileFormats(StringBuilder sb) {
        SectionID sid = addSection("2.2", "File Formats", 3, sb);
        sb.append("<p>Data stored in a file is often stored in a standard ")
                .append(index.getReference("File Format", "file format", sid))
                .append(" - typically based on a versioned specification which")
                .append(" details what encodings are used and how the data is")
                .append(" organised.</p>\n");
        sb.append("<p>Some file formats use different encodings in different")
                .append(" parts, a complication that makes the data more")
                .append(" usable and more compact - requiring less storage")
                .append(" space.</p>\n");
        sb.append("<p>Often the suffix of a filename indicates the file")
                .append(" format, for example the file format of a file named")
                .append(" \"index.html\" is expected to be in ")
                .append(index.getReference("HTML", sid))
                .append(" format. Some file formats contain an identifying")
                .append(" code (known as a ")
                .append(index.getReference("Magic Number", "magic number", sid))
                .append(" typically at the start of the file. If it is not")
                .append(" clear from the filename or any external ")
                .append(index.getReference("Metadata", "metadata", sid))
                .append("what the format of the file is, sometimes it can be")
                .append(" discerned from a magic number.</p>\n");
        sb.append("<p>File formats are revisited in ")
                .append("<a href=\"../io/index.html#5\">IO Section 5.</a>")
                .append("</p>\n");
    }

    public void getDataIntegersAndFloatingPoint(StringBuilder sb) {
        SectionID sid = addSection("2.3", "Integers and Floating Point", 3, sb);
        sb.append("""
              <p>All the integer numbers in a specific range are often 
              represented individually using bytes of a length sufficient for 
              that range. The encoding will detail how this is done. Usually, 
              zero is either in the middle or at the start of the range. If the 
              byte size is minimal, to represent integer numbers in a wider 
              range, either the byte size must increase, or multiple bytes must 
              be used in a more complicated encoding.</p>
              <p>Floating point numbers are a subset of fractions typically 
              encoded using bytes of length 32 or 64. The density of fractions 
              within any part of the range varies. In general, the density is 
              greater towards the centre of the range, which with standard 
              floating point numbers is zero.</p>
              """);
        sb.append("<p>" + index.getReference("Floating-point",
                "Floating point arithmetic", sid)
                + " is standardised and the result of a calculation gets"
                + " rounded to the nearest value. Most of the time, the"
                + " standardisation has ensured that calculations on different"
                + " computers are the same, but there can be variation. Anyway,"
                + " for some floating point calculations the result is"
                + " completely accurate and precise, other times it is"
                + " rounded either up or down. It is important to be aware that"
                + " there can be significant error in this standardised"
                + " arithmetisite.</p>\n");
        sb.append("<p>").append(index.getReference(
                "Single-precision Floating-point",
                "Single precision floating point", sid))
                .append(" is a standard encoding that uses bytes of length 32")
                .append(" to represent each number.</p>\n");
        sb.append("<p>").append(index.getReference(
                "Double-precision Floating-point",
                "Double precision floating point", sid))
                .append(" is a standard encoding that uses bytes of length 64")
                .append(" to represent each number.</p>\n");
    }

    public void getLearning(StringBuilder sb) {
        SectionID sid = getLearning0(sb);
        getLearning1(sb, sid);
    }

    public SectionID getLearning0(StringBuilder sb) {
        SectionID sid = addSection("3", "Learning to Program", 2, sb);
        sb.append("""
              <p>Learning to program takes time and energy. It is highly 
              recommended that you organise to learn new programming concepts 
              when you are well rested and have good concentration. Mistakes 
              and misunderstandings are more likely if you are tired or 
              distracted.</p>
              <p>Take breaks as you learn. They do more than help avoid fatigue
              - they can save a lot more time than they take, and make the 
              learning experience more healthy and enjoyable.</p>
              """);
        sb.append("<p>Save your work often and use ")
                .append(index.getReference("Version Control",
                "version control", sid))
                .append(" as this avoids losing work and provides a track of")
                .append(" progress that you and others might find useful.")
                .append("</p>\n");
        sb.append("<p>Once you have a good grip of programming basics, (which")
                .append(" you should have after this course), good ways to")
                .append(" improve your skills are by getting involved in ")
                .append(index.getReference("Open Source Software",
                "open source software", sid))
                .append(" development projects, reviewing code, writing code,")
                .append(" reading documentation and doing other programming")
                .append(" courses.</p>\n");
        sb.append("""
              <p>Being familiar with one programming language helps in learning 
              another. Many concepts are shared and the language syntax and 
              workflows are often similar.</p>
              <p>Some programming languages are particularly well geared for 
              particular types of application. This can be a consequence of the 
              language fundamentals, but often it is because something similar 
              has already been done with that language.</p>
              <p>When given a choice, experienced programmers will often choose 
              a language for an implementation because they either know that 
              language well - and can envisage what to do, or because they 
              know that a particular language is well suited to the task, or 
              because they want to learn/try something new/different.</p>
              <p>Programming and programming language development are typically 
              community activities. It is normal to ask others for help and to 
              provide others with help and work collaboratively to develop 
              software. There are various online systems that help with this 
              including online forums.<p>
                  """);
        return sid;
    }

    public void getLearning1(StringBuilder sb, SectionID sid) {
        sb.append("""
              <p>Asking for help with programming is a skill. Whilst it may be 
              easiest for you to show someone what is happening and talk about
              it. It is often not so easy to arrange an interactive help 
              session. Often the best way to get help is to document the issue 
              - describe and detail with text and pictures what is happeneing 
              and why this is confusing or not what you expect/want to happen. 
              Often the act of describing and detailing the issue can help with 
              understanding and trying different things which may ultimately 
              resolve the issue before you ask for help. Don't see this as 
              wasted effort, the more you practise preparing to ask for help, 
              the better you should be at it when you do!</p>
              <p>Often detailing an issue involves consulting documentation 
              and providing information about your environment. Sometimes the 
              issue is not that you have done something wrong, but that some 
              other code or software is not working as it should, or that the 
              way that things are set up to work is somehow causing the issue.
              </p>
              """);
        sb.append("<p>Sometimes the issue is a result of a '")
                .append(index.getReference("Software Bug", "software bug", sid))
                .append("' - an error, flaw or fault in the design,")
                .append(" development, or operation that causes incorrect or")
                .append(" unexpected things to happen. Sometimes issues happen")
                .append(" in the same way each time something is attempted,")
                .append(" other times the fault only sometimes happens. A")
                .append(" fault that only sometimes happens is known as a '")
                .append(index.getReference("Glitch", "glitch", sid))
                .append("' and these can be difficult to troubleshoot.</p>\n");
        sb.append("""
              <p>Often it is worth restarting software or rebooting the 
              operating system to attempt to stop unexpected behaviour 
              happening. If you start having to do this frequently it becomes 
              more of a pain, so that you either want a better work around, or 
              for the bug to get fixed.</p>
              <p>Reporting a bug is an important activity in software and 
              language development. Many bug reports are made openly available. 
              A 'known bug' is one that has been reported already. This may 
              already be being worked on or be 'resolved' or 'fixed' or there 
              may be 'workarounds' - ways of coping.</p>
              <p>A new version of software is typically released with one or 
              more bug fixes. Sometimes you have to decide when it is worth 
              doing the work to change to this later version or whether you can 
              cope with a workaround.</p>
              <p>Whether you are filing a bug report, or just asking for help, 
              often you should aim to provide a minimum working example to 
              replicate the bug/issue. And as with all data exchanges, you 
              should think carefully before sharing data.</p>
              <p>In learning to program, some things you might comprehend 
              instantly, other things might take several attempts to grasp or 
              fully understand. Some things you might understand, but they seem 
              strange. Usually, there is a good reason why something works and 
              is written the way it is, but no language is perfect and there may
              well be a better way...</p>
              """);
    }

    public void getLanguageEvolution(StringBuilder sb) {
        SectionID sid = addSection("4", "Language Evolution, Deprecation and Versions", 2, sb);
        sb.append("<p>High level computer programming languages like ")
                .append(index.getReference("Java", sid))
                .append(" and ")
                .append(index.getReference("Python", sid))
                .append(" evolve rapidly. Occasionally new languages are")
                .append(" developed. Some programming languages are retired or")
                .append(" become obsolete, and some older versions of languages")
                .append(" become unsupported over time. The release cadence is")
                .append(" how often releases are made. Sometimes releases are of")
                .append(" different kinds which are supported for different")
                .append(" periods.</p>\n")
                .append("<p>Supporting ")
                .append(index.getReference("Backward Compatibility",
                        "backward compatibility", sid))
                .append(" - interoperability with older versions - has both")
                .append(" costs and benefits. These costs and benefits are")
                .append(" weighed up by those developing languages that")
                .append(" tyically have a process of deciding how things")
                .append(" change.</p>\n");
        sb.append("<p>Changes that are not backward compatible can create a")
                .append(" lot of work! It is also discouraging if old code")
                .append(" does not work with newer language interpreters as")
                .append(" this results in reliance on old versions which can")
                .append(" be problematic and have security implications.")
                .append("</p>\n");
        sb.append("""
              <p>Languages compete for users and developers. Often new features 
              in one language are implemented in other languages soon after. The 
              pace of language evolution is related to the scale of investment 
              in resources, and the skill, and design decisions taken by the 
              developer community.</p>
              <p>As new syntax, new functionality and more efficient ways of
              doing things evolve in a language, some code either becomes 
              obsolete, or is best changed to use the new ways. This can require 
              considerable effort to retire or update (refactor) code.</p>
              <p>Fundamental changes in language syntax are associated with 
              major new versions of a language. Minor versions may add new 
              language features. Minor-minor version changes are usually 
              associated with one or more bug fix.</p>
              """);
        sb.append("<p>"
                + index.getReference("Deprecation", sid)
                + " is a common part of modern high level languages and third"
                + " party software. It is part of a process of phasing things"
                + " out. Things are first marked as deprecated in a version,"
                + " then in subsequent versions the things are removed.</p>");
    }

    public void getConsiderata(StringBuilder sb) {
        SectionID sid = getConsiderata0(sb);
        getConsiderataN(sb, sid);
    }

    public SectionID getConsiderata0(StringBuilder sb) {
        SectionID sid = addSection("5", "Considerata", 2, sb);
        sb.append("""
                  <p>For many reasons, a key one in science and for evidence 
                  based policy being '""")
                .append(index.getReference("Reproducibility", "reproducibility",
                        sid))
                .append("""
                    ', it is important to know what version of a language and 
                    any third party components a program has been tested with 
                    and results have been produced with.</p>""");
        sb.append("""
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
              well documented code/software. Not all code and software in use 
              today is like this!</p>
              <p>Remember to take care and think about the trustworthiness of 
              any code you run.</p>
              <p>Please adhere to the terms and conditions of software licenses.
              </p>
                  """);
        return sid;
    }

    public void getConsiderataN(StringBuilder sb, SectionID sid) {
        sb.append("</div>\n");
    }
}
