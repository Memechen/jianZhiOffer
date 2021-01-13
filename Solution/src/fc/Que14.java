package fc;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/11 下午4:46
 */
public class Que14 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 一开始想的是翻转链表，遍历k次返回，但是返回的不是第K个节点的值那么简单，是返回从倒数第K个节点开始之后的链表
     * 所以调整思路，第一遍遍历获取链表长度，第二次遍历返回第 length（链表长度） - k 个节点。
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (k == 0) {
            return null;
        }

        ListNode newhead = head;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        ListNode res = null;
        for (int i = 0; i < length - k + 1; i++) {
            res = newhead;
            newhead = newhead.next;
        }
        return res;
    }

    /**
     * 一次循环即可，先让fast走K个节点，观察能否走到结尾
     * 若可以，观察长度与K的大小，即返回开始节点
     * 如还没走到结尾，则快慢指针一起走，当快指针走到结尾，则返回慢指针的节点即可。
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail2(ListNode head, int k) {
        if (k == 0){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        int index = 1;
        while (fast != null){
            if (index > k ){
                slow = slow.next;
            }
            fast = fast.next;
            index ++;
        }

        if (index <= k){
            return null;
        }

        return slow;
    }


}
