# George Backend Chapter - Coding Challenge

Congratulations. You made it to our next recruiting stage which is a coding challenge.
In this stage you have to show practical skills in the things which we discussed in the previous recruiting stage:

- Object-Oriented Programming
- Refactoring
- Automated Testing (Unit & Integration Tests)

### Pair-Programming Sessions

You will collaborate in five sessions with George Backend Chapter team members.
Every session takes one hour. There will be a one-hour lunch break from 12am to 1pm.
At the beginning of every session a new George Backend team member will join while the previous colleague leaves.

In the Remote-Pair-Programming Sessions you need to share your screen so that we can follow your progress.
In case you have a dual monitor setup, please make sure that you also share your browser window.
Of course, you can use the web to research in case you need to look up something.
In general, it should feel as if you would have a regular day at work.

### Exercise: Word Count Kata

The requirements of the Word Count Kata are located in [requirements](requirements).
You will find all requirements split into 9 iterations.
The goal of this exercise is __not__ to finish as many iterations as possible.
We will evaluate your solution based on __quality over quantity__.

Please focus on code quality by applying

- Object-Oriented Programming
- Refactoring
- Automated Testing (Unit & Integration Tests)

Please always look only at one iteration at a time.
The goal is to come up with a design which makes future changes to your code base as easy as possible.
Of course, you shouldn't over-engineer your solution but only design as much as needed.
This is exactly what we are going to evaluate.

### Feature Branches

In the George Backend Chapter you have to work in feature branches for each task.
As soon as you finish your task you will open up a pull request on GitHub which then will be reviewed
at least by two of your colleagues (you don't have to do this in your coding interview!).
Therefore, think of solving an iteration as if you would solve a task for our team.
Always focus on quality and come up with a codebase which you would be happy working in.
Empathy in our team is highly valued.
We always put ourselves into our reviewers position to improve their life when reviewing our code.

- For each iteration, please create a branch with the following
  pattern: `<firstname>_<lastname>_session_<session-nr>_iteration_<iteration-nr>_<pairing-partner-name>`
    - The `<pairing-partner-name>` is the name of the team member you pair in this iteration
- Your first iteration must branch off `main`
- Your branches won't be merged back to master
- Make sure every new branch is based on the previous branch

### Assumptions

In case the requirements are ambiguous, please write down your assumptions into the project's `docs/assumptions.md`
file.
Please always create a section for each iteration and put your assumptions under this section.
This helps us to follow certain design decisions in your code which you came up with based on your assumptions.

### Evaluation

We will only evaluate your finished iterations.
Please make sure that

- Your code is compiling
- Your tests aren't failing
- The requirements are met
- The code is in a state that you are happy with

You can see these rules as the definition of done for an iteration.

This example might also seem a bit hypothetical, but we believe it's small but complicated enough, that it makes sense
to come up with an Object-Oriented Design which is more sophisticated than implementing your whole solution in a single
main method 😉.  
The evaluation won't take longer than 1 work day.  
In case we think your solution and way of working fits ours we will invite your for the final team matching.  
If we do not continue the recruiting process with you, we will send you a detailed feedback of our evaluation.

### Requirements

Please use Java 11 or Kotlin as a programming language, the project is already setup to support both.
No Frameworks are allowed for this exercise.
No other libraries than JUnit and the Kotlin Standard Library must be used.
Currently, JUnit 5 as well as Kotlin are configured in the `pom.xml`.
We don’t allow any mocking library.
In case you see the need for mocking, please hand-roll your mocks.

### Let's Get Started

1. Clone the repository
2. Create a branch off `main`  
   `<firstname>_<lastname>_session_1_iteration_1_<pairing-partner-name>`
3. Push this branch to the repository
4. Run `./mvnw clean verify` via your terminal
5. Open the project in your IDE of choice
6. Create a dummy unit test and run it
7. Read the requirements from the _Requirements_ section  
   Please only read one iteration at a time, starting with iteration 1
8. Please think about how you will approach this problem in code for a few minutes before you start coding
