package pl.wojtyna.trainings.designpatterns.problems.crowdsorcery.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public BorrowersRegistryFactory borrowersRegistryFactory() {
        return new BorrowersRegistryFactory();
    }
}
