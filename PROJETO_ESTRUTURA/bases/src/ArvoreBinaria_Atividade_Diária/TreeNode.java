package ArvoreBinaria_Atividade_Diária;

class TreeNode<T> {
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}

