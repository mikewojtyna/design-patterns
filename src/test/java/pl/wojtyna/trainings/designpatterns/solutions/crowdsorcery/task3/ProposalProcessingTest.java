package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task3;

import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task3.domain.Project;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task3.services.FundraisingService;

import static org.assertj.core.api.Assertions.assertThat;

class ProposalProcessingTest {

    @Test
    void accepted() {
        // given
        FundraisingService fundraisingService = new FundraisingService();
        var proposal = new Project();
        proposal.setProposal(true);
        proposal.setProject(false);
        proposal.setStatus("PENDING");

        // when
        fundraisingService.processProposal(proposal, project -> "ACCEPTED");

        // then
        assertThat(proposal.getStatus()).isEqualTo("ACCEPTED");
        assertThat(proposal.isProposal()).isFalse();
        assertThat(proposal.isProject()).isTrue();
    }

    @Test
    void noDecision() {
        // given
        FundraisingService fundraisingService = new FundraisingService();
        var proposal = new Project();
        proposal.setProposal(true);
        proposal.setProject(false);
        proposal.setStatus("PENDING");

        // when
        fundraisingService.processProposal(proposal, project -> "NO_DECISION");

        // then
        assertThat(proposal.getStatus()).isEqualTo("PENDING");
        assertThat(proposal.isProposal()).isTrue();
        assertThat(proposal.isProject()).isFalse();
    }

    @Test
    void rejectedBecauseTooManyProposals() {
        // given
        var fundraisingService = new FundraisingService();
        var proposal = new Project();
        proposal.setProposal(true);
        proposal.setProject(false);
        proposal.setStatus("PENDING");

        // when
        for (int i = 0; i < 1000; i++) {
            processProposalUsingAlwaysAcceptingStrategy(fundraisingService, proposal);
        }

        // then
        fundraisingService.processProposal(proposal, project -> "ACCEPTED");
        assertThat(proposal.status()).isEqualTo("REJECTED");
    }

    private void processProposalUsingAlwaysAcceptingStrategy(FundraisingService fundraisingService, Project proposal) {
        // when
        fundraisingService.processProposal(proposal, project -> "ACCEPTED");

        // then
        assertThat(proposal.getStatus()).isEqualTo("ACCEPTED");
        assertThat(proposal.isProposal()).isFalse();
        assertThat(proposal.isProject()).isTrue();
    }
}
