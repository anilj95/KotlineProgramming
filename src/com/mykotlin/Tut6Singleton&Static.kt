package com.mykotlin

import com.mykotlin.Customer.id

fun main(args: Array<String>) {
// calling properties & methods of Cuctomer without creating object because they behaves as static
    Customer.id = 9
    var name = Customer.registerCustomer()
    println("Customer is: $name & his ID is: $id")

// for companion object : directely using class name
    MyClass.count
    MyClass.registerCustomer()

}

//Singleton:
//Having one instance of the class in whole application i.e we can not create object/instance of this class, there exist only
//one object of this class which is created by the Kotlin internally. Singleton have 'Static' methods & variables.
// but kotlin does not have 'Singleton' keyword. It uses 'object' keyword for that. use it in place of 'class' kotline will create
// singleton object when program runs.

object Customer { // we can not have constructor here, we dont want anyone to create object of this class. In java we are achieving
    //this using private constructor.
    //This class can have properties,methods, init Block and super class i.e it supports inheritance.

    var id: Int = -1 // Behaving as static variable

    fun registerCustomer(): String {  // Behaving as static method
        return "Indian"
    }
}

//Companion object:
// they are declared inside a class : inside companion object block, everything is treated as static.

class MyClass {
    companion object {
        var count: Int =
            -1 // After compilation Kotline actually converts in static.(in above code it was just behaving like static)

        //to use below method in java class, use annotation @JvmStatic so that it will behave as static in java class also. NOt required here.
        @JvmStatic
        fun registerCustomer(): String {  // After compilation Kotline actually converts in static.
            return "USA"
        }
    }
}
