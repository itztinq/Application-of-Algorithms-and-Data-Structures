package queue_book;
import java.util.*;

public class KolokviumskNedela {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> asistenti = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            asistenti.add(sc.nextLine());
        }

        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<String> predmeti = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            predmeti.add(sc.nextLine());
        }

        int k = sc.nextInt();
        sc.nextLine();
        ArrayList<String> otsutni = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            otsutni.add(sc.nextLine());
        }

        for(int i = 0; i < m; i++) {
            String[] parts = predmeti.get(i).split(" ");
            String predemt =  parts[0];
            int br = Integer.parseInt(parts[1]);

            System.out.println(predemt);
            System.out.println(br);

            for(int j = 0; j < br; j++) {
                if(asistenti.getFirst().equals(otsutni.getFirst())) {
                    otsutni.add(otsutni.getFirst());
                    otsutni.removeFirst();
                    asistenti.removeFirst();
                }
                System.out.println(asistenti.getFirst());
                asistenti.add(asistenti.getFirst());
                asistenti.removeFirst();
            }
        }
    }
}
