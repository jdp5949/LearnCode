package Today8_3_23_LL_Stack_Queue_Tree;

import java.util.HashSet;

public class LinkedList {

    public static class Node{
        public Node left;
        public Node right;
        int value;
        public Node next;
        Node(int value){
            this.value=value;
        }
    }
    Node head;
    Node tail;
    public static int length;
    public LinkedList(int value){
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    public Node addTwoNumbers(Node l1, Node l2) {
        Node temp=new Node(0);
        Node cur=temp;
        int carry=0;
        while(l1!=null || l2!=null){
            System.out.println(l1.value);
            int sum=carry;
            if(l1!=null){
                sum+=l1.value;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.value;
                l2=l2.next;
            }
            carry=sum/10;
            sum%=10;
            cur.next=new Node(sum);
            cur=cur.next;
        }
        if(carry>0){
            cur.next=new Node(carry);
        }
        return temp.next;
    }
    public void append(int value){//if empty then add at first node else add at last
        Node newNode=new Node(value);
        if(length==0){
            head=newNode;
        }
        else{
            tail.next=newNode;
        }
        tail=newNode;
        length++;//update length of LL
    }

    public Node removeLast(){
        if(length==0){
            return null;
        }
        Node temp=head;
        Node pre=head;
        while(temp.next!=null){
            pre=temp;
            temp=temp.next;
        }
        tail=pre;
        pre.next=null;
        length--;
        if(length==0){
            head=null;
            tail=null;
        }
        return temp;
    }

    public int getLength(Node head){
        Node temp=head;
        int s=0;
        while(temp!=null){
            temp=temp.next;
            s++;
        }
        return s;
    }
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node reverseList(Node head) {
        Node cur=head,pre=null;
        while(cur!=null){
            Node nextN=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nextN;
        }
        return pre;
    }

    public void printAll(Node head) {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList(head);
        }
    }

}

