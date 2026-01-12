import java.util.*;

class Ponuda {
    String vreme;
    String grad;
    int honorar;

    Ponuda(String vreme, String grad, int honorar) {
        this.vreme = vreme;
        this.grad = grad;
        this.honorar = honorar;
    }
}

public class NajdobraPonuda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Ponuda> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String datum = parts[0];
            String vreme = parts[1];
            String grad = parts[2];
            int honorar = Integer.parseInt(parts[3]);

            if(!map.containsKey(datum) || map.get(datum).honorar < honorar) {
                map.put(datum, new Ponuda(vreme, grad, honorar));
            }
        }

        String targetDatum = sc.nextLine();
        if(map.containsKey(targetDatum)) {
            Ponuda p = map.get(targetDatum);
            System.out.println(p.vreme + " " + p.grad + " " + p.honorar);
        } else {
            System.out.println("No offers");
        }
    }
}
