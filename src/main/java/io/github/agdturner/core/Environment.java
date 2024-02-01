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
package io.github.agdturner.core;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A class storing a String and a Path.
 *
 * @author Andy Turner
 */
public class Environment {

    public static final String HTTPS_WWW_GITHUB_COM_AGDTURNER = "http://www.github.com/agdturner/";
    public static final String AGDTURNER_GITHUB_IO = "agdturner.github.io";
    public static final String HTTPS_AGDTURNER_GITHUB_IO = "http://" + AGDTURNER_GITHUB_IO + "/";
    public static final String AGDTURNER_GITHUB_IO_REPO = HTTPS_WWW_GITHUB_COM_AGDTURNER + AGDTURNER_GITHUB_IO;
    public static final String AGDTURNER_GITHUB_IO_GENERATOR_REPO = AGDTURNER_GITHUB_IO_REPO + ".generator";

    public static final String ARCDOCS_GITHUB_IO = "arcdocs.github.io";
    public static final String HTTPS_ARC_LEEDS_AC_UK = "https://arc.leeds.ac.uk/";
    public static final String HTTPS_ARC_LEEDS_AC_UK_ABOUT_TEAM = HTTPS_ARC_LEEDS_AC_UK + "about/team/";
    public static final String ARC_CONTACT = "https://it.leeds.ac.uk/it?id=sc_cat_item&sys_id=7587b2530f675f00a82247ece1050eda";

    public static final String HTTPS_WWW_LEEDS_AC_UK = "https://www.leeds.ac.uk/";

    public static final String HTTPS_WWW_GEOG_LEEDS_AC_UK = "https://www.geog.leeds.ac.uk/";
    public static final String HTTPS_WWW_GEOG_LEEDS_AC_UK_COURSES_COMPUTING = HTTPS_WWW_GEOG_LEEDS_AC_UK + "courses/computing/";

    public static final String HTTPS_WWW_CCG_LEEDS_AC_UK = "https://www.ccg.leeds.ac.uk/";

    /**
     * The latest version of Java.
     */
    public static final String JAVA_LATEST_VERSION = "21";

    /**
     * The latest Long Term Support version of Java.
     */
    public static final String JAVA_LATEST_LTS_VERSION = "21";

    /**
     * The default Wikipedia URL.
     */
    public static final String EN_WIKIPEDIA_URL = "https://en.wikipedia.org/wiki/";

    /**
     * The default Wikipedia URL.
     */
    public static final String DOCS_ORACLE_COM_EN_JAVA_JAVASE
            = "https://docs.oracle.com/en/java/javase/" + JAVA_LATEST_LTS_VERSION
            + "/docs/api/java.base/java/";

    /**
     * The domain for the website.
     */
    public final String domain;

    /**
     * The Path of a directory where the website pages are written.
     */
    public final Path dir;

    /**
     * Create a new instance.
     *
     * @param domain What {@link #domain} is set to.
     * @param dir What {@link #dir} is set to.
     */
    public Environment(String domain, Path dir) {
        this.domain = domain;
        this.dir = Paths.get(dir.toString(), domain);
    }

    /**
     * @param article Appended to create what is returned.
     * @return {@link #EN_WIKIPEDIA_URL} + article;
     */
    public static final String getWikipediaURL(String article) {
        return EN_WIKIPEDIA_URL + article;
    }

    /**
     * @param tpackage Appended to create what is returned.
     * @param tclass Appended to create what is returned.
     * @return {@link #DOCS_ORACLE_COM_EN_JAVA_JAVASE} +
     * tpackage.replaceAll("\\.", "/") + "/" + tclass;
     */
    public static final String getJavaDocURL(String tpackage, String tclass) {
        return DOCS_ORACLE_COM_EN_JAVA_JAVASE + tpackage.replaceAll("\\.", "/")
                + "/" + tclass;
    }
}
