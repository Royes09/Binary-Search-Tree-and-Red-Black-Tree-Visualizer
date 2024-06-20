package implementations;

public class BSTree {
    private BSTNode root;

    public BSTree() {
        this.root = BSTNode.Nil;
    }

    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
        if (root != BSTNode.Nil) {
            root.setParent(BSTNode.Nil);
        }
    }
}