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
 * For Python Intro Course Variables Page.
 *
 * @author Andy Turner
 */
public class Web extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public Web(PythonIntroCodingCourse course) {
        super(course, "web", "Web", "Web");
    }

    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("1", "Introduction", 2, sb);
        sb.append("<p>The "
                + index.getReference("Internet", sid)
                + " is an international network of addressable machines that"
                + " communicate using the "
                + index.getReference("TCP/IP", "Internet protocol suite",
                        sid)
                + " commonly known as 'TCP/IP'. The "
                + index.getReference("World Wide Web", sid)
                + " (Web) is a set of interlinked data or documents within the"
                + " Internet. Connections are made between data and documents "
                + " via connections between different machines on the internet "
                + " that host and serve the documents and data.</p>\n");
        sb.append("<p>This section of the course provides some details of how the"
                + " Web works...</p>\n");
        
        sid = addSection("2", "Network Sockets, Port Numbers, Addresses and Protocols", 2, sb);
        sb.append("<p>A '"
                + index.getReference("Network Socket", "network socket", sid)
                + "' connects machines so that data can be sent and recieved "
                + "between them across a network. The normal operation is for "
                + "a client to contact a server to open the socket for data "
                + "transfer."
                + "</p>\n");
        sb.append("<p>In Python, to open a network socket and send some data, the "
                + "following code can be used:</p>\n");
        sb.append("""
              <pre><code class="language-python">import socket
              
              socket_1 = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
              socket_1.connect(("localhost", 5555)) # Address tuple
              
              socket_1.send(bytes("hello world", encoding="UTF-8"))</code></pre>
              """);
        sb.append("<p>In this code: the connection is to 'localhost' - the local"
                + " machine; the '"
                + index.getReference("Port", "port number", sid)
                + "' for the connection is 5555; and, the bytes representing "
                + "\"hello world\" in a unicode String are sent.</p>\n");
        sb.append("<p>The following code sets up a server socket to listen on the "
                + "same port, the server code is set to receive 30 bytes of "
                + "data and then print this after converting the bytes to a "
                + "String:</p>\n");
        sb.append("""
              <pre><code class="language-python">import socket
              
              serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
              serversocket.bind(('localhost', 5555))
              serversocket.listen()
              (socket_2, address) = serversocket.accept()
              b = socket_2.recv(30)
              print(str(b))
              </code></pre>
              """);
        sb.append("""
              <p>Web applications typically open multiple network sockets and 
              data transfers are normally initiated following a communication 
              protocol.</p>\n
              """);
        sb.append("<p>Most computers use "
                + index.getReference("TCP/IP")
                + " when communicating on the Internet. The Internet Protocol"
                + " (IP) is used to split data into small chunks called "
                + "\"packets\" and address them to a specific destination "
                + "computer. The Transport Control Protocol (TCP) routes "
                + "packets, and ensures they reach and are reassembled at the "
                + "destination.</p>\n");
        sb.append("<p>Ports are numerical handles which individual software "
                + "applications associate with. The computer directs input "
                + "from the associated port to the specific software. The "
                + "first 1024 ports are allocated to specific purposes and "
                + "protocols.</p>\n");
        sb.append("<p>IP addresses are codes uniques to each networked machine. "
                + "The Domain Name Service (DNS) is a mapping from these codes "
                + "to a Web address (or host name which is often easier to "
                + "remember).</p>\n");
        sb.append("<p>To set up client/server software using sockets, it is best "
                + "to avoid specifying ports already in use and liaise with "
                + "your local IT team that are likely monitoring network "
                + "activity for suspicious behaviour.</p>\n");
        
        sid = addSection("3", "The World Wide Web", 2, sb);
        sb.append("<p>The World Wide Web (Web) is a client-server system using "
                + "port 80 and the hyper-text communication protocols:"
                + index.getReference("HTTP", sid)
                + " and "
                + index.getReference("HTTPS", sid)
                + ". When a server gets a request it is usually to send out a "
                + "Web page - a file stored in a directory on the server and "
                + "referred to via a "
                + index.getReference("URL", sid)
                + ". The URL comprises: a protocol identifier e.g. \"HTTP\", "
                + "\"HTTPS\", \"FTP\"; a case sensitive host name, e.g. "
                + "\"www.w3.org\"; a case sensitive path to the file on that "
                + "server, e.g. \"/People/Berners-Lee/Overview.html\"; and, "
                + "sometimes a port number to connect to (by default, HTTP "
                + "connects to port 80 and HTTPS connects to port 443. "
                + "Different delimeters are used to separate parts of the URL, "
                + "a complete example marked up as a hyperlink is: "
                + "<a href=\"https://www.w3.org:443/People/Berners-Lee/Overview.html\">"
                + "https://www.w3.org:443/People/Berners-Lee/Overview.html</a>"
                + "</p>\n");
        
        sid = addSection("3.1", "Web Pages", 3, sb);
        sb.append("<p>Web pages consist of text that is displayed and tags that "
                + "are not. The tags are formatting details and references to "
                + "other files like images or scripts that can provide style "
                + "information, record user interaction and/or make the page "
                + "dynamic and interactive. The tags are referred to as "
                + index.getReference("HTML", sid)
                + ". HTML files are text files typically saved with the "
                + "filename suffix \".html\" (and sometimes \".htm\"). (If "
                + "the filename is missing from the URL, by default, many "
                + "servers will send a file named \"index.html\" if it exists."
                + "<p>");
        sb.append("""
              <p>A basic webpage:</p>\n
              <pre><code>&lt;!DOCTYPE html>
              &lt;HTML lang="en-GB">
              &lt;HEAD>
              &lt;TITLE>Title for top of browser&lt;/TITLE>
              &lt;/HEAD>
              &lt;BODY>
              &lt;!-- Page content goes here; this is a comment -->
              &lt;/BODY>
              &lt;/HTML></code></pre>
              <p>All the elements are marked up using tags. Each tag starts with 
              the symbol "&lt;" and ends with the symbol ">". Most tags have a 
              paired start and end tag, with the end tag name being the same, 
              but preceded by the symbol "/". What is between the start and 
              end tags is content.</p>\n
              <p>HTML tags can be nested, so HTML can be regarded as having a 
              tree structure which is called the 'Document Object Model (DOM)', 
              where each element is a child of some parent, and each document 
              has a root.</p>\n
              <p>Data within a Web page is sometimes encoded in tables, that is, 
              between a start table tag '&lt;TABLE>' and an end table tag 
              '&lt;/TABLE>'. Within these table values are marked up using other 
              tags for rows and column elements.</p>\n
              <p>In the next ABM practical you are guided through the process of 
              parsing HTML and extracting some data from an HTML TABLE.</p>\n
              <p>HTML elements may be given classes (generic groupings) and IDs 
              (names specific to themselves) as attributes. These are declared 
              in the start tag for the element, for example:</p>\n
              <pre><code>&lt;TABLE class="data" id="table_1"></code></pre>
              """);
        
        sid = addSection("3.2", "Web Page Design", 3, sb);
        sb.append("<p>In general it is good practice to separate the content of a "
                + "Web page from information about how to style it. This is "
                + "typically done by storing the style information in a "
                + "separate file called a "
                + index.getReference("CSS", "Cascading Style Sheet",
                        sid)
                + "  (CSS). These are linked to the HTML in the 'HEAD' section "
                + "with the following tag:</p>\n");
        sb.append("""
              <pre><code>&lt;link rel="stylesheet" href="url_to_css_file"></code></pre>
              <p>The CSS file can be located relative to the page in the 
              directory structure by replacing the URL with the relative file 
              path.</p>\n
              """);
        sb.append("<p>The focus of design should be usability. A key part of this "
                + "is "
                + index.getReference("Web Accessibility", "accessibility",
                        sid)
                + ". If you are working for a public organisation, "
                + "accessibility should be a major design driver.</p>\n");
        
        sid = addSection("3.3", "Processing Web Pages", 3, sb);
        sb.append("<p>Web pages can be retrieved by issuing HTTP requests. In "
                + "Python a good option for this is the "
                + index.getReference("Python Requests", "Requests library", sid)
                + " that comes with Anaconda.</p>\n");
        sb.append("<p>Once the content of a Web page has been retrieved a helpful "
                + "library for parsing the HTML is the "
                + index.getReference("Beautiful Soup",
                        "Beautiful Soup library", sid)
                + "</p>\n");
//              <pre></pre>
//              <pre><code class="language-python"></code></pre>
//              <p></p>\n
//              <pre></pre>
        sb.append("</div>\n");
        return sb.toString();
    }
}
