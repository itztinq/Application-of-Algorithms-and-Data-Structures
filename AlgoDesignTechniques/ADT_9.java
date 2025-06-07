import java.util.*;

public class ADT_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if(m == 0 && n == 1) {
            System.out.println(0);
            return;
        }
        if(m == 0 || m > n * 9) {
            System.out.println("Ne postoi");
            return;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int min = (i == 0 ? 1 : 0);
            for(int j = min; j <= 9; j++) {
                if(m - j <= (n - i - 1) * 9) {
                    res.append(j);
                    m -= j;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
