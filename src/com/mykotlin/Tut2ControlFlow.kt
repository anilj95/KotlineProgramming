package com.mykotlin

// if else, when(switch), for & while loop

fun main(args: Array<String>) {

    //com.mykotlin.findmax()
    //com.mykotlin.planetPosition()
    //com.mykotlin.typeChecking()
    loopBasics()
}

fun findmax() {
    var x = 10
    var y = 20

    var max: Int?
    // normal style of for loop
    if (x > y) {
        max = x
        println("X is greater$max")
    } else {
        max = y
        println("Y is greater$max")
    }

    // if else as statement (in a single line):  which return a value(must write else part also)

    var maxNumber = if (x > y) x else y
    println("Max number is: $maxNumber")

}

// when :  replacement of switch satatement

fun planetPosition() {

    var position = 7
    var message: String?
// normal way of when statement
    when (position) {
        0 -> message = "You must be joking"
        1 -> message = "You are in jupitor"
        2 -> message = "You are in moon"
        3 -> message = "You are on earth"
        4 -> message = "You are in outer solar"
        else -> message =
            "I am not sure what you are" // this is mandetory(otherwise compile time error). Acts as default case
    }

    //println(message)
    // when as a statement: that is, it return a value
    //Cases will not always be constant(integer here,0,1,2,3,4,5..), it can be boolean also unlike switch case
    message = when (position) {
        0 -> "You must be joking"
        1, 2 -> "You are in jupitor" // combining to statement
        in 3..6 -> "You are on earth" // using range operator(double dot(..) operator)
        7 -> "You are in outer solar"
        8 -> "You are in space"
        9 -> "You are in pune"
        else -> "I am not sure what you are"
    }

    println(message)

}

// when is also used as type checking
fun typeChecking() {
    var dataValue: Any =
        10.00 // Any can be any data type : It is the super class of all Kotlin classes but dont compare with object class in java.
    var message: String?
    message = when (dataValue) {

        is Float -> "This is Float data type"
        is Double -> "This is Double data type"
        is Int -> "This is Int data type"
        !is Long -> "This is Long data type" // not is(!is) can also be used as per requirements
        else -> "Unhandled data type"
    }
    println(message)
}

// loops

fun loopBasics() {
    // some basic keywords used in looping
    for (i in 1..8) {
    }
    for (i in 1..8 step 3) {
    } //print 1 to 8 after every 2 no.
    for (i in 1.rangeTo(6)) {
    } // print 1 to 6
    for (i in 5.downTo(1) step 2) {
    } // print 5 to 1 alternate no.
    for (i in 1 until 9) {
    } // will exclude last element

    var sampleArray = arrayOf(3, 4, 5, 6, 7)
    for (number in sampleArray.indices) {
        // println(sampleArray[number])
    }
    for ((index, value) in sampleArray.withIndex()) {
        // println("$index -> $value")
    }
// labelled for loop
    outerfroloop@for (i in 1..3) {

        innerloop@for (j in 1..3) {

            if (j == 2) break@outerfroloop
            println("i: $i, j: $j")
        }
    }
}