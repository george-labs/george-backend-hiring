# Assumptions per iteration

## Iteration 1

Words are separated by space, dot, comma, explanation mark, question mark, semicolon.
```shell
$ wordcount
Enter text: ""
Number of words: 0
$
```

```shell
$ wordcount
Enter text: Mary had a little lamb.
Number of words: 5
$
```

```shell
$ wordcount
Enter text: 1258
Number of words: 0
$
```

```shell
$ wordcount
Enter text: Mary had a li25le 1258 @! lamb. 
Number of words: 4
$
```

## Iteration 2
```shell
$ wordcount
Enter text: the a on off
Number of words: 0
$
```

```shell
$ wordcount
Enter text: the a on off interview
Number of words: 1
$
```

The file not found -> Exception is thrown and the program exits.
The file is empty -> No stop words loaded, but program continues.

## Iteration 3
Partial implementation is presented in JavaApplication.java. Did not manage to properly implement reading input from file withit the time frame.