import Helpers.InputHelper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.*;

public class Task6 {

  public static void main(String[] args) throws IOException {
    String fileName = "users_ds.json";
    ArrayList<Human> humans = initJSON(fileName);
    Map<String, Integer> agesConfig = agesConfig();
    System.out.println("Страна для поиска");
    String country = InputHelper.getStr();
    System.out.println("Возраст для поиска");
    int inputAge = InputHelper.getInt();
    ArrayList<Human> usersFromCountry = usersFromCountry(humans, country);
    ArrayList<Human> usersIndicatedAges = usersIndicatedAges(humans, inputAge);
    ArrayList<Human> usersOlderIndicatedAge = usersOlderIndicatedAge(humans, inputAge);
    ArrayList<Human> usersYoungeraAndIndicatedAge = usersYoungeraAndIndicatedAge(humans, inputAge);
    ArrayList<Human> adults = adults(humans, agesConfig);
    ArrayList<Human> teens = teens(humans, agesConfig);
    ArrayList<Human> brokens = brokens(humans, agesConfig);

    System.out.println("Люди из страны " + country);
    printHelper(usersFromCountry);
    System.out.println();
    System.out.println("Люди возраста " + inputAge + " лет");
    printHelper(usersIndicatedAges);
    System.out.println();
    System.out.println("Люди старше " + inputAge + " лет");
    printHelper(usersOlderIndicatedAge);
    System.out.println();
    System.out.println("Люди младше или в возрасте " + inputAge + " лет");
    printHelper(usersYoungeraAndIndicatedAge);
    System.out.println();
    System.out.println("Совершеннолетние");
    printHelper(adults);
    System.out.println();
    System.out.println("Тины");
    printHelper(teens);
    System.out.println();
    System.out.println("Битые записи");
    printHelper(brokens);
    System.out.println();
    System.out.println("Починеные");
    repairBrokenAndPrint(humans, agesConfig);
    System.out.println("В какую страну перевозим?");
    String countryTransfer = InputHelper.getStr();
    System.out.println("Человека с каким id переводим?");
    moveUser(humans.get(InputHelper.getInt()-1), agesConfig, countryTransfer);
  }

  private static ArrayList<Human> initJSON(String fileName) throws IOException {
    String fileToStr = String.valueOf(Files.readAllLines(Paths.get(fileName)));
    fileToStr.replace("[","");
    fileToStr.replace("]","");
    JSONArray jsonArray = new JSONArray(fileToStr);
    JSONObject jsonObject;
    ArrayList<String> name = new ArrayList();
    ArrayList<Integer> id = new ArrayList<>();
    ArrayList<String> fname = new ArrayList<>();
    ArrayList<String> county = new ArrayList<>();
    ArrayList<Integer> age = new ArrayList<>();
    ArrayList<Boolean> isTeen = new ArrayList<>();
    ArrayList<Human> humans = new ArrayList<>();
    for (int i = 0; i < jsonArray.length(); i++) {
      jsonObject = jsonArray.getJSONObject(i);
      id.add(jsonObject.getInt("id"));
      name.add(jsonObject.getString("name"));
      fname.add(jsonObject.getString("fname"));
      county.add(jsonObject.getString("county"));
      age.add(jsonObject.getInt("age"));
      isTeen.add(jsonObject.getBoolean("is_teen"));
      humans.add(new Human(id.get(i), name.get(i), fname.get(i),county.get(i),age.get(i),isTeen.get(i)));
    }
    return humans;
  }

