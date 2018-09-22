package com.datastructs.runme;

import java.io.*;
import java.util.ArrayList;

public class redBlackTree {
    private static final boolean BLACK = false;
    private static final boolean RED = true;
    public redBlackNode root ;
    public redBlackNode guardian;

    public redBlackTree(String path){
        this.guardian = new redBlackNode();
        this.root = this.guardian;
        File ints = new File(path); //C:\\Users\Bill\\Desktop\\project\\integers.txt
        BufferedReader reader = null;
        //this.intlist = new ArrayList<Integer>();

        try {
            reader = new BufferedReader(new FileReader(ints));
            String text = null;

            while ((text = reader.readLine()) != null) {
                redBlackNode x = new redBlackNode(Integer.parseInt(text));
                this.redBlackInsertion(x);
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
    }

    public void leftRotation(redBlackNode x){
        redBlackNode y = x.right; //orizw y
        x.right = y.left; //metatrepw to arist upodentro tou y se deksio upodentro tou x

        if(y.left!= this.guardian) {
            y.left.father = x;
        }
        y.father = x.father; //sundew patriko tou x me ton y
        if(x.father == this.guardian){
            this.root = y;
        }else if (x==x.father.left){
            x.father.left = y;
        }else {
            x.father.right = y;
        }
        y.left = x; // vazw x sta aristera tou y
        x.father = y;
    }

    public void rigtRotation(redBlackNode x){
        redBlackNode y = x.left;//orizw y
        x.left = y.right; //metatrepw to deksio upodentro tou y se aristero tou x

        if(y.right != this.guardian){
            y.right.father = x;
        }
        y.father = x.father; //sundew patriko tou x me tou y
        if(x.father == this.guardian){
            this.root = y;
        }else if(x==x.father.right){
            x.father.right = y;
        }else {
            x.father.left = y;
        }
        y.right = x; //vazw x sta deksia tou y
        x.father = y;
    }

    public void redBlackInsertion(redBlackNode z){
        redBlackNode y = this.guardian;
        redBlackNode x = this.root;
        while (x != this.guardian){
            y = x;
            if (z.key < x.key){
                x = x.left;
            }else {
                x = x.right;
            }
        }
        z.father = y;
        if (y == this.guardian){
            this.root = z;
        }else if (z.key < y.key){
            y.left = z;
        }else{
            y.right = z;
        }
        z.left = this.guardian;
        z.right = this.guardian;
        z.color = RED;
        this.redBlackRebalance(z);
    }

    public void redBlackRebalance(redBlackNode z){
        while (z.father.color == RED){
            if (z.father == z.father.father.left){
                redBlackNode y = z.father.father.right;
                if(y.color == RED){
                    z.father.color = BLACK;
                    y.color = BLACK;
                    z.father.father.color = RED;
                    z = z.father.father;
                }else if(z == z.father.right){
                    z = z.father;
                    this.leftRotation(z);
                    z.father.color = BLACK;
                    z.father.father.color = RED;
                    this.rigtRotation(z.father.father);
                }
            }else if (z.father == z.father.father.right){
                redBlackNode y = z.father.father.left;
                if(y.color == RED){
                    z.father.color = BLACK;
                    y.color = BLACK;
                    z.father.father.color = RED;
                    z = z.father.father;
                }else if (z == z.father.left){
                    z = z.father;
                    this.rigtRotation(z);
                    z.father.color = BLACK;
                    z.father.father.color = RED;
                    this.leftRotation(z.father.father);
                }
            }
        }
        this.root.color = BLACK;

    }

    public redBlackNode redBlackSearch(Integer k){
      redBlackNode x = this.root;
      while (x != null && k != x.key){
          if (k < x.key){
              x = x.left;
          }else {
              x = x.right;
          }
      }return x;
    }
}
