# Stopwords

A CLI application for counting words in input.

## Setup

The application expects `stopwords.txt` (containing line delimited stop words) to exist in the project path.

## Usage

If no input file is provided, text is read from input stream:
```bash
$ wordcount
Enter text: Mary had a little lamb
Number of words: 4
$
```

Filename can be provided as a first argument to read input text from:
```bash
$ wordcount mytext.txt
Number of words: 4
```