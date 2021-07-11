# Sorting Tool

Command line app that can sort numbers or text input from the command line. Can sort in natural order or by item frequency. Uses a generic class so one sorter class handles all data types.

## Things learned 

First time using a generic class in a project

Insertion sort algorithm implemented for natural sorting

### Details

#### The directory contains 3 files: 

* Main.java - sets up the controller object and passes the args array to it
* Controller.java - parses command line arguments, builds GenericSorted object and handles all user input and output
* GenericSorter.java - generic class that handles both sorting methods

Fifteenth project created for JetBrains Academy Java Developer course - hard level project.

### How to Run

The app can run with or without command line arguments. Default options are natural sorting and word datatype.

Parses 4 arguments: -sortingType, -dataType, -inputFile and -outputFile
  
-sortingType: 3 data types allowed - long, line or word

-dataType: defines the sorting type, either natural or byCount

-inputFile: filename to read the input data

-outputFile: filename to print the results, any error messages are output to the console

### Sample input and output:

The greater than symbol followed by a space (> ) represents the user input. 

Example 1, for sorting longs by count:

\> 1 -2   33 4\
\> 42\
\> 1                 1

Total numbers: 7.\
-2: 1 time(s), 14%\
4: 1 time(s), 14%\
33: 1 time(s), 14%\
42: 1 time(s), 14%\
1: 3 time(s), 43%

Example 2, for sorting numbers naturally:

\> 1 -2   33 4\
\> 42\
\> 1                 1

Total numbers: 7.\
Sorted data: -2 1 1 1 4 33 42

Example 3, for sorting words naturally:

\> 1 -2   33 4\
\> 42\
\> 1                 1\
Total words: 7.\
Sorted data: -2 1 1 1 33 4 42

Example 4, for sorting lines naturally:

\> 1 -2   33 4\
\> 42\
\> 1                 1

Total lines: 3\
Sorted data:\
1                 1\
1 -2   33 4\
42
