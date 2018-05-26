package com.datastructs.runme;


import com.datastructs.mergesort.IntList;


import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class runme {
    public static void main(String[] args) {
        System.out.println("Give the path: ");
        Scanner scan = new Scanner(System.in);
        URI rpath = null;
        try {
            rpath = new URI(scan.nextLine());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        File temp = new File(rpath);
        IntList intarray = new IntList(temp);
    }
}
