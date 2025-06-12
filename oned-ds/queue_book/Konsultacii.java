package queue_book;
import java.util.*;

public class Konsultacii {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> aps = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            aps.add(sc.nextLine());
        }
        int m = sc.nextInt();
        ArrayList<String> mms = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            mms.add(sc.nextLine());
        }

        String tip;
        String preTip = "";
        for(int i = 0; i < n + m; i++) {
            String[] parts = aps.getFirst().split(" ");
            String ime =  parts[0];
            tip = parts[1];

            if(tip.equals(preTip)) {
                aps.add(aps.getFirst());
                aps.removeFirst();
                if(!mms.isEmpty()) {
                    System.out.println(mms.getFirst());
                    mms.removeFirst();
                }
            } else {
                System.out.println(ime);
                aps.removeFirst();
                preTip = tip;
            }
        }
    }
}
