import java.util.*;

public class Drva3 {
    private static int cntNodesWithTwoChildren(BNode<String> node) {
        if(node == null) return 0;
        int left = cntNodesWithTwoChildren(node.left);
        int right = cntNodesWithTwoChildren(node.right);
        int curr = (node.left != null && node.right != null) ? 1 : 0;
        return left + right + curr;
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
                int res = cntNodesWithTwoChildren(node);
                System.out.println(res);
            }
        }
    }
}
