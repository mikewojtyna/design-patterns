package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task2.services.BorrowersRegistry;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task2.services.BorrowersRegistryEnum;
import pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task2.services.BorrowersRegistrySynchronizedMethodSingleton;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class BorrowersRegistrySingletonTest {

    @DisplayName("double-checked locking")
    @Test
    void instanceIsTheSameForEveryThreadUsingDoubleCheckedLocking() {
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

    @DisplayName("enum")
    @Test
    void instanceIsTheSameForEveryThreadUsingEnum() {
        try (var executor = Executors.newThreadPerTaskExecutor(Thread::new)) {
            var borrowersRegistries = IntStream.range(0, 1000)
                                               .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                                                   System.out.println("Thread id: " + Thread.currentThread()
                                                                                            .threadId());
                                                   return BorrowersRegistryEnum.INSTANCE;
                                               }, executor))
                                               .map(CompletableFuture::join).toList();
            assertThat(borrowersRegistries).hasSize(1000)
                                           .allSatisfy(borrowersRegistry -> assertThat(borrowersRegistry).isSameAs(
                                               borrowersRegistries.get(0)));
        }
    }

    @DisplayName("synchronized method")
    @Test
    void instanceIsTheSameForEveryThreadUsingSynchronizedMethod() {
        try (var executor = Executors.newThreadPerTaskExecutor(Thread::new)) {
            var borrowersRegistries = IntStream.range(0, 1000)
                                               .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                                                   System.out.println("Thread id: " + Thread.currentThread()
                                                                                            .threadId());
                                                   return BorrowersRegistrySynchronizedMethodSingleton.create();
                                               }, executor))
                                               .map(CompletableFuture::join).toList();
            assertThat(borrowersRegistries).hasSize(1000)
                                           .allSatisfy(borrowersRegistry -> assertThat(borrowersRegistry).isSameAs(
                                               borrowersRegistries.get(0)));
        }
    }
}
