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
        SectionID sid = addSection("Introduction", sb);
        addParagraphStart(sb, "The ");
        sb.append(index.getReference("Internet", sid));
        sb.append(
                """
                 is an international network of addressable machines that
                communicate using the
                """);
        sb.append(index.getReference("TCP/IP", "Internet protocol suite", sid));
        sb.append(" commonly known as 'TCP/IP'. The ");
        sb.append(index.getReference("World Wide Web", sid));
        addParagraphEnd(sb, 
                """
                 (Web) is a set of interlinked data or documents within the
                Internet. Connections are made between data and documents
                via connections between different machines on the internet
                that host and serve the documents and data.
                """);
        addParagraph(sb, 
                """
                This section of the course provides some details of how the Web
                works...
                """);
        
        sid = addSection("Network Sockets, Port Numbers, Addresses and Protocols", sb);
        addParagraphStart(sb, "A '");
        sb.append(index.getReference("Network Socket", "network socket", sid));
        addParagraphEnd(sb, 
                """
                ' connects machines so that data can be sent and recieved
                between them across a network. The normal operation is for a
                client to contact a server to open the socket for data transfer.
                """);
        addParagraph(sb, 
                """
                In Python, to open a network socket and send some data, the
                following code can be used:
                """);
        addPythonCodeBlock(sb, 
                """
                import socket

                socket_1 = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
                socket_1.connect(("localhost", 5555)) # Address tuple

                socket_1.send(bytes("hello world", encoding="UTF-8"))
                """);
        addParagraphStart(sb, 
                """
                In this code: the connection is to 'localhost' - the local
                machine; the '
                """);
        sb.append(index.getReference("Port", "port number", sid));
        addParagraphEnd(sb, 
                """
                ' for the connection is 5555; and, the bytes representing
                "hello world" in a unicode String are sent.
                """);
        addParagraph(sb,
                """
                The following code sets up a server socket to listen on the same
                port, the server code is set to receive 30 bytes of data and
                then print this after converting the bytes to a String:
                """);
        addPythonCodeBlock(sb,
                """
                import socket

                serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
                serversocket.bind(('localhost', 5555))
                serversocket.listen()
                (socket_2, address) = serversocket.accept()
                b = socket_2.recv(30)
                print(str(b))
                """);
        addParagraph(sb, 
                """
                Web applications typically open multiple network sockets and
                data transfers are normally initiated following a communication
                protocol.
                """);
        addParagraphStart(sb, "Most computers use ");
        sb.append(index.getReference("TCP/IP"));
        addParagraphEnd(sb,
                """
                when communicating on the Internet. The Internet Protocol (IP)
                is used to split data into small chunks called "packets" and
                address them to a specific destination computer. The Transport
                Control Protocol (TCP) routes packets, and ensures they reach
                and are reassembled at the destination.
                """);
        addParagraph(sb,
                """
                Ports are numerical handles which individual software
                applications associate with. The computer directs input from the
                associated port to the specific software. The first 1024 ports
                are allocated to specific purposes and protocols.
                """);
        addParagraph(sb,
                """
                IP addresses are codes uniques to each networked machine. The
                Domain Name Service (DNS) is a mapping from these codes to a Web
                address (or host name which is often easier to remember).
                """);
        addParagraph(sb,
                """
                To set up client/server software using sockets, it is best to
                avoid specifying ports already in use and liaise with your local
                IT team that are likely monitoring network activity for
                suspicious behaviour.
                """);
        
        sid = addSection("The World Wide Web", sb);
        addParagraphStart(sb,
                """
                The World Wide Web (Web) is a client-server system using port 80
                and the hyper-text communication protocols:
                """);
        sb.append(index.getReference("HTTP", sid));
        sb.append(" and ");
        sb.append(index.getReference("HTTPS", sid));
        sb.append(
                """
                . When a server gets a request it is usually to send out a Web
                page - a file stored in a directory on the server and referred
                to via a
                """);
        sb.append(index.getReference("URL", sid));
        addParagraphEnd(sb,
                """
                . The URL comprises: a protocol identifier e.g. "HTTP", "HTTPS",
                "FTP"; a case sensitive host name, e.g. "www.w3.org"; a case
                sensitive path to the file on that server, e.g.
                "/People/Berners-Lee/Overview.html"; and, sometimes a port
                number to connect to (by default, HTTP connects to port 80 and
                HTTPS connects to port 443. Different delimeters are used to
                separate parts of the URL, a complete example marked up as a
                hyperlink is:
                <a href="https://www.w3.org:443/People/Berners-Lee/Overview.html">
                https://www.w3.org:443/People/Berners-Lee/Overview.html</a>
                """);
        
        sid = addSubsection("Web Pages", sb);
        addParagraphStart(sb,
                """
                Web pages consist of text that is displayed and tags that are
                not. The tags are formatting details and references to other
                files like images or scripts that can provide style information,
                record user interaction and/or make the page dynamic and
                interactive. The tags are referred to as
                """);
        sb.append(index.getReference("HTML", sid));
        addParagraphEnd(sb,
                """
                . HTML files are text files typically saved with the filename
                suffix ".html" (and sometimes ".htm"). (If the filename is
                missing from the URL, by default, many servers will send a file
                named "index.html" if it exists.
                """);
        addParagraph(sb, "A basic webpage:");
        addPre(sb, 
                """
                <code>&lt;!DOCTYPE html>
                &lt;HTML lang="en-GB">
                &lt;HEAD>
                &lt;TITLE>Title for top of browser&lt;/TITLE>
                &lt;/HEAD>
                &lt;BODY>
                &lt;!-- Page content goes here; this is a comment -->
                &lt;/BODY>
                &lt;/HTML></code>
                """);
        addParagraph(sb, 
                """
                All the elements are marked up using tags. Each tag starts with
                the symbol "&lt;" and ends with the symbol ">". Most tags have a
                paired start and end tag, with the end tag name being the same,
                but preceded by the symbol "/". What is between the start and
                end tags is content.
                """);
        addParagraph(sb, 
                """
                HTML tags can be nested, so HTML can be regarded as having a
                tree structure which is called the 'Document Object Model
                (DOM)', where each element is a child of some parent, and each
                document has a root.
                """);
        addParagraph(sb, 
                """
                Data within a Web page is sometimes encoded in tables, that is,
                between a start table tag '&lt;TABLE>' and an end table tag
                '&lt;/TABLE>'. Within these table values are marked up using
                other tags for rows and column elements.
                """);
        addParagraph(sb,
                """
                In the next ABM practical you are guided through the process of
                parsing HTML and extracting some data from an HTML TABLE.
                """);
        addParagraph(sb,
                """
                HTML elements may be given classes (generic groupings) and IDs
                (names specific to themselves) as attributes. These are declared
                in the start tag for the element, for example:
                """);
        addPre(sb, """
                   <code>&lt;TABLE class="data" id="table_1"></code>
                   """);
        
        sid = addSubsection("Web Page Design", sb);
        addParagraphStart(sb, 
                """
                In general it is good practice to separate the content of a Web
                page from information about how to style it. This is typically
                done by storing the style information in a separate file called
                a
                """);
        sb.append(index.getReference("CSS", "Cascading Style Sheet", sid));
        addParagraphEnd(sb, 
                """
                 (CSS). These are linked to the HTML in the 'HEAD' section with
                the following tag:
                """);
        addPre(sb, 
                """
                <code>&lt;link rel="stylesheet" href="url_to_css_file"></code>
                """);
        addParagraph(sb,
                """
                The CSS file can be located relative to the page in the
                directory structure by replacing the URL with the relative file
                path.
                """);
        addParagraphStart(sb, 
                """
                The focus of design should be usability. A key part of this is
                """);
        sb.append(index.getReference("Web Accessibility", "accessibility",
                sid));
        addParagraphEnd(sb,
                """
                . If you are working for a public organisation, accessibility
                should be a major design driver.
                """);
        
        sid = addSubsection("Processing Web Pages", sb);
        addParagraphStart(sb,
                """
                Web pages can be retrieved by issuing HTTP requests. In Python
                a good option for this is the
                """);
        sb.append(index.getReference("Python Requests", "Requests library",
                sid));
        addParagraphEnd(sb, " that comes with Anaconda.");
        addParagraphStart(sb,
                """
                Once the content of a Web page has been retrieved a helpful
                library for parsing the HTML is the
                """);
        sb.append(index.getReference("Beautiful Soup",
                        "Beautiful Soup library", sid));
        addParagraphEnd(sb, "");
        return sb.toString();
    }
}
