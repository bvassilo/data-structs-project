package com.datastructs.mergesort;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class IntList {
    private ArrayList<Integer> IntList ;
    File intFile;


    public IntList(File intFile){
        this.IntList = new ArrayList<Integer>();
        BufferedReader reader = null;
        this.intFile = intFile;

        try {
            reader = new BufferedReader(new FileReader(intFile));
            String text = null;

            while ((text = reader.readLine()) != null) {
                IntList.add(Integer.parseInt(text));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(IntList);
    }


}
