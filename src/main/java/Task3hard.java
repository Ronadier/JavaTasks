import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3hard {
  public static void main(String[] args) throws IOException {

    String str = getStr();
    int maxAmount = getInt();
    generateAndPrintJSON(str,maxAmount);
  }

  private static String getStr() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String str = "";
    while (str.length() == 0) {
      System.out.println("Введите строку");
      str = reader.readLine();
      if (str.length() == 0) System.out.println("Вы ввели пустую строку, введите строку ещё раз");
    }
    return str;
  }

  private static int getInt() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int maxAmount = 0;
    while (maxAmount <= 0) {
      System.out.println("Введите число:");
      maxAmount = Integer.parseInt(reader.readLine());
      if (maxAmount <= 0 ) System.out.println("Вы ввели число меньше нуля или ноль. Введите число ещё раз");
    }
    return maxAmount;
  }

  private static Map<String, Integer> getWordsAndAmount(String str, int maxAmount){
    String a = str.toLowerCase().trim();
    String[] subStr;
    subStr = a.split("(?U)\\W+"); //разбиваем на слова. W+ - регулярное выражение для всех знаков препинания, пробелов и пр., (?U) для поддержки юникода
    int[] c = new int[subStr.length];
    Map<String, Integer> result = new HashMap<String, Integer>();
    for (int i =0;i<subStr.length;i++) {
      for (int j=i;j<subStr.length;j++){
       if (subStr[i].equals(subStr[j])) c[i]++;
      }
    }
    for (int i=0;i<c.length;i++){
      if (c[i]>maxAmount) result.put(subStr[i],c[i]);
    }
    return result;
  }
  private static void generateAndPrintJSON(String str, int maxAmount){
    // convert Java to json
    JSONObject root = new JSONObject(); // создаем главный объект JSON
    HashMap<String, Integer> a = (HashMap<String, Integer>) getWordsAndAmount(str, maxAmount);
    a.forEach((k, v) -> root.put(k,v)); //кладём мапу в JSON
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