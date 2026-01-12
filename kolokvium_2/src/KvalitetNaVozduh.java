import java.util.*;

public class KvalitetNaVozduh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, double[]> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String naselba = parts[0];
            double vrednost = Double.parseDouble(parts[1]);

            map.putIfAbsent(naselba, new double[2]);
            map.get(naselba)[0] += vrednost;
            map.get(naselba)[1]++;
        }

        String targetNaselba = sc.nextLine();
        double sum = map.get(targetNaselba)[0];
        double cnt = map.get(targetNaselba)[1];
        double avg = sum / cnt;

        System.out.printf("%.2f", avg);
    }
}
