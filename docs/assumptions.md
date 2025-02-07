# Assumptions per iteration

## Iteration 1
- words which do not match regex would be ignored
- as logging tool I'm using just console (bcs logging tool is missing in pom)
- method provideInput is just for testing (it can be replaced by something nicer: but I would need to add external dependency)

## Iteration 2
- file stopwords.txt is located in resources folder
- if file is missing or cannot be read, error message is logged inside console logger and application is ignoring this
  stopwords functionality
- javadocs are missing due simple implementation and I'm trying to write self documented code
- 
