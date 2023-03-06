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
 * A class that helps with json
 */
object JsonHelper {
    val GSON: Gson = GsonBuilder().setPrettyPrinting().create()

    /**
     * Reads a json object from a file
     * @param filePath The path to the json file
     * @return The json object
     * @throws FileNotFoundException If the file is not found
     */
    @Throws(FileNotFoundException::class)
    fun readJsonObject(filePath: Path): JsonObject {
        val file = filePath.toFile()
        return jsonReader(file)
    }

    /**
     * Writes a json object to a file
     * @param data The data to write to the file
     * @param filePath The path to the file
     * @return The json object
     * @throws Exception If the file is not found or if the data cannot be written to the file
     */
    @Throws(Exception::class)
    fun writeJsonObject(data: JsonObject, filePath: Path): JsonObject {
        val file = filePath.toFile()
        return jsonWriter(data, file)
    }

    /**
     * Writes a json object to a file
     * @param data The data to write to the file
     * @param filePath The path to the file
     * @return The json object
     * @throws Exception If the file is not found or if the data cannot be written to the file
     */
    @Throws(Exception::class)
    fun writeJsonObject(data: Any, filePath: Path): JsonObject {
        val jsonObject = GSON.toJsonTree(data).asJsonObject
        return writeJsonObject(jsonObject, filePath)
    }

    /**
     * Writes a json object to a file
     * @param defaultObject The default object to write to the file if the file does not exist
     * @param path The path to the file
     * @return The json object
     * @throws Exception If the file is not found or if the data cannot be written to the file
     */
    @Throws(Exception::class)
    fun getDefaultJsonObject(defaultObject: Optional<Any>, path: Path): JsonObject {
        return if (defaultObject.isPresent)
            writeJsonObject(defaultObject.get(), path)
        else
            JsonObject()
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