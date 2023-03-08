package io.github.justfoxx.teacup.v1.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.stream.JsonReader
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

/**
 * A utility class for working with JSON data.
 */
object JsonHelper {
    /**
     * The default Gson object used for parsing and formatting JSON data.
     */
    val GSON: Gson = GsonBuilder().setPrettyPrinting().create()

    /**
     * Reads a JSON object from a file.
     *
     * @param filePath The path to the JSON file.
     * @return The JSON object.
     * @throws FileNotFoundException If the file is not found.
     */
    @Throws(FileNotFoundException::class)
    fun readJsonObject(filePath: Path): JsonObject {
        val file = filePath.toFile()
        return jsonReader(file)
    }

    /**
     * Writes a JSON object to a file.
     *
     * @param data The JSON object to write to the file.
     * @param filePath The path to the file.
     * @return The JSON object.
     * @throws Exception If the file is not found or if the data cannot be written to the file.
     */
    @Throws(Exception::class)
    fun writeJsonObject(data: JsonObject, filePath: Path): JsonObject {
        val file = filePath.toFile()
        return jsonWriter(data, file)
    }

    /**
     * Converts an object to a JSON object and writes it to a file.
     *
     * @param data The object to convert to a JSON object and write to the file.
     * @param filePath The path to the file.
     * @return The JSON object.
     * @throws Exception If the file is not found or if the data cannot be written to the file.
     */
    @Throws(Exception::class)
    fun writeJsonObject(data: Any, filePath: Path): JsonObject {
        val jsonObject = GSON.toJsonTree(data).asJsonObject
        return writeJsonObject(jsonObject, filePath)
    }

    /**
     * Gets a default JSON object from a file. If the file does not exist, writes the default object to the file.
     *
     * @param defaultObject The default object to write to the file if the file does not exist.
     * @param filePath The path to the file.
     * @return The JSON object.
     * @throws Exception If the file is not found or if the data cannot be written to the file.
     */
    @Throws(Exception::class)
    fun getDefaultJsonObject(defaultObject: Any?, filePath: Path): JsonObject {
        return if (defaultObject != null)
            writeJsonObject(defaultObject, filePath)
        else
            JsonObject()
    }

    fun <T> convert(jsonObject: JsonObject, clazz: Class<T>): T {
        return GSON.fromJson(jsonObject, clazz)
    }

    @Throws(FileNotFoundException::class)
    private fun jsonReader(file: File): JsonObject {
        val reader = JsonReader(FileReader(file))
        return JsonParser.parseReader(reader).asJsonObject
    }

    @Throws(IOException::class)
    private fun jsonWriter(data: JsonObject, file: File): JsonObject {
        Files.writeString(file.toPath(), GSON.toJson(data))
        return jsonReader(file)
    }

}