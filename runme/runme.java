package com.datastructs.runme;

import  java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;


public class runme {
    public static void main(String[] args) {
       /* System.out.println("Give path" );
        Scanner scan = new Scanner(System.in);
        IntList ob = new IntList(scan.nextLine());
        ob.printArray(ob.getIntArray());
        ob.sort(ob.getIntArray(), 0, ob.getIntArray().length-1);
        System.out.println("\nSorted array");
        ob.printArray(ob.getIntArray());
        System.out.println("the numb is in index " + ob.linearSearch(ob.getIntArray(),ob.getIntArray().length-1,491462));
        System.out.println("the numb is in index " + ob.binarySearch(ob.getIntArray(),0,ob.getIntArray().length-1,258));
        System.out.println("the numb is in index " + ob.interpolationSearch(ob.getIntArray(),499992));*/

        System.out.println("Give path" );
        Scanner scan = new Scanner(System.in);
        redBlackTree tree = new redBlackTree(scan.nextLine());
        System.out.println("DONE" );
    }





}

