import java.util.*;

public class ADT_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arrivals = new int[n];
        int[] departures = new int[n];
        for(int i = 0; i < n; i++) {
            arrivals[i] = sc.nextInt();
            departures[i] = sc.nextInt();
        }
        Arrays.sort(arrivals);
        Arrays.sort(departures);
        int p = 0, maxp = 0, i = 0, j = 0;
        while(i < n) {
            if(arrivals[i] <= departures[j]) {
                p++;
                maxp = Math.max(maxp, p);
                i++;
            } else {
                p--;
                j++;
            }
        }
        System.out.println(maxp);
    }
}