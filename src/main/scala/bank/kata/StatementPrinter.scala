package bank.kata

import java.text.{DecimalFormat, DecimalFormatSymbols}
import java.util.concurrent.atomic.AtomicInteger

/**
  * Created by jordifr on 24/2/17.
  */
class StatementPrinter(console: Console) {

  def print(transactions: List[Transaction]): Unit = {
    console.printLine("DATE | AMOUNT | BALANCE")
    val sum = new AtomicInteger(0)
    transactions.map(t => {
      val total = sum.addAndGet(t.amount)
      s"${t.date} | ${formatAmount(t.amount)} | ${formatAmount(total)}"
    }).reverse.foreach(console.printLine)
  }

  def formatAmount(amount: Int): String = {
    val symbols = new DecimalFormatSymbols();
    symbols.setDecimalSeparator('.')
    val decimalFormat = new DecimalFormat("#.00", symbols)
    decimalFormat.format(amount)
  }

}
