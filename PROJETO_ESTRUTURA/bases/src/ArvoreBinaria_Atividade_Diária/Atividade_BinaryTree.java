package ArvoreBinaria_Atividade_Diária;

class Atividade_BinaryTree<T> {
    private TreeNode<T> root;

    public Atividade_BinaryTree() {
        root = null;
    }

    public void add(T data) {
        root = addRecursive(root, data);
    }

    private TreeNode<T> addRecursive(TreeNode<T> current, T data) {
        if (current == null) {
            return new TreeNode<>(data);
        }

        if (data.hashCode() < current.getData().hashCode()) {
            current.setLeft(addRecursive(current.getLeft(), data));
        } else if (data.hashCode() > current.getData().hashCode()) {
            current.setRight(addRecursive(current.getRight(), data));
        }

        return current;
    }

    public void remove(T data) {
        root = removeRecursive(root, data);
    }

    private TreeNode<T> removeRecursive(TreeNode<T> current, T data) {
        if (current == null) {
            return null;
        }

        if (data.hashCode() == current.getData().hashCode()) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }
            if (current.getLeft() == null) {
                return current.getRight();
            }

            T smallestValue = findSmallestValue(current.getRight());
            current.setData(smallestValue);
            current.setRight(removeRecursive(current.getRight(), smallestValue));
            return current;
        }

        if (data.hashCode() < current.getData().hashCode()) {
            current.setLeft(removeRecursive(current.getLeft(), data));
            return current;
        }

        current.setRight(removeRecursive(current.getRight(), data));
        return current;
    }

    private T findSmallestValue(TreeNode<T> current) {
        return current.getLeft() == null ? current.getData() : findSmallestValue(current.getLeft());
    }

    public void printInOrder() {
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(TreeNode<T> current) {
        if (current != null) {
            printInOrderRecursive(current.getLeft());
            System.out.print(current.getData() + " ");
            printInOrderRecursive(current.getRight());
        }
    }

	public TreeNode<Atividade> getRoot() {
		// TODO Auto-generated method stub
		return null;
	}
}
