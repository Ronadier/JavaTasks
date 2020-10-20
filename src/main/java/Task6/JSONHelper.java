package Task6;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JSONHelper {
  public static ArrayList<Human> initJSON(String fileName) throws IOException {
    String fileToStr = String.valueOf(Files.readAllLines(Paths.get(fileName)));
    fileToStr.replace("[","");
    fileToStr.replace("]","");
    JSONArray jsonArray = new JSONArray(fileToStr);
    JSONObject jsonObject;
    ArrayList<String> name = new ArrayList();
    ArrayList<Integer> id = new ArrayList<>();
    ArrayList<String> fname = new ArrayList<>();
    ArrayList<String> county = new ArrayList<>();
    ArrayList<Integer> age = new ArrayList<>();
    ArrayList<Boolean> isTeen = new ArrayList<>();
    ArrayList<Human> humans = new ArrayList<>();
    for (int i = 0; i < jsonArray.length(); i++) {
      jsonObject = jsonArray.getJSONObject(i);
      id.add(jsonObject.getInt("id"));
      name.add(jsonObject.getString("name"));
      fname.add(jsonObject.getString("fname"));
      county.add(jsonObject.getString("county"));
      age.add(jsonObject.getInt("age"));
      isTeen.add(jsonObject.getBoolean("is_teen"));
      humans.add(new Human(id.get(i), name.get(i), fname.get(i),county.get(i),age.get(i),isTeen.get(i)));
    }
    return humans;
  }

  public static void updateJSON(ArrayList<Human> humans, String fileName) {
    JSONArray jsonArray = new JSONArray();
    JSONObject jsonObject = new JSONObject();
    try (FileWriter writer = new FileWriter(fileName, false)) {
      writer.write("");
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    for (int i=0;i<humans.size();i++) {
      jsonObject.put("id", humans.get(i).id);
      jsonObject.put("name", humans.get(i).name);
      jsonObject.put("fname", humans.get(i).fname);
      jsonObject.put("county", humans.get(i).county);
      jsonObject.put("age", humans.get(i).age);
      jsonObject.put("is_teen", humans.get(i).is_teen);
      jsonArray.put(jsonObject);
      try (FileWriter writer = new FileWriter(fileName, true)) {
        writer.write(String.valueOf(jsonObject));
        if (i!=humans.size()-1) writer.write(",");
      } catch (IOException ex) {
        System.out.println(ex.getMessage());
      }
    }
  }
}
