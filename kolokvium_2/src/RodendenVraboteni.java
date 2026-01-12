import java.util.*;

public class RodendenVraboteni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String ime = parts[0] + " " + parts[1];
            String[] datum = parts[2].split("/");
            String key = datum[0] + "/" + datum[1];
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(ime + " " + datum[2]);
        }

        String targetDatum = sc.nextLine();
        String[] t = targetDatum.split("/");
        String targetKey = t[0] + "/" + t[1];
        int targetGodina = Integer.parseInt(t[2]);

        if(!map.containsKey(targetKey)) {
            System.out.println("Empty");
            return;
        }

        List<String> list = map.get(targetKey);
        Collections.sort(list);

        for(String s : list) {
            String[] parts = s.split(" ");
            String ime = parts[0] + " " + parts[1];
            int godina = Integer.parseInt(parts[2]);
            System.out.println(ime + " " + (targetGodina - godina));
        }
    }
}
