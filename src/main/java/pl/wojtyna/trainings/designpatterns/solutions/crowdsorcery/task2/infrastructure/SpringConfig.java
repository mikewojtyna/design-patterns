package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task2.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public BorrowersRegistryFactory borrowersRegistryFactory() {
        return new BorrowersRegistryFactory();
    }
}
