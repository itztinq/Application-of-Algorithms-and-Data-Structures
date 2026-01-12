import java.util.*;

public class Nizi_i_Listi_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        DLL<Integer> list = new DLL<>();
        for(int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        
        int m = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(list);
        
        DLLNode<Integer> curr = list.find(m);
        if(curr == null) {
            System.out.println(list);
            return;
        }
        
        DLLNode<Integer> target = curr;
        boolean flag = false;
        for(int i = 0; i < k; i++) {
            target = (target.succ != null) ? target.succ : list.getFirst();
            if(target == list.getFirst()) flag = true;
        }

        if(flag) list.insertBefore(m, target);
        else list.insertAfter(m, target);
        list.delete(curr);

        System.out.println(list);
    }
}
