import Helpers.InputHelper;

import java.io.IOException;
import java.util.ArrayList;

public class Task8 {
  public static void main (String[] args) throws IOException {
    System.out.println("Какое число переводим?");
    int a = InputHelper.getInt();
    System.out.println("В какую систему счисления переводим? (2/8/16)");
    int r = InputHelper.getInt();
    for (int i = 0;i<1;i++){
      switch (r) {
        case 2:
          binary(a);
          break;
        case 8:
          octal(a, r);
          break;
        case 16:
          hexadecimal(a, r);
          break;
        default:
          System.out.println("Вы ввели некорректное число системы счисления, повторите, плз");
          r = InputHelper.getInt();
          i--;
      }
    }
  }

  private static void binary(int a){
    ArrayList<Integer> c = new ArrayList<>();
    System.out.print("Число " + a + " в двоичной системе : ");
    do {
      c.add(a%2);
      a = a/2;
    } while (a!=0);

    for (int i = c.size()-1; i>=0;i--){
      System.out.print(c.get(i));
    }
  }

  public static void octal(int a, int r){
    ArrayList<Integer> c = new ArrayList<>();
    System.out.print("Число " + a + " в восьмиричной системе : ");
    do {
      c.add(a%r);
      a = a/r;
    } while (a!=0);
    for (int i = c.size()-1; i>=0;i--){
      System.out.print(c.get(i));
    }
  }

  public static void hexadecimal(int a, int r){
    ArrayList<String> c = new ArrayList<>();
    System.out.print("Число " + a + " в шестнадцатиричной системе : ");
    do {
      if (a%r < 10) {
        c.add(String.valueOf(a % r));
      } else switch (a%r){
        case 10: c.add("A");
        break;
        case 11: c.add("B");
        break;
        case 12: c.add("C");
        break;
        case 13: c.add("D");
        break;
        case 14: c.add("E");
        break;
        case 15: c.add("F");
      }
      a = a/16;
    } while (a!=0);
    for (int i = c.size()-1; i>=0;i--){
      System.out.print(c.get(i));
    }
  }
}
