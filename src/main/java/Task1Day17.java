import Helpers.InputHelper;
import com.ibm.icu.text.RuleBasedNumberFormat;

import java.io.IOException;
import java.util.Locale;

public class Task1Day17 {
  static final String[] BELOW_TWENTY = { "ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцадь", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать" };
  static final String[] TENS = { "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто" };
  static final String[] HUNDREDS = { "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемсот", "девятьсот"};
  static final String[] THOUSANDS = {"тысяча", "тысячи", "тысяч"};
  static final String[] MILLIONS = {"миллион", "миллиона", "миллионов"};
  public static void main (String[] args) throws IOException {
    int startInt = InputHelper.getInt();
    String startStr = String.valueOf(startInt);
    char[] startChar = startStr.toCharArray();
    RuleBasedNumberFormat nf = new RuleBasedNumberFormat(Locale.forLanguageTag("cz"), //готовая библиотека под это для проверки
            RuleBasedNumberFormat.SPELLOUT);
    System.out.println(nf.format(startInt));


    String text = "";
    if (startInt < 1000){
      text = fromOneToThousand(startInt);
    } else if (startInt < 1000000){
      text = fromOneToThousand(startInt/1000) + " " + THOUSANDS[0] + " " + fromOneToThousand(startInt%1000);
    } else if (startInt < 1000000000)
      text = fromOneToThousand(startInt/1000000) + " " + MILLIONS[0] + " " + fromOneToThousand(startInt/1000) + " " + THOUSANDS[0] + " " + fromOneToThousand(startInt%1000);
    System.out.println(text);
      //System.out.println(HUNDREDS[0]);
  }

  private static String fromOneToThousand(int startInt){
    if ( startInt < 20 )
      return BELOW_TWENTY[startInt];
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
    int mid = startInt % 10;
    mid = mid/10;
    int low = startInt % 10;
    String text = HUNDREDS[high - 1] + " " + TENS[mid];
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