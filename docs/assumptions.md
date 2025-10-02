# Assumptions per iteration

## Iteration 1
t1: 
    input: "Mary had a little lamb"
    output: 5
t2: in: "xxxx"
    output: 1
t3: in: ""
    out: 0
t4: in: "Ma1ry had a lil lamb"
    out: 4
t5: in: "mary.had-a lil lamb"
    out: 2
t6  in: "mary. had-a lil lamb"
    out: 2

Assumption:
    words are only counted as words if they are containing only stretches of alphabetical letters case insensitive
    words are split by whitespaces

## Iteration 2
stopwords.txt :
the, a, on, off, mary

t1: 
    in: "Mary had a little lamb"
    out: 3

t2: in: "aaaaa aaaaa bbb"
    out: 3

t3: in: "MARY had a lil lamb"
    out: 3

t4: in: "mary had a lil lamb"
    out 3


Assumption:
    stopwords.txt contains case insensitive words to filter input out

## Iteration 3

t1: file in: "Mary had a lil lamb"
    out: 3

t2: file in: "Mary had \na lil lamb"
    out: 3

t3: file in: ""
    out: 0

t4 file in: "\nhi"
    out: 1

t5 stdin: "hi daniel here"
    out: 3

Assumption:
    words are split by whitespace and newlines if provided via textfile from program argument
    else by Stdin only by whitespaces

## Iteration 4

t1: in: Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.
    out: 9, 7

t2: in: mary-had a lil lamb
    out: 4,4

t3: in: mary loves mary
    out: 3,2

t4: in: mary marries-mary
    out: 3,2

t5  in: mary. had. a. mary.
    out: 3,2


Assumption:
    words are split by whitespaces(\s) and dash(-) 
    a word is still a valid word if the tail of the word consists of a . 
    duplicates only consist of words with exactly the same chars 
    so: mary = mary -> true
        mary. = mary -> false