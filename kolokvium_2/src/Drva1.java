import java.util.*;

public class Drva1 {
    private static int countLeaves(SLLTree<Integer> tree, Tree.Node<Integer> node, Map<Integer, Tree.Node<Integer>> nodes) {
        int cnt = 0;
        Iterator<Integer> children = tree.children(node);
        if(!children.hasNext()) return 1;
        while(children.hasNext()) {
            int childVal = children.next();
            Tree.Node<Integer> childNode = nodes.get(childVal);
            cnt += countLeaves(tree, childNode, nodes);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();

        SLLTree<Integer> tree = new SLLTree<>();
        Map<Integer, Tree.Node<Integer>> nodes = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n + q; i++) {
            String[] parts = sc.nextLine().split(" ");

            if(parts[0].equals("root")) {
                int id = Integer.parseInt(parts[1]);
                tree.makeRoot(id);
                nodes.put(id, tree.root());
            } else if(parts[0].equals("add")) {
                int parent = Integer.parseInt(parts[1]);
                int child = Integer.parseInt(parts[2]);
                Tree.Node<Integer> parentNode = nodes.get(parent);
                Tree.Node<Integer> childNode = tree.addChild(parentNode, child);
                nodes.put(child, childNode);
            } else if(parts[0].equals("ask")) {
                int ind = Integer.parseInt(parts[1]);
                Tree.Node<Integer> node = nodes.get(ind);
                int leafCount = countLeaves(tree, node, nodes);
                res.add(leafCount);
            }
        }

        for(int r : res) System.out.println(r);
    }
}
