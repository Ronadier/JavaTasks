import Helpers.InputHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task1Day16 {
  public static void main (String[] args) throws IOException {
    ArrayList<Integer> turn = new ArrayList<>();

    do {
      int addInt = InputHelper.getInt();
      add(addInt, turn);
      String yesOrNo = InputHelper.getYesOrNo(); //Спрашиваем пользователя, не хочет ли он добавить число
      if (!(yesOrNo.equals("+"))) break;
    } while (true);
    System.out.println("Изначальный список");
    turn.forEach(System.out::println);
    int last = getLast(turn);
    System.out.println("Последнее число : " + last);
    System.out.println("Список после удаления последнего");
    turn.forEach(System.out::println);
    int first = getFirst(turn);
    System.out.println("Первое число : " + first);
    System.out.println("Список послед удаления первого");
    turn.forEach(System.out::println);
  }

  private static ArrayList<Integer> add(int addInt, ArrayList<Integer> turn){
    turn.add(addInt);
    return turn;
  }

  private static int getLast(ArrayList<Integer> turn){
    int last = turn.get(turn.size()-1);
    turn.remove(turn.size()-1);
    return last;
  }

  private static int  getFirst(ArrayList<Integer> turn){
    int first = turn.get(0);
    turn.remove(0);
    return first;
  }
}

/*
Сегодня будет писать небольшую очередь. Надо создать класс, у которого будет три метода - add(), getLast() и getFirst()

При вызове add() мы должны передать в него любое число, которое класс "запомнит". Например, мы передаем 5. Если вызвать add() снова, класс снова запомнит. Например 6.
При вызове getLast() класс должен вернуть последнее добавленное число и "забыть" его. Например, в нашем случае вернуть 6. Если вызвать метод еще раз, вернется 5. А затем NULL.
При вызове getFirst() класс работает наоборот. Возвращает самое ранее добавленное число и забывает его. В нашем случае снала 5, затем 6 и потом уже NULL.
 */