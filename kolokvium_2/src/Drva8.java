import java.util.*;

public class Drva8 {
    private static int greaterElements(BNode<Integer> node, int val) {
        if(node == null) return 0;
        if(val < node.info) {
            return 1 + greaterElements(node.left, val) + greaterElements(node.right, val);
        }
        else return greaterElements(node.right, val);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        for(int i = 0; i < n + q; i++) {
            String[] parts = sc.nextLine().split(" ");

            if(parts[0].equals("insert")) {
                int val = Integer.parseInt(parts[1]);
                tree.insert(val);
            } else if(parts[0].equals("ask")) {
                int val = Integer.parseInt(parts[1]);
                System.out.println(greaterElements(tree.getRoot(), val));
            }
        }
    }
}
