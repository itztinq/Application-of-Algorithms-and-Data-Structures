import java.util.*;

public class ProverskaNaSpeluvanje {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        HashSet<String> recnik = new HashSet<>();

        for(int i = 0; i < n; i++) {
            recnik.add(sc.nextLine().toLowerCase());
        }

        String tekst = sc.nextLine();
        tekst = tekst.replaceAll("[.,?!]", "");

        String[] zborovi = tekst.split("\\s+");
        boolean correct = true;

        for(String zbor : zborovi) {
            String z = zbor.toLowerCase();
            if(!recnik.contains(z)) {
                correct = false;
                System.out.println(zbor);
            }
        }

        if(correct) System.out.println("Bravo");
    }
}
