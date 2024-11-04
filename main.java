// src/Main.java
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class main {
    public static void main(String[] args) {
        System.out.println("Hola, mundo!");

        // Leer y mostrar dependencias desde un archivo JSON
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("dependencies.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray dependencies = (JSONArray) jsonObject.get("dependencies");

            System.out.println("Dependencias:");
            for (Object dep : dependencies) {
                JSONObject dependency = (JSONObject) dep;
                System.out.println("- " + dependency.get("name") + " (v" + dependency.get("version") + ")");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
