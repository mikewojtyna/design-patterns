# Earnings calculator decorator

In this task we'll analyze the service to calculate earnings for the investors. Take a look at [EarningsCalculator.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask6%2Fservices%2FEarningsCalculator.java).

## Problems
To calculate project earnings we first need to calculate all fees. We've decided to hardcode all the fees, including the calculation logic directly in the earnings calculator. For small number of fees this approach might be just fine. However, recently we've learned there would possibly unlimited number of fees to be applies. Fees can be also enabled and disabled dynamically. Our design definitely doesn't support that well, right?

## Your task
Apply the decorator pattern to avoid changing earnings calculator each time there's a new fee enabled or disabled.

### Solution
As always, you can find the solution in the `solutions.crowdsorcery.task6` package. You can follow the `DecoratorPattern` annotation.

## Discussion
- Is code easier or harder to understand after applying the decorator pattern?
- How many classes need to be changed when adding a new fee?
- Could you use other patterns to solve this problem?