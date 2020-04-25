package com.mykotlin

fun main(args: Array<String>) {

    myArrayFun()
    myArrayListFun()
    myMapFun()
    mySetFun()

}

//Array: are mutable but has fixed size. Can not add or remove item in array.

fun myArrayFun() {

    var myArray = Array<Int>(5) { 0 } //array of size 5 & initials values are '0'

    myArray[1] = 6
    myArray[4] = 8
    myArray[2] = 16

    for (element in myArray) { //way 1 to print elements in array

        println(element)
    }

    for (value in 0..myArray.size - 1) { //way 2 to print elements in array

        println(myArray[value])
    }

}

//Collection Api : List,Set,Map

//Immutable collections: Read only operation & Fixed size.
//1.listOf(), mapOf(), setOf() : creats immutable collection of List,Map & Set respectively.

//Mutable collections: Read &Write both operation

//1. List : ArrayList,mutableListOf() & arrayListOf() : creates Mutable & growable size List & Write,Read both.
//2. Map : HashMap,mutableMapOf() & hashMapOf() : creates Mutable & growable size Map & Write,Read both.
//3. Set : mutableSetOf(), hashSetOf() : creates Mutable & growable size Set & Write,Read both.

fun myArrayListFun() {

    var myArrayList = listOf<String>("ram", "shyam", "ghana") // fixed size,read only  can not edit value

    // below methods are mutable & write operation can also be performed
    var myArrayList1 = arrayListOf<String>("modi")
    var myArrayList2 = mutableListOf<String>("rahul")
    var myArrayList3 = ArrayList<String>()

    myArrayList1.add("yogi") //can add, replace,remove
    myArrayList2.add("yogi")
    myArrayList3.add("lauki")
    myArrayList3.add("bhogi")
    myArrayList3.remove("bhogi")

    for (element in myArrayList) {

        println(element)
    }
    for (element in myArrayList1) {

        println(element)
    }
    for (element in myArrayList2) {

        println(element)
    }
    for (element in myArrayList3) {

        println(element)
    }
}
//Map: Key,value pair

fun myMapFun() {

    var myMap = mapOf<Int, String>(2 to "ram", 42 to "dada", 12 to "vaka") //Immutable,fixed in size Read Only.

    for (element in myMap.keys) {

        println(myMap[element])
    }
    // Below all 3 methods are Mutable,Read & Write both

    var myMap1 = mutableMapOf<Int, String>()
    var myMap2 = hashMapOf<Int, String>()
    var myMap3 = HashMap<Int, String>()

    myMap1.put(8, "murthi")
    myMap1.put(8, "krishna")
    myMap2.put(8, "sopm")
    myMap2.put(8, "karthi")
    myMap3.put(8, "janki")
    myMap3.put(8, "vaidehi")

    for (element in myMap1.keys) {

        myMap1[element]
    }

    for (element in myMap2.keys) {

        myMap1[element]
    }

    for (element in myMap3.keys) {

        myMap1[element]
    }

}

// Set : contains unique elements
fun mySetFun() {

    var mySet = setOf<Int>(12, 41, 0, 0, 0, 91, 67) // Immutable, Reaad only.
    //mySet.remove(41)  : can not use as mySet is immutable

    for (value in mySet) {

        println(value)// print only unique element. omly one '0' will be printed.
    }
   // below methods are : Mutable set & Read, Write both.
    var mySet1 = mutableSetOf<Int>() // sequence is guranteed i.e in which they are inserted not(ascending or descending).
    var mySet2 = hashSetOf<Int>() // sequence is not guranteed

    mySet1.add(41)
    mySet1.add(1)
    mySet2.add(4)
    mySet2.add(12)
    mySet1.add(90)
    mySet2.remove(90)

    for (value in mySet1){

        println(value)
    }
    for (value in mySet2){

        println(value)
    }


}
