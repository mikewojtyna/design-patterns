# CrowdSorcery

![logo](crowd-sorcery-logo.png)

Active investing requires a lot of time. Investors usually don't have that much
time. They are more focused on earning money. Portfolio diversification is
essential to secure your returns. If you invest everything into the same asset,
you risk all of your capital. How can we diversify our investment portfolio?
Enter the CrowdSorcery!

## Value proposition

CrowdSorcery allows **Investors** to invest into any kind of **Asset**.
**Borrowers** then repay **Loans**. CrowdSorcery is a fundraising platform which
allows investors to allocate their money passively into groups of assets using
automated strategies.

On the other hand, borrowers can easily finance their **Projects** with elastic
interest rate.

## Requirements

- Borrower can start the fundraising to finance her project.
- Investors can invest into assets using investment strategies.
- Investors can invest manually into given asset.
- Investors can invest manually into specific project.
- Investors receive returns based on the assets or projects they invested in and the **Repayment Schedule**.
- Investors can run investment simulations to test their investment strategies on historical data.
- Borrowers receive funds to finance their projects based on the **Loan Schedule**.
- Handling defaults.

### Fundraising

Borrower needs to create the **Project Proposal** first. This is a document containing all the information required by **Project Verifiers** to make decisions whether proposal should be accepted or not. Only after project proposal is accepted, borrower can start the fundraising. The key factors that influence the decision are:

- **Project description** - what is the project about?
- **Project goal** - how much money does the borrower need?
- **Loan schedule** - when does the borrower need the money? There are three types of schedules:
    - **All at once** - borrower gets all the money immediately.
    - **Fixed** - borrowers gets the money every X months.
    - **Milestone** - borrower gets the money after reaching the specified milestones.
- **Interest rate** - how much interest will the borrower pay?
- **Borrower's credit score** - how reliable is the borrower?

Project can be in one of the following states:

1. **Draft** - borrower is working on the proposal.
2. **Pending** - borrower submitted the proposal and is waiting for the decision.
3. **Accepted** - proposal was accepted immediately
4. **Accepted for manual verification** - proposal was initially accepted, but needs to be verified manually.
5. **Rejected** - proposal was rejected by the verifiers and borrower cannot start the fundraising.

### Investing

There are three ways how investors can invest their money:

- **Automated strategy** - investor can choose from a list of automated strategies. These strategies are based on the risk profile of the investor. For example, investor can choose to invest 50% of his money into low risk assets, 30% into medium risk assets and 20% into high risk assets. We might expect strategies might be based on something more than just risk profile.
- **Manual investment into asset** - investor can choose to invest into specific asset. This is useful when investor wants to invest into specific asset.
- **Manual investment into project** - investor can choose to invest into specific project. This is useful when investor wants to invest into specific project.

Before investor can invest into asset or project, he needs to deposit money into his account. Investor can withdraw his money at any time.

### Investment simulation

Investors can run investment simulations to test their investment strategies on historical data. This allows them to see how their strategies would perform in the past. This is useful for testing new strategies or for testing existing strategies on new assets.

Investment simulations might require a lot of time to run.

### Returns

Investors receive returns based on the assets or projects they invested in. Returns are calculated based on the interest rate and the repayment schedule. For example, if the interest rate is 10% and the repayment schedule is monthly, investor will receive 10% of his investment every month.

### Receiving funds

Borrowers receive funds according to the load schedule. For example, if the schedule is monthly, borrower will receive 1/N of the total amount every month. If the schedule is milestone, borrower will receive the money after reaching the specified milestones.

### Handling defaults

In case borrower defaults, investors will receive their money back based on the **Recovery Schedule**. This schedule specifies how much money will the investors receive and when. CrowdSorcery guarantees that investors will receive at least X% of their investment back. X might vary depending on multiple factors, but will always be stated in the project description before investor decides to invest her money.