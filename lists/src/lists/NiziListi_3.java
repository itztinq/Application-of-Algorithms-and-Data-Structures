package lists;
import java.util.*;

public class NiziListi_3 {
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
        while(curr != null) {
            if(curr.element.length() == l) {
                sll.insertAfter("Target", curr);
                curr = curr.succ;
            }
            curr = curr.succ;
        }
        System.out.println(sll);
    }
}
