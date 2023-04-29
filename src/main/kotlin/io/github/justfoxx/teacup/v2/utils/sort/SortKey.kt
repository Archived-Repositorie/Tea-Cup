package io.github.justfoxx.teacup.v2.utils.sort

data class SortKey<Value,Data : Comparable<Data>>(val value: Value, val sortKey: Data): Comparable<SortKey<Value, Data>> {
    override fun compareTo(other: SortKey<Value, Data>): Int {
        return this.sortKey.compareTo(other.sortKey)
    }
}