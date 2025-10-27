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


