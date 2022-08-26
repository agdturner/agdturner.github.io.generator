/*
 * Copyright 2022 Centre for Computational Geography.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.agdturner.course;

import io.github.agdturner.core.Environment;
import io.github.agdturner.core.PageID;
import io.github.agdturner.core.SectionID;
import io.github.agdturner.core.TermID;
import io.github.agdturner.core.ReferenceID;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Java for generating https://agdturner.github.io Website Content for a course.
 *
 * @author Andy Turner
 */
public class Course {

    /**
     * For storing the course Type e.g. python.
     */
    public final String courseType;

    /**
     * For storing the course Code e.g. GEOG5990.
     */
    public final String courseCode;

    /**
     * For storing the course Name. e.g. "Programming for Geographical
     * Information Analysis: Core Skills"
     */
    public final String courseName;

    /**
     * For storing the course directory path.
     */
    public final Path courseDir;

    /**
     * For storing the course Home Page.
     */
    public CoursePageHome homePage;

    /**
     * The Course Pages (not the CoursePageHome)
     */
    public ArrayList<CoursePage> coursePages;

    /**
     * For storing the course Index Page.
     */
    public CoursePageIndex indexPage;

    /**
     * For storing the course References Page.
     */
    public CoursePageReferences referencesPage;

    /**
     * A set of all the Page IDs.
     */
    public TreeSet<PageID> pageIDs;

    /**
     * A set of all the Section IDs.
     */
    public TreeSet<SectionID> sectionIDs;

    /**
     * To look up the SectionIDs in a Page.
     */
    public TreeMap<PageID, TreeSet<SectionID>> pageIDToSectionIDs;

    /**
     * To look up a PageID from a SectionID.
     */
    public TreeMap<SectionID, PageID> sectionIDToPageID;

    /**
     * To look up a Section Name from a SectionID.
     */
    public TreeMap<SectionID, String> sectionIDToSectionName;
    
    /**
     * To look up the name from the pageID.
     */
    public HashMap<PageID, String> pageIDToName;

    /**
     * To look up the abbreviated name from the PageID.
     */
    public HashMap<PageID, String> pageIDToNameA;

    /**
     * To look up the PageID from the abbreviated name.
     */
    public HashMap<String, PageID> nameAToPageID;

    /**
     * To look up a Link from a PageID.
     */
    public HashMap<PageID, String> pageIDToLink;

    /**
     * To look up a Term from a TermID
     */
    public HashMap<TermID, String> termIDToTerm;

    /**
     * To look up TermIDs in Term order.
     */
    public TreeMap<String, TermID> termToTermID;

    /**
     * For storing an index of Terms and the SectionIDs they are in
     */
    public HashMap<TermID, TreeSet<SectionID>> index;
    
    /**
     * A set of all the Reference IDs.
     */
    public HashSet<ReferenceID> referenceIDs;

    /**
     * To look up a Reference from a ReferenceID
     */
    public HashMap<ReferenceID, String> referenceIDToReference;

    /**
     * To look up a Reference from a ReferenceID
     */
    public TreeMap<String, ReferenceID> referenceToReferenceID;

    /**
     * For Page indexing.
     */
    public int iPage;
    
    /**
     * For Section indexing.
     */
    public int iSection;
    
    /**
     * For Term indexing.
     */
    public int iTerm;
    
    /**
     * For Reference indexing.
     */
    public int iReference;
    
    /**
     * Creates a new instance.
     *
     * @param courseType What {@link #courseType} is set to.
     * @param courseCode What {@link #courseCode} is set to.
     * @param courseName What {@link #courseName} is set to.
     */
    public Course(String courseType, String courseCode, String courseName) {
        this.courseType = courseType;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseDir = Paths.get(Environment.dirCourses.toString(),
                courseType, courseCode);
        pageIDs = new TreeSet<>();
        sectionIDs = new TreeSet<>();
        pageIDToSectionIDs = new TreeMap<>();
        sectionIDToPageID = new TreeMap<>();
        sectionIDToSectionName = new TreeMap<>();
        pageIDToName = new HashMap<>();
        pageIDToNameA = new HashMap<>();
        nameAToPageID = new HashMap<>();
        pageIDToLink = new HashMap<>();
        termIDToTerm = new HashMap<>();
        termIDToTerm = new HashMap<>();
        termToTermID = new TreeMap<>();
        referenceIDs = new HashSet<>();
        referenceIDToReference = new HashMap<>();
        referenceToReferenceID = new TreeMap<>();
        iPage = 0;
        iSection = 0;
        iTerm = 0;
        iReference = 0;
    }

    /**
     * For adding a General Page to the Course.
     *
     * @param w The Web_ContentWriter of the Home Page to add the link to.
     * @param s The long name of a Page.
     * @param linkName The link name for the Page - this is to be unique, in
     * some cases it is the same as s, in other cases it is an abbreviation.
     */
    public void addPage(Web_ContentWriter w, PageID id, String s, String linkName) {
        pageIDs.add(id);
        pageIDToName.put(id, linkName);
        pageIDToNameA.put(id, s);
        nameAToPageID.put(s, id);
        w.add("<li>" + Web_ContentWriter.getLink(s, linkName) + "</li>");
        pageIDToLink.put(id, "../" + s);
    }

}
