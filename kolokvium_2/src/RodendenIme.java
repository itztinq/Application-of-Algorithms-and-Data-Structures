import java.util.*;

public class RodendenIme {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        HashSet<String> set = new HashSet<>();

        String[] iminja = new String[n];
        int[] meseci = new int[n];

        for(int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            iminja[i] = line[0];

            String[] datumParts = line[1].split("\\.");
            meseci[i] = Integer.parseInt(datumParts[1]);
        }

        int targetMesec = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < n; i++) {
            if(meseci[i] == targetMesec) {
                set.add(iminja[i]);
            }
        }

        if(!set.isEmpty()) {
            for(String s : set) System.out.println(s + " ");
        }
        else System.out.println("Empty");
    }
}
