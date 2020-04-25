package com.mykotlin

fun main(args: Array<String>) {
    var objProgram = Program()
    // calling simple way type
    objProgram.addNumber(2, 7)
    // calling interface way type : objProgram.addNumber(2,8, new OnCLickListener(... onClick()){}) : but we dont have 'new' keyword

    objProgram.addNumber(4, 6, object : MyInterface {
        override fun execute(sum: Int) {
            println(sum)
        }

    })
    // Calling Lambda type function
    var myLambda: (Int) -> Unit = { s: Int -> println(s) }
    objProgram.addNumber(1, 2, myLambda) // way 1

    // you can pass Lambda expression directely inside addNumber like below, code will work fine.

    objProgram.addNumber(1, 2, { s: Int -> println(s) }) // way 2
    objProgram.addNumber(1, 2) { s: Int -> println(s) } //OR..same as above (way 3)

    //calling closure
    var result = 0

    var myFuncLambda: (Int, Int) -> Unit = { x, y -> result = x + y }

    objProgram.addTwoNumbers(9, 7, myFuncLambda)

    println(result) // it will print result = 16 i.e we changed outside value inside Lambdas

    // calling  'it' keyword in function

    objProgram.reverseAndDisplay("Hello", { s -> s.reversed() })
    objProgram.reverseAndDisplay("Hello", { it.reversed() })// OR..same asa above() replaced single parameter(s -> s) with it.

    //using with() and apply{}
// These are present in Kotlin standered library not in Kotlin language

    with(objProgram){ // all variable & functions of Program clss can be called from this block.
        addNumber(2, 7) // no need to write objProgram.addNumber()
    }
   // similarly with apply{}, but apply returns receiver, here receiver is 'objProgram' so we can call methods of this object's class.

    objProgram.apply {
        addNumber(3,5)
        name = "Ram"
    }.exucute()

}

//High level functions in Kotlin:
//Can accept function as parameters, can also return a function as value. or both are possible in High level functions.

//Lambdas Expression/Function:
//These are the function without name : { paratemer -> functionBody} ex. : {s -> println("Ram")}
//val maLambda: (Int) -> Unit = {s:Int -> println("Ram")} : Println() does not have any return type so it can be Unit.
// 's' is type of Int : (Int) -> Unit going inside function an Int &  coming(return type) as Unit.
//Also: with two parameters Ex.:  val myLambda: (Int,Int) -> Int = {x,y -> x+y}

class Program {

    var name: String = ""

    fun exucute(){
        println("My name is $name")
    }

    fun addNumber(a: Int, b: Int) { // simple way

        val sum = a + b
        println(sum)
    }

    fun addNumber(a: Int, b: Int, action: MyInterface) { // Interface way in oops

        val sum = a + b
        action.execute(sum)
    }

    fun addNumber(a: Int, b: Int, action: (Int) -> Unit) { // High level function with Lambda as parameter.

        val sum = a + b
        action(sum) // sum is replacing 's' in calling function inside Lambda function(see main fun)
    }


    //Closure in Kotlin:
//In java 8, you can not change the value of outside variable inside Lambdas, but in Kotline you can change.

    fun addTwoNumbers(a: Int, b: Int, myFunc: (Int, Int) -> Unit) {

        myFunc(a, b)
    }

    // it keyword in Kotlin:
// it: Implicit name of Single parameter

    fun reverseAndDisplay(str: String, myReverse: (String) -> String) {

        var result = myReverse(str) // it.reversed() ==> str.reversed() ==> "Hello".reversed() ==> "olleH"
        println(result)
    }

}

interface MyInterface {

    fun execute(sum: Int)
}

