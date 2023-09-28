package Today8_3_23_LL_Stack_Queue_Tree;


public class BinarySearchTree {

    Node root;
    class Node{
        Node left;
        Node right;
        int value;
        Node(int value){
            this.value=value;
        }
    }

    public boolean insert(int value) {
        Node newNode=new Node(value);
        if(root==null){
            root=newNode;
            return true;
        }
        Node temp=root;
        while(true){
            if(newNode.value== temp.value){
                return false;
            }
            if(newNode.value<temp.value){
                if(temp.left==null){
                    temp.left=newNode;
                    return true;
                }
                temp=temp.left;
            }
            else {
                if(temp.right==null){
                    temp.right=newNode;
                    return true;
                }
                temp=temp.right;
            }
        }
    }

    static void printBST(BinarySearchTree.Node root) {
        if(root==null){
            return;
        }

        printBST(root.left);

        printBST(root.right);
        System.out.println(root.value);
    }
}

