package io.github.justfoxx.teacup.v1.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonHelper {
    private JsonHelper() {
    }
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static JsonObject readJsonObject(Path filePath) throws FileNotFoundException {
        var file = filePath.toFile();
        return jsonReader(file);
    }

    public static JsonObject writeJsonObject(JsonObject data, Path filePath) throws Exception {
        var file = filePath.toFile();
        return jsonWriter(data,file);
    }

    public static JsonObject writeJsonObject(Object data, Path filePath) throws Exception {
        var jsonObject = GSON.toJsonTree(data).getAsJsonObject();

        return writeJsonObject(jsonObject,filePath);
    }

    private static JsonObject jsonReader(File file) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(file));
        return JsonParser.parseReader(reader).getAsJsonObject();
    }

    private static JsonObject jsonWriter(JsonObject data, File file) throws IOException {
        Files.writeString(file.toPath(), GSON.toJson(data));
        return jsonReader(file);
    }
}
