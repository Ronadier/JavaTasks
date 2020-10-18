import Helpers.InputHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
  public static void main(String[] args) throws IOException {
    List<String> str = InputHelper.getListStr();

    printResult(str);
  }

  private static void printResult(List<String> str){
    List<String> result = new ArrayList<>();


    for (int i = 0; i<str.size();i++){
      String[] words = str.get(i).split("\\s");
      for (int j =0;j< words.length;j++){
        result.add(words[j]);
      }
    }
    result.forEach(System.out::println);
  }
}


/*
Сегодня поработаем с массивами. Давайте напишем функцию, которая на вход получает массив слов. Например:

["apple banana", "orange", "banana", "kiwi strawberry blueberry"]

Видно, что в этом массиве в некоторых слотах затесалось сразу несколько слов. На выходе функция должна вернуть такой массив, где одно слово будет в каждом элементе:

["apple", "banana", "orange", "banana", "kiwi", "strawberry", "blueberry"]

Словом считается любой набор символов, обособленный пробелами или началом/концом строки.


 */