import Helpers.InputHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Task1Day18 {
  public static void main(String[] args) throws IOException, BadSumException, BadFormatException {
    int denezhka = InputHelper.getInt();
    if (denezhka%100 != 0 ) throw new BadFormatException("Сумма должна быть кратной 100");
    ArrayList<Integer> result = getBanknotes(denezhka);
    System.out.println("Крупными");
      result.forEach(System.out::println);
    }

  private static ArrayList<Integer> getBanknotes(int denezhka) throws BadSumException {
    int[] nominals = {100, 200, 500, 1000, 2000, 5000};
    HashMap<Integer, Integer> nominalsAvailable = new HashMap<>();
    int[] totalCashInNomital = new int[nominals.length];
    int totalCash = 0;
    for (int i = 0; i < nominals.length; i++) {
      nominalsAvailable.put(nominals[i], (int) (Math.random() * 10));
      totalCash += nominals[i] * nominalsAvailable.get(nominals[i]);
      totalCashInNomital[i] = nominals[i] * nominalsAvailable.get(nominals[i]);
    } //заполняем банкомат
    if (totalCash < denezhka) throw new BadSumException("Нет сколько денег, в банкомате всего " + totalCash + " рублей.");
    ArrayList<Integer> result = new ArrayList<>(); //а дальше ядрёная логика
//    while (denezhka > 99) {
//      if (denezhka >= nominals[5]) {
//        if (nominalsAvailable.get(nominals[5]) > 0) {
//          result.add(nominals[5]);
//          denezhka -= nominals[5];
//          totalCashInNomital[5] -= nominals[5];
//          int count = nominalsAvailable.get(nominals[5]) - 1;
//          nominalsAvailable.put(nominals[5], count);
//        } else {
          for (int i = nominals.length - 1; i > 0; i--) {
              while (nominals[i] <= denezhka && nominalsAvailable.get(nominals[i]) > 0) {
                result.add(nominals[i]);
                denezhka -= nominals[i];
                int count = nominalsAvailable.get(nominals[i]) - 1;
                nominalsAvailable.put(nominals[i], count);
              }
              if (denezhka == 0) break;
            }
          if (denezhka!=0) throw new BadSumException("Не хватает какой-то денежки в банкомате");
//        }
//      } else if (denezhka >= nominals[4]) {
//        if (nominalsAvailable.get(nominals[4]) > 0) {
//          result.add(nominals[4]);
//          denezhka -= nominals[4];
//          totalCashInNomital[4] -= nominals[4];
//          int count = nominalsAvailable.get(nominals[4])-1;
//          nominalsAvailable.put(nominals[4], count);
//        } else {
//          for (int i = nominals.length - 3; i > 0; i--) {
//              while (nominals[i] <= denezhka && nominalsAvailable.get(nominals[i]) > 0) {
//                result.add(nominals[i]);
//                denezhka -= nominals[i];
//                int count = nominalsAvailable.get(nominals[i]) - 1;
//                nominalsAvailable.put(nominals[i], count);
//              }
//          }
//        }
//      } else if (denezhka >= nominals[3]) {
//        if (nominalsAvailable.get(nominals[3]) > 0) {
//          result.add(nominals[3]);
//          denezhka -= nominals[3];
//          totalCashInNomital[3] -= nominals[3];
//          int count = nominalsAvailable.get(nominals[3])-1;
//          nominalsAvailable.put(nominals[3], count);
//        }else {
//          for (int i = nominals.length - 4; i > 0; i--) {
//              while (nominals[i] <= denezhka && nominalsAvailable.get(nominals[i]) > 0) {
//                result.add(nominals[i]);
//                denezhka -= nominals[i];
//                int count = nominalsAvailable.get(nominals[i]) - 1;
//                nominalsAvailable.put(nominals[i], count);
//              }
//            }
//        }
//      } else if (denezhka >= nominals[2]) {
//        if (nominalsAvailable.get(nominals[2]) > 0) {
//          result.add(nominals[2]);
//          denezhka -= nominals[2];
//          totalCashInNomital[2] -= nominals[2];
//          int count = nominalsAvailable.get(nominals[2])-1;
//          nominalsAvailable.put(nominals[2], count);
//        } else {
//          for (int i = nominals.length - 5; i > 0; i--) {
//              while (nominals[i] <= denezhka && nominalsAvailable.get(nominals[i]) > 0) {
//                result.add(nominals[i]);
//                denezhka -= nominals[i];
//                int count = nominalsAvailable.get(nominals[i]) - 1;
//                nominalsAvailable.put(nominals[i], count);
//              }
//            }
//        }
//      } else if (denezhka >= nominals[1]) {
//        if (nominalsAvailable.get(nominals[1]) > 0) {
//          result.add(nominals[1]);
//          denezhka -= 200;
//          totalCashInNomital[1] -= nominals[1];
//          int count = nominalsAvailable.get(nominals[1])-1;
//          nominalsAvailable.put(nominals[1], count);
//        }
//      } else {
//          int i = 0;
//          if (nominalsAvailable.get(nominals[i]) > 0) {
//            while (nominals[i] <= denezhka) {
//              result.add(nominals[i]);
//              denezhka -= nominals[i];
//              int count = nominalsAvailable.get(nominals[i]) - 1;
//              nominalsAvailable.put(nominals[i], count);
//            }
//          } else throw new BadSumException("Не хватает соток, попробуйте другую сумму");
//        }
//      }
    return result;
  }

  static class BadFormatException extends Exception{
    public BadFormatException(String message) {
      System.out.println(message);
    }
  }

  static class BadSumException extends Exception{
    public BadSumException(String message) {
      System.out.println(message);
    }
  }
}

/*
Сегодня пишем банкомат для Сбера. Они, хоть и айти-компания теперь, без нас-то не смогут :)

Надо написать функцию, которая получает на вход сумму, которую банкомат должен выдать. Вернуться должен массив, описывающий - в каких банкнотах мы будем выдавать денежку.
Номиналы возможны следующие - 100, 200, 500, 1000, 2000, 5000

Вторым параметром приходит тип выдачи. Существует два типа - "с разменом" и "крупными". С разменом - это когда мы выдаем минимальными валютами. Крупными - когда выдаем минимальным количеством купюр.

Гарантируется, что сумма придет кратной 100.
 */