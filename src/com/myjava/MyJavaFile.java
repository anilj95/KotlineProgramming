package com.myjava;

import com.mykotlin.MyCustomFileName;

public class MyJavaFile {

    public static  int getArea(int a, int b){

        return a*b;
    }

    public static void main (String[] args){

        int area = MyCustomFileName.findArea(4,3);
        // it can be useed with just two parameter althought it requires 3rd parameter also, we made arrangment in kotlin file
        // for this method to be used in java class : used annotation @JvmOverloads
        int volume = MyCustomFileName.findVolume(2,3);
        System.out.println("Area is:" +area);
        System.out.println("Volume is:" +volume);
    }
}
