# Assumptions per iteration

## Iteration 1
I have assumed that the input is one line.
My assumption is that if the text is empty or null, then it contains 0 matches, so 0 should be returned.

## Iteration 2
My assumption is that wordcount should have two variations, one with the filter for stopwords enabled and one without


## Iteration 3
I will remove Reader and Counter interface to make it more simple, because solutions like this should be used there, 
where they make sense, and on a second thought I am overcomplicating it.

## Iteration 4
My assumption is to ignore the special characters '-' and '.' for example in Humpty-Dumpty making it two separate words.

## Iteration 6
Calculating the average is based on the counted words not all input words, meaning that they are already filtered using 
the stopwords and the pattern.

## Iteration 7
Removed reading text file in the main method because I ve assumed that the argument is replaced by -index