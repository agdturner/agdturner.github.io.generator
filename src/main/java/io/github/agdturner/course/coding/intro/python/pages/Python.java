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
        w.addPST(sb, index.getReference("Python"));
        sb.append(
                """
                 is a popular and powerful high-level "programming language" \
                supported and developed by the
                """);
        sb.append(references.getReference("Python Software Foundation"));
        w.addPET(sb,
                """
                 (PSF) - an organisation with a mission to promote, protect, \
                and advance the language, and support and facilitate the \
                growth of a diverse and international community of Python \
                programmers.
                """);
        w.addP(sb, 
                """
                Python 1.0 was released in January 1994. The first version of \
                Python 2 (Python 2.0) was released in October 2000. The first \
                version of Python 3 (Python 3.0) was released in December \
                2008. PSF support for Python 2 ended in 2020 with Python 2.7. \
                By that time Python 3.8 had been released.
                """);
        w.addP(sb, 
                """
                This course focuses on supported versions of Python 3, and \
                does not detail differences between Python 2 and Python 3.
                """);
        w.addDIVET(sb);

        sid = addSection("Python 3", sb);
        w.addPST(sb, "The ");
        sb.append(references.getReference("Python 3 Documentation: Library",
                "Python 3 Library"));
        sb.append(" and various Python ");
        sb.append(index.getReference("source Code"));
        sb.append(
                """
                 interpreters are freely available for all major platforms \
                from the
                """);
        sb.append(references.getReference("Python Website"));
        w.addPET(sb,
                """
                , and these may be freely distributed. Python interpreters \
                translate "source code" written in Python to "machine code". \
                There are a variety of different Python interpreters. \
                "CPython" is the reference implementation of Python. CPython \
                can be defined as both an interpreter and a compiler as it \
                compiles Python code into "bytecode" before interpreting it.
                """);
