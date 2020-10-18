import Helpers.InputHelper;

import java.io.IOException;

public class Task2 {
  public static void main(String[] args) throws IOException {

    int maxLength = InputHelper.getInt();
    String str = InputHelper.getStr();

    printStringLength(str);
    printStringWithoutSpaces(str);
    printEvenOrNotEvenString(str);
    printIsStringLengthMoreMax(str, maxLength);
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
