package queue_book;
import java.util.*;

public class Vozovi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> vagoni = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int v = sc.nextInt();
            if(v != 0) vagoni.add(v);
        }
        Collections.sort(vagoni);
        for(int i = 0; i < vagoni.size(); i++) {
            System.out.print(vagoni.get(i) + " ");
        }
    }
}
