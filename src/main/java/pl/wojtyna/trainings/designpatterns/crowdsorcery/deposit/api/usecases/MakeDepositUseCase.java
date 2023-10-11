package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.api.usecases;

import org.jmolecules.architecture.hexagonal.PrimaryPort;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEventPublisher;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.AccountId;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.AccountRepository;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.Deposit;

@PrimaryPort
public class MakeDepositUseCase {

    private final AccountRepository accountRepository;
    private final DomainEventPublisher eventPublisher;

    public MakeDepositUseCase(AccountRepository accountRepository, DomainEventPublisher eventPublisher) {
        this.accountRepository = accountRepository;
        this.eventPublisher = eventPublisher;
    }

    public void makeDeposit(AccountId accountId, Deposit deposit) {
        accountRepository.load(accountId).ifPresent(account -> {
            var events = account.make(deposit);
            accountRepository.save(account);
            eventPublisher.publish(events);
        });
    }
}
