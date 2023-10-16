# Fundraising service strategy

Take a look at [FundraisingService.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask3%2Fservices%2FFundraisingService.java) class and `processProposal` method.

## Problems
What problems do you see? What would happen if new processing requirements are added frequently and become more and more complex? How would you change the `processProposal` method to make it more flexible?

## Your task

Refactor the `processProposal` method to use the Strategy pattern and write tests just for `processProposal` method.

### Extra
Do you see any other methods that could be refactored using the Strategy pattern?

### Solution
You can find solutions in the `solutions.crowdsorcery.task3` package. You can follow the `patterns.StrategyPattern` annotation to see how it can be implemented using different approaches.

## Discussion

- How does the introduction of the strategy affect the number of test cases that need to be verified?
- How does the introduction of the strategy affect the project's extensibility?
- Where do you see the SOLID: Open-Closed Principle being applied?
- Provide examples of projects you are working on where such a solution would be beneficial and justified
- What are the cons of the Strategy pattern?