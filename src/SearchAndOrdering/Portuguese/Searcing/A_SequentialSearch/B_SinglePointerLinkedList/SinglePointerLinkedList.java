package SearchAndOrdering.Portuguese.Searcing.A_SequentialSearch.B_SinglePointerLinkedList;

public class SinglePointerLinkedList {
    private Node firstNode;
    private Node lastNode;
    private int nodesQtd;

    public SinglePointerLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
        this.nodesQtd = 0;
    }

    public int getNodesQtd() {
        return this.nodesQtd;
    }

    public Node getFirstNode() {
        return this.firstNode;
    }

    public Node getLastNode() {
        return this.lastNode;
    }

    public boolean isEmpty() {
        return (this.firstNode == null);
    }

    public void insertLastNode(Item elem) {
        Node newLastNode = new Node(elem);

        if (this.isEmpty()) {
            this.firstNode = newLastNode;
        } else {
            this.lastNode.setNextNode(newLastNode);
        }
        this.lastNode = newLastNode;
        this.nodesQtd++;
    }

    public String toString() {
        String msg = "";
        Node currentNode = this.firstNode;
        while (currentNode != null) {
            msg += "[" + currentNode.getInfo().getKey() + "] ";
            currentNode = currentNode.getNextNode();
        }
        return msg;
    }
}
