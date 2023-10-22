package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task12.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task12.domain.Investment;

public class PortfolioEditor {

    private final PortfolioDatabase portfolioDatabase;

    public PortfolioEditor(PortfolioDatabase portfolioDatabase) {
        this.portfolioDatabase = portfolioDatabase;
    }

    public void changeTitle(String id, String title) {
        var portfolio = portfolioDatabase.findById(id);
        portfolio.setTitle(title);
        portfolioDatabase.save(portfolio);
    }

    public void changeDescription(String id, String description) {
        var portfolio = portfolioDatabase.findById(id);
        portfolio.setDescription(description);
        portfolioDatabase.save(portfolio);
    }

    public void addInvestment(String id, Investment investment) {
        var portfolio = portfolioDatabase.findById(id);
        portfolio.getInvestments().add(investment);
        portfolioDatabase.save(portfolio);
    }

    public void removeInvestment(String id, Investment investment) {
        var portfolio = portfolioDatabase.findById(id);
        portfolio.getInvestments().remove(investment);
        portfolioDatabase.save(portfolio);
    }

    public void editInvestment(String id, Investment investment) {
        var portfolio = portfolioDatabase.findById(id);
        var investments = portfolio.getInvestments();
        investments.removeIf(i -> i.getProject().getId().equals(investment.getProject().getId()));
        investments.add(investment);
        portfolioDatabase.save(portfolio);
    }
}
