package Task6;

import Helpers.*;
import Helpers.LogicHelper;

import java.io.IOException;
import java.util.*;

public class Task6 {

  public static void main(String[] args) throws IOException {
    String fileName = "users_ds.json";
    ArrayList<Human> humans = JSONHelper.initJSONofHumans(fileName);
    Map<String, Integer> agesConfig = ConfigHelper.agesConfig();
    System.out.println("Страна для поиска");
    String country = InputHelper.getStr();
    System.out.println("Возраст для поиска");
    int inputAge = InputHelper.getInt();

    System.out.println("Люди из страны " + country);
    PrintHelper.printArrayOfHumans(Helpers.LogicHelper.usersFromCountry(humans, country));
    System.out.println();
    System.out.println("Люди возраста " + inputAge + " лет");
    PrintHelper.printArrayOfHumans(Helpers.LogicHelper.usersIndicatedAges(humans, inputAge));
    System.out.println();
    System.out.println("Люди старше " + inputAge + " лет");
    PrintHelper.printArrayOfHumans(Helpers.LogicHelper.usersOlderIndicatedAge(humans, inputAge));
    System.out.println();
    System.out.println("Люди младше или в возрасте " + inputAge + " лет");
    PrintHelper.printArrayOfHumans(Helpers.LogicHelper.usersYoungeraAndIndicatedAge(humans, inputAge));
    System.out.println();
    System.out.println("Совершеннолетние");
    PrintHelper.printArrayOfHumans(Helpers.LogicHelper.getAdultsList(humans, agesConfig));
    System.out.println();
    System.out.println("Тины");
    PrintHelper.printArrayOfHumans(Helpers.LogicHelper.getTeensList(humans, agesConfig));
    System.out.println();
    System.out.println("Битые записи");
    PrintHelper.printArrayOfHumans(Helpers.LogicHelper.getBrokensHumanList(humans, agesConfig));
    System.out.println();
    System.out.println("Починеные");
    Helpers.LogicHelper.repairBrokenAndPrint(humans, agesConfig);
    System.out.println("В какую страну перевозим?");
    String countryTransfer = InputHelper.getStr();
    System.out.println("Человека с каким id переводим?");
    LogicHelper.moveUser(humans.get(InputHelper.getInt()-1), agesConfig, countryTransfer);
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