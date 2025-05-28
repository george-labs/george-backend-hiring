# Assumptions per iteration

## Iteration 1

it's console application
user will just write/paste text into console
output  the results into console
we presume that the input will be in one line

split the input into word candidates, count only the valid words
valid words a-z and A-Z

## Iteration 2

we have a file of stop words that we want to filter out of counting
case sensitivity of the stop words is not specified
it seems from specification that all stop words are lowercase
let's assume that the comparison should be case insensitive

## Iteration 3

first argument will now be filename to read text from
if there is no filename, proceed as before
there seems to be god candidate to reuse of file reading functionality

## Iteration 4

I'm not happy about the mocking of StopWordService but it will have to do for now
it's imitation of Mockito

lets assume that words with trailing dots are valid words
we found that Humpty-Dumpty is being treated as 2 word, not one and apparently it's valid

