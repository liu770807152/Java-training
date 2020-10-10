import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> {
    /**
     * 树节点
     */
    public T data;

    /**
     * 父节点，根没有父节点
     */
    public TreeNode<T> parent;

    /**
     * 左右子节点，叶子节点没有子节点
     */
    public TreeNode<T> left, right;

    /**
     * 保存了当前节点及其所有子节点，方便查询
     */
    private List<TreeNode<T>> allNodes;

    /**
     * 构造函数
     * @param data
     */
    public TreeNode(T data) {
        this.data = data;
        this.left = this.right = null;
        this.allNodes = new LinkedList<TreeNode<T>>();
        this.allNodes.add(this);
    }


    /**
     * 判断是否为根：根没有父节点
     * @return boolean
     */
    public boolean isRoot() {
        return parent == null;
    }


    /**
     * 判断是否为叶子节点：子节点没有子节点
     * @return boolean
     */
    public boolean isLeaf() {
        return this.left.data == null && this.right.data == null;
    }


    /**
     * 递归为当前节点以及当前节点的所有父节点增加新的节点
     * @param node
     */
    private void registerChildForSearch(TreeNode<T> node) {
        allNodes.add(node);
        if (parent != null) {
            parent.registerChildForSearch(node);
        }
    }


    /**
     * 添加一个左子节点
     * @param data
     * @return TreeNode<T>
     */
    public TreeNode<T> addLeftChild(T data) {
        if (data == null) {
            return null;
        }

        TreeNode<T> childNode = new TreeNode<T>(data);

        childNode.parent = this;

        this.left = childNode;

        this.registerChildForSearch(childNode);

        return childNode;
    }


    /**
     * 添加一个右子节点
     * @param data
     * @return TreeNode<T>
     */
    public TreeNode<T> addRightChild(T data) {
        if (data == null) {
            return null;
        }

        TreeNode<T> childNode = new TreeNode<T>(data);

        childNode.parent = this;

        this.right = childNode;

        this.registerChildForSearch(childNode);

        return childNode;
    }


    /**
     * 获取当前节点的层
     * @return int
     */
    public int getLevel() {
        if (this.isRoot()) {
            return 0;
        } else {
            return parent.getLevel() + 1;
        }
    }


    /**
     * 从当前节点及其所有子节点中搜索某节点
     * @param dataForComparison
     * @return TreeNode<T>
     */
    public TreeNode<T> findTreeNode(Comparable<T> dataForComparison) {
        for (TreeNode<T> element : this.allNodes) {
            T curData = element.data;
            if (dataForComparison.compareTo(curData) == 0) {
                return element;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return data != null ? data.toString() : "[tree data null]";
    }
}
