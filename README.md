# Stopwords

A CLI application for counting words in input.

## Usage

If no input file is provided, text is read from input stream:
```bash
$ wordcount
Enter text: Mary had a little lamb
Number of words: 4, unique: 4; average word length: 5.63 characters
$
```

Filename can be provided as a first argument to read input text from:
```bash
$ wordcount mytext.txt
Number of words: 4, unique: 4; average word length: 5.63 characters
```

Optional flags:
- `-index`: print out index of words
- `-dictionary=path/to/file.txt`: path to dictionary of known words to verify index against
