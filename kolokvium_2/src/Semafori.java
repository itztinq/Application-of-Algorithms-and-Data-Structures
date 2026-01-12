import java.text.SimpleDateFormat;
import java.util.*;

public class Semafori {
    static class Prestap {
        Date vreme;
        String ime;

        Prestap(Date vreme, String ime) {
            this.vreme = vreme;
            this.ime = ime;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, String> sopstvenici = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String tablicka = parts[0];
            String ime = parts[1] + " " + parts[2];
            sopstvenici.put(tablicka, ime);
        }

        int maxDozvolenaBrzina = Integer.parseInt(sc.nextLine());

        String[] izvestaj = sc.nextLine().split(" ");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        List<Prestap> prestapi = new ArrayList<>();
        for(int i = 0; i < izvestaj.length; i+= 3) {
            String tablicka = izvestaj[i];
            int brzina = Integer.parseInt(izvestaj[i + 1]);
            Date vreme = sdf.parse(izvestaj[i + 2]);

            if(brzina > maxDozvolenaBrzina) {
                prestapi.add(new Prestap(vreme, sopstvenici.get(tablicka)));
            }
        }

        prestapi.sort(Comparator.comparing(p -> p.vreme));
        for(Prestap p : prestapi) {
            System.out.println(p.ime);
        }
    }
}
