import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/**
 * @author: hyl
 * @date: 2019/08/15
 **/
public class Que3 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }


    }

    //    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//
//        ArrayList<Integer> resList = new ArrayList<>();
//        Stack<Integer> stack = new Stack<>();
//
//        while (listNode != null){
//            stack.add(listNode.val);
//            listNode = listNode.next;
//        }
//
//        while (!stack.isEmpty()){
//            resList.add(stack.pop());
//        }
//
//        return resList;
//    }

    /**
     * 非递归实现，先进后出，可以想到栈，但是这样会存在一个多使用了空间的问题，list中有一个方法
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {

        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.empty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {

        ArrayList<Integer> res = new ArrayList<>();

        while (listNode != null) {
            res.add(0, listNode.val);
            listNode = listNode.next;
        }

        return res;
    }

    /**
     * 递归的方法实现
     *
     * @param listNode
     * @return
     */
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {

        if (listNode != null) {
            printListFromTailToHead3(listNode.next);
            res.add(Integer.valueOf(listNode.val));
        }

        return res;
    }

}

