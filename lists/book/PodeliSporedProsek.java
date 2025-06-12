package book;
import java.util.*;

/* Дадена е двострано поврзана листа чии што jазли содржат по еден природен броj.
Листата треба да се подели на две резултантни листи, т.ш. во првата листа треба
да се сместат сите jазли кои содржат броеви помали или еднакви на просекот
на листата, а во втората сите jазли кои содржат броеви поголеми од просекот на
листата. Jазлите во резултантните листи се додаваат според обратен редослед
од оноj по коj по коj се поjавуваат во дадената листа (т.е. прво се започнува со
разгледување на последниот jазол од влезната листа и се додава во соодветната
резултантна листа, па претпоследниот итн...).
Влез: Во првиот ред од влезот е даден броjот на jазли во листата, а во вториот
ред се дадени броевите од кои се составени jазлите по редослед во листата.
Излез: Во првиот ред од излезот треба да се испечатат jазлите по редослед од
првата резултантна листа (броеви помали или еднакви на просекот на листата),
во вториот ред од втората (броеви поголеми од просекот на листата).
Пример.
Влез:
5
4 2 1 5 3
Излез:
3 1 2
5 4 */

public class PodeliSporedProsek {
    public static double average(DLL<Integer> list) {
        double sum = 0;
        DLLNode<Integer> curr = list.getFirst();
        while(curr != null) {
            sum += curr.element;
            curr = curr.succ;
        }
        return sum / list.getSize();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for(int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        double avg = average(list);

        DLL<Integer> res1 = new DLL<>();
        DLL<Integer> res2 = new DLL<>();

        DLLNode<Integer> curr = list.getLast();
        while(curr != null) {
            if(curr.element <= avg) res1.insertLast(curr.element);
            else res2.insertLast(curr.element);
            curr = curr.pred;
        }

        System.out.println(res1);
        System.out.println(res2);
    }
}
