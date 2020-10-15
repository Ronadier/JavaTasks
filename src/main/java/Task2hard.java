import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2hard {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String str = getStr();
    int maxLength = getInt();
    List<String> bannedWords = new ArrayList<>();
    bannedWords = getBanned();

  }

  private static List<String> getBanned() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<String> str = new ArrayList<>();
    System.out.println("Вы хотите ввести запрещённое слово? (+ если да)");
    String yesOrNo = reader.readLine();
    if (!(yesOrNo.equals("+"))) return str;
    int i=0;
    do {
      System.out.println("Введите запрещённое слово");
      str.add(reader.readLine());
      if (str.get(i).length() == 0) System.out.println("Вы ввели пустую строку, введите слово ещё раз");
      System.out.println("Вы хотите ввести ещё одно слово? (+ если да)");
      yesOrNo = reader.readLine();
      if (!(yesOrNo.equals("+"))) break;
      i++;
    } while (true);
    return str;
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
    int maxLength = 0;
    while (maxLength <= 0) {
      System.out.println("Введите число:");
      maxLength = Integer.parseInt(reader.readLine());
      if (maxLength <= 0 ) System.out.println("Вы ввели число меньше нуля или ноль. Введите число ещё раз");
    }
    return maxLength;
  }

  private static int getLengthWithoutSpaces(String str){
    String[] words = str.split("\\s"); // Разбиение строки на слова с помощью разграничителя (пробел)
    int length = 0;
    for (String s : words){
      length+=s.length();
    }
    return length;
  }

  private static void generateAndPrintJSON(String str){
    // convert Java to json
    JSONObject root = new JSONObject(); // создаем главный объект
    root.put("message", "Hi");
    JSONObject place = new JSONObject(); // создаем объект Place
    place.put("name", "World!");
    root.put("place", place); // сохраняем объект Place в поле place
    String json = root.toString();
    System.out.println(json); // напечатает "{"message":"Hi","place":{"name":"World!"}}"

  }
}
/*
"Для тех, кто хочет посложнее, анализатор текста должен вести себя несколько иначе. Он должен получать на вход три параметра: анализируемый текст, максимально допустимую длину, список запрещенных слов. Результатом работы этой функции должен быть JSON, в котором будут следующие поля:

- ""length"" - длина строки
- ""pure_length"" - длина строки без учета пробелов
- ""origin_text"" - текст, полученный на входе
- ""pure_text"" - текст, в котором все запрещенные слова из списка была заменены на три звездочки
- ""pure_short_text"" - текст из pure_text, обрезанный на максимальном символе. Если этот символ не последний, надо это показать, добавив многоточие в конец.

Пример:

Дано:

text: «Не забывайте о том, что все великие волшебники в истории в свое время были такими же, как мы, – школьниками. Если у них получилось, то получится и у нас», – Гарри Поттер.
maxlen: 35
forbidden_words: [""волшебники"", ""Гарри Поттер""]

Результат функции:

{
""length"":171,
""pure_length"":140
""origin_text"":""«Не забывайте о том, что все великие волшебники в истории в свое время были такими же, как мы, – школьниками. Если у них получилось, то получится и у нас», – Гарри Поттер.""
""pure_text"":""«Не забывайте о том, что все великие *** в истории в свое время были такими же, как мы, – школьниками. Если у них получилось, то получится и у нас», – ***.""
""pure_short_text"":""Не забывайте о том, что все великие...""
}"
 */