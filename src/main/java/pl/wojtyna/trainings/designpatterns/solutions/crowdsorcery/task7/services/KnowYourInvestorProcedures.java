package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.ScreeningResult;

public class KnowYourInvestorProcedures {

    private final ScreeningProcess screeningProcess;

    public KnowYourInvestorProcedures(ScreeningProcess screeningProcess) {this.screeningProcess = screeningProcess;}

    public ScreeningResult screen(Investor investor) {
        return screeningProcess.verify(investor);
    }

}
