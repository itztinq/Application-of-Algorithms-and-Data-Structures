package book;
import java.util.*;

class Ponuda {
    String vreme;
    String grad;
    int honorar;
    public Ponuda(String vreme, String grad, int honorar) {
        this.vreme = vreme;
        this.grad = grad;
        this.honorar = honorar;
    }

    @Override
    public String toString() {
        return vreme + " " + grad + " " + honorar;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Ponuda ponuda = (Ponuda) obj;
        return honorar == ponuda.honorar && Objects.equals(vreme, ponuda.vreme) && Objects.equals(grad, ponuda.grad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vreme, grad, honorar);
    }
}

public class NajdobraPonuda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, Ponuda> table = new CBHT<>(2 * n - 1);
        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String datum = parts[0];
            String vreme =  parts[1];
            String grad = parts[2];
            int honorar = Integer.parseInt(parts[3]);

            SLLNode<MapEntry<String, Ponuda>> curr = table.search(datum);
            if(curr != null) {
                int prevHonorar = curr.element.value.honorar;
                if(prevHonorar > honorar) {
                    table.insert(datum, new Ponuda(curr.element.value.vreme, curr.element.value.grad, curr.element.value.honorar));
                }
                else table.insert(datum, new Ponuda(vreme, grad, honorar));
            }
            else table.insert(datum, new Ponuda(vreme, grad, honorar));
        }

        String datum = sc.nextLine();
        SLLNode<MapEntry<String, Ponuda>> curr = table.search(datum);
        if(curr != null) System.out.println(curr.element.value);
        else System.out.println("No offer");
    }
}
