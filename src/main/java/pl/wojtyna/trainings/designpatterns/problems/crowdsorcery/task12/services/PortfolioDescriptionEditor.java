package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task12.services;

public class PortfolioDescriptionEditor {

    private final PortfolioDatabase portfolioDatabase;

    public PortfolioDescriptionEditor(PortfolioDatabase portfolioDatabase) {
        this.portfolioDatabase = portfolioDatabase;
    }

    public void changeDescription(String id, String description) {
        var portfolio = portfolioDatabase.findById(id);
        portfolio.setDescription(description);
        portfolioDatabase.save(portfolio);
    }
}
