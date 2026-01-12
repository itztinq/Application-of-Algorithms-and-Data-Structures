
import java.util.*;

public class Magacin {
    static class Lek {
        String ime;
        int cena;

        Lek(String ime, int cena) {
            this.ime = ime;
            this.cena = cena;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, Lek> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("@");
            String ime = parts[0];
            String namena = parts[1];
            int cena = Integer.parseInt(parts[2]);

            if(!map.containsKey(namena) || map.get(namena).cena > cena) {
                map.put(namena, new Lek(ime, cena));
            }
        }

        String targetNamena = sc.nextLine();
        if(map.containsKey(targetNamena)) {
            System.out.println(map.get(targetNamena).ime);
        } else {
            System.out.println("No drug found");
        }
    }
}
