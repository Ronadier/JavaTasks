import Helpers.InputHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task4hard {
  public static void main (String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> a = InputHelper.getIntList();
    int n = 0;
    List<Integer> b = new ArrayList<>();
    System.out.println("Введите число N");
    n = Integer.parseInt(reader.readLine());
    for (int i = 0; i < a.size(); i++){ //Т.к. высчитать одно из слагаемых можно с помощью разности
      Integer frequency = n - a.get(i); //то делаем лист с элементами сумма-одно из слагаемых (n-a)
      b.add(frequency);
    }
    //дальше - жесть :)
    boolean isSumTrue = false;
    for (int i = 0;i< a.size();i++){
      if (b.contains(a.get(i)) && b.get(i) != a.get(i)) { //Если лист с разностью содержит элемент a и при этом они не находятся на одной позиции в листе
        System.out.println("True"); //то всё ок
        isSumTrue = true;
        break;
      } else{
        b.set(i, null); //а тут обрабатываем ситуацию, когда мы вводим два одинаковых числа, но сумма их даёт искомый N
        if (b.contains(a.get(i))) { //если одно из чисел обнуляем, но ещё одно такое же осталось - значит всё ок, а если нет - значит это просто случайно попалась сумма одного числа (например N=8, a=4)
          System.out.println("True");
          isSumTrue = true;
          break;
        }
      }
    }
    if (!isSumTrue) System.out.println("False");
  }
}

/*
Для вас задачка чуть сложнее. Мы должны сделать все то же самое, что описано в задаче №1. Но за линейное время.
Для тех, кто незнаком с оценкой сложности алгоритмов можно почитать вот эти статьи:

Введение в анализ сложности алгоритмов (часть 1) - https://habr.com/ru/post/196560/

Введение в анализ сложности алгоритмов (часть 2) - https://habr.com/ru/post/195482/

Введение в анализ сложности алгоритмов (часть 3) - https://habr.com/ru/post/195996/

Введение в анализ сложности алгоритмов (часть 4) - https://habr.com/ru/post/196226/
 */