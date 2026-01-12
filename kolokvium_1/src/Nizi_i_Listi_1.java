import java.util.*;

public class Nizi_i_Listi_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Array<Integer> arr = new Array<>(n);
        int sum = 0;

        for(int i = 0; i < n; i++) {
            arr.insertLast(sc.nextInt());
            sum += arr.get(i);
        }
        System.out.println(arr);

        float avg = (float)sum / n;

        for(int i = 0; i < arr.getSize(); i++) {
            if(arr.get(i) < avg) arr.delete(i--);
        }

        System.out.println(arr);
    }
}
