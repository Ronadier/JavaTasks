package Day12;

import Helpers.InputHelper;

import java.io.IOException;

import static Day12.Task1Day12.timeDifference;

public class Task2Day12 {
  public static void main(String[] args) throws IOException, BadMinuteException, BadFormatException, BadHourException, Task1Day12.TimeTravellingException {
    System.out.println("Enter now");
    String now = InputHelper.getStr();
    checkException(now);
    System.out.println("Enter future");
    String future = InputHelper.getStr();
    checkException(future);
    System.out.println(timeDifference(now, future));
  }

  private static void checkException(String now) throws BadFormatException, BadHourException, BadMinuteException {
    if (!now.contains(":") || now.contains(".") || now.contains("!") || now.contains(",") || now.contains(";")){
      throw new BadFormatException("Формат кривой");
    } else {
      String[] nowArr = now.split(":");
      int hour = Integer.parseInt(nowArr[0]);
      if (hour > 23 || hour < 0) throw new BadHourException("Количество часов должно быть 0-23");
      int min = Integer.parseInt(nowArr[1]);
      if (min > 59 || min < 0) throw new BadMinuteException("Количество минут должно быть 0-59");
    }
  }

  static class BadFormatException extends Exception{
    public BadFormatException(String message) {
      System.out.println(message);
    }
  }

  static class BadHourException extends Exception{
    public BadHourException(String message) {
      System.out.println(message);
    }
  }
  static class BadMinuteException extends Exception{
    public BadMinuteException(String message) {
      System.out.println(message);
    }
  }
}




/*
А мы с вами сегодня поработаем с исключениями. У вас та же задача, только вам ничего не гарантируется. Может прийти абсолютно рандомных две строки. Либо вообще не по формату, тогда надо кидать BadFormatException (его надо создать). Либо значение часа вываливается за рамки (например равно 25), тогда надо кидать BadHourException. Либо количество минут - BadMinuteException. Либо вторая строка означает время в прошлом - TimeTravellingException. А может еще что-то... :)

Функция (или код), которая вызывает нашу функцию, должна оборачивать вызов в try и несколько catch'ей. На каждое исключение надо писать какое-то свое сообщение.
 */