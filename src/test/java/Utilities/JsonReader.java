package Utilities;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class JsonReader {

    public static JSONObject getData() {

        try {

            String content = new String(
                    Files.readAllBytes(
                            Paths.get("src/test/resources/testData.json")));

            return new JSONObject(content);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}