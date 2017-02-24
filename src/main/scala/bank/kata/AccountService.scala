package bank.kata

/**
  * Created by jordifr on 21/2/17.
  */
class AccountService(accountRepository: AccountRepository, clock: Clock, statementPrinter: StatementPrinter) {

  def printStatement(): Unit = this.statementPrinter.print(this.accountRepository.getTransactions)

  def withdraw(amount: Int): Unit = this.accountRepository.save(Transaction(date = clock.today(), amount = amount * -1))

  def deposit(amount: Int):Unit = this.accountRepository.save(Transaction(date = clock.today(), amount = amount))

}
