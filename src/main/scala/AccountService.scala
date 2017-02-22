import java.text.SimpleDateFormat

/**
  * Created by jordifr on 21/2/17.
  */
class AccountService(accountRepository: AccountRepository, clock: Clock) {

  def printStatement() = throw new UnsupportedOperationException

  def withdraw(amount: Int) = this.accountRepository.save(Transaction(date = clock.today(), amount = amount * -1))

  def deposit(amount: Int) = this.accountRepository.save(Transaction(date = clock.today(), amount = amount))

}
