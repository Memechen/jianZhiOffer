package fc;
import hyl.Que24;

import java.util.HashMap;
/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/21 下午1:42
 */
public class Que0 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private TreeNode pLast = null;
    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 如果左子树为空，那么根节点root为双向链表的头节点
        TreeNode head = Convert(root.left);

        if (head == null) {
            head = root;
        }

        // 连接当前节点root和当前链表的尾节点pLast
        root.left = pLast;
        if (pLast != null) {
            pLast.right = root;
        }
        pLast = root;

        Convert(root.right);

        return head;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        new Que0().Convert(root);
    }
}
