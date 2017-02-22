import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

/**
  * Created by jordifr on 21/2/17.
  */
class AccountServiceFeature extends FlatSpec with MockFactory  {

  "an account" must "print transactions in chronological reverse order" in {
    val accountService = new AccountService()
    val console = mock[Console]

    accountService.deposit(1000)
    accountService.withdraw(100)
    accountService.deposit(500)

    (console.printLine _) expects ("DATE | AMOUNT | BALANCE")
    (console.printLine _) expects ("10/04/2014 | 500.00 | 1400.00")
    (console.printLine _) expects ("02/04/2014 | -100.00 | 900.00")
    (console.printLine _) expects ("01/04/2014 | 1000.00 | 1000.00")

  }

}
