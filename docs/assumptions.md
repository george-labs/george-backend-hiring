# Assumptions per iteration

## Iteration 1
The assumptions on what is and what is not a word
not a word: contains any special character not being (a-zA-Z)
w3rd
Marku$
Ma?kus
markus.waidhofer

is a word:
contains only a-zA-Z characters

Word separator is a space only.
Punctuation is ignored, but we need to remove it from the word as a word with punctuation at the end is valid. 
We allow more occurrence of the punctuation at the end.  

Hello, my name is Markus. (5)
Hello, my name is Markus!!! (5)

Each sentence has a space after the punctuation.

Text length is limited to 10000 characters. And the word count fits into the integer.
