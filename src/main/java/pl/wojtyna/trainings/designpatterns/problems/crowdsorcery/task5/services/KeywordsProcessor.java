package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task5.services;

import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.task5.domain.Project;

public class KeywordsProcessor implements ProposalProcessor {

    private final Top3KeywordsProvider top3KeywordsProvider;

    public KeywordsProcessor(Top3KeywordsProvider provider) {
        this.top3KeywordsProvider = provider;
    }

    @Override
    public String process(Project proposal) {
        var description = proposal.description();
        if (description.contains(top3KeywordsProvider.first()) || description.contains(top3KeywordsProvider.second()) || description.contains(
            top3KeywordsProvider.third())) {
            return "ACCEPTED";
        }
        return "NO_DECISION";
    }
}
