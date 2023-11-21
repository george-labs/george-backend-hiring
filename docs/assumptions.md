# Assumptions per iteration

## Iteration 1

Words are always separated by whitespace character, i.e. a2b would be not a word if part of the given input

## Iteration 4

Tokenizer is adapted to handle cases where words end with a punctuation character differently then before, e.g. `word.` should now be interpreted as `word`.
Otherwise, the WordCounter would produce unexpected results.

In addition, it seems that `Humpty-Dumpty` should be interpreted as two words.

## Iteration 5

We assume that a word does not occur in the input that starts or ends with the `-` character.