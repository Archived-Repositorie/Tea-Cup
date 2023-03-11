package io.github.justfoxx.teacup.v1.utils

import com.google.common.collect.ImmutableSet

fun <T: Comparable<T>> List<T>.binarySortedPlace(target: T): Int {
    var left = 0
    var right = this.size - 1
    while (left <= right) {
        val mid = (left + right) / 2
        when {
            this[mid] == target -> return mid
            this[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return left
}

fun <T : Comparable<T>> MutableList<T>.addSorted(value: T) {
    val index = this.binarySortedPlace(value)
    this.add(index, value)
}

fun <T> List<T>.toSet(): Set<T> {
    return ImmutableSet.copyOf(this)
}
