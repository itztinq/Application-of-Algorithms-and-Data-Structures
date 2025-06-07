import java.util.*;

public class ADT_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        double[][] tasks = new double[n][3];
        for(int i = 0; i < n; i++) {
            tasks[i][0] = sc.nextInt();
            tasks[i][1] = sc.nextInt();
            tasks[i][2] = tasks[i][1] / tasks[i][0];
        }
        Arrays.sort(tasks, (a, b) -> Double.compare(b[2], a[2]));
        int hours = 40;
        double res = 0;
        for(int i = 0; i < n && hours > 0; i++) {
            double x = Math.min(tasks[i][0], hours);
            res += x * tasks[i][2];
            hours -= x;
        }
        System.out.println((int)res);
    }
}