package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task1;

public interface FundraisingServiceContract {

    void createProposalDraft();

    void proposeProject();

    void acceptProposalForVerification();

    void acceptProposal();

    void rejectProposal();

    void startFundraising();

    void cancelProjectFundraising();

    void depositInto();

    void releaseFundsFor();
}
