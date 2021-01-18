package fc;

import java.util.Stack;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/14 下午2:47
 */
public class Que18 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 递归实现
     *
     * 我们或许还记得递归的终极思想是数学归纳法，我们思考递归的时候一定不要去一步一步看它执行了啥，只会更绕。我们牢牢记住，思考的方式是我们首先假设子问题都已经完美处理，我只需要处理一下最终的问题即可，子问题的处理方式与最终那个处理方式一样，但是问题规模一定要以1
     * 的进制缩小。最后给一个递归出口条件即可。
     *
     * 对于本题，首先假设root的左右子树已经都处理好了，即左子树自身已经镜像了，右子树自身也镜像了，那么最后一步就是交换左右子树，问题解决。所以我只需要将root.left和root
     * .right交换即可。下面进入递归，就是处理子问题。子问题的处理方式与root一样，只是要缩小问题规模，所以只需要考虑root.left是什么情况，root.right是什么情况即可。
     * @param root
     */
    public void Mirror(TreeNode root){
        if (root == null){
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;

        Mirror(root.left);
        Mirror(root.right);

    }

    /**
     * 非递归实现
     * @param root
     */
    public void Mirror1(TreeNode root){
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode currentNode = stack.pop();

            TreeNode temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;

            if (currentNode.left != null){
                stack.push(currentNode.left);
            }

            if (currentNode.right != null){
                stack.push(currentNode.right);
            }
        }
    }


}
