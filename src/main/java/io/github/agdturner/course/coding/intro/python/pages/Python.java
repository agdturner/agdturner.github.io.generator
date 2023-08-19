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

import io.github.agdturner.course.coding.intro.python.PythonIntroCodingCourse;
import io.github.agdturner.core.SectionID;
import io.github.agdturner.core.Strings;
import io.github.agdturner.course.CoursePage;
import uk.ac.leeds.ccg.web.io.Web_ContentWriter;

/**
 * Python Intro Course Python Page.
 *
 * @author Andy Turner
 */
public class Python extends CoursePage {

    /**
     * Create a new instance.
     *
     * @param course What {@link #site} is set to.
     */
    public Python(PythonIntroCodingCourse course) {
        super(course, "python", "Python", "Python");
    }
    
    @Override
    public String getMainContent() {
        StringBuilder sb = new StringBuilder();
        SectionID sid = addSection("Introduction", sb);
        addParagraphStart(sb, "");
        sb.append(index.getReference("Python"));
        sb.append(
                """
                is a popular and powerful high-level programming language
                supported and developed by the
                """);
        sb.append(references.getReference("Python Software Foundation"));
        addParagraphEnd(sb,
                """
                - an organisation with a mission to promote, protect, and
                advance the language, and support and facilitate the growth of a
                diverse and international community of Python programmers.
                """);
        addParagraphStart(sb, "The ");
        sb.append(references.getReference("Python 3 Documentation: Library",
                        "Python 3 Library"));
        sb.append(" and various Python ");
        sb.append(index.getReference("Source Code", "source code"));
        sb.append(
                """
                interpreters are freely available in source and binary forms for
                all major platforms from the
                """);
        sb.append(references.getReference("Python Website"));
        addParagraphEnd(sb,
                """
                , and these may be freely distributed. Python interpreters
                translate Python source code into machine instructions that work
                at a much lower level. The need for interpretation is what
                classifies Python as a high-level language.
                """);
        addParagraphStart(sb, "The ");
        sb.append(references.getReference("Python Website"));
        addParagraphEnd(sb,
                """
                contains distributions of and pointers to many third party
                Python libraries, tools, and additional documentation.
                """);
        addParagraphStart(sb, 
                "A particularly useful page for beginners is the ");
        sb.append(references.getReference("Python 3 Documentation"));
        addParagraphEnd(sb, ".");

        sid = addSection("Python 3", sb);
        addParagraph(sb,
                """
                Python 3 was first released in 2008. For several years both
                Python 2 and Python 3 were developed and supported, but
                eventually in January 2020 development and maintenance of
                Python 2 ceased. We will not look at the differences between
                Python 2 and Python 3 in this course and will focus just on
                Python 3.
                """);
        addParagraphStart(sb,
                """
                Python 3.10 was released on the 4th of October 2021.
                Python 3.11 was released on the 24th of October 2022.
                Python 3.12 is due for release in October 2023.
                For each major incremental Python 3 release there is a
                """);
        sb.append(references.getReference("Python 3 Documentation: What's New"));
        addParagraphEnd(sb, "webpage that introduces what is new:");
        sb.append(Strings.UL_START);
        for (int i = 0; i < 12; i++) {
            addLI(sb, Web_ContentWriter.getLink(
                    "https://docs.python.org/3/whatsnew/3." + i + ".html",
                    "Whatsnew Python 3." + i));
        }
        sb.append(Strings.UL_END);
        addParagraphStart(sb, 
                """
                On those webpages, changes are marked against numbered Python
                Enhancement Proposals (PEPs). There is a
                """);
        sb.append(references.getReference("Python Enhancement Proposal Website"));
        addParagraphEnd(sb, 
                """
                which has existed since July 2000. PEPs are design documents
                providing information to the Python community, or describing a
                new feature for Python or its processes or environment. A PEP
                should provide a concise technical specification of the feature
                and a rationale for the feature. PEPs allow the community of
                Python users to plan ahead and  get involved in language
                development.
                """);
        addParagraphStart(sb, "Most changes in a major version of Python are ");
        sb.append(index.getReference("Backward Compatibility",
                        "backward compatible", sid));
        addParagraphEnd(sb, ", but some are not.");
        addParagraphStart(sb,
                """
                Usually, a new interpreter is needed to take advantage of new
                language features, whereas a newer interpreter will often
                produce the same results from code interpreted with an older
                interpreter. However, it is important to bear in mind that code
                run with one interpreter might behave differently or produce
                different results when run with another interpreter.
                """);
        sb.append(index.getReference("Regression testing", sid));
        sb.append(" which checks key results are ");
        sb.append(index.getReference("Reproducibility", "reproducibile", sid));
        addParagraphEnd(sb, " is often very important in research.");
        addParagraphStart(sb,
                """
                There is a vast ecosystem of third party Python libraries. Much
                of this is made available as packages via the
                """);
        sb.append(index.getReference("PyPI", "Python Package Index"));
        addParagraphEnd(sb, " (PyPI).");
        addParagraph(sb,
                """
                Below, in <a href="#9">Section 9</a>, there is an exercise that
                involves installing Python packages from PyPI and that links to
                details about how to package code and make it available via
                PyPI.
                """);
        addParagraphStart(sb, "The ");
        sb.append(references.getReference("Python 3 Documentation: Tutorial"));
        addParagraphEnd(sb,
                """
                is a recommended way to start learning Python. In your private
                study time, you might like to make your way through that series
                of tutorials which compliment these learning resources and go
                through some things in more depth.
                """);

        sid = addSection("Running Python", sb);
        addParagraphStart(sb,
                """
                Python instructions also known as 'commands' or 'statements',
                can be entered one at a time at a
                """);
        sb.append(index.getReference("Command Line Interface",
                        "command-line interface", sid));
        addParagraphEnd(sb, " or passed in a file.");
        addParagraphStart(sb,
                "Check if there is a version of Python already on your ");
        sb.append(index.getReference("PATH", sid));
        addParagraphEnd(sb,
                """
                 by running a 'Terminal' or 'Command Window' and entering the
                following at the prompt:
                """);
        addPre(sb, "python --version");
        addParagraph(sb, 
                """
                If 'python' cannot be found, then it is most likely that Python
                is not installed. If a version of Python is available, then the
                version of it should be reported.
                """);
        addParagraphStart(sb, "");
        sb.append(index.getReference("Anaconda", sid));
        sb.append(" is a data science platform. It contains: ");
        sb.append(index.getReference("Conda", sid));
        addParagraphEnd(sb,
                """
                 - an environment manager; a Python interpreter; some commonly
                used third party Python packages; and, some useful additional
                tools. It is available at the University of Leeds via
                'AppsAnywhere' using machines on campus or the 'Academic'
                <a href="https://wvd.leeds.ac.uk">University Windows Virtual
                Desktop</a>.
                """);
        addParagraph(sb,
                """
                Anaconda can also be download and installed. If you choose to do
                this, then it is recommended to select the default install
                options to avoid interfering with any other version of Python
                already installed. By default, Anaconda installs into the user
                home directory.
                """);

        sid = addSubsection("Python REPL", sb);
        sid = addSubsubsection("Hello World", sb);
        addParagraph(sb,
                """
                Open an 'Anaconda prompt'. On Windows the prompt should look
                something like:
                """);
        addPre(sb, "(base) C:\\>");
        addParagraph(sb,
                """
                Here, 'base' is the activated Python environment and 'C:\\' is
                the current drive and working directory. Enter:
                """);
        addPre(sb, "python --version");
        addParagraph(sb,
                """
                This should inform you about the version of Python that came
                with Anaconda. Enter:
                """);
        addPre(sb, "python");
        addParagraph(sb,
                """
                You should arrive at the 'Python prompt' that looks something
                like:
                """);
        addPre(sb,">>>");        
        addParagraphStart(sb, "This is a Python ");
        sb.append(index.getReference("REPL", sid));
        addParagraphEnd(sb, " environment. Enter:");
        addPre(sb, 
                """
                print("Hello World")
                """);
        addParagraph(sb, "You should see the following output:");
        addPre(sb, "Hello World");

        sid = addSubsubsection("Numerical calculations", sb);
        addParagraph(sb,
                """
                The Python prompt can be used for some basic calculations.
                Enter:
                """);
        addPre(sb, "2 + 3");
        addParagraph(sb,
                """
                You should see the result of adding the number 2 to the number
                3:
                """);
        addPre(sb, "5");
        addParagraphStart(sb,
                """
                The plus symbol '+' in this instance acts as an addition
                operator. This is a '
                """);
        sb.append(index.getReference("Python Built-in Types",
                        "Built-in Type", sid));
        addParagraphEnd(sb,
                """
                ' operator that works with specific types of variables.
                Multiplication can be done similarly using an asterix '*'
                symbol; and division can be done using the forward slash
                '/' symbol.
                """);
        addParagraph(sb,
                """
                Dividing '3' by '2' in this way results not in an integer, but
                in '1.5'. In some programming languages dividing by an integer
                will result in an integer. Indeed this used to be the case in an
                old version of Python!
                """);
        addParagraphStart(sb, 
                "Trying to evaluate a division by zero results in a ");
        sb.append(index.getReference("Python ZeroDivisionError",
                        "ZeroDivisionError", sid));
        addParagraphEnd(sb, ".");
        addParagraph(sb,
                """
                Try multiplying and dividing some numbers, and try the
                following division:
                """);
        addPre(sb,"1 / 0");
        addParagraph(sb, " Which should result in:");        
        addPre(sb,
                """
                Traceback (most recent call last):
                    File "&lt;stdin>", line 1, in <module>
                  ZeroDivisionError: division by zero
                """);
        addParagraphStart(sb, "A ");
        sb.append(index.getReference("Python ZeroDivisionError",
                        "ZeroDivisionError", sid));
        sb.append(" is an ");
        sb.append(index.getReference("Python Built-in Exceptions",
                        "exception", sid));
        addParagraphEnd(sb,
                """
                 that is 'raised' in particular circumstances. It is good to get
                familiar with reading details of these that are typically
                printed to the console as a key part of Python programming is
                about interpreting these.
                """);
        addParagraph(sb,
                """
                Try some more calculations. Calculates '2' to the power of '64':
                """);
        addPre(sb,"2 ** 64");
        addParagraph(sb, "The result is an integer with twenty digits. Try:");
        addPre(sb, "2 ** 1000000");
        addParagraph(sb,
                """
                The result is an integer with '301,030' digits. It may take
                noticeably longer to compute and display this number...
                """);
        addParagraphStart(sb,
                """
                One way to calculate how many digits there are is to pass the
                result into the
                """);
        sb.append(index.getReference("Python str", "str", sid));
        sb.append(" function and to pass the result of this into the ");
        sb.append(index.getReference("Python len", "len", sid));
        addParagraphEnd(sb, " function as follows:");
        addPre(sb, "len(str(2 ** 1000000))");
        addParagraph(sb, 
                "Notice how things are passed into the two functions.");
        addParagraph(sb, 
                """
                Increasing the power raised to by a further multiple of ten
                should give ten times more digits and might take over ten longer
                to compute. try it:
                """);
        addPre(sb, "len(str(2 ** 10000000))");
        addParagraph(sb, 
                """
                While waiting for an answer, open another Anaconda prompt to
                look at some small numbers close to zero. Enter:
                """);
        addPre(sb,
                """
                1 / 10
                1 / 100
                1 / 1000
                1 / 10000
                1 / 100000
                """);
        addParagraph(sb, 
                """
                Notice how the format of the number printed out changes with
                the last command. '1e-05 ' is '0.00001' in scientific notation
                where the letter 'e' stands for 'multiply by 10 raised to
                the power of'. Try:
                """);
        addPre(sb, "1/(2**1074)");
        addParagraph(sb, "Which should result in:");
        addPre(sb, "5e-324");
        addParagraph(sb, "Try:");
        addPre(sb, "1/(2**1075)");
        addParagraph(sb, "Which should result in:");
        addPre(sb, "0.0");
        addParagraph(sb,
                """
                The result is rounded down to 0.0 as this is the nearest Float
                value to the true value!
                """);

        sid = addSubsection("Loading Modules and Using Functions", sb);
        addParagraphStart(sb,
                """
                Some mathematical operators are built-in as delimiters. Others
                can be found in the , but they are  '+' and '*' are shorthand
                for functions that reside in the
                """);
        sb.append(index.getReference("Python operator", "operator", sid));
        addParagraphEnd(sb, " module.");
        addParagraph(sb, "Enter:");
        addPre(sb, "operator.add(2, 3)");
        addParagraphStart(sb, "This should raise a ");
        sb.append(index.getReference("Python NameError", "NameError", sid));
        addParagraphEnd(sb, " as follows:");
        addPre(sb, 
                """
                Traceback (most recent call last):
                    File "&lt;stdin>", line 1, in &lt;module>
                  NameError: name 'operator' is not defined
                """);
        addParagraph(sb,
                """
                The NameError is raised as the operator module has not been
                imported.
                """);
        addParagraph(sb, "Enter:");
        addPre(sb, "dir()");
        addParagraphStart(sb, "This runs (or calls) the function '");
        sb.append(index.getReference("Python dir", "dir", sid));
        addParagraphEnd(sb,
                """
                '. Function calls are easy to spot as after the function name
                there are start and end parentheses. In this function call the
                function is passed no arguments - as there is nothing between
                the start and end parentheses. The output is a list of names in
                the current local scope:
                """);
        addPre(sb, 
                """
                ['__annotations__', '__builtins__', '__doc__', '__loader__',
                '__name__', '__package__', '__spec__']
                """);
        addParagraph(sb,
                """
                The list is alphabetically ordered. You can tell it is a list
                as it starts with an open square bracket '[' and ends with
                a closing square bracket ']', and each item is separated with a
                comma ','.
                """);
        addParagraph(sb,
                """
                To import and load the operator module and see that it is
                loaded, enter:
                """);
        addPre(sb,
                """
                import operator
                dir()
                """);
        addParagraph(sb, "The operator module is now in the list.");
        addParagraph(sb, "Enter:");
        addPre(sb, "operator.add(2, 3)");
        addParagraph(sb,
                """
                Now, you should not get the NameError encountered before the
                operator module was imported, but a result.
                """);
        addParagraph(sb,
                """
                The dot '.' in this command effectively instructs the Python
                interpreter to look in the thing on the left (of the dot) to
                find the thing on the right (of the dot). So, the expression
                looks inside the operator module for the function 'add', and
                passes into it the two parameters in the given order. The
                function returns the result of summing these two parameters as
                they are numbers, and the result is displayed.
                """);
        addParagraph(sb, 
                "To list the identifiers in the operator module, enter:");
        addPre(sb, "dir(operator)");
        addParagraph(sb, "It is quite a long list!");
        addParagraph(sb,
                """
                There are numerous functions that have a name starting and
                ending with a double underscore '__'. These are not normally
                called directly, but they can be.
                """);
        addParagraph(sb, "Enter:");
        addPre(sb, "operator.__add__(2, 3)");
        addParagraph(sb, 
                """
                Python does not exert access control on variables and functions.
                A naming convention is used to indicate to users whether a
                variable or function is meant to be accessed from outside the
                module. Underscores '_' and double underscores '__' at the start
                and/or end of identifiers have a special meaning in Python. As a
                general rule, you should not modify anything with these in their
                name directly.
                """);
        addParagraph(sb, 
                """
                Have a play and use some other functions from the operator
                module.
                """);

        sid = addSubsection("The Help System", sb);
        sb.append(index.getReference("Python help", "", sid));
        addParagraph(sb, "At the Python prompt, enter:");
        addPre(sb, "help(operator.add)");
        addParagraph(sb, 
                """
                This prints out some information about how to use the
                <a href="https://docs.python.org/3/library/operator.html#operator.add">
                operator module function add</a>.
                """);
        addParagraph(sb, "Enter the following to enter the help system:");
        addPre(sb, "help()");
        addParagraph(sb, "The prompt should change to look like:");
        addPre(sb, "help> ");
        addParagraph(sb, "Read what is printed:");
        addPre(sb,
                """
                Welcome to Python 3.9's help utility!

                If this is your first time using Python, you should definitely check out
                the tutorial on the Internet at https://docs.python.org/3.9/tutorial/.

                Enter the name of any module, keyword, or topic to get help on writing
                Python programs and using Python modules.  To quit this help utility and
                return to the interpreter, just type "quit".

                To get a list of available modules, keywords, symbols, or topics, type
                "modules", "keywords", "symbols", or "topics".  Each module also comes
                with a one-line summary of what it does; to list the modules whose name
                or summary contain a given string such as "spam", type "modules spam".
                """);
        addParagraph(sb, "Enter:");
        addPre(sb, "modules");
        addParagraph(sb, 
                """
                It may take a few minutes to report a set of warnings and a
                list of available modules:
                """);
        addPre(sb, 
                """
                Cython              comtypes            mock                socks
                IPython             concurrent          modulefinder        sockshandler
                OpenSSL             conda               mpmath              sortedcollections
                PIL                 conda_build         msgpack             sortedcontainers
                PyQt5               conda_content_trust msilib              soupsieve
                TBB                 conda_env           msvcrt              sphinx
                __future__          conda_pack          multipledispatch    spyder
                _abc                conda_package_handling multiprocessing     spyder_kernels
                _aix_support        conda_token         munkres             sqlalchemy
                _argon2_cffi_bindings conda_verify        mypy_extensions     sqlite3
                _ast                configparser        nacl                sre_compile
                _asyncio            constantly          navigator_updater   sre_constants
                _bisect             contextlib          nbclassic           sre_parse
                _black_version      contextvars         nbclient            ssl
                _blake2             cookiecutter        nbconvert           sspi
                _bootlocale         copy                nbformat            sspicon
                _bootsubprocess     copyreg             nest_asyncio        stat
                _bz2                crypt               netbios             statistics
                _cffi_backend       cryptography        netrc               statsmodels
                _codecs             cssselect           networkx            storemagic
                _codecs_cn          csv                 nltk                string
                _codecs_hk          ctypes              nntplib             stringprep
                _codecs_iso2022     curl                nose                struct
                _codecs_jp          curses              notebook            subprocess
                _codecs_kr          cwp                 nt                  sunau
                _codecs_tw          cycler              ntpath              symbol
                _collections        cython              ntsecuritycon       sympy
                _collections_abc    cythonmagic         nturl2path          sympyprinting
                _compat_pickle      cytoolz             numba               symtable
                _compression        daal4py             numbergen           sys
                _contextvars        dask                numbers             sysconfig
                _csv                dataclasses         numexpr             tables
                _ctypes             datashader          numpy               tabnanny
                _ctypes_test        datashape           numpydoc            tabulate
                _datetime           datetime            odbc                tarfile
                _decimal            dateutil            olefile             tbb
                _distutils_hack     dbi                 onedal              tblib
                _elementtree        dbm                 opcode              telnetlib
                _functools          dde                 openpyxl            tempfile
                _hashlib            debugpy             operator            tenacity
                _heapq              decimal             optparse            terminado
                _imp                decorator           os                  test
                _io                 defusedxml          packaging           test_pycosat
                _json               diff_match_patch    pandas              testpath
                _locale             difflib             pandocfilters       tests
                _lsprof             dill                panel               text_unidecode
                _lzma               dis                 param               textdistance
                _markupbase         distributed         paramiko            textwrap
                _md5                distutils           parsel              this
                _msi                doctest             parser              threading
                _multibytecodec     docutils            parso               threadpoolctl
                _multiprocessing    email               partd               three_merge
                _nsis               encodings           past                tifffile
                _opcode             ensurepip           pathlib             time
                _operator           entrypoints         pathspec            timeit
                _osx_support        enum                patsy               timer
                _overlapped         erfa                pdb                 tinycss
                _peg_parser         errno               pep8                tkinter
                _pickle             et_xmlfile          perfmon             tldextract
                _plotly_future_     fastjsonschema      pexpect             tlz
                _plotly_utils       faulthandler        pickle              token
                _py_abc             filecmp             pickleshare         tokenize
                _pydecimal          fileinput           pickletools         toml
                _pyio               filelock            pip                 tomli
                _pyrsistent_version flake8              pipes               tomlkit
                _pytest             flask               pkg_resources       toolz
                _queue              fnmatch             pkginfo             tornado
                _random             fontTools           pkgutil             tqdm
                _sha1               formatter           platform            trace
                _sha256             fractions           platformdirs        traceback
                _sha3               fsspec              plistlib            tracemalloc
                _sha512             ftplib              plotly              traitlets
                _signal             functools           pluggy              tty
                _sitebuiltins       future              poplib              turtle
                _socket             gc                  posixpath           turtledemo
                _sqlite3            genericpath         poyo                twisted
                _sre                gensim              pprint              types
                _ssl                getopt              profile             typing
                _stat               getpass             prometheus_client   typing_extensions
                _statistics         gettext             prompt_toolkit      ujson
                _string             glob                protego             unicodedata
                _strptime           glob2               pstats              unidecode
                _struct             graphlib            psutil              unittest
                _symtable           greenlet            pty                 urllib
                _system_path        gzip                ptyprocess          urllib3
                _testbuffer         h5py                pvectorc            uu
                _testcapi           hamcrest            py                  uuid
                _testconsole        hashlib             py_compile          venv
                _testimportmultiple heapdict            pyasn1              w3lib
                _testinternalcapi   heapq               pyasn1_modules      warnings
                _testmultiphase     hmac                pyclbr              watchdog
                _thread             holoviews           pycodestyle         wave
                _threading_local    html                pycosat             wcwidth
                _tkinter            http                pycparser           weakref
                _tracemalloc        hvplot              pyct                webbrowser
                _uuid               hyperlink           pycurl              webencodings
                _warnings           idlelib             pydispatch          websocket
                _weakref            idna                pydoc               werkzeug
                _weakrefset         imagecodecs         pydoc_data          wheel
                _win32sysloader     imageio             pydocstyle          widgetsnbextension
                _winapi             imagesize           pyexpat             win2kras
                _winxptheme         imaplib             pyflakes            win32api
                _xxsubinterpreters  imghdr              pygments            win32clipboard
                _yaml               imp                 pylab               win32com
                _zoneinfo           importlib           pylint              win32con
                abc                 importlib_metadata  pyls_spyder         win32console
                adodbapi            incremental         pylsp               win32cred
                afxres              inflection          pylsp_black         win32crypt
                aifc                iniconfig           pylsp_jsonrpc       win32cryptcon
                alabaster           inspect             pyodbc              win32ctypes
                anaconda_navigator  intake              pyparsing           win32event
                anaconda_project    intervaltree        pyrsistent          win32evtlog
                antigravity         io                  pytest              win32evtlogutil
                anyio               ipaddress           pythoncom           win32file
                appdirs             ipykernel           pytz                win32gui
                argon2              ipykernel_launcher  pyviz_comms         win32gui_struct
                argparse            ipython_genutils    pywin               win32help
                array               ipywidgets          pywin32_bootstrap   win32inet
                arrow               isapi               pywin32_testutil    win32inetcon
                ast                 isort               pywintypes          win32job
                astroid             isympy              pywt                win32lz
                astropy             itemadapter         pyximport           win32net
                asynchat            itemloaders         qdarkstyle          win32netcon
                asyncio             itertools           qstylizer           win32pdh
                asyncore            itsdangerous        qtawesome           win32pdhquery
                atexit              jdcal               qtconsole           win32pdhutil
                atomicwrites        jedi                qtpy                win32pipe
                attr                jellyfish           queue               win32print
                attrs               jinja2              queuelib            win32process
                audioop             jinja2_time         quopri              win32profile
                automat             jmespath            random              win32ras
                autopep8            joblib              rasutil             win32rcparser
                autoreload          json                re                  win32security
                babel               json5               regcheck            win32service
                backcall            jsonschema          regex               win32serviceutil
                backports           jupyter             regutil             win32timezone
                base64              jupyter_client      repo_cli            win32trace
                bcrypt              jupyter_console     reprlib             win32traceutil
                bdb                 jupyter_core        requests            win32transaction
                binaryornot         jupyter_server      requests_file       win32ts
                binascii            jupyterlab          rlcompleter         win32ui
                binhex              jupyterlab_plotly   rmagic              win32uiole
                binstar_client      jupyterlab_pygments rope                win32verstamp
                bisect              jupyterlab_server   rtree               win32wnet
                bitarray            jupyterlab_widgets  ruamel_yaml         win_inet_pton
                bkcharts            jwt                 run                 win_unicode_console
                black               keyring             runpy               wincertstore
                blackd              keyword             s3transfer          winerror
                bleach              kiwisolver          sched               winioctlcon
                blib2to3            lazy_object_proxy   scipy               winnt
                bokeh               lib2to3             scrapy              winperf
                boto3               libarchive          seaborn             winpty
                botocore            libfuturize         secrets             winreg
                bottleneck          libpasteurize       select              winsound
                brotli              lief                selectors           winxpgui
                bs4                 linecache           send2trash          winxptheme
                builtins            llvmlite            service_identity    wrapt
                bz2                 locale              servicemanager      wsgiref
                cProfile            locket              setuptools          xarray
                calendar            logging             shelve              xdrlib
                certifi             lxml                shlex               xlrd
                cffi                lz4                 shutil              xlsxwriter
                cgi                 lzma                signal              xlwings
                cgitb               mailbox             sip                 xml
                chardet             mailcap             sipconfig           xmlrpc
                charset_normalizer  markdown            sipdistutils        xxsubtype
                chunk               markupsafe          site                yaml
                click               marshal             six                 yapf
                cloudpickle         math                skimage             yapftests
                clyent              matplotlib          sklearn             zict
                cmath               matplotlib_inline   sklearnex           zipapp
                cmd                 mccabe              slugify             zipfile
                code                menuinst            smart_open          zipimport
                codecs              mimetypes           smtpd               zipp
                codeop              mistune             smtplib             zlib
                collections         mkl                 snappy              zmq
                colorama            mkl_fft             sndhdr              zoneinfo
                colorcet            mkl_random          sniffio             zope
                colorsys            mmap                snowballstemmer
                commctrl            mmapfile            socket
                compileall          mmsystem            socketserver

                Enter any module name to get more help.  Or, type "modules spam" to search
                for modules whose name or summary contain the string "spam".
                """);
        addParagraph(sb, 
                """
                Exactly how this list presents itself will depend on the system
                your are using. Enter:
                """);
        addPre(sb, "operator");
        addParagraph(sb, 
                """
                This should display the start of the help documentation for the
                operator module:
                """);
        addPre(sb, 
                """
                Help on module operator:

                NAME
                    operator - Operator interface.

                MODULE REFERENCE
                    https://docs.python.org/3.9/library/operator

                    The following documentation is automatically generated from the Python
                    source files.  It may be incomplete, incorrect or include features that
                    are considered implementation detail and may vary between Python
                    implementations.  When in doubt, consult the module reference at the
                    location listed above.

                DESCRIPTION
                    This module exports a set of functions implemented in C corresponding
                    to the intrinsic operators of Python.  For example, operator.add(x, y)
                    is equivalent to the expression x+y.  The function names are those
                    used for special methods; variants without leading and trailing
                    '__' are also provided for convenience.

                CLASSES
                    builtins.object
                        attrgetter
                        itemgetter
                        methodcaller

                    class attrgetter(builtins.object)
                     |  attrgetter(attr, ...) --> attrgetter object
                     |
                     |  Return a callable object that fetches the given attribute(s) from its operand.
                     |  After f = attrgetter('name'), the call f(r) returns r.name.
                     |  After g = attrgetter('name', 'date'), the call g(r) returns (r.name, r.date).
                -- More  --
                """);
        addParagraph(sb, 
                """
                Press the &lt;enter&gt; key to see the next line of the
                documentation. Press and hold the &lt;enter&gt; key and the
                documentation should stream to the screen. The &lt;space&gt;
                bar key streams the documentation a page at a time. The
                &lt;q&gt; key quits and should return you to the prompt.
                """);
        addParagraph(sb, "Have a look at some documentation for other modules.");
        addParagraph(sb, 
                """
                To exit the help system and return you to the Python prompt,
                enter:
                """);
        addPre(sb, "q");
        addParagraphStart(sb, "To read the help for the ");
        sb.append(index.getReference("Python builtins", "builtins", sid));
        sb.append(" module ");
        sb.append(index.getReference("Python print", "print", sid));
        addParagraphEnd(sb, " function, enter:");
        addPre(sb, "help(print)");
        addParagraph(sb,
                """
                Before learning how to run a file of Python commands, let us
                consider some more basic Python syntax - rules about how it must
                be written.
                """);

        sid = addSection("Basic Python Syntax", sb);

        sid = addSubsection("Syntax Errors", sb);
        index.getReference("Syntax Error", "", sid);
        addParagraphStart(sb,
                """
                If a statement or expression is syntactically incorrect, and the
                Python interpreter attempts to interpret it, a
                """);
        sb.append(index.getReference("Python SyntaxError", "SyntaxError", sid));
        addParagraphEnd(sb, " is raised.");
        addParagraph(sb, "At the Python prompt enter:");
        addPre(sb, "x=");
        addParagraph(sb, "You should get the following:");
        addPre(sb, 
                """
                File "&lt;stdin>", line 1
                    x =
                       ^
                SyntaxError: invalid syntax
                """);
        addParagraph(sb, 
                """
                Essentially, the problem with this code is that the expression
                is incomplete: There should be something on the right of the
                equals sign '='.
                """);
              
        sid = addSubsection("Statements", sb);
        addParagraph(sb, 
                """
                In Python, multiple statements on a single line are separated
                with semicolons ';'. At the Python prompt enter:
                """);
        addPre(sb, "y=1;x=y;print(x)");
        addParagraph(sb, "The output should be:");
        addPre(sb, "1");
        addParagraph(sb, 
                """
                The code could be spaced out more and each statement could
                be on a separate line without the need for any semicolons:
                """);
        addPre(sb, 
                """
                y = 1
                x = y
                print(x)
                """);
        addParagraph(sb, 
                """
                Individual Python statements might include multiple expressions
                and can be formulated over several lines. We will consider some
                examples of these compound statements shortly...
                """);
        addParagraph(sb, 
                """
                Python does not have a special symbol to end a statement like
                many other languages do.
                """);

        sid = addSubsection("Comments", sb);
        addParagraph(sb, 
                """
                The symbol '#' is the start of a comment. Consider the
                following code:
                """);
        addPre(sb, 
                """
                # This entire line is a comment
                x = 0 # This part of the line is a comment
                print(x) # Print out the value of x
                # Comments should be informative.
                # x = 1 # Commented code is not run.
                """);
        addParagraph(sb, 
                """
                Between pairs of matching triple quotes everything is a comment.
                There are two types of triple quote, those using single
                quotation marks, and those using double quotation marks.
                """);
        addParagraphStart(sb, "Triple double quotes are used for ");
        sb.append(index.getReference("Python docstring", "docstrings", sid));
        addParagraph(sb, 
                """
                 - a form of documentation that will be detailed later in the
                course.
                """);
        addParagraphStart(sb, 
                """
                Triple single quotes can be useful for commenting out sections
                of code when
                """);
        sb.append(index.getReference("Debugging", "debugging", sid));
        addParagraphEnd(sb, ". Consider the following code:");
        addPre(sb, 
                """
                '''
                This is between triple single quotes and is a comment
                '''

                \"\"\"
                This is between triple double quotes and is a comment.
                \"\"\"

                '''
                \"\"\"
                This is both between triple single and double quotes and is a comment.
                \"\"\"
                '''
                """);
        addParagraph(sb, 
                """
                Comments can be used to help make code easier to understand and
                outline thinking behind some implementation or future
                improvements that might be made. It can be helpful to refer to
                other information sources in comments. It is sensible to add a
                comment to explain why code any code is commented out.
                """);

        sid = addSubsection("Code Layout", sb);
        addParagraph(sb, 
                """
                Blank lines are allowed and can help structure code into
                blocks. It is good practice to start each code block with a
                comment that outlines what the code block is for. For example:
                """);
        addPre(sb, 
                """
                # Initialise x and y"
                x = 2
                y = 4
                print(x)
                print(y)

                # Calculate and print x to the power of y
                x ** y
                """);
        addParagraph(sb, 
                """
                Indentation is syntax in Python. Indentation refers to the space
                that precedes expressions on a line and is sometimes called
                'blank space' or 'white space'. Care is needed with indentation
                in Python. In particular 'spaces' and 'tabs' can make
                indentation appear the same when it isn't. It is recommended not
                to use tabs for indentation and to use multiple spaces instead.
                """);
        addParagraphStart(sb, 
                "The following is a Python code block with an example ");
        sb.append(index.getReference("Python if", "if statement", sid));
        addParagraphEnd(sb, ":");
        addPre(sb, 
                """
                # if x is greater than y, then print a
                if x > y: # This line has the same indent as the comment above.
                    print(x) # This line is indented one standard step further.
                print(\"done\") # This line is indented to the previous level.
                """);
        addParagraphStart(sb, 
                """
                In the code above, if the variable 'x' is greater than the
                variable 'y', then the value of 'x' is printed. If either of the
                variables 'x' or 'y' has not been initialised, then a
                """);
        sb.append(index.getReference("Python NameError", "NameError"));
        addParagraphEnd(sb, " will be raised.");

        sid = addSubsection("Delimiters, Literals and Operators", sb);
        addParagraphStart(sb, 
                """
                Delimiters in code separate and help organise things. The
                following are
                """);
        sb.append(index.getReference("Python delimiters", sid));
        addParagraphEnd(sb, ":");
        addPre(sb,
                """
                (       )       [       ]       {       }      :
                .       ;       @       =       ->      +=     -=
                *=      /=      //=     %=      @=      &=     |=
                ^=      >>=     <<=     **=
                """);
        addParagraph(sb, 
                """
                The various types of bracket are paired - each open bracket
                must be paired with a closing bracket: parentheses '()'; square
                brackets '[]'; and, curly brackets '{}' also known as braces.
                """);
        addParagraph(sb, 
                """
                A lot of code uses brackets. Failure to pair brackets correctly
                is a common reason for confusion.
                """);
        addParagraph(sb, 
                """
                Commas ',', colons ':', and dots '.' are commonly used
                delimeters in Python. Details of other delimiters are omitted
                for the time being. Some are really better thought of as
                operators rather than delimiters.
                """);
        addParagraphStart(sb,
                "Operators are sequences of symbols that are shorthand for ");
        sb.append(index.getReference("Python operator", "operator", sid));
        addParagraphEnd(sb, " module functions (e.g. +, -, *, /, %)");
        addParagraph(sb, "Literals are specific numerical or text values.");

        sid = addSubsection("Identifiers and Keywords", sb);
        addParagraph(sb, 
                """
                Identifiers are names of variables, functions, classes, modules
                and packages.
                """);
        addParagraphStart(sb, "A Python ");
        sb.append(index.getReference("Python keyword", "keyword", sid));
        addParagraphEnd(sb, 
                """
                 is a reserved word - a term that can't be used for an
                identifier.
                """);
        index.getReference("Syntax Error", "", sid);
        addParagraphStart(sb, "Attempting to ");
        sb.append(index.getReference("Name Binding", "use", sid));
        sb.append(
                """
                 a keyword as an identifier such as a variable name typically
                results in a
                """);
        sb.append(index.getReference("Python SyntaxError", "SyntaxError", sid));
        addParagraphEnd(sb, ". Enter the following at the Python prompt:");
        addPre(sb, "if = 2");
        addParagraph(sb, "This should result in:");
        addPre(sb, 
                """
                File "@lt;stdin>", line 1
                    if = 2
                       ^
                SyntaxError: invalid syntax
                """);
        addParagraphStart(sb, 
                """
                The Python interpreter is expecting a conditional expression
                after the keyword 'if'. Recall that
                """);
        sb.append(index.getReference("Python keyword", "keywords", sid));
        addParagraphEnd(sb, " cannot be used as identifiers.");
        addParagraphStart(sb, "For details, see the ");
        sb.append(references.getReference(
                        "Python Lexical Analysis Documentation"));
        addParagraphEnd(sb, ".");

        sid = addSubsection("Style", sb);
        addParagraphStart(sb, "The following code block is a ");
        sb.append(index.getReference("Python if", sid));
        addParagraphEnd(sb,
                """
                 statement which can be read as follows: If the variable 'x' is
                greater than the variable 'y', then 'x' is printed, otherwise y
                is printed.
                """);
        addPre(sb, 
                """
                x = 0
                y = 1
                # If x is greater than y, then print x, else print y.
                if x > y:
                    print("x", x)
                else:
                    print("y", y)
                """);
        addParagraph(sb, 
                """
                The function print is called with two arguments, and the code
                contains variables, comments, indentation, operators and
                keywords. Styling can be used added to make it easier to
                identify different parts, read and understand code. The
                following is the same code, but coloured to make different
                things in the code easier to identify:
                """);
        addPythonCodeBlock(sb, 
                """
                x = 0
                y = 1
                # if x is greater than y, then print x, else print y.
                if x > y:
                    print("x", x)
                else:
                    print("y", y)
                print("done")
                """);
        addParagraph(sb, 
                """
                The style does not change the meaning of the code, but it
                hopefully makes it easier to read and understand.
                """);
        addParagraph(sb, 
                """
                Further code blocks presented in these learning resources will
                be colourfully styled as above.
                """);
        
        sid = addSection("Running a file of Python commands", sb);
        addParagraph(sb, 
                "Create a new ASCII text file, add to it the following line:");
        addPre(sb, 
                """
                print("Hello World")
                """);
        addParagraph(sb, 
                """
                Save the file with the name "HelloWorld.py". Open an Anaconda
                prompt. Change to the directory where you saved the file
                (path_to_directory) using:
                """);
        addPre(sb, "cd path_to_directory");
        addParagraph(sb, "Run the file using:");
        addPre(sb, "python HelloWorld.py");
        addParagraph(sb, "You should see the following printed to the console:");
        addPre(sb, "Hello World");
        addParagraph(sb, 
                """
                If your file is on a different drive in Windows, then you
                may have to switch to the drive before changing to the directory
                within the drive. To change from drive 'C:' to drive 'M:' in
                Windows, enter the following at the prompt:
                """);
        addPre(sb, "M:");
        addParagraph(sb, 
                """
                To change back again to 'C:', enter the following at the prompt:
                """);
        addPre(sb, "C:");
        addParagraph(sb, 
                """
                For code in files, the statements are executed from top to
                bottom, but the flow may call functions which may themselves
                call other functions. The interpreter returns to the line of
                code after a function call once the function has been executed.
                """);
        addParagraph(sb, 
                """
                It is not necessary to run files of Python code from the
                directory in which the file is located. A path to the file can
                be given in the Python command. That path can be absolute (from
                the base of the file system) or relative (from the current
                directory.
                """);

        sid = addSection("Jupyter Notebook", sb);
        addParagraphStart(sb, "");
        sb.append(index.getReference("Jupyter Notebook"));
        sb.append(", is a ");
        sb.append(index.getReference("REPL", sid));
        addParagraphEnd(sb,
                """
                 like system that embeds code into a document containing other
                information: text, images, data, and links. Code is entered in
                cells which when run present outputs within the document which
                is displayed in a Web browser (unless ouputs are configured to
                appear in separate windows).
                """);
        addParagraphStart(sb,
                """
                Jupyter Notebook comes bundled with Anaconda and can be
                downloaded separately from:
                """);
        sb.append(references.getReference("Jupyter"));
        addParagraphEnd(sb, ".");
        addParagraph(sb,
                """
                At the Anaconda prompt change to a directory where you can write
                new files and enter:
                """);
        addPre(sb,"jupyter notebook");
        addParagraph(sb,
                """
                Some messages should appear in the console and a Web browser
                tab should in the default Web browser and display the Jupyter
                Notebook Interface.
                """);
        addParagraph(sb,
                """
                From the New Button drop down list of the Jupyter Notebook
                Interface, select:
                """);
        addPre(sb, "Python 3 (ipykernel)");
        addParagraph(sb,
                """
                The New Button is highlighted with a red oval in the following
                image of the interface:
                <br><img src="../../resources/python/jupyter1.png"
                alt="Jupyter Notebook Interface 1" />
                """);
        addParagraph(sb,
                """
                A Python REPL environment should appear in another browser tab
                like shown in the following image:
                <br><img src="../../resources/python/jupyter2.png"
                alt="Jupyter Notebook Interface 2" />
                """);
        addParagraph(sb, "Enter the following in a cell and action run:");
        addPre(sb, 
                """
                print("Hello World")
                """);
        addParagraph(sb, 
                """
                You should see something like:
                <br><img src="../../resources/python/jupyter3.png"
                alt="Jupyter Notebook Interface 3" />
                """);
        addParagraphStart(sb,
                "Entire programs can be entered into cells as can ");
        sb.append(index.getReference("Markdown", sid));
        addParagraphEnd(sb, ".");
        addParagraphStart(sb,
                """
                Because a Jupyter Notebook application runs in a Web browser, it
                can utilise
                """);
        sb.append(index.getReference("JavaScript", sid));
        addParagraphEnd(sb,
                """
                 - a programming language that all widely used modern Web
                browsers can run. Leveraging JavaScript and Python allows for
                the generation of some Web based interactive maps. In
                <a href=\"#9\">Section 9</a>, there is a practical exercise
                about this. Prior to attempting this, it is important to learn
                about setting up Python environments and installing Python
                packages. First though, let's explore running Python code in
                some other ways...
                """);

        sid = addSection("Integrated Development Environments", sb);
        addParagraphEnd(sb, "");
        sb.append(index.getReference("IDE",
                        "Integrated Development Environments", sid));
        sb.append(
                """
                 (IDEs) are software tools used to make writing code and
                developing software easier. This section introduces
                """);
        sb.append(references.getReference("IDLE"));
        sb.append(" and ");
        sb.append(references.getReference("Spyder"));
        sb.append(" - IDEs that come with ");
        sb.append(references.getReference("Anaconda"));
        addParagraphEnd(sb, ".");

        sid = addSubsection("IDLE", sb);
        addParagraphStart(sb, "");
        sb.append(index.getReference("IDLE"));
        addParagraphEnd(sb,
                """
                - an Integrated Development and Learning Environment for Python.
                The IDLE application has an 'editor window' for editing files of
                Python commands, and a 'console window' for entering REPL
                commands and displaying output. At the Anaconda prompt enter:
                """);
        addPre(sb, "idle");
        addParagraph(sb,
                """
                This should open up the IDLE console window that should look
                something like the image below:
                <br><img src="../../resources/python/idle1.png"
                alt="The IDLE interface" />
                """);
        addParagraphStart(sb, 
                "As well as the Python console prompt, there is a ");
        sb.append(index.getReference("GUI"));
        addParagraphEnd(sb, " menu. Choose:");
        addPre(sb, "File -> Open...");
        addParagraph(sb,
              """
              Open your HelloWorld.py file. IDLE should open the file in the
              editor window that looks something like:
              <br><img src="../../resources/python/idle2.png"
              alt="The IDLE file editor window interface" />
              """);
        addParagraph(sb,
              """
              Notice that as with a Jupyter Notebook, the code appearing in
              the IDLE editor window is styled.
              """);
        addParagraph(sb, "The editor window has other menu options. Select:");
        addPre(sb, "Run -> Run Module");
        addParagraph(sb,
                """
                This should run the HelloWorld.py file, and output to the
                console in the other window which should appear something like:
                <br><img src="../../resources/python/idle3.png"
                alt="The IDLE interface having run the Hello World program" />
                """);
        addParagraph(sb, "Close the instance of IDLE that is running.");

        sid = addSubsection("Spyder", sb);
        addParagraphStart(sb, "");
        sb.append(index.getReference("Spyder"));
        addParagraphEnd(sb,
                """
                - the Scientific PYthon Development EnviRonment, is an IDE that
                comes with Anaconda.
                """);
        addParagraph(sb, "From the Anaconda prompt enter:");
        addPre(sb, "spyder");
        addParagraph(sb,
                """
                It may take a couple of minutes to load, when you should see
                something like this:
                <br><img src="../../resources/python/spyder1.png"
                alt="The Spyder interface" />
                """);
        addParagraph(sb,
                """
                The pane to the left is the 'editor pane'. The pane to the top
                right is the 'inspector pane'. The pane to the bottom right is
                the 'console pane'.
                """);
        addParagraph(sb, "From the menu, choose:");
        addPre(sb, "File -> Open...");
        addParagraph(sb,
                """
                Open your 'HelloWorld.py' file which should appear in the editor
                pane. From the menu, choose:
                """);
        addPre(sb, "Run -> Run");
        addParagraph(sb,
                """
                If a popup box appears choose the default and this should run
                your program and output should appear in the console like in the
                following image:
                <br><img src="../../resources/python/spyder2.png"
                alt="The Spyder interface showing the Hello World program
                successfully ran" />
                """);
        addParagraph(sb, "Use the editor and add the following in line 2:");
        addPre(sb, "x = y");
        addParagraphStart(sb, "Try to run the file again. It should raise a ");
        sb.append(index.getReference("Python NameError", "NameError", sid));
        addParagraphEnd(sb,
                """
                 and there should be marks against the code on line 2 on the left
                and right of the editor pane. Hover your mouse cursor over the
                mark on the left. You should see something similar to the image
                below:
                <br><img src="../../resources/python/spyder3.png"
                alt="The Spyder interface showing an error." />
                """);
        addParagraphStart(sb, "Have a look at the latest ");
        sb.append(references.getReference("Spyder Documentation"));
        addParagraphEnd(sb, ".");

        sid = addSubsection("Other IDEs", sb);
        addParagraph(sb,
                """
                There are other IDEs that support Python code development. If
                you are already familiar with an IDE that supports Python code
                development, then you might like to give it a try. Other IDEs
                that might be useful to you in future include:
                <a href="https://www.jetbrains.com/pycharm/">PyCharm</a>
                , and
                <a href="https://www.pydev.org">PyDev</a>.
                <!--
                Eclipse
                VS Code
                -->
                """);

        sid = addSection("QGIS Desktop Python Console", sb);
        addParagraphStart(sb, "");
        sb.append(index.getReference("GIS", "Geographical Information System",
                sid));
        sb.append(
                """
                (GIS) software are used to create, manage, process, model,
                visualise and distribute geographical data and information.
                """);
        sb.append(references.getReference("QGIS"));
        sb.append(" is ");
        sb.append(index.getReference("Free and Open Source Software",
                        "free and open source"));
        sb.append(
                """
                GIS software. It has a thriving developer and user community and
                a Python
                """);
        sb.append(index.getReference("API"));
        sb.append(". QGIS is mostly written in mixture of ");
        sb.append(index.getReference("C++", sid));
        addParagraphEnd(sb,
                """
                 and Python and there is are distinct client and server software.
                The operation of both these can be automated using Python.
                """);
        addParagraphStart(sb,
                """
                QGIS Server is geared for serving out data. QGIS Desktop is both
                client and server software. The client software can consume data
                that is served out and is a general desktop application for
                processing geographical data. QGIS Desktop is often controlled
                by users via a
                """);
        sb.append(index.getReference("GUI"));
        addParagraphEnd(sb, " with a menu, panels and toolbars.");
        addParagraph(sb,
                """
                Load QGIS Desktop via AppsAnywhere or download, install and run
                it on your own device.
                """);
        addParagraph(sb,
                """
                As QGIS Desktop software loads, a splash screen should appear.
                When fully loaded the GUI should appear.
                """);
        addParagraph(sb, "From the GUI Menu select:");
        addPre(sb, "Plugins > Python Console");
        addParagraph(sb,
                """
                You should see something like:
                <br><img src="../../resources/python/qgis1.png"
                alt="QGIS Desktop Python Console basic interface" />
                """);
        addParagraph(sb,
                "There are 5 buttons, a display area and a Python prompt:");
        addPre(sb,">>>");
        addParagraph(sb, "At the Python prompt enter:");
        addPre(sb, "dir()");
        addParagraph(sb,
                """
                A considerable amount of functionality should be listed in the
                display area of the Python Console.
                """);
        addParagraph(sb,
                """
                To list the functionality of the QGIS Desktop interface, enter:
                """);
        addPre(sb,"dir(iface)");
        addParagraphStart(sb, "");
        sb.append(index.getReference("PyQGIS", sid));
        addParagraphEnd(sb, 
                """
                 provides programatic access to functionality that can also be
                accessed via the QGIS Desktop GUI. It gives greater control in
                data loading and processing and can be used to extend the
                available functionality.
                """);
        addParagraph(sb,
                """
                In the QGIS Desktop Python console, locate and action the
                'Show Editor' button. The 'editor panel' should appear on the
                right of the console.
                """);
        addParagraph(sb, 
                """
                Download;
                <a href="../../resources/python/QGIS1.py">QGIS1.py</a>
                - a Python source code file written to be run in the QGIS
                Desktop Python console. Read the source code, and run the
                program following the instructions that are in the multi-line
                comment at the top of the source code. (An outline of what to
                expect is provided in that multi-line comment.)
                """);
        addParagraph(sb, 
                """
                The import statements are at the top of the Python source code
                (which is good practise). Code is organised into code blocks
                with comments that outline what each code block does (also good
                practise). In this program, the import statements start with the
                keyword 'from' which details from which package the specified
                modules are imported.
                """);
        index.getReference("For Loop", "", sid);
        addParagraphStart(sb, "The code contains some ");
        sb.append(index.getReference("Python for", sid));
        addParagraphEnd(sb,
                """
                 statements which start with the keyword 'for'. The first of
                these iterates over the 'fields' in a 'layer'. The others
                iterate over the 'features' in a 'layer'. (Iteration simply
                means going through a sequence of things one at a time.
                """);
        addParagraph(sb, 
                """
                The program accesses both attribute and geometry data from a
                layer, and adds data into the QGIS Desktop GUI display.
                """);
        addParagraph(sb, 
                """
                Once the program has run the QGIS Desktop GUI should look
                something like:
                <br><img src="../../resources/python/qgis2.png"
                alt="QGIS Python Console after having run QGISExample.py" />
                """);
        addParagraph(sb, 
                """
                QGIS Desktop Plugins can be written in both C++ and Python.
                This course does not explore this further. For details see the
                following:
                """);
        sb.append(Strings.UL_START);
        addLI(sb,
                """
                <a href="https://www.qgis.org/en/site/getinvolved/development/development.html">
                QGIS Development Web Page</a>
                """);
        addLI(sb,
                """
                <a href="https://docs.qgis.org/testing/en/docs/pyqgis_developer_cookbook/plugins/index.html#developing-python-plugins">
                PyQGIS Development Cookbook: Plugins Web Page: Section on Developing Python Plugins</a>
                """);
        sb.append(Strings.UL_END);

        sid = addSection("Python Packages and Environment Management", sb);
        addParagraphStart(sb, 
                """
                Packaging code and delivering it to users via repositories is
                good practise for numerous reasons. Some software and code
                repositories are programming language specific or software
                specific (like QGIS Desktop Plugins), components within the
                repositories are packaged in standard ways, and there is some
                process of review and some policy about package availability and
                removal. For details on packaging Python code see the
                """);
        sb.append(references.getReference("Python Packaging User Guide"));
        addParagraphEnd(sb,
                """
                - a collection of tutorials and references to help you
                distribute and install Python packages with modern tools.
                """);
        addParagraphStart(sb, "");
        sb.append(index.getReference("PyPI", sid));
        sb.append(
                """
                 is a widely used Python repository. Developers deploy packages
                to PyPI and users install packages from there. Many packages are
                provided as
                """);
        sb.append(index.getReference("Free and Open Source Software"));
        addParagraphEnd(sb,
                ". PyPI also supports hosting private proprietary packages.");
        addParagraph(sb,
                """
                When installing a package in a Python environment, by default
                package dependencies are also installed at the same time. In
                Python terms, a dependency is a package, module or function that
                some other code needs in order to work. At the package level,
                for any package that is being installed, a dependency list can
                be generated which includes all the dependencies. Further lists
                can be generated that reveal what these dependencies also depend
                upon. A web of dependencies can emerge and the dependencies can
                be installed sequentially so as to only install those
                dependencies that depend on things that are already installed in
                the environment.
                """);
        addParagraph(sb,
                """
                A criticism levelled at Python is that it can be poor at
                dependency management compared with other programming languages.
                When code in two different packages depends on different
                versions of a common dependency, there is what is known as a
                dependency conflict in Python. Python is currently not able to
                have multiple versions of a dependency installed in a single
                environment. The work around for this in Python is called
                orchestration which involves organising multiple Python
                environments with the required versions installed and getting
                these to work together. Such orchestration is fiddly and is
                regarded as an advanced topic that is not covered in this
                course.
                """);
        addParagraph(sb,
                """
                Learning about creating, activating, using, deactivating and
                deleting Python environments is important for orchestration and
                for other reasons. This is covered in this section...
                """);
        addParagraph(sb,
                """
                It is easy to pollute Python environments by installing packages
                (and their dependencies) that turn out not to be useful and that
                then get in the way - using up resources and slowing things
                down. This is in part because uninstalling packages and removing
                all their dependencies is not currently easy with Python.
                """);
        addParagraph(sb,
                """
                The general advice when installing several packages is to
                install them all in one go. Some dependency conflict resolution
                is attempted by the installer when this is done. So, for
                example, if a dependency requires a version between 1.2 to 1.5
                of another package and another dependency requies a version from
                1.1 to 1.10, then version 1.5 would be installed as the latest
                version that works for all dependencies. If installations were
                done one at a time, it is likely that version 1.10 would end up
                being the version available and this might not work or might not
                work as expected.
                """);
        addParagraphStart(sb, "");
        sb.append(index.getReference("Conda", sid));
        sb.append(
                """
                 is a package and environment manager that comes with Anaconda.
                Another way to create and manage Python environments uses the
                Python standard library module
                """);
        sb.append(index.getReference("Python venv", "venv", sid));
        sb.append(" and the Python Package Installer ");
        sb.append(index.getReference("PIP", "pip", sid));
        addParagraphEnd(sb, ".");
        addParagraphStart(sb, 
                """
                Conda is the recommended way of installing some Python packages.
                It is not necessarily that those packages cannot be configured
                and made to work using venv and pip, but that such configuration
                is currently more complicated. This is particularly true for
                some commonly used Python
                """);
        sb.append(index.getReference("GIS", sid));
        addParagraphEnd(sb,
                """
                 packages, especially with installation on Microsoft Windows
                operating systems.
                """);
        addParagraph(sb, 
                """
                Open an Anaconda prompt, change to a directory where you can
                write files and enter the following command to create a list of
                Python packages available in the Python environment:
                """);
        addPre(sb, "pip list > piplist.txt");
        addParagraph(sb, 
                """
                It may take a minute or so to run. It should output an
                ASCII text file containing a list of names with version numbers
                similar to:
                <a href="../../resources/python/piplist.txt">piplist.txt</a>.
                """);
        addParagraph(sb,
                "Enter the following command to create a similar list:");
        addPre(sb,"conda list > condalist.txt");
        addParagraph(sb, 
                """
                Again, it may take a minute or so to run. It should output an
                ASCII text file like similar to:
                <a href="../../resources/python/condalist.txt">condalist.txt</a>.
                """);
        addParagraph(sb, 
                """
                Enter the following command to create an explicit list of all
                the conda packages saved in a file named 'spec-file.txt':
                """);
        addPre(sb, "conda list --explicit > spec-file.txt");
        addParagraph(sb, 
                """
                This file can be used to attempt to replicate the Python
                environment on another resource. For details of how
                to do that see:
                <a href="https://conda.io/projects/conda/en/latest/user-guide/tasks/manage-environments.html#sharing-an-environment">
                The Conda User Guide Page on Managing Environments Section on
                Sharing an Environment</a>
                """);
        addParagraph(sb, "Get a list of available Conda environments. Enter:");
        addPre(sb, "conda env list");
        addParagraph(sb, 
                "The list is displayed and should look something like:");
        addPre(sb, 
                """
                # conda environments:
                #
                base                  *  C:\\ProgramData\\Anaconda3
                """);
        addParagraph(sb, 
                """
                Often users create a Python environment for a specific purpose
                and only specific packages are installed for that. The
                following set of instructions install the default Python
                environment that comes with Anaconda, then install in this all
                the packages needed for to run the examples on this page.
                Altogether about 2GB of space is needed in the location where
                you create the environment.
                """);
        addParagraph(sb, 
                """
                It is not vital that you are able to run all the examples on
                this page. Most of the course uses only the Python standard
                library and a few other pakages that are installed as needed.
                """);
        String envPath = "M:\\" + getCourse().getCourseCode() + "\\envs";
        addParagraphStart(sb, 
                """
                Creating Python environments on Cloud storage such as on
                <a href="https://en.wikipedia.org/wiki/OneDrive">
                Microsoft OneDrive</a> or
                <a href="https://en.wikipedia.org/wiki/GoogleDrive">
                Google Drive</a>
                is currently not recommended. On University of Leeds campus
                computers or the 'Academic'
                <a href="https://wvd.leeds.ac.uk">
                University Windows Virtual Desktop</a>
                it is recommended to create the Python environment on the
                M:\\ drive, for example in the following location:
                <br>
                """);
        addParagraphEnd(sb, envPath);
        
        envPath = envPath + "\\myenv";
        addParagraph(sb, 
                """
                Create the environment giving it a name added to the end of the
                directory path as follows:
                """);
        addPre(sb, 
                """
                conda create -p " + envPath
                """);
        addParagraph(sb, 
                """
                The -p option is the option to use a path to get conda to
                install the environment in a particular location. The path
                example given here is for Windows if using Linux or MacOS, then
                the path will be different. By default conda creates
                environments in a directory called 'envs' located wherever
                Anaconda is installed. In this case the environment being
                created is called 'myenv'. Confirm the environment creation by
                pressing the &lt;y> key when prompted. Creating the environment
                should just take a few seconds. Once created, check it is
                listed:
                """);
        addPre(sb, "conda env list");
        addParagraph(sb, "You should see something like what is shown below:");
        addPreStart(sb,
                """
                # conda environments:
                #
                base             *  C:\\ProgramData\\Anaconda3"
                """);
        addPreEnd(sb, "myenv               " + envPath);
        addParagraph(sb, 
                """
                Details may vary depending on where you created the environment
                and what you called it.
                """);
        addParagraph(sb, 
                """
                Conda environments are registered/listed in the '.conda'
                directory in the user home directory in a file with the name
                'environments.txt'.
                """);
        addParagraph(sb, 
                """
                Assuming you named your environment 'myenv', activate it by
                entering:
                """);
        addPre(sb, "conda activate " + envPath);
        addParagraph(sb, 
                """
                The prompt should change to have "(myenv)" prepended instead of
                (base)
                """);
        addParagraph(sb, "Next install the following Python packages:");
        sb.append(Strings.UL_START);
        addLI(sb, """
                  <a href="https://contextily.readthedocs.io/en/latest/">
                  Contextily</a>
                  """);
        addLI(sb, """
                  <a href="https://github.com/Toblerity/Fiona">Fiona</a>
                  """);
        addLI(sb, """
                  <a href="https://python-visualization.github.io/folium/">Folium</a>
                  """);
        addLI(sb, """
                  <a href="https://geopandas.org/">Geopandas</a>
                  """);
        addLI(sb, """
                  <a href="https://readthedocs.org/projects/pip/">pip</a>
                  """);
        addLI(sb, """
                  <a href="https://pypi.org/project/ipykernel/">ipykernel</a>
                  """);
        addLI(sb, """
                  <a href="https://pypi.org/project/PyQt5">PyQt5</a>
                  """);
        addLI(sb, """
                  <a href="https://pypi.org/project/spyder-kernels/">spyder-kernels</a>
                  """);
        sb.append(Strings.UL_END);
        addParagraph(sb, "Enter:");
        addPre(sb, "conda install -c conda-forge contextily fiona folium geopandas pip pysal ipykernel spyder spyder-kernels=2.2");
        addParagraph(sb, 
                """
                The installation may take some time... Once it is complete,
                install pyqt5 using pip by entering:
                """);
        addPre(sb, "pip install pyqt5");
        addParagraph(sb, 
                """
                Next, install 'myenv' into the 'ipykernel' so it will be
                available via the Jupyter Notebook interface:
                """);
        addPre(sb, "python -m ipykernel install --user --name=myenv");
        addParagraph(sb, 
                """
                Download;
                <a href="../../resources/python/Jupyter1.ipynb">
                Jupyter1.ipynb</a>, save it to a directory and start
                Jupyter Notebook so it can load the file.
                """);
        addParagraph(sb, "Enter the following to run Jupyter Notebook:");
        addPre(sb, "jupyter notebook --NotebookApp.max_buffer_size=1073741824");
        addParagraph(sb, 
                """
                This gives Jupyter Notebook twice as much memory as the current
                default (which helps prevent memory errors being encountered).
                """);
        addParagraph(sb, 
                """
                Wait for a Web browser tab to appear with the Jupyter Notebook
                interface. When it appears select:
                """);
        addPre(sb, "New > myenv");
        addParagraph(sb, "Open 'Jupyter1.ipynb' read and run it cell by cell.");
        addParagraph(sb, 
                """
                If for some reason that does not work, then try something a bit
                simpler and copy the code below into a cell and run it.
                """);
        addPythonCodeBlock(sb, 
                """
                # Simple example code
                import folium

                map = folium.Map(
                    location=(53.804, -1.555),
                    zoom_start=16,
                    control_scale=True
                )

                ccg = folium.Marker(
                    location=(53.8041954,-1.5549235),
                    tooltip="Centre for Computational Geography",
                    icon=folium.Icon()
                )
                ccg.add_to(map)

                map
                """);
        addParagraph(sb, 
                """
                This should produce a slippy map with an icon on it that looks
                something like:
                <br><img src="../../resources/python/jupyter4.png"
                alt="Jupyter Notebook Interface 4" />
                """);
        addParagraph(sb, "From the Jupyter Notebook interface choose:");
        addPre(sb, "new > Python 3 (ipykernel)");
        addParagraph(sb, 
                """
                Try running the same code. Most likely, the folium package is
                not installed in your base environment and the following error
                is thrown:
                """);
        addPre(sb, 
                """
                ---------------------------------------------------------------------------
                ModuleNotFoundError                       Traceback (most recent call last)
                Input In [1], in <cell line: 1>()
                ----> 1 import folium
                      3 map = folium.Map(
                      4     location=(53.804, -1.555),
                      5     zoom_start=16,
                      6     control_scale=True
                      7 )
                      9 ccg = folium.Marker(
                     10     location=(53.8041954,-1.5549235),
                     11     tooltip="Centre for Computational Geography",
                     12     icon=folium.Icon()
                     13 )

                ModuleNotFoundError: No module named 'folium'
                """);
        addParagraph(sb, 
                "Exit Jupyter Notebook and deactivate myenv by entering:");
        addPre(sb, "deactivate myenv");
        addParagraph(sb, "To remove the conda environment myenv use:");
        addPre(sb, "conda remove --name myenv --all");
        addParagraph(sb, 
                """
                This ends the section on environment management and installing
                packages.
                """);
        addParagraph(sb, 
                """
                Below are key references for installing packages using pip and
                conda:
                """);
        sb.append(Strings.UL_START);
        addLI(sb, 
                """
                <a href="https://packaging.python.org/en/latest/tutorials/installing-packages/#use-pip-for-installing">
                https://packaging.python.org/en/latest/tutorials/installing-packages/#use-pip-for-installing
                </a>
                """);
        addLI(sb,
                """
                <a href="https://docs.anaconda.com/anaconda/user-guide/tasks/install-packages/">
                https://docs.anaconda.com/anaconda/user-guide/tasks/install-packages/</a>
                """);
        sb.append(Strings.UL_START);

        sid = addSection("Recap and Expectations", sb);
        addParagraph(sb,
                """
                This section of the course introduced some basic Python syntax
                and considered the evolution of the language. It explored
                running Python code in a number of ways: using the REPL
                environment, running files of source code; using Jupyter
                Notebooks; the IDLE and Spyder IDEs; and the Python environment
                in QGIS.
                """);
        addParagraph(sb,
                """
                Loading modules using import statements, and accessing
                functionality via a dot operator was introduced.
                """);
        addParagraphStart(sb, "Example ");
        sb.append(index.getReference("Python if", "if"));
        sb.append(" statements and ");
        sb.append(index.getReference("Python for", "for loops"));
        addParagraphEnd(sb,
                """
                were provided. These key things will be used many times, so do
                not worry if you have not fully understood these yet.
                """);
        addParagraph(sb,
                """
                Versioning, packaging and managing Python/Conda environments
                have been introduced, as has installing Python packages in
                Python environments.
                """);
        addParagraph(sb,
                """
                Some example code has been provided. This is quite good code in
                that there are plentiful comments, and the code also does some
                interesting things: The code that automated some QGIS Desktop
                processing demonstrates how to access functionality from within
                QGIS Desktop. The Jupyter Notebook based example utilised
                Javascript capabilities of the Web browser and leveraged some
                widely used Python GIS tools.
                """);
        addParagraph(sb,
                """
                This has been a broad brush overview. You might benefit from
                revisiting parts of this learning once you are a bit more
                familiar with developing Python code and as you think about
                undertaking projects.
                """);
        return sb.toString();
    }

}
