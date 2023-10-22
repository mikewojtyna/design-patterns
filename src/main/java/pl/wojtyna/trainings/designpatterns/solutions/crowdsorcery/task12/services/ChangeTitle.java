package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.domain.Portfolio;

import java.util.UUID;

public class ChangeTitle implements Command {

    private final CommandId id;
    private final PortfolioDatabase portfolioDatabase;
    private final String portfolioId;
    private final String newTitle;
    private String oldTitle;

    public ChangeTitle(PortfolioDatabase portfolioDatabase, String portfolioId, String newTitle) {
        id = new CommandId(UUID.randomUUID());
        this.portfolioDatabase = portfolioDatabase;
        this.portfolioId = portfolioId;
        this.newTitle = newTitle;
    }

    @Override
    public void execute() {
        var portfolio = findPortfolio();
        oldTitle = portfolio.getTitle();
        changeTitle(portfolio, newTitle);
    }

    @Override
    public void undo() {
        if (oldTitle == null) {
            return;
        }
        changeTitle(findPortfolio(), oldTitle);
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
