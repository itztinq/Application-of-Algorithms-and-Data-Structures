import java.util.*;

public class Epidemija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, int[]> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");

            map.putIfAbsent(parts[0], new int[2]);
            if(parts[2].equals("positive")) {
                map.get(parts[0])[0]++;
            } else {
                map.get(parts[0])[1]++;
            }
        }

        String targetOpstina = sc.nextLine();
        int positive = map.get(targetOpstina)[0];
        int negative = map.get(targetOpstina)[1];
        double rizikFaktor = (double) positive / (positive+ negative);;
        System.out.printf("%.2f" ,rizikFaktor);
    }
}
