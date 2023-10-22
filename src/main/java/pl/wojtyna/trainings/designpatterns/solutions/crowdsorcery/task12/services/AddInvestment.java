package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.domain.Investment;

import java.util.UUID;

public class AddInvestment implements Command {

    private final PortfolioDatabase portfolioDatabase;
    private final String portfolioId;
    private final CommandId id;
    private final Investment investment;

    public AddInvestment(PortfolioDatabase portfolioDatabase, String portfolioId, Investment investment) {
        this.investment = investment;
        this.id = new CommandId(UUID.randomUUID());
        this.portfolioDatabase = portfolioDatabase;
        this.portfolioId = portfolioId;
    }

    @Override
    public void execute() {
        var portfolio = portfolioDatabase.findById(portfolioId);
        portfolio.getInvestments().add(investment);
        portfolioDatabase.save(portfolio);
    }

    @Override
    public void undo() {
        var portfolio = portfolioDatabase.findById(portfolioId);
        portfolio.getInvestments().remove(investment);
        portfolioDatabase.save(portfolio);
    }

    @Override
    public CommandId id() {
        return id;
    }
}
