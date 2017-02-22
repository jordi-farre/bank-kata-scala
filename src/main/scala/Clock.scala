import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
  * Created by jordifr on 21/2/17.
  */
class Clock {

  def today() = this.getLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))

  def getLocalDate() = LocalDate.now()

}
