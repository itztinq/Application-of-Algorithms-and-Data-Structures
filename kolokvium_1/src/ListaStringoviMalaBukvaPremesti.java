import java.util.*;

public class ListaStringoviMalaBukvaPremesti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        SLL<String> list = new SLL<>();

        for(int i = 0; i < n; i++) {
            list.insertLast(sc.nextLine());
        }
        System.out.println(list);

        SLLNode<String> curr = list.getFirst();
        for(int i = 0; i < n; i++) {
            SLLNode<String> tmp = curr;
            if(curr.element.charAt(0) >= 'a' && curr.element.charAt(0) <= 'z') {
                list.insertLast(curr.element);
                list.delete(curr);
                curr = tmp.succ;
            }
            curr = curr.succ;
        }

        System.out.println(list);
    }
}
