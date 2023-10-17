package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task5.services;

import pl.wojtyna.trainings.designpatterns.annotations.AbstractFactoryPattern;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.TimeUnit;

@AbstractFactoryPattern
public class ConfigurationBasedProposalProcessors implements ProposalProcessors {

    private final ConfigurationProvider configurationProvider;

    public ConfigurationBasedProposalProcessors(ConfigurationProvider configurationProvider) {this.configurationProvider = configurationProvider;}

    @Override
    public ProposalProcessor chooseTheRightProcessor() {
        try {
            return createProposalProcessor();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private ProposalProcessor createProposalProcessor() throws InterruptedException {
        var configuration = fetchConfigurationFromDatabase();
        return createProposalWithSomeBusinessLogic(configuration);
    }

    private ProposalProcessor createProposalWithSomeBusinessLogic(
        Configuration configuration) {
        var proposalProcessor = makeSomeDecisionsBasedOn(configuration);
        var now = LocalDate.now();
        if (now.getMonth().equals(Month.DECEMBER)) {
            var dayOfMonth = now.getDayOfMonth();
            if (dayOfMonth > 20) {
                return proposal -> "REJECTED";
            }
        }
        return proposalProcessor;
    }

    private ProposalProcessor makeSomeDecisionsBasedOn(Configuration configuration) {
        if (configuration.type().equals("CREDIT_SCORE")) {
            return new CreditScoreProcessor();
        }
        return proposal -> "NO_DECISION";
    }

    private Configuration fetchConfigurationFromDatabase() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return configurationProvider.provideConfiguration();
    }
}
