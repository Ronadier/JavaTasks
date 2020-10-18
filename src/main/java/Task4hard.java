import Helpers.InputHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task4hard {
  public static void main (String[] args) throws IOException {
    List<Integer> a = InputHelper.getIntList();
    int n = InputHelper.getInt();
    if (isSumTrue(a,n)) System.out.println("True");
    else System.out.println("False");
  }

  private static boolean isSumTrue(List<Integer> a, int n){
    List<Integer> b = new ArrayList<>();
    for (Integer integer : a) { //Т.к. высчитать одно из слагаемых можно с помощью разности
      Integer difference = n - integer; //то делаем лист с элементами сумма-одно из слагаемых (n-a)
      b.add(difference);
    }
    //дальше - жесть :)
    for (int i = 0;i< a.size();i++){
      if (b.contains(a.get(i)) && !b.get(i).equals(a.get(i))) { //Если лист с разностью содержит элемент a и при этом они не находятся на одной позиции в листе
        return true; //то всё ок
      } else{
        b.set(i, null); //а тут обрабатываем ситуацию, когда мы вводим два одинаковых числа, но сумма их даёт искомый N
        if (b.contains(a.get(i))) { //если одно из чисел обнуляем, но ещё одно такое же осталось - значит всё ок, а если нет - значит это просто случайно попалась сумма одного числа (например N=8, a=4)
          return true;
        }
      }
    }
    return false;
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