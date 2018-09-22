package com.datastructs.runme;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class IntList {
    private File ints ;
    private ArrayList<Integer> intlist ;
    private  Integer[] intArray;



    public IntList(String path){
        this.ints = new File(path); //C:\\Users\Bill\\Desktop\\project\\integers.txt
        BufferedReader reader = null;
        this.intlist = new ArrayList<Integer>();

        try {
            reader = new BufferedReader(new FileReader(ints));
            String text = null;

            while ((text = reader.readLine()) != null) {
                intlist.add(Integer.parseInt(text));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Given Array");
        System.out.println(intlist);
        this.intArray = this.listToArray(intlist);
    }
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public void merge(Integer[] arr, int l, int m, int r){
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    // Main function that sorts arr[l..r] using
    // merge()
    public void sort(Integer[]arr, int l, int r){
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }

    }
    public void printArray(Integer arr[])    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public int linearSearch (Integer[] arr,int n,int x){
        for (int i = 0; i < n; i++){
            if (arr[i]==x){
                return i;
            }
        }return -1;
    }
    public int binarySearch (Integer[] arr,int l,int r,int x){
        if(r>=1){
            int mid = (l+(r-1))/2;
            if (arr[mid] == x){
                return mid;
            }
            else if(arr[mid] > x){
                return binarySearch(arr,l,mid-1,x);
            }

                return binarySearch(arr,mid+1,r,x);

        }
        return -1;
    }
    public int interpolationSearch(Integer[] arr,int x){
        int lo = 0, hi = (arr.length-1);
        while (lo <= hi && x >= arr[lo] && x <= arr[hi]){
            int pos = lo + (((hi-lo) / (arr[hi]-arr[lo])) *( x - arr[lo]));
            if(arr[pos] == x){
                return pos;
            }
            else if(arr[pos] < x){
                lo = pos + 1;
            }
            else {
                hi = pos - 1;
            }
        }
        return -1;
    }
    

    public ArrayList<Integer> arrayToList(Integer[] e){
        return this.intlist = new ArrayList<Integer>(Arrays.asList(e));
    }
    public Integer[] listToArray(ArrayList<Integer> e){
        this.intArray = new Integer[e.size()];
        return this.intArray = e.toArray(intArray);
    }
    public File getInts() {
        return ints;
    }
    public ArrayList<Integer> getIntlist() {
        return intlist;
    }
    public Integer[] getIntArray() {
        return intArray;
    }
    public void setIntlist(ArrayList<Integer> intlist) {
        this.intlist = intlist;
    }
    public void setInts(File ints) {
        this.ints = ints;
    }
    public void setIntArray(Integer[] intArray) {
        this.intArray = intArray;
    }
}

