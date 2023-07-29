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
    public static final String ARCDOCS_GITHUB_IO = "arcdocs.github.io";
    public static final String HTTPS_ARC_LEEDS_AC_UK = "https://arc.leeds.ac.uk/";
    
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
     * @param domain What {@link #domain} is set to.
     * @param dir What {@link #dir} is set to.
     */
    public Environment(String domain, Path dir) {
        this.domain = domain;
        this.dir = Paths.get(dir.toString(), domain);
    }
}
