package book;
import java.util.*;

public class Rodendeni2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<Integer, List<String>> table = new CBHT<>(2 * n - 1);
        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String ime = parts[0];
            String datum = parts[1];
            Integer mesec = Integer.parseInt(datum.split("\\.")[1]);

            SLLNode<MapEntry<Integer, List<String>>> curr = table.search(mesec);
            if(curr != null) {
                if(!curr.element.value.contains(ime)) {
                    curr.element.value.add(ime);
                    table.insert(mesec, curr.element.value);
                }
            } else {
                List<String> l = new ArrayList<>();
                l.add(ime);
                table.insert(mesec, l);
            }
        }

        int mesec = sc.nextInt();
        SLLNode<MapEntry<Integer, List<String>>> curr = table.search(mesec);
        if(curr != null) System.out.println(String.join(" ", curr.element.value));
        else System.out.println("Empty");
    }
}
