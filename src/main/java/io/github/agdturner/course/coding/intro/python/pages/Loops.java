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
package io.github.agdturner.course.coding.intro.python.pages;

import io.github.agdturner.core.SectionID;
import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.course.CoursePage;

/**
 * For Python Intro Course Branching and Loops Page.
 *
 * @author Andy Turner
 */
public class Loops extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     *
     */
    public Loops(PythonIntroCodingCourse course) {
        super(course, "loops", "Loops", "Loops");
    }
    
    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        addParagraphStart(sb, "Python has syntax for '");
        sb.append(index.getReference("While Loop", "while loops", sid));
        sb.append("' and '");
        sb.append(index.getReference("For Loop", "for loops", sid));
        addParagraphEnd(sb,
                """
                '. While loops are typically used to repeat something until a
                condition is reached. For loops are typically used to repeat
                something a set number of times (or for each thing in a
                 sequence).
                """);

        sid = addSection("While", sb);
        addParagraphStart(sb, "The following provides an example of a ");
        sb.append(index.getReference("Python while", "while", sid));        
        addParagraphEnd(sb, " statement:");
        addPythonCodeBlock(sb,
                """
                x = 1
                while (x < 10):
                    print(x)
                    x += 1
                """);
        addParagraph(sb, 
                """
                If a while loops condition never evaluates as 'False' then the
                loop will continue indefinitely. This is sometimes a reason why
                a program fails to terminate when you were expecting it to.
                """);
        addParagraphStart(sb, "A ");
        sb.append(index.getReference("Python break", "break", sid));
        addParagraphEnd(sb, 
                """
                statement breaks out of a loop which is commonly done when some
                other condition is reached. For example, consider the following
                code:
                """);
        addPythonCodeBlock(sb,
                """
                # Print the largest number less than 1 million that is divisible by 17
                x = 1000000
                while (x != 0):
                    if (x % 17 == 0):
                        break
                    x -= 1
                print(x)
                """);
        addParagraph(sb, "The output of which is:");
        addPre(sb, "999991");
        addParagraphStart(sb, "The ");
        sb.append(index.getReference("Python continue", "continue", sid));
        addParagraphEnd(sb,
                """
                statement gets the program to return to the start of a loop
                when a condition is reached:
                """);
        addPythonCodeBlock(sb,
                """
                # Print odd numbers from 1 to 10
                x = 0
                while x < 10:
                    x += 1
                    if (x % 2) == 0:
                        continue
                    print(x, end =" ")
                """);
        addParagraph(sb, "The output of which is:");
        addPre(sb, "1 3 5 7 9");
        addParagraph(sb, 
                """
                An 'else' clause can be used with a while loop and this code
                within it is executed when the while condition evaluates as
                'False'.
                """);
        addParagraph(sb, 
                """
                Note that in the above code snippet a 'keyword argument
                (kwarg)' called 'end' is used in the print command to substitute
                the normal end of print statement - a newline - with a space.
                """);

        sid = addSection("For", sb);
        addParagraphStart(sb, "");
        sb.append(index.getReference("For Loop", "For loops", sid));
        sb.append(" in Python (");
        sb.append(index.getReference("Python for", "for loop", sid));
        addParagraphEnd(sb, 
                """
                ) are used with sequences that are 'iterable'. Iterable means
                can be gone through one at a time. In the following example, the
                first time around the loop, the variable 'x' is assigned the
                value '0', the second time around the loop x is assigned the
                value '1' and so on:
                """);
        addPythonCodeBlock(sb, 
                """
                for x in (0,1,2,3,4,5,6,7,8,9):
                    print(x)
                """);
        addParagraphStart(sb, 
                "For sequences of numbers, it is much more common to use a ");
        sb.append(index.getReference("Python range", "range", sid));
        addParagraphEnd(sb, 
                """
                , for example, the following does the same as the previous
                example:
                """);
        addPythonCodeBlock(sb, 
                """
                for x in range(10):
                    print(x)
                """);
        addParagraph(sb, "It is also common to use a slice, for example:");
        addPythonCodeBlock(sb,
                """
                names = ("Dale", "Albert", "Gordon", "Tamara", "Philip", "Chester", "Windom")
                for name in names[1:5:2]:
                    print(name) # <-- Prints "Albert", "Tamara"
                """);
        addParagraph(sb, 
                """
                Sometimes it is helpful to know the index in the sequence when
                iterating, so alternatively we can do the following:
                """);
        addPythonCodeBlock(sb,
                """
                names = ("Dale", "Albert", "Gordon", "Tamara", "Philip", "Chester", "Windom")
                for i in range(len(names)):
                    print(i, names[i])
                """);
        addParagraph(sb, 
                """
                Note, that 'i' cannot be changes within the loop to skip
                objects. As assignment for 'i' would creates a new variable. So
                the following code:
                """);
        addPythonCodeBlock(sb,
                """
                names = ("Dale", "Albert", "Gordon", "Tamara", "Philip", "Chester", "Windom")
                for i in range(len(names)):
                    print(i, names[i])
                    i += 2
                    print(i)
                """);
        addParagraph(sb, "Produces:");
        addPre(sb,
                """
                0 Dale
                2
                1 Albert
                3
                2 Gordon
                4
                3 Tamara
                5
                4 Philip
                6
                5 Chester
                7
                6 Windom
                8
                """);
        addParagraph(sb,
                """
                Slices copy containers, while ranges are iterators that
                actually generate the values one at a time. So, it is more
                efficient to do the following:
                """);
        addPythonCodeBlock(sb,
                """
                names = ("Dale", "Albert", "Gordon", "Tamara", "Philip", "Chester", "Windom")
                for i in range(2,len(names),2):
                    print(names[i])
                """);
        addParagraph(sb, "Instead of:");
        addPythonCodeBlock(sb,
                """
                for name in names[2::2]:
                    print(name)
                """);
        addParagraph(sb,
                """
                A disadvantage of not having an index counter and using a
                sequence is that it makes it harder to remove items from the
                sequence which is often useful. For example, the following code
                does not empty the list names because as we remove the first
                thing in the list, everything else moves to a new position and
                the iterator skips over a value each time:
                """);
        addPythonCodeBlock(sb,
                """
                names = ["Dale","Albert","Gordon","Tamara","Philip", "Chester","Windom"]
                for name in names:
                    names.remove(name)
                print(names)
                """);
        addParagraph(sb,
                """
                A solution to this is to create a slice containing everything
                and then remove from the original list:
                """);
        addPythonCodeBlock(sb,
                """
                names = ["Dale","Albert","Gordon","Tamara","Philip", "Chester","Windom"]
                for name in names[:]:
                    names.remove(name)
                print(names)
                """);
        addParagraph(sb,
                """
                It would though probably be better to simply reinitialise
                'names' as an empty list.
                """);
        addParagraphStart(sb,
                """
                As with a while loop, an 'else' clause can be added to for loop
                and is executed once the loop completes, or not at all if there
                is a
                """);
        sb.append(index.getReference("Python break", "break", sid));
        addParagraphEnd(sb,
                """
                statement that terminates the loop before the last iteration
                completes.
                """);
        addParagraphStart(sb, "Also, a ");
        sb.append(index.getReference("Python continue", "continue", sid));
        addParagraphEnd(sb,
                """
                statement can be used to skip to the start of the next loop
                iteration in the same way as in a while loop.
                """);

        sid = addSection("Nesting loops", sb);
        addParagraph(sb,
                """
                In spatial analysis it is common to want to go through two
                dimensional (2D) raster data or tables of values. One way to do
                this is to nest for loops. Consider the following code which
                goes through all the rows in 'data' and for each 'row', goes
                through the values (one for each 'column'):
                """);
        addPythonCodeBlock(sb,
                """
                data = [
                [0,1,2],
                [3,4,5]
                ]
                for row in data:
                    for value in row:
                        print(value, end=" ")
                    print()
                """);
        addParagraph(sb, "The output of this program is:");
        addPre(sb,
                """
                0 1 2
                3 4 5
                """);
        addParagraph(sb,
                """
                It is often necessary to know and use the row and column
                indexes. Another way to do this is as follows:
                """);
        addPythonCodeBlock(sb,
                """
                data = [
                [0,1,2],
                [3,4,5]
                ]
                for row in range(len(data)):
                    for col in range(len(data[row])):
                        print(data[row][col], end=" ")
                    print()
                """);
        addParagraphStart(sb, "Recall that the ");
        sb.append(index.getReference("Python len", "len", sid));
        sb.append(
                """
                function, when passed a sequence as a parameter, returns the
                length of the sequence, and the
                """);
        sb.append(index.getReference("Python range", "range", sid));
        addParagraphEnd(sb, 
                """
                function turns an Integer argument into a sequence starting
                from '0' and ending with one less than that argument stepping by
                1.
                """);
        addParagraph(sb,
                """
                When processing raster data like this, care is needed not to
                get rows and columns mixed up. This is easier to do if the data
                have the same number of rows and columns!<
                """);
              
        sid = addSection("Moving Window Algorithms", sb);
        addParagraph(sb,
                """
                These are commonly used in image processing and for surface
                analysis. One of the difficulties in applying these concerns
                what to do at the boundaries. The main options are: to deal with
                the special edge and corner cases; to process only those parts
                for which there are data for all parts of the 'window'. Using
                the latter of these solutions we could calculate the maximum
                value in a 3x3 neighbourhood as follows:
                """);
        addPythonCodeBlock(sb,
                """
                data = [
                [0,1,2,3,4,5],
                [6,7,8,9,10,11],
                [12,13,14,15,16,17],
                [18,19,20,21,22,23],
                [24,25,26,27,28,29],
                [30,31,32,33,34,35]
                ]
                result = []
                for row in range(1, len(data) - 1):
                    row_result = []
                    for col in range(1, len(data[row]) - 1):
                        value = data[row][col]
                        for i in range(-1, 2):
                            for j in range(-1, 2):
                                value = max(value, data[row + i][col + j])
                        row_result.append(value)
                        print(value, end=" ")
                    result.append(row_result)
                    print()
                #print(result)
                """);
        addParagraph(sb, "The output of which is:<");
        addPre(sb,
                """
                14 15 16 17
                20 21 22 23
                26 27 28 29
                32 33 34 35
                """);
              
        sid = addSection("Next", sb);
        addParagraph(sb,
                """
                Use containers, branches and loops to simplify and extend the
                Agent Based Model code.
                """);
        return sb.toString();
    }
}
