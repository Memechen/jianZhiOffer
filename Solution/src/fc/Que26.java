package fc;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/21 下午2:54
 */
public class Que26 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    TreeNode head = null;
    TreeNode realHead = null;

    public TreeNode Convert(TreeNode root) {
        convert(root);
        return realHead;
    }

    private void convert(TreeNode root) {
        if (root == null){
            return;
        }
        convert(root.left);

        if (head == null){
            head = root;
            realHead = root;
        }else {
            head.right = root;
            root.left = head;
            head = root;
        }

        convert(root.right);
    }


}
