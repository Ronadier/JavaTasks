import Helpers.InputHelper;

import java.io.IOException;

public class Task8 {
  public static void main (String[] args) throws IOException {
    System.out.println("Какое число переводим?");
    int a = InputHelper.getInt();
    System.out.println("В какую систему счисления переводим?(2/8/16)");
    int b = InputHelper.getInt();
    if (b==2) System.out.println(Integer.toBinaryString(a));
    else if (b==8) System.out.println(Integer.toHexString(a));
    else if (b==16) System.out.println(Integer.toOctalString(a));
  }
}
