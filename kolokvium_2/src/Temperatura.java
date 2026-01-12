import java.util.*;

public class Temperatura {
    static class VremenskiPeriod {
        String pocetok;
        String kraj;
        double temperatura;

        VremenskiPeriod(String pocetok, String kraj, double temperatura) {
            this.pocetok = pocetok;
            this.kraj = kraj;
            this.temperatura = temperatura;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, VremenskiPeriod> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String grad = parts[0];
            String pocetok = parts[1];
            String kraj = parts[2];
            double temperatura = Double.parseDouble(parts[3]);

            if(map.containsKey(grad)) {
                if(temperatura > map.get(grad).temperatura) {
                    map.put(grad, new VremenskiPeriod(pocetok, kraj, temperatura));
                }
            } else {
                map.put(grad, new VremenskiPeriod(pocetok, kraj, temperatura));
            }
        }


        String targetGrad = sc.nextLine();
        VremenskiPeriod vp = map.get(targetGrad);
        System.out.println(targetGrad + ": " + vp.pocetok + " - " + vp.kraj + " " + vp.temperatura);
    }
}
