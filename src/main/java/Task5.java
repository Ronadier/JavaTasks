import Helpers.InputHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task5 {
  public static void main(String[] args) throws IOException {
    String str = InputHelper.getStr();
    String s = encode(str);
    System.out.println(); //отступ для красоты
    System.out.println("Зашифрованная строка: ");
    System.out.println(s);
    System.out.println("Расшифрованная строка: ");
    System.out.println(decode(s));
  }
  private static String encode(String str){
    List<Character> alphabet = initAlph();
    List<Character> alphabetL = initAlphL();
    char[] a = str.toCharArray();
    for (int i = 0;i<a.length;i++){
      for (int j=0;j<alphabet.size();j++){
        if (a[i] == alphabet.get(alphabet.size()-1)) {
          a[i] = alphabetL.get(0);
          break;
        }
        else if (a[i] == alphabet.get(j)) {
          a[i] = alphabetL.get(j+1);
          break;
        }
        else if (a[i] == alphabetL.get(alphabetL.size()-1)) {
          a[i] = alphabet.get(0);
          break;
        }
        else if (a[i] == alphabetL.get(j)) {
          a[i] = alphabet.get(j+1);
          break;
        }
      }
    }
    str = String.valueOf(a);
    return str;
  }

  private static String decode(String str){
    List<Character> alphabet = initAlph();
    List<Character> alphabetL = initAlphL();
    char[] a = str.toCharArray();
    for (int i = 0;i<a.length;i++){
      for (int j=0;j<alphabet.size();j++){
        if (a[i] == alphabet.get(0)) {
          a[i] = alphabetL.get(alphabet.size()-1);
          break;
        }
        else if (a[i] == alphabet.get(j)) {
          a[i] = alphabetL.get(j-1);
          break;
        }
        else if (a[i] == alphabetL.get(0)) {
          a[i] = alphabet.get(alphabetL.size()-1);
          break;
        }
        else if (a[i] == alphabetL.get(j)) {
          a[i] = alphabet.get(j-1);
          break;
        }
      }
    }
    str = String.valueOf(a);
    return str;
  }

  private static ArrayList<Character> initAlph(){
    ArrayList<Character> alphabet = new ArrayList<>();
    for(char i = 'a';i<='z';i++)
    {
      alphabet.add(i);
    }

    return alphabet;
  }

  private static ArrayList<Character> initAlphL(){
    ArrayList<Character> alphabetL = new ArrayList<>();
    for(char i = 'A';i<='Z';i++)
    {
      alphabetL.add(i);
    }
    return alphabetL;
  }
}

/*
Привет. Сегодня пишем шифратор и дешифратор текста :)
Работать будем только с английским. Следовательно, буквы будут использоваться только английского словаря.

Надо написать две функции.

Первая должна получать на вход строку и шифровать ее по следующему принципу - каждая буква заменяется на следующую в алфавите, при этом большая буква становится маленькой, а маленькая - большой.
То есть "a" заменяется на "B", а "X" заменяется на "z". Последняя буква заменяется на первую, то есть "Z" на "a", а "z" на "A". Итоговая строка возвращается.

Вторая функция должна расшифровывать строку, соответственно действовать наоборот.
 */