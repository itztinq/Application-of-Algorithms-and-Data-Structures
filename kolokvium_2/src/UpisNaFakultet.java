import java.util.*;

public class UpisNaFakultet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, Double> aplikacija = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            aplikacija.put(parts[0], Double.parseDouble(parts[1]));
        }

        int m = Integer.parseInt(sc.nextLine());
        Map<String, Double> eDnevnik = new HashMap<>();
        for(int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split(" ");
            eDnevnik.put(parts[0], Double.parseDouble(parts[1]));
        }

        String target = sc.nextLine();
        if(!eDnevnik.containsKey(target)) {
            System.out.println("Empty");
        } else {
            double prosek = eDnevnik.get(target);
            double vnesenProsek = aplikacija.get(target);
            if(prosek == vnesenProsek) {
                System.out.println("Ok");
            }
            else System.out.println("Error");
        }
    }
}
