package com.example.devintensive.models

import com.example.devintensive.utils.Utils
import java.util.*

data class User (                        //первичный конструктор
    val id:String,
    var firstName:String?,
    var lastName: String?,
    var avatar: String?,
    var rating:Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline:Boolean = false
) {

//    var introBit :String    //дополнительные поле-переменная

//втоичный конструктор
    constructor(id: String, firstName: String?, lastName: String?) : this(
            id = id,
            firstName = firstName,
            lastName = lastName,
            avatar = null)
    //ещё один втоичный конструктор
    constructor(id:String) : this(id, "Ega", "Smith")

        init {
        println("Создан новый пользователь " +
                "${if (lastName==="Smith") "His name is $firstName $lastName" else "And his name is $firstName $lastName"}\n")
        }

    //Паттерн проектирования "Фабрика". Позволяет нам создавать объекты и их экземпляры. Удобан в в том случае если сделать какие-то проеобращования:
    //например, отформатировать код. Создавать пользотваеля через конструктор не всегда удобно. При помощи фабрики можем создать подготовительные расёте и сделать на основе их объект
    companion object Factory {
        private var lastID: Int = -1
        fun makeUser(fullName:String?) : User {
            lastID++
            //разобъём строку на 2 части через пробемл
            //parts - коллекция, которая содержит в себе строки
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id = "$lastID", firstName = firstName, lastName = lastName)
        }
    }

//    //блок инициализации
//    init {
//        introBit = getIntro()
//        println("It's Alive! " +
//                "${if (lastName==="Smith") "His name is $firstName $lastName" else "And his name is $firstName $lastName"}\n" +
//                "${getIntro()}")
//    }
//
//    private fun getIntro()= """
//        Taka Taka Taka DImi
//        TaKa TakaTi Taka Takadimi
//
//        Taka Taka Taka DImi
//        TaKa TakaTi Taka Takadimi
//        Taka Taka Taka DImi
//        TaKa TakaTi Taka Takadimi
//        ${"\n"}
//        $firstName $lastName
//    """.trimIndent()
//
//    //    Unit - аналог void  Java. Было -  fun printMe () : Unit {
//    fun printMe () = println("""
//                id: $id
//                firstName: $firstName
//                lastName: $lastName
//                avatar: $avatar
//                rating: $rating
//                respect: $respect
//                lastVisit: $lastVisit
//                isOnline: $isOnline
//        """.trimIndent())
}

