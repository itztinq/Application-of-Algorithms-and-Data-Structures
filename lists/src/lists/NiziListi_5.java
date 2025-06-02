package lists;
import java.util.*;

public class NiziListi_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        SLL<String> sll = new SLL<>();
        for(int i = 0; i < n; i++) {
            sll.insertLast(sc.nextLine());
        }
        System.out.println(sll);
        int l = sc.nextInt();
        SLLNode<String> curr = sll.getFirst();
        for(int i = 0; i < n; i++) {
            if(curr.element.length() == l) {
                sll.insertLast(curr.element);
                sll.delete(curr);
            }
            curr = curr.succ;
        }
        System.out.println(sll);
    }
}
