package SearchAndOrdering.English.Searcing.D_SelfBalancingTree;

public class Node {
    private Item info;
    private Node left, right;
    private int height;

    /**
     * Class constructor, everytime a new Node is created,
     * it has to be informed what Item is to be stored in the Node.
     */
    public Node(Item elem) {
        this.info = elem;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
