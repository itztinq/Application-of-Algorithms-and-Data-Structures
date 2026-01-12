import java.util.*;

public class Drva6 {
    private static int depth(BNode<Integer> node, int val) {
        int d = 1;
        while(node != null) {
            if(val == node.info) return d;
            else if(val < node.info) node = node.left;
            else node = node.right;
            d++;
        }
        return d;
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
                System.out.println(depth(tree.getRoot(), val));
            }
        }
    }
}
