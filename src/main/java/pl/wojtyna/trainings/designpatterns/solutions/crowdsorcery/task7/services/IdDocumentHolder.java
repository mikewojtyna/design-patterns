package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.services;

import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task7.domain.IdDocument;

public class IdDocumentHolder {

    private static final ThreadLocal<IdDocument> threadLocal = new ThreadLocal<>();

    public static void set(IdDocument idDocument) {
        threadLocal.set(idDocument);
    }

    public static IdDocument get() {
        return threadLocal.get();
    }
}
