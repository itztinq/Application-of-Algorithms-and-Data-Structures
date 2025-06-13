package book;
import java.util.*;

public class Anagrami {
    public static String sortiraj(String zbor) {
        char[] bukvi = zbor.toCharArray();
        Arrays.sort(bukvi);
        return new String(bukvi);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, Integer> table = new CBHT<>(2 * n - 1);
        for(int i = 0; i < n; i++) {
            String zbor = sc.nextLine();
            String sortiran = sortiraj(zbor);

            SLLNode<MapEntry<String, Integer>> curr = table.search(sortiran);
            if(curr != null) {
                int prevCnt = curr.element.value;
                table.insert(sortiran, prevCnt + 1);
            } else table.insert(sortiran, 1);
        }

        String zbor = sc.nextLine();
        SLLNode<MapEntry<String, Integer>> curr = table.search(zbor);
        if(curr != null) System.out.println(curr.element.value);
        else  System.out.println("Empty");
    }
}
