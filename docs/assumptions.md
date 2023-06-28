# Assumptions per iteration

## Iteration 1
- The user will input one line of text at a time.
- When a phrase contains invalid words, those words will be ignored and not counted. Valid words are words that contain letters (a-z,A-Z).
- The words were seperated by whitespace.
## Iteration 2
- If the stopwords file does not exist, all valid words in the phrases will be counted.
- The stopwords file should be in the resource folder.
- An assumption is made that the letter case of stopwords is irrelevant. This means that if the stopfile contains the word 'the', then none of the following words will be counted: 'the', 'The', and 'THE'.
## Iteration 4
-  Valid words are words that contain letters (a-z,A-Z).
## Iteration 5
-  Valid words are words that contain letters (a-z,A-Z) and a hyphen. 
- Any punctuation (.,?!) is removed from the input phrase
- Words that start or end with the hyphen character are not considered valid
- If the hyphen character is in the middle of a word, it will be removed, regardless of how many times it occurs.