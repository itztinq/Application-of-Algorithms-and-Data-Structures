import java.util.*;

public class Anagrami {
    static String sortiranZbor(String zbor) {
        char[] chars = zbor.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String zbor = sc.nextLine();
            String sortiran = sortiranZbor(zbor);

            map.put(sortiran, map.getOrDefault(sortiran, 0) + 1);
        }

        String target = sortiranZbor(sc.nextLine());
        if(map.containsKey(target)) {
            System.out.println(map.get(target));
        } else {
            System.out.println(0);
        }
    }
}
