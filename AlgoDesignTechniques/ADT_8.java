import java.util.*;

public class ADT_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> tasks = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            tasks.add(sc.nextInt());
        }
        tasks.sort(Collections.reverseOrder());
        List<Integer> slots = new ArrayList<>();
        for(int t : tasks) {
            boolean flag = false;
            for(int i = 0; i < slots.size(); i++) {
                if(slots.get(i) + t <= 8) {
                    slots.set(i, slots.get(i) + t);
                    flag = true;
                    break;
                }
            }
            if(!flag) slots.add(t);
        }
        int days = (slots.size() + m - 1) / m;
        int free = 8 * days * m - tasks.stream().mapToInt(Integer::intValue).sum();
        System.out.println(days + " " + free);
    }
}
