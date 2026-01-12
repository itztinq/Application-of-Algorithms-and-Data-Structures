import java.util.*;

public class Kreiranje_Algoritmi_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[] arrival = new int[n];
        int[] departure = new int[n];

        for(int i = 0; i < n; i++) {
            arrival[i] = sc.nextInt();
            departure[i] = sc.nextInt();
        }

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int i = 0, j = 0, platforms = 0, res = 0;

        while(i < n && j < n) {
            if(arrival[i] <= departure[j]) {
                platforms++;
                res = Math.max(res, platforms);
                i++;
            } else {
                platforms--;
                j++;
            }
        }

        System.out.println(res);
    }
}
