import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

/**
  * Created by jordifr on 22/2/17.
  */
class AccountRepositoryShould extends FlatSpec with MockFactory {

  val TRANSACTION = Transaction(date = "22/10/2016", amount = 100)

  val repository = new AccountRepository();

  "repository" should "save a transaction" in {
    repository.save(TRANSACTION)

    assert(repository.getTransactions.length == 1)
    assert(repository.getTransactions(0) == TRANSACTION)
  }

}
