package com.example.samplecomposeapp.ui_practice.list.repository


import com.example.samplecomposeapp.ui_practice.list.model.Person

class PersonRepository {

    fun getAllData():List<Person>{
        return listOf(
        Person(id = 0,
            firstName = "John",
            lastName = "Doe",
            age = 21),

            Person(id = 1,
                firstName = "Mrunal",
                lastName = "Haris",
                age = 23),
            Person(id = 2,
                firstName = "Hyshal",
                lastName = "Doe",
                age = 30),
            Person(id = 3,
                firstName = "Ahmed",
                lastName = "John",
                age = 29),
            Person(id = 4,
                firstName = "Michal",
                lastName = "Doe",
                age = 31),
            Person(id = 5,
                firstName = "Maria",
                lastName = "Doe",
                age = 34)
        )
    }
}