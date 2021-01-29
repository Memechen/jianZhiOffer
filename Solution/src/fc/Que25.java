package fc;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/20 下午7:42
 */
public class Que25 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }


    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null) {
            return null;
        }

        //1.复制节点
        RandomListNode cur = pHead;
        while (cur != null){
            // 保存下一个节点next
            RandomListNode next = cur.next;
            // 新建一个clone节点
            RandomListNode cloneNode =new RandomListNode(cur.label);
            // 指定当前节点指到克隆节点上
            cur.next = cloneNode;
            // 指定克隆节点到之前保存的next节点上。
            cloneNode.next = next;
            // 移动游标（当前节点）到next节点
            cur = next;
        }

        //2.复制随机节点
        cur = pHead;
        while (cur!= null){
            // 如果随机节点不为null，准备复制
            if (cur.random != null) {
                // 获取克隆节点
                RandomListNode cloneNode = cur.next;
                // 克隆节点的随机节点 为 当前节点的随机节点指向的下一个节点。不然的话就是当前节点和克隆节点都指向同一个随机节点
                cloneNode.random = cur.random.next;
            }
            cur = cur.next.next;

        }

        //3.拆分为两个节点
        cur = pHead;
        RandomListNode res = cur.next;
        while (cur != null){
            // 获取克隆节点
            RandomListNode cloneNode = cur.next;
            // 游标节点的指向为克隆节点的下一个节点，即原有链路拆分
            cur.next = cloneNode.next;
            // 为什么这块做一个判定：因为如果遍历到了最后一个节点这块，需要立即停止，不然会报空指针。
            if (cloneNode.next != null) {
                // 克隆节点的指向为克隆节点的下下一个节点，即克隆链路拆分
                cloneNode.next = cloneNode.next.next;
            }
            //移动游标
            cur = cur.next;
        }

        return res;
    }
}
