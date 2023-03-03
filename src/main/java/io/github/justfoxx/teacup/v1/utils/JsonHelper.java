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
import java.util.Optional;

/**
 * A class that helps with json
 */
public final class JsonHelper {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Reads a json object from a file
     * @param filePath The path to the json file
     * @return The json object
     * @throws FileNotFoundException If the file is not found
     */
    public static JsonObject readJsonObject(Path filePath) throws FileNotFoundException {
        var file = filePath.toFile();
        return jsonReader(file);
    }

    /**
     * Writes a json object to a file
     * @param data The data to write to the file
     * @param filePath The path to the file
     * @return The json object
     * @throws Exception If the file is not found or if the data cannot be written to the file
     */
    public static JsonObject writeJsonObject(JsonObject data, Path filePath) throws Exception {
        var file = filePath.toFile();
        return jsonWriter(data,file);
    }

    /**
     * Writes a json object to a file
     * @param data The data to write to the file
     * @param filePath The path to the file
     * @return The json object
     * @throws Exception If the file is not found or if the data cannot be written to the file
     */
    public static JsonObject writeJsonObject(Object data, Path filePath) throws Exception {
        var jsonObject = GSON.toJsonTree(data).getAsJsonObject();
        return writeJsonObject(jsonObject,filePath);
    }

    /**
     * Writes a json object to a file
     * @param defaultObject The default object to write to the file if the file does not exist
     * @param path The path to the file
     * @return The json object
     * @throws Exception If the file is not found or if the data cannot be written to the file
     */
    public static JsonObject getDefaultJsonObject(Optional<Object> defaultObject, Path path) throws Exception {
        return defaultObject.isPresent() ? writeJsonObject(defaultObject.get(), path) : new JsonObject();
    }

    private static JsonObject jsonReader(File file) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(file));
        return JsonParser.parseReader(reader).getAsJsonObject();
    }

    private static JsonObject jsonWriter(JsonObject data, File file) throws IOException {
        Files.writeString(file.toPath(), GSON.toJson(data));
        return jsonReader(file);
    }

    private JsonHelper() {
    }
}
