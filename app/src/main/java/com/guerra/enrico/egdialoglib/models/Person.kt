package com.guerra.enrico.egdialoglib.models

/**
 * Created by enrico
 * on 09/07/2018.
 */
class Person(val id: String, val name: String) {
    companion object {
        fun getList(): List<Person> {
            val list = ArrayList<Person>()
            list.add(Person("1", "Peter"))
            list.add(Person("2", "Alan"))
            list.add(Person("3", "Phil"))
            return list
        }
    }
}