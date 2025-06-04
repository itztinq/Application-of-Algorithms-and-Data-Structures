package lists;
import java.util.*;

public class NiziListi_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        DLL<Integer> dll = new DLL<>();
        for(int i = 0; i < n; i++) {
            dll.insertLast(sc.nextInt());
        }
        int k = sc.nextInt();
        DLLNode<Integer> curr = dll.getFirst();
        for(int i = 0; i < k; i++) {
            dll.insertLast(curr.element);
            dll.delete(curr);
            curr = curr.succ;
        }
        System.out.println(dll);
    }
}
