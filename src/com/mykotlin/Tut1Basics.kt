package com.mykotlin

//Notes:1 Data Types:
// Same as java , But here no primitive type : All are classes in Kotline. So no Wrapping , Auto boxing- unboxing concept.
// Numbers: Short, Byte ,Int , Long
// Decimals: Float , Double
// Characters: Char
//Boolean   : Boolean

//Notes:2 Variables : var(mutable) or val(immutable) : can not change after assigning value to val variable

// var/val variableName : <DataType> = literal Ex : var sampleValue:Int= 10
// It does not always require to define data type, the kind of 'literal' you provided to variable, variable assume the data type itself.
// that is called "Type Inference" like other languages , python,swift,java script

// So  Ex: var sampleValue = 10 ( :Int is removed, IDE itself tells it is redundant)

//Notes:3  Null safety in Kotlin: In Kotline, directly you can not assing null value to any variable like java.
// you have to make that variable nullable using '?' keyword
//Null safety operators: 1. safe call, not null assertion , elvise (like ternary in java) & safe call with let (?.let)

fun nullCheck() {
    var sampleValue: Int? = 10 // making sampleValue nullable
    sampleValue = null

    if (sampleValue != null) {
// Here is is called string interpolation using '$' keyword to concatenat  exiting string.
        println("We have some value $sampleValue") // we can use some expression also like :  ${a+b}
    } else {
        println("We dont have value")
    }

    //Important

    var sampleString: String? = "hgghiuhiij"
    // can not call any function directly on nullable variable, compiler gives error.
    //var length = sampleString.length
    // Use safe(?.) or non null asserted(!!.) calls operator
    sampleString = null // assigning it as null to verify below piece of code.
    var length1 = sampleString?.length // safe call basically removes extra null check boiler plate code.
    println("Length of the string is: $length1") //prints:  Length of the string is: null. printing null as a value.
    // use (!!.) this when you are sure value will not be null, otherrwise it will throw Null pointer exception.
    // elvise operator(?:)
    var length2 =
        sampleString?.length ?: "Unknown length" // if length is present print it otherwise, print 2nd argument.
    println("Length of the string is: $length2")

    var str:String? = "ram"

    str?.let {
       println( "My name is jagga$str")  // this block will only execute if str is not null.
    }
}

fun main(args: Array<String>) {

    var value = 10.0 // by default it will be assumed as double not float
    // use 'as' keyword to typecast numbers
    var samlpeStr = null // its type is nothing.

   // var samlpeVar = samlpeStr as Int // will throw TypeCastException

    var samlpeVar = samlpeStr as? Int // 'as?' is called 'type safe' operator, will not throw TypeCastException.

    nullCheck()

}


