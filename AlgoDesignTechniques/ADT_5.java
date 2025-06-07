import java.util.*;

public class ADT_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> pos = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            pos.add(sc.nextInt());
        }
        Collections.sort(pos);
        int lights = 0, covered = 0, i = 0;
        while(covered < m) {
            int best = -1;
            while(i < n && pos.get(i) - 2 <= covered + 1) {
                best = i;
                i++;
            }
            if(best == -1) {
                lights = -1;
                break;
            }
            lights++;
            covered = pos.get(best) + 2;
        }
        System.out.println(lights);
    }
}