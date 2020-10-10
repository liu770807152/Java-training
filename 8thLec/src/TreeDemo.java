public class TreeDemo {
    public static TreeNode<String> getSetA() {
        TreeNode<String> A = new TreeNode<String>("A");
        {
            TreeNode<String> B = A.addLeftChild("B");
            TreeNode<String> C = A.addRightChild("C");
            {
                TreeNode<String> D = B.addLeftChild("D");
                TreeNode<String> E = B.addRightChild("E");
            }
            {
                TreeNode<String> F = C.addLeftChild("F");
                TreeNode<String> G = C.addRightChild("G");
            }
        }
        return A;
    }


    private static String createIndent(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }


    public static void preOrderRecursion(TreeNode node){
        if (node == null) //如果结点为空则返回
        {
            return;
        }
        // 先访问当前节点
        System.out.print(createIndent(node.getLevel()) + node.data + " \n");
        // 再访问左孩子
        preOrderRecursion(node.left);
        // 最后访问右孩子
        preOrderRecursion(node.right);
    }


    public static void inOrderRecursion(TreeNode node){
        if(node == null) //如果结点为空则返回
        {
            return;
        }
        // 先访问左孩子
        inOrderRecursion(node.left);
        // 再访问当前节点
        System.out.print(createIndent(node.getLevel()) + node.data + " \n");
        // 最后访问右孩子
        inOrderRecursion(node.right);
    }


    public static void postOrderRecursion(TreeNode node){
        if(node == null) //如果结点为空则返回
        {
            return;
        }
        // 先访问左孩子
        postOrderRecursion(node.left);
        // 再访问右孩子
        postOrderRecursion(node.right);
        // 最后访问当前节点
        System.out.print(createIndent(node.getLevel()) + node.data + " \n");
    }


    public static void main(String[] args) {

        System.out.println("********************测试前序遍历*************************");

        TreeNode<String> treeRoot = getSetA();
        preOrderRecursion(treeRoot);

        System.out.println("********************测试中序遍历*************************");

        inOrderRecursion(treeRoot);

        System.out.println("********************测试后序遍历*************************");

        postOrderRecursion(treeRoot);

        System.out.println("\n********************测试搜索*************************");

        Comparable<String> searchCCriteria = (treeData) -> {
            boolean nodeOk = treeData.equals("C");
            return nodeOk ? 0 : 1;
        };
        TreeNode<String> foundC = treeRoot.findTreeNode(searchCCriteria);
        System.out.println("C: parent=" + foundC.parent + ", left children=" + foundC.left + ", right children=" + foundC.right);
    }
}
