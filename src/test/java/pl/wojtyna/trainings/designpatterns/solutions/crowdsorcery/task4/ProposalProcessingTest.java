package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task4;

import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task4.domain.Project;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task4.services.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProposalProcessingTest {

    @Test
    void interestRateProcessor() {
        // given
        FundraisingService fundraisingService = new FundraisingService();
        var proposal = new Project();
        proposal.setProposal(true);
        proposal.setProject(false);
        proposal.setStatus("PENDING");
        proposal.setInterestRate(0.1);

        // when
        fundraisingService.processProposal(proposal, new InterestRateProcessor(0.3));

        // then
        assertThat(proposal.getStatus()).isEqualTo("PENDING");

        // given
        var anotherProposal = new Project();
        anotherProposal.setProposal(true);
        anotherProposal.setProject(false);
        anotherProposal.setStatus("PENDING");
        anotherProposal.setInterestRate(0.4);

        // when
        fundraisingService.processProposal(anotherProposal, new InterestRateProcessor(0.3));

        // then
        assertThat(anotherProposal.getStatus()).isEqualTo("VERIFICATION_REQUIRED");
    }

    @Test
    void goalProcessor() {
        // given
        FundraisingService fundraisingService = new FundraisingService();
        var proposal = new Project();
        proposal.setProposal(true);
        proposal.setProject(false);
        proposal.setStatus("PENDING");
        proposal.setGoal(Money.parse("USD 99999"));

        // when
        fundraisingService.processProposal(proposal, new GoalProcessor());

        // then
        assertThat(proposal.getStatus()).isEqualTo("ACCEPTED");

        // given
        var anotherProposal = new Project();
        anotherProposal.setProposal(true);
        anotherProposal.setProject(false);
        anotherProposal.setStatus("PENDING");
        anotherProposal.setGoal(Money.parse("USD 100000"));

        // when
        fundraisingService.processProposal(anotherProposal, new GoalProcessor());

        // then
        assertThat(anotherProposal.getStatus()).isEqualTo("REJECTED");
    }

    @Test
    void keywordsProcessor() {
        // since processors are independent of fundraising service, we can also easily test them in isolation
        // given
        var proposal = new Project();
        proposal.setDescription("This project is all about AI");
        var top3KeywordsProvider = new Top3KeywordsProvider() {

            @Override
            public String first() {
                return "AI";
            }

            @Override
            public String second() {
                return "blockchain";
            }

            @Override
            public String third() {
                return "multiverse";
            }
        };
        var keywordsProcessor = new KeywordsProcessor(top3KeywordsProvider);

        // when
        var decision = keywordsProcessor.process(proposal);

        // then
        assertThat(decision).isEqualTo("ACCEPTED");

        // given
        var anotherProposal = new Project();
        anotherProposal.setDescription("Let's expose MongoDb as REST API!");

        // when
        var anotherDecision = keywordsProcessor.process(anotherProposal);

        // then
        assertThat(anotherDecision).isEqualTo("NO_DECISION");
    }

    @Test
    void compositeProcessor() {
        // given
        FundraisingService fundraisingService = new FundraisingService();
        var proposal = new Project();
        proposal.setProposal(true);
        proposal.setProject(false);
        proposal.setStatus("PENDING");
        proposal.setGoal(Money.parse("USD 100"));
        proposal.setCreditScore(150);
        ProposalProcessor compositeProcessor = new CompositeProcessor(List.of(new GoalProcessor(),
                                                                              new CreditScoreProcessor()));

        // when
        fundraisingService.processProposal(proposal, compositeProcessor);

        // then
        assertThat(proposal.getStatus()).isEqualTo("ACCEPTED");

        // given
        var anotherProposal = new Project();
        anotherProposal.setProposal(true);
        anotherProposal.setProject(false);
        anotherProposal.setStatus("PENDING");
        anotherProposal.setGoal(Money.parse("USD 100"));
        anotherProposal.setCreditScore(100);
        ProposalProcessor anotherCompositeProcessor = new CompositeProcessor(List.of(new GoalProcessor(),
                                                                                     new CreditScoreProcessor()));

        // when
        fundraisingService.processProposal(anotherProposal, anotherCompositeProcessor);

        // then
        assertThat(anotherProposal.getStatus()).isEqualTo("PENDING");
    }

}
