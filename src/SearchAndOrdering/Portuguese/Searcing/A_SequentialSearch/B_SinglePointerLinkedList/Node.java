package SearchAndOrdering.Portuguese.Searcing.A_SequentialSearch.B_SinglePointerLinkedList;

public class Node {
    private Item info; //What is stored in each Node
    private Node nextNode;

    /**
     * Construtor da classe. Toda vez que um Node for criado/instanciado,
     * deve ser informado o Item a ser armazenado no Node.
     */
    public Node(Item elem) {
        this.info = elem;
        this.nextNode = null; //Linha opcional, uma vez que o próximo elemento é automaticamente setado como sendo null
    }

    //Getters e Setters para Item(info) e Node(nextNode)
    public Item getInfo() {
        return this.info;
    }

    public void setInfo(Item elem) {
        this.info = elem;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node _node) {
        this.nextNode = _node;
    }
}
