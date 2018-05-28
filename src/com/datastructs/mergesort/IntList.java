package com.datastructs.mergesort;

import com.sun.jdi.Type;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntList {
    private ArrayList<Integer> intList ;
    private File intFile = null;
    private Integer [] intArray ;

    public IntList (){

    }

    public IntList(String path){
        this.intList = new ArrayList<Integer>();
        BufferedReader reader = null;
        this.intFile = new File(path);


        try {
            reader = new BufferedReader(new FileReader(intFile));
            String text = null;

            while ((text = reader.readLine()) != null) {
                intList.add(Integer.parseInt(text));
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
        System.out.println(intList);
        this.intArray = new Integer[this.intList.size()];
    }

    public IntList (Integer [] a){
        this.intList = new ArrayList<Integer>(Arrays.asList(a));
        this.intArray = new Integer[this.intList.size()];
    }


    public IntList mergeSort (){
       if (this.intArray.length <=1 ){
            return this;
        }
        int q = (this.intArray.length + 1) /2;
        Integer[] intarray1 = new Integer[q];
        System.arraycopy(this.intArray,0,intarray1,0,q);
        IntList a = new IntList(intarray1);
        Integer[] intarray2 = new Integer[q];
        System.arraycopy(this.intArray,q,intarray2,0,q);
        IntList b = new IntList(intarray2);
        a.mergeSort();
        b.mergeSort();
        Integer [] c = merge(a.intArray,b.intArray);
        this.intList = new  ArrayList<Integer>(Arrays.asList(c));
        return  this ;
    }

    public Integer[] merge(Integer[] a ,Integer[] b){
         int i = 0;
         int j = 0;
         int k = 0;
         Integer[] c = new Integer[a.length];
         while(a.length !=0 || b.length !=0){
             if (a[i] <= b[j]){
                 c[k] = a[i];
                 a[i]=null;
                 i=i+1;
                 k=k+1;
             } else if (a[i] > b[j]) {
                 c[k] = b[j];
                 b[j]=null;
                 j=j+1;
                 k=k+1;
             }
         }
         if(a.length ==0 ){
             for(int l = j; l<=b.length;l=l+1 ){
                c[k]=b[l];
                k=k+1;
             }
         }else if(b.length ==0){
             for(int l=j; l<=a.length;l=l+1){
                c[k]=a[l];
                k=k+1;
             }
         }
         //ArrayList<Integer> listArray = new ArrayList<Integer>(Arrays.asList(c));
        // IntList list = new IntList(c);
         return c;
    }

    public File getIntFile() {
        return intFile;
    }
    public ArrayList<Integer> getIntList() {
        return intList;
    }
    public void setIntFile(File intFile) {
        this.intFile = intFile;
    }
    public void setIntList(ArrayList<Integer> intList) {
        this.intList = intList;
    }
    public void setIntList(Integer a,int index){
        this.intList.set(index,a);
    }
}
