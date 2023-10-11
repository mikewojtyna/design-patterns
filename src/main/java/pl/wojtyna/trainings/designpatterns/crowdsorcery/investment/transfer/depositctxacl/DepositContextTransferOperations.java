package pl.wojtyna.trainings.designpatterns.crowdsorcery.investment.transfer.depositctxacl;

import org.joda.money.Money;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.api.usecases.TransferUseCase;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.deposit.domain.account.AccountId;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.investment.transfer.Account;
import pl.wojtyna.trainings.designpatterns.crowdsorcery.investment.transfer.TransferOperations;

import java.util.UUID;

public class DepositContextTransferOperations implements TransferOperations {

    private final TransferUseCase transferUseCase;

    public DepositContextTransferOperations(TransferUseCase transferUseCase) {this.transferUseCase = transferUseCase;}

    @Override
    public void transfer(Account from, Account to, Money amount) {
        transferUseCase.transfer(translate(from), translate(to), amount);
    }

    private AccountId translate(Account account) {
        return new AccountId(UUID.fromString(account.id()));
    }
}
