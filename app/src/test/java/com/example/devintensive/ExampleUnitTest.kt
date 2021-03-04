package com.example.devintensive

import com.example.devintensive.extensions.TimeUnits
import com.example.devintensive.extensions.add
import com.example.devintensive.extensions.format
import com.example.devintensive.extensions.toUserView
import com.example.devintensive.models.User
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
//        val user = User("1")
        val user2 = User("2", "Petya", "Smith")
//        val user3 = User("3", "Yoda", "Staryi", null, lastVisit =  Date(), isOnline = true)

//        user.printMe()
//        user2.printMe()
//        user3.printMe()
    }

    @Test
    fun test_factory() {
        val user1 = User.makeUser("Anna Losk")
//        val user2 = User.makeUser("Yulia Losk")
//        val user3 = User.makeUser("")
        val user2 = user1.copy(id = "2", firstName = "Yulia", lastVisit = Date().add(-2, TimeUnits.MINUTE))
        val user3 = user1.copy(id = "3", firstName = "Svetya", lastVisit = Date().add(4, TimeUnits.HOUR))

        println("""
            ${Date()?.format()} Current date
            ${user2.lastVisit?.format()} user2
            ${user3.lastVisit?.format()} user3
        """.trimIndent())
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("Sveta Kuznetsova")

        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
        //при помощи декомпозиции увидели значения нашего объекта
    }

    @Test
    fun test_copy() {

        //При создании пользователей и при корировании - ссылки будут разными, т.к. они хранятся по разным адресам. выделяется разные участки памяти
        // Если user=user2, то сылка у них будет одинаковая и при изменнении одного обхекта - изменится и другой. Ссылаются на один и тот же участок паямяти
        val user = User.makeUser("Danila Akhtyamov")
        val user2 = user.copy(id = "2", lastVisit = Date()) //при копировании не ссылается на предыдущий

        if (user==user2) {
            println("equals data and hash\n ${user.hashCode()} $user \n ${user.hashCode()} $user2")
        } else {
            println("not equals data and hash\n ${user2.hashCode()} $user \n ${user.hashCode()} $user2")
        }

        if (user===user2) {
            println("equals address ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
        } else {
            println("not equals address ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
        }

    }

    @Test
    fun test_data_maping() {
        val user = User.makeUser("Максим Долгопятов")
        val newUser = user.copy(lastVisit =  Date().add(-7, TimeUnits.SECOND))
        val userView = newUser.toUserView()

        userView.printMe()
    }
}