import Helpers.InputHelper;

import java.io.IOException;
import java.util.ArrayList;

public class Task1Day18 {
  public static void main(String[] args) throws IOException {
    int denezhka = InputHelper.getInt();
    int[] nominals = {100, 200, 500, 1000, 2000, 5000};
    ArrayList<Integer> result = new ArrayList<>();
    System.out.println("Мелкими: " + denezhka/100 + " купюр по 100р.");
    while (denezhka > 99) {
      if (denezhka >= 5000) {
        result.add(nominals[5]);
        denezhka -= 5000;
      } else if (denezhka >= 2000) {
        result.add(nominals[4]);
        denezhka -= 2000;
      } else if (denezhka >= 1000) {
        result.add(nominals[3]);
        denezhka -= 1000;
      } else if (denezhka >= 500) {
        result.add(nominals[2]);
        denezhka -= 500;
      } else if (denezhka >= 200) {
        result.add(nominals[1]);
        denezhka -= 200;
      } else {
        result.add(nominals[0]);
        denezhka -= 100;
      }
    }
    System.out.println("Крупными");
    result.forEach(System.out::println);
  }
}

/*
Сегодня пишем банкомат для Сбера. Они, хоть и айти-компания теперь, без нас-то не смогут :)

Надо написать функцию, которая получает на вход сумму, которую банкомат должен выдать. Вернуться должен массив, описывающий - в каких банкнотах мы будем выдавать денежку.
Номиналы возможны следующие - 100, 200, 500, 1000, 2000, 5000

Вторым параметром приходит тип выдачи. Существует два типа - "с разменом" и "крупными". С разменом - это когда мы выдаем минимальными валютами. Крупными - когда выдаем минимальным количеством купюр.

Гарантируется, что сумма придет кратной 100.
 */