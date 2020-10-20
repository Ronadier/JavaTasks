package Task6;

import Helpers.InputHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConfigHelper {
  static Map<String, Integer> agesConfig() throws IOException {
    ArrayList<String> countries = new ArrayList<>();
    ArrayList<Integer> age = new ArrayList<>();
    countries.add("Russia");
    countries.add("USA");
    countries.add("Japan");
    countries.add("Thailand");
    age.add(18);
    age.add(21);
    age.add(20);
    age.add(20);
    System.out.println("Добавить страну? (+ если да)");
    String s = InputHelper.getStr();
    if (s.equals("+")){
      countries.add(InputHelper.getStr());
      System.out.println("Введите возраст совершеннолетия");
      age.add(InputHelper.getInt());
    }

    Map<String, Integer> result = new HashMap<>();
    for (int i=0;i<countries.size();i++){
      result.put(countries.get(i),age.get(i));
    }
    return result;
  }
}
