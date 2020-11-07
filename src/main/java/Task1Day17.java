import Helpers.InputHelper;
import com.ibm.icu.text.RuleBasedNumberFormat;

import java.io.IOException;
import java.util.Locale;

public class Task1Day17 {
  static final String[] BELOW_TWENTY = { "ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцадь", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать" };
  static final String[] BELOW_TWENTY_F = {"ноль", "одна", "две"};
  static final String[] TENS = { "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто" };
  static final String[] HUNDREDS = { "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемmсот", "девятьсот"};
  static final String[] THOUSANDS = {"тысяча", "тысячи", "тысяч"};
  static final String[] MILLIONS = {"миллион", "миллиона", "миллионов"};
  public static void main (String[] args) throws IOException {
    int startInt = InputHelper.getInt();
    RuleBasedNumberFormat nf = new RuleBasedNumberFormat(Locale.forLanguageTag("ru"), //готовая библиотека под это для проверки
            RuleBasedNumberFormat.SPELLOUT);
    System.out.println(nf.format(startInt));


    String text = "";
    boolean isFemale = false;
    if (startInt < 1000){
      text = fromOneToThousand(startInt, isFemale);
    } else if (startInt < 1000000){
      text = fromThousandToMillion(startInt, isFemale);
    } else if (startInt < 1000000000) {
      text = fromMillionToBillon(startInt, isFemale);
    }
      System.out.println(text);
  }

  private static String fromMillionToBillon(int startInt, boolean isFemale){
    String text = "";
    int tens = (startInt/1000000)%100; //получаем разряд единиц для правильного склонения
    if ((startInt/1000000)%100 > 20) {
      tens = tens % 10;
    }
    switch (tens){
      case 1: text = fromOneToThousand(startInt / 1000000, isFemale) + " " + MILLIONS[0];
        break;
      case 2:
      case 3:
      case 4:
        text = fromOneToThousand(startInt / 1000000, isFemale) + " " + MILLIONS[1];
        break;
      default: text = fromOneToThousand(startInt / 1000000, isFemale) + " " + MILLIONS[2];
    }
    if (startInt % 1000000 > 1000){
      text +=  " " + fromThousandToMillion(startInt % 1000000, isFemale);
    } else if (startInt % 1000000 != 0){
      text +=  " " + fromOneToThousand(startInt % 1000000, isFemale);
    }
    return text;
  }

  private static String fromThousandToMillion(int startInt, boolean isFemale){
    String text = "";
    int tens = (startInt/1000000)%100; //получаем разряд единиц для правильного склонения
    if ((startInt/1000000)%100 > 20) {
      tens = tens % 10;
    }
    switch (tens){
      case 1 : text = fromOneToThousand(startInt/1000, isFemale=true) + " " + THOUSANDS[0];
        break;
      case 2:
      case 3:
      case 4:
        text = fromOneToThousand(startInt/1000, isFemale) + " " + THOUSANDS[1];
        break;
      default: text = fromOneToThousand(startInt/1000, isFemale) + " " + THOUSANDS[2];
    }
    if (startInt % 1000 !=0) {
      text += " " + fromOneToThousand(startInt % 1000, isFemale);
    }
    return text;
  }

  private static String fromOneToThousand(int startInt, boolean isFemale){
    if ( startInt < 20 && !isFemale) {
      return BELOW_TWENTY[startInt];
    } else if (startInt < 3 && isFemale) return BELOW_TWENTY_F[startInt];
    else if ( startInt < 100 ) {
      return lowHundert(startInt);
    }
    else if ( startInt < 1000 ) {
      return lowThousand(startInt);
    }
    return null;
  }

  private static String lowHundert (int startInt){
    int high = startInt / 10;
    int low = startInt % 10;
    String text = TENS[high-1];
    if ( low != 0 )
      text = text + " " + BELOW_TWENTY[low];
    return text;
  }

  private static String lowThousand (int startInt){
    int high = startInt / 100;
    int mid = startInt % 100;
    String text = "";
    if (mid == 0) return HUNDREDS[high-1];
    if (mid <= 20){
      text = HUNDREDS[high - 1] + " " + BELOW_TWENTY[mid];
      return text;
    } else {
      mid = mid/10;
      text = HUNDREDS[high - 1] + " " + TENS[mid-1];
    }
    int low = startInt % 10;
    if ( low != 0 )
      text = text + " " + BELOW_TWENTY[low];
    return text;
  }
}

/*
Сегодня мы будем работать с цифрами. А именно - писать число прописью :)

Задача очень простая, пишем на вход функцию, куда можно передать число от нуля до одного миллиарда. Функция должна написать прописью это число.

Например - передали 1,344,321

Ответ - Один миллион, триста сорок четыре тысячи, триста двадцать один
 */