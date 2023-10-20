# Know your client Chain of Responsibility

Let's take a look at this class
[KnowYourInvestorProcedures.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask7%2Fservices%2FKnowYourInvestorProcedures.java)

## Problems
This class implements Know Your Client procedures, requirement by every financial institution. For the needs of this task, let's assume that investor needs to be screened before she can invest. The screening result can end up in one of the following states:
- `VERIFIED` - investor is cleared to invest
- `REJECTED` - investor cannot invest

Now, there are multiple screening steps that must be performed:
1. Caching - check if investor was already screened for performance reasons mainly
2. Look up the id of the investor
3. Enhance the document with additional information required by further screening steps
4. Checking expiration date of the document
5. Verifying name of the investor
6. Deducing investor experience

And possibly many more in the future. For example:
- logging
- benchmarking
- security checks
- and so on...

As you can see, all of these steps are performed sequentially. However, individual steps are allowed to break the processing and return immediately. For example, there's no need to process further steps if the investor was already rejected in the past or id document is considered expired.

Add few more of such processing steps in `KnowYourInvestorProcedures` and soon you'll end up with a god class that's bloated and extremely hard to maintain and understand.

## Your task
Apply the Chain of Responsibility design pattern to avoid these problems. You can define your own ordering of the steps. You can also add new steps if you want to. The only requirement is that the steps must be executed sequentially and the processing must be stopped if one of the steps returns `REJECTED` result. 

### Solution
As always, you can find the solution in the `solutions.crowdsorcery.task7` package. You can follow the `ChainOfResponsibilityPattern` annotation.

## Discussion
- What are the benefits of using the Chain of Responsibility pattern in this case?
- Are there any drawbacks?
- How you can pass arguments between processing steps? Is it always a good idea?
- What are your thoughts regarding `IdDocumentHolder`?
- Does this pattern allow you to easily add new processing steps?
- Does this pattern allow you to easily understand the processing flow?
- Have you ever faced a similar problem in your codebase? How did you solve it?
- Do you see any chances in your codebase to apply this pattern?