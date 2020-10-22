package Task7;

import Helpers.GoHelper;
import Helpers.InputHelper;
import Helpers.LogicHelper;

import java.io.IOException;
import java.util.ArrayList;

public class Task7 {
  public static void main (String[] args) throws IOException {
    Integer[] gameFieldHorizont = LogicHelper.initArr1Task7();
    Integer[][] gameFieldAll = LogicHelper.initArr2Task7(gameFieldHorizont);
    game(gameFieldHorizont,gameFieldAll);
  }
  private static void game(Integer[] gameFieldHorizont, Integer[][] gameFieldAll) throws IOException {
    int u = 0;
    do {
      System.out.println("Ход человека");
      int move = InputHelper.getInt();
      ArrayList<Integer[][]> result = new ArrayList<>();
      result.add(GoHelper.goHuman(gameFieldHorizont,gameFieldAll,move));
      System.out.println("Конец игры? (Y - да, N - нет)");
      String endGame = InputHelper.getStr();
      if (endGame.equals("Y")) break;
      else {
        result.add(GoHelper.goCompLight(gameFieldHorizont, result.get(u)));
      }
    } while (true);
  }
}

/*
Сегодня мы играем в крестики-нолики. Но для того, чтобы в них играть, сначала придется их написать.

Суть игры в следующем. Есть условное поле три-на-три, я предлагаю нумеровать клеточки следующим образом:

1 2 3
4 5 6
7 8 9

Человек играет за крестики, то есть делает ход первым. Компьютер - за нолики. Когда ходит человек, программа должна просить ввести номер ячейки, на которое человек хочет поставить свой крестик. Если поле занято, компьютер должен просить ввести другое число. После хода человека программа должна вывести текущее состояние поля. Например, я решил поставить крестик на поле номер 5. Лог будет следующим:

Человек поставил крестик на клетку 5.

1 2 3
4 X 6
7 8 9

После этого компьютер спрашивает - это конец игры? Человеку надо ввести Y в случае, если кто-то победил или если на поле закончились свободные клеточки. В другом случае - N.
Если ввели Y, игра заканчивается, программа останавливается. Иначе начинается ход компьютера.

Компьютер выбирает поле по очень простому алгоритму - он занимает клеточку с наименьшею цифрой. То есть в нашем случае ходит на клеточку 1. Лог программы следующий:

Компьютер поставил нолик на клетку 1.

O 2 3
4 X 6
7 8 9

Далее программа снова спрашивает, закончилась ли игра. Снова вводим Y или N. Если ввели Y - игра заканчивается. Иначе снова начинается ход человека, у которого программа снова должна спросить, на какую клетку он ходит.

Важный момент - после каждого хода, человека или компьютера, нужно распечатывать текущее состояние поля.

Задача решается при помощи массива из трех массивов. :)
*/