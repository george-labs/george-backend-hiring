# Assumptions per iteration

## Iteration 1

Completing the logic for counting words in a given line where the source of input is the console.
Writing few test cases which satisfy the positive and negative scenarios.

There is a Point of Entry class which can act as a factory if in future there is a need to have another input source like a File from local machine or a web location.

Currently, to run this application, we need to pass "console" as a CLI argument which will do the job.
There is a missing integration test which should test whether my Main application works fine but due to an issue that my application needs a console input(The text input for word count) during execution, I am unable to complete it at this point of time.