package com.example.devintensive.utils

//Объект - статически объявляемая фкнукция внутри объектов
object Utils {
    fun parseFullName(fullName:String?) : Pair<String?, String?>{
        val parts: List<String>? = fullName?.split(" ")

        //нужно вернуть отдельно имя и отдельно фамилию
        var firstName = parts?.getOrNull(0) //если в нашей колекции нет объекта с индексом 0, то вернет null
        var lastName = parts?.getOrNull(1)
//        return Pair(firstName, lastName)

        if (firstName.isNullOrEmpty()) firstName = null
        if (lastName.isNullOrEmpty()) lastName = null


        return firstName to lastName // то же самое только короткая запись
    }

    fun transliteration(payload: String, divider: String = " "): String {
            var trans: String = "2"
            trans += "wd"
        return trans
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        when{
            firstName.isNullOrEmpty() && lastName.isNullOrEmpty() -> return null
            !firstName.isNullOrEmpty() && lastName.isNullOrEmpty() -> return firstName?.get(0).toString().toUpperCase()
            firstName.isNullOrEmpty() && !lastName.isNullOrEmpty() -> return lastName?.get(0).toString().toUpperCase()
            else -> return "${firstName?.get(0).toString()}${lastName?.get(0).toString()}".toUpperCase()
        }
    }
}