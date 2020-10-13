import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalTime;

public class Task1hard {
  public static void main(String[] args) throws IOException {
    LocalTime zeroOClock = LocalTime.of(0, 0);
    LocalTime fourOClock = LocalTime.of(4, 59);
    LocalTime fiveOClock = LocalTime.of(5, 0);
    LocalTime nineOClock = LocalTime.of(9, 59);
    LocalTime tenOClock = LocalTime.of(10, 0);
    LocalTime sixteenOClock = LocalTime.of(16, 59);
    LocalTime seventeenOClock = LocalTime.of(17, 0);
    LocalTime twentyThreeOClock = LocalTime.of(23, 59);

    String url = "http://worldtimeapi.org/api/timezone/Europe/Moscow";
    URL obj = new URL(url);
    HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
    connection.setRequestMethod("GET");
    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();
    //Разделим ответ на строки, потом из них получим строку времени
    String[] subStr;
    String delimeter = ","; // Разделитель
    subStr = response.toString().split(delimeter);
    String[] words = subStr[2].split("T"); // Разбиение строки на слова с помощью разграничителя "T"
    String[] currTimeAPIStr = words[1].split("\\+"); // получаем строку времени, индекс 0
    LocalTime nowAPI = LocalTime.parse(currTimeAPIStr[0]);

    System.out.println("По часам с сервера сейчас: " + nowAPI);

    if (nowAPI.isAfter(zeroOClock) && nowAPI.isBefore(fourOClock)) System.out.println("Доброй ночи, Костег!");
    else if (nowAPI.isAfter(fiveOClock)&& nowAPI.isBefore(nineOClock)) System.out.println("Доброе утро, Костег!");
    else if (nowAPI.isAfter(tenOClock) && nowAPI.isBefore(sixteenOClock)) System.out.println("Добрый день, Костег!");
    else if (nowAPI.isAfter(seventeenOClock) && nowAPI.isBefore(twentyThreeOClock)) System.out.println("Добрый вечер, Костег!");
  }
}
