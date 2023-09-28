package Today8_3_23_LL_Stack_Queue_Tree;

import java.util.PriorityQueue;

import Today8_3_23_LL_Stack_Queue_Tree.LinkedList.Node;



public class SortLL {
    //merge sort
    public static LinkedList.Node getMid(LinkedList.Node head){
        LinkedList.Node slow=head, fast=head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static LinkedList.Node merge(LinkedList.Node left, LinkedList.Node right){
        LinkedList.Node dummy = new LinkedList.Node(0);
        LinkedList.Node tail = dummy;

        while(left != null && right != null){
            if(left.value < right.value){
                tail.next = left;
                left = left.next;
            }else{
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if(left != null){
            tail.next = left;
        }
        if(right != null){
            tail.next = right;
        }
        return dummy.next;
    }
    public static LinkedList.Node mergerSort(LinkedList.Node head) {
        if(head == null || head.next == null){
            return head;
        }

        // Split the list in 2 halfs
        LinkedList.Node left = head;
        LinkedList.Node right = getMid(head);
        LinkedList.Node tmp = right.next;
        right.next = null;
        right = tmp;

        left = mergerSort(left);
        right = mergerSort(right);
        return merge(left, right);
    }
    public static LinkedList.Node sortLL(LinkedList.Node head) {
        if(head == null || head.next == null){
            return head;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        LinkedList.Node temp = head;
        while(temp.next!=null){
            queue.add(temp.value);
            temp = temp.next;
        }
        queue.add(temp.value);
        temp = head;
        while(!queue.isEmpty()){
            temp.value = queue.poll();
            temp = temp.next;
        }
        return head;
    }
}
