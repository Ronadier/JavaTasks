import java.time.LocalTime;

public class Task1Day26 {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    //тут вызываем какую-нибудь функцию
    int a=0;
    for (int i = 0; i<100000000;i++){
      for (int j = 0;j<10;j++) {
        a++;
      }
    }
    //цикл сверху просто для примера
    long endTime = System.currentTimeMillis();
    long diffMillis = endTime-startTime;
    long diffSecond = diffMillis/1000;
    System.out.println("Функция выполнилась за " + diffMillis + " мс");
    System.out.println("Функция выполнилась за " + diffSecond + " с");
  }
}

/*
П - профилирование

Сегодня финальный день и мы напишем довольно полезный класс, который поможет нам замерять время работы наших программ и отдельных частей.

Суть задачи максимально простая — надо написать удобный в использовании класс, с помощью которого можно замерить работу какого-то участка кода. Вот самый простой пример подобного кода (не оформленного в виде класса), который можно взять за основу:

start_time = getCurrentTime();
callMethod();
run_time = getCurrentTime() - start_time;
print("callMethod() worked " + run_time " seconds");

Здесь мы замеряем время работы метода callMethod в секундах. От класса ожидается возможность замеры времени в секундах (полезно для UI тестов) и миллисекундах (полезно для API и unit тестов).
 */