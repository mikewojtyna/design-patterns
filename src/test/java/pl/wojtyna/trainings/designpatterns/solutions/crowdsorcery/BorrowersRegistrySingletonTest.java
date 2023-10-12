package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery;

import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.services.BorrowersRegistry;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class BorrowersRegistrySingletonTest {

    @Test
    void instanceIsTheSameForEveryThread() {
        try (var executor = Executors.newThreadPerTaskExecutor(Thread::new)) {
            var borrowersRegistries = IntStream.range(0, 1000)
                                               .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                                                   System.out.println("Thread id: " + Thread.currentThread()
                                                                                            .threadId());
                                                   return BorrowersRegistry.create();
                                               }, executor))
                                               .map(CompletableFuture::join).toList();
            assertThat(borrowersRegistries).hasSize(1000)
                                           .allSatisfy(borrowersRegistry -> assertThat(borrowersRegistry).isSameAs(
                                               borrowersRegistries.get(0)));
        }
    }
}
