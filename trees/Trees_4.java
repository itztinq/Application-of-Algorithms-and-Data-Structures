import java.util.*;

public class Trees_4 {
    private static int getMaxDepth(BNode<String> node) {
        if(node == null) return 0;
        int leftD = getMaxDepth(node.left);
        int rightD = getMaxDepth(node.right);
        return 1 + Math.max(leftD, rightD);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int q  = sc.nextInt();
        sc.nextLine();

        BTree<String> tree = new BTree<>();
        Map<String, BNode<String>> map = new HashMap<>();

        for(int i = 0; i < n + q; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");

            switch(parts[0]) {
                case "root":
                    String name = parts[1];
                    tree.makeRoot(name);
                    map.put(name, tree.root);
                    break;

                case "add":
                    String parent = parts[1];
                    String child = parts[2];
                    String dir =  parts[3];
                    BNode<String> parentNode = map.get(parent);
                    int where = dir.equals("LEFT") ? BNode.LEFT : BNode.RIGHT;
                    BNode<String> childNode = tree.addChild(parentNode, where, child);
                    map.put(child, childNode);
                    break;

                case "ask":
                    String nodeName = parts[1];
                    BNode<String> node = map.get(nodeName);
                    System.out.println(getMaxDepth(node));
                    break;
            }
        }
    }
}
