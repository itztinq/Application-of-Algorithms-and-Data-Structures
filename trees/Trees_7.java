import java.util.*;

public class Trees_7 {
    private static <E extends Comparable<E>> int smallerElements(BNode<E> node, E target) {
        if(node == null) return 0;
        if(node.info.compareTo(target) < 0) {
            // node.info < target -> 1 + levo + desno
            return 1 + smallerElements(node.left, target) + smallerElements(node.right, target);
        }
        // samo levo
        else return smallerElements(node.left, target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(int i = 0; i < n + q; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            if(parts[0].equals("insert")) {
                bst.insert(Integer.parseInt(parts[1]));
            } else if(parts[0].equals("ask")) {
                int val = Integer.parseInt(parts[1]);
                System.out.println(smallerElements(bst.getRoot(), val));
            }
        }
    }
}
