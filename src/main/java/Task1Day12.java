import Helpers.InputHelper;

import java.io.IOException;

public class Task1Day12 {
  public static void main(String[] args) throws IOException {
    System.out.println("Enter now");
    String now = InputHelper.getStr();
    System.out.println("Enter future");
    String future = InputHelper.getStr();

    System.out.println(timeDifference(now, future));

  }
  private static String timeDifference(String now, String future){
    int[] nowInt = new int[2];
    int[] futureInt = new int[2];
    int[] result = new int[2];
    String[] nowArray = now.split(":");
    String[] futureArray = future.split(":");
    System.out.println("Result:");
    for (int i = 0; i < nowInt.length; i++) {
      nowInt[i] = Integer.parseInt(nowArray[i]);
      futureInt[i] = Integer.parseInt(futureArray[i]);
      result[i] = futureInt[i] - nowInt[i];
    }
    if (result[1] < 0) {
      result[1] += 60;
    }
    if (result[0] < 10 && result[1] < 10) {
      return ("0" + result[0] + ":" + "0" + result[1]);
    } else if (result[1] < 10) {
      return (result[0] + ":" + "0" + result[1]);
    } else if (result[0] < 10) return ("0" + result[0] + ":" + result[1]);
    return "";
  }
}

/*
Итак, сегодня пишем помощника для часов. А по факту функциу, которая на вход получает две строки. Обе строки в формате  "23:11" и означают текущее время в часах и минутах. Формат времени 24-часово.
Значение часов варьируется от 00 до 23. Значение минут - от 00 до 59.

Первая строка показывает текущее время, а вторая - какое-то будущее время. Задача помощника - вернуть строку в том же формате, подсказывающую сколько часов и минут осталось до указанного времени.

Например:

На вход пришли строки "01:30" и  "22:45". Функция вернет строку "21:15" - то есть между половиной второго и без пятнадцати минут одиннадцать ровно 21 час и 15 минут.
На вход пришли строки "05:30" и "05:35". Функция вернет "00:05".

Гарантируется, что:

- строки всегда приходят в правильном формате, количество часов в правильных пределах, минут - тоже.
- вторая строка всегда означает будущее время, то есть количество либо минут, либо часов там больше.
 */