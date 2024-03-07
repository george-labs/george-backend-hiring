# Assumptions per iteration

## Iteration 1

- User won't enter malicious code (can't use proper user input sanitizing - requires an external library); just do basic sanitizing
- Words are always separated by whitespaces
- Everything except [a-zA-Z] is an invalid word
- User input won't contain newline character(s)