import java.util.*;

class Licnost {
    String name;
    int priority;
    public Licnost(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    public static Comparator<Licnost> comparator = Comparator.comparing(c -> c.priority);
}

public class SortirajPoPrioritet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Licnost> lista =  new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int priority = sc.nextInt();
            Licnost l = new Licnost(name,priority);
            lista.add(l);
        }
        lista.sort(Licnost.comparator);
        for(Licnost l : lista) {
            System.out.println(l.name);
        }
    }
}
