# Assumptions per iteration

## Iteration 1
- Robin suggests that words are separated by spaces.
- I also suggest to count input whitespace characters such as tabs etc. (defined by regexp \s).
- Marton clarified that word "wer2ty" is not counted as a word since it contains also digits that are outside a-zA-Z stretches.
- To start with we expect "sensible" (less than 100MB) inputs, therefore output will fit into Integer.
- From beginning we expect user input on a single line.

- Error handling - TODO


