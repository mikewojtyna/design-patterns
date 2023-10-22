package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.domain.Investor;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task10.domain.ScreeningResult;

public interface CacheManager {

    ScreeningResult getCachedResult(Investor investor);
}
