package Today8_3_23_LL_Stack_Queue_Tree;
import Today8_3_23_LL_Stack_Queue_Tree.LinkedList.*;
import java.util.HashSet;

import static Today8_3_23_LL_Stack_Queue_Tree.LinkedList.length;

public class removeDuplicateLL {

    public static void removeDuplicateBFA(LinkedList.Node head){
        Node ptr1=null,ptr2=null;
        ptr1=head;
        while (ptr1!=null&&ptr1.next!=null){
            ptr2=ptr1;
            while (ptr2.next!=null){
                if(ptr1.value==ptr2.next.value){
                    ptr2.next=ptr2.next.next;
                    length--;
                }
                else {
                    ptr2=ptr2.next;
                }
            }
            ptr1=ptr1.next;
        }
    }

    public static void removeDuplicateHashSet(LinkedList.Node head){
        HashSet<Integer> hs=new HashSet<>();
        LinkedList.Node curr=head;
        LinkedList.Node pre=null;
        while (curr!=null){
            int curval=curr.value;
            if(hs.contains(curval)){
                pre.next=curr.next;
                Today8_3_23_LL_Stack_Queue_Tree.LinkedList.length--;
            }
            else {
                hs.add(curval);
                pre=curr;
            }
            curr=curr.next;
        }
    }
}
