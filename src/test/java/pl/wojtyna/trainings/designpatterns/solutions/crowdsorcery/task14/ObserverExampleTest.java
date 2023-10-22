package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.domain.Borrower;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.listeners.MailNotifierSubscriber;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.listeners.MarketingProcessSubscriber;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.listeners.SlackNotificationsSubscriber;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.services.EventManager;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.services.FundraisingService;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.services.InvestorAndBorrowerFinder;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task14.services.MailAddressFinder;

class ObserverExampleTest {

    @Test
    void examples() {
        var eventManager = new EventManager();
        eventManager.subscribe(new MailNotifierSubscriber((mailAddress, subject, message) -> System.out.println(
            "Sending mail to " + mailAddress + " with subject " + subject + " and message " + message),
                                                          new InvestorAndBorrowerFinder(), new MailAddressFinder() {
            @Override
            public String findMailAddress(Investor investor) {
                return "somefakemailaddress@trash.com";
            }

            @Override
            public String findMailAddress(Borrower borrower) {
                return "somefakemailaddress@trash.com";
            }
        }));
        eventManager.subscribe(new SlackNotificationsSubscriber(message -> System.out.println("Sending slack message " + message)));
        eventManager.subscribe(new MarketingProcessSubscriber((campaignName, project) -> System.out.println(
            "Starting marketing campaign " + campaignName + " for project " + project)));

        var fundraisingService = new FundraisingService(eventManager);
        var project = fundraisingService.createProposalDraft("Some title",
                                                             "Some description",
                                                             Money.of(CurrencyUnit.USD, 1000),
                                                             "Some loan schedule",
                                                             0.1,
                                                             100);
        fundraisingService.proposeProject(project);
        fundraisingService.acceptProposal(project);
        fundraisingService.startFundraising(project);
    }
}
