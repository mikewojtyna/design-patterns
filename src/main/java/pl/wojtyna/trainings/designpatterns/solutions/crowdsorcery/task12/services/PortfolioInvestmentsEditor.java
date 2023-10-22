package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.domain.Investment;

public class PortfolioInvestmentsEditor {

    private final PortfolioDatabase portfolioDatabase;
    private final CommandInvoker commandInvoker;

    public PortfolioInvestmentsEditor(PortfolioDatabase portfolioDatabase, CommandInvoker commandInvoker) {
        this.portfolioDatabase = portfolioDatabase;
        this.commandInvoker = commandInvoker;
    }

    public void addInvestment(String id, Investment investment) {
        var command = new AddInvestment(portfolioDatabase, id, investment);
        commandInvoker.invoke(command);
    }

    public void removeInvestment(String id, Investment investment) {
        var command = new RemoveInvestment(portfolioDatabase, id, investment);
        commandInvoker.invoke(command);
    }

    public void editInvestment(String id, Investment investment) {
        var command = new EditInvestment(portfolioDatabase, id, investment);
        commandInvoker.invoke(command);
    }
}
