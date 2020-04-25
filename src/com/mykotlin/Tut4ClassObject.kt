package com.mykotlin

fun main(args: Array<String>) {
    // no 'new' keyword available to create object of a class.
    var stdObject = Student("Ram", 10) // calling secondary constructor

    println("Id of the student is: ${stdObject.id}")

    var dogObject = Dog()
    dogObject.eat()
    println(dogObject.color)
}

// var/val is allowed  in primary constructor but no constant is allowed in secondary constructor.
class Student(name: String) {  // primary constructors are in header of the class

    var stdName: String = ""
    var id: Int = -1

    // Unlike in java variable are initialized inside constructor, in Kotlin properties(variables in java) are initialize in init block.
// treat init block as the body of primary constructor.
    init {
        this.stdName = name
        println("Name of the student is: $name")
    }

    // secondary constructor: You have to call primary constructor explicitely from secondary constructor otherwise
    //compiler give error(primary constructor call is expected). You can have a body inside secondary constructor.
    //Important : the body of the secondary constructor will be executed after init block
    constructor(
        namewa: String,
        id: Int
    ) : this(namewa) { //2ndery constr calls primary constr then init block then 2nd constr body.
        this.id = id

    }
}
//All classes in Kotlin is inherited from 'Any' class i.e Any class is super class in Kotlin.
// functions of Any class: 1) equals():Boolean  2) toString():String  3) hashCode():Int
// all classes in kotlin is public & final, so we can not inherit any class directly, we have to use 'open' keyword for that.
// all methods & variables are also final and public, use 'open' keyword to make it ready to override.

open class Animal {
    open var color: String = "White"
    open fun eat() { // using open keyword to make it free of final.
        println("Animal Eating")
    }

}

class Dog : Animal() {
    var breed: String = ""
    //override var color:String = "Black"
    override fun eat() { // overriding parent class method
        //super<Animal>.eat() also works. used when an interface is also having same method name which we have implemented.
        super.eat() // calling parent class function using super keyword.
        println("Dog Eating")
    }
}

//abstract class
//abstract properties & functions are 'open' by default
// we can not create an instance of abstract class.
abstract class person {

    abstract var name: String
    abstract fun sleep()
    fun walk() {}
}

class Indian : person() { // Derived/Sub class of person class
    override var name = "ram" // have to override abstract property
    override fun sleep() { //have to override abstract methods if we are inheriting abstract class


    }
}