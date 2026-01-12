import java.util.*;

public class Rodendeni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String datum = sc.nextLine();
            String[] parts = datum.split("\\.");
            int mesec = Integer.parseInt(parts[1]);

            map.put(mesec, map.getOrDefault(mesec, 0) + 1);
        }

        int targetMesec = Integer.parseInt(sc.nextLine());
        if(map.containsKey(targetMesec)) {
            System.out.println(map.get(targetMesec));
        } else {
            System.out.println("Empty");
        }
    }
}