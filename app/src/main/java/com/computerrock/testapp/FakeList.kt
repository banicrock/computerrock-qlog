package com.computerrock.testapp

class FakeList<in T : Any> {

    private val list: MutableList<T> = mutableListOf()

    fun add(element: T) {
        list.add(element)
    }

    fun getAt(index: Int) {
        list[index]
    }
}

class Main() {
    fun main() {
        val list: FakeList<Int> = FakeList()
        list.add(11)

        val listS: FakeList<String> = FakeList()
        listS.add("String")
    }
}