package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.services;

import org.springframework.scheduling.annotation.Scheduled;
import pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.domain.Project;

import java.util.concurrent.TimeUnit;

public class DefaultHandlingService {

    public void handleDefaultOf(Project project) {
        initiateRecoveryProcedure(project);
    }

    public boolean isDefaulted(Project project) {
        throw new UnsupportedOperationException("Implement this method");
    }

    public void markAsDefaulted(Project project) {
        throw new UnsupportedOperationException("Implement this method");
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.DAYS)
    public void checkIfDefaultedAccordingToRules(Project project) {
        if (check(project)) {
            markAsDefaulted(project);
        }
    }

    private void initiateRecoveryProcedure(Project project) {

    }

    private boolean check(Project project) {
        return false;
    }
}
