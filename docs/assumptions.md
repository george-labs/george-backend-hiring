# Assumptions per iteration

## Iteration 1

- User won't enter malicious code (can't use proper user input sanitizing - requires an external library); just do basic checks
- User input won't contain newline character(s)
- Words are always separated by whitespaces
- Everything except [a-zA-Z] is an invalid word


## Iteration 2

- stopwords.txt on classpath; we won't provide a way for user to change this currently
- stopwords file will contain 1 word per line
- stopwords file won't be user-supplied - all word will be valid, no need to check


## Iteration 3

- File will be read from filesystem (not classloader)
- Filename may include a relative path
- User input from console won't contain newline character(s); user input from file MAY contain newlines
- We ignore other than the first command line argument