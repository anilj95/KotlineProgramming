@file:JvmName("MyCustomFileName")

package com.mykotlin

// This way We can create package for java & kotlin both & in one project them both can be used and there methods
//can be called as per requirement
import com.myjava.MyJavaFile
import java.math.BigInteger


// void is replaced by unit in Kotlin: if function does not return anything in java return type is 'void' & it is mandatory to put
//before methods but in kotlin if method does not return anything it is not forced to write 'unit' as return type of that function.
fun main(args: Array<String>) {

    var area = findArea(4, 8)
    //println("Area is: $area")

    var largerValue = maxNumber(3, 6)
    // println("Max value is: $largerValue")
    // calling java class method into koptlin file. use className.method
    var areaIs = MyJavaFile.getArea(8, 7)
    //println(areaIs)
    // similarly from Java class we can call Kotlin file methods using KotlinfielNAme.method
    //Important : At top level if you define @file:JvmName(MyCustomKotlineFileName), JVM will change the name of the file
    // so if you have to call methods of this file into java class, use custom name of this file like: MyCustomKotlineFileName.methodName.

    var result = findVolume(2, 3) // compiler will not give error for 3rd parameter as we already provided deafult value
    println("volume is:" + result)
    // named parameter function : if we change the sequence of parameter also result will not change beacuse of same name as in function
    // findVolume2(height = 12, length = 2, breath = 3)

    //infix function call
    val x = 6
    val y = 8
    val max =
        x.greaterValue(y) // or x greaterValue y (more expressive writting style possible because of infix function)
    //println(max)

    //tailRec function : without tailrec prefix for n=10000, it will throw stackOverflow exception
    println(getFibonacci(1000, BigInteger("1"), BigInteger("0")))


}

fun findArea(length: Int, breath: Int): Int {

    return length * breath
}

//function as expression
fun maxNumber(x: Int, y: Int): Int = if (x > y) x else y

// the data which is present at the end will always return

fun maxNumber2(x: Int, y: Int): Int =
    if (x > y) { // here if x>y 68 will be returned.
        x
        68
    } else {
        y
    }

// default argument functions
// Java does not support default functions so the question is how this function will be called inside java class?
//Ans: Use annotation : @JvmOverloads for interoperability ; reference see myjavafile class
//see below function it has default 3rd parameter, height =10
@JvmOverloads
fun findVolume(length: Int, breath: Int, height: Int = 10): Int {

    return length * breath * height
    // var result = findVolume(2,3) : result = 2*3*10 ; 10 is supplied by default
    // var result = findVolume(2,3,20) : result = 2*3*20 ; default value of height(10) will be overridden
}

//Named parameters :
// pure kotlin concept: can not be used in java class
// used where there are several parameters & we dont want to be careful of the sequence; at the time of calling, provide same name
// as define here, then we dont need to take care of the sequence.

fun findVolume2(length: Int, breath: Int, height: Int = 10) {
    println("length is $length")
    println("breath is $breath")
    println("height is $height")
}

//Extension functions
// if there are lot of functions in any file suppose main activity, it looks cluttered.
// cut all function & paste into seperate file and append all function like :  Mainactivity.functionName
// Now all functions which belongs to different class but can be called from MainActivity class as if they belongs to this class.
// this way we can achieve code readability & decluttered code. See Below example:
// All 4 methods are defined in ViewExtension kotlin file.
class MainActivity {

    var height = getHeight() // type of this function is of class MainActivity that is why you can call in this class
}


class Tut3Functions {

    var area = getArea(2, 3) // all methods are called on Tut3Functions file as extension function, so we can use here
    var volume = getVolume()
    var leng = getLength()

}
// Also we can call extension functions on Activity, Button,DataType(Int,Float) etc.  all activity & buttons can call that methods.
// This way we can Modularize our code, it will be easy to maintain and adds to cleaner architecture.

//**************###########
//Infix function
//All extension functions are infix function but all infix functions are not extension function. Because
//infix function have only one parameter. see below example

infix fun Int.greaterValue(value: Int): Int {

    if (this > value) return this
    else return value
}

//tailrec  function: perform recursion in more optimize way
//Used to avoid stackOverflow exception which occur mainly in recursive function
// performs recursion internally without affecting existing stack, so no stackoverflow exception.

tailrec fun getFibonacci(n: Int, a: BigInteger, b: BigInteger): BigInteger {

    if (n == 0) return b
    else return getFibonacci(n - 1, a + b, a)
}

// suspend function :
// suspend function can only be called from another suspend function or inside coroutine. i.e we can not call in main() function here.

suspend fun findMax(a: Int, b: Int): Int {
    return a + b
}

//inline  function:





