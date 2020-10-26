import Helpers.InputHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task4hard {
  public static void main (String[] args) throws IOException {
    List<Integer> toDoList = InputHelper.getIntList();
    int sumForFind = InputHelper.getInt();
    if (isSumTrue(toDoList,sumForFind)) System.out.println("True");
    else System.out.println("False");
  }

  private static boolean isSumTrue(List<Integer> toDoList, int sumForFind){
    List<Integer> differensList = new ArrayList<>();
    for (int i = 0;i< toDoList.size();i++){
      Integer difference = sumForFind - toDoList.get(i); //делаем лист с элементами сумма-одно из слагаемых (n-a)
      differensList.add(difference);
      if (differensList.contains(toDoList.get(i)) && !differensList.get(i).equals(toDoList.get(i))) { //Если лист с разностью содержит элемент a и при этом они не находятся на одной позиции в листе
        return true; //то всё ок
      } else{
        differensList.set(i, null); //а тут обрабатываем ситуацию, когда мы вводим два одинаковых числа, но сумма их даёт искомый N
        if (differensList.contains(toDoList.get(i))) { //если одно из чисел обнуляем, но ещё одно такое же осталось - значит всё ок, а если нет - значит это просто случайно попалась сумма одного числа (например N=8, a=4)
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