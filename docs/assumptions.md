# Assumptions per iteration

## Iteration 1

## Iteration 2
I assume that the source of stopwords can be something different as a file.
That's why I am not tightly coupling the implementation with reading stopwords from a file but rather do the read in main method only.

I will not allow user to enter path to file with stopwords but instead the file is bundled within my application.
If necessary, we can allow users to specify their own file with stopwords or stopwords themselves later.
