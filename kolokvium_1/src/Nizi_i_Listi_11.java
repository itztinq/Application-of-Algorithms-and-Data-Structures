import java.util.*;

public class Nizi_i_Listi_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        DLL<Integer> list = new DLL<>();
        for(int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        int k = sc.nextInt();
        System.out.println(list);

        DLLNode<Integer> curr = list.getLast();
        for(int i = 0; i < k; i++) {
            list.insertFirst(curr.element);
            list.delete(curr);
            curr = curr.pred;
        }
        System.out.println(list);
    }
}
