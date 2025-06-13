package book;
import java.util.*;

class Merenja {
    String grad;
    String pocetok;
    String kraj;
    float temperatura;
    public Merenja(String grad, String pocetok, String kraj, float temperatura) {
        this.grad = grad;
        this.pocetok = pocetok;
        this.kraj = kraj;
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return grad + ": " + pocetok + " " + kraj + " " + temperatura;
    }
}

public class Temperatura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String, Merenja> table = new CBHT<>(2 * n - 1);
        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String grad = parts[0];
            String pocetok = parts[1];
            String kraj = parts[2];
            float temperatura = Float.parseFloat(parts[3]);

            SLLNode<MapEntry<String, Merenja>> curr = table.search(grad);
            if(curr != null) {
                float prevTemp = curr.element.value.temperatura;
                if(temperatura > prevTemp) {
                    table.insert(grad, new Merenja(grad, pocetok, kraj, temperatura));
                }
                else table.insert(grad, new Merenja(curr.element.value.grad, curr.element.value.pocetok, curr.element.value.kraj, curr.element.value.temperatura));
            }
            else {
                table.insert(grad, new Merenja(grad, pocetok, kraj, temperatura));
            }
        }

        String grad = sc.nextLine();
        SLLNode<MapEntry<String, Merenja>> curr = table.search(grad);
        if(curr != null) System.out.println(curr.element.value.toString());
        else System.out.println("Empty");
    }
}
