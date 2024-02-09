package SearchAndOrdering.English.Searcing.C_Tree;

public class Node {
    private Item info; //What is stored in each Node
    private Node left, right; //Reference to the Nodes to the left and to the right of this Node

    /**
     * Class constructor, everytime a new Node is created,
     * it has to be informed what Item is to be stored in the Node.
     */
    public Node(Item elem) {
        this.info = elem;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public Item getInfo() {
        return this.info;
    }

    public void setLeft(Node elem) {
        this.left = elem;
    }

    public void setRight(Node elem) {
        this.right = elem;
    }

    public void setInfo(Item elem) {
        this.info = elem;
    }
}
