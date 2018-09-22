package com.datastructs.runme;

public class redBlackNode {
    private static final boolean BLACK = false;
    private static final boolean RED = true;

    public boolean color;
    public Integer key;
    public redBlackNode left;
    public redBlackNode right;
    public redBlackNode father;

    public redBlackNode(){ //guardians constructor
         this.key = null;
         this.color = BLACK;
    }
    public redBlackNode(Integer x){
        this.key = x;
    }

}
