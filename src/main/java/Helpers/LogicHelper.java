package Helpers;

import Task6.Human;
import Task6.Task6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LogicHelper {
  static int getLengthWithoutSpaces(String str){
    String[] words = str.split("\\s"); // Разбиение строки на слова с помощью разграничителя (пробел)
    int length = 0;
    for (String s : words){
      length+=s.length();
    }
    return length;
  }

  static String replaceForbiddenWords(String str, List<String> forbiddenWords){
    String replace = str;
    for (String f : forbiddenWords){
       replace = replace.replace(f,"***");
      }
    return replace;
    }

  static String getShortText(String str, int maxLength){
    if (str.length() <= maxLength ) return str;
    else {
      String replace = str.substring(0,maxLength);
      replace = replace + "...";
      return replace;
      }
  }

}
