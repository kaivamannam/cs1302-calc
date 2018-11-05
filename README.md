# CSCI 1302 - Calc App v2018.fa

![?](https://www.maa.org/sites/default/files/images/cms_upload/abacus250457.jpg)

**TUE 2018-11-27 (NOV 27) @ 11:55 PM EST**.

This document contains the description for the Calc App project
assigned to the students in the Fall 2018 CSCI 1302 classes
at the University of Georgia.

**Read the entirety of this file before beginning your project.**

**Seriously. Read this entire file *before* starting.**

## Table of Contents

* [Academic Honesty](#academic-honesty)
* [Updates](#updates)
* [Project Description](#project-description)
* [Project Requirements & Grading](#project-requirements--grading)
  * [Functional Requirements](#functional-requirements)
  * [Non-Functional Requirements](#non-functional-requirements)
* [How to Download the Project](#how-to-download-the-project)
* [Submission Instructions](#submission-instructions)
* [Appendix - FAQ](#appendix---faq)

## Academic Honesty

You agree to the Academic Honesty policy as outlined in the course syllabus. 
In accordance with this notice, I must caution you **not** to 
fork this repository on GitHub if you have an account. Doing so will more than
likely make your copy of the project publicly visible. Please follow the 
instructions contained in the 
[How to Download the Project](#how-to-download-the-project)
section below in order to do your development on nike. Furthermore, you must adhere
 to the copyright notice and licensing information at the bottom of this document.

## Updates

Updates will be posted here.
If there has been an update and you have already cloned the project to Nike, 
then you can update your copy of the project using the <code>$ git pull</code>
command while inside of your project directory.

## Project Description

In this project, you will develop a "programer's" calculator app in Java with 
a graphical user interface (GUI) powered by JavaFX. You will be responsible for 
designing and implementing the user interface for your project (following a few 
guidelines). 

### What is a "Programmer's" Calculator?

There are four (4) characteristics that differentiate this app from a standard
calculator.

1. **Unsigned Integer Operations:** While standard calculator's perform operations
   on real numbers, this "programmer's" calculator will be restricted to 
   operations on unsigned (i.e., non-negative) integers. This means that all
   inputs and outputs will be unsigned integers. This also means that operations
   (e.g., division) will be integer operations. Additionally, this calculator will 
   also support bit shifting operations.

2. **Expression Evaluation:** While standard calculator's can only perform
   one mathematical operation at a time, this "programmer's" calculator will
   allow users to build multi-operaton expressions in a text field, then click
   on an "Evaluate" button to have the calculator actually evaluate the
   expression. The code evaluate an overally expression is already provided to
   you, assuming you provide an implementation of an interface. See the
   [FAQ](#appendix---faq) for more details.
   
2. **Implementation Toggle:** This "programmer's" calculator will provide a toggle
   for three different underlying implementations of the `MathOps` interface, 
   one of which is provided with the skeleton project. The three implementations 
   are: basic, iterative, and recursive. This effectively provides three mutually 
   exclusive modes for the calculator. The current mode dictates which implementation 
   is passed to the code used for expression evaluation. See the
   [FAQ](#appendix---faq) for more details.

3. **Bit Toggle:** This "programmer's" calculator will display a sequence of
   clickable bits in standard order (i.e., most significant to least significant)
   that shows the current binary representation of the result. When the result
   changes, the visible binary should also change. Furthermore, the user should
   be able to toggle (i.e., click) each bit on or off. When this is done, the
   result should change accordingly. See the
   [FAQ](#appendix---faq) for more details.

### Suggested Reading

* LDC Ch. 9 (Polymorhism)
* [Java Tutorial: Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html)

### Learning Outcomes

* Implement generic classes according to an interface (1302-LO1).
* Utilitze inheritance and polymorphism in a software project (1302-LO3-LO4).
* Test your implementation using unit tests (1302-LO9).

## Project Requirements & Grading

This assignment is worth 100 points. The lowest possible grade is 0, and the 
highest possible grade is 105 (due to extra credit).

### Functional Requirements

A functional requirement is *added* to your point total if satisfied.
There will be no partial credit for any of the requirements that simply 
require the presence of a method related a particular functionality. 
The actual functionality is tested using test cases.

* **(20 points) User Interface**: Your application needs to have the
  following user interface components:
  
  * **(5 points) Menu Bar**: Your application should have a menu bar
    with a "File" menu. The only required menu item is an "Exit" item
    that allows the user to exit the application.

  * **(5 points) Expression & Result Text Fields**: Your application
    should have two textfields, one where the expression will be built
    as the user interacts with the buttons and one where the result is
    places when the user clicks on the "Evaluate" button..

  * **(5 points) Calculator Buttons**: Your application needs to have
    buttons for the numbers zero (0) through (9) as well as a button
    for each of the operations listed below. The name of each operation
    is provided as well as the symbol(s) used to denote that operation
    in an expression.:

    * Add (`+`)
    * Subtract (`-`)
    * Multiply (`*`)
    * Divide (`/`)
    * Exponentiation (`^^`)
    * Left Shift (`<<`)
    * Right Shift (`>>`)
    * Factorial (`!`)

    The last operation, factorial, is interesting in that it only
    takes a single operand; the rest take two.
    
  * **(5 points) Bit Toggle:** your application needs display a sequence of
   clickable bits in standard order (i.e., most significant to least significant)
   that shows the current binary representation of the result. When the result
   changes, the visible binary should also change. Furthermore, the user should
   be able to toggle (i.e., click) each bit on or off. When this is done, the
   result should change accordingly. See the
   [FAQ](#appendix---faq) for more details.
    
* **( points) Test Cases**: The bulk of this project will be graded
  based on 50 JUnit test cases, each worth 2 points. This is the same as
  someone using the classes you wrote based purely on the interface
  definitions. If you implement the interface correctly, then you should
  pass the associated test cases. 
  
  Some test cases are presented here with the skeleton project in
  [`/src/test/java`](/src/test/java). You can run the test cases
  with the following command:
  ```
  $ mvn test
  ```

### Non-Functional Requirements

A non-functional requirement is *subtracted* from your point total if
not satisfied. In order to emphasize the importance of these requirements,
non-compliance results in the full point amount being subtracted from your
point total. That is, they are all or nothing.  
  
* **(100 points) Project Structure:** The location of the default
  package for the source code should be a direct subdirectory called `src/main/java`.
  When the project is compiled using Maven, the the default package for compiled 
  code should be `target/classes`. 
  
  If you follow this structure, then you might type the following to compile 
  your code, assuming you are in the top-level project directory:
  ```
  $ mvn compile
  ```
  
  The driver class should be `cs1302.calc.CalcApp`.

* **(100 points) Development Environment:** This project must be implemented 
  in Java 8, and it *must compile and run* correctly on Nike using the specific
  version of Java 8 that is setup according to the instructions provided
  by your instructor (usually provided in the first homework assignment).
  
* **(100 points) No Static Variables:** Use of static variables is 
  not allowed for this assignment. Static constants are allowed. 
  
* **(100 points) No FXML or use of Scene Builder:** FXML and SceneBuilder
  are advanced tools that are not currently covered in this course. Use of
  either for this project is prohibited. Please note that the project is
  not easier with these tools. In most cases, they actually make the
  project harder, especially since those topics have not been covered.
  
* **(25 points) User-Friendly Experience:** Except for reasonable delays resulting from X forwarding, 
  your application should not hang/freeze or crash during execution.
  
* **(25 points) Code Style Guidelines:** You should be consistent with the style 
  aspect of your code in order to promote readability. Besides consistency, the
  following conventions will be enforced:
  
  * **Reference type names are written in _UpperCamelCase_.** Class names are  
    typically nouns or noun phrases. For example, `Character` or `ImmutableList`. 
    Interface names may also be nouns or noun phrases (for example, `List`), but 
    may sometimes be adjectives or adjective phrases instead (for example, 
    `Readable`).
  
  * **Method names are written in _lowerCamelCase_.** Method names are also 
    typically verbs or verb phrases. For example, `sendMessage` or `stop`.
  
  * **Braces are always used where optional.** Braces should be used with `if`, 
    `else`, `for`, `do`, and `while` statements, even when the body is empty or 
    contains only a single statement. Single line lambda expressions are
    permitted. 
    
  * **Column limit: 100.** You should limit the number of characters, including
    whitespace, on any given line to 100 characters. Except as noted below, any 
    line that would exceed this limit must be manually line-wrapped in a
    consistent manner. Exceptions to the column limit include:
    
    * Lines where obeying the column limit is not possible (for example, a long 
      URL in Javadoc, or a long JSNI method reference).
    * In `package` and `import` statements.
    * Command line input examples in a comment that may be cut-and-pasted into 
      a shell.
      
  * **Method height <= window height.** You should limit the number of lines for
    a method so that the entire method can be seen on the screen at once. This
    includes the line(s) with the method's signature and opening curly brace, all
    lines in the body of the mthod (including blank lines), and the line with
    the method's ending curly brace. 
    
    Of all the style guidelines, this is the probably the most subjective and 
    hardest to grade because everyone might have a different window size due
    to different terminal emulator and physical screen size configurations. 
    Therefore, graders will be checking for compliance with the spirit
    of this guideline, which is: methods that are too big and/or repetitive 
    should be refactored to include proper looping constructs and/or broken
    up into smaller methods to improve readability. 

* **(25 points) Javadoc Documentation:** Each method and class needs to be fully
  documented using Javadoc comments. Your comment should provide a description
  of the method's functionality in the first sentence of the comment.  This sentence
  needs to be a gramatically correct English sentence with proper punctuation. Further 
  description can be provided in subsequent sentence. The basic formatting of Javadoc 
  blocks is as seen in this example:
  ```java
  /**
   * Multiple lines of Javadoc text are written here,
   * wrapped normally...
   */
  public int method(String p1) { ... }
  ```
  ... or in this single-line example:
  ```java
  /** An especially short bit of Javadoc. */
  ```
  All method parameters and exceptions need to be documented.
  More information about Javadoc can be found
  [here](https://docs.oracle.com/javase/8/docs/technotes/tools/unix/javadoc.html).

* **(25 points) In-line Documentation:** Code blocks should be adequately documented
  using in-line comments. This is especially necessary when a block of code
  is not immediately understood by a reader (e.g., yourself or the grader).

### Grading

This project will be graded using unit tests that will not be made available
before the project deadline.  

*TL;DR* - Do not modify the provided interfaces and classes; Follow naming 
conventions. **If not, then your project will not be graded.**

## How to Download the Project

On Nike, execute the following terminal command in order to download the project
files into sub-directory within your present working directory:

```
$ git clone https://github.com/cs1302uga/cs1302-calc.git
```

This should create a directory called `cs1302-calc` in
your present working directory that contains the project files. This
directory is an already-setup Maven project. To compile your code, 
simply type the following command while in top level of the 
`cs1302-calc` directory:

```
$ mvn compile
```

If any updates to the project files are announced by your instructor, you can
merge those changes into your copy by changing into your project's directory
on Nike and issuing the following terminal command:

```
$ git pull
```

If you have any problems with any of these procedures, then please contact
your instructor.

## Submission Instructions

You will be submitting your project via Nike before the deadline indicated
near the top of this document. Make sure your project files
are on `nike.cs.uga.edu`. Change into the parent directory of your
project directory. If you've followed the instructions provided in this document, 
then the name of your project directory is likely `cs1302-calc`. 
While in your project's parent directory, execute the following command: 

```
$ submit cs1302-calc cs1302a
```

It is also a good idea to email a copy to yourself. To do this, simply execute 
the following command, replacing the email address with your email address:

```
$ tar zcvf cs1302-lists.tar.gz cs1302-calc
$ mutt -s "[cs1302] cs1302-calc" -a cs1302-calc.tar.gz -- your@email.com < /dev/null
```

If you have any problems submitting your project then please send a private
post to your instructor via the course Piazza as soon as possible. However, 
creating a post about something like this the day or night the project is due 
is probably not the best idea.

# Appendix - FAQ

Below are some frequently asked questions related to this project.

Have a question? Please post it on the course Piazza.

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
