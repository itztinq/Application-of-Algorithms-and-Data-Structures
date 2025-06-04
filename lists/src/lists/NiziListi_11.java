package lists;
import java.util.*;

public class NiziListi_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        DLL<Integer> dll = new DLL<>();
        for(int i = 0; i < n; i++) {
            dll.insertLast(sc.nextInt());
        }
        int k = sc.nextInt();
        System.out.println(dll);
        for(int i = 0; i < k; i++) {
            int x = dll.deleteLast();
            dll.insertFirst(x);
        }
        System.out.println(dll);
    }
}
