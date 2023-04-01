package io.github.justfoxx.teacup.v1.utils

class StringFormater(private val format: HashMap<String,Any>) {
    fun add(key: String, value: Any) {
        format[key] = value
    }
    fun addAll(format: HashMap<String,Any>) {
        this.format.putAll(format)
    }
    fun format(string: String): String {
        var result = string
        for (pair in format) {
            result = result.replace(pair.key, pair.value.toString())
        }
        return result
    }
}
