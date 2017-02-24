package bank.kata

import java.time.LocalDate

import org.scalatest.FlatSpec

/**
  * Created by jordifr on 22/2/17.
  */
class ClockShould extends FlatSpec {

  val DATE = "27/10/2016"

  "clock" should "return date in dd/MM/yyyy format" in {
    val clock = new ClockTest();

    assert(clock.today() == DATE)
  }

  class ClockTest extends Clock {

    override def getLocalDate() = LocalDate.of(2016, 10, 27)

  }

}
