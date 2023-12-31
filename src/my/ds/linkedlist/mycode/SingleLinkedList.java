package my.ds.linkedlist.mycode;

import my.ds.linkedlist.mynode.SingleNode;

public class SingleLinkedList {

    private SingleNode head;
    private SingleNode tail;
    private int size;

    public SingleNode createSingleLinkedList(int nodeValue) {
        head = new SingleNode();
        // tail = new SingleNode();
        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        node.setNext(null);
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertInLinkedList(int nodeValue, int location) {

        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        if (!existsLinkedList()) {
            System.out.println("The linked list does not exist!!");
            return;
        } else if (location == 0) {
            node.setNext(head);
            head = node;
        } else if (location >= size) {
            node.setNext(null);
            tail.setNext(node);
            tail = node;
        } else {
            SingleNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.getNext();
                index++;
            }
            SingleNode nextNode = tempNode.getNext();
            tempNode.setNext(node);
            node.setNext(nextNode);
        }
        //node.toString();
        setSize(getSize() + 1);
    }

    public void traverseLinkedList() {
        if (existsLinkedList()) {
            SingleNode tempNode = head;
            for (int i = 0; i < getSize(); i++) {
                System.out.print(tempNode.getValue());
                if (i != getSize() - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.getNext();
            }
            System.out.println("\n");
        }
    }

    public boolean searchNode(int nodeValue) {
        if (existsLinkedList()) {
            SingleNode tempNode = head;

            for (int i = 0; i < getSize(); i++) {
                if (tempNode.getValue() == nodeValue){
                    System.out.print("Found the node at location: "+i+"\n");
                    return true;
                }
                tempNode = tempNode.getNext();
            }
        }
        System.out.print("Node not found!! \n");
        return false;
    }

    public void deletionOfNode(int location) {
        if (!existsLinkedList()) {
            System.out.println("The linked list does not exist!!");
            return;
        } else if (location == 0){
            head = head.getNext();
            setSize(getSize()-1);
            if (getSize() == 0){
                tail =null;
            }
        } else if (location >= size){
            SingleNode tempNode = head;
            for (int i = 0; i < size-1; i++) {
                tempNode = tempNode.getNext();
                if (tempNode == head) {
                    head = tail = null;
                    setSize(getSize() - 1);
                    return;
                }
            }
                tempNode.setNext(null);
                tail = tempNode;
                setSize(getSize()-1);
        } else {
            SingleNode tempNode = head;
            for (int i = 0; i < location-1; i++){
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(tempNode.getNext().getNext());
            setSize(getSize()-1);
        }
    }

    void deleteLinkedList() {
        System.out.println("\n\nDeleting Linked List...");
        head = null;
        tail = null;
        System.out.println("Linked List deleted successfully !");
    }

    private boolean existsLinkedList() {
        // if head is not null retrun true otherwise return false
        return head != null;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public SingleNode getHead() {
        return head;
    }

    public void setHead(SingleNode head) {
        this.head = head;
    }
}
