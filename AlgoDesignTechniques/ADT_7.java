import java.util.*;

public class ADT_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int ind = Collections.binarySearch(list, m);
        if(ind >= 0) System.out.println(ind);
        else System.out.println("Ne postoi");
    }
}
