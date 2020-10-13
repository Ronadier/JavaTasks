import java.io.IOException;
import java.time.LocalTime;

public class Task1 {
  public static void main(String[] args) throws IOException {
    //задаём значения для проверки
    LocalTime zeroOClock = LocalTime.of(0, 0);
    LocalTime fourOClock = LocalTime.of(4, 59);
    LocalTime fiveOClock = LocalTime.of(5, 0);
    LocalTime nineOClock = LocalTime.of(9, 59);
    LocalTime tenOClock = LocalTime.of(10, 0);
    LocalTime sixteenOClock = LocalTime.of(16, 59);
    LocalTime seventeenOClock = LocalTime.of(17, 0);
    LocalTime twentyThreeOClock = LocalTime.of(23, 59);
    //Текущее время с компьютера
    LocalTime now = LocalTime.now();
    System.out.println("По часам компьютера сейчас: " + now);
    //проверяем часы с компьютера
    if (now.isAfter(zeroOClock) && now.isBefore(fourOClock)) System.out.println("Доброй ночи, Костег!");
    else if (now.isAfter(fiveOClock)&& now.isBefore(nineOClock)) System.out.println("Доброе утро, Костег!");
    else if (now.isAfter(tenOClock) && now.isBefore(sixteenOClock)) System.out.println("Добрый день, Костег!");
    else if (now.isAfter(seventeenOClock) && now.isBefore(twentyThreeOClock)) System.out.println("Добрый вечер, Костег!");

  }
}
