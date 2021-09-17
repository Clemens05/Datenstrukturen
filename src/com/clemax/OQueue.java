package com.clemax;

public class OQueue<ContentType> {
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
    }

    private Node head;
    private Node tail;

    public OQueue() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(ContentType pContent) {
        if (pContent != null) {
            Node neu = new Node(pContent);
            if (!this.isEmpty())
                tail.setNextNode(neu);
            else
                head = neu;
            tail = neu;
        }
    }

    public void dequeue() {
        if (!this.isEmpty())
            head = head.getNextNode();
    }

    public ContentType front() {
        return head != null ? head.getContent() : null;
    }
}
