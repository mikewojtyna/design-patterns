package pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.api.usecases;

import org.jmolecules.architecture.hexagonal.PrimaryPort;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEventPublisher;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.common.domain.DomainEvents;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.AccountRepository;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.DepositAccount;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.Deposits;

@PrimaryPort
public class CreateAccountUseCase {

    private final AccountRepository accountRepository;
    private final Deposits deposits;
    private final DomainEventPublisher eventPublisher;

    public CreateAccountUseCase(AccountRepository accountRepository,
                                Deposits deposits,
                                DomainEventPublisher eventPublisher) {
        this.accountRepository = accountRepository;
        this.deposits = deposits;
        this.eventPublisher = eventPublisher;
    }

    public void createAccount() {
        accountRepository.save(extractInstance(newAccount()));
    }

    private DepositAccount extractInstance(DomainEvents domainEvents) {
        return null;
    }

    private DomainEvents newAccount() {
        DomainEvents events = deposits.openNewAccount();
        eventPublisher.publish(events);
        return events;
    }
}
