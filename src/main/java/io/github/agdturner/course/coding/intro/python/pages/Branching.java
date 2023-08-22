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
public class Branching extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public Branching(PythonIntroCodingCourse course) {
        super(course, "branching", "Branching", "Branching");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        w.addPST(sb, 
                """
                Branching controls the flow of a program. This part considers a
                couple of ways of branching in Python. The main way uses an '
                """);
        sb.append(index.getReference("Conditional", "if", sid));
        w.addPET(sb, "' statement.");
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("If", sb);
        w.addPST(sb, "The ");
        sb.append(index.getReference("Python if", "if statement", sid));
        w.addPET(sb,
                """
                 is a 'compound' statement (one that comprises groups of other
                statements) that provides a means to branch based upon a
                condition which evaluates to either 'True' or" " 'False'.
                Consider the following example:
                """);
        addPythonCodeBlock(sb,
                """
                day_of_week = 5
                day = "Weekday"
                # A simple If Statement
                if day_of_week >= 6:
                    day = "Weekend"
                print(day)
                """);
        w.addP(sb,
                """
                The if statement condition evaluates as False, so the result is:
                """);
        w.addPRE(sb, "Weekday");
        w.addP(sb, "Changing the code slightly to:");
        addPythonCodeBlock(sb,
                """
                day_of_week = 6
                # A simple If Statement
                day = "Weekday"
                if day_of_week >= 6:
                    day = "Weekend"
                print(day)
                """);
        w.addP(sb, "Results in:");
        w.addPRE(sb, "Weekend");
        w.addP(sb,
                """
                An 'else' clause branches into two distinct paths which become
                one again at the end of the compound if statement as in the
                following example.
                """);
        addPythonCodeBlock(sb,
                """
                day_of_week = 5
                # An If-else  Statement
                if day_of_week < 6:
                    day = "Weekday"
                else:
                    day = "Weekend"
                print(day) # <-- Prints Weekday
                """);
        w.addP(sb,
                """
                One or many 'elif' clauses can also be inserted between if and
                else clauses. Elif is short for 'else if'. Consider the
                following example:
                """);
        addPythonCodeBlock(sb,
                """
                day_of_week = 5
                # An If-elif-else Statement
                if day_of_week == 1:
                    day = "Monday"
                elif day_of_week == 2:
                    day = "Tuesday"
                elif day_of_week == 3:
                    day = "Wednesday"
                elif day_of_week == 4:
                    day = "Thursday"
                elif day_of_week == 5:
                    day = "Friday"
                else:
                    day = "Weekend"
                print(day) # <-- Prints Friday
                """);
        w.addP(sb,
                """
                It can be argued that it is better to store a dictionary to
                look up the day from the day_of_week, but a simple look up does
                not branch, and more code can be inserted in any of the clauses,
                so this can do more than just look up a value from a key.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Match", sb);
        w.addPST(sb, "Since Python 3.10 there is also a ");
        sb.append(index.getReference("Python match", "match", sid));
        w.addPET(sb,
                """
                 statement which can simplify if statements with many elif
                clauses as a 'match-case' statement. The following example shows
                the equivalent of the example from the end of previous section:
                """);
        addPythonCodeBlock(sb,
                """
                day_of_week = 5
                match day_of_week:
                    case 1:
                        day = "Monday"
                    case 2:
                        day = "Tuesday"
                    case 3:
                        day = "Wednesday"
                    case 4:
                        day = "Thursday"
                    case 5:
                        day = "Friday"
                    case _:
                        day = "Weekend"
                print(day) # <-- Prints Friday
                """);
        w.addP(sb,
                """
                The final case is a catch all case using the anonymous variable
                '_' which matches anything.
                """);
        w.addP(sb,
                """
                The match-case statement offers more than a syntactic variation,
                as containers and other objects can be matched. Examples of
                these and further details can be found in the relevant PEPS:
                """);
        w.addULST(sb);
        w.addLI(sb, 
                """
                <a href="https://peps.python.org/pep-0634/">
                PEP 634, Structural Pattern Matching: Specification</a>
                """);
        w.addLI(sb, 
                """
                <a href="https://peps.python.org/pep-0635/">
                PEP 635, Structural Pattern Matching: Motivation and Rationale
                </a>
                """);
        w.addLI(sb, 
                """
                <a href="https://peps.python.org/pep-0636/">
                PEP 636, Structural Pattern Matching: Tutorial</a>
                """);
        w.addULET(sb);
        w.addDIVET(sb);
        return sb.toString();
    }
}
