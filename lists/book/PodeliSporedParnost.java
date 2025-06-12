package book;
import java.util.*;

public class PodeliSporedParnost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> lista = new DLL<>();
        for(int i = 0; i < n; i++) {
            lista.insertLast(sc.nextInt());
        }

        DLL<Integer> parni = new DLL<>();
        DLL<Integer> neparni = new DLL<>();
        DLLNode<Integer> l = lista.getFirst();
        DLLNode<Integer> r = lista.getLast();

        boolean flag = true;
        while(l != null && r != null && l.pred != r && l != r.succ) {
            DLLNode<Integer> curr;
            if(flag) {
                curr = l;
                l = l.succ;
            } else {
                curr = r;
                r = r.pred;
            }

            if(curr.element % 2 == 0) parni.insertLast(curr.element);
            else neparni.insertLast(curr.element);

            flag = !flag;
        }

        if(l == r) {
            if(l.element % 2 == 0) parni.insertLast(l.element);
            else neparni.insertLast(l.element);
        }

        System.out.println(parni);
        System.out.println(neparni);
    }
}
