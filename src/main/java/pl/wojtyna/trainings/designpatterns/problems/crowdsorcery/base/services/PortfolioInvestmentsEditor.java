package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.domain.Investment;

public class PortfolioInvestmentsEditor {

    private final PortfolioDatabase portfolioDatabase;

    public PortfolioInvestmentsEditor(PortfolioDatabase portfolioDatabase) {
        this.portfolioDatabase = portfolioDatabase;
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
