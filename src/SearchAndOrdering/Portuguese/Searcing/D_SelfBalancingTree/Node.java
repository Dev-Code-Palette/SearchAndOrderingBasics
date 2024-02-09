package SearchAndOrdering.Portuguese.Searcing.D_SelfBalancingTree;

public class Node {
    private Item info;
    private Node left, right;
    private int height;

    /**
     * Construtor da classe. Toda vez que um Node for criado/instanciado,
     * deve ser informado o Item a ser armazenado no Node.
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
