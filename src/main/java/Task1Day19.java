import java.util.ArrayList;
import java.util.Arrays;

public class Task1Day19 {
  public static void main(String[] args) {
    int[] start = new int[100];
    boolean[] isContains = {false, false};
    for (int i=0;i<start.length;i++){
      start[i] = (int)(Math.random()*100);
      if (start[i] == 13) isContains[0] = true;
      else if (start[i] == 41) isContains[1] = true;
    }
    if (isContains[0] == true && isContains[1] == true) System.out.println("True");
    else System.out.println("False");
  }
}

/*
Сегодня задачка на массивы. Пишум функцию, которая на вход получает несортированный массив чисел. Функция должна вернуть TRUE в случае, если в массиве есть два числа - 13 и 41
Иначе вернуть FALSE
 */