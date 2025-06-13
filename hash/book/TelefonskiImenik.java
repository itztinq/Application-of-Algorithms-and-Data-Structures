package book;
import java.util.*;

public class TelefonskiImenik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String, String> table = new CBHT<>(2 * n - 1);
        for(int i = 0; i < n; i++) {
            String[] parts =  sc.nextLine().split(" ");
            String telBroj = parts[0];
            String ime = parts[1];
            table.insert(telBroj, ime);
        }
        String telBroj = sc.nextLine();
        String broj = "0" + telBroj.substring(4);
        SLLNode<MapEntry<String, String>> curr = table.search(broj);
        if(curr != null) System.out.println(curr.element.value);
        else System.out.println("Unknown number");
    }
}
