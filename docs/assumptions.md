# Assumptions per iteration

## Iteration 1

## Iteration 2
The stopwords.txt is bundle-in with code, it exists, it is correctly formatted
The stopwords.txt is in the resources folder
The stopwords.txt is not a huge file, should not cause OOM exception

## Iteration 3
input text splitting is only supporting spaces, tabs and system independent line separators
If the filename is provided at the startup, the file is encoded in UTF-8
If the filename is provided at the startup and the file does not exists we will not thrown an exception, output error message and exit the application 