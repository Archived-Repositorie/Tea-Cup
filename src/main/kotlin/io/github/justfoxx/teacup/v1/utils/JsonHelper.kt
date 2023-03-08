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

val GSON: Gson = GsonBuilder().setPrettyPrinting().create()

/**
 * Reads a JSON object from a file.
 *
 * @return The JSON object.
 * @throws FileNotFoundException If the file is not found.
 */
@Throws(FileNotFoundException::class)
fun Path.readJsonObject(): JsonObject {
    val file = this.toFile()
    return file.jsonReader()
}

/**
 * Writes a JSON object to a file.
 *
 * @param data The JSON object to write to the file.
 * @return The JSON object.
 * @throws Exception If the file is not found or if the data cannot be written to the file.
 */
@Throws(Exception::class)
fun Path.writeJsonObject(data: JsonObject): JsonObject {
    val file = this.toFile()
    return file.jsonWriter(data)
}

/**
 * Converts an object to a JSON object and writes it to a file.
 *
 * @param data The object to convert to a JSON object and write to the file.
 * @return The JSON object.
 * @throws Exception If the file is not found or if the data cannot be written to the file.
 */
@Throws(Exception::class)
fun Path.writeJsonObject(data: Any): JsonObject {
    val jsonObject = GSON.toJsonTree(data).asJsonObject
    return this.writeJsonObject(jsonObject)
}

/**
 * Gets a default JSON object from a file. If the file does not exist, writes the default object to the file.
 *
 * @param defaultObject The default object to write to the file if the file does not exist.
 * @return The JSON object.
 * @throws Exception If the file is not found or if the data cannot be written to the file.
 */
@Throws(Exception::class)
fun Path.getDefaultJsonObject(defaultObject: Any?): JsonObject {
    return if (defaultObject != null)
        this.writeJsonObject(defaultObject)
    else
        JsonObject()
}

/**
 * Converts a JSON object to a object of the specified class.
 *
 * @param type The class of the object to convert to.
 * @return The Java object converted from the JSON object.
 */
fun <T> JsonObject.convertTo(type: Class<T>): T {
    return GSON.fromJson(this, type)
}

@Throws(FileNotFoundException::class)
private fun File.jsonReader(): JsonObject {
    val reader = JsonReader(FileReader(this))
    return JsonParser.parseReader(reader).asJsonObject
}

@Throws(IOException::class)
private fun File.jsonWriter(data: JsonObject): JsonObject {
    Files.writeString(this.toPath(), GSON.toJson(data))
    return this.jsonReader()
}