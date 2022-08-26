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
package io.github.agdturner.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Things that should probably move to an IO utility library.
 * 
 * @author Andy Turner
 */
public class IO {
    
    /**
     * Creates a new directory called name in the directory path given by dir.
     *
     * @param dir The directory in which to create a directory.
     * @param name The name of the directory to create.
     * @return The Path to the directory created.
     * @throws IOException If encountered.
     */
    public static Path getDir(Path dir, String name) throws IOException {
        Path r = Paths.get(dir.toString(), name);
        if (!Files.exists(r)) {
            Files.createDirectories(r);
        }
        return r;
    }
}
