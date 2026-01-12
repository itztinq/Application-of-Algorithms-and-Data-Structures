import java.util.*;

public class VremenskaPrognoza {
    static class Interval {
        String pocetok;
        String kraj;

        Interval(String pocetok, String kraj) {
            this.pocetok = pocetok;
            this.kraj = kraj;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(!(obj instanceof Interval)) return false;
            Interval i = (Interval) obj;
            return pocetok.equals(i.pocetok) && kraj.equals(i.kraj);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pocetok, kraj);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, LinkedHashMap<Interval, double[]>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String grad = parts[0];
            String pocetok = parts[1];
            String kraj = parts[2];
            double temp = Double.parseDouble(parts[3]);

            map.putIfAbsent(grad, new LinkedHashMap<>());

            Interval interval = new Interval(pocetok, kraj);
            LinkedHashMap<Interval, double[]> intervali = map.get(grad);

            if(intervali.containsKey(interval)) {
                intervali.get(interval)[0] += temp;
                intervali.get(interval)[1]++;
            } else {
                intervali.put(interval, new double[] {temp, 1});
            }
        }

        String targetGrad = sc.nextLine();
        if(!map.containsKey(targetGrad)) {
            System.out.println(targetGrad + ": does not exist");
            return;
        }
        System.out.println(targetGrad + ":");

        LinkedHashMap<Interval, double[]> res = map.get(targetGrad);
        for(Map.Entry<Interval, double[]> entry : res.entrySet()) {
            Interval i = entry.getKey();
            double sum = entry.getValue()[0];
            double count = entry.getValue()[1];
            double avg = sum / count;

            System.out.println(i.pocetok + " - " + i.kraj + " " + String.format("%.2f", avg));
        }
    }
}
