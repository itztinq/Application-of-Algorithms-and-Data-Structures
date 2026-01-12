import java.util.*;

public class Apteka {
    static class Lek {
        String ime;
        boolean pozitivnaLista;
        int cena;
        int kolicina;

        Lek(String ime, boolean pozitivnaLista, int cena, int kolicina) {
            this.ime = ime;
            this.pozitivnaLista = pozitivnaLista;
            this.cena = cena;
            this.kolicina = kolicina;
        }
    }

    static int hash(String zbor) {
        zbor = zbor.toUpperCase();
        return (100 * (100 * (100 * 0 + zbor.charAt(2)) + zbor.charAt(1)) + zbor.charAt(0)) % 656565;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<Integer, List<Lek>> table = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String ime = parts[0];
            boolean pozitivnaLista = parts[1].equals("1");
            int cena = Integer.parseInt(parts[2]);
            int kolicina = Integer.parseInt(parts[3]);

            int key = hash(ime.substring(0, 3));

            table.putIfAbsent(key, new ArrayList<>());
            table.get(key).add(new Lek(ime, pozitivnaLista, cena, kolicina));
        }

        while(true) {
            String imeLek = sc.nextLine();
            if(imeLek.equals("END")) break;

            int kolicina = Integer.parseInt(sc.nextLine());
            String search = imeLek.toUpperCase();
            int key = hash(search.substring(0, 3));

            boolean found = false;

            if(table.containsKey(key)) {
                for(Lek l : table.get(key)) {
                    if(l.ime.equals(search)) {
                        found = true;

                        System.out.println(l.ime + " " + (l.pozitivnaLista ? "POS" : "NEG") + " " + l.cena + " " + l.kolicina);

                        if(kolicina <= l.kolicina) {
                            l.kolicina -= kolicina;
                            System.out.println("Order made");
                        }
                        else System.out.println("No drugs available");
                        break;
                    }
                }
            }

            if(!found) System.out.println("No such drug");
        }
    }
}
