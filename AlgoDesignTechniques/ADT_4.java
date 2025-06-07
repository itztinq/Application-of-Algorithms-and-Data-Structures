import java.util.*;

public class ADT_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0, maxRooms = 0, i = 0, j = 0;
        while(i < n) {
            if(start[i] <= end[j]) {
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
                i++;
            } else {
                rooms--;
                j++;
            }
        }
        System.out.println(maxRooms);
    }
}
