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
        SectionID sid = addSection("Introduction", sb);
        return sid;
    }

    public void getData(StringBuilder sb) {
        SectionID sid = addSection("Data", sb);
        getDataBitsAndBytes(sb);
        getDataFileFormats(sb);
        getDataIntegersAndFloatingPoint(sb);
    }

    public void getDataBitsAndBytes(StringBuilder sb) {
        SectionID sid = addSubsection("Bits and Bytes", sb);
        w.addPST(sb,
                """
                In most modern computers, data is encoded in binary: the
                smallest unit is a
                """);
        sb.append(index.getReference("bit", sid));
        w.addPET(sb,
                """
                 which encodes two possible states, denoted '0' and '1'.
                """);
        w.addCODE()
        w.addPST(sb,
                """
                Typically computers work with fixed size collections of bits
                called
                """);
        sb.append(index.getReference("bytes", sid));
        w.addPET(sb, ".");
        w.addP(sb,
                """
                The more bits there are in a byte, the more different unique
                combinations or arrangements of bits there can be. With each
                added bit, there are double the number of combinations. So, with
                2 bits there are 4 possible combinations [00, 01, 10, 11]; with
                3 bits there are 8 combinations [000, 001, 010, 100, 011, 101,
                110, 111]; with 4, 16 combinations; with 5, 32 combination, and
                so on. With each added bit in a byte there are twice as many
                combinations compared to the smaller sizes byte. This doubling
                adds up exponentially and soon provides many combinations...
                """);
        w.addP(sb,
                """
                7 bits in a byte allows for (128 combinations) which is
                sufficient to represent all the letters in the English alphabet
                in both lower and upper case, the ten numeric digits 0 to 9, and
                64 other symbols.
                """);
        w.addPST(sb, "7 bit bytes is the basis of ");
        sb.append(index.getReference("ASCII", sid));
        sb.append(
                """
                 - a data encoding which is used often used for text, and is the
                 basis of a number of different
                """);
        sb.append(index.getReference("file formats"));
        w.addPET(sb, ".");
        w.addPST(sb, "");
        sb.append(index.getReference("Unicode", sid));
        w.addPET(sb,
                """
                 is another commonly used encoding. As of Unicode version 15.0,
                there are 149,186 characters that are uniquely encoded,
                including various alphabets, mathematical symbols and emojis.
                Unicode uses between 1 and 4 bytes of length 8 for encoding.
                """);
        w.addP(sb,
                """
                Commonly, there are multiples of 8 bits in a byte, but there can
                be any number.
                """);
    }

    public void getDataFileFormats(StringBuilder sb) {
        SectionID sid = addSubsection("File Formats", sb);
        w.addPST(sb,
                "Data stored in a file is often stored in a standard ");
        sb.append(index.getReference("file format", sid));
        w.addPET(sb,
                """
                 - typically based on a versioned specification which details
                the encodings used and how data gets arranged.
                """);

        w.addP(sb,
                """
                Some file formats use different encodings in different parts, a
                complication that makes the data more usable and more compact
                - requiring less storage space.
                """);

        w.addPST(sb,
                """
                Often the suffix of a filename indicates the file format, for
                example the file format of a file named "index.html" is expected
                to be
                """);
        sb.append(index.getReference("HTML", sid));
        sb.append(
                ". Some file formats contain an identifying code (known as a ");
        sb.append(index.getReference("magic number", sid));
        sb.append(
                """
                 typically at the start of the file which specifies the format.
                File format can also be detailed in external
                """);
        sb.append(index.getReference("metadata", sid));
        w.addPET(sb, ".");

        w.addP(sb,
                """
                File formats are revisited in
                <a href=\"../io/index.html#5\">IO Section 5.</a>
                """);
    }

    public void getDataIntegersAndFloatingPoint(StringBuilder sb) {
        SectionID sid = addSubsection("Integers and Floating Point", sb);

        w.addPST(sb, "All the ");
        sb.append(index.getReference("integer", sid));
        sb.append(
                """
                 numbers in a specific range are often represented \
                individually using \
                """);
        sb.append(index.getReference("bytes", sid));
        w.addPET(sb,
                """
                 of a length sufficient for that range. An encoding will \
                detail how this is done. Often, zero is either in the middle \
                or at the start of the range. If the byte size is minimal, to \
                represent integer numbers in a wider range, either the byte \
                size must increase, or multiple bytes must be used in a more \
                complicated encoding.
                """);

        w.addPST(sb, "Floating point numbers are a subset of ");
        sb.append(index.getReference("fractions", sid));
        sb.append(" often encoded using bytes of length 32 or 64. ");
        sb.append(index.getReference("Single-precision floating-point", sid));
        sb.append(" is a standard encoding that uses 32 bit bytes. ");
        sb.append(index.getReference("Double-precision Floating-point", sid));
        w.addPET(sb,
                """
                 is a standard encoding that uses 64 bit bytes. The density of \
                fractions within any part of the range varies. In general, the \
                density is greater towards the centre of the range, which with \
                standard floating point numbers is zero.
                """);

        w.addPST(sb, index.getReference("Floating-point",
                "Floating point arithmetic", sid));
        w.addPET(sb,
                """
                 is standardised. The result of a calculation gets rounded to \
                the nearest value that can be represented in the encoding. \
                Most of the time, the standardisation results in the same \
                calculations on different computers, but there can be \
                variation. For some calculations the result is completely \
                accurate and precise, for others the result is effectively \
                rounded either up or down. It is important to be aware that \
                there can be significant error in this standardised arithmetic.
                """);
    }

    public void getLearning(StringBuilder sb) {
        SectionID sid = getLearning0(sb);
        getLearning1(sb, sid);
    }

    public SectionID getLearning0(StringBuilder sb) {
        SectionID sid = addSection("Learning to Program", sb);
        w.addP(sb,
                """
                Learning to program takes time and energy. It is highly
                recommended that you organise to learn new programming concepts
                when you are well rested and have good concentration. Mistakes
                and misunderstandings are more likely if you are tired or
                distracted.
                """);
        w.addP(sb,
                """
                Take breaks as you learn. They do more than help avoid fatigue
                - they can save a lot more time than they take, and make the
                learning experience more healthy and enjoyable.
                """);
        w.addPST(sb, "Save your work often and use ");
        sb.append(index.getReference("version control", sid));
        w.addPET(sb,
                """
                 as this avoids losing work and provides a track of progress
                that you and others might find useful.
                """);
        w.addPST(sb,
                """
                Once you have a good grip of programming basics, (which you
                should have after this course), good ways to improve your skills
                are by getting involved in
                """);
        sb.append(index.getReference("open source software", sid));
        w.addPET(sb,
                """
                 development projects, reviewing code, writing code, reading
                documentation and doing other programming courses.
                """);
        w.addP(sb,
                """
                Being familiar with one programming language helps in learning
                another. Many concepts are shared and the language syntax and
                workflows are often similar.
                """);
        w.addP(sb,
                """
                Some programming languages are particularly well geared for
                particular types of application. This can be a consequence of
                the language fundamentals, but often it is because something
                similar has already been done with that language.
                """);
        w.addP(sb,
                """
                When given a choice, experienced programmers will often choose
                a language for an implementation because they either know that
                language well - and can envisage what to do, or because they
                know that a particular language is well suited to the task, or
                because they want to learn/try something new/different.
                """);
        w.addP(sb,
                """
                Programming and programming language development are typically
                community activities. It is normal to ask others for help and to
                provide others with help and work collaboratively to develop
                software. There are various online systems that help with this
                including online forums.
                """);
        return sid;
    }

    public void getLearning1(StringBuilder sb, SectionID sid) {
        w.addP(sb,
                """
                Asking for help with programming is a skill. Whilst it may be
                easiest for you to show someone what is happening and talk about
                it. It is often not so easy to arrange an interactive help
                session. Often the best way to get help is to document the issue
                - describe and detail with text and pictures what is happeneing
                and why this is confusing or not what you expect/want to happen.
                Often the act of describing and detailing the issue can help with
                understanding and trying different things which may ultimately
                resolve the issue before you ask for help. Don't see this as
                wasted effort, the more you practise preparing to ask for help,
                the better you should be at it when you do!
                """);
        w.addP(sb,
                """
                Often detailing an issue involves consulting documentation
                and providing information about your environment. Sometimes the
                issue is not that you have done something wrong, but that some
                other code or software is not working as it should, or that the
                way that things are set up to work is somehow causing the issue.
                """);
        w.addPST(sb, "Sometimes the issue is a result of a '");
        sb.append(index.getReference("software bug", sid));
        sb.append("""
                ' - an error, flaw or fault in the design, development, or
                operation that causes incorrect or unexpected things to happen.
                Sometimes issues happen in the same way each time something is
                attempted, other times the fault only sometimes happens. A
                fault that only sometimes happens is known as a '""");
        sb.append(index.getReference("glitch", sid));
        w.addPET(sb, "' and these can be difficult to troubleshoot.");
        w.addP(sb,
                """
                Often it is worth restarting software or rebooting the
                operating system to attempt to stop unexpected behaviour
                happening. If you start having to do this frequently it becomes
                more of a pain, so that you either want a better work around, or
                for the bug to get fixed.
                """);
        w.addP(sb,
                """
                Reporting a bug is an important activity in software and
                language development. Many bug reports are made openly
                available. A 'known bug' is one that has been reported already.
                This may already be being worked on or be 'resolved' or 'fixed'
                or there may be 'workarounds' - ways of coping.
                """);
        w.addP(sb,
                """
                A new version of software is typically released with one or
                more bug fixes. Sometimes you have to decide when it is worth
                doing the work to change to this later version or whether you
                can cope with a workaround.
                """);
        w.addP(sb,
                """
                Whether you are filing a bug report, or just asking for help,
                often you should aim to provide a minimum working example to
                replicate the bug/issue. And as with all data exchanges, you
                should think carefully before sharing data.
                """);
        w.addP(sb,
                """
                In learning to program, some things you might comprehend
                instantly, other things might take several attempts to grasp or
                fully understand. Some things you might understand, but they
                seem strange. Usually, there is a good reason why something
                works and is written the way it is, but no language is perfect
                and there may well be a better way...
                """);
    }

    public void getLanguageEvolution(StringBuilder sb) {
        SectionID sid = addSection("Language Evolution, Deprecation and Versions", sb);
        w.addPST(sb, "High level computer programming languages like ");
        sb.append(index.getReference("Java", sid));
        sb.append(" and ");
        sb.append(index.getReference("Python", sid));
        w.addPET(sb,
                """
                 can evolve rapidly. Occasionally new languages are developed.
                Some programming languages are retired or become obsolete, and
                some older versions of languages become unsupported over time.
                The release cadence is how often releases are made. Sometimes
                releases are of different kinds which are supported for
                different periods.
                """);

        w.addPST(sb, "Supporting ");
        sb.append(index.getReference("backward compatibility", sid));
        w.addPET(sb,
                """
                 - interoperability with older versions - has both costs and
                benefits. These costs and benefits are weighed up by those
                developing languages that tyically have a process of deciding
                how things change.
                """);

        w.addP(sb,
                """
                Changes that are not backward compatible can create a lot of
                work! It is also discouraging if old code does not work with
                newer language interpreters as this results in reliance on old
                versions which can be problematic and have cyber security
                implications.
                """);

        w.addP(sb,
                """
                Languages compete for users and developers. Often new features
                in one language are implemented in other languages soon after.
                The pace of language evolution is related to the scale of
                investment in resources, and the skill, and design decisions
                taken by the developer community.
                """);

        w.addP(sb,
                """
                As new syntax, new functionality and more efficient ways of
                doing things evolve in a language, some code either becomes
                obsolete, or is best changed to use the new ways. This can
                require considerable effort to retire or update (refactor) code.
                """);

        w.addP(sb,
                """
                Fundamental changes in language syntax are associated with
                major new versions of a language. Minor versions may add new
                language features. Minor-minor version changes are usually
                associated with one or more bug fix.
                """);

        w.addPST(sb, "");
        sb.append(index.getReference("Deprecation", sid));
        w.addPET(sb,
                """
                 is a common part of modern high level languages and third party
                software. It is part of a process of phasing things out. Things
                are first marked as deprecated in a version, then in subsequent
                versions the things are removed.
                """);
    }

    public void getConsiderata(StringBuilder sb) {
        SectionID sid = getConsiderata0(sb);
        getConsiderataN(sb, sid);
    }

    public SectionID getConsiderata0(StringBuilder sb) {
        SectionID sid = addSection("Considerata", sb);
        w.addPST(sb,
                """
                For many reasons, a key one in science and for evidence
                based policy being '
                """);
        sb.append(index.getReference("reproducibility", sid));
        w.addPET(sb,
                """
                ', it is important to know what version of a language and any
                third party components a program has been tested with and
                results have been produced with.
                """);
        w.addP(sb,
                """
                With any language, there are often several ways to achieve the
                same or a similar thing. Some ways may work faster, can handle
                larger volumes of data, or might be more concise in terms of the
                amount of source code. There might be no obvious right way to do
                something - so sometimes, independent programming efforts
                produce significantly different source code that essentially
                does the same thing. In other instances, and especially where
                there are style and naming guidelines, source code produced
                independently may be identical.
                """);
        w.addP(sb,
                """
                In learning to program, and in programming generally, code
                review is an important way to transfer skills and knowledge,
                develop good practise and improve code and software.
                """);
        w.addP(sb,
                """
                Throughout this course, you are encouraged to produce easy to
                understand, easy to maintain, efficient, reliable, well tested
                and well documented code/software. Not all code and software in
                use today is like this!
                """);
        w.addP(sb,
                """
                Remember to take care and think about the trustworthiness of
                any code you run.
                """);
        w.addP(sb,
                """
                Please adhere to the terms and conditions of software licenses.
                """);
        return sid;
    }

    public void getConsiderataN(StringBuilder sb, SectionID sid) {
        w.addDIVET(sb);
    }
}
