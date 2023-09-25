# Assumptions per iteration

## Iteration 1

* No need to support more than Utf-8
* Delimiter is everything except 'a-z' & 'A-Z'
* Delimiters are not words
* Does not have to support piped input


## Iteration 2 

* No need for parameter parsing to change path of ignore file
* Renamed stop file internally to ignorefile because its not a stop but a ignore

## Iteration 3

* New lines are counted as delimiters
* No empty newline in file
* Checked in testfiles to test file input
    * If Mock library available would mock IO operations
* 

## Iteration 4

* Unique check is cases sensitive
