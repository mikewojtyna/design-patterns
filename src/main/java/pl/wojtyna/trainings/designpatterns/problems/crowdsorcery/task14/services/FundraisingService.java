package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task14.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task14.domain.Project;

public class FundraisingService {

    private final InvestorAndBorrowerFinder investorAndBorrowerFinder;
    private final MailAddressFinder mailAddressFinder;
    private final MailNotifications mailNotifications;
    private final SlackNotifications slackNotifications;
    private final MarketingProcess marketingProcess;

    public FundraisingService(InvestorAndBorrowerFinder investorAndBorrowerFinder,
                              MailAddressFinder mailAddressFinder,
                              MailNotifications mailNotifications,
                              SlackNotifications slackNotifications,
                              MarketingProcess marketingProcess) {
        this.investorAndBorrowerFinder = investorAndBorrowerFinder;
        this.mailAddressFinder = mailAddressFinder;
        this.mailNotifications = mailNotifications;
        this.slackNotifications = slackNotifications;
        this.marketingProcess = marketingProcess;
    }

    public Project createProposalDraft(String title,
                                       String description,
                                       Money goal,
                                       String loanSchedule,
                                       double interestRate,
                                       int creditScore) {
        return new Project(title, description, goal, loanSchedule, interestRate, creditScore, "DRAFT", false);
    }

    public void proposeProject(Project project) {
        if ("DRAFT".equals(project.status())) {
            project.setStatus("PENDING");
            project.setProposal(true);
            var borrower = investorAndBorrowerFinder.findBorrowerByName(project.getBorrower());
            mailNotifications.sendMail(mailAddressFinder.findMailAddress(borrower),
                                       "Your draft has been proposed",
                                       " Your draft has been proposed. Congratulations!");
            slackNotifications.sendSlackMessage("Your draft has been proposed. Congratulations!");
        }
    }

    public void rejectProposal(Project project) {
        if (project.isProposal()) {
            var borrower = investorAndBorrowerFinder.findBorrowerByName(project.getBorrower());
            mailNotifications.sendMail(mailAddressFinder.findMailAddress(borrower),
                                       "Your proposal has been rejected",
                                       " Your proposal has been rejected. Sorry!");
            slackNotifications.sendSlackMessage("Your proposal has been rejected. Sorry!");
            project.setStatus("REJECTED");
        }
    }

    public void acceptProposal(Project project) {
        if (project.isProposal()) {
            project.setStatus("ACCEPTED");
            project.setProposal(false);
            project.setProject(true);
            var borrower = investorAndBorrowerFinder.findBorrowerByName(project.getBorrower());
            mailNotifications.sendMail(mailAddressFinder.findMailAddress(borrower),
                                       "Your proposal has been accepted",
                                       " Your proposal has been accepted. Congratulations!");
            slackNotifications.sendSlackMessage("Your proposal has been accepted. Congratulations!");
        }
    }

    public void startFundraising(Project project) {
        if ("ACCEPTED".equals(project.status())) {
            var borrower = investorAndBorrowerFinder.findBorrowerByName(project.getBorrower());
            mailNotifications.sendMail(mailAddressFinder.findMailAddress(borrower),
                                       "The fundraising has started",
                                       " The fundraising has started. Congratulations!");
            slackNotifications.sendSlackMessage("The fundraising has started. Congratulations!");
            marketingProcess.beginCampaign("Campaign name", project);
            project.setStatus("FUNDRAISING");
        }
    }

}
