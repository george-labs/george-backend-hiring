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