import java.util.*;

public class Kreiranje_Algoritmi_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for(int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}
