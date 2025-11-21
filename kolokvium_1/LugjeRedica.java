import java.util.*;

public class LugjeRedica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Queue<String> names = new LinkedQueue<>();
        Queue<Integer> req = new LinkedQueue<>();

        for(int i = 0; i < n; i++) {
            names.enqueue(sc.next());
            req.enqueue(sc.nextInt());
        }

        while(!names.isEmpty()) {
            String name = names.dequeue();
            int r = req.dequeue();

            if(r == 0) System.out.println(name);
            else {
                names.enqueue(name);
                req.enqueue(r - 1);
            }
        }
    }
}
