import java.util.*;

public class CrvenKrst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String krvnaGrupa = parts[1];

            if(krvnaGrupa.startsWith("A1") || krvnaGrupa.startsWith("A2")) {
                krvnaGrupa = "A" + krvnaGrupa.charAt(2);
            }

            map.put(krvnaGrupa, map.getOrDefault(krvnaGrupa, 0) + 1);
        }

        for(String key : map.keySet()) {
            System.out.println(key + "=" + map.get(key));
        }
    }
}
