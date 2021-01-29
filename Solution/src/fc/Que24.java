package fc;

import java.util.ArrayList;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/20 上午11:11
 */
public class Que24 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        getPath(root, target);
        return paths;
    }

    private void getPath(TreeNode node, int target) {
        if (node == null) {
            return;
        }

        target = target - node.val;
        path.add(node.val);

        if (node.left == null && node.right == null && target == 0) {
            paths.add(new ArrayList<Integer>(path));
        }

        getPath(node.right, target);
        getPath(node.left, target);

        path.remove(path.get(path.size() - 1));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        new Que24().FindPath(root,11);
    }
}
