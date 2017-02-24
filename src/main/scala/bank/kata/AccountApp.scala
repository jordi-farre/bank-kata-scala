package bank.kata

/**
  * Created by jordifr on 24/2/17.
  */
object AccountApp extends App {

  val accountRepository = new AccountRepository()
  val clock = new Clock()
  val console = new Console()
  val statementPrinter = new StatementPrinter(console)
  val accountService = new AccountService(accountRepository = accountRepository, clock = clock, statementPrinter = statementPrinter)

  accountService.deposit(1000)
  accountService.withdraw(100)
  accountService.deposit(500)
  accountService.printStatement()

}
