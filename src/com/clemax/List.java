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

    /**
     * Die Anfrage liefert den Wert true, wenn die Liste keine Objekte enthält, sonst liefert sie den Wert false.
     * @return boolean
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Die Anfrage liefert den Wert true, wenn es ein aktuelles Objekt gibt, sonst liefert sie den Wert false.
     * @return boolean
     */
    public boolean hasAccess() {
        return current != null;
    }

    /**
     * Falls die Liste nicht leer ist, es ein aktuelles Objekt gibt und dieses nicht das letzte Objekt der Liste ist,
     * wird das dem aktuellen Objekt in der Liste folgende Objekt zum aktuellen Objekt,
     * andernfalls gibt es nach Ausführung des Auftrags kein aktuelles Objekt, d.h. hasAccess() liefert den Wert false.
     *
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

    /**
     * Falls die Liste nicht leer ist, wird das erste Objekt der Liste aktuelles Objekt.
     * Ist die Liste leer, geschieht nichts.
     */
    public void toFirst() {
        if (!isEmpty()) {
            current = first;
        }
    }

    /**
     * Gibt das letzte Element zurück.
     * @return Node
     */
    public Node last() {
        return last;
    }

    /**
     * Falls die Liste nicht leer ist, wird das letzte Objekt der Liste aktuelles Objekt.
     * Ist die Liste leer, geschieht nichts.
     */
    public void toLast() {
        if (!isEmpty()) {
            current = last;
        }
    }

    /**
     * Falls es ein aktuelles Objekt gibt (hasAccess()==true), wird das aktuelle Objekt zurückgegeben.
     * Andernfalls (hasAccess()==false) gibt die Anfrage den Wert null zurück.
     * @return ContentType
     */
    public ContentType getContent() {
        if (this.hasAccess()) {
            return current.getContent();
        } else {
            return null;
        }
    }

    /**
     * Falls es ein aktuelles Objekt gibt (hasAccess()==true) und pContent ungleich null ist,
     * wird das aktuelle Objekt durch pContent ersetzt.
     * Sonst bleibt die Liste unverändert.
     * @param pContent ContentType
     */
    public void setContent(ContentType pContent) {
        if (pContent != null && this.hasAccess()) {
            current.setContent(pContent);
        }
    }

    /**
     * Ein neues Objekt pContent wird am Ende der Liste eingefügt.
     * Das aktuelle Objekt bleibt unverändert.
     * Wenn die Liste leer ist,
     * wird das Objekt pContent in die Liste eingefügt und es gibt weiterhin kein aktuelles Objekt (hasAccess()==false).
     * Falls pContent gleich null ist, bleibt die Liste unverändert.
     * @param pContent ContentType
     */
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

    /**
     * Die Liste pList wird an die Liste angehängt. Anschließend wird pList eine leere Liste.
     * Das aktuelle Objekt bleibt unverändert.
     * Falls pList==null oder eine leere Liste ist, bleibt die Liste unverändert.
     * @param pList List<ContentType>
     */
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

    /**
     * Falls es ein aktuelles Objekt gibt (hasAccess() == true),
     * wird das aktuelle Objekt gelöscht und das Objekt hinter dem gelöschten Objekt wird zum aktuellen Objekt.
     * Wird das Objekt, das am Ende der Liste steht, gelöscht,
     * gibt es kein aktuelles Objekt mehr (hasAccess() == false).
     * Wenn die Liste leer ist oder es kein aktuelles Objekt gibt (hasAccess() == false),
     * bleibt die Liste unverändert.
     */
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

    /**
     * Falls es ein aktuelles Objekt gibt (hasAccess()==true), wird ein neues Objekt pContent vor dem aktuellen Objekt in die Liste
     * eingefügt. Das aktuelle Objekt bleibt unverändert.
     * Falls die Liste leer ist und es somit kein aktuelles Objekt gibt (hasAccess()==false), wird pContent in die Liste eingefügt und es gibt weiterhin kein aktuelles Objekt.
     * Falls es kein aktuelles Objekt gibt (hasAccess()==false) und die Liste nicht leer ist oder pContent==null ist, bleibt die Liste unverändert.
     * @param pContent ContentType
     */
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
