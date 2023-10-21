# Portfolio builder

Let's take a look at this class
[PortfolioCreator.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask8%2Fservices%2FPortfolioCreator.java)

## Problems
The portfolio creator is responsible for creating different representations of the `Portfolio` object, which is created by investors to share their investment details. The class is already bloated. Now, imagine what would happen if we keep introducing new format plugins dynamically at a high rate? Also, there's a new requirement that certain parts of the portfolio should be saved in a different format. How would you solve this problem?

## Your task
Apply the Builder pattern to solve the mentioned problems.

### Solution
As always, you can find the solution in the `solutions.crowdsorcery.task8` package. You can follow the `BuilderPattern` annotation.

## Discussion
- What are the benefits of using the Builder pattern in this case?
- Do you see any drawbacks?
- Is code readability improved?
- When should you apply this pattern?