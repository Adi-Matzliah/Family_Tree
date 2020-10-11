package com.exercise.gm.familytree

class MyList<T> {
    private var size = 0
    private val DEFAULT_CAPACITY = 10
    private lateinit var elements: Array<Any?>

    init {
        elements = arrayOfNulls(DEFAULT_CAPACITY)
    }

    fun add(e: T?) {
        if (size == elements.size) {
            ensureCapa()
        }
        elements[size++] = e
    }


    private fun ensureCapa() {
        val newSize = elements.size * 2
        elements = elements.copyOf(newSize)
    }

    operator fun get(i: Int): T? {
        if (i >= size || i < 0) {
            throw IndexOutOfBoundsException("Index: $i, Size $i")
        }
        return elements[i] as T?
    }

    fun size() : Int = size
}