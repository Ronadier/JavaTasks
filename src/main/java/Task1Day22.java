import Helpers.InputHelper;

import java.io.IOException;
import java.util.HashMap;

public class Task1Day22 {
  public static void main(String[] args) throws IOException {
    String param = InputHelper.getStr();
    HashMap<String, String> stringHashMap = run(param);
    stringHashMap.forEach((key, value) -> System.out.println(key + " => " + value));
  }

  private static HashMap<String, String> run (String param){
    String[] paramArray = param.split("--");
    HashMap<String, String> result = new HashMap<>();
    for (String params : paramArray){
      if (params.contains("=")){
        String[] paramsToHashMap = params.split("=");
        result.put(paramsToHashMap[0],paramsToHashMap[1]);
      } else if (!params.equals("")){
        result.put(params,"True");
      }
    }
    return result;
  }
}

/*
Сегодня учимся парсить параметры консольной утилиты. Допустим, у нас есть утилита run, которая запускается из консоли с различными параметрами. Например:

run --online-mode
run --ip=132.223.324.454
run --stable-mode --ip=129.22.341.11

Наша задача - написать функцию, которая на вход получает параметры строкой. Например, вот такую строку: "--stable-mode --ip=129.22.341.11"
Функция должна разобрать эту строку и вернуть ассоциативный массив (словарь, хешмап), где ключом будет название параметра без двух символов тире в начале, а значением будет либо то, что указано через знак равно (как для параметра ip), либо True, если ключ используется без значения.

Например, нам на вход пришла вот такая строка: "--stable-mode --ip=129.22.341.11 --online-mode --port=4455"
Ожидаемый результат:

[
''ip" => "129.22.341.11",
 "port" => "4455",
"stable-mode" => "True",
"online-mode" => "True"
]

Гарантируется, что все параметры начинаются с двух символов -- и что после параметра идет либо символ равно и значение (не менее одного символа), либо следующий параметр.
 */