  private static void updateJSON(ArrayList<Human> humans, String fileName) {
    JSONArray jsonArray = new JSONArray();
    JSONObject jsonObject = new JSONObject();
    try (FileWriter writer = new FileWriter(fileName, false)) {
      writer.write("");
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    for (int i=0;i<humans.size();i++) {
      jsonObject.put("id", humans.get(i).id);
      jsonObject.put("name", humans.get(i).name);
      jsonObject.put("fname", humans.get(i).fname);
      jsonObject.put("county", humans.get(i).county);
      jsonObject.put("age", humans.get(i).age);
      jsonObject.put("is_teen", humans.get(i).is_teen);
      jsonArray.put(jsonObject);
      try (FileWriter writer = new FileWriter(fileName, true)) {
        writer.write(String.valueOf(jsonObject));
        if (i!=humans.size()-1) writer.write(",");
      } catch (IOException ex) {
        System.out.println(ex.getMessage());
      }
    }
  }

  private static ArrayList<Human> usersFromCountry (ArrayList<Human> humans, String country){
    ArrayList<Human> result = new ArrayList<>();
    for (Human h : humans){
      if (h.county.equals(country)) result.add(h);
    }
    return result;
  }

  private static ArrayList<Human> usersIndicatedAges (ArrayList<Human> humans, int age){
    ArrayList<Human> result = new ArrayList<>();
    for (Human h : humans){
      if (h.age == age) result.add(h);
    }
    return result;
  }

  private static ArrayList<Human> usersOlderIndicatedAge(ArrayList<Human> humans, int age){
    ArrayList<Human> result = new ArrayList<>();
    for (Human h : humans){
      if (h.age > age) result.add(h);
    }
    return result;
  }

  private static ArrayList<Human> usersYoungeraAndIndicatedAge(ArrayList<Human> humans, int age){
    ArrayList<Human> result = new ArrayList<>();
    for (Human h : humans){
      if (h.age <= age) result.add(h);
    }
    return result;
  }

  private static ArrayList<Human> adults(ArrayList<Human> humans, Map<String, Integer> agesConfig){
    ArrayList<Human> result = new ArrayList<>();
    ArrayList<Integer> ages = new ArrayList<>(agesConfig.values());
    ArrayList<String> countries = new ArrayList<>(agesConfig.keySet());
    for (Human h : humans){
      for (int i = 0;i<ages.size();i++) if (h.age >= ages.get(i) &&  h.county.equals(countries.get(i))) result.add(h);
    }
    return result;
  }

  private static ArrayList<Human> teens (ArrayList<Human> humans, Map<String, Integer> agesConfig){
    ArrayList<Human> result = new ArrayList<>();
    ArrayList<Integer> ages = new ArrayList<>(agesConfig.values());
    ArrayList<String> countries = new ArrayList<>(agesConfig.keySet());
    for (Human h : humans){
      for (int i = 0;i<ages.size();i++) if (h.age < ages.get(i) &&  h.county.equals(countries.get(i))) result.add(h);
    }
    return result;
  }

  private static ArrayList<Human> brokens (ArrayList<Human> humans, Map<String, Integer> agesConfig){
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

  private static void printHelper(ArrayList<Human> humans){
    humans.stream().map(s -> MessageFormat.format("id: {0}, name: {1}, fname: {2}, country: {3}, age: {4}, is_teen: {5}", s.id, s.name, s.fname, s.county, s.age, s.is_teen)).forEach(System.out::println);
  }

  private static Map<String, Integer> agesConfig() throws IOException {
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

  private static void repairBrokenAndPrint(ArrayList<Human> humans, Map<String, Integer> agesConfig) throws IOException {
    ArrayList<Human> result = brokens(humans, agesConfig);
    for (Human h : result){
      if (h.is_teen) h.is_teen = false;
      else h.is_teen = true;
    }
    String fileName = "users_ds_upd.json";
    updateJSON(result, fileName);
    result = initJSON(fileName);
    printHelper(result);
  }

  private static void moveUser(Human human, Map<String, Integer> agesConfig, String country) {
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
}

class Human{
  public int id;
  public String name;
  public String fname;
  public String county;
  public int age;
  public boolean is_teen;

  public Human(int id,String  name, String fname, String county, int age, boolean is_teen) {
    this.id = id;
    this.name = name;
    this.fname = fname;
    this.county = county;
    this.age = age;
    this.is_teen = is_teen;
  }
}

/*
Сегодня будем имитировать работу с базой данных. Только вместо базы данных у нас будет файл с JSON.

Сам файл можно скачать отсюда - https://drive.google.com/file/d/1CbAYvkwlFdviNWoA8MPu-WrF42znhjV6/view

Это небольшая база с пользователями, которая содержит следующие колонки - ID пользователя, имя, фамилия, возраст, текущая страна, и булевое значение — считается ли пользователь совершеннолетним в этой стране.

Известно, что в разных странах совершеннолетие считается с разного возраста. В файле принимают участие четыре страны — Россия (с 18 лет), Япония (с 20 лет), США (с 21 года) и Тайланд (с 20 лет).

Наша задача — написать класс, которые работает с этой базой. Он должен содержать следующие методы:

1) Получить всех пользователей из указанной страны. Страна приходит параметром.
2) Получить всех пользователей указанного возраста. Возраст приходит параметром.
3) Получить всех пользователей старше указанного возраста. Возраст приходит параметром.
4) Получить всех пользователей младше указанного возраста или равного ему. Возраст приходит параметром.
5) Получить всех совершеннолетних.
6) Получить всех тинов.
7) Найти все битые записи. Битые записи — это когда пользователь для текущей локации на самом деле должен быть совершеннолетним или тином, а в базе поле is_teen проставлено неправильно.

Само собой, нужно спроектировать класс так, чтобы было как можно меньше дублирования в коде.
 */

/*
В качестве более сложной задачи мы к задаче номер 1 добавим еще немного методов:

8) Исправить все записи. Функция должна читать файл, анализировать - является ли пользователь на самом деле тином в текущей локации или нет, и при необходимости корректировать ему поле is_teen, перезаписывая файл.
9) Перевезти пользователя в текущую локацию. Локация приходит параметром. Если локация не одна из четырех - Россия, Япония, США, Тайланд - функция пишет, что не можно перевезти туда пользователя. Если страна из этих четырех - перевозит, меняя запись в файле и перепроверяя и корректирую поле is_teen при необходимости. Например, если мы пользователя, которому 18 лет, перевозим из РФ в США, он должен перестать считаться совершеннолетним.
10) Добавить страну. Да-да, выходит, что возраст совершеннолетия для страны надо хранить в каком-то конфиге, который можно дополнять. При вызове этого метода название страны приходит параметром, вторым параметром приходит возраст совершеннолетия. После добавления страны пользователей можно перевозить в эту страну также (метод 9).
 */