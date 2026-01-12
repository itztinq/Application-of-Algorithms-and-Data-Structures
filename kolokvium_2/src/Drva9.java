import java.util.*;

public class Drva9 {
    private static void sumDepth(BNode<String> node, int level, int[] res) {
        if(node == null) return;
        res[0] += level;
        res[1]++;
        sumDepth(node.left, level + 1, res);
        sumDepth(node.right, level + 1, res);
    }

    private static float avgDepth(BNode<String> node) {
        if(node == null) return 0;
        int[] res = new int[2];
        sumDepth(node, 0, res);
        return (float) res[0] / res[1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();

        BTree<String> tree = new BTree<>();
        Map<String, BNode<String>> map = new HashMap<>();

        for(int i = 0; i < n + q; i++) {
            String[] parts = sc.nextLine().split(" ");

            if(parts[0].equals("root")) {
                String name = parts[1];
                tree.makeRoot(name);
                map.put(name, tree.root);
            } else if(parts[0].equals("add")) {
                String parent = parts[1];
                String child = parts[2];
                String dir = parts[3];

                BNode<String> parentNode = map.get(parent);
                int where = dir.equals("LEFT") ? BNode.LEFT : BNode.RIGHT;
                BNode<String> childNode = tree.addChild(parentNode, where, child);
                map.put(child, childNode);
            } else if(parts[0].equals("ask")) {
                String nodeName = parts[1];
                BNode<String> node = map.get(nodeName);
                float avg = avgDepth(node);
                System.out.printf("%.2f\n", avg);
            }
        }
    }
}
