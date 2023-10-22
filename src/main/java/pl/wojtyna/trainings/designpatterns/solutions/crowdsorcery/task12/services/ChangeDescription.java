package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.domain.Portfolio;

import java.util.UUID;

public class ChangeDescription implements Command {

    private final CommandId id;
    private final PortfolioDatabase portfolioDatabase;
    private final String portfolioId;
    private final String newDescription;
    private String oldDescription;

    public ChangeDescription(PortfolioDatabase portfolioDatabase, String portfolioId, String newDescription) {
        id = new CommandId(UUID.randomUUID());
        this.portfolioDatabase = portfolioDatabase;
        this.portfolioId = portfolioId;
        this.newDescription = newDescription;
    }

    @Override
    public void execute() {
        var portfolio = findPortfolio();
        oldDescription = portfolio.getTitle();
        changeTitle(portfolio, newDescription);
    }

    @Override
    public void undo() {
        if (oldDescription == null) {
            return;
        }
        changeTitle(findPortfolio(), oldDescription);
    }

    @Override
    public CommandId id() {
        return id;
    }

    private Portfolio findPortfolio() {
        return portfolioDatabase.findById(portfolioId);
    }

    private void changeTitle(Portfolio portfolio, String title) {
        portfolio.setTitle(title);
        portfolioDatabase.save(portfolio);
    }
}
