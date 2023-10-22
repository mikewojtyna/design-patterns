package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.services;

public class PortfolioTitleEditor {

    private final PortfolioDatabase portfolioDatabase;
    private final CommandInvoker commandInvoker;

    public PortfolioTitleEditor(PortfolioDatabase portfolioDatabase, CommandInvoker commandInvoker) {
        this.portfolioDatabase = portfolioDatabase;
        this.commandInvoker = commandInvoker;
    }

    public void changeTitle(String id, String title) {
        var command = new ChangeTitle(portfolioDatabase, id, title);
        commandInvoker.invoke(command);
    }
}
