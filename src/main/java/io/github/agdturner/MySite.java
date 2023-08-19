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
package io.github.agdturner;

import io.github.agdturner.core.Environment;
import io.github.agdturner.core.Site;

/**
 * Java for generating GEOG5003M Website Content.
 *
 * @author Andy Turner
 */
public class MySite extends Site {
    
    /**
     * Creates a new instance.
     *
     * @param env What {@link #env} is set to.
     * @param localPaths What {@link #localPaths} is set to.
     */
    public MySite(Environment env, boolean localPaths) {
        super(env, localPaths);
    }
}
