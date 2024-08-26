# Assumptions per iteration

## Iteration 1
When program runs, it asks for a single input which is then processed.
After processing and showing the desired result to the user, the program exits.

Customer wants to input whole sentences as input, delimited by punctuation symbols: dot(.), comma(,) and exclamation mark(!) and question mark(?).
If string is followed by at most one punctuation mark, it is counted as word.
Following example has 10 words:
```
Mary, who had a little lamb said I am hungry!
```

Following example has 5 words:
```
Joseph did not have any lambs...
```

## Iteration 2
Program reads file "stopwords.txt" which contains list of 'blaclisted' words that do not count.
For example if file contains:
```
the
```

Then following example has 4 words:
```
the little lamb is white.
```

We assume that the stop words have to match exactly (including case).