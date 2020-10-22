package Helpers;

import Task6.Human;

import java.text.MessageFormat;
import java.util.ArrayList;

public class PrintHelper {
  public static void printArrayOfHumans(ArrayList<Human> humans){
    humans.stream().map(s -> MessageFormat.format("id: {0}, name: {1}, fname: {2}, country: {3}, age: {4}, is_teen: {5}", s.id, s.name, s.fname, s.county, s.age, s.is_teen)).forEach(System.out::println);
  }
}
