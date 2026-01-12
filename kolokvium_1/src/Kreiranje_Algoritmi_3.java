import java.util.*;

public class Kreiranje_Algoritmi_3 {
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
        double hours = 40.0;
        double total = 0.0;

        for(double[] task : tasks) {
            if(hours <= 0) break;

            if(task[0] <= hours) {
                total += task[1];
                hours -= task[0];
            } else {
                total += hours * task[2];
                hours = 0;
            }
        }

        if(total == Math.floor(total)) System.out.println((int)total);
        else System.out.println(total);
    }
}
