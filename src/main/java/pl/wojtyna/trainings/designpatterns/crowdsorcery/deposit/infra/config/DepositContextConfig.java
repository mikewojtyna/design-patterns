package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEventPublisher;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.api.usecases.CreateAccountUseCase;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.api.usecases.WithdrawUseCase;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.*;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.payment.DepositInitiatedPolicy;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.payment.PaymentProcessor;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.infra.event.LocalEventsHandler;

import java.util.Optional;

@Configuration
public class DepositContextConfig {

    @Bean
    public Deposits deposits() {
        return () -> null;
    }

    @Bean
    public CreateAccountUseCase createAccountUseCase(AccountRepository accountRepository, Deposits deposits,
                                                     DomainEventPublisher eventPublisher) {
        return new CreateAccountUseCase(accountRepository, deposits, eventPublisher);
    }

    @Bean
    public PaymentVerifiedPolicy paymentVerifiedPolicy(AccountRepository accountRepository,
                                                       DomainEventPublisher eventPublisher) {
        return new PaymentVerifiedPolicy(accountRepository, eventPublisher);
    }

    @Bean
    public LocalEventsHandler localEventsHandler(DepositInitiatedPolicy depositInitiatedPolicy,
                                                 PaymentVerifiedPolicy paymentVerifiedPolicy) {
        return new LocalEventsHandler(depositInitiatedPolicy, paymentVerifiedPolicy);
    }

    @Bean
    public DepositInitiatedPolicy depositInitiatedPolicy(PaymentProcessor paymentProcessor) {
        return new DepositInitiatedPolicy(paymentProcessor);
    }

    @Bean
    public AccountRepository accountRepository() {
        return new AccountRepository() {
            @Override
            public Optional<DepositAccount> load(AccountId id) {
                return Optional.empty();
            }

            @Override
            public void save(DepositAccount account) {

            }
        };
    }

    @Bean
    public WithdrawUseCase withdrawUseCase(AccountRepository accountRepository, DomainEventPublisher eventPublisher) {
        return new WithdrawUseCase(accountRepository, eventPublisher);
    }
}
