import Helpers.InputHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Task1Day25 {
  public static void main(String[] args) throws IOException {
    System.out.println("Начальное");
    int from = InputHelper.getInt();
    System.out.println("Конечное");
    int to = InputHelper.getInt();
    String result = getRandomString(from, to);
    System.out.println(result);
  }

  private static String getRandomString(int from, int to) {
    Random rnd = new Random();
    ArrayList<Character> listOfChar = new ArrayList<>();
    int diff = to - from;
    int length = rnd.nextInt(diff + 1);
    length += from;
    for (int i = 0;i<length; i++) {
      listOfChar.add ((char) ('a' + rnd.nextInt(26)));
    }
    String result = "";
    for (Character ch : listOfChar){
      result += ch.toString();
    }
    return result;
  }
}

/*
Сегодня пишем генератор случайных данных. Надо написать метод, который получает на вход длину ОТ и ДО (оба параметра типа INT). Возвращает метод случайно сгенеренную строку, длина который попадает в указанный промежуток.
Гарантируется, что число ОТ будет меньше числа ДО, оба числа будут положительными.
Параметры ОТ и ДО - включительные. То есть длина строки может равнять ОТ и ДО.

Метод должен каждый раз возвращать новое значение, так что хардкодить не получится :)
 */