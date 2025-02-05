# Assumptions per iteration

## Iteration 1

## Iteration 2
I assume that the source of stopwords can be something different as a file.
That's why I am not tightly coupling the implementation with reading stopwords from a file but rather do the read in main method only.

I will not allow user to enter path to file with stopwords but instead the file is bundled within my application.
If necessary, we can allow users to specify their own file with stopwords or stopwords themselves later.

## Iteration 3
The application can read now text from file if provided as an argument.
No tests are added for that case as the core functionality (counting words) did not change.
I wrap IOExceptions into RuntimeExceptions. A better approach is to have a specific domain exception (for debuging etc.) but I am keeping it simple as it is small commandline app for now.
I assume that user understands info from Java exception about non-existing file. As an alternative we can provide more user friendly messages for such cases.
I also do not check if file is text of binary. I assume text file in UTF8.

## Iteration 4

The example in the iteration 4 reveled that my understanding of word definition is not correct.
Enter text: Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.
Number of words: 9, unique: 7

Till now, I assumed that words must be separated by whitespace chars only.
I did not put it to assumptions file but spoke about it with interviewer 1.
Now I see that example in iteration 4 contradicts it, so we can improve the solution.
Based on discussion with the current interviewer, I am adding a few more separators that define boundary of a word: comma, dot, hyphen, single quote, double quote, colon, semicolon.

## Iteration 5
Hyphen is not separator of words anymore.
I decided to define word containing hyphes as any string which has at least one letter. It can have one or more hyphens.

Examples:
Humpty-Dumpty : 1 word
Humpty- : 1 word
-Humpty : 1 word
A-B-C : 1 word
---- : 0 words
-A- : 1 word

## Iteration 7
It is not specified in which order to print index but based on on the example I decided to print it alphabetically sorted.
I will not print duplicates, just each word once.

