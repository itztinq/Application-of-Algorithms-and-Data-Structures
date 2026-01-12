import java.util.*;

public class TelefonskiImenik {
    static String normalizirajBroj(String broj) {
        if(broj.startsWith("+389")) {
            return "0" + broj.substring(4);
        }
        return broj;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String broj = normalizirajBroj(parts[0]);
            map.put(broj, parts[1]);
        }

        String targetBroj = normalizirajBroj(sc.nextLine());
        if(map.containsKey(targetBroj)) {
            System.out.println(map.get(targetBroj));
        }
        else System.out.println("Unknown number");
    }
}
