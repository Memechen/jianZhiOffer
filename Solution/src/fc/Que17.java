package fc;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/13 下午4:07
 */
public class Que17 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            if (judge(root1, root2)){
                return true;
            }
        }

        return judge(root1.left, root2) || judge(root1.right, root2);
    }

    private boolean judge(TreeNode root, TreeNode subtree) {
        //子结构已经循环完毕，代表全部匹配
        if(subtree == null){
            return true;
        }
        //大树已经循环完毕，并未成功匹配
        if(root == null){
            return false;
        }
        //相等后判断左右孩子
        if(root.val == subtree.val){
            return judge(root.left, subtree.left) && judge(root.right, subtree.right);
        }
        return false;

    }
}
