package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task5.services;

import pl.wojtyna.trainings.designpatterns.annotations.AbstractFactoryPattern;

@AbstractFactoryPattern
public interface ProposalProcessors {

    ProposalProcessor chooseTheRightProcessor();
}
