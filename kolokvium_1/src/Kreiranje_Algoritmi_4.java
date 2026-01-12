import java.util.*;

public class Kreiranje_Algoritmi_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[] starts = new int[n];
        int[] ends = new int[n];

        for(int i = 0; i < n; i++) {
            starts[i] = sc.nextInt();
            ends[i] = sc.nextInt();
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int i = 0, j = 0, rooms = 0, res = 0;
        while(i < n && j < n) {
            if(starts[i] <= ends[j]) {
                rooms++;
                res = Math.max(res, rooms);
                i++;
            } else {
                rooms--;
                j++;
            }
        }

        System.out.println(res);
    }
}
