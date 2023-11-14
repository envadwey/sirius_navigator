import java.util.*;

class TreeNode {
    int val;
    List<TreeNode> children;

    public TreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите корень дерева:");
        TreeNode root = new TreeNode(scanner.nextInt());

        buildTree(scanner, root);

        System.out.println("Исходное дерево:");
        printTree(root);

        shortenTree(root);

        System.out.println("Дерево после укорачивания:");
        printTree(root);
    }

    public static void buildTree(Scanner scanner, TreeNode node) {
        System.out.println("Сколько у " + node.val + " потомков?");
        int numChildren = scanner.nextInt();

        for (int i = 0; i < numChildren; i++) {
            System.out.println("Введите значение потомка " + (i + 1) + " для " + node.val + ":");
            int childValue = scanner.nextInt();
            TreeNode child = new TreeNode(childValue);
            node.addChild(child);
            buildTree(scanner, child);
        }
    }

    public static void shortenTree(TreeNode node) {
        if (node.children.size() == 1) {
            TreeNode child = node.children.get(0);
            node.val = child.val;
            node.children = child.children;
            shortenTree(node);
        } else {
            for (TreeNode child : node.children) {
                shortenTree(child);
            }
        }
    }

    public static void printTree(TreeNode node) {
        System.out.print(node.val + " -> ");
        for (TreeNode child : node.children) {
            System.out.print(child.val + " ");
        }
        System.out.println();
        for (TreeNode child : node.children) {
            printTree(child);
        }
    }
}
