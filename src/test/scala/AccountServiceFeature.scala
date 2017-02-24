import org.mockito.{InOrder, Mockito}
import org.scalatest.FlatSpec
import org.scalatest.mockito.MockitoSugar

/**
  * Created by jordifr on 21/2/17.
  */
class AccountServiceFeature extends FlatSpec with MockitoSugar  {

  "an account" must "print transactions in chronological reverse order" in {
    val accountRepository = new AccountRepository()
    val clock = mock[Clock]
    val console = mock[Console]
    val statementPrinter = new StatementPrinter(console)
    val accountService = new AccountService(accountRepository = accountRepository, clock = clock, statementPrinter = statementPrinter)

    Mockito.when(clock.today()).thenReturn("01/04/2014", "02/04/2014", "10/04/2014")

    accountService.deposit(1000)
    accountService.withdraw(100)
    accountService.deposit(500)
    accountService.printStatement()

    val inOrder: InOrder = Mockito.inOrder(console)
    inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE")
    inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00")
    inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00")
    inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00")

  }

}
