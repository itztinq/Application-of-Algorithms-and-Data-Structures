package book;
import java.util.*;

public class PrevrtiLista {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for(int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        DLL<Integer> res = new DLL<>();
        DLLNode<Integer> curr = list.getLast();
        while(curr != null) {
            if(curr.element % 2 == 0) {
                res.insertLast(curr.element);
            }
            curr = curr.pred;
        }

        curr = list.getLast();
        while(curr != null) {
            if(curr.element % 2 != 0) {
                res.insertLast(curr.element);
            }
            curr = curr.pred;
        }

        System.out.println(res);
    }
}
