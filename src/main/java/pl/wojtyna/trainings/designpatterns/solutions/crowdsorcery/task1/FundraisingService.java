package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task1;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.domain.*;

public interface FundraisingService {

    ProposalDraft createProposalDraft(ProposalDraftData proposalDraftData);

    Proposal proposeProject(ProposalDraft proposalDraft);

    AcceptedProposal acceptProposalForVerification(Proposal proposal);

    AcceptedProposal acceptProposal(Proposal proposal);

    RejectedProposal rejectProposal(Proposal proposal);

    Fundraising startFundraising(Proposal proposal);

    void cancelProjectFundraising(Fundraising fundraising);

    void depositInto(Fundraising fundraising);

    Project releaseFundsFor(Fundraising fundraising);
}
