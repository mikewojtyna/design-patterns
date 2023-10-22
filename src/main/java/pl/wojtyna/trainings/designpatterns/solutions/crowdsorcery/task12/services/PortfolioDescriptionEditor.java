package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.services;

public class PortfolioDescriptionEditor {

    private final PortfolioDatabase portfolioDatabase;
    private final CommandInvoker commandInvoker;

    public PortfolioDescriptionEditor(PortfolioDatabase portfolioDatabase, CommandInvoker commandInvoker) {
        this.portfolioDatabase = portfolioDatabase;
        this.commandInvoker = commandInvoker;
    }

    public void changeDescription(String id, String description) {
        var command = new ChangeDescription(portfolioDatabase, id, description);
        commandInvoker.invoke(command);
    }
}
