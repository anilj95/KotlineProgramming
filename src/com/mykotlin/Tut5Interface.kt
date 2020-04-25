package com.mykotlin

fun main(args: Array<String>) {

    var objTouch = Touch()
    objTouch.onTouch()
    objTouch.solid()

    //data classes experiment code
    var user1 = User("sam", 10)
    var user2 = User("sam", 10)

    // we have to convert to string for the result we want. Data classes already converts these things internally.
    print(user1.toString())
    //copy() function belows to data classes.
    var newName = user1.copy("Peter")  // we are using named pararmeter here.

    // name will be change from 'sam' to 'peter'
    println(newName.toString())

    if (user1 == user2) {
        println("Equal")
    } else println("Not equal") // it will  print Not equal. Because both are different object. user1&2 are memory address of User.
    // if User class will be 'Data' class it will print if statement. put 'data' keyword before class it will works fine.
}

interface MyInterfaceListener { // can not instantiate interface

    var name: String // properties inside interface are also abstract in nature.
    fun onTouch() // abstract method(can not have body): by default methods inside interface is abstract in nature
    fun solid() { // normal function in interface is open & public by default. We dont have to override normal function of interface
        // in derived class
    }

}

// 2nd interface with same methods
interface MySecondInterfaceListener { // can not instantiate interface


    fun onTouch() // abstract method(can not have body): by default methods inside interface is abstract in nature
    fun solid() {
        println("Ram and shyam")
    }

}

class Touch :
    MyInterfaceListener { // there is no primary constructor '()' extended on interface, this is how we implement interface
    override var name: String = "shyam"

    override fun onTouch() {

        println("touch happened by $name")
    }

    // normal methods(method having body(curly barces {})) of interface in 'optional' to override
    override fun solid() {

        println("button clicked by $name")
    }
}

// IN below code solid is normal function but we have to override because it is present in both interface.
class Button : MyInterfaceListener, MySecondInterfaceListener {
    override var name: String = "REd"
    override fun onTouch() {

    }

    override fun solid() {
        // compiler will get confuse if we will not define name of the Inteface for the method to be called.
        // because both method names are same so we have to explicitely provide name of the interface

        super<MyInterfaceListener>.solid()

    }
}

//Data classes in Kotlin:
// 'Any'  class have some functions like : equals(),toSting() & hasCode(). Data class by default implements these methods.
// put 'data'  keyword before class it will works fine. Because data classes have implemented equals,toString() & hasCode() methods.
// So it will compare the values nnot the references. see main function.

//data class constructor only contains property variable i.e var/val.
// It will not work like this: data class User(name:String, id:Int) ; requires var or val.
data class User(var name: String, var id: Int) {

}

