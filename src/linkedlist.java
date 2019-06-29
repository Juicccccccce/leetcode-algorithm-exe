/* Question2 */

public class linkedlist {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;}
    }

    public static void main(String[] args) {
//        ListNode list1 = new ListNode(3);
//        ListNode list11 = new ListNode(4);
//        list11.next = new ListNode(2);
//        list1.next = list11;
//        ListNode list2 = new ListNode(4);
//        ListNode list22 = new ListNode(6);
//        list22.next = new ListNode(5);
//        list2.next = list22;
        ListNode list1 = new ListNode(5);
        ListNode list2 = new ListNode(5);

        // The first step done in main function
        int sum = (list1.val + list2.val) % 10;
        boolean over = false;
        if (list1.val + list2.val >= 10) {
            over = true;
        }
        System.out.println(sum);
        System.out.println(over);
        ListNode result = new ListNode(sum);
        addLists(list1,list2,result,over);
        System.out.println(result.next.val);


    }

    public static ListNode addLists(ListNode l1, ListNode l2, ListNode result, boolean over) {
        System.out.println(over);
        //if the next is null, need finish loop
        if (l1.next == null && l2.next == null) {
            if (over) {
                result.next = new ListNode(1);
                return result;
            }
            return result;
        } else {
            ListNode next1;
            ListNode next2;
            if (l1.next == null) {
                //When next is null, seen it as node with val 0
                next1 = new ListNode(0);
                next2 = l2.next;
            } else if (l2.next == null) {
                next1 = l1.next;
                next2 = new ListNode(0);
            } else {
                next1 = l1.next;
                next2 = l2.next;
            }
            int sum;
            if (over) {
                sum = (next1.val + next2.val+1) %10;
                if (next1.val + next2.val + 1 >= 10) {
                    over = true;
                } else {
                    over = false;
                }
            } else {
                sum = (next1.val + next2.val) %10;
                System.out.println(sum);
                if (next1.val + next2.val >= 10) {
                    over = true;
                } else {
                    over = false;
                }
            }

            ListNode newNode = new ListNode(sum);
            result.next = newNode;
            addLists(next1, next2, result.next, over);
        }
        return result;
    }

}
