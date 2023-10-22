package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.base.services;

public class PortfolioTitleEditor {

    private final PortfolioDatabase portfolioDatabase;

    public PortfolioTitleEditor(PortfolioDatabase portfolioDatabase) {
        this.portfolioDatabase = portfolioDatabase;
    }

    public void changeTitle(String id, String title) {
        var portfolio = portfolioDatabase.findById(id);
        portfolio.setTitle(title);
        portfolioDatabase.save(portfolio);
    }
}
