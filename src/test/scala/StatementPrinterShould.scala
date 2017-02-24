import org.mockito.Mockito._
import org.mockito.{InOrder, Mockito}
import org.scalatest.FlatSpec
import org.scalatest.mockito.MockitoSugar

/**
  * Created by jordifr on 24/2/17.
  */
class StatementPrinterShould extends FlatSpec with MockitoSugar {

  val console = mock[Console]

  val statementPrinter = new StatementPrinter(console)

  "an empty list of transactions" should "print only header" in {
    statementPrinter.print(List())

    verify(this.console).printLine("DATE | AMOUNT | BALANCE")
  }

  "a list with multiple transactions" should "print header and transaction detail in reverse order" in {
    val transactions = List(Transaction("01/04/2014", 1000), Transaction("02/04/2014", -100), Transaction("10/04/2014", 500))

    statementPrinter.print(transactions)

    val inOrder: InOrder = Mockito.inOrder(console)
    inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE")
    inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00")
    inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00")
    inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00")
  }

}
