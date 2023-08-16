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

## Iteration 2
* The file is on the classpath of the application.
* The line is read from the input and trimmed, so the unwanted space at the end is removed then counting the words.
* The word skipping is case-insensitive, so no matter the case in file is, the word should be skipped
* 