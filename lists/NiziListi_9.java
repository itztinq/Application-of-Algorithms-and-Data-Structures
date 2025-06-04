import java.util.Scanner;

public class NiziListi_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        DLL<Integer> dll = new DLL<>();
        for(int i = 0; i < n; i++) {
            dll.insertLast(sc.nextInt());
        }
        int m = sc.nextInt();
        sc.nextLine();
        int k = sc.nextInt();
        System.out.println(dll);
        DLLNode<Integer> curr = dll.find(m);
        if(curr == null) {
            System.out.println(dll);
            return;
        }
        DLLNode<Integer> target = curr;
        boolean flag = false;
        for(int i = 0; i < k; i++) {
            target = (target.pred != null) ? target.pred : dll.getLast();
            if(target == dll.getLast()) flag = true;
        }
        if(flag) dll.insertAfter(m, target);
        else dll.insertBefore(m, target);
        dll.delete(curr);
        System.out.println(dll);
    }
}
