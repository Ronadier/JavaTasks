package Helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputHelper {
  public static List<String> getForbiddenWords() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<String> str = new ArrayList<>();
    System.out.println("Вы хотите ввести запрещённое слово? (+ если да)");
    String yesOrNo = reader.readLine();
    if (!(yesOrNo.equals("+"))) return str;
    int i=0;
    do {
      System.out.println("Введите запрещённое слово");
      str.add(reader.readLine());
      if (str.get(i).length() == 0) System.out.println("Вы ввели пустую строку, введите слово ещё раз");
      System.out.println("Вы хотите ввести ещё одно слово? (+ если да)");
      yesOrNo = reader.readLine();
      if (!(yesOrNo.equals("+"))) break;
      i++;
    } while (true);
    return str;
  }

  public static String getYesOrNo () throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Ещё разок? (+ если да)");
    String yesOrNo = reader.readLine();
    return yesOrNo;
  }

  public static String getStr() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String str = "";
    while (str.length() == 0) {
      System.out.println("Введите строку");
      str = reader.readLine();
      if (str.length() == 0) System.out.println("Вы ввели пустую строку, введите строку ещё раз");
    }
    return str;
  }

  public static List<String> getListStr() throws IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<String> str = new ArrayList<>();
    int a=0;
    do {
      System.out.println("Введите элемент: ");
      str.add(reader.readLine());
      a++;
    } while (!(str.get(a-1).equals("")));
    return str;
  }

  public static int getInt() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int maxLength = 0;
    while (maxLength <= 0) {
      System.out.println("Введите число:");
      maxLength = Integer.parseInt(reader.readLine());
      if (maxLength <= 0 ) System.out.println("Вы ввели число меньше нуля или ноль. Введите число ещё раз");
    }
    return maxLength;
  }

  public static List<Integer> getIntList() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> a = new ArrayList<>();
    int c = 0;
    do {
      System.out.println("Введите число номер " + c + " в массив: ");
      c++;
      String s = reader.readLine();
      if (s.equals("")) break;
      a.add(Integer.parseInt(s));
    }while (true);
    return a;
  }
}
