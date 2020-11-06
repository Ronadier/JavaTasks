import Helpers.InputHelper;

import java.io.IOException;
import java.util.ArrayList;

public class Task1Day24 {
  public static void main(String[] args) throws IOException {
    int input = InputHelper.getInt();
    //Инициализация рандомного массива массовов длиной 5
    ArrayList<int[]> listOfArrays  = new ArrayList<>();
    int lengthOfList = 5;
    for (int i =0;i<lengthOfList;i++){

      int[] add = new int[(int)(Math.random()*10)];
      for (int j =0;j<add.length;j++){
        add[j] = (int)(Math.random()*10);
      }
      for (int a : add){
        System.out.print(a + " ");
      }
      System.out.println();
      listOfArrays.add(add);
    }
    System.out.println("Провер очка");
  boolean a = isArraysLengthTrue(input, listOfArrays);
    System.out.println(a);
  }


  private static boolean isArraysLengthTrue(int input, ArrayList<int[]> listOfArrays){
    ArrayList<Integer> numbers = new ArrayList<>();
    while(input != 0) {
      numbers.add(input % (10));
      input = input / 10;
    }
    //переставим элементы в нормальной последовательности
    //Переменная, которая будет использоваться при обмене элементов
    int temp;
    for (int i = 0; i < numbers.size()/2; i++) {
      temp = numbers.get(numbers.size()-i-1);
      numbers.set(numbers.size()-i-1,numbers.get(i));
      numbers.set(i, temp);
    }
    numbers.forEach(System.out::println);
    if (listOfArrays.size() == numbers.size()){
      for (int i = 0;i<listOfArrays.size();i++){
        if (listOfArrays.get(i).length != numbers.get(i)){
          return false;
        }
      }
      return true;
    }
    return false;
  }
}

/*
Сегодня поработаем с массивами. Надо написать функцию, которая на вход получает положительное число и массив массивов.

Например, на вход пришло число 456. Надо убедиться, что в массиве массивов ровно три массива: первый массив имеет 4 элемента, второй - 5 элементов, а третий - 6 элементов.
Если пришло число 55, надо убедиться, что в массиве массивов два массива по 5 элементов каждый.

Функция возвращает True, если массив подходит под число или False, если нет

Гарантируется, что число больше 0.

Приводить число к строке нельзя. :)
 */