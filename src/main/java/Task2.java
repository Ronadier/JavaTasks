import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
  public static void main(String[] args) throws IOException {

    int maxLength = getInt();
    String str = getStr();

    printStringLength(str);
    printStringWithoutSpaces(str);
    printEvenOrNotEvenString(str);
    printIsStringLengthMoreMax(str, maxLength);
  }

  private static int getInt() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int maxLength = 0;
    while (maxLength <= 0) {
      System.out.println("Введите число:");
      maxLength = Integer.parseInt(reader.readLine());
      if (maxLength <= 0 ) System.out.println("Вы ввели число меньше нуля или ноль. Введите число ещё раз");
    }
    return maxLength;
  }

  private static String getStr() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String str = "";
    while (str.length() == 0) {
      System.out.println("Введите строку");
      str = reader.readLine();
      if (str.length() == 0) System.out.println("Вы ввели пустую строку, введите строку ещё раз");
    }
    return str;
  }

  private static int getLengthWithoutSpaces(String str){
    String[] words = str.split("\\s"); // Разбиение строки на слова с помощью разграничителя (пробел)
    int length = 0;
    for (String s : words){
      length+=s.length();
    }
    return length;
  }

  private static boolean isStringLengthEven(String str){
    return str.length() % 2 == 0;
  }

  private static void printStringLength(String str){
    System.out.println("Количество символов в строке: " + str.length());
  }

  private static void printStringWithoutSpaces(String str){
    System.out.println("Количество символов в строке без пробелов: "+ getLengthWithoutSpaces(str));
  }

  private static void printEvenOrNotEvenString (String str){
    if (isStringLengthEven(str)) System.out.println("Количество символов в строке (учитывая пробелы) чётное");
    else System.out.println("Количество символов в строке (учитывая пробелы) нечётное");
  }

  private static void printIsStringLengthMoreMax(String str, int maxLength){
    if (str.length() > maxLength) System.out.println("Длина введённой строки превышает "+maxLength+ " символов");
  }
}
