# Assumptions per iteration

## Iteration 1

- Solution for the first iteration is to use a simple regex to count the number of words in a text as stretches of letters (a-z,A-Z)
- The goal is to count the number of words in a text.
- The first Iteration takes as input the console.


## Iteration 2
- The solution will have elements that will be ignored/are not relevant for counting. 
- There will be a "stopwords.txt" file that contains the elements that the solution should ignore.
- The stopwords can be set both 
  - at the root of repo:  val file = File("stopwords.txt")
  - or in resources: val file = File("src/main/resources/stopwords.txt")

## Iteration 3

- There are 2 different entry points now (The application can be started with)
    - a filename to read the text from instead of entering it manually.
    - If no filename is provided, the application will still ask for a text. Sample usage:
- We have during the run parametrised element named "mytext", 
which is the reflection of the actual ".txt" file we will be using when it is provided 
- Extracted the InputHandler into it's own separate service, for handling parameter arguments.

## Iteration 4
- The solution should keep the total number of words
- This iteration requires selecting unique words and elements for each different sentence.
- Created separate method for collecting the total number of elements and unique values

