import Helpers.InputHelper;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

public class Task3hard {
  public static void main(String[] args) throws IOException {

    String str = InputHelper.getStr();
    int maxAmount = InputHelper.getInt();
    generateAndPrintJSON(str,maxAmount);
  }


  private static HashMap<String, Integer> getWordsAndAmount(String str, int maxAmount){
    String a = str.toLowerCase().trim();
    List<String> subStr = new ArrayList<>();
    subStr = Arrays.asList(a.split("(?U)\\W+")); //разбиваем на слова. W+ - регулярное выражение для всех знаков препинания, пробелов и пр., (?U) для поддержки юникода
    HashMap<String, Integer> result = new HashMap<>();
    for (String s : subStr ){
      if (Collections.frequency(subStr, s) > maxAmount) {
        result.put(s, Collections.frequency(subStr, s));
      }
    }

    return result;
  }
  private static void generateAndPrintJSON(String str, int maxAmount){
    // convert Java to json
    JSONObject root = new JSONObject(); // создаем главный объект JSON
    HashMap<String, Integer> a = getWordsAndAmount(str, maxAmount);
    a.forEach(root::put); //кладём мапу в JSON, можно так же записать a.forEach((k, v) -> root.put(k,v))
    String json = root.toString();
    System.out.println(json);
  }

}

/*
Сегодня задача №2 не связана с первой задачей. Сегодня мы напишем функцию, которая снова на вход получает текст и ищет в нем слова паразиты. Словами-паразитами называются слова, которые встречаются в тексте >= N раз, где N - целочисленный параметр, который передается вторым параметром в функцию.

Несколько правил:
- Словом считается любой набор символов, обособленный слева и справа пробелами ИЛИ началом/концом строки.
- Слова с разным регистром считаются одним и тем же словом. То есть предлог "под", который мы можем встретить в середине предложения и "Под" - в начале предложения - одно и то же слово.
- Знаки препинания не учитываются. То есть "привет." и "привет" - это одно и то же слово.

Гарантируется, что текст будет только на русском или английском языках.

Результат вернуть JSON'ом, где ключи - слова-паразиты, а значение - количество раз, которое оно встречается.

Пример:

Дано:

text: "Ну что ж я, я найти решения правильного не смогу ж? Смогу ж конечно, я ж старательный все ж таки."
max_amount: 3

Ответ:

{
"я":3,
"ж":5
}
 */