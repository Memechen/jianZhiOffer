package fc;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/13 上午11:13
 */
public class Que16 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归版本
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode res = null;
        if (list1.val >= list2.val) {
            res = list2;
            res.next = Merge(list1, list2.next);
        } else {
            res = list1;
            res.next = Merge(list1.next, list2);
        }

        return res;

    }

    /**
     * 非递归版本
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge2(ListNode list1, ListNode list2) {
        ListNode current = new ListNode(-1);
        ListNode root = current;

        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }
        
        return root.next;
    }
}
