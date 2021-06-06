package com.cesarpa.model

class InnerDemo

fun main() {
    var a: (Int) -> Int = { number ->
        number * number
    }
    println(a(3))

    var printName: (String) -> Unit = { print("hola bola$it")}
    printName("cesarpa")

    val f = object : A{
        override fun show() {
            print("Oh genial")
        }
    }
    f.show()
}

typealias KotlinShowAlias = () -> Unit

class X:A{
    override fun show() {
        TODO("Not yet implemented")
    }
}

interface A {
    fun show()
}