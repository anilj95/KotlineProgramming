package com.mykotlin

// Filter:
// It returns a list containing the only elements which matching the given conditions(Predicates)

//Map:

//It returns the modified list from original list after trasformation.

//Predicates functions in Kotlin

// Predicates are condition that returns either True or False.

fun main(args: Array<String>) {

    var myArray = listOf(2, 3, 4, 6, 43, 90)

    var mySmallNum = myArray.filter { it < 10 } // { num -> num <10}

    for (num in mySmallNum) {

        //println(num)
    }

    var mySquaredNums = myArray.map { it * it } // {num -> num*num}


    for (num in mySquaredNums) {

       // println(num)
    }
// applying filter & map both at a time.

    val mySquaredSmallNums = myArray.filter { it < 10 }
        .map { it * it }

    for (num in mySquaredSmallNums) {

        println(num)
    }

 var myList = listOf<Person>(Person(10,"Anni"),Person(13,"Aooja"),Person(20,"Rama"))


 var names = myList.filter { Person -> Person.name.startsWith("A") }.map { it.name } // printing all person names starrt with 'A'


    for (name in names){
    println(name)
 }

    //Predicates functions in Kotlin : all,any,count,find
 // 1)   all : do all elements satisfy the condition
    
    var value: Boolean = myArray.all { it<10 }  // return false, not all elements are less than 10 in the list.
    println(value)

    // 2)   any : does any one elements satisfy the condition

    var value1: Boolean = myArray.any { it<10 }  // return true
    println(value1)

    // 3)   count : return all elements satisfy the condition return type is Int

    var value2: Int = myArray.count() { it>10 } // return 2, as two elements are greater than 10 inthe list

    println(value2)

    // 4)   find : return first elements which satisfy the condition return type is Int

    var value3: Int? = myArray.find { it>10 } // return 43 , first element greater than 10

    println(value3)

    //*** Lazy keyword:

    // lazy intialization is initialized only if you use it, & it is initialize only once & saved into cache memory.

    val pi :Float by lazy {  3.14f }

    val area1 = 2*pi*10

    println(area1)


    genericFunc<String>()

}




// reified type parameter.
inline fun <reified T> genericFunc() {
    print(T::class)
}

class Person(var age:Int, var name:String){


}


