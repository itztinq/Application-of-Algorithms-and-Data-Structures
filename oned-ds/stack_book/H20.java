package stack_book;
import java.util.*;

/* Пример:
Влез:
H H O H H O H H O H H H H H O H O H O O H O O H H H
Излез:
8
H
O
*/

public class H20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] atoms = str.split(" ");
        int cnt = 0;

        ArrayStack<String> H = new ArrayStack<>(100);
        ArrayStack<String> O = new ArrayStack<>(100);

        for(String atom : atoms) {
            if(atom.equals("H")) H.push(atom);
            else if(atom.equals("O")) O.push(atom);

            if(H.size() >= 2 && O.size() >= 1) {
                H.pop();
                H.pop();
                O.pop();
                cnt++;
            }
        }

        System.out.println(cnt);
        while(!H.isEmpty()) System.out.println(H.pop());
        while(!O.isEmpty()) System.out.println(O.pop());
    }
}
