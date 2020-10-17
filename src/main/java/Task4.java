import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> a = new ArrayList<>();
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
    if (isSumTrue(a,n)) System.out.println("True");
    else System.out.println("False");
  }

  public static boolean isSumTrue(List<Integer> a, int n){
    for (int i=0;i<a.size();i++){
      for (int j = i;j<a.size();j++){
        if (a.get(i) + a.get(j)==n) return true;
      }
    }
    return false;
  }
}


/*
Сегодня нас ждет несложная алгоритмическая задачка. Мы напишем функцию, которая на вход будет получать несортированный массив чисел первым параметром, и какой-то число вторым параметром.

Функция должна вернуть TRUE в случае, если в массиве есть два числа, которые в сумме дают то, которое мы передали вторым параметром.

Например

array: [1, 3, 2, 12, 11]
N: 5

result: TRUE // так как 3 и 2 в сумме дают 5
 */