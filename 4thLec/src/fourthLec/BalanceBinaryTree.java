package fourthLec;

public class BalanceBinaryTree {
    private class TreeNode {
        TreeNode left;
        TreeNode right;

        TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }

    private class Result{
        boolean isB;
        int depth;
        public Result(int depth, boolean isB){
            this.isB = isB;
            this.depth = depth;
        }
    }
    //主函数
    public boolean isBalanced(TreeNode root) {
        return isBST(root).isB;
    }

    //这里的单次执行过程具体如下：
    //是否终止?->没终止的话，判断是否满足不平衡的三个条件->返回值
    public Result isBST(TreeNode root){
        if(root == null){
            return new Result(0, true);
        }
        //不平衡的情况有3种：左树不平衡、右树不平衡、左树和右树差的绝对值大于1
        Result left = isBST(root.left);
        Result right = isBST(root.right);
        if(left.isB == false || right.isB == false){
            return new Result(0, false);
        }
        if(Math.abs(left.depth - right.depth) > 1){
            return new Result(0, false);
        }
        //不满足上面3种情况，说明平衡了，树的深度为左右俩子树最大深度+1
        return new Result(Math.max(left.depth, right.depth) + 1, true);
    }
}
