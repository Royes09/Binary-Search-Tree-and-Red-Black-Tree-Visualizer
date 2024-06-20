package implementations;

public class RBNode {
    public static final RBNode Nil = new RBNode(-1);  // Sentinel node

    private int key;
    private Color color;
    private RBNode parent;
    private RBNode left;
    private RBNode right;
    private int level;  // Level in the tree

    public RBNode(int key) {
        this.key = key;
        this.color = Color.BLACK;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public RBNode getParent() {
        return parent;
    }

    public void setParent(RBNode parent) {
        this.parent = parent;
    }

    public RBNode getLeft() {
        return left;
    }

    public void setLeft(RBNode left) {
        this.left = left;
    }

    public RBNode getRight() {
        return right;
    }

    public void setRight(RBNode right) {
        this.right = right;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}