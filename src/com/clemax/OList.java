package com.clemax;

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

    public void toLast() {
        if (!this.isEmpty()) {
            current = last;
        }
    }

    public ContentType getContent() {
        if (this.hasAccess()) {
            return current.getContent();
        } else {
            return null;
        }
    }

    public void setContent(ContentType pContent) {
        if (hasAccess()) {
            current = new Node(pContent);
        }
    }

    public void append(ContentType pContent) {
        if (pContent != null) {
            Node neu = new Node(pContent);
            if (last != null) {
                last.setNextNode(neu);
                last = neu;
            } else {
                if (this.isEmpty()) {
                    first = neu;
                }
                last = neu;
            }
        }
    }

    public void concat(OList<ContentType> pList) {
        if (pList != null && !pList.isEmpty()) {
            pList.toFirst();
            while (!pList.isEmpty()) {
                this.append(pList.getContent());
                pList.remove();
            }
        }
    }

    public void remove() {
        if (this.hasAccess()) {
            Node previous = this.getPrevious();
            previous.setNextNode(current.getNextNode());
            current = previous;
        }
    }

    public void next() {
        if (!this.isEmpty() && this.hasAccess()) {
            if (current != last) {
                current = current.getNextNode();
            }
        }
    }

    // muss verbessert werden
    public void toFirst() {
        if (!this.isEmpty() && this.hasAccess() && current != last) {
            current = first;
        }
    }

    public void insert(ContentType pContent) {
        if (pContent != null) {
            if (this.hasAccess()) {
                Node neu = new Node(pContent);
                if (!this.isEmpty()) {
                    if (current == first) {
                        neu.setNextNode(first);
                        neu.setNextNode(first);
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
        while (current.getNextNode() != temp)
            this.next();
        Node vorgaenger = current;
        current = temp;
        return vorgaenger;
    }
}
