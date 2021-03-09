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

    private fun replacement(word: String?) : String {
        var trans = ""
        if (word != null) {
            for (element in word) {
                when(element) {
                    'а', 'А' -> trans += "a"
                    'б', 'Б' -> trans += "b"
                    'в', 'В' -> trans += "v"
                    'г', 'Г' -> trans += "g"
                    'д', 'Д' -> trans += "d"
                    'е', 'Е' -> trans += "e"
                    'ё', 'Ё' -> trans += "e"
                    'ж', 'Ж' -> trans += "zh"
                    'з', 'З' -> trans += "z"
                    'и', 'И' -> trans += "i"
                    'й', 'Й' -> trans += "i"
                    'к', 'К' -> trans += "k"
                    'л', 'Л' -> trans += "l"
                    'м', 'М' -> trans += "m"
                    'н', 'Н' -> trans += "n"
                    'о', 'О' -> trans += "o"
                    'п', 'П' -> trans += "p"
                    'р', 'Р' -> trans += "r"
                    'с', 'С' -> trans += "s"
                    'т', 'Т' -> trans += "t"
                    'у', 'У' -> trans += "u"
                    'ф', 'Ф' -> trans += "f"
                    'х', 'Х' -> trans += "h"
                    'ц', 'Ц' -> trans += "c"
                    'ч', 'Ч' -> trans += "ch"
                    'ш', 'Ш' -> trans += "sh"
                    'щ', 'Щ' -> trans += "sh"
                    'ъ', 'Ъ' -> trans += ""
                    'ы', 'Ы' -> trans += "i"
                    'ь', 'Ь' -> trans += ""
                    'э', 'Э' -> trans += "e"
                    'ю', 'Ю' -> trans += "yu"
                    'я', 'Я' -> trans += "ya"
                    else -> trans += element
                }
            }
        }
        return trans
    }

    fun transliteration(payload: String, divider: String = "_"): String {
        val parts: List<String>? = payload.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        val fName = replacement(firstName).capitalize()
        val lName = replacement(lastName).capitalize()

        return "${fName}${divider}${lName}"
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return when{
            firstName.isNullOrEmpty() && lastName.isNullOrEmpty() -> null
            !firstName.isNullOrEmpty() && lastName.isNullOrEmpty() -> firstName[0].toString().toUpperCase()
            firstName.isNullOrEmpty() && !lastName.isNullOrEmpty() -> lastName[0].toString().toUpperCase()
            else -> "${firstName?.get(0).toString()}${lastName?.get(0).toString()}".toUpperCase()
        }
    }
}