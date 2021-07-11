# Sorting Tool

Command line app that can sort numbers or text input from the command line. Can sort in natural order or by item frequency. Uses a generic class so one sorter class handles all data types.

## Things learned 

First time using a generic class in a project

Insertion sort algorithm implemented for natural sorting

### Details

User options:


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
