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
