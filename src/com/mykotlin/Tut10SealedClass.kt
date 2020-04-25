package com.mykotlin

fun main(args: Array<String>) {

    var circle = Shape.Circle(6.0f)
    var squre = Shape.Square(4)
    var rectangle = Shape.Rectangle(3, 8)

    evaluate(circle) // this function will take of type 'shape' object only
    evaluate(squre)
    evaluate(rectangle)
    //evaluate(octago)
}
// sealed class:
//They are, in a sense, an extension of enum classes: the set of values for an enum type is also restricted, but each enum constant
// exists only as a 'single' instance, whereas a subclass of a sealed class can have multiple instances which can contain state.
//Constructors of a sealed class are 'private' by default. i.e it can not be instantiated.
//All subclasses of a sealed class must be declared 'within' the same file.
//Sealed classes are important in ensuring 'type safety' by restricting the set of types at compile-time only.



sealed class Shape {
    class Circle(var radius: Float) : Shape()
    data class Square(var length: Int) : Shape()
    class Rectangle(var length: Int, var breadth: Int) : Shape()
    object D : Shape() {

        fun name() {
            println("Object D")
        }
    }

}

fun evaluate(eval: Shape) = when (eval) { // here when is used as expression so does not require 'else' block
//The 'is' modifier checks if the class is of the following type
    is Shape.Circle -> println("Radius of circle is: ${eval.radius}") // is keyword == instanceOf() of java.
    is Shape.Square -> println("Square of is: ${eval.length * eval.length}")
    is Shape.Rectangle -> println("Rectangle  is: ${eval.length * eval.breadth}")
    // is keyword is required with classes  not with objects
    Shape.D -> Shape.D.name()
}


