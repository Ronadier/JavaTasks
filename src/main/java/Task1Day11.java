import Helpers.InputHelper;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Random;

public class Task1Day11 {
  public static void main(String[] args) throws IOException {
    int a1 = InputHelper.getInt();
    int a = a1;
    System.out.println(LocalTime.now()); // выведем время
    do {
      a1 = new Random().nextInt();
    }while (a1 != a); //фигачим циклом рандом пока не будет то число, что мы ввели

    int a2 = InputHelper.getInt();
    do {
      a1 = new Random().nextInt();
    }while (a1 != a); //фигачим циклом рандом пока не будет то число, что мы ввели ещё раз

    String aa = Integer.toBinaryString(a1); //переведём в двоичную систему счисления оба числа
    String aaa = Integer.toBinaryString(a2);
    String b = aa + aaa; //сложим строки

    a = Integer.highestOneBit(Integer.parseInt(b)); //возьмём максимальный разряд из суммы строк
    a1 = Integer.highestOneBit(Integer.parseInt(aa)); //и из 1 числа
    do {
      a -= 1; //а теперь в цикле будем отнимать от максимального разряда по 1 чтоб получилась разность 1 и второго числа
    } while (a != a1 - a2);
    System.out.println(LocalTime.now());
    System.out.println(a);

  }
}

/*
Сегодня задачка будет общей для всех уровней. Я решил немного повеселиться, а то все работа и работа... Сегодня предлагаю расслабиться и написать какую-нибудь чушь. Функцию, которая работает максимально странно и неожиданно.
Более того, я предлагаю сделать конкурс - автор самого забавного и интересного варианта получит бесплатный доступ на мой вебинар по автоматизации API на Python. Очень надеюсь, что он ему будет нужен. :)
Выбирать самый забавный вариант будем голосованием в группе.

Итак, мой вариант (он не участвует в конкурсе) будет на PHP, я напишу функцию, которая складывает два числа:

<?php

function getSum(int $a, int $b): int {
    // take current unix timestamp, e.g. 1603349486
    $current_time_1 = time();

    // do nothing $a seconds, e.g. 2
    sleep($a);

    // do nothing $b seconds, e.g. 3
    sleep($b);

    // take current unix timestamp, 1603349491 ($current_time_1 + 5 seconds)
    $current_time_2 = time();

    // 1603349491 seconds - 1603349486 seconds = 5
    $sum = $current_time_2 - $current_time_1;

    return $sum;
}

Функция сначала берет текущее время, потом ничего не делает $a и $b секунд последовательно и снова берет текущее время. Их разность и есть сумма $a и $b. Вот что-то такое странно и забавное на любую тематику я предлагаю написать. :)
 */