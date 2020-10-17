import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Task4hard {
  public static void main (String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Set<Integer> a = new TreeSet<>();
    int n,c = 0;
    do {
      System.out.println("Введите число номер " + c + " в массив: ");
      c++;
      String s = reader.readLine();
      if (s.equals("")) break;
      a.add(Integer.parseInt(s));
    }while (true);
    System.out.println("Введите число N");
    n = Integer.parseInt(reader.readLine());
    Set<Integer> b = new HashSet<>();
    for (Integer integer : a) {
      if (integer < n) b.add(integer);
      else break;
    }
    b.forEach(System.out::println);
    
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