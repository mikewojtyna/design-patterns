# Wrapping complicated credit score subsystem - the Facade Pattern
We need to communicate with complicated subsystem to update and sync the borrower credit scores. In this task you'll work with the following classes:

- [BorrowerCreditScoreSyncer.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask15%2Fservices%2FBorrowerCreditScoreSyncer.java)
- [BorrowerCreditScoreLocalDbUpdater.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask15%2Fservices%2FBorrowerCreditScoreLocalDbUpdater.java)
- [BorrowerCombinedScoreFinder.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask15%2Fservices%2FBorrowerCombinedScoreFinder.java)

## Problems
As you can see, the complicated interactions with `JdbcDatabase`, `MongoDatabase` and `ConnectionManager` is duplicated within all services. Unfortunately, the previous version of the system stored credit scores partially in Mongo DB and SQL storage. Now, we need to combine both scores and return the final result after applying some transformation (`(sqlCreditScore + legacyPoints / 2) + 1 + bonusPoints`). The extra bonus points can be provided by client of the `BorrowerCreditScoreLocalDbUpdater`. Note, that `BorrowerCreditScoreSyncer` is slightly different, as it doesn't allow to add any bonus points.

Each time we introduce a new service, we're forced to again duplicate this complicated flow of calls between multiple components.

## Your task
Apply the Facade Pattern to simplify the interactions.

### Solution
As always, you can find the solution in the `solutions.crowdsorcery.task15` package. You can follow the `@FacadePattern` annotation.

## Discussion
- Is simplification always the correct approach? What do we gain, what do we loose?
- Can Facade Pattern be used during refactoring steps?
- What are the differences between Adapter and Facade patterns?
- What about the bonus points? How did it influence the parameters of the facade?
- Give some real-life examples of working with facades.
- It's quite tempting to put all the complexity of our systems into this little innocent Facade, right? :)