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
package io.github.agdturner.course.python.intro.pages;

import io.github.agdturner.course.python.intro.PythonIntroCourse;
import io.github.agdturner.course.Page;

/**
 * For Python Intro Course Variables Page.
 *
 * @author Andy Turner
 */
public class Web extends Page {
    
    /**
     * Create a new instance.
     *
     * @param c The Course.
     */
    public Web(PythonIntroCourse c) {
        super("web", "Web", "Web", c);
    }
    
    @Override
    public void write() {
        writeHeader();
        writeH1();
        w.add("""
              <h2 id="1">1. Introduction</h2>
              <p>The Internet is an international network of addressable 
              machines that communicate using the
              <a href="https://en.wikipedia.org/wiki/Internet_protocol_suite">
              Internet protocol suite, commonly known as TCP/IP</a>. The World 
              Wide Web (Web) is a set of interlinked data or documents within 
              the Internet. The Web has a client-server architecture. The key 
              element of a client-server system is the socket.</p>
              <p>In this section of the course...</p>
              
              <h2>2. Sockets, Ports, Addresses and Protocols</h2>
              <p>Sockets are connections between machines which streams can be 
              connected to to transfer data (messages). The normal operation is 
              for a client to contact a server using an address and a port 
              number.</p> 
              <p>The client and server are programs and may be running on the 
              same machine. Anyway, if the server is listening to a port, then 
              when contact occurs, it generates a standard socket connected at 
              the other end to the client socket.</p>
              <p>In Python, to open a socket to a server from a client, the 
              following code can be used:</p>
              <pre><code class=\"language-python\">import socket
              
              socket_1 = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
              socket_1.connect(("localhost", 5555)) # Address tuple
              
              socket_1.send(bytes("hello world", encoding="UTF-8"))</code></pre>
              <p>In this code, the connection is to "localhost" - the local 
              machine. The port number for the connection is 5555. The bytes 
              representing "hello world" in a unicode String are sent.</p>
              <p>The following code sets up a server socket to listen on the 
              same port, the server code is set to receive 30 bytes of data and 
              then print this after converting the bytes to a String:</p>
              <pre><code class=\"language-python\">import socket
              
              serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
              serversocket.bind(('localhost', 5555))
              serversocket.listen()
              (socket_2, address) = serversocket.accept()
              b = socket_2.recv(30)
              print(str(b))
              </code></pre>
              <p>Web applications typically open multiple sockets to different 
              clients, and one server can serve multiple clients at once. Data 
              transfers are normally initiated following a communication 
              protocol.</p>
              <p>Most computers use TCP/IP when communicating with network nodes 
              and other destination computers on the internet. The Internet 
              Protocol (IP) is used to split data into small chunks called 
              "packets" and address them to a specific destination computer. The 
              Transport Control Protocol (TCP) routes packets and ensures they 
              reach and are reassembled at the destination.</p>
              <p>Ports are numerical handles which individual software 
              applications associate with. The computer directs input from the 
              associated port to the specific software. The first 1024 ports are 
              allocated to specific purposes and protocols.</p>
              <p>IP addresses are codes uniques to each networked machine. The 
              Domain Name Service (DNS) is a mapping from these codes to a Web
              address or host name which is often easier to remember.</p>
              <p>If you want to set up client/server software using sockets, you 
              should avoid specifying ports already in use and liaise with you 
              local IT team that are likely monitoring network activity for 
              suspicious behaviour.</p>
              
              
              <h2 id="3">3. The World Wide Web</h2>
              <p>The World Wide Web (Web) is a client-server system using port 
              80 and some particular hyper-text communication protocols
              <a href="https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol">
              HTTP</a>/
              <a href="https://en.wikipedia.org/wiki/HTTPS">HTTPS</a>. When a 
              server gets a request it is usually to send out a Web page - a 
              file stored in a directory on the server and referenced via a 
              <a href="https://en.wikipedia.org/wiki/URL">
              Uniform Resource Locator (URL)</a>.
              The URL comprises: a method for locating information, e.g. "HTTP",
              "HTTPS", "FTP"; a case sensitive host name, e.g. "www.w3.org"; a 
              case sensitive path to the file on that server, e.g.
              "/People/Berners-Lee/Overview.html"; and, sometimes a port number 
              to connect to (by default, HTTP connects to port 80 and HTTPS 
              connects to port 443. Different delimeters are used to separate 
              parts of the URL, a complete example marked up as a hyperlink is:
              <a href="https://www.w3.org:443/People/Berners-Lee/Overview.html">
              https://www.w3.org:443/People/Berners-Lee/Overview.html</a>
              
              <h3 id="3.1">3.1. Web Pages</h3>
              <p>Web pages consist of text that is displayed and tags that are 
              not. The tags are formatting details and references to other files 
              like images or scripts that can provide style information, record 
              user interaction and/or make the page dynamic and interactive. The 
              tags are referred to as  
              <a href="https://en.wikipedia.org/wiki/HTML">
              HyperText Markup Language (HTML)</a>.
              <p>HTML files are text files typically saved with the filename 
              suffix ".html" (and sometimes ".htm"). Note that if the filename 
              is missing from the URL, by default, many servers will send a file 
              named "index.html".<p>
              <p>A basic webpage:</p>
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
              end tags is content.</p>
              <p>HTML tags can be nested, so HTML can be regarded as having a 
              tree structure which is called the Document Object Model (DOM), 
              where each element is a child of some parent, and each document 
              has a root.</p>
              <p>Data within a Web page is sometimes encoded in tables, that is, 
              between a start table tag "&lt;TABLE>" and an end table tag 
              "&lt;/TABLE>". Within these table values are marked up using other 
              tags for rows and column elements.</p>
              <p>In the practical you are guided through the process of parsing 
              HTML and extracting some data from an HTML TABLE.</p>
              <p>HTML elements may be given classes (generic groupings) and IDs 
              (names specific to themselves) as attributes. These are declared 
              in the start tag for the element, for example:</p>
              <pre>&lt;TABLE class="data" id="table_1"></pre>
              
              <h3 id="3.2">3.2. Web Page Design</h3>
              <p>In general it is good practice to separate the content of a 
              Web page from information about how to style it. This is typically 
              done by storing the style information in a separate file called a 
              Cascading Style Sheet (CSS). These are linked to the HTML in the 
              HEAD section with the following tag:</p>
              <pre>&lt;link rel="stylesheet" href="url_to_css_file"></pre>
              <p>Or the css can be located relative to the page in the directory 
              structure by replacing the url with the relative file path.</p>
              <p>The focus of design should be usability. A key part of this is 
              accessibility. If you are working for a public organisation, 
              accessibility for the disabled has to be a major design driver.
              </p>
              
              <h3 id="3.3">3.3. Processing Web Pages</h3>
              <p>Web pages can be retrieved by issuing HTTP requests. In Python 
              a good option for this is the
              <a href="https://requests.readthedocs.io/">requests library</a>
              that comes with Anaconda.</p>
              <p>Once the content of a Web page has been retrieved a helpful 
              library for parsing the HTML is
              <a href="https://beautiful-soup-4.readthedocs.io/">
              Beautiful Soup</a></p>
              
              """);
//              <pre></pre>
//              <pre><code class=\"language-python\"></code></pre>
//              <p></p>
//              <pre></pre>
        w.add("</div>");
    }
}
