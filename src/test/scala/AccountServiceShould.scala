import org.mockito.Mockito
import org.mockito.Mockito._
import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec}
import org.scalatest.mockito.MockitoSugar

/**
  * Created by jordifr on 21/2/17.
  */
class AccountServiceShould extends FlatSpec with BeforeAndAfter with MockitoSugar {

  val DEPOSIT_TRANSACTION = new Transaction(date = "20/01/2017", amount = 1000)
  val WITHDRAW_TRANSACTION = new Transaction(date = "20/01/2017", amount = -1000)
  var accountRepository = mock[AccountRepository]
  var clock = mock[Clock]
  var statementPrinter = mock[StatementPrinter]
  var accountService = new AccountService(accountRepository = accountRepository, clock = clock, statementPrinter = statementPrinter)

  before {
    this.accountRepository = mock[AccountRepository]
    this.clock = mock[Clock]
    this.statementPrinter = mock[StatementPrinter]
    this.accountService = new AccountService(accountRepository = accountRepository, clock = clock, statementPrinter = statementPrinter);
  }

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


  "print statement" should "print a list of transactions" in {
    val transactions = List(DEPOSIT_TRANSACTION)
    when(this.accountRepository.getTransactions).thenReturn(transactions)
    doNothing().when(this.statementPrinter).print(transactions)

    this.accountService.printStatement()

    verify(accountRepository).getTransactions
    verify(statementPrinter).print(transactions)
  }

}
