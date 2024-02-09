package SearchAndOrdering.Portuguese.Searcing.C_Tree;

public class Node {
    private Item info; //What is stored in each Node
    private Node left, right; //Reference to the Nodes to the left and to the right of this Node

    /**
     * Construtor da classe. Toda vez que um Node for criado/instanciado,
     * deve ser informado o Item a ser armazenado no Node.
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
