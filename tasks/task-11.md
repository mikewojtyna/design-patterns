# Transfer service changes - the Adapter Pattern

Let's talk about transfers. Take a look at these two classes:
- [old transfer service](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask11%2Fservices%2FOldTransferService.java)
- [new transfer service](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask11%2Fservices%2FTransferService.java) 

## Problems
The old implementation of the transfer service was extremely naive. It simply assumed we're operating as a bank and we're responsible for managing deposits directly in our local database using local transactions. Obviously, this doesn't make any sense. Therefore, we decided to change the transfer service to use an external API. This API is exposed as a [Payment Gateway class](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask11%2FPaymentGateway.java).

As you can see, the payment gateway operates on a completely different model than our transfer service. Still, we cannot stick with the old implementation. The only problem is that the old transfer service is already being used by many other classes. We cannot simply change the interface of the old transfer service. We need to find a way to adapt the old transfer service to the new one.

**Note:** sometimes creating adapters might require a lot of work (and potentially multiple classes cooperating together). In this case, the old transfer service uses a synchronous API. If there's no exception, we simply assume that transfer succeeded. Doesn't smell good, right? If we really need to adhere to the old API, we are forced to wait and 'simulate' the sync API. However, if the old API is used by hundreds of other classes and/or (even worse) multiple teams in our organization, we might be forced to create such adapters. Let's just hope for a short period of time, until a new better API is well adopted. 

## Your task
Apply the adapter pattern to keep the old contract of the transfer service, but use the new payment gateway to perform the actual transfer. Unfortunately, you will have to write the waiting code in the adapter.

### Solution
As always, you can find the solution in the `solutions.crowdsorcery.task11` package. You can follow the `@AdapterPattern` annotation.

## Discussion
- Is it the final solution?
- How bad API design can affect the whole system?
- If we decide to introduce a new API, how do you help your clients to migrate to the new API?
- Should we always create asynchronous APIs?
- What happens when you apply the adapter pattern to the architecture level?