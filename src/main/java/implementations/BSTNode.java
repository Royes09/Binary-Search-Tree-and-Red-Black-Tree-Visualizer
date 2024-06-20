package implementations;

public class BSTNode {
    public static final BSTNode Nil = new BSTNode(-1);  // Sentinel node

    private int key;
    private BSTNode parent;
    private BSTNode left;
    private BSTNode right;
    private int level;  // Level in the tree

    public BSTNode(int key) {
        this.key = key;
        this.parent = Nil;
        this.left = Nil;
        this.right = Nil;
        this.level = 1;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public BSTNode getParent() {
        return parent;
    }

    public void setParent(BSTNode parent) {
        this.parent = parent;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


}