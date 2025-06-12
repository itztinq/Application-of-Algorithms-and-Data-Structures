package book;
import java.util.*;

public class ListaOdListi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        DLL<DLL<Integer>> list = new DLL<>();
        for(int i = 0; i < n; i++) {
            DLL<Integer> dll = new DLL<>();
            for(int j = 0; j < m; j++) {
                dll.insertLast(sc.nextInt());
            }
            list.insertLast(dll);
        }

        double product = 1;
        DLLNode<DLL<Integer>> curr = list.getFirst();
        while(curr != null) {
            int sum = 0;
            DLLNode<Integer> t = curr.element.getFirst();
            while(t != null) {
                sum += t.element;
                t = t.succ;
            }
            product *= sum;
            curr = curr.succ;
        }

        System.out.println(product);
    }
}
