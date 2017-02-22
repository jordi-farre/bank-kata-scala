import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

/**
  * Created by jordifr on 21/2/17.
  */
class AccountServiceShould extends FlatSpec with MockFactory {

  "deposit "should "add a positive transaction" in {
    val accountRepository = mock[AccountRepository]
    val clock = mock[Clock]
    val accountService = new AccountService(accountRepository = accountRepository, clock = clock);
    val transaction = new Transaction(date = "20/01/2017", amount = 1000)

    (clock.today _) expects () returning transaction.date
    (accountRepository.save _) expects (transaction)

    accountService.deposit(1000);

  }

  "withdraw "should "add a negative transaction" in {
    val accountRepository = mock[AccountRepository]
    val clock = mock[Clock]
    val accountService = new AccountService(accountRepository = accountRepository, clock = clock);
    val transaction = new Transaction(date = "20/01/2017", amount = -1000)

    (clock.today _) expects () returning transaction.date
    (accountRepository.save _) expects (transaction)

    accountService.withdraw(1000);

  }

}
