package Helpers;

import org.json.JSONObject;

import java.util.List;

public class JSONhelper {
  public static void generateAndPrintJSON(String str, List<String> forbiddenWords, int maxLength){
    // convert Java to json
    JSONObject root = new JSONObject(); // создаем главный объект JSON
    root.put("length", str.length());
    root.put("pure_length", LogicHelper.getLengthWithoutSpaces(str));
    root.put("origin_text", str);
    root.put("pure_text", LogicHelper.replaceForbiddenWords(str,forbiddenWords));
    root.put("pure_short_text", LogicHelper.getShortText(str, maxLength));
    String json = root.toString();
    System.out.println(json);

  }
}
