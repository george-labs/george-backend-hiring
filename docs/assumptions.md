# Assumptions per iteration

## Iteration 1

### Session 1:
Requirements:
1. Input to the Command line
2. Output Number of words (result ends with NL) -> `Number of words: 5`
3. Word is the (a-z,A-Z)
4. Input Validation -> start with `Enter text: `

Initial design thoughts:
   //Where data come from
   // UI -> responsible for UI
   //Core:
   // Validator -> to check the commandline structure
   // Fetcher -> to get the data
   // Parser -> to count the words
   // Presenter -> create the output
   //Where data go after
   //  Outputer -> the class responsible for output the data

### Session 2:
Note: Validation will be omited due to wrong understanding. The program will paste for the user the inital text: `Enter text: `

### Session 3:
New Requirements:
1. Store a file with stop words
2. Filter out those words from counting 

Potential improvements in data layer:
// 1. Create dao (with local cash) -> StopWordsRepository just once and then will cash the value
// 2. the filter StopWordsFilter will dao.

### Session 4:
// The factory for Filter were introduced due to increased complexity of creating the object

### Session 5:
// create a factory  to decide how to process the counting
// new implementaiton of the Fetcher
//BONUS -> 

//Things that didn't manage to make in time:
1. Add FetcherFactory
2. Cover tests
3. Create general approach to read from files
