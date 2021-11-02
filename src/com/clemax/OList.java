public class OList<ContentType> {
    public OList() {

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
                        this.getPrevious().setNext(neu);
                        neu.setNext(current);
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