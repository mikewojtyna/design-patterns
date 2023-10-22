# Portfolio editor - the Command Pattern

We introduced a set of new services to allow investors edit their portfolio easily. Let's take a look at these classes:
- [PortfolioEditor.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask12%2Fservices%2FPortfolioEditor.java)
- [PortfolioTitleEditor.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask12%2Fservices%2FPortfolioTitleEditor.java)
- [PortfolioDescriptionEditor.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask12%2Fservices%2FPortfolioDescriptionEditor.java) 
- [PortfolioInvestmentsEditor.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask12%2Fservices%2FPortfolioInvestmentsEditor.java)

The main class is the portfolio editor. The rest of them are just subsets of the portfolio editor.

## Problems
The first thing which is evident is the code duplication. Each editor needs to duplicate the logic to edit special part of the portfolio object. However, the solution for this problem is quite simple - we can extract the logic to another service and simply delegate to it from all the other editors. These editors can act e.g. as decorators, adding something (like logging) on top of the basic logic. This doesn't justify using the command pattern yet.

But, just recently our investors decided they'd like to be able to undo all of the changes made to the portfolio. We can also expect, that soon new requirements will arise, such as:

- audit log for security and debugging reasons
- repeating any command, e.g. for testing purposes or for retry policies in case of errors
- going back in time by repeating multiple commands from the past
- logging the commands to the external system
- and possibly many more...

## Your task
Avoid duplication of the logic in editors and satisfy the undo requirement by applying the Command Pattern.

### Solution
As always, you can find the solution in the `solutions.crowdsorcery.task12` package. You can follow the `@CommandPattern` annotation.

## Discussion
- If you were to introduce the logging requirement, how would you do it? Could you combine the command pattern with some other pattern to achieve this?
- Commands can be implemented as API services, orchestrating all the logic and delegating it to the receivers. Commands can be also implemented as simple DTOs, which are then processed by the services. What are the advantages and disadvantages of both approaches? When should you use the first one and when the second one?
- If command modifies some object, does it need to have access to the persistence layer (e.g. `PortfolioDatabase`)? Are there any other options? What do you think of creating specialized versions of the command invoker, e.g. to invoke commands on `Aggregate`s (as in DDD)?
- Does command pattern support functional-style programming?