package book;
import java.util.*;

/* Дадена е двострано поврзана листа коjа содржи природни броеви. Ваша задача
е да jа преуредите влезната листата, т.ш. ме´гу секои два соседни jазли од влезната листа ´ке додадете нов jазел коj ´ке jа содржи средната вредност од двата
соседни jазли. Доколку средната вредност е децимална, тогаш броjот треба да
биде заокружен на поголемиот (пр. Ако соседните jазли имаат вредност 1 и 2,
нивната средна вредност е 1,5 и оваа вредност се заокружува на 2).
Влез: Од стандарден влез во првиот ред се дава цел броj N, коj го претставува броjот на елементи во листата, а во вториот се даваат броевите во листата
одделени со празно место.
Излез: Ваша задача е да jа испечатите резултантната листа. */

public class VmetniProsek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for(int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        DLLNode<Integer> tmp = list.getFirst();
        DLLNode<Integer> next = tmp.succ;
        while(tmp != null && next != null) {
            float x = tmp.element;
            float y = next.element;
            Integer z = Math.round((x + y) / 2);
            list.insertAfter(z, tmp);
            tmp = next;
            next = tmp.succ;
        }
        System.out.println(list);
    }
}
