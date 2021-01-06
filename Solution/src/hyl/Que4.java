package hyl;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author: hyl
 * @date: 2019/08/15
 **/
public class Que4 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //根据前序和中序构造二叉树
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre == null || in == null) {
            return null;
        }

        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        if (pre.length != in.length) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);

        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {

                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1),
                        Arrays.copyOfRange(in, 0, i));

                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(in, i + 1, in.length));

            }
        }

        return root;
    }

    /**
     * 因为是树的结构，一般都是用递归来实现。
     * <p>
     * 用数学归纳法的思想就是，假设最后一步，就是root的左右子树都已经重建好了，那么我只要考虑将root的左右子树安上去即可。
     * <p>
     * 根据前序遍历的性质，第一个元素必然就是root，那么下面的工作就是如何确定root的左右子树的范围。
     * <p>
     * 根据中序遍历的性质，root元素前面都是root的左子树，后面都是root的右子树。那么我们只要找到中序遍历中root的位置，就可以确定好左右子树的范围。
     * <p>
     * 正如上面所说，只需要将确定的左右子树安到root上即可。递归要注意出口，假设最后只有一个元素了，那么就要返回。
     *
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }

        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        if (pre.length != in.length) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);

        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {
                root.left = reConstructBinaryTree1(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree1(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {3, 2, 4, 1, 6, 5, 7};
        reConstructBinaryTree1(pre, in);
    }
}
