package implementations;

public class RBTree {
    private RBNode root;

    public RBTree() {
        this.root = RBNode.Nil;
    }

    public RBNode getRoot() {
        return root;
    }

    public void setRoot(RBNode root) {
        this.root = root;
        if (root != RBNode.Nil) {
            root.setParent(RBNode.Nil);
        }
    }
}