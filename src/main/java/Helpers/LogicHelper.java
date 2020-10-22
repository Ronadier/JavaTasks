package Helpers;

import Task6.Human;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LogicHelper {
  static int getLengthWithoutSpaces(String str){
    String[] words = str.split("\\s"); // Разбиение строки на слова с помощью разграничителя (пробел)
    int length = 0;
    for (String s : words){
      length+=s.length();
    }
    return length;
  }

  static String replaceForbiddenWords(String str, List<String> forbiddenWords){
    String replace = str;
    for (String f : forbiddenWords){
       replace = replace.replace(f,"***");
      }
    return replace;
    }

  static String getShortText(String str, int maxLength){
    if (str.length() <= maxLength ) return str;
    else {
      String replace = str.substring(0,maxLength);
      replace = replace + "...";
      return replace;
      }
  }

  public static ArrayList<Human> usersFromCountry(ArrayList<Human> humans, String country){
    ArrayList<Human> result = new ArrayList<>();
    for (Human h : humans){
      if (h.county.equals(country)) result.add(h);
    }
    return result;
  }

  public static ArrayList<Human> usersIndicatedAges(ArrayList<Human> humans, int age){
    ArrayList<Human> result = new ArrayList<>();
    for (Human h : humans){
      if (h.age == age) result.add(h);
    }
    return result;
  }

  public static ArrayList<Human> usersOlderIndicatedAge(ArrayList<Human> humans, int age){
    ArrayList<Human> result = new ArrayList<>();
    for (Human h : humans){
      if (h.age > age) result.add(h);
    }
    return result;
  }

  public static ArrayList<Human> usersYoungeraAndIndicatedAge(ArrayList<Human> humans, int age){
    ArrayList<Human> result = new ArrayList<>();
    for (Human h : humans){
      if (h.age <= age) result.add(h);
    }
    return result;
  }

  public static ArrayList<Human> getAdultsList(ArrayList<Human> humans, Map<String, Integer> agesConfig){
    ArrayList<Human> result = new ArrayList<>();
    ArrayList<Integer> ages = new ArrayList<>(agesConfig.values());
    ArrayList<String> countries = new ArrayList<>(agesConfig.keySet());
    for (Human h : humans){
      for (int i = 0;i<ages.size();i++) if (h.age >= ages.get(i) &&  h.county.equals(countries.get(i))) result.add(h);
    }
    return result;
  }

  public static ArrayList<Human> getTeensList(ArrayList<Human> humans, Map<String, Integer> agesConfig){
    ArrayList<Human> result = new ArrayList<>();
    ArrayList<Integer> ages = new ArrayList<>(agesConfig.values());
    ArrayList<String> countries = new ArrayList<>(agesConfig.keySet());
    for (Human h : humans){
      for (int i = 0;i<ages.size();i++) if (h.age < ages.get(i) &&  h.county.equals(countries.get(i))) result.add(h);
    }
    return result;
  }

  public static ArrayList<Human> getBrokensHumanList(ArrayList<Human> humans, Map<String, Integer> agesConfig){
    ArrayList<Human> result = new ArrayList<>();
    ArrayList<Integer> ages = new ArrayList<>(agesConfig.values());
    ArrayList<String> countries = new ArrayList<>(agesConfig.keySet());
    for (Human h : humans){
      for (int i = 0;i<ages.size();i++) {
        if (h.age >= ages.get(i) && h.county.equals(countries.get(i)) && h.is_teen) result.add(h);
        else if (h.age < ages.get(i) &&  h.county.equals(countries.get(i)) && !h.is_teen) result.add(h);
      }
    }
    return result;
  }

  public static void repairBrokenAndPrint(ArrayList<Human> humans, Map<String, Integer> agesConfig) throws IOException {
    ArrayList<Human> result = getBrokensHumanList(humans, agesConfig);
    for (Human h : result){
      if (h.is_teen) h.is_teen = false;
      else h.is_teen = true;
    }
    String fileName = "users_ds_upd.json";
    JSONHelper.updateJSONofHumans(result, fileName);
    result = JSONHelper.initJSONofHumans(fileName);
    PrintHelper.printArrayOfHumans(result);
  }

  public static void moveUser(Human human, Map<String, Integer> agesConfig, String country) {
    int index = 0;
    ArrayList<Integer> ages = new ArrayList<>(agesConfig.values());
    ArrayList<String> countries = new ArrayList<>(agesConfig.keySet());
    boolean isCountry = false;
    for (int i=0;i<countries.size();i++) if (country.equals(countries.get(i))) {
      isCountry = true;
      index = i;
    }
    if (!isCountry) System.out.println("Тут этсамое... страна не та");
    else {
      human.county = country;
      if (human.age < ages.get(index)) human.is_teen = true;
      else human.is_teen = false;
      System.out.println("Перевезли человека с id " + human.id + ", которого зовут " + human.name + " в страну " + human.county + " ему " + human.age + " лет, его is_teen - " + human.is_teen);
    }
  }

  public static Integer[] initArr1Task7(){
    Integer[] a = new Integer[3];
    return a;
  }

  public static Integer[][] initArr2Task7(Integer[] a){
    int u=1;
    Integer[][] b = new Integer[a.length][3];
    for (int i = 0;i<a.length;i++){
      for (int j = 0;j<b.length;j++) {
        b[i][j] = u;
        u++;
        System.out.print(b[i][j] + " ");
      }
      System.out.println();
    }
    return b;
  }
}
