import java.util.*;

public class Kreiranje_Algoritimi_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != sortedArr[i]) {
                int pos = -1;
                for (int j = 0; j < sortedArr.length; j++) {
                    if (arr[i] == sortedArr[j]) {
                        pos = j;
                        break;
                    }
                }
                int diff = i - pos;
                System.out.println(arr[i] + " " + diff);
            }
        }
    }
}
