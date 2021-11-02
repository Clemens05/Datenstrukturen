public class OList<ContentType> {
    private class Node {
        private Node nextNode;
        private final ContentType content;

        public Node(ContentType pContent) {
            content = pContent;
            nextNode = null;
        }

        public ContentType getContent() {
            return content;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node pNode) {
            nextNode = pNode;
        }
    }

    private Node first;
    private Node last;
    private Node current;

    public OList() {
        first = null;
        last = null;
        current = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean hasAccess() {
        return current != null;
    }

    // muss verbessert werden
    public void next() {
        if (!this.isEmpty() && this.hasAccess())
            current = current.getNextNode()
    }

    // muss verbessert werden
    public void toFirst() {
        if (!this.isEmpty && this.hasAccess && current != last) {
            current = first;
        }
    }

    public void insert(ContentType pContent) {
        if (pContent != null) {
            if (this.hasAccess()) {
                Node neu = new Node(pContent);
                if (!this.isEmpty()) {
                    if (current == first) {
                        neu.setNext(first);
                        first = neu;
                    } else {
                        this.getPrevious().setNextNode(neu);
                        neu.setNextNode(current);
                    }
                } else {
                    first = neu;
                    last = neu;
                }
            }
        }
    }

    private Node getPrevious() {
        Node temp = current;
        this.toFirst();
        while (current.getNext() != ablage)
            current.next();
        Node vorgaenger = current;
        current = ablage;
        return vorgaenger;
    }
}