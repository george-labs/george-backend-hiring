# Assumptions per iteration

## Iteration 2
- Stopwords are case sensitive. This means that "The" and "the" are considered different words.

## Iteration 3
- It was not specified where the file should be, so I just put it in the classpath.

## Iteration 4
- Words ending with a special character are counted as unique words. So "Hello" and "Hello!" are considered different words.

## Iteration 5
- It is not clear if the average word length is calculated from the unique or total words. Thats why i chose to calculate it from the unique words.

## Iteration 7
- The sorting is a bit off from what is in the requirements in the iteration. Also i did not read anything about sorting in the iterations requirements so it should be fine.
- The -index needs to be after the file if you want to use reading from a file. Otherwise the program will think that the -index is the file name.