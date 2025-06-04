package lists;
import java.util.*;

public class NiziListi_6 {
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
        SLLNode<String> last = null;
        while(curr != null) {
            if(curr.element.length() == l) {
                last = curr;
            }
            curr = curr.succ;
        }
        if(last != null && last != sll.getFirst()) {
            sll.insertFirst(last.element);
            sll.delete(last);
        }
        System.out.println(sll);
    }
}
