import java.util.*;

public class ADT_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int maxSeen = Integer.MIN_VALUE;
        List<int[]> misplaced = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(arr[i] >= maxSeen) maxSeen = arr[i];
            else {
                int pos = Arrays.binarySearch(sorted, arr[i]);
                int shift = i - pos;
                misplaced.add(new int[] {arr[i], shift});
            }
        }
        System.out.println(misplaced.size());
        for(int[] m :  misplaced) {
            System.out.println(m[0] + " " + m[1]);
        }
    }
}
