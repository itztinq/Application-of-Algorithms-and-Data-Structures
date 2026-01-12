package stack_book;
import java.util.*;

/* Пример 1:
Влез:
7
6 5 8 4 7 10 9
Излез:
2
*/

public class OtrovniRastenija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        int days = 0;
        for(int i = 1; i < arr.size(); i++){
            if(arr.get(i) > arr.get(i - 1)){
                arr.remove(i);
                days++;
            }
        }

        System.out.println(days);
    }
}
