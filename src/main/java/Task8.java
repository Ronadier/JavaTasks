import Helpers.InputHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Task8 {
  public static void main (String[] args) throws IOException {
    System.out.println("Какое число переводим?");
    int number = InputHelper.getInt();
    System.out.println("В какую систему счисления переводим?");
    int numeralSystem = 0;
    do {
      numeralSystem = InputHelper.getInt();
      if (numeralSystem > 37) System.out.println("Мы не умеем в системы счисления больше 36");
    } while (numeralSystem > 37);
    System.out.print("В " + numeralSystem + "-ой системе счисления это - ");
    transfer(number,numeralSystem);
  }

  private static void transfer(int number, int numeralSystem){
    ArrayList<String> result = new ArrayList<>();
    if (numeralSystem <= 10) {
      do {
        result.add(String.valueOf(number%numeralSystem));
        number = number/numeralSystem;
      } while (number!=0);
    } else {
      do {
        HashMap<Integer, Character> mapOfValues = initKeyValue();
        if (number % numeralSystem < 10) {
          result.add(String.valueOf(number % numeralSystem));
          number = number/numeralSystem;
        } else {
          result.add(String.valueOf(mapOfValues.get(number % numeralSystem)));
          number = number/numeralSystem;
        }
      } while (number!=0);
    }
    for (int i = result.size()-1; i>=0;i--){
      System.out.print(result.get(i));
    }
  }

  private static HashMap<Integer, Character> initKeyValue(){
    HashMap<Integer, Character> result = new HashMap<>();
    char a = 'A';
    for (int i = 10; i < 36; i++){
      result.put(i,a);
      a++;
    }
    return result;
  }
}
