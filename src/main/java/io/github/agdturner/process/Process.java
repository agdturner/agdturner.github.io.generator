/*
 * Copyright 2023 Centre for Computational Geography.
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
package io.github.agdturner.process;

import io.github.agdturner.course.coding.intro.java.process.Java0;
import io.github.agdturner.course.coding.intro.python.process.Python0;
import io.github.agdturner.course.coding.intro.python.sog.process.GEOG5003M;
import io.github.agdturner.course.coding.intro.python.sog.process.GEOG5990M;
import io.github.agdturner.course.coding.intro.python.sog.process.GEOG5995M;
import io.github.agdturner.pages.MyHome;

/**
 * A master process to create all sites.
 * 
 * @author Andy Turner
 */
public class Process {
    
    /**
     * Create a new instance.
     */
    public Process(){}
    
    /**
     * Main method.
     * @param args Arguments are ignored.
     */
    public static void main(String[] args) {
        new Process().run(args);
    }
    
    /**
     * The runner.
     * @param args Arguments are ignored.
    */
    public void run(String[] args) {
        MyHome.main(args);
        //GEOG5003M.main(args);
        //GEOG5990M.main(args);
        //GEOG5995M.main(args);
        Python0.main(args);
        //Java0.main(args);
    }
    
    
}
