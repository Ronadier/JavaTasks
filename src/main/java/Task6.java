import Helpers.InputHelper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;

public class Task6 {

  public static void main(String[] args) throws IOException {
    ArrayList<Human> humans = initJSON();

    System.out.println("Страна");
    String country = InputHelper.getStr();
    System.out.println("Возраст");
    int inputAge = InputHelper.getInt();
    ArrayList<Human> usersFromCountry = usersFromCountry(humans, country);
    ArrayList<Human> usersIndicatedAges = usersIndicatedAges(humans, inputAge);
    ArrayList<Human> usersOlderIndicatedAge = usersOlderIndicatedAge(humans, inputAge);
    ArrayList<Human> usersYoungeraAndIndicatedAge = usersYoungeraAndIndicatedAge(humans, inputAge);
    ArrayList<Human> adults = adults(humans);
    ArrayList<Human> teens = teens(humans);
    ArrayList<Human> brokens = brokens(humans);


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
  }

  private static ArrayList<Human> initJSON() throws IOException {
    String fileToStr = String.valueOf(Files.readAllLines(Paths.get("users_ds.json")));
    System.out.println(fileToStr);

    JSONArray jsonArray = new JSONArray(fileToStr);
    JSONObject jsonObject;
    int i = 0;
    ArrayList<String> name = new ArrayList();
    ArrayList<Integer> id = new ArrayList<>();
    ArrayList<String> fname = new ArrayList<>();
    ArrayList<String> county = new ArrayList<>();
    ArrayList<Integer> age = new ArrayList<>();
    ArrayList<Boolean> isTeen = new ArrayList<>();
    ArrayList<Human> humans = new ArrayList<>();
    while (i < jsonArray.length()) {
      jsonObject = jsonArray.getJSONObject(i);
      id.add(jsonObject.getInt("id"));
      name.add(jsonObject.getString("name"));
      fname.add(jsonObject.getString("fname"));
      county.add(jsonObject.getString("county"));
      age.add(jsonObject.getInt("age"));
      isTeen.add(jsonObject.getBoolean("is_teen"));
      humans.add(new Human(id.get(i), name.get(i), fname.get(i),county.get(i),age.get(i),isTeen.get(i)));
      i++;
    }
    return humans;
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

  private static ArrayList<Human> adults(ArrayList<Human> humans){
    ArrayList<Human> result = new ArrayList<>();
    for (Human h : humans){
      if (h.age >= 18 && h.county.equals("Russia")) result.add(h);
      else if (h.age >=20 && (h.county.equals("Japan") || h.county.equals("Thailand"))) result.add(h);
      else if (h.age >=21 && h.county.equals("USA")) result.add(h);
    }
    return result;
  }

  private static ArrayList<Human> teens (ArrayList<Human> humans){
    ArrayList<Human> result = new ArrayList<>();
    for (Human h : humans){
      if (h.age < 18 && h.county.equals("Russia")) result.add(h);
      else if (h.age < 20 && (h.county.equals("Japan") || h.county.equals("Thailand"))) result.add(h);
      else if (h.age < 21 && h.county.equals("USA")) result.add(h);
    }
    return result;
  }

  private static ArrayList<Human> brokens (ArrayList<Human> humans){
    ArrayList<Human> result = new ArrayList<>();
    for (Human h : humans){
      if (h.age < 18 && h.county.equals("Russia") && !h.is_teen) result.add(h);
      else if (h.age < 20 && (h.county.equals("Japan") || h.county.equals("Thailand")) && !h.is_teen) result.add(h);
      else if (h.age < 21 && h.county.equals("USA") && !h.is_teen) result.add(h);
      else if (h.age >= 18 && h.county.equals("Russia") && h.is_teen) result.add(h);
      else if (h.age >=20 && (h.county.equals("Japan") || h.county.equals("Thailand")) && h.is_teen) result.add(h);
      else if (h.age >=21 && h.county.equals("USA") && h.is_teen) result.add(h);
    }
    return result;
  }

  private static void printHelper(ArrayList<Human> humans){
    humans.stream().map(s -> MessageFormat.format("id: {0}, name: {1}, fname: {2}, country: {3}, age: {4}, is_teen: {5}", s.id, s.name, s.fname, s.county, s.age, s.is_teen)).forEach(System.out::println);
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