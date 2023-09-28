package leetcode;

import Today8_3_23_LL_Stack_Queue_Tree.LinkedList;

public class LInkedListMethods {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //make temp listnode and add any value
        //make curr as temp head then iterate through list1 and list2 becomd not null
        //if list1 value if greater then add list1 value to cur list and list1.next
        //else list2 value added and list2.next
        // cur.next
        //if list1 still left then added to cur same for list2 if avaible then added to cur
        //return temp.next because first value is random added value
        ListNode temp= new ListNode(-1);
        ListNode cur=temp;

        while( list1!=null && list2!=null){
            if(list1.val<=list2.val){
                cur.next=list1;
                list1=list1.next;
            }
            else{
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
            // System.out.println(temp.next.val);
        }
        if(list1!=null){
            cur.next=list1;
        }
        if(list2!=null){
            cur.next=list2;
        }
        return temp.next;
    }

    public boolean hasCycle(ListNode head) {
        //checking for cycle in LL
        //two pointer fast and slow=head, one step and step
        //if two pointer met anywhere then cycle is detected
        //if loop (fast and fast.next !=null )break then no cycle
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
    // intersetion fo two LL
    // getlength function easy
    //first diff bet both list length
    //then whaterver list is bigger head pointer move toward diffent of two list
    //then check if node is same of any list till both list get null
    //if found then return that node
    public static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la=getLength(headA);
        int lb=getLength(headB);
        int diff=Math.abs(la-lb);
        if(la>lb){
            while(diff>0){
                headA=headA.next;
                diff--;
            }
        }
        else{
            while(diff>0){
                headB=headB.next;
                diff--;
            }
        }
        while(headA!=null && headB!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }

    //reverse list
    public ListNode reverseList(ListNode head) {
        //get two node cur=head and pre=null
        //cur till  null(end)
        // temp node = cur.next,cur.next=pre,pre=cur,cur=temp
        //return pre
        ListNode cur=head,pre=null;
        while(cur!=null){
            ListNode nextN=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nextN;
        }
        return pre;
    }

    //palidrom linkedlist
    public boolean isPalindrome(ListNode head) {
        // three thing need to do
        //getmid fast and slow pointer
        //pass that mid and make after mid list revrse
        //check head and temp if not != values then false
        //if outside loop then true
        ListNode f=head;
        ListNode s=head;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        ListNode temp=rev(s);
        while(temp!=null && head!=null){
            if(temp.val!=head.val) return false;
            head=head.next;
            temp=temp.next;
        }
        return true;
    }
    ListNode rev(ListNode head){
        ListNode p=null,q=null,r=head;
        while(r!=null){
            p=q;
            q=r;
            r=r.next;
            q.next=p;
        }
        return q;
    }

    //medium
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum %= 10;
            current.next = new ListNode(sum);
            current = current.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode temp=new ListNode(0);
        temp.next=head;
        ListNode fast=temp,slow=temp;
        while(n>0){
            fast=fast.next;
            n--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return temp.next;
    }
    //left right connect like LinkedList
    public LinkedList.Node connect(LinkedList.Node root) {
        if (root == null) {
            return null;
        }
        LinkedList.Node levelStart = root;
        while (levelStart != null) {
            LinkedList.Node current = levelStart;
            while (current != null) {
                if (current.left != null) {
                    current.left.next = current.right;
                }
                if (current.right != null && current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }

    //random pointer copy hashamap
//    public LinkedList.Node copyRandomList(LinkedList.Node head) {
//        Node cur=head;
//        HashMap<Node,Node> hm=new HashMap();
//        while(cur!=null){
//            hm.put(cur,new Node(cur.val));
//            cur=cur.next;
//        }
//        cur=head;
//        while(cur!=null){
//            hm.get(cur).next=hm.get(cur.next);
//            hm.get(cur).random=hm.get(cur.random);
//            cur=cur.next;
//        }
//        return hm.get(head);
//    }
    //merge sort in linkedlist
    //three method
    //getmid
    //merge
    //main
    public ListNode getMid(ListNode head){
        ListNode slow=head, fast=head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(left != null && right != null){
            if(left.val < right.val){
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        // Split the list in 2 halfs
        ListNode left = head;
        ListNode right = getMid(head);
        ListNode tmp = right.next;
        right.next = null;
        right = tmp;

        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }

}
