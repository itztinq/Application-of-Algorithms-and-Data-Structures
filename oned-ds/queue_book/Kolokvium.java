package queue_book;
import java.util.*;

public class Kolokvium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentiTermin = sc.nextInt();

        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> matPrijaveni = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            matPrijaveni.add(sc.nextLine());
        }

        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<String> ostanati = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            ostanati.add(sc.nextLine());
        }

        int k = sc.nextInt();
        sc.nextLine();
        ArrayList<String> matematika = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            matematika.add(sc.nextLine());
        }

        ArrayList<String> studenti = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            studenti.add(matematika.get(i));
        }
        for(int i = 0; i < m; i++) {
            studenti.add(ostanati.get(i));
        }
        for(int i = 0; i < n; i++) {
            if(studenti.contains(matPrijaveni.get(i))) {
                continue;
            } else studenti.add(matPrijaveni.get(i));
        }

        double total = Math.ceil((n + m + k) / studentiTermin);
        int t = (int)total;

        for(int i = 0; i < t; i++) {
            System.out.println(i + 1);
            for(int j = 0; j < studentiTermin; j++) {
                if(!studenti.isEmpty()) {
                    System.out.println(studenti.getFirst());
                    studenti.removeFirst();
                } else break;
            }
        }
    }
}
