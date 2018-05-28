package com.datastructs.runme;


import com.datastructs.mergesort.IntList;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class runme {
    public static void main(String[] args) {
        System.out.println("Give me the path");
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        IntList intarray = new IntList(path);
        intarray = intarray.mergeSort();
        System.out.println();
        System.out.println();
        System.out.println(intarray.getIntList());



    }
}

