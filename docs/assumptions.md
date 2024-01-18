# Assumptions per iteration

## Iteration 1

- Words containing numbers or special characters it counts as 2 words (`te12st` counts as 2 words `te` and `st`).

## Iteration 2

- Words that are split by a stop word `testfootest` where `foo` is a stop word should still count as 1 valid word. 

## Iteration 3

- We assume the input file will be small enough to fit into the memory.
