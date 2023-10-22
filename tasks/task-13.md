# Dealing with unreliable external tax calculator service - the Proxy Pattern
We need to use an external service to calculate the tax for our projects.

Take a look at the following classes:

- [TaxCalculator.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask13%2FTaxCalculator.java)
- [UnreliableTaxCalculator.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Fdesignpatterns%2Fproblems%2Fcrowdsorcery%2Ftask13%2FUnreliableTaxCalculator.java)

## Problems
Unfortunately, the external service is unreliable. It sometimes throws exceptions, sometimes returns wrong results. For the needs of this task let's assume that TaxCalculator is a third-party library and we cannot modify it.

Calculating tax is a critical part of our software. We need to handle this situation.

## Your task
Implement **very** simple Circuit Breaker using the Proxy Pattern. The Circuit Breaker should be implemented as a proxy for the `TaxCalculator` class. It should be able to detect when the external service is not working properly and return a default value instead of the result from the external service. After maximum 3 failed attempts, the Circuit Breaker should stop calling the external service and return the default value all the time.

### Solution
As always, you can find the solution in the `solutions.crowdsorcery.task13` package. You can follow the `@ProxyPattern` annotation.

## Discussion
- Do you know how Spring Framework utilizes the Proxy Pattern?
- How does proxy pattern affect the readability of the code?
- Is it easier to debug the code with or without the proxy?
- Have you ever used the Proxy pattern in your projects?