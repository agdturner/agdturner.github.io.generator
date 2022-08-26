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
 *
 * @author Andy Turner
 */
public class Environment {
    
    public static final String domain = "agdturner.github.io";
    
    public static final Path dir = Paths.get("C:", "Users", "agdtu", "src", "agdt", domain);
    
    public static final Path dirCourses = Paths.get(dir.toString(), "courses");

    public static final String gURL = "http://github.com/";

    public static final String gaURL = gURL + "agdturner/";
    
}
