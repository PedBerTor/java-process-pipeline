# Java Process Pipeline

Java implementation of an operating system process pipeline

### Overview

This project provides a practical implementation of an operating system process pipeline using 
Java, designed to illustrate concepts such as inter-process communication and stream handling.

The project comprises three main components:
* **[Generator](src/Generator.java):** a utility for generating random text strings.
* **[Analyzer](src/Analyzer.java):** a utility for analyzing text input.
* **[Launcher](src/Launcher.java):** an orchestrator for the execution of the pipeline.

To get the pipeline launched using Java, `Launcher` starts a new `Generator` process and pipes 
its output directly to an `Analyzer` process, as described in the following diagram:

![Overview](/docs/overview.png)

Alternatively, the pipeline can be launched manually by connecting the output of `Generator` to 
the input of `Analyzer` using the pipe operator (|).

See [Usage](#Usage) for more information.

> **_NOTE:_** Due to its educational nature, this project is not intended to
> represent a production-ready solution. It is a demonstration of various design
> patterns, advanced features, and coding techniques. While the code may illustrate
> good programming practices, it may not adhere to all the best practices necessary
> for a real-world, production-grade application.

### Requirements

Java 11 or newer

### Usage

#### Launch the pipeline with Launcher

Compile `Generator`, `Analyzer` and `Launcher` classes:

```Shell
javac src/Generator.java
javac src/Analyzer.java
javac src/Launcher.java
```

Launch the pipeline running `Launcher`:

```Shell
java -cp src Launcher
```

#### Launch the pipeline manually

Compile `Generator` and `Analyzer` classes:

```Shell
javac src/Generator.java
javac src/Analyzer.java
```

Launch the pipeline using the pipe operator (|):

```Shell
java -cp src Generator 2 | java -cp src Analyzer
```

### License

This project is released under the [MIT License](LICENSE).

```
Copyright (c) 2024 Pedro Bernaldez

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
