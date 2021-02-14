package com.example.devintensive.utils

//Объект - статически объявляемая фкнукция внутри объектов
object Utils {
    fun parseFullName(fullName:String?) : Pair<String?, String?>{
        val parts: List<String>? = fullName?.split(" ")

        //нужно вернуть отдельно имя и отдельно фамилию
        val firstName = parts?.getOrNull(0) //если в нашей колекции нет объекта с индексом 0, то вернет null
        val lastName = parts?.getOrNull(1)
//        return Pair(firstName, lastName)
        return firstName to lastName // то же самое только короткая запись
    }
}