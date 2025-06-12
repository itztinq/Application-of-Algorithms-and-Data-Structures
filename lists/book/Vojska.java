package book;
import java.util.*;

/* Пред командантот на воjската наредени се сите воjници и во двоjно поврзана
листа дадени се нивните ID-a. На командантот не му се допа´га како се наредени
воjниците и решава да одбере два под-интервали од воjници и да им ги замени
местата, односно воjниците што се нао´гаат во едниот под-интервал ´ке ги смести
во другиот, и обратно.
Пример.
Влез:
10
1 2 3 4 5 6 7 8 9 10
1 5
6 10
Излез:
6 7 8 9 10 1 2 3 4 5
*/

public class Vojska {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for(int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        DLLNode<Integer> curr = list.getFirst();

        while(curr != null) {
            if(curr.element == x2) break;
            curr = curr.succ;
        }

        DLL<Integer> res = new DLL<>();

        while(curr.element != y2) {
            res.insertLast(curr.element);
            curr = curr.succ;
        }
        res.insertLast(y2);

        curr = list.getFirst();
        while(curr != null) {
            if(curr.element == x1) break;
            curr = curr.succ;
        }

        while(curr.element != y1) {
            res.insertLast(curr.element);
            curr = curr.succ;
        }
        res.insertLast(y1);

        System.out.println(res);
    }
}
