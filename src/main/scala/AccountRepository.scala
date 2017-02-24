import scala.collection.mutable.ListBuffer

/**
  * Created by jordifr on 21/2/17.
  */
class AccountRepository {

  val transactions = ListBuffer[Transaction]()

  def getTransactions = transactions.toList

  def save(transaction: Transaction): Unit = transactions += transaction

}
