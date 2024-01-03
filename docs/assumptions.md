# Assumptions per iteration

## Iteration 1
- multiple whitespaces possible
- lines could start white space
- other characters in words make word not acceptable and word should not be counted
- linebreaks count as whitespaces

###Examples
- Mary had a little lamb - 5words
- Mary %had a lit#tle lamb - 3words
- Mary had a\nlittle lamb -5words
- Mary had a lit\ntle lamb - 6words
