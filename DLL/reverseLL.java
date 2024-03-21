/* PROBLEM STATEMENT:
 * 
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */



import java.util.Scanner;
class Node{
    int data;Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
public class reverseLL {
    static Node head=null;
    static Node res=new Node(0);
        public static void Insert(int s){
            Node newNode=new Node(s);
            if(head==null) head=newNode;
            else{
                Node temp=head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newNode;
                
            }

        }
        public static void display(){
            Node cur=head;
            while(cur!=null){
                System.out.print(cur.data+" ");
                cur=cur.next;
            }
        
        }
        //iterative method
        /*public static Node reverse(Node head){
            if(head==null || head.next ==null) return head;
            Node prev=null,cur=head;
            while(cur!=null){
                Node nxt=cur.next;
                cur.next=prev;
                prev=cur;
                cur=nxt;
            }
            return prev;
            
        }*/
        public static Node reverseList(Node head) {
        Node temp=head;
        //Node resend=res;
        rever(temp);
        return res.next;
        
        
    }
    public static Node rever(Node temp){
        if(temp==null ||temp.next==null) 
        {   res.next=temp;
            return temp;
        }
        
        Node n1=rever(temp.next);
       // System.out.println(res.val);
        n1.next=temp;
        temp.next=null;
        //System.out.println(n1.data);
        return temp;
        
    }
        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            Insert(sc.nextInt());
        }
        System.out.println("Original Linked List:");
        display();
        head = reverseList(head); // Update head reference with the new head of reversed list
        System.out.println("\nReversed Linked List:");
        display();
    }
}


/*Iterative:
Time complexity: O(n) Space Complexity:O(1) 

recursion:
Time Complexity:O(n) Space ccomplexity:O(n) for stack calls
*/