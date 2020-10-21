import Helpers.InputHelper;

import java.io.IOException;
import java.util.ArrayList;

public class Task8 {
  public static void main (String[] args) throws IOException {
    System.out.println("Какое число переводим?");
    int a = InputHelper.getInt();
    System.out.println(Integer.toBinaryString(a));
    System.out.println(Integer.toHexString(a));
    System.out.println(Integer.toOctalString(a));

    dva(a);
  }

  private static void dva (int a){
    ArrayList<Integer> c = new ArrayList<>();
    do {
      if (a%2 == 0) c.add(0);
      else c.add(1);
      a = a/2;
    } while (a!=0);
    for (int i = c.size()-1; i>=0;i--){
      System.out.print(c.get(i));
    }
  }
}
