package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.api.usecases;

import org.jmolecules.architecture.hexagonal.PrimaryPort;
import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEventPublisher;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.AccountId;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.AccountRepository;

@PrimaryPort
public class WithdrawUseCase {

    private final AccountRepository accountRepository;
    private final DomainEventPublisher eventPublisher;

    public WithdrawUseCase(AccountRepository accountRepository, DomainEventPublisher eventPublisher) {
        this.accountRepository = accountRepository;
        this.eventPublisher = eventPublisher;
    }

    public void withdraw(Money amount, AccountId id) {
        accountRepository.load(id).ifPresent(account -> {
            var events = account.withdraw(amount);
            accountRepository.save(account);
            eventPublisher.publish(events);
        });
    }
}
