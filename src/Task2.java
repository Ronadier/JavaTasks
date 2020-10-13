import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int maxLength = 0;
    while (maxLength <= 0) {
      System.out.println("Введите число:");
      maxLength = Integer.parseInt(reader.readLine());
      if (maxLength <= 0 ) System.out.println("Вы ввели число меньше нуля или ноль. Введите число ещё раз");
    }
    String str = "";
    while (str.length() == 0) {
      System.out.println("Введите строку");
      str = reader.readLine();
      if (str.length() == 0) System.out.println("Вы ввели пустую строку, введите строку ещё раз");
    }

    System.out.println("Количество символов в строке: " + str.length());
    System.out.println("Количество символов в строке без пробелов: "+countWithoutSpaces(str));
    if (even(str)) System.out.println("Количество символов в строке (учитывая пробелы) чётное");
    else System.out.println("Количество символов в строке (учитывая пробелы) нечётное");
    if (str.length() > maxLength) System.out.println("Длина введённой строки превышает "+maxLength+ " символов");
  }

  public static int countWithoutSpaces(String str){
    String[] words = str.split("\\s"); // Разбиение строки на слова с помощью разграничителя (пробел)
    int length = 0;
    for (String s : words){
      length+=s.length();
    }
    return length;
  }

  public static boolean even(String str){
    if (str.length() % 2 == 0) return true;
    else return false;
  }
}
