package com.clemax;

public class OStack<ContentType> {
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

    private Node head;

    public OStack() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(ContentType pContent) {
        if (pContent != null) {
            Node neu = new Node(pContent);
            if (!this.isEmpty())
                neu.setNextNode(head);
            head = neu;
        }
    }

    public void pop() {
        if (!this.isEmpty())
            head = head.getNextNode();
    }

    public ContentType top() {
        return head != null ? head.getContent() : null;
    }
}
