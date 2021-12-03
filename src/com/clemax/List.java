package com.clemax;

public class List<ContentType> {
    private class Node {
        private Node nextNode;
        private ContentType content;

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

        public void setContent(ContentType pContent) {
            content = pContent;
        }
    }

    private Node first;
    private Node last;
    private Node current;

    public List() {
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

    /**
     * Besonderheit: Wenn current == last ist, dann wird current auf first gesetzt
     * Wichtig: Bei der eigentlichen NRW-List gibt es diese Besonderheit nicht.
     * Vorallem für den Vokabeltrainer ist diese Besonderheit wichtig
     * (Zum durchgehen von first bis last der Liste per while-Schleife)
     */
    public void next() {
        if (this.hasAccess()) {
            if (current != last) {
                current = current.getNextNode();
            } else {
                current = first;
            }
        }
    }

    public void toFirst() {
        if (!isEmpty()) {
            current = first;
        }
    }

    public Node last() {
        return last;
    }

    public void toLast() {
        if (!isEmpty()) {
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
        if (pContent != null && this.hasAccess()) {
            current.setContent(pContent);
        }
    }

    public void append(ContentType pContent) {
        if (pContent != null) { // Nichts tun, wenn es keine Inhalt gibt.

            if (this.isEmpty()) { // Fall: An leere Liste anfuegen.
                this.insert(pContent);
            } else { // Fall: An nicht-leere Liste anfuegen.

                // Neuen Knoten erstellen.
                Node newNode = new Node(pContent);

                last.setNextNode(newNode);
                last = newNode; // Letzten Knoten aktualisieren.
            }

        }
    }

    public void concat(List<ContentType> pList) {
        if (pList != this && pList != null && !pList.isEmpty()) {
            if (this.isEmpty()) {
                first = pList.first;
                last = pList.last;
            } else {
                last.setNextNode(pList.first);
                last = pList.last;
            }

            pList.first = null;
            pList.last = null;
            pList.current = null;
        }
    }

    public void remove() {
        if (this.hasAccess() && !this.isEmpty()) {
            if (current == first) {
                first = first.getNextNode();
            } else {
                Node previous = this.getPrevious(current);
                if (current == last) {
                    last = previous;
                }
                previous.setNextNode(current.getNextNode());
            }

            Node temp = current.getNextNode();
            current.setContent(null);
            current.setNextNode(null);
            current = temp;

            if (this.isEmpty()) {
                last = null;
            }
        }
    }

    public void insert(ContentType pContent) {
        if (pContent != null) { // Nichts tun, wenn es keinen Inhalt gibt.
            if (this.hasAccess()) { // Fall: Es gibt ein aktuelles Element.

                // Neuen Knoten erstellen.
                Node newNode = new Node(pContent);

                if (current != first) { // Fall: Nicht an erster Stelle einfuegen.
                    Node previous = this.getPrevious(current);
                    newNode.setNextNode(previous.getNextNode());
                    previous.setNextNode(newNode);
                } else { // Fall: An erster Stelle einfuegen.
                    newNode.setNextNode(first);
                    first = newNode;
                }

            } else { //Fall: Es gibt kein aktuelles Element.

                if (this.isEmpty()) { // Fall: In leere Liste einfuegen.

                    // Neuen Knoten erstellen.
                    Node newNode = new Node(pContent);

                    first = newNode;
                    last = newNode;
                }

            }
        }
    }

    private Node getPrevious(Node pNode) {
        if (pNode != null && pNode != first && !this.isEmpty()) {
            Node temp = first;
            while (temp != null && temp.getNextNode() != pNode) {
                temp = temp.getNextNode();
            }
            return temp;
        } else {
            return null;
        }
    }
}
