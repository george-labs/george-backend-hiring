# Assumptions per iteration

## Iteration 1
- If text provided for the input have words that contains non (a-z,A-Z) characters, an IllegalArgumentException will be thrown and execution is stopped.

## Iteration 2
- If stopwords are not loaded successfully from stopwords.txt, An Error message will be showing and the count function will count words without considering stopwords

## Iteration 3
- provided Filename should be a .txt file, with a name [a-zA-Z0-9_-] with no spaces or special characters
- In order to execute with mytext.txt as an argument, this command should be run <br />
``./mvnw clean compile exec:java -D"exec.mainClass"="WordCountRunner" -D"exec.args"="mytext.txt"``
- If the provided filename failed to load, an FileNotFoundException will be fired with message (Error: File Does not exist filename.txt) and returning 0 as a word count