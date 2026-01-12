import java.util.*;

public class Nizi_i_Listi_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        SLL<String> list = new SLL<>();
        for(int i = 0; i < n; i++) {
            list.insertLast(sc.nextLine());
        }

        int l = sc.nextInt();
        System.out.println(list);

        SLLNode<String> curr = list.getFirst();
        for(int i = 0; i < n; i++) {
            if(curr.element.length() == l) {
                list.insertLast(curr.element);
                list.delete(curr);
            }
            curr = curr.succ;
        }
        System.out.println(list);
    }
}