//        sb.append("""
//                  The need for interpretation is what classifies Python as a \
//                  high-level language.
//                  """);

        w.addPST(sb, "The ");
        sb.append(references.getReference("Python Website"));
        w.addPET(sb,
                """
                 contains distributions of and pointers to many third party \
                Python libraries, tools, and additional documentation.
                """);
        
        w.addPST(sb,
                "A particularly useful page for beginners is the ");
        sb.append(references.getReference("Python 3 Documentation"));
        w.addPET(sb, ".");
        
        w.addPST(sb,
                """
                Python 3.10 was released in October 2021. \
                Python 3.11 was released in October 2022. \
                Python 3.12 was released in December 2023. \
                Python 3.13 is due for release in October 2024. \
                For each major incremental Python 3 release there is a \
                """);
        sb.append(references.getReference("Python 3 Documentation: What's New"));
        w.addPET(sb, " that introduces what's new:");
        
        w.addULST(sb);
        for (int i = 0; i < 13; i++) {
            w.addLI(sb, Web_ContentWriter.getLink(
                    "https://docs.python.org/3/whatsnew/3." + i + ".html",
                    "What's New In Python 3." + i));
        }
        w.addULET(sb);
        
        w.addPST(sb,
                """
                Changes are marked against numbered Python Enhancement \
                Proposals (PEPs). There is a \
                """);
        sb.append(references.getReference("Python Enhancement Proposal Website"));
        w.addPET(sb,
                """
                 which has existed since July 2000. PEPs are design documents \
                providing information to the Python community, or describing a \
                new feature for Python or its processes or environment. A PEP \
                should provide a concise technical specification of the \
                feature and a rationale for the feature. PEPs allow the \
                community of Python users to plan ahead and get involved in \
                language development.
                """);
        
        w.addPST(sb, "Most changes in Python are ");
        sb.append(index.getReference("backward compatible", sid));
        sb.append(" but some are not. So, ");
        sb.append(index.getReference("regression testing", sid));
        w.addPET(sb, 
                """
                 tends to be important in developing scientific software in \
                Python.
                """);
        
        w.addPST(sb,
                """
                 There is a vast ecosystem of third party Python libraries. \
                Much of this is made available as packages via the \
                """);
        sb.append(index.getReference("PyPI", "Python Package Index"));
        w.addPET(sb, " (PyPI).");
        w.addP(sb,
                """
                 Below, in <A href="#9">Section 9</A>, there is an exercise \
                that involves installing Python packages from PyPI and that \
                links to details about how to package code and make it \
                available via PyPI. \
                """);
        w.addPST(sb, "The ");
        sb.append(references.getReference("Python 3 Documentation: Tutorial"));
        w.addPET(sb,
                """
                 is another useful learning resource for learning Python.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Running Python", sb);
        w.addPST(sb,
                """
                Python instructions also known as 'commands' or 'statements', \
                can be entered one at a time at a
                """);
        sb.append(index.getReference("Command Line Interface",
                "command-line interface", sid));
        w.addPET(sb, " or passed in a file.");
        w.addPST(sb,
                " Check if there is a version of Python already on your ");
        sb.append(index.getReference("PATH", sid));
        w.addPET(sb,
                """
                 by running a 'Terminal' or 'Command Window' and entering the \
                following at the prompt:
                """);
        w.addPRE(sb, "python --version");
        w.addP(sb,
                """
                If 'python' cannot be found, then it is most likely that \
                Python is not installed. If a version of Python is available, \
                then the version of it should be reported.""");
        w.addPST(sb, "");
        sb.append(index.getReference("Anaconda", sid));
        sb.append(" is a data science platform. It contains: ");
        sb.append(index.getReference("Conda", sid));
        w.addPET(sb,
                """
                 - an environment manager; a Python interpreter; some commonly \
                used third party Python packages; and, some useful additional \
                tools. It is available at the University of Leeds via \
                'AppsAnywhere' using machines on campus or the 'Academic' \
                <A href="https://wvd.leeds.ac.uk">University Windows Virtual \
                Desktop</A>.""");
        w.addP(sb,
                """
                 Anaconda can also be download and installed. If you choose to \
                do this, then it is recommended to select the default install \
                options to avoid interfering with any other version of Python \
                already installed. By default, Anaconda installs into the user \
                home directory.""");

        sid = addSubsection("Python REPL", sb);
        sid = addSubsubsection("Hello World", sb);
        w.addP(sb,
                """
                Open an 'Anaconda prompt'. On Windows the prompt should look \
                something like:
                """);
        w.addPRE(sb, "(base) C:\\>");
        w.addP(sb,
                """
                Here, 'base' is the activated Python environment and 'C:\\' is \
                the current drive and working directory. Enter:""");
        w.addPRE(sb, "python --version");
        w.addP(sb,
                """
                This should inform you about the version of Python that came \
                with Anaconda. Enter:""");
        w.addPRE(sb, "python");
        w.addP(sb,
                """
                You should arrive at the 'Python prompt' that looks something \
                like:""");
        w.addPRE(sb, ">>>");
        w.addPST(sb, "This is a Python ");
        sb.append(index.getReference("REPL", sid));
        w.addPET(sb, " environment. Enter:");
        w.addPRE(sb,
                """
                print("Hello World")
                """);
        w.addP(sb, "You should see the following output:");
        w.addPRE(sb, "Hello World");

        sid = addSubsubsection("Numerical calculations", sb);
        w.addP(sb,
                """
                The Python prompt can be used for some basic calculations. \
                Enter:
                """);
        w.addPRE(sb, "2 + 3");
        w.addP(sb,
                """
                You should see the result of adding the number 2 to the number \
                3:
                """);
        w.addPRE(sb, "5");
        w.addPST(sb,
                """
                The plus symbol '+' in this instance acts as an addition \
                operator. This is a '
                """);
        sb.append(index.getReference("Python Built-in Types",
                "Built-in Type", sid));
        w.addPET(sb,
                """
                ' operator that works with specific types of variables. \
                Multiplication can be done similarly using an asterix '*' \
                symbol; and division can be done using the forward slash \
                '/' symbol.""");
        w.addP(sb,
                """
                Dividing '3' by '2' in this way results not in an integer, but \
                in '1.5'. In some programming languages dividing by an integer \
                will result in an integer. Indeed this used to be the case in \
                an old version of Python!""");
        w.addPST(sb,
                "Trying to evaluate a division by zero results in a ");
        sb.append(index.getReference("Python ZeroDivisionError",
                "ZeroDivisionError", sid));
        w.addPET(sb, ".");
        w.addP(sb,
                """
                Try multiplying and dividing some numbers. Try dividing one by \
                zero:""");
        w.addPRE(sb, "1 / 0");
        w.addP(sb, "Which should result in:");
        w.addPRE(sb,
                """
                Traceback (most recent call last):
                    File "&lt;stdin>", line 1, in <module>
                  ZeroDivisionError: division by zero
                """);
        w.addPST(sb, "A ");
        sb.append(index.getReference("Python ZeroDivisionError",
                "ZeroDivisionError", sid));
        sb.append(" is an ");
        sb.append(index.getReference("Python Built-in Exceptions",
                "exception", sid));
        w.addPET(sb,
                """
                 that is 'raised' in such circumstances. It is good to get \
                familiar with error messages which are typically printed to \
                the console. A key part of learning to program is about \
                interpreting error messages and thinking about what to do to \
                avoid and handle errors/exceptions.""");
        w.addP(sb,
                """
                Try some more calculations. Calculate '2' to the power of '64':
                """);
        w.addPRE(sb, "2 ** 64");
        w.addP(sb, "The result is an integer with twenty digits. Try:");
        w.addPRE(sb, "2 ** 1000000");
        w.addP(sb,
                """
                The result is an integer with '301030' digits. It may take \
                noticeably longer to compute and display this number...""");
        w.addPST(sb,
                """
                One way to calculate how many digits there are is to pass the \
                result into the \
                """);
        sb.append(index.getReference("Python str", "str", sid));
        sb.append(" function and to pass the result of this into the ");
        sb.append(index.getReference("Python len", "len", sid));
        w.addPET(sb, " function as follows:");
        w.addPRE(sb, "len(str(2 ** 1000000))");
        w.addP(sb,
                "Note how things are passed into the two functions.");
        w.addP(sb,
                """
                Increasing the exponent power by a further multiple of ten \
                should give ten times more digits and take significantly \
                longer to compute and display. try it:""");
        w.addPRE(sb, "len(str(2 ** 10000000))");
        w.addP(sb,
                """
                While waiting for an answer, open another Anaconda prompt to \
                look at some small numbers close to zero. Enter:
                """);
        w.addPRE(sb,
                """
                1 / 10
                1 / 100
                1 / 1000
                1 / 10000
                1 / 100000
                """);
        w.addP(sb,
                """
                Notice how the format of the number printed out changes with \
                the last command. '1e-05 ' is '0.00001' in scientific notation \
                where the letter 'e' stands for 'multiply by 10 raised to \
                the power of'. Try:""");
        w.addPRE(sb, "1/(2**1074)");
        w.addP(sb, "This will probably result in:");
        w.addPRE(sb, "5e-324");
        w.addP(sb, "Try:");
        w.addPRE(sb, "1/(2**1075)");
        w.addP(sb, "Which will probably result in:");
        w.addPRE(sb, "0.0");
        w.addP(sb,
                """
                The result is rounded down to 0.0 as this is the nearest \
                'Float' type number value to the true value!""");

        sid = addSubsection("Loading Modules and Using Functions", sb);
        w.addPST(sb,
                """
                Some mathematical operators are built-in as delimiters. Others \
                can be found in the , but they are  '+' and '*' are shorthand \
                for functions that reside in the \
                """);
        sb.append(index.getReference("Python operator", "operator", sid));
        w.addPET(sb, " module.");
        w.addP(sb, "Enter:");
        w.addPRE(sb, "operator.add(2, 3)");
        w.addPST(sb, "This should raise a ");
        sb.append(index.getReference("Python NameError", "NameError", sid));
        w.addPET(sb, ":");
        w.addPRE(sb,
                """
                Traceback (most recent call last):
                    File "&lt;stdin>", line 1, in &lt;module>
                  NameError: name 'operator' is not defined
                """);
        w.addP(sb,
                """
                The NameError is raised as the operator module has not been \
                imported.
                """);
        w.addP(sb, "Enter:");
        w.addPRE(sb, "dir()");
        w.addPST(sb, "This runs (or calls) the function '");
        sb.append(index.getReference("Python dir", "dir", sid));
        w.addPET(sb,
                """
                '. Function calls are easy to spot as after the function name \
                there are start and end parentheses. In this function call the \
                function is passed no arguments - as there is nothing between \
                the start and end parentheses. The output is a list of names \
                in the current local scope:""");
        w.addPRE(sb,
                """
                ['__annotations__', '__builtins__', '__doc__', '__loader__', \
                '__name__', '__package__', '__spec__']""");
        w.addP(sb,
                """
                The list is alphabetically ordered. You can tell it is a list \
                as it starts with an open square bracket '[' and ends with \
                a closing square bracket ']', and each item is separated with \
                a comma ','.""");
        w.addP(sb,
                """
                To import and load the operator module and see that it is \
                loaded, enter:""");
        w.addPRE(sb,
                """
                import operator
                dir()
                """);
        w.addP(sb, "The operator module should now be in the list.");
        w.addP(sb, "Enter:");
        w.addPRE(sb, "operator.add(2, 3)");
        w.addP(sb,
                """
                Now, you should not get the NameError encountered before the \
                operator module was imported, but a result.""");
        w.addP(sb,
                """
                The dot '.' in this command effectively instructs the Python \
                interpreter to look in the thing on the left (of the dot) to \
                find the thing on the right (of the dot). So, the expression \
                looks inside the operator module for the function 'add', and \
                passes into it the two parameters in the given order. The \
                function returns the result of summing these two parameters as \
                they are numbers, and the result is displayed.""");
        w.addP(sb,
                "To list the identifiers in the operator module, enter:");
        w.addPRE(sb, "dir(operator)");
        w.addP(sb, "It is quite a long list!");
        w.addP(sb,
                """
                There are numerous functions that have a name starting and \
                ending with a double underscore '__'. These are not normally \
                called directly, but they can be.""");
        w.addP(sb, "Enter:");
        w.addPRE(sb, "operator.__add__(2, 3)");
        w.addP(sb,
                """
                Python does not exert access control on variables and \
                functions. A naming convention is used to indicate to users \
                whether a variable or function is meant to be accessed from \
                outside the module. Underscores '_' and double underscores \
                '__' at the start and/or end of identifiers have a special \
                meaning in Python. As a general rule, you should not modify \
                anything with these in their name directly.""");
        w.addP(sb,
                """
                Have a play and use some other functions from the operator \
                module.
                """);

        sid = addSubsection("The Help System", sb);
        sb.append(index.getReference("Python help", "", sid));
        w.addP(sb, "At the Python prompt, enter:");
        w.addPRE(sb, "help(operator.add)");
        w.addP(sb,
                """
                This prints out some information about how to use the
                <a href="https://docs.python.org/3/library/operator.html#operator.add">
                operator module function add</a>.
                """);
        w.addP(sb, "Enter the following to enter the help system:");
        w.addPRE(sb, "help()");
        w.addP(sb, "The prompt should change to look like:");
        w.addPRE(sb, "help> ");
        w.addP(sb, "Read what is printed:");
        w.addPRE(sb,
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
        w.addP(sb, "Enter:");
        w.addPRE(sb, "modules");
        w.addP(sb,
                """
                It may take a few minutes to report a set of warnings and a
                list of available modules:
                """);
        w.addPRE(sb,
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
        w.addP(sb,
                """
                Exactly how this list presents itself will depend on the system
                your are using. Enter:
                """);
        w.addPRE(sb, "operator");
        w.addP(sb,
                """
                This should display the start of the help documentation for the
                operator module:
                """);
        w.addPRE(sb,
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
        w.addP(sb,
                """
                Press the &lt;enter&gt; key to see the next line of the
                documentation. Press and hold the &lt;enter&gt; key and the
                documentation should stream to the screen. The &lt;space&gt;
                bar key streams the documentation a page at a time. The
                &lt;q&gt; key quits and should return you to the prompt.
                """);
        w.addP(sb, "Have a look at some documentation for other modules.");
        w.addP(sb,
                """
                To exit the help system and return you to the Python prompt,
                enter:
                """);
        w.addPRE(sb, "q");
        w.addPST(sb, "To read the help for the ");
        sb.append(index.getReference("Python builtins", "builtins", sid));
        sb.append(" module ");
        sb.append(index.getReference("Python print", "print", sid));
        w.addPET(sb, " function, enter:");
        w.addPRE(sb, "help(print)");
        w.addP(sb,
                """
                Before learning how to run a file of Python commands, let us
                consider some more basic Python syntax - rules about how it must
                be written.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Basic Python Syntax", sb);

        sid = addSubsection("Syntax Errors", sb);
        index.getReference("Syntax Error", "", sid);
        w.addPST(sb,
                """
                If a statement or expression is syntactically incorrect, and the
                Python interpreter attempts to interpret it, a
                """);
        sb.append(index.getReference("Python SyntaxError", "SyntaxError", sid));
        w.addPET(sb, " is raised.");
        w.addP(sb, "At the Python prompt enter:");
        w.addPRE(sb, "x=");
        w.addP(sb, "You should get the following:");
        w.addPRE(sb,
                """
                File "&lt;stdin>", line 1
                    x =
                       ^
                SyntaxError: invalid syntax
                """);
        w.addP(sb,
                """
                Essentially, the problem with this code is that the expression
                is incomplete: There should be something on the right of the
                equals sign '='.
                """);

        sid = addSubsection("Statements", sb);
        w.addP(sb,
                """
                In Python, multiple statements on a single line are separated
                with semicolons ';'. At the Python prompt enter:
                """);
        w.addPRE(sb, "y=1;x=y;print(x)");
        w.addP(sb, "The output should be:");
        w.addPRE(sb, "1");
        w.addP(sb,
                """
                The code could be spaced out more and each statement could
                be on a separate line without the need for any semicolons:
                """);
        w.addPRE(sb,
                """
                y = 1
                x = y
                print(x)
                """);
        w.addP(sb,
                """
                Individual Python statements might include multiple expressions
                and can be formulated over several lines. We will consider some
                examples of these compound statements shortly...
                """);
        w.addP(sb,
                """
                Python does not have a special symbol to end a statement like
                many other languages do.
                """);

        sid = addSubsection("Comments", sb);
        w.addP(sb,
                """
                The symbol '#' is the start of a comment. Consider the
                following code:
                """);
        w.addPRE(sb,
                """
                # This entire line is a comment
                x = 0 # This part of the line is a comment
                print(x) # Print out the value of x
                # Comments should be informative.
                # x = 1 # Commented code is not run.
                """);
        w.addP(sb,
                """
                Between pairs of matching triple quotes everything is a comment.
                There are two types of triple quote, those using single
                quotation marks, and those using double quotation marks.
                """);
        w.addPST(sb, "Triple double quotes are used for ");
        sb.append(index.getReference("Python docstring", "docstrings", sid));
        w.addP(sb,
                """
                 - a form of documentation that will be detailed later in the
                course.
                """);
        w.addPST(sb,
                """
                Triple single quotes can be useful for commenting out sections
                of code when
                """);
        sb.append(index.getReference("Debugging", "debugging", sid));
        w.addPET(sb, ". Consider the following code:");
        w.addPRE(sb,
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
        w.addP(sb,
                """
                Comments can be used to help make code easier to understand and
                outline thinking behind some implementation or future
                improvements that might be made. It can be helpful to refer to
                other information sources in comments. It is sensible to add a
                comment to explain why code any code is commented out.
                """);

        sid = addSubsection("Code Layout", sb);
        w.addP(sb,
                """
                Blank lines are allowed and can help structure code into
                blocks. It is good practice to start each code block with a
                comment that outlines what the code block is for. For example:
                """);
        w.addPRE(sb,
                """
                # Initialise x and y"
                x = 2
                y = 4
                print(x)
                print(y)

                # Calculate and print x to the power of y
                x ** y
                """);
        w.addP(sb,
                """
                Indentation is syntax in Python. Indentation refers to the space
                that precedes expressions on a line and is sometimes called
                'blank space' or 'white space'. Care is needed with indentation
                in Python. In particular 'spaces' and 'tabs' can make
                indentation appear the same when it isn't. It is recommended not
                to use tabs for indentation and to use multiple spaces instead.
                """);
        w.addPST(sb,
                "The following is a Python code block with an example ");
        sb.append(index.getReference("Python if", "if statement", sid));
        w.addPET(sb, ":");
        w.addPRE(sb,
                """
                # if x is greater than y, then print a
                if x > y: # This line has the same indent as the comment above.
                    print(x) # This line is indented one standard step further.
                print(\"done\") # This line is indented to the previous level.
                """);
        w.addPST(sb,
                """
                In the code above, if the variable 'x' is greater than the
                variable 'y', then the value of 'x' is printed. If either of the
                variables 'x' or 'y' has not been initialised, then a
                """);
        sb.append(index.getReference("Python NameError", "NameError"));
        w.addPET(sb, " will be raised.");

        sid = addSubsection("Delimiters, Literals and Operators", sb);
        w.addPST(sb,
                """
                Delimiters in code separate and help organise things. The
                following are
                """);
        sb.append(index.getReference("Python delimiters", sid));
        w.addPET(sb, ":");
        w.addPRE(sb,
                """
                (       )       [       ]       {       }      :
                .       ;       @       =       ->      +=     -=
                *=      /=      //=     %=      @=      &=     |=
                ^=      >>=     <<=     **=
                """);
        w.addP(sb,
                """
                The various types of bracket are paired - each open bracket
                must be paired with a closing bracket: parentheses '()'; square
                brackets '[]'; and, curly brackets '{}' also known as braces.
                """);
        w.addP(sb,
                """
                A lot of code uses brackets. Failure to pair brackets correctly
                is a common reason for confusion.
                """);
        w.addP(sb,
                """
                Commas ',', colons ':', and dots '.' are commonly used
                delimeters in Python. Details of other delimiters are omitted
                for the time being. Some are really better thought of as
                operators rather than delimiters.
                """);
        w.addPST(sb,
                "Operators are sequences of symbols that are shorthand for ");
        sb.append(index.getReference("Python operator", "operator", sid));
        w.addPET(sb, " module functions (e.g. +, -, *, /, %)");
        w.addP(sb, "Literals are specific numerical or text values.");

        sid = addSubsection("Identifiers and Keywords", sb);
        w.addP(sb,
                """
                Identifiers are names of variables, functions, classes, modules
                and packages.
                """);
        w.addPST(sb, "A Python ");
        sb.append(index.getReference("Python keyword", "keyword", sid));
        w.addPET(sb,
                """
                 is a reserved word - a term that can't be used for an
                identifier.
                """);
        index.getReference("Syntax Error", "", sid);
        w.addPST(sb, "Attempting to ");
        sb.append(index.getReference("Name Binding", "use", sid));
        sb.append(
                """
                 a keyword as an identifier such as a variable name typically
                results in a
                """);
        sb.append(index.getReference("Python SyntaxError", "SyntaxError", sid));
        w.addPET(sb, ". Enter the following at the Python prompt:");
        w.addPRE(sb, "if = 2");
        w.addP(sb, "This should result in:");
        w.addPRE(sb,
                """
                File "@lt;stdin>", line 1
                    if = 2
                       ^
                SyntaxError: invalid syntax
                """);
        w.addPST(sb,
                """
                The Python interpreter is expecting a conditional expression
                after the keyword 'if'. Recall that
                """);
        sb.append(index.getReference("Python keyword", "keywords", sid));
        w.addPET(sb, " cannot be used as identifiers.");
        w.addPST(sb, "For details, see the ");
        sb.append(references.getReference(
                "Python Lexical Analysis Documentation"));
        w.addPET(sb, ".");

        sid = addSubsection("Style", sb);
        w.addPST(sb, "The following code block is a ");
        sb.append(index.getReference("Python if", sid));
        w.addPET(sb,
                """
                 statement which can be read as follows: If the variable 'x' is
                greater than the variable 'y', then 'x' is printed, otherwise y
                is printed.
                """);
        w.addPRE(sb,
                """
                x = 0
                y = 1
                # If x is greater than y, then print x, else print y.
                if x > y:
                    print("x", x)
                else:
                    print("y", y)
                """);
        w.addP(sb,
                """
                The function print is called with two arguments, and the code
                contains variables, comments, indentation, operators and
                keywords. Styling can be used added to make it easier to
                identify different parts, read and understand code. The
                following is the same code, but coloured to make different
                things in the code easier to identify:
                """);
        addCodeBlock(this.getCourse().courseType, sb,
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
        w.addP(sb,
                """
                The style does not change the meaning of the code, but it
                hopefully makes it easier to read and understand.
                """);
        w.addP(sb,
                """
                Further code blocks presented in these learning resources will
                be colourfully styled as above.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Running a file of Python commands", sb);
        w.addP(sb,
                "Create a new ASCII text file, add to it the following line:");
        w.addPRE(sb,
                """
                print("Hello World")
                """);
        w.addP(sb,
                """
                Save the file with the name "HelloWorld.py". Open an Anaconda
                prompt. Change to the directory where you saved the file
                (path_to_directory) using:
                """);
        w.addPRE(sb, "cd path_to_directory");
        w.addP(sb, "Run the file using:");
        w.addPRE(sb, "python HelloWorld.py");
        w.addP(sb, "You should see the following printed to the console:");
        w.addPRE(sb, "Hello World");
        w.addP(sb,
                """
                If your file is on a different drive in Windows, then you
                may have to switch to the drive before changing to the directory
                within the drive. To change from drive 'C:' to drive 'M:' in
                Windows, enter the following at the prompt:
                """);
        w.addPRE(sb, "M:");
        w.addP(sb,
                """
                To change back again to 'C:', enter the following at the prompt:
                """);
        w.addPRE(sb, "C:");
        w.addP(sb,
                """
                For code in files, the statements are executed from top to
                bottom, but the flow may call functions which may themselves
                call other functions. The interpreter returns to the line of
                code after a function call once the function has been executed.
                """);
        w.addP(sb,
                """
                It is not necessary to run files of Python code from the
                directory in which the file is located. A path to the file can
                be given in the Python command. That path can be absolute (from
                the base of the file system) or relative (from the current
                directory.
                """);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Jupyter Notebook", sb);
        w.addPST(sb, "");
        sb.append(index.getReference("Jupyter Notebook"));
        sb.append(", is a ");
        sb.append(index.getReference("REPL", sid));
        w.addPET(sb,
                """
                 like system that embeds code into a document containing other
                information: text, images, data, and links. Code is entered in
                cells which when run present outputs within the document which
                is displayed in a Web browser (unless ouputs are configured to
                appear in separate windows).
                """);
        w.addPST(sb,
                """
                Jupyter Notebook comes bundled with Anaconda and can be
                downloaded separately from:
                """);
        sb.append(references.getReference("Jupyter"));
        w.addPET(sb, ".");
        w.addP(sb,
                """
                At the Anaconda prompt change to a directory where you can write
                new files and enter:
                """);
        w.addPRE(sb, "jupyter notebook");
        w.addP(sb,
                """
                Some messages should appear in the console and a Web browser
                tab should in the default Web browser and display the Jupyter
                Notebook Interface.
                """);
        w.addP(sb,
                """
                From the New Button drop down list of the Jupyter Notebook
                Interface, select:
                """);
        w.addPRE(sb, "Python 3 (ipykernel)");
        w.addP(sb,
                """
                The New Button is highlighted with a red oval in the following
                image of the interface:
                <br /><img src="../../resources/python/jupyter1.png"
                alt="Jupyter Notebook Interface 1" />
                """);
        w.addP(sb,
                """
                A Python REPL environment should appear in another browser tab
                like shown in the following image:
                <br /><img src="../../resources/python/jupyter2.png"
                alt="Jupyter Notebook Interface 2" />
                """);
        w.addP(sb, "Enter the following in a cell and action run:");
        w.addPRE(sb,
                """
                print("Hello World")
                """);
        w.addP(sb,
                """
                You should see something like:
                <br /><img src="../../resources/python/jupyter3.png"
                alt="Jupyter Notebook Interface 3" />
                """);
        w.addPST(sb,
                "Entire programs can be entered into cells as can ");
        sb.append(index.getReference("Markdown", sid));
        w.addPET(sb, ".");
        w.addPST(sb,
                """
                Because a Jupyter Notebook application runs in a Web browser, it
                can utilise
                """);
        sb.append(index.getReference("JavaScript", sid));
        w.addPET(sb,
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
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Integrated Development Environments", sb);
        w.addPET(sb, "");
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
        w.addPET(sb, ".");

        sid = addSubsection("IDLE", sb);
        w.addPST(sb, "");
        sb.append(index.getReference("IDLE"));
        w.addPET(sb,
                """
                - an Integrated Development and Learning Environment for Python.
                The IDLE application has an 'editor window' for editing files of
                Python commands, and a 'console window' for entering REPL
                commands and displaying output. At the Anaconda prompt enter:
                """);
        w.addPRE(sb, "idle");
        w.addP(sb,
                """
                This should open up the IDLE console window that should look
                something like the image below:
                <br /><img src="../../resources/python/idle1.png"
                alt="The IDLE interface" />
                """);
        w.addPST(sb,
                "As well as the Python console prompt, there is a ");
        sb.append(index.getReference("GUI"));
        w.addPET(sb, " menu. Choose:");
        w.addPRE(sb, "File -> Open...");
        w.addP(sb,
                """
              Open your HelloWorld.py file. IDLE should open the file in the
              editor window that looks something like:
              <br /><img src="../../resources/python/idle2.png"
              alt="The IDLE file editor window interface" />
              """);
        w.addP(sb,
                """
              Notice that as with a Jupyter Notebook, the code appearing in
              the IDLE editor window is styled.
              """);
        w.addP(sb, "The editor window has other menu options. Select:");
        w.addPRE(sb, "Run -> Run Module");
        w.addP(sb,
                """
                This should run the HelloWorld.py file, and output to the
                console in the other window which should appear something like:
                <br /><img src="../../resources/python/idle3.png"
                alt="The IDLE interface having run the Hello World program" />
                """);
        w.addP(sb, "Close the instance of IDLE that is running.");

        sid = addSubsection("Spyder", sb);
        w.addPST(sb, "");
        sb.append(index.getReference("Spyder"));
        w.addPET(sb,
                """
                - the Scientific PYthon Development EnviRonment, is an IDE that
                comes with Anaconda.
                """);
        w.addP(sb, "From the Anaconda prompt enter:");
        w.addPRE(sb, "spyder");
        w.addP(sb,
                """
                It may take a couple of minutes to load, when you should see
                something like this:
                <br /><img src="../../resources/python/spyder1.png"
                alt="The Spyder interface" />
                """);
        w.addP(sb,
                """
                The pane to the left is the 'editor pane'. The pane to the top
                right is the 'inspector pane'. The pane to the bottom right is
                the 'console pane'.
                """);
        w.addP(sb, "From the menu, choose:");
        w.addPRE(sb, "File -> Open...");
        w.addP(sb,
                """
                Open your 'HelloWorld.py' file which should appear in the editor
                pane. From the menu, choose:
                """);
        w.addPRE(sb, "Run -> Run");
        w.addP(sb,
                """
                If a popup box appears choose the default and this should run
                your program and output should appear in the console like in the
                following image:
                <br /><img src="../../resources/python/spyder2.png"
                alt="The Spyder interface showing the Hello World program
                successfully ran" />
                """);
        w.addP(sb, "Use the editor and add the following in line 2:");
        w.addPRE(sb, "x = y");
        w.addPST(sb, "Try to run the file again. It should raise a ");
        sb.append(index.getReference("Python NameError", "NameError", sid));
        w.addPET(sb,
                """
                 and there should be marks against the code on line 2 on the left
                and right of the editor pane. Hover your mouse cursor over the
                mark on the left. You should see something similar to the image
                below:
                <br /><img src="../../resources/python/spyder3.png"
                alt="The Spyder interface showing an error." />
                """);
        w.addPST(sb, "Have a look at the latest ");
        sb.append(references.getReference("Spyder Documentation"));
        w.addPET(sb, ".");

        sid = addSubsection("Other IDEs", sb);
        w.addP(sb,
                """
                There are other IDEs that support Python code development. If \
                you are already familiar with an IDE that supports Python code \
                development, then you might like to give it a try. Other IDEs \
                that might be useful to you in future include: \
                <a href="https://www.jetbrains.com/pycharm/">PyCharm</a>\
                , and \
                <a href="https://www.pydev.org">PyDev</a>. \
                <!-- Eclipse, Netbeans and VS Code are other IDEs that may \
                support Python -->""");
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("QGIS Desktop Python Console", sb);
        w.addPST(sb, "");
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
        w.addPET(sb,
                """
                 and Python and there is are distinct client and server software.
                The operation of both these can be automated using Python.
                """);
        w.addPST(sb,
                """
                QGIS Server is geared for serving out data. QGIS Desktop is both
                client and server software. The client software can consume data
                that is served out and is a general desktop application for
                processing geographical data. QGIS Desktop is often controlled
                by users via a
                """);
        sb.append(index.getReference("GUI"));
        w.addPET(sb, " with a menu, panels and toolbars.");
        w.addP(sb,
                """
                Load QGIS Desktop via AppsAnywhere or download, install and run
                it on your own device.
                """);
        w.addP(sb,
                """
                As QGIS Desktop software loads, a splash screen should appear.
                When fully loaded the GUI should appear.
                """);
        w.addP(sb, "From the GUI Menu select:");
        w.addPRE(sb, "Plugins > Python Console");
        w.addP(sb,
                """
                You should see something like:
                <br /><img src="../../resources/python/qgis1.png"
                alt="QGIS Desktop Python Console basic interface" />
                """);
        w.addP(sb,
                "There are 5 buttons, a display area and a Python prompt:");
        w.addPRE(sb, ">>>");
        w.addP(sb, "At the Python prompt enter:");
        w.addPRE(sb, "dir()");
        w.addP(sb,
                """
                A considerable amount of functionality should be listed in the
                display area of the Python Console.
                """);
        w.addP(sb,
                """
                To list the functionality of the QGIS Desktop interface, enter:
                """);
        w.addPRE(sb, "dir(iface)");
        w.addPST(sb, "");
        sb.append(index.getReference("PyQGIS", sid));
        w.addPET(sb,
                """
                 provides programatic access to functionality that can also be
                accessed via the QGIS Desktop GUI. It gives greater control in
                data loading and processing and can be used to extend the
                available functionality.
                """);
        w.addP(sb,
                """
                In the QGIS Desktop Python console, locate and action the
                'Show Editor' button. The 'editor panel' should appear on the
                right of the console.
                """);
        w.addP(sb,
                """
                Download;
                <a href="../../resources/python/QGIS1.py">QGIS1.py</a>
                - a Python source code file written to be run in the QGIS
                Desktop Python console. Read the source code, and run the
                program following the instructions that are in the multi-line
                comment at the top of the source code. (An outline of what to
                expect is provided in that multi-line comment.)
                """);
        w.addP(sb,
                """
                The import statements are at the top of the Python source code
                (which is good practise). Code is organised into code blocks
                with comments that outline what each code block does (also good
                practise). In this program, the import statements start with the
                keyword 'from' which details from which package the specified
                modules are imported.
                """);
        index.getReference("For Loop", "", sid);
        w.addPST(sb, "The code contains some ");
        sb.append(index.getReference("Python for", sid));
        w.addPET(sb,
                """
                 statements which start with the keyword 'for'. The first of
                these iterates over the 'fields' in a 'layer'. The others
                iterate over the 'features' in a 'layer'. (Iteration simply
                means going through a sequence of things one at a time.
                """);
        w.addP(sb,
                """
                The program accesses both attribute and geometry data from a
                layer, and adds data into the QGIS Desktop GUI display.
                """);
        w.addP(sb,
                """
                Once the program has run the QGIS Desktop GUI should look
                something like:
                <br /><img src="../../resources/python/qgis2.png"
                alt="QGIS Python Console after having run QGISExample.py" />
                """);
        w.addP(sb,
                """
                QGIS Desktop Plugins can be written in both C++ and Python.
                This course does not explore this further. For details see the
                following:
                """);
        w.addULST(sb);
        w.addLI(sb,
                """
                <a href="https://www.qgis.org/en/site/getinvolved/development/development.html">
                QGIS Development Web Page</a>
                """);
        w.addLI(sb,
                """
                <a href="https://docs.qgis.org/testing/en/docs/pyqgis_developer_cookbook/plugins/index.html#developing-python-plugins">
                PyQGIS Development Cookbook: Plugins Web Page: Section on Developing Python Plugins</a>
                """);
        w.addULET(sb);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Python Packages and Environment Management", sb);
        w.addPST(sb,
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
        w.addPET(sb,
                """
                - a collection of tutorials and references to help you
                distribute and install Python packages with modern tools.
                """);
        w.addPST(sb, "");
        sb.append(index.getReference("PyPI", sid));
        sb.append(
                """
                 is a widely used Python repository. Developers deploy packages
                to PyPI and users install packages from there. Many packages are
                provided as
                """);
        sb.append(index.getReference("Free and Open Source Software"));
        w.addPET(sb,
                ". PyPI also supports hosting private proprietary packages.");
        w.addP(sb,
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
        w.addP(sb,
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
        w.addP(sb,
                """
                Learning about creating, activating, using, deactivating and
                deleting Python environments is important for orchestration and
                for other reasons. This is covered in this section...
                """);
        w.addP(sb,
                """
                It is easy to pollute Python environments by installing packages
                (and their dependencies) that turn out not to be useful and that
                then get in the way - using up resources and slowing things
                down. This is in part because uninstalling packages and removing
                all their dependencies is not currently easy with Python.
                """);
        w.addP(sb,
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
        w.addPST(sb, "");
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
        w.addPET(sb, ".");
        w.addPST(sb,
                """
                Conda is the recommended way of installing some Python packages.
                It is not necessarily that those packages cannot be configured
                and made to work using venv and pip, but that such configuration
                is currently more complicated. This is particularly true for
                some commonly used Python
                """);
        sb.append(index.getReference("GIS", sid));
        w.addPET(sb,
                """
                 packages, especially with installation on Microsoft Windows
                operating systems.
                """);
        w.addP(sb,
                """
                Open an Anaconda prompt, change to a directory where you can
                write files and enter the following command to create a list of
                Python packages available in the Python environment:
                """);
        w.addPRE(sb, "pip list > piplist.txt");
        w.addP(sb,
                """
                It may take a minute or so to run. It should output an
                ASCII text file containing a list of names with version numbers
                similar to:
                <a href="../../resources/python/piplist.txt">piplist.txt</a>.
                """);
        w.addP(sb,
                "Enter the following command to create a similar list:");
        w.addPRE(sb, "conda list > condalist.txt");
        w.addP(sb,
                """
                Again, it may take a minute or so to run. It should output an
                ASCII text file like similar to:
                <a href="../../resources/python/condalist.txt">condalist.txt</a>.
                """);
        w.addP(sb,
                """
                Enter the following command to create an explicit list of all
                the conda packages saved in a file named 'spec-file.txt':
                """);
        w.addPRE(sb, "conda list --explicit > spec-file.txt");
        w.addP(sb,
                """
                This file can be used to attempt to replicate the Python
                environment on another resource. For details of how
                to do that see:
                <a href="https://conda.io/projects/conda/en/latest/user-guide/tasks/manage-environments.html#sharing-an-environment">
                The Conda User Guide Page on Managing Environments Section on
                Sharing an Environment</a>
                """);
        w.addP(sb, "Get a list of available Conda environments. Enter:");
        w.addPRE(sb, "conda env list");
        w.addP(sb,
                "The list is displayed and should look something like:");
        w.addPRE(sb,
                """
                # conda environments:
                #
                base                  *  C:\\ProgramData\\Anaconda3
                """);
        w.addP(sb,
                """
                Often users create a Python environment for a specific purpose
                and only specific packages are installed for that. The
                following set of instructions install the default Python
                environment that comes with Anaconda, then install in this all
                the packages needed for to run the examples on this page.
                Altogether about 2GB of space is needed in the location where
                you create the environment.
                """);
        w.addP(sb,
                """
                It is not vital that you are able to run all the examples on
                this page. Most of the course uses only the Python standard
                library and a few other pakages that are installed as needed.
                """);
        String envPath = "M:\\python\\envs";
        w.addPST(sb,
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
                <br />
                """);
        w.addPET(sb, envPath);

        envPath = envPath + "\\myenv";
        w.addP(sb,
                """
                Create the environment giving it a name added to the end of the
                directory path as follows:
                """);
        w.addPRE(sb,
                """
                conda create -p " + envPath
                """);
        w.addP(sb,
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
        w.addPRE(sb, "conda env list");
        w.addP(sb, "You should see something like what is shown below:");
        w.addPREST(sb,
                """
                # conda environments:
                #
                base             *  C:\\ProgramData\\Anaconda3"
                """);
        w.addPREET(sb, "myenv               " + envPath);
        w.addP(sb,
                """
                Details may vary depending on where you created the environment
                and what you called it.
                """);
        w.addP(sb,
                """
                Conda environments are registered/listed in the '.conda'
                directory in the user home directory in a file with the name
                'environments.txt'.
                """);
        w.addP(sb,
                """
                Assuming you named your environment 'myenv', activate it by
                entering:
                """);
        w.addPRE(sb, "conda activate " + envPath);
        w.addP(sb,
                """
                The prompt should change to have "(myenv)" prepended instead of
                (base)
                """);
        w.addP(sb, "Next install the following Python packages:");
        w.addULST(sb);
        w.addLI(sb, """
                  <a href="https://contextily.readthedocs.io/en/latest/">
                  Contextily</a>
                  """);
        w.addLI(sb, """
                  <a href="https://github.com/Toblerity/Fiona">Fiona</a>
                  """);
        w.addLI(sb, """
                  <a href="https://python-visualization.github.io/folium/">Folium</a>
                  """);
        w.addLI(sb, """
                  <a href="https://geopandas.org/">Geopandas</a>
                  """);
        w.addLI(sb, """
                  <a href="https://readthedocs.org/projects/pip/">pip</a>
                  """);
        w.addLI(sb, """
                  <a href="https://pypi.org/project/ipykernel/">ipykernel</a>
                  """);
        w.addLI(sb, """
                  <a href="https://pypi.org/project/PyQt5">PyQt5</a>
                  """);
        w.addLI(sb, """
                  <a href="https://pypi.org/project/spyder-kernels/">spyder-kernels</a>
                  """);
        w.addULET(sb);
        w.addP(sb, "Enter:");
        w.addPRE(sb, "conda install -c conda-forge contextily fiona folium geopandas pip pysal ipykernel spyder spyder-kernels=2.2");
        w.addP(sb,
                """
                The installation may take some time... Once it is complete,
                install pyqt5 using pip by entering:
                """);
        w.addPRE(sb, "pip install pyqt5");
        w.addP(sb,
                """
                Next, install 'myenv' into the 'ipykernel' so it will be
                available via the Jupyter Notebook interface:
                """);
        w.addPRE(sb, "python -m ipykernel install --user --name=myenv");
        w.addP(sb,
                """
                Download;
                <a href="../../resources/python/Jupyter1.ipynb">
                Jupyter1.ipynb</a>, save it to a directory and start
                Jupyter Notebook so it can load the file.
                """);
        w.addP(sb, "Enter the following to run Jupyter Notebook:");
        w.addPRE(sb, "jupyter notebook --NotebookApp.max_buffer_size=1073741824");
        w.addP(sb,
                """
                This gives Jupyter Notebook twice as much memory as the current
                default (which helps prevent memory errors being encountered).
                """);
        w.addP(sb,
                """
                Wait for a Web browser tab to appear with the Jupyter Notebook
                interface. When it appears select:
                """);
        w.addPRE(sb, "New > myenv");
        w.addP(sb, "Open 'Jupyter1.ipynb' read and run it cell by cell.");
        w.addP(sb,
                """
                If for some reason that does not work, then try something
                simpler and copy the code below into a cell and run it.
                """);
        addCodeBlock(this.getCourse().courseType, sb,
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
        w.addP(sb,
                """
                This should produce a slippy map with an icon on it that looks
                something like:
                <br /><img src="../../resources/python/jupyter4.png"
                alt="Jupyter Notebook Interface 4" />
                """);
        w.addP(sb, "From the Jupyter Notebook interface choose:");
        w.addPRE(sb, "new > Python 3 (ipykernel)");
        w.addP(sb,
                """
                Try running the same code. Most likely, the folium package is
                not installed in your base environment and the following error
                is thrown:
                """);
        w.addPRE(sb,
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
        w.addP(sb,
                "Exit Jupyter Notebook and deactivate myenv by entering:");
        w.addPRE(sb, "deactivate myenv");
        w.addP(sb, "To remove the conda environment myenv use:");
        w.addPRE(sb, "conda remove --name myenv --all");
        w.addP(sb,
                """
                This ends the section on environment management and installing
                packages.
                """);
        w.addP(sb,
                """
                Below are key references for installing packages using pip and
                conda:
                """);
        w.addULST(sb);
        w.addLI(sb,
                """
                <a href="https://packaging.python.org/en/latest/tutorials/installing-packages/#use-pip-for-installing">
                https://packaging.python.org/en/latest/tutorials/installing-packages/#use-pip-for-installing
                </a>
                """);
        w.addLI(sb,
                """
                <a href="https://docs.anaconda.com/anaconda/user-guide/tasks/install-packages/">
                https://docs.anaconda.com/anaconda/user-guide/tasks/install-packages/</a>
                """);
        w.addULET(sb);
        w.addDIVET(sb);
        sb.append("\n");

        sid = addSection("Recap and Expectations", sb);
        w.addP(sb,
                """
                This section of the course introduced some basic Python syntax
                and considered the evolution of the language. It explored
                running Python code in a number of ways: using the REPL
                environment, running files of source code; using Jupyter
                Notebooks; the IDLE and Spyder IDEs; and the Python environment
                in QGIS.
                """);
        w.addP(sb,
                """
                Loading modules using import statements, and accessing
                functionality via a dot operator was introduced.
                """);
        w.addPST(sb, "Example ");
        sb.append(index.getReference("Python if", "if"));
        sb.append(" statements and ");
        sb.append(index.getReference("Python for", "for loops"));
        w.addPET(sb,
                """
                 were provided. These key things will be used many times, so do
                not worry if you have not fully understood these yet.
                """);
        w.addP(sb,
                """
                Versioning, packaging and managing Python/Conda environments
                have been introduced, as has installing Python packages in
                Python environments.
                """);
        w.addP(sb,
                """
                Some example code has been provided that automates some QGIS
                Desktop processing. The Jupyter Notebook based example utilised
                Javascript capabilities of the Web browser and leveraged some
                widely used Python GIS tools.
                """);
        w.addP(sb,
                """
                This has been a broad brush overview. You might benefit from
                revisiting parts of this learning once you are more familiar
                with developing Python code and as you think about undertaking
                projects.
                """);
        w.addDIVET(sb);
        sb.append("\n");
        return sb.toString();
    }

}
