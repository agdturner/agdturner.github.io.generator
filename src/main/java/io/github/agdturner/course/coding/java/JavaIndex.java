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
package io.github.agdturner.course.coding.java;

import io.github.agdturner.course.Course;
import io.github.agdturner.course.Index;
import io.github.agdturner.course.IndexTerm;

/**
 * Java Index Course Page.
 *
 * @author Andy Turner
 */
public class JavaIndex extends Index {

    public static String DOCS_ORACLE_COM_EN_JAVA_JAVASE = "https://docs.oracle.com/en/java/javase/20/";
    
    /**
     * Create a new instance.
     *
     * @param course What {@code #course} is set to.
     * @param filename What {@link #filename} is set to.
     * @param title What {@link #title} is set to.
     * @param label What {@link #label} is set to.
     */
    public JavaIndex(Course course, String filename, String title, String label) {
        super(course, filename, title, label);
        String term;
        String url;
        String description;
        IndexTerm indexTerm;

        term = "Java bytecode";
        url = getWikipediaURL("Java_bytecode");
        description = "the \"bytecode\" of the \"Java Virtual Machine\".";
        indexTerm = new IndexTerm(this, description, url); addIndexTerm(term, indexTerm);
        
        term = "Java Class";
        url = DOCS_ORACLE_COM_EN_JAVA_JAVASE + "docs/api/java.base/java/lang/Class.html";
        description = "Instances of the class <code>Class</code> represent "
                + "classes and interfaces in a running Java \"application\".";
        indexTerm = new IndexTerm(this, description, url); addIndexTerm(term, indexTerm);
        addAlias(term, "Java classes", indexTerm);
        
        term = "Java class file";
        url = getWikipediaURL("Java_class_file");
        description = "A file containing \"Java bytecode\" that can be "
        + "executed on the \"Java Virtual Machine\".";
        indexTerm = new IndexTerm(this, description, url); addIndexTerm(term, indexTerm);
        
        term = "Javadoc";
        url = getWikipediaURL("Javadoc");
        description = "A documentation generator for \"Java\".";
        indexTerm = new IndexTerm(this, description, url); addIndexTerm(term, indexTerm);
        
        term = "Java Platform, Standard Edition";
        url = getWikipediaURL("Java_Platform,_Standard_Edition");
        description = "A computing platform for development and deployment of "
                + "portable code for desktop and server environments.";
        indexTerm = new IndexTerm(this, description, url); addIndexTerm(term, indexTerm);
        
        term = "Java Package";
        url = getWikipediaURL("Java_package");
        description = "A Java package organizes \"Java classes\" into "
                + "namespaces, providing a unique namespace for each type it "
                + "contains. Classes in the same package can access each "
                + "other's package-private and protected members.";
        indexTerm = new IndexTerm(this, description, url); addIndexTerm(term, indexTerm);

        term = "Java Platform Module System";
        url = getWikipediaURL("Java_Platform_Module_System");
        description = "The Java Platform Module System[1] specifies a "
                + "distribution format for collections of Java code and "
                + "associated resources. It also specifies a repository for "
                + "storing these collections, or modules, and identifies how "
                + "they can be discovered, loaded and checked for integrity.";
        indexTerm = new IndexTerm(this, description, url); addIndexTerm(term, indexTerm);

        term = "Java (software platform)";
        url = getWikipediaURL("Java (software platform)");
        description = "A set of computer software and specifications that "
                + "provides a system for developing application software and "
                + "deploying it in a cross-platform computing environment";
        indexTerm = new IndexTerm(this, description, url); addIndexTerm(term, indexTerm);
        
        term = "Java Virtual Machine";
        url = getWikipediaURL("Java_Virtual_Machine");
        description = "A virtual machine that enables a computer to run "
                + "\"Java\" programs as well as programs written in other "
                + "languages that are also compiled to \"Java bytecode\". "
                + "The Java Virtual Machine (JVM) is detailed by a "
                + "specification that formally describes what is required in a "
                + "JVM implementation. It reduces the need of program authors "
                + "to worry about idiosyncrasies of underlying hardware "
                + "platforms.";
        indexTerm = new IndexTerm(this, description, url); addIndexTerm(term, indexTerm);
        addAlias(term, "JVM", indexTerm);
        
        term = "JShell";
        url = DOCS_ORACLE_COM_EN_JAVA_JAVASE + "jshell/introduction-jshell.html";
        description = "An interactive command line tool for learning \"Java\" "
                + "and prototyping. The Java Shell tool (JShell) is a \"REPL\" "
                + "tool, which evaluates declarations, statements, and "
                + "expressions as they are entered and immediately shows the "
                + "results.";
        indexTerm = new IndexTerm(this, description, url); addIndexTerm(term, indexTerm);
                        
        term = "openJDK";
        url = getWikipediaURL("OpenJDK");
        description = "A free and open-source implementation of the "
                + "\"Java Platform, Standard Edition\".";
        indexTerm = new IndexTerm(this, description, url); addIndexTerm(term, indexTerm);
        
    }

}
