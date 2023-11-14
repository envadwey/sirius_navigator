import java.util.Scanner;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }
}

public class BinaryTree {
    Node root;
    Scanner scanner = new Scanner(System.in);

    public void createTree() {
        System.out.print("Введите вершину дерева: ");
        int value = scanner.nextInt();
        root = new Node(value);
        askChildren(root);
    }

    private void askChildren(Node node) {
        System.out.print("Сколько потомков будет у " + node.value + "?: ");
        int childrenCount = scanner.nextInt();
        if (childrenCount > 0) {
            System.out.print("Введите значение потомка " + node.value + "-1: ");
            int leftValue = scanner.nextInt();
            node.left = new Node(leftValue);
            askChildren(node.left);
        }
        if (childrenCount > 1) {
            System.out.print("Введите значение потомка " + node.value + "-2: ");
            int rightValue = scanner.nextInt();
            node.right = new Node(rightValue);
            askChildren(node.right);
        }
    }

    public void removeApproxEquals(Node node) {
        if (node == null) {
            return;
        }

        if (node.left != null && Math.abs(node.value - node.left.value) <= 1) {
            node.left = null;
        }

        if (node.right != null && Math.abs(node.value - node.right.value) <= 1) {
            node.right = null;
        }

        if (node.left != null) {
            removeApproxEquals(node.left);
        }
        if (node.right != null) {
            removeApproxEquals(node.right);
        }
    }

    public void printInOrderWithChildren(Node node) {
        if (node != null) {
            printInOrderWithChildren(node.left);
            System.out.print(node.value + " -> ");
            if (node.left != null) {
                System.out.print(node.left.value + " ");
            }
            if (node.right != null) {
                System.out.print(node.right.value + " ");
            }
            System.out.println();
            printInOrderWithChildren(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createTree();
        System.out.println("Исходное дерево:");
        tree.printInOrderWithChildren(tree.root);
        System.out.println();
        tree.removeApproxEquals(tree.root);
        System.out.println("Измененное дерево:");
        tree.printInOrderWithChildren(tree.root);
        System.out.println();
    }
}

