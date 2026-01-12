import java.util.*;

public class Granica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, String> pasoshi = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            pasoshi.put(parts[0], parts[1]);
        }

        int m = Integer.parseInt(sc.nextLine());
        Set<String> promenetiIminja = new HashSet<>();
        for(int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split(" ");
            promenetiIminja.add(parts[0]);
        }

        String targetPasosh = sc.nextLine();
        String targetIme = pasoshi.get(targetPasosh);

        if(promenetiIminja.contains(targetIme)) {
            System.out.println("Not Allowed");
        } else {
            System.out.println("Allowed");
        }
    }
}
