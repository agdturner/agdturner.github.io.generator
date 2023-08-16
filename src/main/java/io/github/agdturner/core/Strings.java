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

//import java.util.ArrayList;
//import java.util.HashMap;
import uk.ac.leeds.ccg.web.core.Web_Strings;

/**
 * A class for handling strings.
 * 
 * @author Andy Turner
 */
public class Strings extends Web_Strings {

    
    public static final String PYTHON_CODE_BLOCK_END
            = SYMBOL_PRE_END_TAG + "</code>";

    public static final String PYTHON_CODE_BLOCK_START
            = SYMBOL_PRE_START_TAG + "<code class=\"language-python\">";

    public static final String OL_END = getEndTag(s_ol);

    public static final String OL_START = getStartTag(s_ol);
    
    public static final String UL_END = getEndTag(s_ul);

    public static final String UL_START = getStartTag(s_ul);
    
    
                
    //public ArrayList<String> strings;
    //public HashMap<String, Integer> stringToStringID;

    /**
     * Create a new instance.
     */
    public Strings() {
    }

//    /**
//     * If s is in {@link #strings} return the StringID for it. Otherwise, add s
//     * to the collections ({@link #strings} and {@link #stringToStringID}) and
//     * return the StringID.
//     *
//     * @param s The String to get the StringID for.
//     * @return The StringID for s.
//     */
//    public Integer get(String s) {
//        Integer r = stringToStringID.get(s);
//        if (r == null) {
//            r = stringToStringID.size();
//            stringToStringID.put(s, r);
//            strings.add(s);
//        }
//        return r;
//    }
//
//    /**
//     * Return strings.get(i).
//     * @param i 
//     */
//    public String get(Integer i) {
//        return strings.get(i);
//    }
    
    /**
     * @param s The String to capitalise the first letter.
     * @return s with first letter capitalised.
     */
    public static String toUpperCaseFirstLetter(String s){
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }
}
