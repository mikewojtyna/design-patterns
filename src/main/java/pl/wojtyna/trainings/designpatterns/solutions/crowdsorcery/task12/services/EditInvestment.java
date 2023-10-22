package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.domain.Investment;

import java.util.UUID;

public class EditInvestment implements Command {

    private final PortfolioDatabase portfolioDatabase;
    private final String portfolioId;
    private final Investment investment;
    private final CommandId id;
    private Investment oldInvestment;

    public EditInvestment(PortfolioDatabase portfolioDatabase,
                          String portfolioId,
                          Investment investment) {
        this.id = new CommandId(UUID.randomUUID());
        this.portfolioDatabase = portfolioDatabase;
        this.portfolioId = portfolioId;
        this.investment = investment;
    }

    @Override
    public void execute() {
        var portfolio = portfolioDatabase.findById(portfolioId);
        var investments = portfolio.getInvestments();
        var oldInvestment = investments.stream()
                                       .filter(i -> i.getProject().getId().equals(investment.getProject().getId()))
                                       .findAny().orElse(null);
        this.oldInvestment = oldInvestment;
        investments.remove(oldInvestment);
        investments.add(investment);
        portfolioDatabase.save(portfolio);
    }

    @Override
    public void undo() {
        var portfolio = portfolioDatabase.findById(portfolioId);
        var investments = portfolio.getInvestments();
        investments.removeIf(i -> i.getProject().getId().equals(investment.getProject().getId()));
        investments.add(oldInvestment);
        portfolioDatabase.save(portfolio);
    }

    @Override
    public CommandId id() {
        return id;
    }
}
