import java.util.*;

public class Nizi_i_Listi_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        DLL<Integer> list = new DLL<>();
        for(int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        int k = sc.nextInt();
        DLLNode<Integer> curr = list.getFirst();
        for(int i = 0; i < k; i++) {
            list.insertLast(curr.element);
            list.delete(curr);
            curr = curr.succ;
        }
        System.out.println(list);
    }
}
