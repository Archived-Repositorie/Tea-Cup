package io.github.justfoxx.teacup.v2.utils.sort


class SortedList<Value, Key> where Key : Comparable<Key> {
    private val values: MutableList<SortKey<Value, Key>> = mutableListOf()
    fun add(value: Value, key: Key) {
        add(SortKey(value,key))
    }

    private fun add(valueKey: SortKey<Value, Key>) {
        val index = getSortedPlace(valueKey)
        values.add(index, valueKey)
    }

    private fun getSortedPlace(key: SortKey<Value, Key>): Int {
        var left = 0
        var right = values.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            when {
                values[mid] == key -> return mid
                values[mid] < key -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return left
    }

    fun iterator(): Iterable<Value> {
        return values.map { it.value }.asIterable()
    }
}