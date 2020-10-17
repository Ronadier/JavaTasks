import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task5hard {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String str = reader.readLine();
    System.out.println("Хэш до засолки");
    System.out.println(md5Apache(str));
    String salt = getSalt(str); //Получаем соль
    String strWithSalt = str + salt; //Получаем строку+соль
    String hash = md5Apache(strWithSalt); //Получаем хэш
    String fileName = "hash.txt";
    System.out.println("Введите строку для поиска хэша");
    String hashToFunc = md5Apache(reader.readLine());
    writeToFile(fileName, str, salt, hashToFunc);

    isFileContainsHash(fileName,hash);

  }

  private static String md5Apache(String st) {
    String md5Hex = DigestUtils.md5Hex(st);

    return md5Hex;
  }

  private static String getSalt(String str){
    char[] salt = new char[str.length()];
    char[] a1 = str.toCharArray();
    for (int i=0;i<salt.length;i++){
      salt[i] = (char) (a1[i] - 1);
    }
    String result = String.copyValueOf(salt);
    return result;
  }

  private static void writeToFile(String fileName, String str, String salt, String hash){
    try(FileWriter writer = new FileWriter(fileName, true))
    {
      writer.write("String: " + str +"\n");
      writer.write("Salt: " + salt + "\n");
      writer.write("Hash: " + hash + "\n");
      writer.flush();
    }
    catch(IOException ex){
      System.out.println(ex.getMessage());
    }
  }

  private static void isFileContainsHash (String fileName, String hash) throws IOException {
    List<String> s = Files.readAllLines(Paths.get(fileName));
    boolean isContains = false;
    for (int i = 0;i<s.size();i++){
     if (s.get(i).contains(hash)){
       System.out.println(); //Пустая строка для красоты
       System.out.println(s.get(i));
       System.out.println(s.get(i-1));
       System.out.println(s.get(i-2));
       isContains = true;
     }
    }
    if (!isContains) System.out.println("Сорян, хэша нет");
  }
}

/*
А тут сегодня будем работать с соленым md5 и файлами.

Нужно написать две функции.

Первая принимает на вход строку, ""солит"" ее и хеширует в md5 (да-да, он устарел, но для тренировки ничем не плох). Так как md5 не поддается обратной расшифровке, нужно в файлике рядом в любом удобном вам формате запоминать изначальную строку, соль и хеш. Будет круто, если соль будет динамической и меняться по какой-то логике в зависимости от строки.

Вторая функция должна получать на вход хеш и искать его с нашем файле. Если такое хеш уже был однажды сгенерен, функция должна возвращать соль и изначальное значение. Иначе кидать исключение.

О том, что такое соль можно почитать тут или поискать информацию на Хабре - https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D0%BB%D1%8C_(%D0%BA%D1%80%D0%B8%D0%BF%D1%82%D0%BE%D0%B3%D1%80%D0%B0%D1%84%D0%B8%D1%8F)

Что такое хеш можно почитать тут или поискать информацию на Хабре - https://ru.wikipedia.org/wiki/%D0%A5%D0%B5%D1%88-%D1%84%D1%83%D0%BD%D0%BA%D1%86%D0%B8%D1%8F

О том, что такое md5 можно почитать тут или поискать информацию на Хабре - https://ru.wikipedia.org/wiki/MD5
 */