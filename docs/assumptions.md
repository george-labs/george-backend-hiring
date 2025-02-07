# Assumptions per iteration

## Iteration 1
    - words are splitted by space symbol in input string
    - there is a IDE warning about logging stack trace. I would use @Slf4j to get rid of it
## Iteration 2
    - in case system cannot find a file with stop words it will output a warning
    - the file with stop words will be stored in resource folder
    - for now I will store stopwords in a list
        - It will cost me O(n) to check matches every time
        - I was considering using HashMap for storing <StopWord, 0> pairs
            - Key is a stop word from resource file and value is 0 always
            - For now I will not benefit from holding values, but I may use it in future for counting words
            - Also picking an element from HashMap by key is O(1) which may be much faster on bigger nubmers
## Iteration 3 
    - in case program runs with more than 1 args there is a warning
        - extra arguments will be ignored
        - program will process file specified in 1st arg

