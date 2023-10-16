package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task4.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task4.domain.Project;

import java.util.List;

public class CompositeProcessor implements ProposalProcessor {

    private final List<ProposalProcessor> processors;

    public CompositeProcessor(List<ProposalProcessor> processors) {
        this.processors = processors;
    }

    @Override
    public String process(Project proposal) {
        if (processors.stream().anyMatch(processor -> processor.process(proposal).equals("REJECTED"))) {
            return "REJECTED";
        }
        if (processors.stream().filter(processor -> processor.process(proposal).equals("VERIFICATION_REQUIRED"))
                      .count() > processors.size() / 2) {
            return "VERIFICATION_REQUIRED";
        }
        if (processors.stream().allMatch(processor -> processor.process(proposal).equals("ACCEPTED"))) {
            return "ACCEPTED";
        }
        return "NO_DECISION";
    }
}
