# Fundraising service strategy composition
Let's go back to the [FundraisingService.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask4%2Fservices%2FFundraisingService.java) class and `processProposal` method.

## Problems
`ProposalProcesor` is currently implemented only by one class. This class clearly violates the Single Responsibility Principle. At some point it will become a God Object. In fact, in previous task we just moved the same piece of code into another class. We can do better.

## Your task
Split `GodClassProposalProcessor` into smaller processors, each responsible only for one thing. Then, create one special processor that will make the final decision by delegating to other processors. For the needs of this task let's assume the following rules:

- If at least one processor returns `REJECTED`, then proposal is rejected immediately.
- If the majority of processors return `VERIFICATION_REQUIRED`, then proposal is marked as `VERIFICATION_REQUIRED`.
- Proposal is accepted only if all processors return `ACCEPTED`.
- `NO_DECISION` is the final decision if none of the above rules apply.

Use Composite pattern to improve the implementation of the `ProposalProcessor`. Write tests.

### Solution
You can find solutions in the `solutions.crowdsorcery.task4` package. You can follow the `patterns.StrategyPattern` and `patterns.CompositePattern`.

## Discussion
- How does the introduction of the composite affect the number of test cases that need to be verified?
- How does the introduction of the composite affect the project's extensibility?