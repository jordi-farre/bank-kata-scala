import org.mockito.Mockito
import org.mockito.Mockito._
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec
import org.scalatest.mockito.MockitoSugar

/**
  * Created by jordifr on 21/2/17.
  */
class AccountServiceShould extends FlatSpec with MockitoSugar {

  val accountRepository = mock[AccountRepository]
  val clock = mock[Clock]
  val accountService = new AccountService(accountRepository = accountRepository, clock = clock);
  val DEPOSIT_TRANSACTION = new Transaction(date = "20/01/2017", amount = 1000)
  val WITHDRAW_TRANSACTION = new Transaction(date = "20/01/2017", amount = -1000)

  "deposit" should "add a positive transaction" in {
    when(this.clock.today()).thenReturn(this.DEPOSIT_TRANSACTION.date)
    doNothing().when(this.accountRepository).save(this.DEPOSIT_TRANSACTION)

    accountService.deposit(1000);

    verify(this.clock).today()
    verify(this.accountRepository).save(this.DEPOSIT_TRANSACTION)

  }

  "withdraw" should "add a negative transaction" in {
    when(this.clock.today()).thenReturn(this.WITHDRAW_TRANSACTION.date)
    doNothing().when(this.accountRepository).save(this.WITHDRAW_TRANSACTION)

    accountService.withdraw(1000);

    verify(this.clock).today()
    verify(this.accountRepository).save(this.WITHDRAW_TRANSACTION)

  }

}
